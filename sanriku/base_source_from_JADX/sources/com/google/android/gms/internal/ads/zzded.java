package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbns;
import com.google.android.gms.internal.ads.zzbqh;
import java.util.concurrent.Executor;

public final class zzded<R extends zzbqh<AdT>, AdT extends zzbns> implements zzdeu<R, zzdeh<AdT>> {
    private final Executor executor;
    private final zzdio zzgrx;
    private zzdqx<Void> zzgry = new zzdei(this);

    public zzded(zzdio zzdio, Executor executor2) {
        this.zzgrx = zzdio;
        this.executor = executor2;
    }

    public final zzdri<zzdeh<AdT>> zza(zzdev zzdev, zzdew<R> zzdew) {
        return zzdqr.zzg(new zzdeo(this.zzgrx, zzdev.zzgsi, zzdew, this.executor).zzaro()).zzb(new zzdeg(this, zzdev, zzdew), this.executor).zza(Exception.class, new zzdef(this), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(zzdev zzdev, zzdew zzdew, zzdes zzdes) throws Exception {
        zzdiy zzdiy = zzdes.zzgrv;
        zzarj zzarj = zzdes.zzgbt;
        zzdiv<?> zza = zzdiy != null ? this.zzgrx.zza(zzdiy) : null;
        if (zzdiy == null) {
            return zzdqw.zzag(null);
        }
        if (!(zza == null || zzarj == null)) {
            zzdqw.zza(((zzbqh) zzdew.zzc(zzdev.zzgsi).zzaeg()).zzaed().zzc(zzarj), this.zzgry, this.executor);
        }
        return zzdqw.zzag(new zzdeh(zzdiy, zzarj, zza));
    }

    public final /* bridge */ /* synthetic */ Object zzarj() {
        return null;
    }
}
