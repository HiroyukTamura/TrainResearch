/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.a.g;
import kotlin.reflect.jvm.internal.impl.a.a.h;

public final class m
implements h {
    private final h b;
    private final b<kotlin.reflect.jvm.internal.impl.e.b, Boolean> c;

    public m(h h2, b<? super kotlin.reflect.jvm.internal.impl.e.b, Boolean> b2) {
        j.b(h2, "delegate");
        j.b(b2, "fqNameFilter");
        this.b = h2;
        this.c = b2;
    }

    private final boolean a(c object) {
        return (object = object.b()) != null && this.c.a((kotlin.reflect.jvm.internal.impl.e.b)object) != false;
    }

    @Override
    public c a(kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "fqName");
        if (this.c.a(b2).booleanValue()) {
            return this.b.a(b2);
        }
        return null;
    }

    @Override
    public boolean a() {
        boolean bl2;
        block2 : {
            c c2;
            Object object = this.b;
            bl2 = object instanceof Collection;
            boolean bl3 = false;
            if (bl2 && ((Collection)object).isEmpty()) {
                return false;
            }
            object = object.iterator();
            do {
                bl2 = bl3;
                if (!object.hasNext()) break block2;
            } while (!this.a(c2 = (c)object.next()));
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public List<g> b() {
        Object object = this.b.b();
        Collection collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (!this.a(((g)e2).a())) continue;
            collection.add(e2);
        }
        return (List)collection;
    }

    @Override
    public boolean b(kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "fqName");
        if (this.c.a(b2).booleanValue()) {
            return this.b.b(b2);
        }
        return false;
    }

    @Override
    public List<g> c() {
        Object object = this.b.c();
        Collection collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (!this.a(((g)e2).a())) continue;
            collection.add(e2);
        }
        return (List)collection;
    }

    @Override
    public Iterator<c> iterator() {
        Object object = this.b;
        Collection collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            c c2 = (c)e2;
            if (!this.a(c2)) continue;
            collection.add(e2);
        }
        return ((List)collection).iterator();
    }
}

