package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;

final class zzep implements Runnable {
    private final /* synthetic */ int zzyx;
    private final /* synthetic */ boolean zzyy;
    private final /* synthetic */ zzeo zzyz;

    zzep(zzeo zzeo, int i, boolean z) {
        this.zzyz = zzeo;
        this.zzyx = i;
        this.zzyy = z;
    }

    public final void run() {
        zzbv.zza zzb = this.zzyz.zzb(this.zzyx, this.zzyy);
        zzbv.zza unused = this.zzyz.zzyq = zzb;
        if (zzeo.zza(this.zzyx, zzb)) {
            this.zzyz.zza(this.zzyx + 1, this.zzyy);
        }
    }
}
