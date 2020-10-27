package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import kotlin.UByte;
import p009e.p010a.p011a.p012a.C0681a;

public abstract class zzgt implements Serializable, Iterable<Byte> {
    public static final zzgt zza = new zzhd(zzie.zzb);
    private static final zzgz zzb = (zzgm.zza() ? new zzhc((zzgs) null) : new zzgx((zzgs) null));
    private static final Comparator<zzgt> zzd = new zzgv();
    private int zzc = 0;

    zzgt() {
    }

    public static zzgt zza(String str) {
        return new zzhd(str.getBytes(zzie.zza));
    }

    static zzgt zza(byte[] bArr) {
        return new zzhd(bArr);
    }

    public static zzgt zza(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzhd(zzb.zza(bArr, i, i2));
    }

    /* access modifiers changed from: private */
    public static int zzb(byte b) {
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

    static zzhb zzc(int i) {
        return new zzhb(i, (zzgs) null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zza2 = zza();
            i = zza(zza2, 0, zza2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzgs(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zza());
        objArr[2] = zza() <= 50 ? zzkq.zza(this) : String.valueOf(zzkq.zza(zza(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i);

    public abstract int zza();

    /* access modifiers changed from: protected */
    public abstract int zza(int i, int i2, int i3);

    public abstract zzgt zza(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzgq zzgq) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract byte zzb(int i);

    public final String zzb() {
        return zza() == 0 ? "" : zza(zzie.zza);
    }

    public abstract boolean zzc();

    /* access modifiers changed from: protected */
    public final int zzd() {
        return this.zzc;
    }
}
