package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

final class zzcro extends zzasx {
    private final /* synthetic */ zzbsu zzghh;
    private final /* synthetic */ zzbqw zzghi;
    private final /* synthetic */ zzbrx zzghj;
    private final /* synthetic */ zzbwd zzghk;

    zzcro(zzcrk zzcrk, zzbsu zzbsu, zzbqw zzbqw, zzbrx zzbrx, zzbwd zzbwd) {
        this.zzghh = zzbsu;
        this.zzghi = zzbqw;
        this.zzghj = zzbrx;
        this.zzghk = zzbwd;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzatc zzatc) {
        this.zzghk.zza(zzatc);
    }

    public final void zzaf(IObjectWrapper iObjectWrapper) {
    }

    public final void zzag(IObjectWrapper iObjectWrapper) {
    }

    public final void zzah(IObjectWrapper iObjectWrapper) {
        this.zzghh.zzua();
    }

    public final void zzai(IObjectWrapper iObjectWrapper) {
        this.zzghk.zzsm();
    }

    public final void zzaj(IObjectWrapper iObjectWrapper) {
        this.zzghh.zztz();
    }

    public final void zzak(IObjectWrapper iObjectWrapper) {
        this.zzghi.onAdClicked();
    }

    public final void zzal(IObjectWrapper iObjectWrapper) {
        this.zzghj.onAdLeftApplication();
    }

    public final void zzam(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzghj.onRewardedVideoCompleted();
    }

    public final void zzb(Bundle bundle) {
    }

    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
    }

    public final void zze(IObjectWrapper iObjectWrapper, int i) {
    }
}
