// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzcit implements Runnable
{
    private /* synthetic */ zzciq zzbuk;
    private /* synthetic */ zzcfd zzbul;
    
    zzcit(final zzciq zzbuk, final zzcfd zzbul) {
        this.zzbuk = zzbuk;
        this.zzbul = zzbul;
    }
    
    @Override
    public final void run() {
        synchronized (this.zzbuk) {
            zzciq.zza(this.zzbuk, false);
            if (!this.zzbuk.zzbua.isConnected()) {
                this.zzbuk.zzbua.zzwF().zzyC().log("Connected to remote service");
                this.zzbuk.zzbua.zza(this.zzbul);
            }
        }
    }
}
