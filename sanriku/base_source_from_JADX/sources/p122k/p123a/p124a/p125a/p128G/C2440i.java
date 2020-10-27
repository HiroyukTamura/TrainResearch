package p122k.p123a.p124a.p125a.p128G;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import p009e.p028d.p030b.p054b.C1532a;
import p122k.p123a.p124a.p125a.C2351B;
import p122k.p123a.p124a.p125a.C2352C;

/* renamed from: k.a.a.a.G.i */
public class C2440i implements C2436e {

    /* renamed from: c */
    public static final C2440i f4002c;

    /* renamed from: d */
    public static final C2440i f4003d;

    /* renamed from: a */
    protected List<C2439h> f4004a;

    /* renamed from: b */
    protected boolean f4005b;

    static {
        C2440i b = m4151b(0, 65534);
        f4002c = b;
        b.mo34257a(true);
        C2440i iVar = new C2440i(new int[0]);
        f4003d = iVar;
        iVar.mo34257a(true);
    }

    public C2440i(int... iArr) {
        if (iArr == null) {
            this.f4004a = new ArrayList(2);
            return;
        }
        this.f4004a = new ArrayList(iArr.length);
        for (int a : iArr) {
            mo34255a(a);
        }
    }

    /* renamed from: b */
    public static C2440i m4151b(int i, int i2) {
        C2440i iVar = new C2440i(new int[0]);
        iVar.mo34256a(i, i2);
        return iVar;
    }

    /* renamed from: a */
    public int mo34251a() {
        if (mo34258b()) {
            return 0;
        }
        return this.f4004a.get(0).f4000a;
    }

    /* renamed from: a */
    public String mo34252a(C2351B b) {
        StringBuilder sb = new StringBuilder();
        List<C2439h> list = this.f4004a;
        if (list == null || list.isEmpty()) {
            return "{}";
        }
        if (mo34260c() > 1) {
            sb.append("{");
        }
        Iterator<C2439h> it = this.f4004a.iterator();
        while (it.hasNext()) {
            C2439h next = it.next();
            int i = next.f4000a;
            int i2 = next.f4001b;
            if (i == i2) {
                sb.append(mo34253a(b, i));
            } else {
                for (int i3 = i; i3 <= i2; i3++) {
                    if (i3 > i) {
                        sb.append(", ");
                    }
                    sb.append(mo34253a(b, i3));
                }
            }
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        if (mo34260c() > 1) {
            sb.append("}");
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo34253a(C2351B b, int i) {
        return i == -1 ? "<EOF>" : i == -2 ? "<EPSILON>" : ((C2352C) b).mo34032a(i);
    }

    /* renamed from: a */
    public void mo34255a(int i) {
        if (!this.f4005b) {
            mo34256a(i, i);
            return;
        }
        throw new IllegalStateException("can't alter readonly IntervalSet");
    }

    /* renamed from: a */
    public void mo34256a(int i, int i2) {
        boolean z;
        C2439h a = C2439h.m4146a(i, i2);
        if (this.f4005b) {
            throw new IllegalStateException("can't alter readonly IntervalSet");
        } else if (a.f4001b >= a.f4000a) {
            ListIterator<C2439h> listIterator = this.f4004a.listIterator();
            while (listIterator.hasNext()) {
                C2439h next = listIterator.next();
                if (!a.equals(next)) {
                    if (a.mo34245a(next) || !a.mo34246b(next)) {
                        C2439h c = a.mo34247c(next);
                        listIterator.set(c);
                        while (listIterator.hasNext()) {
                            C2439h next2 = listIterator.next();
                            if (c.mo34245a(next2) || !c.mo34246b(next2)) {
                                listIterator.remove();
                                listIterator.previous();
                                listIterator.set(c.mo34247c(next2));
                                listIterator.next();
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    int i3 = a.f4000a;
                    int i4 = next.f4000a;
                    if (i3 >= i4 || a.f4001b >= i4) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        listIterator.previous();
                        listIterator.add(a);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f4004a.add(a);
        }
    }

    /* renamed from: a */
    public void mo34257a(boolean z) {
        if (!this.f4005b || z) {
            this.f4005b = z;
            return;
        }
        throw new IllegalStateException("can't alter readonly IntervalSet");
    }

    /* renamed from: b */
    public boolean mo34258b() {
        List<C2439h> list = this.f4004a;
        return list == null || list.isEmpty();
    }

    /* renamed from: b */
    public boolean mo34259b(int i) {
        int size = this.f4004a.size();
        int i2 = 0;
        while (i2 < size) {
            C2439h hVar = this.f4004a.get(i2);
            int i3 = hVar.f4000a;
            int i4 = hVar.f4001b;
            if (i < i3) {
                break;
            } else if (i >= i3 && i <= i4) {
                return true;
            } else {
                i2++;
            }
        }
        return false;
    }

    /* renamed from: c */
    public int mo34260c() {
        int size = this.f4004a.size();
        if (size == 1) {
            C2439h hVar = this.f4004a.get(0);
            return (hVar.f4001b - hVar.f4000a) + 1;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            C2439h hVar2 = this.f4004a.get(i2);
            i += (hVar2.f4001b - hVar2.f4000a) + 1;
        }
        return i;
    }

    /* renamed from: c */
    public void mo34261c(int i) {
        if (!this.f4005b) {
            int size = this.f4004a.size();
            int i2 = 0;
            while (i2 < size) {
                C2439h hVar = this.f4004a.get(i2);
                int i3 = hVar.f4000a;
                int i4 = hVar.f4001b;
                if (i >= i3) {
                    if (i == i3 && i == i4) {
                        this.f4004a.remove(i2);
                        return;
                    } else if (i == i3) {
                        hVar.f4000a++;
                        return;
                    } else if (i == i4) {
                        hVar.f4001b--;
                        return;
                    } else {
                        if (i > i3 && i < i4) {
                            int i5 = hVar.f4001b;
                            hVar.f4001b = i - 1;
                            mo34256a(i + 1, i5);
                        }
                        i2++;
                    }
                } else {
                    return;
                }
            }
            return;
        }
        throw new IllegalStateException("can't alter readonly IntervalSet");
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C2440i)) {
            return false;
        }
        return this.f4004a.equals(((C2440i) obj).f4004a);
    }

    public int hashCode() {
        int i = 0;
        for (C2439h next : this.f4004a) {
            i = C1532a.m2145b(C1532a.m2145b(i, next.f4000a), next.f4001b);
        }
        return C1532a.m2119a(i, this.f4004a.size() * 2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<C2439h> list = this.f4004a;
        if (list == null || list.isEmpty()) {
            return "{}";
        }
        if (mo34260c() > 1) {
            sb.append("{");
        }
        Iterator<C2439h> it = this.f4004a.iterator();
        while (it.hasNext()) {
            C2439h next = it.next();
            int i = next.f4000a;
            int i2 = next.f4001b;
            if (i != i2) {
                sb.append(i);
                sb.append("..");
                sb.append(i2);
            } else if (i == -1) {
                sb.append("<EOF>");
            } else {
                sb.append(i);
            }
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        if (mo34260c() > 1) {
            sb.append("}");
        }
        return sb.toString();
    }

    /* renamed from: a */
    public C2440i mo34254a(C2436e eVar) {
        if (eVar == null) {
            return this;
        }
        boolean z = eVar instanceof C2440i;
        int i = 0;
        C2440i iVar = (C2440i) eVar;
        if (z) {
            int size = iVar.f4004a.size();
            while (i < size) {
                C2439h hVar = iVar.f4004a.get(i);
                mo34256a(hVar.f4000a, hVar.f4001b);
                i++;
            }
        } else {
            ArrayList arrayList = new ArrayList();
            int size2 = iVar.f4004a.size();
            while (i < size2) {
                C2439h hVar2 = iVar.f4004a.get(i);
                int i2 = hVar2.f4001b;
                for (int i3 = hVar2.f4000a; i3 <= i2; i3++) {
                    arrayList.add(Integer.valueOf(i3));
                }
                i++;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                mo34255a(((Integer) it.next()).intValue());
            }
        }
        return this;
    }

    /* renamed from: a */
    public static C2440i m4150a(C2440i iVar, C2440i iVar2) {
        int i = 0;
        if (iVar == null || iVar.mo34258b()) {
            return new C2440i(new int[0]);
        }
        C2440i iVar3 = new C2440i(new int[0]);
        iVar3.mo34254a((C2436e) iVar);
        if (iVar2 != null && !iVar2.mo34258b()) {
            int i2 = 0;
            while (i < iVar3.f4004a.size() && i2 < iVar2.f4004a.size()) {
                C2439h hVar = iVar3.f4004a.get(i);
                C2439h hVar2 = iVar2.f4004a.get(i2);
                int i3 = hVar2.f4001b;
                int i4 = hVar.f4000a;
                if (i3 >= i4) {
                    int i5 = hVar2.f4000a;
                    if (i5 <= hVar.f4001b) {
                        C2439h hVar3 = null;
                        C2439h hVar4 = i5 > i4 ? new C2439h(hVar.f4000a, hVar2.f4000a - 1) : null;
                        if (hVar2.f4001b < hVar.f4001b) {
                            hVar3 = new C2439h(hVar2.f4001b + 1, hVar.f4001b);
                        }
                        List<C2439h> list = iVar3.f4004a;
                        if (hVar4 != null) {
                            list.set(i, hVar4);
                            if (hVar3 != null) {
                                i++;
                                iVar3.f4004a.add(i, hVar3);
                            }
                        } else if (hVar3 != null) {
                            list.set(i, hVar3);
                        } else {
                            list.remove(i);
                        }
                    }
                    i++;
                }
                i2++;
            }
        }
        return iVar3;
    }
}
