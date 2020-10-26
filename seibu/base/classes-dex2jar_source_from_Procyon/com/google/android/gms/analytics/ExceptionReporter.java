// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import com.google.android.gms.internal.zzaob;
import java.util.Collection;
import java.util.ArrayList;
import android.content.Context;

public class ExceptionReporter implements UncaughtExceptionHandler
{
    private final Context mContext;
    private ExceptionParser zzadA;
    private GoogleAnalytics zzadB;
    private final UncaughtExceptionHandler zzady;
    private final Tracker zzadz;
    
    public ExceptionReporter(final Tracker zzadz, final UncaughtExceptionHandler zzady, final Context context) {
        if (zzadz == null) {
            throw new NullPointerException("tracker cannot be null");
        }
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.zzady = zzady;
        this.zzadz = zzadz;
        this.zzadA = new StandardExceptionParser(context, new ArrayList<String>());
        this.mContext = context.getApplicationContext();
        String name;
        if (zzady == null) {
            name = "null";
        }
        else {
            name = zzady.getClass().getName();
        }
        final String value = String.valueOf(name);
        String concat;
        if (value.length() != 0) {
            concat = "ExceptionReporter created, original handler is ".concat(value);
        }
        else {
            concat = new String("ExceptionReporter created, original handler is ");
        }
        zzaob.v(concat);
    }
    
    public ExceptionParser getExceptionParser() {
        return this.zzadA;
    }
    
    public void setExceptionParser(final ExceptionParser zzadA) {
        this.zzadA = zzadA;
    }
    
    @Override
    public void uncaughtException(final Thread thread, final Throwable t) {
        String description = "UncaughtException";
        if (this.zzadA != null) {
            String name;
            if (thread != null) {
                name = thread.getName();
            }
            else {
                name = null;
            }
            description = this.zzadA.getDescription(name, t);
        }
        final String value = String.valueOf(description);
        String concat;
        if (value.length() != 0) {
            concat = "Reporting uncaught exception: ".concat(value);
        }
        else {
            concat = new String("Reporting uncaught exception: ");
        }
        zzaob.v(concat);
        this.zzadz.send(((HitBuilders.HitBuilder)new HitBuilders.ExceptionBuilder().setDescription(description).setFatal(true)).build());
        if (this.zzadB == null) {
            this.zzadB = GoogleAnalytics.getInstance(this.mContext);
        }
        final GoogleAnalytics zzadB = this.zzadB;
        zzadB.dispatchLocalHits();
        zzadB.zzji().zzkv().zzkm();
        if (this.zzady != null) {
            zzaob.v("Passing exception to the original handler");
            this.zzady.uncaughtException(thread, t);
        }
    }
    
    final UncaughtExceptionHandler zzjn() {
        return this.zzady;
    }
}
