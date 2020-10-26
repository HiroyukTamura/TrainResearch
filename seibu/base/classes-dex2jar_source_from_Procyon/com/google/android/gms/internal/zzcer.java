// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import android.os.Handler;

abstract class zzcer
{
    private static volatile Handler zzagY;
    private volatile long zzagZ;
    private final zzcgl zzboe;
    private boolean zzbpA;
    private final Runnable zzv;
    
    zzcer(final zzcgl zzboe) {
        zzbo.zzu(zzboe);
        this.zzboe = zzboe;
        this.zzbpA = true;
        this.zzv = new zzces(this);
    }
    
    private final Handler getHandler() {
        if (zzcer.zzagY != null) {
            return zzcer.zzagY;
        }
        synchronized (zzcer.class) {
            if (zzcer.zzagY == null) {
                zzcer.zzagY = new Handler(this.zzboe.getContext().getMainLooper());
            }
            return zzcer.zzagY;
        }
    }
    
    public final void cancel() {
        this.zzagZ = 0L;
        this.getHandler().removeCallbacks(this.zzv);
    }
    
    public abstract void run();
    
    public final boolean zzbo() {
        return this.zzagZ != 0L;
    }
    
    public final void zzs(final long l) {
        this.cancel();
        if (l >= 0L) {
            this.zzagZ = this.zzboe.zzkq().currentTimeMillis();
            if (!this.getHandler().postDelayed(this.zzv, l)) {
                this.zzboe.zzwF().zzyx().zzj("Failed to schedule delayed post. time", l);
            }
        }
    }
}
