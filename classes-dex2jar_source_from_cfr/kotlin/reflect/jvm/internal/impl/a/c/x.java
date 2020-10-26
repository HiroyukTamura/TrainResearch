/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ah;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.aj;
import kotlin.reflect.jvm.internal.impl.a.ak;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.k;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.n;
import kotlin.reflect.jvm.internal.impl.a.p;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.au;

public abstract class x
extends k
implements ah {
    static final /* synthetic */ boolean a;
    private boolean b;
    private final boolean c;
    private final w d;
    private final ai e;
    private final boolean f;
    private final b.a g;
    private ba h;
    private t i = null;

    static {
        a = x.class.desiredAssertionStatus() ^ true;
    }

    public x(w w2, ba ba2, ai ai2, h h2, f f2, boolean bl2, boolean bl3, boolean bl4, b.a a2, an an2) {
        super(ai2.b(), h2, f2, an2);
        this.d = w2;
        this.h = ba2;
        this.e = ai2;
        this.b = bl2;
        this.c = bl3;
        this.f = bl4;
        this.g = a2;
    }

    @Override
    public boolean A() {
        return false;
    }

    @Override
    public boolean B() {
        return false;
    }

    @Override
    public boolean C() {
        return false;
    }

    @Override
    public boolean D() {
        return false;
    }

    @Override
    public t.a<? extends t> E() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override
    public <V> V a(t.b<V> b2) {
        return null;
    }

    @Override
    public /* synthetic */ b a(m m2, w w2, ba ba2, b.a a2, boolean bl2) {
        return this.b(m2, w2, ba2, a2, bl2);
    }

    @Override
    public void a(Collection<? extends b> collection) {
        if (!a) {
            if (collection.isEmpty()) {
                return;
            }
            throw new AssertionError((Object)"Overridden accessors should be empty");
        }
    }

    public void a(ba ba2) {
        this.h = ba2;
    }

    public void a(t t2) {
        this.i = t2;
    }

    public void a(boolean bl2) {
        this.b = bl2;
    }

    @Override
    public boolean a() {
        return this.f;
    }

    protected Collection<ah> b(boolean bl2) {
        ArrayList<ah> arrayList = new ArrayList<ah>(0);
        for (ai ai2 : this.q().k()) {
            void b2;
            if (bl2) {
                aj aj2 = ai2.a();
            } else {
                ak ak2 = ai2.c();
            }
            if (b2 == null) continue;
            arrayList.add((ah)b2);
        }
        return arrayList;
    }

    public ah b(m m2, w w2, ba ba2, b.a a2, boolean bl2) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override
    public t c(au au2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public al d() {
        return this.q().d();
    }

    @Override
    public /* synthetic */ n d(au au2) {
        return this.c(au2);
    }

    @Override
    public al e() {
        return this.q().e();
    }

    @Override
    public List<as> f() {
        return Collections.emptyList();
    }

    @Override
    public /* synthetic */ a h() {
        return this.r();
    }

    @Override
    public boolean j() {
        return false;
    }

    @Override
    public /* synthetic */ b l() {
        return this.r();
    }

    @Override
    public w m() {
        return this.d;
    }

    @Override
    public /* synthetic */ m m_() {
        return this.r();
    }

    @Override
    public b.a n() {
        return this.g;
    }

    @Override
    public /* synthetic */ p n_() {
        return this.r();
    }

    @Override
    public boolean o() {
        return this.b;
    }

    @Override
    public ba p() {
        return this.h;
    }

    @Override
    public ai q() {
        return this.e;
    }

    public abstract ah r();

    @Override
    public /* synthetic */ t s() {
        return this.r();
    }

    @Override
    public t t() {
        return this.i;
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
    public boolean w() {
        return this.c;
    }

    @Override
    public boolean z() {
        return false;
    }
}

