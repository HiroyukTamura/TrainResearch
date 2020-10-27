package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzdhn {
    public static void zzc(Throwable th, String str) {
        int zzd = zzcjk.zzd(th);
        StringBuilder sb = new StringBuilder(31);
        sb.append("Ad failed to load : ");
        sb.append(zzd);
        zzazw.zzfb(sb.toString());
        zzawr.zza(str, th);
        if (zzcjk.zzd(th) != 3) {
            zzq.zzla().zzb(th, str);
        }
    }

    public static void zze(Context context, boolean z) {
        String str;
        if (z) {
            str = "This request is sent from a test device.";
        } else {
            zzvj.zzpr();
            String zzbk = zzazm.zzbk(context);
            str = C0681a.m313a(C0681a.m336b(zzbk, 101), "Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"", zzbk, "\") to get test ads on this device.");
        }
        zzazw.zzfb(str);
    }
}
