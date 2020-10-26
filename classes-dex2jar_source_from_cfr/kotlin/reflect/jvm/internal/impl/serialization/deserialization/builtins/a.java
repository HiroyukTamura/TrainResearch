/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.util.List;
import kotlin.e.b.j;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.f.g;
import kotlin.reflect.jvm.internal.impl.f.i;

public final class a
extends kotlin.reflect.jvm.internal.impl.serialization.a {
    public static final a a = new a();

    private a() {
        g g2 = g.a();
        kotlin.reflect.jvm.internal.impl.d.a.b.a(g2);
        j.a((Object)g2, "ExtensionRegistryLite.ne\u2026sterAllExtensions(this) }");
        i.f<a.s, Integer> f2 = kotlin.reflect.jvm.internal.impl.d.a.b.a;
        j.a(f2, "BuiltInsProtoBuf.packageFqName");
        i.f<a.e, List<a.a>> f3 = kotlin.reflect.jvm.internal.impl.d.a.b.c;
        j.a(f3, "BuiltInsProtoBuf.constructorAnnotation");
        i.f<a.c, List<a.a>> f4 = kotlin.reflect.jvm.internal.impl.d.a.b.b;
        j.a(f4, "BuiltInsProtoBuf.classAnnotation");
        i.f<a.o, List<a.a>> f5 = kotlin.reflect.jvm.internal.impl.d.a.b.d;
        j.a(f5, "BuiltInsProtoBuf.functionAnnotation");
        i.f<a.w, List<a.a>> f6 = kotlin.reflect.jvm.internal.impl.d.a.b.e;
        j.a(f6, "BuiltInsProtoBuf.propertyAnnotation");
        i.f<a.k, List<a.a>> f7 = kotlin.reflect.jvm.internal.impl.d.a.b.g;
        j.a(f7, "BuiltInsProtoBuf.enumEntryAnnotation");
        i.f<a.w, a.a.a.b> f8 = kotlin.reflect.jvm.internal.impl.d.a.b.f;
        j.a(f8, "BuiltInsProtoBuf.compileTimeValue");
        i.f<a.ak, List<a.a>> f9 = kotlin.reflect.jvm.internal.impl.d.a.b.h;
        j.a(f9, "BuiltInsProtoBuf.parameterAnnotation");
        i.f<a.ac, List<a.a>> f10 = kotlin.reflect.jvm.internal.impl.d.a.b.i;
        j.a(f10, "BuiltInsProtoBuf.typeAnnotation");
        i.f<a.ag, List<a.a>> f11 = kotlin.reflect.jvm.internal.impl.d.a.b.j;
        j.a(f11, "BuiltInsProtoBuf.typeParameterAnnotation");
        super(g2, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11);
    }

    private final String c(b object) {
        if (((b)object).c()) {
            return "default-package";
        }
        object = ((b)object).e().a();
        j.a(object, "fqName.shortName().asString()");
        return object;
    }

    public final String a(b b2) {
        j.b(b2, "fqName");
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = b2.a();
        j.a((Object)string2, "fqName.asString()");
        stringBuilder.append(n.a(string2, '.', '/', false, 4, null));
        stringBuilder.append("/");
        stringBuilder.append(this.b(b2));
        return stringBuilder.toString();
    }

    public final String b(b b2) {
        j.b(b2, "fqName");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c(b2));
        stringBuilder.append(".");
        stringBuilder.append("kotlin_builtins");
        return stringBuilder.toString();
    }
}

