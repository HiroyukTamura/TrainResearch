package com.google.android.gms.internal.ads;

public final class zzcmt implements zzbrc, zzbsm {
    private static final Object zzgdh = new Object();
    private static int zzgdi;
    private final zzcmy zzgdj;

    public zzcmt(zzcmy zzcmy) {
        this.zzgdj = zzcmy;
    }

    private static void zzaov() {
        synchronized (zzgdh) {
            zzgdi++;
        }
    }

    private static boolean zzaow() {
        boolean z;
        synchronized (zzgdh) {
            z = zzgdi < ((Integer) zzvj.zzpv().zzd(zzzz.zzcta)).intValue();
        }
        return z;
    }

    public final void onAdFailedToLoad(int i) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsz)).booleanValue() && zzaow()) {
            this.zzgdj.zzbl(false);
            zzaov();
        }
    }

    public final void onAdLoaded() {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsz)).booleanValue() && zzaow()) {
            this.zzgdj.zzbl(true);
            zzaov();
        }
    }
}
