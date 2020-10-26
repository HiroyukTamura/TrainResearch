// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class zzcim implements Runnable
{
    private /* synthetic */ String zzbjh;
    private /* synthetic */ String zzbth;
    private /* synthetic */ String zzbti;
    private /* synthetic */ zzcid zzbua;
    private /* synthetic */ AtomicReference zzbub;
    
    zzcim(final zzcid zzbua, final AtomicReference zzbub, final String zzbjh, final String zzbth, final String zzbti) {
        this.zzbua = zzbua;
        this.zzbub = zzbub;
        this.zzbjh = zzbjh;
        this.zzbth = zzbth;
        this.zzbti = zzbti;
    }
    
    @Override
    public final void run() {
        final AtomicReference zzbub = this.zzbub;
        // monitorenter(zzbub)
        try {
            final zzcfd zzd = this.zzbua.zzbtU;
            Label_0069: {
                if (zzd != null) {
                    break Label_0069;
                }
                while (true) {
                    this.zzbua.zzwF().zzyx().zzd("Failed to get conditional properties", zzcfl.zzdZ(this.zzbjh), this.zzbth, this.zzbti);
                    this.zzbub.set(Collections.emptyList());
                    while (true) {
                        try {
                            this.zzbub.notify();
                            return;
                            // iftrue(Label_0142:, !TextUtils.isEmpty((CharSequence)this.zzbjh))
                            Block_6: {
                                break Block_6;
                            }
                            this.zzbub.set(zzd.zza(this.zzbth, this.zzbti, this.zzbua.zzwu().zzdV(this.zzbua.zzwF().zzyE())));
                            this.zzbua.zzkP();
                            this.zzbub.notify();
                            return;
                        }
                        finally {
                        }
                        // monitorexit(zzbub)
                        Label_0142: {
                            final zzcfd zzcfd;
                            this.zzbub.set(zzcfd.zzk(this.zzbjh, this.zzbth, this.zzbti));
                        }
                        continue;
                    }
                }
            }
        }
        catch (RemoteException ex) {
            this.zzbua.zzwF().zzyx().zzd("Failed to get conditional properties", zzcfl.zzdZ(this.zzbjh), this.zzbth, ex);
            this.zzbub.set(Collections.emptyList());
        }
        finally {
            this.zzbub.notify();
        }
    }
}
