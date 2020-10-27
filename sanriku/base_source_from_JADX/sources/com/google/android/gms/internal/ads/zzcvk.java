package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

public final class zzcvk implements zzdah<Bundle> {
    private final zzdhe zzfll;

    public zzcvk(zzdhe zzdhe) {
        Preconditions.checkNotNull(zzdhe, "the targeting must not be null");
        this.zzfll = zzdhe;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzs(java.lang.Object r14) {
        /*
            r13 = this;
            android.os.Bundle r14 = (android.os.Bundle) r14
            com.google.android.gms.internal.ads.zzdhe r0 = r13.zzfll
            com.google.android.gms.internal.ads.zzuj r1 = r0.zzguw
            java.lang.String r0 = r0.zzgux
            java.lang.String r2 = "slotname"
            r14.putString(r2, r0)
            int[] r0 = com.google.android.gms.internal.ads.zzcvj.zzfwx
            com.google.android.gms.internal.ads.zzdhe r2 = r13.zzfll
            com.google.android.gms.internal.ads.zzdgr r2 = r2.zzgvd
            int r2 = r2.zzguh
            r3 = 1
            int r2 = r2 - r3
            r0 = r0[r2]
            r2 = 2
            if (r0 == r3) goto L_0x0022
            if (r0 == r2) goto L_0x001f
            goto L_0x0027
        L_0x001f:
            java.lang.String r0 = "is_rewarded_interstitial"
            goto L_0x0024
        L_0x0022:
            java.lang.String r0 = "is_new_rewarded"
        L_0x0024:
            r14.putBoolean(r0, r3)
        L_0x0027:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r4 = java.util.Locale.US
            java.lang.String r5 = "yyyyMMdd"
            r0.<init>(r5, r4)
            java.util.Date r4 = new java.util.Date
            long r5 = r1.zzceg
            r4.<init>(r5)
            java.lang.String r0 = r0.format(r4)
            long r4 = r1.zzceg
            r6 = -1
            r8 = 0
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 == 0) goto L_0x0046
            r4 = 1
            goto L_0x0047
        L_0x0046:
            r4 = 0
        L_0x0047:
            java.lang.String r5 = "cust_age"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r5, (java.lang.String) r0, (boolean) r4)
            android.os.Bundle r0 = r1.extras
            java.lang.String r4 = "extras"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r4, (android.os.Bundle) r0)
            int r0 = r1.zzceh
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r4 = r1.zzceh
            r5 = -1
            if (r4 == r5) goto L_0x0060
            r4 = 1
            goto L_0x0061
        L_0x0060:
            r4 = 0
        L_0x0061:
            java.lang.String r6 = "cust_gender"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r6, (java.lang.Integer) r0, (boolean) r4)
            java.util.List<java.lang.String> r0 = r1.zzcei
            java.lang.String r4 = "kw"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r4, (java.util.List<java.lang.String>) r0)
            int r0 = r1.zzacq
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r4 = r1.zzacq
            if (r4 == r5) goto L_0x0079
            r4 = 1
            goto L_0x007a
        L_0x0079:
            r4 = 0
        L_0x007a:
            java.lang.String r6 = "tag_for_child_directed_treatment"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r6, (java.lang.Integer) r0, (boolean) r4)
            boolean r0 = r1.zzcej
            if (r0 == 0) goto L_0x0088
            java.lang.String r4 = "test_request"
            r14.putBoolean(r4, r0)
        L_0x0088:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            int r4 = r1.versionCode
            if (r4 < r2) goto L_0x0096
            boolean r4 = r1.zzbli
            if (r4 == 0) goto L_0x0096
            r4 = 1
            goto L_0x0097
        L_0x0096:
            r4 = 0
        L_0x0097:
            java.lang.String r6 = "d_imp_hdr"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r6, (java.lang.Integer) r0, (boolean) r4)
            java.lang.String r0 = r1.zzcek
            int r4 = r1.versionCode
            if (r4 < r2) goto L_0x00aa
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x00aa
            r2 = 1
            goto L_0x00ab
        L_0x00aa:
            r2 = 0
        L_0x00ab:
            java.lang.String r4 = "ppid"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r4, (java.lang.String) r0, (boolean) r2)
            android.location.Location r0 = r1.zzmp
            if (r0 == 0) goto L_0x0115
            float r2 = r0.getAccuracy()
            r4 = 1148846080(0x447a0000, float:1000.0)
            float r2 = r2 * r4
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            long r6 = r0.getTime()
            r9 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r9
            java.lang.Long r4 = java.lang.Long.valueOf(r6)
            double r6 = r0.getLatitude()
            r9 = 4711630319722168320(0x416312d000000000, double:1.0E7)
            double r6 = r6 * r9
            long r6 = (long) r6
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            double r11 = r0.getLongitude()
            double r11 = r11 * r9
            long r9 = (long) r11
            java.lang.Long r0 = java.lang.Long.valueOf(r9)
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            float r2 = r2.floatValue()
            java.lang.String r9 = "radius"
            r7.putFloat(r9, r2)
            long r9 = r6.longValue()
            java.lang.String r2 = "lat"
            r7.putLong(r2, r9)
            long r9 = r0.longValue()
            java.lang.String r0 = "long"
            r7.putLong(r0, r9)
            long r9 = r4.longValue()
            java.lang.String r0 = "time"
            r7.putLong(r0, r9)
            java.lang.String r0 = "uule"
            r14.putBundle(r0, r7)
        L_0x0115:
            java.lang.String r0 = r1.zzcem
            java.lang.String r2 = "url"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r2, (java.lang.String) r0)
            java.util.List<java.lang.String> r0 = r1.zzcet
            java.lang.String r2 = "neighboring_content_urls"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r2, (java.util.List<java.lang.String>) r0)
            android.os.Bundle r0 = r1.zzceo
            java.lang.String r2 = "custom_targeting"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r2, (android.os.Bundle) r0)
            java.util.List<java.lang.String> r0 = r1.zzcep
            java.lang.String r2 = "category_exclusions"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r2, (java.util.List<java.lang.String>) r0)
            java.lang.String r0 = r1.zzceq
            java.lang.String r2 = "request_agent"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r2, (java.lang.String) r0)
            java.lang.String r0 = r1.zzcer
            java.lang.String r2 = "request_pkg"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r2, (java.lang.String) r0)
            boolean r0 = r1.zzces
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            int r2 = r1.versionCode
            r4 = 7
            if (r2 < r4) goto L_0x014c
            r2 = 1
            goto L_0x014d
        L_0x014c:
            r2 = 0
        L_0x014d:
            java.lang.String r4 = "is_designed_for_families"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r4, (java.lang.Boolean) r0, (boolean) r2)
            int r0 = r1.versionCode
            r2 = 8
            if (r0 < r2) goto L_0x0170
            int r0 = r1.zzacr
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r2 = r1.zzacr
            if (r2 == r5) goto L_0x0163
            goto L_0x0164
        L_0x0163:
            r3 = 0
        L_0x0164:
            java.lang.String r2 = "tag_for_under_age_of_consent"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r2, (java.lang.Integer) r0, (boolean) r3)
            java.lang.String r0 = r1.zzacs
            java.lang.String r1 = "max_ad_content_rating"
            com.google.android.gms.internal.ads.zzdhj.zza((android.os.Bundle) r14, (java.lang.String) r1, (java.lang.String) r0)
        L_0x0170:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcvk.zzs(java.lang.Object):void");
    }
}
