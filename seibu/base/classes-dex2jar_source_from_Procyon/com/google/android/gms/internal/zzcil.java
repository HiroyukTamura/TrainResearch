// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.zza;
import android.os.RemoteException;
import android.text.TextUtils;

final class zzcil implements Runnable
{
    private /* synthetic */ zzcid zzbua;
    private /* synthetic */ boolean zzbud;
    private /* synthetic */ boolean zzbue;
    private /* synthetic */ zzcek zzbuf;
    private /* synthetic */ zzcek zzbug;
    
    zzcil(final zzcid zzbua, final boolean b, final boolean zzbue, final zzcek zzbuf, final zzcek zzbug) {
        this.zzbua = zzbua;
        this.zzbud = true;
        this.zzbue = zzbue;
        this.zzbuf = zzbuf;
        this.zzbug = zzbug;
    }
    
    @Override
    public final void run() {
        final zzcfd zzd = this.zzbua.zzbtU;
        if (zzd == null) {
            this.zzbua.zzwF().zzyx().log("Discarding data. Failed to send conditional user property to service");
            return;
        }
        Label_0055: {
            if (this.zzbud) {
                final zzcid zzbua = this.zzbua;
                zza zzbuf;
                if (this.zzbue) {
                    zzbuf = null;
                }
                else {
                    zzbuf = this.zzbuf;
                }
                zzbua.zza(zzd, zzbuf);
            }
            else {
                Label_0137: {
                    try {
                        if (!TextUtils.isEmpty((CharSequence)this.zzbug.packageName)) {
                            break Label_0137;
                        }
                        zzd.zza(this.zzbuf, this.zzbua.zzwu().zzdV(this.zzbua.zzwF().zzyE()));
                    }
                    catch (RemoteException ex) {
                        this.zzbua.zzwF().zzyx().zzj("Failed to send conditional user property to the service", ex);
                    }
                    break Label_0055;
                }
                zzd.zzb(this.zzbuf);
            }
        }
        this.zzbua.zzkP();
    }
}
