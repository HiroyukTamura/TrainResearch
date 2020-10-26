/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.i;
import kotlin.reflect.jvm.internal.impl.j.ap;

public final class ag {
    private final i a;
    private final List<ap> b;
    private final ag c;

    public ag(i i2, List<? extends ap> list, ag ag2) {
        j.b(i2, "classifierDescriptor");
        j.b(list, "arguments");
        this.a = i2;
        this.b = list;
        this.c = ag2;
    }

    public final i a() {
        return this.a;
    }

    public final List<ap> b() {
        return this.b;
    }

    public final ag c() {
        return this.c;
    }
}

