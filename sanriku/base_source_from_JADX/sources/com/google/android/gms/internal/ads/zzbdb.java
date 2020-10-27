package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

final class zzbdb implements zznu {
    private Uri uri;
    private final zznu zzegg;
    private final long zzegh;
    private final zznu zzegi;
    private long zzegj;

    zzbdb(zznu zznu, int i, zznu zznu2) {
        this.zzegg = zznu;
        this.zzegh = (long) i;
        this.zzegi = zznu2;
    }

    public final void close() throws IOException {
        this.zzegg.close();
        this.zzegi.close();
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzegj;
        long j2 = this.zzegh;
        if (j < j2) {
            i3 = this.zzegg.read(bArr, i, (int) Math.min((long) i2, j2 - j));
            this.zzegj += (long) i3;
        } else {
            i3 = 0;
        }
        if (this.zzegj < this.zzegh) {
            return i3;
        }
        int read = this.zzegi.read(bArr, i + i3, i2 - i3);
        int i4 = i3 + read;
        this.zzegj += (long) read;
        return i4;
    }

    public final long zza(zznv zznv) throws IOException {
        zznv zznv2;
        zznv zznv3 = zznv;
        this.uri = zznv3.uri;
        long j = zznv3.position;
        long j2 = this.zzegh;
        zznv zznv4 = null;
        if (j >= j2) {
            zznv2 = null;
        } else {
            long j3 = zznv3.zzce;
            long j4 = j2 - j;
            if (j3 != -1) {
                j4 = Math.min(j3, j4);
            }
            zznv2 = new zznv(zznv3.uri, j, j4, (String) null);
        }
        long j5 = zznv3.zzce;
        if (j5 == -1 || zznv3.position + j5 > this.zzegh) {
            long max = Math.max(this.zzegh, zznv3.position);
            long j6 = zznv3.zzce;
            zznv4 = new zznv(zznv3.uri, max, j6 != -1 ? Math.min(j6, (zznv3.position + j6) - this.zzegh) : -1, (String) null);
        }
        long j7 = 0;
        long zza = zznv2 != null ? this.zzegg.zza(zznv2) : 0;
        if (zznv4 != null) {
            j7 = this.zzegi.zza(zznv4);
        }
        this.zzegj = zznv3.position;
        if (zza == -1 || j7 == -1) {
            return -1;
        }
        return zza + j7;
    }
}
