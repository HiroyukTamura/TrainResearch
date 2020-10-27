package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
import p009e.p010a.p011a.p012a.C0681a;

final class zzeao extends zzeak<Boolean> implements zzecl<Boolean>, zzeea, RandomAccess {
    private static final zzeao zzhsz;
    private int size;
    private boolean[] zzhta;

    static {
        zzeao zzeao = new zzeao(new boolean[0], 0);
        zzhsz = zzeao;
        zzeao.zzbcj();
    }

    zzeao() {
        this(new boolean[10], 0);
    }

    private zzeao(boolean[] zArr, int i) {
        this.zzhta = zArr;
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbck();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfm(i));
        }
        boolean[] zArr = this.zzhta;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[C0681a.m302a(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zzhta, i, zArr2, i + 1, this.size - i);
            this.zzhta = zArr2;
        }
        this.zzhta[i] = booleanValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        addBoolean(((Boolean) obj).booleanValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzbck();
        zzecg.checkNotNull(collection);
        if (!(collection instanceof zzeao)) {
            return super.addAll(collection);
        }
        zzeao zzeao = (zzeao) collection;
        int i = zzeao.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zzhta;
            if (i3 > zArr.length) {
                this.zzhta = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zzeao.zzhta, 0, this.zzhta, this.size, zzeao.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addBoolean(boolean z) {
        zzbck();
        int i = this.size;
        boolean[] zArr = this.zzhta;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[C0681a.m302a(i, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.zzhta = zArr2;
        }
        boolean[] zArr3 = this.zzhta;
        int i2 = this.size;
        this.size = i2 + 1;
        zArr3[i2] = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeao)) {
            return super.equals(obj);
        }
        zzeao zzeao = (zzeao) obj;
        if (this.size != zzeao.size) {
            return false;
        }
        boolean[] zArr = zzeao.zzhta;
        for (int i = 0; i < this.size; i++) {
            if (this.zzhta[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzfl(i);
        return Boolean.valueOf(this.zzhta[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzecg.zzbu(this.zzhta[i2]);
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbck();
        zzfl(i);
        boolean[] zArr = this.zzhta;
        boolean z = zArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final boolean remove(Object obj) {
        zzbck();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzhta[i]))) {
                boolean[] zArr = this.zzhta;
                System.arraycopy(zArr, i + 1, zArr, i, (this.size - i) - 1);
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
            boolean[] zArr = this.zzhta;
            System.arraycopy(zArr, i2, zArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbck();
        zzfl(i);
        boolean[] zArr = this.zzhta;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzecl zzfn(int i) {
        if (i >= this.size) {
            return new zzeao(Arrays.copyOf(this.zzhta, i), this.size);
        }
        throw new IllegalArgumentException();
    }
}
