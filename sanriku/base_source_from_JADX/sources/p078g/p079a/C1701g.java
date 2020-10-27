package p078g.p079a;

import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p080A.p085e.p087b.C1615b;

/* renamed from: g.a.g */
public abstract class C1701g<T> {

    /* renamed from: a */
    static final int f2055a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    /* renamed from: a */
    public static <T> C1701g<T> m2394a(C1703i<T> iVar, C1695a aVar) {
        C1599b.m2241a(iVar, "source is null");
        C1599b.m2241a(aVar, "mode is null");
        return new C1615b(iVar, aVar);
    }
}
