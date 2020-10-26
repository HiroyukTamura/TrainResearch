// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

import android.support.annotation.MainThread;
import java.util.Iterator;
import java.util.ArrayList;
import com.google.android.gms.internal.zzbdt;
import java.lang.ref.WeakReference;
import java.util.List;
import com.google.android.gms.internal.zzbds;
import android.support.annotation.Nullable;
import java.util.concurrent.Executor;
import android.support.annotation.NonNull;
import android.app.Activity;
import com.google.android.gms.common.internal.zzbo;

final class zzn<TResult> extends Task<TResult>
{
    private final Object mLock;
    private final zzl<TResult> zzbMg;
    private boolean zzbMh;
    private TResult zzbMi;
    private Exception zzbMj;
    
    zzn() {
        this.mLock = new Object();
        this.zzbMg = new zzl<TResult>();
    }
    
    private final void zzDG() {
        zzbo.zza(this.zzbMh, (Object)"Task is not yet complete");
    }
    
    private final void zzDH() {
        zzbo.zza(!this.zzbMh, (Object)"Task is already complete");
    }
    
    private final void zzDI() {
        synchronized (this.mLock) {
            if (!this.zzbMh) {
                return;
            }
            // monitorexit(this.mLock)
            this.zzbMg.zza(this);
        }
    }
    
    @NonNull
    @Override
    public final Task<TResult> addOnCompleteListener(@NonNull final Activity activity, @NonNull final OnCompleteListener<TResult> onCompleteListener) {
        final zze<TResult> zze = new zze<TResult>(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.zzbMg.zza(zze);
        zza.zzr(activity).zzb(zze);
        this.zzDI();
        return this;
    }
    
    @NonNull
    @Override
    public final Task<TResult> addOnCompleteListener(@NonNull final OnCompleteListener<TResult> onCompleteListener) {
        return this.addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }
    
    @NonNull
    @Override
    public final Task<TResult> addOnCompleteListener(@NonNull final Executor executor, @NonNull final OnCompleteListener<TResult> onCompleteListener) {
        this.zzbMg.zza(new zze<TResult>(executor, onCompleteListener));
        this.zzDI();
        return this;
    }
    
    @NonNull
    @Override
    public final Task<TResult> addOnFailureListener(@NonNull final Activity activity, @NonNull final OnFailureListener onFailureListener) {
        final zzg<TResult> zzg = new zzg<TResult>(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.zzbMg.zza(zzg);
        zza.zzr(activity).zzb(zzg);
        this.zzDI();
        return this;
    }
    
    @NonNull
    @Override
    public final Task<TResult> addOnFailureListener(@NonNull final OnFailureListener onFailureListener) {
        return this.addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }
    
    @NonNull
    @Override
    public final Task<TResult> addOnFailureListener(@NonNull final Executor executor, @NonNull final OnFailureListener onFailureListener) {
        this.zzbMg.zza(new zzg<TResult>(executor, onFailureListener));
        this.zzDI();
        return this;
    }
    
    @NonNull
    @Override
    public final Task<TResult> addOnSuccessListener(@NonNull final Activity activity, @NonNull final OnSuccessListener<? super TResult> onSuccessListener) {
        final zzi<TResult> zzi = new zzi<TResult>(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.zzbMg.zza(zzi);
        zza.zzr(activity).zzb(zzi);
        this.zzDI();
        return this;
    }
    
    @NonNull
    @Override
    public final Task<TResult> addOnSuccessListener(@NonNull final OnSuccessListener<? super TResult> onSuccessListener) {
        return this.addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
    }
    
    @NonNull
    @Override
    public final Task<TResult> addOnSuccessListener(@NonNull final Executor executor, @NonNull final OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzbMg.zza(new zzi<TResult>(executor, onSuccessListener));
        this.zzDI();
        return this;
    }
    
    @NonNull
    @Override
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull final Continuation<TResult, TContinuationResult> continuation) {
        return this.continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }
    
    @NonNull
    @Override
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull final Executor executor, @NonNull final Continuation<TResult, TContinuationResult> continuation) {
        final zzn<Object> zzn = new zzn<Object>();
        this.zzbMg.zza(new com.google.android.gms.tasks.zza<TResult, Object>(executor, (Continuation<Object, Object>)continuation, zzn));
        this.zzDI();
        return (Task<TContinuationResult>)zzn;
    }
    
    @NonNull
    @Override
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull final Continuation<TResult, Task<TContinuationResult>> continuation) {
        return this.continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }
    
    @NonNull
    @Override
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull final Executor executor, @NonNull final Continuation<TResult, Task<TContinuationResult>> continuation) {
        final zzn<Object> zzn = new zzn<Object>();
        this.zzbMg.zza(new zzc<TResult, Object>(executor, (Continuation<Object, Task<Object>>)continuation, zzn));
        this.zzDI();
        return (Task<TContinuationResult>)zzn;
    }
    
    @Nullable
    @Override
    public final Exception getException() {
        synchronized (this.mLock) {
            return this.zzbMj;
        }
    }
    
    @Override
    public final TResult getResult() {
        synchronized (this.mLock) {
            this.zzDG();
            if (this.zzbMj != null) {
                throw new RuntimeExecutionException(this.zzbMj);
            }
        }
        // monitorexit(o)
        return this.zzbMi;
    }
    
    @Override
    public final <X extends Throwable> TResult getResult(@NonNull final Class<X> clazz) throws X, Throwable {
        synchronized (this.mLock) {
            this.zzDG();
            if (clazz.isInstance(this.zzbMj)) {
                throw clazz.cast(this.zzbMj);
            }
        }
        if (this.zzbMj != null) {
            throw new RuntimeExecutionException(this.zzbMj);
        }
        // monitorexit(o)
        return this.zzbMi;
    }
    
    @Override
    public final boolean isComplete() {
        synchronized (this.mLock) {
            return this.zzbMh;
        }
    }
    
    @Override
    public final boolean isSuccessful() {
        while (true) {
            synchronized (this.mLock) {
                if (this.zzbMh && this.zzbMj == null) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public final void setException(@NonNull final Exception zzbMj) {
        zzbo.zzb(zzbMj, "Exception must not be null");
        synchronized (this.mLock) {
            this.zzDH();
            this.zzbMh = true;
            this.zzbMj = zzbMj;
            // monitorexit(this.mLock)
            this.zzbMg.zza(this);
        }
    }
    
    public final void setResult(final TResult zzbMi) {
        synchronized (this.mLock) {
            this.zzDH();
            this.zzbMh = true;
            this.zzbMi = zzbMi;
            // monitorexit(this.mLock)
            this.zzbMg.zza(this);
        }
    }
    
    public final boolean trySetException(@NonNull final Exception zzbMj) {
        zzbo.zzb(zzbMj, "Exception must not be null");
        synchronized (this.mLock) {
            if (this.zzbMh) {
                return false;
            }
            this.zzbMh = true;
            this.zzbMj = zzbMj;
            // monitorexit(this.mLock)
            this.zzbMg.zza(this);
            return true;
        }
    }
    
    public final boolean trySetResult(final TResult zzbMi) {
        synchronized (this.mLock) {
            if (this.zzbMh) {
                return false;
            }
            this.zzbMh = true;
            this.zzbMi = zzbMi;
            // monitorexit(this.mLock)
            this.zzbMg.zza(this);
            return true;
        }
    }
    
    static class zza extends zzbds
    {
        private final List<WeakReference<zzk<?>>> mListeners;
        
        private zza(final zzbdt zzbdt) {
            super(zzbdt);
            this.mListeners = new ArrayList<WeakReference<zzk<?>>>();
            this.zzaEG.zza("TaskOnStopCallback", this);
        }
        
        public static zza zzr(final Activity activity) {
            final zzbdt zzn = zzbds.zzn(activity);
            zza zza;
            if ((zza = zzn.zza("TaskOnStopCallback", zza.class)) == null) {
                zza = new zza(zzn);
            }
            return zza;
        }
        
        @MainThread
        @Override
        public final void onStop() {
            synchronized (this.mListeners) {
                final Iterator<WeakReference<zzk<?>>> iterator = this.mListeners.iterator();
                while (iterator.hasNext()) {
                    final zzk zzk = iterator.next().get();
                    if (zzk != null) {
                        zzk.cancel();
                    }
                }
            }
            this.mListeners.clear();
        }
        // monitorexit(list)
        
        public final <T> void zzb(final zzk<T> referent) {
            synchronized (this.mListeners) {
                this.mListeners.add(new WeakReference<zzk<?>>(referent));
            }
        }
    }
}
