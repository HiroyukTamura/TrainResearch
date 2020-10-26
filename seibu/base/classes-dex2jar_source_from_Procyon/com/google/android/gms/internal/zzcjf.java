// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.util.zze;

final class zzcjf
{
    private long mStartTime;
    private final zze zzvw;
    
    public zzcjf(final zze zzvw) {
        zzbo.zzu(zzvw);
        this.zzvw = zzvw;
    }
    
    public final void clear() {
        this.mStartTime = 0L;
    }
    
    public final void start() {
        this.mStartTime = this.zzvw.elapsedRealtime();
    }
    
    public final boolean zzu(final long n) {
        return this.mStartTime == 0L || this.zzvw.elapsedRealtime() - this.mStartTime >= n;
    }
}
