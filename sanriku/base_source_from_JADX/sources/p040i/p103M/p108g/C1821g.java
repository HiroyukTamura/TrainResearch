package p040i.p103M.p108g;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C1744A;
import p040i.C1755F;
import p040i.C1758I;
import p040i.C1934k;
import p040i.p103M.p107f.C1795c;
import p040i.p103M.p107f.C1799e;

/* renamed from: i.M.g.g */
public final class C1821g implements C1744A.C1745a {

    /* renamed from: a */
    private int f2426a;

    /* renamed from: b */
    private final C1799e f2427b;

    /* renamed from: c */
    private final List<C1744A> f2428c;

    /* renamed from: d */
    private final int f2429d;

    /* renamed from: e */
    private final C1795c f2430e;

    /* renamed from: f */
    private final C1755F f2431f;

    /* renamed from: g */
    private final int f2432g;

    /* renamed from: h */
    private final int f2433h;

    /* renamed from: i */
    private final int f2434i;

    public C1821g(C1799e eVar, List<? extends C1744A> list, int i, C1795c cVar, C1755F f, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(list, "interceptors");
        Intrinsics.checkParameterIsNotNull(f, "request");
        this.f2427b = eVar;
        this.f2428c = list;
        this.f2429d = i;
        this.f2430e = cVar;
        this.f2431f = f;
        this.f2432g = i2;
        this.f2433h = i3;
        this.f2434i = i4;
    }

    /* renamed from: a */
    public static /* synthetic */ C1821g m2876a(C1821g gVar, int i, C1795c cVar, C1755F f, int i2, int i3, int i4, int i5) {
        C1821g gVar2 = gVar;
        int i6 = (i5 & 1) != 0 ? gVar2.f2429d : i;
        C1795c cVar2 = (i5 & 2) != 0 ? gVar2.f2430e : cVar;
        C1755F f2 = (i5 & 4) != 0 ? gVar2.f2431f : f;
        int i7 = (i5 & 8) != 0 ? gVar2.f2432g : i2;
        int i8 = (i5 & 16) != 0 ? gVar2.f2433h : i3;
        int i9 = (i5 & 32) != 0 ? gVar2.f2434i : i4;
        if (gVar2 != null) {
            Intrinsics.checkParameterIsNotNull(f2, "request");
            return new C1821g(gVar2.f2427b, gVar2.f2428c, i6, cVar2, f2, i7, i8, i9);
        }
        throw null;
    }

    /* renamed from: a */
    public C1758I mo27450a(C1755F f) throws IOException {
        Intrinsics.checkParameterIsNotNull(f, "request");
        boolean z = false;
        if (this.f2429d < this.f2428c.size()) {
            this.f2426a++;
            C1795c cVar = this.f2430e;
            if (cVar != null) {
                if (cVar.mo27696h().mo27706a(f.mo27542g())) {
                    if (!(this.f2426a == 1)) {
                        StringBuilder a = C0681a.m330a("network interceptor ");
                        a.append(this.f2428c.get(this.f2429d - 1));
                        a.append(" must call proceed() exactly once");
                        throw new IllegalStateException(a.toString().toString());
                    }
                } else {
                    StringBuilder a2 = C0681a.m330a("network interceptor ");
                    a2.append(this.f2428c.get(this.f2429d - 1));
                    a2.append(" must retain the same host and port");
                    throw new IllegalStateException(a2.toString().toString());
                }
            }
            C1821g a3 = m2876a(this, this.f2429d + 1, (C1795c) null, f, 0, 0, 0, 58);
            C1744A a4 = this.f2428c.get(this.f2429d);
            C1758I intercept = a4.intercept(a3);
            if (intercept != null) {
                if (this.f2430e != null) {
                    if (!(this.f2429d + 1 >= this.f2428c.size() || a3.f2426a == 1)) {
                        throw new IllegalStateException(("network interceptor " + a4 + " must call proceed() exactly once").toString());
                    }
                }
                if (intercept.mo27554d() != null) {
                    z = true;
                }
                if (z) {
                    return intercept;
                }
                throw new IllegalStateException(("interceptor " + a4 + " returned a response with no body").toString());
            }
            throw new NullPointerException("interceptor " + a4 + " returned null");
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: a */
    public C1934k mo27451a() {
        C1795c cVar = this.f2430e;
        if (cVar != null) {
            return cVar.mo27694f();
        }
        return null;
    }

    /* renamed from: b */
    public final C1799e mo27790b() {
        return this.f2427b;
    }

    /* renamed from: c */
    public final int mo27791c() {
        return this.f2432g;
    }

    /* renamed from: d */
    public final C1795c mo27792d() {
        return this.f2430e;
    }

    /* renamed from: e */
    public final int mo27793e() {
        return this.f2433h;
    }

    /* renamed from: f */
    public final C1755F mo27794f() {
        return this.f2431f;
    }

    /* renamed from: g */
    public final int mo27795g() {
        return this.f2434i;
    }

    /* renamed from: h */
    public int mo27796h() {
        return this.f2433h;
    }

    public C1755F request() {
        return this.f2431f;
    }
}
