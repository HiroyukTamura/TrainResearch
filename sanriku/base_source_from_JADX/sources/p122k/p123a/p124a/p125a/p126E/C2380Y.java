package p122k.p123a.p124a.p125a.p126E;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;
import p122k.p123a.p124a.p125a.C2474v;
import p122k.p123a.p124a.p125a.C2476w;

/* renamed from: k.a.a.a.E.Y */
public abstract class C2380Y {

    /* renamed from: a */
    public static final C2380Y f3865a = new C2385e();

    /* renamed from: k.a.a.a.E.Y$a */
    public static class C2381a extends C2383c {

        /* renamed from: b */
        public final C2380Y[] f3866b;

        public C2381a(C2380Y y, C2380Y y2) {
            HashSet hashSet = new HashSet();
            if (y instanceof C2381a) {
                hashSet.addAll(Arrays.asList(((C2381a) y).f3866b));
            } else {
                hashSet.add(y);
            }
            if (y2 instanceof C2381a) {
                hashSet.addAll(Arrays.asList(((C2381a) y2).f3866b));
            } else {
                hashSet.add(y2);
            }
            List a = C2380Y.m4020a(hashSet);
            if (!a.isEmpty()) {
                hashSet.add((C2384d) Collections.min(a));
            }
            this.f3866b = (C2380Y[]) hashSet.toArray(new C2380Y[hashSet.size()]);
        }

        /* renamed from: a */
        public boolean mo34096a(C2474v<?, ?> vVar, C2476w wVar) {
            for (C2380Y a : this.f3866b) {
                if (!a.mo34096a(vVar, wVar)) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: b */
        public C2380Y mo34097b(C2474v<?, ?> vVar, C2476w wVar) {
            ArrayList arrayList = new ArrayList();
            C2380Y[] yArr = this.f3866b;
            int length = yArr.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = 1;
                if (i < length) {
                    C2380Y y = yArr[i];
                    C2380Y b = y.mo34097b(vVar, wVar);
                    if (b == y) {
                        i3 = 0;
                    }
                    i2 |= i3;
                    if (b == null) {
                        return null;
                    }
                    if (b != C2380Y.f3865a) {
                        arrayList.add(b);
                    }
                    i++;
                } else if (i2 == 0) {
                    return this;
                } else {
                    if (arrayList.isEmpty()) {
                        return C2380Y.f3865a;
                    }
                    C2380Y y2 = (C2380Y) arrayList.get(0);
                    while (i3 < arrayList.size()) {
                        y2 = C2380Y.m4021a(y2, (C2380Y) arrayList.get(i3));
                        i3++;
                    }
                    return y2;
                }
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C2381a)) {
                return false;
            }
            return Arrays.equals(this.f3866b, ((C2381a) obj).f3866b);
        }

        public int hashCode() {
            return C1532a.m2122a((T[]) this.f3866b, C2381a.class.hashCode());
        }

        public String toString() {
            return C1532a.m2131a(Arrays.asList(this.f3866b).iterator(), "&&");
        }
    }

    /* renamed from: k.a.a.a.E.Y$b */
    public static class C2382b extends C2383c {

        /* renamed from: b */
        public final C2380Y[] f3867b;

        public C2382b(C2380Y y, C2380Y y2) {
            HashSet hashSet = new HashSet();
            if (y instanceof C2382b) {
                hashSet.addAll(Arrays.asList(((C2382b) y).f3867b));
            } else {
                hashSet.add(y);
            }
            if (y2 instanceof C2382b) {
                hashSet.addAll(Arrays.asList(((C2382b) y2).f3867b));
            } else {
                hashSet.add(y2);
            }
            List a = C2380Y.m4020a(hashSet);
            if (!a.isEmpty()) {
                hashSet.add((C2384d) Collections.max(a));
            }
            this.f3867b = (C2380Y[]) hashSet.toArray(new C2380Y[hashSet.size()]);
        }

        /* renamed from: a */
        public boolean mo34096a(C2474v<?, ?> vVar, C2476w wVar) {
            for (C2380Y a : this.f3867b) {
                if (a.mo34096a(vVar, wVar)) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: b */
        public C2380Y mo34097b(C2474v<?, ?> vVar, C2476w wVar) {
            ArrayList arrayList = new ArrayList();
            C2380Y[] yArr = this.f3867b;
            int length = yArr.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = 1;
                if (i < length) {
                    C2380Y y = yArr[i];
                    C2380Y b = y.mo34097b(vVar, wVar);
                    if (b == y) {
                        i3 = 0;
                    }
                    i2 |= i3;
                    C2380Y y2 = C2380Y.f3865a;
                    if (b == y2) {
                        return y2;
                    }
                    if (b != null) {
                        arrayList.add(b);
                    }
                    i++;
                } else if (i2 == 0) {
                    return this;
                } else {
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    C2380Y y3 = (C2380Y) arrayList.get(0);
                    while (i3 < arrayList.size()) {
                        y3 = C2380Y.m4022b(y3, (C2380Y) arrayList.get(i3));
                        i3++;
                    }
                    return y3;
                }
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C2382b)) {
                return false;
            }
            return Arrays.equals(this.f3867b, ((C2382b) obj).f3867b);
        }

        public int hashCode() {
            return C1532a.m2122a((T[]) this.f3867b, C2382b.class.hashCode());
        }

        public String toString() {
            return C1532a.m2131a(Arrays.asList(this.f3867b).iterator(), "||");
        }
    }

    /* renamed from: k.a.a.a.E.Y$c */
    public static abstract class C2383c extends C2380Y {
    }

    /* renamed from: k.a.a.a.E.Y$d */
    public static class C2384d extends C2380Y implements Comparable<C2384d> {

        /* renamed from: b */
        public final int f3868b;

        protected C2384d() {
            this.f3868b = 0;
        }

        public C2384d(int i) {
            this.f3868b = i;
        }

        /* renamed from: a */
        public boolean mo34096a(C2474v<?, ?> vVar, C2476w wVar) {
            return vVar.mo34331a(wVar, this.f3868b);
        }

        /* renamed from: b */
        public C2380Y mo34097b(C2474v<?, ?> vVar, C2476w wVar) {
            if (vVar.mo34331a(wVar, this.f3868b)) {
                return C2380Y.f3865a;
            }
            return null;
        }

        public int compareTo(Object obj) {
            return this.f3868b - ((C2384d) obj).f3868b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C2384d)) {
                return false;
            }
            return this == obj || this.f3868b == ((C2384d) obj).f3868b;
        }

        public int hashCode() {
            return 31 + this.f3868b;
        }

        public String toString() {
            return C0681a.m322a(C0681a.m330a("{"), this.f3868b, ">=prec}?");
        }
    }

    /* renamed from: k.a.a.a.E.Y$e */
    public static class C2385e extends C2380Y {

        /* renamed from: b */
        public final int f3869b;

        /* renamed from: c */
        public final int f3870c;

        /* renamed from: d */
        public final boolean f3871d;

        protected C2385e() {
            this.f3869b = -1;
            this.f3870c = -1;
            this.f3871d = false;
        }

        public C2385e(int i, int i2, boolean z) {
            this.f3869b = i;
            this.f3870c = i2;
            this.f3871d = z;
        }

        /* renamed from: a */
        public boolean mo34096a(C2474v<?, ?> vVar, C2476w wVar) {
            if (!this.f3871d) {
                wVar = null;
            }
            return vVar.mo20205a(wVar, this.f3869b, this.f3870c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C2385e)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C2385e eVar = (C2385e) obj;
            return this.f3869b == eVar.f3869b && this.f3870c == eVar.f3870c && this.f3871d == eVar.f3871d;
        }

        public int hashCode() {
            return C1532a.m2119a(C1532a.m2145b(C1532a.m2145b(C1532a.m2145b(0, this.f3869b), this.f3870c), this.f3871d ? 1 : 0), 3);
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("{");
            a.append(this.f3869b);
            a.append(":");
            return C0681a.m322a(a, this.f3870c, "}?");
        }
    }

    /* renamed from: a */
    static /* synthetic */ List m4020a(Collection collection) {
        Iterator it = collection.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            C2380Y y = (C2380Y) it.next();
            if (y instanceof C2384d) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((C2384d) y);
                it.remove();
            }
        }
        return arrayList == null ? Collections.emptyList() : arrayList;
    }

    /* renamed from: a */
    public static C2380Y m4021a(C2380Y y, C2380Y y2) {
        C2380Y y3;
        if (y == null || y == (y3 = f3865a)) {
            return y2;
        }
        if (y2 == null || y2 == y3) {
            return y;
        }
        C2381a aVar = new C2381a(y, y2);
        C2380Y[] yArr = aVar.f3866b;
        return yArr.length == 1 ? yArr[0] : aVar;
    }

    /* renamed from: b */
    public static C2380Y m4022b(C2380Y y, C2380Y y2) {
        if (y == null) {
            return y2;
        }
        if (y2 == null) {
            return y;
        }
        C2380Y y3 = f3865a;
        if (y == y3 || y2 == y3) {
            return f3865a;
        }
        C2382b bVar = new C2382b(y, y2);
        C2380Y[] yArr = bVar.f3867b;
        return yArr.length == 1 ? yArr[0] : bVar;
    }

    /* renamed from: a */
    public abstract boolean mo34096a(C2474v<?, ?> vVar, C2476w wVar);

    /* renamed from: b */
    public C2380Y mo34097b(C2474v<?, ?> vVar, C2476w wVar) {
        return this;
    }
}
