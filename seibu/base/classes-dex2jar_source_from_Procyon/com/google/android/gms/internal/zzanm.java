// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import android.os.Handler;

abstract class zzanm
{
    private static volatile Handler zzagY;
    private final zzamj zzafJ;
    private volatile long zzagZ;
    private final Runnable zzv;
    
    zzanm(final zzamj zzafJ) {
        zzbo.zzu(zzafJ);
        this.zzafJ = zzafJ;
        this.zzv = new zzann(this);
    }
    
    private final Handler getHandler() {
        if (zzanm.zzagY != null) {
            return zzanm.zzagY;
        }
        synchronized (zzanm.class) {
            if (zzanm.zzagY == null) {
                zzanm.zzagY = new Handler(this.zzafJ.getContext().getMainLooper());
            }
            return zzanm.zzagY;
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
    
    public final long zzlz() {
        if (this.zzagZ == 0L) {
            return 0L;
        }
        return Math.abs(this.zzafJ.zzkq().currentTimeMillis() - this.zzagZ);
    }
    
    public final void zzs(final long l) {
        this.cancel();
        if (l >= 0L) {
            this.zzagZ = this.zzafJ.zzkq().currentTimeMillis();
            if (!this.getHandler().postDelayed(this.zzv, l)) {
                this.zzafJ.zzkr().zze("Failed to schedule delayed post. time", l);
            }
        }
    }
    
    public final void zzt(long l) {
        final long n = 0L;
        if (this.zzbo()) {
            if (l < 0L) {
                this.cancel();
                return;
            }
            l -= Math.abs(this.zzafJ.zzkq().currentTimeMillis() - this.zzagZ);
            if (l < 0L) {
                l = n;
            }
            this.getHandler().removeCallbacks(this.zzv);
            if (!this.getHandler().postDelayed(this.zzv, l)) {
                this.zzafJ.zzkr().zze("Failed to adjust delayed post. time", l);
            }
        }
    }
}
