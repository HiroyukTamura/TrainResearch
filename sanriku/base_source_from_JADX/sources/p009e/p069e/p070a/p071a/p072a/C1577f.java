package p009e.p069e.p070a.p071a.p072a;

import java.lang.reflect.Type;
import p078g.p079a.C1711q;
import retrofit2.CallAdapter;

/* renamed from: e.e.a.a.a.f */
final class C1577f implements CallAdapter<Object> {

    /* renamed from: a */
    private final Type f1841a;

    /* renamed from: b */
    private final C1711q f1842b;

    /* renamed from: c */
    private final boolean f1843c;

    /* renamed from: d */
    private final boolean f1844d;

    /* renamed from: e */
    private final boolean f1845e;

    /* renamed from: f */
    private final boolean f1846f;

    /* renamed from: g */
    private final boolean f1847g;

    /* renamed from: h */
    private final boolean f1848h;

    C1577f(Type type, C1711q qVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f1841a = type;
        this.f1842b = qVar;
        this.f1843c = z;
        this.f1844d = z2;
        this.f1845e = z3;
        this.f1846f = z4;
        this.f1847g = z5;
        this.f1848h = z6;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <R> java.lang.Object adapt(retrofit2.Call<R> r3) {
        /*
            r2 = this;
            e.e.a.a.a.b r0 = new e.e.a.a.a.b
            r0.<init>(r3)
            boolean r3 = r2.f1843c
            if (r3 == 0) goto L_0x0010
            e.e.a.a.a.e r3 = new e.e.a.a.a.e
            r3.<init>(r0)
        L_0x000e:
            r0 = r3
            goto L_0x001a
        L_0x0010:
            boolean r3 = r2.f1844d
            if (r3 == 0) goto L_0x001a
            e.e.a.a.a.a r3 = new e.e.a.a.a.a
            r3.<init>(r0)
            goto L_0x000e
        L_0x001a:
            g.a.q r3 = r2.f1842b
            if (r3 == 0) goto L_0x0029
            java.lang.String r1 = "scheduler is null"
            p078g.p079a.p080A.p082b.C1599b.m2241a(r3, (java.lang.String) r1)
            g.a.A.e.d.h r1 = new g.a.A.e.d.h
            r1.<init>(r0, r3)
            r0 = r1
        L_0x0029:
            boolean r3 = r2.f1845e
            if (r3 == 0) goto L_0x0034
            g.a.a r3 = p078g.p079a.C1695a.LATEST
            g.a.g r3 = r0.mo27426a((p078g.p079a.C1695a) r3)
            return r3
        L_0x0034:
            boolean r3 = r2.f1846f
            if (r3 == 0) goto L_0x003f
            g.a.A.e.d.g r3 = new g.a.A.e.d.g
            r1 = 0
            r3.<init>(r0, r1)
            return r3
        L_0x003f:
            boolean r3 = r2.f1847g
            if (r3 == 0) goto L_0x0049
            g.a.A.e.d.f r3 = new g.a.A.e.d.f
            r3.<init>(r0)
            return r3
        L_0x0049:
            boolean r3 = r2.f1848h
            if (r3 == 0) goto L_0x0053
            g.a.A.e.d.d r3 = new g.a.A.e.d.d
            r3.<init>(r0)
            return r3
        L_0x0053:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p009e.p069e.p070a.p071a.p072a.C1577f.adapt(retrofit2.Call):java.lang.Object");
    }

    public Type responseType() {
        return this.f1841a;
    }
}
