package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.List;

@KeepForSdk
public class ConnectionTracker {
    private static final Object zzfw = new Object();
    private static volatile ConnectionTracker zzfx = null;
    @VisibleForTesting
    private static boolean zzfy = false;
    private final List<String> zzfz;
    private final List<String> zzga;
    private final List<String> zzgb;
    private final List<String> zzgc;

    private ConnectionTracker() {
        List<String> list = Collections.EMPTY_LIST;
        this.zzfz = list;
        this.zzga = list;
        this.zzgb = list;
        this.zzgc = list;
    }

    @KeepForSdk
    public static ConnectionTracker getInstance() {
        if (zzfx == null) {
            synchronized (zzfw) {
                if (zzfx == null) {
                    zzfx = new ConnectionTracker();
                }
            }
        }
        return zzfx;
    }

    @KeepForSdk
    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    @KeepForSdk
    public void unbindService(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    @SuppressLint({"UntrackedBindService"})
    @KeepForSdk
    public void unbindServiceSafe(Context context, ServiceConnection serviceConnection) {
        try {
            unbindService(context, serviceConnection);
        } catch (IllegalArgumentException e) {
            Log.w("ConnectionTracker", "Exception thrown while unbinding", e);
        }
    }

    public final boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        if (!(component == null ? false : ClientLibraryUtils.zzc(context, component.getPackageName()))) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }
}
