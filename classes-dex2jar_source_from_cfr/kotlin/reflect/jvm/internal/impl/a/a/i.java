/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.a.e;
import kotlin.reflect.jvm.internal.impl.a.a.g;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.e.b;

public final class i
implements h {
    public static final a b = new a(null);
    private final List<c> c;
    private final List<g> d;

    public i(List<? extends c> collection) {
        j.b(collection, "annotations");
        this.c = collection;
        Object object = collection;
        collection = new ArrayList(m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            collection.add((c)((Object)new g((c)object.next(), null)));
        }
        this.d = collection;
    }

    @Override
    public c a(b b2) {
        j.b(b2, "fqName");
        return h.b.a(this, b2);
    }

    @Override
    public boolean a() {
        return this.d.isEmpty();
    }

    @Override
    public List<g> b() {
        Object object;
        Iterator iterator = this.d;
        Collection collection = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            boolean bl2 = ((g)object).b() != null;
            if (!bl2) continue;
            collection.add(object);
        }
        iterator = (List)collection;
        collection = new ArrayList(m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            Object object2 = (g)iterator.next();
            object = object2.a();
            if ((object2 = object2.b()) == null) {
                j.a();
            }
            collection.add(new g((c)object, (e)((Object)object2)));
        }
        return (List)collection;
    }

    @Override
    public boolean b(b b2) {
        j.b(b2, "fqName");
        return h.b.b(this, b2);
    }

    @Override
    public List<g> c() {
        return this.d;
    }

    @Override
    public Iterator<c> iterator() {
        return this.c.iterator();
    }

    public String toString() {
        return this.c.toString();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }
    }

}

