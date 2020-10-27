package p122k.p123a.p124a.p125a.p126E;

import p009e.p028d.p030b.p054b.C1532a;
import p122k.p123a.p124a.p125a.C2466o;

/* renamed from: k.a.a.a.E.C */
public final class C2356C implements C2421w {

    /* renamed from: a */
    private final int f3830a;

    public C2356C(int i) {
        this.f3830a = i;
    }

    /* renamed from: a */
    public void mo34036a(C2466o oVar) {
        oVar.f4045o = this.f3830a;
    }

    /* renamed from: a */
    public boolean mo34037a() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C2356C) && this.f3830a == ((C2356C) obj).f3830a;
    }

    public int hashCode() {
        C2423y yVar = C2423y.MODE;
        return C1532a.m2119a(C1532a.m2145b(C1532a.m2145b(0, 2), this.f3830a), 2);
    }

    public String toString() {
        return String.format("mode(%d)", new Object[]{Integer.valueOf(this.f3830a)});
    }
}
