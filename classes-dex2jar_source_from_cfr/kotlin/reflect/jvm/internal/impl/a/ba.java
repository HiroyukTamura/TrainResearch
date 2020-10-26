/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.q;
import kotlin.reflect.jvm.internal.impl.h.e.a.e;

public abstract class ba {
    private final String a;
    private final boolean b;

    protected ba(String string2, boolean bl2) {
        j.b(string2, "name");
        this.a = string2;
        this.b = bl2;
    }

    protected Integer a(ba ba2) {
        j.b(ba2, "visibility");
        return az.a(this, ba2);
    }

    public String a() {
        return this.a;
    }

    public abstract boolean a(e var1, q var2, m var3);

    public ba b() {
        return this;
    }

    public final boolean c() {
        return this.b;
    }

    public final String toString() {
        return this.a();
    }
}

