/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.List;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.g.c;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ak;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.w;

public abstract class q
extends az
implements ak {
    private final ad a;
    private final ad b;

    public q(ad ad2, ad ad3) {
        j.b(ad2, "lowerBound");
        j.b(ad3, "upperBound");
        super(null);
        this.a = ad2;
        this.b = ad3;
    }

    public abstract String a(c var1, kotlin.reflect.jvm.internal.impl.g.h var2);

    @Override
    public List<ap> a() {
        return this.p_().a();
    }

    @Override
    public boolean a(w w2) {
        j.b(w2, "type");
        return false;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h b() {
        return this.p_().b();
    }

    @Override
    public boolean c() {
        return this.p_().c();
    }

    @Override
    public w d() {
        return this.a;
    }

    @Override
    public w e() {
        return this.b;
    }

    public final ad f() {
        return this.a;
    }

    @Override
    public an g() {
        return this.p_().g();
    }

    public final ad h() {
        return this.b;
    }

    public abstract ad p_();

    public String toString() {
        return c.h.a(this);
    }

    @Override
    public h x() {
        return this.p_().x();
    }
}

