/*
 * Decompiled with CFR 0.139.
 */
package c.a.e;

public enum b {
    a(0),
    b(1),
    c(2),
    d(3),
    e(7),
    f(8),
    g(9),
    h(10),
    i(11),
    j(12),
    k(13);
    
    public final int l;

    private b(int n3) {
        this.l = n3;
    }

    public static b a(int n2) {
        for (b b2 : b.values()) {
            if (b2.l != n2) continue;
            return b2;
        }
        return null;
    }
}

