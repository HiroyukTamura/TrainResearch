// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Build$VERSION;

final class zzciy implements Runnable
{
    private /* synthetic */ zzcix zzbuq;
    
    zzciy(final zzcix zzbuq) {
        this.zzbuq = zzbuq;
    }
    
    @Override
    public final void run() {
        if (this.zzbuq.zzbun != null) {
            if (this.zzbuq.zzbup.zzbum.callServiceStopSelfResult(this.zzbuq.zzbun)) {
                zzcem.zzxE();
                this.zzbuq.zzbrP.zzyD().zzj("Local AppMeasurementService processed last upload request. StartId", this.zzbuq.zzbun);
            }
        }
        else {
            zzcem.zzxE();
            if (Build$VERSION.SDK_INT >= 24) {
                this.zzbuq.zzbrP.zzyD().log("AppMeasurementJobService processed last upload request.");
                this.zzbuq.zzbup.zzbum.zza(this.zzbuq.zzbuo, false);
            }
        }
    }
}
