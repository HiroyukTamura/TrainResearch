package p122k.p123a.p124a.p125a;

import java.util.ArrayList;
import java.util.List;
import p122k.p123a.p124a.p125a.p129H.C2445b;
import p122k.p123a.p124a.p125a.p129H.C2446c;
import p122k.p123a.p124a.p125a.p129H.C2447d;
import p122k.p123a.p124a.p125a.p129H.C2450g;

/* renamed from: k.a.a.a.s */
public class C2471s extends C2476w {

    /* renamed from: d */
    public List<C2446c> f4058d;

    /* renamed from: e */
    public C2477x f4059e;

    /* renamed from: f */
    public C2477x f4060f;

    public C2471s() {
    }

    public C2471s(C2471s sVar, int i) {
        super(sVar, i);
    }

    /* renamed from: a */
    public C2445b mo34342a(C2477x xVar) {
        C2445b bVar = new C2445b(xVar);
        if (this.f4058d == null) {
            this.f4058d = new ArrayList();
        }
        this.f4058d.add(bVar);
        bVar.f4010b = this;
        return bVar;
    }

    /* renamed from: a */
    public C2446c mo34270a(int i) {
        List<C2446c> list = this.f4058d;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.f4058d.get(i);
    }

    /* renamed from: a */
    public C2450g mo34343a(int i, int i2) {
        List<C2446c> list = this.f4058d;
        if (list != null && i2 >= 0 && i2 < list.size()) {
            int i3 = -1;
            for (C2446c next : this.f4058d) {
                if (next instanceof C2450g) {
                    C2450g gVar = (C2450g) next;
                    if (gVar.mo34274a().getType() == i && (i3 = i3 + 1) == i2) {
                        return gVar;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public C2476w mo34344a(C2476w wVar) {
        if (this.f4058d == null) {
            this.f4058d = new ArrayList();
        }
        this.f4058d.add(wVar);
        return wVar;
    }

    /* renamed from: a */
    public void mo20243a(C2447d dVar) {
    }

    /* renamed from: b */
    public void mo20245b(C2447d dVar) {
    }

    public int getChildCount() {
        List<C2446c> list = this.f4058d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public C2446c getParent() {
        return (C2471s) this.f4071a;
    }
}
