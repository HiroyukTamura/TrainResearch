// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.util.Log;

public class zzab
{
    public static boolean DEBUG;
    private static String TAG;
    
    static {
        zzab.TAG = "Volley";
        zzab.DEBUG = Log.isLoggable("Volley", 2);
    }
    
    public static void zza(final String s, final Object... array) {
        if (zzab.DEBUG) {
            Log.v(zzab.TAG, zzd(s, array));
        }
    }
    
    public static void zza(final Throwable t, final String s, final Object... array) {
        Log.e(zzab.TAG, zzd(s, array), t);
    }
    
    public static void zzb(final String s, final Object... array) {
        Log.d(zzab.TAG, zzd(s, array));
    }
    
    public static void zzc(final String s, final Object... array) {
        Log.e(zzab.TAG, zzd(s, array));
    }
    
    private static String zzd(String format, final Object... args) {
        if (args != null) {
            format = String.format(Locale.US, format, args);
        }
        final StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i = 2; i < stackTrace.length; ++i) {
            if (!stackTrace[i].getClass().equals(zzab.class)) {
                final String className = stackTrace[i].getClassName();
                final String substring = className.substring(className.lastIndexOf(46) + 1);
                final String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                final String value = String.valueOf(stackTrace[i].getMethodName());
                final String string = new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(value).length()).append(substring2).append(".").append(value).toString();
                return String.format(Locale.US, "[%d] %s: %s", Thread.currentThread().getId(), string, format);
            }
        }
        final String string = "<unknown>";
        return String.format(Locale.US, "[%d] %s: %s", Thread.currentThread().getId(), string, format);
    }
    
    static final class zza
    {
        public static final boolean zzai;
        private final List<zzac> zzaj;
        private boolean zzak;
        
        static {
            zzai = zzab.DEBUG;
        }
        
        zza() {
            this.zzaj = new ArrayList<zzac>();
            this.zzak = false;
        }
        
        @Override
        protected final void finalize() throws Throwable {
            if (!this.zzak) {
                this.zzc("Request on the loose");
                zzab.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
        
        public final void zza(final String s, final long n) {
            synchronized (this) {
                if (this.zzak) {
                    throw new IllegalStateException("Marker added to finished log");
                }
            }
            final String s2;
            this.zzaj.add(new zzac(s2, n, SystemClock.elapsedRealtime()));
        }
        // monitorexit(this)
        
        public final void zzc(final String s) {
            synchronized (this) {
                this.zzak = true;
                long l;
                if (this.zzaj.size() == 0) {
                    l = 0L;
                }
                else {
                    l = this.zzaj.get(this.zzaj.size() - 1).time - this.zzaj.get(0).time;
                }
                if (l > 0L) {
                    final long time = this.zzaj.get(0).time;
                    zzab.zzb("(%-4d ms) %s", l, s);
                    final Iterator<zzac> iterator = this.zzaj.iterator();
                    long n = time;
                    while (iterator.hasNext()) {
                        final zzac zzac = iterator.next();
                        final long time2 = zzac.time;
                        zzab.zzb("(+%-4d) [%2d] %s", time2 - n, zzac.zzal, zzac.name);
                        n = time2;
                    }
                }
            }
        }
    }
}
