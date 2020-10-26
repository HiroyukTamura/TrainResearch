/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.a.g;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.i.f;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.l;

public class a
implements h {
    static final /* synthetic */ l[] b;
    private final f c;

    static {
        b = new l[]{v.a(new t(v.a(a.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    public a(i i2, kotlin.e.a.a<? extends List<? extends c>> a2) {
        j.b(i2, "storageManager");
        j.b(a2, "compute");
        this.c = i2.a(a2);
    }

    private final List<c> d() {
        return (List)kotlin.reflect.jvm.internal.impl.i.h.a(this.c, (Object)this, b[0]);
    }

    @Override
    public c a(b b2) {
        j.b(b2, "fqName");
        return h.b.a(this, b2);
    }

    @Override
    public boolean a() {
        return this.d().isEmpty();
    }

    @Override
    public List<g> b() {
        return m.a();
    }

    @Override
    public boolean b(b b2) {
        j.b(b2, "fqName");
        return h.b.b(this, b2);
    }

    @Override
    public List<g> c() {
        Object object = this.d();
        Collection collection = new ArrayList(m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            collection.add(new g((c)object.next(), null));
        }
        return (List)collection;
    }

    @Override
    public Iterator<c> iterator() {
        return this.d().iterator();
    }
}

