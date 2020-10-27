package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public final class zzbke implements zzbqx, zzbrp, zzbsm, zzub {
    @Nullable
    private final View view;
    private final zzdha zzfgj;
    private final zzdgo zzfgk;
    private final zzdld zzfgl;
    private final zzdt zzfgm;
    private boolean zzfgn;
    private boolean zzfgo;
    private final Context zzvf;

    public zzbke(Context context, zzdha zzdha, zzdgo zzdgo, zzdld zzdld, @Nullable View view2, zzdt zzdt) {
        this.zzvf = context;
        this.zzfgj = zzdha;
        this.zzfgk = zzdgo;
        this.zzfgl = zzdld;
        this.zzfgm = zzdt;
        this.view = view2;
    }

    public final void onAdClicked() {
        zzdld zzdld = this.zzfgl;
        zzdha zzdha = this.zzfgj;
        zzdgo zzdgo = this.zzfgk;
        zzdld.zza(zzdha, zzdgo, zzdgo.zzdeu);
    }

    public final void onAdClosed() {
    }

    public final synchronized void onAdImpression() {
        if (!this.zzfgo) {
            String str = null;
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcol)).booleanValue()) {
                str = this.zzfgm.zzcb().zza(this.zzvf, this.view, (Activity) null);
            }
            this.zzfgl.zza(this.zzfgj, this.zzfgk, false, str, this.zzfgk.zzdev);
            this.zzfgo = true;
        }
    }

    public final void onAdLeftApplication() {
    }

    public final synchronized void onAdLoaded() {
        if (this.zzfgn) {
            ArrayList arrayList = new ArrayList(this.zzfgk.zzdev);
            arrayList.addAll(this.zzfgk.zzgtn);
            this.zzfgl.zza(this.zzfgj, this.zzfgk, true, (String) null, arrayList);
        } else {
            this.zzfgl.zza(this.zzfgj, this.zzfgk, this.zzfgk.zzgtp);
            this.zzfgl.zza(this.zzfgj, this.zzfgk, this.zzfgk.zzgtn);
        }
        this.zzfgn = true;
    }

    public final void onAdOpened() {
    }

    public final void onRewardedVideoCompleted() {
        zzdld zzdld = this.zzfgl;
        zzdha zzdha = this.zzfgj;
        zzdgo zzdgo = this.zzfgk;
        zzdld.zza(zzdha, zzdgo, zzdgo.zzgto);
    }

    public final void onRewardedVideoStarted() {
        zzdld zzdld = this.zzfgl;
        zzdha zzdha = this.zzfgj;
        zzdgo zzdgo = this.zzfgk;
        zzdld.zza(zzdha, zzdgo, zzdgo.zzdoj);
    }

    public final void zzb(zzasd zzasd, String str, String str2) {
        zzdld zzdld = this.zzfgl;
        zzdha zzdha = this.zzfgj;
        zzdgo zzdgo = this.zzfgk;
        zzdld.zza(zzdha, zzdgo, zzdgo.zzdok, zzasd);
    }
}
