package com.google.android.gms.internal.ads;

public final class zzbdv extends zzbdl {
    public zzbdv(zzbbx zzbbx) {
        super(zzbbx);
    }

    public final void abort() {
    }

    public final boolean zzfl(String str) {
        zzbbx zzbbx = (zzbbx) this.zzego.get();
        if (zzbbx != null) {
            zzbbx.zza(zzfm(str), (zzbdl) this);
        }
        zzazw.zzfc("VideoStreamNoopCache is doing nothing.");
        zza(str, zzfm(str), "noop", "Noop cache is a noop.");
        return false;
    }
}
