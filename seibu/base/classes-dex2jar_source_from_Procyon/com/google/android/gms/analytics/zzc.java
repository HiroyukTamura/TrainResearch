// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import android.os.Handler;
import com.google.android.gms.internal.zzaoc;

final class zzc implements Runnable
{
    private /* synthetic */ zzaoc zzadv;
    private /* synthetic */ int zzadw;
    private /* synthetic */ CampaignTrackingService zzadx;
    private /* synthetic */ Handler zzs;
    
    zzc(final CampaignTrackingService zzadx, final zzaoc zzadv, final Handler zzs, final int zzadw) {
        this.zzadx = zzadx;
        this.zzadv = zzadv;
        this.zzs = zzs;
        this.zzadw = zzadw;
    }
    
    @Override
    public final void run() {
        this.zzadx.zza(this.zzadv, this.zzs, this.zzadw);
    }
}
