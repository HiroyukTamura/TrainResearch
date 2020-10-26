/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.af;
import kotlin.a.al;
import kotlin.e.b.k;
import kotlin.e.b.v;
import kotlin.g;
import kotlin.h;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ac;
import kotlin.reflect.jvm.internal.impl.a.ae;
import kotlin.reflect.jvm.internal.impl.a.c.i;
import kotlin.reflect.jvm.internal.impl.a.c.j;
import kotlin.reflect.jvm.internal.impl.a.c.q;
import kotlin.reflect.jvm.internal.impl.a.c.s;
import kotlin.reflect.jvm.internal.impl.a.c.t;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.o;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.i.c;
import kotlin.reflect.l;

public final class u
extends j
implements y {
    static final /* synthetic */ l[] a;
    private final Map<y.a<? extends Object>, Object> b;
    private s c;
    private ac d;
    private boolean e;
    private final c<kotlin.reflect.jvm.internal.impl.e.b, ae> f;
    private final g g;
    private final kotlin.reflect.jvm.internal.impl.i.i h;
    private final KotlinBuiltIns i;
    private final f j;

    static {
        a = new l[]{v.a(new kotlin.e.b.t(v.a(u.class), "packageFragmentProviderForWholeModuleWithDependencies", "getPackageFragmentProviderForWholeModuleWithDependencies()Lorg/jetbrains/kotlin/descriptors/impl/CompositePackageFragmentProvider;"))};
    }

    public u(f f2, kotlin.reflect.jvm.internal.impl.i.i i2, KotlinBuiltIns kotlinBuiltIns, kotlin.reflect.jvm.internal.impl.h.g g2) {
        this(f2, i2, kotlinBuiltIns, g2, null, null, 48, null);
    }

    public u(f map, kotlin.reflect.jvm.internal.impl.i.i object, KotlinBuiltIns kotlinBuiltIns, kotlin.reflect.jvm.internal.impl.h.g g2, Map<y.a<?>, ? extends Object> map2, f f2) {
        kotlin.e.b.j.b(map, "moduleName");
        kotlin.e.b.j.b(object, "storageManager");
        kotlin.e.b.j.b(kotlinBuiltIns, "builtIns");
        kotlin.e.b.j.b(map2, "capabilities");
        super(kotlin.reflect.jvm.internal.impl.a.a.h.a.a(), (f)((Object)map));
        this.h = object;
        this.i = kotlinBuiltIns;
        this.j = f2;
        if (((f)((Object)map)).c()) {
            if (g2 == null || (map = af.a(kotlin.s.a(kotlin.reflect.jvm.internal.impl.h.g.a, g2))) == null) {
                map = af.a();
            }
            this.b = af.a(map2, map);
            this.e = true;
            this.f = this.h.a((kotlin.e.a.b)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.b, q>(){

                @Override
                public final q a(kotlin.reflect.jvm.internal.impl.e.b b2) {
                    kotlin.e.b.j.b(b2, "fqName");
                    return new q(this, b2, this.h);
                }
            });
            this.g = h.a((kotlin.e.a.a)new kotlin.e.a.a<i>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final i b() {
                    Object object = this.c;
                    if (object != null) {
                        Object object2;
                        object = object.a();
                        boolean bl2 = object.contains(this);
                        if (kotlin.y.a && !bl2) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("Module ");
                            ((StringBuilder)object).append(this.k());
                            ((StringBuilder)object).append(" is not contained in his own dependencies, this is probably a misconfiguration");
                            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
                        }
                        object = (Iterable)object;
                        Object object3 = object.iterator();
                        while (object3.hasNext()) {
                            object2 = (u)object3.next();
                            bl2 = ((u)object2).j();
                            if (!kotlin.y.a || bl2) continue;
                            object = new StringBuilder();
                            ((StringBuilder)object).append("Dependency module ");
                            ((StringBuilder)object).append(((u)object2).k());
                            ((StringBuilder)object).append(" was not initialized by the time contents of dependent module ");
                            ((StringBuilder)object).append(this.k());
                            ((StringBuilder)object).append(" were queried");
                            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
                        }
                        object2 = new ArrayList(kotlin.a.m.a(object, 10));
                        object = object.iterator();
                        while (object.hasNext()) {
                            object3 = ((u)object.next()).d;
                            if (object3 == null) {
                                kotlin.e.b.j.a();
                            }
                            object2.add(object3);
                        }
                        return new i((List)object2);
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Dependencies of module ");
                    ((StringBuilder)object).append(this.k());
                    ((StringBuilder)object).append(" were not set before querying module content");
                    throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
                }
            });
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Module name must be special: ");
        ((StringBuilder)object).append(map);
        throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public /* synthetic */ u(f f2, kotlin.reflect.jvm.internal.impl.i.i i2, KotlinBuiltIns kotlinBuiltIns, kotlin.reflect.jvm.internal.impl.h.g g2, Map map, f f3, int n2, kotlin.e.b.g g3) {
        if ((n2 & 8) != 0) {
            g2 = null;
        }
        if ((n2 & 16) != 0) {
            map = af.a();
        }
        if ((n2 & 32) != 0) {
            f3 = null;
        }
        this(f2, i2, kotlinBuiltIns, g2, map, f3);
    }

    private final i h() {
        g g2 = this.g;
        l l2 = a[0];
        return (i)g2.a();
    }

    private final boolean j() {
        return this.d != null;
    }

    private final String k() {
        String string2 = this.h_().toString();
        kotlin.e.b.j.a((Object)string2, "name.toString()");
        return string2;
    }

    @Override
    public <R, D> R a(o<R, D> o2, D d2) {
        kotlin.e.b.j.b(o2, "visitor");
        return y.b.a(this, o2, d2);
    }

    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.e.b> a(kotlin.reflect.jvm.internal.impl.e.b b2, kotlin.e.a.b<? super f, Boolean> b3) {
        kotlin.e.b.j.b(b2, "fqName");
        kotlin.e.b.j.b(b3, "nameFilter");
        this.e();
        return this.g().a(b2, b3);
    }

    @Override
    public ae a(kotlin.reflect.jvm.internal.impl.e.b b2) {
        kotlin.e.b.j.b(b2, "fqName");
        this.e();
        return (ae)this.f.a(b2);
    }

    @Override
    public KotlinBuiltIns a() {
        return this.i;
    }

    public final void a(List<u> list) {
        kotlin.e.b.j.b(list, "descriptors");
        this.a(list, al.<u>a());
    }

    public final void a(List<u> list, Set<u> set) {
        kotlin.e.b.j.b(list, "descriptors");
        kotlin.e.b.j.b(set, "friends");
        this.a(new t(list, set, kotlin.a.m.<u>a()));
    }

    public final void a(ac object) {
        kotlin.e.b.j.b(object, "providerForModuleContent");
        boolean bl2 = this.j();
        if (kotlin.y.a && !(bl2 ^ true)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Attempt to initialize module ");
            ((StringBuilder)object).append(this.k());
            ((StringBuilder)object).append(" twice");
            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
        }
        this.d = object;
    }

    public final void a(s object) {
        kotlin.e.b.j.b(object, "dependencies");
        boolean bl2 = this.c == null;
        if (kotlin.y.a && !bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Dependencies of ");
            ((StringBuilder)object).append(this.k());
            ((StringBuilder)object).append(" were already set");
            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
        }
        this.c = object;
    }

    public final /* varargs */ void a(u ... arru) {
        kotlin.e.b.j.b(arru, "descriptors");
        this.a(kotlin.a.g.h(arru));
    }

    @Override
    public boolean a(y y2) {
        kotlin.e.b.j.b(y2, "targetModule");
        if (!kotlin.e.b.j.a((Object)this, (Object)y2)) {
            s s2 = this.c;
            if (s2 == null) {
                kotlin.e.b.j.a();
            }
            if (!kotlin.a.m.a((Iterable)s2.b(), y2) && !this.f().contains(y2)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public m b() {
        return y.b.a(this);
    }

    public boolean c() {
        return this.e;
    }

    public void e() {
        if (this.c()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Accessing invalid module descriptor ");
        stringBuilder.append(this);
        throw (Throwable)new kotlin.reflect.jvm.internal.impl.a.u(stringBuilder.toString());
    }

    public List<y> f() {
        Object object = this.c;
        if (object != null) {
            return object.c();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Dependencies of module ");
        ((StringBuilder)object).append(this.k());
        ((StringBuilder)object).append(" were not set");
        throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
    }

    public final ac g() {
        this.e();
        return this.h();
    }

}

