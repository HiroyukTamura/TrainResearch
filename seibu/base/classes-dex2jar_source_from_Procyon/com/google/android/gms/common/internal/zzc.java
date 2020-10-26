// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.util.Log;
import android.os.Looper;

public final class zzc
{
    public static void zzae(final boolean b) {
        if (!b) {
            throw new IllegalStateException();
        }
    }
    
    public static void zzcz(final String s) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            final String value = String.valueOf(Thread.currentThread());
            final String value2 = String.valueOf(Looper.getMainLooper().getThread());
            Log.e("Asserts", new StringBuilder(String.valueOf(value).length() + 57 + String.valueOf(value2).length()).append("checkMainThread: current thread ").append(value).append(" IS NOT the main thread ").append(value2).append("!").toString());
            throw new IllegalStateException(s);
        }
    }
    
    public static void zzr(final Object o) {
        if (o == null) {
            throw new IllegalArgumentException("null reference");
        }
    }
}
