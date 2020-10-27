package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzng;
import com.google.android.gms.internal.measurement.zzns;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzhh extends zzg {
    @VisibleForTesting
    protected zzid zza;
    final zzp zzb;
    @VisibleForTesting
    protected boolean zzc = true;
    private zzhc zzd;
    private final Set<zzhf> zze = new CopyOnWriteArraySet();
    private boolean zzf;
    private final AtomicReference<String> zzg = new AtomicReference<>();

    protected zzhh(zzgd zzgd) {
        super(zzgd);
        this.zzb = new zzp(zzgd);
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzq().zza((Runnable) new zzhn(this, str, str2, obj, j));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzam() {
        zzd();
        String zza2 = zzs().zzn.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                zza("app", "_npa", (Object) null, zzm().currentTimeMillis());
            } else {
                zza("app", "_npa", (Object) Long.valueOf("true".equals(zza2) ? 1 : 0), zzm().currentTimeMillis());
            }
        }
        if (!this.zzy.zzab() || !this.zzc) {
            zzr().zzw().zza("Updating Scion state (FE)");
            zzh().zzac();
            return;
        }
        zzr().zzw().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzai();
        if (zzns.zzb() && zzt().zza(zzaq.zzbv)) {
            zzk().zza.zza();
        }
        if (zzng.zzb() && zzt().zza(zzaq.zzca)) {
            if (!(this.zzy.zzf().zza.zzc().zzi.zza() > 0)) {
                zzfq zzf2 = this.zzy.zzf();
                zzf2.zza.zzad();
                zzf2.zza(zzf2.zza.zzn().getPackageName());
            }
        }
        if (zzt().zza(zzaq.zzcq)) {
            zzq().zza((Runnable) new zzib(this));
        }
    }

    @VisibleForTesting
    private final ArrayList<Bundle> zzb(String str, String str2, String str3) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzx.zza()) {
            zzr().zzf().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzq().zza(atomicReference, 5000, "get conditional user properties", new zzhs(this, atomicReference, str, str2, str3));
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzkw.zzb((List<zzw>) list);
            }
            zzr().zzf().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        zzfb zzf2;
        String str4;
        if (zzq().zzg()) {
            zzf2 = zzr().zzf();
            str4 = "Cannot get user properties from analytics worker thread";
        } else if (zzx.zza()) {
            zzf2 = zzr().zzf();
            str4 = "Cannot get user properties from main thread";
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzq().zza(atomicReference, 5000, "get user properties", new zzhv(this, atomicReference, str, str2, str3, z));
            List<zzkr> list = (List) atomicReference.get();
            if (list == null) {
                zzr().zzf().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzkr zzkr : list) {
                arrayMap.put(zzkr.zza, zzkr.zza());
            }
            return arrayMap;
        }
        zzf2.zza(str4);
        return Collections.emptyMap();
    }

    private final void zzb(Bundle bundle, long j) {
        Class<Long> cls = Long.class;
        Class<String> cls2 = String.class;
        Preconditions.checkNotNull(bundle);
        zzgy.zza(bundle, "app_id", cls2, null);
        zzgy.zza(bundle, "origin", cls2, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.NAME, cls2, null);
        zzgy.zza(bundle, "value", Object.class, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, cls2, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, cls, 0L);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, cls2, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, cls2, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, cls, 0L);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, cls2, null);
        zzgy.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        Object obj = bundle.get("value");
        if (zzp().zzc(string) != 0) {
            zzr().zzf().zza("Invalid conditional user property name", zzo().zzc(string));
        } else if (zzp().zzb(string, obj) != 0) {
            zzr().zzf().zza("Invalid conditional user property value", zzo().zzc(string), obj);
        } else {
            Object zzc2 = zzp().zzc(string, obj);
            if (zzc2 == null) {
                zzr().zzf().zza("Unable to normalize conditional user property value", zzo().zzc(string), obj);
                return;
            }
            zzgy.zza(bundle, zzc2);
            long j2 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzr().zzf().zza("Invalid conditional user property time to live", zzo().zzc(string), Long.valueOf(j3));
                } else {
                    zzq().zza((Runnable) new zzhr(this, bundle));
                }
            } else {
                zzr().zzf().zza("Invalid conditional user property timeout", zzo().zzc(string), Long.valueOf(j2));
            }
        }
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzq().zza((Runnable) new zzhk(this, str, str2, j, zzkw.zzb(bundle), z, z2, z3, str3));
    }

    private final void zzb(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzm().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str3 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzq().zza((Runnable) new zzhq(this, bundle2));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        if (!this.zzy.zzab()) {
            zzr().zzx().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkr zzkr = new zzkr(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle2.get("value"), bundle2.getString("origin"));
        try {
            zzao zza2 = zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false);
            zzh().zza(new zzw(bundle2.getString("app_id"), bundle2.getString("origin"), zzkr, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zza2, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc(boolean z) {
        zzd();
        zzb();
        zzw();
        zzr().zzw().zza("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzs().zzb(z);
        zzam();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzd(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        if (!this.zzy.zzab()) {
            zzr().zzx().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzkr zzkr = new zzkr(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), 0, (Object) null, (String) null);
        try {
            zzao zza2 = zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false);
            zzkr zzkr2 = zzkr;
            zzh().zza(new zzw(bundle2.getString("app_id"), bundle2.getString("origin"), zzkr2, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle2.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzao) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzao) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zza2));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        zzb();
        return zzb((String) null, str, str2);
    }

    public final ArrayList<Bundle> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3);
    }

    public final Map<String, Object> zza(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3, z);
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzb();
        return zzb((String) null, str, str2, z);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzm().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzb();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzr().zzi().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        zzb(bundle2, j);
    }

    @WorkerThread
    public final void zza(zzhc zzhc) {
        zzhc zzhc2;
        zzd();
        zzb();
        zzw();
        if (!(zzhc == null || zzhc == (zzhc2 = this.zzd))) {
            Preconditions.checkState(zzhc2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzhc;
    }

    public final void zza(zzhf zzhf) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzhf);
        if (!this.zze.add(zzhf)) {
            zzr().zzi().zza("OnEventListener already registered");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(@Nullable String str) {
        this.zzg.set(str);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, j, bundle, true, this.zzd == null || zzkw.zze(str2), false, (String) null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x03ea  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x041c  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x043d  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0506  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x058c  */
    /* JADX WARNING: Removed duplicated region for block: B:211:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r28, java.lang.String r29, long r30, android.os.Bundle r32, boolean r33, boolean r34, boolean r35, java.lang.String r36) {
        /*
            r27 = this;
            r7 = r27
            r8 = r28
            r15 = r29
            r13 = r30
            r12 = r32
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r32)
            r27.zzd()
            r27.zzw()
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzy
            boolean r0 = r0.zzab()
            if (r0 != 0) goto L_0x002c
            com.google.android.gms.measurement.internal.zzez r0 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzw()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.zza(r1)
            return
        L_0x002c:
            com.google.android.gms.measurement.internal.zzy r0 = r27.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzaq.zzbb
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r1)
            if (r0 == 0) goto L_0x0056
            com.google.android.gms.measurement.internal.zzes r0 = r27.zzg()
            java.util.List r0 = r0.zzah()
            if (r0 == 0) goto L_0x0056
            boolean r0 = r0.contains(r15)
            if (r0 != 0) goto L_0x0056
            com.google.android.gms.measurement.internal.zzez r0 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzw()
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.zza(r1, r15, r8)
            return
        L_0x0056:
            boolean r0 = r7.zzf
            r11 = 0
            r10 = 0
            r9 = 1
            if (r0 != 0) goto L_0x00b0
            r7.zzf = r9
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzy     // Catch:{ ClassNotFoundException -> 0x00a3 }
            boolean r0 = r0.zzt()     // Catch:{ ClassNotFoundException -> 0x00a3 }
            if (r0 != 0) goto L_0x0076
            java.lang.String r0 = "com.google.android.gms.tagmanager.TagManagerService"
            android.content.Context r1 = r27.zzn()     // Catch:{ ClassNotFoundException -> 0x00a3 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00a3 }
            java.lang.Class r0 = java.lang.Class.forName(r0, r9, r1)     // Catch:{ ClassNotFoundException -> 0x00a3 }
            goto L_0x007c
        L_0x0076:
            java.lang.String r0 = "com.google.android.gms.tagmanager.TagManagerService"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x00a3 }
        L_0x007c:
            java.lang.String r1 = "initialize"
            java.lang.Class[] r2 = new java.lang.Class[r9]     // Catch:{ Exception -> 0x0094 }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r10] = r3     // Catch:{ Exception -> 0x0094 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x0094 }
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0094 }
            android.content.Context r2 = r27.zzn()     // Catch:{ Exception -> 0x0094 }
            r1[r10] = r2     // Catch:{ Exception -> 0x0094 }
            r0.invoke(r11, r1)     // Catch:{ Exception -> 0x0094 }
            goto L_0x00b0
        L_0x0094:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzez r1 = r27.zzr()     // Catch:{ ClassNotFoundException -> 0x00a3 }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzi()     // Catch:{ ClassNotFoundException -> 0x00a3 }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.zza(r2, r0)     // Catch:{ ClassNotFoundException -> 0x00a3 }
            goto L_0x00b0
        L_0x00a3:
            com.google.android.gms.measurement.internal.zzez r0 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzv()
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.zza(r1)
        L_0x00b0:
            com.google.android.gms.measurement.internal.zzy r0 = r27.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzaq.zzbh
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r1)
            if (r0 == 0) goto L_0x00e1
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x00e1
            java.lang.String r0 = "gclid"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x00e1
            java.lang.String r4 = r12.getString(r0)
            com.google.android.gms.common.util.Clock r0 = r27.zzm()
            long r5 = r0.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1 = r27
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
        L_0x00e1:
            boolean r0 = com.google.android.gms.internal.measurement.zzof.zzb()
            if (r0 == 0) goto L_0x010f
            com.google.android.gms.measurement.internal.zzy r0 = r27.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzaq.zzcm
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r1)
            if (r0 == 0) goto L_0x010f
            r27.zzu()
            if (r33 == 0) goto L_0x010f
            boolean r0 = com.google.android.gms.measurement.internal.zzkw.zzg(r29)
            if (r0 == 0) goto L_0x010f
            com.google.android.gms.measurement.internal.zzkw r0 = r27.zzp()
            com.google.android.gms.measurement.internal.zzfl r1 = r27.zzs()
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zzx
            android.os.Bundle r1 = r1.zza()
            r0.zza((android.os.Bundle) r12, (android.os.Bundle) r1)
        L_0x010f:
            r0 = 40
            if (r35 == 0) goto L_0x0173
            r27.zzu()
            java.lang.String r1 = "_iap"
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x0173
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkw r1 = r1.zzi()
            java.lang.String r2 = "event"
            boolean r3 = r1.zza((java.lang.String) r2, (java.lang.String) r15)
            r4 = 2
            if (r3 != 0) goto L_0x012e
            goto L_0x0141
        L_0x012e:
            java.lang.String[] r3 = com.google.android.gms.measurement.internal.zzhb.zza
            boolean r3 = r1.zza((java.lang.String) r2, (java.lang.String[]) r3, (java.lang.String) r15)
            if (r3 != 0) goto L_0x0139
            r4 = 13
            goto L_0x0141
        L_0x0139:
            boolean r1 = r1.zza((java.lang.String) r2, (int) r0, (java.lang.String) r15)
            if (r1 != 0) goto L_0x0140
            goto L_0x0141
        L_0x0140:
            r4 = 0
        L_0x0141:
            if (r4 == 0) goto L_0x0173
            com.google.android.gms.measurement.internal.zzez r1 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzh()
            com.google.android.gms.measurement.internal.zzex r2 = r27.zzo()
            java.lang.String r2 = r2.zza((java.lang.String) r15)
            java.lang.String r3 = "Invalid public event name. Event will not be logged (FE)"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzy
            r1.zzi()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzkw.zza((java.lang.String) r15, (int) r0, (boolean) r9)
            if (r15 == 0) goto L_0x0167
            int r10 = r29.length()
        L_0x0167:
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkw r1 = r1.zzi()
            java.lang.String r2 = "_ev"
            r1.zza((int) r4, (java.lang.String) r2, (java.lang.String) r0, (int) r10)
            return
        L_0x0173:
            r27.zzu()
            com.google.android.gms.measurement.internal.zzin r1 = r27.zzi()
            com.google.android.gms.measurement.internal.zzik r1 = r1.zza((boolean) r10)
            java.lang.String r2 = "_sc"
            if (r1 == 0) goto L_0x018a
            boolean r3 = r12.containsKey(r2)
            if (r3 != 0) goto L_0x018a
            r1.zzd = r9
        L_0x018a:
            if (r33 == 0) goto L_0x0190
            if (r35 == 0) goto L_0x0190
            r3 = 1
            goto L_0x0191
        L_0x0190:
            r3 = 0
        L_0x0191:
            com.google.android.gms.measurement.internal.zzin.zza((com.google.android.gms.measurement.internal.zzik) r1, (android.os.Bundle) r12, (boolean) r3)
            java.lang.String r3 = "am"
            boolean r16 = r3.equals(r8)
            boolean r3 = com.google.android.gms.measurement.internal.zzkw.zze(r29)
            if (r33 == 0) goto L_0x01d3
            com.google.android.gms.measurement.internal.zzhc r4 = r7.zzd
            if (r4 == 0) goto L_0x01d3
            if (r3 != 0) goto L_0x01d3
            if (r16 != 0) goto L_0x01d3
            com.google.android.gms.measurement.internal.zzez r0 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzw()
            com.google.android.gms.measurement.internal.zzex r1 = r27.zzo()
            java.lang.String r1 = r1.zza((java.lang.String) r15)
            com.google.android.gms.measurement.internal.zzex r2 = r27.zzo()
            java.lang.String r2 = r2.zza((android.os.Bundle) r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.zza(r3, r1, r2)
            com.google.android.gms.measurement.internal.zzhc r1 = r7.zzd
            r2 = r28
            r3 = r29
            r4 = r32
            r5 = r30
            r1.interceptEvent(r2, r3, r4, r5)
            return
        L_0x01d3:
            com.google.android.gms.measurement.internal.zzgd r3 = r7.zzy
            boolean r3 = r3.zzag()
            if (r3 != 0) goto L_0x01dc
            return
        L_0x01dc:
            com.google.android.gms.measurement.internal.zzkw r3 = r27.zzp()
            int r3 = r3.zzb((java.lang.String) r15)
            if (r3 == 0) goto L_0x0220
            com.google.android.gms.measurement.internal.zzez r1 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzh()
            com.google.android.gms.measurement.internal.zzex r2 = r27.zzo()
            java.lang.String r2 = r2.zza((java.lang.String) r15)
            java.lang.String r4 = "Invalid event name. Event will not be logged (FE)"
            r1.zza(r4, r2)
            r27.zzp()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzkw.zza((java.lang.String) r15, (int) r0, (boolean) r9)
            if (r15 == 0) goto L_0x0208
            int r10 = r29.length()
        L_0x0208:
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkw r1 = r1.zzi()
            java.lang.String r2 = "_ev"
            r28 = r1
            r29 = r36
            r30 = r3
            r31 = r2
            r32 = r0
            r33 = r10
            r28.zza((java.lang.String) r29, (int) r30, (java.lang.String) r31, (java.lang.String) r32, (int) r33)
            return
        L_0x0220:
            java.lang.String r0 = "_sn"
            java.lang.String r5 = "_o"
            java.lang.String r3 = "_si"
            java.lang.String[] r4 = new java.lang.String[]{r5, r0, r2, r3}
            java.util.List r17 = com.google.android.gms.common.util.CollectionUtils.listOf((T[]) r4)
            com.google.android.gms.measurement.internal.zzkw r4 = r27.zzp()
            r6 = 1
            r9 = r4
            r4 = 0
            r10 = r36
            r19 = r11
            r11 = r29
            r12 = r32
            r13 = r17
            r14 = r35
            r15 = r6
            android.os.Bundle r15 = r9.zza((java.lang.String) r10, (java.lang.String) r11, (android.os.Bundle) r12, (java.util.List<java.lang.String>) r13, (boolean) r14, (boolean) r15)
            if (r15 == 0) goto L_0x026f
            boolean r6 = r15.containsKey(r2)
            if (r6 == 0) goto L_0x026f
            boolean r6 = r15.containsKey(r3)
            if (r6 != 0) goto L_0x0255
            goto L_0x026f
        L_0x0255:
            java.lang.String r0 = r15.getString(r0)
            java.lang.String r2 = r15.getString(r2)
            long r9 = r15.getLong(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r9)
            com.google.android.gms.measurement.internal.zzik r11 = new com.google.android.gms.measurement.internal.zzik
            long r9 = r3.longValue()
            r11.<init>(r0, r2, r9)
            goto L_0x0271
        L_0x026f:
            r11 = r19
        L_0x0271:
            if (r11 != 0) goto L_0x0275
            r0 = r1
            goto L_0x0276
        L_0x0275:
            r0 = r11
        L_0x0276:
            com.google.android.gms.measurement.internal.zzy r1 = r27.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzaq.zzat
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r2)
            java.lang.String r14 = "_ae"
            r9 = 0
            if (r1 == 0) goto L_0x02b1
            r27.zzu()
            com.google.android.gms.measurement.internal.zzin r1 = r27.zzi()
            com.google.android.gms.measurement.internal.zzik r1 = r1.zza((boolean) r4)
            if (r1 == 0) goto L_0x02b1
            r13 = r29
            boolean r1 = r14.equals(r13)
            if (r1 == 0) goto L_0x02b3
            com.google.android.gms.measurement.internal.zzjw r1 = r27.zzk()
            com.google.android.gms.measurement.internal.zzkc r1 = r1.zzb
            long r1 = r1.zzb()
            int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x02b3
            com.google.android.gms.measurement.internal.zzkw r3 = r27.zzp()
            r3.zza((android.os.Bundle) r15, (long) r1)
            goto L_0x02b3
        L_0x02b1:
            r13 = r29
        L_0x02b3:
            boolean r1 = com.google.android.gms.internal.measurement.zzmv.zzb()
            if (r1 == 0) goto L_0x0335
            com.google.android.gms.measurement.internal.zzy r1 = r27.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzaq.zzbu
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r2)
            if (r1 == 0) goto L_0x0335
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r8)
            java.lang.String r2 = "_ffr"
            if (r1 != 0) goto L_0x0318
            java.lang.String r1 = "_ssr"
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x0318
            com.google.android.gms.measurement.internal.zzkw r1 = r27.zzp()
            java.lang.String r2 = r15.getString(r2)
            boolean r3 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r2)
            if (r3 == 0) goto L_0x02e8
            r11 = r19
            goto L_0x02ec
        L_0x02e8:
            java.lang.String r11 = r2.trim()
        L_0x02ec:
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzs()
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzu
            java.lang.String r2 = r2.zza()
            boolean r2 = com.google.android.gms.measurement.internal.zzkw.zzc((java.lang.String) r11, (java.lang.String) r2)
            if (r2 == 0) goto L_0x030b
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzw()
            java.lang.String r2 = "Not logging duplicate session_start_with_rollout event"
            r1.zza(r2)
            r1 = 0
            goto L_0x0315
        L_0x030b:
            com.google.android.gms.measurement.internal.zzfl r1 = r1.zzs()
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzu
            r1.zza(r11)
            r1 = 1
        L_0x0315:
            if (r1 != 0) goto L_0x0335
            return
        L_0x0318:
            boolean r1 = r14.equals(r13)
            if (r1 == 0) goto L_0x0335
            com.google.android.gms.measurement.internal.zzkw r1 = r27.zzp()
            com.google.android.gms.measurement.internal.zzfl r1 = r1.zzs()
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzu
            java.lang.String r1 = r1.zza()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0335
            r15.putString(r2, r1)
        L_0x0335:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r12.add(r15)
            com.google.android.gms.measurement.internal.zzkw r1 = r27.zzp()
            java.security.SecureRandom r1 = r1.zzh()
            long r2 = r1.nextLong()
            com.google.android.gms.measurement.internal.zzfl r1 = r27.zzs()
            com.google.android.gms.measurement.internal.zzfp r1 = r1.zzp
            long r19 = r1.zza()
            int r1 = (r19 > r9 ? 1 : (r19 == r9 ? 0 : -1))
            if (r1 <= 0) goto L_0x03bc
            com.google.android.gms.measurement.internal.zzfl r1 = r27.zzs()
            r9 = r30
            boolean r1 = r1.zza((long) r9)
            if (r1 == 0) goto L_0x03be
            com.google.android.gms.measurement.internal.zzfl r1 = r27.zzs()
            com.google.android.gms.measurement.internal.zzfn r1 = r1.zzr
            boolean r1 = r1.zza()
            if (r1 == 0) goto L_0x03be
            com.google.android.gms.measurement.internal.zzez r1 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()
            java.lang.String r6 = "Current session is expired, remove the session number, ID, and engagement time"
            r1.zza(r6)
            r6 = 0
            com.google.android.gms.common.util.Clock r1 = r27.zzm()
            long r19 = r1.currentTimeMillis()
            java.lang.String r11 = "auto"
            java.lang.String r21 = "_sid"
            r1 = r27
            r22 = r2
            r2 = r11
            r3 = r21
            r11 = 0
            r4 = r6
            r8 = r5
            r5 = r19
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            r4 = 0
            com.google.android.gms.common.util.Clock r1 = r27.zzm()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r1 = r27
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            com.google.android.gms.common.util.Clock r1 = r27.zzm()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_se"
            r1 = r27
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            goto L_0x03c2
        L_0x03bc:
            r9 = r30
        L_0x03be:
            r22 = r2
            r8 = r5
            r11 = 0
        L_0x03c2:
            java.lang.String r1 = "extend_session"
            r2 = 0
            long r1 = r15.getLong(r1, r2)
            r3 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x03ea
            com.google.android.gms.measurement.internal.zzez r1 = r27.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzjw r1 = r1.zze()
            com.google.android.gms.measurement.internal.zzke r1 = r1.zza
            r5 = 1
            r1.zza(r9, r5)
            goto L_0x03eb
        L_0x03ea:
            r5 = 1
        L_0x03eb:
            java.util.Set r1 = r15.keySet()
            int r2 = r15.size()
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.util.Arrays.sort(r1)
            boolean r2 = com.google.android.gms.internal.measurement.zzmo.zzb()
            if (r2 == 0) goto L_0x043d
            com.google.android.gms.measurement.internal.zzy r2 = r27.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzaq.zzcg
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x043d
            com.google.android.gms.measurement.internal.zzy r2 = r27.zzt()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzaq.zzcf
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x043d
            int r0 = r1.length
            r2 = 0
        L_0x041e:
            if (r2 >= r0) goto L_0x0435
            r3 = r1[r2]
            r27.zzp()
            java.lang.Object r4 = r15.get(r3)
            android.os.Bundle[] r4 = com.google.android.gms.measurement.internal.zzkw.zzb((java.lang.Object) r4)
            if (r4 == 0) goto L_0x0432
            r15.putParcelableArray(r3, r4)
        L_0x0432:
            int r2 = r2 + 1
            goto L_0x041e
        L_0x0435:
            r33 = r8
            r2 = r13
            r0 = r14
            r20 = 1
            goto L_0x04ff
        L_0x043d:
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x0440:
            java.lang.String r6 = "_eid"
            if (r3 >= r2) goto L_0x04ec
            r5 = r1[r3]
            java.lang.Object r19 = r15.get(r5)
            r27.zzp()
            r32 = r1
            android.os.Bundle[] r1 = com.google.android.gms.measurement.internal.zzkw.zzb((java.lang.Object) r19)
            if (r1 == 0) goto L_0x04ca
            int r11 = r1.length
            r15.putInt(r5, r11)
            r19 = r2
            r11 = 0
        L_0x045c:
            int r2 = r1.length
            if (r11 >= r2) goto L_0x04bc
            r2 = r1[r11]
            r20 = r15
            r15 = 1
            com.google.android.gms.measurement.internal.zzin.zza((com.google.android.gms.measurement.internal.zzik) r0, (android.os.Bundle) r2, (boolean) r15)
            com.google.android.gms.measurement.internal.zzkw r18 = r27.zzp()
            r21 = 0
            java.lang.String r24 = "_ep"
            r9 = r18
            r10 = r36
            r25 = r11
            r11 = r24
            r26 = r12
            r12 = r2
            r2 = r13
            r13 = r17
            r18 = r0
            r0 = r14
            r14 = r35
            r33 = r8
            r8 = r20
            r20 = 1
            r15 = r21
            android.os.Bundle r9 = r9.zza((java.lang.String) r10, (java.lang.String) r11, (android.os.Bundle) r12, (java.util.List<java.lang.String>) r13, (boolean) r14, (boolean) r15)
            java.lang.String r10 = "_en"
            r9.putString(r10, r2)
            r10 = r22
            r9.putLong(r6, r10)
            java.lang.String r12 = "_gn"
            r9.putString(r12, r5)
            int r12 = r1.length
            java.lang.String r13 = "_ll"
            r9.putInt(r13, r12)
            java.lang.String r12 = "_i"
            r13 = r25
            r9.putInt(r12, r13)
            r12 = r26
            r12.add(r9)
            int r9 = r13 + 1
            r14 = r0
            r13 = r2
            r15 = r8
            r0 = r18
            r8 = r33
            r11 = r9
            r9 = r30
            goto L_0x045c
        L_0x04bc:
            r18 = r0
            r33 = r8
            r2 = r13
            r0 = r14
            r8 = r15
            r10 = r22
            r20 = 1
            int r1 = r1.length
            int r4 = r4 + r1
            goto L_0x04d7
        L_0x04ca:
            r18 = r0
            r19 = r2
            r33 = r8
            r2 = r13
            r0 = r14
            r8 = r15
            r10 = r22
            r20 = 1
        L_0x04d7:
            int r3 = r3 + 1
            r1 = r32
            r14 = r0
            r13 = r2
            r15 = r8
            r22 = r10
            r0 = r18
            r2 = r19
            r5 = 1
            r11 = 0
            r9 = r30
            r8 = r33
            goto L_0x0440
        L_0x04ec:
            r33 = r8
            r2 = r13
            r0 = r14
            r8 = r15
            r10 = r22
            r20 = 1
            if (r4 == 0) goto L_0x04ff
            r8.putLong(r6, r10)
            java.lang.String r1 = "_epc"
            r8.putInt(r1, r4)
        L_0x04ff:
            r10 = 0
        L_0x0500:
            int r1 = r12.size()
            if (r10 >= r1) goto L_0x0576
            java.lang.Object r1 = r12.get(r10)
            android.os.Bundle r1 = (android.os.Bundle) r1
            if (r10 == 0) goto L_0x0510
            r3 = 1
            goto L_0x0511
        L_0x0510:
            r3 = 0
        L_0x0511:
            if (r3 == 0) goto L_0x051a
            java.lang.String r3 = "_ep"
            r8 = r28
            r9 = r33
            goto L_0x051f
        L_0x051a:
            r8 = r28
            r9 = r33
            r3 = r2
        L_0x051f:
            r1.putString(r9, r8)
            if (r34 == 0) goto L_0x052c
            com.google.android.gms.measurement.internal.zzkw r4 = r27.zzp()
            android.os.Bundle r1 = r4.zza((android.os.Bundle) r1)
        L_0x052c:
            r11 = r1
            com.google.android.gms.measurement.internal.zzao r13 = new com.google.android.gms.measurement.internal.zzao
            com.google.android.gms.measurement.internal.zzan r4 = new com.google.android.gms.measurement.internal.zzan
            r4.<init>(r11)
            r1 = r13
            r14 = r2
            r2 = r3
            r3 = r4
            r4 = r28
            r15 = 1
            r5 = r30
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzis r1 = r27.zzh()
            r5 = r36
            r1.zza((com.google.android.gms.measurement.internal.zzao) r13, (java.lang.String) r5)
            if (r16 != 0) goto L_0x056e
            java.util.Set<com.google.android.gms.measurement.internal.zzhf> r1 = r7.zze
            java.util.Iterator r13 = r1.iterator()
        L_0x0551:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x056e
            java.lang.Object r1 = r13.next()
            com.google.android.gms.measurement.internal.zzhf r1 = (com.google.android.gms.measurement.internal.zzhf) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r11)
            r2 = r28
            r3 = r29
            r5 = r30
            r1.onEvent(r2, r3, r4, r5)
            r5 = r36
            goto L_0x0551
        L_0x056e:
            int r10 = r10 + 1
            r33 = r9
            r2 = r14
            r20 = 1
            goto L_0x0500
        L_0x0576:
            r14 = r2
            r15 = 1
            r27.zzu()
            com.google.android.gms.measurement.internal.zzin r1 = r27.zzi()
            r2 = 0
            com.google.android.gms.measurement.internal.zzik r1 = r1.zza((boolean) r2)
            if (r1 == 0) goto L_0x059b
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x059b
            com.google.android.gms.measurement.internal.zzjw r0 = r27.zzk()
            com.google.android.gms.common.util.Clock r1 = r27.zzm()
            long r1 = r1.elapsedRealtime()
            r0.zza(r15, r15, r1)
        L_0x059b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhh.zza(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        zzb();
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (zzt().zza(zzaq.zzcc)) {
            String str4 = str2;
            if (zzkw.zzc(str2, "screen_view")) {
                zzi().zza(bundle2, j);
                return;
            }
        } else {
            String str5 = str2;
        }
        long j2 = j;
        zzb(str3, str2, j, bundle2, z2, !z2 || this.zzd == null || zzkw.zze(str2), !z, (String) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzd()
            r8.zzb()
            r8.zzw()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0063
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0053
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0053
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L_0x0038
            r4 = r2
            goto L_0x003a
        L_0x0038:
            r4 = 0
        L_0x003a:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzfl r0 = r8.zzs()
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzn
            long r4 = r10.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x004e
            java.lang.String r11 = "true"
        L_0x004e:
            r0.zza(r11)
            r6 = r10
            goto L_0x0061
        L_0x0053:
            if (r11 != 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzfl r10 = r8.zzs()
            com.google.android.gms.measurement.internal.zzfr r10 = r10.zzn
            java.lang.String r0 = "unset"
            r10.zza(r0)
            r6 = r11
        L_0x0061:
            r3 = r1
            goto L_0x0065
        L_0x0063:
            r3 = r10
            r6 = r11
        L_0x0065:
            com.google.android.gms.measurement.internal.zzgd r10 = r8.zzy
            boolean r10 = r10.zzab()
            if (r10 != 0) goto L_0x007b
            com.google.android.gms.measurement.internal.zzez r9 = r8.zzr()
            com.google.android.gms.measurement.internal.zzfb r9 = r9.zzx()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L_0x007b:
            com.google.android.gms.measurement.internal.zzgd r10 = r8.zzy
            boolean r10 = r10.zzag()
            if (r10 != 0) goto L_0x0084
            return
        L_0x0084:
            com.google.android.gms.measurement.internal.zzkr r10 = new com.google.android.gms.measurement.internal.zzkr
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzis r9 = r8.zzh()
            r9.zza((com.google.android.gms.measurement.internal.zzkr) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhh.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, true, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        int i = 6;
        int i2 = 0;
        if (z) {
            i = zzp().zzc(str2);
        } else {
            zzkw zzp = zzp();
            if (zzp.zza("user property", str2)) {
                if (!zzp.zza("user property", zzhd.zza, str2)) {
                    i = 15;
                } else if (zzp.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            zzp();
            String zza2 = zzkw.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzy.zzi().zza(i, "_ev", zza2, i2);
        } else if (obj != null) {
            int zzb2 = zzp().zzb(str2, obj);
            if (zzb2 != 0) {
                zzp();
                String zza3 = zzkw.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzy.zzi().zza(zzb2, "_ev", zza3, i2);
                return;
            }
            Object zzc2 = zzp().zzc(str2, obj);
            if (zzc2 != null) {
                zza(str3, str2, j, zzc2);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    public final void zza(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zza();
        zzb(str, str2, str3, bundle);
    }

    public final void zza(boolean z) {
        zzw();
        zzb();
        zzq().zza((Runnable) new zzhz(this, z));
    }

    public final void zzab() {
        if (zzn().getApplicationContext() instanceof Application) {
            ((Application) zzn().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzq().zza(atomicReference, 15000, "boolean test flag value", new zzhi(this, atomicReference));
    }

    public final String zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzq().zza(atomicReference, 15000, "String test flag value", new zzht(this, atomicReference));
    }

    public final Long zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzq().zza(atomicReference, 15000, "long test flag value", new zzhu(this, atomicReference));
    }

    public final Integer zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzq().zza(atomicReference, 15000, "int test flag value", new zzhx(this, atomicReference));
    }

    public final Double zzag() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzq().zza(atomicReference, 15000, "double test flag value", new zzhw(this, atomicReference));
    }

    @Nullable
    public final String zzah() {
        zzb();
        return this.zzg.get();
    }

    @WorkerThread
    public final void zzai() {
        zzd();
        zzb();
        zzw();
        if (this.zzy.zzag()) {
            if (zzt().zza(zzaq.zzbg)) {
                zzy zzt = zzt();
                zzt.zzu();
                Boolean zze2 = zzt.zze("google_analytics_deferred_deep_link_enabled");
                if (zze2 != null && zze2.booleanValue()) {
                    zzr().zzw().zza("Deferred Deep Link feature enabled.");
                    zzq().zza((Runnable) new zzhj(this));
                }
            }
            zzh().zzae();
            this.zzc = false;
            String zzw = zzs().zzw();
            if (!TextUtils.isEmpty(zzw)) {
                zzl().zzaa();
                if (!zzw.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzw);
                    zza("auto", "_ou", bundle);
                }
            }
        }
    }

    @Nullable
    public final String zzaj() {
        zzik zzab = this.zzy.zzv().zzab();
        if (zzab != null) {
            return zzab.zza;
        }
        return null;
    }

    @Nullable
    public final String zzak() {
        zzik zzab = this.zzy.zzv().zzab();
        if (zzab != null) {
            return zzab.zzb;
        }
        return null;
    }

    @Nullable
    public final String zzal() {
        if (this.zzy.zzo() != null) {
            return this.zzy.zzo();
        }
        try {
            return zzil.zza(zzn(), "google_app_id");
        } catch (IllegalStateException e) {
            this.zzy.zzr().zzf().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public final List<zzkr> zzb(boolean z) {
        zzfb zzf2;
        String str;
        zzb();
        zzw();
        zzr().zzx().zza("Getting user properties (FE)");
        if (zzq().zzg()) {
            zzf2 = zzr().zzf();
            str = "Cannot get all user properties from analytics worker thread";
        } else if (zzx.zza()) {
            zzf2 = zzr().zzf();
            str = "Cannot get all user properties from main thread";
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzq().zza(atomicReference, 5000, "get user properties", new zzhm(this, atomicReference, z));
            List<zzkr> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzr().zzf().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
        zzf2.zza(str);
        return Collections.emptyList();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final void zzb(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zza();
        zzb(new Bundle(bundle), zzm().currentTimeMillis());
    }

    public final void zzb(zzhf zzhf) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzhf);
        if (!this.zze.remove(zzhf)) {
            zzr().zzi().zza("OnEventListener had not been registered");
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(String str, String str2, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, zzm().currentTimeMillis(), bundle);
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        zzb();
        zzb((String) null, str, str2, bundle);
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zza zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzhh zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzes zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzis zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzin zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzev zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzjw zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzai zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzex zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzkw zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzfw zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzez zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzfl zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzy zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzx zzu() {
        return super.zzu();
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }
}
