/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.reflect.jvm.internal.impl.j.aq;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;

public class ar
extends aq {
    private final ba a;
    private final w b;

    public ar(ba ba2, w w2) {
        this.a = ba2;
        this.b = w2;
    }

    public ar(w w2) {
        this(ba.a, w2);
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public ba b() {
        return this.a;
    }

    @Override
    public w c() {
        return this.b;
    }
}

