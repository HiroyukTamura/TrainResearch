package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

final class zzeat extends zzeav {
    private final int limit = this.zzhti.size();
    private int position = 0;
    private final /* synthetic */ zzeaq zzhti;

    zzeat(zzeaq zzeaq) {
        this.zzhti = zzeaq;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzhti.zzfp(i);
        }
        throw new NoSuchElementException();
    }
}
