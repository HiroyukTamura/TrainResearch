package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.UByte;
import p009e.p010a.p011a.p012a.C0681a;

public abstract class zzps implements Serializable, Iterable<Byte> {
    public static final zzps zzavx = new zzqc(zzre.zzbbh);
    private static final zzpy zzavy = (zzpp.zzna() ? new zzqd((zzpt) null) : new zzpw((zzpt) null));
    private static final Comparator<zzps> zzavz = new zzpu();
    private int zzavn = 0;

    zzps() {
    }

    /* access modifiers changed from: private */
    public static int zza(byte b) {
        return b & UByte.MAX_VALUE;
    }

    static zzqa zzam(int i) {
        return new zzqa(i, (zzpt) null);
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

    public static zzps zzb(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzqc(zzavy.zzc(bArr, i, i2));
    }

    public static zzps zzcy(String str) {
        return new zzqc(str.getBytes(zzre.UTF_8));
    }

    static zzps zzf(byte[] bArr) {
        return new zzqc(bArr);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzavn;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzavn = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzpt(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    /* access modifiers changed from: protected */
    public abstract int zza(int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzpr zzpr) throws IOException;

    public abstract byte zzak(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzal(int i);

    public abstract zzps zzc(int i, int i2);

    public final String zznc() {
        return size() == 0 ? "" : zza(zzre.UTF_8);
    }

    public abstract boolean zznd();

    /* access modifiers changed from: protected */
    public final int zzne() {
        return this.zzavn;
    }
}
