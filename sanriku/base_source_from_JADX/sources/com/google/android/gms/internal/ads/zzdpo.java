package com.google.android.gms.internal.ads;

import java.util.ListIterator;

public abstract class zzdpo<E> extends zzdpp<E> implements ListIterator<E> {
    protected zzdpo() {
    }

    @Deprecated
    public final void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void set(E e) {
        throw new UnsupportedOperationException();
    }
}
