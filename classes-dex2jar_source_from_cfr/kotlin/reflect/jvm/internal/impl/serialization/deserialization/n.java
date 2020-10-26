/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Set;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.c.w;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.h;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.g;

public abstract class n
extends w {
    private final i a;

    public n(b b2, i i2, y y2) {
        j.b(b2, "fqName");
        j.b(i2, "storageManager");
        j.b(y2, "module");
        super(y2, b2);
        this.a = i2;
    }

    public boolean a(f f2) {
        j.b(f2, "name");
        kotlin.reflect.jvm.internal.impl.h.e.h h2 = this.a();
        return h2 instanceof h && ((h)h2).e().contains(f2);
    }

    public abstract g c();
}

