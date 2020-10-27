package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

final class zzgs extends zzgu {
    private int zza = 0;
    private final int zzb = this.zzc.zza();
    private final /* synthetic */ zzgt zzc;

    zzgs(zzgt zzgt) {
        this.zzc = zzgt;
    }

    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
