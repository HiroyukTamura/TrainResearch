// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzcir implements Runnable
{
    private /* synthetic */ zzcfd zzbuj;
    private /* synthetic */ zzciq zzbuk;
    
    zzcir(final zzciq zzbuk, final zzcfd zzbuj) {
        this.zzbuk = zzbuk;
        this.zzbuj = zzbuj;
    }
    
    @Override
    public final void run() {
        synchronized (this.zzbuk) {
            zzciq.zza(this.zzbuk, false);
            if (!this.zzbuk.zzbua.isConnected()) {
                this.zzbuk.zzbua.zzwF().zzyD().log("Connected to service");
                this.zzbuk.zzbua.zza(this.zzbuj);
            }
        }
    }
}
