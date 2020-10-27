package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

final class zzcji extends zzahf {
    private final /* synthetic */ zzciz zzgal;
    private final /* synthetic */ Object zzgam;
    private final /* synthetic */ String zzgan;
    private final /* synthetic */ long zzgao;
    private final /* synthetic */ zzbaj zzgap;

    zzcji(zzciz zzciz, Object obj, String str, long j, zzbaj zzbaj) {
        this.zzgal = zzciz;
        this.zzgam = obj;
        this.zzgan = str;
        this.zzgao = j;
        this.zzgap = zzbaj;
    }

    public final void onInitializationFailed(String str) {
        synchronized (this.zzgam) {
            this.zzgal.zza(this.zzgan, false, str, (int) (zzq.zzld().elapsedRealtime() - this.zzgao));
            this.zzgal.zzgad.zzr(this.zzgan, "error");
            this.zzgap.set(false);
        }
    }

    public final void onInitializationSucceeded() {
        synchronized (this.zzgam) {
            this.zzgal.zza(this.zzgan, true, "", (int) (zzq.zzld().elapsedRealtime() - this.zzgao));
            this.zzgal.zzgad.zzgi(this.zzgan);
            this.zzgap.set(true);
        }
    }
}
