package com.google.android.gms.internal.ads;

final class zzkm {
    public int index;
    public final int length;
    public int zzavx;
    public long zzavy;
    private final boolean zzavz;
    private final zzos zzawa;
    private final zzos zzawb;
    private int zzawc;
    private int zzawd;

    public zzkm(zzos zzos, zzos zzos2, boolean z) {
        this.zzawb = zzos;
        this.zzawa = zzos2;
        this.zzavz = z;
        zzos2.zzbi(12);
        this.length = zzos2.zzje();
        zzos.zzbi(12);
        this.zzawd = zzos.zzje();
        zzoh.checkState(zzos.readInt() != 1 ? false : true, "first_chunk must be 1");
        this.index = -1;
    }

    public final boolean zzgz() {
        int i = this.index + 1;
        this.index = i;
        if (i == this.length) {
            return false;
        }
        this.zzavy = this.zzavz ? this.zzawa.zzjf() : this.zzawa.zzjb();
        if (this.index == this.zzawc) {
            this.zzavx = this.zzawb.zzje();
            this.zzawb.zzbj(4);
            int i2 = this.zzawd - 1;
            this.zzawd = i2;
            this.zzawc = i2 > 0 ? this.zzawb.zzje() - 1 : -1;
        }
        return true;
    }
}
