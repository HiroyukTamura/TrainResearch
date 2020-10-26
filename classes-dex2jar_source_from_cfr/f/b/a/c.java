/*
 * Decompiled with CFR 0.139.
 */
package f.b.a;

import c.ad;
import com.b.a.f;
import com.b.a.h;
import com.b.a.k;
import f.e;

final class c<T>
implements e<ad, T> {
    private static final d.f a = d.f.b("EFBBBF");
    private final f<T> b;

    c(f<T> f2) {
        this.b = f2;
    }

    @Override
    public T a(ad ad2) {
        block4 : {
            d.e e2 = ad2.d();
            try {
                k.b b2;
                if (e2.a(0L, a)) {
                    e2.i(a.g());
                }
                Object object = k.a(e2);
                e2 = this.b.a((k)object);
                if ((object = object.h()) != (b2 = k.b.j)) break block4;
                ad2.close();
            }
            catch (Throwable throwable) {
                ad2.close();
                throw throwable;
            }
            return (T)e2;
        }
        throw new h("JSON document was not fully consumed.");
    }
}

