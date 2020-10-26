/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c;

import kotlin.reflect.jvm.internal.impl.a.aq;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.c.a.a;
import kotlin.reflect.jvm.internal.impl.c.a.a.f;
import kotlin.reflect.jvm.internal.impl.c.a.a.g;
import kotlin.reflect.jvm.internal.impl.c.a.a.k;
import kotlin.reflect.jvm.internal.impl.c.a.c.c;
import kotlin.reflect.jvm.internal.impl.c.a.f.l;
import kotlin.reflect.jvm.internal.impl.c.a.i;
import kotlin.reflect.jvm.internal.impl.c.a.j;
import kotlin.reflect.jvm.internal.impl.c.b.e;
import kotlin.reflect.jvm.internal.impl.c.b.m;
import kotlin.reflect.jvm.internal.impl.c.b.t;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;

public final class b {
    private final kotlin.reflect.jvm.internal.impl.i.i a;
    private final i b;
    private final m c;
    private final e d;
    private final k e;
    private final p f;
    private final g g;
    private final f h;
    private final kotlin.reflect.jvm.internal.impl.c.a.a.j i;
    private final kotlin.reflect.jvm.internal.impl.c.a.d.b j;
    private final kotlin.reflect.jvm.internal.impl.c.a.c.j k;
    private final t l;
    private final aq m;
    private final kotlin.reflect.jvm.internal.impl.b.a.c n;
    private final y o;
    private final ReflectionTypes p;
    private final a q;
    private final l r;
    private final j s;
    private final c t;

    public b(kotlin.reflect.jvm.internal.impl.i.i i2, i i3, m m2, e e2, k k2, p p2, g g2, f f2, kotlin.reflect.jvm.internal.impl.c.a.a.j j2, kotlin.reflect.jvm.internal.impl.c.a.d.b b2, kotlin.reflect.jvm.internal.impl.c.a.c.j j3, t t2, aq aq2, kotlin.reflect.jvm.internal.impl.b.a.c c2, y y2, ReflectionTypes reflectionTypes, a a2, l l2, j j4, c c3) {
        kotlin.e.b.j.b(i2, "storageManager");
        kotlin.e.b.j.b(i3, "finder");
        kotlin.e.b.j.b(m2, "kotlinClassFinder");
        kotlin.e.b.j.b(e2, "deserializedDescriptorResolver");
        kotlin.e.b.j.b(k2, "signaturePropagator");
        kotlin.e.b.j.b(p2, "errorReporter");
        kotlin.e.b.j.b(g2, "javaResolverCache");
        kotlin.e.b.j.b(f2, "javaPropertyInitializerEvaluator");
        kotlin.e.b.j.b(j2, "samConversionResolver");
        kotlin.e.b.j.b(b2, "sourceElementFactory");
        kotlin.e.b.j.b(j3, "moduleClassResolver");
        kotlin.e.b.j.b(t2, "packagePartProvider");
        kotlin.e.b.j.b(aq2, "supertypeLoopChecker");
        kotlin.e.b.j.b(c2, "lookupTracker");
        kotlin.e.b.j.b(y2, "module");
        kotlin.e.b.j.b(reflectionTypes, "reflectionTypes");
        kotlin.e.b.j.b(a2, "annotationTypeQualifierResolver");
        kotlin.e.b.j.b(l2, "signatureEnhancement");
        kotlin.e.b.j.b(j4, "javaClassesTracker");
        kotlin.e.b.j.b(c3, "settings");
        this.a = i2;
        this.b = i3;
        this.c = m2;
        this.d = e2;
        this.e = k2;
        this.f = p2;
        this.g = g2;
        this.h = f2;
        this.i = j2;
        this.j = b2;
        this.k = j3;
        this.l = t2;
        this.m = aq2;
        this.n = c2;
        this.o = y2;
        this.p = reflectionTypes;
        this.q = a2;
        this.r = l2;
        this.s = j4;
        this.t = c3;
    }

    public final b a(g g2) {
        kotlin.e.b.j.b(g2, "javaResolverCache");
        return new b(this.a, this.b, this.c, this.d, this.e, this.f, g2, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t);
    }

    public final kotlin.reflect.jvm.internal.impl.i.i a() {
        return this.a;
    }

    public final i b() {
        return this.b;
    }

    public final m c() {
        return this.c;
    }

    public final e d() {
        return this.d;
    }

    public final k e() {
        return this.e;
    }

    public final p f() {
        return this.f;
    }

    public final g g() {
        return this.g;
    }

    public final f h() {
        return this.h;
    }

    public final kotlin.reflect.jvm.internal.impl.c.a.d.b i() {
        return this.j;
    }

    public final kotlin.reflect.jvm.internal.impl.c.a.c.j j() {
        return this.k;
    }

    public final t k() {
        return this.l;
    }

    public final aq l() {
        return this.m;
    }

    public final kotlin.reflect.jvm.internal.impl.b.a.c m() {
        return this.n;
    }

    public final y n() {
        return this.o;
    }

    public final ReflectionTypes o() {
        return this.p;
    }

    public final a p() {
        return this.q;
    }

    public final l q() {
        return this.r;
    }

    public final j r() {
        return this.s;
    }

    public final c s() {
        return this.t;
    }
}

