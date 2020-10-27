package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

final class zzagx implements zzdqj<zzags, ParcelFileDescriptor> {
    private final /* synthetic */ zzagm zzdbe;

    zzagx(zzagu zzagu, zzagm zzagm) {
        this.zzdbe = zzagm;
    }

    public final /* synthetic */ zzdri zzf(Object obj) throws Exception {
        zzbaj zzbaj = new zzbaj();
        ((zzags) obj).zza(this.zzdbe, new zzagw(this, zzbaj));
        return zzbaj;
    }
}
