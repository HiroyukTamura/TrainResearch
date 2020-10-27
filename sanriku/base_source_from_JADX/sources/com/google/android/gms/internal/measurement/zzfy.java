package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

public abstract class zzfy<E> extends zzfz<E> implements ListIterator<E> {
    protected zzfy() {
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
