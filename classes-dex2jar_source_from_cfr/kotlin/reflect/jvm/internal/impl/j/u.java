/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.Collection;
import java.util.List;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.a;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.t;
import kotlin.y;

public final class u
extends as {
    private final kotlin.reflect.jvm.internal.impl.a.as[] a;
    private final ap[] b;
    private final boolean c;

    public u(List<? extends kotlin.reflect.jvm.internal.impl.a.as> arras, List<? extends ap> arrap) {
        j.b(arras, "parameters");
        j.b(arrap, "argumentsList");
        arras = ((Collection)arras).toArray(new kotlin.reflect.jvm.internal.impl.a.as[0]);
        if (arras != null) {
            if ((arrap = ((Collection)arrap).toArray(new ap[0])) != null) {
                this(arras, arrap, false, 4, null);
                return;
            }
            throw new t("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new t("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public u(kotlin.reflect.jvm.internal.impl.a.as[] object, ap[] arrap, boolean bl2) {
        j.b(object, "parameters");
        j.b(arrap, "arguments");
        this.a = object;
        this.b = arrap;
        this.c = bl2;
        boolean bl3 = this.a.length <= this.b.length;
        if (y.a) {
            if (bl3) {
                return;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Number of arguments should not be less then number of parameters, but: parameters=");
            ((StringBuilder)object).append(this.a.length);
            ((StringBuilder)object).append(", args=");
            ((StringBuilder)object).append(this.b.length);
            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
        }
    }

    public /* synthetic */ u(kotlin.reflect.jvm.internal.impl.a.as[] arras, ap[] arrap, boolean bl2, int n2, g g2) {
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        this(arras, arrap, bl2);
    }

    @Override
    public boolean a() {
        return this.b.length == 0;
    }

    @Override
    public ap b(w a2) {
        int n2;
        j.b(a2, "key");
        h h2 = ((w)a2).g().d();
        a2 = h2;
        if (!(h2 instanceof kotlin.reflect.jvm.internal.impl.a.as)) {
            a2 = null;
        }
        if ((a2 = (kotlin.reflect.jvm.internal.impl.a.as)a2) != null && (n2 = a2.g()) < this.a.length && j.a((Object)this.a[n2].e(), (Object)a2.e())) {
            return this.b[n2];
        }
        return null;
    }

    @Override
    public boolean b() {
        return this.c;
    }

    public final kotlin.reflect.jvm.internal.impl.a.as[] d() {
        return this.a;
    }

    public final ap[] e() {
        return this.b;
    }
}

