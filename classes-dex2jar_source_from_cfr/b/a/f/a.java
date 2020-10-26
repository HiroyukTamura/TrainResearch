/*
 * Decompiled with CFR 0.139.
 */
package b.a.f;

import b.a.b;
import b.a.c;
import b.a.c.f;
import b.a.d;
import b.a.e;
import b.a.g;
import b.a.h;
import b.a.i;
import java.util.concurrent.Callable;

public final class a {
    static volatile b.a.d.d<? super Throwable> a;
    static volatile b.a.d.e<? super Runnable, ? extends Runnable> b;
    static volatile b.a.d.e<? super Callable<h>, ? extends h> c;
    static volatile b.a.d.e<? super Callable<h>, ? extends h> d;
    static volatile b.a.d.e<? super Callable<h>, ? extends h> e;
    static volatile b.a.d.e<? super Callable<h>, ? extends h> f;
    static volatile b.a.d.e<? super h, ? extends h> g;
    static volatile b.a.d.e<? super c, ? extends c> h;
    static volatile b.a.d.e<? super e, ? extends e> i;
    static volatile b.a.d.e<? super d, ? extends d> j;
    static volatile b.a.d.e<? super i, ? extends i> k;
    static volatile b.a.d.e<? super b, ? extends b> l;
    static volatile b.a.d.b<? super e, ? super g, ? extends g> m;

    public static b a(b b2) {
        b.a.d.e<? super b, ? extends b> e2 = l;
        b b3 = b2;
        if (e2 != null) {
            b3 = a.a(e2, b2);
        }
        return b3;
    }

    public static <T> c<T> a(c<T> c2) {
        b.a.d.e<? super c, ? extends c> e2 = h;
        c c3 = c2;
        if (e2 != null) {
            c3 = a.a(e2, c2);
        }
        return c3;
    }

    public static <T> d<T> a(d<T> d2) {
        b.a.d.e<? super d, ? extends d> e2 = j;
        d d3 = d2;
        if (e2 != null) {
            d3 = a.a(e2, d2);
        }
        return d3;
    }

    public static <T> e<T> a(e<T> e2) {
        b.a.d.e<? super e, ? extends e> e3 = i;
        e e4 = e2;
        if (e3 != null) {
            e4 = a.a(e3, e2);
        }
        return e4;
    }

    public static <T> g<? super T> a(e<T> e2, g<? super T> g2) {
        b.a.d.b<? super e, ? super g, ? extends g> b2 = m;
        if (b2 != null) {
            return a.a(b2, e2, g2);
        }
        return g2;
    }

    static h a(b.a.d.e<? super Callable<h>, ? extends h> e2, Callable<h> callable) {
        return b.a.e.b.b.a(a.a(e2, callable), "Scheduler Callable result can't be null");
    }

    public static h a(h h2) {
        b.a.d.e<? super h, ? extends h> e2 = g;
        if (e2 == null) {
            return h2;
        }
        return a.a(e2, h2);
    }

    public static h a(Callable<h> callable) {
        b.a.e.b.b.a(callable, "Scheduler Callable can't be null");
        b.a.d.e<? super Callable<h>, ? extends h> e2 = c;
        if (e2 == null) {
            return a.e(callable);
        }
        return a.a(e2, callable);
    }

    public static <T> i<T> a(i<T> i2) {
        b.a.d.e<? super i, ? extends i> e2 = k;
        i i3 = i2;
        if (e2 != null) {
            i3 = a.a(e2, i2);
        }
        return i3;
    }

    static <T, U, R> R a(b.a.d.b<T, U, R> b2, T t2, U u2) {
        try {
            b2 = b2.a(t2, u2);
        }
        catch (Throwable throwable) {
            throw b.a.e.h.a.a(throwable);
        }
        return (R)b2;
    }

    static <T, R> R a(b.a.d.e<T, R> e2, T t2) {
        try {
            e2 = e2.a(t2);
        }
        catch (Throwable throwable) {
            throw b.a.e.h.a.a(throwable);
        }
        return (R)e2;
    }

    public static Runnable a(Runnable runnable) {
        b.a.e.b.b.a(runnable, "run is null");
        b.a.d.e<? super Runnable, ? extends Runnable> e2 = b;
        if (e2 == null) {
            return runnable;
        }
        return a.a(e2, runnable);
    }

    public static void a(Throwable throwable) {
        Throwable throwable2;
        b.a.d.d<? super Throwable> d2 = a;
        if (throwable == null) {
            throwable2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else {
            throwable2 = throwable;
            if (!a.b(throwable)) {
                throwable2 = new f(throwable);
            }
        }
        if (d2 != null) {
            try {
                d2.a(throwable2);
                return;
            }
            catch (Throwable throwable3) {
                throwable3.printStackTrace();
                a.c(throwable3);
            }
        }
        throwable2.printStackTrace();
        a.c(throwable2);
    }

    public static h b(Callable<h> callable) {
        b.a.e.b.b.a(callable, "Scheduler Callable can't be null");
        b.a.d.e<? super Callable<h>, ? extends h> e2 = e;
        if (e2 == null) {
            return a.e(callable);
        }
        return a.a(e2, callable);
    }

    static boolean b(Throwable throwable) {
        if (throwable instanceof b.a.c.d) {
            return true;
        }
        if (throwable instanceof b.a.c.c) {
            return true;
        }
        if (throwable instanceof IllegalStateException) {
            return true;
        }
        if (throwable instanceof NullPointerException) {
            return true;
        }
        if (throwable instanceof IllegalArgumentException) {
            return true;
        }
        return throwable instanceof b.a.c.a;
    }

    public static h c(Callable<h> callable) {
        b.a.e.b.b.a(callable, "Scheduler Callable can't be null");
        b.a.d.e<? super Callable<h>, ? extends h> e2 = f;
        if (e2 == null) {
            return a.e(callable);
        }
        return a.a(e2, callable);
    }

    static void c(Throwable throwable) {
        Thread thread = Thread.currentThread();
        thread.getUncaughtExceptionHandler().uncaughtException(thread, throwable);
    }

    public static h d(Callable<h> callable) {
        b.a.e.b.b.a(callable, "Scheduler Callable can't be null");
        b.a.d.e<? super Callable<h>, ? extends h> e2 = d;
        if (e2 == null) {
            return a.e(callable);
        }
        return a.a(e2, callable);
    }

    static h e(Callable<h> object) {
        try {
            object = b.a.e.b.b.a(object.call(), "Scheduler Callable result can't be null");
            return object;
        }
        catch (Throwable throwable) {
            throw b.a.e.h.a.a(throwable);
        }
    }
}

