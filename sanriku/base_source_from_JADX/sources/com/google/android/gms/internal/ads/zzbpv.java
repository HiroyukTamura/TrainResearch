package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

public final class zzbpv implements zzbtm {
    private final zzazz zzbml;
    private final zzawt zzduw;
    private final zzciz zzffr;
    private final zzdhe zzfll;
    private final Context zzzo;

    public zzbpv(Context context, zzdhe zzdhe, zzazz zzazz, zzawt zzawt, zzciz zzciz) {
        this.zzzo = context;
        this.zzfll = zzdhe;
        this.zzbml = zzazz;
        this.zzduw = zzawt;
        this.zzffr = zzciz;
    }

    public final void zzb(zzdha zzdha) {
    }

    public final void zzd(zzarj zzarj) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcpk)).booleanValue()) {
            zzq.zzle().zza(this.zzzo, this.zzbml, this.zzfll.zzgux, this.zzduw.zzww());
        }
        this.zzffr.zzaog();
    }
}
