package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;

final class zzcuq implements zzdqx<zzcvd> {
    private final /* synthetic */ zzavm zzgkx;
    private final /* synthetic */ zzcuh zzgky;

    zzcuq(zzcuh zzcuh, zzavm zzavm) {
        this.zzgky = zzcuh;
        this.zzgkx = zzavm;
    }

    public final /* synthetic */ void onSuccess(@Nullable Object obj) {
        zzcvd zzcvd = (zzcvd) obj;
        try {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcue)).booleanValue()) {
                if (this.zzgky.zzbml.zzdzo >= ((Integer) zzvj.zzpv().zzd(zzzz.zzcug)).intValue()) {
                    if (zzcvd == null) {
                        this.zzgkx.zza((String) null, (String) null, (Bundle) null);
                        return;
                    } else {
                        this.zzgkx.zza(zzcvd.zzglg, zzcvd.zzglh, zzcvd.zzgli);
                        return;
                    }
                }
            }
            if (zzcvd == null) {
                this.zzgkx.zzk((String) null, (String) null);
            } else {
                this.zzgkx.zzk(zzcvd.zzglg, zzcvd.zzglh);
            }
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final void zzb(Throwable th) {
        try {
            zzavm zzavm = this.zzgkx;
            String valueOf = String.valueOf(th.getMessage());
            zzavm.onError(valueOf.length() != 0 ? "Internal error. ".concat(valueOf) : new String("Internal error. "));
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }
}
