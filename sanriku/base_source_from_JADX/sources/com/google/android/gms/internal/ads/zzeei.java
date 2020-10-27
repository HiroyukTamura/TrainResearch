package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzeei implements Iterator<zzebb> {
    private final ArrayDeque<zzeed> zzibp;
    private zzebb zzibq;

    private zzeei(zzeaq zzeaq) {
        zzebb zzebb;
        if (zzeaq instanceof zzeed) {
            zzeed zzeed = (zzeed) zzeaq;
            ArrayDeque<zzeed> arrayDeque = new ArrayDeque<>(zzeed.zzbcs());
            this.zzibp = arrayDeque;
            arrayDeque.push(zzeed);
            zzebb = zzal(zzeed.zzibc);
        } else {
            this.zzibp = null;
            zzebb = (zzebb) zzeaq;
        }
        this.zzibq = zzebb;
    }

    /* synthetic */ zzeei(zzeaq zzeaq, zzeeg zzeeg) {
        this(zzeaq);
    }

    private final zzebb zzal(zzeaq zzeaq) {
        while (zzeaq instanceof zzeed) {
            zzeed zzeed = (zzeed) zzeaq;
            this.zzibp.push(zzeed);
            zzeaq = zzeed.zzibc;
        }
        return (zzebb) zzeaq;
    }

    public final boolean hasNext() {
        return this.zzibq != null;
    }

    public final /* synthetic */ Object next() {
        zzebb zzebb;
        zzebb zzebb2 = this.zzibq;
        if (zzebb2 != null) {
            while (true) {
                ArrayDeque<zzeed> arrayDeque = this.zzibp;
                if (arrayDeque != null && !arrayDeque.isEmpty()) {
                    zzebb = zzal(this.zzibp.pop().zzibd);
                    if (!zzebb.isEmpty()) {
                        break;
                    }
                } else {
                    zzebb = null;
                }
            }
            zzebb = null;
            this.zzibq = zzebb;
            return zzebb2;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
