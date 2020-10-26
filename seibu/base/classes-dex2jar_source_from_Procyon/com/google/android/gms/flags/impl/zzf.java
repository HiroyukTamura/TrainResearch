// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.flags.impl;

import android.util.Log;
import java.util.concurrent.Callable;
import com.google.android.gms.internal.zzcag;
import android.content.SharedPreferences;

public final class zzf extends zza<Long>
{
    public static Long zza(final SharedPreferences sharedPreferences, final String s, final Long n) {
        try {
            return zzcag.zzb((Callable<Long>)new zzg(sharedPreferences, s, n));
        }
        catch (Exception ex) {
            final String value = String.valueOf(ex.getMessage());
            String concat;
            if (value.length() != 0) {
                concat = "Flag value not available, returning default: ".concat(value);
            }
            else {
                concat = new String("Flag value not available, returning default: ");
            }
            Log.w("FlagDataUtils", concat);
            return n;
        }
    }
}
