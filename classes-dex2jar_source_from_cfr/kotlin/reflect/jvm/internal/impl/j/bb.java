/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.List;
import kotlin.e.b.g;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.t;

public abstract class bb
extends w {
    public bb() {
        super(null);
    }

    @Override
    public List<ap> a() {
        return this.d().a();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h b() {
        return this.d().b();
    }

    @Override
    public boolean c() {
        return this.d().c();
    }

    protected abstract w d();

    public boolean e() {
        return true;
    }

    @Override
    public an g() {
        return this.d().g();
    }

    @Override
    public final az l() {
        w w2 = this.d();
        while (w2 instanceof bb) {
            w2 = ((bb)w2).d();
        }
        if (w2 != null) {
            return (az)w2;
        }
        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
    }

    public String toString() {
        if (this.e()) {
            return this.d().toString();
        }
        return "<Not computed yet>";
    }

    @Override
    public h x() {
        return this.d().x();
    }
}

