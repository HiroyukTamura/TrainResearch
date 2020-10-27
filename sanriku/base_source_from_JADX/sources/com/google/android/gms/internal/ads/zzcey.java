package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;

public final class zzcey {
    private final zzazz zzbmo;
    private final zzbes zzbnm;
    private final zzst zzeht;
    private final zzdt zzejl;
    private final zza zzejn;
    private final zzrv zzejp;
    private final zzdhe zzfll;
    /* access modifiers changed from: private */
    public final zzbte zzfxb;
    private final Context zzvf;

    public zzcey(zzbes zzbes, Context context, zzdhe zzdhe, zzdt zzdt, zzazz zzazz, zza zza, zzst zzst, zzbte zzbte, zzbwr zzbwr) {
        this.zzbnm = zzbes;
        this.zzvf = context;
        this.zzfll = zzdhe;
        this.zzejl = zzdt;
        this.zzbmo = zzazz;
        this.zzejn = zza;
        this.zzeht = zzst;
        this.zzfxb = zzbte;
        this.zzejp = zzbwr;
    }

    public final zzbek zza(zzum zzum, boolean z) throws zzbew {
        return zzbes.zza(this.zzvf, zzbfz.zzb(zzum), zzum.zzacf, false, false, this.zzejl, this.zzbmo, (zzaam) null, new zzcfb(this), this.zzejn, this.zzeht, this.zzejp, z);
    }

    public final zzbek zzc(zzum zzum) throws zzbew {
        return zza(zzum, false);
    }
}
