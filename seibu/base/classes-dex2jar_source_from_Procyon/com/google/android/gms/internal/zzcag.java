// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.StrictMode$ThreadPolicy;
import android.os.StrictMode;
import java.util.concurrent.Callable;

public final class zzcag
{
    public static <T> T zzb(final Callable<T> callable) throws Exception {
        final StrictMode$ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(StrictMode$ThreadPolicy.LAX);
            return callable.call();
        }
        finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
