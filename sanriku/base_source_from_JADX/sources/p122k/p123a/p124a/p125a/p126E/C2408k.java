package p122k.p123a.p124a.p125a.p126E;

import java.util.Arrays;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: k.a.a.a.E.k */
public class C2408k extends C2371Q {

    /* renamed from: d */
    public final C2371Q[] f3926d;

    /* renamed from: e */
    public final int[] f3927e;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C2408k(p122k.p123a.p124a.p125a.p126E.C2371Q[] r6, int[] r7) {
        /*
            r5 = this;
            int r0 = r6.length
            r1 = 0
            r2 = 1
            r3 = 0
        L_0x0004:
            if (r3 >= r0) goto L_0x000f
            r4 = r6[r3]
            int r2 = p009e.p028d.p030b.p054b.C1532a.m2120a((int) r2, (java.lang.Object) r4)
            int r3 = r3 + 1
            goto L_0x0004
        L_0x000f:
            int r0 = r7.length
        L_0x0010:
            if (r1 >= r0) goto L_0x001b
            r3 = r7[r1]
            int r2 = p009e.p028d.p030b.p054b.C1532a.m2145b(r2, r3)
            int r1 = r1 + 1
            goto L_0x0010
        L_0x001b:
            int r0 = r6.length
            int r0 = r0 * 2
            int r0 = p009e.p028d.p030b.p054b.C1532a.m2119a((int) r2, (int) r0)
            r5.<init>(r0)
            r5.f3926d = r6
            r5.f3927e = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p122k.p123a.p124a.p125a.p126E.C2408k.<init>(k.a.a.a.E.Q[], int[]):void");
    }

    /* renamed from: a */
    public C2371Q mo34084a(int i) {
        return this.f3926d[i];
    }

    /* renamed from: b */
    public int mo34086b(int i) {
        return this.f3927e[i];
    }

    /* renamed from: b */
    public boolean mo34087b() {
        return this.f3927e[0] == Integer.MAX_VALUE;
    }

    /* renamed from: c */
    public int mo34088c() {
        return this.f3927e.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2408k) || this.f3853a != obj.hashCode()) {
            return false;
        }
        C2408k kVar = (C2408k) obj;
        if (!Arrays.equals(this.f3927e, kVar.f3927e) || !Arrays.equals(this.f3926d, kVar.f3926d)) {
            return false;
        }
        return true;
    }

    public String toString() {
        String str;
        if (mo34087b()) {
            return "[]";
        }
        StringBuilder a = C0681a.m330a("[");
        for (int i = 0; i < this.f3927e.length; i++) {
            if (i > 0) {
                a.append(", ");
            }
            int[] iArr = this.f3927e;
            if (iArr[i] == Integer.MAX_VALUE) {
                str = "$";
            } else {
                a.append(iArr[i]);
                if (this.f3926d[i] != null) {
                    a.append(' ');
                    str = this.f3926d[i].toString();
                } else {
                    str = "null";
                }
            }
            a.append(str);
        }
        a.append("]");
        return a.toString();
    }
}
