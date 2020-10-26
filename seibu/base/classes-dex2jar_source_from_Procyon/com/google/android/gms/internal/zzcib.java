// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;

final class zzcib implements Runnable
{
    private /* synthetic */ zzchz zzbtQ;
    private /* synthetic */ zzcic zzbtR;
    
    zzcib(final zzchz zzbtQ, final zzcic zzbtR) {
        this.zzbtQ = zzbtQ;
        this.zzbtR = zzbtR;
    }
    
    @Override
    public final void run() {
        this.zzbtQ.zza(this.zzbtR);
        this.zzbtQ.zzbtE = null;
        this.zzbtQ.zzww().zza((AppMeasurement.zzb)null);
    }
}
