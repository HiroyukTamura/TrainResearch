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
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.h.i;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.a.g;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.i.f;
import kotlin.reflect.l;

public class b
implements h {
    static final /* synthetic */ l[] b;
    private final f c;

    static {
        b = new l[]{v.a(new t(v.a(b.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    public b(kotlin.reflect.jvm.internal.impl.i.i i2, kotlin.e.a.a<? extends List<g>> a2) {
        j.b(i2, "storageManager");
        j.b(a2, "compute");
        this.c = i2.a(a2);
    }

    private final List<g> d() {
        return (List)kotlin.reflect.jvm.internal.impl.i.h.a(this.c, (Object)this, b[0]);
    }

    @Override
    public c a(kotlin.reflect.jvm.internal.impl.e.b object) {
        Object var4_5;
        Object object2;
        block3 : {
            block2 : {
                c c2;
                g g2;
                boolean bl2;
                j.b(object, "fqName");
                Iterator iterator = ((Iterable)this.d()).iterator();
                do {
                    boolean bl3 = iterator.hasNext();
                    var4_5 = null;
                    if (!bl3) break block2;
                    object2 = iterator.next();
                    g2 = (g)object2;
                    c2 = g2.c();
                } while (!(bl2 = g2.d() == null && j.a((Object)c2.b(), object)));
                object = object2;
                break block3;
            }
            object = null;
        }
        object2 = (g)object;
        object = var4_5;
        if (object2 != null) {
            object = ((g)object2).a();
        }
        return object;
    }

    @Override
    public boolean a() {
        return this.d().isEmpty();
    }

    @Override
    public List<g> b() {
        Object object = this.d();
        Collection collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            boolean bl2 = ((g)e2).b() != null;
            if (!bl2) continue;
            collection.add(e2);
        }
        return (List)collection;
    }

    @Override
    public boolean b(kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "fqName");
        return h.b.b(this, b2);
    }

    @Override
    public List<g> c() {
        return this.d();
    }

    @Override
    public Iterator<c> iterator() {
        return i.e(i.a(m.q((Iterable)this.d()), a.a), b.a).a();
    }

}

