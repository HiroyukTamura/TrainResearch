package p122k.p123a.p124a.p125a;

import java.util.BitSet;
import java.util.Collection;
import p122k.p123a.p124a.p125a.p126E.C2391c;
import p122k.p123a.p124a.p125a.p127F.C2426b;

/* renamed from: k.a.a.a.t */
public class C2472t implements C2452a {

    /* renamed from: a */
    private final Collection<? extends C2452a> f4061a;

    public C2472t(Collection<? extends C2452a> collection) {
        if (collection != null) {
            this.f4061a = collection;
            return;
        }
        throw new NullPointerException("delegates");
    }

    /* renamed from: a */
    public void mo34276a(C2469r rVar, C2426b bVar, int i, int i2, int i3, C2391c cVar) {
        for (C2452a a : this.f4061a) {
            a.mo34276a(rVar, bVar, i, i2, i3, cVar);
        }
    }

    /* renamed from: a */
    public void mo34277a(C2469r rVar, C2426b bVar, int i, int i2, BitSet bitSet, C2391c cVar) {
        for (C2452a a : this.f4061a) {
            a.mo34277a(rVar, bVar, i, i2, bitSet, cVar);
        }
    }

    /* renamed from: a */
    public void mo34278a(C2469r rVar, C2426b bVar, int i, int i2, boolean z, BitSet bitSet, C2391c cVar) {
        for (C2452a a : this.f4061a) {
            a.mo34278a(rVar, bVar, i, i2, z, bitSet, cVar);
        }
    }

    /* renamed from: a */
    public void mo34279a(C2474v<?, ?> vVar, Object obj, int i, int i2, String str, C2473u uVar) {
        for (C2452a a : this.f4061a) {
            a.mo34279a(vVar, obj, i, i2, str, uVar);
        }
    }
}
