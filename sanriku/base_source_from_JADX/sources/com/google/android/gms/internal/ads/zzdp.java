package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

final class zzdp implements Runnable {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Context zzxa;
    private final /* synthetic */ String zzxb;
    private final /* synthetic */ View zzxc;

    zzdp(zzdl zzdl, Context context, String str, View view, Activity activity) {
        this.zzxa = context;
        this.zzxb = str;
        this.zzxc = view;
        this.val$activity = activity;
    }

    public final void run() {
        try {
            zzdl.zzvw.zza(this.zzxa, this.zzxb, this.zzxc, this.val$activity);
        } catch (Exception e) {
            zzdl.zzvy.zza(2021, -1, e);
        }
    }
}
