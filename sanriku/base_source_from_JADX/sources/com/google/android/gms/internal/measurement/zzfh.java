package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

final class zzfh extends zzfz<T> {
    private boolean zza;
    private final /* synthetic */ Object zzb;

    zzfh(Object obj) {
        this.zzb = obj;
    }

    public final boolean hasNext() {
        return !this.zza;
    }

    public final T next() {
        if (!this.zza) {
            this.zza = true;
            return this.zzb;
        }
        throw new NoSuchElementException();
    }
}
