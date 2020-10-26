/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.g;
import kotlin.h;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.j.ai;
import kotlin.reflect.jvm.internal.impl.j.aq;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.l;

public final class ah
extends aq {
    static final /* synthetic */ l[] a;
    private final g b;
    private final as c;

    static {
        a = new l[]{v.a(new t(v.a(ah.class), "_type", "get_type()Lorg/jetbrains/kotlin/types/KotlinType;"))};
    }

    public ah(as as2) {
        j.b(as2, "typeParameter");
        this.c = as2;
        this.b = h.a(kotlin.l.b, (kotlin.e.a.a)new kotlin.e.a.a<w>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final w b() {
                return ai.a(this.c);
            }
        });
    }

    private final w d() {
        g g2 = this.b;
        l l2 = a[0];
        return (w)g2.a();
    }

    @Override
    public boolean a() {
        return true;
    }

    @Override
    public ba b() {
        return ba.c;
    }

    @Override
    public w c() {
        return this.d();
    }

}

