package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public final class zzgc<T> {
    private final Map<String, AtomicReference<T>> zzabi = new HashMap();

    public final AtomicReference<T> zzar(String str) {
        synchronized (this) {
            if (!this.zzabi.containsKey(str)) {
                this.zzabi.put(str, new AtomicReference());
            }
        }
        return this.zzabi.get(str);
    }
}
