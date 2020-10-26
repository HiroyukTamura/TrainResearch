/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.i;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.impl.l.k;
import kotlin.w;

public class b
implements kotlin.reflect.jvm.internal.impl.i.i {
    public static final kotlin.reflect.jvm.internal.impl.i.i a;
    static final /* synthetic */ boolean c;
    private static final String d;
    protected final Lock b;
    private final c e;
    private final String f;

    static {
        c = b.class.desiredAssertionStatus() ^ true;
        d = n.c(b.class.getCanonicalName(), ".", "");
        a = new b("NO_LOCKS", c.a, kotlin.reflect.jvm.internal.impl.i.e.a){

            @Override
            protected <T> j<T> a() {
                return j.a();
            }
        };
    }

    public b() {
        this(b.c(), c.a, new ReentrantLock());
    }

    private b(String string2, c c2, Lock lock) {
        this.b = lock;
        this.e = c2;
        this.f = string2;
    }

    private static <T extends Throwable> T b(T t2) {
        int n2;
        Object object;
        int n3;
        block3 : {
            object = ((Throwable)t2).getStackTrace();
            n3 = ((StackTraceElement[])object).length;
            for (n2 = 0; n2 < n3; ++n2) {
                if (object[n2].getClassName().startsWith(d)) {
                    continue;
                }
                break block3;
            }
            n2 = -1;
        }
        if (!c && n2 < 0) {
            throw new AssertionError((Object)"This method should only be called on exceptions created in LockBasedStorageManager");
        }
        object = Arrays.asList(object).subList(n2, n3);
        ((Throwable)t2).setStackTrace(object.toArray(new StackTraceElement[object.size()]));
        return t2;
    }

    private static String c() {
        return "<unknown creating class>";
    }

    private static <K> ConcurrentMap<K, Object> d() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    protected <T> j<T> a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Recursive call in a lazy value under ");
        stringBuilder.append(this);
        throw b.b(new IllegalStateException(stringBuilder.toString()));
    }

    @Override
    public <K, V> kotlin.reflect.jvm.internal.impl.i.c<K, V> a(kotlin.e.a.b<? super K, ? extends V> b2) {
        return this.a(b2, b.<K>d());
    }

    public <K, V> kotlin.reflect.jvm.internal.impl.i.c<K, V> a(kotlin.e.a.b<? super K, ? extends V> b2, ConcurrentMap<K, Object> concurrentMap) {
        return new h<K, V>(this, concurrentMap, b2);
    }

    @Override
    public <T> kotlin.reflect.jvm.internal.impl.i.f<T> a(kotlin.e.a.a<? extends T> a2) {
        return new f<T>(this, a2);
    }

    @Override
    public <T> kotlin.reflect.jvm.internal.impl.i.f<T> a(kotlin.e.a.a<? extends T> a2, final T t2) {
        return new f<T>(this, a2){

            @Override
            protected j<T> a(boolean bl2) {
                return j.a(t2);
            }
        };
    }

    @Override
    public <T> kotlin.reflect.jvm.internal.impl.i.f<T> a(kotlin.e.a.a<? extends T> a2, final kotlin.e.a.b<? super Boolean, ? extends T> b2, final kotlin.e.a.b<? super T, w> b3) {
        return new f<T>(this, a2){

            @Override
            protected j<T> a(boolean bl2) {
                if (b2 == null) {
                    return super.a(bl2);
                }
                return j.a(b2.a(bl2));
            }

            @Override
            protected void a(T t2) {
                b3.a(t2);
            }
        };
    }

    @Override
    public <K, V> kotlin.reflect.jvm.internal.impl.i.a<K, V> b() {
        return new a(this, b.<K>d());
    }

    @Override
    public <K, V> kotlin.reflect.jvm.internal.impl.i.d<K, V> b(kotlin.e.a.b<? super K, ? extends V> b2) {
        return this.b(b2, b.<K>d());
    }

    public <K, V> kotlin.reflect.jvm.internal.impl.i.d<K, V> b(kotlin.e.a.b<? super K, ? extends V> b2, ConcurrentMap<K, Object> concurrentMap) {
        return new g<K, V>(this, concurrentMap, b2);
    }

    @Override
    public <T> kotlin.reflect.jvm.internal.impl.i.g<T> b(kotlin.e.a.a<? extends T> a2) {
        return new e<T>(this, a2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(this.hashCode()));
        stringBuilder.append(" (");
        stringBuilder.append(this.f);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private static class a<K, V>
    extends b<K, V>
    implements kotlin.reflect.jvm.internal.impl.i.a<K, V> {
        static final /* synthetic */ boolean a;

        static {
            a = b.class.desiredAssertionStatus() ^ true;
        }

        private a(b b2, ConcurrentMap<d<K, V>, Object> concurrentMap) {
            super(b2, concurrentMap);
        }

        @Override
        public V a(K object, kotlin.e.a.a<? extends V> a2) {
            object = super.a(object, a2);
            if (!a) {
                if (object != null) {
                    return (V)object;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("computeIfAbsent() returned null under ");
                ((StringBuilder)object).append(this.a());
                throw new AssertionError((Object)((StringBuilder)object).toString());
            }
            return (V)object;
        }
    }

    private static class b<K, V>
    extends g<d<K, V>, V> {
        private b(b b2, ConcurrentMap<d<K, V>, Object> concurrentMap) {
            super(b2, concurrentMap, new kotlin.e.a.b<d<K, V>, V>(){

                @Override
                public V a(d<K, V> d2) {
                    return (V)d2.b.a();
                }
            });
        }

        public V a(K k2, kotlin.e.a.a<? extends V> a2) {
            return this.a(new d<K, V>(k2, a2));
        }

    }

    public static interface c {
        public static final c a = new c(){

            @Override
            public RuntimeException a(Throwable throwable) {
                throw kotlin.reflect.jvm.internal.impl.l.c.a(throwable);
            }
        };

        public RuntimeException a(Throwable var1);

    }

    private static class d<K, V> {
        private final K a;
        private final kotlin.e.a.a<? extends V> b;

        public d(K k2, kotlin.e.a.a<? extends V> a2) {
            this.a = k2;
            this.b = a2;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object != null) {
                if (this.getClass() != object.getClass()) {
                    return false;
                }
                object = (d)object;
                return this.a.equals(((d)object).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    private static class e<T>
    implements kotlin.reflect.jvm.internal.impl.i.g<T> {
        private final b a;
        private final kotlin.e.a.a<? extends T> b;
        private volatile Object c = i.a;

        public e(b b2, kotlin.e.a.a<? extends T> a2) {
            this.a = b2;
            this.b = a2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public T a() {
            Object object = this.c;
            if (!(object instanceof i)) {
                return (T)k.d(object);
            }
            this.a.b.lock();
            try {
                object = this.c;
                if (!(object instanceof i)) {
                    object = k.d(object);
                    return (T)object;
                }
                if (object == i.b) {
                    this.c = i.c;
                    j<T> j2 = this.a(true);
                    if (!j2.c()) {
                        object = j2.b();
                        return (T)object;
                    }
                }
                if (object == i.c && !((j)(object = this.a(false))).c()) {
                    object = ((j)object).b();
                    return (T)object;
                }
                this.c = i.b;
                try {
                    this.c = object = this.b.a();
                    this.a(object);
                    return (T)object;
                }
                catch (Throwable throwable) {
                    if (!kotlin.reflect.jvm.internal.impl.l.c.b(throwable)) {
                        if (this.c != i.b) throw this.a.e.a(throwable);
                        this.c = k.a(throwable);
                        throw this.a.e.a(throwable);
                    }
                    this.c = i.a;
                    throw (RuntimeException)throwable;
                }
            }
            finally {
                this.a.b.unlock();
            }
        }

        protected j<T> a(boolean bl2) {
            return this.a.a();
        }

        protected void a(T t2) {
        }

        public boolean b() {
            return this.c != i.a && this.c != i.b;
        }
    }

    private static class f<T>
    extends e<T>
    implements kotlin.reflect.jvm.internal.impl.i.f<T> {
        static final /* synthetic */ boolean d;

        static {
            d = b.class.desiredAssertionStatus() ^ true;
        }

        public f(b b2, kotlin.e.a.a<? extends T> a2) {
            super(b2, a2);
        }

        @Override
        public T a() {
            Object t2 = super.a();
            if (!d) {
                if (t2 != null) {
                    return t2;
                }
                throw new AssertionError((Object)"compute() returned null");
            }
            return t2;
        }
    }

    private static class g<K, V>
    implements kotlin.reflect.jvm.internal.impl.i.d<K, V> {
        private final b a;
        private final ConcurrentMap<K, Object> b;
        private final kotlin.e.a.b<? super K, ? extends V> c;

        public g(b b2, ConcurrentMap<K, Object> concurrentMap, kotlin.e.a.b<? super K, ? extends V> b3) {
            this.a = b2;
            this.b = concurrentMap;
            this.c = b3;
        }

        private AssertionError a(K k2, Object object) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Race condition detected on input ");
            stringBuilder.append(k2);
            stringBuilder.append(". Old value is ");
            stringBuilder.append(object);
            stringBuilder.append(" under ");
            stringBuilder.append(this.a);
            return (AssertionError)((Object)b.b((Throwable)((Object)new AssertionError((Object)stringBuilder.toString()))));
        }

        private AssertionError b(K k2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Recursion detected on input: ");
            stringBuilder.append(k2);
            stringBuilder.append(" under ");
            stringBuilder.append(this.a);
            return (AssertionError)((Object)b.b((Throwable)((Object)new AssertionError((Object)stringBuilder.toString()))));
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        @Override
        public V a(K var1_1) {
            block12 : {
                block11 : {
                    block10 : {
                        var2_4 = this.b.get(var1_1 /* !! */ );
                        if (var2_4 != null && var2_4 != i.b) {
                            return k.c(var2_4);
                        }
                        this.a.b.lock();
                        try {
                            var2_4 = this.b.get(var1_1 /* !! */ );
                            if (var2_4 == i.b) throw this.b(var1_1 /* !! */ );
                            if (var2_4 == null) break block10;
                            var1_2 = k.c(var2_4);
                            this.a.b.unlock();
                        }
                        catch (Throwable var1_3) {
                            this.a.b.unlock();
                            throw var1_3;
                        }
                        return var1_2;
                    }
                    var3_8 = null;
                    this.b.put(var1_1 /* !! */ , (Object)i.b);
                    var2_4 = this.c.a(var1_1 /* !! */ );
                    var4_9 = this.b.put(var1_1 /* !! */ , k.b(var2_4));
                    var5_10 = i.b;
                    if (var4_9 != var5_10) break block11;
                    this.a.b.unlock();
                    return var2_4;
                }
                var4_9 = this.a(var1_1 /* !! */ , var4_9);
                try {
                    throw var4_9;
                }
                catch (Throwable var2_5) {
                    var3_8 = var4_9;
                    break block12;
                }
                catch (Throwable var2_6) {
                    // empty catch block
                }
            }
            if (kotlin.reflect.jvm.internal.impl.l.c.b((Throwable)var2_7)) ** GOTO lbl43
            if (var2_7 == var3_8) throw b.a(this.a).a((Throwable)var2_7);
            var3_8 = this.b.put(var1_1 /* !! */ , k.a((Throwable)var2_7));
            if (var3_8 == i.b) throw b.a(this.a).a((Throwable)var2_7);
            throw this.a(var1_1 /* !! */ , var3_8);
lbl43: // 1 sources:
            this.b.remove(var1_1 /* !! */ );
            throw (RuntimeException)var2_7;
        }

        protected b a() {
            return this.a;
        }
    }

    private static class h<K, V>
    extends g<K, V>
    implements kotlin.reflect.jvm.internal.impl.i.c<K, V> {
        static final /* synthetic */ boolean a;

        static {
            a = b.class.desiredAssertionStatus() ^ true;
        }

        public h(b b2, ConcurrentMap<K, Object> concurrentMap, kotlin.e.a.b<? super K, ? extends V> b3) {
            super(b2, concurrentMap, b3);
        }

        @Override
        public V a(K object) {
            object = super.a(object);
            if (!a) {
                if (object != null) {
                    return (V)object;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("compute() returned null under ");
                ((StringBuilder)object).append(this.a());
                throw new AssertionError((Object)((StringBuilder)object).toString());
            }
            return (V)object;
        }
    }

    private static enum i {
        a,
        b,
        c;
        
    }

    private static class j<T> {
        static final /* synthetic */ boolean a;
        private final T b;
        private final boolean c;

        static {
            a = b.class.desiredAssertionStatus() ^ true;
        }

        private j(T t2, boolean bl2) {
            this.b = t2;
            this.c = bl2;
        }

        public static <T> j<T> a() {
            return new j<Object>(null, true);
        }

        public static <T> j<T> a(T t2) {
            return new j<T>(t2, false);
        }

        public T b() {
            if (!a && this.c) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("A value requested from FALL_THROUGH in ");
                stringBuilder.append(this);
                throw new AssertionError((Object)stringBuilder.toString());
            }
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        public String toString() {
            if (this.c()) {
                return "FALL_THROUGH";
            }
            return String.valueOf(this.b);
        }
    }

}

