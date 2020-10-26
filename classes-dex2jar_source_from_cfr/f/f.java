/*
 * Decompiled with CFR 0.139.
 */
package f;

import f.b;
import f.c;
import f.n;
import f.p;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

final class f
extends c.a {
    static final c.a a = new f();

    f() {
    }

    @Override
    public c<?, ?> a(Type type, Annotation[] arrannotation, n n2) {
        if (f.a(type) != b.class) {
            return null;
        }
        return new c<Object, b<?>>(p.e(type)){
            final /* synthetic */ Type a;
            {
                this.a = type;
            }

            @Override
            public /* synthetic */ Object a(b b2) {
                return this.b(b2);
            }

            @Override
            public Type a() {
                return this.a;
            }

            public b<Object> b(b<Object> b2) {
                return b2;
            }
        };
    }

}

