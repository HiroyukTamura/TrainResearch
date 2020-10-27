package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnFailureListener;

final /* synthetic */ class zzdmc implements OnFailureListener {
    private final zzdma zzhbq;

    zzdmc(zzdma zzdma) {
        this.zzhbq = zzdma;
    }

    public final void onFailure(Exception exc) {
        this.zzhbq.zze(exc);
    }
}
