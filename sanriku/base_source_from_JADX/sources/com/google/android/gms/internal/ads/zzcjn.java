package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public final class zzcjn {
    private final zzdrh zzfur;
    private final zzdrh zzgav;
    private final zzckr zzgaw;
    private final zzegt<zzclo> zzgax;

    public zzcjn(zzdrh zzdrh, zzdrh zzdrh2, zzckr zzckr, zzegt<zzclo> zzegt) {
        this.zzgav = zzdrh;
        this.zzfur = zzdrh2;
        this.zzgaw = zzckr;
        this.zzgax = zzegt;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(zzarj zzarj, int i, zzclc zzclc) throws Exception {
        return this.zzgax.get().zzb(zzarj, i);
    }

    public final zzdri<InputStream> zze(zzarj zzarj) {
        String str = zzarj.packageName;
        zzq.zzkw();
        return zzdqw.zzb(zzaxa.zzep(str) ? zzdqw.immediateFailedFuture(new zzclc(0)) : zzdqw.zzb(this.zzgav.zzd(new zzcjm(this, zzarj)), ExecutionException.class, zzcjp.zzbly, this.zzfur), zzclc.class, new zzcjo(this, zzarj, Binder.getCallingUid()), this.zzfur);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzf(zzarj zzarj) throws Exception {
        return this.zzgaw.zzg(zzarj).get((long) ((Integer) zzvj.zzpv().zzd(zzzz.zzcrr)).intValue(), TimeUnit.SECONDS);
    }
}
