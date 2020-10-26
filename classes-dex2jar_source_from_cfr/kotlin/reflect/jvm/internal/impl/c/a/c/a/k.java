/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ab;
import kotlin.a.af;
import kotlin.e.b.v;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.ak;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.ac;
import kotlin.reflect.jvm.internal.impl.a.c.ah;
import kotlin.reflect.jvm.internal.impl.a.c.z;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.c.m;
import kotlin.reflect.jvm.internal.impl.c.a.e.n;
import kotlin.reflect.jvm.internal.impl.c.a.e.q;
import kotlin.reflect.jvm.internal.impl.c.a.e.x;
import kotlin.reflect.jvm.internal.impl.c.a.o;
import kotlin.reflect.jvm.internal.impl.h.e.c;
import kotlin.reflect.jvm.internal.impl.h.e.d;
import kotlin.reflect.jvm.internal.impl.h.e.h;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.l;
import kotlin.s;

public abstract class k
extends kotlin.reflect.jvm.internal.impl.h.e.i {
    static final /* synthetic */ l[] a;
    private final kotlin.reflect.jvm.internal.impl.i.f<Collection<kotlin.reflect.jvm.internal.impl.a.m>> b;
    private final kotlin.reflect.jvm.internal.impl.i.f<kotlin.reflect.jvm.internal.impl.c.a.c.a.b> d;
    private final kotlin.reflect.jvm.internal.impl.i.c<kotlin.reflect.jvm.internal.impl.e.f, Collection<am>> e;
    private final kotlin.reflect.jvm.internal.impl.i.f f;
    private final kotlin.reflect.jvm.internal.impl.i.f g;
    private final kotlin.reflect.jvm.internal.impl.i.f h;
    private final kotlin.reflect.jvm.internal.impl.i.c<kotlin.reflect.jvm.internal.impl.e.f, List<ai>> i;
    private final kotlin.reflect.jvm.internal.impl.c.a.c.h j;

    static {
        a = new l[]{v.a(new kotlin.e.b.t(v.a(k.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), v.a(new kotlin.e.b.t(v.a(k.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), v.a(new kotlin.e.b.t(v.a(k.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    }

    public k(kotlin.reflect.jvm.internal.impl.c.a.c.h h2) {
        kotlin.e.b.j.b(h2, "c");
        this.j = h2;
        this.b = this.j.c().a((kotlin.e.a.a)new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.impl.a.m>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final List<kotlin.reflect.jvm.internal.impl.a.m> b() {
                return this.a(kotlin.reflect.jvm.internal.impl.h.e.d.a, kotlin.reflect.jvm.internal.impl.h.e.h.c.a(), kotlin.reflect.jvm.internal.impl.b.a.d.m);
            }
        }, kotlin.a.m.a());
        this.d = this.j.c().a((kotlin.e.a.a)new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.c.a.c.a.b>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final kotlin.reflect.jvm.internal.impl.c.a.c.a.b b() {
                return this.d();
            }
        });
        this.e = this.j.c().a((kotlin.e.a.b)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.f, List<? extends am>>(){

            @Override
            public final List<am> a(kotlin.reflect.jvm.internal.impl.e.f f2) {
                kotlin.e.b.j.b(f2, "name");
                LinkedHashSet<am> linkedHashSet = new LinkedHashSet();
                for (q q2 : ((kotlin.reflect.jvm.internal.impl.c.a.c.a.b)this.i().a()).a(f2)) {
                    kotlin.reflect.jvm.internal.impl.c.a.b.e e2 = this.a(q2);
                    if (!this.a(e2)) continue;
                    this.j().e().g().a(q2, e2);
                    linkedHashSet.add(e2);
                }
                linkedHashSet = linkedHashSet;
                kotlin.reflect.jvm.internal.impl.h.k.a(linkedHashSet);
                this.a(linkedHashSet, f2);
                return kotlin.a.m.k((Iterable)this.j().e().q().a(this.j(), linkedHashSet));
            }
        });
        this.f = this.j.c().a((kotlin.e.a.a)new kotlin.e.a.a<Set<? extends kotlin.reflect.jvm.internal.impl.e.f>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Set<kotlin.reflect.jvm.internal.impl.e.f> b() {
                return this.c(kotlin.reflect.jvm.internal.impl.h.e.d.h, null);
            }
        });
        this.g = this.j.c().a((kotlin.e.a.a)new kotlin.e.a.a<Set<? extends kotlin.reflect.jvm.internal.impl.e.f>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Set<kotlin.reflect.jvm.internal.impl.e.f> b() {
                return this.e(kotlin.reflect.jvm.internal.impl.h.e.d.i, null);
            }
        });
        this.h = this.j.c().a((kotlin.e.a.a)new kotlin.e.a.a<Set<? extends kotlin.reflect.jvm.internal.impl.e.f>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Set<kotlin.reflect.jvm.internal.impl.e.f> b() {
                return this.d(kotlin.reflect.jvm.internal.impl.h.e.d.f, null);
            }
        });
        this.i = this.j.c().a((kotlin.e.a.b)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.f, List<? extends ai>>(){

            @Override
            public final List<ai> a(kotlin.reflect.jvm.internal.impl.e.f f2) {
                kotlin.e.b.j.b(f2, "name");
                ArrayList<ai> arrayList = new ArrayList<ai>();
                Object object = ((kotlin.reflect.jvm.internal.impl.c.a.c.a.b)this.i().a()).b(f2);
                if (object != null && !object.c()) {
                    arrayList.add(this.a((n)object));
                }
                object = this;
                Collection collection = arrayList;
                ((k)object).a(f2, collection);
                if (kotlin.reflect.jvm.internal.impl.h.c.n(this.h())) {
                    return kotlin.a.m.k((Iterable)arrayList);
                }
                return kotlin.a.m.k(this.j().e().q().a(this.j(), collection));
            }
        });
    }

    private final ai a(final n n2) {
        ai ai2 = this.b(n2);
        ai2.a(null, null);
        ai2.a(this.d(n2), kotlin.a.m.a(), this.f(), (kotlin.reflect.jvm.internal.impl.j.w)null);
        if (kotlin.reflect.jvm.internal.impl.h.c.a(ai2, ai2.r())) {
            ai2.a(this.j.c().b(new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.h.b.f<?>>((kotlin.reflect.jvm.internal.impl.a.c.y)ai2){
                final /* synthetic */ kotlin.reflect.jvm.internal.impl.a.c.y c;
                {
                    this.c = y2;
                    super(0);
                }

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final kotlin.reflect.jvm.internal.impl.h.b.f<?> b() {
                    return this.j().e().h().a(n2, this.c);
                }
            }));
        }
        kotlin.reflect.jvm.internal.impl.c.a.a.g g2 = this.j.e().g();
        ai2 = ai2;
        g2.a(n2, ai2);
        return ai2;
    }

    private final kotlin.reflect.jvm.internal.impl.a.c.y b(n object) {
        boolean bl2 = object.p();
        kotlin.reflect.jvm.internal.impl.a.a.h h2 = kotlin.reflect.jvm.internal.impl.c.a.c.f.a(this.j, (kotlin.reflect.jvm.internal.impl.c.a.e.d)object);
        object = kotlin.reflect.jvm.internal.impl.c.a.b.f.a(this.h(), h2, w.a, object.q(), bl2 ^ true, object.r(), this.j.e().i().a((kotlin.reflect.jvm.internal.impl.c.a.e.l)object), this.c((n)object));
        kotlin.e.b.j.a(object, "JavaPropertyDescriptor.c\u2026d.isFinalStatic\n        )");
        return (kotlin.reflect.jvm.internal.impl.a.c.y)object;
    }

    private final Set<kotlin.reflect.jvm.internal.impl.e.f> c() {
        return (Set)kotlin.reflect.jvm.internal.impl.i.h.a(this.f, (Object)this, a[0]);
    }

    private final boolean c(n n2) {
        return n2.p() && n2.o();
    }

    private final kotlin.reflect.jvm.internal.impl.j.w d(n object) {
        boolean bl2;
        Object object2;
        block7 : {
            boolean bl3;
            block6 : {
                object2 = this.j.b();
                kotlin.reflect.jvm.internal.impl.c.a.e.v v2 = object.d();
                kotlin.reflect.jvm.internal.impl.c.a.a.l l2 = kotlin.reflect.jvm.internal.impl.c.a.a.l.b;
                bl3 = false;
                if (KotlinBuiltIns.isPrimitiveType((kotlin.reflect.jvm.internal.impl.j.w)(object2 = ((kotlin.reflect.jvm.internal.impl.c.a.c.b.c)object2).a(v2, kotlin.reflect.jvm.internal.impl.c.a.c.b.d.a(l2, false, null, 3, null))))) break block6;
                bl2 = bl3;
                if (!KotlinBuiltIns.isString((kotlin.reflect.jvm.internal.impl.j.w)object2)) break block7;
            }
            bl2 = bl3;
            if (this.c((n)object)) {
                bl2 = bl3;
                if (object.e()) {
                    bl2 = true;
                }
            }
        }
        if (bl2) {
            object = av.d((kotlin.reflect.jvm.internal.impl.j.w)object2);
            kotlin.e.b.j.a(object, "TypeUtils.makeNotNullable(propertyType)");
            return object;
        }
        return object2;
    }

    private final Set<kotlin.reflect.jvm.internal.impl.e.f> e() {
        return (Set)kotlin.reflect.jvm.internal.impl.i.h.a(this.g, (Object)this, a[1]);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Collection<ai> a(kotlin.reflect.jvm.internal.impl.e.f list, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(list, "name");
        kotlin.e.b.j.b(b2, "location");
        if (!this.o_().contains(list)) {
            list = kotlin.a.m.a();
            do {
                return list;
                break;
            } while (true);
        }
        list = this.i.a((kotlin.reflect.jvm.internal.impl.e.f)((Object)list));
        return list;
    }

    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.a.m> a(kotlin.reflect.jvm.internal.impl.h.e.d d2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b2) {
        kotlin.e.b.j.b(d2, "kindFilter");
        kotlin.e.b.j.b(b2, "nameFilter");
        return (Collection)this.b.a();
    }

    protected final List<kotlin.reflect.jvm.internal.impl.a.m> a(kotlin.reflect.jvm.internal.impl.h.e.d object, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b2, kotlin.reflect.jvm.internal.impl.b.a.b b3) {
        kotlin.e.b.j.b(object, "kindFilter");
        kotlin.e.b.j.b(b2, "nameFilter");
        kotlin.e.b.j.b(b3, "location");
        LinkedHashSet<kotlin.reflect.jvm.internal.impl.a.b> linkedHashSet = new LinkedHashSet<kotlin.reflect.jvm.internal.impl.a.b>();
        if (((kotlin.reflect.jvm.internal.impl.h.e.d)((Object)object)).a(kotlin.reflect.jvm.internal.impl.h.e.d.k.h())) {
            for (kotlin.reflect.jvm.internal.impl.e.f f2 : this.d((kotlin.reflect.jvm.internal.impl.h.e.d)((Object)object), b2)) {
                if (!b2.a(f2).booleanValue()) continue;
                kotlin.reflect.jvm.internal.impl.l.a.a((Collection)linkedHashSet, this.c(f2, b3));
            }
        }
        if (((kotlin.reflect.jvm.internal.impl.h.e.d)((Object)object)).a(kotlin.reflect.jvm.internal.impl.h.e.d.k.e()) && !((kotlin.reflect.jvm.internal.impl.h.e.d)((Object)object)).b().contains(c.a.a)) {
            for (kotlin.reflect.jvm.internal.impl.e.f f2 : this.c((kotlin.reflect.jvm.internal.impl.h.e.d)((Object)object), b2)) {
                if (!b2.a(f2).booleanValue()) continue;
                linkedHashSet.addAll(this.b(f2, b3));
            }
        }
        if (((kotlin.reflect.jvm.internal.impl.h.e.d)((Object)object)).a(kotlin.reflect.jvm.internal.impl.h.e.d.k.f()) && !((kotlin.reflect.jvm.internal.impl.h.e.d)((Object)object)).b().contains(c.a.a)) {
            for (kotlin.reflect.jvm.internal.impl.e.f f3 : this.e((kotlin.reflect.jvm.internal.impl.h.e.d)((Object)object), b2)) {
                if (!b2.a(f3).booleanValue()) continue;
                linkedHashSet.addAll(this.a(f3, b3));
            }
        }
        return kotlin.a.m.k((Iterable)linkedHashSet);
    }

    protected final kotlin.reflect.jvm.internal.impl.c.a.b.e a(q map) {
        Object object;
        kotlin.e.b.j.b(map, "method");
        Object object2 = kotlin.reflect.jvm.internal.impl.c.a.c.f.a(this.j, (kotlin.reflect.jvm.internal.impl.c.a.e.d)((Object)map));
        object2 = kotlin.reflect.jvm.internal.impl.c.a.b.e.a(this.h(), (kotlin.reflect.jvm.internal.impl.a.a.h)object2, map.r(), this.j.e().i().a((kotlin.reflect.jvm.internal.impl.c.a.e.l)((Object)map)));
        kotlin.reflect.jvm.internal.impl.c.a.c.h h2 = this.j;
        kotlin.e.b.j.a(object2, "functionDescriptorImpl");
        h2 = kotlin.reflect.jvm.internal.impl.c.a.c.a.a(h2, (kotlin.reflect.jvm.internal.impl.a.m)object2, (x)((Object)map), 0, 4, null);
        Object object3 = map.s();
        Object object4 = new ArrayList(kotlin.a.m.a(object3, 10));
        object3 = object3.iterator();
        while (object3.hasNext()) {
            object = (kotlin.reflect.jvm.internal.impl.c.a.e.w)object3.next();
            object = h2.f().a((kotlin.reflect.jvm.internal.impl.c.a.e.w)object);
            if (object == null) {
                kotlin.e.b.j.a();
            }
            object4.add(object);
        }
        object3 = (List)object4;
        object4 = this.a(h2, (t)object2, map.c());
        object3 = this.a((q)((Object)map), (List<? extends as>)object3, this.a((q)((Object)map), h2), ((b)object4).a());
        object = ((a)object3).b();
        al al2 = this.f();
        List<as> list = ((a)object3).d();
        List<kotlin.reflect.jvm.internal.impl.a.av> list2 = ((a)object3).c();
        kotlin.reflect.jvm.internal.impl.j.w w2 = ((a)object3).a();
        w w3 = w.e.a(map.n(), map.p() ^ true);
        ba ba2 = map.q();
        map = ((a)object3).b() != null ? af.a(s.a(kotlin.reflect.jvm.internal.impl.c.a.b.e.a, kotlin.a.m.f(((b)object4).a()))) : af.a();
        ((kotlin.reflect.jvm.internal.impl.c.a.b.e)object2).a((kotlin.reflect.jvm.internal.impl.j.w)object, al2, list, list2, w2, w3, ba2, map);
        ((kotlin.reflect.jvm.internal.impl.c.a.b.e)object2).a(((a)object3).e(), ((b)object4).b());
        if (((Collection)((a)object3).f()).isEmpty() ^ true) {
            h2.e().e().a((kotlin.reflect.jvm.internal.impl.a.b)object2, ((a)object3).f());
        }
        return object2;
    }

    protected abstract a a(q var1, List<? extends as> var2, kotlin.reflect.jvm.internal.impl.j.w var3, List<? extends kotlin.reflect.jvm.internal.impl.a.av> var4);

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected final b a(kotlin.reflect.jvm.internal.impl.c.a.c.h var1_1, t var2_2, List<? extends kotlin.reflect.jvm.internal.impl.c.a.e.y> var3_3) {
        kotlin.e.b.j.b(var1_1, "c");
        kotlin.e.b.j.b(var2_2, "function");
        kotlin.e.b.j.b(var3_3, "jValueParameters");
        var12_4 = new LinkedHashSet<E>();
        var9_5 = kotlin.a.m.n((Iterable)var3_3);
        var13_6 = new ArrayList<E>(kotlin.a.m.a(var9_5, 10));
        var14_7 = var9_5.iterator();
        var6_8 = false;
        while (var14_7.hasNext() != false) {
            var9_5 = var14_7.next();
            var5_10 = var9_5.c();
            var15_15 = (kotlin.reflect.jvm.internal.impl.c.a.e.y)var9_5.d();
            var16_16 = kotlin.reflect.jvm.internal.impl.c.a.c.f.a((kotlin.reflect.jvm.internal.impl.c.a.c.h)var1_1, var15_15);
            var17_17 = kotlin.reflect.jvm.internal.impl.c.a.c.b.d.a(kotlin.reflect.jvm.internal.impl.c.a.a.l.b, false, null, 3, null);
            var9_5 = o.m;
            kotlin.e.b.j.a(var9_5, "JvmAnnotationNames.PARAMETER_NAME_FQ_NAME");
            var9_5 = var16_16.a((kotlin.reflect.jvm.internal.impl.e.b)var9_5);
            if (var9_5 == null || (var10_13 = kotlin.reflect.jvm.internal.impl.h.c.a.b((kotlin.reflect.jvm.internal.impl.a.a.c)var9_5)) == null) ** GOTO lbl-1000
            var9_5 = var10_13;
            if (!(var10_13 instanceof kotlin.reflect.jvm.internal.impl.h.b.s)) {
                var9_5 = null;
            }
            if ((var9_5 = (kotlin.reflect.jvm.internal.impl.h.b.s)var9_5) != null) {
                var9_5 = (String)var9_5.a();
            } else lbl-1000: // 2 sources:
            {
                var9_5 = null;
            }
            var8_12 = var15_15.e();
            var7_11 = true;
            if (var8_12) {
                var11_14 = var15_15.d();
                var10_13 = var11_14;
                if (!(var11_14 instanceof kotlin.reflect.jvm.internal.impl.c.a.e.f)) {
                    var10_13 = null;
                }
                if ((var10_13 = (kotlin.reflect.jvm.internal.impl.c.a.e.f)var10_13) == null) {
                    var1_1 = new StringBuilder();
                    var1_1.append("Vararg parameter should be an array: ");
                    var1_1.append(var15_15);
                    throw (Throwable)new AssertionError((Object)var1_1.toString());
                }
                var10_13 = var1_1.b().a((kotlin.reflect.jvm.internal.impl.c.a.e.f)var10_13, (kotlin.reflect.jvm.internal.impl.c.a.c.b.a)var17_17, true);
                var10_13 = s.a(var10_13, var1_1.d().a().getArrayElementType((kotlin.reflect.jvm.internal.impl.j.w)var10_13));
            } else {
                var10_13 = s.a(var1_1.b().a(var15_15.d(), (kotlin.reflect.jvm.internal.impl.c.a.c.b.a)var17_17), null);
            }
            var11_14 = var10_13.c();
            var10_13 = (kotlin.reflect.jvm.internal.impl.j.w)var10_13.d();
            if (kotlin.e.b.j.a((Object)var2_2.h_().a(), (Object)"equals") && var3_3.size() == 1 && kotlin.e.b.j.a((Object)var1_1.d().a().getNullableAnyType(), var11_14)) {
                var9_5 = kotlin.reflect.jvm.internal.impl.e.f.a("other");
            } else if (var9_5 != null && (var4_9 = ((CharSequence)var9_5).length() > 0) && var12_4.add(var9_5)) {
                var9_5 = kotlin.reflect.jvm.internal.impl.e.f.a((String)var9_5);
            } else {
                var9_5 = var15_15.c();
                if (var9_5 == null) {
                    var6_8 = var7_11;
                }
                if (var9_5 == null) {
                    var9_5 = new StringBuilder();
                    var9_5.append('p');
                    var9_5.append(var5_10);
                    var9_5 = kotlin.reflect.jvm.internal.impl.e.f.a(var9_5.toString());
                }
            }
            var17_17 = var2_2;
            kotlin.e.b.j.a(var9_5, "name");
            var13_6.add(new ah((kotlin.reflect.jvm.internal.impl.a.a)var17_17, null, var5_10, var16_16, (kotlin.reflect.jvm.internal.impl.e.f)var9_5, (kotlin.reflect.jvm.internal.impl.j.w)var11_14, false, false, false, (kotlin.reflect.jvm.internal.impl.j.w)var10_13, var1_1.e().i().a(var15_15)));
        }
        return new b(kotlin.a.m.k((List)var13_6), var6_8);
    }

    protected final kotlin.reflect.jvm.internal.impl.j.w a(q q2, kotlin.reflect.jvm.internal.impl.c.a.c.h h2) {
        kotlin.e.b.j.b(q2, "method");
        kotlin.e.b.j.b(h2, "c");
        boolean bl2 = q2.f().h();
        kotlin.reflect.jvm.internal.impl.c.a.c.b.a a2 = kotlin.reflect.jvm.internal.impl.c.a.c.b.d.a(kotlin.reflect.jvm.internal.impl.c.a.a.l.b, bl2, null, 2, null);
        return h2.b().a(q2.d(), a2);
    }

    protected abstract void a(Collection<am> var1, kotlin.reflect.jvm.internal.impl.e.f var2);

    protected abstract void a(kotlin.reflect.jvm.internal.impl.e.f var1, Collection<ai> var2);

    protected boolean a(kotlin.reflect.jvm.internal.impl.c.a.b.e e2) {
        kotlin.e.b.j.b(e2, "$receiver");
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Collection<am> b(kotlin.reflect.jvm.internal.impl.e.f list, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(list, "name");
        kotlin.e.b.j.b(b2, "location");
        if (!this.l_().contains(list)) {
            list = kotlin.a.m.a();
            do {
                return list;
                break;
            } while (true);
        }
        list = this.e.a((kotlin.reflect.jvm.internal.impl.e.f)((Object)list));
        return list;
    }

    protected abstract Set<kotlin.reflect.jvm.internal.impl.e.f> c(kotlin.reflect.jvm.internal.impl.h.e.d var1, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> var2);

    protected abstract Set<kotlin.reflect.jvm.internal.impl.e.f> d(kotlin.reflect.jvm.internal.impl.h.e.d var1, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> var2);

    protected abstract kotlin.reflect.jvm.internal.impl.c.a.c.a.b d();

    protected abstract Set<kotlin.reflect.jvm.internal.impl.e.f> e(kotlin.reflect.jvm.internal.impl.h.e.d var1, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> var2);

    protected abstract al f();

    protected abstract kotlin.reflect.jvm.internal.impl.a.m h();

    protected final kotlin.reflect.jvm.internal.impl.i.f<kotlin.reflect.jvm.internal.impl.c.a.c.a.b> i() {
        return this.d;
    }

    protected final kotlin.reflect.jvm.internal.impl.c.a.c.h j() {
        return this.j;
    }

    @Override
    public Set<kotlin.reflect.jvm.internal.impl.e.f> l_() {
        return this.c();
    }

    @Override
    public Set<kotlin.reflect.jvm.internal.impl.e.f> o_() {
        return this.e();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lazy scope for ");
        stringBuilder.append(this.h());
        return stringBuilder.toString();
    }

    protected static final class a {
        private final kotlin.reflect.jvm.internal.impl.j.w a;
        private final kotlin.reflect.jvm.internal.impl.j.w b;
        private final List<kotlin.reflect.jvm.internal.impl.a.av> c;
        private final List<as> d;
        private final boolean e;
        private final List<String> f;

        public a(kotlin.reflect.jvm.internal.impl.j.w w2, kotlin.reflect.jvm.internal.impl.j.w w3, List<? extends kotlin.reflect.jvm.internal.impl.a.av> list, List<? extends as> list2, boolean bl2, List<String> list3) {
            kotlin.e.b.j.b(w2, "returnType");
            kotlin.e.b.j.b(list, "valueParameters");
            kotlin.e.b.j.b(list2, "typeParameters");
            kotlin.e.b.j.b(list3, "errors");
            this.a = w2;
            this.b = w3;
            this.c = list;
            this.d = list2;
            this.e = bl2;
            this.f = list3;
        }

        public final kotlin.reflect.jvm.internal.impl.j.w a() {
            return this.a;
        }

        public final kotlin.reflect.jvm.internal.impl.j.w b() {
            return this.b;
        }

        public final List<kotlin.reflect.jvm.internal.impl.a.av> c() {
            return this.c;
        }

        public final List<as> d() {
            return this.d;
        }

        public final boolean e() {
            return this.e;
        }

        public boolean equals(Object object) {
            if (this != object) {
                if (object instanceof a) {
                    boolean bl2;
                    object = (a)object;
                    if (kotlin.e.b.j.a((Object)this.a, (Object)((a)object).a) && kotlin.e.b.j.a((Object)this.b, (Object)((a)object).b) && kotlin.e.b.j.a(this.c, ((a)object).c) && kotlin.e.b.j.a(this.d, ((a)object).d) && (bl2 = this.e == ((a)object).e) && kotlin.e.b.j.a(this.f, ((a)object).f)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public final List<String> f() {
            return this.f;
        }

        public int hashCode() {
            RuntimeException runtimeException;
            super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            throw runtimeException;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MethodSignatureData(returnType=");
            stringBuilder.append(this.a);
            stringBuilder.append(", receiverType=");
            stringBuilder.append(this.b);
            stringBuilder.append(", valueParameters=");
            stringBuilder.append(this.c);
            stringBuilder.append(", typeParameters=");
            stringBuilder.append(this.d);
            stringBuilder.append(", hasStableParameterNames=");
            stringBuilder.append(this.e);
            stringBuilder.append(", errors=");
            stringBuilder.append(this.f);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    protected static final class b {
        private final List<kotlin.reflect.jvm.internal.impl.a.av> a;
        private final boolean b;

        public b(List<? extends kotlin.reflect.jvm.internal.impl.a.av> list, boolean bl2) {
            kotlin.e.b.j.b(list, "descriptors");
            this.a = list;
            this.b = bl2;
        }

        public final List<kotlin.reflect.jvm.internal.impl.a.av> a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

}

