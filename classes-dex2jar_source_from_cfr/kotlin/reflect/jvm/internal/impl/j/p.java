/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.a.m;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ae;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.ac;
import kotlin.reflect.jvm.internal.impl.a.c.f;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.n;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.o;
import kotlin.reflect.jvm.internal.impl.j.w;

public class p {
    public static final ad a;
    private static final y b;
    private static final a c;
    private static final w d;
    private static final ai e;
    private static final Set<ai> f;

    static {
        b = new y(){

            @Override
            public <R, D> R a(kotlin.reflect.jvm.internal.impl.a.o<R, D> o2, D d2) {
                return null;
            }

            @Override
            public Collection<kotlin.reflect.jvm.internal.impl.e.b> a(kotlin.reflect.jvm.internal.impl.e.b b2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b3) {
                return m.a();
            }

            @Override
            public ae a(kotlin.reflect.jvm.internal.impl.e.b b2) {
                throw new IllegalStateException("Should not be called!");
            }

            @Override
            public KotlinBuiltIns a() {
                return DefaultBuiltIns.getInstance();
            }

            @Override
            public boolean a(y y2) {
                return false;
            }

            @Override
            public kotlin.reflect.jvm.internal.impl.a.m b() {
                return null;
            }

            @Override
            public kotlin.reflect.jvm.internal.impl.e.f h_() {
                return kotlin.reflect.jvm.internal.impl.e.f.c("<ERROR MODULE>");
            }

            @Override
            public kotlin.reflect.jvm.internal.impl.a.m m_() {
                return this;
            }

            @Override
            public h x() {
                return h.a.a();
            }
        };
        c = new a(kotlin.reflect.jvm.internal.impl.e.f.c("<ERROR CLASS>"));
        a = p.c("<LOOP IN SUPERTYPES>");
        d = p.c("<ERROR PROPERTY TYPE>");
        e = p.c();
        f = Collections.singleton(e);
    }

    public static e a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ERROR CLASS: ");
        stringBuilder.append(string2);
        stringBuilder.append(">");
        return new a(kotlin.reflect.jvm.internal.impl.e.f.c(stringBuilder.toString()));
    }

    public static y a() {
        return b;
    }

    public static kotlin.reflect.jvm.internal.impl.h.e.h a(String string2, boolean bl2) {
        if (bl2) {
            return new c(string2);
        }
        return new b(string2);
    }

    public static ad a(String string2, List<ap> list) {
        return new o(p.e(string2), p.b(string2), list, false);
    }

    public static ad a(String string2, an an2) {
        return new o(an2, p.b(string2));
    }

    public static boolean a(kotlin.reflect.jvm.internal.impl.a.m m2) {
        boolean bl2 = false;
        if (m2 == null) {
            return false;
        }
        if (p.b(m2) || p.b(m2.b()) || m2 == b) {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean a(w w2) {
        return w2 != null && w2.g() instanceof d;
    }

    private static am b(b object) {
        object = new kotlin.reflect.jvm.internal.impl.j.b.a(c, (b)object);
        ((ac)object).b(null, null, Collections.emptyList(), Collections.<av>emptyList(), p.c("<ERROR FUNCTION RETURN TYPE>"), kotlin.reflect.jvm.internal.impl.a.w.c, az.e);
        return object;
    }

    public static kotlin.reflect.jvm.internal.impl.h.e.h b(String string2) {
        return p.a(string2, false);
    }

    private static an b(final String string2, final a a2) {
        return new an(){

            @Override
            public List<kotlin.reflect.jvm.internal.impl.a.as> b() {
                return m.a();
            }

            @Override
            public kotlin.reflect.jvm.internal.impl.a.h d() {
                return a2;
            }

            @Override
            public KotlinBuiltIns e() {
                return DefaultBuiltIns.getInstance();
            }

            @Override
            public boolean f() {
                return false;
            }

            @Override
            public Collection<w> k_() {
                return m.a();
            }

            public String toString() {
                return string2;
            }
        };
    }

    private static boolean b(kotlin.reflect.jvm.internal.impl.a.m m2) {
        return m2 instanceof a;
    }

    private static kotlin.reflect.jvm.internal.impl.a.c.y c() {
        kotlin.reflect.jvm.internal.impl.a.c.y y2 = kotlin.reflect.jvm.internal.impl.a.c.y.a(c, h.a.a(), kotlin.reflect.jvm.internal.impl.a.w.c, az.e, true, kotlin.reflect.jvm.internal.impl.e.f.c("<ERROR PROPERTY>"), b.a.a, kotlin.reflect.jvm.internal.impl.a.an.a, false, false, false, false, false, false);
        y2.a(d, Collections.emptyList(), null, (w)null);
        return y2;
    }

    public static ad c(String string2) {
        return p.a(string2, Collections.<ap>emptyList());
    }

    public static ad d(String string2) {
        return p.a(string2, p.f(string2));
    }

    public static an e(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ERROR : ");
        stringBuilder.append(string2);
        stringBuilder.append("]");
        return p.b(stringBuilder.toString(), c);
    }

    public static an f(String string2) {
        return p.b(string2, c);
    }

    private static class a
    extends kotlin.reflect.jvm.internal.impl.a.c.h {
        public a(kotlin.reflect.jvm.internal.impl.e.f object) {
            super(p.a(), (kotlin.reflect.jvm.internal.impl.e.f)object, kotlin.reflect.jvm.internal.impl.a.w.c, kotlin.reflect.jvm.internal.impl.a.f.a, Collections.<w>emptyList(), kotlin.reflect.jvm.internal.impl.a.an.a, false, kotlin.reflect.jvm.internal.impl.i.b.a);
            object = f.a(this, h.a.a(), true, kotlin.reflect.jvm.internal.impl.a.an.a);
            ((f)object).a(Collections.<av>emptyList(), az.d);
            kotlin.reflect.jvm.internal.impl.h.e.h h2 = p.b(this.h_().a());
            ((kotlin.reflect.jvm.internal.impl.a.c.o)object).a(new o(p.b("<ERROR>", this), h2));
            this.a(h2, Collections.singleton(object), (kotlin.reflect.jvm.internal.impl.a.d)object);
        }

        @Override
        public e a(au au2) {
            return this;
        }

        @Override
        public kotlin.reflect.jvm.internal.impl.h.e.h a(as as2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error scope for class ");
            stringBuilder.append(this.h_());
            stringBuilder.append(" with arguments: ");
            stringBuilder.append(as2);
            return p.b(stringBuilder.toString());
        }

        @Override
        public /* synthetic */ n d(au au2) {
            return this.a(au2);
        }

        @Override
        public String toString() {
            return this.h_().a();
        }
    }

    public static class b
    implements kotlin.reflect.jvm.internal.impl.h.e.h {
        private final String a;

        private b(String string2) {
            this.a = string2;
        }

        public /* synthetic */ Collection a(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
            return this.d(f2, b2);
        }

        @Override
        public Collection<kotlin.reflect.jvm.internal.impl.a.m> a(kotlin.reflect.jvm.internal.impl.h.e.d d2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b2) {
            return Collections.emptyList();
        }

        public /* synthetic */ Collection b(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
            return this.e(f2, b2);
        }

        @Override
        public kotlin.reflect.jvm.internal.impl.a.h c(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
            return p.a(f2.a());
        }

        public Set d(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
            return f;
        }

        public Set e(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
            return Collections.singleton(p.b(this));
        }

        @Override
        public Set<kotlin.reflect.jvm.internal.impl.e.f> l_() {
            return Collections.emptySet();
        }

        @Override
        public Set<kotlin.reflect.jvm.internal.impl.e.f> o_() {
            return Collections.emptySet();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ErrorScope{");
            stringBuilder.append(this.a);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static class c
    implements kotlin.reflect.jvm.internal.impl.h.e.h {
        private final String a;

        private c(String string2) {
            this.a = string2;
        }

        public Collection a(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b object) {
            object = new StringBuilder();
            ((StringBuilder)object).append(this.a);
            ((StringBuilder)object).append(", required name: ");
            ((StringBuilder)object).append(f2);
            throw new IllegalStateException(((StringBuilder)object).toString());
        }

        @Override
        public Collection<kotlin.reflect.jvm.internal.impl.a.m> a(kotlin.reflect.jvm.internal.impl.h.e.d d2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b2) {
            throw new IllegalStateException(this.a);
        }

        public Collection b(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b object) {
            object = new StringBuilder();
            ((StringBuilder)object).append(this.a);
            ((StringBuilder)object).append(", required name: ");
            ((StringBuilder)object).append(f2);
            throw new IllegalStateException(((StringBuilder)object).toString());
        }

        @Override
        public kotlin.reflect.jvm.internal.impl.a.h c(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b object) {
            object = new StringBuilder();
            ((StringBuilder)object).append(this.a);
            ((StringBuilder)object).append(", required name: ");
            ((StringBuilder)object).append(f2);
            throw new IllegalStateException(((StringBuilder)object).toString());
        }

        @Override
        public Set<kotlin.reflect.jvm.internal.impl.e.f> l_() {
            throw new IllegalStateException();
        }

        @Override
        public Set<kotlin.reflect.jvm.internal.impl.e.f> o_() {
            throw new IllegalStateException();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ThrowingScope{");
            stringBuilder.append(this.a);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static class d
    implements an {
        private final kotlin.reflect.jvm.internal.impl.a.as a;
        private final an b;

        public kotlin.reflect.jvm.internal.impl.a.as a() {
            return this.a;
        }

        @Override
        public List<kotlin.reflect.jvm.internal.impl.a.as> b() {
            return this.b.b();
        }

        @Override
        public kotlin.reflect.jvm.internal.impl.a.h d() {
            return this.b.d();
        }

        @Override
        public KotlinBuiltIns e() {
            return kotlin.reflect.jvm.internal.impl.h.c.a.d(this.a);
        }

        @Override
        public boolean f() {
            return this.b.f();
        }

        @Override
        public Collection<w> k_() {
            return this.b.k_();
        }
    }

}

