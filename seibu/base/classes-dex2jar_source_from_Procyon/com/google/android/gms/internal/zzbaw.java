// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager$RunningAppProcessInfo;
import com.google.android.gms.common.util.zzq;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.app.Application;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.ArrayList;
import android.content.ComponentCallbacks2;
import android.app.Application$ActivityLifecycleCallbacks;

public final class zzbaw implements Application$ActivityLifecycleCallbacks, ComponentCallbacks2
{
    private static final zzbaw zzaBJ;
    private final ArrayList<zzbax> mListeners;
    private final AtomicBoolean zzaBK;
    private final AtomicBoolean zzaBL;
    private boolean zzafK;
    
    static {
        zzaBJ = new zzbaw();
    }
    
    private zzbaw() {
        this.zzaBK = new AtomicBoolean();
        this.zzaBL = new AtomicBoolean();
        this.mListeners = new ArrayList<zzbax>();
        this.zzafK = false;
    }
    
    public static void zza(final Application application) {
        synchronized (zzbaw.zzaBJ) {
            if (!zzbaw.zzaBJ.zzafK) {
                application.registerActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)zzbaw.zzaBJ);
                application.registerComponentCallbacks((ComponentCallbacks)zzbaw.zzaBJ);
                zzbaw.zzaBJ.zzafK = true;
            }
        }
    }
    
    private final void zzac(final boolean b) {
        synchronized (zzbaw.zzaBJ) {
            final ArrayList<zzbax> list = this.mListeners;
            final int size = list.size();
            int i = 0;
            while (i < size) {
                final zzbax value = list.get(i);
                ++i;
                value.zzac(b);
            }
        }
    }
    // monitorexit(zzbaw)
    
    public static zzbaw zzpv() {
        return zzbaw.zzaBJ;
    }
    
    public final void onActivityCreated(final Activity activity, final Bundle bundle) {
        final boolean compareAndSet = this.zzaBK.compareAndSet(true, false);
        this.zzaBL.set(true);
        if (compareAndSet) {
            this.zzac(false);
        }
    }
    
    public final void onActivityDestroyed(final Activity activity) {
    }
    
    public final void onActivityPaused(final Activity activity) {
    }
    
    public final void onActivityResumed(final Activity activity) {
        final boolean compareAndSet = this.zzaBK.compareAndSet(true, false);
        this.zzaBL.set(true);
        if (compareAndSet) {
            this.zzac(false);
        }
    }
    
    public final void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
    }
    
    public final void onActivityStarted(final Activity activity) {
    }
    
    public final void onActivityStopped(final Activity activity) {
    }
    
    public final void onConfigurationChanged(final Configuration configuration) {
    }
    
    public final void onLowMemory() {
    }
    
    public final void onTrimMemory(final int n) {
        if (n == 20 && this.zzaBK.compareAndSet(false, true)) {
            this.zzaBL.set(true);
            this.zzac(true);
        }
    }
    
    public final void zza(final zzbax e) {
        synchronized (zzbaw.zzaBJ) {
            this.mListeners.add(e);
        }
    }
    
    @TargetApi(16)
    public final boolean zzab(final boolean b) {
        boolean value = true;
        if (!this.zzaBL.get()) {
            if (!zzq.zzrZ()) {
                return value;
            }
            final ActivityManager$RunningAppProcessInfo activityManager$RunningAppProcessInfo = new ActivityManager$RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(activityManager$RunningAppProcessInfo);
            if (!this.zzaBL.getAndSet(true) && activityManager$RunningAppProcessInfo.importance > 100) {
                this.zzaBK.set(true);
            }
        }
        value = this.zzaBK.get();
        return value;
    }
    
    public final boolean zzpw() {
        return this.zzaBK.get();
    }
}
