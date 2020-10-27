package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p009e.p010a.p011a.p012a.C0681a;

@KeepForSdk
public class DataBufferIterator<T> implements Iterator<T> {
    protected final DataBuffer<T> zaln;
    protected int zalo = -1;

    public DataBufferIterator(DataBuffer<T> dataBuffer) {
        this.zaln = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
    }

    public boolean hasNext() {
        return this.zalo < this.zaln.getCount() - 1;
    }

    public T next() {
        if (hasNext()) {
            DataBuffer<T> dataBuffer = this.zaln;
            int i = this.zalo + 1;
            this.zalo = i;
            return dataBuffer.get(i);
        }
        throw new NoSuchElementException(C0681a.m309a(46, "Cannot advance the iterator beyond ", this.zalo));
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
