/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import java.util.Collection;
import kotlin.a.m;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.c.b.j;
import kotlin.reflect.jvm.internal.impl.c.b.v;

public final class w
implements v<j> {
    public static final w a = new w();

    private w() {
    }

    @Override
    public /* synthetic */ Object a(e e2) {
        return this.c(e2);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.j.w a(Collection<? extends kotlin.reflect.jvm.internal.impl.j.w> collection) {
        kotlin.e.b.j.b(collection, "types");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("There should be no intersection type in existing descriptors, but found: ");
        stringBuilder.append(m.a(collection, null, null, null, 0, null, null, 63, null));
        throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
    }

    @Override
    public void a(kotlin.reflect.jvm.internal.impl.j.w w2, e e2) {
        kotlin.e.b.j.b(w2, "kotlinType");
        kotlin.e.b.j.b(e2, "descriptor");
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public String b(e e2) {
        kotlin.e.b.j.b(e2, "classDescriptor");
        return null;
    }

    public Void c(e e2) {
        kotlin.e.b.j.b(e2, "classDescriptor");
        return null;
    }
}

