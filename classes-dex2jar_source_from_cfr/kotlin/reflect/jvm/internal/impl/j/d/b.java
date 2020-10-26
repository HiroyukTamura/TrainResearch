/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.g.b;
import kotlin.reflect.jvm.internal.impl.g.c;
import kotlin.reflect.jvm.internal.impl.g.h;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ao;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ar;
import kotlin.reflect.jvm.internal.impl.j.at;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.ax;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.t;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.y;

public final class b {
    private static final ap a(ap ap2) {
        return au.a(new ao(){

            @Override
            public ap a(an an2) {
                j.b(an2, "key");
                an an3 = an2;
                if (!(an2 instanceof kotlin.reflect.jvm.internal.impl.h.a.a.b)) {
                    an3 = null;
                }
                if ((an2 = (kotlin.reflect.jvm.internal.impl.h.a.a.b)an3) != null) {
                    if (((kotlin.reflect.jvm.internal.impl.h.a.a.b)an2).h().a()) {
                        return new ar(ba.c, ((kotlin.reflect.jvm.internal.impl.h.a.a.b)an2).h().c());
                    }
                    return ((kotlin.reflect.jvm.internal.impl.h.a.a.b)an2).h();
                }
                return null;
            }
        }).b(ap2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final ap a(ap ap2, boolean bl2) {
        if (ap2 == null) {
            return null;
        }
        if (ap2.a()) {
            return ap2;
        }
        w w2 = ap2.c();
        if (!av.a(w2, b.a)) {
            return ap2;
        }
        ba ba2 = ap2.b();
        if (ba2 == ba.c) {
            j.a((Object)w2, "type");
            return new ar(ba2, b.a(w2).b());
        }
        if (!bl2) return b.a(ap2);
        j.a((Object)w2, "type");
        return new ar(ba2, b.a(w2).a());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final ap a(kotlin.reflect.jvm.internal.impl.j.d.d object) {
        boolean bl2 = ((kotlin.reflect.jvm.internal.impl.j.d.d)object).a();
        if (y.a && !bl2) {
            kotlin.reflect.jvm.internal.impl.g.c c2 = kotlin.reflect.jvm.internal.impl.g.c.j.a(d.a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Only consistent enhanced type projection can be converted to type projection, but ");
            stringBuilder.append('[');
            stringBuilder.append(c2.a(((kotlin.reflect.jvm.internal.impl.j.d.d)object).b()));
            stringBuilder.append(": <");
            stringBuilder.append(c2.a(((kotlin.reflect.jvm.internal.impl.j.d.d)object).c()));
            stringBuilder.append(", ");
            stringBuilder.append(c2.a(((kotlin.reflect.jvm.internal.impl.j.d.d)object).d()));
            stringBuilder.append(">]");
            stringBuilder.append(" was found");
            throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
        }
        kotlin.e.a.b<ba, ba> b2 = new kotlin.e.a.b<ba, ba>((kotlin.reflect.jvm.internal.impl.j.d.d)object){
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.j.d.d a;
            {
                this.a = d2;
                super(1);
            }

            @Override
            public final ba a(ba ba2) {
                j.b((Object)ba2, "variance");
                ba ba3 = ba2;
                if (ba2 == this.a.b().k()) {
                    ba3 = ba.a;
                }
                return ba3;
            }
        };
        if (j.a((Object)((kotlin.reflect.jvm.internal.impl.j.d.d)object).c(), (Object)((kotlin.reflect.jvm.internal.impl.j.d.d)object).d())) {
            return new ar(((kotlin.reflect.jvm.internal.impl.j.d.d)object).c());
        }
        if (KotlinBuiltIns.isNothing(((kotlin.reflect.jvm.internal.impl.j.d.d)object).c()) && ((kotlin.reflect.jvm.internal.impl.j.d.d)object).b().k() != ba.b) {
            object = new ar(b2.a(ba.c), ((kotlin.reflect.jvm.internal.impl.j.d.d)object).d());
            do {
                return (ap)object;
                break;
            } while (true);
        }
        if (KotlinBuiltIns.isNullableAny(((kotlin.reflect.jvm.internal.impl.j.d.d)object).d())) {
            object = new ar(b2.a(ba.b), ((kotlin.reflect.jvm.internal.impl.j.d.d)object).c());
            return (ap)object;
        }
        object = new ar(b2.a(ba.c), ((kotlin.reflect.jvm.internal.impl.j.d.d)object).d());
        return (ap)object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final kotlin.reflect.jvm.internal.impl.j.d.a<w> a(w object) {
        ArrayList<void> arrayList;
        ArrayList<Object> arrayList2;
        void var4_17;
        boolean bl2;
        block14 : {
            j.b(object, "type");
            if (t.a((w)object)) {
                kotlin.reflect.jvm.internal.impl.j.d.a<w> a2 = b.a(t.c((w)object));
                kotlin.reflect.jvm.internal.impl.j.d.a<w> a3 = b.a(t.d((w)object));
                return new kotlin.reflect.jvm.internal.impl.j.d.a<w>(ax.a(x.a(t.c(a2.a()), t.d(a3.a())), (w)object), ax.a(x.a(t.c(a2.b()), t.d(a3.b())), (w)object));
            }
            Object object2 = ((w)object).g();
            if (kotlin.reflect.jvm.internal.impl.h.a.a.c.a((w)object)) {
                if (object2 == null) throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
                ap ap2 = ((kotlin.reflect.jvm.internal.impl.h.a.a.b)object2).h();
                kotlin.e.a.b<w, w> b2 = new kotlin.e.a.b<w, w>((w)object){
                    final /* synthetic */ w a;
                    {
                        this.a = w2;
                        super(1);
                    }

                    @Override
                    public final w a(w w2) {
                        j.b(w2, "$receiver");
                        return av.b(w2, this.a.c());
                    }
                };
                w w2 = ap2.c();
                j.a((Object)w2, "typeProjection.type");
                w2 = b2.a(w2);
                object2 = ap2.b();
                switch (kotlin.reflect.jvm.internal.impl.j.d.c.b[((Enum)object2).ordinal()]) {
                    default: {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Only nontrivial projections should have been captured, not: ");
                        ((StringBuilder)object).append(ap2);
                        throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
                    }
                    case 2: {
                        object = kotlin.reflect.jvm.internal.impl.j.c.a.a((w)object).getNothingType();
                        j.a(object, "type.builtIns.nothingType");
                        return new kotlin.reflect.jvm.internal.impl.j.d.a<w>(b2.a((w)object), w2);
                    }
                    case 1: 
                }
                return new kotlin.reflect.jvm.internal.impl.j.d.a<w>(w2, kotlin.reflect.jvm.internal.impl.j.c.a.a((w)object).getNullableAnyType());
            }
            if (((w)object).a().isEmpty()) return new kotlin.reflect.jvm.internal.impl.j.d.a<Object>(object, object);
            if (((w)object).a().size() != object2.b().size()) {
                return new kotlin.reflect.jvm.internal.impl.j.d.a<Object>(object, object);
            }
            arrayList2 = new ArrayList<Object>();
            arrayList = new ArrayList<void>();
            Iterable iterable = ((w)object).a();
            object2 = object2.b();
            j.a(object2, "typeConstructor.parameters");
            for (o o2 : kotlin.a.m.a(iterable, (Iterable)object2)) {
                void var4_8;
                Object object3 = (ap)o2.c();
                as as2 = (as)o2.d();
                j.a((Object)as2, "typeParameter");
                kotlin.reflect.jvm.internal.impl.j.d.d d2 = b.a((ap)object3, as2);
                if (object3.a()) {
                    arrayList2.add(d2);
                } else {
                    kotlin.reflect.jvm.internal.impl.j.d.a<kotlin.reflect.jvm.internal.impl.j.d.d> a4 = b.b(d2);
                    object3 = a4.c();
                    kotlin.reflect.jvm.internal.impl.j.d.d d3 = a4.d();
                    arrayList2.add(object3);
                }
                arrayList.add(var4_8);
            }
            Iterable iterable2 = arrayList2;
            boolean bl3 = iterable2 instanceof Collection;
            boolean bl4 = false;
            if (bl3 && ((Collection)iterable2).isEmpty()) {
                bl2 = bl4;
            } else {
                Iterator iterator = iterable2.iterator();
                do {
                    bl2 = bl4;
                    if (!iterator.hasNext()) break block14;
                } while (!(((kotlin.reflect.jvm.internal.impl.j.d.d)iterator.next()).a() ^ true));
                bl2 = true;
            }
        }
        if (bl2) {
            ad ad2 = kotlin.reflect.jvm.internal.impl.j.c.a.a((w)object).getNothingType();
            j.a((Object)ad2, "type.builtIns.nothingType");
            w w3 = ad2;
            return new kotlin.reflect.jvm.internal.impl.j.d.a<w>((w)var4_17, b.a((w)object, (List<kotlin.reflect.jvm.internal.impl.j.d.d>)arrayList));
        }
        w w4 = b.a((w)object, (List<kotlin.reflect.jvm.internal.impl.j.d.d>)arrayList2);
        return new kotlin.reflect.jvm.internal.impl.j.d.a<w>((w)var4_17, b.a((w)object, (List<kotlin.reflect.jvm.internal.impl.j.d.d>)arrayList));
    }

    private static final kotlin.reflect.jvm.internal.impl.j.d.d a(ap object, as as2) {
        Object object2 = au.a(as2.k(), (ap)object);
        switch (kotlin.reflect.jvm.internal.impl.j.d.c.a[object2.ordinal()]) {
            default: {
                throw new m();
            }
            case 3: {
                object2 = kotlin.reflect.jvm.internal.impl.h.c.a.d(as2).getNothingType();
                j.a(object2, "typeParameter.builtIns.nothingType");
                object2 = (w)object2;
                object = object.c();
                j.a(object, "type");
                return new kotlin.reflect.jvm.internal.impl.j.d.d(as2, (w)object2, (w)object);
            }
            case 2: {
                object = object.c();
                j.a(object, "type");
                object2 = kotlin.reflect.jvm.internal.impl.h.c.a.d(as2).getNullableAnyType();
                j.a(object2, "typeParameter.builtIns.nullableAnyType");
                return new kotlin.reflect.jvm.internal.impl.j.d.d(as2, (w)object, (w)object2);
            }
            case 1: 
        }
        object2 = object.c();
        j.a(object2, "type");
        object = object.c();
        j.a(object, "type");
        return new kotlin.reflect.jvm.internal.impl.j.d.d(as2, (w)object2, (w)object);
    }

    private static final w a(w object, List<kotlin.reflect.jvm.internal.impl.j.d.d> collection) {
        boolean bl2 = ((w)object).a().size() == collection.size();
        if (y.a && !bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Incorrect type arguments ");
            ((StringBuilder)object).append(collection);
            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
        }
        Object object2 = collection;
        collection = new ArrayList(kotlin.a.m.a(object2, 10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            collection.add((kotlin.reflect.jvm.internal.impl.j.d.d)((Object)b.a((kotlin.reflect.jvm.internal.impl.j.d.d)object2.next())));
        }
        return at.a((w)object, collection, null, 2, null);
    }

    private static final kotlin.reflect.jvm.internal.impl.j.d.a<kotlin.reflect.jvm.internal.impl.j.d.d> b(kotlin.reflect.jvm.internal.impl.j.d.d d2) {
        Object object = b.a(d2.c());
        w w2 = ((kotlin.reflect.jvm.internal.impl.j.d.a)object).c();
        object = ((kotlin.reflect.jvm.internal.impl.j.d.a)object).d();
        Object object2 = b.a(d2.d());
        w w3 = ((kotlin.reflect.jvm.internal.impl.j.d.a)object2).c();
        object2 = ((kotlin.reflect.jvm.internal.impl.j.d.a)object2).d();
        return new kotlin.reflect.jvm.internal.impl.j.d.a<kotlin.reflect.jvm.internal.impl.j.d.d>(new kotlin.reflect.jvm.internal.impl.j.d.d(d2.b(), (w)object, w3), new kotlin.reflect.jvm.internal.impl.j.d.d(d2.b(), w2, (w)object2));
    }

}

