/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.i;

public final class a
extends i {
    private final ad a;
    private final ad b;

    public a(ad ad2, ad ad3) {
        j.b(ad2, "delegate");
        j.b(ad3, "abbreviation");
        this.a = ad2;
        this.b = ad3;
    }

    public a a(h h2) {
        j.b(h2, "newAnnotations");
        return new a(this.d().c(h2), this.b);
    }

    @Override
    public /* synthetic */ ad a(boolean bl2) {
        return this.c(bl2);
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
        return new a(this.d().a(bl2), this.b.a(bl2));
    }

    @Override
    public /* synthetic */ ad c(h h2) {
        return this.a(h2);
    }

    @Override
    protected ad d() {
        return this.a;
    }

    public final ad e() {
        return this.d();
    }

    public final ad f() {
        return this.b;
    }
}

