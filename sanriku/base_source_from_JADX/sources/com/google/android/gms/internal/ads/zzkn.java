package com.google.android.gms.internal.ads;

final class zzkn implements zzkl {
    private final zzos zzavw;
    private final int zzawe = this.zzavw.zzje();
    private final int zzawf = this.zzavw.zzje();

    public zzkn(zzkk zzkk) {
        zzos zzos = zzkk.zzavw;
        this.zzavw = zzos;
        zzos.zzbi(12);
    }

    public final int zzgw() {
        return this.zzawf;
    }

    public final int zzgx() {
        int i = this.zzawe;
        return i == 0 ? this.zzavw.zzje() : i;
    }

    public final boolean zzgy() {
        return this.zzawe != 0;
    }
}
