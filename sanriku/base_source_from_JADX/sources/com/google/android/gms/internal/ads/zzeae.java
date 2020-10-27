package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzeae extends WeakReference<Throwable> {
    private final int zzhsp;

    public zzeae(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zzhsp = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzeae.class) {
            if (this == obj) {
                return true;
            }
            zzeae zzeae = (zzeae) obj;
            return this.zzhsp == zzeae.zzhsp && get() == zzeae.get();
        }
    }

    public final int hashCode() {
        return this.zzhsp;
    }
}
