/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.e.b.g;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.a;
import kotlin.reflect.jvm.internal.impl.d.b.c;
import kotlin.reflect.jvm.internal.impl.d.b.h;
import kotlin.reflect.jvm.internal.impl.d.b.k;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.aa;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.t;

public final class l {
    private final aa a;
    private final t b;
    private final j c;
    private final c d;
    private final m e;
    private final h f;
    private final k g;
    private final a h;
    private final f i;

    public l(j object, c c2, m m2, h h2, k k2, a a2, f f2, aa aa2, List<a.ag> list) {
        kotlin.e.b.j.b(object, "components");
        kotlin.e.b.j.b(c2, "nameResolver");
        kotlin.e.b.j.b(m2, "containingDeclaration");
        kotlin.e.b.j.b(h2, "typeTable");
        kotlin.e.b.j.b(k2, "versionRequirementTable");
        kotlin.e.b.j.b(a2, "metadataVersion");
        kotlin.e.b.j.b(list, "typeParameters");
        this.c = object;
        this.d = c2;
        this.e = m2;
        this.f = h2;
        this.g = k2;
        this.h = a2;
        this.i = f2;
        object = new StringBuilder();
        ((StringBuilder)object).append("Deserializer for ");
        ((StringBuilder)object).append(this.e.h_());
        this.a = new aa(this, aa2, list, ((StringBuilder)object).toString(), false, 16, null);
        this.b = new t(this);
    }

    public static /* bridge */ /* synthetic */ l a(l l2, m m2, List list, c c2, h h2, k k2, a a2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            c2 = l2.d;
        }
        if ((n2 & 8) != 0) {
            h2 = l2.f;
        }
        if ((n2 & 16) != 0) {
            k2 = l2.g;
        }
        if ((n2 & 32) != 0) {
            a2 = l2.h;
        }
        return l2.a(m2, list, c2, h2, k2, a2);
    }

    public final aa a() {
        return this.a;
    }

    public final l a(m m2, List<a.ag> list, c c2, h h2, k k2, a a2) {
        j j2;
        block0 : {
            kotlin.e.b.j.b(m2, "descriptor");
            kotlin.e.b.j.b(list, "typeParameterProtos");
            kotlin.e.b.j.b(c2, "nameResolver");
            kotlin.e.b.j.b(h2, "typeTable");
            kotlin.e.b.j.b(k2, "versionRequirementTable");
            kotlin.e.b.j.b(a2, "metadataVersion");
            j2 = this.c;
            if (kotlin.reflect.jvm.internal.impl.d.b.l.a(a2)) break block0;
            k2 = this.g;
        }
        return new l(j2, c2, m2, h2, k2, a2, this.i, this.a, list);
    }

    public final t b() {
        return this.b;
    }

    public final i c() {
        return this.c.b();
    }

    public final j d() {
        return this.c;
    }

    public final c e() {
        return this.d;
    }

    public final m f() {
        return this.e;
    }

    public final h g() {
        return this.f;
    }

    public final k h() {
        return this.g;
    }

    public final f i() {
        return this.i;
    }
}

