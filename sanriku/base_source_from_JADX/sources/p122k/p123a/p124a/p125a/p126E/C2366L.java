package p122k.p123a.p124a.p125a.p126E;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p122k.p123a.p124a.p125a.C2350A;
import p122k.p123a.p124a.p125a.C2468q;
import p122k.p123a.p124a.p125a.C2469r;
import p122k.p123a.p124a.p125a.C2471s;
import p122k.p123a.p124a.p125a.C2474v;
import p122k.p123a.p124a.p125a.C2476w;
import p122k.p123a.p124a.p125a.p127F.C2426b;
import p122k.p123a.p124a.p125a.p127F.C2428d;
import p122k.p123a.p124a.p125a.p128G.C2433c;
import p122k.p123a.p124a.p125a.p128G.C2440i;

/* renamed from: k.a.a.a.E.L */
public class C2366L extends C2400f {

    /* renamed from: l */
    public static final boolean f3837l = Boolean.parseBoolean(System.getenv("TURN_OFF_LR_LOOP_ENTRY_BRANCH_OPT"));

    /* renamed from: d */
    protected final C2469r f3838d;

    /* renamed from: e */
    public final C2426b[] f3839e;

    /* renamed from: f */
    private C2373T f3840f = C2373T.LL;

    /* renamed from: g */
    protected C2433c<C2371Q, C2371Q, C2371Q> f3841g;

    /* renamed from: h */
    protected C2350A f3842h;

    /* renamed from: i */
    protected int f3843i;

    /* renamed from: j */
    protected C2471s f3844j;

    /* renamed from: k */
    protected C2426b f3845k;

    public C2366L(C2469r rVar, C2387a aVar, C2426b[] bVarArr, C2372S s) {
        super(aVar, s);
        this.f3838d = rVar;
        this.f3839e = bVarArr;
    }

    /* renamed from: c */
    protected static int m3973c(C2391c cVar) {
        Iterator<C2389b> it = cVar.iterator();
        int i = 0;
        while (it.hasNext()) {
            C2389b next = it.next();
            if (i == 0) {
                i = next.f3885b;
            } else if (next.f3885b != i) {
                return 0;
            }
        }
        return i;
    }

    /* renamed from: a */
    public int mo34066a(C2350A a, int i, C2471s sVar) {
        this.f3842h = a;
        this.f3843i = a.mo34283b();
        this.f3844j = sVar;
        C2426b bVar = this.f3839e[i];
        this.f3845k = bVar;
        int a2 = a.mo34280a();
        int i2 = this.f3843i;
        try {
            C2428d a3 = bVar.mo34187a() ? bVar.mo34185a(this.f3838d.mo34339m()) : bVar.f3962b;
            if (a3 == null) {
                if (sVar == null) {
                    sVar = C2476w.f4070c;
                }
                C2391c a4 = mo34072a((C2403g) bVar.f3964d, (C2476w) C2476w.f4070c, false);
                if (bVar.mo34187a()) {
                    bVar.f3962b.f3969b = a4;
                    a3 = mo34073a(bVar, new C2428d(mo34070a(a4)));
                    bVar.mo34186a(this.f3838d.mo34339m(), a3);
                } else {
                    a3 = mo34073a(bVar, new C2428d(a4));
                    bVar.f3962b = a3;
                }
            }
            return mo34068a(bVar, a3, a, i2, sVar);
        } finally {
            this.f3841g = null;
            this.f3845k = null;
            a.mo34282a(i2);
            a.mo34286d(a2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C2428d mo34073a(C2426b bVar, C2428d dVar) {
        if (dVar == C2400f.f3911c) {
            return dVar;
        }
        synchronized (bVar.f3961a) {
            C2428d dVar2 = bVar.f3961a.get(dVar);
            if (dVar2 != null) {
                return dVar2;
            }
            dVar.f3968a = bVar.f3961a.size();
            if (!dVar.f3969b.f3889a) {
                dVar.f3969b.mo34124a((C2400f) this);
                C2391c cVar = dVar.f3969b;
                cVar.f3889a = true;
                cVar.f3890b = null;
            }
            bVar.f3961a.put(dVar, dVar);
            return dVar;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C2428d mo34074a(C2426b bVar, C2428d dVar, int i, C2428d dVar2) {
        if (dVar2 == null) {
            return null;
        }
        C2428d a = mo34073a(bVar, dVar2);
        if (dVar == null || i < -1 || i > this.f3912a.f3878f) {
            return a;
        }
        synchronized (dVar) {
            if (dVar.f3970c == null) {
                dVar.f3970c = new C2428d[(this.f3912a.f3878f + 1 + 1)];
            }
            dVar.f3970c[i + 1] = a;
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C2468q mo34075a(C2350A a, C2471s sVar, C2391c cVar, int i) {
        return new C2468q(this.f3838d, a, a.get(i), a.mo34029c(1), cVar, sVar);
    }

    /* renamed from: a */
    public void mo34076a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34078a(C2426b bVar, int i, int i2, boolean z, BitSet bitSet, C2391c cVar) {
        C2469r rVar = this.f3838d;
        if (rVar != null) {
            rVar.mo34350g().mo34278a(this.f3838d, bVar, i, i2, z, bitSet, cVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo34079b(C2391c cVar) {
        C2440i iVar = new C2440i(new int[0]);
        Iterator<C2389b> it = cVar.iterator();
        while (it.hasNext()) {
            C2389b next = it.next();
            if (next.mo34118a() > 0 || ((next.f3884a instanceof C2378W) && next.f3886c.mo34085a())) {
                iVar.mo34255a(next.f3885b);
            }
        }
        if (iVar.mo34260c() == 0) {
            return 0;
        }
        return iVar.mo34251a();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x025a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0210  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo34080b(p122k.p123a.p124a.p125a.p126E.C2389b r17, p122k.p123a.p124a.p125a.p126E.C2391c r18, java.util.Set<p122k.p123a.p124a.p125a.p126E.C2389b> r19, boolean r20, boolean r21, int r22, boolean r23) {
        /*
            r16 = this;
            r8 = r16
            r9 = r17
            r10 = r18
            r11 = r19
            k.a.a.a.E.g r12 = r9.f3884a
            boolean r0 = r12.f3918d
            if (r0 != 0) goto L_0x0013
            k.a.a.a.G.c<k.a.a.a.E.Q, k.a.a.a.E.Q, k.a.a.a.E.Q> r0 = r8.f3841g
            r10.mo34126a(r9, r0)
        L_0x0013:
            r13 = 0
            r14 = 0
        L_0x0015:
            int r0 = r12.mo34153a()
            if (r14 >= r0) goto L_0x025e
            r0 = 10
            r1 = 1
            if (r14 != 0) goto L_0x00e6
            boolean r2 = f3837l
            if (r2 == 0) goto L_0x0026
            goto L_0x00e1
        L_0x0026:
            k.a.a.a.E.g r2 = r9.f3884a
            int r3 = r2.mo34062b()
            if (r3 != r0) goto L_0x00e1
            r3 = r2
            k.a.a.a.E.c0 r3 = (p122k.p123a.p124a.p125a.p126E.C2395c0) r3
            boolean r3 = r3.f3900j
            if (r3 == 0) goto L_0x00e1
            k.a.a.a.E.Q r3 = r9.f3886c
            boolean r3 = r3.mo34087b()
            if (r3 != 0) goto L_0x00e1
            k.a.a.a.E.Q r3 = r9.f3886c
            boolean r3 = r3.mo34085a()
            if (r3 == 0) goto L_0x0047
            goto L_0x00e1
        L_0x0047:
            k.a.a.a.E.Q r3 = r9.f3886c
            int r3 = r3.mo34088c()
            r4 = 0
        L_0x004e:
            if (r4 >= r3) goto L_0x006b
            k.a.a.a.E.a r5 = r8.f3912a
            java.util.List<k.a.a.a.E.g> r5 = r5.f3873a
            k.a.a.a.E.Q r6 = r9.f3886c
            int r6 = r6.mo34086b(r4)
            java.lang.Object r5 = r5.get(r6)
            k.a.a.a.E.g r5 = (p122k.p123a.p124a.p125a.p126E.C2403g) r5
            int r5 = r5.f3917c
            int r6 = r2.f3917c
            if (r5 == r6) goto L_0x0068
            goto L_0x00e1
        L_0x0068:
            int r4 = r4 + 1
            goto L_0x004e
        L_0x006b:
            k.a.a.a.E.f0 r4 = r2.mo34154a((int) r13)
            k.a.a.a.E.g r4 = r4.f3914a
            k.a.a.a.E.p r4 = (p122k.p123a.p124a.p125a.p126E.C2413p) r4
            k.a.a.a.E.o r4 = r4.f3930i
            int r4 = r4.f3916b
            k.a.a.a.E.a r5 = r8.f3912a
            java.util.List<k.a.a.a.E.g> r5 = r5.f3873a
            java.lang.Object r4 = r5.get(r4)
            k.a.a.a.E.o r4 = (p122k.p123a.p124a.p125a.p126E.C2412o) r4
            r5 = 0
        L_0x0082:
            if (r5 >= r3) goto L_0x00df
            k.a.a.a.E.Q r6 = r9.f3886c
            int r6 = r6.mo34086b(r5)
            k.a.a.a.E.a r7 = r8.f3912a
            java.util.List<k.a.a.a.E.g> r7 = r7.f3873a
            java.lang.Object r6 = r7.get(r6)
            k.a.a.a.E.g r6 = (p122k.p123a.p124a.p125a.p126E.C2403g) r6
            int r7 = r6.mo34153a()
            if (r7 != r1) goto L_0x00e1
            k.a.a.a.E.f0 r7 = r6.mo34154a((int) r13)
            boolean r7 = r7.mo34081b()
            if (r7 != 0) goto L_0x00a5
            goto L_0x00e1
        L_0x00a5:
            k.a.a.a.E.f0 r7 = r6.mo34154a((int) r13)
            k.a.a.a.E.g r7 = r7.f3914a
            int r15 = r6.mo34062b()
            r0 = 8
            if (r15 != r0) goto L_0x00b6
            if (r7 != r2) goto L_0x00b6
            goto L_0x00da
        L_0x00b6:
            if (r6 != r4) goto L_0x00b9
            goto L_0x00da
        L_0x00b9:
            if (r7 != r4) goto L_0x00bc
            goto L_0x00da
        L_0x00bc:
            int r6 = r7.mo34062b()
            if (r6 != r0) goto L_0x00e1
            int r0 = r7.mo34153a()
            if (r0 != r1) goto L_0x00e1
            k.a.a.a.E.f0 r0 = r7.mo34154a((int) r13)
            boolean r0 = r0.mo34081b()
            if (r0 == 0) goto L_0x00e1
            k.a.a.a.E.f0 r0 = r7.mo34154a((int) r13)
            k.a.a.a.E.g r0 = r0.f3914a
            if (r0 != r2) goto L_0x00e1
        L_0x00da:
            int r5 = r5 + 1
            r0 = 10
            goto L_0x0082
        L_0x00df:
            r0 = 1
            goto L_0x00e2
        L_0x00e1:
            r0 = 0
        L_0x00e2:
            if (r0 == 0) goto L_0x00e6
            goto L_0x025a
        L_0x00e6:
            k.a.a.a.E.f0 r0 = r12.mo34154a((int) r14)
            boolean r2 = r0 instanceof p122k.p123a.p124a.p125a.p126E.C2407j
            if (r2 != 0) goto L_0x00f2
            if (r20 == 0) goto L_0x00f2
            r4 = 1
            goto L_0x00f3
        L_0x00f2:
            r4 = 0
        L_0x00f3:
            if (r22 != 0) goto L_0x00f7
            r2 = 1
            goto L_0x00f8
        L_0x00f7:
            r2 = 0
        L_0x00f8:
            int r3 = r0.mo34063a()
            r5 = 10
            if (r3 == r5) goto L_0x01a7
            switch(r3) {
                case 1: goto L_0x019f;
                case 2: goto L_0x018e;
                case 3: goto L_0x0175;
                case 4: goto L_0x0112;
                case 5: goto L_0x018e;
                case 6: goto L_0x0105;
                case 7: goto L_0x018e;
                default: goto L_0x0103;
            }
        L_0x0103:
            goto L_0x01db
        L_0x0105:
            r2 = r0
            k.a.a.a.E.j r2 = (p122k.p123a.p124a.p125a.p126E.C2407j) r2
            k.a.a.a.E.b r3 = new k.a.a.a.E.b
            k.a.a.a.E.g r2 = r2.f3914a
            r3.<init>(r9, r2)
            r2 = r3
            goto L_0x01fb
        L_0x0112:
            r3 = r0
            k.a.a.a.E.P r3 = (p122k.p123a.p124a.p125a.p126E.C2370P) r3
            if (r4 == 0) goto L_0x016c
            boolean r5 = r3.f3850d
            if (r5 == 0) goto L_0x011f
            if (r5 == 0) goto L_0x016c
            if (r2 == 0) goto L_0x016c
        L_0x011f:
            if (r21 == 0) goto L_0x0151
            k.a.a.a.A r2 = r8.f3842h
            int r2 = r2.mo34283b()
            k.a.a.a.A r5 = r8.f3842h
            int r6 = r8.f3843i
            r5.mo34282a(r6)
            k.a.a.a.E.Y$e r5 = new k.a.a.a.E.Y$e
            int r6 = r3.f3848b
            int r7 = r3.f3849c
            boolean r15 = r3.f3850d
            r5.<init>(r6, r7, r15)
            k.a.a.a.s r6 = r8.f3844j
            k.a.a.a.r r7 = r8.f3838d
            boolean r5 = r5.mo34096a((p122k.p123a.p124a.p125a.C2474v<?, ?>) r7, (p122k.p123a.p124a.p125a.C2476w) r6)
            k.a.a.a.A r6 = r8.f3842h
            r6.mo34282a(r2)
            if (r5 == 0) goto L_0x01db
            k.a.a.a.E.b r2 = new k.a.a.a.E.b
            k.a.a.a.E.g r3 = r3.f3914a
            r2.<init>(r9, r3)
            goto L_0x01fb
        L_0x0151:
            k.a.a.a.E.Y r2 = r9.f3888e
            k.a.a.a.E.Y$e r5 = new k.a.a.a.E.Y$e
            int r6 = r3.f3848b
            int r7 = r3.f3849c
            boolean r15 = r3.f3850d
            r5.<init>(r6, r7, r15)
            k.a.a.a.E.Y r2 = p122k.p123a.p124a.p125a.p126E.C2380Y.m4021a((p122k.p123a.p124a.p125a.p126E.C2380Y) r2, (p122k.p123a.p124a.p125a.p126E.C2380Y) r5)
            k.a.a.a.E.b r5 = new k.a.a.a.E.b
            k.a.a.a.E.g r3 = r3.f3914a
            k.a.a.a.E.Q r6 = r9.f3886c
            r5.<init>((p122k.p123a.p124a.p125a.p126E.C2389b) r9, (p122k.p123a.p124a.p125a.p126E.C2403g) r3, (p122k.p123a.p124a.p125a.p126E.C2371Q) r6, (p122k.p123a.p124a.p125a.p126E.C2380Y) r2)
            goto L_0x018b
        L_0x016c:
            k.a.a.a.E.b r2 = new k.a.a.a.E.b
            k.a.a.a.E.g r3 = r3.f3914a
            r2.<init>(r9, r3)
            goto L_0x01fb
        L_0x0175:
            r2 = r0
            k.a.a.a.E.X r2 = (p122k.p123a.p124a.p125a.p126E.C2379X) r2
            k.a.a.a.E.g r3 = r2.f3864c
            k.a.a.a.E.Q r5 = r9.f3886c
            int r3 = r3.f3916b
            k.a.a.a.E.a0 r3 = p122k.p123a.p124a.p125a.p126E.C2388a0.m4041a(r5, r3)
            k.a.a.a.E.b r5 = new k.a.a.a.E.b
            k.a.a.a.E.g r2 = r2.f3914a
            k.a.a.a.E.Y r6 = r9.f3888e
            r5.<init>((p122k.p123a.p124a.p125a.p126E.C2389b) r9, (p122k.p123a.p124a.p125a.p126E.C2403g) r2, (p122k.p123a.p124a.p125a.p126E.C2371Q) r3, (p122k.p123a.p124a.p125a.p126E.C2380Y) r6)
        L_0x018b:
            r2 = r5
            goto L_0x01fb
        L_0x018e:
            if (r23 == 0) goto L_0x01db
            r2 = -1
            boolean r2 = r0.mo34064a(r2, r13, r1)
            if (r2 == 0) goto L_0x01db
            k.a.a.a.E.b r2 = new k.a.a.a.E.b
            k.a.a.a.E.g r3 = r0.f3914a
            r2.<init>(r9, r3)
            goto L_0x01fb
        L_0x019f:
            k.a.a.a.E.b r2 = new k.a.a.a.E.b
            k.a.a.a.E.g r3 = r0.f3914a
            r2.<init>(r9, r3)
            goto L_0x01fb
        L_0x01a7:
            r3 = r0
            k.a.a.a.E.O r3 = (p122k.p123a.p124a.p125a.p126E.C2369O) r3
            if (r4 == 0) goto L_0x01f4
            if (r2 == 0) goto L_0x01f4
            if (r21 == 0) goto L_0x01dd
            k.a.a.a.A r2 = r8.f3842h
            int r2 = r2.mo34283b()
            k.a.a.a.A r5 = r8.f3842h
            int r6 = r8.f3843i
            r5.mo34282a(r6)
            k.a.a.a.E.Y$d r5 = new k.a.a.a.E.Y$d
            int r6 = r3.f3847b
            r5.<init>(r6)
            k.a.a.a.s r6 = r8.f3844j
            k.a.a.a.r r7 = r8.f3838d
            boolean r5 = r5.mo34096a((p122k.p123a.p124a.p125a.C2474v<?, ?>) r7, (p122k.p123a.p124a.p125a.C2476w) r6)
            k.a.a.a.A r6 = r8.f3842h
            r6.mo34282a(r2)
            if (r5 == 0) goto L_0x01db
            k.a.a.a.E.b r2 = new k.a.a.a.E.b
            k.a.a.a.E.g r3 = r3.f3914a
            r2.<init>(r9, r3)
            goto L_0x01fb
        L_0x01db:
            r2 = 0
            goto L_0x01fb
        L_0x01dd:
            k.a.a.a.E.Y r2 = r9.f3888e
            k.a.a.a.E.Y$d r5 = new k.a.a.a.E.Y$d
            int r6 = r3.f3847b
            r5.<init>(r6)
            k.a.a.a.E.Y r2 = p122k.p123a.p124a.p125a.p126E.C2380Y.m4021a((p122k.p123a.p124a.p125a.p126E.C2380Y) r2, (p122k.p123a.p124a.p125a.p126E.C2380Y) r5)
            k.a.a.a.E.b r5 = new k.a.a.a.E.b
            k.a.a.a.E.g r3 = r3.f3914a
            k.a.a.a.E.Q r6 = r9.f3886c
            r5.<init>((p122k.p123a.p124a.p125a.p126E.C2389b) r9, (p122k.p123a.p124a.p125a.p126E.C2403g) r3, (p122k.p123a.p124a.p125a.p126E.C2371Q) r6, (p122k.p123a.p124a.p125a.p126E.C2380Y) r2)
            goto L_0x018b
        L_0x01f4:
            k.a.a.a.E.b r2 = new k.a.a.a.E.b
            k.a.a.a.E.g r3 = r3.f3914a
            r2.<init>(r9, r3)
        L_0x01fb:
            if (r2 == 0) goto L_0x025a
            boolean r3 = r0.mo34081b()
            if (r3 != 0) goto L_0x020a
            boolean r3 = r11.add(r2)
            if (r3 != 0) goto L_0x020a
            goto L_0x025a
        L_0x020a:
            k.a.a.a.E.g r3 = r9.f3884a
            boolean r3 = r3 instanceof p122k.p123a.p124a.p125a.p126E.C2378W
            if (r3 == 0) goto L_0x0240
            boolean r3 = r11.add(r2)
            if (r3 != 0) goto L_0x0217
            goto L_0x025a
        L_0x0217:
            k.a.a.a.F.b r3 = r8.f3845k
            if (r3 == 0) goto L_0x0236
            boolean r3 = r3.mo34187a()
            if (r3 == 0) goto L_0x0236
            k.a.a.a.E.s r0 = (p122k.p123a.p124a.p125a.p126E.C2416s) r0
            int r0 = r0.mo34163d()
            k.a.a.a.F.b r3 = r8.f3845k
            k.a.a.a.E.q r3 = r3.f3964d
            int r3 = r3.f3917c
            if (r0 != r3) goto L_0x0236
            int r0 = r2.f3887d
            r3 = 1073741824(0x40000000, float:2.0)
            r0 = r0 | r3
            r2.f3887d = r0
        L_0x0236:
            int r0 = r2.f3887d
            int r0 = r0 + r1
            r2.f3887d = r0
            r10.f3895g = r1
            int r0 = r22 + -1
            goto L_0x0248
        L_0x0240:
            boolean r0 = r0 instanceof p122k.p123a.p124a.p125a.p126E.C2379X
            if (r0 == 0) goto L_0x024a
            if (r22 < 0) goto L_0x024a
            int r0 = r22 + 1
        L_0x0248:
            r6 = r0
            goto L_0x024c
        L_0x024a:
            r6 = r22
        L_0x024c:
            r0 = r16
            r1 = r2
            r2 = r18
            r3 = r19
            r5 = r21
            r7 = r23
            r0.mo34077a(r1, r2, r3, r4, r5, r6, r7)
        L_0x025a:
            int r14 = r14 + 1
            goto L_0x0015
        L_0x025e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p122k.p123a.p124a.p125a.p126E.C2366L.mo34080b(k.a.a.a.E.b, k.a.a.a.E.c, java.util.Set, boolean, boolean, int, boolean):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C2391c mo34070a(C2391c cVar) {
        C2371Q q;
        C2380Y b;
        HashMap hashMap = new HashMap();
        C2391c cVar2 = new C2391c(cVar.f3896h);
        Iterator<C2389b> it = cVar.iterator();
        while (it.hasNext()) {
            C2389b next = it.next();
            if (next.f3885b == 1 && (b = next.f3888e.mo34097b((C2474v<?, ?>) this.f3838d, (C2476w) this.f3844j)) != null) {
                hashMap.put(Integer.valueOf(next.f3884a.f3916b), next.f3886c);
                if (b != next.f3888e) {
                    cVar2.mo34126a(new C2389b(next, next.f3884a, next.f3886c, b), this.f3841g);
                } else {
                    cVar2.mo34126a(next, this.f3841g);
                }
            }
        }
        Iterator<C2389b> it2 = cVar.iterator();
        while (it2.hasNext()) {
            C2389b next2 = it2.next();
            if (next2.f3885b != 1 && (next2.mo34120b() || (q = (C2371Q) hashMap.get(Integer.valueOf(next2.f3884a.f3916b))) == null || !q.equals(next2.f3886c))) {
                cVar2.mo34126a(next2, this.f3841g);
            }
        }
        return cVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34077a(C2389b bVar, C2391c cVar, Set<C2389b> set, boolean z, boolean z2, int i, boolean z3) {
        C2389b bVar2 = bVar;
        C2391c cVar2 = cVar;
        if (bVar2.f3884a instanceof C2378W) {
            if (!bVar2.f3886c.mo34087b()) {
                for (int i2 = 0; i2 < bVar2.f3886c.mo34088c(); i2++) {
                    if (bVar2.f3886c.mo34086b(i2) != Integer.MAX_VALUE) {
                        C2389b bVar3 = new C2389b(this.f3912a.f3873a.get(bVar2.f3886c.mo34086b(i2)), bVar2.f3885b, bVar2.f3886c.mo34084a(i2), bVar2.f3888e);
                        bVar3.f3887d = bVar2.f3887d;
                        mo34077a(bVar3, cVar, set, z, z2, i - 1, z3);
                    } else if (z2) {
                        cVar.mo34126a(new C2389b(bVar, bVar2.f3884a, (C2371Q) C2371Q.f3851b, bVar2.f3888e), this.f3841g);
                    } else {
                        mo34080b(bVar, cVar, set, z, z2, i, z3);
                    }
                }
                return;
            } else if (z2) {
                cVar.mo34126a(bVar, this.f3841g);
                return;
            }
        }
        mo34080b(bVar, cVar, set, z, z2, i, z3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C2391c mo34071a(C2391c cVar, int i, boolean z) {
        boolean z2;
        int i2 = i;
        boolean z3 = z;
        if (this.f3841g == null) {
            this.f3841g = new C2433c<>();
        }
        C2391c cVar2 = new C2391c(z3);
        Iterator<C2389b> it = cVar.iterator();
        ArrayList<C2389b> arrayList = null;
        while (true) {
            z2 = false;
            if (!it.hasNext()) {
                break;
            }
            C2389b next = it.next();
            C2403g gVar = next.f3884a;
            if (!(gVar instanceof C2378W)) {
                int a = gVar.mo34153a();
                for (int i3 = 0; i3 < a; i3++) {
                    C2401f0 a2 = next.f3884a.mo34154a(i3);
                    C2403g gVar2 = a2.mo34064a(i2, 0, this.f3912a.f3878f) ? a2.f3914a : null;
                    if (gVar2 != null) {
                        cVar2.mo34126a(new C2389b(next, gVar2, next.f3886c, next.f3888e), this.f3841g);
                    }
                }
            } else if (z3 || i2 == -1) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
            }
        }
        C2391c cVar3 = (arrayList != null || i2 == -1 || (cVar2.size() != 1 && m3973c(cVar2) == 0)) ? null : cVar2;
        if (cVar3 == null) {
            C2391c cVar4 = new C2391c(z3);
            HashSet hashSet = new HashSet();
            boolean z4 = i2 == -1;
            Iterator<C2389b> it2 = cVar2.iterator();
            while (it2.hasNext()) {
                mo34077a(it2.next(), cVar4, hashSet, false, z, 0, z4);
                cVar4 = cVar4;
            }
            cVar3 = cVar4;
        }
        if (i2 == -1) {
            if (cVar3 == cVar2) {
                z2 = true;
            }
            if (!C2373T.m4007a(cVar3)) {
                C2391c cVar5 = new C2391c(cVar3.f3896h);
                Iterator<C2389b> it3 = cVar3.iterator();
                while (it3.hasNext()) {
                    C2389b next2 = it3.next();
                    C2403g gVar3 = next2.f3884a;
                    if (gVar3 instanceof C2378W) {
                        cVar5.mo34126a(next2, this.f3841g);
                    } else if (z2 && gVar3.f3918d && this.f3912a.mo34116b(gVar3).mo34259b(-2)) {
                        cVar5.mo34126a(new C2389b(next2, this.f3912a.f3876d[next2.f3884a.f3917c]), this.f3841g);
                    }
                }
                cVar3 = cVar5;
            }
        }
        if (arrayList != null && (!z3 || !C2373T.m4009c(cVar3))) {
            for (C2389b a3 : arrayList) {
                cVar3.mo34126a(a3, this.f3841g);
            }
        }
        if (cVar3.isEmpty()) {
            return null;
        }
        return cVar3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C2391c mo34072a(C2403g gVar, C2476w wVar, boolean z) {
        C2371Q a = C2371Q.m3999a(this.f3912a, wVar);
        C2391c cVar = new C2391c(z);
        int i = 0;
        while (i < gVar.mo34153a()) {
            int i2 = i + 1;
            C2389b bVar = new C2389b(gVar.mo34154a(i).f3914a, i2, a);
            mo34077a(bVar, cVar, new HashSet(), true, z, 0, false);
            i = i2;
        }
        return cVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public BitSet mo34069a(C2428d.C2429a[] aVarArr, C2471s sVar, boolean z) {
        BitSet bitSet = new BitSet();
        for (C2428d.C2429a aVar : aVarArr) {
            C2380Y y = aVar.f3976a;
            if (y == C2380Y.f3865a) {
                bitSet.set(aVar.f3977b);
                if (!z) {
                    break;
                }
            } else if (y.mo34096a((C2474v<?, ?>) this.f3838d, (C2476w) sVar)) {
                bitSet.set(aVar.f3977b);
                if (!z) {
                    break;
                }
            } else {
                continue;
            }
        }
        return bitSet;
    }

    /* JADX WARNING: type inference failed for: r2v30, types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        r4 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f6, code lost:
        if (r5 == false) goto L_0x00f8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fd  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo34068a(p122k.p123a.p124a.p125a.p127F.C2426b r19, p122k.p123a.p124a.p125a.p127F.C2428d r20, p122k.p123a.p124a.p125a.C2350A r21, int r22, p122k.p123a.p124a.p125a.C2471s r23) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            r9 = r21
            r10 = r22
            r11 = r23
            r12 = 1
            int r0 = r9.mo34284b(r12)
            r1 = r0
            r0 = r20
        L_0x0012:
            k.a.a.a.F.d[] r2 = r0.f3970c
            r3 = 0
            if (r2 == 0) goto L_0x0022
            int r4 = r1 + 1
            if (r4 < 0) goto L_0x0022
            int r5 = r2.length
            if (r4 < r5) goto L_0x001f
            goto L_0x0022
        L_0x001f:
            r2 = r2[r4]
            goto L_0x0023
        L_0x0022:
            r2 = r3
        L_0x0023:
            r13 = 0
            if (r2 != 0) goto L_0x01ea
            k.a.a.a.E.c r2 = r0.f3969b
            k.a.a.a.E.c r2 = r7.mo34071a((p122k.p123a.p124a.p125a.p126E.C2391c) r2, (int) r1, (boolean) r13)
            if (r2 != 0) goto L_0x0037
            k.a.a.a.F.d r2 = p122k.p123a.p124a.p125a.p126E.C2400f.f3911c
            r7.mo34074a((p122k.p123a.p124a.p125a.p127F.C2426b) r8, (p122k.p123a.p124a.p125a.p127F.C2428d) r0, (int) r1, (p122k.p123a.p124a.p125a.p127F.C2428d) r2)
            k.a.a.a.F.d r2 = p122k.p123a.p124a.p125a.p126E.C2400f.f3911c
            goto L_0x01ea
        L_0x0037:
            k.a.a.a.F.d r4 = new k.a.a.a.F.d
            r4.<init>(r2)
            int r5 = m3973c(r2)
            if (r5 == 0) goto L_0x004c
            r4.f3971d = r12
            k.a.a.a.E.c r2 = r4.f3969b
            r2.f3892d = r5
            r4.f3972e = r5
            goto L_0x012e
        L_0x004c:
            k.a.a.a.E.T r5 = r7.f3840f
            boolean r6 = p122k.p123a.p124a.p125a.p126E.C2373T.m4007a((p122k.p123a.p124a.p125a.p126E.C2391c) r2)
            if (r6 == 0) goto L_0x0056
            goto L_0x00f8
        L_0x0056:
            k.a.a.a.E.T r6 = p122k.p123a.p124a.p125a.p126E.C2373T.SLL
            if (r5 != r6) goto L_0x0088
            boolean r5 = r2.f3894f
            if (r5 == 0) goto L_0x0088
            k.a.a.a.E.c r5 = new k.a.a.a.E.c
            r5.<init>(r12)
            java.util.Iterator r6 = r2.iterator()
        L_0x0067:
            boolean r14 = r6.hasNext()
            if (r14 == 0) goto L_0x0089
            java.lang.Object r14 = r6.next()
            k.a.a.a.E.b r14 = (p122k.p123a.p124a.p125a.p126E.C2389b) r14
            k.a.a.a.E.b r15 = new k.a.a.a.E.b
            k.a.a.a.E.Y r13 = p122k.p123a.p124a.p125a.p126E.C2380Y.f3865a
            k.a.a.a.E.g r12 = r14.f3884a
            r17 = r6
            k.a.a.a.E.Q r6 = r14.f3886c
            r15.<init>((p122k.p123a.p124a.p125a.p126E.C2389b) r14, (p122k.p123a.p124a.p125a.p126E.C2403g) r12, (p122k.p123a.p124a.p125a.p126E.C2371Q) r6, (p122k.p123a.p124a.p125a.p126E.C2380Y) r13)
            r5.mo34126a(r15, r3)
            r6 = r17
            r12 = 1
            r13 = 0
            goto L_0x0067
        L_0x0088:
            r5 = r2
        L_0x0089:
            java.util.Collection r6 = p122k.p123a.p124a.p125a.p126E.C2373T.m4008b(r5)
            java.util.Iterator r6 = r6.iterator()
        L_0x0091:
            boolean r12 = r6.hasNext()
            if (r12 == 0) goto L_0x00a6
            java.lang.Object r12 = r6.next()
            java.util.BitSet r12 = (java.util.BitSet) r12
            int r12 = r12.cardinality()
            r13 = 1
            if (r12 <= r13) goto L_0x0091
            r6 = 1
            goto L_0x00a7
        L_0x00a6:
            r6 = 0
        L_0x00a7:
            if (r6 == 0) goto L_0x00fa
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x00b2:
            boolean r12 = r5.hasNext()
            if (r12 == 0) goto L_0x00d8
            java.lang.Object r12 = r5.next()
            k.a.a.a.E.b r12 = (p122k.p123a.p124a.p125a.p126E.C2389b) r12
            k.a.a.a.E.g r13 = r12.f3884a
            java.lang.Object r13 = r6.get(r13)
            java.util.BitSet r13 = (java.util.BitSet) r13
            if (r13 != 0) goto L_0x00d2
            java.util.BitSet r13 = new java.util.BitSet
            r13.<init>()
            k.a.a.a.E.g r14 = r12.f3884a
            r6.put(r14, r13)
        L_0x00d2:
            int r12 = r12.f3885b
            r13.set(r12)
            goto L_0x00b2
        L_0x00d8:
            java.util.Collection r5 = r6.values()
            java.util.Iterator r5 = r5.iterator()
        L_0x00e0:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00f5
            java.lang.Object r6 = r5.next()
            java.util.BitSet r6 = (java.util.BitSet) r6
            int r6 = r6.cardinality()
            r12 = 1
            if (r6 != r12) goto L_0x00e0
            r5 = 1
            goto L_0x00f6
        L_0x00f5:
            r5 = 0
        L_0x00f6:
            if (r5 != 0) goto L_0x00fa
        L_0x00f8:
            r5 = 1
            goto L_0x00fb
        L_0x00fa:
            r5 = 0
        L_0x00fb:
            if (r5 == 0) goto L_0x012e
            k.a.a.a.E.c r5 = r4.f3969b
            java.util.Collection r2 = p122k.p123a.p124a.p125a.p126E.C2373T.m4008b(r2)
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x010c:
            boolean r12 = r2.hasNext()
            if (r12 == 0) goto L_0x011c
            java.lang.Object r12 = r2.next()
            java.util.BitSet r12 = (java.util.BitSet) r12
            r6.or(r12)
            goto L_0x010c
        L_0x011c:
            r5.f3893e = r6
            r2 = 1
            r4.f3974g = r2
            r4.f3971d = r2
            k.a.a.a.E.c r2 = r4.f3969b
            java.util.BitSet r2 = r2.f3893e
            r5 = 0
            int r2 = r2.nextSetBit(r5)
            r4.f3972e = r2
        L_0x012e:
            boolean r2 = r4.f3971d
            if (r2 == 0) goto L_0x01e6
            k.a.a.a.E.c r2 = r4.f3969b
            boolean r2 = r2.f3894f
            if (r2 == 0) goto L_0x01e6
            k.a.a.a.E.a r2 = r7.f3912a
            int r5 = r8.f3963c
            k.a.a.a.E.q r2 = r2.mo34112a((int) r5)
            int r2 = r2.mo34153a()
            k.a.a.a.E.c r5 = r4.f3969b
            int r6 = r5.f3892d
            if (r6 == 0) goto L_0x0155
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            int r5 = r5.f3892d
            r6.set(r5)
            goto L_0x0157
        L_0x0155:
            java.util.BitSet r6 = r5.f3893e
        L_0x0157:
            k.a.a.a.E.c r5 = r4.f3969b
            int r12 = r2 + 1
            k.a.a.a.E.Y[] r12 = new p122k.p123a.p124a.p125a.p126E.C2380Y[r12]
            java.util.Iterator r5 = r5.iterator()
        L_0x0161:
            boolean r13 = r5.hasNext()
            if (r13 == 0) goto L_0x0182
            java.lang.Object r13 = r5.next()
            k.a.a.a.E.b r13 = (p122k.p123a.p124a.p125a.p126E.C2389b) r13
            int r14 = r13.f3885b
            boolean r14 = r6.get(r14)
            if (r14 == 0) goto L_0x0161
            int r14 = r13.f3885b
            r15 = r12[r14]
            k.a.a.a.E.Y r13 = r13.f3888e
            k.a.a.a.E.Y r13 = p122k.p123a.p124a.p125a.p126E.C2380Y.m4022b((p122k.p123a.p124a.p125a.p126E.C2380Y) r15, (p122k.p123a.p124a.p125a.p126E.C2380Y) r13)
            r12[r14] = r13
            goto L_0x0161
        L_0x0182:
            r5 = 0
            r13 = 1
        L_0x0184:
            if (r13 > r2) goto L_0x019a
            r14 = r12[r13]
            if (r14 != 0) goto L_0x018f
            k.a.a.a.E.Y r14 = p122k.p123a.p124a.p125a.p126E.C2380Y.f3865a
            r12[r13] = r14
            goto L_0x0197
        L_0x018f:
            r14 = r12[r13]
            k.a.a.a.E.Y r15 = p122k.p123a.p124a.p125a.p126E.C2380Y.f3865a
            if (r14 == r15) goto L_0x0197
            int r5 = r5 + 1
        L_0x0197:
            int r13 = r13 + 1
            goto L_0x0184
        L_0x019a:
            if (r5 != 0) goto L_0x019d
            r12 = r3
        L_0x019d:
            if (r12 == 0) goto L_0x01d9
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r5 = 0
            r13 = 1
        L_0x01a6:
            int r14 = r12.length
            if (r13 >= r14) goto L_0x01c3
            r14 = r12[r13]
            if (r6 == 0) goto L_0x01bb
            boolean r15 = r6.get(r13)
            if (r15 == 0) goto L_0x01bb
            k.a.a.a.F.d$a r15 = new k.a.a.a.F.d$a
            r15.<init>(r14, r13)
            r2.add(r15)
        L_0x01bb:
            k.a.a.a.E.Y r15 = p122k.p123a.p124a.p125a.p126E.C2380Y.f3865a
            if (r14 == r15) goto L_0x01c0
            r5 = 1
        L_0x01c0:
            int r13 = r13 + 1
            goto L_0x01a6
        L_0x01c3:
            if (r5 != 0) goto L_0x01c6
            goto L_0x01d3
        L_0x01c6:
            int r3 = r2.size()
            k.a.a.a.F.d$a[] r3 = new p122k.p123a.p124a.p125a.p127F.C2428d.C2429a[r3]
            java.lang.Object[] r2 = r2.toArray(r3)
            r3 = r2
            k.a.a.a.F.d$a[] r3 = (p122k.p123a.p124a.p125a.p127F.C2428d.C2429a[]) r3
        L_0x01d3:
            r4.f3975h = r3
            r2 = 0
            r4.f3972e = r2
            goto L_0x01e0
        L_0x01d9:
            r2 = 0
            int r3 = r6.nextSetBit(r2)
            r4.f3972e = r3
        L_0x01e0:
            k.a.a.a.F.d$a[] r3 = r4.f3975h
            if (r3 == 0) goto L_0x01e6
            r4.f3972e = r2
        L_0x01e6:
            k.a.a.a.F.d r2 = r7.mo34074a((p122k.p123a.p124a.p125a.p127F.C2426b) r8, (p122k.p123a.p124a.p125a.p127F.C2428d) r0, (int) r1, (p122k.p123a.p124a.p125a.p127F.C2428d) r4)
        L_0x01ea:
            k.a.a.a.F.d r3 = p122k.p123a.p124a.p125a.p126E.C2400f.f3911c
            if (r2 != r3) goto L_0x0201
            k.a.a.a.E.c r1 = r0.f3969b
            k.a.a.a.q r1 = r7.mo34075a((p122k.p123a.p124a.p125a.C2350A) r9, (p122k.p123a.p124a.p125a.C2471s) r11, (p122k.p123a.p124a.p125a.p126E.C2391c) r1, (int) r10)
            r21.mo34282a(r22)
            k.a.a.a.E.c r0 = r0.f3969b
            int r0 = r7.mo34067a((p122k.p123a.p124a.p125a.p126E.C2391c) r0, (p122k.p123a.p124a.p125a.C2471s) r11)
            if (r0 == 0) goto L_0x0200
            return r0
        L_0x0200:
            throw r1
        L_0x0201:
            boolean r0 = r2.f3974g
            r12 = -1
            if (r0 == 0) goto L_0x032e
            k.a.a.a.E.T r0 = r7.f3840f
            k.a.a.a.E.T r3 = p122k.p123a.p124a.p125a.p126E.C2373T.SLL
            if (r0 == r3) goto L_0x032e
            k.a.a.a.E.c r0 = r2.f3969b
            java.util.BitSet r0 = r0.f3893e
            k.a.a.a.F.d$a[] r1 = r2.f3975h
            if (r1 == 0) goto L_0x0237
            int r0 = r21.mo34283b()
            if (r0 == r10) goto L_0x021d
            r21.mo34282a(r22)
        L_0x021d:
            k.a.a.a.F.d$a[] r1 = r2.f3975h
            r3 = 1
            java.util.BitSet r1 = r7.mo34069a((p122k.p123a.p124a.p125a.p127F.C2428d.C2429a[]) r1, (p122k.p123a.p124a.p125a.C2471s) r11, (boolean) r3)
            int r4 = r1.cardinality()
            if (r4 != r3) goto L_0x0230
            r4 = 0
            int r0 = r1.nextSetBit(r4)
            return r0
        L_0x0230:
            if (r0 == r10) goto L_0x0235
            r9.mo34282a(r0)
        L_0x0235:
            r5 = r1
            goto L_0x0239
        L_0x0237:
            r3 = 1
            r5 = r0
        L_0x0239:
            k.a.a.a.E.q r0 = r8.f3964d
            k.a.a.a.E.c r13 = r7.mo34072a((p122k.p123a.p124a.p125a.p126E.C2403g) r0, (p122k.p123a.p124a.p125a.C2476w) r11, (boolean) r3)
            k.a.a.a.E.c r6 = r2.f3969b
            int r4 = r21.mo34283b()
            k.a.a.a.r r0 = r7.f3838d
            if (r0 == 0) goto L_0x0256
            k.a.a.a.a r0 = r0.mo34350g()
            k.a.a.a.r r1 = r7.f3838d
            r2 = r19
            r3 = r22
            r0.mo34277a((p122k.p123a.p124a.p125a.C2469r) r1, (p122k.p123a.p124a.p125a.p127F.C2426b) r2, (int) r3, (int) r4, (java.util.BitSet) r5, (p122k.p123a.p124a.p125a.p126E.C2391c) r6)
        L_0x0256:
            r21.mo34282a(r22)
            r0 = 1
            int r1 = r9.mo34284b(r0)
        L_0x025e:
            k.a.a.a.E.c r6 = r7.mo34071a((p122k.p123a.p124a.p125a.p126E.C2391c) r13, (int) r1, (boolean) r0)
            if (r6 != 0) goto L_0x0274
            k.a.a.a.q r0 = r7.mo34075a((p122k.p123a.p124a.p125a.C2350A) r9, (p122k.p123a.p124a.p125a.C2471s) r11, (p122k.p123a.p124a.p125a.p126E.C2391c) r13, (int) r10)
            r21.mo34282a(r22)
            int r1 = r7.mo34067a((p122k.p123a.p124a.p125a.p126E.C2391c) r13, (p122k.p123a.p124a.p125a.C2471s) r11)
            if (r1 == 0) goto L_0x0273
            goto L_0x031f
        L_0x0273:
            throw r0
        L_0x0274:
            java.util.Collection r0 = p122k.p123a.p124a.p125a.p126E.C2373T.m4008b(r6)
            int r2 = m3973c(r6)
            r6.f3892d = r2
            if (r2 == 0) goto L_0x0281
            goto L_0x028d
        L_0x0281:
            k.a.a.a.E.T r2 = r7.f3840f
            k.a.a.a.E.T r3 = p122k.p123a.p124a.p125a.p126E.C2373T.LL_EXACT_AMBIG_DETECTION
            if (r2 == r3) goto L_0x0290
            int r2 = p122k.p123a.p124a.p125a.p126E.C2373T.m4006a((java.util.Collection<java.util.BitSet>) r0)
            if (r2 == 0) goto L_0x0320
        L_0x028d:
            r11 = r2
            r4 = 0
            goto L_0x02d8
        L_0x0290:
            java.util.Iterator r2 = r0.iterator()
        L_0x0294:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x02aa
            java.lang.Object r3 = r2.next()
            java.util.BitSet r3 = (java.util.BitSet) r3
            int r3 = r3.cardinality()
            r4 = 1
            if (r3 != r4) goto L_0x0294
            r16 = 1
            goto L_0x02ad
        L_0x02aa:
            r4 = 1
            r16 = 0
        L_0x02ad:
            r2 = r16 ^ 1
            if (r2 == 0) goto L_0x0320
            java.util.Iterator r2 = r0.iterator()
            java.lang.Object r3 = r2.next()
            java.util.BitSet r3 = (java.util.BitSet) r3
        L_0x02bb:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x02cf
            java.lang.Object r4 = r2.next()
            java.util.BitSet r4 = (java.util.BitSet) r4
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x02bb
            r2 = 0
            goto L_0x02d0
        L_0x02cf:
            r2 = 1
        L_0x02d0:
            if (r2 == 0) goto L_0x0320
            int r0 = p122k.p123a.p124a.p125a.p126E.C2373T.m4006a((java.util.Collection<java.util.BitSet>) r0)
            r11 = r0
            r4 = 1
        L_0x02d8:
            int r0 = r6.f3892d
            if (r0 == 0) goto L_0x02f4
            int r4 = r21.mo34283b()
            k.a.a.a.r r0 = r7.f3838d
            if (r0 == 0) goto L_0x02f2
            k.a.a.a.a r0 = r0.mo34350g()
            k.a.a.a.r r1 = r7.f3838d
            r2 = r19
            r3 = r22
            r5 = r11
            r0.mo34276a((p122k.p123a.p124a.p125a.C2469r) r1, (p122k.p123a.p124a.p125a.p127F.C2426b) r2, (int) r3, (int) r4, (int) r5, (p122k.p123a.p124a.p125a.p126E.C2391c) r6)
        L_0x02f2:
            r1 = r11
            goto L_0x031f
        L_0x02f4:
            int r3 = r21.mo34283b()
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.ArrayList<k.a.a.a.E.b> r0 = r6.f3891c
            java.util.Iterator r0 = r0.iterator()
        L_0x0303:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0315
            java.lang.Object r1 = r0.next()
            k.a.a.a.E.b r1 = (p122k.p123a.p124a.p125a.p126E.C2389b) r1
            int r1 = r1.f3885b
            r5.set(r1)
            goto L_0x0303
        L_0x0315:
            r0 = r18
            r1 = r19
            r2 = r22
            r0.mo34078a(r1, r2, r3, r4, r5, r6)
            goto L_0x02f2
        L_0x031f:
            return r1
        L_0x0320:
            if (r1 == r12) goto L_0x032a
            r21.mo34285d()
            r0 = 1
            int r1 = r9.mo34284b(r0)
        L_0x032a:
            r13 = r6
            r0 = 1
            goto L_0x025e
        L_0x032e:
            boolean r0 = r2.f3971d
            if (r0 == 0) goto L_0x036f
            k.a.a.a.F.d$a[] r0 = r2.f3975h
            if (r0 != 0) goto L_0x0339
            int r0 = r2.f3972e
            return r0
        L_0x0339:
            int r3 = r21.mo34283b()
            r21.mo34282a(r22)
            k.a.a.a.F.d$a[] r0 = r2.f3975h
            r1 = 1
            java.util.BitSet r12 = r7.mo34069a((p122k.p123a.p124a.p125a.p127F.C2428d.C2429a[]) r0, (p122k.p123a.p124a.p125a.C2471s) r11, (boolean) r1)
            int r0 = r12.cardinality()
            if (r0 == 0) goto L_0x0368
            if (r0 == r1) goto L_0x0362
            r4 = 0
            k.a.a.a.E.c r6 = r2.f3969b
            r0 = r18
            r1 = r19
            r2 = r22
            r5 = r12
            r0.mo34078a(r1, r2, r3, r4, r5, r6)
            r0 = 0
            int r0 = r12.nextSetBit(r0)
            return r0
        L_0x0362:
            r0 = 0
            int r0 = r12.nextSetBit(r0)
            return r0
        L_0x0368:
            k.a.a.a.E.c r0 = r2.f3969b
            k.a.a.a.q r0 = r7.mo34075a((p122k.p123a.p124a.p125a.C2350A) r9, (p122k.p123a.p124a.p125a.C2471s) r11, (p122k.p123a.p124a.p125a.p126E.C2391c) r0, (int) r10)
            throw r0
        L_0x036f:
            if (r1 == r12) goto L_0x037a
            r21.mo34285d()
            r0 = 1
            int r1 = r9.mo34284b(r0)
            goto L_0x037b
        L_0x037a:
            r0 = 1
        L_0x037b:
            r0 = r2
            r12 = 1
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: p122k.p123a.p124a.p125a.p126E.C2366L.mo34068a(k.a.a.a.F.b, k.a.a.a.F.d, k.a.a.a.A, int, k.a.a.a.s):int");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo34067a(C2391c cVar, C2471s sVar) {
        int b;
        C2391c cVar2 = new C2391c(cVar.f3896h);
        C2391c cVar3 = new C2391c(cVar.f3896h);
        Iterator<C2389b> it = cVar.iterator();
        while (it.hasNext()) {
            C2389b next = it.next();
            C2380Y y = next.f3888e;
            if (y == C2380Y.f3865a || y.mo34096a((C2474v<?, ?>) this.f3838d, (C2476w) sVar)) {
                cVar2.mo34126a(next, (C2433c<C2371Q, C2371Q, C2371Q>) null);
            } else {
                cVar3.mo34126a(next, (C2433c<C2371Q, C2371Q, C2371Q>) null);
            }
        }
        int b2 = mo34079b(cVar2);
        if (b2 != 0) {
            return b2;
        }
        if (cVar3.size() <= 0 || (b = mo34079b(cVar3)) == 0) {
            return 0;
        }
        return b;
    }
}
