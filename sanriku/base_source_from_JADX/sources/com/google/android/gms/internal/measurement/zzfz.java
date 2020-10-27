package com.google.android.gms.internal.measurement;

import java.util.Iterator;

public abstract class zzfz<E> implements Iterator<E> {
    protected zzfz() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
