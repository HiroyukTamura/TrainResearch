/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.al;
import kotlin.a.m;
import kotlin.e.a.a;
import kotlin.e.a.b;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.b.a.c;
import kotlin.reflect.jvm.internal.impl.b.a.d;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.k;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.h;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.l;

public class i
extends h {
    private final kotlin.reflect.jvm.internal.impl.e.b a;
    private final ab d;

    public i(ab ab2, a.s object, kotlin.reflect.jvm.internal.impl.d.b.c object2, kotlin.reflect.jvm.internal.impl.d.b.a object3, f object4, j j2, a<? extends Collection<kotlin.reflect.jvm.internal.impl.e.f>> a2) {
        kotlin.e.b.j.b(ab2, "packageDescriptor");
        kotlin.e.b.j.b(object, "proto");
        kotlin.e.b.j.b(object2, "nameResolver");
        kotlin.e.b.j.b(object3, "metadataVersion");
        kotlin.e.b.j.b(j2, "components");
        kotlin.e.b.j.b(a2, "classNames");
        Object object5 = ((a.s)object).p();
        kotlin.e.b.j.a(object5, "proto.typeTable");
        object5 = new kotlin.reflect.jvm.internal.impl.d.b.h((a.ai)object5);
        k.a a3 = k.a;
        a.ao ao2 = ((a.s)object).r();
        kotlin.e.b.j.a((Object)ao2, "proto.versionRequirementTable");
        object2 = j2.a(ab2, (kotlin.reflect.jvm.internal.impl.d.b.c)object2, (kotlin.reflect.jvm.internal.impl.d.b.h)object5, a3.a(ao2), (kotlin.reflect.jvm.internal.impl.d.b.a)object3, (f)object4);
        object3 = ((a.s)object).d();
        kotlin.e.b.j.a(object3, "proto.functionList");
        object3 = (Collection)object3;
        object4 = ((a.s)object).f();
        kotlin.e.b.j.a(object4, "proto.propertyList");
        object4 = (Collection)object4;
        object = ((a.s)object).j();
        kotlin.e.b.j.a(object, "proto.typeAliasList");
        super((l)object2, (Collection<a.o>)object3, (Collection<a.w>)object4, (Collection)object, a2);
        this.d = ab2;
        this.a = this.d.f();
    }

    public /* synthetic */ Collection a(kotlin.reflect.jvm.internal.impl.h.e.d d2, b b2) {
        return this.b(d2, b2);
    }

    @Override
    protected kotlin.reflect.jvm.internal.impl.e.a a(kotlin.reflect.jvm.internal.impl.e.f f2) {
        kotlin.e.b.j.b(f2, "name");
        return new kotlin.reflect.jvm.internal.impl.e.a(this.a, f2);
    }

    @Override
    protected void a(Collection<kotlin.reflect.jvm.internal.impl.a.m> collection, b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b2) {
        kotlin.e.b.j.b(collection, "result");
        kotlin.e.b.j.b(b2, "nameFilter");
    }

    public List<kotlin.reflect.jvm.internal.impl.a.m> b(kotlin.reflect.jvm.internal.impl.h.e.d object, b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> object2) {
        kotlin.e.b.j.b(object, "kindFilter");
        kotlin.e.b.j.b(object2, "nameFilter");
        object = this.a((kotlin.reflect.jvm.internal.impl.h.e.d)object, (b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean>)object2, d.m);
        Object object3 = this.f().d().l();
        object2 = new ArrayList();
        object3 = object3.iterator();
        while (object3.hasNext()) {
            m.a(object2, (Iterable)((kotlin.reflect.jvm.internal.impl.a.b.b)object3.next()).a(this.a));
        }
        return m.b(object, (List)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected boolean b(kotlin.reflect.jvm.internal.impl.e.f f2) {
        kotlin.e.b.j.b(f2, "name");
        boolean bl2 = super.b(f2);
        boolean bl3 = true;
        if (bl2) return bl3;
        Iterable<kotlin.reflect.jvm.internal.impl.a.b.b> iterable = this.f().d().l();
        if (iterable instanceof Collection && ((Collection)iterable).isEmpty()) {
            return false;
        }
        iterable = iterable.iterator();
        do {
            if (!iterable.hasNext()) return false;
        } while (!((kotlin.reflect.jvm.internal.impl.a.b.b)iterable.next()).a(this.a, f2));
        return true;
    }

    @Override
    protected Set<kotlin.reflect.jvm.internal.impl.e.f> c() {
        return al.a();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.h c(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(b2, "location");
        this.d(f2, b2);
        return super.c(f2, b2);
    }

    @Override
    protected Set<kotlin.reflect.jvm.internal.impl.e.f> d() {
        return al.a();
    }

    @Override
    public void d(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(b2, "location");
        kotlin.reflect.jvm.internal.impl.b.a.a(this.f().d().j(), b2, this.d, f2);
    }
}

