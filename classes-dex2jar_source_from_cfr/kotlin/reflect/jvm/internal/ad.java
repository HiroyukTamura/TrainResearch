/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import kotlin.e.b.h;
import kotlin.e.b.k;
import kotlin.e.b.w;
import kotlin.reflect.e;
import kotlin.reflect.f;
import kotlin.reflect.jvm.d;
import kotlin.reflect.jvm.internal.ae;
import kotlin.reflect.jvm.internal.ai;
import kotlin.reflect.jvm.internal.c;
import kotlin.reflect.jvm.internal.i;
import kotlin.reflect.jvm.internal.l;
import kotlin.reflect.jvm.internal.m;
import kotlin.reflect.jvm.internal.o;
import kotlin.reflect.jvm.internal.q;
import kotlin.reflect.jvm.internal.s;
import kotlin.reflect.jvm.internal.t;
import kotlin.reflect.n;

public class ad
extends w {
    private static l a(kotlin.e.b.c object) {
        if ((object = ((kotlin.e.b.c)object).f()) instanceof l) {
            return (l)object;
        }
        return c.a;
    }

    @Override
    public String a(h h2) {
        m m2 = d.a(h2);
        if (m2 != null && (m2 = ai.a(m2)) != null) {
            return ae.a.b(m2.b());
        }
        return super.a(h2);
    }

    @Override
    public String a(k k2) {
        return this.a((h)k2);
    }

    @Override
    public kotlin.reflect.c a(Class class_) {
        return i.a(class_);
    }

    @Override
    public e a(Class class_, String string2) {
        return new q(class_, string2);
    }

    @Override
    public f a(kotlin.e.b.i i2) {
        return new m(ad.a(i2), i2.g(), i2.h(), i2.c());
    }

    @Override
    public kotlin.reflect.i a(kotlin.e.b.m m2) {
        return new o(ad.a(m2), m2.g(), m2.h(), m2.c());
    }

    @Override
    public kotlin.reflect.m a(kotlin.e.b.q q2) {
        return new s(ad.a(q2), q2.g(), q2.h(), q2.c());
    }

    @Override
    public n a(kotlin.e.b.s s2) {
        return new t(ad.a(s2), s2.g(), s2.h(), s2.c());
    }
}

