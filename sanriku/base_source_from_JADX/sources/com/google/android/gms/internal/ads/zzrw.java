package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

public final class zzrw {
    @AppOpenAd.AppOpenAdOrientation
    private final int orientation;
    private final zzuk zzaca;
    private final zzxt zzacc;
    private zzvz zzbsb;
    private final String zzbsc;
    private final AppOpenAd.AppOpenAdLoadCallback zzbsd;
    private final zzalm zzbse = new zzalm();
    private final Context zzvf;

    public zzrw(Context context, String str, zzxt zzxt, @AppOpenAd.AppOpenAdOrientation int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzvf = context;
        this.zzbsc = str;
        this.zzacc = zzxt;
        this.orientation = i;
        this.zzbsd = appOpenAdLoadCallback;
        this.zzaca = zzuk.zzcev;
    }

    public final void zzmt() {
        try {
            this.zzbsb = zzvj.zzps().zza(this.zzvf, zzum.zzpj(), this.zzbsc, this.zzbse);
            this.zzbsb.zza(new zzut(this.orientation));
            this.zzbsb.zza((zzrn) new zzrk(this.zzbsd));
            this.zzbsb.zza(zzuk.zza(this.zzvf, this.zzacc));
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }
}
