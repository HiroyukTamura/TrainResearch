/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.a.a;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.o;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.p;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.e.f;

public class ac
extends o
implements am {
    protected ac(m m2, am am2, h h2, f f2, b.a a2, an an2) {
        super(m2, am2, h2, f2, a2, an2);
    }

    public static ac a(m m2, h h2, f f2, b.a a2, an an2) {
        return new ac(m2, null, h2, f2, a2, an2);
    }

    @Override
    public t.a<? extends am> E() {
        return super.E();
    }

    @Override
    public /* synthetic */ b a(m m2, w w2, ba ba2, b.a a2, boolean bl2) {
        return this.b(m2, w2, ba2, a2, bl2);
    }

    public ac a(kotlin.reflect.jvm.internal.impl.j.w w2, al al2, List<? extends as> list, List<av> list2, kotlin.reflect.jvm.internal.impl.j.w w3, w w4, ba ba2, Map<? extends t.b<?>, ?> map) {
        super.a(w2, al2, list, list2, w3, w4, ba2);
        if (map != null && !map.isEmpty()) {
            this.c = new LinkedHashMap(map);
        }
        return this;
    }

    @Override
    protected o a(m m2, t t2, b.a a2, f f2, h h2, an an2) {
        block0 : {
            t2 = (am)t2;
            if (f2 != null) break block0;
            f2 = this.h_();
        }
        return new ac(m2, (am)t2, h2, f2, a2, an2);
    }

    public /* synthetic */ o a(kotlin.reflect.jvm.internal.impl.j.w w2, al al2, List list, List list2, kotlin.reflect.jvm.internal.impl.j.w w3, w w4, ba ba2) {
        return this.b(w2, al2, list, list2, w3, w4, ba2);
    }

    public am b(m m2, w w2, ba ba2, b.a a2, boolean bl2) {
        return (am)super.c(m2, w2, ba2, a2, bl2);
    }

    public ac b(kotlin.reflect.jvm.internal.impl.j.w w2, al al2, List<? extends as> list, List<av> list2, kotlin.reflect.jvm.internal.impl.j.w w3, w w4, ba ba2) {
        return this.a(w2, al2, list, list2, w3, w4, ba2, null);
    }

    @Override
    public /* synthetic */ t c(m m2, w w2, ba ba2, b.a a2, boolean bl2) {
        return this.b(m2, w2, ba2, a2, bl2);
    }

    @Override
    public /* synthetic */ a h() {
        return this.o();
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

    public am o() {
        return (am)super.s();
    }

    @Override
    public /* synthetic */ t s() {
        return this.o();
    }
}

