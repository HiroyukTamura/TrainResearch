/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.a;

import java.util.List;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.a.a;
import kotlin.reflect.jvm.internal.impl.j.a.f;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.p;

public final class e
extends ad {
    private final a a;
    private final f b;
    private final az c;
    private final h d;
    private final boolean e;

    public e(a a2, f f2, az az2, h h2, boolean bl2) {
        j.b((Object)a2, "captureStatus");
        j.b(f2, "constructor");
        j.b(h2, "annotations");
        this.a = a2;
        this.b = f2;
        this.c = az2;
        this.d = h2;
        this.e = bl2;
    }

    public /* synthetic */ e(a a2, f f2, az az2, h h2, boolean bl2, int n2, g g2) {
        if ((n2 & 8) != 0) {
            h2 = h.a.a();
        }
        if ((n2 & 16) != 0) {
            bl2 = false;
        }
        this(a2, f2, az2, h2, bl2);
    }

    public e(a a2, az az2, ap ap2) {
        j.b((Object)a2, "captureStatus");
        j.b(ap2, "projection");
        this(a2, new f(ap2, null, 2, null), az2, null, false, 24, null);
    }

    @Override
    public List<ap> a() {
        return m.a();
    }

    public e a(h h2) {
        j.b(h2, "newAnnotations");
        return new e(this.a, this.d(), this.c, h2, this.c());
    }

    @Override
    public /* synthetic */ ad a(boolean bl2) {
        return this.c(bl2);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h b() {
        kotlin.reflect.jvm.internal.impl.h.e.h h2 = p.a("No member resolution should be done on captured type!", true);
        j.a((Object)h2, "ErrorUtils.createErrorSc\u2026on captured type!\", true)");
        return h2;
    }

    @Override
    public /* synthetic */ az b(h h2) {
        return this.a(h2);
    }

    @Override
    public /* synthetic */ az b(boolean bl2) {
        return this.c(bl2);
    }

    public e c(boolean bl2) {
        return new e(this.a, this.d(), this.c, this.x(), bl2);
    }

    @Override
    public /* synthetic */ ad c(h h2) {
        return this.a(h2);
    }

    @Override
    public boolean c() {
        return this.e;
    }

    public f d() {
        return this.b;
    }

    public final az e() {
        return this.c;
    }

    @Override
    public /* synthetic */ an g() {
        return this.d();
    }

    @Override
    public h x() {
        return this.d;
    }
}

