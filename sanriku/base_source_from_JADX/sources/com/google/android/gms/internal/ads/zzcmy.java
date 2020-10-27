package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zztf;
import java.util.ArrayList;

public final class zzcmy {
    private static final SparseArray<zztf.zzo.zzc> zzgdw;
    private final zzbqc zzfls;
    private final zzcmv zzgbg;
    private final TelephonyManager zzgdt;
    /* access modifiers changed from: private */
    public final zzcmp zzgdu;
    private zztp zzgdv;
    private final Context zzvf;

    static {
        SparseArray<zztf.zzo.zzc> sparseArray = new SparseArray<>();
        zzgdw = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zztf.zzo.zzc.CONNECTED);
        zzgdw.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zztf.zzo.zzc.CONNECTING);
        zzgdw.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zztf.zzo.zzc.CONNECTING);
        zzgdw.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zztf.zzo.zzc.CONNECTING);
        zzgdw.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zztf.zzo.zzc.DISCONNECTING);
        zzgdw.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zztf.zzo.zzc.DISCONNECTED);
        zzgdw.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zztf.zzo.zzc.DISCONNECTED);
        zzgdw.put(NetworkInfo.DetailedState.FAILED.ordinal(), zztf.zzo.zzc.DISCONNECTED);
        zzgdw.put(NetworkInfo.DetailedState.IDLE.ordinal(), zztf.zzo.zzc.DISCONNECTED);
        zzgdw.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zztf.zzo.zzc.DISCONNECTED);
        zzgdw.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zztf.zzo.zzc.SUSPENDED);
        zzgdw.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zztf.zzo.zzc.CONNECTING);
        zzgdw.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zztf.zzo.zzc.CONNECTING);
    }

    zzcmy(Context context, zzbqc zzbqc, zzcmv zzcmv, zzcmp zzcmp) {
        this.zzvf = context;
        this.zzfls = zzbqc;
        this.zzgbg = zzcmv;
        this.zzgdu = zzcmp;
        this.zzgdt = (TelephonyManager) context.getSystemService("phone");
    }

    /* access modifiers changed from: private */
    public final byte[] zza(boolean z, ArrayList<zztf.zzc.zza> arrayList, zztf.zzm zzm, zztf.zzo.zzc zzc) {
        boolean z2 = true;
        zztf.zzo.zza.C2672zza zzeu = zztf.zzo.zza.zzol().zzf((Iterable<? extends zztf.zzc.zza>) arrayList).zzh(zzbk(zzq.zzky().zzb(this.zzvf.getContentResolver()) != 0)).zzi(zzq.zzky().zza(this.zzvf, this.zzgdt)).zzev(this.zzgbg.zzaoy()).zzew(this.zzgbg.zzapa()).zzci(this.zzgbg.getResponseCode()).zzb(zzc).zzb(zzm).zzj(this.zzgdv).zzf(zzbk(z)).zzeu(zzq.zzld().currentTimeMillis());
        if (zzq.zzky().zza(this.zzvf.getContentResolver()) == 0) {
            z2 = false;
        }
        return ((zztf.zzo.zza) ((zzecd) zzeu.zzg(zzbk(z2)).zzbet())).toByteArray();
    }

    private static zztp zzbk(boolean z) {
        return z ? zztp.ENUM_TRUE : zztp.ENUM_FALSE;
    }

    /* access modifiers changed from: private */
    public final zztf.zzm zzk(Bundle bundle) {
        zztf.zzm.zza zza;
        zztf.zzm.zzb zzof = zztf.zzm.zzof();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.zzgdv = zztp.ENUM_TRUE;
        } else {
            this.zzgdv = zztp.ENUM_FALSE;
            zzof.zzb(i != 0 ? i != 1 ? zztf.zzm.zzc.NETWORKTYPE_UNSPECIFIED : zztf.zzm.zzc.WIFI : zztf.zzm.zzc.CELL);
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zza = zztf.zzm.zza.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zza = zztf.zzm.zza.THREE_G;
                    break;
                case 13:
                    zza = zztf.zzm.zza.LTE;
                    break;
                default:
                    zza = zztf.zzm.zza.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzof.zzb(zza);
        }
        return (zztf.zzm) ((zzecd) zzof.zzbet());
    }

    /* access modifiers changed from: private */
    public static zztf.zzo.zzc zzl(Bundle bundle) {
        return zzgdw.get(zzdhj.zza(zzdhj.zza(bundle, "device"), "network").getInt("active_network_state", -1), zztf.zzo.zzc.UNSPECIFIED);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.google.android.gms.internal.ads.zztf.zzc.zza> zzm(android.os.Bundle r7) {
        /*
            java.lang.String r0 = "ad_types"
            java.lang.Object r7 = r7.get(r0)
            boolean r0 = r7 instanceof java.util.List
            if (r0 == 0) goto L_0x000d
            java.util.List r7 = (java.util.List) r7
            goto L_0x0017
        L_0x000d:
            boolean r0 = r7 instanceof java.lang.String[]
            if (r0 == 0) goto L_0x003d
            java.lang.String[] r7 = (java.lang.String[]) r7
            java.util.List r7 = java.util.Arrays.asList(r7)
        L_0x0017:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r7.size()
            r0.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L_0x0024:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0038
            java.lang.Object r1 = r7.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0024
            java.lang.String r1 = (java.lang.String) r1
            r0.add(r1)
            goto L_0x0024
        L_0x0038:
            java.util.List r7 = java.util.Collections.unmodifiableList(r0)
            goto L_0x0041
        L_0x003d:
            java.util.List r7 = java.util.Collections.emptyList()
        L_0x0041:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x004a:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x00a3
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = -1
            int r3 = r1.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case -1396342996: goto L_0x0080;
                case -1052618729: goto L_0x0076;
                case -239580146: goto L_0x006c;
                case 604727084: goto L_0x0062;
                default: goto L_0x0061;
            }
        L_0x0061:
            goto L_0x0089
        L_0x0062:
            java.lang.String r3 = "interstitial"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 1
            goto L_0x0089
        L_0x006c:
            java.lang.String r3 = "rewarded"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 3
            goto L_0x0089
        L_0x0076:
            java.lang.String r3 = "native"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 2
            goto L_0x0089
        L_0x0080:
            java.lang.String r3 = "banner"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 0
        L_0x0089:
            if (r2 == 0) goto L_0x009d
            if (r2 == r6) goto L_0x009a
            if (r2 == r5) goto L_0x0097
            if (r2 == r4) goto L_0x0094
            com.google.android.gms.internal.ads.zztf$zzc$zza r1 = com.google.android.gms.internal.ads.zztf.zzc.zza.AD_FORMAT_TYPE_UNSPECIFIED
            goto L_0x009f
        L_0x0094:
            com.google.android.gms.internal.ads.zztf$zzc$zza r1 = com.google.android.gms.internal.ads.zztf.zzc.zza.REWARD_BASED_VIDEO_AD
            goto L_0x009f
        L_0x0097:
            com.google.android.gms.internal.ads.zztf$zzc$zza r1 = com.google.android.gms.internal.ads.zztf.zzc.zza.NATIVE_APP_INSTALL
            goto L_0x009f
        L_0x009a:
            com.google.android.gms.internal.ads.zztf$zzc$zza r1 = com.google.android.gms.internal.ads.zztf.zzc.zza.INTERSTITIAL
            goto L_0x009f
        L_0x009d:
            com.google.android.gms.internal.ads.zztf$zzc$zza r1 = com.google.android.gms.internal.ads.zztf.zzc.zza.BANNER
        L_0x009f:
            r0.add(r1)
            goto L_0x004a
        L_0x00a3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmy.zzm(android.os.Bundle):java.util.ArrayList");
    }

    public final void zzbl(boolean z) {
        zzdqw.zza(this.zzfls.zzaik(), new zzcnb(this, z), zzbab.zzdzw);
    }
}
