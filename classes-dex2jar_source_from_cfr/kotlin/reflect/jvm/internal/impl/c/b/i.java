/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ao;
import kotlin.reflect.jvm.internal.impl.c.b.a.a;
import kotlin.reflect.jvm.internal.impl.c.b.n;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.c;
import kotlin.reflect.jvm.internal.impl.d.c.a.g;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.f.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.r;

public final class i
implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.f {
    private final String b;
    private final kotlin.reflect.jvm.internal.impl.h.d.b c;
    private final kotlin.reflect.jvm.internal.impl.h.d.b d;
    private final r<g> e;
    private final boolean f;
    private final n g;

    public i(n n2, a.s s2, c c2, r<g> r2, boolean bl2) {
        kotlin.reflect.jvm.internal.impl.h.d.b b2;
        j.b(n2, "kotlinClass");
        j.b(s2, "packageProto");
        j.b(c2, "nameResolver");
        kotlin.reflect.jvm.internal.impl.h.d.b b3 = kotlin.reflect.jvm.internal.impl.h.d.b.a(n2.b());
        j.a((Object)b3, "JvmClassName.byClassId(kotlinClass.classId)");
        String string2 = n2.d().a();
        kotlin.reflect.jvm.internal.impl.h.d.b b4 = b2 = null;
        if (string2 != null) {
            boolean bl3 = ((CharSequence)string2).length() > 0;
            b4 = b2;
            if (bl3) {
                b4 = kotlin.reflect.jvm.internal.impl.h.d.b.a(string2);
            }
        }
        this(b3, b4, s2, c2, r2, bl2, n2);
    }

    public i(kotlin.reflect.jvm.internal.impl.h.d.b object, kotlin.reflect.jvm.internal.impl.h.d.b object2, a.s s2, c c2, r<g> r2, boolean bl2, n n2) {
        j.b(object, "className");
        j.b(s2, "packageProto");
        j.b(c2, "nameResolver");
        this.c = object;
        this.d = object2;
        this.e = r2;
        this.f = bl2;
        this.g = n2;
        object = s2;
        object2 = kotlin.reflect.jvm.internal.impl.d.c.b.l;
        j.a(object2, "JvmProtoBuf.packageModuleName");
        object = (Integer)kotlin.reflect.jvm.internal.impl.d.b.f.a(object, object2);
        if (object == null || (object = c2.a(((Number)object).intValue())) == null) {
            object = "main";
        }
        this.b = object;
    }

    @Override
    public ao a() {
        ao ao2 = ao.a;
        j.a((Object)ao2, "SourceFile.NO_SOURCE_FILE");
        return ao2;
    }

    public final f b() {
        Object object = this.c.c();
        j.a(object, "className.internalName");
        object = f.a(kotlin.i.n.c((String)object, '/', null, 2, null));
        j.a(object, "Name.identifier(classNam\u2026.substringAfterLast('/'))");
        return object;
    }

    public final kotlin.reflect.jvm.internal.impl.e.a c() {
        return new kotlin.reflect.jvm.internal.impl.e.a(this.c.b(), this.b());
    }

    public final kotlin.reflect.jvm.internal.impl.h.d.b d() {
        return this.c;
    }

    public final kotlin.reflect.jvm.internal.impl.h.d.b e() {
        return this.d;
    }

    public final n f() {
        return this.g;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }
}

