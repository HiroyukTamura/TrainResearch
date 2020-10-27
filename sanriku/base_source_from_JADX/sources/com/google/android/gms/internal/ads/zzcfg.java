package com.google.android.gms.internal.ads;

import android.graphics.Rect;

final /* synthetic */ class zzcfg implements zzpz {
    private final zzbek zzelg;

    zzcfg(zzbek zzbek) {
        this.zzelg = zzbek;
    }

    public final void zza(zzqa zzqa) {
        zzbfw zzabj = this.zzelg.zzabj();
        Rect rect = zzqa.zzbpe;
        zzabj.zza(rect.left, rect.top, false);
    }
}
