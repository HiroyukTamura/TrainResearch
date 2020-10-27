package com.google.android.gms.internal.ads;

import java.util.Iterator;

public abstract class zzdov<E> {
    zzdov() {
    }

    public zzdov<E> zza(Iterator<? extends E> it) {
        while (it.hasNext()) {
            zzac(it.next());
        }
        return this;
    }

    public abstract zzdov<E> zzac(E e);

    public zzdov<E> zzg(Iterable<? extends E> iterable) {
        for (Object zzac : iterable) {
            zzac(zzac);
        }
        return this;
    }
}
