/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization;

import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.f.g;
import kotlin.reflect.jvm.internal.impl.f.i;

public class a {
    private final g a;
    private final i.f<a.s, Integer> b;
    private final i.f<a.e, List<a.a>> c;
    private final i.f<a.c, List<a.a>> d;
    private final i.f<a.o, List<a.a>> e;
    private final i.f<a.w, List<a.a>> f;
    private final i.f<a.k, List<a.a>> g;
    private final i.f<a.w, a.a.a.b> h;
    private final i.f<a.ak, List<a.a>> i;
    private final i.f<a.ac, List<a.a>> j;
    private final i.f<a.ag, List<a.a>> k;

    public a(g g2, i.f<a.s, Integer> f2, i.f<a.e, List<a.a>> f3, i.f<a.c, List<a.a>> f4, i.f<a.o, List<a.a>> f5, i.f<a.w, List<a.a>> f6, i.f<a.k, List<a.a>> f7, i.f<a.w, a.a.a.b> f8, i.f<a.ak, List<a.a>> f9, i.f<a.ac, List<a.a>> f10, i.f<a.ag, List<a.a>> f11) {
        j.b(g2, "extensionRegistry");
        j.b(f2, "packageFqName");
        j.b(f3, "constructorAnnotation");
        j.b(f4, "classAnnotation");
        j.b(f5, "functionAnnotation");
        j.b(f6, "propertyAnnotation");
        j.b(f7, "enumEntryAnnotation");
        j.b(f8, "compileTimeValue");
        j.b(f9, "parameterAnnotation");
        j.b(f10, "typeAnnotation");
        j.b(f11, "typeParameterAnnotation");
        this.a = g2;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f = f6;
        this.g = f7;
        this.h = f8;
        this.i = f9;
        this.j = f10;
        this.k = f11;
    }

    public final g a() {
        return this.a;
    }

    public final i.f<a.e, List<a.a>> b() {
        return this.c;
    }

    public final i.f<a.c, List<a.a>> c() {
        return this.d;
    }

    public final i.f<a.o, List<a.a>> d() {
        return this.e;
    }

    public final i.f<a.w, List<a.a>> e() {
        return this.f;
    }

    public final i.f<a.k, List<a.a>> f() {
        return this.g;
    }

    public final i.f<a.w, a.a.a.b> g() {
        return this.h;
    }

    public final i.f<a.ak, List<a.a>> h() {
        return this.i;
    }

    public final i.f<a.ac, List<a.a>> i() {
        return this.j;
    }

    public final i.f<a.ag, List<a.a>> j() {
        return this.k;
    }
}

