// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.zzp;
import android.annotation.TargetApi;
import com.google.android.gms.internal.zzbha;
import android.content.Context;

public final class zzw
{
    @TargetApi(19)
    public static boolean zzb(final Context context, final int n, final String s) {
        return zzbha.zzaP(context).zzf(n, s);
    }
    
    public static boolean zzf(final Context context, final int n) {
        if (zzb(context, n, "com.google.android.gms")) {
            final PackageManager packageManager = context.getPackageManager();
            try {
                return zzp.zzax(context).zza(context.getPackageManager(), packageManager.getPackageInfo("com.google.android.gms", 64));
            }
            catch (PackageManager$NameNotFoundException ex) {
                if (Log.isLoggable("UidVerifier", 3)) {
                    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
                    return false;
                }
            }
        }
        return false;
    }
}
