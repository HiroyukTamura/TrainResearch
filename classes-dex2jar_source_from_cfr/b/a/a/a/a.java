/*
 * Decompiled with CFR 0.139.
 */
package b.a.a.a;

import b.a.c.b;
import b.a.d.e;
import b.a.h;
import java.util.concurrent.Callable;

public final class a {
    private static volatile e<Callable<h>, h> a;
    private static volatile e<h, h> b;

    static h a(e<Callable<h>, h> object, Callable<h> callable) {
        if ((object = a.a(object, callable)) != null) {
            return object;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    public static h a(h h2) {
        if (h2 != null) {
            e<h, h> e2 = b;
            if (e2 == null) {
                return h2;
            }
            return a.a(e2, h2);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static h a(Callable<h> callable) {
        if (callable != null) {
            e<Callable<h>, h> e2 = a;
            if (e2 == null) {
                return a.b(callable);
            }
            return a.a(e2, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    static <T, R> R a(e<T, R> e2, T t2) {
        try {
            e2 = e2.a(t2);
        }
        catch (Throwable throwable) {
            throw b.a(throwable);
        }
        return (R)e2;
    }

    static h b(Callable<h> object) {
        block3 : {
            try {
                object = object.call();
                if (object == null) break block3;
                return object;
            }
            catch (Throwable throwable) {
                throw b.a(throwable);
            }
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }
}

