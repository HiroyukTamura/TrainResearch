/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package b.a.a.b;

import android.os.Handler;
import android.os.Looper;
import b.a.a.b.b;
import b.a.h;
import java.util.concurrent.Callable;

public final class a {
    private static final h a = b.a.a.a.a.a(new Callable<h>(){

        public h a() {
            return a.a;
        }

        @Override
        public /* synthetic */ Object call() {
            return this.a();
        }
    });

    public static h a() {
        return b.a.a.a.a.a(a);
    }

    private static final class a {
        static final h a = new b(new Handler(Looper.getMainLooper()));
    }

}

