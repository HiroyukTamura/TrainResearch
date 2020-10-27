package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class zzay extends ByteArrayOutputStream {
    private final zzaj zzbw;

    public zzay(zzaj zzaj, int i) {
        this.zzbw = zzaj;
        this.buf = zzaj.zzc(Math.max(i, 256));
    }

    private final void zzd(int i) {
        int i2 = this.count;
        if (i2 + i > this.buf.length) {
            byte[] zzc = this.zzbw.zzc((i2 + i) << 1);
            System.arraycopy(this.buf, 0, zzc, 0, this.count);
            this.zzbw.zza(this.buf);
            this.buf = zzc;
        }
    }

    public final void close() throws IOException {
        this.zzbw.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.zzbw.zza(this.buf);
    }

    public final synchronized void write(int i) {
        zzd(1);
        super.write(i);
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        zzd(i2);
        super.write(bArr, i, i2);
    }
}
