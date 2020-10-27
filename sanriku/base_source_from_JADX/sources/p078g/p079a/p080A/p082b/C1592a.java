package p078g.p079a.p080A.p082b;

import p009e.p010a.p011a.p012a.C0681a;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p099y.C1735b;
import p078g.p079a.p100z.C1738a;
import p078g.p079a.p100z.C1739b;
import p078g.p079a.p100z.C1741d;
import p078g.p079a.p100z.C1742e;

/* renamed from: g.a.A.b.a */
public final class C1592a {

    /* renamed from: a */
    static final C1742e<Object, Object> f1863a = new C1597e();

    /* renamed from: b */
    public static final Runnable f1864b = new C1596d();

    /* renamed from: c */
    public static final C1738a f1865c = new C1594b();

    /* renamed from: d */
    static final C1741d<Object> f1866d = new C1595c();

    /* renamed from: e */
    public static final C1741d<Throwable> f1867e = new C1598f();

    /* renamed from: g.a.A.b.a$a */
    static final class C1593a<T1, T2, R> implements C1742e<Object[], R> {

        /* renamed from: a */
        final C1739b<? super T1, ? super T2, ? extends R> f1868a;

        C1593a(C1739b<? super T1, ? super T2, ? extends R> bVar) {
            this.f1868a = bVar;
        }

        public Object apply(Object obj) throws Exception {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                return this.f1868a.apply(objArr[0], objArr[1]);
            }
            StringBuilder a = C0681a.m330a("Array of size 2 expected but got ");
            a.append(objArr.length);
            throw new IllegalArgumentException(a.toString());
        }
    }

    /* renamed from: g.a.A.b.a$b */
    static final class C1594b implements C1738a {
        C1594b() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* renamed from: g.a.A.b.a$c */
    static final class C1595c implements C1741d<Object> {
        C1595c() {
        }

        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* renamed from: g.a.A.b.a$d */
    static final class C1596d implements Runnable {
        C1596d() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* renamed from: g.a.A.b.a$e */
    static final class C1597e implements C1742e<Object, Object> {
        C1597e() {
        }

        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* renamed from: g.a.A.b.a$f */
    static final class C1598f implements C1741d<Throwable> {
        C1598f() {
        }

        public void accept(Object obj) throws Exception {
            C1682a.m2372a((Throwable) new C1735b((Throwable) obj));
        }
    }

    /* renamed from: a */
    public static <T> C1741d<T> m2235a() {
        return f1866d;
    }

    /* renamed from: a */
    public static <T1, T2, R> C1742e<Object[], R> m2236a(C1739b<? super T1, ? super T2, ? extends R> bVar) {
        C1599b.m2241a(bVar, "f is null");
        return new C1593a(bVar);
    }

    /* renamed from: b */
    public static <T> C1742e<T, T> m2237b() {
        return f1863a;
    }
}
