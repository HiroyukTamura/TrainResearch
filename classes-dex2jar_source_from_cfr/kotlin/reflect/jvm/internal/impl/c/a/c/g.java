/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c;

import java.util.Collection;
import java.util.List;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.ac;
import kotlin.reflect.jvm.internal.impl.c.a.c.b;
import kotlin.reflect.jvm.internal.impl.c.a.c.d;
import kotlin.reflect.jvm.internal.impl.c.a.c.h;
import kotlin.reflect.jvm.internal.impl.c.a.c.m;
import kotlin.reflect.jvm.internal.impl.c.a.e.t;
import kotlin.reflect.jvm.internal.impl.c.a.i;
import kotlin.reflect.jvm.internal.impl.e.f;

public final class g
implements ac {
    private final h a;
    private final kotlin.reflect.jvm.internal.impl.i.a<kotlin.reflect.jvm.internal.impl.e.b, kotlin.reflect.jvm.internal.impl.c.a.c.a.h> b;

    public g(b b2) {
        j.b(b2, "components");
        this.a = new h(b2, m.a.a, kotlin.h.a(null));
        this.b = this.a.c().b();
    }

    private final kotlin.reflect.jvm.internal.impl.c.a.c.a.h b(kotlin.reflect.jvm.internal.impl.e.b b2) {
        final t t2 = this.a.e().b().a(b2);
        if (t2 != null) {
            return this.b.a(b2, new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.c.a.c.a.h>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final kotlin.reflect.jvm.internal.impl.c.a.c.a.h b() {
                    h h2 = this.a;
                    t t22 = t2;
                    j.a((Object)t22, "jPackage");
                    return new kotlin.reflect.jvm.internal.impl.c.a.c.a.h(h2, t22);
                }
            });
        }
        return null;
    }

    public /* synthetic */ Collection a(kotlin.reflect.jvm.internal.impl.e.b b2, kotlin.e.a.b b3) {
        return this.b(b2, b3);
    }

    public List<kotlin.reflect.jvm.internal.impl.c.a.c.a.h> a(kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "fqName");
        return kotlin.a.m.b(this.b(b2));
    }

    public List<kotlin.reflect.jvm.internal.impl.e.b> b(kotlin.reflect.jvm.internal.impl.e.b list, kotlin.e.a.b<? super f, Boolean> b2) {
        j.b(list, "fqName");
        j.b(b2, "nameFilter");
        list = this.b((kotlin.reflect.jvm.internal.impl.e.b)((Object)list));
        list = list != null ? ((kotlin.reflect.jvm.internal.impl.c.a.c.a.h)((Object)list)).g() : null;
        if (list != null) {
            return list;
        }
        return kotlin.a.m.a();
    }

}

