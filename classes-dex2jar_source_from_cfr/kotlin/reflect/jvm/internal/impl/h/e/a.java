/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e;

import java.util.Collection;
import java.util.Set;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.e.d;
import kotlin.reflect.jvm.internal.impl.h.e.h;

public abstract class a
implements h {
    @Override
    public Collection<ai> a(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        j.b(f2, "name");
        j.b(b2, "location");
        return this.c().a(f2, b2);
    }

    @Override
    public Collection<m> a(d d2, b<? super f, Boolean> b2) {
        j.b(d2, "kindFilter");
        j.b(b2, "nameFilter");
        return this.c().a(d2, b2);
    }

    @Override
    public Collection<am> b(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        j.b(f2, "name");
        j.b(b2, "location");
        return this.c().b(f2, b2);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.h c(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        j.b(f2, "name");
        j.b(b2, "location");
        return this.c().c(f2, b2);
    }

    protected abstract h c();

    @Override
    public Set<f> l_() {
        return this.c().l_();
    }

    @Override
    public Set<f> o_() {
        return this.c().o_();
    }
}

