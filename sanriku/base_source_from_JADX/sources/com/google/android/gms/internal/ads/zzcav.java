package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

final /* synthetic */ class zzcav implements Runnable {
    private final zzcat zzftn;
    private final ViewGroup zzftt;

    zzcav(zzcat zzcat, ViewGroup viewGroup) {
        this.zzftn = zzcat;
        this.zzftt = viewGroup;
    }

    public final void run() {
        this.zzftn.zzb(this.zzftt);
    }
}
