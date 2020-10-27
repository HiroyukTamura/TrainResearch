package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

final class zztf extends zztl {
    private final /* synthetic */ zztc zzbef;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zztf(zztc zztc) {
        super(zztc, (zztd) null);
        this.zzbef = zztc;
    }

    /* synthetic */ zztf(zztc zztc, zztd zztd) {
        this(zztc);
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzte(this.zzbef, (zztd) null);
    }
}
