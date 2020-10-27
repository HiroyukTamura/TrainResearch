package com.google.android.gms.internal.ads;

final class zzdde implements zzdqx<zzblr> {
    private final /* synthetic */ zzctz zzgkk;
    private final /* synthetic */ zzddd zzgqg;
    private final /* synthetic */ zzdcz zzgqh;

    zzdde(zzdcz zzdcz, zzctz zzctz, zzddd zzddd) {
        this.zzgqh = zzdcz;
        this.zzgkk = zzctz;
        this.zzgqg = zzddd;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzblr zzblr = (zzblr) obj;
        synchronized (this.zzgqh) {
            zzdri unused = this.zzgqh.zzgjl = null;
            this.zzgkk.onSuccess(zzblr);
        }
    }

    public final void zzb(Throwable th) {
        synchronized (this.zzgqh) {
            zzdri unused = this.zzgqh.zzgjl = null;
            zzbll zzbll = (zzbll) this.zzgqh.zzgqe.zzarj();
            if (zzbll != null) {
                zzbll.zzaee().onAdFailedToLoad(zzcjk.zzd(th));
            } else {
                this.zzgqh.zzgqd.onAdFailedToLoad(zzcjk.zzd(th));
                this.zzgqh.zzb((zzdet) this.zzgqg).zzaes().zzaed().zzaij().zzaja();
            }
            zzdhn.zzc(th, "AppOpenAdLoader.onFailure");
            this.zzgkk.zzapn();
        }
    }
}
