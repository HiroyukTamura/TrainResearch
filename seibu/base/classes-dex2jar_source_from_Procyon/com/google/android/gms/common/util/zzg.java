// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import android.util.Log;
import com.google.android.gms.common.internal.zzbo;
import android.content.Context;
import android.os.DropBoxManager;

public final class zzg
{
    private static final String[] zzaJD;
    private static DropBoxManager zzaJE;
    private static boolean zzaJF;
    private static int zzaJG;
    private static int zzaJH;
    
    static {
        zzaJD = new String[] { "android.", "com.android.", "dalvik.", "java.", "javax." };
        zzg.zzaJE = null;
        zzg.zzaJF = false;
        zzg.zzaJG = -1;
        zzg.zzaJH = 0;
    }
    
    public static boolean zza(final Context context, final Throwable t) {
        return zza(context, t, 0);
    }
    
    private static boolean zza(final Context context, final Throwable t, final int n) {
        try {
            zzbo.zzu(context);
            zzbo.zzu(t);
            return false;
        }
        catch (Exception ex) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", (Throwable)ex);
            return false;
        }
    }
}
