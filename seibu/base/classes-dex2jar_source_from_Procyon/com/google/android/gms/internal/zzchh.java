// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;

final class zzchh implements Runnable
{
    private /* synthetic */ String zzbjh;
    private /* synthetic */ zzcgq zzbtf;
    private /* synthetic */ String zzbtl;
    private /* synthetic */ String zzbtm;
    private /* synthetic */ long zzbtn;
    
    zzchh(final zzcgq zzbtf, final String zzbtl, final String zzbjh, final String zzbtm, final long zzbtn) {
        this.zzbtf = zzbtf;
        this.zzbtl = zzbtl;
        this.zzbjh = zzbjh;
        this.zzbtm = zzbtm;
        this.zzbtn = zzbtn;
    }
    
    @Override
    public final void run() {
        if (this.zzbtl == null) {
            this.zzbtf.zzboe.zzwx().zza(this.zzbjh, null);
            return;
        }
        final AppMeasurement.zzb zzb = new AppMeasurement.zzb();
        zzb.zzboj = this.zzbtm;
        zzb.zzbok = this.zzbtl;
        zzb.zzbol = this.zzbtn;
        this.zzbtf.zzboe.zzwx().zza(this.zzbjh, zzb);
    }
}
