package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

final class zzcma implements zzdqx<ParcelFileDescriptor> {
    private final /* synthetic */ zzard zzgcp;

    zzcma(zzclo zzclo, zzard zzard) {
        this.zzgcp = zzard;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        try {
            this.zzgcp.zzb((ParcelFileDescriptor) obj);
        } catch (RemoteException e) {
            zzawr.zza("Service can't call client", e);
        }
    }

    public final void zzb(Throwable th) {
        try {
            this.zzgcp.zza(zzaye.zza(th, zzcjk.zzd(th)));
        } catch (RemoteException e) {
            zzawr.zza("Service can't call client", e);
        }
    }
}
