package p122k.p123a.p124a.p125a.p126E;

import java.util.IdentityHashMap;
import p122k.p123a.p124a.p125a.C2476w;

/* renamed from: k.a.a.a.E.Q */
public abstract class C2371Q {

    /* renamed from: b */
    public static final C2415r f3851b = new C2415r();

    /* renamed from: c */
    public static int f3852c = 0;

    /* renamed from: a */
    public final int f3853a;

    protected C2371Q(int i) {
        f3852c++;
        this.f3853a = i;
    }

    /* renamed from: a */
    public static C2371Q m3998a(C2371Q q, C2372S s, IdentityHashMap<C2371Q, C2371Q> identityHashMap) {
        if (q.mo34087b()) {
            return q;
        }
        C2371Q q2 = identityHashMap.get(q);
        if (q2 != null) {
            return q2;
        }
        C2371Q q3 = s.f3854a.get(q);
        if (q3 != null) {
            identityHashMap.put(q, q3);
            return q3;
        }
        C2371Q[] qArr = new C2371Q[q.mo34088c()];
        boolean z = false;
        for (int i = 0; i < qArr.length; i++) {
            C2371Q a = m3998a(q.mo34084a(i), s, identityHashMap);
            if (z || a != q.mo34084a(i)) {
                if (!z) {
                    qArr = new C2371Q[q.mo34088c()];
                    for (int i2 = 0; i2 < q.mo34088c(); i2++) {
                        qArr[i2] = q.mo34084a(i2);
                    }
                    z = true;
                }
                qArr[i] = a;
            }
        }
        if (!z) {
            s.mo34091a(q);
            identityHashMap.put(q, q);
            return q;
        }
        C2371Q a2 = qArr.length == 0 ? f3851b : qArr.length == 1 ? C2388a0.m4041a(qArr[0], q.mo34086b(0)) : new C2408k(qArr, ((C2408k) q).f3927e);
        s.mo34091a(a2);
        identityHashMap.put(a2, a2);
        identityHashMap.put(q, a2);
        return a2;
    }

    /* renamed from: a */
    public static C2371Q m3999a(C2387a aVar, C2476w wVar) {
        if (wVar == null) {
            wVar = C2476w.f4070c;
        }
        C2476w wVar2 = wVar.f4071a;
        return (wVar2 == null || wVar == C2476w.f4070c) ? f3851b : C2388a0.m4041a(m3999a(aVar, wVar2), ((C2379X) aVar.f3873a.get(wVar.f4072b).mo34154a(0)).f3864c.f3916b);
    }

    /* renamed from: a */
    public abstract C2371Q mo34084a(int i);

    /* renamed from: a */
    public boolean mo34085a() {
        return mo34086b(mo34088c() - 1) == Integer.MAX_VALUE;
    }

    /* renamed from: b */
    public abstract int mo34086b(int i);

    /* renamed from: b */
    public boolean mo34087b() {
        return this == f3851b;
    }

    /* renamed from: c */
    public abstract int mo34088c();

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        return this.f3853a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: k.a.a.a.E.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: k.a.a.a.E.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: k.a.a.a.E.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: k.a.a.a.E.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v33, resolved type: k.a.a.a.E.k} */
    /* JADX WARNING: type inference failed for: r4v8, types: [java.lang.Object[]] */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r1 == r9) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00dc, code lost:
        if (r3 != null) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0102, code lost:
        if (r3 != null) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x015a, code lost:
        if (r4 != null) goto L_0x0274;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0088  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p122k.p123a.p124a.p125a.p126E.C2371Q m3997a(p122k.p123a.p124a.p125a.p126E.C2371Q r16, p122k.p123a.p124a.p125a.p126E.C2371Q r17, boolean r18, p122k.p123a.p124a.p125a.p128G.C2433c<p122k.p123a.p124a.p125a.p126E.C2371Q, p122k.p123a.p124a.p125a.p126E.C2371Q, p122k.p123a.p124a.p125a.p126E.C2371Q> r19) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            if (r0 == r1) goto L_0x0275
            boolean r4 = r16.equals(r17)
            if (r4 == 0) goto L_0x0012
            goto L_0x0275
        L_0x0012:
            boolean r4 = r0 instanceof p122k.p123a.p124a.p125a.p126E.C2388a0
            r5 = 2147483647(0x7fffffff, float:NaN)
            r6 = 0
            r7 = 1
            if (r4 == 0) goto L_0x010a
            boolean r8 = r1 instanceof p122k.p123a.p124a.p125a.p126E.C2388a0
            if (r8 == 0) goto L_0x010a
            k.a.a.a.E.a0 r0 = (p122k.p123a.p124a.p125a.p126E.C2388a0) r0
            k.a.a.a.E.a0 r1 = (p122k.p123a.p124a.p125a.p126E.C2388a0) r1
            if (r3 == 0) goto L_0x0039
            java.lang.Object r4 = r3.mo34218a(r0, r1)
            k.a.a.a.E.Q r4 = (p122k.p123a.p124a.p125a.p126E.C2371Q) r4
            if (r4 == 0) goto L_0x0030
        L_0x002d:
            r0 = r4
            goto L_0x0109
        L_0x0030:
            java.lang.Object r4 = r3.mo34218a(r1, r0)
            k.a.a.a.E.Q r4 = (p122k.p123a.p124a.p125a.p126E.C2371Q) r4
            if (r4 == 0) goto L_0x0039
            goto L_0x002d
        L_0x0039:
            r4 = 0
            r8 = 2
            k.a.a.a.E.r r9 = f3851b
            if (r2 == 0) goto L_0x0045
            if (r0 != r9) goto L_0x0042
            goto L_0x007e
        L_0x0042:
            if (r1 != r9) goto L_0x007d
            goto L_0x007e
        L_0x0045:
            if (r0 != r9) goto L_0x004a
            if (r1 != r9) goto L_0x004a
            goto L_0x007e
        L_0x004a:
            k.a.a.a.E.r r9 = f3851b
            if (r0 != r9) goto L_0x0065
            int[] r9 = new int[r8]
            int r10 = r1.f3883e
            r9[r6] = r10
            r9[r7] = r5
            k.a.a.a.E.Q[] r5 = new p122k.p123a.p124a.p125a.p126E.C2371Q[r8]
            k.a.a.a.E.Q r10 = r1.f3882d
            r5[r6] = r10
            r5[r7] = r4
            k.a.a.a.E.k r10 = new k.a.a.a.E.k
            r10.<init>(r5, r9)
        L_0x0063:
            r9 = r10
            goto L_0x007e
        L_0x0065:
            if (r1 != r9) goto L_0x007d
            int[] r9 = new int[r8]
            int r10 = r0.f3883e
            r9[r6] = r10
            r9[r7] = r5
            k.a.a.a.E.Q[] r5 = new p122k.p123a.p124a.p125a.p126E.C2371Q[r8]
            k.a.a.a.E.Q r10 = r0.f3882d
            r5[r6] = r10
            r5[r7] = r4
            k.a.a.a.E.k r10 = new k.a.a.a.E.k
            r10.<init>(r5, r9)
            goto L_0x0063
        L_0x007d:
            r9 = r4
        L_0x007e:
            if (r9 == 0) goto L_0x0088
            if (r3 == 0) goto L_0x0085
            r3.mo34219a(r0, r1, r9)
        L_0x0085:
            r0 = r9
            goto L_0x0109
        L_0x0088:
            int r5 = r0.f3883e
            int r9 = r1.f3883e
            if (r5 != r9) goto L_0x00af
            k.a.a.a.E.Q r4 = r0.f3882d
            k.a.a.a.E.Q r5 = r1.f3882d
            k.a.a.a.E.Q r2 = m3997a(r4, r5, r2, r3)
            k.a.a.a.E.Q r4 = r0.f3882d
            if (r2 != r4) goto L_0x009c
            goto L_0x0109
        L_0x009c:
            k.a.a.a.E.Q r4 = r1.f3882d
            if (r2 != r4) goto L_0x00a2
            r0 = r1
            goto L_0x0109
        L_0x00a2:
            int r4 = r0.f3883e
            k.a.a.a.E.a0 r2 = p122k.p123a.p124a.p125a.p126E.C2388a0.m4041a(r2, r4)
            if (r3 == 0) goto L_0x00ad
            r3.mo34219a(r0, r1, r2)
        L_0x00ad:
            r0 = r2
            goto L_0x0109
        L_0x00af:
            if (r0 == r1) goto L_0x00bd
            k.a.a.a.E.Q r2 = r0.f3882d
            if (r2 == 0) goto L_0x00bf
            k.a.a.a.E.Q r5 = r1.f3882d
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x00bf
        L_0x00bd:
            k.a.a.a.E.Q r4 = r0.f3882d
        L_0x00bf:
            int[] r2 = new int[r8]
            if (r4 == 0) goto L_0x00df
            int r5 = r0.f3883e
            r2[r6] = r5
            int r9 = r1.f3883e
            r2[r7] = r9
            if (r5 <= r9) goto L_0x00d1
            r2[r6] = r9
            r2[r7] = r5
        L_0x00d1:
            k.a.a.a.E.Q[] r5 = new p122k.p123a.p124a.p125a.p126E.C2371Q[r8]
            r5[r6] = r4
            r5[r7] = r4
            k.a.a.a.E.k r4 = new k.a.a.a.E.k
            r4.<init>(r5, r2)
            if (r3 == 0) goto L_0x002d
            goto L_0x0104
        L_0x00df:
            int r4 = r0.f3883e
            r2[r6] = r4
            int r5 = r1.f3883e
            r2[r7] = r5
            k.a.a.a.E.Q[] r9 = new p122k.p123a.p124a.p125a.p126E.C2371Q[r8]
            k.a.a.a.E.Q r10 = r0.f3882d
            r9[r6] = r10
            k.a.a.a.E.Q r11 = r1.f3882d
            r9[r7] = r11
            if (r4 <= r5) goto L_0x00fd
            r2[r6] = r5
            r2[r7] = r4
            k.a.a.a.E.Q[] r9 = new p122k.p123a.p124a.p125a.p126E.C2371Q[r8]
            r9[r6] = r11
            r9[r7] = r10
        L_0x00fd:
            k.a.a.a.E.k r4 = new k.a.a.a.E.k
            r4.<init>(r9, r2)
            if (r3 == 0) goto L_0x002d
        L_0x0104:
            r3.mo34219a(r0, r1, r4)
            goto L_0x002d
        L_0x0109:
            return r0
        L_0x010a:
            if (r2 == 0) goto L_0x0116
            boolean r8 = r0 instanceof p122k.p123a.p124a.p125a.p126E.C2415r
            if (r8 == 0) goto L_0x0111
            return r0
        L_0x0111:
            boolean r8 = r1 instanceof p122k.p123a.p124a.p125a.p126E.C2415r
            if (r8 == 0) goto L_0x0116
            return r1
        L_0x0116:
            if (r4 == 0) goto L_0x012c
            k.a.a.a.E.k r4 = new k.a.a.a.E.k
            k.a.a.a.E.a0 r0 = (p122k.p123a.p124a.p125a.p126E.C2388a0) r0
            k.a.a.a.E.Q[] r8 = new p122k.p123a.p124a.p125a.p126E.C2371Q[r7]
            k.a.a.a.E.Q r9 = r0.f3882d
            r8[r6] = r9
            int[] r9 = new int[r7]
            int r0 = r0.f3883e
            r9[r6] = r0
            r4.<init>(r8, r9)
            r0 = r4
        L_0x012c:
            boolean r4 = r1 instanceof p122k.p123a.p124a.p125a.p126E.C2388a0
            if (r4 == 0) goto L_0x0144
            k.a.a.a.E.k r4 = new k.a.a.a.E.k
            k.a.a.a.E.a0 r1 = (p122k.p123a.p124a.p125a.p126E.C2388a0) r1
            k.a.a.a.E.Q[] r8 = new p122k.p123a.p124a.p125a.p126E.C2371Q[r7]
            k.a.a.a.E.Q r9 = r1.f3882d
            r8[r6] = r9
            int[] r9 = new int[r7]
            int r1 = r1.f3883e
            r9[r6] = r1
            r4.<init>(r8, r9)
            r1 = r4
        L_0x0144:
            k.a.a.a.E.k r0 = (p122k.p123a.p124a.p125a.p126E.C2408k) r0
            k.a.a.a.E.k r1 = (p122k.p123a.p124a.p125a.p126E.C2408k) r1
            if (r3 == 0) goto L_0x015e
            java.lang.Object r4 = r3.mo34218a(r0, r1)
            k.a.a.a.E.Q r4 = (p122k.p123a.p124a.p125a.p126E.C2371Q) r4
            if (r4 == 0) goto L_0x0154
            goto L_0x0274
        L_0x0154:
            java.lang.Object r4 = r3.mo34218a(r1, r0)
            k.a.a.a.E.Q r4 = (p122k.p123a.p124a.p125a.p126E.C2371Q) r4
            if (r4 == 0) goto L_0x015e
            goto L_0x0274
        L_0x015e:
            int[] r4 = r0.f3927e
            int r8 = r4.length
            int[] r9 = r1.f3927e
            int r10 = r9.length
            int r8 = r8 + r10
            int[] r8 = new int[r8]
            int r4 = r4.length
            int r9 = r9.length
            int r4 = r4 + r9
            k.a.a.a.E.Q[] r9 = new p122k.p123a.p124a.p125a.p126E.C2371Q[r4]
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x016f:
            int[] r13 = r0.f3927e
            int r14 = r13.length
            if (r10 >= r14) goto L_0x01d9
            int[] r14 = r1.f3927e
            int r15 = r14.length
            if (r11 >= r15) goto L_0x01d9
            k.a.a.a.E.Q[] r15 = r0.f3926d
            r15 = r15[r10]
            k.a.a.a.E.Q[] r6 = r1.f3926d
            r6 = r6[r11]
            r7 = r13[r10]
            r5 = r14[r11]
            if (r7 != r5) goto L_0x01b7
            r5 = r13[r10]
            r7 = 2147483647(0x7fffffff, float:NaN)
            if (r5 != r7) goto L_0x0194
            if (r15 != 0) goto L_0x0194
            if (r6 != 0) goto L_0x0194
            r13 = 1
            goto L_0x0195
        L_0x0194:
            r13 = 0
        L_0x0195:
            if (r15 == 0) goto L_0x01a1
            if (r6 == 0) goto L_0x01a1
            boolean r14 = r15.equals(r6)
            if (r14 == 0) goto L_0x01a1
            r14 = 1
            goto L_0x01a2
        L_0x01a1:
            r14 = 0
        L_0x01a2:
            if (r13 != 0) goto L_0x01b0
            if (r14 == 0) goto L_0x01a7
            goto L_0x01b0
        L_0x01a7:
            k.a.a.a.E.Q r6 = m3997a(r15, r6, r2, r3)
            r9[r12] = r6
            r8[r12] = r5
            goto L_0x01b4
        L_0x01b0:
            r9[r12] = r15
            r8[r12] = r5
        L_0x01b4:
            int r10 = r10 + 1
            goto L_0x01cf
        L_0x01b7:
            r7 = 2147483647(0x7fffffff, float:NaN)
            r5 = r13[r10]
            r7 = r14[r11]
            if (r5 >= r7) goto L_0x01c9
            r9[r12] = r15
            r5 = r13[r10]
            r8[r12] = r5
            int r10 = r10 + 1
            goto L_0x01d1
        L_0x01c9:
            r9[r12] = r6
            r5 = r14[r11]
            r8[r12] = r5
        L_0x01cf:
            int r11 = r11 + 1
        L_0x01d1:
            int r12 = r12 + 1
            r5 = 2147483647(0x7fffffff, float:NaN)
            r6 = 0
            r7 = 1
            goto L_0x016f
        L_0x01d9:
            int[] r2 = r0.f3927e
            int r2 = r2.length
            if (r10 >= r2) goto L_0x01f2
        L_0x01de:
            int[] r2 = r0.f3927e
            int r5 = r2.length
            if (r10 >= r5) goto L_0x0206
            k.a.a.a.E.Q[] r5 = r0.f3926d
            r5 = r5[r10]
            r9[r12] = r5
            r2 = r2[r10]
            r8[r12] = r2
            int r12 = r12 + 1
            int r10 = r10 + 1
            goto L_0x01de
        L_0x01f2:
            int[] r2 = r1.f3927e
            int r5 = r2.length
            if (r11 >= r5) goto L_0x0206
            k.a.a.a.E.Q[] r5 = r1.f3926d
            r5 = r5[r11]
            r9[r12] = r5
            r2 = r2[r11]
            r8[r12] = r2
            int r12 = r12 + 1
            int r11 = r11 + 1
            goto L_0x01f2
        L_0x0206:
            if (r12 >= r4) goto L_0x0228
            r2 = 1
            if (r12 != r2) goto L_0x021b
            r2 = 0
            r4 = r9[r2]
            r2 = r8[r2]
            k.a.a.a.E.a0 r2 = p122k.p123a.p124a.p125a.p126E.C2388a0.m4041a(r4, r2)
            if (r3 == 0) goto L_0x0219
            r3.mo34219a(r0, r1, r2)
        L_0x0219:
            r0 = r2
            goto L_0x0275
        L_0x021b:
            r2 = 0
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r9, r12)
            r9 = r4
            k.a.a.a.E.Q[] r9 = (p122k.p123a.p124a.p125a.p126E.C2371Q[]) r9
            int[] r8 = java.util.Arrays.copyOf(r8, r12)
            goto L_0x0229
        L_0x0228:
            r2 = 0
        L_0x0229:
            k.a.a.a.E.k r4 = new k.a.a.a.E.k
            r4.<init>(r9, r8)
            boolean r5 = r4.equals(r0)
            if (r5 == 0) goto L_0x023a
            if (r3 == 0) goto L_0x0275
            r3.mo34219a(r0, r1, r0)
            goto L_0x0275
        L_0x023a:
            boolean r5 = r4.equals(r1)
            if (r5 == 0) goto L_0x0247
            if (r3 == 0) goto L_0x0245
            r3.mo34219a(r0, r1, r1)
        L_0x0245:
            r0 = r1
            goto L_0x0275
        L_0x0247:
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            r6 = 0
        L_0x024d:
            int r7 = r9.length
            if (r6 >= r7) goto L_0x025e
            r7 = r9[r6]
            boolean r8 = r5.containsKey(r7)
            if (r8 != 0) goto L_0x025b
            r5.put(r7, r7)
        L_0x025b:
            int r6 = r6 + 1
            goto L_0x024d
        L_0x025e:
            r6 = 0
        L_0x025f:
            int r2 = r9.length
            if (r6 >= r2) goto L_0x026f
            r2 = r9[r6]
            java.lang.Object r2 = r5.get(r2)
            k.a.a.a.E.Q r2 = (p122k.p123a.p124a.p125a.p126E.C2371Q) r2
            r9[r6] = r2
            int r6 = r6 + 1
            goto L_0x025f
        L_0x026f:
            if (r3 == 0) goto L_0x0274
            r3.mo34219a(r0, r1, r4)
        L_0x0274:
            r0 = r4
        L_0x0275:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p122k.p123a.p124a.p125a.p126E.C2371Q.m3997a(k.a.a.a.E.Q, k.a.a.a.E.Q, boolean, k.a.a.a.G.c):k.a.a.a.E.Q");
    }
}
