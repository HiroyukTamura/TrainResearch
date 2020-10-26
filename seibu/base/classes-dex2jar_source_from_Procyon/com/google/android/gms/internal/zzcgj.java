// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import java.util.concurrent.Callable;
import com.google.android.gms.common.internal.zzbo;
import java.util.concurrent.FutureTask;

final class zzcgj<V> extends FutureTask<V> implements Comparable<zzcgj>
{
    private final String zzbsg;
    private /* synthetic */ zzcgg zzbsh;
    private final long zzbsi;
    private final boolean zzbsj;
    
    zzcgj(final zzcgg zzbsh, final Runnable runnable, final boolean b, final String zzbsg) {
        this.zzbsh = zzbsh;
        super(runnable, null);
        zzbo.zzu(zzbsg);
        this.zzbsi = zzcgg.zzbsf.getAndIncrement();
        this.zzbsg = zzbsg;
        this.zzbsj = false;
        if (this.zzbsi == Long.MAX_VALUE) {
            zzbsh.zzwF().zzyx().log("Tasks index overflow");
        }
    }
    
    zzcgj(final zzcgg zzbsh, final Callable<V> callable, final boolean zzbsj, final String zzbsg) {
        this.zzbsh = zzbsh;
        super(callable);
        zzbo.zzu(zzbsg);
        this.zzbsi = zzcgg.zzbsf.getAndIncrement();
        this.zzbsg = zzbsg;
        this.zzbsj = zzbsj;
        if (this.zzbsi == Long.MAX_VALUE) {
            zzbsh.zzwF().zzyx().log("Tasks index overflow");
        }
    }
    
    @Override
    protected final void setException(final Throwable exception) {
        this.zzbsh.zzwF().zzyx().zzj(this.zzbsg, exception);
        if (exception instanceof zzcgh) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), exception);
        }
        super.setException(exception);
    }
}
