package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbns;
import com.google.android.gms.internal.ads.zzbqh;
import com.google.android.gms.internal.ads.zztf;
import java.util.concurrent.Executor;

public final class zzddy<R extends zzbqh<AdT>, AdT extends zzbns> implements zzdeu<R, AdT> {
    private final Executor executor;
    private final zzdeu<R, AdT> zzgqe;
    private final zzdeu<R, zzdeh<AdT>> zzgro;
    private final zzdjd<AdT> zzgrp;
    private R zzgrq;

    public zzddy(zzdeu<R, AdT> zzdeu, zzdeu<R, zzdeh<AdT>> zzdeu2, zzdjd<AdT> zzdjd, Executor executor2) {
        this.zzgqe = zzdeu;
        this.zzgro = zzdeu2;
        this.zzgrp = zzdjd;
        this.executor = executor2;
    }

    private final zzdri<AdT> zza(zzdiv<AdT> zzdiv, zzdev zzdev, zzdew<R> zzdew) {
        zzbqg<R> zzc = zzdew.zzc(zzdev.zzgsi);
        if (zzdiv.zzgxu != null) {
            zzdiv.zzgxu.zzaib().zzb(((zzbqh) zzc.zzaeg()).zzafb());
            return zzdqw.zzag(zzdiv.zzgxu);
        }
        zzc.zza(zzdiv.zzepv);
        zzdri<AdT> zza = this.zzgqe.zza(zzdev, new zzdea(zzc));
        this.zzgrq = (zzbqh) this.zzgqe.zzarj();
        return zza;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzark */
    public final synchronized R zzarj() {
        return this.zzgrq;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(zzdev zzdev, zzdeb zzdeb, zzdew zzdew, zzdeh zzdeh) throws Exception {
        if (zzdeh != null) {
            zzdeb zzdeb2 = new zzdeb(zzdeb.zzgrt, zzdeb.zzgru, zzdeb.zzdlx, zzdeb.zzbsc, zzdeb.executor, zzdeb.zzgmd, zzdeh.zzgrv);
            if (zzdeh.zzgsc != null) {
                this.zzgrq = null;
                this.zzgrp.zzb((zzdjj) zzdeb2);
                return zza(zzdeh.zzgsc, zzdev, zzdew);
            }
            zzdri<zzdjh<AdT>> zzc = this.zzgrp.zzc((zzdjj) zzdeb2);
            if (zzc != null) {
                this.zzgrq = (zzbqh) zzdew.zzc(zzdev.zzgsi).zzaeg();
                return zzdqw.zzb(zzc, new zzddz(this, zzdew), this.executor);
            }
            this.zzgrp.zzb((zzdjj) zzdeb2);
            zzdev = new zzdev(zzdev.zzgsi, zzdeh.zzgbt);
        }
        zzdri<AdT> zza = this.zzgqe.zza(zzdev, zzdew);
        this.zzgrq = (zzbqh) this.zzgqe.zzarj();
        return zza;
    }

    public final synchronized zzdri<AdT> zza(zzdev zzdev, zzdew<R> zzdew) {
        zzdhe zzafa;
        zzdew<R> zzdew2;
        zzdev zzdev2;
        zzafa = ((zzbqh) zzdew.zzc(zzdev.zzgsi).zzaeg()).zzafa();
        zzdew2 = zzdew;
        zzdev2 = zzdev;
        return zzdqr.zzg(this.zzgro.zza(zzdev, zzdew)).zzb(new zzddx(this, zzdev, new zzdeb(zzdew2, zzdev2, zzafa.zzguw, zzafa.zzgux, this.executor, zzafa.zzgva, (zzdiy) null), zzdew), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(zzdew zzdew, zzdjh zzdjh) throws Exception {
        zzdjj zzdjj;
        if (zzdjh == null || zzdjh.zzgsc == null || (zzdjj = zzdjh.zzgyj) == null) {
            throw new zzclp("Empty prefetch");
        }
        zzdjh.zzgsc.zzgxt.zzaij().zze((zztf.zzb) ((zzecd) zztf.zzb.zznf().zza(zztf.zzb.zza.zznh().zza(zztf.zzb.C2671zzb.IN_MEMORY).zza(zztf.zzb.zzd.zznj())).zzbet()));
        return zza(zzdjh.zzgsc, ((zzdeb) zzdjj).zzgru, zzdew);
    }
}
