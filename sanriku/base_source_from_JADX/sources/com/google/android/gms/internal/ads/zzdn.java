package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzdn implements Runnable {
    private final /* synthetic */ Context zzxa;

    zzdn(zzdl zzdl, Context context) {
        this.zzxa = context;
    }

    public final void run() {
        try {
            zzdl.zzvw.zzb(this.zzxa);
        } catch (Exception e) {
            zzdl.zzvy.zza(2019, -1, e);
        }
    }
}
