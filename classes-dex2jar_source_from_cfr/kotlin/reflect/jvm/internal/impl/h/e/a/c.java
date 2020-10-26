/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e.a;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.h.e.a.d;
import kotlin.reflect.jvm.internal.impl.h.e.a.g;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.w;

public class c
implements d,
g {
    private final c a;
    private final e b;
    private final e c;

    public c(e object, c c2) {
        j.b(object, "classDescriptor");
        this.c = object;
        object = c2 != null ? c2 : this;
        this.a = object;
        this.b = this.c;
    }

    @Override
    public /* synthetic */ w a() {
        return this.b();
    }

    public ad b() {
        return this.c.i_();
    }

    @Override
    public final e c() {
        return this.c;
    }

    public boolean equals(Object object) {
        e e2 = this.c;
        boolean bl2 = object instanceof c;
        Object var3_4 = null;
        if (!bl2) {
            object = null;
        }
        c c2 = (c)object;
        object = var3_4;
        if (c2 != null) {
            object = c2.c;
        }
        return j.a((Object)e2, object);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Class{");
        stringBuilder.append(this.b());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

