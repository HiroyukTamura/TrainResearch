package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zztf;

public final class zzbyh implements zzbqx, zzbvi {
    @Nullable
    private final View view;
    private final zzauu zzboj;
    private final zzaur zzfkp;
    private final zztf.zza.C2669zza zzfpf;
    private String zzfpl;
    private final Context zzvf;

    public zzbyh(zzaur zzaur, Context context, zzauu zzauu, @Nullable View view2, zztf.zza.C2669zza zza) {
        this.zzfkp = zzaur;
        this.zzvf = context;
        this.zzboj = zzauu;
        this.view = view2;
        this.zzfpf = zza;
    }

    public final void onAdClosed() {
        this.zzfkp.zzam(false);
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdOpened() {
        View view2 = this.view;
        if (!(view2 == null || this.zzfpl == null)) {
            this.zzboj.zzg(view2.getContext(), this.zzfpl);
        }
        this.zzfkp.zzam(true);
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzajn() {
        String zzad = this.zzboj.zzad(this.zzvf);
        this.zzfpl = zzad;
        String valueOf = String.valueOf(zzad);
        String str = this.zzfpf == zztf.zza.C2669zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial";
        this.zzfpl = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    public final void zzb(zzasd zzasd, String str, String str2) {
        if (this.zzboj.zzab(this.zzvf)) {
            try {
                this.zzboj.zza(this.zzvf, this.zzboj.zzag(this.zzvf), this.zzfkp.getAdUnitId(), zzasd.getType(), zzasd.getAmount());
            } catch (RemoteException e) {
                zzazw.zzd("Remote Exception to get reward item.", e);
            }
        }
    }
}
