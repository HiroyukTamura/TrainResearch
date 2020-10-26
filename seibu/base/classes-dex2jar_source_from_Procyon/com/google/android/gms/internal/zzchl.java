// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.util.zze;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.Task;
import java.util.Arrays;
import android.content.Context;
import android.support.v4.util.ArrayMap;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import java.util.Iterator;
import java.util.ArrayList;
import android.os.Parcelable;
import android.text.TextUtils;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzbo;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Set;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzchl extends zzchj
{
    protected zzchy zzbto;
    private AppMeasurement.EventInterceptor zzbtp;
    private final Set<AppMeasurement.OnEventListener> zzbtq;
    private boolean zzbtr;
    private final AtomicReference<String> zzbts;
    
    protected zzchl(final zzcgl zzcgl) {
        super(zzcgl);
        this.zzbtq = new CopyOnWriteArraySet<AppMeasurement.OnEventListener>();
        this.zzbts = new AtomicReference<String>();
    }
    
    public static int getMaxUserProperties(final String s) {
        zzbo.zzcF(s);
        return zzcem.zzxu();
    }
    
    private final void zza(final AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        final long currentTimeMillis = super.zzkq().currentTimeMillis();
        zzbo.zzu(conditionalUserProperty);
        zzbo.zzcF(conditionalUserProperty.mName);
        zzbo.zzcF(conditionalUserProperty.mOrigin);
        zzbo.zzu(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        final String mName = conditionalUserProperty.mName;
        final Object mValue = conditionalUserProperty.mValue;
        if (super.zzwB().zzes(mName) != 0) {
            super.zzwF().zzyx().zzj("Invalid conditional user property name", super.zzwA().zzdY(mName));
            return;
        }
        if (super.zzwB().zzl(mName, mValue) != 0) {
            super.zzwF().zzyx().zze("Invalid conditional user property value", super.zzwA().zzdY(mName), mValue);
            return;
        }
        final Object zzm = super.zzwB().zzm(mName, mValue);
        if (zzm == null) {
            super.zzwF().zzyx().zze("Unable to normalize conditional user property value", super.zzwA().zzdY(mName), mValue);
            return;
        }
        conditionalUserProperty.mValue = zzm;
        final long mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
        if (!TextUtils.isEmpty((CharSequence)conditionalUserProperty.mTriggerEventName) && (mTriggerTimeout > zzcem.zzxw() || mTriggerTimeout < 1L)) {
            super.zzwF().zzyx().zze("Invalid conditional user property timeout", super.zzwA().zzdY(mName), mTriggerTimeout);
            return;
        }
        final long mTimeToLive = conditionalUserProperty.mTimeToLive;
        if (mTimeToLive > zzcem.zzxx() || mTimeToLive < 1L) {
            super.zzwF().zzyx().zze("Invalid conditional user property time to live", super.zzwA().zzdY(mName), mTimeToLive);
            return;
        }
        super.zzwE().zzj(new zzchn(this, conditionalUserProperty));
    }
    
    private final void zza(final String s, final String s2, final long n, Bundle bundle, final boolean b, final boolean b2, final boolean b3, final String s3) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        else {
            final Bundle bundle2 = new Bundle(bundle);
            final Iterator iterator = bundle2.keySet().iterator();
            while (true) {
                bundle = bundle2;
                if (!iterator.hasNext()) {
                    break;
                }
                final String s4 = iterator.next();
                final Object value = bundle2.get(s4);
                if (value instanceof Bundle) {
                    bundle2.putBundle(s4, new Bundle((Bundle)value));
                }
                else if (value instanceof Parcelable[]) {
                    final Parcelable[] array = (Parcelable[])value;
                    for (int i = 0; i < array.length; ++i) {
                        if (array[i] instanceof Bundle) {
                            array[i] = (Parcelable)new Bundle((Bundle)array[i]);
                        }
                    }
                }
                else {
                    if (!(value instanceof ArrayList)) {
                        continue;
                    }
                    final ArrayList<Object> list = (ArrayList<Object>)value;
                    for (int j = 0; j < list.size(); ++j) {
                        final Bundle value2 = list.get(j);
                        if (value2 instanceof Bundle) {
                            list.set(j, new Bundle((Bundle)value2));
                        }
                    }
                }
            }
        }
        super.zzwE().zzj(new zzcht(this, s, s2, n, bundle, b, b2, b3, s3));
    }
    
    private final void zza(final String s, final String s2, final long n, final Object o) {
        super.zzwE().zzj(new zzchu(this, s, s2, o, n));
    }
    
    private final void zza(final String s, final String s2, final Bundle bundle, final boolean b, final boolean b2, final boolean b3, final String s3) {
        this.zza(s, s2, super.zzkq().currentTimeMillis(), bundle, true, b2, b3, null);
    }
    
    @WorkerThread
    private final void zza(final String s, final String s2, final Object o, final long n) {
        zzbo.zzcF(s);
        zzbo.zzcF(s2);
        super.zzjC();
        super.zzwp();
        this.zzkD();
        if (!this.zzboe.isEnabled()) {
            super.zzwF().zzyC().log("User property not set since app measurement is disabled");
        }
        else if (this.zzboe.zzyP()) {
            super.zzwF().zzyC().zze("Setting user property (FE)", super.zzwA().zzdW(s2), o);
            super.zzww().zzb(new zzcji(s2, n, o, s));
        }
    }
    
    private final void zza(final String mAppId, final String mName, final String mExpiredEventName, final Bundle mExpiredEventParams) {
        final long currentTimeMillis = super.zzkq().currentTimeMillis();
        zzbo.zzcF(mName);
        final AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mAppId = mAppId;
        conditionalUserProperty.mName = mName;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (mExpiredEventName != null) {
            conditionalUserProperty.mExpiredEventName = mExpiredEventName;
            conditionalUserProperty.mExpiredEventParams = mExpiredEventParams;
        }
        super.zzwE().zzj(new zzcho(this, conditionalUserProperty));
    }
    
    @Nullable
    private final String zzad(final long n) {
        final AtomicReference<String> atomicReference = new AtomicReference<String>();
        synchronized (atomicReference) {
            super.zzwE().zzj(new zzchx(this, atomicReference));
            try {
                atomicReference.wait(n);
                return atomicReference.get();
            }
            catch (InterruptedException ex) {
                super.zzwF().zzyz().log("Interrupted waiting for app instance id");
                return null;
            }
        }
    }
    
    @WorkerThread
    private final void zzan(final boolean b) {
        super.zzjC();
        super.zzwp();
        this.zzkD();
        super.zzwF().zzyC().zzj("Setting app measurement enabled (FE)", b);
        super.zzwG().setMeasurementEnabled(b);
        super.zzww().zzzj();
    }
    
    private final Map<String, Object> zzb(final String s, String s2, final String s3, final boolean b) {
        if (super.zzwE().zzyM()) {
            super.zzwF().zzyx().log("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        super.zzwE();
        if (zzcgg.zzS()) {
            super.zzwF().zzyx().log("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        final AtomicReference<List<?>> atomicReference = new AtomicReference<List<?>>();
        synchronized (atomicReference) {
            this.zzboe.zzwE().zzj(new zzchq(this, atomicReference, s, s2, s3, b));
            try {
                atomicReference.wait(5000L);
                // monitorexit(atomicReference)
                s2 = (String)atomicReference.get();
                if (s2 == null) {
                    super.zzwF().zzyz().log("Timed out waiting for get user properties");
                    return Collections.emptyMap();
                }
            }
            catch (InterruptedException ex) {
                super.zzwF().zzyz().zzj("Interrupted waiting for get user properties", ex);
            }
        }
        final ArrayMap<String, Object> arrayMap = new ArrayMap<String, Object>(((List)s2).size());
        for (final zzcji zzcji : s2) {
            arrayMap.put(zzcji.name, zzcji.getValue());
        }
        return arrayMap;
    }
    
    @WorkerThread
    private final void zzb(final AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        super.zzjC();
        this.zzkD();
        zzbo.zzu(conditionalUserProperty);
        zzbo.zzcF(conditionalUserProperty.mName);
        zzbo.zzcF(conditionalUserProperty.mOrigin);
        zzbo.zzu(conditionalUserProperty.mValue);
        if (!this.zzboe.isEnabled()) {
            super.zzwF().zzyC().log("Conditional property not sent since Firebase Analytics is disabled");
            return;
        }
        final zzcji zzcji = new zzcji(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
        try {
            super.zzww().zzf(new zzcek(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzcji, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, super.zzwB().zza(conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0L, true, false), conditionalUserProperty.mTriggerTimeout, super.zzwB().zza(conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0L, true, false), conditionalUserProperty.mTimeToLive, super.zzwB().zza(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0L, true, false)));
        }
        catch (IllegalArgumentException ex) {}
    }
    
    @WorkerThread
    private final void zzb(String zza, final String anObject, final long n, final Bundle bundle, final boolean b, final boolean b2, final boolean b3, final String s) {
        zzbo.zzcF(zza);
        zzbo.zzcF(anObject);
        zzbo.zzu(bundle);
        super.zzjC();
        this.zzkD();
        if (!this.zzboe.isEnabled()) {
            super.zzwF().zzyC().log("Event not sent since app measurement is disabled");
        }
        else {
            boolean equals = false;
            while (true) {
                if (this.zzbtr) {
                    break Label_0102;
                }
                this.zzbtr = true;
                try {
                    final Class<?> forName = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                    try {
                        forName.getDeclaredMethod("initialize", Context.class).invoke(null, super.getContext());
                        equals = "am".equals(zza);
                        final boolean zzex = zzcjl.zzex(anObject);
                        if (b && this.zzbtp != null && !zzex && !equals) {
                            super.zzwF().zzyC().zze("Passing event to registered event handler (FE)", super.zzwA().zzdW(anObject), super.zzwA().zzA(bundle));
                            this.zzbtp.interceptEvent(zza, anObject, bundle, n);
                            return;
                        }
                    }
                    catch (Exception ex) {
                        super.zzwF().zzyz().zzj("Failed to invoke Tag Manager's initialize() method", ex);
                    }
                }
                catch (ClassNotFoundException ex2) {
                    super.zzwF().zzyB().log("Tag Manager is not found and thus will not be used");
                    continue;
                }
                break;
            }
            if (this.zzboe.zzyP()) {
                final int zzeq = super.zzwB().zzeq(anObject);
                if (zzeq != 0) {
                    super.zzwB();
                    zza = zzcjl.zza(anObject, zzcem.zzxh(), true);
                    int length;
                    if (anObject != null) {
                        length = anObject.length();
                    }
                    else {
                        length = 0;
                    }
                    this.zzboe.zzwB().zza(s, zzeq, "_ev", zza, length);
                    return;
                }
                final List<String> singletonList = Collections.singletonList("_o");
                final Bundle zza2 = super.zzwB().zza(anObject, bundle, singletonList, b3, true);
                final ArrayList<Bundle> list = new ArrayList<Bundle>();
                list.add(zza2);
                final long nextLong = super.zzwB().zzzt().nextLong();
                int n2 = 0;
                final String[] a = zza2.keySet().toArray(new String[bundle.size()]);
                Arrays.sort(a);
                for (int length2 = a.length, i = 0; i < length2; ++i) {
                    final String s2 = a[i];
                    final Object value = zza2.get(s2);
                    super.zzwB();
                    final Bundle[] zzC = zzcjl.zzC(value);
                    if (zzC != null) {
                        zza2.putInt(s2, zzC.length);
                        for (int j = 0; j < zzC.length; ++j) {
                            final Bundle zza3 = super.zzwB().zza("_ep", zzC[j], singletonList, b3, false);
                            zza3.putString("_en", anObject);
                            zza3.putLong("_eid", nextLong);
                            zza3.putString("_gn", s2);
                            zza3.putInt("_ll", zzC.length);
                            zza3.putInt("_i", j);
                            list.add(zza3);
                        }
                        n2 += zzC.length;
                    }
                }
                if (n2 != 0) {
                    zza2.putLong("_eid", nextLong);
                    zza2.putInt("_epc", n2);
                }
                zzcem.zzxE();
                final zzcic zzzh = super.zzwx().zzzh();
                if (zzzh != null && !zza2.containsKey("_sc")) {
                    zzzh.zzbtS = true;
                }
                for (int k = 0; k < list.size(); ++k) {
                    Bundle zzB = list.get(k);
                    int n3;
                    if (k != 0) {
                        n3 = 1;
                    }
                    else {
                        n3 = 0;
                    }
                    String s3;
                    if (n3 != 0) {
                        s3 = "_ep";
                    }
                    else {
                        s3 = anObject;
                    }
                    zzB.putString("_o", zza);
                    if (!zzB.containsKey("_sc")) {
                        zzchz.zza(zzzh, zzB);
                    }
                    if (b2) {
                        zzB = super.zzwB().zzB(zzB);
                    }
                    super.zzwF().zzyC().zze("Logging event (FE)", super.zzwA().zzdW(anObject), super.zzwA().zzA(zzB));
                    super.zzww().zzc(new zzcez(s3, new zzcew(zzB), zza, n), s);
                    if (!equals) {
                        final Iterator<AppMeasurement.OnEventListener> iterator = this.zzbtq.iterator();
                        while (iterator.hasNext()) {
                            iterator.next().onEvent(zza, anObject, new Bundle(zzB), n);
                        }
                    }
                }
                zzcem.zzxE();
                if (super.zzwx().zzzh() != null && "_ae".equals(anObject)) {
                    super.zzwD().zzap(true);
                }
            }
        }
    }
    
    @WorkerThread
    private final void zzc(final AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        super.zzjC();
        this.zzkD();
        zzbo.zzu(conditionalUserProperty);
        zzbo.zzcF(conditionalUserProperty.mName);
        if (!this.zzboe.isEnabled()) {
            super.zzwF().zzyC().log("Conditional property not cleared since Firebase Analytics is disabled");
            return;
        }
        final zzcji zzcji = new zzcji(conditionalUserProperty.mName, 0L, null, null);
        try {
            super.zzww().zzf(new zzcek(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzcji, conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, null, conditionalUserProperty.mTriggerTimeout, null, conditionalUserProperty.mTimeToLive, super.zzwB().zza(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false)));
        }
        catch (IllegalArgumentException ex) {}
    }
    
    private final List<AppMeasurement.ConditionalUserProperty> zzl(final String s, final String mOrigin, final String s2) {
        if (super.zzwE().zzyM()) {
            super.zzwF().zzyx().log("Cannot get conditional user properties from analytics worker thread");
            return Collections.emptyList();
        }
        super.zzwE();
        if (zzcgg.zzS()) {
            super.zzwF().zzyx().log("Cannot get conditional user properties from main thread");
            return Collections.emptyList();
        }
        Object o = new AtomicReference<List<zzcek>>();
        synchronized (o) {
            this.zzboe.zzwE().zzj(new zzchp(this, (AtomicReference)o, s, mOrigin, s2));
            try {
                o.wait(5000L);
                // monitorexit(o)
                o = ((AtomicReference<List<zzcek>>)o).get();
                if (o == null) {
                    super.zzwF().zzyz().zzj("Timed out waiting for get conditional user properties", s);
                    return Collections.emptyList();
                }
            }
            catch (InterruptedException ex) {
                super.zzwF().zzyz().zze("Interrupted waiting for get conditional user properties", s, ex);
            }
        }
        final ArrayList list = new ArrayList<AppMeasurement.ConditionalUserProperty>(((List)o).size());
        for (final zzcek zzcek : o) {
            final AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
            final String mAppId;
            conditionalUserProperty.mAppId = mAppId;
            conditionalUserProperty.mOrigin = mOrigin;
            conditionalUserProperty.mCreationTimestamp = zzcek.zzbpe;
            conditionalUserProperty.mName = zzcek.zzbpd.name;
            conditionalUserProperty.mValue = zzcek.zzbpd.getValue();
            conditionalUserProperty.mActive = zzcek.zzbpf;
            conditionalUserProperty.mTriggerEventName = zzcek.zzbpg;
            if (zzcek.zzbph != null) {
                conditionalUserProperty.mTimedOutEventName = zzcek.zzbph.name;
                if (zzcek.zzbph.zzbpM != null) {
                    conditionalUserProperty.mTimedOutEventParams = zzcek.zzbph.zzbpM.zzyt();
                }
            }
            conditionalUserProperty.mTriggerTimeout = zzcek.zzbpi;
            if (zzcek.zzbpj != null) {
                conditionalUserProperty.mTriggeredEventName = zzcek.zzbpj.name;
                if (zzcek.zzbpj.zzbpM != null) {
                    conditionalUserProperty.mTriggeredEventParams = zzcek.zzbpj.zzbpM.zzyt();
                }
            }
            conditionalUserProperty.mTriggeredTimestamp = zzcek.zzbpd.zzbuy;
            conditionalUserProperty.mTimeToLive = zzcek.zzbpk;
            if (zzcek.zzbpl != null) {
                conditionalUserProperty.mExpiredEventName = zzcek.zzbpl.name;
                if (zzcek.zzbpl.zzbpM != null) {
                    conditionalUserProperty.mExpiredEventParams = zzcek.zzbpl.zzbpM.zzyt();
                }
            }
            list.add(conditionalUserProperty);
        }
        return (List<AppMeasurement.ConditionalUserProperty>)list;
    }
    
    public final void clearConditionalUserProperty(final String s, final String s2, final Bundle bundle) {
        super.zzwp();
        this.zza(null, s, s2, bundle);
    }
    
    public final void clearConditionalUserPropertyAs(final String s, final String s2, final String s3, final Bundle bundle) {
        zzbo.zzcF(s);
        super.zzwo();
        this.zza(s, s2, s3, bundle);
    }
    
    public final Task<String> getAppInstanceId() {
        try {
            final String zzyH = super.zzwG().zzyH();
            if (zzyH != null) {
                return Tasks.forResult(zzyH);
            }
            return Tasks.call(super.zzwE().zzyN(), (Callable<String>)new zzchw(this));
        }
        catch (Exception ex) {
            super.zzwF().zzyz().log("Failed to schedule task for getAppInstanceId");
            return Tasks.forException(ex);
        }
    }
    
    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserProperties(final String s, final String s2) {
        super.zzwp();
        return this.zzl(null, s, s2);
    }
    
    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserPropertiesAs(final String s, final String s2, final String s3) {
        zzbo.zzcF(s);
        super.zzwo();
        return this.zzl(s, s2, s3);
    }
    
    public final Map<String, Object> getUserProperties(final String s, final String s2, final boolean b) {
        super.zzwp();
        return this.zzb(null, s, s2, b);
    }
    
    public final Map<String, Object> getUserPropertiesAs(final String s, final String s2, final String s3, final boolean b) {
        zzbo.zzcF(s);
        super.zzwo();
        return this.zzb(s, s2, s3, b);
    }
    
    public final void registerOnMeasurementEventListener(final AppMeasurement.OnEventListener onEventListener) {
        super.zzwp();
        this.zzkD();
        zzbo.zzu(onEventListener);
        if (!this.zzbtq.add(onEventListener)) {
            super.zzwF().zzyz().log("OnEventListener already registered");
        }
    }
    
    public final void setConditionalUserProperty(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzbo.zzu(conditionalUserProperty);
        super.zzwp();
        conditionalUserProperty = new AppMeasurement.ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty((CharSequence)conditionalUserProperty.mAppId)) {
            super.zzwF().zzyz().log("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty.mAppId = null;
        this.zza(conditionalUserProperty);
    }
    
    public final void setConditionalUserPropertyAs(final AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzbo.zzu(conditionalUserProperty);
        zzbo.zzcF(conditionalUserProperty.mAppId);
        super.zzwo();
        this.zza(new AppMeasurement.ConditionalUserProperty(conditionalUserProperty));
    }
    
    @WorkerThread
    public final void setEventInterceptor(final AppMeasurement.EventInterceptor zzbtp) {
        super.zzjC();
        super.zzwp();
        this.zzkD();
        if (zzbtp != null && zzbtp != this.zzbtp) {
            zzbo.zza(this.zzbtp == null, (Object)"EventInterceptor already set.");
        }
        this.zzbtp = zzbtp;
    }
    
    public final void setMeasurementEnabled(final boolean b) {
        this.zzkD();
        super.zzwp();
        super.zzwE().zzj(new zzchm(this, b));
    }
    
    public final void setMinimumSessionDuration(final long n) {
        super.zzwp();
        super.zzwE().zzj(new zzchr(this, n));
    }
    
    public final void setSessionTimeoutDuration(final long n) {
        super.zzwp();
        super.zzwE().zzj(new zzchs(this, n));
    }
    
    public final void unregisterOnMeasurementEventListener(final AppMeasurement.OnEventListener onEventListener) {
        super.zzwp();
        this.zzkD();
        zzbo.zzu(onEventListener);
        if (!this.zzbtq.remove(onEventListener)) {
            super.zzwF().zzyz().log("OnEventListener had not been registered");
        }
    }
    
    public final void zza(final String s, final String s2, final Bundle bundle, final long n) {
        super.zzwp();
        this.zza(s, s2, n, bundle, false, true, true, null);
    }
    
    public final void zza(final String s, final String s2, final Bundle bundle, final boolean b) {
        super.zzwp();
        this.zza(s, s2, bundle, true, this.zzbtp == null || zzcjl.zzex(s2), true, null);
    }
    
    @Nullable
    final String zzac(long elapsedRealtime) {
        String s = null;
        if (super.zzwE().zzyM()) {
            super.zzwF().zzyx().log("Cannot retrieve app instance id from analytics worker thread");
        }
        else {
            super.zzwE();
            if (zzcgg.zzS()) {
                super.zzwF().zzyx().log("Cannot retrieve app instance id from main thread");
                return null;
            }
            elapsedRealtime = super.zzkq().elapsedRealtime();
            final String zzad = this.zzad(120000L);
            elapsedRealtime = super.zzkq().elapsedRealtime() - elapsedRealtime;
            if ((s = zzad) == null) {
                s = zzad;
                if (elapsedRealtime < 120000L) {
                    return this.zzad(120000L - elapsedRealtime);
                }
            }
        }
        return s;
    }
    
    public final List<zzcji> zzao(final boolean b) {
        super.zzwp();
        this.zzkD();
        super.zzwF().zzyC().log("Fetching user attributes (FE)");
        Object emptyList;
        if (super.zzwE().zzyM()) {
            super.zzwF().zzyx().log("Cannot get all user properties from analytics worker thread");
            emptyList = Collections.emptyList();
        }
        else {
            super.zzwE();
            if (zzcgg.zzS()) {
                super.zzwF().zzyx().log("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            emptyList = new AtomicReference<List>();
            synchronized (emptyList) {
                this.zzboe.zzwE().zzj(new zzchv(this, (AtomicReference)emptyList, b));
                try {
                    emptyList.wait(5000L);
                    // monitorexit(emptyList)
                    if ((emptyList = ((AtomicReference<List>)emptyList).get()) == null) {
                        super.zzwF().zzyz().log("Timed out waiting for get user properties");
                        return Collections.emptyList();
                    }
                    return (List<zzcji>)emptyList;
                }
                catch (InterruptedException ex) {
                    super.zzwF().zzyz().zzj("Interrupted waiting for get user properties", ex);
                }
            }
        }
        return (List<zzcji>)emptyList;
    }
    
    public final void zzb(String s, final String s2, Object zzm) {
        int length = 0;
        final int n = 0;
        zzbo.zzcF(s);
        final long currentTimeMillis = super.zzkq().currentTimeMillis();
        final int zzes = super.zzwB().zzes(s2);
        if (zzes != 0) {
            super.zzwB();
            s = zzcjl.zza(s2, zzcem.zzxi(), true);
            int length2 = n;
            if (s2 != null) {
                length2 = s2.length();
            }
            this.zzboe.zzwB().zza(zzes, "_ev", s, length2);
        }
        else {
            if (zzm == null) {
                this.zza(s, s2, currentTimeMillis, null);
                return;
            }
            final int zzl = super.zzwB().zzl(s2, zzm);
            if (zzl != 0) {
                super.zzwB();
                s = zzcjl.zza(s2, zzcem.zzxi(), true);
                if (zzm instanceof String || zzm instanceof CharSequence) {
                    length = String.valueOf(zzm).length();
                }
                this.zzboe.zzwB().zza(zzl, "_ev", s, length);
                return;
            }
            zzm = super.zzwB().zzm(s2, zzm);
            if (zzm != null) {
                this.zza(s, s2, currentTimeMillis, zzm);
            }
        }
    }
    
    public final void zzd(final String s, final String s2, final Bundle bundle) {
        super.zzwp();
        this.zza(s, s2, bundle, true, this.zzbtp == null || zzcjl.zzex(s2), false, null);
    }
    
    final void zzee(@Nullable final String newValue) {
        this.zzbts.set(newValue);
    }
    
    @Override
    protected final void zzjD() {
    }
    
    @Nullable
    public final String zzyH() {
        super.zzwp();
        return this.zzbts.get();
    }
}
