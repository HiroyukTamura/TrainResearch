/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.ap;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.c.ac;
import kotlin.reflect.jvm.internal.impl.a.c.ah;
import kotlin.reflect.jvm.internal.impl.a.c.o;
import kotlin.reflect.jvm.internal.impl.a.i;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.a.b;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.k.j;
import kotlin.t;
import kotlin.y;

public final class f
extends ac {
    public static final a a = new a(null);

    private f(kotlin.reflect.jvm.internal.impl.a.m m2, f f2, b.a a2, boolean bl2) {
        super(m2, f2, h.a.a(), j.g, a2, an.a);
        this.a(true);
        this.h(bl2);
        this.i(false);
    }

    public /* synthetic */ f(kotlin.reflect.jvm.internal.impl.a.m m2, f f2, b.a a2, boolean bl2, g g2) {
        this(m2, f2, a2, bl2);
    }

    private final kotlin.reflect.jvm.internal.impl.a.t a(List<kotlin.reflect.jvm.internal.impl.e.f> object) {
        Object object2;
        Object object3;
        boolean bl2;
        block8 : {
            int n2 = this.i().size() - object.size();
            boolean bl3 = false;
            int n3 = n2 != 0 && n2 != 1 ? 0 : 1;
            if (y.a && n3 == 0) {
                throw (Throwable)((Object)new AssertionError((Object)"Assertion failed"));
            }
            object3 = this.i();
            kotlin.e.b.j.a(object3, "valueParameters");
            object3 = (Iterable)object3;
            Collection collection = new ArrayList(m.a(object3, 10));
            Iterator<av> iterator = object3.iterator();
            while (iterator.hasNext()) {
                av av2 = iterator.next();
                kotlin.e.b.j.a((Object)av2, "it");
                object2 = av2.h_();
                n3 = av2.c();
                int n4 = n3 - n2;
                object3 = object2;
                if (n4 >= 0) {
                    kotlin.reflect.jvm.internal.impl.e.f f2 = (kotlin.reflect.jvm.internal.impl.e.f)object.get(n4);
                    object3 = object2;
                    if (f2 != null) {
                        object3 = f2;
                    }
                }
                object2 = this;
                kotlin.e.b.j.a(object3, "newName");
                collection.add(av2.a((kotlin.reflect.jvm.internal.impl.a.a)object2, (kotlin.reflect.jvm.internal.impl.e.f)object3, n3));
            }
            object3 = (List)collection;
            object2 = this.e(au.a);
            if ((object = (Iterable)object) instanceof Collection && ((Collection)object).isEmpty()) {
                bl2 = bl3;
            } else {
                object = object.iterator();
                do {
                    bl2 = bl3;
                    if (!object.hasNext()) break block8;
                } while ((n3 = (kotlin.reflect.jvm.internal.impl.e.f)object.next() == null ? 1 : 0) == 0);
                bl2 = true;
            }
        }
        object = super.a(((o.a)object2).c(bl2).b((List<av>)object3).a(this.o()));
        if (object == null) {
            kotlin.e.b.j.a();
        }
        return object;
    }

    @Override
    protected o a(kotlin.reflect.jvm.internal.impl.a.m m2, kotlin.reflect.jvm.internal.impl.a.t t2, b.a a2, kotlin.reflect.jvm.internal.impl.e.f f2, h h2, an an2) {
        kotlin.e.b.j.b(m2, "newOwner");
        kotlin.e.b.j.b((Object)a2, "kind");
        kotlin.e.b.j.b(h2, "annotations");
        kotlin.e.b.j.b(an2, "source");
        return new f(m2, (f)t2, a2, this.D());
    }

    @Override
    protected kotlin.reflect.jvm.internal.impl.a.t a(o.a object) {
        kotlin.e.b.j.b(object, "configuration");
        object = (f)super.a((o.a)object);
        if (object != null) {
            boolean bl2;
            Collection<av> collection;
            Iterator iterator;
            block6 : {
                collection = ((o)object).i();
                kotlin.e.b.j.a(collection, "substituted.valueParameters");
                collection = collection;
                boolean bl3 = collection instanceof Collection;
                boolean bl4 = true;
                if (bl3 && ((Collection)collection).isEmpty()) {
                    bl2 = bl4;
                } else {
                    collection = collection.iterator();
                    do {
                        bl2 = bl4;
                        if (!collection.hasNext()) break block6;
                        iterator = (av)collection.next();
                        kotlin.e.b.j.a((Object)iterator, "it");
                        iterator = iterator.r();
                        kotlin.e.b.j.a((Object)iterator, "it.type");
                    } while (!(bl2 = FunctionTypesKt.extractParameterNameFromFunctionTypeArgument((kotlin.reflect.jvm.internal.impl.j.w)((Object)iterator)) != null));
                    bl2 = false;
                }
            }
            if (bl2) {
                return (kotlin.reflect.jvm.internal.impl.a.t)object;
            }
            collection = ((o)object).i();
            kotlin.e.b.j.a(collection, "substituted.valueParameters");
            iterator = collection;
            collection = new ArrayList(m.a(iterator, 10));
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                kotlin.reflect.jvm.internal.impl.a.a.a a2 = (av)iterator.next();
                kotlin.e.b.j.a((Object)a2, "it");
                a2 = a2.r();
                kotlin.e.b.j.a((Object)a2, "it.type");
                collection.add((av)((Object)FunctionTypesKt.extractParameterNameFromFunctionTypeArgument((kotlin.reflect.jvm.internal.impl.j.w)a2)));
            }
            return f.super.a((List<kotlin.reflect.jvm.internal.impl.e.f>)collection);
        }
        return null;
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public boolean w() {
        return false;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        private final av a(f a2, int n2, as a3) {
            block7 : {
                Object object;
                block6 : {
                    block5 : {
                        block4 : {
                            object = a3.h_().a();
                            int n3 = ((String)object).hashCode();
                            if (n3 == 69) break block4;
                            if (n3 != 84 || !((String)object).equals("T")) break block5;
                            object = "instance";
                            break block6;
                        }
                        if (!((String)object).equals("E")) break block5;
                        object = "receiver";
                        break block6;
                    }
                    kotlin.e.b.j.a(object, "typeParameterName");
                    if (object == null) break block7;
                    object = ((String)object).toLowerCase();
                    kotlin.e.b.j.a(object, "(this as java.lang.String).toLowerCase()");
                }
                a2 = a2;
                h h2 = h.a.a();
                object = kotlin.reflect.jvm.internal.impl.e.f.a((String)object);
                kotlin.e.b.j.a(object, "Name.identifier(name)");
                a3 = a3.i_();
                kotlin.e.b.j.a((Object)a3, "typeParameter.defaultType");
                a3 = (kotlin.reflect.jvm.internal.impl.j.w)a3;
                an an2 = an.a;
                kotlin.e.b.j.a((Object)an2, "SourceElement.NO_SOURCE");
                return new ah(a2, null, n2, h2, (kotlin.reflect.jvm.internal.impl.e.f)object, (kotlin.reflect.jvm.internal.impl.j.w)a3, false, false, false, null, an2);
            }
            throw new t("null cannot be cast to non-null type java.lang.String");
        }

        public final f a(b ap2, boolean bl2) {
            Object object;
            boolean bl3;
            kotlin.e.b.j.b(ap2, "functionClass");
            List<as> list = ap2.z();
            f f2 = new f((kotlin.reflect.jvm.internal.impl.a.m)((Object)ap2), null, b.a.a, bl2, null);
            ap2 = ap2.D();
            List list2 = m.a();
            Object object2 = list;
            Collection<av> collection = new ArrayList();
            object2 = object2.iterator();
            while (object2.hasNext() && (bl3 = ((as)(object = object2.next())).k() == ba.b)) {
                ((ArrayList)collection).add((av)object);
            }
            object2 = m.n((List)collection);
            collection = new ArrayList(m.a(object2, 10));
            object2 = object2.iterator();
            while (object2.hasNext()) {
                object = (ab)object2.next();
                collection.add(f.a.a(f2, ((ab)object).a(), (as)((ab)object).b()));
            }
            f2.b(null, (al)ap2, list2, (List)collection, m.h(list).i_(), w.d, az.e);
            f2.j(true);
            return f2;
        }
    }

}

