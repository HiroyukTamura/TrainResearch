/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.a;

import java.util.Collection;
import java.util.Map;
import kotlin.a.af;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.c.h;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.l;

public class b
implements c {
    static final /* synthetic */ l[] a;
    private final an b;
    private final kotlin.reflect.jvm.internal.impl.i.f c;
    private final kotlin.reflect.jvm.internal.impl.c.a.e.b d;
    private final kotlin.reflect.jvm.internal.impl.e.b e;

    static {
        a = new l[]{v.a(new t(v.a(b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    }

    public b(h object, kotlin.reflect.jvm.internal.impl.c.a.e.a a2, kotlin.reflect.jvm.internal.impl.e.b object2) {
        j.b(object, "c");
        j.b(object2, "fqName");
        this.e = object2;
        if (a2 != null && (object2 = ((h)object).e().i().a(a2)) != null) {
            object2 = (an)object2;
        } else {
            object2 = an.a;
            j.a(object2, "SourceElement.NO_SOURCE");
        }
        this.b = object2;
        this.c = ((h)object).c().a((kotlin.e.a.a)new kotlin.e.a.a<ad>((h)object){
            final /* synthetic */ h b;
            {
                this.b = h2;
                super(0);
            }

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final ad b() {
                kotlin.reflect.jvm.internal.impl.a.e e2 = this.b.d().a().getBuiltInClassByFqName(this.b());
                j.a((Object)e2, "c.module.builtIns.getBuiltInClassByFqName(fqName)");
                return e2.i_();
            }
        });
        object = a2 != null && (object = a2.a()) != null ? (kotlin.reflect.jvm.internal.impl.c.a.e.b)m.c((Iterable)object) : null;
        this.d = object;
    }

    @Override
    public /* synthetic */ w a() {
        return this.e();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.e.b b() {
        return this.e;
    }

    @Override
    public Map<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> c() {
        return af.a();
    }

    @Override
    public an d() {
        return this.b;
    }

    public ad e() {
        return (ad)kotlin.reflect.jvm.internal.impl.i.h.a(this.c, (Object)this, a[0]);
    }

    protected final kotlin.reflect.jvm.internal.impl.c.a.e.b f() {
        return this.d;
    }

}

