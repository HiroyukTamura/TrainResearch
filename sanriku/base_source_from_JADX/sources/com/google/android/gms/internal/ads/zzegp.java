package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class zzegp<E> extends AbstractList<E> {
    private static final zzegr zzcr = zzegr.zzn(zzegp.class);
    List<E> zziiq;
    Iterator<E> zziir;

    public zzegp(List<E> list, Iterator<E> it) {
        this.zziiq = list;
        this.zziir = it;
    }

    public E get(int i) {
        if (this.zziiq.size() > i) {
            return this.zziiq.get(i);
        }
        if (this.zziir.hasNext()) {
            this.zziiq.add(this.zziir.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public Iterator<E> iterator() {
        return new zzegs(this);
    }

    public int size() {
        zzcr.zzig("potentially expensive size() call");
        zzcr.zzig("blowup running");
        while (this.zziir.hasNext()) {
            this.zziiq.add(this.zziir.next());
        }
        return this.zziiq.size();
    }
}
