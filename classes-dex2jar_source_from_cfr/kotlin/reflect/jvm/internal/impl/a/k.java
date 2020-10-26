/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class k {
    public static final boolean a(w w2) {
        j.b(w2, "$receiver");
        return (KotlinBuiltIns.isPrimitiveType(w2) || UnsignedTypes.INSTANCE.isUnsignedType(w2)) && !av.f(w2) || KotlinBuiltIns.isString(w2);
        {
        }
    }
}

