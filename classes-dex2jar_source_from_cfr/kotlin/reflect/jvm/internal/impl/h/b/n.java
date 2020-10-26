/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.m;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class n
implements an {
    private final ArrayList<w> a;
    private final long b;
    private final y c;

    public Void a() {
        return null;
    }

    @Override
    public List<as> b() {
        return m.a();
    }

    @Override
    public /* synthetic */ h d() {
        return (h)((Object)this.a());
    }

    @Override
    public KotlinBuiltIns e() {
        return this.c.a();
    }

    @Override
    public boolean f() {
        return false;
    }

    @Override
    public Collection<w> k_() {
        return this.a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IntegerValueType(");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

