package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
import p009e.p010a.p011a.p012a.C0681a;

final class zzebp extends zzeak<Double> implements zzecl<Double>, zzeea, RandomAccess {
    private static final zzebp zzhul;
    private int size;
    private double[] zzhum;

    static {
        zzebp zzebp = new zzebp(new double[0], 0);
        zzhul = zzebp;
        zzebp.zzbcj();
    }

    zzebp() {
        this(new double[10], 0);
    }

    private zzebp(double[] dArr, int i) {
        this.zzhum = dArr;
        this.size = i;
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
        double doubleValue = ((Double) obj).doubleValue();
        zzbck();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfm(i));
        }
        double[] dArr = this.zzhum;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[C0681a.m302a(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zzhum, i, dArr2, i + 1, this.size - i);
            this.zzhum = dArr2;
        }
        this.zzhum[i] = doubleValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzd(((Double) obj).doubleValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzbck();
        zzecg.checkNotNull(collection);
        if (!(collection instanceof zzebp)) {
            return super.addAll(collection);
        }
        zzebp zzebp = (zzebp) collection;
        int i = zzebp.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.zzhum;
            if (i3 > dArr.length) {
                this.zzhum = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(zzebp.zzhum, 0, this.zzhum, this.size, zzebp.size);
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
        if (!(obj instanceof zzebp)) {
            return super.equals(obj);
        }
        zzebp zzebp = (zzebp) obj;
        if (this.size != zzebp.size) {
            return false;
        }
        double[] dArr = zzebp.zzhum;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzhum[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzfl(i);
        return Double.valueOf(this.zzhum[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzecg.zzfr(Double.doubleToLongBits(this.zzhum[i2]));
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbck();
        zzfl(i);
        double[] dArr = this.zzhum;
        double d = dArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final boolean remove(Object obj) {
        zzbck();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzhum[i]))) {
                double[] dArr = this.zzhum;
                System.arraycopy(dArr, i + 1, dArr, i, (this.size - i) - 1);
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
            double[] dArr = this.zzhum;
            System.arraycopy(dArr, i2, dArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzbck();
        zzfl(i);
        double[] dArr = this.zzhum;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final int size() {
        return this.size;
    }

    public final void zzd(double d) {
        zzbck();
        int i = this.size;
        double[] dArr = this.zzhum;
        if (i == dArr.length) {
            double[] dArr2 = new double[C0681a.m302a(i, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.zzhum = dArr2;
        }
        double[] dArr3 = this.zzhum;
        int i2 = this.size;
        this.size = i2 + 1;
        dArr3[i2] = d;
    }

    public final /* synthetic */ zzecl zzfn(int i) {
        if (i >= this.size) {
            return new zzebp(Arrays.copyOf(this.zzhum, i), this.size);
        }
        throw new IllegalArgumentException();
    }
}
