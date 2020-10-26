/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.j;
import kotlin.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.a.l;
import kotlin.reflect.jvm.internal.impl.c.a.c.b.a;
import kotlin.reflect.jvm.internal.impl.c.a.c.b.b;
import kotlin.reflect.jvm.internal.impl.c.a.c.b.d;
import kotlin.reflect.jvm.internal.impl.c.a.c.b.f;
import kotlin.reflect.jvm.internal.impl.c.a.c.b.g;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ar;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.t;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.reflect.jvm.internal.impl.j.y;
import kotlin.s;

public final class e
extends kotlin.reflect.jvm.internal.impl.j.as {
    public static final e a = new e();
    private static final a b = d.a(l.b, false, null, 3, null).a(b.c);
    private static final a c = d.a(l.b, false, null, 3, null).a(b.b);

    private e() {
    }

    /*
     * Enabled aggressive block sorting
     */
    private final o<ad, Boolean> a(ad object, kotlin.reflect.jvm.internal.impl.a.e object2, a collection) {
        Object object3;
        block7 : {
            block5 : {
                block6 : {
                    if (((w)object).g().b().isEmpty()) break block5;
                    object3 = (w)object;
                    if (!KotlinBuiltIns.isArray((w)object3)) break block6;
                    collection = ((w)object).a().get(0);
                    object2 = collection.b();
                    collection = collection.c();
                    j.a((Object)collection, "componentTypeProjection.type");
                    object2 = kotlin.a.m.a(new ar((ba)((Object)object2), this.c((w)((Object)collection))));
                    object = x.a(object.x(), ((w)object).g(), (List<? extends ap>)object2, ((w)object).c());
                    break block5;
                }
                if (!y.a((w)object3)) break block7;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Raw error type: ");
                ((StringBuilder)object2).append(((w)object).g());
                object = p.c(((StringBuilder)object2).toString());
            }
            object2 = false;
            return s.a(object, object2);
        }
        object3 = object.x();
        an an2 = ((w)object).g();
        Collection<as> collection2 = ((w)object).g().b();
        j.a(collection2, "type.constructor.parameters");
        Object object4 = collection2;
        collection2 = new ArrayList(kotlin.a.m.a(object4, 10));
        object4 = object4.iterator();
        do {
            if (!object4.hasNext()) {
                collection = collection2;
                boolean bl2 = ((w)object).c();
                object = object2.a(a);
                j.a(object, "declaration.getMemberScope(RawSubstitution)");
                object = x.a((h)object3, an2, collection, bl2, (kotlin.reflect.jvm.internal.impl.h.e.h)object);
                object2 = true;
                return s.a(object, object2);
            }
            as as2 = (as)object4.next();
            e e2 = a;
            j.a((Object)as2, "parameter");
            collection2.add((as)((Object)e.a(e2, as2, collection, null, 4, null)));
        } while (true);
    }

    public static /* bridge */ /* synthetic */ ap a(e e2, as as2, a a2, w w2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            w2 = d.a(as2, null, null, 3, null);
        }
        return e2.a(as2, a2, w2);
    }

    private final w c(w object) {
        kotlin.reflect.jvm.internal.impl.a.a.a a2 = ((w)object).g().d();
        if (a2 instanceof as) {
            return this.c(d.a((as)a2, null, null, 3, null));
        }
        if (a2 instanceof kotlin.reflect.jvm.internal.impl.a.e) {
            Object object2 = t.c((w)object);
            kotlin.reflect.jvm.internal.impl.a.a.a a3 = (kotlin.reflect.jvm.internal.impl.a.e)a2;
            object2 = this.a((ad)object2, (kotlin.reflect.jvm.internal.impl.a.e)a3, b);
            a2 = (ad)((o)object2).c();
            boolean bl2 = (Boolean)((o)object2).d();
            object = this.a(t.d((w)object), (kotlin.reflect.jvm.internal.impl.a.e)a3, c);
            a3 = ((o)object).c();
            boolean bl3 = ((o)object).d();
            object = !bl2 && !bl3 ? x.a((ad)a2, (ad)a3) : (az)new g((ad)a2, (ad)a3);
            return (w)object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Unexpected declaration kind: ");
        ((StringBuilder)object).append(a2);
        throw (Throwable)new IllegalStateException(((StringBuilder)object).toString().toString());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final ap a(as object, a a2, w w2) {
        j.b(object, "parameter");
        j.b(a2, "attr");
        j.b(w2, "erasedUpperBound");
        b b2 = a2.b();
        switch (f.a[b2.ordinal()]) {
            default: {
                throw new m();
            }
            case 2: 
            case 3: {
                if (!object.k().b()) {
                    return new ar(ba.a, kotlin.reflect.jvm.internal.impl.h.c.a.d((kotlin.reflect.jvm.internal.impl.a.m)object).getNothingType());
                }
                List<as> list = w2.g().b();
                j.a(list, "erasedUpperBound.constructor.parameters");
                if (!(((Collection)list).isEmpty() ^ true)) return d.a((as)object, a2);
                return new ar(ba.c, w2);
            }
            case 1: 
        }
        return new ar(ba.a, w2);
    }

    public ar a(w w2) {
        j.b(w2, "key");
        return new ar(this.c(w2));
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public /* synthetic */ ap b(w w2) {
        return this.a(w2);
    }
}

