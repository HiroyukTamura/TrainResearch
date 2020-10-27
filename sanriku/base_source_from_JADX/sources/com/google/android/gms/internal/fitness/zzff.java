package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.UByte;
import p009e.p010a.p011a.p012a.C0681a;

public abstract class zzff implements Serializable, Iterable<Byte> {
    public static final zzff zzri = new zzfp(zzgk.zzvz);
    private static final zzfl zzrj = (zzfd.zzan() ? new zzfo((zzfe) null) : new zzfj((zzfe) null));
    private static final Comparator<zzff> zzrl = new zzfh();
    private int zzrk = 0;

    zzff() {
    }

    /* access modifiers changed from: private */
    public static int zza(byte b) {
        return b & UByte.MAX_VALUE;
    }

    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(C0681a.m310a(32, "Beginning index: ", i, " < 0"));
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException(C0681a.m311a(66, "Beginning index larger than ending index: ", i, ", ", i2));
        } else {
            throw new IndexOutOfBoundsException(C0681a.m311a(37, "End index: ", i2, " >= ", i3));
        }
    }

    static zzfn zzj(int i) {
        return new zzfn(i, (zzfe) null);
    }

    public static zzff zzl(String str) {
        return new zzfp(str.getBytes(zzgk.UTF_8));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzrk;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzrk = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzfe(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    /* access modifiers changed from: protected */
    public abstract int zza(int i, int i2, int i3);

    public abstract zzff zza(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzfc zzfc) throws IOException;

    public final String zzap() {
        return size() == 0 ? "" : zza(zzgk.UTF_8);
    }

    public abstract boolean zzaq();

    /* access modifiers changed from: protected */
    public final int zzar() {
        return this.zzrk;
    }

    public abstract byte zzh(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzi(int i);
}
