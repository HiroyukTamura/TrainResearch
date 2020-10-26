/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.af;
import kotlin.a.m;
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.aa;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.b.a.d;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.c.h;
import kotlin.reflect.jvm.internal.impl.c.a.c.j;
import kotlin.reflect.jvm.internal.impl.c.a.e.g;
import kotlin.reflect.jvm.internal.impl.c.a.o;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.b.i;
import kotlin.reflect.jvm.internal.impl.h.b.q;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ar;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.reflect.l;
import kotlin.s;

public final class e
implements kotlin.reflect.jvm.internal.impl.a.a.c {
    static final /* synthetic */ l[] a;
    private final kotlin.reflect.jvm.internal.impl.i.g b;
    private final kotlin.reflect.jvm.internal.impl.i.f c;
    private final kotlin.reflect.jvm.internal.impl.c.a.d.a d;
    private final kotlin.reflect.jvm.internal.impl.i.f e;
    private final h f;
    private final kotlin.reflect.jvm.internal.impl.c.a.e.a g;

    static {
        a = new l[]{v.a(new t(v.a(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), v.a(new t(v.a(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), v.a(new t(v.a(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public e(h h2, kotlin.reflect.jvm.internal.impl.c.a.e.a a2) {
        kotlin.e.b.j.b(h2, "c");
        kotlin.e.b.j.b(a2, "javaAnnotation");
        this.f = h2;
        this.g = a2;
        this.b = this.f.c().b((kotlin.e.a.a)new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.e.b>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final kotlin.reflect.jvm.internal.impl.e.b b() {
                kotlin.reflect.jvm.internal.impl.e.a a2 = this.g.b();
                if (a2 != null) {
                    return a2.g();
                }
                return null;
            }
        });
        this.c = this.f.c().a((kotlin.e.a.a)new kotlin.e.a.a<ad>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final ad b() {
                kotlin.reflect.jvm.internal.impl.e.b b2 = this.b();
                if (b2 != null) {
                    Object object = kotlin.reflect.jvm.internal.impl.builtins.b.c.a;
                    kotlin.e.b.j.a((Object)b2, "fqName");
                    object = kotlin.reflect.jvm.internal.impl.builtins.b.c.a((kotlin.reflect.jvm.internal.impl.builtins.b.c)object, b2, this.f.d().a(), null, 4, null);
                    if (object == null) {
                        object = this.g.c();
                        object = object != null ? this.f.e().j().a((g)object) : null;
                    }
                    if (object == null) {
                        object = this.a(b2);
                    }
                    return object.i_();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No fqName: ");
                stringBuilder.append(this.g);
                return p.c(stringBuilder.toString());
            }
        });
        this.d = this.f.e().i().a(this.g);
        this.e = this.f.c().a(new kotlin.e.a.a<Map<f, ? extends kotlin.reflect.jvm.internal.impl.h.b.f<?>>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Map<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> b() {
                Object object = this.g.a();
                Collection collection = new ArrayList();
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    Object object2 = (kotlin.reflect.jvm.internal.impl.c.a.e.b)iterator.next();
                    object = object2.a();
                    if (object == null) {
                        object = o.c;
                    }
                    if ((object = (object2 = this.a((kotlin.reflect.jvm.internal.impl.c.a.e.b)object2)) != null ? s.a(object, object2) : null) == null) continue;
                    collection.add(object);
                }
                return af.a((List)collection);
            }
        });
    }

    private final kotlin.reflect.jvm.internal.impl.a.e a(kotlin.reflect.jvm.internal.impl.e.b object) {
        y y2 = this.f.d();
        object = kotlin.reflect.jvm.internal.impl.e.a.a((kotlin.reflect.jvm.internal.impl.e.b)object);
        kotlin.e.b.j.a(object, "ClassId.topLevel(fqName)");
        return kotlin.reflect.jvm.internal.impl.a.s.a(y2, (kotlin.reflect.jvm.internal.impl.e.a)object, this.f.e().d().a().m());
    }

    private final kotlin.reflect.jvm.internal.impl.h.b.f<?> a(kotlin.reflect.jvm.internal.impl.c.a.e.a a2) {
        return new kotlin.reflect.jvm.internal.impl.h.b.a(new e(this.f, a2));
    }

    private final kotlin.reflect.jvm.internal.impl.h.b.f<?> a(kotlin.reflect.jvm.internal.impl.c.a.e.b b2) {
        if (b2 instanceof kotlin.reflect.jvm.internal.impl.c.a.e.o) {
            return kotlin.reflect.jvm.internal.impl.h.b.g.a.a(((kotlin.reflect.jvm.internal.impl.c.a.e.o)b2).b());
        }
        if (b2 instanceof kotlin.reflect.jvm.internal.impl.c.a.e.m) {
            b2 = (kotlin.reflect.jvm.internal.impl.c.a.e.m)b2;
            return this.a(b2.b(), b2.c());
        }
        if (b2 instanceof kotlin.reflect.jvm.internal.impl.c.a.e.e) {
            f f2 = b2.a();
            if (f2 == null) {
                f2 = o.c;
                kotlin.e.b.j.a((Object)f2, "DEFAULT_ANNOTATION_MEMBER_NAME");
            }
            return this.a(f2, ((kotlin.reflect.jvm.internal.impl.c.a.e.e)b2).b());
        }
        if (b2 instanceof kotlin.reflect.jvm.internal.impl.c.a.e.c) {
            return this.a(((kotlin.reflect.jvm.internal.impl.c.a.e.c)b2).b());
        }
        if (b2 instanceof kotlin.reflect.jvm.internal.impl.c.a.e.h) {
            return this.a(((kotlin.reflect.jvm.internal.impl.c.a.e.h)b2).b());
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.h.b.f<?> a(kotlin.reflect.jvm.internal.impl.c.a.e.v object) {
        Object object2 = av.d(this.f.b().a((kotlin.reflect.jvm.internal.impl.c.a.e.v)object, kotlin.reflect.jvm.internal.impl.c.a.c.b.d.a(kotlin.reflect.jvm.internal.impl.c.a.a.l.b, false, null, 3, null)));
        object = kotlin.reflect.jvm.internal.impl.h.c.a.a(this.f.d(), new kotlin.reflect.jvm.internal.impl.e.b("java.lang.Class"), d.p);
        if (object != null) {
            object2 = m.a(new ar((w)object2));
            return new kotlin.reflect.jvm.internal.impl.h.b.o(x.a(kotlin.reflect.jvm.internal.impl.a.a.h.a.a(), (kotlin.reflect.jvm.internal.impl.a.e)object, (List<? extends ap>)object2));
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.h.b.f<?> a(kotlin.reflect.jvm.internal.impl.e.a a2, f f2) {
        if (a2 != null && f2 != null) {
            return new i(a2, f2);
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.h.b.f<?> a(f object, List<? extends kotlin.reflect.jvm.internal.impl.c.a.e.b> f2) {
        Object object2 = this.e();
        kotlin.e.b.j.a(object2, "type");
        if (kotlin.reflect.jvm.internal.impl.j.y.a((w)object2)) {
            return null;
        }
        object2 = kotlin.reflect.jvm.internal.impl.h.c.a.a(this);
        if (object2 == null) {
            kotlin.e.b.j.a();
        }
        if ((object = kotlin.reflect.jvm.internal.impl.c.a.a.a.a((f)object, (kotlin.reflect.jvm.internal.impl.a.e)object2)) == null || (object = object.r()) == null) {
            object = this.f.e().n().a().getArrayType(ba.a, p.c("Unknown array element type"));
        }
        f2 = (Iterable)((Object)f2);
        object2 = new ArrayList(m.a(f2, 10));
        Iterator<kotlin.reflect.jvm.internal.impl.c.a.e.b> iterator = f2.iterator();
        while (iterator.hasNext()) {
            f2 = this.a(iterator.next());
            if (f2 == null) {
                f2 = new q();
            }
            object2.add(f2);
        }
        f2 = (List)object2;
        object2 = kotlin.reflect.jvm.internal.impl.h.b.g.a;
        kotlin.e.b.j.a(object, "arrayType");
        return ((kotlin.reflect.jvm.internal.impl.h.b.g)object2).a((List<? extends kotlin.reflect.jvm.internal.impl.h.b.f<?>>)((Object)f2), (w)object);
    }

    @Override
    public /* synthetic */ w a() {
        return this.e();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.e.b b() {
        return (kotlin.reflect.jvm.internal.impl.e.b)kotlin.reflect.jvm.internal.impl.i.h.a(this.b, (Object)this, a[0]);
    }

    @Override
    public Map<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> c() {
        return (Map)kotlin.reflect.jvm.internal.impl.i.h.a(this.e, (Object)this, a[2]);
    }

    @Override
    public /* synthetic */ an d() {
        return this.f();
    }

    public ad e() {
        return (ad)kotlin.reflect.jvm.internal.impl.i.h.a(this.c, (Object)this, a[1]);
    }

    public kotlin.reflect.jvm.internal.impl.c.a.d.a f() {
        return this.d;
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.g.c.a(kotlin.reflect.jvm.internal.impl.g.c.f, this, null, 2, null);
    }

}

