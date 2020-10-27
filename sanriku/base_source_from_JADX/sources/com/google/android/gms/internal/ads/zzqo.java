package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
final class zzqo implements Application.ActivityLifecycleCallbacks {
    /* access modifiers changed from: private */
    public boolean foreground = true;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    @Nullable
    private Activity zzaad;
    /* access modifiers changed from: private */
    public boolean zzbqh = false;
    /* access modifiers changed from: private */
    public final List<zzqq> zzbqi = new ArrayList();
    private final List<zzrb> zzbqj = new ArrayList();
    private Runnable zzbqk;
    private long zzbql;
    private Context zzvf;
    private boolean zzyw = false;

    zzqo() {
    }

    private final void setActivity(Activity activity) {
        synchronized (this.lock) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.zzaad = activity;
            }
        }
    }

    @Nullable
    public final Activity getActivity() {
        return this.zzaad;
    }

    @Nullable
    public final Context getContext() {
        return this.zzvf;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.lock) {
            if (this.zzaad != null) {
                if (this.zzaad.equals(activity)) {
                    this.zzaad = null;
                }
                Iterator<zzrb> it = this.zzbqj.iterator();
                while (it.hasNext()) {
                    try {
                        if (it.next().zza(activity)) {
                            it.remove();
                        }
                    } catch (Exception e) {
                        zzq.zzla().zza(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzazw.zzc("", e);
                    }
                }
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        setActivity(activity);
        synchronized (this.lock) {
            for (zzrb onActivityPaused : this.zzbqj) {
                try {
                    onActivityPaused.onActivityPaused(activity);
                } catch (Exception e) {
                    zzq.zzla().zza(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzazw.zzc("", e);
                }
            }
        }
        this.zzbqh = true;
        Runnable runnable = this.zzbqk;
        if (runnable != null) {
            zzaxa.zzdwf.removeCallbacks(runnable);
        }
        zzdns zzdns = zzaxa.zzdwf;
        zzqn zzqn = new zzqn(this);
        this.zzbqk = zzqn;
        zzdns.postDelayed(zzqn, this.zzbql);
    }

    public final void onActivityResumed(Activity activity) {
        setActivity(activity);
        this.zzbqh = false;
        boolean z = !this.foreground;
        this.foreground = true;
        Runnable runnable = this.zzbqk;
        if (runnable != null) {
            zzaxa.zzdwf.removeCallbacks(runnable);
        }
        synchronized (this.lock) {
            for (zzrb onActivityResumed : this.zzbqj) {
                try {
                    onActivityResumed.onActivityResumed(activity);
                } catch (Exception e) {
                    zzq.zzla().zza(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzazw.zzc("", e);
                }
            }
            if (z) {
                for (zzqq zzp : this.zzbqi) {
                    try {
                        zzp.zzp(true);
                    } catch (Exception e2) {
                        zzazw.zzc("", e2);
                    }
                }
            } else {
                zzazw.zzed("App is still foreground.");
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void zza(Application application, Context context) {
        if (!this.zzyw) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                setActivity((Activity) context);
            }
            this.zzvf = application;
            this.zzbql = ((Long) zzvj.zzpv().zzd(zzzz.zzclo)).longValue();
            this.zzyw = true;
        }
    }

    public final void zza(zzqq zzqq) {
        synchronized (this.lock) {
            this.zzbqi.add(zzqq);
        }
    }

    public final void zzb(zzqq zzqq) {
        synchronized (this.lock) {
            this.zzbqi.remove(zzqq);
        }
    }
}
