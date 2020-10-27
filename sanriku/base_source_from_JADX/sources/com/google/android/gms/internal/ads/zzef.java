package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzef implements zzei {
    private final /* synthetic */ Activity val$activity;

    zzef(zzea zzea, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.val$activity);
    }
}
