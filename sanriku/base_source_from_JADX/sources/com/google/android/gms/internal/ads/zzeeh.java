package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

final class zzeeh extends InputStream {
    private int mark;
    private final /* synthetic */ zzeed zzibj;
    private zzeei zzibk;
    private zzebb zzibl;
    private int zzibm;
    private int zzibn;
    private int zzibo;

    public zzeeh(zzeed zzeed) {
        this.zzibj = zzeed;
        initialize();
    }

    private final void initialize() {
        zzeei zzeei = new zzeei(this.zzibj, (zzeeg) null);
        this.zzibk = zzeei;
        zzebb zzebb = (zzebb) zzeei.next();
        this.zzibl = zzebb;
        this.zzibm = zzebb.size();
        this.zzibn = 0;
        this.zzibo = 0;
    }

    private final void zzbgp() {
        int i;
        if (this.zzibl != null && this.zzibn == (i = this.zzibm)) {
            this.zzibo += i;
            this.zzibn = 0;
            if (this.zzibk.hasNext()) {
                zzebb zzebb = (zzebb) this.zzibk.next();
                this.zzibl = zzebb;
                this.zzibm = zzebb.size();
                return;
            }
            this.zzibl = null;
            this.zzibm = 0;
        }
    }

    private final int zzl(byte[] bArr, int i, int i2) {
        int i3 = i2;
        while (i3 > 0) {
            zzbgp();
            if (this.zzibl == null) {
                break;
            }
            int min = Math.min(this.zzibm - this.zzibn, i3);
            if (bArr != null) {
                this.zzibl.zza(bArr, this.zzibn, i, min);
                i += min;
            }
            this.zzibn += min;
            i3 -= min;
        }
        return i2 - i3;
    }

    public final int available() throws IOException {
        return this.zzibj.size() - (this.zzibo + this.zzibn);
    }

    public final void mark(int i) {
        this.mark = this.zzibo + this.zzibn;
    }

    public final boolean markSupported() {
        return true;
    }

    public final int read() throws IOException {
        zzbgp();
        zzebb zzebb = this.zzibl;
        if (zzebb == null) {
            return -1;
        }
        int i = this.zzibn;
        this.zzibn = i + 1;
        return zzebb.zzfo(i) & UByte.MAX_VALUE;
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw null;
        } else if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else {
            int zzl = zzl(bArr, i, i2);
            if (zzl == 0) {
                return -1;
            }
            return zzl;
        }
    }

    public final synchronized void reset() {
        initialize();
        zzl((byte[]) null, 0, this.mark);
    }

    public final long skip(long j) {
        if (j >= 0) {
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return (long) zzl((byte[]) null, 0, (int) j);
        }
        throw new IndexOutOfBoundsException();
    }
}
