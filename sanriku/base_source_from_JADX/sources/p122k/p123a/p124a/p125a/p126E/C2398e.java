package p122k.p123a.p124a.p125a.p126E;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* renamed from: k.a.a.a.E.e */
public class C2398e {

    /* renamed from: b */
    public static final int f3904b = 3;

    /* renamed from: c */
    private static final UUID f3905c = UUID.fromString("33761B2D-78BB-4A43-8B0B-4F5BEE8AACF3");

    /* renamed from: d */
    private static final UUID f3906d = UUID.fromString("1DA0C57D-6C06-438A-9B27-10BCB3CE0F61");

    /* renamed from: e */
    private static final UUID f3907e = UUID.fromString("AADB8D7E-AEEF-4415-AD2B-8204D6CF042E");

    /* renamed from: f */
    private static final List<UUID> f3908f;

    /* renamed from: g */
    public static final UUID f3909g = f3907e;

    /* renamed from: a */
    private final C2396d f3910a;

    static {
        ArrayList arrayList = new ArrayList();
        f3908f = arrayList;
        arrayList.add(f3905c);
        f3908f.add(f3906d);
        f3908f.add(f3907e);
    }

    public C2398e() {
        C2396d c = C2396d.m4058c();
        this.f3910a = c == null ? C2396d.m4058c() : c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34150a(boolean z) {
        if (!z) {
            throw new IllegalStateException((String) null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo34151a(UUID uuid, UUID uuid2) {
        int indexOf = f3908f.indexOf(uuid);
        return indexOf >= 0 && f3908f.indexOf(uuid2) >= indexOf;
    }

    /* JADX WARNING: type inference failed for: r14v7 */
    /* JADX WARNING: type inference failed for: r14v8, types: [k.a.a.a.E.n] */
    /* JADX WARNING: type inference failed for: r14v9, types: [k.a.a.a.E.V] */
    /* JADX WARNING: type inference failed for: r14v10, types: [k.a.a.a.E.m] */
    /* JADX WARNING: type inference failed for: r14v11, types: [k.a.a.a.E.M] */
    /* JADX WARNING: type inference failed for: r14v12, types: [k.a.a.a.E.b0] */
    /* JADX WARNING: type inference failed for: r14v13, types: [k.a.a.a.E.e0] */
    /* JADX WARNING: type inference failed for: r14v14, types: [k.a.a.a.E.W] */
    /* JADX WARNING: type inference failed for: r14v15, types: [k.a.a.a.E.o] */
    /* JADX WARNING: type inference failed for: r14v16, types: [k.a.a.a.E.d0] */
    /* JADX WARNING: type inference failed for: r14v17, types: [k.a.a.a.E.c0] */
    /* JADX WARNING: type inference failed for: r14v18, types: [k.a.a.a.E.N] */
    /* JADX WARNING: type inference failed for: r14v19, types: [k.a.a.a.E.I] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p122k.p123a.p124a.p125a.p126E.C2387a mo34148a(char[] r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.Class<k.a.a.a.E.a> r1 = p122k.p123a.p124a.p125a.p126E.C2387a.class
            java.lang.Object r2 = r19.clone()
            char[] r2 = (char[]) r2
            r3 = 1
            r4 = 1
        L_0x000c:
            int r5 = r2.length
            r6 = 2
            if (r4 >= r5) goto L_0x0019
            char r5 = r2[r4]
            int r5 = r5 - r6
            char r5 = (char) r5
            r2[r4] = r5
            int r4 = r4 + 1
            goto L_0x000c
        L_0x0019:
            r4 = 0
            char r5 = r2[r4]
            r7 = 3
            if (r5 != r7) goto L_0x0688
            long r7 = m4062a((char[]) r2, (int) r3)
            r5 = 5
            long r9 = m4062a((char[]) r2, (int) r5)
            java.util.UUID r5 = new java.util.UUID
            r5.<init>(r9, r7)
            r7 = 9
            java.util.List<java.util.UUID> r8 = f3908f
            boolean r8 = r8.contains(r5)
            if (r8 == 0) goto L_0x0665
            java.util.UUID r1 = f3906d
            boolean r1 = r0.mo34151a((java.util.UUID) r1, (java.util.UUID) r5)
            java.util.UUID r6 = f3907e
            boolean r6 = r0.mo34151a((java.util.UUID) r6, (java.util.UUID) r5)
            k.a.a.a.E.h[] r8 = p122k.p123a.p124a.p125a.p126E.C2405h.m4080a()
            r9 = 10
            char r7 = r2[r7]
            r7 = r8[r7]
            r8 = 11
            char r9 = r2[r9]
            k.a.a.a.E.a r10 = new k.a.a.a.E.a
            r10.<init>(r7, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            char r8 = r2[r8]
            r11 = 12
            r12 = 0
            r13 = 12
        L_0x0067:
            r14 = 65535(0xffff, float:9.1834E-41)
            r15 = 0
            r4 = -1
            if (r12 >= r8) goto L_0x0127
            int r16 = r13 + 1
            char r13 = r2[r13]
            if (r13 != 0) goto L_0x007b
            r10.mo34115a((p122k.p123a.p124a.p125a.p126E.C2403g) r15)
            r13 = r16
            goto L_0x0120
        L_0x007b:
            int r17 = r16 + 1
            char r15 = r2[r16]
            if (r15 != r14) goto L_0x0082
            goto L_0x0083
        L_0x0082:
            r4 = r15
        L_0x0083:
            switch(r13) {
                case 0: goto L_0x00ea;
                case 1: goto L_0x00e1;
                case 2: goto L_0x00db;
                case 3: goto L_0x00d5;
                case 4: goto L_0x00cf;
                case 5: goto L_0x00c9;
                case 6: goto L_0x00c3;
                case 7: goto L_0x00bd;
                case 8: goto L_0x00b7;
                case 9: goto L_0x00b1;
                case 10: goto L_0x00ab;
                case 11: goto L_0x00a5;
                case 12: goto L_0x009f;
                default: goto L_0x0086;
            }
        L_0x0086:
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r13)
            r4 = 0
            r2[r4] = r3
            java.lang.String r3 = "The specified state type %d is not valid."
            java.lang.String r1 = java.lang.String.format(r1, r3, r2)
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            r2.<init>(r1)
            throw r2
        L_0x009f:
            k.a.a.a.E.I r14 = new k.a.a.a.E.I
            r14.<init>()
            goto L_0x00e6
        L_0x00a5:
            k.a.a.a.E.N r14 = new k.a.a.a.E.N
            r14.<init>()
            goto L_0x00e6
        L_0x00ab:
            k.a.a.a.E.c0 r14 = new k.a.a.a.E.c0
            r14.<init>()
            goto L_0x00e6
        L_0x00b1:
            k.a.a.a.E.d0 r14 = new k.a.a.a.E.d0
            r14.<init>()
            goto L_0x00e6
        L_0x00b7:
            k.a.a.a.E.o r14 = new k.a.a.a.E.o
            r14.<init>()
            goto L_0x00e6
        L_0x00bd:
            k.a.a.a.E.W r14 = new k.a.a.a.E.W
            r14.<init>()
            goto L_0x00e6
        L_0x00c3:
            k.a.a.a.E.e0 r14 = new k.a.a.a.E.e0
            r14.<init>()
            goto L_0x00e6
        L_0x00c9:
            k.a.a.a.E.b0 r14 = new k.a.a.a.E.b0
            r14.<init>()
            goto L_0x00e6
        L_0x00cf:
            k.a.a.a.E.M r14 = new k.a.a.a.E.M
            r14.<init>()
            goto L_0x00e6
        L_0x00d5:
            k.a.a.a.E.m r14 = new k.a.a.a.E.m
            r14.<init>()
            goto L_0x00e6
        L_0x00db:
            k.a.a.a.E.V r14 = new k.a.a.a.E.V
            r14.<init>()
            goto L_0x00e6
        L_0x00e1:
            k.a.a.a.E.n r14 = new k.a.a.a.E.n
            r14.<init>()
        L_0x00e6:
            r15 = r14
            r15.f3917c = r4
            goto L_0x00eb
        L_0x00ea:
            r15 = 0
        L_0x00eb:
            if (r13 != r11) goto L_0x0103
            int r4 = r17 + 1
            char r13 = r2[r17]
            k.a.a.a.G.k r14 = new k.a.a.a.G.k
            r11 = r15
            k.a.a.a.E.I r11 = (p122k.p123a.p124a.p125a.p126E.C2362I) r11
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r14.<init>(r11, r13)
            r7.add(r14)
        L_0x0100:
            r17 = r4
            goto L_0x011b
        L_0x0103:
            boolean r4 = r15 instanceof p122k.p123a.p124a.p125a.p126E.C2413p
            if (r4 == 0) goto L_0x011b
            int r4 = r17 + 1
            char r11 = r2[r17]
            k.a.a.a.G.k r13 = new k.a.a.a.G.k
            r14 = r15
            k.a.a.a.E.p r14 = (p122k.p123a.p124a.p125a.p126E.C2413p) r14
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r13.<init>(r14, r11)
            r9.add(r13)
            goto L_0x0100
        L_0x011b:
            r10.mo34115a((p122k.p123a.p124a.p125a.p126E.C2403g) r15)
            r13 = r17
        L_0x0120:
            int r12 = r12 + 1
            r4 = 0
            r11 = 12
            goto L_0x0067
        L_0x0127:
            java.util.Iterator r7 = r7.iterator()
        L_0x012b:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x014e
            java.lang.Object r8 = r7.next()
            k.a.a.a.G.k r8 = (p122k.p123a.p124a.p125a.p128G.C2442k) r8
            A r11 = r8.f4007a
            k.a.a.a.E.I r11 = (p122k.p123a.p124a.p125a.p126E.C2362I) r11
            java.util.List<k.a.a.a.E.g> r12 = r10.f3873a
            B r8 = r8.f4008b
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Object r8 = r12.get(r8)
            k.a.a.a.E.g r8 = (p122k.p123a.p124a.p125a.p126E.C2403g) r8
            r11.f3836g = r8
            goto L_0x012b
        L_0x014e:
            java.util.Iterator r7 = r9.iterator()
        L_0x0152:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0175
            java.lang.Object r8 = r7.next()
            k.a.a.a.G.k r8 = (p122k.p123a.p124a.p125a.p128G.C2442k) r8
            A r9 = r8.f4007a
            k.a.a.a.E.p r9 = (p122k.p123a.p124a.p125a.p126E.C2413p) r9
            java.util.List<k.a.a.a.E.g> r11 = r10.f3873a
            B r8 = r8.f4008b
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Object r8 = r11.get(r8)
            k.a.a.a.E.o r8 = (p122k.p123a.p124a.p125a.p126E.C2412o) r8
            r9.f3930i = r8
            goto L_0x0152
        L_0x0175:
            int r7 = r13 + 1
            char r8 = r2[r13]
            r9 = r7
            r7 = 0
        L_0x017b:
            if (r7 >= r8) goto L_0x018f
            int r11 = r9 + 1
            char r9 = r2[r9]
            java.util.List<k.a.a.a.E.g> r12 = r10.f3873a
            java.lang.Object r9 = r12.get(r9)
            k.a.a.a.E.q r9 = (p122k.p123a.p124a.p125a.p126E.C2414q) r9
            r9.f3932h = r3
            int r7 = r7 + 1
            r9 = r11
            goto L_0x017b
        L_0x018f:
            if (r1 == 0) goto L_0x01ab
            int r1 = r9 + 1
            char r7 = r2[r9]
            r9 = r1
            r1 = 0
        L_0x0197:
            if (r1 >= r7) goto L_0x01ab
            int r8 = r9 + 1
            char r9 = r2[r9]
            java.util.List<k.a.a.a.E.g> r11 = r10.f3873a
            java.lang.Object r9 = r11.get(r9)
            k.a.a.a.E.V r9 = (p122k.p123a.p124a.p125a.p126E.C2377V) r9
            r9.f3862h = r3
            int r1 = r1 + 1
            r9 = r8
            goto L_0x0197
        L_0x01ab:
            int r1 = r9 + 1
            char r7 = r2[r9]
            k.a.a.a.E.h r8 = r10.f3877e
            k.a.a.a.E.h r9 = p122k.p123a.p124a.p125a.p126E.C2405h.LEXER
            if (r8 != r9) goto L_0x01b9
            int[] r8 = new int[r7]
            r10.f3879g = r8
        L_0x01b9:
            k.a.a.a.E.V[] r8 = new p122k.p123a.p124a.p125a.p126E.C2377V[r7]
            r10.f3875c = r8
            r8 = r1
            r1 = 0
        L_0x01bf:
            if (r1 >= r7) goto L_0x01f2
            int r9 = r8 + 1
            char r8 = r2[r8]
            java.util.List<k.a.a.a.E.g> r11 = r10.f3873a
            java.lang.Object r8 = r11.get(r8)
            k.a.a.a.E.V r8 = (p122k.p123a.p124a.p125a.p126E.C2377V) r8
            k.a.a.a.E.V[] r11 = r10.f3875c
            r11[r1] = r8
            k.a.a.a.E.h r8 = r10.f3877e
            k.a.a.a.E.h r11 = p122k.p123a.p124a.p125a.p126E.C2405h.LEXER
            if (r8 != r11) goto L_0x01ee
            int r8 = r9 + 1
            char r9 = r2[r9]
            if (r9 != r14) goto L_0x01de
            r9 = -1
        L_0x01de:
            int[] r11 = r10.f3879g
            r11[r1] = r9
            java.util.UUID r9 = f3907e
            boolean r9 = r0.mo34151a((java.util.UUID) r9, (java.util.UUID) r5)
            if (r9 != 0) goto L_0x01ef
            int r9 = r8 + 1
            char r8 = r2[r8]
        L_0x01ee:
            r8 = r9
        L_0x01ef:
            int r1 = r1 + 1
            goto L_0x01bf
        L_0x01f2:
            k.a.a.a.E.W[] r1 = new p122k.p123a.p124a.p125a.p126E.C2378W[r7]
            r10.f3876d = r1
            java.util.List<k.a.a.a.E.g> r1 = r10.f3873a
            java.util.Iterator r1 = r1.iterator()
        L_0x01fc:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x021d
            java.lang.Object r5 = r1.next()
            k.a.a.a.E.g r5 = (p122k.p123a.p124a.p125a.p126E.C2403g) r5
            boolean r7 = r5 instanceof p122k.p123a.p124a.p125a.p126E.C2378W
            if (r7 != 0) goto L_0x020d
            goto L_0x01fc
        L_0x020d:
            r7 = r5
            k.a.a.a.E.W r7 = (p122k.p123a.p124a.p125a.p126E.C2378W) r7
            k.a.a.a.E.W[] r9 = r10.f3876d
            int r5 = r5.f3917c
            r9[r5] = r7
            k.a.a.a.E.V[] r9 = r10.f3875c
            r5 = r9[r5]
            r5.f3861g = r7
            goto L_0x01fc
        L_0x021d:
            int r1 = r8 + 1
            char r5 = r2[r8]
            r7 = r1
            r1 = 0
        L_0x0223:
            if (r1 >= r5) goto L_0x023a
            int r8 = r7 + 1
            char r7 = r2[r7]
            java.util.List<k.a.a.a.E.e0> r9 = r10.f3881i
            java.util.List<k.a.a.a.E.g> r11 = r10.f3873a
            java.lang.Object r7 = r11.get(r7)
            k.a.a.a.E.e0 r7 = (p122k.p123a.p124a.p125a.p126E.C2399e0) r7
            r9.add(r7)
            int r1 = r1 + 1
            r7 = r8
            goto L_0x0223
        L_0x023a:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r5 = r7 + 1
            char r7 = r2[r7]
            r8 = r5
            r5 = 0
        L_0x0245:
            if (r5 >= r7) goto L_0x0279
            char r9 = r2[r8]
            int r8 = r8 + 1
            k.a.a.a.G.i r11 = new k.a.a.a.G.i
            r12 = 0
            int[] r13 = new int[r12]
            r11.<init>(r13)
            r1.add(r11)
            int r12 = r8 + 1
            char r8 = r2[r8]
            if (r8 == 0) goto L_0x025e
            r8 = 1
            goto L_0x025f
        L_0x025e:
            r8 = 0
        L_0x025f:
            if (r8 == 0) goto L_0x0264
            r11.mo34255a((int) r4)
        L_0x0264:
            r8 = 0
        L_0x0265:
            if (r8 >= r9) goto L_0x0275
            char r13 = r2[r12]
            int r15 = r12 + 1
            char r15 = r2[r15]
            r11.mo34256a((int) r13, (int) r15)
            int r12 = r12 + 2
            int r8 = r8 + 1
            goto L_0x0265
        L_0x0275:
            int r5 = r5 + 1
            r8 = r12
            goto L_0x0245
        L_0x0279:
            int r5 = r8 + 1
            char r7 = r2[r8]
            r8 = r5
            r5 = 0
        L_0x027f:
            if (r5 >= r7) goto L_0x0326
            char r9 = r2[r8]
            int r11 = r8 + 1
            char r11 = r2[r11]
            int r12 = r8 + 2
            char r12 = r2[r12]
            int r13 = r8 + 3
            char r13 = r2[r13]
            int r15 = r8 + 4
            char r15 = r2[r15]
            int r16 = r8 + 5
            char r3 = r2[r16]
            java.util.List<k.a.a.a.E.g> r14 = r10.f3873a
            java.lang.Object r11 = r14.get(r11)
            k.a.a.a.E.g r11 = (p122k.p123a.p124a.p125a.p126E.C2403g) r11
            switch(r12) {
                case 1: goto L_0x030c;
                case 2: goto L_0x0300;
                case 3: goto L_0x02f1;
                case 4: goto L_0x02e6;
                case 5: goto L_0x02da;
                case 6: goto L_0x02cf;
                case 7: goto L_0x02c3;
                case 8: goto L_0x02b7;
                case 9: goto L_0x02b1;
                case 10: goto L_0x02aa;
                default: goto L_0x02a2;
            }
        L_0x02a2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "The specified transition type is not valid."
            r1.<init>(r2)
            throw r1
        L_0x02aa:
            k.a.a.a.E.O r3 = new k.a.a.a.E.O
            r3.<init>(r11, r13)
            goto L_0x0311
        L_0x02b1:
            k.a.a.a.E.g0 r3 = new k.a.a.a.E.g0
            r3.<init>(r11)
            goto L_0x0311
        L_0x02b7:
            k.a.a.a.E.J r3 = new k.a.a.a.E.J
            java.lang.Object r12 = r1.get(r13)
            k.a.a.a.G.i r12 = (p122k.p123a.p124a.p125a.p128G.C2440i) r12
            r3.<init>(r11, r12)
            goto L_0x0311
        L_0x02c3:
            k.a.a.a.E.Z r3 = new k.a.a.a.E.Z
            java.lang.Object r12 = r1.get(r13)
            k.a.a.a.G.i r12 = (p122k.p123a.p124a.p125a.p128G.C2440i) r12
            r3.<init>(r11, r12)
            goto L_0x0311
        L_0x02cf:
            k.a.a.a.E.j r12 = new k.a.a.a.E.j
            if (r3 == 0) goto L_0x02d5
            r3 = 1
            goto L_0x02d6
        L_0x02d5:
            r3 = 0
        L_0x02d6:
            r12.<init>(r11, r13, r15, r3)
            goto L_0x02fe
        L_0x02da:
            k.a.a.a.E.l r12 = new k.a.a.a.E.l
            if (r3 == 0) goto L_0x02e2
            r12.<init>(r11, r4)
            goto L_0x02fe
        L_0x02e2:
            r12.<init>(r11, r13)
            goto L_0x02fe
        L_0x02e6:
            k.a.a.a.E.P r12 = new k.a.a.a.E.P
            if (r3 == 0) goto L_0x02ec
            r3 = 1
            goto L_0x02ed
        L_0x02ec:
            r3 = 0
        L_0x02ed:
            r12.<init>(r11, r13, r15, r3)
            goto L_0x02fe
        L_0x02f1:
            k.a.a.a.E.X r12 = new k.a.a.a.E.X
            java.util.List<k.a.a.a.E.g> r14 = r10.f3873a
            java.lang.Object r13 = r14.get(r13)
            k.a.a.a.E.V r13 = (p122k.p123a.p124a.p125a.p126E.C2377V) r13
            r12.<init>(r13, r15, r3, r11)
        L_0x02fe:
            r3 = r12
            goto L_0x0311
        L_0x0300:
            k.a.a.a.E.U r12 = new k.a.a.a.E.U
            if (r3 == 0) goto L_0x0308
            r12.<init>(r11, r4, r15)
            goto L_0x02fe
        L_0x0308:
            r12.<init>(r11, r13, r15)
            goto L_0x02fe
        L_0x030c:
            k.a.a.a.E.s r3 = new k.a.a.a.E.s
            r3.<init>(r11)
        L_0x0311:
            java.util.List<k.a.a.a.E.g> r11 = r10.f3873a
            java.lang.Object r9 = r11.get(r9)
            k.a.a.a.E.g r9 = (p122k.p123a.p124a.p125a.p126E.C2403g) r9
            r9.mo34155a((p122k.p123a.p124a.p125a.p126E.C2401f0) r3)
            int r8 = r8 + 6
            int r5 = r5 + 1
            r3 = 1
            r14 = 65535(0xffff, float:9.1834E-41)
            goto L_0x027f
        L_0x0326:
            java.util.List<k.a.a.a.E.g> r1 = r10.f3873a
            java.util.Iterator r1 = r1.iterator()
        L_0x032c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0371
            java.lang.Object r3 = r1.next()
            k.a.a.a.E.g r3 = (p122k.p123a.p124a.p125a.p126E.C2403g) r3
            r5 = 0
        L_0x0339:
            int r7 = r3.mo34153a()
            if (r5 >= r7) goto L_0x032c
            k.a.a.a.E.f0 r7 = r3.mo34154a((int) r5)
            boolean r9 = r7 instanceof p122k.p123a.p124a.p125a.p126E.C2379X
            if (r9 != 0) goto L_0x0348
            goto L_0x036e
        L_0x0348:
            k.a.a.a.E.X r7 = (p122k.p123a.p124a.p125a.p126E.C2379X) r7
            k.a.a.a.E.V[] r9 = r10.f3875c
            k.a.a.a.E.g r11 = r7.f3914a
            int r11 = r11.f3917c
            r9 = r9[r11]
            boolean r9 = r9.f3862h
            if (r9 == 0) goto L_0x035b
            int r9 = r7.f3863b
            if (r9 != 0) goto L_0x035b
            goto L_0x035c
        L_0x035b:
            r11 = -1
        L_0x035c:
            k.a.a.a.E.s r9 = new k.a.a.a.E.s
            k.a.a.a.E.g r12 = r7.f3864c
            r9.<init>(r12, r11)
            k.a.a.a.E.W[] r11 = r10.f3876d
            k.a.a.a.E.g r7 = r7.f3914a
            int r7 = r7.f3917c
            r7 = r11[r7]
            r7.mo34155a((p122k.p123a.p124a.p125a.p126E.C2401f0) r9)
        L_0x036e:
            int r5 = r5 + 1
            goto L_0x0339
        L_0x0371:
            java.util.List<k.a.a.a.E.g> r1 = r10.f3873a
            java.util.Iterator r1 = r1.iterator()
        L_0x0377:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x03dd
            java.lang.Object r3 = r1.next()
            k.a.a.a.E.g r3 = (p122k.p123a.p124a.p125a.p126E.C2403g) r3
            boolean r5 = r3 instanceof p122k.p123a.p124a.p125a.p126E.C2413p
            if (r5 == 0) goto L_0x03a1
            r5 = r3
            k.a.a.a.E.p r5 = (p122k.p123a.p124a.p125a.p126E.C2413p) r5
            k.a.a.a.E.o r7 = r5.f3930i
            if (r7 == 0) goto L_0x039b
            k.a.a.a.E.p r9 = r7.f3929g
            if (r9 != 0) goto L_0x0395
            r7.f3929g = r5
            goto L_0x03a1
        L_0x0395:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x039b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x03a1:
            boolean r5 = r3 instanceof p122k.p123a.p124a.p125a.p126E.C2368N
            if (r5 == 0) goto L_0x03bf
            k.a.a.a.E.N r3 = (p122k.p123a.p124a.p125a.p126E.C2368N) r3
            r5 = 0
        L_0x03a8:
            int r7 = r3.mo34153a()
            if (r5 >= r7) goto L_0x0377
            k.a.a.a.E.f0 r7 = r3.mo34154a((int) r5)
            k.a.a.a.E.g r7 = r7.f3914a
            boolean r9 = r7 instanceof p122k.p123a.p124a.p125a.p126E.C2367M
            if (r9 == 0) goto L_0x03bc
            k.a.a.a.E.M r7 = (p122k.p123a.p124a.p125a.p126E.C2367M) r7
            r7.f3846j = r3
        L_0x03bc:
            int r5 = r5 + 1
            goto L_0x03a8
        L_0x03bf:
            boolean r5 = r3 instanceof p122k.p123a.p124a.p125a.p126E.C2397d0
            if (r5 == 0) goto L_0x0377
            k.a.a.a.E.d0 r3 = (p122k.p123a.p124a.p125a.p126E.C2397d0) r3
            r5 = 0
        L_0x03c6:
            int r7 = r3.mo34153a()
            if (r5 >= r7) goto L_0x0377
            k.a.a.a.E.f0 r7 = r3.mo34154a((int) r5)
            k.a.a.a.E.g r7 = r7.f3914a
            boolean r9 = r7 instanceof p122k.p123a.p124a.p125a.p126E.C2395c0
            if (r9 == 0) goto L_0x03da
            k.a.a.a.E.c0 r7 = (p122k.p123a.p124a.p125a.p126E.C2395c0) r7
            r7.f3899i = r3
        L_0x03da:
            int r5 = r5 + 1
            goto L_0x03c6
        L_0x03dd:
            int r1 = r8 + 1
            char r3 = r2[r8]
            r5 = 1
        L_0x03e2:
            if (r5 > r3) goto L_0x03fd
            int r7 = r1 + 1
            char r1 = r2[r1]
            java.util.List<k.a.a.a.E.g> r8 = r10.f3873a
            java.lang.Object r1 = r8.get(r1)
            k.a.a.a.E.q r1 = (p122k.p123a.p124a.p125a.p126E.C2414q) r1
            java.util.List<k.a.a.a.E.q> r8 = r10.f3874b
            r8.add(r1)
            int r8 = r5 + -1
            r1.f3931g = r8
            int r5 = r5 + 1
            r1 = r7
            goto L_0x03e2
        L_0x03fd:
            k.a.a.a.E.h r3 = r10.f3877e
            k.a.a.a.E.h r5 = p122k.p123a.p124a.p125a.p126E.C2405h.LEXER
            if (r3 != r5) goto L_0x04d1
            if (r6 == 0) goto L_0x0479
            int r3 = r1 + 1
            char r1 = r2[r1]
            k.a.a.a.E.w[] r1 = new p122k.p123a.p124a.p125a.p126E.C2421w[r1]
            r10.f3880h = r1
            r1 = 0
        L_0x040e:
            k.a.a.a.E.w[] r5 = r10.f3880h
            int r5 = r5.length
            if (r1 >= r5) goto L_0x04d1
            k.a.a.a.E.y[] r5 = p122k.p123a.p124a.p125a.p126E.C2423y.m4122a()
            int r6 = r3 + 1
            char r3 = r2[r3]
            r3 = r5[r3]
            int r5 = r6 + 1
            char r6 = r2[r6]
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r6 != r7) goto L_0x0427
            r6 = -1
        L_0x0427:
            int r8 = r5 + 1
            char r5 = r2[r5]
            if (r5 != r7) goto L_0x042e
            r5 = -1
        L_0x042e:
            int r9 = r3.ordinal()
            switch(r9) {
                case 0: goto L_0x046c;
                case 1: goto L_0x0466;
                case 2: goto L_0x0460;
                case 3: goto L_0x045d;
                case 4: goto L_0x045a;
                case 5: goto L_0x0454;
                case 6: goto L_0x0451;
                case 7: goto L_0x044b;
                default: goto L_0x0435;
            }
        L_0x0435:
            java.util.Locale r1 = java.util.Locale.getDefault()
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r4 = 0
            r2[r4] = r3
            java.lang.String r3 = "The specified lexer action type %d is not valid."
            java.lang.String r1 = java.lang.String.format(r1, r3, r2)
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            r2.<init>(r1)
            throw r2
        L_0x044b:
            k.a.a.a.E.H r3 = new k.a.a.a.E.H
            r3.<init>(r6)
            goto L_0x0471
        L_0x0451:
            k.a.a.a.E.G r3 = p122k.p123a.p124a.p125a.p126E.C2360G.f3834a
            goto L_0x0471
        L_0x0454:
            k.a.a.a.E.F r3 = new k.a.a.a.E.F
            r3.<init>(r6)
            goto L_0x0471
        L_0x045a:
            k.a.a.a.E.E r3 = p122k.p123a.p124a.p125a.p126E.C2358E.f3832a
            goto L_0x0471
        L_0x045d:
            k.a.a.a.E.D r3 = p122k.p123a.p124a.p125a.p126E.C2357D.f3831a
            goto L_0x0471
        L_0x0460:
            k.a.a.a.E.C r3 = new k.a.a.a.E.C
            r3.<init>(r6)
            goto L_0x0471
        L_0x0466:
            k.a.a.a.E.A r3 = new k.a.a.a.E.A
            r3.<init>(r6, r5)
            goto L_0x0471
        L_0x046c:
            k.a.a.a.E.z r3 = new k.a.a.a.E.z
            r3.<init>(r6)
        L_0x0471:
            k.a.a.a.E.w[] r5 = r10.f3880h
            r5[r1] = r3
            int r1 = r1 + 1
            r3 = r8
            goto L_0x040e
        L_0x0479:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List<k.a.a.a.E.g> r2 = r10.f3873a
            java.util.Iterator r2 = r2.iterator()
        L_0x0484:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04c3
            java.lang.Object r3 = r2.next()
            k.a.a.a.E.g r3 = (p122k.p123a.p124a.p125a.p126E.C2403g) r3
            r5 = 0
        L_0x0491:
            int r6 = r3.mo34153a()
            if (r5 >= r6) goto L_0x0484
            k.a.a.a.E.f0 r6 = r3.mo34154a((int) r5)
            boolean r7 = r6 instanceof p122k.p123a.p124a.p125a.p126E.C2407j
            if (r7 != 0) goto L_0x04a0
            goto L_0x04c0
        L_0x04a0:
            r7 = r6
            k.a.a.a.E.j r7 = (p122k.p123a.p124a.p125a.p126E.C2407j) r7
            int r8 = r7.f3924b
            int r7 = r7.f3925c
            k.a.a.a.E.A r9 = new k.a.a.a.E.A
            r9.<init>(r8, r7)
            k.a.a.a.E.j r7 = new k.a.a.a.E.j
            k.a.a.a.E.g r6 = r6.f3914a
            int r11 = r1.size()
            r12 = 0
            r7.<init>(r6, r8, r11, r12)
            java.util.List<k.a.a.a.E.f0> r6 = r3.f3919e
            r6.set(r5, r7)
            r1.add(r9)
        L_0x04c0:
            int r5 = r5 + 1
            goto L_0x0491
        L_0x04c3:
            int r2 = r1.size()
            k.a.a.a.E.w[] r2 = new p122k.p123a.p124a.p125a.p126E.C2421w[r2]
            java.lang.Object[] r1 = r1.toArray(r2)
            k.a.a.a.E.w[] r1 = (p122k.p123a.p124a.p125a.p126E.C2421w[]) r1
            r10.f3880h = r1
        L_0x04d1:
            java.util.List<k.a.a.a.E.g> r1 = r10.f3873a
            java.util.Iterator r1 = r1.iterator()
        L_0x04d7:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0517
            java.lang.Object r2 = r1.next()
            k.a.a.a.E.g r2 = (p122k.p123a.p124a.p125a.p126E.C2403g) r2
            boolean r3 = r2 instanceof p122k.p123a.p124a.p125a.p126E.C2395c0
            if (r3 != 0) goto L_0x04e8
            goto L_0x04d7
        L_0x04e8:
            k.a.a.a.E.V[] r3 = r10.f3875c
            int r5 = r2.f3917c
            r3 = r3[r5]
            boolean r3 = r3.f3862h
            if (r3 == 0) goto L_0x04d7
            int r3 = r2.mo34153a()
            r5 = 1
            int r3 = r3 - r5
            k.a.a.a.E.f0 r3 = r2.mo34154a((int) r3)
            k.a.a.a.E.g r3 = r3.f3914a
            boolean r5 = r3 instanceof p122k.p123a.p124a.p125a.p126E.C2362I
            if (r5 == 0) goto L_0x04d7
            boolean r5 = r3.f3918d
            if (r5 == 0) goto L_0x04d7
            r5 = 0
            k.a.a.a.E.f0 r3 = r3.mo34154a((int) r5)
            k.a.a.a.E.g r3 = r3.f3914a
            boolean r3 = r3 instanceof p122k.p123a.p124a.p125a.p126E.C2378W
            if (r3 == 0) goto L_0x04d7
            k.a.a.a.E.c0 r2 = (p122k.p123a.p124a.p125a.p126E.C2395c0) r2
            r3 = 1
            r2.f3900j = r3
            goto L_0x04d7
        L_0x0517:
            k.a.a.a.E.d r1 = r0.f3910a
            boolean r1 = r1.mo34147b()
            if (r1 == 0) goto L_0x0522
            r0.mo34149a((p122k.p123a.p124a.p125a.p126E.C2387a) r10)
        L_0x0522:
            k.a.a.a.E.d r1 = r0.f3910a
            boolean r1 = r1.mo34146a()
            if (r1 == 0) goto L_0x0664
            k.a.a.a.E.h r1 = r10.f3877e
            k.a.a.a.E.h r2 = p122k.p123a.p124a.p125a.p126E.C2405h.PARSER
            if (r1 != r2) goto L_0x0664
            k.a.a.a.E.V[] r1 = r10.f3875c
            int r1 = r1.length
            int[] r1 = new int[r1]
            r10.f3879g = r1
            r1 = 0
        L_0x0538:
            k.a.a.a.E.V[] r2 = r10.f3875c
            int r2 = r2.length
            if (r1 >= r2) goto L_0x0549
            int[] r2 = r10.f3879g
            int r3 = r10.f3878f
            int r3 = r3 + r1
            r5 = 1
            int r3 = r3 + r5
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x0538
        L_0x0549:
            r1 = 0
        L_0x054a:
            k.a.a.a.E.V[] r2 = r10.f3875c
            int r2 = r2.length
            if (r1 >= r2) goto L_0x0659
            k.a.a.a.E.m r2 = new k.a.a.a.E.m
            r2.<init>()
            r2.f3917c = r1
            r10.mo34115a((p122k.p123a.p124a.p125a.p126E.C2403g) r2)
            k.a.a.a.E.o r3 = new k.a.a.a.E.o
            r3.<init>()
            r3.f3917c = r1
            r10.mo34115a((p122k.p123a.p124a.p125a.p126E.C2403g) r3)
            r2.f3930i = r3
            java.util.List<k.a.a.a.E.q> r5 = r10.f3874b
            r5.add(r2)
            java.util.List<k.a.a.a.E.q> r5 = r10.f3874b
            int r5 = r5.size()
            int r5 = r5 + r4
            r2.f3931g = r5
            r3.f3929g = r2
            k.a.a.a.E.V[] r5 = r10.f3875c
            r5 = r5[r1]
            boolean r5 = r5.f3862h
            if (r5 == 0) goto L_0x05d0
            java.util.List<k.a.a.a.E.g> r5 = r10.f3873a
            java.util.Iterator r5 = r5.iterator()
        L_0x0583:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x05ba
            java.lang.Object r6 = r5.next()
            k.a.a.a.E.g r6 = (p122k.p123a.p124a.p125a.p126E.C2403g) r6
            int r7 = r6.f3917c
            if (r7 == r1) goto L_0x0594
            goto L_0x0583
        L_0x0594:
            boolean r7 = r6 instanceof p122k.p123a.p124a.p125a.p126E.C2395c0
            if (r7 != 0) goto L_0x0599
            goto L_0x0583
        L_0x0599:
            int r7 = r6.mo34153a()
            r8 = 1
            int r7 = r7 - r8
            k.a.a.a.E.f0 r7 = r6.mo34154a((int) r7)
            k.a.a.a.E.g r7 = r7.f3914a
            boolean r8 = r7 instanceof p122k.p123a.p124a.p125a.p126E.C2362I
            if (r8 != 0) goto L_0x05aa
            goto L_0x0583
        L_0x05aa:
            boolean r8 = r7.f3918d
            if (r8 == 0) goto L_0x0583
            r8 = 0
            k.a.a.a.E.f0 r7 = r7.mo34154a((int) r8)
            k.a.a.a.E.g r7 = r7.f3914a
            boolean r7 = r7 instanceof p122k.p123a.p124a.p125a.p126E.C2378W
            if (r7 == 0) goto L_0x0583
            goto L_0x05bc
        L_0x05ba:
            r8 = 0
            r6 = 0
        L_0x05bc:
            if (r6 == 0) goto L_0x05c8
            r5 = r6
            k.a.a.a.E.c0 r5 = (p122k.p123a.p124a.p125a.p126E.C2395c0) r5
            k.a.a.a.E.d0 r5 = r5.f3899i
            k.a.a.a.E.f0 r5 = r5.mo34154a((int) r8)
            goto L_0x05d5
        L_0x05c8:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Couldn't identify final state of the precedence rule prefix section."
            r1.<init>(r2)
            throw r1
        L_0x05d0:
            k.a.a.a.E.W[] r5 = r10.f3876d
            r6 = r5[r1]
            r5 = 0
        L_0x05d5:
            java.util.List<k.a.a.a.E.g> r7 = r10.f3873a
            java.util.Iterator r7 = r7.iterator()
        L_0x05db:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0603
            java.lang.Object r8 = r7.next()
            k.a.a.a.E.g r8 = (p122k.p123a.p124a.p125a.p126E.C2403g) r8
            java.util.List<k.a.a.a.E.f0> r8 = r8.f3919e
            java.util.Iterator r8 = r8.iterator()
        L_0x05ed:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x05db
            java.lang.Object r9 = r8.next()
            k.a.a.a.E.f0 r9 = (p122k.p123a.p124a.p125a.p126E.C2401f0) r9
            if (r9 != r5) goto L_0x05fc
            goto L_0x05ed
        L_0x05fc:
            k.a.a.a.E.g r11 = r9.f3914a
            if (r11 != r6) goto L_0x05ed
            r9.f3914a = r3
            goto L_0x05ed
        L_0x0603:
            k.a.a.a.E.V[] r5 = r10.f3875c
            r5 = r5[r1]
            int r5 = r5.mo34153a()
            if (r5 <= 0) goto L_0x0625
            k.a.a.a.E.V[] r5 = r10.f3875c
            r7 = r5[r1]
            r5 = r5[r1]
            int r5 = r5.mo34153a()
            r8 = 1
            int r5 = r5 - r8
            java.util.List<k.a.a.a.E.f0> r7 = r7.f3919e
            java.lang.Object r5 = r7.remove(r5)
            k.a.a.a.E.f0 r5 = (p122k.p123a.p124a.p125a.p126E.C2401f0) r5
            r2.mo34155a((p122k.p123a.p124a.p125a.p126E.C2401f0) r5)
            goto L_0x0603
        L_0x0625:
            k.a.a.a.E.V[] r5 = r10.f3875c
            r5 = r5[r1]
            k.a.a.a.E.s r7 = new k.a.a.a.E.s
            r7.<init>(r2)
            r5.mo34155a((p122k.p123a.p124a.p125a.p126E.C2401f0) r7)
            k.a.a.a.E.s r5 = new k.a.a.a.E.s
            r5.<init>(r6)
            r3.mo34155a((p122k.p123a.p124a.p125a.p126E.C2401f0) r5)
            k.a.a.a.E.n r5 = new k.a.a.a.E.n
            r5.<init>()
            r10.mo34115a((p122k.p123a.p124a.p125a.p126E.C2403g) r5)
            k.a.a.a.E.l r6 = new k.a.a.a.E.l
            int[] r7 = r10.f3879g
            r7 = r7[r1]
            r6.<init>(r3, r7)
            r5.mo34155a((p122k.p123a.p124a.p125a.p126E.C2401f0) r6)
            k.a.a.a.E.s r3 = new k.a.a.a.E.s
            r3.<init>(r5)
            r2.mo34155a((p122k.p123a.p124a.p125a.p126E.C2401f0) r3)
            int r1 = r1 + 1
            goto L_0x054a
        L_0x0659:
            k.a.a.a.E.d r1 = r0.f3910a
            boolean r1 = r1.mo34147b()
            if (r1 == 0) goto L_0x0664
            r0.mo34149a((p122k.p123a.p124a.p125a.p126E.C2387a) r10)
        L_0x0664:
            return r10
        L_0x0665:
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r4 = 0
            r3[r4] = r5
            java.util.UUID r4 = f3909g
            r5 = 1
            r3[r5] = r4
            java.lang.String r4 = "Could not deserialize ATN with UUID %s (expected %s or a legacy UUID)."
            java.lang.String r2 = java.lang.String.format(r2, r4, r3)
            java.lang.UnsupportedOperationException r3 = new java.lang.UnsupportedOperationException
            java.io.InvalidClassException r4 = new java.io.InvalidClassException
            java.lang.String r1 = r1.getName()
            r4.<init>(r1, r2)
            r3.<init>(r4)
            throw r3
        L_0x0688:
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.Object[] r3 = new java.lang.Object[r6]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            r5 = 0
            r3[r5] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r5 = 1
            r3[r5] = r4
            java.lang.String r4 = "Could not deserialize ATN with version %d (expected %d)."
            java.lang.String r2 = java.lang.String.format(r2, r4, r3)
            java.lang.UnsupportedOperationException r3 = new java.lang.UnsupportedOperationException
            java.io.InvalidClassException r4 = new java.io.InvalidClassException
            java.lang.String r1 = r1.getName()
            r4.<init>(r1, r2)
            r3.<init>(r4)
            goto L_0x06b2
        L_0x06b1:
            throw r3
        L_0x06b2:
            goto L_0x06b1
        */
        throw new UnsupportedOperationException("Method not decompiled: p122k.p123a.p124a.p125a.p126E.C2398e.mo34148a(char[]):k.a.a.a.E.a");
    }

    /* renamed from: a */
    protected static long m4062a(char[] cArr, int i) {
        int i2 = i + 2;
        return (((long) ((cArr[i2 + 1] << 16) | cArr[i2])) << 32) | (((long) (cArr[i] | (cArr[i + 1] << 16))) & 4294967295L);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00fe, code lost:
        if (r0.f3931g < 0) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0109, code lost:
        if ((r0 instanceof p122k.p123a.p124a.p125a.p126E.C2378W) == false) goto L_0x010c;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo34149a(p122k.p123a.p124a.p125a.p126E.C2387a r7) {
        /*
            r6 = this;
            java.util.List<k.a.a.a.E.g> r7 = r7.f3873a
            java.util.Iterator r7 = r7.iterator()
        L_0x0006:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0111
            java.lang.Object r0 = r7.next()
            k.a.a.a.E.g r0 = (p122k.p123a.p124a.p125a.p126E.C2403g) r0
            if (r0 != 0) goto L_0x0015
            goto L_0x0006
        L_0x0015:
            boolean r1 = r0.f3918d
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0024
            int r1 = r0.mo34153a()
            if (r1 > r3) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r1 = 0
            goto L_0x0025
        L_0x0024:
            r1 = 1
        L_0x0025:
            r6.mo34150a((boolean) r1)
            boolean r1 = r0 instanceof p122k.p123a.p124a.p125a.p126E.C2367M
            if (r1 == 0) goto L_0x0039
            r1 = r0
            k.a.a.a.E.M r1 = (p122k.p123a.p124a.p125a.p126E.C2367M) r1
            k.a.a.a.E.N r1 = r1.f3846j
            if (r1 == 0) goto L_0x0035
            r1 = 1
            goto L_0x0036
        L_0x0035:
            r1 = 0
        L_0x0036:
            r6.mo34150a((boolean) r1)
        L_0x0039:
            boolean r1 = r0 instanceof p122k.p123a.p124a.p125a.p126E.C2395c0
            if (r1 == 0) goto L_0x0091
            r1 = r0
            k.a.a.a.E.c0 r1 = (p122k.p123a.p124a.p125a.p126E.C2395c0) r1
            k.a.a.a.E.d0 r4 = r1.f3899i
            if (r4 == 0) goto L_0x0046
            r4 = 1
            goto L_0x0047
        L_0x0046:
            r4 = 0
        L_0x0047:
            r6.mo34150a((boolean) r4)
            int r4 = r1.mo34153a()
            r5 = 2
            if (r4 != r5) goto L_0x0053
            r4 = 1
            goto L_0x0054
        L_0x0053:
            r4 = 0
        L_0x0054:
            r6.mo34150a((boolean) r4)
            k.a.a.a.E.f0 r4 = r1.mo34154a((int) r2)
            k.a.a.a.E.g r4 = r4.f3914a
            boolean r4 = r4 instanceof p122k.p123a.p124a.p125a.p126E.C2390b0
            if (r4 == 0) goto L_0x0070
            k.a.a.a.E.f0 r4 = r1.mo34154a((int) r3)
            k.a.a.a.E.g r4 = r4.f3914a
            boolean r4 = r4 instanceof p122k.p123a.p124a.p125a.p126E.C2362I
            r6.mo34150a((boolean) r4)
            boolean r1 = r1.f3932h
            r1 = r1 ^ r3
            goto L_0x0087
        L_0x0070:
            k.a.a.a.E.f0 r4 = r1.mo34154a((int) r2)
            k.a.a.a.E.g r4 = r4.f3914a
            boolean r4 = r4 instanceof p122k.p123a.p124a.p125a.p126E.C2362I
            if (r4 == 0) goto L_0x008b
            k.a.a.a.E.f0 r4 = r1.mo34154a((int) r3)
            k.a.a.a.E.g r4 = r4.f3914a
            boolean r4 = r4 instanceof p122k.p123a.p124a.p125a.p126E.C2390b0
            r6.mo34150a((boolean) r4)
            boolean r1 = r1.f3932h
        L_0x0087:
            r6.mo34150a((boolean) r1)
            goto L_0x0091
        L_0x008b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>()
            throw r7
        L_0x0091:
            boolean r1 = r0 instanceof p122k.p123a.p124a.p125a.p126E.C2397d0
            if (r1 == 0) goto L_0x00ac
            int r1 = r0.mo34153a()
            if (r1 != r3) goto L_0x009d
            r1 = 1
            goto L_0x009e
        L_0x009d:
            r1 = 0
        L_0x009e:
            r6.mo34150a((boolean) r1)
            k.a.a.a.E.f0 r1 = r0.mo34154a((int) r2)
            k.a.a.a.E.g r1 = r1.f3914a
            boolean r1 = r1 instanceof p122k.p123a.p124a.p125a.p126E.C2395c0
            r6.mo34150a((boolean) r1)
        L_0x00ac:
            boolean r1 = r0 instanceof p122k.p123a.p124a.p125a.p126E.C2362I
            if (r1 == 0) goto L_0x00bd
            r1 = r0
            k.a.a.a.E.I r1 = (p122k.p123a.p124a.p125a.p126E.C2362I) r1
            k.a.a.a.E.g r1 = r1.f3836g
            if (r1 == 0) goto L_0x00b9
            r1 = 1
            goto L_0x00ba
        L_0x00b9:
            r1 = 0
        L_0x00ba:
            r6.mo34150a((boolean) r1)
        L_0x00bd:
            boolean r1 = r0 instanceof p122k.p123a.p124a.p125a.p126E.C2377V
            if (r1 == 0) goto L_0x00ce
            r1 = r0
            k.a.a.a.E.V r1 = (p122k.p123a.p124a.p125a.p126E.C2377V) r1
            k.a.a.a.E.W r1 = r1.f3861g
            if (r1 == 0) goto L_0x00ca
            r1 = 1
            goto L_0x00cb
        L_0x00ca:
            r1 = 0
        L_0x00cb:
            r6.mo34150a((boolean) r1)
        L_0x00ce:
            boolean r1 = r0 instanceof p122k.p123a.p124a.p125a.p126E.C2413p
            if (r1 == 0) goto L_0x00df
            r1 = r0
            k.a.a.a.E.p r1 = (p122k.p123a.p124a.p125a.p126E.C2413p) r1
            k.a.a.a.E.o r1 = r1.f3930i
            if (r1 == 0) goto L_0x00db
            r1 = 1
            goto L_0x00dc
        L_0x00db:
            r1 = 0
        L_0x00dc:
            r6.mo34150a((boolean) r1)
        L_0x00df:
            boolean r1 = r0 instanceof p122k.p123a.p124a.p125a.p126E.C2412o
            if (r1 == 0) goto L_0x00f0
            r1 = r0
            k.a.a.a.E.o r1 = (p122k.p123a.p124a.p125a.p126E.C2412o) r1
            k.a.a.a.E.p r1 = r1.f3929g
            if (r1 == 0) goto L_0x00ec
            r1 = 1
            goto L_0x00ed
        L_0x00ec:
            r1 = 0
        L_0x00ed:
            r6.mo34150a((boolean) r1)
        L_0x00f0:
            boolean r1 = r0 instanceof p122k.p123a.p124a.p125a.p126E.C2414q
            if (r1 == 0) goto L_0x0101
            k.a.a.a.E.q r0 = (p122k.p123a.p124a.p125a.p126E.C2414q) r0
            int r1 = r0.mo34153a()
            if (r1 <= r3) goto L_0x010b
            int r0 = r0.f3931g
            if (r0 < 0) goto L_0x010c
            goto L_0x010b
        L_0x0101:
            int r1 = r0.mo34153a()
            if (r1 <= r3) goto L_0x010b
            boolean r0 = r0 instanceof p122k.p123a.p124a.p125a.p126E.C2378W
            if (r0 == 0) goto L_0x010c
        L_0x010b:
            r2 = 1
        L_0x010c:
            r6.mo34150a((boolean) r2)
            goto L_0x0006
        L_0x0111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p122k.p123a.p124a.p125a.p126E.C2398e.mo34149a(k.a.a.a.E.a):void");
    }
}
