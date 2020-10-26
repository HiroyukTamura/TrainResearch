// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import com.google.android.gms.internal.zzaoc;

final class zze implements Runnable
{
    private /* synthetic */ zzaoc zzadv;
    private /* synthetic */ int zzadw;
    private /* synthetic */ CampaignTrackingService zzadx;
    
    zze(final CampaignTrackingService zzadx, final int zzadw, final zzaoc zzadv) {
        this.zzadx = zzadx;
        this.zzadw = zzadw;
        this.zzadv = zzadv;
    }
    
    @Override
    public final void run() {
        final boolean stopSelfResult = this.zzadx.stopSelfResult(this.zzadw);
        if (stopSelfResult) {
            this.zzadv.zza("Install campaign broadcast processed", stopSelfResult);
        }
    }
}
