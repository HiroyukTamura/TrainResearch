/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.f;
import kotlin.reflect.jvm.internal.impl.a.c.g;
import kotlin.reflect.jvm.internal.impl.a.c.j;
import kotlin.reflect.jvm.internal.impl.a.d;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.h.e.h;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;

public class v
extends g {
    static final /* synthetic */ boolean c;
    private final kotlin.reflect.jvm.internal.impl.a.f d;
    private final boolean e;
    private w f;
    private ba g;
    private kotlin.reflect.jvm.internal.impl.j.an h;
    private List<as> i;
    private final Collection<kotlin.reflect.jvm.internal.impl.j.w> j = new ArrayList<kotlin.reflect.jvm.internal.impl.j.w>();
    private final i k;

    static {
        c = v.class.desiredAssertionStatus() ^ true;
    }

    public v(m m2, kotlin.reflect.jvm.internal.impl.a.f f2, boolean bl2, boolean bl3, kotlin.reflect.jvm.internal.impl.e.f f3, an an2, i i2) {
        super(i2, m2, f3, an2, bl3);
        this.k = i2;
        if (!c && f2 == kotlin.reflect.jvm.internal.impl.a.f.f) {
            throw new AssertionError((Object)"Fix isCompanionObject()");
        }
        this.d = f2;
        this.e = bl2;
    }

    public Set<d> a() {
        return Collections.emptySet();
    }

    public void a(List<as> object) {
        if (this.i == null) {
            this.i = new ArrayList<as>((Collection<as>)object);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Type parameters are already set for ");
        ((StringBuilder)object).append(this.h_());
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public void a(ba ba2) {
        this.g = ba2;
    }

    public void a(w object) {
        if (!c && object == w.b) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Implement getSealedSubclasses() for this class: ");
            ((StringBuilder)object).append(this.getClass());
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        this.f = object;
    }

    public void c() {
        if (!c && this.h != null) {
            throw new AssertionError(this.h);
        }
        this.h = new kotlin.reflect.jvm.internal.impl.j.e(this, this.i, this.j, this.k);
        Iterator<d> iterator = this.a().iterator();
        while (iterator.hasNext()) {
            ((f)iterator.next()).a(this.i_());
        }
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.j.an e() {
        return this.h;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h f_() {
        return h.c.a;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h g() {
        return h.c.a;
    }

    @Override
    public e i() {
        return null;
    }

    public /* synthetic */ Collection k() {
        return this.a();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.f l() {
        return this.d;
    }

    @Override
    public w m() {
        return this.f;
    }

    @Override
    public d o() {
        return null;
    }

    @Override
    public ba p() {
        return this.g;
    }

    @Override
    public boolean q() {
        return false;
    }

    @Override
    public boolean r() {
        return this.e;
    }

    @Override
    public boolean s() {
        return false;
    }

    @Override
    public boolean t() {
        return false;
    }

    public String toString() {
        return j.a(this);
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
    public h x() {
        return h.a.a();
    }

    @Override
    public List<as> z() {
        return this.i;
    }
}

