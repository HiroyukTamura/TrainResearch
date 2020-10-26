/*
 * Decompiled with CFR 0.139.
 */
package f.b.b;

import c.ab;
import c.v;
import f.e;

final class a<T>
implements e<T, ab> {
    static final a<Object> a = new a<T>();
    private static final v b = v.a("text/plain; charset=UTF-8");

    private a() {
    }

    @Override
    public /* synthetic */ Object a(Object object) {
        return this.b(object);
    }

    public ab b(T t2) {
        return ab.a(b, String.valueOf(t2));
    }
}

