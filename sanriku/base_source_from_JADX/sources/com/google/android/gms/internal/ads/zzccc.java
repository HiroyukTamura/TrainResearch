package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;

final /* synthetic */ class zzccc implements zzdnx {
    private final String zzdcd;
    private final int zzdwu;
    private final int zzdwv;
    private final double zzfvj;

    zzccc(String str, double d, int i, int i2) {
        this.zzdcd = str;
        this.zzfvj = d;
        this.zzdwu = i;
        this.zzdwv = i2;
    }

    public final Object apply(Object obj) {
        String str = this.zzdcd;
        return new zzace(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.zzfvj, this.zzdwu, this.zzdwv);
    }
}
