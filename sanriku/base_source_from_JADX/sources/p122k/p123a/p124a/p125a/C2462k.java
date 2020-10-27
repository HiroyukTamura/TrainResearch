package p122k.p123a.p124a.p125a;

import java.io.PrintStream;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.p026i.C0767d;
import p122k.p123a.p124a.p125a.p126E.C2366L;
import p122k.p123a.p124a.p125a.p126E.C2379X;
import p122k.p123a.p124a.p125a.p126E.C2387a;
import p122k.p123a.p124a.p125a.p128G.C2436e;
import p122k.p123a.p124a.p125a.p128G.C2440i;
import p122k.p123a.p124a.p125a.p128G.C2442k;

/* renamed from: k.a.a.a.k */
public class C2462k {

    /* renamed from: a */
    protected boolean f4031a = false;

    /* renamed from: b */
    protected int f4032b = -1;

    /* renamed from: c */
    protected C2440i f4033c;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo34307a(String str) {
        return C0681a.m321a("'", str.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t"), "'");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34310a(C2469r rVar, C2440i iVar) {
        C2350A a = rVar.f4050e;
        while (true) {
            int b = a.mo34284b(1);
            if (b != -1 && !iVar.mo34259b(b)) {
                rVar.mo34336j();
                a = rVar.f4050e;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C2440i mo34311b(C2469r rVar) {
        if (rVar != null) {
            return C0767d.f484t.mo34113a(rVar.mo34352i(), (C2476w) rVar.f4052g);
        }
        throw null;
    }

    /* renamed from: c */
    public C2477x mo34290c(C2469r rVar) throws C2473u {
        String str;
        C2477x f = mo34315f(rVar);
        if (f != null) {
            rVar.mo34336j();
            return f;
        }
        boolean z = true;
        if (!((C2366L) rVar.f4068b).f3912a.mo34114a(((C2366L) rVar.f4068b).f3912a.f3873a.get(rVar.mo34352i()).mo34154a(0).f3914a, (C2476w) rVar.f4052g).mo34259b(rVar.f4050e.mo34284b(1))) {
            z = false;
        } else if (!this.f4031a) {
            this.f4031a = true;
            C2477x l = rVar.mo34338l();
            C2440i b = mo34311b(rVar);
            StringBuilder a = C0681a.m330a("missing ");
            a.append(b.mo34252a(C0767d.f482r));
            a.append(" at ");
            a.append(mo34308a(l));
            rVar.mo34330a(l, a.toString(), (C2473u) null);
        }
        if (z) {
            C2477x l2 = rVar.mo34338l();
            int a2 = mo34311b(rVar).mo34251a();
            if (a2 == -1) {
                str = "<missing EOF>";
            } else {
                StringBuilder a3 = C0681a.m330a("<missing ");
                a3.append(((C2352C) C0767d.f482r).mo34032a(a2));
                a3.append(">");
                str = a3.toString();
            }
            String str2 = str;
            C2477x c = rVar.f4050e.mo34029c(-1);
            if (l2.getType() == -1 && c != null) {
                l2 = c;
            }
            return ((C2459h) rVar.f4050e.mo34030c().mo34320d()).mo34305a(new C2442k(l2.mo34299c(), l2.mo34299c().mo34321e()), a2, str2, 0, -1, -1, l2.mo34297a(), l2.mo34298b());
        }
        throw new C2464m(rVar);
    }

    /* renamed from: d */
    public void mo34313d(C2469r rVar) {
        this.f4031a = false;
        this.f4033c = null;
        this.f4032b = -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo34314e(C2469r rVar) {
        if (!this.f4031a) {
            this.f4031a = true;
            C2477x l = rVar.mo34338l();
            String a = mo34308a(l);
            C2440i b = mo34311b(rVar);
            rVar.mo34330a(l, "extraneous input " + a + " expecting " + b.mo34252a(C0767d.f482r), (C2473u) null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public C2477x mo34315f(C2469r rVar) {
        if (!mo34311b(rVar).mo34259b(rVar.f4050e.mo34284b(2))) {
            return null;
        }
        mo34314e(rVar);
        rVar.mo34336j();
        C2477x l = rVar.mo34338l();
        this.f4031a = false;
        this.f4033c = null;
        this.f4032b = -1;
        return l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0089, code lost:
        if (r6.mo34259b(-2) == false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008b, code lost:
        if (r1 != -1) goto L_0x008e;
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo34291g(p122k.p123a.p124a.p125a.C2469r r11) throws p122k.p123a.p124a.p125a.C2473u {
        /*
            r10 = this;
            ATNInterpreter r0 = r11.f4068b
            k.a.a.a.E.L r0 = (p122k.p123a.p124a.p125a.p126E.C2366L) r0
            k.a.a.a.E.a r0 = r0.f3912a
            java.util.List<k.a.a.a.E.g> r0 = r0.f3873a
            int r1 = r11.mo34352i()
            java.lang.Object r0 = r0.get(r1)
            k.a.a.a.E.g r0 = (p122k.p123a.p124a.p125a.p126E.C2403g) r0
            boolean r1 = r10.f4031a
            if (r1 == 0) goto L_0x0017
            return
        L_0x0017:
            k.a.a.a.A r1 = r11.f4050e
            r2 = 1
            int r1 = r1.mo34284b(r2)
            k.a.a.a.E.a r3 = p009e.p015c.p016a.p017a.p018a.p024s.p025m.p026i.C0767d.f484t
            k.a.a.a.G.i r3 = r3.mo34116b(r0)
            boolean r3 = r3.mo34259b(r1)
            if (r3 != 0) goto L_0x00d9
            r3 = -1
            if (r1 != r3) goto L_0x002f
            goto L_0x00d9
        L_0x002f:
            ATNInterpreter r4 = r11.f4068b
            k.a.a.a.E.L r4 = (p122k.p123a.p124a.p125a.p126E.C2366L) r4
            k.a.a.a.E.a r4 = r4.f3912a
            k.a.a.a.s r5 = r11.f4052g
            java.util.List<k.a.a.a.E.g> r6 = r4.f3873a
            int r7 = r11.mo34352i()
            java.lang.Object r6 = r6.get(r7)
            k.a.a.a.E.g r6 = (p122k.p123a.p124a.p125a.p126E.C2403g) r6
            k.a.a.a.G.i r6 = r4.mo34116b(r6)
            boolean r7 = r6.mo34259b(r1)
            r8 = 0
            if (r7 == 0) goto L_0x004f
            goto L_0x008f
        L_0x004f:
            r7 = -2
            boolean r9 = r6.mo34259b(r7)
            if (r9 != 0) goto L_0x0057
            goto L_0x008e
        L_0x0057:
            if (r5 == 0) goto L_0x0085
            int r9 = r5.f4072b
            if (r9 < 0) goto L_0x0085
            boolean r9 = r6.mo34259b(r7)
            if (r9 == 0) goto L_0x0085
            java.util.List<k.a.a.a.E.g> r6 = r4.f3873a
            int r9 = r5.f4072b
            java.lang.Object r6 = r6.get(r9)
            k.a.a.a.E.g r6 = (p122k.p123a.p124a.p125a.p126E.C2403g) r6
            k.a.a.a.E.f0 r6 = r6.mo34154a((int) r8)
            k.a.a.a.E.X r6 = (p122k.p123a.p124a.p125a.p126E.C2379X) r6
            k.a.a.a.E.g r6 = r6.f3864c
            k.a.a.a.G.i r6 = r4.mo34116b(r6)
            boolean r9 = r6.mo34259b(r1)
            if (r9 == 0) goto L_0x0080
            goto L_0x008f
        L_0x0080:
            k.a.a.a.w r5 = r5.f4071a
            k.a.a.a.s r5 = (p122k.p123a.p124a.p125a.C2471s) r5
            goto L_0x0057
        L_0x0085:
            boolean r4 = r6.mo34259b(r7)
            if (r4 == 0) goto L_0x008e
            if (r1 != r3) goto L_0x008e
            goto L_0x008f
        L_0x008e:
            r2 = 0
        L_0x008f:
            if (r2 == 0) goto L_0x0092
            return
        L_0x0092:
            int r0 = r0.mo34062b()
            r1 = 3
            if (r0 == r1) goto L_0x00cc
            r1 = 4
            if (r0 == r1) goto L_0x00cc
            r1 = 5
            if (r0 == r1) goto L_0x00cc
            switch(r0) {
                case 9: goto L_0x00a3;
                case 10: goto L_0x00cc;
                case 11: goto L_0x00a3;
                default: goto L_0x00a2;
            }
        L_0x00a2:
            goto L_0x00cb
        L_0x00a3:
            r10.mo34314e(r11)
            k.a.a.a.E.a r0 = p009e.p015c.p016a.p017a.p018a.p024s.p025m.p026i.C0767d.f484t
            int r1 = r11.mo34352i()
            k.a.a.a.s r2 = r11.f4052g
            k.a.a.a.G.i r0 = r0.mo34113a((int) r1, (p122k.p123a.p124a.p125a.C2476w) r2)
            k.a.a.a.G.i r1 = r10.mo34309a((p122k.p123a.p124a.p125a.C2469r) r11)
            if (r0 == 0) goto L_0x00c9
            k.a.a.a.G.i r2 = new k.a.a.a.G.i
            int[] r3 = new int[r8]
            r2.<init>(r3)
            r2.mo34254a((p122k.p123a.p124a.p125a.p128G.C2436e) r0)
            r2.mo34254a((p122k.p123a.p124a.p125a.p128G.C2436e) r1)
            r10.mo34310a((p122k.p123a.p124a.p125a.C2469r) r11, (p122k.p123a.p124a.p125a.p128G.C2440i) r2)
            goto L_0x00cb
        L_0x00c9:
            r11 = 0
            throw r11
        L_0x00cb:
            return
        L_0x00cc:
            k.a.a.a.x r0 = r10.mo34315f(r11)
            if (r0 == 0) goto L_0x00d3
            return
        L_0x00d3:
            k.a.a.a.m r0 = new k.a.a.a.m
            r0.<init>(r11)
            throw r0
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p122k.p123a.p124a.p125a.C2462k.mo34291g(k.a.a.a.r):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C2440i mo34309a(C2469r rVar) {
        C2387a aVar = ((C2366L) rVar.f4068b).f3912a;
        C2440i iVar = new C2440i(new int[0]);
        for (C2476w wVar = rVar.f4052g; wVar != null; wVar = wVar.f4071a) {
            int i = wVar.f4072b;
            if (i < 0) {
                break;
            }
            iVar.mo34254a((C2436e) aVar.mo34116b(((C2379X) aVar.f3873a.get(i).mo34154a(0)).f3864c));
        }
        iVar.mo34261c(-2);
        return iVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo34308a(C2477x xVar) {
        if (xVar == null) {
            return "<no token>";
        }
        String text = xVar.getText();
        if (text == null) {
            if (xVar.getType() == -1) {
                text = "<EOF>";
            } else {
                StringBuilder a = C0681a.m330a("<");
                a.append(xVar.getType());
                a.append(">");
                text = a.toString();
            }
        }
        return mo34307a(text);
    }

    /* renamed from: b */
    public void mo34312b(C2469r rVar, C2473u uVar) {
        if (!this.f4031a) {
            this.f4031a = true;
            if (uVar instanceof C2468q) {
                C2468q qVar = (C2468q) uVar;
                C2350A a = rVar.f4050e;
                String a2 = a != null ? qVar.mo34324d().getType() == -1 ? "<EOF>" : a.mo34028a(qVar.mo34324d(), qVar.mo34348c()) : "<unknown input>";
                StringBuilder a3 = C0681a.m330a("no viable alternative at input ");
                a3.append(mo34307a(a2));
                rVar.mo34330a(qVar.mo34348c(), a3.toString(), (C2473u) qVar);
            } else if (uVar instanceof C2464m) {
                C2464m mVar = (C2464m) uVar;
                StringBuilder a4 = C0681a.m330a("mismatched input ");
                a4.append(mo34308a(mVar.mo34348c()));
                a4.append(" expecting ");
                C2440i a5 = mVar.mo34345a();
                if (((C0767d) rVar) != null) {
                    a4.append(a5.mo34252a(C0767d.f482r));
                    rVar.mo34330a(mVar.mo34348c(), a4.toString(), (C2473u) mVar);
                    return;
                }
                throw null;
            } else if (uVar instanceof C2463l) {
                C2463l lVar = (C2463l) uVar;
                if (((C0767d) rVar) != null) {
                    String str = C0767d.f479o[rVar.f4052g.mo20244b()];
                    rVar.mo34330a(lVar.mo34348c(), "rule " + str + " " + lVar.getMessage(), (C2473u) lVar);
                    return;
                }
                throw null;
            } else {
                PrintStream printStream = System.err;
                StringBuilder a6 = C0681a.m330a("unknown recognition error type: ");
                a6.append(uVar.getClass().getName());
                printStream.println(a6.toString());
                rVar.mo34330a(uVar.mo34348c(), uVar.getMessage(), uVar);
            }
        }
    }

    /* renamed from: a */
    public void mo34289a(C2469r rVar, C2473u uVar) {
        C2440i iVar;
        if (this.f4032b == rVar.f4050e.mo34283b() && (iVar = this.f4033c) != null && iVar.mo34259b(rVar.mo34352i())) {
            rVar.mo34336j();
        }
        this.f4032b = rVar.f4050e.mo34283b();
        if (this.f4033c == null) {
            this.f4033c = new C2440i(new int[0]);
        }
        this.f4033c.mo34255a(rVar.mo34352i());
        mo34310a(rVar, mo34309a(rVar));
    }
}
