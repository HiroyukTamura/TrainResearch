package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzqe implements zzqk {
    private final /* synthetic */ Activity val$activity;

    zzqe(zzqc zzqc, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.val$activity);
    }
}