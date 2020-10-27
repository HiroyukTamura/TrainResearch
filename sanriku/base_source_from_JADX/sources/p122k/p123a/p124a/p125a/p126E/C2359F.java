package p122k.p123a.p124a.p125a.p126E;

import p009e.p028d.p030b.p054b.C1532a;
import p122k.p123a.p124a.p125a.C2466o;

/* renamed from: k.a.a.a.E.F */
public final class C2359F implements C2421w {

    /* renamed from: a */
    private final int f3833a;

    public C2359F(int i) {
        this.f3833a = i;
    }

    /* renamed from: a */
    public void mo34036a(C2466o oVar) {
        int i = this.f3833a;
        oVar.f4044n.mo34237a(oVar.f4045o);
        oVar.f4045o = i;
    }

    /* renamed from: a */
    public boolean mo34037a() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C2359F) && this.f3833a == ((C2359F) obj).f3833a;
    }

    public int hashCode() {
        C2423y yVar = C2423y.PUSH_MODE;
        return C1532a.m2119a(C1532a.m2145b(C1532a.m2145b(0, 5), this.f3833a), 2);
    }

    public String toString() {
        return String.format("pushMode(%d)", new Object[]{Integer.valueOf(this.f3833a)});
    }
}
