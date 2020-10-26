/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.a.m;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ac;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.a;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.aa;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.b;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.g;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.h;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.k;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.l;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.s;

public final class j {
    private final h a;
    private final kotlin.reflect.jvm.internal.impl.i.i b;
    private final y c;
    private final k d;
    private final g e;
    private final b<c, kotlin.reflect.jvm.internal.impl.h.b.f<?>, kotlin.reflect.jvm.internal.impl.a.a.g> f;
    private final ac g;
    private final s h;
    private final p i;
    private final kotlin.reflect.jvm.internal.impl.b.a.c j;
    private final q k;
    private final Iterable<kotlin.reflect.jvm.internal.impl.a.b.b> l;
    private final kotlin.reflect.jvm.internal.impl.a.aa m;
    private final i n;
    private final kotlin.reflect.jvm.internal.impl.a.b.a o;
    private final kotlin.reflect.jvm.internal.impl.a.b.c p;
    private final kotlin.reflect.jvm.internal.impl.f.g q;

    public j(kotlin.reflect.jvm.internal.impl.i.i i2, y y2, k k2, g g2, b<? extends c, ? extends kotlin.reflect.jvm.internal.impl.h.b.f<?>, kotlin.reflect.jvm.internal.impl.a.a.g> b2, ac ac2, s s2, p p2, kotlin.reflect.jvm.internal.impl.b.a.c c2, q q2, Iterable<? extends kotlin.reflect.jvm.internal.impl.a.b.b> iterable, kotlin.reflect.jvm.internal.impl.a.aa aa2, i i3, kotlin.reflect.jvm.internal.impl.a.b.a a2, kotlin.reflect.jvm.internal.impl.a.b.c c3, kotlin.reflect.jvm.internal.impl.f.g g3) {
        kotlin.e.b.j.b(i2, "storageManager");
        kotlin.e.b.j.b(y2, "moduleDescriptor");
        kotlin.e.b.j.b(k2, "configuration");
        kotlin.e.b.j.b(g2, "classDataFinder");
        kotlin.e.b.j.b(b2, "annotationAndConstantLoader");
        kotlin.e.b.j.b(ac2, "packageFragmentProvider");
        kotlin.e.b.j.b(s2, "localClassifierTypeSettings");
        kotlin.e.b.j.b(p2, "errorReporter");
        kotlin.e.b.j.b(c2, "lookupTracker");
        kotlin.e.b.j.b(q2, "flexibleTypeDeserializer");
        kotlin.e.b.j.b(iterable, "fictitiousClassDescriptorFactories");
        kotlin.e.b.j.b(aa2, "notFoundClasses");
        kotlin.e.b.j.b(i3, "contractDeserializer");
        kotlin.e.b.j.b(a2, "additionalClassPartsProvider");
        kotlin.e.b.j.b(c3, "platformDependentDeclarationFilter");
        kotlin.e.b.j.b(g3, "extensionRegistryLite");
        this.b = i2;
        this.c = y2;
        this.d = k2;
        this.e = g2;
        this.f = b2;
        this.g = ac2;
        this.h = s2;
        this.i = p2;
        this.j = c2;
        this.k = q2;
        this.l = iterable;
        this.m = aa2;
        this.n = i3;
        this.o = a2;
        this.p = c3;
        this.q = g3;
        this.a = new h(this);
    }

    public final e a(kotlin.reflect.jvm.internal.impl.e.a a2) {
        kotlin.e.b.j.b(a2, "classId");
        return h.a(this.a, a2, null, 2, null);
    }

    public final h a() {
        return this.a;
    }

    public final l a(ab ab2, kotlin.reflect.jvm.internal.impl.d.b.c c2, kotlin.reflect.jvm.internal.impl.d.b.h h2, kotlin.reflect.jvm.internal.impl.d.b.k k2, a a2, f f2) {
        kotlin.e.b.j.b(ab2, "descriptor");
        kotlin.e.b.j.b(c2, "nameResolver");
        kotlin.e.b.j.b(h2, "typeTable");
        kotlin.e.b.j.b(k2, "versionRequirementTable");
        kotlin.e.b.j.b(a2, "metadataVersion");
        return new l(this, c2, ab2, h2, k2, a2, f2, null, m.<a.ag>a());
    }

    public final kotlin.reflect.jvm.internal.impl.i.i b() {
        return this.b;
    }

    public final y c() {
        return this.c;
    }

    public final k d() {
        return this.d;
    }

    public final g e() {
        return this.e;
    }

    public final b<c, kotlin.reflect.jvm.internal.impl.h.b.f<?>, kotlin.reflect.jvm.internal.impl.a.a.g> f() {
        return this.f;
    }

    public final ac g() {
        return this.g;
    }

    public final s h() {
        return this.h;
    }

    public final p i() {
        return this.i;
    }

    public final kotlin.reflect.jvm.internal.impl.b.a.c j() {
        return this.j;
    }

    public final q k() {
        return this.k;
    }

    public final Iterable<kotlin.reflect.jvm.internal.impl.a.b.b> l() {
        return this.l;
    }

    public final kotlin.reflect.jvm.internal.impl.a.aa m() {
        return this.m;
    }

    public final i n() {
        return this.n;
    }

    public final kotlin.reflect.jvm.internal.impl.a.b.a o() {
        return this.o;
    }

    public final kotlin.reflect.jvm.internal.impl.a.b.c p() {
        return this.p;
    }

    public final kotlin.reflect.jvm.internal.impl.f.g q() {
        return this.q;
    }
}

