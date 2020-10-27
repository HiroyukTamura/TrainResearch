package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class zzjj implements zzjl {
    private static final byte[] zzanr = new byte[4096];
    private long position;
    private final zznu zzans;
    private final long zzant;
    private byte[] zzanu = new byte[65536];
    private int zzanv;
    private int zzanw;

    public zzjj(zznu zznu, long j, long j2) {
        this.zzans = zznu;
        this.position = j;
        this.zzant = j2;
    }

    private final int zza(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int read = this.zzans.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                return i3 + read;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    private final int zzag(int i) {
        int min = Math.min(this.zzanw, i);
        zzah(min);
        return min;
    }

    private final void zzah(int i) {
        int i2 = this.zzanw - i;
        this.zzanw = i2;
        this.zzanv = 0;
        byte[] bArr = this.zzanu;
        if (i2 < bArr.length - 524288) {
            bArr = new byte[(i2 + 65536)];
        }
        System.arraycopy(this.zzanu, i, bArr, 0, this.zzanw);
        this.zzanu = bArr;
    }

    private final void zzai(int i) {
        if (i != -1) {
            this.position += (long) i;
        }
    }

    private final int zzb(byte[] bArr, int i, int i2) {
        int i3 = this.zzanw;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.zzanu, 0, bArr, i, min);
        zzah(min);
        return min;
    }

    private final boolean zzd(int i, boolean z) throws IOException, InterruptedException {
        int i2 = this.zzanv + i;
        byte[] bArr = this.zzanu;
        if (i2 > bArr.length) {
            this.zzanu = Arrays.copyOf(this.zzanu, zzov.zzd(bArr.length << 1, 65536 + i2, i2 + 524288));
        }
        int min = Math.min(this.zzanw - this.zzanv, i);
        while (min < i) {
            min = zza(this.zzanu, this.zzanv, i, min, false);
            if (min == -1) {
                return false;
            }
        }
        int i3 = this.zzanv + i;
        this.zzanv = i3;
        this.zzanw = Math.max(this.zzanw, i3);
        return true;
    }

    public final long getLength() {
        return this.zzant;
    }

    public final long getPosition() {
        return this.position;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int zzb = zzb(bArr, i, i2);
        if (zzb == 0) {
            zzb = zza(bArr, i, i2, 0, true);
        }
        zzai(zzb);
        return zzb;
    }

    public final void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        zza(bArr, i, i2, false);
    }

    public final void zza(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        if (zzd(i2, false)) {
            System.arraycopy(this.zzanu, this.zzanv - i2, bArr, i, i2);
        }
    }

    public final boolean zza(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int zzb = zzb(bArr, i, i2);
        while (zzb < i2 && zzb != -1) {
            zzb = zza(bArr, i, i2, zzb, z);
        }
        zzai(zzb);
        return zzb != -1;
    }

    public final int zzad(int i) throws IOException, InterruptedException {
        int zzag = zzag(i);
        if (zzag == 0) {
            byte[] bArr = zzanr;
            zzag = zza(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        zzai(zzag);
        return zzag;
    }

    public final void zzae(int i) throws IOException, InterruptedException {
        int zzag = zzag(i);
        while (zzag < i && zzag != -1) {
            byte[] bArr = zzanr;
            zzag = zza(bArr, -zzag, Math.min(i, bArr.length + zzag), zzag, false);
        }
        zzai(zzag);
    }

    public final void zzaf(int i) throws IOException, InterruptedException {
        zzd(i, false);
    }

    public final void zzgp() {
        this.zzanv = 0;
    }
}
