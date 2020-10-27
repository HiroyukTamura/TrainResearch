package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class zzegj implements zzbi, Closeable, Iterator<zzbf> {
    private static zzegr zzcr = zzegr.zzn(zzegj.class);
    private static final zzbf zziil = new zzegm("eof ");
    long zzarx = 0;
    long zzbdj = 0;
    protected zzegl zziij;
    protected zzbe zziim;
    private zzbf zziin = null;
    long zziio = 0;
    private List<zzbf> zziip = new ArrayList();

    /* access modifiers changed from: private */
    /* renamed from: zzbiq */
    public final zzbf next() {
        zzbf zza;
        zzbf zzbf = this.zziin;
        if (zzbf == null || zzbf == zziil) {
            zzegl zzegl = this.zziij;
            if (zzegl == null || this.zziio >= this.zzarx) {
                this.zziin = zziil;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzegl) {
                    this.zziij.zzfc(this.zziio);
                    zza = this.zziim.zza(this.zziij, this);
                    this.zziio = this.zziij.position();
                }
                return zza;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.zziin = null;
            return zzbf;
        }
    }

    public void close() throws IOException {
        this.zziij.close();
    }

    public boolean hasNext() {
        zzbf zzbf = this.zziin;
        if (zzbf == zziil) {
            return false;
        }
        if (zzbf != null) {
            return true;
        }
        try {
            this.zziin = (zzbf) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zziin = zziil;
            return false;
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zziip.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.zziip.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void zza(zzegl zzegl, long j, zzbe zzbe) throws IOException {
        this.zziij = zzegl;
        long position = zzegl.position();
        this.zzbdj = position;
        this.zziio = position;
        zzegl.zzfc(zzegl.position() + j);
        this.zzarx = zzegl.position();
        this.zziim = zzbe;
    }

    public final List<zzbf> zzbip() {
        return (this.zziij == null || this.zziin == zziil) ? this.zziip : new zzegp(this.zziip, this);
    }
}
