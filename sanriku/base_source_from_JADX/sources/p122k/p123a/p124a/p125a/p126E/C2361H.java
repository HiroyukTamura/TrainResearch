package p122k.p123a.p124a.p125a.p126E;

import p009e.p028d.p030b.p054b.C1532a;
import p122k.p123a.p124a.p125a.C2466o;

/* renamed from: k.a.a.a.E.H */
public class C2361H implements C2421w {

    /* renamed from: a */
    private final int f3835a;

    public C2361H(int i) {
        this.f3835a = i;
    }

    /* renamed from: a */
    public void mo34036a(C2466o oVar) {
        oVar.f4043m = this.f3835a;
    }

    /* renamed from: a */
    public boolean mo34037a() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C2361H) && this.f3835a == ((C2361H) obj).f3835a;
    }

    public int hashCode() {
        C2423y yVar = C2423y.TYPE;
        return C1532a.m2119a(C1532a.m2145b(C1532a.m2145b(0, 7), this.f3835a), 2);
    }

    public String toString() {
        return String.format("type(%d)", new Object[]{Integer.valueOf(this.f3835a)});
    }
}
