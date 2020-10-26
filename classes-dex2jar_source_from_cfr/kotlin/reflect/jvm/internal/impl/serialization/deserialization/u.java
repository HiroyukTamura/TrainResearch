/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.d.b.c;
import kotlin.reflect.jvm.internal.impl.e.a;
import kotlin.reflect.jvm.internal.impl.e.f;

public final class u {
    public static final a a(c object, int n2) {
        j.b(object, "$receiver");
        object = a.a(object.b(n2), object.c(n2));
        j.a(object, "ClassId.fromString(getQu\u2026 isLocalClassName(index))");
        return object;
    }

    public static final f b(c object, int n2) {
        j.b(object, "$receiver");
        object = f.d(object.a(n2));
        j.a(object, "Name.guessByFirstCharacter(getString(index))");
        return object;
    }
}

