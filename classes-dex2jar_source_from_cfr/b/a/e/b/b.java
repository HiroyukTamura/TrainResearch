/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.b;

import b.a.d.c;

public final class b {
    static final c<Object, Object> a = new a();

    public static int a(int n2, int n3) {
        if (n2 < n3) {
            return -1;
        }
        return n2 > n3;
    }

    public static int a(int n2, String string2) {
        if (n2 > 0) {
            return n2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" > 0 required but it was ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static int a(long l2, long l3) {
        long l4 = l2 LCMP l3;
        if (l4 < 0) {
            return -1;
        }
        return l4 > 0;
    }

    public static <T> T a(T t2, String string2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(string2);
    }

    static final class a
    implements c<Object, Object> {
        a() {
        }
    }

}

