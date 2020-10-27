package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

public final class zzcmw implements zzdla {
    private final zzcmv zzgdr;

    zzcmw(zzcmv zzcmv) {
        this.zzgdr = zzcmv;
    }

    public final void zza(zzdkr zzdkr, String str) {
    }

    public final void zza(zzdkr zzdkr, String str, Throwable th) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsz)).booleanValue() && zzdkr.RENDERER == zzdkr && this.zzgdr.zzaoz() != 0) {
            this.zzgdr.zzer(zzq.zzld().elapsedRealtime() - this.zzgdr.zzaoz());
        }
    }

    public final void zzb(zzdkr zzdkr, String str) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsz)).booleanValue() && zzdkr.RENDERER == zzdkr) {
            this.zzgdr.zzff(zzq.zzld().elapsedRealtime());
        }
    }

    public final void zzc(zzdkr zzdkr, String str) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsz)).booleanValue() && zzdkr.RENDERER == zzdkr && this.zzgdr.zzaoz() != 0) {
            this.zzgdr.zzer(zzq.zzld().elapsedRealtime() - this.zzgdr.zzaoz());
        }
    }
}
