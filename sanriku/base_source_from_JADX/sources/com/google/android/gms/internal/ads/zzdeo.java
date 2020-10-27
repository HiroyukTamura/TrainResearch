package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqh;
import java.util.concurrent.Executor;

final class zzdeo<R extends zzbqh<? extends zzbns>> {
    private final Executor executor;
    private final zzdew<R> zzgrt;
    private final zzdio zzgrx;
    private final zzdet zzgse;
    /* access modifiers changed from: private */
    public zzdes zzgsf;

    public zzdeo(zzdio zzdio, zzdet zzdet, zzdew<R> zzdew, Executor executor2) {
        this.zzgrx = zzdio;
        this.zzgse = zzdet;
        this.zzgrt = zzdew;
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    @Deprecated
    public final zzdiy zzarp() {
        zzdhe zzafa = ((zzbqh) this.zzgrt.zzc(this.zzgse).zzaeg()).zzafa();
        return this.zzgrx.zza(zzafa.zzguw, zzafa.zzgux, zzafa.zzgva);
    }

    public final zzdri<zzdes> zzaro() {
        zzdri zzdri;
        zzdes zzdes = this.zzgsf;
        if (zzdes != null) {
            return zzdqw.zzag(zzdes);
        }
        if (!zzabo.zzcxc.get().booleanValue()) {
            zzdes zzdes2 = new zzdes((zzarj) null, zzarp(), (zzdeq) null);
            this.zzgsf = zzdes2;
            zzdri = zzdqw.zzag(zzdes2);
        } else {
            zzdri = zzdqr.zzg(((zzbqh) this.zzgrt.zzc(this.zzgse).zza(new zzdee(this.zzgrx.zzasr().zzgwy)).zzaeg()).zzaed().zza(this.zzgrx.zzasr())).zza(new zzdep(this), this.executor).zza(zzclc.class, new zzdeq(this), this.executor);
        }
        return zzdqw.zzb(zzdri, zzden.zzdsc, this.executor);
    }
}
