package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzawn;
import com.google.android.gms.internal.ads.zzaxa;
import com.google.android.gms.internal.ads.zzaxf;

final class zzl extends zzawn {
    final /* synthetic */ zzc zzdkr;

    private zzl(zzc zzc) {
        this.zzdkr = zzc;
    }

    public final void zzup() {
        Bitmap zza = zzq.zzlp().zza(Integer.valueOf(this.zzdkr.zzdjq.zzdla.zzbme));
        if (zza != null) {
            zzaxf zzky = zzq.zzky();
            zzc zzc = this.zzdkr;
            Activity activity = zzc.zzaad;
            zzg zzg = zzc.zzdjq.zzdla;
            zzaxa.zzdwf.post(new zzk(this, zzky.zza(activity, zza, zzg.zzbmc, zzg.zzbmd)));
        }
    }
}
