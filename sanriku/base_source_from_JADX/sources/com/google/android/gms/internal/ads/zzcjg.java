package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

final class zzcjg implements zzdqx<String> {
    final /* synthetic */ zzciz zzgal;

    zzcjg(zzciz zzciz) {
        this.zzgal = zzciz;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        String str = (String) obj;
        synchronized (this) {
            boolean unused = this.zzgal.zzfzy = true;
            this.zzgal.zza("com.google.android.gms.ads.MobileAds", true, "", (int) (zzq.zzld().elapsedRealtime() - this.zzgal.zzfzz));
            this.zzgal.executor.execute(new zzcjj(this, str));
        }
    }

    public final void zzb(Throwable th) {
        synchronized (this) {
            boolean unused = this.zzgal.zzfzy = true;
            this.zzgal.zza("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (zzq.zzld().elapsedRealtime() - this.zzgal.zzfzz));
            this.zzgal.zzgaa.setException(new Exception());
        }
    }
}
