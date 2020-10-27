package p122k.p123a.p124a.p125a.p126E;

import java.util.IdentityHashMap;
import java.util.UUID;
import p122k.p123a.p124a.p125a.p127F.C2428d;

/* renamed from: k.a.a.a.E.f */
public abstract class C2400f {

    /* renamed from: c */
    public static final C2428d f3911c;

    /* renamed from: a */
    public final C2387a f3912a;

    /* renamed from: b */
    protected final C2372S f3913b;

    static {
        int i = C2398e.f3904b;
        UUID uuid = C2398e.f3909g;
        C2428d dVar = new C2428d(new C2391c(true));
        f3911c = dVar;
        dVar.f3968a = Integer.MAX_VALUE;
    }

    public C2400f(C2387a aVar, C2372S s) {
        this.f3912a = aVar;
        this.f3913b = s;
    }

    /* renamed from: a */
    public C2371Q mo34152a(C2371Q q) {
        C2371Q a;
        C2372S s = this.f3913b;
        if (s == null) {
            return q;
        }
        synchronized (s) {
            a = C2371Q.m3998a(q, this.f3913b, new IdentityHashMap());
        }
        return a;
    }

    /* renamed from: a */
    public abstract void mo34076a();
}
