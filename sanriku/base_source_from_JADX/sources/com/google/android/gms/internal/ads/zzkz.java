package com.google.android.gms.internal.ads;

final class zzkz {
    public final int[] zzanx;
    public final long[] zzany;
    public final int zzawf;
    public final int zzawl;
    public final int[] zzawn;
    public final long[] zzayl;

    public zzkz(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z = true;
        zzoh.checkArgument(iArr.length == jArr2.length);
        zzoh.checkArgument(jArr.length == jArr2.length);
        zzoh.checkArgument(iArr2.length != jArr2.length ? false : z);
        this.zzany = jArr;
        this.zzanx = iArr;
        this.zzawl = i;
        this.zzayl = jArr2;
        this.zzawn = iArr2;
        this.zzawf = jArr.length;
    }

    public final int zzec(long j) {
        for (int zza = zzov.zza(this.zzayl, j, true, false); zza >= 0; zza--) {
            if ((this.zzawn[zza] & 1) != 0) {
                return zza;
            }
        }
        return -1;
    }

    public final int zzed(long j) {
        for (int zzb = zzov.zzb(this.zzayl, j, true, false); zzb < this.zzayl.length; zzb++) {
            if ((this.zzawn[zzb] & 1) != 0) {
                return zzb;
            }
        }
        return -1;
    }
}
