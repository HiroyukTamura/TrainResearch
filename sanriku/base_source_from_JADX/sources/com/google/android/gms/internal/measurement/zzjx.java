package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.RandomAccess;
import p009e.p010a.p011a.p012a.C0681a;

final class zzjx<E> extends zzgn<E> implements RandomAccess {
    private static final zzjx<Object> zza;
    private E[] zzb;
    private int zzc;

    static {
        zzjx<Object> zzjx = new zzjx<>(new Object[0], 0);
        zza = zzjx;
        zzjx.zzb();
    }

    zzjx() {
        this(new Object[10], 0);
    }

    private zzjx(E[] eArr, int i) {
        this.zzb = eArr;
        this.zzc = i;
    }

    private final void zzb(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzc(i));
        }
    }

    private final String zzc(int i) {
        return C0681a.m311a(35, "Index:", i, ", Size:", this.zzc);
    }

    public static <E> zzjx<E> zzd() {
        return zza;
    }

    public final void add(int i, E e) {
        int i2;
        zzc();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzc(i));
        }
        E[] eArr = this.zzb;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = new Object[C0681a.m302a(i2, 3, 2, 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zzb, i, eArr2, i + 1, this.zzc - i);
            this.zzb = eArr2;
        }
        this.zzb[i] = e;
        this.zzc++;
        this.modCount++;
    }

    public final boolean add(E e) {
        zzc();
        int i = this.zzc;
        E[] eArr = this.zzb;
        if (i == eArr.length) {
            this.zzb = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }

    public final E get(int i) {
        zzb(i);
        return this.zzb[i];
    }

    public final E remove(int i) {
        zzc();
        zzb(i);
        E[] eArr = this.zzb;
        E e = eArr[i];
        int i2 = this.zzc;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return e;
    }

    public final E set(int i, E e) {
        zzc();
        zzb(i);
        E[] eArr = this.zzb;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.zzc;
    }

    public final /* synthetic */ zzik zza(int i) {
        if (i >= this.zzc) {
            return new zzjx(Arrays.copyOf(this.zzb, i), this.zzc);
        }
        throw new IllegalArgumentException();
    }
}
