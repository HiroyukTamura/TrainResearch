/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.e.a.b;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.ar;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.l;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.g.c;
import kotlin.reflect.jvm.internal.impl.g.g;
import kotlin.reflect.jvm.internal.impl.g.h;
import kotlin.reflect.jvm.internal.impl.h.c;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.w;

public class f
implements Comparator<m> {
    public static final f a;
    static final /* synthetic */ boolean b;
    private static final kotlin.reflect.jvm.internal.impl.g.c c;

    static {
        b = f.class.desiredAssertionStatus() ^ true;
        a = new f();
        c = kotlin.reflect.jvm.internal.impl.g.c.j.a((b<? super h, w>)new b<h, w>(){

            @Override
            public w a(h h2) {
                h2.f(false);
                h2.e(true);
                h2.a(kotlin.reflect.jvm.internal.impl.g.a.b);
                h2.b(g.l);
                return w.a;
            }
        });
    }

    private f() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int a(m m2, m m3) {
        int n2;
        Object object = a.c(m2, m3);
        if (object != null) {
            return (Integer)object;
        }
        if (m2 instanceof ar && m3 instanceof ar) {
            object = (ar)m2;
            ar ar2 = (ar)m3;
            n2 = c.a(object.a()).compareTo(c.a(ar2.a()));
            if (n2 != 0) {
                return n2;
            }
        } else {
            boolean bl2 = m2 instanceof kotlin.reflect.jvm.internal.impl.a.a;
            int n3 = 1;
            if (bl2 && m3 instanceof kotlin.reflect.jvm.internal.impl.a.a) {
                Object object2 = (kotlin.reflect.jvm.internal.impl.a.a)m2;
                object = (kotlin.reflect.jvm.internal.impl.a.a)m3;
                List<as> list = object2.d();
                List<as> list2 = object.d();
                if (!b) {
                    n2 = list != null ? 1 : 0;
                    if (list2 == null) {
                        n3 = 0;
                    }
                    if (n2 != n3) {
                        throw new AssertionError();
                    }
                }
                if (list != null && (n2 = c.a(list.r()).compareTo(c.a(list2.r()))) != 0) {
                    return n2;
                }
                list = object2.i();
                list2 = object.i();
                for (n2 = 0; n2 < Math.min(list.size(), list2.size()); ++n2) {
                    n3 = c.a(((av)list.get(n2)).r()).compareTo(c.a(((av)list2.get(n2)).r()));
                    if (n3 == 0) continue;
                    return n3;
                }
                n2 = list.size() - list2.size();
                if (n2 != 0) {
                    return n2;
                }
                list = object2.f();
                list2 = object.f();
                for (n2 = 0; n2 < Math.min(list.size(), list2.size()); ++n2) {
                    List<kotlin.reflect.jvm.internal.impl.j.w> list3 = list.get(n2).j();
                    List<kotlin.reflect.jvm.internal.impl.j.w> list4 = list2.get(n2).j();
                    n3 = list3.size() - list4.size();
                    if (n3 != 0) {
                        return n3;
                    }
                    for (n3 = 0; n3 < list3.size(); ++n3) {
                        int n4 = c.a(list3.get(n3)).compareTo(c.a(list4.get(n3)));
                        if (n4 == 0) continue;
                        return n4;
                    }
                }
                n2 = list.size() - list2.size();
                if (n2 != 0) {
                    return n2;
                }
                if (object2 instanceof kotlin.reflect.jvm.internal.impl.a.b && object instanceof kotlin.reflect.jvm.internal.impl.a.b) {
                    object2 = ((kotlin.reflect.jvm.internal.impl.a.b)object2).n();
                    object = ((kotlin.reflect.jvm.internal.impl.a.b)object).n();
                    n2 = ((Enum)object2).ordinal() - ((Enum)object).ordinal();
                    if (n2 != 0) {
                        return n2;
                    }
                }
            } else {
                if (!(m2 instanceof e) || !(m3 instanceof e)) throw new AssertionError((Object)String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", m2, m2.getClass(), m3, m3.getClass()));
                object = (e)m2;
                e e2 = (e)m3;
                if (object.l().ordinal() != e2.l().ordinal()) {
                    return object.l().ordinal() - e2.l().ordinal();
                }
                if (object.q() != e2.q()) {
                    if (!object.q()) return -1;
                    return 1;
                }
            }
        }
        if ((n2 = c.a(m2).compareTo(c.a(m3))) == 0) return c.g(m2).h_().a(c.g(m3).h_());
        return n2;
    }

    @Override
    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((m)object, (m)object2);
    }

    public static class a
    implements Comparator<m> {
        public static final a a = new a();

        private a() {
        }

        private static int a(m m2) {
            if (c.l(m2)) {
                return 8;
            }
            if (m2 instanceof l) {
                return 7;
            }
            if (m2 instanceof ai) {
                if (((ai)m2).d() == null) {
                    return 6;
                }
                return 5;
            }
            if (m2 instanceof t) {
                if (((t)m2).d() == null) {
                    return 4;
                }
                return 3;
            }
            if (m2 instanceof e) {
                return 2;
            }
            return m2 instanceof ar;
        }

        private static Integer c(m m2, m m3) {
            int n2 = a.a(m3) - a.a(m2);
            if (n2 != 0) {
                return n2;
            }
            if (c.l(m2) && c.l(m3)) {
                return 0;
            }
            n2 = m2.h_().a(m3.h_());
            if (n2 != 0) {
                return n2;
            }
            return null;
        }

        public int a(m object, m m2) {
            if ((object = a.c((m)object, m2)) != null) {
                return (Integer)object;
            }
            return 0;
        }

        @Override
        public /* synthetic */ int compare(Object object, Object object2) {
            return this.a((m)object, (m)object2);
        }
    }

}

