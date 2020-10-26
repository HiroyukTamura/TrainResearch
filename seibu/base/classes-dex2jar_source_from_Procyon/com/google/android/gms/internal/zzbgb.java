// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.util.Log;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzaj;

public final class zzbgb
{
    private final String mTag;
    private final zzaj zzaIA;
    private final String zzaIc;
    private final int zzagX;
    
    private zzbgb(final String mTag, final String zzaIc) {
        this.zzaIc = zzaIc;
        this.mTag = mTag;
        this.zzaIA = new zzaj(mTag);
        this.zzagX = this.getLogLevel();
    }
    
    public zzbgb(final String s, final String... array) {
        this(s, zzb(array));
    }
    
    private final String format(final String format, @Nullable final Object... args) {
        String format2 = format;
        if (args != null) {
            format2 = format;
            if (args.length > 0) {
                format2 = String.format(format, args);
            }
        }
        return this.zzaIc.concat(format2);
    }
    
    private final int getLogLevel() {
        int n;
        for (n = 2; 7 >= n && !Log.isLoggable(this.mTag, n); ++n) {}
        return n;
    }
    
    private static String zzb(final String... array) {
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int length = array.length, i = 0; i < length; ++i) {
            final String str = array[i];
            if (sb.length() > 1) {
                sb.append(",");
            }
            sb.append(str);
        }
        sb.append(']').append(' ');
        return sb.toString();
    }
    
    private final boolean zzz(final int n) {
        return this.zzagX <= n;
    }
    
    public final void zza(final String s, final Throwable t, @Nullable final Object... array) {
        Log.wtf(this.mTag, this.format(s, array), t);
    }
    
    public final void zza(final String s, @Nullable final Object... array) {
        if (this.zzz(2)) {
            Log.v(this.mTag, this.format(s, array));
        }
    }
    
    public final void zzb(final String s, @Nullable final Object... array) {
        if (this.zzz(3)) {
            Log.d(this.mTag, this.format(s, array));
        }
    }
    
    public final void zzd(final Throwable t) {
        Log.wtf(this.mTag, t);
    }
    
    public final void zze(final String s, @Nullable final Object... array) {
        Log.i(this.mTag, this.format(s, array));
    }
    
    public final void zzf(final String s, @Nullable final Object... array) {
        Log.w(this.mTag, this.format(s, array));
    }
}
