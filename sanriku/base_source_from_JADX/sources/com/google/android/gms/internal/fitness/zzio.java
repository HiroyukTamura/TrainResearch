package com.google.android.gms.internal.fitness;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zzio extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzid zzyv;

    private zzio(zzid zzid) {
        this.zzyv = zzid;
    }

    /* synthetic */ zzio(zzid zzid, zzig zzig) {
        this(zzid);
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzyv.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.zzyv.clear();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzyv.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzil(this.zzyv, (zzig) null);
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzyv.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.zzyv.size();
    }
}
