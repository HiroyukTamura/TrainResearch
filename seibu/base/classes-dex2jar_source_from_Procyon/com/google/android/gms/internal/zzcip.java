// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzcip implements Runnable
{
    private /* synthetic */ boolean zzbtw;
    private /* synthetic */ zzcid zzbua;
    private /* synthetic */ AtomicReference zzbub;
    
    zzcip(final zzcid zzbua, final AtomicReference zzbub, final boolean zzbtw) {
        this.zzbua = zzbua;
        this.zzbub = zzbub;
        this.zzbtw = zzbtw;
    }
    
    @Override
    public final void run() {
        final AtomicReference zzbub = this.zzbub;
        // monitorenter(zzbub)
        try {
            final zzcfd zzd = this.zzbua.zzbtU;
            Label_0044: {
                if (zzd != null) {
                    break Label_0044;
                }
                this.zzbua.zzwF().zzyx().log("Failed to get user properties");
                try {
                    this.zzbub.notify();
                    return;
                    this.zzbub.set(zzd.zza(this.zzbua.zzwu().zzdV(null), this.zzbtw));
                    this.zzbua.zzkP();
                    this.zzbub.notify();
                }
                finally {
                }
                // monitorexit(zzbub)
            }
        }
        catch (RemoteException ex) {
            this.zzbua.zzwF().zzyx().zzj("Failed to get user properties", ex);
        }
        finally {
            this.zzbub.notify();
        }
    }
}
