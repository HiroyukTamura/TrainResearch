/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.ak;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.ah;
import kotlin.reflect.jvm.internal.impl.a.c.x;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.o;
import kotlin.reflect.jvm.internal.impl.a.p;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.ad;

public class aa
extends x
implements ak {
    static final /* synthetic */ boolean b;
    private av c;
    private final ak d;

    static {
        b = aa.class.desiredAssertionStatus() ^ true;
    }

    public aa(ai b2, h h2, w w2, ba ba2, boolean bl2, boolean bl3, boolean bl4, b.a a2, ak ak2, an an2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<set-");
        stringBuilder.append(b2.h_());
        stringBuilder.append(">");
        super(w2, ba2, (ai)b2, h2, f.c(stringBuilder.toString()), bl2, bl3, bl4, a2, an2);
        b2 = ak2 != null ? ak2 : this;
        this.d = b2;
    }

    public static ah a(ak ak2, kotlin.reflect.jvm.internal.impl.j.w w2) {
        return new ah(ak2, null, 0, h.a.a(), f.c("<set-?>"), w2, false, false, false, null, an.a);
    }

    public void F() {
        if (!b && this.c != null) {
            throw new AssertionError();
        }
        this.c = aa.a(this, this.q().g());
    }

    public ak G() {
        return this.d;
    }

    @Override
    public <R, D> R a(o<R, D> o2, D d2) {
        return o2.a(this, d2);
    }

    public void a(av av2) {
        if (!b && this.c != null) {
            throw new AssertionError();
        }
        this.c = av2;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.j.w g() {
        return kotlin.reflect.jvm.internal.impl.h.c.a.d(this).getUnitType();
    }

    @Override
    public /* synthetic */ a h() {
        return this.G();
    }

    @Override
    public List<av> i() {
        if (this.c != null) {
            return Collections.singletonList(this.c);
        }
        throw new IllegalStateException();
    }

    public Collection<? extends ak> k() {
        return super.b(false);
    }

    @Override
    public /* synthetic */ b l() {
        return this.G();
    }

    @Override
    public /* synthetic */ m m_() {
        return this.G();
    }

    @Override
    public /* synthetic */ p n_() {
        return this.G();
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.ah r() {
        return this.G();
    }

    @Override
    public /* synthetic */ t s() {
        return this.G();
    }
}

