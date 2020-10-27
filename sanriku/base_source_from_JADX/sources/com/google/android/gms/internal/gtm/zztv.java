package com.google.android.gms.internal.gtm;

import java.util.ListIterator;

final class zztv implements ListIterator<String> {
    private ListIterator<String> zzbep = this.zzber.zzbeo.listIterator(this.zzbeq);
    private final /* synthetic */ int zzbeq;
    private final /* synthetic */ zztu zzber;

    zztv(zztu zztu, int i) {
        this.zzber = zztu;
        this.zzbeq = i;
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.zzbep.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzbep.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return this.zzbep.next();
    }

    public final int nextIndex() {
        return this.zzbep.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return this.zzbep.previous();
    }

    public final int previousIndex() {
        return this.zzbep.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
