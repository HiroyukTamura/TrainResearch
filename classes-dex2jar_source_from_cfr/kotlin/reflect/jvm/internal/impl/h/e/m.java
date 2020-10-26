/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.e.h;
import kotlin.reflect.jvm.internal.impl.h.k;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.t;

public final class m
extends kotlin.reflect.jvm.internal.impl.h.e.a {
    public static final a a = new a(null);
    private final kotlin.reflect.jvm.internal.impl.h.e.b b;

    private m(kotlin.reflect.jvm.internal.impl.h.e.b b2) {
        this.b = b2;
    }

    public /* synthetic */ m(kotlin.reflect.jvm.internal.impl.h.e.b b2, g g2) {
        this(b2);
    }

    public static final h a(String string2, Collection<? extends w> collection) {
        return a.a(string2, collection);
    }

    @Override
    public Collection<ai> a(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        j.b(f2, "name");
        j.b(b2, "location");
        return k.a(super.a(f2, b2), d.a);
    }

    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.a.m> a(kotlin.reflect.jvm.internal.impl.h.e.d object, kotlin.e.a.b<? super f, Boolean> object2) {
        j.b(object, "kindFilter");
        j.b(object2, "nameFilter");
        Object object3 = super.a((kotlin.reflect.jvm.internal.impl.h.e.d)object, (kotlin.e.a.b<? super f, Boolean>)object2);
        object = new ArrayList();
        object2 = new ArrayList();
        object3 = object3.iterator();
        while (object3.hasNext()) {
            Object e2 = object3.next();
            if ((kotlin.reflect.jvm.internal.impl.a.m)e2 instanceof kotlin.reflect.jvm.internal.impl.a.a) {
                ((ArrayList)object).add(e2);
                continue;
            }
            ((ArrayList)object2).add(e2);
        }
        object2 = new o<Object, Object>(object, object2);
        object = (List)((o)object2).c();
        object2 = (List)((o)object2).d();
        if (object != null) {
            return kotlin.a.m.b(k.a((Collection)object, b.a), (Iterable)object2);
        }
        throw new t("null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
    }

    @Override
    public Collection<am> b(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        j.b(f2, "name");
        j.b(b2, "location");
        return k.a(super.b(f2, b2), c.a);
    }

    @Override
    public /* synthetic */ h c() {
        return this.d();
    }

    protected kotlin.reflect.jvm.internal.impl.h.e.b d() {
        return this.b;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final h a(String object, Collection<? extends w> collection) {
            j.b(object, "message");
            j.b(collection, "types");
            Object object2 = collection;
            Collection collection2 = new ArrayList(kotlin.a.m.a(object2, 10));
            object2 = object2.iterator();
            while (object2.hasNext()) {
                collection2.add(((w)object2.next()).b());
            }
            object = new kotlin.reflect.jvm.internal.impl.h.e.b((String)object, (List)collection2);
            if (collection.size() <= 1) {
                return (h)object;
            }
            return new m((kotlin.reflect.jvm.internal.impl.h.e.b)object, null);
        }
    }

}

