package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Map;

final class zzdpj extends zzdou<Map.Entry<K, V>> {
    private final /* synthetic */ zzdpg zzhfx;

    zzdpj(zzdpg zzdpg) {
        this.zzhfx = zzdpg;
    }

    public final /* synthetic */ Object get(int i) {
        zzdoj.zzs(i, this.zzhfx.size);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zzhfx.zzhft[i2], this.zzhfx.zzhft[i2 + 1]);
    }

    public final int size() {
        return this.zzhfx.size;
    }

    public final boolean zzavx() {
        return true;
    }
}
