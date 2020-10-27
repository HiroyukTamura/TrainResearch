package com.google.android.gms.internal.ads;

import java.util.Iterator;

final class zzeff implements Iterator<String> {
    private Iterator<String> zzicm = this.zzicn.zzicl.iterator();
    private final /* synthetic */ zzefd zzicn;

    zzeff(zzefd zzefd) {
        this.zzicn = zzefd;
    }

    public final boolean hasNext() {
        return this.zzicm.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.zzicm.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
