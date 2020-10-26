// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.stats;

import android.text.TextUtils;
import android.os.Process;
import android.os.PowerManager$WakeLock;

public final class zzc
{
    public static String zza(final PowerManager$WakeLock powerManager$WakeLock, final String s) {
        final String value = String.valueOf(String.valueOf((long)Process.myPid() << 32 | (long)System.identityHashCode(powerManager$WakeLock)));
        String obj = s;
        if (TextUtils.isEmpty((CharSequence)s)) {
            obj = "";
        }
        final String value2 = String.valueOf(obj);
        if (value2.length() != 0) {
            return value.concat(value2);
        }
        return new String(value);
    }
}
