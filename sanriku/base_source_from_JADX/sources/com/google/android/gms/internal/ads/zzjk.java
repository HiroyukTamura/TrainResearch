package com.google.android.gms.internal.ads;

public final class zzjk implements zzjr {
    private final int length;
    private final long zzaht;
    private final int[] zzanx;
    private final long[] zzany;
    private final long[] zzanz;
    private final long[] zzaoa;

    public zzjk(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzanx = iArr;
        this.zzany = jArr;
        this.zzanz = jArr2;
        this.zzaoa = jArr3;
        int length2 = iArr.length;
        this.length = length2;
        if (length2 > 0) {
            this.zzaht = jArr2[length2 - 1] + jArr3[length2 - 1];
        } else {
            this.zzaht = 0;
        }
    }

    public final long getDurationUs() {
        return this.zzaht;
    }

    public final boolean isSeekable() {
        return true;
    }

    public final long zzdz(long j) {
        return this.zzany[zzov.zza(this.zzaoa, j, true, true)];
    }
}
