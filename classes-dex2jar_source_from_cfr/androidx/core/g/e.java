/*
 * Decompiled with CFR 0.139.
 */
package androidx.core.g;

public class e {
    public static int a(int n2) {
        if (n2 >= 0) {
            return n2;
        }
        throw new IllegalArgumentException();
    }

    public static <T> T a(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException();
    }

    public static <T> T a(T t2, Object object) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(object));
    }
}

