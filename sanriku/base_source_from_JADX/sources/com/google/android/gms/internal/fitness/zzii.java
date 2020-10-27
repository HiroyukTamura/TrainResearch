package com.google.android.gms.internal.fitness;

import java.util.Iterator;
import java.util.Map;

final class zzii extends zzio {
    private final /* synthetic */ zzid zzyv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzii(zzid zzid) {
        super(zzid, (zzig) null);
        this.zzyv = zzid;
    }

    /* synthetic */ zzii(zzid zzid, zzig zzig) {
        this(zzid);
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzif(this.zzyv, (zzig) null);
    }
}
