package p122k.p123a.p124a.p125a.p128G;

/* renamed from: k.a.a.a.G.h */
public class C2439h {

    /* renamed from: c */
    static C2439h[] f3999c = new C2439h[1001];

    /* renamed from: a */
    public int f4000a;

    /* renamed from: b */
    public int f4001b;

    static {
        new C2439h(-1, -2);
    }

    public C2439h(int i, int i2) {
        this.f4000a = i;
        this.f4001b = i2;
    }

    /* renamed from: a */
    public static C2439h m4146a(int i, int i2) {
        if (i != i2 || i < 0 || i > 1000) {
            return new C2439h(i, i2);
        }
        C2439h[] hVarArr = f3999c;
        if (hVarArr[i] == null) {
            hVarArr[i] = new C2439h(i, i);
        }
        return f3999c[i];
    }

    /* renamed from: a */
    public boolean mo34245a(C2439h hVar) {
        return this.f4000a == hVar.f4001b + 1 || this.f4001b == hVar.f4000a - 1;
    }

    /* renamed from: b */
    public boolean mo34246b(C2439h hVar) {
        int i = this.f4000a;
        int i2 = hVar.f4000a;
        if (!(i < i2 && this.f4001b < i2)) {
            if (this.f4000a > hVar.f4001b) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public C2439h mo34247c(C2439h hVar) {
        return m4146a(Math.min(this.f4000a, hVar.f4000a), Math.max(this.f4001b, hVar.f4001b));
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C2439h)) {
            return false;
        }
        C2439h hVar = (C2439h) obj;
        return this.f4000a == hVar.f4000a && this.f4001b == hVar.f4001b;
    }

    public int hashCode() {
        return ((713 + this.f4000a) * 31) + this.f4001b;
    }

    public String toString() {
        return this.f4000a + ".." + this.f4001b;
    }
}
