package p122k.p123a.p124a.p125a.p126E;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import p122k.p123a.p124a.p125a.p128G.C2440i;

/* renamed from: k.a.a.a.E.f0 */
public abstract class C2401f0 {

    /* renamed from: a */
    public C2403g f3914a;

    /* renamed from: k.a.a.a.E.f0$a */
    static class C2402a extends HashMap<Class<? extends C2401f0>, Integer> {
        C2402a() {
            put(C2416s.class, 1);
            put(C2376U.class, 2);
            put(C2379X.class, 3);
            put(C2370P.class, 4);
            put(C2409l.class, 5);
            put(C2407j.class, 6);
            put(C2386Z.class, 7);
            put(C2363J.class, 8);
            put(C2404g0.class, 9);
            put(C2369O.class, 10);
        }
    }

    static {
        Collections.unmodifiableList(Arrays.asList(new String[]{"INVALID", "EPSILON", "RANGE", "RULE", "PREDICATE", "ATOM", "ACTION", "SET", "NOT_SET", "WILDCARD", "PRECEDENCE"}));
        Collections.unmodifiableMap(new C2402a());
    }

    protected C2401f0(C2403g gVar) {
        if (gVar != null) {
            this.f3914a = gVar;
            return;
        }
        throw new NullPointerException("target cannot be null.");
    }

    /* renamed from: a */
    public abstract int mo34063a();

    /* renamed from: a */
    public abstract boolean mo34064a(int i, int i2, int i3);

    /* renamed from: b */
    public boolean mo34081b() {
        return false;
    }

    /* renamed from: c */
    public C2440i mo34094c() {
        return null;
    }
}
