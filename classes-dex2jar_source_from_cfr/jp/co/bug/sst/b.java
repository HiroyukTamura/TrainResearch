/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package jp.co.bug.sst;

import android.os.Handler;

public interface b {
    public void a();

    public void a(int var1);

    public void a(a var1);

    public boolean a(Handler var1);

    public static interface a {
        public void a(c var1);

        public void a(byte[] var1);
    }

    public static class b
    extends Error {
        public b(Throwable throwable) {
            super(throwable);
        }
    }

    public static class c
    extends RuntimeException {
        public c(String string2) {
            super(string2);
        }

        public c(String string2, Throwable throwable) {
            super(string2, throwable);
        }

        public c(Throwable throwable) {
            super(throwable);
        }
    }

}

