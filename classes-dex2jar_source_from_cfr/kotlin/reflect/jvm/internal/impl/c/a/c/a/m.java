/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.a;

import java.util.Collection;
import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.k;
import kotlin.reflect.jvm.internal.impl.c.a.c.h;
import kotlin.reflect.jvm.internal.impl.c.a.e.q;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.w;

public abstract class m
extends k {
    public m(h h2) {
        j.b(h2, "c");
        super(h2);
    }

    @Override
    protected k.a a(q q2, List<? extends as> list, w w2, List<? extends av> list2) {
        j.b(q2, "method");
        j.b(list, "methodTypeParameters");
        j.b(w2, "returnType");
        j.b(list2, "valueParameters");
        return new k.a(w2, null, list2, list, false, kotlin.a.m.<String>a());
    }

    @Override
    protected void a(f f2, Collection<ai> collection) {
        j.b(f2, "name");
        j.b(collection, "result");
    }

    @Override
    public /* synthetic */ al f() {
        return (al)((Object)this.g());
    }

    protected Void g() {
        return null;
    }
}

