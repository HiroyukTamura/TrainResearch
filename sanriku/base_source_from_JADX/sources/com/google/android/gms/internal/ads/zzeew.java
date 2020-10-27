package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zzeew extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzeel zzicc;

    private zzeew(zzeel zzeel) {
        this.zzicc = zzeel;
    }

    /* synthetic */ zzeew(zzeel zzeel, zzeeo zzeeo) {
        this(zzeel);
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzicc.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.zzicc.clear();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzicc.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzeet(this.zzicc, (zzeeo) null);
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzicc.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.zzicc.size();
    }
}
