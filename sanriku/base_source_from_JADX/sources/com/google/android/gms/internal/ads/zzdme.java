package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnFailureListener;

final /* synthetic */ class zzdme implements OnFailureListener {
    private final zzdma zzhbq;

    zzdme(zzdma zzdma) {
        this.zzhbq = zzdma;
    }

    public final void onFailure(Exception exc) {
        this.zzhbq.zzd(exc);
    }
}
