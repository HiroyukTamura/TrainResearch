package p122k.p123a.p124a.p125a.p126E;

import java.util.EmptyStackException;
import p009e.p028d.p030b.p054b.C1532a;
import p122k.p123a.p124a.p125a.C2466o;
import p122k.p123a.p124a.p125a.p128G.C2438g;

/* renamed from: k.a.a.a.E.E */
public final class C2358E implements C2421w {

    /* renamed from: a */
    public static final C2358E f3832a = new C2358E();

    private C2358E() {
    }

    /* renamed from: a */
    public void mo34036a(C2466o oVar) {
        if (!oVar.f4044n.mo34239b()) {
            C2438g gVar = oVar.f4044n;
            oVar.f4045o = gVar.mo34241c(gVar.mo34240c() - 1);
            return;
        }
        throw new EmptyStackException();
    }

    /* renamed from: a */
    public boolean mo34037a() {
        return false;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        C2423y yVar = C2423y.POP_MODE;
        return C1532a.m2119a(C1532a.m2145b(0, 4), 1);
    }

    public String toString() {
        return "popMode";
    }
}
