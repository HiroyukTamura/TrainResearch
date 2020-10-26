/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import androidx.constraintlayout.b.a.d;
import androidx.constraintlayout.b.a.e;
import androidx.constraintlayout.b.a.f;
import androidx.constraintlayout.b.a.h;
import androidx.constraintlayout.b.a.l;
import androidx.constraintlayout.b.a.n;
import androidx.constraintlayout.b.a.o;
import androidx.constraintlayout.b.a.q;
import androidx.constraintlayout.b.a.r;
import androidx.constraintlayout.b.c;
import androidx.constraintlayout.b.e;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class g
extends r {
    private boolean aA = false;
    private boolean aB = false;
    protected e af = new e();
    int ag;
    int ah;
    int ai;
    int aj;
    int ak = 0;
    int al = 0;
    d[] am = new d[4];
    d[] an = new d[4];
    public List<h> ao = new ArrayList<h>();
    public boolean ap = false;
    public boolean aq = false;
    public boolean ar = false;
    public int as = 0;
    public int at = 0;
    public boolean au = false;
    int av = 0;
    private boolean ax = false;
    private q ay;
    private int az = 3;

    private void V() {
        this.ak = 0;
        this.al = 0;
    }

    private void d(f f2) {
        if (this.ak + 1 >= this.an.length) {
            this.an = Arrays.copyOf(this.an, this.an.length * 2);
        }
        this.an[this.ak] = new d(f2, 0, this.M());
        ++this.ak;
    }

    private void e(f f2) {
        if (this.al + 1 >= this.am.length) {
            this.am = Arrays.copyOf(this.am, this.am.length * 2);
        }
        this.am[this.al] = new d(f2, 1, this.M());
        ++this.al;
    }

    public boolean K() {
        return this.aA;
    }

    public boolean L() {
        return this.aB;
    }

    public boolean M() {
        return this.ax;
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void N() {
        int n3;
        int n2;
        int n4 = this.I;
        int n5 = this.J;
        int n6 = Math.max(0, this.p());
        int n7 = Math.max(0, this.r());
        this.aA = false;
        this.aB = false;
        if (this.D != null) {
            if (this.ay == null) {
                this.ay = new q(this);
            }
            this.ay.a(this);
            this.f(this.ag);
            this.g(this.ah);
            this.F();
            this.a(this.af.g());
        } else {
            this.I = 0;
            this.J = 0;
        }
        if (this.az != 0) {
            if (!this.q(8)) {
                this.Q();
            }
            this.R();
            this.af.c = true;
        } else {
            this.af.c = false;
        }
        f.a a2 = this.C[1];
        f.a a3 = this.C[0];
        this.V();
        if (this.ao.size() == 0) {
            this.ao.clear();
            this.ao.add(0, new h(this.aw));
        }
        int n8 = this.ao.size();
        ArrayList arrayList = this.aw;
        boolean bl2 = this.G() == f.a.b || this.H() == f.a.b;
        int n9 = 0;
        for (int i2 = 0; i2 < n8 && !this.au; ++i2) {
            f f2;
            this.aw = (ArrayList)this.ao.get((int)i2).a;
            this.V();
            int n10 = this.aw.size();
            for (n2 = 0; n2 < n10; ++n2) {
                f2 = (f)this.aw.get(n2);
                if (!(f2 instanceof r)) continue;
                ((r)f2).N();
            }
            n2 = 0;
            boolean bl3 = true;
            while (bl3) {
                int n11;
                boolean bl4;
                block44 : {
                    block43 : {
                        block42 : {
                            n3 = n2 + 1;
                            n2 = n9;
                            this.af.b();
                            n2 = n9;
                            this.b(this.af);
                            for (n11 = 0; n11 < n10; ++n11) {
                                n2 = n9;
                                f2 = (f)this.aw.get(n11);
                                f2.b(this.af);
                            }
                            n2 = n9;
                            try {
                                bl4 = this.d(this.af);
                                if (!bl4) break block42;
                            }
                            catch (Exception exception) {}
                            try {
                                this.af.f();
                            }
                            catch (Exception exception) {
                                bl3 = bl4;
                                n9 = n2;
                                break block43;
                            }
                        }
                        n9 = n2;
                        bl3 = bl4;
                        break block44;
                        break block43;
                        catch (Exception exception) {
                            n9 = n2;
                        }
                    }
                    ((Throwable)((Object)f2)).printStackTrace();
                    PrintStream printStream = System.out;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("EXCEPTION : ");
                    stringBuilder.append(f2);
                    printStream.println(stringBuilder.toString());
                }
                if (bl3) {
                    this.a(this.af, l.a);
                } else {
                    this.c(this.af);
                    for (n2 = 0; n2 < n10; ++n2) {
                        f2 = (f)this.aw.get(n2);
                        if (f2.C[0] == f.a.c && f2.p() < f2.q()) {
                            l.a[2] = true;
                            break;
                        }
                        if (f2.C[1] != f.a.c || f2.r() >= f2.s()) continue;
                        l.a[2] = true;
                        break;
                    }
                }
                if (bl2 && n3 < 8 && l.a[2]) {
                    int n12 = 0;
                    int n13 = 0;
                    n11 = 0;
                    n2 = n3;
                    for (n3 = n12; n3 < n10; ++n3) {
                        f2 = (f)this.aw.get(n3);
                        n13 = Math.max(n13, f2.I + f2.p());
                        n11 = Math.max(n11, f2.J + f2.r());
                    }
                    n13 = Math.max(this.P, n13);
                    n3 = Math.max(this.Q, n11);
                    if (a3 == f.a.b && this.p() < n13) {
                        this.h(n13);
                        this.C[0] = f.a.b;
                        bl3 = true;
                        n9 = 1;
                    } else {
                        bl3 = false;
                    }
                    if (a2 == f.a.b && this.r() < n3) {
                        this.i(n3);
                        this.C[1] = f.a.b;
                        bl3 = true;
                        n9 = 1;
                    }
                } else {
                    n2 = n3;
                    bl3 = false;
                }
                n3 = Math.max(this.P, this.p());
                if (n3 > this.p()) {
                    this.h(n3);
                    this.C[0] = f.a.a;
                    bl3 = true;
                    n9 = 1;
                }
                if ((n3 = Math.max(this.Q, this.r())) > this.r()) {
                    this.i(n3);
                    this.C[1] = f.a.a;
                    bl3 = true;
                    n9 = 1;
                }
                boolean bl5 = bl3;
                n11 = n9;
                if (n9 == 0) {
                    bl4 = bl3;
                    n3 = n9;
                    if (this.C[0] == f.a.b) {
                        bl4 = bl3;
                        n3 = n9;
                        if (n6 > 0) {
                            bl4 = bl3;
                            n3 = n9;
                            if (this.p() > n6) {
                                this.aA = true;
                                this.C[0] = f.a.a;
                                this.h(n6);
                                bl4 = true;
                                n3 = 1;
                            }
                        }
                    }
                    bl5 = bl4;
                    n11 = n3;
                    if (this.C[1] == f.a.b) {
                        bl5 = bl4;
                        n11 = n3;
                        if (n7 > 0) {
                            bl5 = bl4;
                            n11 = n3;
                            if (this.r() > n7) {
                                this.aB = true;
                                this.C[1] = f.a.a;
                                this.i(n7);
                                bl3 = true;
                                n9 = 1;
                                continue;
                            }
                        }
                    }
                }
                bl3 = bl5;
                n9 = n11;
            }
        }
        this.aw = arrayList;
        if (this.D != null) {
            n2 = Math.max(this.P, this.p());
            n3 = Math.max(this.Q, this.r());
            this.ay.b(this);
            this.h(n2 + this.ag + this.ai);
            this.i(n3 + this.ah + this.aj);
        } else {
            this.I = n4;
            this.J = n5;
        }
        if (n9 != 0) {
            this.C[0] = a3;
            this.C[1] = a2;
        }
        this.a(this.af.g());
        if (this != this.T()) return;
        this.E();
    }

    public void O() {
        this.Q();
        this.b(this.az);
    }

    public void P() {
        n n2 = this.a(e.c.b).a();
        n n3 = this.a(e.c.c).a();
        n2.a(null, 0.0f);
        n3.a(null, 0.0f);
    }

    public void Q() {
        int n2 = this.aw.size();
        this.c();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((f)this.aw.get(i2)).c();
        }
    }

    public void R() {
        if (!this.q(8)) {
            this.b(this.az);
        }
        this.P();
    }

    public boolean S() {
        return false;
    }

    public void a(int n2) {
        this.az = n2;
    }

    void a(f f2, int n2) {
        if (n2 == 0) {
            this.d(f2);
            return;
        }
        if (n2 == 1) {
            this.e(f2);
        }
    }

    public void a(e e2, boolean[] arrbl) {
        arrbl[2] = false;
        this.c(e2);
        int n2 = this.aw.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            f f2 = (f)this.aw.get(i2);
            f2.c(e2);
            if (f2.C[0] == f.a.c && f2.p() < f2.q()) {
                arrbl[2] = true;
            }
            if (f2.C[1] != f.a.c || f2.r() >= f2.s()) continue;
            arrbl[2] = true;
        }
    }

    public void a(boolean bl2) {
        this.ax = bl2;
    }

    public int b() {
        return this.az;
    }

    @Override
    public void b(int n2) {
        super.b(n2);
        int n3 = this.aw.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            ((f)this.aw.get(i2)).b(n2);
        }
    }

    public boolean d(e e2) {
        this.a(e2);
        int n2 = this.aw.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            f f2 = (f)this.aw.get(i2);
            if (f2 instanceof g) {
                f.a a2 = f2.C[0];
                f.a a3 = f2.C[1];
                if (a2 == f.a.b) {
                    f2.a(f.a.a);
                }
                if (a3 == f.a.b) {
                    f2.b(f.a.a);
                }
                f2.a(e2);
                if (a2 == f.a.b) {
                    f2.a(a2);
                }
                if (a3 != f.a.b) continue;
                f2.b(a3);
                continue;
            }
            l.a(this, e2, f2);
            f2.a(e2);
        }
        if (this.ak > 0) {
            androidx.constraintlayout.b.a.c.a(this, e2, 0);
        }
        if (this.al > 0) {
            androidx.constraintlayout.b.a.c.a(this, e2, 1);
        }
        return true;
    }

    public void e(int n2, int n3) {
        if (this.C[0] != f.a.b && this.c != null) {
            this.c.a(n2);
        }
        if (this.C[1] != f.a.b && this.d != null) {
            this.d.a(n3);
        }
    }

    @Override
    public void g() {
        this.af.b();
        this.ag = 0;
        this.ai = 0;
        this.ah = 0;
        this.aj = 0;
        this.ao.clear();
        this.au = false;
        super.g();
    }

    public boolean q(int n2) {
        return (this.az & n2) == n2;
    }
}

