/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.al;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.aa;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.aq;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.at;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.b.a.d;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.g;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.l;
import kotlin.reflect.jvm.internal.impl.c.a.c.h;
import kotlin.reflect.jvm.internal.impl.c.a.e.aa;
import kotlin.reflect.jvm.internal.impl.c.a.e.v;
import kotlin.reflect.jvm.internal.impl.c.a.m;
import kotlin.reflect.jvm.internal.impl.c.a.o;
import kotlin.reflect.jvm.internal.impl.h.b.s;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ar;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import kotlin.t;
import kotlin.y;

public final class f
extends kotlin.reflect.jvm.internal.impl.a.c.g
implements kotlin.reflect.jvm.internal.impl.c.a.b.d {
    public static final a c = new a(null);
    private static final Set<String> q = al.a("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");
    private final h d;
    private final kotlin.reflect.jvm.internal.impl.a.f e;
    private final w f;
    private final kotlin.reflect.jvm.internal.impl.a.ba g;
    private final boolean h;
    private final b i;
    private final g j;
    private final kotlin.reflect.jvm.internal.impl.h.e.f k;
    private final l l;
    private final kotlin.reflect.jvm.internal.impl.a.a.h m;
    private final kotlin.reflect.jvm.internal.impl.i.f<List<as>> n;
    private final kotlin.reflect.jvm.internal.impl.c.a.e.g o;
    private final e p;

    public f(h object, kotlin.reflect.jvm.internal.impl.a.m m2, kotlin.reflect.jvm.internal.impl.c.a.e.g g2, e e2) {
        boolean bl2;
        j.b(object, "outerContext");
        j.b(m2, "containingDeclaration");
        j.b(g2, "jClass");
        super(((h)object).c(), m2, g2.r(), ((h)object).e().i().a(g2), false);
        this.o = g2;
        this.p = e2;
        this.d = kotlin.reflect.jvm.internal.impl.c.a.c.a.a((h)object, this, (kotlin.reflect.jvm.internal.impl.c.a.e.x)this.o, 0, 4, null);
        object = this.d.e().g();
        g2 = this.o;
        m2 = this;
        object.a(g2, (e)m2);
        object = this.o.j();
        boolean bl3 = false;
        boolean bl4 = object == null;
        if (y.a && !bl4) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Creating LazyJavaClassDescriptor for light class ");
            ((StringBuilder)object).append(this.o);
            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
        }
        object = this.o.h() ? kotlin.reflect.jvm.internal.impl.a.f.e : (this.o.g() ? kotlin.reflect.jvm.internal.impl.a.f.b : (this.o.i() ? kotlin.reflect.jvm.internal.impl.a.f.c : kotlin.reflect.jvm.internal.impl.a.f.a));
        this.e = object;
        if (this.o.h()) {
            object = w.a;
        } else {
            object = w.e;
            bl2 = this.o.n() || this.o.g();
            object = ((w.a)object).a(bl2, this.o.p() ^ true);
        }
        this.f = object;
        this.g = this.o.q();
        bl2 = bl3;
        if (this.o.f() != null) {
            bl2 = bl3;
            if (!this.o.o()) {
                bl2 = true;
            }
        }
        this.h = bl2;
        this.i = new b();
        this.j = new g(this.d, (e)m2, this.o);
        this.k = new kotlin.reflect.jvm.internal.impl.h.e.f(this.a());
        this.l = new l(this.d, this.o, this);
        this.m = kotlin.reflect.jvm.internal.impl.c.a.c.f.a(this.d, this.o);
        this.n = this.d.c().a((kotlin.e.a.a)new kotlin.e.a.a<List<? extends as>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final List<as> b() {
                Object object = this.o.s();
                Object object2 = new ArrayList(kotlin.a.m.a(object, 10));
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    object = (kotlin.reflect.jvm.internal.impl.c.a.e.w)iterator.next();
                    as as2 = this.d.f().a((kotlin.reflect.jvm.internal.impl.c.a.e.w)object);
                    if (as2 != null) {
                        object2.add(as2);
                        continue;
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Parameter ");
                    ((StringBuilder)object2).append(object);
                    ((StringBuilder)object2).append(" surely belongs to class ");
                    ((StringBuilder)object2).append(this.o);
                    ((StringBuilder)object2).append(", so it must be resolved");
                    throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object2).toString()));
                }
                return (List)object2;
            }
        });
    }

    public /* synthetic */ f(h h2, kotlin.reflect.jvm.internal.impl.a.m m2, kotlin.reflect.jvm.internal.impl.c.a.e.g g2, e e2, int n2, kotlin.e.b.g g3) {
        if ((n2 & 8) != 0) {
            e2 = null;
        }
        this(h2, m2, g2, e2);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h C() {
        return this.k;
    }

    public final f a(kotlin.reflect.jvm.internal.impl.c.a.a.g object, e e2) {
        j.b(object, "javaResolverCache");
        object = kotlin.reflect.jvm.internal.impl.c.a.c.a.a(this.d, this.d.e().a((kotlin.reflect.jvm.internal.impl.c.a.a.g)object));
        kotlin.reflect.jvm.internal.impl.a.m m2 = this.b();
        j.a((Object)m2, "containingDeclaration");
        return new f((h)object, m2, this.o, e2);
    }

    public g a() {
        return this.j;
    }

    public List<kotlin.reflect.jvm.internal.impl.a.d> c() {
        return (List)this.j.e().a();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.j.an e() {
        return this.i;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h f_() {
        return this.l;
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.h.e.h g() {
        return this.a();
    }

    @Override
    public e i() {
        return null;
    }

    public /* synthetic */ Collection k() {
        return this.c();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.f l() {
        return this.e;
    }

    @Override
    public w m() {
        return this.f;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.d o() {
        return null;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.ba p() {
        if (j.a((Object)this.g, (Object)az.a) && this.o.f() == null) {
            return m.a;
        }
        return this.g;
    }

    @Override
    public boolean q() {
        return false;
    }

    @Override
    public boolean r() {
        return this.h;
    }

    @Override
    public boolean s() {
        return false;
    }

    @Override
    public boolean t() {
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lazy Java class ");
        stringBuilder.append(kotlin.reflect.jvm.internal.impl.h.c.a.a((kotlin.reflect.jvm.internal.impl.a.m)this));
        return stringBuilder.toString();
    }

    @Override
    public boolean u() {
        return false;
    }

    @Override
    public boolean v() {
        return false;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.a.h x() {
        return this.m;
    }

    @Override
    public List<as> z() {
        return (List)this.n.a();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }
    }

    private final class b
    extends kotlin.reflect.jvm.internal.impl.j.b {
        private final kotlin.reflect.jvm.internal.impl.i.f<List<as>> b;

        public b() {
            super(f.this.d.c());
            this.b = f.this.d.c().a((kotlin.e.a.a)new kotlin.e.a.a<List<? extends as>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final List<as> b() {
                    return at.a(f.this);
                }
            });
        }

        private final kotlin.reflect.jvm.internal.impl.j.w i() {
            block6 : {
                Object object;
                Object object2;
                block8 : {
                    int n2;
                    Object object3;
                    int n3;
                    block7 : {
                        object2 = this.k();
                        if (object2 == null || (n2 = !((kotlin.reflect.jvm.internal.impl.e.b)object2).c() && ((kotlin.reflect.jvm.internal.impl.e.b)object2).b(KotlinBuiltIns.BUILT_INS_PACKAGE_NAME) ? 1 : 0) == 0) {
                            object2 = null;
                        }
                        object = object2 != null ? object2 : kotlin.reflect.jvm.internal.impl.c.a.h.a.a(kotlin.reflect.jvm.internal.impl.h.c.a.b((kotlin.reflect.jvm.internal.impl.a.m)f.this));
                        if (object == null || (object = kotlin.reflect.jvm.internal.impl.h.c.a.a(f.this.d.d(), (kotlin.reflect.jvm.internal.impl.e.b)object, d.s)) == null) break block6;
                        object3 = object.e();
                        j.a(object3, "classDescriptor.typeConstructor");
                        n2 = object3.b().size();
                        object3 = f.this.e().b();
                        n3 = object3.size();
                        if (n3 != n2) break block7;
                        j.a(object3, "typeParameters");
                        object3 = (Iterable)object3;
                        object2 = new ArrayList(kotlin.a.m.a(object3, 10));
                        object3 = object3.iterator();
                        while (object3.hasNext()) {
                            as as2 = (as)object3.next();
                            ba ba2 = ba.a;
                            j.a((Object)as2, "parameter");
                            object2.add(new ar(ba2, as2.i_()));
                        }
                        object2 = (List)object2;
                        break block8;
                    }
                    if (n3 != 1 || n2 <= 1 || object2 != null) break block6;
                    object2 = ba.a;
                    j.a(object3, "typeParameters");
                    object3 = kotlin.a.m.j(object3);
                    j.a(object3, "typeParameters.single()");
                    object2 = new ar((ba)((Object)object2), ((as)object3).i_());
                    Object object4 = new kotlin.g.c(1, n2);
                    object3 = new ArrayList(kotlin.a.m.a(object4, 10));
                    object4 = object4.iterator();
                    while (object4.hasNext()) {
                        ((ae)object4).b();
                        object3.add(object2);
                    }
                    object2 = (List)object3;
                }
                return x.a(kotlin.reflect.jvm.internal.impl.a.a.h.a.a(), (e)object, (List<? extends ap>)object2);
            }
            return null;
        }

        private final kotlin.reflect.jvm.internal.impl.e.b k() {
            Object object = f.this.x();
            kotlin.reflect.jvm.internal.impl.e.b b2 = o.j;
            j.a((Object)b2, "JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION");
            Object object2 = object.a(b2);
            b2 = null;
            object = b2;
            if (object2 != null) {
                object = object2 = kotlin.a.m.g((Iterable)object2.c().values());
                if (!(object2 instanceof s)) {
                    object = null;
                }
                object2 = (s)object;
                object = b2;
                if (object2 != null) {
                    object2 = (String)((kotlin.reflect.jvm.internal.impl.h.b.f)object2).a();
                    object = b2;
                    if (object2 != null) {
                        if (!kotlin.reflect.jvm.internal.impl.e.d.a((String)object2)) {
                            return null;
                        }
                        object = new kotlin.reflect.jvm.internal.impl.e.b((String)object2);
                    }
                }
            }
            return object;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        protected Collection<kotlin.reflect.jvm.internal.impl.j.w> a() {
            Object var3_8;
            Object object;
            List<Object> list = f.this.o.d();
            ArrayList<kotlin.reflect.jvm.internal.impl.j.w> arrayList = new ArrayList<kotlin.reflect.jvm.internal.impl.j.w>(list.size());
            Collection<String> collection = new ArrayList<Object>(0);
            Iterator iterator = this.i();
            Object object2 = list.iterator();
            do {
                boolean bl2 = object2.hasNext();
                var3_8 = null;
                list = null;
                if (!bl2) break;
                object = object2.next();
                kotlin.reflect.jvm.internal.impl.j.w w2 = f.this.d.b().a((v)object, kotlin.reflect.jvm.internal.impl.c.a.c.b.d.a(kotlin.reflect.jvm.internal.impl.c.a.a.l.a, false, null, 3, null));
                if (w2.g().d() instanceof aa.b) {
                    ((ArrayList)collection).add((String)object);
                }
                object = w2.g();
                if (iterator != null) {
                    list = ((kotlin.reflect.jvm.internal.impl.j.w)((Object)iterator)).g();
                }
                if (j.a(object, (Object)list) || KotlinBuiltIns.isAnyOrNullableAny(w2)) continue;
                arrayList.add(w2);
            } while (true);
            object2 = arrayList;
            object = f.this.p;
            list = var3_8;
            if (object != null) {
                list = kotlin.reflect.jvm.internal.impl.builtins.b.h.a((e)object, f.this).f().b(object.i_(), ba.a);
            }
            kotlin.reflect.jvm.internal.impl.l.a.a(object2, list);
            kotlin.reflect.jvm.internal.impl.l.a.a(object2, iterator);
            if (((Collection)collection).isEmpty() ^ true) {
                list = f.this.d.e().f();
                e e2 = this.j_();
                iterator = collection;
                collection = new ArrayList(kotlin.a.m.a(iterator, 10));
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    object = (v)iterator.next();
                    if (object == null) throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                    collection.add(((kotlin.reflect.jvm.internal.impl.c.a.e.j)object).g());
                }
                list.a(e2, (List<String>)((List)collection));
            }
            if (object2.isEmpty() ^ true) {
                list = kotlin.a.m.k((Iterable)arrayList);
                do {
                    return list;
                    break;
                } while (true);
            }
            list = kotlin.a.m.a(f.this.d.d().a().getAnyType());
            return list;
        }

        @Override
        public List<as> b() {
            return (List)this.b.a();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.h d() {
            return this.j_();
        }

        @Override
        public boolean f() {
            return true;
        }

        @Override
        protected aq g() {
            return f.this.d.e().l();
        }

        @Override
        public e j_() {
            return f.this;
        }

        public String toString() {
            String string2 = f.this.h_().a();
            j.a((Object)string2, "name.asString()");
            return string2;
        }

    }

}

