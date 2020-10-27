package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzecu<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzhzk;

    public zzecu(Iterator<Map.Entry<K, Object>> it) {
        this.zzhzk = it;
    }

    public final boolean hasNext() {
        return this.zzhzk.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzhzk.next();
        return next.getValue() instanceof zzecp ? new zzecr(next) : next;
    }

    public final void remove() {
        this.zzhzk.remove();
    }
}
