/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a;

import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;

public final class o {
    public static final b a = new b("kotlin.Metadata");
    public static final String b;
    public static final f c;
    public static final b d;
    public static final b e;
    public static final b f;
    public static final b g;
    public static final b h;
    public static final b i;
    public static final b j;
    public static final b k;
    public static final b l;
    public static final b m;
    public static final b n;
    public static final b o;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("L");
        stringBuilder.append(kotlin.reflect.jvm.internal.impl.h.d.b.a(a).c());
        stringBuilder.append(";");
        b = stringBuilder.toString();
        c = f.a("value");
        d = new b("org.jetbrains.annotations.NotNull");
        e = new b("org.jetbrains.annotations.Nullable");
        f = new b("org.jetbrains.annotations.Mutable");
        g = new b("org.jetbrains.annotations.ReadOnly");
        h = new b("kotlin.annotations.jvm.ReadOnly");
        i = new b("kotlin.annotations.jvm.Mutable");
        j = new b("kotlin.jvm.PurelyImplements");
        k = new b("kotlin.jvm.internal.EnhancedNullability");
        l = new b("kotlin.jvm.internal.EnhancedMutability");
        m = new b("kotlin.annotations.jvm.internal.ParameterName");
        n = new b("kotlin.annotations.jvm.internal.DefaultValue");
        o = new b("kotlin.annotations.jvm.internal.DefaultNull");
    }
}

