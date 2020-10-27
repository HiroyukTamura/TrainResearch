package com.google.android.gms.internal.measurement;

import java.util.AbstractCollection;
import java.util.Iterator;

final class zzen extends AbstractCollection<V> {
    private final /* synthetic */ zzef zza;

    zzen(zzef zzef) {
        this.zza = zzef;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator<V> iterator() {
        return this.zza.zzg();
    }

    public final int size() {
        return this.zza.size();
    }
}
