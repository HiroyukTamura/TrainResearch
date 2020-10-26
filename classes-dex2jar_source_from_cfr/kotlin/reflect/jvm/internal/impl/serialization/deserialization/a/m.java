/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.a.g;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.aq;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.aa;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.b;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.l;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.u;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.x;

public final class m
extends kotlin.reflect.jvm.internal.impl.a.c.b {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.a a;
    private final l b;
    private final a.ag c;

    public m(l l2, a.ag ag2, int n2) {
        kotlin.e.b.j.b(l2, "c");
        kotlin.e.b.j.b(ag2, "proto");
        i i2 = l2.c();
        kotlin.reflect.jvm.internal.impl.a.m m2 = l2.f();
        f f2 = u.b(l2.e(), ag2.g());
        x x2 = x.a;
        a.ag.b b2 = ag2.p();
        kotlin.e.b.j.a((Object)b2, "proto.variance");
        super(i2, m2, f2, x2.a(b2), ag2.k(), n2, an.a, aq.a.a);
        this.b = l2;
        this.c = ag2;
        this.a = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.a(this.b.c(), (kotlin.e.a.a<? extends List<? extends c>>)new kotlin.e.a.a<List<? extends c>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final List<c> b() {
                return kotlin.a.m.k((Iterable)this.b.d().f().a(this.c, this.b.e()));
            }
        });
    }

    @Override
    public /* synthetic */ void a(w w2) {
        this.b(w2);
    }

    protected Void b(w object) {
        kotlin.e.b.j.b(object, "type");
        object = new StringBuilder();
        ((StringBuilder)object).append("There should be no cycles for deserialized type parameters, but found for: ");
        ((StringBuilder)object).append(this);
        throw (Throwable)new IllegalStateException(((StringBuilder)object).toString());
    }

    @Override
    protected List<w> m() {
        Collection<a.ac> collection = kotlin.reflect.jvm.internal.impl.d.b.g.a(this.c, this.b.g());
        if (collection.isEmpty()) {
            return kotlin.a.m.a(kotlin.reflect.jvm.internal.impl.h.c.a.d(this).getDefaultBound());
        }
        Object object = collection;
        collection = new ArrayList(kotlin.a.m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            a.ac ac2 = (a.ac)object.next();
            collection.add((a.ac)((Object)this.b.a().a(ac2, h.a.a())));
        }
        return collection;
    }

    public kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.a o() {
        return this.a;
    }

    @Override
    public /* synthetic */ h x() {
        return this.o();
    }

}

