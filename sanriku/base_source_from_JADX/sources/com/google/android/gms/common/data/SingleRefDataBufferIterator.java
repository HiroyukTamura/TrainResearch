package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.NoSuchElementException;
import p009e.p010a.p011a.p012a.C0681a;

@KeepForSdk
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
    private T zams;

    public SingleRefDataBufferIterator(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        if (hasNext()) {
            int i = this.zalo + 1;
            this.zalo = i;
            if (i == 0) {
                T t = this.zaln.get(0);
                this.zams = t;
                if (!(t instanceof DataBufferRef)) {
                    String valueOf = String.valueOf(this.zams.getClass());
                    throw new IllegalStateException(C0681a.m313a(valueOf.length() + 44, "DataBuffer reference of type ", valueOf, " is not movable"));
                }
            } else {
                ((DataBufferRef) this.zams).zag(i);
            }
            return this.zams;
        }
        throw new NoSuchElementException(C0681a.m309a(46, "Cannot advance the iterator beyond ", this.zalo));
    }
}
