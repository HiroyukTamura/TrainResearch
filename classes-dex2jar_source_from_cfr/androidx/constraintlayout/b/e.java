/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b;

import androidx.constraintlayout.b.a.e;
import androidx.constraintlayout.b.b;
import androidx.constraintlayout.b.c;
import androidx.constraintlayout.b.d;
import androidx.constraintlayout.b.f;
import androidx.constraintlayout.b.g;
import androidx.constraintlayout.b.h;
import java.util.Arrays;
import java.util.HashMap;

public class e {
    public static f g;
    private static int h = 1000;
    int a = 0;
    b[] b = new b[this.k];
    public boolean c = false;
    int d = 1;
    int e = 0;
    final c f;
    private HashMap<String, h> i = null;
    private a j;
    private int k;
    private int l = this.k = 32;
    private boolean[] m = new boolean[this.k];
    private int n = this.k;
    private h[] o = new h[h];
    private int p = 0;
    private b[] q = new b[this.k];
    private final a r;

    public e() {
        this.i();
        this.f = new c();
        this.j = new d(this.f);
        this.r = new b(this.f);
    }

    private final int a(a a2, boolean bl2) {
        Object object;
        int n2;
        if (g != null) {
            object = g;
            ++((f)object).h;
        }
        for (n2 = 0; n2 < this.d; ++n2) {
            this.m[n2] = false;
        }
        boolean bl3 = false;
        n2 = 0;
        while (!bl3) {
            int n3;
            if (g != null) {
                object = g;
                ++((f)object).i;
            }
            if ((n3 = n2 + 1) >= this.d * 2) {
                return n3;
            }
            if (a2.g() != null) {
                this.m[a2.g().a] = true;
            }
            if ((object = a2.a(this, this.m)) != null) {
                if (this.m[((h)object).a]) {
                    return n3;
                }
                this.m[object.a] = true;
            }
            if (object != null) {
                b b2;
                int n4 = -1;
                float f2 = Float.MAX_VALUE;
                for (n2 = 0; n2 < this.e; ++n2) {
                    int n5;
                    float f3;
                    b2 = this.b[n2];
                    if (b2.a.f == h.a.a) {
                        n5 = n4;
                        f3 = f2;
                    } else if (b2.e) {
                        n5 = n4;
                        f3 = f2;
                    } else {
                        n5 = n4;
                        f3 = f2;
                        if (b2.a((h)object)) {
                            float f4 = b2.d.b((h)object);
                            n5 = n4;
                            f3 = f2;
                            if (f4 < 0.0f) {
                                f4 = -b2.b / f4;
                                n5 = n4;
                                f3 = f2;
                                if (f4 < f2) {
                                    n5 = n2;
                                    f3 = f4;
                                }
                            }
                        }
                    }
                    n4 = n5;
                    f2 = f3;
                }
                if (n4 > -1) {
                    b2 = this.b[n4];
                    b2.a.b = -1;
                    if (g != null) {
                        f f5 = g;
                        ++f5.j;
                    }
                    b2.c((h)object);
                    b2.a.b = n4;
                    b2.a.c(b2);
                    n2 = n3;
                    continue;
                }
            }
            bl3 = true;
            n2 = n3;
        }
        return n2;
    }

    public static b a(e e2, h h2, h h3, h h4, float f2, boolean bl2) {
        b b2 = e2.c();
        if (bl2) {
            e2.b(b2);
        }
        return b2.a(h2, h3, h4, f2);
    }

    public static f a() {
        return g;
    }

    /*
     * Enabled aggressive block sorting
     */
    private h a(h.a arrh, String string2) {
        h h2 = this.f.b.a();
        if (h2 == null) {
            h2 = new h((h.a)arrh, string2);
        } else {
            h2.b();
        }
        h2.a((h.a)arrh, string2);
        if (this.p >= h) {
            this.o = Arrays.copyOf(this.o, h *= 2);
        }
        arrh = this.o;
        int n2 = this.p;
        this.p = n2 + 1;
        arrh[n2] = h2;
        return h2;
    }

    private int b(a object) {
        block14 : {
            int n2;
            block13 : {
                for (n2 = 0; n2 < this.e; ++n2) {
                    if (this.b[n2].a.f == h.a.a || !(this.b[n2].b < 0.0f)) continue;
                    n2 = 1;
                    break block13;
                }
                n2 = 0;
            }
            if (n2 == 0) break block14;
            boolean bl2 = false;
            n2 = 0;
            while (!bl2) {
                Object object2;
                if (g != null) {
                    object = g;
                    ++((f)object).k;
                }
                int n3 = n2 + 1;
                n2 = -1;
                int n4 = -1;
                float f2 = Float.MAX_VALUE;
                int n5 = 0;
                for (int i2 = 0; i2 < this.e; ++i2) {
                    int n6;
                    int n7;
                    float f3;
                    int n8;
                    block16 : {
                        block17 : {
                            block15 : {
                                object = this.b[i2];
                                if (object.a.f != h.a.a) break block15;
                                n8 = n2;
                                n6 = n4;
                                f3 = f2;
                                n7 = n5;
                                break block16;
                            }
                            if (!((b)object).e) break block17;
                            n8 = n2;
                            n6 = n4;
                            f3 = f2;
                            n7 = n5;
                            break block16;
                        }
                        n8 = n2;
                        n6 = n4;
                        f3 = f2;
                        n7 = n5;
                        if (!(((b)object).b < 0.0f)) break block16;
                        int n9 = 1;
                        do {
                            block18 : {
                                n8 = n2;
                                n6 = n4;
                                f3 = f2;
                                n7 = n5;
                                if (n9 >= this.d) break;
                                object2 = this.f.c[n9];
                                float f4 = ((b)object).d.b((h)object2);
                                if (f4 <= 0.0f) break block18;
                                n6 = n5;
                                n7 = 0;
                                n5 = n4;
                                n8 = n2;
                                n4 = n6;
                                for (n2 = n7; n2 < 7; ++n2) {
                                    block20 : {
                                        block19 : {
                                            f3 = ((h)object2).e[n2] / f4;
                                            if (f3 < f2 && n2 == n4) break block19;
                                            n6 = n4;
                                            if (n2 <= n4) break block20;
                                        }
                                        n5 = n9;
                                        n8 = i2;
                                        f2 = f3;
                                        n6 = n2;
                                    }
                                    n4 = n6;
                                }
                                n2 = n5;
                                n5 = n4;
                                n4 = n2;
                                n2 = n8;
                            }
                            ++n9;
                        } while (true);
                    }
                    n2 = n8;
                    n4 = n6;
                    f2 = f3;
                    n5 = n7;
                }
                if (n2 != -1) {
                    object = this.b[n2];
                    object.a.b = -1;
                    if (g != null) {
                        object2 = g;
                        ++((f)object2).j;
                    }
                    ((b)object).c(this.f.c[n4]);
                    object.a.b = n2;
                    ((b)object).a.c((b)object);
                } else {
                    bl2 = true;
                }
                if (n3 > this.d / 2) {
                    bl2 = true;
                }
                n2 = n3;
            }
            return n2;
        }
        return 0;
    }

    private void b(b b2) {
        b2.a(this, 0);
    }

    private final void c(b b2) {
        if (this.e > 0) {
            b2.d.a(b2, this.b);
            if (b2.d.a == 0) {
                b2.e = true;
            }
        }
    }

    private final void d(b b2) {
        if (this.b[this.e] != null) {
            this.f.a.a(this.b[this.e]);
        }
        this.b[this.e] = b2;
        b2.a.b = this.e++;
        b2.a.c(b2);
    }

    private void h() {
        this.k *= 2;
        this.b = Arrays.copyOf(this.b, this.k);
        this.f.c = Arrays.copyOf(this.f.c, this.k);
        this.m = new boolean[this.k];
        this.l = this.k;
        this.n = this.k;
        if (g != null) {
            f f2 = g;
            ++f2.d;
            e.g.D = e.g.p = Math.max(e.g.p, (long)this.k);
        }
    }

    private void i() {
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            b b2 = this.b[i2];
            if (b2 != null) {
                this.f.a.a(b2);
            }
            this.b[i2] = null;
        }
    }

    private void j() {
        for (int i2 = 0; i2 < this.e; ++i2) {
            b b2 = this.b[i2];
            b2.a.d = b2.b;
        }
    }

    public h a(int n2, String object) {
        if (g != null) {
            f f2 = g;
            ++f2.m;
        }
        if (this.d + 1 >= this.l) {
            this.h();
        }
        object = this.a(h.a.d, (String)object);
        ++this.a;
        ++this.d;
        ((h)object).a = this.a;
        ((h)object).c = n2;
        this.f.c[this.a] = object;
        this.j.d((h)object);
        return object;
    }

    public h a(Object object) {
        Object object2;
        block7 : {
            block8 : {
                object2 = null;
                if (object == null) {
                    return null;
                }
                if (this.d + 1 >= this.l) {
                    this.h();
                }
                if (!(object instanceof androidx.constraintlayout.b.a.e)) break block7;
                androidx.constraintlayout.b.a.e e2 = (androidx.constraintlayout.b.a.e)object;
                object = object2 = e2.b();
                if (object2 == null) {
                    e2.a(this.f);
                    object = e2.b();
                }
                if (((h)object).a == -1 || ((h)object).a > this.a) break block8;
                object2 = object;
                if (this.f.c[((h)object).a] != null) break block7;
            }
            if (((h)object).a != -1) {
                ((h)object).b();
            }
            ++this.a;
            ++this.d;
            ((h)object).a = this.a;
            ((h)object).f = h.a.a;
            this.f.c[this.a] = object;
            object2 = object;
        }
        return object2;
    }

    public void a(androidx.constraintlayout.b.a.f object, androidx.constraintlayout.b.a.f object2, float f2, int n2) {
        h h2 = this.a(((androidx.constraintlayout.b.a.f)object).a(e.c.b));
        h h3 = this.a(((androidx.constraintlayout.b.a.f)object).a(e.c.c));
        h h4 = this.a(((androidx.constraintlayout.b.a.f)object).a(e.c.d));
        h h5 = this.a(((androidx.constraintlayout.b.a.f)object).a(e.c.e));
        object = this.a(((androidx.constraintlayout.b.a.f)object2).a(e.c.b));
        h h6 = this.a(((androidx.constraintlayout.b.a.f)object2).a(e.c.c));
        h h7 = this.a(((androidx.constraintlayout.b.a.f)object2).a(e.c.d));
        object2 = this.a(((androidx.constraintlayout.b.a.f)object2).a(e.c.e));
        b b2 = this.c();
        double d2 = f2;
        double d3 = Math.sin(d2);
        double d4 = n2;
        b2.b(h3, h5, h6, (h)object2, (float)(d3 * d4));
        this.a(b2);
        object2 = this.c();
        ((b)object2).b(h2, h4, (h)object, h7, (float)(Math.cos(d2) * d4));
        this.a((b)object2);
    }

    public void a(b b2) {
        Object object;
        if (b2 == null) {
            return;
        }
        if (g != null) {
            object = g;
            ++((f)object).f;
            if (b2.e) {
                object = g;
                ++((f)object).g;
            }
        }
        if (this.e + 1 >= this.n || this.d + 1 >= this.l) {
            this.h();
        }
        boolean bl2 = false;
        boolean bl3 = false;
        if (!b2.e) {
            this.c(b2);
            if (b2.e()) {
                return;
            }
            b2.d();
            bl2 = bl3;
            if (b2.a(this)) {
                b2.a = object = this.e();
                this.d(b2);
                this.r.a(b2);
                this.a(this.r, true);
                if (((h)object).b == -1) {
                    if (b2.a == object && (object = b2.b((h)object)) != null) {
                        if (g != null) {
                            f f2 = g;
                            ++f2.j;
                        }
                        b2.c((h)object);
                    }
                    if (!b2.e) {
                        b2.a.c(b2);
                    }
                    --this.e;
                }
                bl2 = true;
            }
            if (!b2.a()) {
                return;
            }
        }
        if (!bl2) {
            this.d(b2);
        }
    }

    void a(b b2, int n2, int n3) {
        b2.c(this.a(n3, null), n2);
    }

    void a(a a2) {
        if (g != null) {
            f f2 = g;
            ++f2.t;
            e.g.u = Math.max(e.g.u, (long)this.d);
            e.g.v = Math.max(e.g.v, (long)this.e);
        }
        this.c((b)a2);
        this.b(a2);
        this.a(a2, false);
        this.j();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(h object, int n2) {
        block5 : {
            block2 : {
                b b2;
                block4 : {
                    block3 : {
                        int n3 = ((h)object).b;
                        if (((h)object).b == -1) break block2;
                        b2 = this.b[n3];
                        if (b2.e) break block3;
                        if (b2.d.a != 0) break block4;
                        b2.e = true;
                    }
                    b2.b = n2;
                    return;
                }
                b2 = this.c();
                b2.b((h)object, n2);
                object = b2;
                break block5;
            }
            b b3 = this.c();
            b3.a((h)object, n2);
            object = b3;
        }
        this.a((b)object);
    }

    public void a(h h2, h h3, int n2, float f2, h h4, h h5, int n3, int n4) {
        b b2 = this.c();
        b2.a(h2, h3, n2, f2, h4, h5, n3);
        if (n4 != 6) {
            b2.a(this, n4);
        }
        this.a(b2);
    }

    public void a(h h2, h h3, int n2, int n3) {
        b b2 = this.c();
        h h4 = this.d();
        h4.c = 0;
        b2.a(h2, h3, h4, n2);
        if (n3 != 6) {
            this.a(b2, (int)(b2.d.b(h4) * -1.0f), n3);
        }
        this.a(b2);
    }

    public void a(h h2, h h3, h h4, h h5, float f2, int n2) {
        b b2 = this.c();
        b2.a(h2, h3, h4, h5, f2);
        if (n2 != 6) {
            b2.a(this, n2);
        }
        this.a(b2);
    }

    public void a(h h2, h h3, boolean bl2) {
        b b2 = this.c();
        h h4 = this.d();
        h4.c = 0;
        b2.a(h2, h3, h4, 0);
        if (bl2) {
            this.a(b2, (int)(b2.d.b(h4) * -1.0f), 1);
        }
        this.a(b2);
    }

    public int b(Object object) {
        if ((object = ((androidx.constraintlayout.b.a.e)object).b()) != null) {
            return (int)(((h)object).d + 0.5f);
        }
        return 0;
    }

    public void b() {
        int n2;
        for (n2 = 0; n2 < this.f.c.length; ++n2) {
            h h2 = this.f.c[n2];
            if (h2 == null) continue;
            h2.b();
        }
        this.f.b.a(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.f.c, null);
        if (this.i != null) {
            this.i.clear();
        }
        this.a = 0;
        this.j.f();
        this.d = 1;
        for (n2 = 0; n2 < this.e; ++n2) {
            this.b[n2].c = false;
        }
        this.i();
        this.e = 0;
    }

    public void b(h h2, h h3, int n2, int n3) {
        b b2 = this.c();
        h h4 = this.d();
        h4.c = 0;
        b2.b(h2, h3, h4, n2);
        if (n3 != 6) {
            this.a(b2, (int)(b2.d.b(h4) * -1.0f), n3);
        }
        this.a(b2);
    }

    public void b(h h2, h h3, boolean bl2) {
        b b2 = this.c();
        h h4 = this.d();
        h4.c = 0;
        b2.b(h2, h3, h4, 0);
        if (bl2) {
            this.a(b2, (int)(b2.d.b(h4) * -1.0f), 1);
        }
        this.a(b2);
    }

    public b c() {
        b b2 = this.f.a.a();
        if (b2 == null) {
            b2 = new b(this.f);
        } else {
            b2.c();
        }
        h.a();
        return b2;
    }

    public b c(h h2, h h3, int n2, int n3) {
        b b2 = this.c();
        b2.a(h2, h3, n2);
        if (n3 != 6) {
            b2.a(this, n3);
        }
        this.a(b2);
        return b2;
    }

    public h d() {
        Object object;
        if (g != null) {
            object = g;
            ++((f)object).n;
        }
        if (this.d + 1 >= this.l) {
            this.h();
        }
        object = this.a(h.a.c, null);
        ++this.a;
        ++this.d;
        ((h)object).a = this.a;
        this.f.c[this.a] = object;
        return object;
    }

    public h e() {
        Object object;
        if (g != null) {
            object = g;
            ++((f)object).o;
        }
        if (this.d + 1 >= this.l) {
            this.h();
        }
        object = this.a(h.a.c, null);
        ++this.a;
        ++this.d;
        ((h)object).a = this.a;
        this.f.c[this.a] = object;
        return object;
    }

    public void f() {
        f f2;
        if (g != null) {
            f2 = g;
            ++f2.e;
        }
        if (this.c) {
            int n2;
            block6 : {
                if (g != null) {
                    f2 = g;
                    ++f2.r;
                }
                int n3 = 0;
                for (n2 = 0; n2 < this.e; ++n2) {
                    if (this.b[n2].e) continue;
                    n2 = n3;
                    break block6;
                }
                n2 = 1;
            }
            if (n2 != 0) {
                if (g != null) {
                    f2 = g;
                    ++f2.q;
                }
                this.j();
                return;
            }
        }
        this.a(this.j);
    }

    public c g() {
        return this.f;
    }

    static interface a {
        public h a(e var1, boolean[] var2);

        public void a(a var1);

        public void d(h var1);

        public void f();

        public h g();
    }

}

