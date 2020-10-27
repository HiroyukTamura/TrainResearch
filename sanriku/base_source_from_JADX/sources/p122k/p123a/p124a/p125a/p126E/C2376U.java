package p122k.p123a.p124a.p125a.p126E;

import p009e.p010a.p011a.p012a.C0681a;
import p122k.p123a.p124a.p125a.p128G.C2440i;

/* renamed from: k.a.a.a.E.U */
public final class C2376U extends C2401f0 {

    /* renamed from: b */
    public final int f3859b;

    /* renamed from: c */
    public final int f3860c;

    public C2376U(C2403g gVar, int i, int i2) {
        super(gVar);
        this.f3859b = i;
        this.f3860c = i2;
    }

    /* renamed from: a */
    public int mo34063a() {
        return 2;
    }

    /* renamed from: a */
    public boolean mo34064a(int i, int i2, int i3) {
        return i >= this.f3859b && i <= this.f3860c;
    }

    /* renamed from: c */
    public C2440i mo34094c() {
        return C2440i.m4151b(this.f3859b, this.f3860c);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("'");
        a.append((char) this.f3859b);
        a.append("'..'");
        a.append((char) this.f3860c);
        a.append("'");
        return a.toString();
    }
}
