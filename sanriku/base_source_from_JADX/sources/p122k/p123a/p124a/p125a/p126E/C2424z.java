package p122k.p123a.p124a.p125a.p126E;

import p009e.p028d.p030b.p054b.C1532a;
import p122k.p123a.p124a.p125a.C2466o;

/* renamed from: k.a.a.a.E.z */
public final class C2424z implements C2421w {

    /* renamed from: a */
    private final int f3960a;

    public C2424z(int i) {
        this.f3960a = i;
    }

    /* renamed from: a */
    public void mo34036a(C2466o oVar) {
        oVar.f4042l = this.f3960a;
    }

    /* renamed from: a */
    public boolean mo34037a() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C2424z) && this.f3960a == ((C2424z) obj).f3960a;
    }

    public int hashCode() {
        C2423y yVar = C2423y.CHANNEL;
        return C1532a.m2119a(C1532a.m2145b(C1532a.m2145b(0, 0), this.f3960a), 2);
    }

    public String toString() {
        return String.format("channel(%d)", new Object[]{Integer.valueOf(this.f3960a)});
    }
}
