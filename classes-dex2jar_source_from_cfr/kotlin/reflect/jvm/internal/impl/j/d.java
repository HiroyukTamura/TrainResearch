/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.j;

final class d
extends j {
    private final h a;

    public d(ad ad2, h h2) {
        kotlin.e.b.j.b(ad2, "delegate");
        kotlin.e.b.j.b(h2, "annotations");
        super(ad2);
        this.a = h2;
    }

    @Override
    public h x() {
        return this.a;
    }
}

