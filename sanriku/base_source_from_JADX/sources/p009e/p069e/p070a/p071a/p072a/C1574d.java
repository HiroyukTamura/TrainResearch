package p009e.p069e.p070a.p071a.p072a;

import retrofit2.Response;

/* renamed from: e.e.a.a.a.d */
public final class C1574d<T> {
    private C1574d(Response<T> response, Throwable th) {
    }

    /* renamed from: a */
    public static <T> C1574d<T> m2203a(Throwable th) {
        if (th != null) {
            return new C1574d<>((Response) null, th);
        }
        throw new NullPointerException("error == null");
    }

    /* renamed from: a */
    public static <T> C1574d<T> m2204a(Response<T> response) {
        if (response != null) {
            return new C1574d<>(response, (Throwable) null);
        }
        throw new NullPointerException("response == null");
    }
}
