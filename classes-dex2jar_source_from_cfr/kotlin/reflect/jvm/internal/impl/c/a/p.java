/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.al;
import kotlin.a.m;
import kotlin.reflect.jvm.internal.impl.c.a.o;
import kotlin.reflect.jvm.internal.impl.e.b;

public final class p {
    private static final List<b> a = m.b(o.e, new b("androidx.annotation.Nullable"), new b("androidx.annotation.Nullable"), new b("com.android.annotations.Nullable"), new b("org.eclipse.jdt.annotation.Nullable"), new b("org.checkerframework.checker.nullness.qual.Nullable"), new b("javax.annotation.Nullable"), new b("javax.annotation.CheckForNull"), new b("edu.umd.cs.findbugs.annotations.CheckForNull"), new b("edu.umd.cs.findbugs.annotations.Nullable"), new b("edu.umd.cs.findbugs.annotations.PossiblyNull"), new b("io.reactivex.annotations.Nullable"));
    private static final b b = new b("javax.annotation.Nonnull");
    private static final b c = new b("javax.annotation.CheckForNull");
    private static final List<b> d = m.b(o.d, new b("edu.umd.cs.findbugs.annotations.NonNull"), new b("androidx.annotation.NonNull"), new b("androidx.annotation.NonNull"), new b("com.android.annotations.NonNull"), new b("org.eclipse.jdt.annotation.NonNull"), new b("org.checkerframework.checker.nullness.qual.NonNull"), new b("lombok.NonNull"), new b("io.reactivex.annotations.NonNull"));
    private static final b e = new b("org.checkerframework.checker.nullness.compatqual.NullableDecl");
    private static final b f = new b("org.checkerframework.checker.nullness.compatqual.NonNullDecl");
    private static final b g = new b("androidx.annotation.RecentlyNullable");
    private static final b h = new b("androidx.annotation.RecentlyNonNull");
    private static final Set<b> i = al.a(al.a(al.a(al.a(al.a(al.a(al.a((Set)new LinkedHashSet(), (Iterable)a), b), (Iterable)d), e), f), g), h);
    private static final List<b> j = m.b(o.g, o.h);
    private static final List<b> k = m.b(o.f, o.i);

    public static final List<b> a() {
        return a;
    }

    public static final b b() {
        return b;
    }

    public static final b c() {
        return c;
    }

    public static final List<b> d() {
        return d;
    }

    public static final b e() {
        return e;
    }

    public static final b f() {
        return f;
    }

    public static final b g() {
        return g;
    }

    public static final b h() {
        return h;
    }

    public static final List<b> i() {
        return j;
    }

    public static final List<b> j() {
        return k;
    }
}

