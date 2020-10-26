/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package jp.co.bug.sst;

import android.os.Handler;

public interface e {
    public void a();

    public void a(a var1);

    public boolean a(Handler var1, int var2, int var3);

    public static interface a {
        public void a(jp.co.bug.sst.a.b var1);

        public void a(c var1);
    }

    public static class b
    extends c {
        public b(String string2, Throwable throwable) {
            super(string2, throwable);
        }
    }

    public static class c
    extends Exception {
        public c(String string2, Throwable throwable) {
            super(string2, throwable);
        }
    }

}

