package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class zzdqs<V> extends zzdor implements Future<V> {
    protected zzdqs() {
    }

    public boolean cancel(boolean z) {
        return zzavr().cancel(z);
    }

    public V get() throws InterruptedException, ExecutionException {
        return zzavr().get();
    }

    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return zzavr().get(j, timeUnit);
    }

    public boolean isCancelled() {
        return zzavr().isCancelled();
    }

    public boolean isDone() {
        return zzavr().isDone();
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzawp */
    public abstract Future<? extends V> zzavr();
}
