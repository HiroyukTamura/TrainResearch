package androidx.browser.trusted;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.StrictMode;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.browser.trusted.TrustedWebActivityServiceWrapper;
import androidx.core.app.NotificationManagerCompat;
import java.util.Arrays;
import java.util.Locale;

public class TrustedWebActivityService extends Service {
    @SuppressLint({"ActionValue", "ServiceName"})
    public static final String ACTION_TRUSTED_WEB_ACTIVITY_SERVICE = "android.support.customtabs.trusted.TRUSTED_WEB_ACTIVITY_SERVICE";
    public static final String KEY_SMALL_ICON_BITMAP = "android.support.customtabs.trusted.SMALL_ICON_BITMAP";
    public static final String META_DATA_NAME_SMALL_ICON = "android.support.customtabs.trusted.SMALL_ICON";
    private static final String PREFS_FILE = "TrustedWebActivityVerifiedProvider";
    private static final String PREFS_VERIFIED_PROVIDER = "Provider";
    public static final int SMALL_ICON_NOT_SET = -1;
    private final ITrustedWebActivityService.Stub mBinder = new ITrustedWebActivityService.Stub() {
        private void checkCaller() {
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            if (trustedWebActivityService.mVerifiedUid == -1) {
                String[] packagesForUid = trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                try {
                    if (Arrays.asList(packagesForUid).contains(TrustedWebActivityService.getPreferences(TrustedWebActivityService.this).getString(TrustedWebActivityService.PREFS_VERIFIED_PROVIDER, (String) null))) {
                        TrustedWebActivityService.this.mVerifiedUid = Binder.getCallingUid();
                        return;
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                } finally {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                }
            }
            if (TrustedWebActivityService.this.mVerifiedUid != Binder.getCallingUid()) {
                throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
            }
        }

        public Bundle areNotificationsEnabled(Bundle bundle) {
            checkCaller();
            return new TrustedWebActivityServiceWrapper.ResultArgs(TrustedWebActivityService.this.areNotificationsEnabled(TrustedWebActivityServiceWrapper.NotificationsEnabledArgs.fromBundle(bundle).channelName)).toBundle();
        }

        public void cancelNotification(Bundle bundle) {
            checkCaller();
            TrustedWebActivityServiceWrapper.CancelNotificationArgs fromBundle = TrustedWebActivityServiceWrapper.CancelNotificationArgs.fromBundle(bundle);
            TrustedWebActivityService.this.cancelNotification(fromBundle.platformTag, fromBundle.platformId);
        }

        public Bundle getActiveNotifications() {
            checkCaller();
            return new TrustedWebActivityServiceWrapper.ActiveNotificationsArgs(TrustedWebActivityService.this.getActiveNotifications()).toBundle();
        }

        public Bundle getSmallIconBitmap() {
            checkCaller();
            return TrustedWebActivityService.this.getSmallIconBitmap();
        }

        public int getSmallIconId() {
            checkCaller();
            return TrustedWebActivityService.this.getSmallIconId();
        }

        public Bundle notifyNotificationWithChannel(Bundle bundle) {
            checkCaller();
            TrustedWebActivityServiceWrapper.NotifyNotificationArgs fromBundle = TrustedWebActivityServiceWrapper.NotifyNotificationArgs.fromBundle(bundle);
            return new TrustedWebActivityServiceWrapper.ResultArgs(TrustedWebActivityService.this.notifyNotificationWithChannel(fromBundle.platformTag, fromBundle.platformId, fromBundle.notification, fromBundle.channelName)).toBundle();
        }
    };
    private NotificationManager mNotificationManager;
    int mVerifiedUid = -1;

    private static String channelNameToId(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    private void ensureOnCreateCalled() {
        if (this.mNotificationManager == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
    }

    static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, 0);
    }

    public static final void setVerifiedProvider(@NonNull final Context context, @Nullable final String str) {
        if (str == null || str.isEmpty()) {
            str = null;
        }
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                SharedPreferences.Editor edit = TrustedWebActivityService.getPreferences(context).edit();
                edit.putString(TrustedWebActivityService.PREFS_VERIFIED_PROVIDER, str);
                edit.apply();
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void setVerifiedProviderSynchronouslyForTesting(Context context, @Nullable String str) {
        if (str == null || str.isEmpty()) {
            str = null;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            SharedPreferences.Editor edit = getPreferences(context).edit();
            edit.putString(PREFS_VERIFIED_PROVIDER, str);
            edit.apply();
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public boolean areNotificationsEnabled(@NonNull String str) {
        ensureOnCreateCalled();
        if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        return NotificationApiHelperForO.isChannelEnabled(this.mNotificationManager, channelNameToId(str));
    }

    public void cancelNotification(@NonNull String str, int i) {
        ensureOnCreateCalled();
        this.mNotificationManager.cancel(str, i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Parcelable[] getActiveNotifications() {
        ensureOnCreateCalled();
        if (Build.VERSION.SDK_INT >= 23) {
            return NotificationApiHelperForM.getActiveNotifications(this.mNotificationManager);
        }
        throw new IllegalStateException("getActiveNotifications cannot be called pre-M.");
    }

    @NonNull
    public Bundle getSmallIconBitmap() {
        int smallIconId = getSmallIconId();
        Bundle bundle = new Bundle();
        if (smallIconId == -1) {
            return bundle;
        }
        bundle.putParcelable(KEY_SMALL_ICON_BITMAP, BitmapFactory.decodeResource(getResources(), smallIconId));
        return bundle;
    }

    public int getSmallIconId() {
        try {
            ServiceInfo serviceInfo = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128);
            if (serviceInfo.metaData == null) {
                return -1;
            }
            return serviceInfo.metaData.getInt(META_DATA_NAME_SMALL_ICON, -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public boolean notifyNotificationWithChannel(@NonNull String str, int i, @NonNull Notification notification, @NonNull String str2) {
        ensureOnCreateCalled();
        if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            String channelNameToId = channelNameToId(str2);
            notification = NotificationApiHelperForO.copyNotificationOntoChannel(this, this.mNotificationManager, notification, channelNameToId, str2);
            if (!NotificationApiHelperForO.isChannelEnabled(this.mNotificationManager, channelNameToId)) {
                return false;
            }
        }
        this.mNotificationManager.notify(str, i, notification);
        return true;
    }

    @Nullable
    public final IBinder onBind(@Nullable Intent intent) {
        return this.mBinder;
    }

    @CallSuper
    public void onCreate() {
        super.onCreate();
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
    }

    public final boolean onUnbind(@Nullable Intent intent) {
        this.mVerifiedUid = -1;
        return super.onUnbind(intent);
    }
}
