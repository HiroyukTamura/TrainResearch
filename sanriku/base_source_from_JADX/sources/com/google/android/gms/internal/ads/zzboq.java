package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzboq<T> {
    private final Executor executor;
    private final zzckg zzflj;
    private final zzckn zzflk;
    private final zzdhe zzfll;
    private final zzdku zzflm;
    private final zzbju zzfln;
    private final zzcqp<T> zzflo;
    /* access modifiers changed from: private */
    public final zzbtx zzflp;
    @Nullable
    private final zzdha zzflq;
    private final zzclf zzflr;
    private final zzbqc zzfls;

    zzboq(zzckg zzckg, zzckn zzckn, zzdhe zzdhe, zzdku zzdku, zzbju zzbju, zzcqp<T> zzcqp, zzbtx zzbtx, @Nullable zzdha zzdha, zzclf zzclf, zzbqc zzbqc, Executor executor2) {
        this.zzflj = zzckg;
        this.zzflk = zzckn;
        this.zzfll = zzdhe;
        this.zzflm = zzdku;
        this.zzfln = zzbju;
        this.zzflo = zzcqp;
        this.zzflp = zzbtx;
        this.zzflq = zzdha;
        this.zzflr = zzclf;
        this.zzfls = zzbqc;
        this.executor = executor2;
    }

    private final zzdri<zzdha> zza(zzdri<zzarj> zzdri) {
        zzdkm<O2> zza;
        zzdkk zzu;
        zzdri zzaos;
        if (this.zzflq != null) {
            zzu = this.zzflm.zzu(zzdkr.SERVER_TRANSACTION);
            zzaos = zzdqw.zzag(this.zzflq);
        } else {
            zzq.zzlc().zzmu();
            if (this.zzfll.zzguw.zzceu != null) {
                zzu = this.zzflm.zzu(zzdkr.SERVER_TRANSACTION);
                zzaos = this.zzflk.zzaos();
            } else {
                zza = this.zzflm.zza(zzdkr.SERVER_TRANSACTION, zzdri).zza(this.zzflj);
                return zza.zzaud();
            }
        }
        zza = zzu.zze(zzaos);
        return zza.zzaud();
    }

    public final zzdri<zzdha> zza(@NonNull zzarj zzarj) {
        return zza((zzdri<zzarj>) zzdqw.zzag(zzarj));
    }

    public final zzdri<zzarj> zza(zzdir zzdir) {
        zzdkd<E, O2> zzaud = this.zzflm.zza(zzdkr.GET_CACHE_KEY, this.zzfls.zzail()).zza(new zzbot(this, zzdir)).zzaud();
        zzdqw.zza(zzaud, new zzbos(this), this.executor);
        return zzaud;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(zzdir zzdir, zzarj zzarj) throws Exception {
        zzarj.zzdph = zzdir;
        return this.zzflr.zzj(zzarj);
    }

    public final zzdri<zzdha> zzaih() {
        return zza(this.zzfls.zzail());
    }

    public final zzdri<T> zzaii() {
        return zzb(zzaih());
    }

    public final zzbtx zzaij() {
        return this.zzflp;
    }

    public final zzdri<T> zzb(@NonNull zzarj zzarj) {
        return zzb(zza(zzarj));
    }

    public final zzdri<T> zzb(zzdri<zzdha> zzdri) {
        zzdkm<O2> zza;
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcrq)).booleanValue()) {
            zza = this.zzflm.zza(zzdkr.RENDERER, zzdri).zza(this.zzfln).zza(this.zzflo);
        } else {
            zza = this.zzflm.zza(zzdkr.RENDERER, zzdri).zza(this.zzfln).zza(this.zzflo).zza((long) ((Integer) zzvj.zzpv().zzd(zzzz.zzcrr)).intValue(), TimeUnit.SECONDS);
        }
        return zza.zzaud();
    }

    public final zzdri<Void> zzc(zzarj zzarj) {
        zzdkd<E, I> zzaud = this.zzflm.zza(zzdkr.NOTIFY_CACHE_HIT, this.zzflr.zzk(zzarj)).zzaud();
        zzdqw.zza(zzaud, new zzbov(this), this.executor);
        return zzaud;
    }
}
