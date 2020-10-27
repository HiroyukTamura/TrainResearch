package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

final class zzcbu implements zzdnx<zzo, Bitmap> {
    private final /* synthetic */ double zzfun;
    private final /* synthetic */ boolean zzfuo;
    private final /* synthetic */ zzcbv zzfup;

    zzcbu(zzcbv zzcbv, double d, boolean z) {
        this.zzfup = zzcbv;
        this.zzfun = d;
        this.zzfuo = z;
    }

    public final /* synthetic */ Object apply(Object obj) {
        return this.zzfup.zza(((zzo) obj).data, this.zzfun, this.zzfuo);
    }
}
