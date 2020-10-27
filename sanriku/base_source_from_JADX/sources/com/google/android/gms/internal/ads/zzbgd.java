package com.google.android.gms.internal.ads;

import android.view.View;

final class zzbgd implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzaun zzeij;
    private final /* synthetic */ zzbgc zzelm;

    zzbgd(zzbgc zzbgc, zzaun zzaun) {
        this.zzelm = zzbgc;
        this.zzeij = zzaun;
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzelm.zza(view, this.zzeij, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
