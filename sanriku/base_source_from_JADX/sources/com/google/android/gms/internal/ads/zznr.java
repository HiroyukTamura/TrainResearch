package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

public final class zznr implements zznu {
    private final byte[] data;
    private Uri uri;
    private int zzbfk;
    private int zzbfl;

    public zznr(byte[] bArr) {
        zzoh.checkNotNull(bArr);
        zzoh.checkArgument(bArr.length > 0);
        this.data = bArr;
    }

    public final void close() throws IOException {
        this.uri = null;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzbfl;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.data, this.zzbfk, bArr, i, min);
        this.zzbfk += min;
        this.zzbfl -= min;
        return min;
    }

    public final long zza(zznv zznv) throws IOException {
        this.uri = zznv.uri;
        long j = zznv.position;
        this.zzbfk = (int) j;
        long j2 = zznv.zzce;
        if (j2 == -1) {
            j2 = ((long) this.data.length) - j;
        }
        int i = (int) j2;
        this.zzbfl = i;
        if (i > 0 && this.zzbfk + i <= this.data.length) {
            return (long) i;
        }
        int i2 = this.zzbfk;
        long j3 = zznv.zzce;
        int length = this.data.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i2);
        sb.append(", ");
        sb.append(j3);
        sb.append("], length: ");
        sb.append(length);
        throw new IOException(sb.toString());
    }
}
