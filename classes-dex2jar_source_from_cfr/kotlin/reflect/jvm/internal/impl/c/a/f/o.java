/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.c.a.f.k;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.w;

final class o
extends k {
    private final ad a;

    public o(ad ad2, int n2, boolean bl2) {
        j.b(ad2, "type");
        super(ad2, n2, bl2);
        this.a = ad2;
    }

    @Override
    public /* synthetic */ w b() {
        return this.e();
    }

    public ad e() {
        return this.a;
    }
}

