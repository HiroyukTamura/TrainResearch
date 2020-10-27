package p122k.p123a.p124a.p125a.p127F;

import java.util.Arrays;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;
import p122k.p123a.p124a.p125a.p126E.C2380Y;
import p122k.p123a.p124a.p125a.p126E.C2391c;
import p122k.p123a.p124a.p125a.p126E.C2422x;

/* renamed from: k.a.a.a.F.d */
public class C2428d {

    /* renamed from: a */
    public int f3968a = -1;

    /* renamed from: b */
    public C2391c f3969b = new C2391c(true);

    /* renamed from: c */
    public C2428d[] f3970c;

    /* renamed from: d */
    public boolean f3971d = false;

    /* renamed from: e */
    public int f3972e;

    /* renamed from: f */
    public C2422x f3973f;

    /* renamed from: g */
    public boolean f3974g;

    /* renamed from: h */
    public C2429a[] f3975h;

    /* renamed from: k.a.a.a.F.d$a */
    public static class C2429a {

        /* renamed from: a */
        public C2380Y f3976a;

        /* renamed from: b */
        public int f3977b;

        public C2429a(C2380Y y, int i) {
            this.f3977b = i;
            this.f3976a = y;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("(");
            a.append(this.f3976a);
            a.append(", ");
            return C0681a.m322a(a, this.f3977b, ")");
        }
    }

    public C2428d() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2428d)) {
            return false;
        }
        return this.f3969b.equals(((C2428d) obj).f3969b);
    }

    public int hashCode() {
        return C1532a.m2119a(C1532a.m2145b(7, this.f3969b.hashCode()), 1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3968a);
        sb.append(":");
        sb.append(this.f3969b);
        if (this.f3971d) {
            sb.append("=>");
            C2429a[] aVarArr = this.f3975h;
            if (aVarArr != null) {
                sb.append(Arrays.toString(aVarArr));
            } else {
                sb.append(this.f3972e);
            }
        }
        return sb.toString();
    }

    public C2428d(C2391c cVar) {
        this.f3969b = cVar;
    }
}
