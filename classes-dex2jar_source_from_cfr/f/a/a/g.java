/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package f.a.a;

import b.a.d;
import b.a.e;
import b.a.h;
import b.a.i;
import f.a.a.a;
import f.a.a.c;
import f.a.a.f;
import f.b;
import f.m;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

final class g<R>
implements f.c<R, Object> {
    private final Type a;
    @Nullable
    private final h b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    g(Type type, @Nullable h h2, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.a = type;
        this.b = h2;
        this.c = bl2;
        this.d = bl3;
        this.e = bl4;
        this.f = bl5;
        this.g = bl6;
        this.h = bl7;
        this.i = bl8;
    }

    @Override
    public Object a(b<R> object) {
        object = this.c ? new f.a.a.b<R>((b<R>)object) : new c<R>((b<R>)object);
        if (this.d) {
            object = new f(object);
        } else if (this.e) {
            object = new a(object);
        }
        e e2 = object;
        if (this.b != null) {
            e2 = ((e)object).b(this.b);
        }
        if (this.f) {
            return e2.a(b.a.a.e);
        }
        if (this.g) {
            return e2.d();
        }
        if (this.h) {
            return e2.c();
        }
        object = e2;
        if (this.i) {
            object = e2.b();
        }
        return object;
    }

    @Override
    public Type a() {
        return this.a;
    }
}

