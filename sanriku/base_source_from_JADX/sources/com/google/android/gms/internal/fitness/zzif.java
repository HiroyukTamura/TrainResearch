package com.google.android.gms.internal.fitness;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzif implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzyu;
    private final /* synthetic */ zzid zzyv;

    private zzif(zzid zzid) {
        this.zzyv = zzid;
        this.pos = this.zzyv.zzyl.size();
    }

    /* synthetic */ zzif(zzid zzid, zzig zzig) {
        this(zzid);
    }

    private final Iterator<Map.Entry<K, V>> zzda() {
        if (this.zzyu == null) {
            this.zzyu = this.zzyv.zzyo.entrySet().iterator();
        }
        return this.zzyu;
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzyv.zzyl.size()) || zzda().hasNext();
    }

    public final /* synthetic */ Object next() {
        Object obj;
        if (zzda().hasNext()) {
            obj = zzda().next();
        } else {
            List zzb = this.zzyv.zzyl;
            int i = this.pos - 1;
            this.pos = i;
            obj = zzb.get(i);
        }
        return (Map.Entry) obj;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
