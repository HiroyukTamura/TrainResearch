/*
 * Decompiled with CFR 0.139.
 */
package jp.co.bug.b;

public class a {
    private static a a = new b();

    public static /* varargs */ void a(Object ... arrobject) {
        a.a(arrobject);
    }

    public static /* varargs */ void b(Object ... arrobject) {
        a.b(arrobject);
    }

    public static interface a {
        public /* varargs */ void a(Object ... var1);

        public /* varargs */ void b(Object ... var1);
    }

    public static class b
    implements a {
        @Override
        public /* varargs */ void a(Object ... arrobject) {
        }

        @Override
        public /* varargs */ void b(Object ... arrobject) {
        }
    }

}

