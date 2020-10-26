/*
 * Decompiled with CFR 0.139.
 */
package f.b.a;

import c.ab;
import c.v;
import com.b.a.f;
import com.b.a.p;
import d.c;
import f.e;

final class b<T>
implements e<T, ab> {
    private static final v a = v.a("application/json; charset=UTF-8");
    private final f<T> b;

    b(f<T> f2) {
        this.b = f2;
    }

    @Override
    public /* synthetic */ Object a(Object object) {
        return this.b(object);
    }

    public ab b(T t2) {
        c c2 = new c();
        p p2 = p.a(c2);
        this.b.a(p2, t2);
        return ab.a(a, c2.o());
    }
}

