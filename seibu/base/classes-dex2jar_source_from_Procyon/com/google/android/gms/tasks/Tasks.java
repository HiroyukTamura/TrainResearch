// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;
import com.google.android.gms.common.internal.zzbo;
import android.support.annotation.NonNull;

public final class Tasks
{
    private Tasks() {
    }
    
    public static <TResult> TResult await(@NonNull final Task<TResult> task) throws ExecutionException, InterruptedException {
        zzbo.zzcG("Must not be called on the main application thread");
        zzbo.zzb(task, "Task must not be null");
        if (task.isComplete()) {
            return (TResult)zzb((Task<Object>)task);
        }
        final zza zza = new zza(null);
        zza(task, (zzb)zza);
        zza.await();
        return (TResult)zzb((Task<Object>)task);
    }
    
    public static <TResult> TResult await(@NonNull final Task<TResult> task, final long n, @NonNull final TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        zzbo.zzcG("Must not be called on the main application thread");
        zzbo.zzb(task, "Task must not be null");
        zzbo.zzb(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return zzb(task);
        }
        final zza zza = new zza(null);
        zza(task, (zzb)zza);
        if (!zza.await(n, timeUnit)) {
            throw new TimeoutException("Timed out waiting for Task");
        }
        return zzb(task);
    }
    
    public static <TResult> Task<TResult> call(@NonNull final Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }
    
    public static <TResult> Task<TResult> call(@NonNull final Executor executor, @NonNull final Callable<TResult> callable) {
        zzbo.zzb(executor, "Executor must not be null");
        zzbo.zzb(callable, "Callback must not be null");
        final zzn<TResult> zzn = new zzn<TResult>();
        executor.execute(new zzo(zzn, callable));
        return zzn;
    }
    
    public static <TResult> Task<TResult> forException(@NonNull final Exception exception) {
        final zzn<TResult> zzn = new zzn<TResult>();
        zzn.setException(exception);
        return zzn;
    }
    
    public static <TResult> Task<TResult> forResult(final TResult result) {
        final zzn<TResult> zzn = new zzn<TResult>();
        zzn.setResult(result);
        return zzn;
    }
    
    public static Task<Void> whenAll(final Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return forResult((Void)null);
        }
        final Iterator<? extends Task<?>> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        final zzn<Void> zzn = new zzn<Void>();
        final zzc zzc = new zzc(collection.size(), zzn);
        final Iterator<? extends Task<?>> iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            zza((Task<?>)iterator2.next(), (zzb)zzc);
        }
        return zzn;
    }
    
    public static Task<Void> whenAll(final Task<?>... a) {
        if (a.length == 0) {
            return forResult((Void)null);
        }
        return whenAll(Arrays.asList(a));
    }
    
    private static void zza(final Task<?> task, final zzb zzb) {
        task.addOnSuccessListener(TaskExecutors.zzbMf, zzb);
        task.addOnFailureListener(TaskExecutors.zzbMf, zzb);
    }
    
    private static <TResult> TResult zzb(final Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }
    
    static final class zza implements zzb
    {
        private final CountDownLatch zztJ;
        
        private zza() {
            this.zztJ = new CountDownLatch(1);
        }
        
        public final void await() throws InterruptedException {
            this.zztJ.await();
        }
        
        public final boolean await(final long timeout, final TimeUnit unit) throws InterruptedException {
            return this.zztJ.await(timeout, unit);
        }
        
        @Override
        public final void onFailure(@NonNull final Exception ex) {
            this.zztJ.countDown();
        }
        
        @Override
        public final void onSuccess(final Object o) {
            this.zztJ.countDown();
        }
    }
    
    interface zzb extends OnFailureListener, OnSuccessListener<Object>
    {
    }
    
    static final class zzc implements zzb
    {
        private final Object mLock;
        private final zzn<Void> zzbMe;
        private Exception zzbMj;
        private final int zzbMl;
        private int zzbMm;
        private int zzbMn;
        
        public zzc(final int zzbMl, final zzn<Void> zzbMe) {
            this.mLock = new Object();
            this.zzbMl = zzbMl;
            this.zzbMe = zzbMe;
        }
        
        private final void zzDJ() {
            if (this.zzbMm + this.zzbMn == this.zzbMl) {
                if (this.zzbMj != null) {
                    this.zzbMe.setException(new ExecutionException(new StringBuilder(54).append(this.zzbMn).append(" out of ").append(this.zzbMl).append(" underlying tasks failed").toString(), this.zzbMj));
                    return;
                }
                this.zzbMe.setResult(null);
            }
        }
        
        @Override
        public final void onFailure(@NonNull final Exception zzbMj) {
            synchronized (this.mLock) {
                ++this.zzbMn;
                this.zzbMj = zzbMj;
                this.zzDJ();
            }
        }
        
        @Override
        public final void onSuccess(final Object o) {
            synchronized (this.mLock) {
                ++this.zzbMm;
                this.zzDJ();
            }
        }
    }
}
