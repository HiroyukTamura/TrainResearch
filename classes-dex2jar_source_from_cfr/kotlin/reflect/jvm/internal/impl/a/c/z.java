/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ah;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.aj;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.x;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.o;
import kotlin.reflect.jvm.internal.impl.a.p;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.e.f;

public class z
extends x
implements aj {
    private kotlin.reflect.jvm.internal.impl.j.w b;
    private final aj c;

    public z(ai b2, h h2, w w2, ba ba2, boolean bl2, boolean bl3, boolean bl4, b.a a2, aj aj2, an an2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<get-");
        stringBuilder.append(b2.h_());
        stringBuilder.append(">");
        super(w2, ba2, (ai)b2, h2, f.c(stringBuilder.toString()), bl2, bl3, bl4, a2, an2);
        b2 = aj2 != null ? aj2 : this;
        this.c = b2;
    }

    public aj F() {
        return this.c;
    }

    @Override
    public <R, D> R a(o<R, D> o2, D d2) {
        return o2.a(this, d2);
    }

    public void a(kotlin.reflect.jvm.internal.impl.j.w w2) {
        kotlin.reflect.jvm.internal.impl.j.w w3 = w2;
        if (w2 == null) {
            w3 = this.q().r();
        }
        this.b = w3;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.j.w g() {
        return this.b;
    }

    @Override
    public /* synthetic */ a h() {
        return this.F();
    }

    @Override
    public List<av> i() {
        return Collections.emptyList();
    }

    public Collection<? extends aj> k() {
        return super.b(true);
    }

    @Override
    public /* synthetic */ b l() {
        return this.F();
    }

    @Override
    public /* synthetic */ m m_() {
        return this.F();
    }

    @Override
    public /* synthetic */ p n_() {
        return this.F();
    }

    @Override
    public /* synthetic */ ah r() {
        return this.F();
    }

    @Override
    public /* synthetic */ t s() {
        return this.F();
    }
}

