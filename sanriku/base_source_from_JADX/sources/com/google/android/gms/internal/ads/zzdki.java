package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

public final class zzdki {
    private final E zzgyz;
    private final List<zzdri<?>> zzgze;
    private final /* synthetic */ zzdkg zzgzf;

    private zzdki(zzdkg zzdkg, E e, List<zzdri<?>> list) {
        this.zzgzf = zzdkg;
        this.zzgyz = e;
        this.zzgze = list;
    }

    public final <O> zzdkm<O> zzb(Callable<O> callable) {
        zzdrb<V> zzk = zzdqw.zzk(this.zzgze);
        zzdri<C> zza = zzk.zza(zzdkh.zzgnf, zzbab.zzdzw);
        zzdkg zzdkg = this.zzgzf;
        return new zzdkm(zzdkg, this.zzgyz, (String) null, zza, this.zzgze, zzk.zza(callable, zzdkg.zzfur), (zzdkf) null);
    }
}
