/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.b;

final class c<V> {
    static final c<Object> a = new c<V>();
    private final long b;
    private final V c;
    private final c<V> d;
    private final c<V> e;
    private final int f;

    private c() {
        this.f = 0;
        this.b = 0L;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    private c(long l2, V v2, c<V> c2, c<V> c3) {
        this.b = l2;
        this.c = v2;
        this.d = c2;
        this.e = c3;
        this.f = c2.f + 1 + c3.f;
    }

    private static <V> c<V> a(long l2, V v2, c<V> c2, c<V> c3) {
        if (c2.f + c3.f > 1) {
            if (c2.f >= c3.f * 5) {
                c<V> c4 = c2.d;
                c<V> c5 = c2.e;
                if (c5.f < c4.f * 2) {
                    return new c<V>(c2.b + l2, c2.c, c4, new c<V>(-c2.b, v2, c.super.b(c5.b + c2.b), c3));
                }
                c<V> c6 = c5.d;
                c<V> c7 = c5.e;
                return new c<V>(c5.b + c2.b + l2, c5.c, new c<V>(-c5.b, c2.c, c4, c.super.b(c6.b + c5.b)), new c<V>(-c2.b - c5.b, v2, c.super.b(c7.b + c5.b + c2.b), c3));
            }
            if (c3.f >= c2.f * 5) {
                c<V> c8 = c3.d;
                c<V> c9 = c3.e;
                if (c8.f < c9.f * 2) {
                    return new c<V>(c3.b + l2, c3.c, new c<V>(-c3.b, v2, c2, c.super.b(c8.b + c3.b)), c9);
                }
                c<V> c10 = c8.d;
                c<V> c11 = c8.e;
                return new c<V>(c8.b + c3.b + l2, c8.c, new c<V>(-c3.b - c8.b, v2, c2, c.super.b(c10.b + c8.b + c3.b)), new c<V>(-c8.b, c3.c, c.super.b(c11.b + c8.b), c9));
            }
        }
        return new c<V>(l2, v2, c2, c3);
    }

    private c<V> a(c<V> c2, c<V> c3) {
        if (c2 == this.d && c3 == this.e) {
            return this;
        }
        return c.a(this.b, this.c, c2, c3);
    }

    private c<V> b(long l2) {
        if (this.f != 0) {
            if (l2 == this.b) {
                return this;
            }
            return new c<V>(l2, this.c, this.d, this.e);
        }
        return this;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    V a(long l2) {
        c<V> c2;
        if (this.f == 0) {
            return null;
        }
        if (l2 < this.b) {
            c2 = this.d;
            do {
                return c2.a(l2 - this.b);
                break;
            } while (true);
        }
        if (l2 <= this.b) return this.c;
        c2 = this.e;
        return c2.a(l2 - this.b);
    }

    c<V> a(long l2, V v2) {
        if (this.f == 0) {
            return new c<V>(l2, v2, this, this);
        }
        if (l2 < this.b) {
            return this.a(this.d.a(l2 - this.b, v2), this.e);
        }
        if (l2 > this.b) {
            return this.a(this.d, this.e.a(l2 - this.b, v2));
        }
        if (v2 == this.c) {
            return this;
        }
        return new c<V>(l2, v2, this.d, this.e);
    }
}

