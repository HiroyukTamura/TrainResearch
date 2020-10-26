// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzaom implements Runnable
{
    private /* synthetic */ zzaol zzaiG;
    
    zzaom(final zzaol zzaiG) {
        this.zzaiG = zzaiG;
    }
    
    @Override
    public final void run() {
        if (this.zzaiG.zzaiF.zzaiD.callServiceStopSelfResult(this.zzaiG.zzadw)) {
            this.zzaiG.zzadv.zzbo("Local AnalyticsService processed last dispatch request");
        }
    }
}
