// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.internal.zzbo;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import android.content.Context;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

public final class zzcgg extends zzchj
{
    private static final AtomicLong zzbsf;
    private ExecutorService zzbrV;
    private zzcgk zzbrW;
    private zzcgk zzbrX;
    private final PriorityBlockingQueue<FutureTask<?>> zzbrY;
    private final BlockingQueue<FutureTask<?>> zzbrZ;
    private final Thread.UncaughtExceptionHandler zzbsa;
    private final Thread.UncaughtExceptionHandler zzbsb;
    private final Object zzbsc;
    private final Semaphore zzbsd;
    private volatile boolean zzbse;
    
    static {
        zzbsf = new AtomicLong(Long.MIN_VALUE);
    }
    
    zzcgg(final zzcgl zzcgl) {
        super(zzcgl);
        this.zzbsc = new Object();
        this.zzbsd = new Semaphore(2);
        this.zzbrY = new PriorityBlockingQueue<FutureTask<?>>();
        this.zzbrZ = new LinkedBlockingQueue<FutureTask<?>>();
        this.zzbsa = new zzcgi(this, "Thread death: Uncaught exception on worker thread");
        this.zzbsb = new zzcgi(this, "Thread death: Uncaught exception on network thread");
    }
    
    public static boolean zzS() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
    
    private final void zza(final zzcgj<?> e) {
        synchronized (this.zzbsc) {
            this.zzbrY.add(e);
            if (this.zzbrW == null) {
                (this.zzbrW = new zzcgk("Measurement Worker", this.zzbrY)).setUncaughtExceptionHandler(this.zzbsa);
                this.zzbrW.start();
            }
            else {
                this.zzbrW.zzfF();
            }
        }
    }
    
    public final <V> Future<V> zze(final Callable<V> callable) throws IllegalStateException {
        this.zzkD();
        zzbo.zzu(callable);
        final zzcgj<V> zzcgj = new zzcgj<V>(callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzbrW) {
            if (!this.zzbrY.isEmpty()) {
                super.zzwF().zzyz().log("Callable skipped the worker queue.");
            }
            zzcgj.run();
            return zzcgj;
        }
        this.zza(zzcgj);
        return zzcgj;
    }
    
    public final <V> Future<V> zzf(final Callable<V> callable) throws IllegalStateException {
        this.zzkD();
        zzbo.zzu(callable);
        final zzcgj<V> zzcgj = new zzcgj<V>(callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzbrW) {
            zzcgj.run();
            return zzcgj;
        }
        this.zza(zzcgj);
        return zzcgj;
    }
    
    public final void zzj(final Runnable runnable) throws IllegalStateException {
        this.zzkD();
        zzbo.zzu(runnable);
        this.zza(new zzcgj<Object>(this, runnable, false, "Task exception on worker thread"));
    }
    
    @Override
    public final void zzjC() {
        if (Thread.currentThread() != this.zzbrW) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }
    
    @Override
    protected final void zzjD() {
    }
    
    public final void zzk(final Runnable runnable) throws IllegalStateException {
        this.zzkD();
        zzbo.zzu(runnable);
        final zzcgj<Object> zzcgj = new zzcgj<Object>(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzbsc) {
            this.zzbrZ.add(zzcgj);
            if (this.zzbrX == null) {
                (this.zzbrX = new zzcgk("Measurement Network", this.zzbrZ)).setUncaughtExceptionHandler(this.zzbsb);
                this.zzbrX.start();
            }
            else {
                this.zzbrX.zzfF();
            }
        }
    }
    
    @Override
    public final void zzwq() {
        if (Thread.currentThread() != this.zzbrX) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }
    
    public final boolean zzyM() {
        return Thread.currentThread() == this.zzbrW;
    }
    
    final ExecutorService zzyN() {
        synchronized (this.zzbsc) {
            if (this.zzbrV == null) {
                this.zzbrV = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));
            }
            return this.zzbrV;
        }
    }
}
