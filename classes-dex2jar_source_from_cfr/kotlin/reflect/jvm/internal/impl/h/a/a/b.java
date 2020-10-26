/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.a.a;

import java.util.Collection;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.j.a.f;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.y;

public final class b
implements an {
    private f a;
    private final ap b;

    public b(ap object) {
        j.b(object, "typeProjection");
        this.b = object;
        boolean bl2 = this.b.b() != ba.a;
        if (y.a) {
            if (bl2) {
                return;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Only nontrivial projections can be captured, not: ");
            ((StringBuilder)object).append(this.b);
            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
        }
    }

    public final f a() {
        return this.a;
    }

    public final void a(f f2) {
        this.a = f2;
    }

    @Override
    public List<as> b() {
        return m.a();
    }

    @Override
    public /* synthetic */ h d() {
        return (h)((Object)this.g());
    }

    @Override
    public KotlinBuiltIns e() {
        KotlinBuiltIns kotlinBuiltIns = this.b.c().g().e();
        j.a((Object)kotlinBuiltIns, "typeProjection.type.constructor.builtIns");
        return kotlinBuiltIns;
    }

    @Override
    public boolean f() {
        return false;
    }

    public Void g() {
        return null;
    }

    public final ap h() {
        return this.b;
    }

    @Override
    public Collection<w> k_() {
        w w2 = this.b.b() == ba.c ? this.b.c() : (w)this.e().getNullableAnyType();
        return m.a(w2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CapturedTypeConstructor(");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

