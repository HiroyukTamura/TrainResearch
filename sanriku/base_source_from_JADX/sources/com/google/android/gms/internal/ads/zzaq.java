package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@VisibleForTesting
final class zzaq extends FilterInputStream {
    private final long zzce;
    private long zzcf;

    zzaq(InputStream inputStream, long j) {
        super(inputStream);
        this.zzce = j;
    }

    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.zzcf++;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.zzcf += (long) read;
        }
        return read;
    }

    /* access modifiers changed from: package-private */
    public final long zzp() {
        return this.zzce - this.zzcf;
    }
}
