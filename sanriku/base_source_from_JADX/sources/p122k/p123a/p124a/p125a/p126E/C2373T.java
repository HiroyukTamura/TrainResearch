package p122k.p123a.p124a.p125a.p126E;

import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import p009e.p028d.p030b.p054b.C1532a;
import p122k.p123a.p124a.p125a.p128G.C2430a;
import p122k.p123a.p124a.p125a.p128G.C2434d;

/* renamed from: k.a.a.a.E.T */
public enum C2373T {
    SLL,
    LL,
    LL_EXACT_AMBIG_DETECTION;

    /* renamed from: k.a.a.a.E.T$a */
    private static final class C2374a extends C2430a<C2389b> {

        /* renamed from: a */
        public static final C2374a f3858a = null;

        static {
            f3858a = new C2374a();
        }

        private C2374a() {
        }

        /* renamed from: a */
        public boolean mo34093a(Object obj, Object obj2) {
            C2389b bVar = (C2389b) obj;
            C2389b bVar2 = (C2389b) obj2;
            if (bVar == bVar2) {
                return true;
            }
            return bVar != null && bVar2 != null && bVar.f3884a.f3916b == bVar2.f3884a.f3916b && bVar.f3886c.equals(bVar2.f3886c);
        }

        /* renamed from: a */
        public int mo34092a(Object obj) {
            C2389b bVar = (C2389b) obj;
            return C1532a.m2119a(C1532a.m2120a(C1532a.m2145b(7, bVar.f3884a.f3916b), (Object) bVar.f3886c), 2);
        }
    }

    /* renamed from: k.a.a.a.E.T$b */
    static class C2375b extends C2434d<C2389b, BitSet> {
        public C2375b() {
            super(C2374a.f3858a);
        }
    }

    static {
        SLL = new C2373T("SLL", 0);
        LL = new C2373T("LL", 1);
        LL_EXACT_AMBIG_DETECTION = new C2373T("LL_EXACT_AMBIG_DETECTION", 2);
    }

    /* renamed from: a */
    public static int m4006a(Collection<BitSet> collection) {
        BitSet bitSet = new BitSet();
        for (BitSet nextSetBit : collection) {
            bitSet.set(nextSetBit.nextSetBit(0));
            if (bitSet.cardinality() > 1) {
                return 0;
            }
        }
        return bitSet.nextSetBit(0);
    }

    /* renamed from: a */
    public static boolean m4007a(C2391c cVar) {
        Iterator<C2389b> it = cVar.iterator();
        while (it.hasNext()) {
            if (!(it.next().f3884a instanceof C2378W)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static Collection<BitSet> m4008b(C2391c cVar) {
        C2375b bVar = new C2375b();
        Iterator<C2389b> it = cVar.iterator();
        while (it.hasNext()) {
            C2389b next = it.next();
            BitSet bitSet = (BitSet) bVar.get(next);
            if (bitSet == null) {
                bitSet = new BitSet();
                bVar.put(next, bitSet);
            }
            bitSet.set(next.f3885b);
        }
        return bVar.values();
    }

    /* renamed from: c */
    public static boolean m4009c(C2391c cVar) {
        Iterator<C2389b> it = cVar.iterator();
        while (it.hasNext()) {
            if (it.next().f3884a instanceof C2378W) {
                return true;
            }
        }
        return false;
    }
}
