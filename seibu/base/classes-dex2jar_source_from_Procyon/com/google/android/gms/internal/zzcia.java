// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

final class zzcia implements Runnable
{
    private /* synthetic */ boolean zzbtN;
    private /* synthetic */ AppMeasurement.zzb zzbtO;
    private /* synthetic */ zzcic zzbtP;
    private /* synthetic */ zzchz zzbtQ;
    
    zzcia(final zzchz zzbtQ, final boolean zzbtN, final AppMeasurement.zzb zzbtO, final zzcic zzbtP) {
        this.zzbtQ = zzbtQ;
        this.zzbtN = zzbtN;
        this.zzbtO = zzbtO;
        this.zzbtP = zzbtP;
    }
    
    @Override
    public final void run() {
        if (this.zzbtN && this.zzbtQ.zzbtE != null) {
            this.zzbtQ.zza(this.zzbtQ.zzbtE);
        }
        int n;
        if (this.zzbtO == null || this.zzbtO.zzbol != this.zzbtP.zzbol || !zzcjl.zzR(this.zzbtO.zzbok, this.zzbtP.zzbok) || !zzcjl.zzR(this.zzbtO.zzboj, this.zzbtP.zzboj)) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0) {
            final Bundle bundle = new Bundle();
            zzchz.zza(this.zzbtP, bundle);
            if (this.zzbtO != null) {
                if (this.zzbtO.zzboj != null) {
                    bundle.putString("_pn", this.zzbtO.zzboj);
                }
                bundle.putString("_pc", this.zzbtO.zzbok);
                bundle.putLong("_pi", this.zzbtO.zzbol);
            }
            this.zzbtQ.zzwt().zzd("auto", "_vs", bundle);
        }
        this.zzbtQ.zzbtE = this.zzbtP;
        this.zzbtQ.zzww().zza(this.zzbtP);
    }
}
