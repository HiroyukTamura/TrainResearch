/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.m;
import kotlin.reflect.jvm.internal.impl.h.j;
import kotlin.reflect.jvm.internal.impl.l.j;
import kotlin.w;

public final class k {
    public static final <H> Collection<H> a(Collection<? extends H> collection, kotlin.e.a.b<? super H, ? extends kotlin.reflect.jvm.internal.impl.a.a> b2) {
        Collection<H> collection2;
        kotlin.e.b.j.b(collection, "$receiver");
        kotlin.e.b.j.b(b2, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        collection = new LinkedList<H>(collection);
        kotlin.reflect.jvm.internal.impl.l.j<Collection<Object>> j2 = kotlin.reflect.jvm.internal.impl.l.j.a.a();
        while ((collection2 = collection).isEmpty() ^ true) {
            Collection collection3;
            Object object = m.f((List)collection);
            Collection<H> collection4 = j.a(object, collection2, b2, new kotlin.e.a.b<H, w>((kotlin.reflect.jvm.internal.impl.l.j)(collection3 = kotlin.reflect.jvm.internal.impl.l.j.a.a())){
                final /* synthetic */ kotlin.reflect.jvm.internal.impl.l.j a;
                {
                    this.a = j2;
                    super(1);
                }

                @Override
                public /* synthetic */ Object a(Object object) {
                    this.b(object);
                    return w.a;
                }

                public final void b(H h2) {
                    kotlin.reflect.jvm.internal.impl.l.j j2 = this.a;
                    kotlin.e.b.j.a(h2, "it");
                    j2.add(h2);
                }
            });
            if (collection4.size() == 1 && ((AbstractCollection)collection3).isEmpty()) {
                kotlin.e.b.j.a(collection4, "overridableGroup");
                collection3 = m.f((Iterable)collection4);
                kotlin.e.b.j.a(collection3, "overridableGroup.single()");
                j2.add(collection3);
                continue;
            }
            collection2 = j.a(collection4, b2);
            kotlin.e.b.j.a(collection2, "mostSpecific");
            object = b2.a(collection2);
            kotlin.e.b.j.a(collection4, "overridableGroup");
            for (Object e2 : (Iterable)collection4) {
                kotlin.e.b.j.a(e2, "it");
                if (j.c(object, b2.a(e2))) continue;
                collection3.add(e2);
            }
            if ((collection3 = (Collection)collection3).isEmpty() ^ true) {
                j2.addAll(collection3);
            }
            j2.add(collection2);
        }
        return j2;
    }

    public static final <D extends kotlin.reflect.jvm.internal.impl.a.a> void a(Collection<D> collection) {
        kotlin.e.b.j.b(collection, "$receiver");
        Collection<D> collection2 = k.a(collection, a.a);
        if (collection.size() == collection2.size()) {
            return;
        }
        collection.retainAll(collection2);
    }

}

