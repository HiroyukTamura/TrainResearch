/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c;

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
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.c.b;
import kotlin.reflect.jvm.internal.impl.c.a.c.h;
import kotlin.reflect.jvm.internal.impl.c.a.e.d;

public final class e
implements kotlin.reflect.jvm.internal.impl.a.a.h {
    private final kotlin.reflect.jvm.internal.impl.i.d<kotlin.reflect.jvm.internal.impl.c.a.e.a, c> b;
    private final h c;
    private final d d;

    public e(h h2, d d2) {
        j.b(h2, "c");
        j.b(d2, "annotationOwner");
        this.c = h2;
        this.d = d2;
        this.b = this.c.e().a().b((kotlin.e.a.b)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.c.a.e.a, c>(){

            @Override
            public final c a(kotlin.reflect.jvm.internal.impl.c.a.e.a a2) {
                j.b(a2, "annotation");
                return kotlin.reflect.jvm.internal.impl.c.a.a.c.a.a(a2, this.c);
            }
        });
    }

    @Override
    public c a(kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "fqName");
        Object object = this.d.a(b2);
        if (object != null && (object = (c)((kotlin.e.a.b)this.b).a(object)) != null) {
            return object;
        }
        return kotlin.reflect.jvm.internal.impl.c.a.a.c.a.a(b2, this.d, this.c);
    }

    @Override
    public boolean a() {
        return this.d.a().isEmpty() && !this.d.b();
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

    @Override
    public Iterator<c> iterator() {
        kotlin.h.h h2 = i.e(m.q((Iterable)this.d.a()), (kotlin.e.a.b)this.b);
        kotlin.reflect.jvm.internal.impl.c.a.a.c c2 = kotlin.reflect.jvm.internal.impl.c.a.a.c.a;
        kotlin.reflect.jvm.internal.impl.e.b b2 = KotlinBuiltIns.FQ_NAMES.deprecated;
        j.a((Object)b2, "KotlinBuiltIns.FQ_NAMES.deprecated");
        return i.d(i.a(h2, c2.a(b2, this.d, this.c))).a();
    }

}

