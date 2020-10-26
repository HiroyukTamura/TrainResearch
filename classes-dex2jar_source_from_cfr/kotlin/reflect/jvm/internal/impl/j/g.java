/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.j.a.k;
import kotlin.reflect.jvm.internal.impl.j.a.l;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ag;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.f;
import kotlin.reflect.jvm.internal.impl.j.i;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.jvm.internal.impl.j.t;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.y;

public final class g
extends i
implements f {
    public static final a a = new a(null);
    private final ad b;

    private g(ad ad2) {
        this.b = ad2;
    }

    public /* synthetic */ g(ad ad2, kotlin.e.b.g g2) {
        this(ad2);
    }

    @Override
    public ad a(boolean bl2) {
        if (bl2) {
            return this.d().a(bl2);
        }
        return this;
    }

    public g a(h h2) {
        j.b(h2, "newAnnotations");
        return new g(this.d().c(h2));
    }

    @Override
    public w a_(w w2) {
        j.b(w2, "replacement");
        return ag.a(w2.l());
    }

    @Override
    public /* synthetic */ az b(h h2) {
        return this.a(h2);
    }

    @Override
    public /* synthetic */ az b(boolean bl2) {
        return this.a(bl2);
    }

    @Override
    public /* synthetic */ ad c(h h2) {
        return this.a(h2);
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    protected ad d() {
        return this.b;
    }

    public final ad e() {
        return this.b;
    }

    @Override
    public boolean q_() {
        return this.d().g() instanceof k || this.d().g().d() instanceof as;
        {
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d());
        stringBuilder.append("!!");
        return stringBuilder.toString();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }

        public final g a(az az2) {
            j.b(az2, "type");
            boolean bl2 = az2 instanceof g;
            Object object = null;
            if (bl2) {
                return (g)az2;
            }
            if (this.b(az2)) {
                if (az2 instanceof q) {
                    object = (q)az2;
                    bl2 = j.a((Object)((q)object).f().g(), (Object)((q)object).h().g());
                    if (y.a && !bl2) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("DefinitelyNotNullType for flexible type (");
                        ((StringBuilder)object).append(az2);
                        ((StringBuilder)object).append(") can be created only from type variable with the same constructor for bounds");
                        throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
                    }
                }
                object = new g(t.c(az2), null);
            }
            return object;
        }

        public final boolean b(az az2) {
            j.b(az2, "type");
            return kotlin.reflect.jvm.internal.impl.j.c.a.a(az2) && !l.a.a(az2);
        }
    }

}

