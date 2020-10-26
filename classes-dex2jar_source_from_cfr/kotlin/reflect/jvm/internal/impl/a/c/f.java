/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.o;
import kotlin.reflect.jvm.internal.impl.a.d;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.i;
import kotlin.reflect.jvm.internal.impl.a.l;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.n;
import kotlin.reflect.jvm.internal.impl.a.p;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.j.au;

public class f
extends o
implements d {
    static final /* synthetic */ boolean b;
    private static final kotlin.reflect.jvm.internal.impl.e.f d;
    protected final boolean a;

    static {
        b = f.class.desiredAssertionStatus() ^ true;
        d = kotlin.reflect.jvm.internal.impl.e.f.c("<init>");
    }

    protected f(e e2, l l2, h h2, boolean bl2, b.a a2, an an2) {
        super(e2, l2, h2, d, a2, an2);
        this.a = bl2;
    }

    public static f a(e e2, h h2, boolean bl2, an an2) {
        return new f(e2, null, h2, bl2, b.a.a, an2);
    }

    public al F() {
        m m2 = this.G();
        if (m2.r() && (m2 = m2.b()) instanceof e) {
            return m2.D();
        }
        return null;
    }

    public e G() {
        return (e)super.b();
    }

    @Override
    public <R, D> R a(kotlin.reflect.jvm.internal.impl.a.o<R, D> o2, D d2) {
        return o2.a(this, d2);
    }

    @Override
    public /* synthetic */ b a(m m2, w w2, ba ba2, b.a a2, boolean bl2) {
        return this.b(m2, w2, ba2, a2, bl2);
    }

    public f a(List<av> list, ba ba2) {
        this.a(list, ba2, this.G().z());
        return this;
    }

    public f a(List<av> list, ba ba2, List<as> list2) {
        super.a(null, this.F(), list2, list, null, w.a, ba2);
        return this;
    }

    @Override
    protected /* synthetic */ o a(m m2, t t2, b.a a2, kotlin.reflect.jvm.internal.impl.e.f f2, h h2, an an2) {
        return this.b(m2, t2, a2, f2, h2, an2);
    }

    @Override
    public d a(au au2) {
        return (d)super.c(au2);
    }

    @Override
    public void a(Collection<? extends b> collection) {
        if (!b) {
            if (collection.isEmpty()) {
                return;
            }
            throw new AssertionError((Object)"Constructors cannot override anything");
        }
    }

    protected f b(m object, t object2, b.a a2, kotlin.reflect.jvm.internal.impl.e.f f2, h h2, an an2) {
        if (a2 != b.a.a && a2 != b.a.d) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Attempt at creating a constructor that is not a declaration: \ncopy from: ");
            ((StringBuilder)object2).append(this);
            ((StringBuilder)object2).append("\n");
            ((StringBuilder)object2).append("newOwner: ");
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append("\n");
            ((StringBuilder)object2).append("kind: ");
            ((StringBuilder)object2).append((Object)a2);
            throw new IllegalStateException(((StringBuilder)object2).toString());
        }
        if (!b && f2 != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Attempt to rename constructor: ");
            ((StringBuilder)object).append(this);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        return new f((e)object, this, h2, this.a, b.a.a, an2);
    }

    @Override
    public d b(m m2, w w2, ba ba2, b.a a2, boolean bl2) {
        return (d)super.c(m2, w2, ba2, a2, bl2);
    }

    @Override
    public /* synthetic */ l b(au au2) {
        return this.a(au2);
    }

    @Override
    public /* synthetic */ m b() {
        return this.G();
    }

    @Override
    public /* synthetic */ t c(m m2, w w2, ba ba2, b.a a2, boolean bl2) {
        return this.b(m2, w2, ba2, a2, bl2);
    }

    @Override
    public /* synthetic */ t c(au au2) {
        return this.a(au2);
    }

    @Override
    public /* synthetic */ n d(au au2) {
        return this.a(au2);
    }

    @Override
    public /* synthetic */ a h() {
        return this.o();
    }

    @Override
    public Collection<? extends t> k() {
        return Collections.emptySet();
    }

    @Override
    public /* synthetic */ b l() {
        return this.o();
    }

    @Override
    public /* synthetic */ m m_() {
        return this.o();
    }

    @Override
    public /* synthetic */ p n_() {
        return this.o();
    }

    @Override
    public d o() {
        return (d)super.s();
    }

    @Override
    public /* synthetic */ i q() {
        return this.G();
    }

    @Override
    public boolean r() {
        return this.a;
    }

    @Override
    public /* synthetic */ t s() {
        return this.o();
    }
}

