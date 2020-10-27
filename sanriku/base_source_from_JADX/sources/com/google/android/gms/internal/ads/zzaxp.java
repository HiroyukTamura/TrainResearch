package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.WindowInsets;

final /* synthetic */ class zzaxp implements View.OnApplyWindowInsetsListener {
    private final zzaxq zzdwm;
    private final Activity zzdwn;

    zzaxp(zzaxq zzaxq, Activity activity) {
        this.zzdwm = zzaxq;
        this.zzdwn = activity;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return zzaxq.zza(this.zzdwn, view, windowInsets);
    }
}
