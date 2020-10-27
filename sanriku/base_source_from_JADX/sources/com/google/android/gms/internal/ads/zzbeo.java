package com.google.android.gms.internal.ads;

import android.view.View;

final class zzbeo implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzaun zzeij;
    private final /* synthetic */ zzbej zzeik;
    private final /* synthetic */ int zzeil;

    zzbeo(zzbej zzbej, View view, zzaun zzaun, int i) {
        this.zzeik = zzbej;
        this.val$view = view;
        this.zzeij = zzaun;
        this.zzeil = i;
    }

    public final void run() {
        this.zzeik.zza(this.val$view, this.zzeij, this.zzeil - 1);
    }
}
