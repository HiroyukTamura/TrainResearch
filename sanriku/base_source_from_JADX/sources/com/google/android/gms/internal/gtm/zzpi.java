package com.google.android.gms.internal.gtm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzpi extends WeakReference<Throwable> {
    private final int zzavn;

    public zzpi(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, (ReferenceQueue) null);
        if (th != null) {
            this.zzavn = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzpi.class) {
            if (this == obj) {
                return true;
            }
            zzpi zzpi = (zzpi) obj;
            return this.zzavn == zzpi.zzavn && get() == zzpi.get();
        }
    }

    public final int hashCode() {
        return this.zzavn;
    }
}
