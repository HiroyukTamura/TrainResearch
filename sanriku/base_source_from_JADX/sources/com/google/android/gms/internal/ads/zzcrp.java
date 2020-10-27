package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcrp implements Runnable {
    private final zzdgo zzfjm;
    private final zzdha zzfvc;
    private final zzcrm zzghl;
    private final zzcnl zzghm;

    zzcrp(zzcrm zzcrm, zzdha zzdha, zzdgo zzdgo, zzcnl zzcnl) {
        this.zzghl = zzcrm;
        this.zzfvc = zzdha;
        this.zzfjm = zzdgo;
        this.zzghm = zzcnl;
    }

    public final void run() {
        zzcrm zzcrm = this.zzghl;
        zzcrk.zzc(this.zzfvc, this.zzfjm, this.zzghm);
    }
}
