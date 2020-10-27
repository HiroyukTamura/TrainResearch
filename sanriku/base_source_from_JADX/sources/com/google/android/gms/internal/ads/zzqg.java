package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzqg implements zzqk {
    private final /* synthetic */ Activity val$activity;

    zzqg(zzqc zzqc, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.val$activity);
    }
}
