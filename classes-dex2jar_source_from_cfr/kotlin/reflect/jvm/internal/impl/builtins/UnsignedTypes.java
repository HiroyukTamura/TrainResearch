/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.a;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedType;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class UnsignedTypes {
    public static final UnsignedTypes INSTANCE = new UnsignedTypes();
    private static final Set<f> a;

    static {
        UnsignedType[] arrunsignedType = UnsignedType.values();
        Collection collection = new ArrayList(arrunsignedType.length);
        int n2 = arrunsignedType.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            collection.add(arrunsignedType[i2].getTypeName());
        }
        a = kotlin.a.m.m((List)collection);
    }

    private UnsignedTypes() {
    }

    public final boolean isUnsignedClass(m m2) {
        j.b(m2, "descriptor");
        m m3 = m2.b();
        return m3 instanceof ab && j.a((Object)((ab)m3).f(), (Object)KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME) && a.contains(m2.h_());
    }

    public final boolean isUnsignedType(w a2) {
        j.b(a2, "type");
        if (av.a(a2)) {
            return false;
        }
        if ((a2 = a2.g().d()) != null) {
            j.a((Object)a2, "descriptor");
            return this.isUnsignedClass((m)a2);
        }
        return false;
    }
}

