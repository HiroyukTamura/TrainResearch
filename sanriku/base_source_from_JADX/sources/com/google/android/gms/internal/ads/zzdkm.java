package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzdkm<O> {
    private final E zzgyz;
    @Nullable
    private final String zzgza;
    private final List<zzdri<?>> zzgze;
    final /* synthetic */ zzdkg zzgzf;
    private final zzdri<?> zzgzi;
    private final zzdri<O> zzgzj;

    private zzdkm(zzdkg zzdkg, E e, String str, zzdri<?> zzdri, List<zzdri<?>> list, zzdri<O> zzdri2) {
        this.zzgzf = zzdkg;
        this.zzgyz = e;
        this.zzgza = str;
        this.zzgzi = zzdri;
        this.zzgze = list;
        this.zzgzj = zzdri2;
    }

    /* synthetic */ zzdkm(zzdkg zzdkg, Object obj, String str, zzdri zzdri, List list, zzdri zzdri2, zzdkf zzdkf) {
        this(zzdkg, obj, (String) null, zzdri, list, zzdri2);
    }

    private final <O2> zzdkm<O2> zza(zzdqj<O, O2> zzdqj, Executor executor) {
        return new zzdkm(this.zzgzf, this.zzgyz, this.zzgza, this.zzgzi, this.zzgze, zzdqw.zzb(this.zzgzj, zzdqj, executor));
    }

    public final zzdkm<O> zza(long j, TimeUnit timeUnit) {
        zzdkg zzdkg = this.zzgzf;
        return new zzdkm(zzdkg, this.zzgyz, this.zzgza, this.zzgzi, this.zzgze, zzdqw.zza(this.zzgzj, j, timeUnit, zzdkg.zzfif));
    }

    public final <O2> zzdkm<O2> zza(zzdqj<O, O2> zzdqj) {
        return zza(zzdqj, (Executor) this.zzgzf.zzfur);
    }

    public final <T extends Throwable> zzdkm<O> zza(Class<T> cls, zzdkb<T, O> zzdkb) {
        return zza(cls, new zzdkn(zzdkb));
    }

    public final <T extends Throwable> zzdkm<O> zza(Class<T> cls, zzdqj<T, O> zzdqj) {
        zzdkg zzdkg = this.zzgzf;
        return new zzdkm(zzdkg, this.zzgyz, this.zzgza, this.zzgzi, this.zzgze, zzdqw.zzb(this.zzgzj, cls, zzdqj, zzdkg.zzfur));
    }

    public final zzdkd<E, O> zzaud() {
        E e = this.zzgyz;
        String str = this.zzgza;
        if (str == null) {
            str = this.zzgzf.zzv(e);
        }
        zzdkd<E, O> zzdkd = new zzdkd<>(e, str, this.zzgzj);
        this.zzgzf.zzgzd.zza(zzdkd);
        this.zzgzi.addListener(new zzdkq(this, zzdkd), zzbab.zzdzw);
        zzdqw.zza(zzdkd, new zzdkp(this, zzdkd), zzbab.zzdzw);
        return zzdkd;
    }

    public final <O2> zzdkm<O2> zzb(zzdkb<O, O2> zzdkb) {
        return zza(new zzdkl(zzdkb));
    }

    public final <O2> zzdkm<O2> zze(zzdri<O2> zzdri) {
        return zza(new zzdko(zzdri), (Executor) zzbab.zzdzw);
    }

    public final zzdkm<O> zzgv(String str) {
        return new zzdkm(this.zzgzf, this.zzgyz, str, this.zzgzi, this.zzgze, this.zzgzj);
    }

    public final zzdkm<O> zzw(E e) {
        return this.zzgzf.zza(e, zzaud());
    }
}
