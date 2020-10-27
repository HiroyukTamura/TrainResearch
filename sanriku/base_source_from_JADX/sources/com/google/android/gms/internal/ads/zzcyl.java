package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public final class zzcyl implements zzdak<zzcym> {
    private final PackageInfo zzdly;
    private final zzawt zzduw;
    private final zzdhe zzfll;
    private final zzdrh zzfur;

    public zzcyl(zzdrh zzdrh, zzdhe zzdhe, @Nullable PackageInfo packageInfo, zzawt zzawt) {
        this.zzfur = zzdrh;
        this.zzfll = zzdhe;
        this.zzdly = packageInfo;
        this.zzduw = zzawt;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f5, code lost:
        if (r9 == 3) goto L_0x011a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(java.util.ArrayList r9, android.os.Bundle r10) {
        /*
            r8 = this;
            r0 = 3
            java.lang.String r1 = "native_version"
            r10.putInt(r1, r0)
            java.lang.String r1 = "native_templates"
            r10.putStringArrayList(r1, r9)
            com.google.android.gms.internal.ads.zzdhe r9 = r8.zzfll
            java.util.ArrayList<java.lang.String> r9 = r9.zzguz
            java.lang.String r1 = "native_custom_templates"
            r10.putStringArrayList(r1, r9)
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r9 = com.google.android.gms.internal.ads.zzzz.zzcov
            com.google.android.gms.internal.ads.zzzv r1 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r9 = r1.zzd(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            java.lang.String r1 = "landscape"
            java.lang.String r2 = "portrait"
            java.lang.String r3 = "any"
            java.lang.String r4 = "unknown"
            r5 = 2
            r6 = 1
            if (r9 == 0) goto L_0x0061
            com.google.android.gms.internal.ads.zzdhe r9 = r8.zzfll
            com.google.android.gms.internal.ads.zzaci r9 = r9.zzdhc
            int r9 = r9.versionCode
            if (r9 <= r0) goto L_0x0061
            java.lang.String r9 = "enable_native_media_orientation"
            r10.putBoolean(r9, r6)
            com.google.android.gms.internal.ads.zzdhe r9 = r8.zzfll
            com.google.android.gms.internal.ads.zzaci r9 = r9.zzdhc
            int r9 = r9.zzbky
            if (r9 == r6) goto L_0x0055
            if (r9 == r5) goto L_0x0053
            if (r9 == r0) goto L_0x0051
            r7 = 4
            if (r9 == r7) goto L_0x004e
            r9 = r4
            goto L_0x0056
        L_0x004e:
            java.lang.String r9 = "square"
            goto L_0x0056
        L_0x0051:
            r9 = r2
            goto L_0x0056
        L_0x0053:
            r9 = r1
            goto L_0x0056
        L_0x0055:
            r9 = r3
        L_0x0056:
            boolean r7 = r4.equals(r9)
            if (r7 != 0) goto L_0x0061
            java.lang.String r7 = "native_media_orientation"
            r10.putString(r7, r9)
        L_0x0061:
            com.google.android.gms.internal.ads.zzdhe r9 = r8.zzfll
            com.google.android.gms.internal.ads.zzaci r9 = r9.zzdhc
            int r9 = r9.zzbkx
            if (r9 == 0) goto L_0x0071
            if (r9 == r6) goto L_0x006f
            if (r9 == r5) goto L_0x0072
            r1 = r4
            goto L_0x0072
        L_0x006f:
            r1 = r2
            goto L_0x0072
        L_0x0071:
            r1 = r3
        L_0x0072:
            boolean r9 = r4.equals(r1)
            if (r9 != 0) goto L_0x007d
            java.lang.String r9 = "native_image_orientation"
            r10.putString(r9, r1)
        L_0x007d:
            com.google.android.gms.internal.ads.zzdhe r9 = r8.zzfll
            com.google.android.gms.internal.ads.zzaci r9 = r9.zzdhc
            boolean r9 = r9.zzbkz
            java.lang.String r1 = "native_multiple_images"
            r10.putBoolean(r1, r9)
            com.google.android.gms.internal.ads.zzdhe r9 = r8.zzfll
            com.google.android.gms.internal.ads.zzaci r9 = r9.zzdhc
            boolean r9 = r9.zzblc
            java.lang.String r1 = "use_custom_mute"
            r10.putBoolean(r1, r9)
            android.content.pm.PackageInfo r9 = r8.zzdly
            if (r9 != 0) goto L_0x0099
            r9 = 0
            goto L_0x009b
        L_0x0099:
            int r9 = r9.versionCode
        L_0x009b:
            com.google.android.gms.internal.ads.zzawt r1 = r8.zzduw
            int r1 = r1.zzwv()
            if (r9 <= r1) goto L_0x00ad
            com.google.android.gms.internal.ads.zzawt r1 = r8.zzduw
            r1.zzxb()
            com.google.android.gms.internal.ads.zzawt r1 = r8.zzduw
            r1.zzcy(r9)
        L_0x00ad:
            com.google.android.gms.internal.ads.zzawt r9 = r8.zzduw
            org.json.JSONObject r9 = r9.zzxa()
            if (r9 == 0) goto L_0x00c4
            com.google.android.gms.internal.ads.zzdhe r1 = r8.zzfll
            java.lang.String r1 = r1.zzgux
            org.json.JSONArray r9 = r9.optJSONArray(r1)
            if (r9 == 0) goto L_0x00c4
            java.lang.String r9 = r9.toString()
            goto L_0x00c5
        L_0x00c4:
            r9 = 0
        L_0x00c5:
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 != 0) goto L_0x00d0
            java.lang.String r1 = "native_advanced_settings"
            r10.putString(r1, r9)
        L_0x00d0:
            com.google.android.gms.internal.ads.zzdhe r9 = r8.zzfll
            int r9 = r9.zzgkg
            if (r9 <= r6) goto L_0x00db
            java.lang.String r1 = "max_num_ads"
            r10.putInt(r1, r9)
        L_0x00db:
            com.google.android.gms.internal.ads.zzdhe r9 = r8.zzfll
            com.google.android.gms.internal.ads.zzahm r9 = r9.zzdno
            if (r9 == 0) goto L_0x012c
            java.lang.String r1 = r9.zzdbn
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0120
            int r1 = r9.versionCode
            java.lang.String r2 = "p"
            java.lang.String r3 = "l"
            if (r1 < r5) goto L_0x00f8
            int r9 = r9.zzbky
            if (r9 == r5) goto L_0x0119
            if (r9 == r0) goto L_0x011a
            goto L_0x0119
        L_0x00f8:
            int r9 = r9.zzdbm
            if (r9 == r6) goto L_0x0119
            if (r9 == r5) goto L_0x011a
            r0 = 52
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Instream ad video aspect ratio "
            r1.append(r0)
            r1.append(r9)
            java.lang.String r9 = " is wrong."
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.google.android.gms.internal.ads.zzazw.zzfa(r9)
        L_0x0119:
            r2 = r3
        L_0x011a:
            java.lang.String r9 = "ia_var"
            r10.putString(r9, r2)
            goto L_0x0127
        L_0x0120:
            java.lang.String r9 = r9.zzdbn
            java.lang.String r0 = "ad_tag"
            r10.putString(r0, r9)
        L_0x0127:
            java.lang.String r9 = "instr"
            r10.putBoolean(r9, r6)
        L_0x012c:
            com.google.android.gms.internal.ads.zzdhe r9 = r8.zzfll
            com.google.android.gms.internal.ads.zzaem r9 = r9.zzarx()
            if (r9 == 0) goto L_0x0139
            java.lang.String r9 = "has_delayed_banner_listener"
            r10.putBoolean(r9, r6)
        L_0x0139:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcyl.zza(java.util.ArrayList, android.os.Bundle):void");
    }

    public final zzdri<zzcym> zzaqa() {
        return this.zzfur.zzd(new zzcyo(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcym zzaqi() throws Exception {
        ArrayList<String> arrayList = this.zzfll.zzguy;
        return arrayList == null ? zzcyn.zzgnh : arrayList.isEmpty() ? zzcyq.zzgnh : new zzcyp(this, arrayList);
    }
}
