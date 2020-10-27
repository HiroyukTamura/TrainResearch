package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

final class zzrq<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzbca;

    public zzrq(Iterator<Map.Entry<K, Object>> it) {
        this.zzbca = it;
    }

    public final boolean hasNext() {
        return this.zzbca.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzbca.next();
        return next.getValue() instanceof zzrn ? new zzrp(next) : next;
    }

    public final void remove() {
        this.zzbca.remove();
    }
}
