package p122k.p123a.p124a.p125a;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import p122k.p123a.p124a.p125a.p126E.C2366L;
import p122k.p123a.p124a.p125a.p128G.C2438g;
import p122k.p123a.p124a.p125a.p129H.C2445b;
import p122k.p123a.p124a.p125a.p129H.C2446c;
import p122k.p123a.p124a.p125a.p129H.C2447d;
import p122k.p123a.p124a.p125a.p129H.C2450g;
import p122k.p123a.p124a.p125a.p129H.C2451h;

/* renamed from: k.a.a.a.r */
public abstract class C2469r extends C2474v<C2477x, C2366L> {

    /* renamed from: d */
    protected C2462k f4049d = new C2462k();

    /* renamed from: e */
    protected C2350A f4050e;

    /* renamed from: f */
    protected final C2438g f4051f;

    /* renamed from: g */
    protected C2471s f4052g;

    /* renamed from: h */
    protected boolean f4053h;

    /* renamed from: i */
    private C2470a f4054i;

    /* renamed from: j */
    protected List<C2447d> f4055j;

    /* renamed from: k */
    protected int f4056k;

    /* renamed from: l */
    protected boolean f4057l;

    /* renamed from: k.a.a.a.r$a */
    public class C2470a implements C2447d {
    }

    static {
        new WeakHashMap();
    }

    public C2469r(C2350A a) {
        C2438g gVar = new C2438g();
        this.f4051f = gVar;
        gVar.mo34237a(0);
        this.f4053h = true;
        this.f4050e = null;
        C2462k kVar = this.f4049d;
        kVar.f4031a = false;
        kVar.f4033c = null;
        kVar.f4032b = -1;
        this.f4052g = null;
        this.f4056k = 0;
        this.f4057l = false;
        mo34333b((C2447d) this.f4054i);
        this.f4054i = null;
        this.f4051f.mo34236a();
        this.f4051f.mo34237a(0);
        ATNInterpreter atninterpreter = this.f4068b;
        if (atninterpreter != null) {
            atninterpreter.mo34076a();
        }
        this.f4050e = a;
    }

    /* renamed from: a */
    public void mo34325a(C2447d dVar) {
        if (dVar != null) {
            if (this.f4055j == null) {
                this.f4055j = new ArrayList();
            }
            this.f4055j.add(dVar);
            return;
        }
        throw new NullPointerException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    /* renamed from: a */
    public void mo34326a(C2462k kVar) {
        this.f4049d = kVar;
    }

    /* renamed from: a */
    public void mo34328a(C2471s sVar, int i) {
        C2471s sVar2;
        C2471s sVar3;
        if (sVar != null) {
            if (!(!this.f4053h || (sVar2 = this.f4052g) == sVar || (sVar3 = (C2471s) sVar2.f4071a) == null)) {
                List<C2446c> list = sVar3.f4058d;
                if (list != null) {
                    list.remove(list.size() - 1);
                }
                sVar3.mo34344a((C2476w) sVar);
            }
            this.f4052g = sVar;
            return;
        }
        throw null;
    }

    /* renamed from: a */
    public void mo34330a(C2477x xVar, String str, C2473u uVar) {
        this.f4056k++;
        mo34350g().mo34279a((C2474v<?, ?>) this, (Object) xVar, xVar.mo34297a(), xVar.mo34298b(), str, uVar);
    }

    /* renamed from: b */
    public void mo34333b(C2447d dVar) {
        List<C2447d> list = this.f4055j;
        if (list != null && list.remove(dVar) && this.f4055j.isEmpty()) {
            this.f4055j = null;
        }
    }

    /* renamed from: b */
    public void mo34334b(C2471s sVar, int i) {
        mo34349a(i);
        this.f4052g = sVar;
        sVar.f4059e = this.f4050e.mo34029c(1);
        if (this.f4053h) {
            C2471s sVar2 = this.f4052g;
            C2471s sVar3 = (C2471s) sVar2.f4071a;
            if (sVar3 != null) {
                sVar3.mo34344a((C2476w) sVar2);
            }
        }
        if (this.f4055j != null) {
            mo34340n();
        }
    }

    /* renamed from: c */
    public void mo34335c(C2471s sVar, int i) {
        C2471s sVar2 = this.f4052g;
        sVar2.f4071a = sVar;
        sVar2.f4072b = i;
        this.f4050e.mo34029c(-1);
        this.f4052g = sVar;
        sVar.f4059e = sVar2.f4059e;
        if (this.f4053h) {
            sVar.mo34344a((C2476w) sVar2);
        }
        if (this.f4055j != null) {
            mo34340n();
        }
    }

    /* renamed from: j */
    public C2477x mo34336j() {
        C2477x l = mo34338l();
        if (l.getType() != -1) {
            this.f4050e.mo34285d();
        }
        List<C2447d> list = this.f4055j;
        boolean z = list != null && !list.isEmpty();
        if (this.f4053h || z) {
            if (this.f4049d.f4031a) {
                C2445b a = this.f4052g.mo34342a(l);
                List<C2447d> list2 = this.f4055j;
                if (list2 != null) {
                    for (C2447d a2 : list2) {
                        a2.mo20077a(a);
                    }
                }
            } else {
                C2471s sVar = this.f4052g;
                if (sVar != null) {
                    C2451h hVar = new C2451h(l);
                    if (sVar.f4058d == null) {
                        sVar.f4058d = new ArrayList();
                    }
                    sVar.f4058d.add(hVar);
                    hVar.f4010b = sVar;
                    List<C2447d> list3 = this.f4055j;
                    if (list3 != null) {
                        for (C2447d a3 : list3) {
                            a3.mo20078a((C2450g) hVar);
                        }
                    }
                } else {
                    throw null;
                }
            }
        }
        return l;
    }

    /* renamed from: k */
    public void mo34337k() {
        int i;
        C2350A a;
        C2471s sVar;
        if (this.f4057l) {
            sVar = this.f4052g;
            a = this.f4050e;
            i = 1;
        } else {
            sVar = this.f4052g;
            a = this.f4050e;
            i = -1;
        }
        sVar.f4060f = a.mo34029c(i);
        if (this.f4055j != null) {
            mo34341o();
        }
        mo34349a(this.f4052g.f4072b);
        this.f4052g = (C2471s) this.f4052g.f4071a;
    }

    /* renamed from: l */
    public C2477x mo34338l() {
        return this.f4050e.mo34029c(1);
    }

    /* renamed from: m */
    public final int mo34339m() {
        if (this.f4051f.mo34239b()) {
            return -1;
        }
        C2438g gVar = this.f4051f;
        return gVar.mo34238b(gVar.mo34240c() - 1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo34340n() {
        for (C2447d next : this.f4055j) {
            next.mo20158b(this.f4052g);
            this.f4052g.mo20243a(next);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void mo34341o() {
        for (int size = this.f4055j.size() - 1; size >= 0; size--) {
            C2447d dVar = this.f4055j.get(size);
            this.f4052g.mo20245b(dVar);
            dVar.mo20079a(this.f4052g);
        }
    }

    /* renamed from: b */
    public C2477x mo34332b(int i) throws C2473u {
        C2477x l = mo34338l();
        if (l.getType() == i) {
            if (i == -1) {
                this.f4057l = true;
            }
            C2462k kVar = this.f4049d;
            kVar.f4031a = false;
            kVar.f4033c = null;
            kVar.f4032b = -1;
            mo34336j();
        } else {
            l = this.f4049d.mo34290c(this);
            if (this.f4053h && l.mo34301e() == -1) {
                this.f4052g.mo34342a(l);
            }
        }
        return l;
    }

    /* renamed from: a */
    public void mo34329a(C2471s sVar, int i, int i2) {
        mo34349a(i);
        this.f4051f.mo34237a(i2);
        this.f4052g = sVar;
        sVar.f4059e = this.f4050e.mo34029c(1);
        if (this.f4055j != null) {
            mo34340n();
        }
    }

    /* renamed from: a */
    public boolean mo34331a(C2476w wVar, int i) {
        C2438g gVar = this.f4051f;
        return i >= gVar.mo34238b(gVar.mo34240c() + -1);
    }

    /* renamed from: a */
    public void mo34327a(C2471s sVar) {
        C2438g gVar = this.f4051f;
        gVar.mo34241c(gVar.mo34240c() - 1);
        this.f4052g.f4060f = this.f4050e.mo34029c(-1);
        C2471s sVar2 = this.f4052g;
        if (this.f4055j != null) {
            while (this.f4052g != sVar) {
                mo34341o();
                this.f4052g = (C2471s) this.f4052g.f4071a;
            }
        } else {
            this.f4052g = sVar;
        }
        sVar2.f4071a = sVar;
        if (this.f4053h && sVar != null) {
            sVar.mo34344a((C2476w) sVar2);
        }
    }
}
