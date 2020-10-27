package com.google.android.gms.internal.ads;

public final class zzbfz {
    public final int heightPixels;
    private final int type;
    public final int widthPixels;

    private zzbfz(int i, int i2, int i3) {
        this.type = i;
        this.widthPixels = i2;
        this.heightPixels = i3;
    }

    public static zzbfz zzacl() {
        return new zzbfz(0, 0, 0);
    }

    public static zzbfz zzacm() {
        return new zzbfz(4, 0, 0);
    }

    public static zzbfz zzacn() {
        return new zzbfz(5, 0, 0);
    }

    public static zzbfz zzb(zzum zzum) {
        return zzum.zzcew ? new zzbfz(3, 0, 0) : zzum.zzcey ? new zzbfz(2, 0, 0) : zzum.zzbnf ? zzacl() : zzq(zzum.widthPixels, zzum.heightPixels);
    }

    public static zzbfz zzq(int i, int i2) {
        return new zzbfz(1, i, i2);
    }

    public final boolean isFluid() {
        return this.type == 2;
    }

    public final boolean zzaco() {
        return this.type == 3;
    }

    public final boolean zzacp() {
        return this.type == 0;
    }

    public final boolean zzacq() {
        return this.type == 4;
    }

    public final boolean zzacr() {
        return this.type == 5;
    }
}
