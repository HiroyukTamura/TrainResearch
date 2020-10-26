/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.a;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.a.e;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.w;

public class d
implements c {
    private final w a;
    private final Map<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> b;
    private final an c;

    public d(w w2, Map<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> map, an an2) {
        this.a = w2;
        this.b = map;
        this.c = an2;
    }

    @Override
    public w a() {
        return this.a;
    }

    @Override
    public b b() {
        return c.a.a(this);
    }

    @Override
    public Map<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> c() {
        return this.b;
    }

    @Override
    public an d() {
        return this.c;
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.g.c.f.a(this, null);
    }
}

