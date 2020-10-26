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
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.a.b;
import kotlin.reflect.jvm.internal.impl.c.a.a.c;
import kotlin.reflect.jvm.internal.impl.c.a.c.h;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.l;
import kotlin.s;

public final class e
extends b {
    static final /* synthetic */ l[] b;
    private final kotlin.reflect.jvm.internal.impl.i.f c;

    static {
        b = new l[]{v.a(new t(v.a(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public e(kotlin.reflect.jvm.internal.impl.c.a.e.a a2, h h2) {
        j.b(h2, "c");
        kotlin.reflect.jvm.internal.impl.e.b b2 = KotlinBuiltIns.FQ_NAMES.deprecated;
        j.a((Object)b2, "KotlinBuiltIns.FQ_NAMES.deprecated");
        super(h2, a2, b2);
        this.c = h2.c().a(a.a);
    }

    @Override
    public Map<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> c() {
        return (Map)kotlin.reflect.jvm.internal.impl.i.h.a(this.c, (Object)this, b[0]);
    }

}

