// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import android.support.annotation.NonNull;
import java.util.Queue;

final class zzl<TResult>
{
    private final Object mLock;
    private Queue<zzk<TResult>> zzbMc;
    private boolean zzbMd;
    
    zzl() {
        this.mLock = new Object();
    }
    
    public final void zza(@NonNull final Task<TResult> task) {
        while (true) {
            // monitorexit(mLock)
            while (true) {
                final zzk<TResult> zzk;
                synchronized (this.mLock) {
                    if (this.zzbMc == null || this.zzbMd) {
                        return;
                    }
                    this.zzbMd = true;
                    // monitorexit(this.mLock)
                    final Object mLock = this.mLock;
                    synchronized (this.mLock) {
                        zzk = this.zzbMc.poll();
                        if (zzk == null) {
                            this.zzbMd = false;
                            return;
                        }
                    }
                }
                final Task<TResult> task2;
                zzk.onComplete(task2);
                continue;
            }
        }
    }
    
    public final void zza(@NonNull final zzk<TResult> zzk) {
        synchronized (this.mLock) {
            if (this.zzbMc == null) {
                this.zzbMc = new ArrayDeque<zzk<TResult>>();
            }
            this.zzbMc.add(zzk);
        }
    }
}
