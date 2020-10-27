package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

abstract class zzdqm<T> extends zzdre<T> {
    private final Executor zzhhq;
    boolean zzhhr = true;
    private final /* synthetic */ zzdqk zzhhs;

    zzdqm(zzdqk zzdqk, Executor executor) {
        this.zzhhs = zzdqk;
        this.zzhhq = (Executor) zzdoj.checkNotNull(executor);
    }

    /* access modifiers changed from: package-private */
    public final void execute() {
        try {
            this.zzhhq.execute(this);
        } catch (RejectedExecutionException e) {
            if (this.zzhhr) {
                this.zzhhs.setException(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean isDone() {
        return this.zzhhs.isDone();
    }

    /* access modifiers changed from: package-private */
    public abstract void setValue(T t);

    /* access modifiers changed from: package-private */
    public final void zzb(T t, Throwable th) {
        zzdqm unused = this.zzhhs.zzhhp = null;
        if (th == null) {
            setValue(t);
        } else if (th instanceof ExecutionException) {
            this.zzhhs.setException(th.getCause());
        } else if (th instanceof CancellationException) {
            this.zzhhs.cancel(false);
        } else {
            this.zzhhs.setException(th);
        }
    }
}
