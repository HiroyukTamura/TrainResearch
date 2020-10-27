package p122k.p123a.p124a.p125a.p126E;

import p009e.p028d.p030b.p054b.C1532a;
import p122k.p123a.p124a.p125a.C2466o;

/* renamed from: k.a.a.a.E.A */
public final class C2354A implements C2421w {

    /* renamed from: a */
    private final int f3826a;

    /* renamed from: b */
    private final int f3827b;

    public C2354A(int i, int i2) {
        this.f3826a = i;
        this.f3827b = i2;
    }

    /* renamed from: a */
    public void mo34036a(C2466o oVar) {
        if (oVar == null) {
            throw null;
        }
    }

    /* renamed from: a */
    public boolean mo34037a() {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2354A)) {
            return false;
        }
        C2354A a = (C2354A) obj;
        return this.f3826a == a.f3826a && this.f3827b == a.f3827b;
    }

    public int hashCode() {
        C2423y yVar = C2423y.CUSTOM;
        return C1532a.m2119a(C1532a.m2145b(C1532a.m2145b(C1532a.m2145b(0, 1), this.f3826a), this.f3827b), 3);
    }
}
