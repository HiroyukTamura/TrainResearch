/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.c.a;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.c;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.l.i;

public abstract class b
extends c
implements an {
    private int a = 0;

    public b(kotlin.reflect.jvm.internal.impl.i.i i2) {
        super(i2);
    }

    private static boolean a(e m2, e m3) {
        if (!m2.h_().equals(m3.h_())) {
            return false;
        }
        m m4 = m2.b();
        m2 = m3.b();
        for (m3 = m4; m3 != null && m2 != null; m3 = m3.b(), m2 = m2.b()) {
            if (m3 instanceof y) {
                return m2 instanceof y;
            }
            if (m2 instanceof y) {
                return false;
            }
            if (m3 instanceof ab) {
                return m2 instanceof ab && ((ab)m3).f().equals(((ab)m2).f());
            }
            if (m2 instanceof ab) {
                return false;
            }
            if (m3.h_().equals(m2.h_())) continue;
            return false;
        }
        return true;
    }

    private static boolean a(h h2) {
        return !p.a(h2) && !kotlin.reflect.jvm.internal.impl.h.c.b(h2);
    }

    @Override
    protected Collection<w> a(boolean bl2) {
        m m2 = this.j_().b();
        if (!(m2 instanceof e)) {
            return Collections.emptyList();
        }
        i i2 = new i();
        m2 = (e)m2;
        i2.add(m2.i_());
        m2 = m2.i();
        if (bl2 && m2 != null) {
            i2.add(m2.i_());
        }
        return i2;
    }

    @Override
    public /* synthetic */ h d() {
        return this.j_();
    }

    @Override
    public KotlinBuiltIns e() {
        return a.d(this.j_());
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof an)) {
            return false;
        }
        if (object.hashCode() != this.hashCode()) {
            return false;
        }
        Object object2 = (an)object;
        if (object2.b().size() != this.b().size()) {
            return false;
        }
        object = this.j_();
        object2 = object2.d();
        if (b.a((h)object)) {
            if (object2 != null && !b.a((h)object2)) {
                return false;
            }
            if (object2 instanceof e) {
                return b.a((e)object, (e)object2);
            }
        }
        return false;
    }

    @Override
    protected w h() {
        if (KotlinBuiltIns.isSpecialClassWithNoSupertypes(this.j_())) {
            return null;
        }
        return this.e().getAnyType();
    }

    public final int hashCode() {
        int n2 = this.a;
        if (n2 != 0) {
            return n2;
        }
        e e2 = this.j_();
        n2 = b.a(e2) ? kotlin.reflect.jvm.internal.impl.h.c.d(e2).hashCode() : System.identityHashCode(this);
        this.a = n2;
        return n2;
    }

    public abstract e j_();
}

