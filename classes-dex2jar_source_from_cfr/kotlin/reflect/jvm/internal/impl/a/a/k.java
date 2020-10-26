/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.a;

import java.util.Map;
import kotlin.e.b.j;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.g;
import kotlin.h;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.l;

public final class k
implements c {
    static final /* synthetic */ l[] a;
    private final g b;
    private final KotlinBuiltIns c;
    private final b d;
    private final Map<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> e;

    static {
        a = new l[]{v.a(new t(v.a(k.class), "type", "getType()Lorg/jetbrains/kotlin/types/KotlinType;"))};
    }

    public k(KotlinBuiltIns kotlinBuiltIns, b b2, Map<f, ? extends kotlin.reflect.jvm.internal.impl.h.b.f<?>> map) {
        j.b(kotlinBuiltIns, "builtIns");
        j.b(b2, "fqName");
        j.b(map, "allValueArguments");
        this.c = kotlinBuiltIns;
        this.d = b2;
        this.e = map;
        this.b = h.a(kotlin.l.b, (kotlin.e.a.a)new kotlin.e.a.a<ad>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final ad b() {
                kotlin.reflect.jvm.internal.impl.a.e e2 = this.c.getBuiltInClassByFqName(this.b());
                j.a((Object)e2, "builtIns.getBuiltInClassByFqName(fqName)");
                return e2.i_();
            }
        });
    }

    @Override
    public w a() {
        g g2 = this.b;
        l l2 = a[0];
        return (w)g2.a();
    }

    @Override
    public b b() {
        return this.d;
    }

    @Override
    public Map<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> c() {
        return this.e;
    }

    @Override
    public an d() {
        an an2 = an.a;
        j.a((Object)an2, "SourceElement.NO_SOURCE");
        return an2;
    }

}

