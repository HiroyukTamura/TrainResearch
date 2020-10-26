/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.c.b.y;
import kotlin.reflect.jvm.internal.impl.j.ba;

public final class x {
    public static final x a;
    public static final x b;
    public static final x c;
    public static final x d;
    public static final x e;
    public static final x f;
    public static final x g;
    public static final a h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final x n;
    private final boolean o;
    private final x p;
    private final x q;

    static {
        h = new a(null);
        a = new x(false, false, false, false, false, null, false, null, null, 511, null);
        b = new x(false, true, false, false, false, null, false, null, null, 509, null);
        c = new x(false, false, false, false, false, a, false, null, null, 476, null);
        d = new x(false, true, false, false, false, a, false, null, null, 476, null);
        e = new x(false, false, false, true, false, a, false, null, null, 471, null);
        f = new x(false, false, false, true, false, a, false, null, null, 407, null);
        g = new x(false, false, true, false, false, new x(false, false, true, false, false, a, false, null, null, 475, null), false, null, null, 472, null);
    }

    private x(boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, x x2, boolean bl7, x x3, x x4) {
        this.i = bl2;
        this.j = bl3;
        this.k = bl4;
        this.l = bl5;
        this.m = bl6;
        this.n = x2;
        this.o = bl7;
        this.p = x3;
        this.q = x4;
    }

    /* synthetic */ x(boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, x x2, boolean bl7, x x3, x x4, int n2, g g2) {
        boolean bl8 = true;
        if ((n2 & 1) != 0) {
            bl2 = true;
        }
        if ((n2 & 2) != 0) {
            bl3 = true;
        }
        boolean bl9 = false;
        if ((n2 & 4) != 0) {
            bl4 = false;
        }
        if ((n2 & 8) != 0) {
            bl5 = false;
        }
        if ((n2 & 16) != 0) {
            bl6 = bl9;
        }
        if ((n2 & 32) != 0) {
            x2 = null;
        }
        if ((n2 & 64) != 0) {
            bl7 = bl8;
        }
        if ((n2 & 128) != 0) {
            x3 = x2;
        }
        if ((n2 & 256) != 0) {
            x4 = x2;
        }
        this(bl2, bl3, bl4, bl5, bl6, x2, bl7, x3, x4);
    }

    public final x a() {
        return new x(this.i, true, this.k, this.l, this.m, this.n, this.o, this.p, this.q);
    }

    public final x a(ba object) {
        j.b(object, "effectiveVariance");
        switch (y.a[object.ordinal()]) {
            default: {
                object = this.n;
                if (object == null) break;
                return object;
            }
            case 2: {
                object = this.q;
                if (object == null) break;
                return object;
            }
            case 1: {
                object = this.p;
                if (object == null) break;
                return object;
            }
        }
        return this;
    }

    public final boolean b() {
        return this.i;
    }

    public final boolean c() {
        return this.j;
    }

    public final boolean d() {
        return this.k;
    }

    public final boolean e() {
        return this.o;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

}

