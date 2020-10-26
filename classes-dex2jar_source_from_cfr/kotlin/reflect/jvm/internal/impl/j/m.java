/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.g.c;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.c.a;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class m
extends q {
    private final h a;

    public m(KotlinBuiltIns object, h h2) {
        j.b(object, "builtIns");
        j.b(h2, "annotations");
        ad ad2 = ((KotlinBuiltIns)object).getNothingType();
        j.a((Object)ad2, "builtIns.nothingType");
        object = ((KotlinBuiltIns)object).getNullableAnyType();
        j.a(object, "builtIns.nullableAnyType");
        super(ad2, (ad)object);
        this.a = h2;
    }

    @Override
    public String a(c c2, kotlin.reflect.jvm.internal.impl.g.h h2) {
        j.b(c2, "renderer");
        j.b(h2, "options");
        return "dynamic";
    }

    public m a(h h2) {
        j.b(h2, "newAnnotations");
        return new m(a.a((w)this.p_()), h2);
    }

    public m a(boolean bl2) {
        return this;
    }

    @Override
    public /* synthetic */ az b(h h2) {
        return this.a(h2);
    }

    @Override
    public /* synthetic */ az b(boolean bl2) {
        return this.a(bl2);
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public ad p_() {
        return this.h();
    }

    @Override
    public h x() {
        return this.a;
    }
}

