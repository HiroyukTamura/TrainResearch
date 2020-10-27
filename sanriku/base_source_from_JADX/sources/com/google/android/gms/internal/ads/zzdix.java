package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzdix implements zzdiy {
    private final Object[] zzgxw;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0175  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzdix(com.google.android.gms.internal.ads.zzuj r3, java.lang.String r4, int r5, java.lang.String r6, com.google.android.gms.internal.ads.zzut r7) {
        /*
            r2 = this;
            r2.<init>()
            java.util.HashSet r0 = new java.util.HashSet
            java.lang.String r1 = ","
            java.lang.String[] r1 = r6.split(r1)
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.add(r6)
            r1.add(r4)
            java.lang.String r4 = "networkType"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x002c
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            r1.add(r4)
        L_0x002c:
            java.lang.String r4 = "birthday"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x003d
            long r4 = r3.zzceg
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.add(r4)
        L_0x003d:
            java.lang.String r4 = "extras"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x004f
            android.os.Bundle r4 = r3.extras
            java.lang.String r4 = zzr(r4)
        L_0x004b:
            r1.add(r4)
            goto L_0x005e
        L_0x004f:
            java.lang.String r4 = "npa"
            boolean r5 = r0.contains(r4)
            if (r5 == 0) goto L_0x005e
            android.os.Bundle r5 = r3.extras
            java.lang.String r4 = r5.getString(r4)
            goto L_0x004b
        L_0x005e:
            java.lang.String r4 = "gender"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x006f
            int r4 = r3.zzceh
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.add(r4)
        L_0x006f:
            java.lang.String r4 = "keywords"
            boolean r4 = r0.contains(r4)
            r5 = 0
            if (r4 == 0) goto L_0x0087
            java.util.List<java.lang.String> r4 = r3.zzcei
            if (r4 == 0) goto L_0x0084
            java.lang.String r4 = r4.toString()
            r1.add(r4)
            goto L_0x0087
        L_0x0084:
            r1.add(r5)
        L_0x0087:
            java.lang.String r4 = "isTestDevice"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0098
            boolean r4 = r3.zzcej
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r1.add(r4)
        L_0x0098:
            java.lang.String r4 = "tagForChildDirectedTreatment"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x00a9
            int r4 = r3.zzacq
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.add(r4)
        L_0x00a9:
            java.lang.String r4 = "manualImpressionsEnabled"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x00ba
            boolean r4 = r3.zzbli
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r1.add(r4)
        L_0x00ba:
            java.lang.String r4 = "publisherProvidedId"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x00c7
            java.lang.String r4 = r3.zzcek
            r1.add(r4)
        L_0x00c7:
            java.lang.String r4 = "location"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x00de
            android.location.Location r4 = r3.zzmp
            if (r4 == 0) goto L_0x00db
            java.lang.String r4 = r4.toString()
            r1.add(r4)
            goto L_0x00de
        L_0x00db:
            r1.add(r5)
        L_0x00de:
            java.lang.String r4 = "contentUrl"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x00eb
            java.lang.String r4 = r3.zzcem
            r1.add(r4)
        L_0x00eb:
            java.lang.String r4 = "networkExtras"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x00fc
            android.os.Bundle r4 = r3.zzcen
            java.lang.String r4 = zzr(r4)
            r1.add(r4)
        L_0x00fc:
            java.lang.String r4 = "customTargeting"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x010d
            android.os.Bundle r4 = r3.zzceo
            java.lang.String r4 = zzr(r4)
            r1.add(r4)
        L_0x010d:
            java.lang.String r4 = "categoryExclusions"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0124
            java.util.List<java.lang.String> r4 = r3.zzcep
            if (r4 == 0) goto L_0x0121
            java.lang.String r4 = r4.toString()
            r1.add(r4)
            goto L_0x0124
        L_0x0121:
            r1.add(r5)
        L_0x0124:
            java.lang.String r4 = "requestAgent"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0131
            java.lang.String r4 = r3.zzceq
            r1.add(r4)
        L_0x0131:
            java.lang.String r4 = "requestPackage"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x013e
            java.lang.String r4 = r3.zzcer
            r1.add(r4)
        L_0x013e:
            java.lang.String r4 = "isDesignedForFamilies"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x014f
            boolean r4 = r3.zzces
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r1.add(r4)
        L_0x014f:
            java.lang.String r4 = "tagForUnderAgeOfConsent"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0160
            int r4 = r3.zzacr
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.add(r4)
        L_0x0160:
            java.lang.String r4 = "maxAdContentRating"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x016d
            java.lang.String r3 = r3.zzacs
            r1.add(r3)
        L_0x016d:
            java.lang.String r3 = "orientation"
            boolean r3 = r0.contains(r3)
            if (r3 == 0) goto L_0x0184
            if (r7 == 0) goto L_0x0181
            int r3 = r7.orientation
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.add(r3)
            goto L_0x0184
        L_0x0181:
            r1.add(r5)
        L_0x0184:
            java.lang.Object[] r3 = r1.toArray()
            r2.zzgxw = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdix.<init>(com.google.android.gms.internal.ads.zzuj, java.lang.String, int, java.lang.String, com.google.android.gms.internal.ads.zzut):void");
    }

    private static String zzr(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            sb.append(obj == null ? "null" : obj instanceof Bundle ? zzr((Bundle) obj) : obj.toString());
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdix)) {
            return false;
        }
        return Arrays.equals(this.zzgxw, ((zzdix) obj).zzgxw);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzgxw);
    }

    public final String toString() {
        int hashCode = hashCode();
        String arrays = Arrays.toString(this.zzgxw);
        StringBuilder sb = new StringBuilder(C0681a.m336b(arrays, 22));
        sb.append("[PoolKey#");
        sb.append(hashCode);
        sb.append(" ");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
