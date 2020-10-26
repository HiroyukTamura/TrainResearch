/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h;

import java.util.Collection;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.b;

public abstract class i {
    public abstract void a(b var1);

    public void a(b b2, Collection<? extends b> collection) {
        j.b(b2, "member");
        j.b(collection, "overridden");
        b2.a(collection);
    }

    public abstract void b(b var1, b var2);

    public abstract void c(b var1, b var2);
}

