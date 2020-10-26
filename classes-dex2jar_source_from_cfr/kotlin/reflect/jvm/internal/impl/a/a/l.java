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
import kotlin.e.b.k;
import kotlin.h.i;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.a.g;
import kotlin.reflect.jvm.internal.impl.a.a.h;

public final class l
implements h {
    private final List<h> b;

    public l(List<? extends h> list) {
        j.b(list, "delegates");
        this.b = list;
    }

    public /* varargs */ l(h ... arrh) {
        j.b(arrh, "delegates");
        this(kotlin.a.g.h(arrh));
    }

    @Override
    public c a(final kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "fqName");
        return (c)i.c(i.f(m.q((Iterable)this.b), (kotlin.e.a.b)new kotlin.e.a.b<h, c>(){

            @Override
            public final c a(h h2) {
                j.b(h2, "it");
                return h2.a(b2);
            }
        }));
    }

    @Override
    public boolean a() {
        boolean bl2;
        block2 : {
            Object object = this.b;
            bl2 = object instanceof Collection;
            boolean bl3 = true;
            if (bl2 && ((Collection)object).isEmpty()) {
                return true;
            }
            object = object.iterator();
            do {
                bl2 = bl3;
                if (!object.hasNext()) break block2;
            } while (((h)object.next()).a());
            bl2 = false;
        }
        return bl2;
    }

    @Override
    public List<g> b() {
        Object object = this.b;
        Collection collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            m.a(collection, (Iterable)((h)object.next()).b());
        }
        return (List)collection;
    }

    @Override
    public boolean b(kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "fqName");
        Iterator iterator = m.q((Iterable)this.b).a();
        while (iterator.hasNext()) {
            if (!((h)iterator.next()).b(b2)) continue;
            return true;
        }
        return false;
    }

    @Override
    public List<g> c() {
        Object object = this.b;
        Collection collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            m.a(collection, (Iterable)((h)object.next()).c());
        }
        return (List)collection;
    }

    @Override
    public Iterator<c> iterator() {
        return i.d(m.q((Iterable)this.b), b.a).a();
    }

}

