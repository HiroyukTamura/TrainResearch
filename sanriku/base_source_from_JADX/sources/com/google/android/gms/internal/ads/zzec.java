package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzec implements zzei {
    private final /* synthetic */ Activity val$activity;

    zzec(zzea zzea, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.val$activity);
    }
}
