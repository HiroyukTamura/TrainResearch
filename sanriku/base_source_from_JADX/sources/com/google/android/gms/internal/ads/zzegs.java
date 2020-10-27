package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

final class zzegs implements Iterator<E> {
    private int pos = 0;
    private final /* synthetic */ zzegp zziis;

    zzegs(zzegp zzegp) {
        this.zziis = zzegp;
    }

    public final boolean hasNext() {
        return this.pos < this.zziis.zziiq.size() || this.zziis.zziir.hasNext();
    }

    public final E next() {
        while (this.pos >= this.zziis.zziiq.size()) {
            zzegp zzegp = this.zziis;
            zzegp.zziiq.add(zzegp.zziir.next());
        }
        List<E> list = this.zziis.zziiq;
        int i = this.pos;
        this.pos = i + 1;
        return list.get(i);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
