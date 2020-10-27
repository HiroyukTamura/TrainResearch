package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdpz extends AbstractExecutorService implements zzdrh {
    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return zzdrw.zza(runnable, t);
    }

    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return zzdrw.zze(callable);
    }

    public /* synthetic */ Future submit(Runnable runnable, @NullableDecl Object obj) {
        return (zzdri) super.submit(runnable, obj);
    }

    /* renamed from: zzd */
    public final <T> zzdri<T> submit(Callable<T> callable) {
        return (zzdri) super.submit(callable);
    }

    /* renamed from: zzf */
    public final zzdri<?> submit(Runnable runnable) {
        return (zzdri) super.submit(runnable);
    }
}
