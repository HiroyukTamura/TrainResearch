/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.af;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.ab;
import kotlin.reflect.jvm.internal.impl.a.c.j;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.n;
import kotlin.reflect.jvm.internal.impl.a.o;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.w;

public abstract class c
extends j
implements al {
    private static final f a = f.c("<this>");

    public c() {
        super(h.a.a(), a);
    }

    @Override
    public <R, D> R a(o<R, D> o2, D d2) {
        return o2.a(this, d2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public al a(au object) {
        kotlin.reflect.jvm.internal.impl.j.ba ba2;
        w w2;
        if (((au)object).a()) {
            return this;
        }
        if (this.b() instanceof e) {
            w2 = this.r();
            ba2 = kotlin.reflect.jvm.internal.impl.j.ba.c;
        } else {
            w2 = this.r();
            ba2 = kotlin.reflect.jvm.internal.impl.j.ba.a;
        }
        object = ((au)object).b(w2, ba2);
        if (object == null) {
            return null;
        }
        if (object == this.r()) {
            return this;
        }
        return new ab(this.b(), new kotlin.reflect.jvm.internal.impl.h.e.a.h((w)object));
    }

    public af c() {
        return this;
    }

    @Override
    public al d() {
        return null;
    }

    @Override
    public /* synthetic */ n d(au au2) {
        return this.a(au2);
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
        return this.c();
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
        return this.c();
    }

    @Override
    public ba p() {
        return az.f;
    }

    @Override
    public w r() {
        return this.a().a();
    }

    @Override
    public an y() {
        return an.a;
    }
}

