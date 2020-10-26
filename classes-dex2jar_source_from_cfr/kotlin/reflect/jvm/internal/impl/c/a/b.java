/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.a.af;
import kotlin.a.al;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.c.a.a;
import kotlin.reflect.jvm.internal.impl.c.a.c.k;
import kotlin.reflect.jvm.internal.impl.c.a.f.g;
import kotlin.reflect.jvm.internal.impl.c.a.f.h;
import kotlin.reflect.jvm.internal.impl.c.a.p;
import kotlin.s;

public final class b {
    private static final kotlin.reflect.jvm.internal.impl.e.b a = new kotlin.reflect.jvm.internal.impl.e.b("javax.annotation.meta.TypeQualifierNickname");
    private static final kotlin.reflect.jvm.internal.impl.e.b b = new kotlin.reflect.jvm.internal.impl.e.b("javax.annotation.meta.TypeQualifier");
    private static final kotlin.reflect.jvm.internal.impl.e.b c = new kotlin.reflect.jvm.internal.impl.e.b("javax.annotation.meta.TypeQualifierDefault");
    private static final kotlin.reflect.jvm.internal.impl.e.b d = new kotlin.reflect.jvm.internal.impl.e.b("kotlin.annotations.jvm.UnderMigration");
    private static final Map<kotlin.reflect.jvm.internal.impl.e.b, k> e = af.a(s.a(new kotlin.reflect.jvm.internal.impl.e.b("javax.annotation.ParametersAreNullableByDefault"), new k(new h(g.a, false, 2, null), (Collection<? extends a.a>)kotlin.a.m.a(a.a.b))), s.a(new kotlin.reflect.jvm.internal.impl.e.b("javax.annotation.ParametersAreNonnullByDefault"), new k(new h(g.b, false, 2, null), (Collection<? extends a.a>)kotlin.a.m.a(a.a.b))));
    private static final Set<kotlin.reflect.jvm.internal.impl.e.b> f = al.a(p.b(), p.c());

    public static final /* synthetic */ kotlin.reflect.jvm.internal.impl.e.b a() {
        return a;
    }

    public static final /* synthetic */ boolean a(e e2) {
        return b.b(e2);
    }

    public static final /* synthetic */ Map b() {
        return e;
    }

    private static final boolean b(e e2) {
        return f.contains(kotlin.reflect.jvm.internal.impl.h.c.a.b((m)e2)) || e2.x().b(b);
        {
        }
    }

    public static final /* synthetic */ kotlin.reflect.jvm.internal.impl.e.b c() {
        return c;
    }

    public static final /* synthetic */ kotlin.reflect.jvm.internal.impl.e.b d() {
        return d;
    }
}

