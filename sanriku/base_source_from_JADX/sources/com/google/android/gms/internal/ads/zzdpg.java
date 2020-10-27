package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzdpg<K, V> extends zzdpb<Map.Entry<K, V>> {
    /* access modifiers changed from: private */
    public final transient int size;
    private final transient zzdoy<K, V> zzhfs;
    /* access modifiers changed from: private */
    public final transient Object[] zzhft;
    private final transient int zzhfu = 0;

    zzdpg(zzdoy<K, V> zzdoy, Object[] objArr, int i, int i2) {
        this.zzhfs = zzdoy;
        this.zzhft = objArr;
        this.size = i2;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.zzhfs.get(key));
        }
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzavw().zza(objArr, i);
    }

    /* renamed from: zzavs */
    public final zzdpp<Map.Entry<K, V>> iterator() {
        return (zzdpp) zzavw().iterator();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzavx() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final zzdou<Map.Entry<K, V>> zzawe() {
        return new zzdpj(this);
    }
}
