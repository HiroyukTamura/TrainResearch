package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zzq;

final class zzaon implements Runnable {
    private final /* synthetic */ zzaol zzdhz;
    private final /* synthetic */ AdOverlayInfoParcel zzdih;

    zzaon(zzaol zzaol, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdhz = zzaol;
        this.zzdih = adOverlayInfoParcel;
    }

    public final void run() {
        zzq.zzkv();
        zzn.zza(this.zzdhz.zzdia, this.zzdih, true);
    }
}
