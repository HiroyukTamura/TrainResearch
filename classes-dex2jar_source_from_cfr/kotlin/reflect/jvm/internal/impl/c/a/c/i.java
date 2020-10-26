/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c;

import java.util.List;
import java.util.Map;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.n;
import kotlin.reflect.jvm.internal.impl.c.a.c.h;
import kotlin.reflect.jvm.internal.impl.c.a.c.m;
import kotlin.reflect.jvm.internal.impl.c.a.e.w;
import kotlin.reflect.jvm.internal.impl.c.a.e.x;
import kotlin.reflect.jvm.internal.impl.i.d;

public final class i
implements m {
    private final Map<w, Integer> a;
    private final d<w, n> b;
    private final h c;
    private final kotlin.reflect.jvm.internal.impl.a.m d;
    private final int e;

    public i(h h2, kotlin.reflect.jvm.internal.impl.a.m m2, x x2, int n2) {
        j.b(h2, "c");
        j.b(m2, "containingDeclaration");
        j.b(x2, "typeParameterOwner");
        this.c = h2;
        this.d = m2;
        this.e = n2;
        this.a = kotlin.reflect.jvm.internal.impl.l.a.a((Iterable)x2.s());
        this.b = this.c.c().b((b)new b<w, n>(){

            @Override
            public final n a(w w2) {
                j.b(w2, "typeParameter");
                Integer n2 = (Integer)this.a.get(w2);
                if (n2 != null) {
                    int n3 = ((Number)n2).intValue();
                    return new n(kotlin.reflect.jvm.internal.impl.c.a.c.a.a(this.c, this), w2, this.e + n3, this.d);
                }
                return null;
            }
        });
    }

    @Override
    public as a(w w2) {
        j.b(w2, "javaTypeParameter");
        n n2 = (n)this.b.a(w2);
        if (n2 != null) {
            return n2;
        }
        return this.c.f().a(w2);
    }

}

