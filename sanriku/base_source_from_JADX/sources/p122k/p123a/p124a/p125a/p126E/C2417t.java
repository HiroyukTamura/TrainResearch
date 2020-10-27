package p122k.p123a.p124a.p125a.p126E;

import java.util.BitSet;
import java.util.Set;
import p122k.p123a.p124a.p125a.p128G.C2436e;
import p122k.p123a.p124a.p125a.p128G.C2440i;

/* renamed from: k.a.a.a.E.t */
public class C2417t {

    /* renamed from: a */
    public final C2387a f3934a;

    public C2417t(C2387a aVar) {
        this.f3934a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34165a(C2403g gVar, C2403g gVar2, C2371Q q, C2440i iVar, Set<C2389b> set, BitSet bitSet, boolean z, boolean z2) {
        int i;
        int i2;
        C2379X x;
        C2403g gVar3 = gVar;
        C2371Q q2 = q;
        C2440i iVar2 = iVar;
        BitSet bitSet2 = bitSet;
        int i3 = 0;
        if (set.add(new C2389b(gVar3, 0, q2))) {
            if (gVar3 == gVar2) {
                if (q2 == null) {
                    iVar2.mo34255a(-2);
                    return;
                } else if (q.mo34087b() && z2) {
                    iVar2.mo34255a(-1);
                    return;
                }
            }
            if (gVar3 instanceof C2378W) {
                if (q2 == null) {
                    iVar2.mo34255a(-2);
                    return;
                } else if (q.mo34087b() && z2) {
                    iVar2.mo34255a(-1);
                    return;
                } else if (q2 != C2371Q.f3851b) {
                    boolean z3 = bitSet2.get(gVar3.f3917c);
                    try {
                        bitSet2.clear(gVar3.f3917c);
                        while (i3 < q.mo34088c()) {
                            mo34165a(this.f3934a.f3873a.get(q2.mo34086b(i3)), gVar2, q2.mo34084a(i3), iVar, set, bitSet, z, z2);
                            i3++;
                            C2403g gVar4 = gVar2;
                        }
                        if (!z3) {
                            return;
                        }
                        return;
                    } finally {
                        if (z3) {
                            bitSet2.set(gVar3.f3917c);
                        }
                    }
                }
            }
            int i4 = 0;
            for (int a = gVar.mo34153a(); i4 < a; a = i) {
                C2401f0 a2 = gVar3.mo34154a(i4);
                if (a2.getClass() == C2379X.class) {
                    C2379X x2 = (C2379X) a2;
                    if (bitSet2.get(x2.f3914a.f3917c)) {
                        i2 = i4;
                        i = a;
                    } else {
                        C2388a0 a3 = C2388a0.m4041a(q2, x2.f3864c.f3916b);
                        try {
                            bitSet2.set(((C2379X) a2).f3914a.f3917c);
                            x = x2;
                            i2 = i4;
                            i = a;
                            try {
                                mo34165a(a2.f3914a, gVar2, a3, iVar, set, bitSet, z, z2);
                                bitSet2.clear(x.f3914a.f3917c);
                            } catch (Throwable th) {
                                th = th;
                                bitSet2.clear(x.f3914a.f3917c);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            x = x2;
                            bitSet2.clear(x.f3914a.f3917c);
                            throw th;
                        }
                    }
                } else {
                    i2 = i4;
                    i = a;
                    if (a2 instanceof C2406i) {
                        if (!z) {
                            iVar2.mo34255a(0);
                        }
                    } else if (!a2.mo34081b()) {
                        if (a2.getClass() == C2404g0.class) {
                            iVar2.mo34254a((C2436e) C2440i.m4151b(1, this.f3934a.f3878f));
                        } else {
                            C2440i c = a2.mo34094c();
                            if (c != null) {
                                if (a2 instanceof C2363J) {
                                    C2440i b = C2440i.m4151b(1, this.f3934a.f3878f);
                                    if (b.mo34258b()) {
                                        c = null;
                                    } else {
                                        if (c.mo34258b()) {
                                            c = new C2440i(new int[0]);
                                            c.mo34254a((C2436e) b);
                                        } else {
                                            c = C2440i.m4150a(b, c);
                                        }
                                        iVar2.mo34254a((C2436e) c);
                                        i4 = i2 + 1;
                                    }
                                }
                                iVar2.mo34254a((C2436e) c);
                                i4 = i2 + 1;
                            }
                        }
                    }
                    mo34165a(a2.f3914a, gVar2, q, iVar, set, bitSet, z, z2);
                }
                i4 = i2 + 1;
            }
        }
    }
}
