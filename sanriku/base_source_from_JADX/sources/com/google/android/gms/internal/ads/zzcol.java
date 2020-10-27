package com.google.android.gms.internal.ads;

import android.net.Uri;

final /* synthetic */ class zzcol implements zzdqj {
    private final Uri zzdwc;
    private final zzcoi zzgfb;
    private final zzdha zzgfc;
    private final zzdgo zzgfd;

    zzcol(zzcoi zzcoi, Uri uri, zzdha zzdha, zzdgo zzdgo) {
        this.zzgfb = zzcoi;
        this.zzdwc = uri;
        this.zzgfc = zzdha;
        this.zzgfd = zzdgo;
    }

    public final zzdri zzf(Object obj) {
        return this.zzgfb.zza(this.zzdwc, this.zzgfc, this.zzgfd, obj);
    }
}
