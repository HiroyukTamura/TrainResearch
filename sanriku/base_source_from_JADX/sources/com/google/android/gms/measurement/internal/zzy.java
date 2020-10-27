package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzmd;
import com.google.android.gms.internal.measurement.zzor;
import java.lang.reflect.InvocationTargetException;

public final class zzy extends zzgx {
    private Boolean zza;
    @NonNull
    private zzaa zzb = zzab.zza;
    private Boolean zzc;

    zzy(zzgd zzgd) {
        super(zzgd);
    }

    @WorkerThread
    private final int zza(String str, @NonNull zzeo<Integer> zzeo, int i, int i2) {
        return Math.max(Math.min(zzb(str, zzeo), i2), i);
    }

    private final String zza(String str, String str2) {
        String str3;
        zzfb zzfb;
        Class<String> cls = String.class;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{str, str2});
        } catch (ClassNotFoundException e) {
            e = e;
            zzfb = zzr().zzf();
            str3 = "Could not find SystemProperties class";
            zzfb.zza(str3, e);
            return str2;
        } catch (NoSuchMethodException e2) {
            e = e2;
            zzfb = zzr().zzf();
            str3 = "Could not find SystemProperties.get() method";
            zzfb.zza(str3, e);
            return str2;
        } catch (IllegalAccessException e3) {
            e = e3;
            zzfb = zzr().zzf();
            str3 = "Could not access SystemProperties.get()";
            zzfb.zza(str3, e);
            return str2;
        } catch (InvocationTargetException e4) {
            e = e4;
            zzfb = zzr().zzf();
            str3 = "SystemProperties.get() threw an exception";
            zzfb.zza(str3, e);
            return str2;
        }
    }

    public static long zzk() {
        return zzaq.zzac.zza(null).longValue();
    }

    public static long zzv() {
        return zzaq.zzc.zza(null).longValue();
    }

    @Nullable
    @VisibleForTesting
    private final Bundle zzz() {
        try {
            if (zzn().getPackageManager() == null) {
                zzr().zzf().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzn()).getApplicationInfo(zzn().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            zzr().zzf().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            zzr().zzf().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final int zza(@Size(min = 1) String str) {
        return zza(str, zzaq.zzah, 25, 100);
    }

    @WorkerThread
    public final long zza(String str, @NonNull zzeo<Long> zzeo) {
        if (str != null) {
            String zza2 = this.zzb.zza(str, zzeo.zza());
            if (!TextUtils.isEmpty(zza2)) {
                try {
                    return zzeo.zza(Long.valueOf(Long.parseLong(zza2))).longValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return zzeo.zza(null).longValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002d, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(com.google.android.gms.measurement.internal.zzf r6) {
        /*
            r5 = this;
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r1 = r6.zze()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0033
            boolean r1 = com.google.android.gms.internal.measurement.zzoe.zzb()
            if (r1 == 0) goto L_0x002f
            com.google.android.gms.measurement.internal.zzy r1 = r5.zzt()
            java.lang.String r2 = r6.zzc()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzaq.zzbn
            boolean r1 = r1.zzd(r2, r3)
            if (r1 == 0) goto L_0x002f
            java.lang.String r1 = r6.zzg()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0033
        L_0x002f:
            java.lang.String r1 = r6.zzf()
        L_0x0033:
            com.google.android.gms.measurement.internal.zzeo<java.lang.String> r2 = com.google.android.gms.measurement.internal.zzaq.zzd
            r3 = 0
            java.lang.Object r2 = r2.zza(r3)
            java.lang.String r2 = (java.lang.String) r2
            android.net.Uri$Builder r2 = r0.scheme(r2)
            com.google.android.gms.measurement.internal.zzeo<java.lang.String> r4 = com.google.android.gms.measurement.internal.zzaq.zze
            java.lang.Object r3 = r4.zza(r3)
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri$Builder r2 = r2.encodedAuthority(r3)
            java.lang.String r3 = "config/app/"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r4 = r1.length()
            if (r4 == 0) goto L_0x005d
            java.lang.String r1 = r3.concat(r1)
            goto L_0x0062
        L_0x005d:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L_0x0062:
            android.net.Uri$Builder r1 = r2.path(r1)
            java.lang.String r6 = r6.zzd()
            java.lang.String r2 = "app_instance_id"
            android.net.Uri$Builder r6 = r1.appendQueryParameter(r2, r6)
            java.lang.String r1 = "platform"
            java.lang.String r2 = "android"
            android.net.Uri$Builder r6 = r6.appendQueryParameter(r1, r2)
            long r1 = r5.zzf()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "gmp_version"
            r6.appendQueryParameter(r2, r1)
            android.net.Uri r6 = r0.build()
            java.lang.String r6 = r6.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zza(com.google.android.gms.measurement.internal.zzf):java.lang.String");
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* access modifiers changed from: package-private */
    public final void zza(@NonNull zzaa zzaa) {
        this.zzb = zzaa;
    }

    public final boolean zza(zzeo<Boolean> zzeo) {
        return zzd((String) null, zzeo);
    }

    /* access modifiers changed from: package-private */
    public final int zzb(@Size(min = 1) String str) {
        if (!zzmd.zzb() || !zzd((String) null, zzaq.zzcj)) {
            return 500;
        }
        return zza(str, zzaq.zzag, 500, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
    }

    @WorkerThread
    public final int zzb(String str, @NonNull zzeo<Integer> zzeo) {
        if (str != null) {
            String zza2 = this.zzb.zza(str, zzeo.zza());
            if (!TextUtils.isEmpty(zza2)) {
                try {
                    return zzeo.zza(Integer.valueOf(Integer.parseInt(zza2))).intValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return zzeo.zza(null).intValue();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @WorkerThread
    public final double zzc(String str, @NonNull zzeo<Double> zzeo) {
        if (str != null) {
            String zza2 = this.zzb.zza(str, zzeo.zza());
            if (!TextUtils.isEmpty(zza2)) {
                try {
                    return zzeo.zza(Double.valueOf(Double.parseDouble(zza2))).doubleValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return zzeo.zza(null).doubleValue();
    }

    @WorkerThread
    public final int zzc(@Size(min = 1) String str) {
        return zzb(str, zzaq.zzn);
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: package-private */
    public final int zzd(@Size(min = 1) String str) {
        if (!zzmd.zzb() || !zzd((String) null, zzaq.zzcj)) {
            return 25;
        }
        return zza(str, zzaq.zzaf, 25, 100);
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.android.gms.measurement.internal.zzeo, com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(java.lang.String r4, @androidx.annotation.NonNull com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r5) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x000e
        L_0x0003:
            java.lang.Object r4 = r5.zza(r0)
        L_0x0007:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            return r4
        L_0x000e:
            com.google.android.gms.measurement.internal.zzaa r1 = r3.zzb
            java.lang.String r2 = r5.zza()
            java.lang.String r4 = r1.zza(r4, r2)
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 == 0) goto L_0x001f
            goto L_0x0003
        L_0x001f:
            boolean r4 = java.lang.Boolean.parseBoolean(r4)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            java.lang.Object r4 = r5.zza(r4)
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zzd(java.lang.String, com.google.android.gms.measurement.internal.zzeo):boolean");
    }

    public final int zze() {
        return (!zzmd.zzb() || !zzt().zzd((String) null, zzaq.zzck) || zzp().zzj() < 201500) ? 25 : 100;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    @VisibleForTesting
    public final Boolean zze(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzz = zzz();
        if (zzz == null) {
            zzr().zzf().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!zzz.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(zzz.getBoolean(str));
        }
    }

    public final boolean zze(String str, zzeo<Boolean> zzeo) {
        return zzd(str, zzeo);
    }

    public final long zzf() {
        zzu();
        return 31000;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b A[SYNTHETIC, Splitter:B:9:0x002b] */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> zzf(@androidx.annotation.Size(min = 1) java.lang.String r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzz()
            r1 = 0
            if (r0 != 0) goto L_0x0019
            com.google.android.gms.measurement.internal.zzez r4 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfb r4 = r4.zzf()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L_0x0017:
            r4 = r1
            goto L_0x0028
        L_0x0019:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x0020
            goto L_0x0017
        L_0x0020:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x0028:
            if (r4 != 0) goto L_0x002b
            return r1
        L_0x002b:
            android.content.Context r0 = r3.zzn()     // Catch:{ NotFoundException -> 0x0043 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0043 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0043 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0043 }
            if (r4 != 0) goto L_0x003e
            return r1
        L_0x003e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0043 }
            return r4
        L_0x0043:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzez r0 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zza(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zzf(java.lang.String):java.util.List");
    }

    public final boolean zzg() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = zzn().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzc = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        zzr().zzf().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }

    public final boolean zzg(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzh() {
        zzu();
        Boolean zze = zze("firebase_analytics_collection_deactivated");
        return zze != null && zze.booleanValue();
    }

    public final boolean zzh(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    public final Boolean zzi() {
        zzb();
        Boolean zze = zze("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(zze == null || zze.booleanValue());
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzi(String str) {
        return zzd(str, zzaq.zzaj);
    }

    public final Boolean zzj() {
        zzb();
        boolean z = true;
        if (!zzor.zzb() || !zza(zzaq.zzcb)) {
            return true;
        }
        Boolean zze = zze("google_analytics_automatic_screen_reporting_enabled");
        if (zze != null && !zze.booleanValue()) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzj(String str) {
        zzeo<String> zzeo = zzaq.zzak;
        return zzeo.zza(str == null ? null : this.zzb.zza(str, zzeo.zza()));
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

    public final String zzw() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzx() {
        return zza("debug.deferred.deeplink", "");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzy() {
        if (this.zza == null) {
            Boolean zze = zze("app_measurement_lite");
            this.zza = zze;
            if (zze == null) {
                this.zza = false;
            }
        }
        return this.zza.booleanValue() || !this.zzy.zzt();
    }
}
