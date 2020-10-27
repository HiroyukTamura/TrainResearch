package p122k.p123a.p124a.p125a.p126E;

import java.util.HashMap;
import java.util.Map;

/* renamed from: k.a.a.a.E.S */
public class C2372S {

    /* renamed from: a */
    protected final Map<C2371Q, C2371Q> f3854a = new HashMap();

    /* renamed from: a */
    public C2371Q mo34091a(C2371Q q) {
        C2415r rVar = C2371Q.f3851b;
        if (q == rVar) {
            return rVar;
        }
        C2371Q q2 = this.f3854a.get(q);
        if (q2 != null) {
            return q2;
        }
        this.f3854a.put(q, q);
        return q;
    }
}
