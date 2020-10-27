package p009e.p015c.p016a.p017a.p018a.p020o;

import p009e.p015c.p016a.p017a.p018a.C0708l;

/* renamed from: e.c.a.a.a.o.a */
public class C0718a<S extends C0708l<?, ?>> {

    /* renamed from: a */
    private final S f407a;

    /* renamed from: e.c.a.a.a.o.a$a */
    public enum C0719a {
        INSERT,
        UPDATE,
        DELETE,
        TRANSACTION;

        static {
            INSERT = new C0719a("INSERT", 0);
            UPDATE = new C0719a("UPDATE", 1);
            DELETE = new C0719a("DELETE", 2);
            TRANSACTION = new C0719a("TRANSACTION", 3);
        }
    }

    public C0718a(C0719a aVar, S s) {
        this.f407a = s;
    }

    /* renamed from: a */
    public S mo19927a() {
        return this.f407a;
    }
}
