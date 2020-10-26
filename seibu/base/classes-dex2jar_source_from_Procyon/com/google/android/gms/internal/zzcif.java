// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzcif implements Runnable
{
    private /* synthetic */ zzcid zzbua;
    private /* synthetic */ AtomicReference zzbub;
    
    zzcif(final zzcid zzbua, final AtomicReference zzbub) {
        this.zzbua = zzbua;
        this.zzbub = zzbub;
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
                this.zzbua.zzwF().zzyx().log("Failed to get app instance id");
                try {
                    this.zzbub.notify();
                    return;
                    Label_0108: {
                        this.zzbua.zzkP();
                    }
                    this.zzbub.notify();
                    return;
                    this.zzbub.set(zzd.zzc(this.zzbua.zzwu().zzdV(null)));
                    final String s = this.zzbub.get();
                    // iftrue(Label_0108:, s == null)
                    this.zzbua.zzwt().zzee(s);
                    this.zzbua.zzwG().zzbrq.zzef(s);
                }
                finally {
                }
                // monitorexit(zzbub)
            }
        }
        catch (RemoteException ex) {
            this.zzbua.zzwF().zzyx().zzj("Failed to get app instance id", ex);
        }
        finally {
            this.zzbub.notify();
        }
    }
}
