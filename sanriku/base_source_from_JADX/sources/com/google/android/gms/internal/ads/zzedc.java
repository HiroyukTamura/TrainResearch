package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
import p009e.p010a.p011a.p012a.C0681a;

final class zzedc extends zzeak<Long> implements zzecm, zzeea, RandomAccess {
    private static final zzedc zzhzt;
    private int size;
    private long[] zzhzu;

    static {
        zzedc zzedc = new zzedc(new long[0], 0);
        zzhzt = zzedc;
        zzedc.zzbcj();
    }

    zzedc() {
        this(new long[10], 0);
    }

    private zzedc(long[] jArr, int i) {
        this.zzhzu = jArr;
        this.size = i;
    }

    public static zzedc zzbfx() {
        return zzhzt;
    }

    private final void zzfl(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzfm(i));
        }
    }

    private final String zzfm(int i) {
        return C0681a.m311a(35, "Index:", i, ", Size:", this.size);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        zzbck();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfm(i));
        }
        long[] jArr = this.zzhzu;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[C0681a.m302a(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzhzu, i, jArr2, i + 1, this.size - i);
            this.zzhzu = jArr2;
        }
        this.zzhzu[i] = longValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzfs(((Long) obj).longValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzbck();
        zzecg.checkNotNull(collection);
        if (!(collection instanceof zzedc)) {
            return super.addAll(collection);
        }
        zzedc zzedc = (zzedc) collection;
        int i = zzedc.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzhzu;
            if (i3 > jArr.length) {
                this.zzhzu = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzedc.zzhzu, 0, this.zzhzu, this.size, zzedc.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzedc)) {
            return super.equals(obj);
        }
        zzedc zzedc = (zzedc) obj;
        if (this.size != zzedc.size) {
            return false;
        }
        long[] jArr = zzedc.zzhzu;
        for (int i = 0; i < this.size; i++) {
            if (this.zzhzu[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    public final long getLong(int i) {
        zzfl(i);
        return this.zzhzu[i];
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzecg.zzfr(this.zzhzu[i2]);
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbck();
        zzfl(i);
        long[] jArr = this.zzhzu;
        long j = jArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final boolean remove(Object obj) {
        zzbck();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzhzu[i]))) {
                long[] jArr = this.zzhzu;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzbck();
        if (i2 >= i) {
            long[] jArr = this.zzhzu;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzbck();
        zzfl(i);
        long[] jArr = this.zzhzu;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.size;
    }

    public final void zzfs(long j) {
        zzbck();
        int i = this.size;
        long[] jArr = this.zzhzu;
        if (i == jArr.length) {
            long[] jArr2 = new long[C0681a.m302a(i, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zzhzu = jArr2;
        }
        long[] jArr3 = this.zzhzu;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = j;
    }

    /* renamed from: zzgx */
    public final zzecm zzfn(int i) {
        if (i >= this.size) {
            return new zzedc(Arrays.copyOf(this.zzhzu, i), this.size);
        }
        throw new IllegalArgumentException();
    }
}
