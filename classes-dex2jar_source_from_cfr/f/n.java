/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package f;

import c.ab;
import c.ad;
import c.e;
import c.t;
import c.x;
import f.a;
import f.b;
import f.c;
import f.e;
import f.i;
import f.k;
import f.o;
import f.p;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public final class n {
    final e.a a;
    final t b;
    final List<e.a> c;
    final List<c.a> d;
    @Nullable
    final Executor e;
    final boolean f;
    private final Map<Method, o<?, ?>> g = new ConcurrentHashMap();

    n(e.a a2, t t2, List<e.a> list, List<c.a> list2, @Nullable Executor executor, boolean bl2) {
        this.a = a2;
        this.b = t2;
        this.c = list;
        this.d = list2;
        this.e = executor;
        this.f = bl2;
    }

    private void b(Class<?> arrmethod) {
        k k2 = k.a();
        for (Method method : arrmethod.getDeclaredMethods()) {
            if (k2.a(method)) continue;
            this.a(method);
        }
    }

    public e.a a() {
        return this.a;
    }

    public c<?, ?> a(@Nullable c.a a2, Type type, Annotation[] object) {
        int n2;
        p.a(type, "returnType == null");
        p.a(object, "annotations == null");
        int n3 = this.d.indexOf(a2) + 1;
        int n4 = this.d.size();
        for (n2 = n3; n2 < n4; ++n2) {
            c<?, ?> c2 = this.d.get(n2).a(type, (Annotation[])object, this);
            if (c2 == null) continue;
            return c2;
        }
        object = new StringBuilder("Could not locate call adapter for ");
        ((StringBuilder)object).append(type);
        ((StringBuilder)object).append(".\n");
        if (a2 != null) {
            ((StringBuilder)object).append("  Skipped:");
            for (n2 = 0; n2 < n3; ++n2) {
                ((StringBuilder)object).append("\n   * ");
                ((StringBuilder)object).append(this.d.get(n2).getClass().getName());
            }
            ((StringBuilder)object).append('\n');
        }
        ((StringBuilder)object).append("  Tried:");
        n2 = this.d.size();
        while (n3 < n2) {
            ((StringBuilder)object).append("\n   * ");
            ((StringBuilder)object).append(this.d.get(n3).getClass().getName());
            ++n3;
        }
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public c<?, ?> a(Type type, Annotation[] arrannotation) {
        return this.a((c.a)null, type, arrannotation);
    }

    public <T> e<ad, T> a(@Nullable e.a a2, Type type, Annotation[] object) {
        int n2;
        p.a(type, "type == null");
        p.a(object, "annotations == null");
        int n3 = this.c.indexOf(a2) + 1;
        int n4 = this.c.size();
        for (n2 = n3; n2 < n4; ++n2) {
            e<ad, ?> e2 = this.c.get(n2).a(type, (Annotation[])object, this);
            if (e2 == null) continue;
            return e2;
        }
        object = new StringBuilder("Could not locate ResponseBody converter for ");
        ((StringBuilder)object).append(type);
        ((StringBuilder)object).append(".\n");
        if (a2 != null) {
            ((StringBuilder)object).append("  Skipped:");
            for (n2 = 0; n2 < n3; ++n2) {
                ((StringBuilder)object).append("\n   * ");
                ((StringBuilder)object).append(this.c.get(n2).getClass().getName());
            }
            ((StringBuilder)object).append('\n');
        }
        ((StringBuilder)object).append("  Tried:");
        n2 = this.c.size();
        while (n3 < n2) {
            ((StringBuilder)object).append("\n   * ");
            ((StringBuilder)object).append(this.c.get(n3).getClass().getName());
            ++n3;
        }
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public <T> e<T, ab> a(@Nullable e.a a2, Type type, Annotation[] object, Annotation[] arrannotation) {
        int n2;
        p.a(type, "type == null");
        p.a(object, "parameterAnnotations == null");
        p.a(arrannotation, "methodAnnotations == null");
        int n3 = this.c.indexOf(a2) + 1;
        int n4 = this.c.size();
        for (n2 = n3; n2 < n4; ++n2) {
            e<?, ab> e2 = this.c.get(n2).a(type, (Annotation[])object, arrannotation, this);
            if (e2 == null) continue;
            return e2;
        }
        object = new StringBuilder("Could not locate RequestBody converter for ");
        ((StringBuilder)object).append(type);
        ((StringBuilder)object).append(".\n");
        if (a2 != null) {
            ((StringBuilder)object).append("  Skipped:");
            for (n2 = 0; n2 < n3; ++n2) {
                ((StringBuilder)object).append("\n   * ");
                ((StringBuilder)object).append(this.c.get(n2).getClass().getName());
            }
            ((StringBuilder)object).append('\n');
        }
        ((StringBuilder)object).append("  Tried:");
        n2 = this.c.size();
        while (n3 < n2) {
            ((StringBuilder)object).append("\n   * ");
            ((StringBuilder)object).append(this.c.get(n3).getClass().getName());
            ++n3;
        }
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public <T> e<T, ab> a(Type type, Annotation[] arrannotation, Annotation[] arrannotation2) {
        return this.a(null, type, arrannotation, arrannotation2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    o<?, ?> a(Method method) {
        o o2 = this.g.get(method);
        if (o2 != null) {
            return o2;
        }
        Map<Method, o<?, ?>> map = this.g;
        synchronized (map) {
            o<?, ?> o3 = this.g.get(method);
            o2 = o3;
            if (o3 == null) {
                o2 = new o.a(this, method).a();
                this.g.put(method, o2);
            }
            return o2;
        }
    }

    public <T> T a(final Class<T> class_) {
        p.a(class_);
        if (this.f) {
            this.b(class_);
        }
        ClassLoader classLoader = class_.getClassLoader();
        InvocationHandler invocationHandler = new InvocationHandler(){
            private final k c = k.a();

            @Override
            public Object invoke(Object o2, Method method, @Nullable Object[] arrobject) {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, arrobject);
                }
                if (this.c.a(method)) {
                    return this.c.a(method, class_, o2, arrobject);
                }
                o2 = n.this.a(method);
                return o2.a(new i(o2, arrobject));
            }
        };
        return (T)Proxy.newProxyInstance(classLoader, new Class[]{class_}, invocationHandler);
    }

    public t b() {
        return this.b;
    }

    public <T> e<ad, T> b(Type type, Annotation[] arrannotation) {
        return this.a((e.a)null, type, arrannotation);
    }

    public <T> e<T, String> c(Type type, Annotation[] arrannotation) {
        p.a(type, "type == null");
        p.a(arrannotation, "annotations == null");
        int n2 = this.c.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            e<?, String> e2 = this.c.get(i2).b(type, arrannotation, this);
            if (e2 == null) continue;
            return e2;
        }
        return a.d.a;
    }

    public static final class a {
        private final k a;
        @Nullable
        private e.a b;
        private t c;
        private final List<e.a> d = new ArrayList<e.a>();
        private final List<c.a> e = new ArrayList<c.a>();
        @Nullable
        private Executor f;
        private boolean g;

        public a() {
            this(k.a());
        }

        a(k k2) {
            this.a = k2;
        }

        public a a(t t2) {
            p.a(t2, "baseUrl == null");
            Object object = t2.j();
            if ("".equals(object.get(object.size() - 1))) {
                this.c = t2;
                return this;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("baseUrl must end in /: ");
            ((StringBuilder)object).append(t2);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }

        public a a(c.a a2) {
            this.e.add(p.a(a2, "factory == null"));
            return this;
        }

        public a a(e.a a2) {
            this.d.add(p.a(a2, "factory == null"));
            return this;
        }

        public a a(String string2) {
            p.a(string2, "baseUrl == null");
            Object object = t.e(string2);
            if (object != null) {
                return this.a((t)object);
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Illegal URL: ");
            ((StringBuilder)object).append(string2);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }

        public a a(Executor executor) {
            this.f = p.a(executor, "executor == null");
            return this;
        }

        public n a() {
            if (this.c != null) {
                Object object;
                Object object2 = this.b;
                e.a a2 = object2;
                if (object2 == null) {
                    a2 = new x();
                }
                object2 = object = this.f;
                if (object == null) {
                    object2 = this.a.b();
                }
                object = new ArrayList<c.a>(this.e);
                object.add(this.a.a((Executor)object2));
                ArrayList<e.a> arrayList = new ArrayList<e.a>(this.d.size() + 1);
                arrayList.add(new f.a());
                arrayList.addAll(this.d);
                return new n(a2, this.c, Collections.unmodifiableList(arrayList), Collections.unmodifiableList(object), (Executor)object2, this.g);
            }
            throw new IllegalStateException("Base URL required.");
        }
    }

}

