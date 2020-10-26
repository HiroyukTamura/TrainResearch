/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;

public class h
extends as {
    private final as a;

    public h(as as2) {
        j.b(as2, "substitution");
        this.a = as2;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.a.h a(kotlin.reflect.jvm.internal.impl.a.a.h h2) {
        j.b(h2, "annotations");
        return this.a.a(h2);
    }

    @Override
    public w a(w w2, ba ba2) {
        j.b(w2, "topLevelType");
        j.b((Object)ba2, "position");
        return this.a.a(w2, ba2);
    }

    @Override
    public boolean a() {
        return this.a.a();
    }

    @Override
    public ap b(w w2) {
        j.b(w2, "key");
        return this.a.b(w2);
    }

    @Override
    public boolean b() {
        return this.a.b();
    }

    @Override
    public boolean c() {
        return this.a.c();
    }
}

