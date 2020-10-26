/*
 * Decompiled with CFR 0.139.
 */
package b.a;

import b.a.c;
import b.a.c.b;
import b.a.e.e.b.d;
import b.a.e.e.b.f;
import b.a.e.e.b.g;
import b.a.f.a;
import b.a.h;
import b.a.i;

public abstract class e<T>
implements b.a.f<T> {
    public static int a() {
        return c.a();
    }

    public static <T, R> e<R> a(Iterable<? extends b.a.f<? extends T>> iterable, b.a.d.e<? super Object[], ? extends R> e2) {
        b.a.e.b.b.a(e2, "zipper is null");
        b.a.e.b.b.a(iterable, "sources is null");
        return a.a(new g(null, iterable, e2, e.a(), false));
    }

    public final c<T> a(b.a.a a2) {
        b.a.e.e.a.b b2 = new b.a.e.e.a.b(this);
        switch (1.a[a2.ordinal()]) {
            default: {
                return b2.b();
            }
            case 4: {
                return a.a(new b.a.e.e.a.e(b2));
            }
            case 3: {
                return b2;
            }
            case 2: {
                return b2.d();
            }
            case 1: 
        }
        return b2.c();
    }

    public final e<T> a(h h2) {
        return this.a(h2, false, e.a());
    }

    public final e<T> a(h h2, boolean bl2, int n2) {
        b.a.e.b.b.a(h2, "scheduler is null");
        b.a.e.b.b.a(n2, "bufferSize");
        return a.a(new b.a.e.e.b.c(this, h2, bl2, n2));
    }

    @Override
    public final void a(b.a.g<? super T> g2) {
        b.a.e.b.b.a(g2, "observer is null");
        try {
            g2 = a.a(this, g2);
            b.a.e.b.b.a(g2, "Plugin returned null Observer");
            this.b(g2);
            return;
        }
        catch (Throwable throwable) {
            b.b(throwable);
            a.a(throwable);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(throwable);
            throw nullPointerException;
        }
        catch (NullPointerException nullPointerException) {
            throw nullPointerException;
        }
    }

    public final b.a.b b() {
        return a.a(new b.a.e.e.b.b(this));
    }

    public final e<T> b(h h2) {
        b.a.e.b.b.a(h2, "scheduler is null");
        return a.a(new f(this, h2));
    }

    protected abstract void b(b.a.g<? super T> var1);

    public final b.a.d<T> c() {
        return a.a(new d<T>(this));
    }

    public final i<T> d() {
        return a.a(new b.a.e.e.b.e<Object>(this, null));
    }

}

