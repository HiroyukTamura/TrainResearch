package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class zzkx implements Iterator<String> {
    private Iterator<String> zza = this.zzb.zza.iterator();
    private final /* synthetic */ zzkv zzb;

    zzkx(zzkv zzkv) {
        this.zzb = zzkv;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
