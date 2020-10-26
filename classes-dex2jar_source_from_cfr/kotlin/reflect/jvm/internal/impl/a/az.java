/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.a.al;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ao;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.ae;
import kotlin.reflect.jvm.internal.impl.a.d;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.i;
import kotlin.reflect.jvm.internal.impl.a.l;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.q;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.h.c;
import kotlin.reflect.jvm.internal.impl.h.e.a.f;
import kotlin.reflect.jvm.internal.impl.h.e.a.g;
import kotlin.reflect.jvm.internal.impl.j.n;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.k.g;
import kotlin.reflect.jvm.internal.impl.l.a;

public class az {
    public static final ba a = new ba("private", false){

        private boolean a(m m2) {
            return c.r(m2) != ao.a;
        }

        @Override
        public boolean a(kotlin.reflect.jvm.internal.impl.h.e.a.e object, q object2, m m2) {
            block16 : {
                m m3;
                if (c.f((m)object2) && this.a(m2)) {
                    return az.a((m)object2, m2);
                }
                object = object2;
                if (object2 instanceof l) {
                    m3 = ((l)object2).q();
                    object = object2;
                    if (c.j(m3)) {
                        object = object2;
                        if (c.f(m3)) {
                            object = object2;
                            if (m2 instanceof l) {
                                object = object2;
                                if (c.f(m2.b())) {
                                    object = object2;
                                    if (az.a((m)object2, m2)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                do {
                    object2 = object;
                    if (object == null) break block16;
                    m3 = object.b();
                    if (m3 instanceof e) {
                        object2 = m3;
                        if (!c.i(m3)) break block16;
                    }
                    object = m3;
                } while (!(m3 instanceof ab));
                object2 = m3;
            }
            boolean bl2 = false;
            if (object2 == null) {
                return false;
            }
            while (m2 != null) {
                if (object2 == m2) {
                    return true;
                }
                if (m2 instanceof ab) {
                    boolean bl3 = bl2;
                    if (object2 instanceof ab) {
                        bl3 = bl2;
                        if (((ab)object2).f().equals(((ab)m2).f())) {
                            bl3 = bl2;
                            if (c.a(m2, (m)object2)) {
                                bl3 = true;
                            }
                        }
                    }
                    return bl3;
                }
                m2 = m2.b();
            }
            return false;
        }
    };
    public static final ba b = new ba("private_to_this", false){

        @Override
        public String a() {
            return "private/*private to this*/";
        }

        @Override
        public boolean a(kotlin.reflect.jvm.internal.impl.h.e.a.e e2, q q2, m m2) {
            if (az.a.a(e2, q2, m2)) {
                if (e2 == az.l) {
                    return true;
                }
                if (e2 == o) {
                    return false;
                }
                if ((q2 = c.a((m)q2, e.class)) != null && e2 instanceof g) {
                    return ((g)e2).c().E().equals(q2.m_());
                }
            }
            return false;
        }
    };
    public static final ba c = new ba("protected", true){

        private boolean a(kotlin.reflect.jvm.internal.impl.h.e.a.e object, q q2, e e2) {
            boolean bl2;
            block8 : {
                block9 : {
                    kotlin.reflect.jvm.internal.impl.h.e.a.e e3 = az.m;
                    boolean bl3 = false;
                    if (object == e3) {
                        return false;
                    }
                    if (!(q2 instanceof b)) {
                        return true;
                    }
                    if (q2 instanceof l) {
                        return true;
                    }
                    if (object == az.l) {
                        return true;
                    }
                    bl2 = bl3;
                    if (object == o) break block8;
                    if (object == null) {
                        return false;
                    }
                    if (c.a((w)(object = object instanceof f ? ((f)object).b() : object.a()), (m)e2)) break block9;
                    bl2 = bl3;
                    if (!n.a((w)object)) break block8;
                }
                bl2 = true;
            }
            return bl2;
        }

        @Override
        public boolean a(kotlin.reflect.jvm.internal.impl.h.e.a.e e2, q q2, m m2) {
            q q3 = c.a((m)q2, e.class);
            if ((m2 = c.a(m2, e.class, false)) == null) {
                return false;
            }
            if (q3 != null && c.i(q3) && (q3 = c.a((m)q3, e.class)) != null && c.b((e)m2, q3)) {
                return true;
            }
            q3 = c.a(q2);
            e e3 = c.a((m)q3, e.class);
            if (e3 == null) {
                return false;
            }
            if (c.b((e)m2, e3) && this.a(e2, q3, (e)m2)) {
                return true;
            }
            return this.a(e2, q2, m2.b());
        }
    };
    public static final ba d = new ba("internal", false){

        @Override
        public boolean a(kotlin.reflect.jvm.internal.impl.h.e.a.e object, q q2, m m2) {
            object = c.g(q2);
            if (!c.g(m2).a((y)object)) {
                return false;
            }
            return p.a(q2, m2);
        }
    };
    public static final ba e = new ba("public", true){

        @Override
        public boolean a(kotlin.reflect.jvm.internal.impl.h.e.a.e e2, q q2, m m2) {
            return true;
        }
    };
    public static final ba f = new ba("local", false){

        @Override
        public boolean a(kotlin.reflect.jvm.internal.impl.h.e.a.e e2, q q2, m m2) {
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    };
    public static final ba g = new ba("inherited", false){

        @Override
        public boolean a(kotlin.reflect.jvm.internal.impl.h.e.a.e e2, q q2, m m2) {
            throw new IllegalStateException("Visibility is unknown yet");
        }
    };
    public static final ba h = new ba("invisible_fake", false){

        @Override
        public boolean a(kotlin.reflect.jvm.internal.impl.h.e.a.e e2, q q2, m m2) {
            return false;
        }
    };
    public static final ba i = new ba("unknown", false){

        @Override
        public boolean a(kotlin.reflect.jvm.internal.impl.h.e.a.e e2, q q2, m m2) {
            return false;
        }
    };
    public static final Set<ba> j = Collections.unmodifiableSet(al.a(a, b, d, f));
    public static final ba k;
    public static final kotlin.reflect.jvm.internal.impl.h.e.a.e l;
    @Deprecated
    public static final kotlin.reflect.jvm.internal.impl.h.e.a.e m;
    private static final Map<ba, Integer> n;
    private static final kotlin.reflect.jvm.internal.impl.h.e.a.e o;
    private static final kotlin.reflect.jvm.internal.impl.k.g p;

    static {
        Object object = a.a(4);
        object.put(b, 0);
        object.put(a, 0);
        object.put(d, 1);
        object.put(c, 1);
        object.put(e, 2);
        n = Collections.unmodifiableMap(object);
        k = e;
        o = new kotlin.reflect.jvm.internal.impl.h.e.a.e(){

            @Override
            public w a() {
                throw new IllegalStateException("This method should not be called");
            }
        };
        l = new kotlin.reflect.jvm.internal.impl.h.e.a.e(){

            @Override
            public w a() {
                throw new IllegalStateException("This method should not be called");
            }
        };
        m = new kotlin.reflect.jvm.internal.impl.h.e.a.e(){

            @Override
            public w a() {
                throw new IllegalStateException("This method should not be called");
            }
        };
        object = ServiceLoader.load(kotlin.reflect.jvm.internal.impl.k.g.class, kotlin.reflect.jvm.internal.impl.k.g.class.getClassLoader()).iterator();
        object = object.hasNext() ? (kotlin.reflect.jvm.internal.impl.k.g)object.next() : g.a.a;
        p = object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static Integer a(ba object, ba object2) {
        int n2;
        if (object == object2) {
            n2 = 0;
            do {
                return n2;
                break;
            } while (true);
        }
        object = n.get(object);
        object2 = n.get(object2);
        if (object == null || object2 == null || ((Integer)object).equals(object2)) return null;
        n2 = (Integer)object - (Integer)object2;
        return n2;
    }

    public static q a(kotlin.reflect.jvm.internal.impl.h.e.a.e object, q q2, m m2) {
        m m3 = q2.m_();
        while ((m3 = (q)m3) != null && m3.p() != f) {
            if (!m3.p().a((kotlin.reflect.jvm.internal.impl.h.e.a.e)object, (q)m3, m2)) {
                return m3;
            }
            m3 = c.a(m3, q.class);
        }
        if (q2 instanceof ae && (object = az.a((kotlin.reflect.jvm.internal.impl.h.e.a.e)object, ((ae)q2).o(), m2)) != null) {
            return object;
        }
        return null;
    }

    public static boolean a(ba ba2) {
        return ba2 == a || ba2 == b;
        {
        }
    }

    public static boolean a(m m2, m object) {
        if ((object = c.r((m)object)) != ao.a) {
            return object.equals(c.r(m2));
        }
        return false;
    }

    public static boolean a(q q2, m m2) {
        return az.a(l, q2, m2) == null;
    }

    public static Integer b(ba object, ba ba2) {
        Integer n2 = ((ba)object).a(ba2);
        if (n2 != null) {
            return n2;
        }
        if ((object = ba2.a((ba)object)) != null) {
            return -((Integer)object).intValue();
        }
        return null;
    }

}

