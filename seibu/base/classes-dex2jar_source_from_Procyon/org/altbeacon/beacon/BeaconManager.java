// 
// Decompiled by Procyon v0.5.36
// 

package org.altbeacon.beacon;

import java.util.Map;
import org.altbeacon.beacon.service.Callback;
import org.altbeacon.beacon.service.RangedBeacon;
import org.altbeacon.beacon.service.RegionMonitoringState;
import java.util.Collections;
import java.util.Iterator;
import org.altbeacon.beacon.service.MonitoringStatus;
import java.util.Collection;
import org.altbeacon.beacon.utils.ProcessUtils;
import android.bluetooth.BluetoothManager;
import android.content.ServiceConnection;
import android.content.Intent;
import org.altbeacon.beacon.service.BeaconService;
import org.altbeacon.beacon.service.RangeState;
import org.altbeacon.beacon.logging.Loggers;
import android.annotation.TargetApi;
import android.os.RemoteException;
import org.altbeacon.beacon.service.ScanJobScheduler;
import android.os.Build$VERSION;
import org.altbeacon.beacon.service.SettingsData;
import org.altbeacon.beacon.service.StartRMData;
import android.os.Handler;
import android.os.Message;
import org.altbeacon.beacon.logging.LogManager;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ConcurrentHashMap;
import org.altbeacon.beacon.service.RunningAverageRssiFilter;
import android.os.Messenger;
import java.util.ArrayList;
import java.util.Set;
import org.altbeacon.beacon.service.scanner.NonBeaconLeScanCallback;
import android.app.Notification;
import android.content.Context;
import java.util.concurrent.ConcurrentMap;
import java.util.List;
import android.support.annotation.Nullable;
import org.altbeacon.beacon.simulator.BeaconSimulator;
import android.support.annotation.NonNull;

public class BeaconManager
{
    public static final long DEFAULT_BACKGROUND_BETWEEN_SCAN_PERIOD = 300000L;
    public static final long DEFAULT_BACKGROUND_SCAN_PERIOD = 10000L;
    public static final long DEFAULT_EXIT_PERIOD = 10000L;
    public static final long DEFAULT_FOREGROUND_BETWEEN_SCAN_PERIOD = 0L;
    public static final long DEFAULT_FOREGROUND_SCAN_PERIOD = 1100L;
    private static final Object SINGLETON_LOCK;
    @NonNull
    private static final String TAG = "BeaconManager";
    @Nullable
    protected static BeaconSimulator beaconSimulator;
    protected static String distanceModelUpdateUrl;
    protected static Class rssiFilterImplClass;
    private static boolean sAndroidLScanningDisabled;
    private static long sExitRegionPeriod;
    @Nullable
    protected static volatile BeaconManager sInstance;
    private static boolean sManifestCheckingDisabled;
    private long backgroundBetweenScanPeriod;
    private long backgroundScanPeriod;
    @NonNull
    private final List<BeaconParser> beaconParsers;
    @NonNull
    private final ConcurrentMap<BeaconConsumer, BeaconManager.BeaconManager$ConsumerInfo> consumers;
    @Nullable
    protected RangeNotifier dataRequestNotifier;
    private long foregroundBetweenScanPeriod;
    private long foregroundScanPeriod;
    private boolean mBackgroundMode;
    private boolean mBackgroundModeUninitialized;
    @NonNull
    private final Context mContext;
    @Nullable
    private Notification mForegroundServiceNotification;
    private int mForegroundServiceNotificationId;
    private boolean mMainProcess;
    @Nullable
    private NonBeaconLeScanCallback mNonBeaconLeScanCallback;
    private boolean mRegionStatePersistenceEnabled;
    @Nullable
    private Boolean mScannerInSameProcess;
    private boolean mScheduledScanJobsEnabled;
    @NonNull
    protected final Set<MonitorNotifier> monitorNotifiers;
    @NonNull
    protected final Set<RangeNotifier> rangeNotifiers;
    @NonNull
    private final ArrayList<Region> rangedRegions;
    @Nullable
    private Messenger serviceMessenger;
    
    static {
        BeaconManager.sInstance = null;
        BeaconManager.sAndroidLScanningDisabled = false;
        BeaconManager.sManifestCheckingDisabled = false;
        SINGLETON_LOCK = new Object();
        BeaconManager.sExitRegionPeriod = 10000L;
        BeaconManager.distanceModelUpdateUrl = "https://s3.amazonaws.com/android-beacon-library/android-distance.json";
        BeaconManager.rssiFilterImplClass = RunningAverageRssiFilter.class;
    }
    
    protected BeaconManager(@NonNull final Context context) {
        this.consumers = new ConcurrentHashMap<BeaconConsumer, BeaconManager.BeaconManager$ConsumerInfo>();
        this.serviceMessenger = null;
        this.rangeNotifiers = new CopyOnWriteArraySet<RangeNotifier>();
        this.dataRequestNotifier = null;
        this.monitorNotifiers = new CopyOnWriteArraySet<MonitorNotifier>();
        this.rangedRegions = new ArrayList<Region>();
        this.beaconParsers = new CopyOnWriteArrayList<BeaconParser>();
        this.mRegionStatePersistenceEnabled = true;
        this.mBackgroundMode = false;
        this.mBackgroundModeUninitialized = true;
        this.mMainProcess = false;
        this.mScannerInSameProcess = null;
        this.mScheduledScanJobsEnabled = false;
        this.mForegroundServiceNotification = null;
        this.mForegroundServiceNotificationId = -1;
        this.foregroundScanPeriod = 1100L;
        this.foregroundBetweenScanPeriod = 0L;
        this.backgroundScanPeriod = 10000L;
        this.backgroundBetweenScanPeriod = 300000L;
        this.mContext = context.getApplicationContext();
        this.checkIfMainProcess();
        if (!BeaconManager.sManifestCheckingDisabled) {
            this.verifyServiceDeclaration();
        }
        this.beaconParsers.add((BeaconParser)new AltBeaconParser());
        this.setScheduledScanJobsEnabledDefault();
    }
    
    @TargetApi(18)
    private void applyChangesToServices(final int n, final Region region) throws RemoteException {
        if (!this.isAnyConsumerBound()) {
            LogManager.w("BeaconManager", "The BeaconManager is not bound to the service.  Call beaconManager.bind(BeaconConsumer consumer) and wait for a callback to onBeaconServiceConnect()", new Object[0]);
        }
        else {
            if (!this.mScheduledScanJobsEnabled) {
                final Message obtain = Message.obtain((Handler)null, n, 0, 0);
                if (n == 6) {
                    obtain.setData(new StartRMData(this.getScanPeriod(), this.getBetweenScanPeriod(), this.mBackgroundMode).toBundle());
                }
                else if (n == 7) {
                    obtain.setData(new SettingsData().collect(this.mContext).toBundle());
                }
                else {
                    obtain.setData(new StartRMData(region, this.callbackPackageName(), this.getScanPeriod(), this.getBetweenScanPeriod(), this.mBackgroundMode).toBundle());
                }
                this.serviceMessenger.send(obtain);
                return;
            }
            if (Build$VERSION.SDK_INT >= 21) {
                ScanJobScheduler.getInstance().applySettingsToScheduledJob(this.mContext, this);
            }
        }
    }
    
    private String callbackPackageName() {
        final String packageName = this.mContext.getPackageName();
        LogManager.d("BeaconManager", "callback packageName: %s", new Object[] { packageName });
        return packageName;
    }
    
    private boolean determineIfCalledFromSeparateScannerProcess() {
        boolean b = false;
        if (this.isScannerInDifferentProcess()) {
            b = b;
            if (!this.isMainProcess()) {
                LogManager.w("BeaconManager", "Ranging/Monitoring may not be controlled from a separate BeaconScanner process.  To remove this warning, please wrap this call in: if (beaconManager.isMainProcess())", new Object[0]);
                b = true;
            }
        }
        return b;
    }
    
    @Nullable
    public static BeaconSimulator getBeaconSimulator() {
        return BeaconManager.beaconSimulator;
    }
    
    private long getBetweenScanPeriod() {
        if (this.mBackgroundMode) {
            return this.backgroundBetweenScanPeriod;
        }
        return this.foregroundBetweenScanPeriod;
    }
    
    public static String getDistanceModelUpdateUrl() {
        return BeaconManager.distanceModelUpdateUrl;
    }
    
    @NonNull
    public static BeaconManager getInstanceForApplication(@NonNull final Context context) {
        final BeaconManager sInstance = BeaconManager.sInstance;
        if (sInstance != null) {
            return sInstance;
        }
        final Object singleton_LOCK = BeaconManager.SINGLETON_LOCK;
        // monitorenter(singleton_LOCK)
    Label_0041:
        while (true) {
            try {
                while (true) {
                    BeaconManager sInstance2;
                    if ((sInstance2 = BeaconManager.sInstance) == null) {
                        sInstance2 = new BeaconManager(context);
                        try {
                            BeaconManager.sInstance = sInstance2;
                            // monitorexit(singleton_LOCK)
                            return sInstance2;
                            // monitorexit(singleton_LOCK)
                            throw;
                        }
                        finally {
                            continue Label_0041;
                        }
                        return sInstance;
                    }
                    continue;
                }
            }
            finally {
                continue Label_0041;
            }
            break;
        }
    }
    
    public static boolean getManifestCheckingDisabled() {
        return BeaconManager.sManifestCheckingDisabled;
    }
    
    public static long getRegionExitPeriod() {
        return BeaconManager.sExitRegionPeriod;
    }
    
    public static Class getRssiFilterImplClass() {
        return BeaconManager.rssiFilterImplClass;
    }
    
    private long getScanPeriod() {
        if (this.mBackgroundMode) {
            return this.backgroundScanPeriod;
        }
        return this.foregroundScanPeriod;
    }
    
    public static boolean isAndroidLScanningDisabled() {
        return BeaconManager.sAndroidLScanningDisabled;
    }
    
    private boolean isBleAvailable() {
        if (Build$VERSION.SDK_INT < 18) {
            LogManager.w("BeaconManager", "Bluetooth LE not supported prior to API 18.", new Object[0]);
            return false;
        }
        if (!this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            LogManager.w("BeaconManager", "This device does not support bluetooth LE.", new Object[0]);
            return false;
        }
        return true;
    }
    
    private boolean isBleAvailableOrSimulated() {
        return getBeaconSimulator() != null || this.isBleAvailable();
    }
    
    @Deprecated
    public static void logDebug(final String s, final String s2) {
        LogManager.d(s, s2, new Object[0]);
    }
    
    @Deprecated
    public static void logDebug(final String s, final String s2, final Throwable t) {
        LogManager.d(t, s, s2, new Object[0]);
    }
    
    public static void setAndroidLScanningDisabled(final boolean sAndroidLScanningDisabled) {
        BeaconManager.sAndroidLScanningDisabled = sAndroidLScanningDisabled;
        final BeaconManager sInstance = BeaconManager.sInstance;
        if (sInstance != null) {
            sInstance.applySettings();
        }
    }
    
    public static void setBeaconSimulator(final BeaconSimulator beaconSimulator) {
        warnIfScannerNotInSameProcess();
        BeaconManager.beaconSimulator = beaconSimulator;
    }
    
    public static void setDebug(final boolean b) {
        if (b) {
            LogManager.setLogger(Loggers.verboseLogger());
            LogManager.setVerboseLoggingEnabled(true);
            return;
        }
        LogManager.setLogger(Loggers.empty());
        LogManager.setVerboseLoggingEnabled(false);
    }
    
    public static void setDistanceModelUpdateUrl(@NonNull final String distanceModelUpdateUrl) {
        warnIfScannerNotInSameProcess();
        BeaconManager.distanceModelUpdateUrl = distanceModelUpdateUrl;
    }
    
    public static void setManifestCheckingDisabled(final boolean sManifestCheckingDisabled) {
        BeaconManager.sManifestCheckingDisabled = sManifestCheckingDisabled;
    }
    
    public static void setRegionExitPeriod(final long sExitRegionPeriod) {
        BeaconManager.sExitRegionPeriod = sExitRegionPeriod;
        final BeaconManager sInstance = BeaconManager.sInstance;
        if (sInstance != null) {
            sInstance.applySettings();
        }
    }
    
    public static void setRssiFilterImplClass(@NonNull final Class rssiFilterImplClass) {
        warnIfScannerNotInSameProcess();
        BeaconManager.rssiFilterImplClass = rssiFilterImplClass;
    }
    
    private void setScheduledScanJobsEnabledDefault() {
        this.mScheduledScanJobsEnabled = (Build$VERSION.SDK_INT >= 26);
    }
    
    public static void setUseTrackingCache(final boolean useTrackingCache) {
        RangeState.setUseTrackingCache(useTrackingCache);
        if (BeaconManager.sInstance != null) {
            BeaconManager.sInstance.applySettings();
        }
    }
    
    @Deprecated
    public static void setsManifestCheckingDisabled(final boolean sManifestCheckingDisabled) {
        BeaconManager.sManifestCheckingDisabled = sManifestCheckingDisabled;
    }
    
    private void verifyServiceDeclaration() {
        final List queryIntentServices = this.mContext.getPackageManager().queryIntentServices(new Intent(this.mContext, (Class)BeaconService.class), 65536);
        if (queryIntentServices != null && queryIntentServices.isEmpty()) {
            throw new BeaconManager.BeaconManager$ServiceNotDeclaredException(this);
        }
    }
    
    private static void warnIfScannerNotInSameProcess() {
        final BeaconManager sInstance = BeaconManager.sInstance;
        if (sInstance != null && sInstance.isScannerInDifferentProcess()) {
            LogManager.w("BeaconManager", "Unsupported configuration change made for BeaconScanner in separate process", new Object[0]);
        }
    }
    
    public void addMonitorNotifier(@NonNull final MonitorNotifier monitorNotifier) {
        if (!this.determineIfCalledFromSeparateScannerProcess() && monitorNotifier != null) {
            this.monitorNotifiers.add(monitorNotifier);
        }
    }
    
    public void addRangeNotifier(@NonNull final RangeNotifier rangeNotifier) {
        if (rangeNotifier != null) {
            this.rangeNotifiers.add(rangeNotifier);
        }
    }
    
    public void applySettings() {
        if (this.determineIfCalledFromSeparateScannerProcess()) {
            return;
        }
        if (!this.isAnyConsumerBound()) {
            LogManager.d("BeaconManager", "Not synchronizing settings to service, as it has not started up yet", new Object[0]);
            return;
        }
        if (this.isScannerInDifferentProcess()) {
            LogManager.d("BeaconManager", "Synchronizing settings to service", new Object[0]);
            this.syncSettingsToService();
            return;
        }
        LogManager.d("BeaconManager", "Not synchronizing settings to service, as it is in the same process", new Object[0]);
    }
    
    public void bind(@NonNull final BeaconConsumer beaconConsumer) {
        if (!this.isBleAvailableOrSimulated()) {
            LogManager.w("BeaconManager", "Method invocation will be ignored.", new Object[0]);
            return;
        }
        while (true) {
            final BeaconManager.BeaconManager$ConsumerInfo beaconManager$ConsumerInfo;
            synchronized (this.consumers) {
                beaconManager$ConsumerInfo = new BeaconManager.BeaconManager$ConsumerInfo(this);
                if (this.consumers.putIfAbsent(beaconConsumer, beaconManager$ConsumerInfo) != null) {
                    LogManager.d("BeaconManager", "This consumer is already bound", new Object[0]);
                    return;
                }
            }
            final BeaconConsumer beaconConsumer2;
            LogManager.d("BeaconManager", "This consumer is not bound.  Binding now: %s", new Object[] { beaconConsumer2 });
            if (this.mScheduledScanJobsEnabled) {
                LogManager.d("BeaconManager", "Not starting beacon scanning service. Using scheduled jobs", new Object[0]);
                beaconConsumer2.onBeaconServiceConnect();
            }
            else {
                LogManager.d("BeaconManager", "Binding to service", new Object[0]);
                final Intent intent = new Intent(beaconConsumer2.getApplicationContext(), (Class)BeaconService.class);
                if (Build$VERSION.SDK_INT >= 26 && this.getForegroundServiceNotification() != null) {
                    if (this.isAnyConsumerBound()) {
                        LogManager.i("BeaconManager", "Not starting foreground beacon scanning service.  A consumer is already bound, so it should be started", new Object[0]);
                    }
                    else {
                        LogManager.i("BeaconManager", "Starting foreground beacon scanning service.", new Object[0]);
                        this.mContext.startForegroundService(intent);
                    }
                }
                beaconConsumer2.bindService(intent, (ServiceConnection)beaconManager$ConsumerInfo.beaconServiceConnection, 1);
            }
            LogManager.d("BeaconManager", "consumer count is now: %s", new Object[] { this.consumers.size() });
        }
    }
    
    @TargetApi(18)
    public boolean checkAvailability() throws BleNotAvailableException {
        if (!this.isBleAvailableOrSimulated()) {
            throw new BleNotAvailableException("Bluetooth LE not supported by this device");
        }
        return ((BluetoothManager)this.mContext.getSystemService("bluetooth")).getAdapter().isEnabled();
    }
    
    protected void checkIfMainProcess() {
        final ProcessUtils processUtils = new ProcessUtils(this.mContext);
        final String processName = processUtils.getProcessName();
        final String packageName = processUtils.getPackageName();
        final int pid = processUtils.getPid();
        this.mMainProcess = processUtils.isMainProcess();
        LogManager.i("BeaconManager", "BeaconManager started up on pid " + pid + " named '" + processName + "' for application package '" + packageName + "'.  isMainProcess=" + this.mMainProcess, new Object[0]);
    }
    
    public void disableForegroundServiceScanning() throws IllegalStateException {
        if (this.isAnyConsumerBound()) {
            throw new IllegalStateException("May not be called after consumers are already bound");
        }
        this.mForegroundServiceNotification = null;
        this.setScheduledScanJobsEnabledDefault();
    }
    
    public void enableForegroundServiceScanning(final Notification mForegroundServiceNotification, final int mForegroundServiceNotificationId) throws IllegalStateException {
        if (this.isAnyConsumerBound()) {
            throw new IllegalStateException("May not be called after consumers are already bound.");
        }
        if (mForegroundServiceNotification == null) {
            throw new NullPointerException("Notification cannot be null");
        }
        this.setEnableScheduledScanJobs(false);
        this.mForegroundServiceNotification = mForegroundServiceNotification;
        this.mForegroundServiceNotificationId = mForegroundServiceNotificationId;
    }
    
    public long getBackgroundBetweenScanPeriod() {
        return this.backgroundBetweenScanPeriod;
    }
    
    public boolean getBackgroundMode() {
        return this.mBackgroundMode;
    }
    
    public long getBackgroundScanPeriod() {
        return this.backgroundScanPeriod;
    }
    
    @NonNull
    public List<BeaconParser> getBeaconParsers() {
        return this.beaconParsers;
    }
    
    @Nullable
    protected RangeNotifier getDataRequestNotifier() {
        return this.dataRequestNotifier;
    }
    
    public long getForegroundBetweenScanPeriod() {
        return this.foregroundBetweenScanPeriod;
    }
    
    public long getForegroundScanPeriod() {
        return this.foregroundScanPeriod;
    }
    
    public Notification getForegroundServiceNotification() {
        return this.mForegroundServiceNotification;
    }
    
    public int getForegroundServiceNotificationId() {
        return this.mForegroundServiceNotificationId;
    }
    
    @NonNull
    public Collection<Region> getMonitoredRegions() {
        return (Collection<Region>)MonitoringStatus.getInstanceForApplication(this.mContext).regions();
    }
    
    @Deprecated
    @Nullable
    public MonitorNotifier getMonitoringNotifier() {
        final Iterator<MonitorNotifier> iterator = this.monitorNotifiers.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }
    
    @NonNull
    public Set<MonitorNotifier> getMonitoringNotifiers() {
        return Collections.unmodifiableSet((Set<? extends MonitorNotifier>)this.monitorNotifiers);
    }
    
    @Nullable
    public NonBeaconLeScanCallback getNonBeaconLeScanCallback() {
        return this.mNonBeaconLeScanCallback;
    }
    
    @NonNull
    public Collection<Region> getRangedRegions() {
        synchronized (this.rangedRegions) {
            return new ArrayList<Region>(this.rangedRegions);
        }
    }
    
    @Deprecated
    @Nullable
    public RangeNotifier getRangingNotifier() {
        final Iterator<RangeNotifier> iterator = this.rangeNotifiers.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }
    
    @NonNull
    public Set<RangeNotifier> getRangingNotifiers() {
        return Collections.unmodifiableSet((Set<? extends RangeNotifier>)this.rangeNotifiers);
    }
    
    public boolean getScheduledScanJobsEnabled() {
        return this.mScheduledScanJobsEnabled;
    }
    
    public boolean isAnyConsumerBound() {
        while (true) {
            synchronized (this.consumers) {
                if (this.consumers.isEmpty()) {
                    return false;
                }
                if (this.mScheduledScanJobsEnabled) {
                    return true;
                }
                if (this.serviceMessenger != null) {
                    return true;
                }
                return false;
            }
            return true;
            b = false;
            return b;
        }
    }
    
    public boolean isBackgroundModeUninitialized() {
        return this.mBackgroundModeUninitialized;
    }
    
    public boolean isBound(@NonNull final BeaconConsumer beaconConsumer) {
        final ConcurrentMap<BeaconConsumer, BeaconManager.BeaconManager$ConsumerInfo> consumers = this.consumers;
        // monitorenter(consumers)
        if (beaconConsumer == null) {
            return false;
        }
        while (true) {
            try {
                if (this.consumers.get(beaconConsumer) == null) {
                    break;
                }
                if (this.mScheduledScanJobsEnabled) {
                    return true;
                }
                if (this.serviceMessenger != null) {
                    return true;
                }
                break;
            }
            finally {
            }
            // monitorexit(consumers)
            return true;
        }
        return false;
    }
    
    public boolean isMainProcess() {
        return this.mMainProcess;
    }
    
    public boolean isRegionStatePersistenceEnabled() {
        return this.mRegionStatePersistenceEnabled;
    }
    
    public boolean isScannerInDifferentProcess() {
        return this.mScannerInSameProcess != null && !this.mScannerInSameProcess;
    }
    
    public void removeAllMonitorNotifiers() {
        if (this.determineIfCalledFromSeparateScannerProcess()) {
            return;
        }
        this.monitorNotifiers.clear();
    }
    
    public void removeAllRangeNotifiers() {
        this.rangeNotifiers.clear();
    }
    
    public boolean removeMonitorNotifier(@NonNull final MonitorNotifier monitorNotifier) {
        return !this.determineIfCalledFromSeparateScannerProcess() && this.monitorNotifiers.remove(monitorNotifier);
    }
    
    @Deprecated
    public boolean removeMonitoreNotifier(@NonNull final MonitorNotifier monitorNotifier) {
        return this.removeMonitorNotifier(monitorNotifier);
    }
    
    public boolean removeRangeNotifier(@NonNull final RangeNotifier rangeNotifier) {
        return this.rangeNotifiers.remove(rangeNotifier);
    }
    
    public void requestStateForRegion(@NonNull final Region region) {
        if (!this.determineIfCalledFromSeparateScannerProcess()) {
            final RegionMonitoringState state = MonitoringStatus.getInstanceForApplication(this.mContext).stateOf(region);
            int n = 0;
            if (state != null) {
                n = n;
                if (state.getInside()) {
                    n = 1;
                }
            }
            final Iterator<MonitorNotifier> iterator = this.monitorNotifiers.iterator();
            while (iterator.hasNext()) {
                iterator.next().didDetermineStateForRegion(n, region);
            }
        }
    }
    
    public void setBackgroundBetweenScanPeriod(final long backgroundBetweenScanPeriod) {
        this.backgroundBetweenScanPeriod = backgroundBetweenScanPeriod;
        if (Build$VERSION.SDK_INT >= 26 && this.backgroundBetweenScanPeriod < 900000L) {
            LogManager.w("BeaconManager", "Setting a short backgroundBetweenScanPeriod has no effect on Android 8+, which is limited to scanning every ~15 minutes", new Object[0]);
        }
    }
    
    public void setBackgroundMode(final boolean mBackgroundMode) {
        if (!this.isBleAvailableOrSimulated()) {
            LogManager.w("BeaconManager", "Method invocation will be ignored.", new Object[0]);
        }
        else {
            this.mBackgroundModeUninitialized = false;
            if (mBackgroundMode != this.mBackgroundMode) {
                this.mBackgroundMode = mBackgroundMode;
                try {
                    this.updateScanPeriods();
                }
                catch (RemoteException ex) {
                    LogManager.e("BeaconManager", "Cannot contact service to set scan periods", new Object[0]);
                }
            }
        }
    }
    
    public void setBackgroundScanPeriod(final long backgroundScanPeriod) {
        this.backgroundScanPeriod = backgroundScanPeriod;
    }
    
    protected void setDataRequestNotifier(@Nullable final RangeNotifier dataRequestNotifier) {
        this.dataRequestNotifier = dataRequestNotifier;
    }
    
    public void setEnableScheduledScanJobs(final boolean mScheduledScanJobsEnabled) {
        if (this.isAnyConsumerBound()) {
            LogManager.e("BeaconManager", "ScanJob may not be configured because a consumer is already bound.", new Object[0]);
            throw new IllegalStateException("Method must be called before calling bind()");
        }
        if (mScheduledScanJobsEnabled && Build$VERSION.SDK_INT < 21) {
            LogManager.e("BeaconManager", "ScanJob may not be configured because JobScheduler is not availble prior to Android 5.0", new Object[0]);
            return;
        }
        if (!mScheduledScanJobsEnabled && Build$VERSION.SDK_INT >= 26) {
            LogManager.w("BeaconManager", "Disabling ScanJobs on Android 8+ may disable delivery of beacon callbacks in the background unless a foreground service is active.", new Object[0]);
        }
        if (!mScheduledScanJobsEnabled && Build$VERSION.SDK_INT >= 21) {
            ScanJobScheduler.getInstance().cancelSchedule(this.mContext);
        }
        this.mScheduledScanJobsEnabled = mScheduledScanJobsEnabled;
    }
    
    public void setForegroundBetweenScanPeriod(final long foregroundBetweenScanPeriod) {
        this.foregroundBetweenScanPeriod = foregroundBetweenScanPeriod;
    }
    
    public void setForegroundScanPeriod(final long foregroundScanPeriod) {
        this.foregroundScanPeriod = foregroundScanPeriod;
    }
    
    public void setMaxTrackingAge(final int maxTrackinAge) {
        RangedBeacon.setMaxTrackinAge(maxTrackinAge);
    }
    
    @Deprecated
    public void setMonitorNotifier(@Nullable final MonitorNotifier monitorNotifier) {
        if (!this.determineIfCalledFromSeparateScannerProcess()) {
            this.monitorNotifiers.clear();
            if (monitorNotifier != null) {
                this.addMonitorNotifier(monitorNotifier);
            }
        }
    }
    
    public void setNonBeaconLeScanCallback(@Nullable final NonBeaconLeScanCallback mNonBeaconLeScanCallback) {
        this.mNonBeaconLeScanCallback = mNonBeaconLeScanCallback;
    }
    
    @Deprecated
    public void setRangeNotifier(@Nullable final RangeNotifier rangeNotifier) {
        this.rangeNotifiers.clear();
        if (rangeNotifier != null) {
            this.addRangeNotifier(rangeNotifier);
        }
    }
    
    @Deprecated
    public void setRegionStatePeristenceEnabled(final boolean regionStatePersistenceEnabled) {
        this.setRegionStatePersistenceEnabled(regionStatePersistenceEnabled);
    }
    
    public void setRegionStatePersistenceEnabled(final boolean mRegionStatePersistenceEnabled) {
        this.mRegionStatePersistenceEnabled = mRegionStatePersistenceEnabled;
        if (!this.isScannerInDifferentProcess()) {
            if (mRegionStatePersistenceEnabled) {
                MonitoringStatus.getInstanceForApplication(this.mContext).startStatusPreservation();
            }
            else {
                MonitoringStatus.getInstanceForApplication(this.mContext).stopStatusPreservation();
            }
        }
        this.applySettings();
    }
    
    public void setScannerInSameProcess(final boolean b) {
        this.mScannerInSameProcess = b;
    }
    
    @TargetApi(18)
    public void startMonitoringBeaconsInRegion(@NonNull final Region region) throws RemoteException {
        if (!this.isBleAvailableOrSimulated()) {
            LogManager.w("BeaconManager", "Method invocation will be ignored.", new Object[0]);
        }
        else if (!this.determineIfCalledFromSeparateScannerProcess()) {
            if (this.mScheduledScanJobsEnabled) {
                MonitoringStatus.getInstanceForApplication(this.mContext).addRegion(region, new Callback(this.callbackPackageName()));
            }
            this.applyChangesToServices(4, region);
            if (this.isScannerInDifferentProcess()) {
                MonitoringStatus.getInstanceForApplication(this.mContext).addLocalRegion(region);
            }
            this.requestStateForRegion(region);
        }
    }
    
    @TargetApi(18)
    public void startRangingBeaconsInRegion(@NonNull final Region e) throws RemoteException {
        if (!this.isBleAvailableOrSimulated()) {
            LogManager.w("BeaconManager", "Method invocation will be ignored.", new Object[0]);
        }
        else if (!this.determineIfCalledFromSeparateScannerProcess()) {
            synchronized (this.rangedRegions) {
                this.rangedRegions.add(e);
                // monitorexit(this.rangedRegions)
                this.applyChangesToServices(2, e);
            }
        }
    }
    
    @TargetApi(18)
    public void stopMonitoringBeaconsInRegion(@NonNull final Region region) throws RemoteException {
        if (!this.isBleAvailableOrSimulated()) {
            LogManager.w("BeaconManager", "Method invocation will be ignored.", new Object[0]);
        }
        else if (!this.determineIfCalledFromSeparateScannerProcess()) {
            if (this.mScheduledScanJobsEnabled) {
                MonitoringStatus.getInstanceForApplication(this.mContext).removeRegion(region);
            }
            this.applyChangesToServices(5, region);
            if (this.isScannerInDifferentProcess()) {
                MonitoringStatus.getInstanceForApplication(this.mContext).removeLocalRegion(region);
            }
        }
    }
    
    @TargetApi(18)
    public void stopRangingBeaconsInRegion(@NonNull final Region region) throws RemoteException {
        if (!this.isBleAvailableOrSimulated()) {
            LogManager.w("BeaconManager", "Method invocation will be ignored.", new Object[0]);
        }
        else if (!this.determineIfCalledFromSeparateScannerProcess()) {
            final ArrayList<Region> rangedRegions = this.rangedRegions;
            // monitorenter(rangedRegions)
            Object o = null;
            try {
                for (final Region region2 : this.rangedRegions) {
                    if (region.getUniqueId().equals(region2.getUniqueId())) {
                        o = region2;
                    }
                }
                this.rangedRegions.remove(o);
                // monitorexit(rangedRegions)
                this.applyChangesToServices(3, region);
            }
            finally {
            }
            // monitorexit(rangedRegions)
        }
    }
    
    protected void syncSettingsToService() {
        if (this.mScheduledScanJobsEnabled) {
            if (Build$VERSION.SDK_INT >= 21) {
                ScanJobScheduler.getInstance().applySettingsToScheduledJob(this.mContext, this);
            }
            return;
        }
        try {
            this.applyChangesToServices(7, null);
        }
        catch (RemoteException ex) {
            LogManager.e("BeaconManager", "Failed to sync settings to service", new Object[] { ex });
        }
    }
    
    public void unbind(@NonNull final BeaconConsumer beaconConsumer) {
        if (!this.isBleAvailableOrSimulated()) {
            LogManager.w("BeaconManager", "Method invocation will be ignored.", new Object[0]);
            return;
        }
        while (true) {
            Label_0248: {
                while (true) {
                    synchronized (this.consumers) {
                        if (!this.consumers.containsKey(beaconConsumer)) {
                            break Label_0248;
                        }
                        LogManager.d("BeaconManager", "Unbinding", new Object[0]);
                        if (this.mScheduledScanJobsEnabled) {
                            LogManager.d("BeaconManager", "Not unbinding from scanning service as we are using scan jobs.", new Object[0]);
                            LogManager.d("BeaconManager", "Before unbind, consumer count is " + this.consumers.size(), new Object[0]);
                            this.consumers.remove(beaconConsumer);
                            LogManager.d("BeaconManager", "After unbind, consumer count is " + this.consumers.size(), new Object[0]);
                            if (this.consumers.size() == 0) {
                                this.serviceMessenger = null;
                                this.mBackgroundMode = false;
                                if (this.mScheduledScanJobsEnabled && Build$VERSION.SDK_INT >= 21) {
                                    LogManager.i("BeaconManager", "Cancelling scheduled jobs after unbind of last consumer.", new Object[0]);
                                    ScanJobScheduler.getInstance().cancelSchedule(this.mContext);
                                }
                            }
                            return;
                        }
                    }
                    beaconConsumer.unbindService((ServiceConnection)this.consumers.get(beaconConsumer).beaconServiceConnection);
                    continue;
                }
            }
            LogManager.d("BeaconManager", "This consumer is not bound to: %s", new Object[] { beaconConsumer });
            LogManager.d("BeaconManager", "Bound consumers: ", new Object[0]);
            final Iterator<Map.Entry<Object, Object>> iterator = this.consumers.entrySet().iterator();
            while (iterator.hasNext()) {
                LogManager.d("BeaconManager", String.valueOf(iterator.next().getValue()), new Object[0]);
            }
        }
    }
    
    @TargetApi(18)
    public void updateScanPeriods() throws RemoteException {
        if (!this.isBleAvailableOrSimulated()) {
            LogManager.w("BeaconManager", "Method invocation will be ignored.", new Object[0]);
        }
        else if (!this.determineIfCalledFromSeparateScannerProcess()) {
            LogManager.d("BeaconManager", "updating background flag to %s", new Object[] { this.mBackgroundMode });
            LogManager.d("BeaconManager", "updating scan period to %s, %s", new Object[] { this.getScanPeriod(), this.getBetweenScanPeriod() });
            this.applyChangesToServices(6, null);
        }
    }
}
