/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.j.a.c;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ax;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.f;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.jvm.internal.impl.j.t;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.y;

public final class r
extends q
implements f {
    public static boolean a;
    public static final a b;
    private boolean c;

    static {
        b = new a(null);
    }

    public r(ad ad2, ad ad3) {
        j.b(ad2, "lowerBound");
        j.b(ad3, "upperBound");
        super(ad2, ad3);
    }

    private final void i() {
        if (a) {
            if (this.c) {
                return;
            }
            this.c = true;
            boolean bl2 = t.a(this.f());
            if (y.a && !(bl2 ^ true)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Lower bound of a flexible type can not be flexible: ");
                stringBuilder.append(this.f());
                throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
            }
            bl2 = t.a(this.h());
            if (y.a && !(bl2 ^ true)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Upper bound of a flexible type can not be flexible: ");
                stringBuilder.append(this.h());
                throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
            }
            bl2 = j.a((Object)this.f(), (Object)this.h());
            if (y.a && !(true ^ bl2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Lower and upper bounds are equal: ");
                stringBuilder.append(this.f());
                stringBuilder.append(" == ");
                stringBuilder.append(this.h());
                throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
            }
            bl2 = c.a.a(this.f(), this.h());
            if (y.a) {
                if (bl2) {
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Lower bound ");
                stringBuilder.append(this.f());
                stringBuilder.append(" of a flexible type must be a subtype of the upper bound ");
                stringBuilder.append(this.h());
                throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
            }
        }
    }

    @Override
    public String a(kotlin.reflect.jvm.internal.impl.g.c c2, kotlin.reflect.jvm.internal.impl.g.h object) {
        j.b(c2, "renderer");
        j.b(object, "options");
        if (object.h()) {
            object = new StringBuilder();
            ((StringBuilder)object).append('(');
            ((StringBuilder)object).append(c2.a(this.f()));
            ((StringBuilder)object).append("..");
            ((StringBuilder)object).append(c2.a(this.h()));
            ((StringBuilder)object).append(')');
            return ((StringBuilder)object).toString();
        }
        return c2.a(c2.a(this.f()), c2.a(this.h()), kotlin.reflect.jvm.internal.impl.j.c.a.a((w)this));
    }

    @Override
    public w a_(w w2) {
        block4 : {
            az az2;
            block3 : {
                block2 : {
                    j.b(w2, "replacement");
                    az2 = w2.l();
                    if (!(az2 instanceof q)) break block2;
                    w2 = az2;
                    break block3;
                }
                if (!(az2 instanceof ad)) break block4;
                w2 = (ad)az2;
                w2 = x.a((ad)w2, ((ad)w2).a(true));
            }
            return ax.a((az)w2, az2);
        }
        throw new m();
    }

    @Override
    public az b(h h2) {
        j.b(h2, "newAnnotations");
        return x.a(this.f().c(h2), this.h().c(h2));
    }

    @Override
    public az b(boolean bl2) {
        return x.a(this.f().a(bl2), this.h().a(bl2));
    }

    @Override
    public ad p_() {
        this.i();
        return this.f();
    }

    @Override
    public boolean q_() {
        return this.f().g().d() instanceof as && j.a((Object)this.f().g(), (Object)this.h().g());
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

}

