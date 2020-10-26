// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.util.Log;
import com.google.android.gms.common.util.zzd;
import android.content.ServiceConnection;
import android.content.Intent;
import android.content.Context;
import java.util.Collections;
import java.util.List;

public final class zza
{
    private static final Object zzaHL;
    private static volatile zza zzaJa;
    private final List<String> zzaJb;
    private final List<String> zzaJc;
    private final List<String> zzaJd;
    private final List<String> zzaJe;
    
    static {
        zzaHL = new Object();
    }
    
    private zza() {
        this.zzaJb = (List<String>)Collections.EMPTY_LIST;
        this.zzaJc = (List<String>)Collections.EMPTY_LIST;
        this.zzaJd = (List<String>)Collections.EMPTY_LIST;
        this.zzaJe = (List<String>)Collections.EMPTY_LIST;
    }
    
    @SuppressLint({ "UntrackedBindService" })
    public static boolean zza(final Context context, final String s, final Intent intent, final ServiceConnection serviceConnection, final int n) {
        final ComponentName component = intent.getComponent();
        if (component != null && zzd.zzC(context, component.getPackageName())) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        return context.bindService(intent, serviceConnection, n);
    }
    
    public static zza zzrU() {
        Label_0030: {
            if (zza.zzaJa != null) {
                break Label_0030;
            }
            synchronized (zza.zzaHL) {
                if (zza.zzaJa == null) {
                    zza.zzaJa = new zza();
                }
                return zza.zzaJa;
            }
        }
    }
    
    public final boolean zza(final Context context, final Intent intent, final ServiceConnection serviceConnection, final int n) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, n);
    }
}
