/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.util.Log
 */
package a.a.a;

import a.a.a.d;
import a.a.b;
import a.b.f;
import android.app.Application;
import android.util.Log;
import androidx.f.a.e;
import androidx.lifecycle.j;

public final class a {
    public static void a(androidx.f.a.d d2) {
        f.a(d2, "fragment");
        d d3 = a.b(d2);
        if (Log.isLoggable((String)"dagger.android.support", (int)3)) {
            Log.d((String)"dagger.android.support", (String)String.format("An injector for %s was found in %s", d2.getClass().getCanonicalName(), d3.getClass().getCanonicalName()));
        }
        b<androidx.f.a.d> b2 = d3.c_();
        f.a(b2, "%s.supportFragmentInjector() returned null", d3.getClass());
        b2.a(d2);
    }

    private static d b(androidx.f.a.d d2) {
        androidx.f.a.d d3;
        j j2 = d2;
        while ((d3 = j2.u()) != null) {
            j2 = d3;
            if (!(d3 instanceof d)) continue;
            return (d)((Object)d3);
        }
        j2 = d2.o();
        if (j2 instanceof d) {
            return (d)((Object)j2);
        }
        if (j2.getApplication() instanceof d) {
            return (d)j2.getApplication();
        }
        throw new IllegalArgumentException(String.format("No injector was found for %s", d2.getClass().getCanonicalName()));
    }
}

