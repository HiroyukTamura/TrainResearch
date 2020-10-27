package p076f.p077b;

import p101h.p102a.C1743a;

/* renamed from: f.b.a */
public final class C1584a<T> implements C1743a<T> {

    /* renamed from: c */
    private static final Object f1854c = new Object();

    /* renamed from: a */
    private volatile C1743a<T> f1855a;

    /* renamed from: b */
    private volatile Object f1856b = f1854c;

    private C1584a(C1743a<T> aVar) {
        this.f1855a = aVar;
    }

    /* renamed from: a */
    public static <P extends C1743a<T>, T> C1743a<T> m2212a(P p) {
        if (p != null) {
            return p instanceof C1584a ? p : new C1584a(p);
        }
        throw null;
    }

    /* renamed from: a */
    public static Object m2213a(Object obj, Object obj2) {
        if (!(obj != f1854c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public T get() {
        T t = this.f1856b;
        if (t == f1854c) {
            synchronized (this) {
                t = this.f1856b;
                if (t == f1854c) {
                    t = this.f1855a.get();
                    m2213a(this.f1856b, t);
                    this.f1856b = t;
                    this.f1855a = null;
                }
            }
        }
        return t;
    }
}
