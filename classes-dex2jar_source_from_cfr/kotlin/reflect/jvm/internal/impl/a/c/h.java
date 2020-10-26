/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.g;
import kotlin.reflect.jvm.internal.impl.a.d;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.f;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.h.e.h;
import kotlin.reflect.jvm.internal.impl.i.i;

public class h
extends g {
    static final /* synthetic */ boolean c;
    private final w d;
    private final f e;
    private final kotlin.reflect.jvm.internal.impl.j.an f;
    private kotlin.reflect.jvm.internal.impl.h.e.h g;
    private Set<d> h;
    private d i;

    static {
        c = h.class.desiredAssertionStatus() ^ true;
    }

    public h(m object, kotlin.reflect.jvm.internal.impl.e.f f2, w w2, f f3, Collection<kotlin.reflect.jvm.internal.impl.j.w> collection, an an2, boolean bl2, i i2) {
        super(i2, (m)object, f2, an2, bl2);
        if (!c && w2 == w.b) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Implement getSealedSubclasses() for this class: ");
            ((StringBuilder)object).append(this.getClass());
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        this.d = w2;
        this.e = f3;
        this.f = new kotlin.reflect.jvm.internal.impl.j.e(this, Collections.emptyList(), collection, i2);
    }

    public final void a(kotlin.reflect.jvm.internal.impl.h.e.h h2, Set<d> set, d d2) {
        this.g = h2;
        this.h = set;
        this.i = d2;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.j.an e() {
        return this.f;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h f_() {
        return h.c.a;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h g() {
        return this.g;
    }

    @Override
    public e i() {
        return null;
    }

    @Override
    public Collection<d> k() {
        return this.h;
    }

    @Override
    public f l() {
        return this.e;
    }

    @Override
    public w m() {
        return this.d;
    }

    @Override
    public d o() {
        return this.i;
    }

    @Override
    public ba p() {
        return az.e;
    }

    @Override
    public boolean q() {
        return false;
    }

    @Override
    public boolean r() {
        return false;
    }

    @Override
    public boolean s() {
        return false;
    }

    @Override
    public boolean t() {
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class ");
        stringBuilder.append(this.h_());
        return stringBuilder.toString();
    }

    @Override
    public boolean u() {
        return false;
    }

    @Override
    public boolean v() {
        return false;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.a.h x() {
        return kotlin.reflect.jvm.internal.impl.a.a.h.a.a();
    }

    @Override
    public List<as> z() {
        return Collections.emptyList();
    }
}

