package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdpk<E> extends zzdpb<E> {
    static final zzdpk<Object> zzhfy = new zzdpk(new Object[0], 0, (Object[]) null, 0, 0);
    private final transient int mask;
    private final transient int size;
    private final transient int zzahb;
    private final transient Object[] zzhfz;
    private final transient Object[] zzhga;

    zzdpk(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzhfz = objArr;
        this.zzhga = objArr2;
        this.mask = i2;
        this.zzahb = i;
        this.size = i3;
    }

    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.zzhga;
        if (obj == null || objArr == null) {
            return false;
        }
        int zzef = zzdoq.zzef(obj.hashCode());
        while (true) {
            int i = zzef & this.mask;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zzef = i + 1;
        }
    }

    public final int hashCode() {
        return this.zzahb;
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzhfz, 0, objArr, i, this.size);
        return i + this.size;
    }

    /* renamed from: zzavs */
    public final zzdpp<E> iterator() {
        return (zzdpp) zzavw().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzavt() {
        return this.zzhfz;
    }

    /* access modifiers changed from: package-private */
    public final int zzavu() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzavv() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzavx() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzawd() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final zzdou<E> zzawe() {
        return zzdou.zzb(this.zzhfz, this.size);
    }
}
