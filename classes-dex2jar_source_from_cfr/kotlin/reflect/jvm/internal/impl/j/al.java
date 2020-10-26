/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.j.aq;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class al
extends aq {
    private final w a;

    public al(w w2) {
        j.b(w2, "_type");
        this.a = w2;
    }

    @Override
    public boolean a() {
        return true;
    }

    @Override
    public ba b() {
        return ba.c;
    }

    @Override
    public w c() {
        return this.a;
    }
}

