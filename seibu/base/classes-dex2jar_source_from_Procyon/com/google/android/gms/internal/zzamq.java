// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzamq implements Runnable
{
    private /* synthetic */ zzany zzagn;
    private /* synthetic */ zzamp zzago;
    
    zzamq(final zzamp zzago, final zzany zzagn) {
        this.zzago = zzago;
        this.zzagn = zzagn;
    }
    
    @Override
    public final void run() {
        if (!this.zzago.zzagk.isConnected()) {
            this.zzago.zzagk.zzbp("Connected to service after a timeout");
            this.zzago.zzagk.zza(this.zzagn);
        }
    }
}
