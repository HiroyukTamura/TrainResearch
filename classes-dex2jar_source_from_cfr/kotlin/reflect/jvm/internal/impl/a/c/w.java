/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.c.k;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.o;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.t;

public abstract class w
extends k
implements ab {
    private final b a;

    public w(y y2, b b2) {
        j.b(y2, "module");
        j.b(b2, "fqName");
        super(y2, h.a.a(), b2.f(), an.a);
        this.a = b2;
    }

    @Override
    public <R, D> R a(o<R, D> o2, D d2) {
        j.b(o2, "visitor");
        return o2.a(this, d2);
    }

    @Override
    public /* synthetic */ m b() {
        return this.e();
    }

    @Override
    public y e() {
        m m2 = super.b();
        if (m2 != null) {
            return (y)m2;
        }
        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
    }

    @Override
    public final b f() {
        return this.a;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package ");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }

    @Override
    public an y() {
        an an2 = an.a;
        j.a((Object)an2, "SourceElement.NO_SOURCE");
        return an2;
    }
}

