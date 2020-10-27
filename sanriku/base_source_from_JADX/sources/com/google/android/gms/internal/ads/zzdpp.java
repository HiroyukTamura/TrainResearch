package com.google.android.gms.internal.ads;

import java.util.Iterator;

public abstract class zzdpp<E> implements Iterator<E> {
    protected zzdpp() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
