package com.google.android.gms.internal.ads;

import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzbdu implements zzaga<zzbbx> {
    private static Integer zzb(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(C0681a.m336b(str2, C0681a.m336b(str, 39)));
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzazw.zzfc(sb.toString());
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(java.lang.Object r10, java.util.Map r11) {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzbbx r10 = (com.google.android.gms.internal.ads.zzbbx) r10
            r0 = 3
            boolean r0 = com.google.android.gms.internal.ads.zzazw.isLoggable(r0)
            if (r0 == 0) goto L_0x0031
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r11)
            java.lang.String r1 = "google.afma.Notify_dt"
            r0.remove(r1)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            int r1 = r1 + 15
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Precache GMSG: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.internal.ads.zzazw.zzed(r0)
        L_0x0031:
            com.google.android.gms.ads.internal.zzq.zzls()
            java.lang.String r0 = "abort"
            boolean r0 = r11.containsKey(r0)
            if (r0 == 0) goto L_0x0048
            boolean r10 = com.google.android.gms.internal.ads.zzbdm.zzc(r10)
            if (r10 != 0) goto L_0x0047
            java.lang.String r10 = "Precache abort but no precache task running."
            com.google.android.gms.internal.ads.zzazw.zzfc(r10)
        L_0x0047:
            return
        L_0x0048:
            java.lang.String r0 = "src"
            java.lang.Object r0 = r11.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x00e3
            r1 = 1
            java.lang.String[] r2 = new java.lang.String[r1]
            r3 = 0
            r2[r3] = r0
            java.lang.String r4 = "demuxed"
            java.lang.Object r4 = r11.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r5 = 0
            if (r4 == 0) goto L_0x0098
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0080 }
            r2.<init>(r4)     // Catch:{ JSONException -> 0x0080 }
            int r6 = r2.length()     // Catch:{ JSONException -> 0x0080 }
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ JSONException -> 0x0080 }
            r7 = 0
        L_0x006f:
            int r8 = r2.length()     // Catch:{ JSONException -> 0x0080 }
            if (r7 >= r8) goto L_0x007e
            java.lang.String r8 = r2.getString(r7)     // Catch:{ JSONException -> 0x0080 }
            r6[r7] = r8     // Catch:{ JSONException -> 0x0080 }
            int r7 = r7 + 1
            goto L_0x006f
        L_0x007e:
            r2 = r6
            goto L_0x0098
        L_0x0080:
            java.lang.String r2 = "Malformed demuxed URL list for precache: "
            int r6 = r4.length()
            if (r6 == 0) goto L_0x008e
            java.lang.String r2 = r2.concat(r4)
            goto L_0x0094
        L_0x008e:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r2)
            r2 = r4
        L_0x0094:
            com.google.android.gms.internal.ads.zzazw.zzfc(r2)
            r2 = r5
        L_0x0098:
            if (r2 != 0) goto L_0x009e
            java.lang.String[] r2 = new java.lang.String[r1]
            r2[r3] = r0
        L_0x009e:
            com.google.android.gms.internal.ads.zzbdk r1 = com.google.android.gms.internal.ads.zzbdm.zzd(r10)
            if (r1 == 0) goto L_0x00aa
            java.lang.String r10 = "Precache task is already running."
        L_0x00a6:
            com.google.android.gms.internal.ads.zzazw.zzfc(r10)
            return
        L_0x00aa:
            com.google.android.gms.ads.internal.zza r1 = r10.zzzi()
            if (r1 != 0) goto L_0x00b3
            java.lang.String r10 = "Precache requires a dependency provider."
            goto L_0x00a6
        L_0x00b3:
            com.google.android.gms.internal.ads.zzbby r1 = new com.google.android.gms.internal.ads.zzbby
            java.lang.String r4 = "flags"
            java.lang.Object r4 = r11.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r1.<init>(r4)
            java.lang.String r4 = "player"
            java.lang.Integer r4 = zzb(r11, r4)
            if (r4 != 0) goto L_0x00cc
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
        L_0x00cc:
            int r3 = r4.intValue()
            com.google.android.gms.ads.internal.zza r4 = r10.zzzi()
            com.google.android.gms.internal.ads.zzbdt r4 = r4.zzblp
            com.google.android.gms.internal.ads.zzbdl r1 = r4.zza(r10, r3, r5, r1)
            com.google.android.gms.internal.ads.zzbdk r3 = new com.google.android.gms.internal.ads.zzbdk
            r3.<init>(r10, r1, r0, r2)
            r3.zzwn()
            goto L_0x00eb
        L_0x00e3:
            com.google.android.gms.internal.ads.zzbdk r10 = com.google.android.gms.internal.ads.zzbdm.zzd(r10)
            if (r10 == 0) goto L_0x0128
            com.google.android.gms.internal.ads.zzbdl r1 = r10.zzegn
        L_0x00eb:
            java.lang.String r10 = "minBufferMs"
            java.lang.Integer r10 = zzb(r11, r10)
            if (r10 == 0) goto L_0x00fa
            int r10 = r10.intValue()
            r1.zzde(r10)
        L_0x00fa:
            java.lang.String r10 = "maxBufferMs"
            java.lang.Integer r10 = zzb(r11, r10)
            if (r10 == 0) goto L_0x0109
            int r10 = r10.intValue()
            r1.zzdf(r10)
        L_0x0109:
            java.lang.String r10 = "bufferForPlaybackMs"
            java.lang.Integer r10 = zzb(r11, r10)
            if (r10 == 0) goto L_0x0118
            int r10 = r10.intValue()
            r1.zzdg(r10)
        L_0x0118:
            java.lang.String r10 = "bufferForPlaybackAfterRebufferMs"
            java.lang.Integer r10 = zzb(r11, r10)
            if (r10 == 0) goto L_0x0127
            int r10 = r10.intValue()
            r1.zzdh(r10)
        L_0x0127:
            return
        L_0x0128:
            java.lang.String r10 = "Precache must specify a source."
            goto L_0x00a6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdu.zza(java.lang.Object, java.util.Map):void");
    }
}
