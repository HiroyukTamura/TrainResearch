/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.h.i;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ac;
import kotlin.reflect.jvm.internal.impl.e.f;

public final class ad
implements ac {
    private final Collection<ab> a;

    public ad(Collection<? extends ab> collection) {
        j.b(collection, "packageFragments");
        this.a = collection;
    }

    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.e.b> a(final kotlin.reflect.jvm.internal.impl.e.b b2, kotlin.e.a.b<? super f, Boolean> b3) {
        j.b(b2, "fqName");
        j.b(b3, "nameFilter");
        return i.e(i.a(i.e(m.q((Iterable)this.a), a.a), (kotlin.e.a.b)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.b, Boolean>(){

            @Override
            public /* synthetic */ Object a(Object object) {
                return this.a((kotlin.reflect.jvm.internal.impl.e.b)object);
            }

            @Override
            public final boolean a(kotlin.reflect.jvm.internal.impl.e.b b22) {
                j.b(b22, "it");
                return !b22.c() && j.a((Object)b22.d(), (Object)b2);
            }
        }));
    }

    @Override
    public List<ab> a(kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "fqName");
        Object object = this.a;
        Collection collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (!j.a((Object)((ab)e2).f(), (Object)b2)) continue;
            collection.add(e2);
        }
        return (List)collection;
    }

}

