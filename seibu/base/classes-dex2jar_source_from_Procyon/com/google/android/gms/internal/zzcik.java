// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.zza;
import android.os.RemoteException;
import android.text.TextUtils;

final class zzcik implements Runnable
{
    private /* synthetic */ String zzbjh;
    private /* synthetic */ zzcez zzbtj;
    private /* synthetic */ zzcid zzbua;
    private /* synthetic */ boolean zzbud;
    private /* synthetic */ boolean zzbue;
    
    zzcik(final zzcid zzbua, final boolean b, final boolean zzbue, final zzcez zzbtj, final String zzbjh) {
        this.zzbua = zzbua;
        this.zzbud = true;
        this.zzbue = zzbue;
        this.zzbtj = zzbtj;
        this.zzbjh = zzbjh;
    }
    
    @Override
    public final void run() {
        final zzcfd zzd = this.zzbua.zzbtU;
        if (zzd == null) {
            this.zzbua.zzwF().zzyx().log("Discarding data. Failed to send event to service");
            return;
        }
        Label_0055: {
            if (this.zzbud) {
                final zzcid zzbua = this.zzbua;
                zza zzbtj;
                if (this.zzbue) {
                    zzbtj = null;
                }
                else {
                    zzbtj = this.zzbtj;
                }
                zzbua.zza(zzd, zzbtj);
            }
            else {
                Label_0134: {
                    try {
                        if (!TextUtils.isEmpty((CharSequence)this.zzbjh)) {
                            break Label_0134;
                        }
                        zzd.zza(this.zzbtj, this.zzbua.zzwu().zzdV(this.zzbua.zzwF().zzyE()));
                    }
                    catch (RemoteException ex) {
                        this.zzbua.zzwF().zzyx().zzj("Failed to send event to the service", ex);
                    }
                    break Label_0055;
                }
                zzd.zza(this.zzbtj, this.zzbjh, this.zzbua.zzwF().zzyE());
            }
        }
        this.zzbua.zzkP();
    }
}
