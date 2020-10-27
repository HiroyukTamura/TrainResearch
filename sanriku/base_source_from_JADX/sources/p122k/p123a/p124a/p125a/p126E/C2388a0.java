package p122k.p123a.p124a.p125a.p126E;

/* renamed from: k.a.a.a.E.a0 */
public class C2388a0 extends C2371Q {

    /* renamed from: d */
    public final C2371Q f3882d;

    /* renamed from: e */
    public final int f3883e;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    C2388a0(p122k.p123a.p124a.p125a.p126E.C2371Q r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            if (r3 == 0) goto L_0x0011
            int r0 = p009e.p028d.p030b.p054b.C1532a.m2120a((int) r0, (java.lang.Object) r3)
            int r0 = p009e.p028d.p030b.p054b.C1532a.m2145b(r0, r4)
            r1 = 2
            int r0 = p009e.p028d.p030b.p054b.C1532a.m2119a((int) r0, (int) r1)
            goto L_0x0016
        L_0x0011:
            r1 = 0
            int r0 = p009e.p028d.p030b.p054b.C1532a.m2119a((int) r0, (int) r1)
        L_0x0016:
            r2.<init>(r0)
            r2.f3882d = r3
            r2.f3883e = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p122k.p123a.p124a.p125a.p126E.C2388a0.<init>(k.a.a.a.E.Q, int):void");
    }

    /* renamed from: a */
    public static C2388a0 m4041a(C2371Q q, int i) {
        return (i == Integer.MAX_VALUE && q == null) ? C2371Q.f3851b : new C2388a0(q, i);
    }

    /* renamed from: a */
    public C2371Q mo34084a(int i) {
        return this.f3882d;
    }

    /* renamed from: b */
    public int mo34086b(int i) {
        return this.f3883e;
    }

    /* renamed from: c */
    public int mo34088c() {
        return 1;
    }

    public boolean equals(Object obj) {
        C2371Q q;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2388a0) || this.f3853a != obj.hashCode()) {
            return false;
        }
        C2388a0 a0Var = (C2388a0) obj;
        if (this.f3883e != a0Var.f3883e || (q = this.f3882d) == null || !q.equals(a0Var.f3882d)) {
            return false;
        }
        return true;
    }

    public String toString() {
        C2371Q q = this.f3882d;
        String obj = q != null ? q.toString() : "";
        if (obj.length() == 0) {
            int i = this.f3883e;
            return i == Integer.MAX_VALUE ? "$" : String.valueOf(i);
        }
        return String.valueOf(this.f3883e) + " " + obj;
    }
}
