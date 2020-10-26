/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.o;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;

final class c
implements as {
    private final as a;
    private final m b;
    private final int c;

    public c(as as2, m m2, int n2) {
        j.b(as2, "originalDescriptor");
        j.b(m2, "declarationDescriptor");
        this.a = as2;
        this.b = m2;
        this.c = n2;
    }

    @Override
    public <R, D> R a(o<R, D> o2, D d2) {
        return this.a.a(o2, d2);
    }

    @Override
    public boolean a() {
        return true;
    }

    @Override
    public m b() {
        return this.b;
    }

    @Override
    public as c() {
        return this.a.c();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.j.an e() {
        return this.a.e();
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.h f() {
        return this.c();
    }

    @Override
    public int g() {
        return this.c + this.a.g();
    }

    @Override
    public f h_() {
        return this.a.h_();
    }

    @Override
    public ad i_() {
        return this.a.i_();
    }

    @Override
    public List<w> j() {
        return this.a.j();
    }

    @Override
    public ba k() {
        return this.a.k();
    }

    @Override
    public boolean l() {
        return this.a.l();
    }

    @Override
    public /* synthetic */ m m_() {
        return this.c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.toString());
        stringBuilder.append("[inner-copy]");
        return stringBuilder.toString();
    }

    @Override
    public h x() {
        return this.a.x();
    }

    @Override
    public an y() {
        return this.a.y();
    }
}

