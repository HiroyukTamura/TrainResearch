package com.google.android.gms.internal.ads;

import java.util.ListIterator;

final class zzefg implements ListIterator<String> {
    private final /* synthetic */ int zzhhc;
    private final /* synthetic */ zzefd zzicn;
    private ListIterator<String> zzico = this.zzicn.zzicl.listIterator(this.zzhhc);

    zzefg(zzefd zzefd, int i) {
        this.zzicn = zzefd;
        this.zzhhc = i;
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.zzico.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzico.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return this.zzico.next();
    }

    public final int nextIndex() {
        return this.zzico.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return this.zzico.previous();
    }

    public final int previousIndex() {
        return this.zzico.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}
