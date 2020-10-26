/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.w;

final class a
implements c {
    public static final a a = new a();

    private a() {
    }

    private final Void e() {
        throw (Throwable)new IllegalStateException("No methods should be called on this descriptor. Only its presence matters".toString());
    }

    @Override
    public w a() {
        this.e();
        throw null;
    }

    @Override
    public b b() {
        return c.a.a(this);
    }

    @Override
    public Map<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> c() {
        this.e();
        throw null;
    }

    @Override
    public an d() {
        this.e();
        throw null;
    }

    public String toString() {
        return "[EnhancedType]";
    }
}

