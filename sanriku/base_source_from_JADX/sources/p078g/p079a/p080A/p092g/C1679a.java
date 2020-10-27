package p078g.p079a.p080A.p092g;

/* renamed from: g.a.A.g.a */
public final class C1679a {

    /* renamed from: g.a.A.g.a$a */
    static final class C1680a extends Throwable {
        C1680a() {
            super("No further exceptions");
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

    static {
        new C1680a();
    }

    /* renamed from: a */
    public static RuntimeException m2365a(Throwable th) {
        if (!(th instanceof Error)) {
            return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
        }
        throw ((Error) th);
    }
}
