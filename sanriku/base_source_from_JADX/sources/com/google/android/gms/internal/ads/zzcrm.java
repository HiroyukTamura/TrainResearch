package com.google.android.gms.internal.ads;

final class zzcrm implements zzbwg {
    private final /* synthetic */ zzdgo zzggq;
    private final /* synthetic */ zzdha zzghe;
    private final /* synthetic */ zzcnl zzghf;
    final /* synthetic */ zzcrk zzghg;

    zzcrm(zzcrk zzcrk, zzdha zzdha, zzdgo zzdgo, zzcnl zzcnl) {
        this.zzghg = zzcrk;
        this.zzghe = zzdha;
        this.zzggq = zzdgo;
        this.zzghf = zzcnl;
    }

    public final void onInitializationSucceeded() {
        this.zzghg.zzfhi.execute(new zzcrp(this, this.zzghe, this.zzggq, this.zzghf));
    }

    public final void zzdq(int i) {
        String valueOf = String.valueOf(this.zzghf.zzflf);
        zzazw.zzfc(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "));
    }
}
