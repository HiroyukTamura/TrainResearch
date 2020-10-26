/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c;

import kotlin.e.b.j;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.g;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.c.a.c.b;
import kotlin.reflect.jvm.internal.impl.c.a.c.b.c;
import kotlin.reflect.jvm.internal.impl.c.a.c.d;
import kotlin.reflect.jvm.internal.impl.c.a.c.m;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.l;

public final class h {
    static final /* synthetic */ l[] a;
    private final g b;
    private final c c;
    private final b d;
    private final m e;
    private final g<d> f;

    static {
        a = new l[]{v.a(new t(v.a(h.class), "defaultTypeQualifiers", "getDefaultTypeQualifiers()Lorg/jetbrains/kotlin/load/java/lazy/JavaTypeQualifiersByElementType;"))};
    }

    public h(b b2, m m2, g<d> g2) {
        j.b(b2, "components");
        j.b(m2, "typeParameterResolver");
        j.b(g2, "delegateForDefaultTypeQualifiers");
        this.d = b2;
        this.e = m2;
        this.b = this.f = g2;
        this.c = new c(this, this.e);
    }

    public final d a() {
        g g2 = this.b;
        l l2 = a[0];
        return (d)g2.a();
    }

    public final c b() {
        return this.c;
    }

    public final i c() {
        return this.d.a();
    }

    public final y d() {
        return this.d.n();
    }

    public final b e() {
        return this.d;
    }

    public final m f() {
        return this.e;
    }

    public final g<d> g() {
        return this.f;
    }
}

