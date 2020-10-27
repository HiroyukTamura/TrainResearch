package p009e.p028d.p030b.p031a.p032i.p035u.p036h;

import android.content.Context;
import p076f.p077b.C1585b;
import p101h.p102a.C1743a;

/* renamed from: e.d.b.a.i.u.h.H */
public final class C0935H implements C1585b<C0933G> {

    /* renamed from: a */
    private final C1743a<Context> f644a;

    /* renamed from: b */
    private final C1743a<String> f645b;

    /* renamed from: c */
    private final C1743a<Integer> f646c;

    public C0935H(C1743a<Context> aVar, C1743a<String> aVar2, C1743a<Integer> aVar3) {
        this.f644a = aVar;
        this.f645b = aVar2;
        this.f646c = aVar3;
    }

    public Object get() {
        return new C0933G(this.f644a.get(), this.f645b.get(), this.f646c.get().intValue());
    }
}
