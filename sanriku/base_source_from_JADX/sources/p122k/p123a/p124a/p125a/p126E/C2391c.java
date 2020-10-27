package p122k.p123a.p124a.p125a.p126E;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import p122k.p123a.p124a.p125a.p128G.C2430a;
import p122k.p123a.p124a.p125a.p128G.C2431b;
import p122k.p123a.p124a.p125a.p128G.C2433c;

/* renamed from: k.a.a.a.E.c */
public class C2391c implements Set<C2389b> {

    /* renamed from: a */
    protected boolean f3889a;

    /* renamed from: b */
    public C2392a f3890b;

    /* renamed from: c */
    public final ArrayList<C2389b> f3891c;

    /* renamed from: d */
    public int f3892d;

    /* renamed from: e */
    protected BitSet f3893e;

    /* renamed from: f */
    public boolean f3894f;

    /* renamed from: g */
    public boolean f3895g;

    /* renamed from: h */
    public final boolean f3896h;

    /* renamed from: i */
    private int f3897i;

    /* renamed from: k.a.a.a.E.c$a */
    public static abstract class C2392a extends C2431b<C2389b> {
        public C2392a(C2430a<? super C2389b> aVar) {
            super(aVar, 16, 2);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Object mo34143a(Object obj) {
            if (!(obj instanceof C2389b)) {
                return null;
            }
            return (C2389b) obj;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Object[][] mo34145b(int i) {
            return new C2389b[i][];
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Object[] mo34144a(int i) {
            return new C2389b[i];
        }
    }

    /* renamed from: k.a.a.a.E.c$b */
    public static final class C2393b extends C2430a<C2389b> {

        /* renamed from: a */
        public static final C2393b f3898a = new C2393b();

        private C2393b() {
        }

        /* renamed from: a */
        public boolean mo34093a(Object obj, Object obj2) {
            C2389b bVar = (C2389b) obj;
            C2389b bVar2 = (C2389b) obj2;
            if (bVar == bVar2) {
                return true;
            }
            return bVar != null && bVar2 != null && bVar.f3884a.f3916b == bVar2.f3884a.f3916b && bVar.f3885b == bVar2.f3885b && bVar.f3888e.equals(bVar2.f3888e);
        }

        /* renamed from: a */
        public int mo34092a(Object obj) {
            C2389b bVar = (C2389b) obj;
            return bVar.f3888e.hashCode() + ((((bVar.f3884a.f3916b + 217) * 31) + bVar.f3885b) * 31);
        }
    }

    /* renamed from: k.a.a.a.E.c$c */
    public static class C2394c extends C2392a {
        public C2394c() {
            super(C2393b.f3898a);
        }
    }

    public C2391c() {
        this(true);
    }

    public C2391c(boolean z) {
        this.f3889a = false;
        this.f3891c = new ArrayList<>(7);
        this.f3897i = -1;
        this.f3890b = new C2394c();
        this.f3896h = z;
    }

    /* renamed from: a */
    public void mo34124a(C2400f fVar) {
        if (this.f3889a) {
            throw new IllegalStateException("This set is readonly");
        } else if (!this.f3890b.isEmpty()) {
            Iterator<C2389b> it = this.f3891c.iterator();
            while (it.hasNext()) {
                C2389b next = it.next();
                next.f3886c = fVar.mo34152a(next.f3886c);
            }
        }
    }

    /* renamed from: a */
    public boolean mo34125a(C2389b bVar) {
        mo34126a(bVar, (C2433c<C2371Q, C2371Q, C2371Q>) null);
        return true;
    }

    /* renamed from: a */
    public boolean mo34126a(C2389b bVar, C2433c<C2371Q, C2371Q, C2371Q> cVar) {
        if (!this.f3889a) {
            if (bVar.f3888e != C2380Y.f3865a) {
                this.f3894f = true;
            }
            if (bVar.mo34118a() > 0) {
                this.f3895g = true;
            }
            C2389b bVar2 = (C2389b) this.f3890b.mo34202d(bVar);
            if (bVar2 == bVar) {
                this.f3897i = -1;
                this.f3891c.add(bVar);
                return true;
            }
            C2371Q a = C2371Q.m3997a(bVar2.f3886c, bVar.f3886c, !this.f3896h, cVar);
            bVar2.f3887d = Math.max(bVar2.f3887d, bVar.f3887d);
            if (bVar.mo34120b()) {
                bVar2.f3887d |= 1073741824;
            }
            bVar2.f3886c = a;
            return true;
        }
        throw new IllegalStateException("This set is readonly");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        mo34125a((C2389b) obj);
        return true;
    }

    public boolean addAll(Collection<? extends C2389b> collection) {
        for (C2389b a : collection) {
            mo34125a(a);
        }
        return false;
    }

    public void clear() {
        if (!this.f3889a) {
            this.f3891c.clear();
            this.f3897i = -1;
            this.f3890b.clear();
            return;
        }
        throw new IllegalStateException("This set is readonly");
    }

    public boolean contains(Object obj) {
        C2392a aVar = this.f3890b;
        if (aVar != null) {
            return aVar.contains(obj);
        }
        throw new UnsupportedOperationException("This method is not implemented for readonly sets.");
    }

    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2391c)) {
            return false;
        }
        C2391c cVar = (C2391c) obj;
        ArrayList<C2389b> arrayList = this.f3891c;
        return arrayList != null && arrayList.equals(cVar.f3891c) && this.f3896h == cVar.f3896h && this.f3892d == cVar.f3892d && this.f3893e == cVar.f3893e && this.f3894f == cVar.f3894f && this.f3895g == cVar.f3895g;
    }

    public int hashCode() {
        if (!this.f3889a) {
            return this.f3891c.hashCode();
        }
        if (this.f3897i == -1) {
            this.f3897i = this.f3891c.hashCode();
        }
        return this.f3897i;
    }

    public boolean isEmpty() {
        return this.f3891c.isEmpty();
    }

    public Iterator<C2389b> iterator() {
        return this.f3891c.iterator();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f3891c.size();
    }

    public Object[] toArray() {
        return (C2389b[]) this.f3890b.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f3890b.toArray(tArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3891c.toString());
        if (this.f3894f) {
            sb.append(",hasSemanticContext=");
            sb.append(this.f3894f);
        }
        if (this.f3892d != 0) {
            sb.append(",uniqueAlt=");
            sb.append(this.f3892d);
        }
        if (this.f3893e != null) {
            sb.append(",conflictingAlts=");
            sb.append(this.f3893e);
        }
        if (this.f3895g) {
            sb.append(",dipsIntoOuterContext");
        }
        return sb.toString();
    }
}
