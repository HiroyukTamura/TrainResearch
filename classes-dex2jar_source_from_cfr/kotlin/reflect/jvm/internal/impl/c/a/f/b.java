/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

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
import kotlin.reflect.jvm.internal.impl.c.a.f.a;

final class b
implements h {
    private final kotlin.reflect.jvm.internal.impl.e.b b;

    public b(kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "fqNameToMatch");
        this.b = b2;
    }

    @Override
    public /* synthetic */ c a(kotlin.reflect.jvm.internal.impl.e.b b2) {
        return this.c(b2);
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public List<g> b() {
        return m.a();
    }

    @Override
    public boolean b(kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "fqName");
        return h.b.b(this, b2);
    }

    @Override
    public List<g> c() {
        Object object = this;
        Collection collection = new ArrayList(m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            collection.add(new g((c)object.next(), null));
        }
        return (List)collection;
    }

    public a c(kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "fqName");
        if (j.a((Object)b2, (Object)this.b)) {
            return a.a;
        }
        return null;
    }

    @Override
    public Iterator<c> iterator() {
        return m.a().iterator();
    }
}

