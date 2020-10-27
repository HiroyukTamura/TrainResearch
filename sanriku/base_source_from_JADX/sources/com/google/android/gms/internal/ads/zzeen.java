package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzeen implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzicb;
    private final /* synthetic */ zzeel zzicc;

    private zzeen(zzeel zzeel) {
        this.zzicc = zzeel;
        this.pos = this.zzicc.zzibs.size();
    }

    /* synthetic */ zzeen(zzeel zzeel, zzeeo zzeeo) {
        this(zzeel);
    }

    private final Iterator<Map.Entry<K, V>> zzbha() {
        if (this.zzicb == null) {
            this.zzicb = this.zzicc.zzibv.entrySet().iterator();
        }
        return this.zzicb;
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzicc.zzibs.size()) || zzbha().hasNext();
    }

    public final /* synthetic */ Object next() {
        Object obj;
        if (zzbha().hasNext()) {
            obj = zzbha().next();
        } else {
            List zzb = this.zzicc.zzibs;
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
