// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

@Deprecated
public final class zzaob
{
    private static volatile Logger zzaim;
    
    static {
        zzaob.zzaim = new zzanl();
    }
    
    public static Logger getLogger() {
        return zzaob.zzaim;
    }
    
    public static void setLogger(final Logger zzaim) {
        zzaob.zzaim = zzaim;
    }
    
    public static void v(final String s) {
        final zzaoc zzlM = zzaoc.zzlM();
        if (zzlM != null) {
            zzlM.zzbo(s);
        }
        else if (zzz(0)) {
            Log.v((String)zzans.zzahg.get(), s);
        }
        final Logger zzaim = zzaob.zzaim;
        if (zzaim != null) {
            zzaim.verbose(s);
        }
    }
    
    public static void zzaT(final String s) {
        final zzaoc zzlM = zzaoc.zzlM();
        if (zzlM != null) {
            zzlM.zzbr(s);
        }
        else if (zzz(2)) {
            Log.w((String)zzans.zzahg.get(), s);
        }
        final Logger zzaim = zzaob.zzaim;
        if (zzaim != null) {
            zzaim.warn(s);
        }
    }
    
    public static void zzf(final String s, final Object obj) {
        final zzaoc zzlM = zzaoc.zzlM();
        if (zzlM != null) {
            zzlM.zze(s, obj);
        }
        else if (zzz(3)) {
            String string;
            if (obj != null) {
                final String value = String.valueOf(obj);
                string = new StringBuilder(String.valueOf(s).length() + 1 + String.valueOf(value).length()).append(s).append(":").append(value).toString();
            }
            else {
                string = s;
            }
            Log.e((String)zzans.zzahg.get(), string);
        }
        final Logger zzaim = zzaob.zzaim;
        if (zzaim != null) {
            zzaim.error(s);
        }
    }
    
    private static boolean zzz(final int n) {
        boolean b = false;
        if (zzaob.zzaim != null) {
            b = b;
            if (zzaob.zzaim.getLogLevel() <= n) {
                b = true;
            }
        }
        return b;
    }
}
