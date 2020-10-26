/*
 * Decompiled with CFR 0.139.
 */
package androidx.core.a.a;

import java.lang.reflect.Array;

final class e {
    static final /* synthetic */ boolean a;

    static {
        a = e.class.desiredAssertionStatus() ^ true;
    }

    private e() {
    }

    public static int a(int n2) {
        if (n2 <= 4) {
            return 8;
        }
        return n2 * 2;
    }

    public static int[] a(int[] arrn, int n2, int n3) {
        if (!a && n2 > arrn.length) {
            throw new AssertionError();
        }
        int[] arrn2 = arrn;
        if (n2 + 1 > arrn.length) {
            arrn2 = new int[e.a(n2)];
            System.arraycopy(arrn, 0, arrn2, 0, n2);
        }
        arrn2[n2] = n3;
        return arrn2;
    }

    public static <T> T[] a(T[] arrT, int n2, T t2) {
        if (!a && n2 > arrT.length) {
            throw new AssertionError();
        }
        Object[] arrobject = arrT;
        if (n2 + 1 > arrT.length) {
            arrobject = (Object[])Array.newInstance(arrT.getClass().getComponentType(), e.a(n2));
            System.arraycopy(arrT, 0, arrobject, 0, n2);
        }
        arrobject[n2] = t2;
        return arrobject;
    }
}

