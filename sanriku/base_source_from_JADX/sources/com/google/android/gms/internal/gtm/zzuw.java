package com.google.android.gms.internal.gtm;

import java.io.IOException;

public abstract class zzuw {
    protected volatile int zzbhl = -1;

    public static final <T extends zzuw> T zza(T t, byte[] bArr) throws zzuv {
        return zzb(t, bArr, 0, bArr.length);
    }

    public static final void zza(zzuw zzuw, byte[] bArr, int i, int i2) {
        try {
            zzuo zzk = zzuo.zzk(bArr, 0, i2);
            zzuw.zza(zzk);
            zzk.zzrx();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    private static final <T extends zzuw> T zzb(T t, byte[] bArr, int i, int i2) throws zzuv {
        try {
            zzun zzj = zzun.zzj(bArr, 0, i2);
            t.zza(zzj);
            zzj.zzan(0);
            return t;
        } catch (zzuv e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public String toString() {
        return zzux.zzc(this);
    }

    public abstract zzuw zza(zzun zzun) throws IOException;

    public void zza(zzuo zzuo) throws IOException {
    }

    public final int zzpe() {
        int zzy = zzy();
        this.zzbhl = zzy;
        return zzy;
    }

    /* renamed from: zzry */
    public zzuw clone() throws CloneNotSupportedException {
        return (zzuw) super.clone();
    }

    public final int zzse() {
        if (this.zzbhl < 0) {
            zzpe();
        }
        return this.zzbhl;
    }

    /* access modifiers changed from: protected */
    public int zzy() {
        return 0;
    }
}
