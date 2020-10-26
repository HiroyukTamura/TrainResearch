/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import androidx.constraintlayout.b.a.e;
import androidx.constraintlayout.b.a.f;
import androidx.constraintlayout.b.a.g;
import androidx.constraintlayout.b.a.h;
import androidx.constraintlayout.b.a.k;
import androidx.constraintlayout.b.a.n;
import androidx.constraintlayout.b.a.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class a {
    private static int a(f f2, int n2, boolean bl2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        int n11;
        int n12 = f2.w.c != null && n2 == 1 ? 1 : 0;
        if (bl2) {
            n8 = f2.B();
            n5 = f2.r() - f2.B();
            n11 = n2 * 2;
            n4 = n11 + 1;
        } else {
            n8 = f2.r() - f2.B();
            n5 = f2.B();
            n4 = n2 * 2;
            n11 = n4 + 1;
        }
        if (f2.A[n4].c != null && f2.A[n11].c == null) {
            n10 = -1;
            n7 = n4;
            n4 = n10;
            n9 = n11;
        } else {
            n7 = 1;
            n9 = n4;
            n4 = n7;
            n7 = n11;
        }
        n10 = n12 != 0 ? n3 - n8 : n3;
        int n13 = f2.A[n7].e() * n4;
        int n14 = n13 + n10;
        n3 = n2 == 0 ? f2.p() : f2.r();
        int n15 = n3 * n4;
        Iterator iterator = f2.A[n7].a().h.iterator();
        n3 = 0;
        while (iterator.hasNext()) {
            n3 = Math.max(n3, a.a(((n)((p)iterator.next())).a.a, n2, bl2, n14));
        }
        iterator = f2.A[n9].a().h.iterator();
        n11 = 0;
        while (iterator.hasNext()) {
            n11 = Math.max(n11, a.a(((n)((p)iterator.next())).a.a, n2, bl2, n15 + n14));
        }
        if (n12 != 0) {
            n6 = n3 - n8;
            n9 = n11 + n5;
        } else {
            n9 = n2 == 0 ? f2.p() : f2.r();
            n9 = n11 + n9 * n4;
            n6 = n3;
        }
        if (n2 == 1) {
            iterator = f2.w.a().h.iterator();
            n11 = 0;
            n3 = n15;
            while (iterator.hasNext()) {
                n n16 = (n)((p)iterator.next());
                if (n4 == 1) {
                    n11 = Math.max(n11, a.a(n16.a.a, n2, bl2, n8 + n14));
                    continue;
                }
                n11 = Math.max(n11, a.a(n16.a.a, n2, bl2, n5 * n4 + n14));
            }
            n15 = n3;
            n3 = n14 = n11;
            n11 = n15;
            if (f2.w.a().h.size() > 0) {
                n3 = n14;
                n11 = n15;
                if (n12 == 0) {
                    if (n4 == 1) {
                        n3 = n14 + n8;
                        n11 = n15;
                    } else {
                        n3 = n14 - n5;
                        n11 = n15;
                    }
                }
            }
        } else {
            n11 = n15;
            n3 = 0;
        }
        n5 = n13 + Math.max(n6, Math.max(n9, n3));
        n3 = n10 + f2.A[n7].e() * n4;
        n8 = n12 = n3 + n11;
        n11 = n3;
        if (n4 == -1) {
            n11 = n12;
            n8 = n3;
        }
        if (bl2) {
            f2.a(n11, n8, n2);
            return n5;
        }
        if (n2 == 0) {
            f2.r.g.add(f2);
            f2.K = n11;
            return n5;
        }
        if (n2 == 1) {
            f2.r.h.add(f2);
            f2.L = n11;
        }
        return n5;
    }

    private static int a(h h2, int n2) {
        Iterator<f> iterator = h2.a(n2).iterator();
        int n3 = 0;
        while (iterator.hasNext()) {
            f f2 = iterator.next();
            e[] arre = f2.A;
            boolean bl2 = true;
            if (arre[n2 * 2 + 1].c != null) {
                bl2 = false;
            }
            n3 = Math.max(n3, a.a(f2, n2, bl2, 0));
        }
        h2.d[n2] = n3;
        return n3;
    }

    private static void a(e e2) {
        n n2 = e2.a();
        if (e2.c != null && e2.c.c != e2) {
            e2.c.a().a(n2);
        }
    }

    private static void a(f f2, int n2, int n3) {
        if (n2 == 0) {
            n2 = n3 - (f2.K + f2.p());
            f2.c(n2, f2.p() + n2);
            return;
        }
        if (n2 == 1) {
            n2 = n3 - (f2.L + f2.r());
            f2.d(n2, f2.r() + n2);
        }
    }

    public static void a(g g2) {
        if ((g2.b() & 32) != 32) {
            a.b(g2);
            return;
        }
        g2.au = true;
        g2.ap = false;
        g2.aq = false;
        g2.ar = false;
        Iterator<h> iterator = g2.aw;
        List<h> list = g2.ao;
        boolean bl2 = g2.G() == f.a.b;
        boolean bl3 = g2.H() == f.a.b;
        boolean bl4 = bl2 || bl3;
        list.clear();
        Object object = iterator.iterator();
        while (object.hasNext()) {
            f f2 = (f)object.next();
            f2.r = null;
            f2.t.a().h.clear();
            f2.v.a().h.clear();
            f2.s.a().h.clear();
            f2.u.a().h.clear();
            f2.w.a().h.clear();
            f2.z.a().h.clear();
        }
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object = (f)iterator.next();
            if (((f)object).r != null || a.a((f)object, list, bl4)) continue;
            a.b(g2);
            g2.au = false;
            return;
        }
        if (!g2.au) {
            return;
        }
        iterator = list.iterator();
        int n2 = 0;
        int n3 = 0;
        while (iterator.hasNext()) {
            int n4;
            block13 : {
                block12 : {
                    object = iterator.next();
                    if (bl2) break block12;
                    n4 = n2;
                    if (bl4) break block13;
                }
                n4 = Math.max(n2, a.a((h)object, 0));
            }
            if (!bl3) {
                n2 = n4;
                if (bl4) continue;
            }
            n3 = Math.max(n3, a.a((h)object, 1));
            n2 = n4;
        }
        if (bl2) {
            g2.a(f.a.a);
            g2.h(n2);
            g2.ap = true;
            g2.aq = true;
            g2.as = n2;
        }
        if (bl3) {
            g2.b(f.a.a);
            g2.i(n3);
            g2.ap = true;
            g2.ar = true;
            g2.at = n3;
        }
        if (bl3 && bl2 || !bl4) {
            g2.au = true;
            a.a(list, 0, n2);
            a.a(list, 1, n3);
            return;
        }
        g2.au = false;
    }

    public static void a(List<h> object, int n2, int n3) {
        object = object.iterator();
        while (object.hasNext()) {
            Iterator<f> iterator = ((h)object.next()).b(n2).iterator();
            while (iterator.hasNext()) {
                a.a(iterator.next(), n2, n3);
            }
        }
    }

    private static boolean a(f object, h h2, List<h> list, boolean bl2) {
        if (object == null) {
            return true;
        }
        g g2 = (g)((f)((Object)object)).k();
        if (((f)object).r == null) {
            int n2;
            int n3;
            h2.a.add((f)((Object)object));
            ((f)object).r = h2;
            if (object.s.c == null && object.u.c == null && object.t.c == null && object.v.c == null && object.w.c == null && object.z.c == null) {
                g2.au = false;
                if (bl2) {
                    return false;
                }
            }
            if (object.t.c != null && object.v.c != null) {
                g2.au = false;
                if (bl2) {
                    return false;
                }
            }
            if (object.s.c != null && object.u.c != null) {
                g2.au = false;
                if (bl2) {
                    return false;
                }
            }
            if ((n2 = ((f)((Object)object)).G() == f.a.c ? 1 : 0) ^ (n3 = ((f)((Object)object)).H() == f.a.c ? 1 : 0) && ((f)object).G != 0.0f) {
                if (((f)((Object)object)).G() == f.a.c) {
                    ((f)((Object)object)).h((int)((float)((f)((Object)object)).r() / ((f)object).G));
                } else if (((f)((Object)object)).H() == f.a.c) {
                    ((f)((Object)object)).i((int)((float)((f)((Object)object)).p() / ((f)object).G));
                }
            } else if (((f)((Object)object)).G() == f.a.c || ((f)((Object)object)).H() == f.a.c) {
                g2.au = false;
                if (bl2) {
                    return false;
                }
            }
            if (object.s.c == null && object.u.c == null || object.s.c != null && object.s.c.a == ((f)object).D || object.u.c != null && object.u.c.a == ((f)object).D) {
                h2.e.add((f)((Object)object));
            }
            if (object.t.c == null && object.v.c == null && object.w.c == null || object.t.c != null && object.t.c.a == ((f)object).D || object.v.c != null && object.v.c.a == ((f)object).D) {
                h2.f.add((f)((Object)object));
            }
            if (object instanceof k) {
                g2.au = false;
                if (bl2) {
                    return false;
                }
                k object2 = (k)((Object)object);
                for (n2 = 0; n2 < object2.ag; ++n2) {
                    if (a.a(object2.af[n2], h2, list, bl2)) continue;
                    return false;
                }
            }
            for (e e2 : ((f)object).A) {
                if (e2.c == null || e2.c.a == ((f)((Object)object)).k()) continue;
                if (e2.b == e.c.g) {
                    g2.au = false;
                    if (bl2) {
                        return false;
                    }
                } else {
                    a.a(e2);
                }
                if (a.a(e2.c.a, h2, list, bl2)) continue;
                return false;
            }
            return true;
        }
        if (((f)object).r != h2) {
            h2.a.addAll(object.r.a);
            h2.e.addAll(object.r.e);
            h2.f.addAll(object.r.f);
            list.remove(((f)object).r);
            object = object.r.a.iterator();
            while (object.hasNext()) {
                object.next().r = h2;
            }
        }
        return true;
    }

    private static boolean a(f f2, List<h> list, boolean bl2) {
        h h2 = new h(new ArrayList<f>());
        list.add(h2);
        return a.a(f2, h2, list, bl2);
    }

    private static void b(g g2) {
        g2.ao.clear();
        g2.ao.add(0, new h(g2.aw));
    }
}

