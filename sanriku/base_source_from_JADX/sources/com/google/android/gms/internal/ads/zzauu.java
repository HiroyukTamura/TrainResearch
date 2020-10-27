package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzauu {
    private final AtomicReference<ThreadPoolExecutor> zzdsp = new AtomicReference<>((Object) null);
    private final Object zzdsq = new Object();
    @Nullable
    private String zzdsr = null;
    @Nullable
    private String zzdss = null;
    @VisibleForTesting
    private final AtomicBoolean zzdst = new AtomicBoolean(false);
    private final AtomicInteger zzdsu = new AtomicInteger(-1);
    private final AtomicReference<Object> zzdsv = new AtomicReference<>((Object) null);
    private final AtomicReference<Object> zzdsw = new AtomicReference<>((Object) null);
    private final ConcurrentMap<String, Method> zzdsx = new ConcurrentHashMap(9);
    private final AtomicReference<zzbgr> zzdsy = new AtomicReference<>((Object) null);
    private final BlockingQueue<FutureTask<?>> zzdsz = new ArrayBlockingQueue(20);
    private final Object zzdta = new Object();

    private final Object zza(String str, Context context) {
        if (!zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdsv, true)) {
            return null;
        }
        try {
            return zzm(context, str).invoke(this.zzdsv.get(), new Object[0]);
        } catch (Exception e) {
            zza(e, str, true);
            return null;
        }
    }

    private final <T> T zza(String str, @Nullable T t, zzavh<T> zzavh) {
        synchronized (this.zzdsy) {
            if (this.zzdsy.get() != null) {
                try {
                    T zzb = zzavh.zzb(this.zzdsy.get());
                    return zzb;
                } catch (Exception e) {
                    zza(e, str, false);
                    return t;
                }
            }
        }
    }

    private final void zza(Context context, String str, String str2) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdsv, true)) {
            Method zzl = zzl(context, str2);
            try {
                zzl.invoke(this.zzdsv.get(), new Object[]{str});
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zzawr.zzeg(sb.toString());
            } catch (Exception e) {
                zza(e, str2, false);
            }
        }
    }

    private final void zza(Context context, String str, String str2, @Nullable Bundle bundle) {
        if (zzab(context)) {
            Bundle zzl = zzl(str2, str);
            if (bundle != null) {
                zzl.putAll(bundle);
            }
            if (zzac(context)) {
                zza("logEventInternal", (zzavk) new zzauv(str, zzl));
            } else if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdsv, true)) {
                Method zzai = zzai(context);
                try {
                    zzai.invoke(this.zzdsv.get(), new Object[]{"am", str, zzl});
                } catch (Exception e) {
                    zza(e, "logEventInternal", true);
                }
            }
        }
    }

    private final void zza(Exception exc, String str, boolean z) {
        if (!this.zzdst.get()) {
            StringBuilder sb = new StringBuilder(C0681a.m336b(str, 30));
            sb.append("Invoke Firebase method ");
            sb.append(str);
            sb.append(" error.");
            zzazw.zzfc(sb.toString());
            if (z) {
                zzazw.zzfc("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
                this.zzdst.set(true);
            }
        }
    }

    private final void zza(String str, zzavk zzavk) {
        synchronized (this.zzdsy) {
            FutureTask futureTask = new FutureTask(new zzauy(this, zzavk, str), (Object) null);
            if (this.zzdsy.get() != null) {
                futureTask.run();
            } else {
                this.zzdsz.offer(futureTask);
            }
        }
    }

    private final boolean zza(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet((Object) null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context}));
            } catch (Exception e) {
                zza(e, "getInstance", z);
                return false;
            }
        }
        return true;
    }

    @VisibleForTesting
    private static boolean zzac(Context context) {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzckt)).booleanValue()) {
            return false;
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) < ((Integer) zzvj.zzpv().zzd(zzzz.zzcku)).intValue()) {
            return false;
        }
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzckv)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    @Nullable
    private final Method zzai(Context context) {
        Class<String> cls = String.class;
        Method method = (Method) this.zzdsx.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", new Class[]{cls, cls, Bundle.class});
            this.zzdsx.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, "logEventInternal", true);
            return null;
        }
    }

    private static Bundle zzl(String str, String str2) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e) {
            String valueOf = String.valueOf(str);
            zzazw.zzc(valueOf.length() != 0 ? "Invalid event ID: ".concat(valueOf) : new String("Invalid event ID: "), e);
        }
        if ("_ac".equals(str2)) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    @Nullable
    private final Method zzl(Context context, String str) {
        Method method = (Method) this.zzdsx.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[]{String.class});
            this.zzdsx.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    @Nullable
    private final Method zzm(Context context, String str) {
        Method method = (Method) this.zzdsx.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzdsx.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final Method zzn(Context context, String str) {
        Class<String> cls = String.class;
        Method method = (Method) this.zzdsx.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, new Class[]{Activity.class, cls, cls});
            this.zzdsx.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final ThreadPoolExecutor zzvm() {
        if (this.zzdsp.get() == null) {
            this.zzdsp.compareAndSet((Object) null, new ThreadPoolExecutor(((Integer) zzvj.zzpv().zzd(zzzz.zzcks)).intValue(), ((Integer) zzvj.zzpv().zzd(zzzz.zzcks)).intValue(), 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), new zzavi(this)));
        }
        return this.zzdsp.get();
    }

    public final void zza(Context context, zzuj zzuj) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzckz)).booleanValue() && zzab(context) && zzac(context)) {
            synchronized (this.zzdta) {
            }
        }
    }

    public final void zza(Context context, zzyy zzyy) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzckz)).booleanValue() && zzab(context) && zzac(context)) {
            synchronized (this.zzdta) {
            }
        }
    }

    public final void zza(Context context, String str, String str2, String str3, int i) {
        if (zzab(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i);
            zza(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(C0681a.m336b(str3, 75));
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zzawr.zzeg(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzavk zzavk, String str) {
        if (this.zzdsy.get() != null) {
            try {
                zzavk.zza(this.zzdsy.get());
            } catch (Exception e) {
                zza(e, str, false);
            }
        }
    }

    public final boolean zzab(Context context) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzckm)).booleanValue() && !this.zzdst.get()) {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzckw)).booleanValue()) {
                return true;
            }
            if (this.zzdsu.get() == -1) {
                zzvj.zzpr();
                if (!zzazm.zzd(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                    zzvj.zzpr();
                    if (zzazm.zzbm(context)) {
                        zzazw.zzfc("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.zzdsu.set(0);
                    }
                }
                this.zzdsu.set(1);
            }
            if (this.zzdsu.get() == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzad(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "getCurrentScreenName"
            boolean r1 = r6.zzab(r7)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x000b
            return r2
        L_0x000b:
            boolean r1 = zzac(r7)
            if (r1 == 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzavh r7 = com.google.android.gms.internal.ads.zzauz.zzdtc
            java.lang.String r0 = "getCurrentScreenNameOrScreenClass"
            java.lang.Object r7 = r6.zza((java.lang.String) r0, r2, r7)
            java.lang.String r7 = (java.lang.String) r7
            return r7
        L_0x001c:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r6.zzdsv
            r3 = 1
            java.lang.String r4 = "com.google.android.gms.measurement.AppMeasurement"
            boolean r1 = r6.zza((android.content.Context) r7, (java.lang.String) r4, (java.util.concurrent.atomic.AtomicReference<java.lang.Object>) r1, (boolean) r3)
            if (r1 != 0) goto L_0x0028
            return r2
        L_0x0028:
            r1 = 0
            java.lang.reflect.Method r3 = r6.zzm(r7, r0)     // Catch:{ Exception -> 0x0056 }
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r4 = r6.zzdsv     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x0056 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r3 = r3.invoke(r4, r5)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0056 }
            if (r3 != 0) goto L_0x0052
            java.lang.String r3 = "getCurrentScreenClass"
            java.lang.reflect.Method r7 = r6.zzm(r7, r3)     // Catch:{ Exception -> 0x0056 }
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r3 = r6.zzdsv     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x0056 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r7 = r7.invoke(r3, r4)     // Catch:{ Exception -> 0x0056 }
            r3 = r7
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0056 }
        L_0x0052:
            if (r3 == 0) goto L_0x0055
            return r3
        L_0x0055:
            return r2
        L_0x0056:
            r7 = move-exception
            r6.zza((java.lang.Exception) r7, (java.lang.String) r0, (boolean) r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauu.zzad(android.content.Context):java.lang.String");
    }

    @Nullable
    public final String zzae(Context context) {
        if (!zzab(context)) {
            return null;
        }
        synchronized (this.zzdsq) {
            if (this.zzdsr != null) {
                String str = this.zzdsr;
                return str;
            }
            this.zzdsr = zzac(context) ? (String) zza("getGmpAppId", this.zzdsr, zzavb.zzdtc) : (String) zza("getGmpAppId", context);
            String str2 = this.zzdsr;
            return str2;
        }
    }

    @Nullable
    public final String zzaf(Context context) {
        if (!zzab(context)) {
            return null;
        }
        long longValue = ((Long) zzvj.zzpv().zzd(zzzz.zzckr)).longValue();
        if (zzac(context)) {
            if (longValue >= 0) {
                return (String) zzvm().submit(new zzavd(this)).get(longValue, TimeUnit.MILLISECONDS);
            }
            try {
                return (String) zza("getAppInstanceId", (Object) null, zzave.zzdtc);
            } catch (TimeoutException unused) {
                return "TIME_OUT";
            } catch (Exception unused2) {
                return null;
            }
        } else if (longValue < 0) {
            return (String) zza("getAppInstanceId", context);
        } else {
            try {
                return (String) zzvm().submit(new zzavg(this, context)).get(longValue, TimeUnit.MILLISECONDS);
            } catch (TimeoutException unused3) {
                return "TIME_OUT";
            } catch (Exception unused4) {
                return null;
            }
        }
    }

    @Nullable
    public final String zzag(Context context) {
        if (!zzab(context)) {
            return null;
        }
        if (zzac(context)) {
            Long l = (Long) zza("getAdEventId", (Object) null, zzavf.zzdtc);
            if (l != null) {
                return Long.toString(l.longValue());
            }
            return null;
        }
        Object zza = zza("generateEventId", context);
        if (zza != null) {
            return zza.toString();
        }
        return null;
    }

    @Nullable
    public final String zzah(Context context) {
        if (!zzab(context)) {
            return null;
        }
        synchronized (this.zzdsq) {
            if (this.zzdss != null) {
                String str = this.zzdss;
                return str;
            }
            this.zzdss = zzac(context) ? (String) zza("getAppIdOrigin", this.zzdss, zzauw.zzdtc) : "fa";
            String str2 = this.zzdss;
            return str2;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzaj(Context context) throws Exception {
        return (String) zza("getAppInstanceId", context);
    }

    public final void zze(Context context, String str) {
        if (zzab(context)) {
            if (zzac(context)) {
                zza("beginAdUnitExposure", (zzavk) new zzaut(str));
            } else {
                zza(context, str, "beginAdUnitExposure");
            }
        }
    }

    public final void zzf(Context context, String str) {
        if (zzab(context)) {
            if (zzac(context)) {
                zza("endAdUnitExposure", (zzavk) new zzava(str));
            } else {
                zza(context, str, "endAdUnitExposure");
            }
        }
    }

    public final void zzg(Context context, String str) {
        if (!zzab(context) || !(context instanceof Activity)) {
            return;
        }
        if (zzac(context)) {
            zza("setScreenName", (zzavk) new zzavc(context, str));
        } else if (zza(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzdsw, false)) {
            Method zzn = zzn(context, "setCurrentScreen");
            try {
                zzn.invoke(this.zzdsw.get(), new Object[]{(Activity) context, str, context.getPackageName()});
            } catch (Exception e) {
                zza(e, "setCurrentScreen", false);
            }
        }
    }

    public final void zzh(Context context, String str) {
        zza(context, "_ac", str, (Bundle) null);
    }

    public final void zzi(Context context, String str) {
        zza(context, "_ai", str, (Bundle) null);
    }

    public final void zzj(Context context, String str) {
        zza(context, "_aq", str, (Bundle) null);
    }

    public final void zzk(Context context, String str) {
        zza(context, "_aa", str, (Bundle) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzvn() throws Exception {
        return (String) zza("getAppInstanceId", (Object) null, zzaux.zzdtc);
    }
}
