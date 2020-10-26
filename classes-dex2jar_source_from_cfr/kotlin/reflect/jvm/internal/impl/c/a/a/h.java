/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.a;

import java.util.Map;
import kotlin.a.af;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.a.b;
import kotlin.reflect.jvm.internal.impl.c.a.a.c;
import kotlin.reflect.jvm.internal.impl.c.a.a.d;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.l;
import kotlin.s;

public final class h
extends b {
    static final /* synthetic */ l[] b;
    private final kotlin.reflect.jvm.internal.impl.i.f c;

    static {
        b = new l[]{v.a(new t(v.a(h.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public h(kotlin.reflect.jvm.internal.impl.c.a.e.a a2, kotlin.reflect.jvm.internal.impl.c.a.c.h h2) {
        j.b(a2, "annotation");
        j.b(h2, "c");
        kotlin.reflect.jvm.internal.impl.e.b b2 = KotlinBuiltIns.FQ_NAMES.retention;
        j.a((Object)b2, "KotlinBuiltIns.FQ_NAMES.retention");
        super(h2, a2, b2);
        this.c = h2.c().a(new kotlin.e.a.a<Map<f, ? extends kotlin.reflect.jvm.internal.impl.h.b.f<?>>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Map<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> b() {
                Object object = d.a.a(this.f());
                object = object != null ? af.a(s.a(c.a.c(), object)) : null;
                if (object != null) {
                    return object;
                }
                return af.a();
            }
        });
    }

    @Override
    public Map<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> c() {
        return (Map)kotlin.reflect.jvm.internal.impl.i.h.a(this.c, (Object)this, b[0]);
    }

}

