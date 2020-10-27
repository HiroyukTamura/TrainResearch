package com.google.android.gms.ads.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzawe;
import com.google.android.gms.internal.ads.zzazz;

public final class zzd {
    private long zzblx = 0;
    private Context zzvf;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (r11.zzwg() != false) goto L_0x0054;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(android.content.Context r8, com.google.android.gms.internal.ads.zzazz r9, boolean r10, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzawe r11, java.lang.String r12, @androidx.annotation.Nullable java.lang.String r13, @androidx.annotation.Nullable java.lang.Runnable r14) {
        /*
            r7 = this;
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzq.zzld()
            long r0 = r0.elapsedRealtime()
            long r2 = r7.zzblx
            long r0 = r0 - r2
            r2 = 5000(0x1388, double:2.4703E-320)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0017
            java.lang.String r8 = "Not retrying to fetch app settings"
            com.google.android.gms.internal.ads.zzazw.zzfc(r8)
            return
        L_0x0017:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzq.zzld()
            long r0 = r0.elapsedRealtime()
            r7.zzblx = r0
            r0 = 0
            r1 = 1
            if (r11 != 0) goto L_0x0027
        L_0x0025:
            r0 = 1
            goto L_0x0054
        L_0x0027:
            long r2 = r11.zzwf()
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzq.zzld()
            long r4 = r4.currentTimeMillis()
            long r4 = r4 - r2
            com.google.android.gms.internal.ads.zzzk<java.lang.Long> r2 = com.google.android.gms.internal.ads.zzzz.zzcpn
            com.google.android.gms.internal.ads.zzzv r3 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r2 = r3.zzd(r2)
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x004a
            r2 = 1
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            if (r2 != 0) goto L_0x0025
            boolean r11 = r11.zzwg()
            if (r11 != 0) goto L_0x0054
            goto L_0x0025
        L_0x0054:
            if (r0 != 0) goto L_0x0057
            return
        L_0x0057:
            if (r8 != 0) goto L_0x005f
            java.lang.String r8 = "Context not provided to fetch application settings"
            com.google.android.gms.internal.ads.zzazw.zzfc(r8)
            return
        L_0x005f:
            boolean r11 = android.text.TextUtils.isEmpty(r12)
            if (r11 == 0) goto L_0x0071
            boolean r11 = android.text.TextUtils.isEmpty(r13)
            if (r11 == 0) goto L_0x0071
            java.lang.String r8 = "App settings could not be fetched. Required parameters missing"
            com.google.android.gms.internal.ads.zzazw.zzfc(r8)
            return
        L_0x0071:
            android.content.Context r11 = r8.getApplicationContext()
            if (r11 == 0) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            r11 = r8
        L_0x0079:
            r7.zzvf = r11
            com.google.android.gms.internal.ads.zzakg r11 = com.google.android.gms.ads.internal.zzq.zzlj()
            android.content.Context r0 = r7.zzvf
            com.google.android.gms.internal.ads.zzakp r9 = r11.zzb(r0, r9)
            com.google.android.gms.internal.ads.zzakl<org.json.JSONObject> r11 = com.google.android.gms.internal.ads.zzakk.zzddu
            java.lang.String r0 = "google.afma.config.fetchAppSettings"
            com.google.android.gms.internal.ads.zzakh r9 = r9.zza(r0, r11, r11)
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x00d0 }
            r11.<init>()     // Catch:{ Exception -> 0x00d0 }
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x00d0 }
            if (r0 != 0) goto L_0x009e
            java.lang.String r13 = "app_id"
            r11.put(r13, r12)     // Catch:{ Exception -> 0x00d0 }
            goto L_0x00a9
        L_0x009e:
            boolean r12 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x00d0 }
            if (r12 != 0) goto L_0x00a9
            java.lang.String r12 = "ad_unit_id"
            r11.put(r12, r13)     // Catch:{ Exception -> 0x00d0 }
        L_0x00a9:
            java.lang.String r12 = "is_init"
            r11.put(r12, r10)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r10 = "pn"
            java.lang.String r8 = r8.getPackageName()     // Catch:{ Exception -> 0x00d0 }
            r11.put(r10, r8)     // Catch:{ Exception -> 0x00d0 }
            com.google.android.gms.internal.ads.zzdri r8 = r9.zzi(r11)     // Catch:{ Exception -> 0x00d0 }
            com.google.android.gms.internal.ads.zzdqj r9 = com.google.android.gms.ads.internal.zzf.zzbly     // Catch:{ Exception -> 0x00d0 }
            com.google.android.gms.internal.ads.zzdrh r10 = com.google.android.gms.internal.ads.zzbab.zzdzw     // Catch:{ Exception -> 0x00d0 }
            com.google.android.gms.internal.ads.zzdri r9 = com.google.android.gms.internal.ads.zzdqw.zzb(r8, r9, (java.util.concurrent.Executor) r10)     // Catch:{ Exception -> 0x00d0 }
            if (r14 == 0) goto L_0x00ca
            com.google.android.gms.internal.ads.zzdrh r10 = com.google.android.gms.internal.ads.zzbab.zzdzw     // Catch:{ Exception -> 0x00d0 }
            r8.addListener(r14, r10)     // Catch:{ Exception -> 0x00d0 }
        L_0x00ca:
            java.lang.String r8 = "ConfigLoader.maybeFetchNewAppSettings"
            com.google.android.gms.internal.ads.zzbaf.zza(r9, r8)     // Catch:{ Exception -> 0x00d0 }
            return
        L_0x00d0:
            r8 = move-exception
            java.lang.String r9 = "Error requesting application settings"
            com.google.android.gms.internal.ads.zzazw.zzc(r9, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzd.zza(android.content.Context, com.google.android.gms.internal.ads.zzazz, boolean, com.google.android.gms.internal.ads.zzawe, java.lang.String, java.lang.String, java.lang.Runnable):void");
    }

    public final void zza(Context context, zzazz zzazz, String str, zzawe zzawe) {
        zza(context, zzazz, false, zzawe, zzawe != null ? zzawe.zzwi() : null, str, (Runnable) null);
    }

    public final void zza(Context context, zzazz zzazz, String str, @Nullable Runnable runnable) {
        zza(context, zzazz, true, (zzawe) null, str, (String) null, runnable);
    }
}
