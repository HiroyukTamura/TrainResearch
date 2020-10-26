// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.util.zze;
import android.support.annotation.Size;
import android.support.annotation.Nullable;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.support.annotation.NonNull;
import android.support.annotation.MainThread;
import java.util.Iterator;
import android.support.v4.util.ArrayMap;
import java.util.concurrent.CopyOnWriteArrayList;
import android.app.Activity;
import java.util.Map;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzchz extends zzchj
{
    protected zzcic zzbtE;
    private volatile AppMeasurement.zzb zzbtF;
    private AppMeasurement.zzb zzbtG;
    private long zzbtH;
    private final Map<Activity, zzcic> zzbtI;
    private final CopyOnWriteArrayList<AppMeasurement.zza> zzbtJ;
    private boolean zzbtK;
    private AppMeasurement.zzb zzbtL;
    private String zzbtM;
    
    public zzchz(final zzcgl zzcgl) {
        super(zzcgl);
        this.zzbtI = new ArrayMap<Activity, zzcic>();
        this.zzbtJ = new CopyOnWriteArrayList<AppMeasurement.zza>();
    }
    
    @MainThread
    private final void zza(final Activity activity, final zzcic zzcic, final boolean b) {
        int n = 1;
        int n2 = 1;
        while (true) {
            Object o = null;
            Label_0019: {
                if (this.zzbtF != null) {
                    o = this.zzbtF;
                    break Label_0019;
                }
                Label_0101: {
                    break Label_0101;
                    Iterator<AppMeasurement.zza> iterator;
                    AppMeasurement.zza zza;
                    zzcic zzbtF;
                    Label_0185_Outer:Label_0198_Outer:
                    while (true) {
                        this.zzbtK = true;
                        while (true) {
                            Label_0299: {
                                try {
                                    while (true) {
                                        Label_0279: {
                                            try {
                                                iterator = this.zzbtJ.iterator();
                                                while (true) {
                                                    n = n2;
                                                    if (!iterator.hasNext()) {
                                                        break Label_0279;
                                                    }
                                                    n = n2;
                                                    zza = iterator.next();
                                                    try {
                                                        n2 &= (zza.zza((AppMeasurement.zzb)o, zzcic) ? 1 : 0);
                                                        continue Label_0185_Outer;
                                                        // iftrue(Label_0314:, this.zzbtG == null || Math.abs(super.zzkq().elapsedRealtime() - this.zzbtH) >= 1000L)
                                                        o = this.zzbtG;
                                                    }
                                                    catch (Exception ex) {
                                                        n = n2;
                                                        super.zzwF().zzyx().zzj("onScreenChangeCallback threw exception", ex);
                                                    }
                                                }
                                            }
                                            catch (Exception o) {
                                                super.zzwF().zzyx().zzj("onScreenChangeCallback loop threw exception", o);
                                            }
                                            if (this.zzbtF == null) {
                                                o = this.zzbtG;
                                                if (n != 0) {
                                                    if (zzcic.zzbok == null) {
                                                        zzcic.zzbok = zzen(activity.getClass().getCanonicalName());
                                                    }
                                                    zzbtF = new zzcic(zzcic);
                                                    this.zzbtG = this.zzbtF;
                                                    this.zzbtH = super.zzkq().elapsedRealtime();
                                                    this.zzbtF = zzbtF;
                                                    super.zzwE().zzj(new zzcia(this, b, (AppMeasurement.zzb)o, zzbtF));
                                                }
                                                return;
                                            }
                                            break Label_0299;
                                        }
                                        this.zzbtK = false;
                                        n = n2;
                                        continue Label_0198_Outer;
                                    }
                                }
                                finally {
                                    this.zzbtK = false;
                                }
                            }
                            o = this.zzbtF;
                            continue;
                        }
                    }
                }
                Label_0314: {
                    o = null;
                }
            }
            if (o != null) {
                o = new AppMeasurement.zzb((AppMeasurement.zzb)o);
                continue;
            }
            o = null;
            continue;
        }
    }
    
    @WorkerThread
    private final void zza(@NonNull final zzcic zzcic) {
        super.zzwr().zzJ(super.zzkq().elapsedRealtime());
        if (super.zzwD().zzap(zzcic.zzbtS)) {
            zzcic.zzbtS = false;
        }
    }
    
    public static void zza(final AppMeasurement.zzb zzb, final Bundle bundle) {
        if (bundle != null && zzb != null && !bundle.containsKey("_sc")) {
            if (zzb.zzboj != null) {
                bundle.putString("_sn", zzb.zzboj);
            }
            bundle.putString("_sc", zzb.zzbok);
            bundle.putLong("_si", zzb.zzbol);
        }
    }
    
    private static String zzen(String substring) {
        final String[] split = substring.split("\\.");
        if (split.length == 0) {
            substring = substring.substring(0, 36);
        }
        else {
            final String s = substring = split[split.length - 1];
            if (s.length() > 36) {
                return s.substring(0, 36);
            }
        }
        return substring;
    }
    
    @MainThread
    public final void onActivityDestroyed(final Activity activity) {
        this.zzbtI.remove(activity);
    }
    
    @MainThread
    public final void onActivityPaused(final Activity activity) {
        final zzcic zzq = this.zzq(activity);
        this.zzbtG = this.zzbtF;
        this.zzbtH = super.zzkq().elapsedRealtime();
        this.zzbtF = null;
        super.zzwE().zzj(new zzcib(this, zzq));
    }
    
    @MainThread
    public final void onActivityResumed(final Activity activity) {
        this.zza(activity, this.zzq(activity), false);
        super.zzwr().zzwn();
    }
    
    @MainThread
    public final void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
        if (bundle != null) {
            final zzcic zzcic = this.zzbtI.get(activity);
            if (zzcic != null) {
                final Bundle bundle2 = new Bundle();
                bundle2.putLong("id", zzcic.zzbol);
                bundle2.putString("name", zzcic.zzboj);
                bundle2.putString("referrer_name", zzcic.zzbok);
                bundle.putBundle("com.google.firebase.analytics.screen_service", bundle2);
            }
        }
    }
    
    @MainThread
    public final void registerOnScreenChangeCallback(@NonNull final AppMeasurement.zza zza) {
        super.zzwp();
        if (zza == null) {
            super.zzwF().zzyz().log("Attempting to register null OnScreenChangeCallback");
            return;
        }
        this.zzbtJ.remove(zza);
        this.zzbtJ.add(zza);
    }
    
    @MainThread
    public final void setCurrentScreen(@NonNull final Activity activity, @Nullable @Size(max = 36L, min = 1L) final String s, @Nullable @Size(max = 36L, min = 1L) String s2) {
        if (activity == null) {
            super.zzwF().zzyz().log("setCurrentScreen must be called with a non-null activity");
            return;
        }
        super.zzwE();
        if (!zzcgg.zzS()) {
            super.zzwF().zzyz().log("setCurrentScreen must be called from the main thread");
            return;
        }
        if (this.zzbtK) {
            super.zzwF().zzyz().log("Cannot call setCurrentScreen from onScreenChangeCallback");
            return;
        }
        if (this.zzbtF == null) {
            super.zzwF().zzyz().log("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.zzbtI.get(activity) == null) {
            super.zzwF().zzyz().log("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        String zzen;
        if ((zzen = s2) == null) {
            zzen = zzen(activity.getClass().getCanonicalName());
        }
        final boolean equals = this.zzbtF.zzbok.equals(zzen);
        final boolean zzR = zzcjl.zzR(this.zzbtF.zzboj, s);
        if (equals && zzR) {
            super.zzwF().zzyA().log("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (s != null && (s.length() <= 0 || s.length() > zzcem.zzxk())) {
            super.zzwF().zzyz().zzj("Invalid screen name length in setCurrentScreen. Length", s.length());
            return;
        }
        if (zzen != null && (zzen.length() <= 0 || zzen.length() > zzcem.zzxk())) {
            super.zzwF().zzyz().zzj("Invalid class name length in setCurrentScreen. Length", zzen.length());
            return;
        }
        final zzcfn zzyD = super.zzwF().zzyD();
        if (s == null) {
            s2 = "null";
        }
        else {
            s2 = s;
        }
        zzyD.zze("Setting current screen to name, class", s2, zzen);
        final zzcic zzcic = new zzcic(s, zzen, super.zzwB().zzzs());
        this.zzbtI.put(activity, zzcic);
        this.zza(activity, zzcic, true);
    }
    
    @MainThread
    public final void unregisterOnScreenChangeCallback(@NonNull final AppMeasurement.zza o) {
        super.zzwp();
        this.zzbtJ.remove(o);
    }
    
    @WorkerThread
    public final void zza(final String s, final AppMeasurement.zzb zzbtL) {
        super.zzjC();
        synchronized (this) {
            if (this.zzbtM == null || this.zzbtM.equals(s) || zzbtL != null) {
                this.zzbtM = s;
                this.zzbtL = zzbtL;
            }
        }
    }
    
    @Override
    protected final void zzjD() {
    }
    
    @MainThread
    final zzcic zzq(@NonNull final Activity activity) {
        zzbo.zzu(activity);
        zzcic zzcic;
        if ((zzcic = this.zzbtI.get(activity)) == null) {
            zzcic = new zzcic(null, zzen(activity.getClass().getCanonicalName()), super.zzwB().zzzs());
            this.zzbtI.put(activity, zzcic);
        }
        return zzcic;
    }
    
    @WorkerThread
    public final zzcic zzzh() {
        this.zzkD();
        super.zzjC();
        return this.zzbtE;
    }
    
    public final AppMeasurement.zzb zzzi() {
        super.zzwp();
        final AppMeasurement.zzb zzbtF = this.zzbtF;
        if (zzbtF == null) {
            return null;
        }
        return new AppMeasurement.zzb(zzbtF);
    }
}
