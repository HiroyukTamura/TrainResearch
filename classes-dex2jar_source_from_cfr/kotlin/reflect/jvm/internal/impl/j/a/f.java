/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.a;

import java.util.Collection;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.c.a;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.y;

public final class f
implements an {
    private final ap a;
    private List<? extends az> b;

    public f(ap ap2, List<? extends az> list) {
        j.b(ap2, "projection");
        this.a = ap2;
        this.b = list;
    }

    public /* synthetic */ f(ap ap2, List list, int n2, g g2) {
        if ((n2 & 2) != 0) {
            list = null;
        }
        this(ap2, list);
    }

    public List<az> a() {
        List<az> list = this.b;
        if (list != null) {
            return list;
        }
        return m.a();
    }

    public final void a(List<? extends az> list) {
        j.b(list, "supertypes");
        boolean bl2 = this.b == null;
        if (y.a && !bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Already initialized! oldValue = ");
            stringBuilder.append(this.b);
            stringBuilder.append(", newValue = ");
            stringBuilder.append(list);
            throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
        }
        this.b = list;
    }

    @Override
    public List<as> b() {
        return m.a();
    }

    @Override
    public h d() {
        return null;
    }

    @Override
    public KotlinBuiltIns e() {
        w w2 = this.a.c();
        j.a((Object)w2, "projection.type");
        return a.a(w2);
    }

    @Override
    public boolean f() {
        return false;
    }

    public /* synthetic */ Collection k_() {
        return this.a();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CapturedType(");
        stringBuilder.append(this.a);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

