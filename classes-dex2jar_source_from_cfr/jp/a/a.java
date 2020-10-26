/*
 * Decompiled with CFR 0.139.
 */
package jp.a;

public abstract class a {
    public abstract h a();

    public abstract void a(g var1);

    public abstract boolean a(a var1);

    public abstract void b();

    public static enum a {
        a,
        b;
        
    }

    public static class b
    extends Exception {
        public b(String string2, Throwable throwable) {
            super(string2, throwable);
        }
    }

    public static class c
    extends Error {
        public c(String string2, Throwable throwable) {
            super(string2, throwable);
        }
    }

    public static class d
    extends b {
        public d(String string2, Throwable throwable) {
            super(string2, throwable);
        }
    }

    public static class e
    extends b {
        public e(String string2, Throwable throwable) {
            super(string2, throwable);
        }
    }

    public static enum f {
        a,
        b,
        c,
        d,
        e,
        f,
        g;
        
    }

    public static interface g {
        public void a(b var1);

        public void a(f var1, int var2, String var3, String var4);

        public void a(h var1);
    }

    public static enum h {
        a,
        b,
        c,
        d;
        
    }

}

