/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ac;
import kotlin.reflect.jvm.internal.impl.e.a;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.g;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.n;

public final class m
implements g {
    private final ac a;

    public m(ac ac2) {
        j.b(ac2, "packageFragmentProvider");
        this.a = ac2;
    }

    @Override
    public f a(a a2) {
        j.b(a2, "classId");
        ac ac2 = this.a;
        b object2 = a2.a();
        j.a((Object)object2, "classId.packageFqName");
        for (ab ab2 : ac2.a(object2)) {
            f f2;
            if (!(ab2 instanceof n) || (f2 = ((n)ab2).c().a(a2)) == null) continue;
            return f2;
        }
        return null;
    }
}

