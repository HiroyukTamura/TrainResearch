package com.google.android.gms.internal.fitness;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzik implements Iterator<Object> {
    zzik() {
    }

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
