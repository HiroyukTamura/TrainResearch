/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  javax.annotation.Nullable
 *  org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
 */
package f;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import f.c;
import f.f;
import f.g;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

class k {
    private static final k a = k.c();

    k() {
    }

    static k a() {
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static k c() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new a();
            }
        }
        catch (ClassNotFoundException classNotFoundException) {}
        try {
            Class.forName("java.util.Optional");
            return new b();
        }
        catch (ClassNotFoundException classNotFoundException) {
            return new k();
        }
    }

    c.a a(@Nullable Executor executor) {
        if (executor != null) {
            return new g(executor);
        }
        return f.a;
    }

    @Nullable
    /* varargs */ Object a(Method method, Class<?> class_, Object object, @Nullable Object ... arrobject) {
        throw new UnsupportedOperationException();
    }

    boolean a(Method method) {
        return false;
    }

    @Nullable
    Executor b() {
        return null;
    }

    static class f.k$a
    extends k {
        f.k$a() {
        }

        @Override
        c.a a(@Nullable Executor executor) {
            if (executor != null) {
                return new g(executor);
            }
            throw new AssertionError();
        }

        @Override
        public Executor b() {
            return new a();
        }

        static class a
        implements Executor {
            private final Handler a = new Handler(Looper.getMainLooper());

            a() {
            }

            @Override
            public void execute(Runnable runnable) {
                this.a.post(runnable);
            }
        }

    }

    @IgnoreJRERequirement
    static class b
    extends k {
        b() {
        }

        @Override
        /* varargs */ Object a(Method method, Class<?> class_, Object object, @Nullable Object ... arrobject) {
            Constructor constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            constructor.setAccessible(true);
            return ((MethodHandles.Lookup)constructor.newInstance(class_, -1)).unreflectSpecial(method, class_).bindTo(object).invokeWithArguments(arrobject);
        }

        @Override
        boolean a(Method method) {
            return method.isDefault();
        }
    }

}

