package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class zzdz implements zzei {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzxu;

    zzdz(zzea zzea, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzxu = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.val$activity, this.zzxu);
    }
}
