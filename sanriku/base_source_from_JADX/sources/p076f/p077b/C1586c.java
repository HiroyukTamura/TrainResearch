package p076f.p077b;

import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: f.b.c */
public final class C1586c<T> implements C1585b<T> {

    /* renamed from: a */
    private final T f1857a;

    static {
        new C1586c((Object) null);
    }

    private C1586c(T t) {
        this.f1857a = t;
    }

    /* renamed from: a */
    public static <T> C1585b<T> m2214a(T t) {
        C1532a.m2125a(t, "instance cannot be null");
        return new C1586c(t);
    }

    public T get() {
        return this.f1857a;
    }
}
