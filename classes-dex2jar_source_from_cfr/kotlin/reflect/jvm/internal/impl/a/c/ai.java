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
import kotlin.reflect.jvm.internal.impl.a.ax;
import kotlin.reflect.jvm.internal.impl.a.c.k;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.p;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.w;

public abstract class ai
extends k
implements ax {
    static final /* synthetic */ boolean c;
    protected w b;

    static {
        c = ai.class.desiredAssertionStatus() ^ true;
    }

    public ai(m m2, h h2, f f2, w w2, an an2) {
        super(m2, h2, f2, an2);
        this.b = w2;
    }

    public ax F() {
        return (ax)super.n_();
    }

    public void a(w w2) {
        if (!c && this.b != null) {
            throw new AssertionError();
        }
        this.b = w2;
    }

    @Override
    public al d() {
        return null;
    }

    @Override
    public al e() {
        return null;
    }

    @Override
    public List<as> f() {
        return Collections.emptyList();
    }

    @Override
    public w g() {
        return this.r();
    }

    @Override
    public /* synthetic */ a h() {
        return this.F();
    }

    @Override
    public List<av> i() {
        return Collections.emptyList();
    }

    @Override
    public boolean j() {
        return false;
    }

    @Override
    public Collection<? extends a> k() {
        return Collections.emptySet();
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
    public w r() {
        return this.b;
    }

    @Override
    public boolean z() {
        return false;
    }
}

