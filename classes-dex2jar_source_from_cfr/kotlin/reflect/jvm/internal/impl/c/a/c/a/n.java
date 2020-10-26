/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.aq;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.a.l;
import kotlin.reflect.jvm.internal.impl.c.a.c.b;
import kotlin.reflect.jvm.internal.impl.c.a.c.b.a;
import kotlin.reflect.jvm.internal.impl.c.a.c.b.c;
import kotlin.reflect.jvm.internal.impl.c.a.c.e;
import kotlin.reflect.jvm.internal.impl.c.a.c.h;
import kotlin.reflect.jvm.internal.impl.c.a.e.d;
import kotlin.reflect.jvm.internal.impl.c.a.e.j;
import kotlin.reflect.jvm.internal.impl.c.a.e.v;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;

public final class n
extends kotlin.reflect.jvm.internal.impl.a.c.b {
    private final e a;
    private final h b;
    private final kotlin.reflect.jvm.internal.impl.c.a.e.w c;

    public n(h h2, kotlin.reflect.jvm.internal.impl.c.a.e.w w2, int n2, kotlin.reflect.jvm.internal.impl.a.m m2) {
        kotlin.e.b.j.b(h2, "c");
        kotlin.e.b.j.b(w2, "javaTypeParameter");
        kotlin.e.b.j.b(m2, "containingDeclaration");
        super(h2.c(), m2, w2.r(), ba.a, false, n2, an.a, h2.e().l());
        this.b = h2;
        this.c = w2;
        this.a = new e(this.b, this.c);
    }

    @Override
    protected void a(w w2) {
        kotlin.e.b.j.b(w2, "type");
    }

    @Override
    protected List<w> m() {
        Collection<j> collection = this.c.c();
        if (collection.isEmpty()) {
            collection = this.b.d().a().getAnyType();
            kotlin.e.b.j.a((Object)collection, "c.module.builtIns.anyType");
            ad ad2 = this.b.d().a().getNullableAnyType();
            kotlin.e.b.j.a((Object)ad2, "c.module.builtIns.nullableAnyType");
            return m.a(x.a((ad)((Object)collection), ad2));
        }
        Object object = collection;
        collection = new ArrayList(m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            j j2 = (j)object.next();
            collection.add((j)((Object)this.b.b().a((v)j2, kotlin.reflect.jvm.internal.impl.c.a.c.b.d.a(l.b, false, this, 1, null))));
        }
        return (List)collection;
    }

    public e o() {
        return this.a;
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.a.h x() {
        return this.o();
    }
}

