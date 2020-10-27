package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzeet implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzicb;
    private final /* synthetic */ zzeel zzicc;
    private boolean zzicf;

    private zzeet(zzeel zzeel) {
        this.zzicc = zzeel;
        this.pos = -1;
    }

    /* synthetic */ zzeet(zzeel zzeel, zzeeo zzeeo) {
        this(zzeel);
    }

    private final Iterator<Map.Entry<K, V>> zzbha() {
        if (this.zzicb == null) {
            this.zzicb = this.zzicc.zzibt.entrySet().iterator();
        }
        return this.zzicb;
    }

    public final boolean hasNext() {
        return this.pos + 1 < this.zzicc.zzibs.size() || (!this.zzicc.zzibt.isEmpty() && zzbha().hasNext());
    }

    public final /* synthetic */ Object next() {
        this.zzicf = true;
        int i = this.pos + 1;
        this.pos = i;
        return (Map.Entry) (i < this.zzicc.zzibs.size() ? this.zzicc.zzibs.get(this.pos) : zzbha().next());
    }

    public final void remove() {
        if (this.zzicf) {
            this.zzicf = false;
            this.zzicc.zzbgt();
            if (this.pos < this.zzicc.zzibs.size()) {
                zzeel zzeel = this.zzicc;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zzeel.zzhk(i);
                return;
            }
            zzbha().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
