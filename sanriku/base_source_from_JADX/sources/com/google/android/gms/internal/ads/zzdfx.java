package com.google.android.gms.internal.ads;

final class zzdfx implements zzdqx<zzcel> {
    private final /* synthetic */ zzctz zzgkk;
    private final /* synthetic */ zzdga zzgsv;
    private final /* synthetic */ zzdfw zzgsw;

    zzdfx(zzdfw zzdfw, zzctz zzctz, zzdga zzdga) {
        this.zzgsw = zzdfw;
        this.zzgkk = zzctz;
        this.zzgsv = zzdga;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzcel zzcel = (zzcel) obj;
        synchronized (this.zzgsw) {
            this.zzgkk.onSuccess(zzcel);
            this.zzgsw.zzgst.onAdMetadataChanged();
        }
    }

    public final void zzb(Throwable th) {
        synchronized (this.zzgsw) {
            zzceo zzceo = (zzceo) this.zzgsw.zzgqe.zzarj();
            if (zzceo != null) {
                zzceo.zzaee().onAdFailedToLoad(zzcjk.zzd(th));
            } else {
                this.zzgsw.zzgst.onAdFailedToLoad(zzcjk.zzd(th));
                this.zzgsw.zze(this.zzgsv).zzafu().zzaed().zzaij().zzaja();
            }
            zzdhn.zzc(th, "RewardedAdLoader.onFailure");
            this.zzgkk.zzapn();
        }
    }
}
