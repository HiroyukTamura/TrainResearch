package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

final class zzdq implements Runnable {
    private final /* synthetic */ Context zzxa;
    private final /* synthetic */ View zzxc;
    private final /* synthetic */ Activity zzxd;

    zzdq(zzdl zzdl, Context context, View view, Activity activity) {
        this.zzxa = context;
        this.zzxc = view;
        this.zzxd = activity;
    }

    public final void run() {
        try {
            zzdl.zzvw.zza(this.zzxa, this.zzxc, this.zzxd);
        } catch (Exception e) {
            zzdl.zzvy.zza(2020, -1, e);
        }
    }
}
