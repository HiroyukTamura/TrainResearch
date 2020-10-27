package p078g.p079a.p099y;

/* renamed from: g.a.y.b */
public final class C1735b extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1735b(Throwable th) {
        super("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + th, th == null ? new NullPointerException() : th);
    }
}
