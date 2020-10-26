// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzans;
import android.app.Activity;
import com.google.android.gms.internal.zzaop;
import com.google.android.gms.internal.zzaor;
import com.google.android.gms.internal.zzaoa;
import com.google.android.gms.internal.zzaot;
import com.google.android.gms.internal.zzaob;
import android.annotation.TargetApi;
import android.app.Application$ActivityLifecycleCallbacks;
import android.app.Application;
import java.util.Iterator;
import android.support.annotation.RequiresPermission;
import android.content.Context;
import java.util.HashSet;
import com.google.android.gms.internal.zzamj;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;

public final class GoogleAnalytics extends com.google.android.gms.analytics.zza
{
    private static List<Runnable> zzadC;
    private Set<zza> zzadD;
    private boolean zzadE;
    private boolean zzadF;
    private volatile boolean zzadG;
    private boolean zzadH;
    private boolean zzuH;
    
    static {
        GoogleAnalytics.zzadC = new ArrayList<Runnable>();
    }
    
    public GoogleAnalytics(final zzamj zzamj) {
        super(zzamj);
        this.zzadD = new HashSet<zza>();
    }
    
    @RequiresPermission(allOf = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" })
    public static GoogleAnalytics getInstance(final Context context) {
        return zzamj.zzaf(context).zzkG();
    }
    
    public static void zzjo() {
        Label_0054: {
            synchronized (GoogleAnalytics.class) {
                if (GoogleAnalytics.zzadC == null) {
                    break Label_0054;
                }
                final Iterator<Runnable> iterator = GoogleAnalytics.zzadC.iterator();
                while (iterator.hasNext()) {
                    iterator.next().run();
                }
            }
            GoogleAnalytics.zzadC = null;
        }
    }
    // monitorexit(GoogleAnalytics.class)
    
    public final void dispatchLocalHits() {
        this.zzji().zzkv().zzkl();
    }
    
    @TargetApi(14)
    public final void enableAutoActivityReports(final Application application) {
        if (!this.zzadE) {
            application.registerActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)new zzb());
            this.zzadE = true;
        }
    }
    
    public final boolean getAppOptOut() {
        return this.zzadG;
    }
    
    @Deprecated
    public final Logger getLogger() {
        return zzaob.getLogger();
    }
    
    public final void initialize() {
        final zzaot zzkx = this.zzji().zzkx();
        zzkx.zzmg();
        if (zzkx.zzmh()) {
            this.setDryRun(zzkx.zzmi());
        }
        zzkx.zzmg();
        this.zzuH = true;
    }
    
    public final boolean isDryRunEnabled() {
        return this.zzadF;
    }
    
    public final boolean isInitialized() {
        return this.zzuH;
    }
    
    public final Tracker newTracker(final int n) {
        synchronized (this) {
            final Tracker tracker = new Tracker(this.zzji(), null, null);
            if (n > 0) {
                final zzaor zzaor = new zzaop(this.zzji()).zzP(n);
                if (zzaor != null) {
                    tracker.zza(zzaor);
                }
            }
            tracker.initialize();
            return tracker;
        }
    }
    
    public final Tracker newTracker(final String s) {
        synchronized (this) {
            final Tracker tracker = new Tracker(this.zzji(), s, null);
            tracker.initialize();
            return tracker;
        }
    }
    
    public final void reportActivityStart(final Activity activity) {
        if (!this.zzadE) {
            this.zzj(activity);
        }
    }
    
    public final void reportActivityStop(final Activity activity) {
        if (!this.zzadE) {
            this.zzk(activity);
        }
    }
    
    public final void setAppOptOut(final boolean zzadG) {
        this.zzadG = zzadG;
        if (this.zzadG) {
            this.zzji().zzkv().zzkk();
        }
    }
    
    public final void setDryRun(final boolean zzadF) {
        this.zzadF = zzadF;
    }
    
    public final void setLocalDispatchPeriod(final int localDispatchPeriod) {
        this.zzji().zzkv().setLocalDispatchPeriod(localDispatchPeriod);
    }
    
    @Deprecated
    public final void setLogger(final Logger logger) {
        zzaob.setLogger(logger);
        if (!this.zzadH) {
            final String s = zzans.zzahg.get();
            final String s2 = zzans.zzahg.get();
            Log.i(s, new StringBuilder(String.valueOf(s2).length() + 112).append("GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append(s2).append(" DEBUG").toString());
            this.zzadH = true;
        }
    }
    
    final void zza(final zza zza) {
        this.zzadD.add(zza);
        final Context context = this.zzji().getContext();
        if (context instanceof Application) {
            this.enableAutoActivityReports((Application)context);
        }
    }
    
    final void zzb(final zza zza) {
        this.zzadD.remove(zza);
    }
    
    final void zzj(final Activity activity) {
        final Iterator<zza> iterator = this.zzadD.iterator();
        while (iterator.hasNext()) {
            iterator.next().zzl(activity);
        }
    }
    
    final void zzk(final Activity activity) {
        final Iterator<zza> iterator = this.zzadD.iterator();
        while (iterator.hasNext()) {
            iterator.next().zzm(activity);
        }
    }
    
    interface zza
    {
        void zzl(final Activity p0);
        
        void zzm(final Activity p0);
    }
    
    @TargetApi(14)
    final class zzb implements Application$ActivityLifecycleCallbacks
    {
        public final void onActivityCreated(final Activity activity, final Bundle bundle) {
        }
        
        public final void onActivityDestroyed(final Activity activity) {
        }
        
        public final void onActivityPaused(final Activity activity) {
        }
        
        public final void onActivityResumed(final Activity activity) {
        }
        
        public final void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
        }
        
        public final void onActivityStarted(final Activity activity) {
            GoogleAnalytics.this.zzj(activity);
        }
        
        public final void onActivityStopped(final Activity activity) {
            GoogleAnalytics.this.zzk(activity);
        }
    }
}
