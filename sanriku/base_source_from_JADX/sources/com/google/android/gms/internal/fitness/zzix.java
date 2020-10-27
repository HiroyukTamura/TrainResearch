package com.google.android.gms.internal.fitness;

import java.util.Iterator;

final class zzix implements Iterator<String> {
    private Iterator<String> zzzf = this.zzzg.zzze.iterator();
    private final /* synthetic */ zziv zzzg;

    zzix(zziv zziv) {
        this.zzzg = zziv;
    }

    public final boolean hasNext() {
        return this.zzzf.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.zzzf.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
