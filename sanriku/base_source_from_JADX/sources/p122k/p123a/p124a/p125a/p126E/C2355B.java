package p122k.p123a.p124a.p125a.p126E;

import p009e.p028d.p030b.p054b.C1532a;
import p122k.p123a.p124a.p125a.C2466o;

/* renamed from: k.a.a.a.E.B */
public final class C2355B implements C2421w {

    /* renamed from: a */
    private final int f3828a;

    /* renamed from: b */
    private final C2421w f3829b;

    public C2355B(int i, C2421w wVar) {
        this.f3828a = i;
        this.f3829b = wVar;
    }

    /* renamed from: a */
    public void mo34036a(C2466o oVar) {
        this.f3829b.mo34036a(oVar);
    }

    /* renamed from: a */
    public boolean mo34037a() {
        return true;
    }

    /* renamed from: b */
    public C2421w mo34040b() {
        return this.f3829b;
    }

    /* renamed from: c */
    public int mo34041c() {
        return this.f3828a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2355B)) {
            return false;
        }
        C2355B b = (C2355B) obj;
        return this.f3828a == b.f3828a && this.f3829b.equals(b.f3829b);
    }

    public int hashCode() {
        return C1532a.m2119a(C1532a.m2120a(C1532a.m2145b(0, this.f3828a), (Object) this.f3829b), 2);
    }
}
