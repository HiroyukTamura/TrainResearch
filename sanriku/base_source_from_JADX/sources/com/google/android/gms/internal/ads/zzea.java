package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class zzea implements Application.ActivityLifecycleCallbacks {
    private final Application zzxv;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzxw;
    private boolean zzxx = false;

    public zzea(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzxw = new WeakReference<>(activityLifecycleCallbacks);
        this.zzxv = application;
    }

    private final void zza(zzei zzei) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzxw.get();
            if (activityLifecycleCallbacks != null) {
                zzei.zza(activityLifecycleCallbacks);
            } else if (!this.zzxx) {
                this.zzxv.unregisterActivityLifecycleCallbacks(this);
                this.zzxx = true;
            }
        } catch (Exception unused) {
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzdz(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzef(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzee(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzeb(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzeg(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzec(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzed(this, activity));
    }
}
