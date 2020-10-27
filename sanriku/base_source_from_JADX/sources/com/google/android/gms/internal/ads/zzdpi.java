package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdpi<K> extends zzdpb<K> {
    private final transient zzdou<K> zzhfg;
    private final transient zzdoy<K, ?> zzhfs;

    zzdpi(zzdoy<K, ?> zzdoy, zzdou<K> zzdou) {
        this.zzhfs = zzdoy;
        this.zzhfg = zzdou;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zzhfs.get(obj) != null;
    }

    public final int size() {
        return this.zzhfs.size();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzavw().zza(objArr, i);
    }

    /* renamed from: zzavs */
    public final zzdpp<K> iterator() {
        return (zzdpp) zzavw().iterator();
    }

    public final zzdou<K> zzavw() {
        return this.zzhfg;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzavx() {
        return true;
    }
}
