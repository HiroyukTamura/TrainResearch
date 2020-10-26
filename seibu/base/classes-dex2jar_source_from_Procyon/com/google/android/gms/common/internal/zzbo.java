// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.util.zzv;
import android.text.TextUtils;
import android.os.Looper;
import android.os.Handler;

public final class zzbo
{
    public static long zza(final long n, final Object obj) {
        if (n == 0L) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return n;
    }
    
    public static void zza(final Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException("Must be called on the handler thread");
        }
    }
    
    public static void zza(final boolean b, final Object obj) {
        if (!b) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
    
    public static void zza(final boolean b, final String format, final Object... args) {
        if (!b) {
            throw new IllegalStateException(String.format(format, args));
        }
    }
    
    public static void zzae(final boolean b) {
        if (!b) {
            throw new IllegalStateException();
        }
    }
    
    public static void zzaf(final boolean b) {
        if (!b) {
            throw new IllegalArgumentException();
        }
    }
    
    public static <T> T zzb(final T t, final Object obj) {
        if (t == null) {
            throw new NullPointerException(String.valueOf(obj));
        }
        return t;
    }
    
    public static void zzb(final boolean b, final Object obj) {
        if (!b) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }
    
    public static void zzb(final boolean b, final String format, final Object... args) {
        if (!b) {
            throw new IllegalArgumentException(String.format(format, args));
        }
    }
    
    public static String zzcF(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return s;
    }
    
    public static void zzcG(final String s) {
        if (zzv.zzS()) {
            throw new IllegalStateException(s);
        }
    }
    
    public static void zzcz(final String s) {
        if (!zzv.zzS()) {
            throw new IllegalStateException(s);
        }
    }
    
    public static String zzh(final String s, final Object obj) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return s;
    }
    
    public static <T> T zzu(final T t) {
        if (t == null) {
            throw new NullPointerException("null reference");
        }
        return t;
    }
}
