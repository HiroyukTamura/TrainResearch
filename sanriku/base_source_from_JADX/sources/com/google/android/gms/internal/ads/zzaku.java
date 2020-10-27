package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzaku {
    private zzajf zzdeg;
    private zzdri<zzakd> zzdeh;

    zzaku(zzajf zzajf) {
        this.zzdeg = zzajf;
    }

    private final void zztd() {
        if (this.zzdeh == null) {
            zzbaj zzbaj = new zzbaj();
            this.zzdeh = zzbaj;
            this.zzdeg.zzb((zzdt) null).zza(new zzakx(zzbaj), new zzakw(zzbaj));
        }
    }

    public final <I, O> zzalb<I, O> zzb(String str, zzaki<I> zzaki, zzakj<O> zzakj) {
        zztd();
        return new zzalb<>(this.zzdeh, str, zzaki, zzakj);
    }

    public final void zzc(String str, zzaga<? super zzakd> zzaga) {
        zztd();
        this.zzdeh = zzdqw.zzb(this.zzdeh, new zzakz(str, zzaga), (Executor) zzbab.zzdzw);
    }

    public final void zzd(String str, zzaga<? super zzakd> zzaga) {
        this.zzdeh = zzdqw.zzb(this.zzdeh, new zzaky(str, zzaga), (Executor) zzbab.zzdzw);
    }
}
