package com.google.android.gms.internal.ads;

public final class zzg implements zzad {
    private int zzr;
    private int zzs;
    private final int zzt;
    private final float zzu;

    public zzg() {
        this(2500, 1, 1.0f);
    }

    private zzg(int i, int i2, float f) {
        this.zzr = 2500;
        this.zzt = 1;
        this.zzu = 1.0f;
    }

    public final void zza(zzae zzae) throws zzae {
        boolean z = true;
        int i = this.zzs + 1;
        this.zzs = i;
        int i2 = this.zzr;
        this.zzr = i2 + ((int) (((float) i2) * this.zzu));
        if (i > this.zzt) {
            z = false;
        }
        if (!z) {
            throw zzae;
        }
    }

    public final int zzb() {
        return this.zzr;
    }

    public final int zzc() {
        return this.zzs;
    }
}
