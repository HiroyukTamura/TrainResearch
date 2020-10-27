package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzge extends WeakReference<Throwable> {
    private final int zza;

    public zzge(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zza = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzge.class) {
            if (this == obj) {
                return true;
            }
            zzge zzge = (zzge) obj;
            return this.zza == zzge.zza && get() == zzge.get();
        }
    }

    public final int hashCode() {
        return this.zza;
    }
}
