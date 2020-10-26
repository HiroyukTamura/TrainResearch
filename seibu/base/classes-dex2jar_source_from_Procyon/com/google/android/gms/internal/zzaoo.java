// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.util.zze;

final class zzaoo
{
    private long mStartTime;
    private final zze zzvw;
    
    public zzaoo(final zze zzvw) {
        zzbo.zzu(zzvw);
        this.zzvw = zzvw;
    }
    
    public zzaoo(final zze zzvw, final long mStartTime) {
        zzbo.zzu(zzvw);
        this.zzvw = zzvw;
        this.mStartTime = mStartTime;
    }
    
    public final void clear() {
        this.mStartTime = 0L;
    }
    
    public final void start() {
        this.mStartTime = this.zzvw.elapsedRealtime();
    }
    
    public final boolean zzu(final long n) {
        return this.mStartTime == 0L || this.zzvw.elapsedRealtime() - this.mStartTime > n;
    }
}
