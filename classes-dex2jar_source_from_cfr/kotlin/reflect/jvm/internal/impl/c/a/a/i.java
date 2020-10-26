/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.a;

import java.util.List;
import java.util.Map;
import kotlin.a.af;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.a.b;
import kotlin.reflect.jvm.internal.impl.c.a.a.c;
import kotlin.reflect.jvm.internal.impl.c.a.a.d;
import kotlin.reflect.jvm.internal.impl.c.a.c.h;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.l;
import kotlin.s;

public final class i
extends b {
    static final /* synthetic */ l[] b;
    private final kotlin.reflect.jvm.internal.impl.i.f c;

    static {
        b = new l[]{v.a(new t(v.a(i.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public i(kotlin.reflect.jvm.internal.impl.c.a.e.a a2, h h2) {
        j.b(a2, "annotation");
        j.b(h2, "c");
        kotlin.reflect.jvm.internal.impl.e.b b2 = KotlinBuiltIns.FQ_NAMES.target;
        j.a((Object)b2, "KotlinBuiltIns.FQ_NAMES.target");
        super(h2, a2, b2);
        this.c = h2.c().a(new kotlin.e.a.a<Map<f, ? extends kotlin.reflect.jvm.internal.impl.h.b.f<?>>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            public final Map<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> b() {
                block3 : {
                    var2_1 = this.f();
                    var1_2 = var2_1 instanceof kotlin.reflect.jvm.internal.impl.c.a.e.e;
                    var4_3 = null;
                    if (!var1_2) break block3;
                    var2_1 = d.a;
                    var3_4 = ((kotlin.reflect.jvm.internal.impl.c.a.e.e)this.f()).b();
                    ** GOTO lbl12
                }
                if (var2_1 instanceof kotlin.reflect.jvm.internal.impl.c.a.e.m) {
                    var2_1 = d.a;
                    var3_4 = m.a(this.f());
lbl12: // 2 sources:
                    var2_1 = var2_1.a(var3_4);
                } else {
                    var2_1 = null;
                }
                var3_4 = var4_3;
                if (var2_1 != null) {
                    var3_4 = af.a(s.a(c.a.b(), var2_1));
                }
                if (var3_4 == null) return af.a();
                return var3_4;
            }
        });
    }

    @Override
    public Map<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> c() {
        return (Map)kotlin.reflect.jvm.internal.impl.i.h.a(this.c, (Object)this, b[0]);
    }

}

