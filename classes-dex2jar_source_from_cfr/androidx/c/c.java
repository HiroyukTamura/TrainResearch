/*
 * Decompiled with CFR 0.139.
 */
package androidx.c;

class c {
    static final int[] a = new int[0];
    static final long[] b = new long[0];
    static final Object[] c = new Object[0];

    public static int a(int n2) {
        return c.c(n2 * 4) / 4;
    }

    static int a(int[] arrn, int n2, int n3) {
        --n2;
        int n4 = 0;
        while (n4 <= n2) {
            int n5 = n4 + n2 >>> 1;
            int n6 = arrn[n5];
            if (n6 < n3) {
                n4 = n5 + 1;
                continue;
            }
            if (n6 > n3) {
                n2 = n5 - 1;
                continue;
            }
            return n5;
        }
        return n4;
    }

    static int a(long[] arrl, int n2, long l2) {
        --n2;
        int n3 = 0;
        while (n3 <= n2) {
            int n4 = n3 + n2 >>> 1;
            long l3 = arrl[n4] LCMP l2;
            if (l3 < 0) {
                n3 = n4 + 1;
                continue;
            }
            if (l3 > 0) {
                n2 = n4 - 1;
                continue;
            }
            return n4;
        }
        return n3;
    }

    public static boolean a(Object object, Object object2) {
        return object == object2 || object != null && object.equals(object2);
        {
        }
    }

    public static int b(int n2) {
        return c.c(n2 * 8) / 8;
    }

    public static int c(int n2) {
        for (int i2 = 4; i2 < 32; ++i2) {
            int n3 = (1 << i2) - 12;
            if (n2 > n3) continue;
            return n3;
        }
        return n2;
    }
}

