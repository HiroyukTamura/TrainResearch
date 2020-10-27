package com.google.android.gms.measurement.internal;

import java.util.Iterator;

final class zzam implements Iterator<String> {
    private Iterator<String> zza = this.zzb.zza.keySet().iterator();
    private final /* synthetic */ zzan zzb;

    zzam(zzan zzan) {
        this.zzb = zzan;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
