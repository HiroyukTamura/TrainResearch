/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.a;

import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.impl.e.a;
import kotlin.reflect.jvm.internal.impl.e.b;

@Metadata(bv={1, 0, 2}, d1={"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u00a8\u0006\u0003"}, d2={"toRuntimeFqName", "", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "descriptors.runtime"}, k=2, mv={1, 1, 11})
public final class g {
    public static final /* synthetic */ String a(a a2) {
        return g.b(a2);
    }

    private static final String b(a a2) {
        String string2 = a2.b().a();
        j.a((Object)string2, "relativeClassName.asString()");
        string2 = n.a(string2, '.', '$', false, 4, null);
        Object object = a2.a();
        j.a(object, "packageFqName");
        if (((b)object).c()) {
            return string2;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(a2.a());
        ((StringBuilder)object).append('.');
        ((StringBuilder)object).append(string2);
        return ((StringBuilder)object).toString();
    }
}

