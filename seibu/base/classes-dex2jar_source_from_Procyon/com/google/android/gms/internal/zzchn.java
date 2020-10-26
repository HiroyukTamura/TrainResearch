// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;

final class zzchn implements Runnable
{
    private /* synthetic */ zzchl zzbtt;
    private /* synthetic */ AppMeasurement.ConditionalUserProperty zzbtu;
    
    zzchn(final zzchl zzbtt, final AppMeasurement.ConditionalUserProperty zzbtu) {
        this.zzbtt = zzbtt;
        this.zzbtu = zzbtu;
    }
    
    @Override
    public final void run() {
        this.zzbtt.zzb(this.zzbtu);
    }
}
