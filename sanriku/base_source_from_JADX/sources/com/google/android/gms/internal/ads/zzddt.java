package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbns;
import com.google.android.gms.internal.ads.zzbqh;
import java.util.concurrent.Executor;

public final class zzddt<R extends zzbqh<AdT>, AdT extends zzbns> implements zzdeu<R, zzdiv<AdT>> {
    private final Executor executor = zzdrk.zzawr();
    private R zzgre;

    public final zzdri<zzdiv<AdT>> zza(zzdev zzdev, zzdew<R> zzdew) {
        zzbqg<R> zzc = zzdew.zzc(zzdev.zzgsi);
        zzc.zza(new zzdfa(true));
        R r = (zzbqh) zzc.zzaeg();
        this.zzgre = r;
        zzboq zzaed = r.zzaed();
        zzdiv zzdiv = new zzdiv();
        zzarj zzarj = zzdev.zzgsh;
        return zzdqr.zzg(zzarj != null ? zzaed.zza(zzarj) : zzaed.zzaih()).zzb(new zzddw(this, zzdiv, zzaed), this.executor).zza(new zzddv(zzdiv), this.executor);
    }

    public final /* synthetic */ Object zzarj() {
        return this.zzgre;
    }
}
