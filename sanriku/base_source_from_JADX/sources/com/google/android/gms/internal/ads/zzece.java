package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
import p009e.p010a.p011a.p012a.C0681a;

final class zzece extends zzeak<Integer> implements zzeck, zzeea, RandomAccess {
    private static final zzece zzhxz;
    private int size;
    private int[] zzhya;

    static {
        zzece zzece = new zzece(new int[0], 0);
        zzhxz = zzece;
        zzece.zzbcj();
    }

    zzece() {
        this(new int[10], 0);
    }

    private zzece(int[] iArr, int i) {
        this.zzhya = iArr;
        this.size = i;
    }

    public static zzece zzbfe() {
        return zzhxz;
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
        int intValue = ((Integer) obj).intValue();
        zzbck();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfm(i));
        }
        int[] iArr = this.zzhya;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[C0681a.m302a(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzhya, i, iArr2, i + 1, this.size - i);
            this.zzhya = iArr2;
        }
        this.zzhya[i] = intValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzgw(((Integer) obj).intValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzbck();
        zzecg.checkNotNull(collection);
        if (!(collection instanceof zzece)) {
            return super.addAll(collection);
        }
        zzece zzece = (zzece) collection;
        int i = zzece.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzhya;
            if (i3 > iArr.length) {
                this.zzhya = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzece.zzhya, 0, this.zzhya, this.size, zzece.size);
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
        if (!(obj instanceof zzece)) {
            return super.equals(obj);
        }
        zzece zzece = (zzece) obj;
        if (this.size != zzece.size) {
            return false;
        }
        int[] iArr = zzece.zzhya;
        for (int i = 0; i < this.size; i++) {
            if (this.zzhya[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public final int getInt(int i) {
        zzfl(i);
        return this.zzhya[i];
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzhya[i2];
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbck();
        zzfl(i);
        int[] iArr = this.zzhya;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final boolean remove(Object obj) {
        zzbck();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzhya[i]))) {
                int[] iArr = this.zzhya;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
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
            int[] iArr = this.zzhya;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzbck();
        zzfl(i);
        int[] iArr = this.zzhya;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.size;
    }

    /* renamed from: zzgv */
    public final zzeck zzfn(int i) {
        if (i >= this.size) {
            return new zzece(Arrays.copyOf(this.zzhya, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzgw(int i) {
        zzbck();
        int i2 = this.size;
        int[] iArr = this.zzhya;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[C0681a.m302a(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zzhya = iArr2;
        }
        int[] iArr3 = this.zzhya;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i;
    }
}
