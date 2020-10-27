package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zztf;
import java.util.HashMap;

public final class zzbyb implements zzo, zzbsm {
    private final zzazz zzbmo;
    @Nullable
    private final zzbek zzdce;
    private final zzdgo zzfkd;
    @Nullable
    @VisibleForTesting
    private IObjectWrapper zzfke;
    private final zztf.zza.C2669zza zzfpf;
    private final Context zzvf;

    public zzbyb(Context context, @Nullable zzbek zzbek, zzdgo zzdgo, zzazz zzazz, zztf.zza.C2669zza zza) {
        this.zzvf = context;
        this.zzdce = zzbek;
        this.zzfkd = zzdgo;
        this.zzbmo = zzazz;
        this.zzfpf = zza;
    }

    public final void onAdLoaded() {
        zztf.zza.C2669zza zza = this.zzfpf;
        if ((zza == zztf.zza.C2669zza.REWARD_BASED_VIDEO_AD || zza == zztf.zza.C2669zza.INTERSTITIAL) && this.zzfkd.zzdos && this.zzdce != null && zzq.zzll().zzo(this.zzvf)) {
            zzazz zzazz = this.zzbmo;
            int i = zzazz.zzdzn;
            int i2 = zzazz.zzdzo;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(".");
            sb.append(i2);
            IObjectWrapper zza2 = zzq.zzll().zza(sb.toString(), this.zzdce.getWebView(), "", "javascript", this.zzfkd.zzgua.optInt("media_type", -1) == 0 ? null : "javascript");
            this.zzfke = zza2;
            if (zza2 != null && this.zzdce.getView() != null) {
                zzq.zzll().zza(this.zzfke, this.zzdce.getView());
                this.zzdce.zzap(this.zzfke);
                zzq.zzll().zzab(this.zzfke);
            }
        }
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void zztz() {
        this.zzfke = null;
    }

    public final void zzua() {
        zzbek zzbek;
        if (this.zzfke != null && (zzbek = this.zzdce) != null) {
            zzbek.zza("onSdkImpression", new HashMap());
        }
    }
}
