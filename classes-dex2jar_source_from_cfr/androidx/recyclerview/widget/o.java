/*
 * Decompiled with CFR 0.139.
 */
package androidx.recyclerview.widget;

import androidx.core.g.d;
import androidx.recyclerview.widget.RecyclerView;

class o {
    final androidx.c.a<RecyclerView.x, a> a = new androidx.c.a();
    final androidx.c.d<RecyclerView.x> b = new androidx.c.d();

    o() {
    }

    private RecyclerView.f.c a(RecyclerView.x object, int n2) {
        block5 : {
            block8 : {
                a a2;
                int n3;
                block7 : {
                    block6 : {
                        n3 = this.a.a(object);
                        if (n3 < 0) {
                            return null;
                        }
                        a2 = (a)this.a.c(n3);
                        if (a2 == null || (a2.a & n2) == 0) break block5;
                        a2.a &= n2;
                        if (n2 != 4) break block6;
                        object = a2.b;
                        break block7;
                    }
                    if (n2 != 8) break block8;
                    object = a2.c;
                }
                if ((a2.a & 12) == 0) {
                    this.a.d(n3);
                    a.a(a2);
                }
                return object;
            }
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        return null;
    }

    RecyclerView.x a(long l2) {
        return this.b.a(l2);
    }

    void a() {
        this.a.clear();
        this.b.c();
    }

    void a(long l2, RecyclerView.x x2) {
        this.b.b(l2, x2);
    }

    void a(RecyclerView.x x2, RecyclerView.f.c c2) {
        a a2;
        a a3 = a2 = (a)this.a.get(x2);
        if (a2 == null) {
            a3 = a.a();
            this.a.put(x2, a3);
        }
        a3.b = c2;
        a3.a |= 4;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    void a(b var1_1) {
        var2_2 = this.a.size() - 1;
        while (var2_2 >= 0) {
            block10 : {
                block8 : {
                    block9 : {
                        block7 : {
                            var6_6 = (RecyclerView.x)this.a.b(var2_2);
                            var7_7 = (a)this.a.d(var2_2);
                            if ((var7_7.a & 3) == 3) break block7;
                            if ((var7_7.a & 1) == 0) break block8;
                            if (var7_7.b != null) break block9;
                        }
                        var1_1.a(var6_6);
                        break block10;
                    }
                    var4_4 = var7_7.b;
                    var5_5 = var7_7.c;
                    ** GOTO lbl23
                }
                if ((var7_7.a & 14) == 14) ** GOTO lbl-1000
                if ((var7_7.a & 12) == 12) {
                    var1_1.c(var6_6, var7_7.b, var7_7.c);
                } else if ((var7_7.a & 4) != 0) {
                    var4_4 = var7_7.b;
                    var5_5 = null;
lbl23: // 2 sources:
                    var1_1.a(var6_6, var4_4, var5_5);
                } else if ((var7_7.a & 8) != 0) lbl-1000: // 2 sources:
                {
                    var1_1.b(var6_6, var7_7.b, var7_7.c);
                } else {
                    var3_3 = var7_7.a;
                }
            }
            a.a(var7_7);
            --var2_2;
        }
    }

    boolean a(RecyclerView.x object) {
        return (object = (a)this.a.get(object)) != null && (((a)object).a & 1) != 0;
    }

    RecyclerView.f.c b(RecyclerView.x x2) {
        return this.a(x2, 4);
    }

    void b() {
        a.b();
    }

    void b(RecyclerView.x x2, RecyclerView.f.c c2) {
        a a2;
        a a3 = a2 = (a)this.a.get(x2);
        if (a2 == null) {
            a3 = a.a();
            this.a.put(x2, a3);
        }
        a3.a |= 2;
        a3.b = c2;
    }

    RecyclerView.f.c c(RecyclerView.x x2) {
        return this.a(x2, 8);
    }

    void c(RecyclerView.x x2, RecyclerView.f.c c2) {
        a a2;
        a a3 = a2 = (a)this.a.get(x2);
        if (a2 == null) {
            a3 = a.a();
            this.a.put(x2, a3);
        }
        a3.c = c2;
        a3.a |= 8;
    }

    boolean d(RecyclerView.x object) {
        return (object = (a)this.a.get(object)) != null && (((a)object).a & 4) != 0;
    }

    void e(RecyclerView.x x2) {
        a a2;
        a a3 = a2 = (a)this.a.get(x2);
        if (a2 == null) {
            a3 = a.a();
            this.a.put(x2, a3);
        }
        a3.a |= 1;
    }

    void f(RecyclerView.x object) {
        if ((object = (a)this.a.get(object)) == null) {
            return;
        }
        ((a)object).a &= -2;
    }

    void g(RecyclerView.x object) {
        for (int i2 = this.b.b() - 1; i2 >= 0; --i2) {
            if (object != this.b.c(i2)) continue;
            this.b.a(i2);
            break;
        }
        if ((object = (a)this.a.remove(object)) != null) {
            a.a((a)object);
        }
    }

    public void h(RecyclerView.x x2) {
        this.f(x2);
    }

    static class a {
        static d.a<a> d = new d.b<a>(20);
        int a;
        RecyclerView.f.c b;
        RecyclerView.f.c c;

        private a() {
        }

        static a a() {
            a a2;
            a a3 = a2 = d.a();
            if (a2 == null) {
                a3 = new a();
            }
            return a3;
        }

        static void a(a a2) {
            a2.a = 0;
            a2.b = null;
            a2.c = null;
            d.a(a2);
        }

        static void b() {
            while (d.a() != null) {
            }
        }
    }

    static interface b {
        public void a(RecyclerView.x var1);

        public void a(RecyclerView.x var1, RecyclerView.f.c var2, RecyclerView.f.c var3);

        public void b(RecyclerView.x var1, RecyclerView.f.c var2, RecyclerView.f.c var3);

        public void c(RecyclerView.x var1, RecyclerView.f.c var2, RecyclerView.f.c var3);
    }

}

