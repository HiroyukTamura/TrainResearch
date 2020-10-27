package p122k.p123a.p124a.p125a.p126E;

import java.util.Iterator;
import p122k.p123a.p124a.p125a.C2457f;
import p122k.p123a.p124a.p125a.C2466o;
import p122k.p123a.p124a.p125a.C2467p;
import p122k.p123a.p124a.p125a.p127F.C2426b;
import p122k.p123a.p124a.p125a.p127F.C2428d;

/* renamed from: k.a.a.a.E.v */
public class C2419v extends C2400f {

    /* renamed from: k */
    public static int f3937k;

    /* renamed from: d */
    protected final C2466o f3938d;

    /* renamed from: e */
    protected int f3939e = -1;

    /* renamed from: f */
    protected int f3940f = 1;

    /* renamed from: g */
    protected int f3941g = 0;

    /* renamed from: h */
    public final C2426b[] f3942h;

    /* renamed from: i */
    protected int f3943i = 0;

    /* renamed from: j */
    protected final C2420a f3944j = new C2420a();

    /* renamed from: k.a.a.a.E.v$a */
    protected static class C2420a {

        /* renamed from: a */
        protected int f3945a = -1;

        /* renamed from: b */
        protected int f3946b = 0;

        /* renamed from: c */
        protected int f3947c = -1;

        /* renamed from: d */
        protected C2428d f3948d;

        protected C2420a() {
        }
    }

    public C2419v(C2466o oVar, C2387a aVar, C2426b[] bVarArr, C2372S s) {
        super(aVar, s);
        this.f3942h = bVarArr;
        this.f3938d = oVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C2428d mo34170a(C2391c cVar) {
        C2389b bVar;
        C2428d dVar = new C2428d(cVar);
        Iterator<C2389b> it = cVar.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar.f3884a instanceof C2378W) {
                break;
            }
        }
        if (bVar != null) {
            dVar.f3971d = true;
            dVar.f3973f = ((C2418u) bVar).mo34166c();
            dVar.f3972e = this.f3912a.f3879g[bVar.f3884a.f3917c];
        }
        C2426b bVar2 = this.f3942h[this.f3943i];
        synchronized (bVar2.f3961a) {
            C2428d dVar2 = bVar2.f3961a.get(dVar);
            if (dVar2 != null) {
                return dVar2;
            }
            dVar.f3968a = bVar2.f3961a.size();
            cVar.f3889a = true;
            cVar.f3890b = null;
            dVar.f3969b = cVar;
            bVar2.f3961a.put(dVar, dVar);
            return dVar;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34171a(C2428d dVar, int i, C2428d dVar2) {
        if (i >= 0 && i <= 127) {
            synchronized (dVar) {
                if (dVar.f3970c == null) {
                    dVar.f3970c = new C2428d[128];
                }
                dVar.f3970c[i + 0] = dVar2;
            }
        }
    }

    /* renamed from: a */
    public void mo34172a(C2457f fVar) {
        if (fVar.mo34284b(1) == 10) {
            this.f3940f++;
            this.f3941g = 0;
        } else {
            this.f3941g++;
        }
        fVar.mo34285d();
    }

    /* renamed from: b */
    public int mo34174b() {
        return this.f3941g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo34175b(C2457f fVar) {
        C2403g gVar = this.f3912a.f3881i.get(this.f3943i);
        C2415r rVar = C2371Q.f3851b;
        C2364K k = new C2364K();
        int i = 0;
        while (i < gVar.mo34153a()) {
            int i2 = i + 1;
            mo34173a(fVar, new C2418u(gVar.mo34154a(i).f3914a, i2, (C2371Q) rVar), k, false, false, false);
            i = i2;
        }
        boolean z = k.f3894f;
        k.f3894f = false;
        C2428d a = mo34170a((C2391c) k);
        if (!z) {
            this.f3942h[this.f3943i].f3962b = a;
        }
        return mo34169a(fVar, a);
    }

    /* renamed from: c */
    public int mo34176c() {
        return this.f3940f;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0150, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0152, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0153, code lost:
        if (r3 == null) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0155, code lost:
        r5 = mo34173a(r17, r3, r19, r5, r21, r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0164, code lost:
        r15 = r15 + 1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo34173a(p122k.p123a.p124a.p125a.C2457f r17, p122k.p123a.p124a.p125a.p126E.C2418u r18, p122k.p123a.p124a.p125a.p126E.C2391c r19, boolean r20, boolean r21, boolean r22) {
        /*
            r16 = this;
            r8 = r16
            r9 = r17
            r0 = r18
            r10 = r19
            k.a.a.a.E.g r1 = r0.f3884a
            boolean r2 = r1 instanceof p122k.p123a.p124a.p125a.p126E.C2378W
            r11 = 0
            r12 = 0
            r13 = 1
            if (r2 == 0) goto L_0x0086
            k.a.a.a.E.Q r1 = r0.f3886c
            if (r1 == 0) goto L_0x001f
            boolean r1 = r1.mo34085a()
            if (r1 == 0) goto L_0x001c
            goto L_0x001f
        L_0x001c:
            r13 = r20
            goto L_0x0036
        L_0x001f:
            k.a.a.a.E.Q r1 = r0.f3886c
            if (r1 == 0) goto L_0x0082
            boolean r1 = r1.mo34087b()
            if (r1 == 0) goto L_0x002a
            goto L_0x0082
        L_0x002a:
            k.a.a.a.E.u r1 = new k.a.a.a.E.u
            k.a.a.a.E.g r2 = r0.f3884a
            k.a.a.a.E.r r3 = p122k.p123a.p124a.p125a.p126E.C2371Q.f3851b
            r1.<init>((p122k.p123a.p124a.p125a.p126E.C2418u) r0, (p122k.p123a.p124a.p125a.p126E.C2403g) r2, (p122k.p123a.p124a.p125a.p126E.C2371Q) r3)
            r10.mo34126a(r1, r12)
        L_0x0036:
            k.a.a.a.E.Q r1 = r0.f3886c
            if (r1 == 0) goto L_0x0081
            boolean r1 = r1.mo34087b()
            if (r1 != 0) goto L_0x0081
            r5 = r13
        L_0x0041:
            k.a.a.a.E.Q r1 = r0.f3886c
            int r1 = r1.mo34088c()
            if (r11 >= r1) goto L_0x0080
            k.a.a.a.E.Q r1 = r0.f3886c
            int r1 = r1.mo34086b(r11)
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == r2) goto L_0x007d
            k.a.a.a.E.Q r1 = r0.f3886c
            k.a.a.a.E.Q r1 = r1.mo34084a(r11)
            k.a.a.a.E.a r2 = r8.f3912a
            java.util.List<k.a.a.a.E.g> r2 = r2.f3873a
            k.a.a.a.E.Q r3 = r0.f3886c
            int r3 = r3.mo34086b(r11)
            java.lang.Object r2 = r2.get(r3)
            k.a.a.a.E.g r2 = (p122k.p123a.p124a.p125a.p126E.C2403g) r2
            k.a.a.a.E.u r3 = new k.a.a.a.E.u
            r3.<init>((p122k.p123a.p124a.p125a.p126E.C2418u) r0, (p122k.p123a.p124a.p125a.p126E.C2403g) r2, (p122k.p123a.p124a.p125a.p126E.C2371Q) r1)
            r1 = r16
            r2 = r17
            r4 = r19
            r6 = r21
            r7 = r22
            boolean r5 = r1.mo34173a(r2, r3, r4, r5, r6, r7)
        L_0x007d:
            int r11 = r11 + 1
            goto L_0x0041
        L_0x0080:
            r13 = r5
        L_0x0081:
            return r13
        L_0x0082:
            r10.mo34126a(r0, r12)
            return r13
        L_0x0086:
            boolean r1 = r1.f3918d
            if (r1 != 0) goto L_0x0095
            if (r20 == 0) goto L_0x0092
            boolean r1 = r18.mo34167d()
            if (r1 != 0) goto L_0x0095
        L_0x0092:
            r10.mo34126a(r0, r12)
        L_0x0095:
            k.a.a.a.E.g r14 = r0.f3884a
            r5 = r20
            r15 = 0
        L_0x009a:
            int r1 = r14.mo34153a()
            if (r15 >= r1) goto L_0x0170
            k.a.a.a.E.f0 r1 = r14.mo34154a((int) r15)
            int r2 = r1.mo34063a()
            r3 = 10
            if (r2 == r3) goto L_0x0168
            switch(r2) {
                case 1: goto L_0x0149;
                case 2: goto L_0x0135;
                case 3: goto L_0x0120;
                case 4: goto L_0x00e1;
                case 5: goto L_0x0135;
                case 6: goto L_0x00b1;
                case 7: goto L_0x0135;
                default: goto L_0x00af;
            }
        L_0x00af:
            goto L_0x0152
        L_0x00b1:
            k.a.a.a.E.Q r2 = r0.f3886c
            if (r2 == 0) goto L_0x00c5
            boolean r2 = r2.mo34085a()
            if (r2 == 0) goto L_0x00bc
            goto L_0x00c5
        L_0x00bc:
            k.a.a.a.E.u r2 = new k.a.a.a.E.u
            k.a.a.a.E.g r1 = r1.f3914a
            r2.<init>(r0, r1)
            goto L_0x0150
        L_0x00c5:
            k.a.a.a.E.x r2 = r18.mo34166c()
            k.a.a.a.E.a r3 = r8.f3912a
            k.a.a.a.E.w[] r3 = r3.f3880h
            r4 = r1
            k.a.a.a.E.j r4 = (p122k.p123a.p124a.p125a.p126E.C2407j) r4
            int r4 = r4.f3925c
            r3 = r3[r4]
            k.a.a.a.E.x r2 = p122k.p123a.p124a.p125a.p126E.C2422x.m4119a(r2, r3)
            k.a.a.a.E.u r3 = new k.a.a.a.E.u
            k.a.a.a.E.g r1 = r1.f3914a
            r3.<init>((p122k.p123a.p124a.p125a.p126E.C2418u) r0, (p122k.p123a.p124a.p125a.p126E.C2403g) r1, (p122k.p123a.p124a.p125a.p126E.C2422x) r2)
            goto L_0x0153
        L_0x00e1:
            r2 = r1
            k.a.a.a.E.P r2 = (p122k.p123a.p124a.p125a.p126E.C2370P) r2
            r10.f3894f = r13
            k.a.a.a.o r2 = r8.f3938d
            if (r2 != 0) goto L_0x00eb
            goto L_0x010b
        L_0x00eb:
            if (r21 != 0) goto L_0x00ee
            goto L_0x010b
        L_0x00ee:
            int r2 = r8.f3941g
            int r3 = r8.f3940f
            int r4 = r17.mo34283b()
            int r6 = r17.mo34280a()
            r16.mo34172a((p122k.p123a.p124a.p125a.C2457f) r17)     // Catch:{ all -> 0x0114 }
            k.a.a.a.o r7 = r8.f3938d     // Catch:{ all -> 0x0114 }
            if (r7 == 0) goto L_0x0113
            r8.f3941g = r2
            r8.f3940f = r3
            r9.mo34282a(r4)
            r9.mo34286d(r6)
        L_0x010b:
            k.a.a.a.E.u r2 = new k.a.a.a.E.u
            k.a.a.a.E.g r1 = r1.f3914a
            r2.<init>(r0, r1)
            goto L_0x0150
        L_0x0113:
            throw r12     // Catch:{ all -> 0x0114 }
        L_0x0114:
            r0 = move-exception
            r8.f3941g = r2
            r8.f3940f = r3
            r9.mo34282a(r4)
            r9.mo34286d(r6)
            throw r0
        L_0x0120:
            r2 = r1
            k.a.a.a.E.X r2 = (p122k.p123a.p124a.p125a.p126E.C2379X) r2
            k.a.a.a.E.Q r3 = r0.f3886c
            k.a.a.a.E.g r2 = r2.f3864c
            int r2 = r2.f3916b
            k.a.a.a.E.a0 r2 = p122k.p123a.p124a.p125a.p126E.C2388a0.m4041a(r3, r2)
            k.a.a.a.E.u r3 = new k.a.a.a.E.u
            k.a.a.a.E.g r1 = r1.f3914a
            r3.<init>((p122k.p123a.p124a.p125a.p126E.C2418u) r0, (p122k.p123a.p124a.p125a.p126E.C2403g) r1, (p122k.p123a.p124a.p125a.p126E.C2371Q) r2)
            goto L_0x0153
        L_0x0135:
            if (r22 == 0) goto L_0x0152
            r2 = -1
            r3 = 65535(0xffff, float:9.1834E-41)
            boolean r2 = r1.mo34064a(r2, r11, r3)
            if (r2 == 0) goto L_0x0152
            k.a.a.a.E.u r2 = new k.a.a.a.E.u
            k.a.a.a.E.g r1 = r1.f3914a
            r2.<init>(r0, r1)
            goto L_0x0150
        L_0x0149:
            k.a.a.a.E.u r2 = new k.a.a.a.E.u
            k.a.a.a.E.g r1 = r1.f3914a
            r2.<init>(r0, r1)
        L_0x0150:
            r3 = r2
            goto L_0x0153
        L_0x0152:
            r3 = r12
        L_0x0153:
            if (r3 == 0) goto L_0x0164
            r1 = r16
            r2 = r17
            r4 = r19
            r6 = r21
            r7 = r22
            boolean r1 = r1.mo34173a(r2, r3, r4, r5, r6, r7)
            r5 = r1
        L_0x0164:
            int r15 = r15 + 1
            goto L_0x009a
        L_0x0168:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r1 = "Precedence predicates are not supported in lexers."
            r0.<init>(r1)
            throw r0
        L_0x0170:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p122k.p123a.p124a.p125a.p126E.C2419v.mo34173a(k.a.a.a.f, k.a.a.a.E.u, k.a.a.a.E.c, boolean, boolean, boolean):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo34169a(C2457f fVar, C2428d dVar) {
        C2466o oVar;
        int i;
        int i2;
        int i3;
        C2389b bVar;
        C2457f fVar2 = fVar;
        C2428d dVar2 = dVar;
        if (dVar2.f3971d) {
            C2420a aVar = this.f3944j;
            aVar.f3945a = fVar.mo34283b();
            aVar.f3946b = this.f3940f;
            aVar.f3947c = this.f3941g;
            aVar.f3948d = dVar2;
        }
        C2428d dVar3 = dVar2;
        int b = fVar2.mo34284b(1);
        while (true) {
            C2428d[] dVarArr = dVar3.f3970c;
            C2428d dVar4 = (dVarArr == null || b < 0 || b > 127) ? null : dVarArr[b + 0];
            int i4 = -1;
            if (dVar4 == null) {
                C2364K k = new C2364K();
                Iterator<C2389b> it = dVar3.f3969b.iterator();
                int i5 = 0;
                int i6 = 0;
                while (it.hasNext()) {
                    C2389b next = it.next();
                    boolean z = next.f3885b == i6;
                    if (!z || !((C2418u) next).mo34167d()) {
                        int a = next.f3884a.mo34153a();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= a) {
                                break;
                            }
                            C2401f0 a2 = next.f3884a.mo34154a(i7);
                            C2403g gVar = a2.mo34064a(b, i5, 65535) ? a2.f3914a : null;
                            if (gVar != null) {
                                C2418u uVar = (C2418u) next;
                                C2422x c = uVar.mo34166c();
                                if (c != null) {
                                    c = c.mo34177a(fVar.mo34283b() - this.f3939e);
                                }
                                boolean z2 = b == i4;
                                i3 = i7;
                                bVar = next;
                                i2 = i6;
                                i = a;
                                if (mo34173a(fVar, new C2418u(uVar, gVar, c), k, z, true, z2)) {
                                    i6 = bVar.f3885b;
                                    break;
                                }
                            } else {
                                i3 = i7;
                                i = a;
                                bVar = next;
                                i2 = i6;
                            }
                            i7 = i3 + 1;
                            next = bVar;
                            i6 = i2;
                            a = i;
                            i5 = 0;
                            i4 = -1;
                        }
                        i5 = 0;
                        i4 = -1;
                    }
                    i6 = i6;
                    i5 = 0;
                    i4 = -1;
                }
                if (k.isEmpty()) {
                    if (!k.f3894f) {
                        mo34171a(dVar3, b, C2400f.f3911c);
                    }
                    dVar4 = C2400f.f3911c;
                } else {
                    boolean z3 = k.f3894f;
                    k.f3894f = false;
                    C2428d a3 = mo34170a((C2391c) k);
                    if (!z3) {
                        mo34171a(dVar3, b, a3);
                    }
                    dVar4 = a3;
                }
            }
            if (dVar4 == C2400f.f3911c) {
                break;
            }
            if (b != -1) {
                mo34172a(fVar);
            }
            if (dVar4.f3971d) {
                C2420a aVar2 = this.f3944j;
                aVar2.f3945a = fVar.mo34283b();
                aVar2.f3946b = this.f3940f;
                aVar2.f3947c = this.f3941g;
                aVar2.f3948d = dVar4;
                if (b == -1) {
                    break;
                }
            }
            b = fVar2.mo34284b(1);
            dVar3 = dVar4;
        }
        C2420a aVar3 = this.f3944j;
        C2391c cVar = dVar3.f3969b;
        C2428d dVar5 = aVar3.f3948d;
        if (dVar5 != null) {
            C2422x xVar = dVar5.f3973f;
            int i8 = this.f3939e;
            int i9 = aVar3.f3945a;
            int i10 = aVar3.f3946b;
            int i11 = aVar3.f3947c;
            fVar2.mo34282a(i9);
            this.f3940f = i10;
            this.f3941g = i11;
            if (!(xVar == null || (oVar = this.f3938d) == null)) {
                xVar.mo34178a(oVar, fVar2, i8);
            }
            return aVar3.f3948d.f3972e;
        } else if (b == -1 && fVar.mo34283b() == this.f3939e) {
            return -1;
        } else {
            throw new C2467p(this.f3938d, fVar2, this.f3939e, cVar);
        }
    }

    /* renamed from: a */
    public int mo34168a(C2457f fVar, int i) {
        f3937k++;
        this.f3943i = i;
        int a = fVar.mo34280a();
        try {
            this.f3939e = fVar.mo34283b();
            C2420a aVar = this.f3944j;
            aVar.f3945a = -1;
            aVar.f3946b = 0;
            aVar.f3947c = -1;
            aVar.f3948d = null;
            C2426b bVar = this.f3942h[i];
            if (bVar.f3962b == null) {
                return mo34175b(fVar);
            }
            int a2 = mo34169a(fVar, bVar.f3962b);
            fVar.mo34286d(a);
            return a2;
        } finally {
            fVar.mo34286d(a);
        }
    }

    /* renamed from: a */
    public void mo34076a() {
        C2420a aVar = this.f3944j;
        aVar.f3945a = -1;
        aVar.f3946b = 0;
        aVar.f3947c = -1;
        aVar.f3948d = null;
        this.f3939e = -1;
        this.f3940f = 1;
        this.f3941g = 0;
        this.f3943i = 0;
    }
}
