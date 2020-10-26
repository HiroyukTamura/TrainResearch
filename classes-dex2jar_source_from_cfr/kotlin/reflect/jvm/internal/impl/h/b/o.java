/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.b;

import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.h.b.f;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class o
extends f<w> {
    private final w a;

    public o(w w2) {
        j.b(w2, "type");
        super(w2);
        this.a = w2;
    }

    @Override
    public /* synthetic */ Object a() {
        return this.b();
    }

    @Override
    public w a(y y2) {
        j.b(y2, "module");
        return this.a;
    }

    public w b() {
        w w2 = m.j(this.a.a()).c();
        j.a((Object)w2, "type.arguments.single().type");
        return w2;
    }
}

