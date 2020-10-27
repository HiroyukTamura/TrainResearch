package p078g.p079a.p080A.p082b;

import p078g.p079a.p100z.C1740c;

/* renamed from: g.a.A.b.b */
public final class C1599b {

    /* renamed from: a */
    static final C1740c<Object, Object> f1869a = new C1600a();

    /* renamed from: g.a.A.b.b$a */
    static final class C1600a implements C1740c<Object, Object> {
        C1600a() {
        }

        /* renamed from: a */
        public boolean mo27357a(Object obj, Object obj2) {
            return obj == obj2 || (obj != null && obj.equals(obj2));
        }
    }

    /* renamed from: a */
    public static int m2238a(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }

    /* renamed from: a */
    public static int m2239a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    /* renamed from: a */
    public static <T> C1740c<T, T> m2240a() {
        return f1869a;
    }

    /* renamed from: a */
    public static <T> T m2241a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
