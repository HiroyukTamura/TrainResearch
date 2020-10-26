// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.flags.impl;

import java.util.concurrent.Callable;
import com.google.android.gms.internal.zzcag;
import android.content.Context;
import android.content.SharedPreferences;

public final class zzj
{
    private static SharedPreferences zzaXQ;
    
    static {
        zzj.zzaXQ = null;
    }
    
    public static SharedPreferences zzaW(final Context context) throws Exception {
        synchronized (SharedPreferences.class) {
            if (zzj.zzaXQ == null) {
                zzj.zzaXQ = zzcag.zzb((Callable<SharedPreferences>)new zzk(context));
            }
            return zzj.zzaXQ;
        }
    }
}
