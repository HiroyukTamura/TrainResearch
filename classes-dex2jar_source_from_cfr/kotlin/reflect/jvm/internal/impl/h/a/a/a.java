/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.a.a;

import java.util.List;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.h.a.a.b;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ak;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class a
extends ad
implements ak {
    private final ap a;
    private final b b;
    private final boolean c;
    private final h d;

    public a(ap ap2, b b2, boolean bl2, h h2) {
        j.b(ap2, "typeProjection");
        j.b(b2, "constructor");
        j.b(h2, "annotations");
        this.a = ap2;
        this.b = b2;
        this.c = bl2;
        this.d = h2;
    }

    public /* synthetic */ a(ap ap2, b b2, boolean bl2, h h2, int n2, g g2) {
        if ((n2 & 2) != 0) {
            b2 = new b(ap2);
        }
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        if ((n2 & 8) != 0) {
            h2 = h.a.a();
        }
        this(ap2, b2, bl2, h2);
    }

    private final w a(ba ba2, w w2) {
        if (this.a.b() == ba2) {
            w2 = this.a.c();
        }
        return w2;
    }

    @Override
    public List<ap> a() {
        return m.a();
    }

    public a a(h h2) {
        j.b(h2, "newAnnotations");
        return new a(this.a, this.f(), this.c(), h2);
    }

    @Override
    public /* synthetic */ ad a(boolean bl2) {
        return this.c(bl2);
    }

    @Override
    public boolean a(w w2) {
        j.b(w2, "type");
        return this.f() == w2.g();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h b() {
        kotlin.reflect.jvm.internal.impl.h.e.h h2 = p.a("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        j.a((Object)h2, "ErrorUtils.createErrorSc\u2026system resolution\", true)");
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

    public a c(boolean bl2) {
        if (bl2 == this.c()) {
            return this;
        }
        return new a(this.a, this.f(), bl2, this.x());
    }

    @Override
    public /* synthetic */ ad c(h h2) {
        return this.a(h2);
    }

    @Override
    public boolean c() {
        return this.c;
    }

    @Override
    public w d() {
        Object object = ba.c;
        ad ad2 = kotlin.reflect.jvm.internal.impl.j.c.a.a((w)this).getNullableAnyType();
        j.a((Object)ad2, "builtIns.nullableAnyType");
        object = this.a((ba)((Object)object), ad2);
        j.a(object, "representative(OUT_VARIA\u2026builtIns.nullableAnyType)");
        return object;
    }

    @Override
    public w e() {
        Object object = ba.b;
        ad ad2 = kotlin.reflect.jvm.internal.impl.j.c.a.a((w)this).getNothingType();
        j.a((Object)ad2, "builtIns.nothingType");
        object = this.a((ba)((Object)object), ad2);
        j.a(object, "representative(IN_VARIANCE, builtIns.nothingType)");
        return object;
    }

    public b f() {
        return this.b;
    }

    @Override
    public /* synthetic */ an g() {
        return this.f();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Captured(");
        stringBuilder.append(this.a);
        stringBuilder.append(')');
        String string2 = this.c() ? "?" : "";
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    @Override
    public h x() {
        return this.d;
    }
}

