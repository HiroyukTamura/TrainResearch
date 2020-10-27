package com.google.android.gms.internal.ads;

import android.view.View;

final class zzben implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzaun zzeij;
    private final /* synthetic */ zzbej zzeik;

    zzben(zzbej zzbej, zzaun zzaun) {
        this.zzeik = zzbej;
        this.zzeij = zzaun;
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzeik.zza(view, this.zzeij, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
