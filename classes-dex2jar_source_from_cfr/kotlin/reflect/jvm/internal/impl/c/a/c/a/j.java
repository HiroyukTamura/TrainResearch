/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.al;
import kotlin.e.b.k;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.b;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.f;
import kotlin.reflect.jvm.internal.impl.c.a.c.h;
import kotlin.reflect.jvm.internal.impl.c.a.e.aa;
import kotlin.reflect.jvm.internal.impl.c.a.e.g;
import kotlin.reflect.jvm.internal.impl.c.a.e.t;
import kotlin.reflect.jvm.internal.impl.c.a.i;
import kotlin.reflect.jvm.internal.impl.c.b.a.a;
import kotlin.reflect.jvm.internal.impl.c.b.n;
import kotlin.reflect.jvm.internal.impl.h.e.d;

public final class j
extends kotlin.reflect.jvm.internal.impl.c.a.c.a.m {
    private final kotlin.reflect.jvm.internal.impl.i.g<Set<String>> b;
    private final kotlin.reflect.jvm.internal.impl.i.d<a, e> d;
    private final t e;
    private final kotlin.reflect.jvm.internal.impl.c.a.c.a.h f;

    public j(final h h2, t t2, kotlin.reflect.jvm.internal.impl.c.a.c.a.h h3) {
        kotlin.e.b.j.b(h2, "c");
        kotlin.e.b.j.b(t2, "jPackage");
        kotlin.e.b.j.b(h3, "ownerDescriptor");
        super(h2);
        this.e = t2;
        this.f = h3;
        this.b = h2.c().b((kotlin.e.a.a)new kotlin.e.a.a<Set<? extends String>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Set<String> b() {
                return h2.e().b().b(this.c().f());
            }
        });
        this.d = h2.c().b((kotlin.e.a.b)new kotlin.e.a.b<a, e>(){

            @Override
            public final e a(a object) {
                kotlin.e.b.j.b(object, "request");
                kotlin.reflect.jvm.internal.impl.e.a a2 = new kotlin.reflect.jvm.internal.impl.e.a(this.c().f(), ((a)object).a());
                Object object2 = ((a)object).b() != null ? h2.e().c().a(((a)object).b()) : h2.e().c().a(a2);
                kotlin.reflect.jvm.internal.impl.e.a a3 = object2 != null ? object2.b() : null;
                if (a3 != null && (a3.f() || a3.d())) {
                    return null;
                }
                if ((object2 = this.a((n)object2)) instanceof b.a) {
                    return ((b.a)object2).a();
                }
                if (object2 instanceof b.c) {
                    return null;
                }
                if (object2 instanceof b.b) {
                    if ((object = ((a)object).b()) == null) {
                        object = h2.e().b().a(a2);
                    }
                    object2 = object != null ? object.j() : null;
                    if (object2 != aa.b) {
                        object2 = object != null ? object.c() : null;
                        if (object2 != null && !((kotlin.reflect.jvm.internal.impl.e.b)object2).c() && !(kotlin.e.b.j.a((Object)((kotlin.reflect.jvm.internal.impl.e.b)object2).d(), (Object)this.c().f()) ^ true)) {
                            object = new f(h2, this.c(), (g)object, null, 8, null);
                            h2.e().r().a((kotlin.reflect.jvm.internal.impl.c.a.b.d)object);
                        } else {
                            object = null;
                        }
                        return (e)object;
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Couldn't find kotlin binary class for light class created by kotlin binary file\n");
                    ((StringBuilder)object2).append("JavaClass: ");
                    ((StringBuilder)object2).append(object);
                    ((StringBuilder)object2).append('\n');
                    ((StringBuilder)object2).append("ClassId: ");
                    ((StringBuilder)object2).append(a2);
                    ((StringBuilder)object2).append('\n');
                    ((StringBuilder)object2).append("findKotlinClass(JavaClass) = ");
                    ((StringBuilder)object2).append(h2.e().c().a((g)object));
                    ((StringBuilder)object2).append('\n');
                    ((StringBuilder)object2).append("findKotlinClass(ClassId) = ");
                    ((StringBuilder)object2).append(h2.e().c().a(a2));
                    ((StringBuilder)object2).append('\n');
                    throw (Throwable)new IllegalStateException(((StringBuilder)object2).toString());
                }
                throw new m();
            }
        });
    }

    private final e a(kotlin.reflect.jvm.internal.impl.e.f f2, g g2) {
        if (!kotlin.reflect.jvm.internal.impl.e.h.b(f2)) {
            return null;
        }
        Set set = (Set)this.b.a();
        if (g2 == null && set != null && !set.contains(f2.a())) {
            return null;
        }
        return (e)this.d.a(new a(f2, g2));
    }

    /*
     * Enabled aggressive block sorting
     */
    private final b a(n object) {
        block5 : {
            block4 : {
                if (object == null) break block4;
                if (object.d().d() != a.a.b) {
                    object = b.c.a;
                    return (b)object;
                }
                object = this.j().e().d().a((n)object);
                if (object != null) break block5;
            }
            object = b.b.a;
            return (b)object;
        }
        return new b.a((e)object);
    }

    @Override
    public Collection<ai> a(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(b2, "location");
        return kotlin.a.m.a();
    }

    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.a.m> a(kotlin.reflect.jvm.internal.impl.h.e.d d2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b2) {
        kotlin.e.b.j.b(d2, "kindFilter");
        kotlin.e.b.j.b(b2, "nameFilter");
        return this.a(d2, b2, kotlin.reflect.jvm.internal.impl.b.a.d.m);
    }

    public final e a(g g2) {
        kotlin.e.b.j.b(g2, "javaClass");
        return this.a(g2.r(), g2);
    }

    @Override
    protected void a(Collection<am> collection, kotlin.reflect.jvm.internal.impl.e.f f2) {
        kotlin.e.b.j.b(collection, "result");
        kotlin.e.b.j.b(f2, "name");
    }

    @Override
    protected Set<kotlin.reflect.jvm.internal.impl.e.f> c(kotlin.reflect.jvm.internal.impl.h.e.d d2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b2) {
        kotlin.e.b.j.b(d2, "kindFilter");
        return al.a();
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.h c(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        return this.e(f2, b2);
    }

    protected kotlin.reflect.jvm.internal.impl.c.a.c.a.h c() {
        return this.f;
    }

    @Override
    protected Set<kotlin.reflect.jvm.internal.impl.e.f> d(kotlin.reflect.jvm.internal.impl.h.e.d object, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> object2) {
        kotlin.e.b.j.b(object, "kindFilter");
        if (!((kotlin.reflect.jvm.internal.impl.h.e.d)object).a(kotlin.reflect.jvm.internal.impl.h.e.d.k.a())) {
            return al.a();
        }
        object = (Set)this.b.a();
        if (object != null) {
            object2 = (Iterable)object;
            object = new HashSet();
            object2 = object2.iterator();
            while (object2.hasNext()) {
                object.add(kotlin.reflect.jvm.internal.impl.e.f.a((String)object2.next()));
            }
            return (Set)object;
        }
        object = this.e;
        if (object2 == null) {
            object2 = kotlin.reflect.jvm.internal.impl.l.d.a();
        }
        object = object.a((kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean>)object2);
        object2 = new LinkedHashSet();
        Iterator iterator = object.iterator();
        while (iterator.hasNext()) {
            object = (g)iterator.next();
            object = object.j() == aa.a ? null : object.r();
            if (object == null) continue;
            object2.add(object);
        }
        return (Set)object2;
    }

    @Override
    protected kotlin.reflect.jvm.internal.impl.c.a.c.a.b d() {
        return b.a.a;
    }

    @Override
    protected Set<kotlin.reflect.jvm.internal.impl.e.f> e(kotlin.reflect.jvm.internal.impl.h.e.d d2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b2) {
        kotlin.e.b.j.b(d2, "kindFilter");
        return al.a();
    }

    public e e(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(b2, "location");
        return this.a(f2, (g)null);
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.m h() {
        return this.c();
    }

    private static final class a {
        private final kotlin.reflect.jvm.internal.impl.e.f a;
        private final g b;

        public a(kotlin.reflect.jvm.internal.impl.e.f f2, g g2) {
            kotlin.e.b.j.b(f2, "name");
            this.a = f2;
            this.b = g2;
        }

        public final kotlin.reflect.jvm.internal.impl.e.f a() {
            return this.a;
        }

        public final g b() {
            return this.b;
        }

        public boolean equals(Object object) {
            return object instanceof a && kotlin.e.b.j.a((Object)this.a, (Object)((a)object).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    private static abstract class kotlin.reflect.jvm.internal.impl.c.a.c.a.j$b {
        private kotlin.reflect.jvm.internal.impl.c.a.c.a.j$b() {
        }

        public /* synthetic */ kotlin.reflect.jvm.internal.impl.c.a.c.a.j$b(kotlin.e.b.g g2) {
            this();
        }

        public static final class a
        extends kotlin.reflect.jvm.internal.impl.c.a.c.a.j$b {
            private final e a;

            public a(e e2) {
                kotlin.e.b.j.b(e2, "descriptor");
                super(null);
                this.a = e2;
            }

            public final e a() {
                return this.a;
            }
        }

        public static final class b
        extends kotlin.reflect.jvm.internal.impl.c.a.c.a.j$b {
            public static final b a = new b();

            private b() {
                super(null);
            }
        }

        public static final class c
        extends kotlin.reflect.jvm.internal.impl.c.a.c.a.j$b {
            public static final c a = new c();

            private c() {
                super(null);
            }
        }

    }

}

