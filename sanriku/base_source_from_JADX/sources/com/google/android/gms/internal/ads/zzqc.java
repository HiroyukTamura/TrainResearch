package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class zzqc implements Application.ActivityLifecycleCallbacks {
    private final Application zzxv;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzxw;
    private boolean zzxx = false;

    public zzqc(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzxw = new WeakReference<>(activityLifecycleCallbacks);
        this.zzxv = application;
    }

    private final void zza(zzqk zzqk) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzxw.get();
            if (activityLifecycleCallbacks != null) {
                zzqk.zza(activityLifecycleCallbacks);
            } else if (!this.zzxx) {
                this.zzxv.unregisterActivityLifecycleCallbacks(this);
                this.zzxx = true;
            }
        } catch (Exception e) {
            zzazw.zzc("Error while dispatching lifecycle callback.", e);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzqb(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzqh(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzqg(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzqd(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzqi(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzqe(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzqf(this, activity));
    }
}
