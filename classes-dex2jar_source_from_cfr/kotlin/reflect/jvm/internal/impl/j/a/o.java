/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.a;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Set;
import kotlin.e.b.g;
import kotlin.reflect.jvm.internal.impl.j.a.e;
import kotlin.reflect.jvm.internal.impl.j.a.k;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.at;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.t;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.l.j;
import kotlin.y;

public class o {
    private int a;
    private boolean b;
    private ArrayDeque<ad> c;
    private Set<ad> d;
    private final boolean e;
    private final boolean f;

    public o(boolean bl2, boolean bl3) {
        this.e = bl2;
        this.f = bl3;
    }

    public /* synthetic */ o(boolean bl2, boolean bl3, int n2, g g2) {
        if ((n2 & 2) != 0) {
            bl3 = true;
        }
        this(bl2, bl3);
    }

    public static final /* synthetic */ int a(o o2) {
        return o2.a;
    }

    public static final /* synthetic */ void a(o o2, int n2) {
        o2.a = n2;
    }

    public static final /* synthetic */ void b(o o2) {
        o2.c();
    }

    public static final /* synthetic */ ArrayDeque c(o o2) {
        return o2.c;
    }

    private final void c() {
        boolean bl2 = this.b;
        if (y.a && !(bl2 ^ true)) {
            throw (Throwable)((Object)new AssertionError((Object)"Assertion failed"));
        }
        this.b = true;
        if (this.c == null) {
            this.c = new ArrayDeque(4);
        }
        if (this.d == null) {
            this.d = j.a.a();
        }
    }

    public static final /* synthetic */ Set d(o o2) {
        return o2.d;
    }

    private final void d() {
        Collection<ad> collection = this.c;
        if (collection == null) {
            kotlin.e.b.j.a();
        }
        ((ArrayDeque)collection).clear();
        collection = this.d;
        if (collection == null) {
            kotlin.e.b.j.a();
        }
        collection.clear();
        this.b = false;
    }

    public static final /* synthetic */ void e(o o2) {
        o2.d();
    }

    public Boolean a(az az2, az az3) {
        kotlin.e.b.j.b(az2, "subType");
        kotlin.e.b.j.b(az3, "superType");
        return null;
    }

    public a a(ad ad2, e e2) {
        kotlin.e.b.j.b(ad2, "subType");
        kotlin.e.b.j.b(e2, "superType");
        return a.b;
    }

    public b a() {
        return b.d;
    }

    public boolean a(an an2, an an3) {
        kotlin.e.b.j.b(an2, "a");
        kotlin.e.b.j.b(an3, "b");
        return kotlin.e.b.j.a((Object)an2, (Object)an3);
    }

    public final boolean a(az az2) {
        kotlin.e.b.j.b(az2, "$receiver");
        return this.f && az2.g() instanceof k;
    }

    public final boolean b() {
        return this.e;
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        private static final /* synthetic */ a[] d;

        static {
            a a2;
            a a3;
            a a4;
            a = a3 = new a();
            b = a4 = new a();
            c = a2 = new a();
            d = new a[]{a3, a4, a2};
        }

        public static a valueOf(String string2) {
            return Enum.valueOf(a.class, string2);
        }

        public static a[] values() {
            return (a[])d.clone();
        }
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b a;
        public static final /* enum */ b b;
        public static final /* enum */ b c;
        public static final /* enum */ b d;
        private static final /* synthetic */ b[] e;

        static {
            b b2;
            b b3;
            b b4;
            b b5;
            a = b2 = new b();
            b = b3 = new b();
            c = b4 = new b();
            d = b5 = new b();
            e = new b[]{b2, b3, b4, b5};
        }

        public static b valueOf(String string2) {
            return Enum.valueOf(b.class, string2);
        }

        public static b[] values() {
            return (b[])e.clone();
        }
    }

    public static abstract class kotlin.reflect.jvm.internal.impl.j.a.o$c {
        private kotlin.reflect.jvm.internal.impl.j.a.o$c() {
        }

        public /* synthetic */ kotlin.reflect.jvm.internal.impl.j.a.o$c(g g2) {
            this();
        }

        public abstract ad a(w var1);

        public static final class a
        extends kotlin.reflect.jvm.internal.impl.j.a.o$c {
            public static final a a = new a();

            private a() {
                super(null);
            }

            @Override
            public ad a(w w2) {
                kotlin.e.b.j.b(w2, "type");
                return t.c(w2);
            }
        }

        public static final class b
        extends kotlin.reflect.jvm.internal.impl.j.a.o$c {
            private final au a;

            public b(au au2) {
                kotlin.e.b.j.b(au2, "substitutor");
                super(null);
                this.a = au2;
            }

            @Override
            public ad a(w w2) {
                kotlin.e.b.j.b(w2, "type");
                w2 = this.a.a(t.c(w2), ba.a);
                kotlin.e.b.j.a((Object)w2, "substitutor.safeSubstitu\u2026le(), Variance.INVARIANT)");
                return at.a(w2);
            }
        }

        public static final class c
        extends kotlin.reflect.jvm.internal.impl.j.a.o$c {
            public static final c a = new c();

            private c() {
                super(null);
            }

            @Override
            public /* synthetic */ ad a(w w2) {
                return (ad)((Object)this.b(w2));
            }

            public Void b(w w2) {
                kotlin.e.b.j.b(w2, "type");
                throw (Throwable)new UnsupportedOperationException("Should not be called");
            }
        }

        public static final class d
        extends kotlin.reflect.jvm.internal.impl.j.a.o$c {
            public static final d a = new d();

            private d() {
                super(null);
            }

            @Override
            public ad a(w w2) {
                kotlin.e.b.j.b(w2, "type");
                return t.d(w2);
            }
        }

    }

}

