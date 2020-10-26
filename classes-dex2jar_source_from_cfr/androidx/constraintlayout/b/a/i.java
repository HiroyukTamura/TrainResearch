/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import androidx.constraintlayout.b.a.e;
import androidx.constraintlayout.b.a.f;
import androidx.constraintlayout.b.a.g;
import androidx.constraintlayout.b.a.m;
import androidx.constraintlayout.b.a.n;
import androidx.constraintlayout.b.b;
import androidx.constraintlayout.b.e;
import androidx.constraintlayout.b.h;
import java.util.ArrayList;

public class i
extends f {
    protected float af = -1.0f;
    protected int ag = -1;
    protected int ah = -1;
    private androidx.constraintlayout.b.a.e ai = this.t;
    private int aj = 0;
    private boolean ak = false;
    private int al = 0;
    private m am = new m();
    private int an = 8;

    public i() {
        this.B.clear();
        this.B.add(this.ai);
        int n2 = this.A.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.A[i2] = this.ai;
        }
    }

    @Override
    public ArrayList<androidx.constraintlayout.b.a.e> D() {
        return this.B;
    }

    @Override
    public androidx.constraintlayout.b.a.e a(e.c c2) {
        switch (1.a[c2.ordinal()]) {
            default: {
                break;
            }
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return null;
            }
            case 3: 
            case 4: {
                if (this.aj != 0) break;
                return this.ai;
            }
            case 1: 
            case 2: {
                if (this.aj != 1) break;
                return this.ai;
            }
        }
        throw new AssertionError((Object)c2.name());
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(int n2) {
        if (this.aj == n2) {
            return;
        }
        this.aj = n2;
        this.B.clear();
        androidx.constraintlayout.b.a.e e2 = this.aj == 1 ? this.s : this.t;
        this.ai = e2;
        this.B.add(this.ai);
        int n3 = this.A.length;
        n2 = 0;
        while (n2 < n3) {
            this.A[n2] = this.ai;
            ++n2;
        }
        return;
    }

    @Override
    public void a(e e2) {
        Object object = (g)this.k();
        if (object == null) {
            return;
        }
        androidx.constraintlayout.b.a.e e3 = ((f)object).a(e.c.b);
        Object object2 = ((f)object).a(e.c.d);
        boolean bl2 = this.D != null && this.D.C[0] == f.a.b;
        if (this.aj == 0) {
            e3 = ((f)object).a(e.c.c);
            object2 = ((f)object).a(e.c.e);
            bl2 = this.D != null && this.D.C[1] == f.a.b;
        }
        if (this.ag != -1) {
            object = e2.a(this.ai);
            e2.c((h)object, e2.a(e3), this.ag, 6);
            if (bl2) {
                e2.a(e2.a(object2), (h)object, 0, 5);
                return;
            }
        } else if (this.ah != -1) {
            object = e2.a(this.ai);
            object2 = e2.a(object2);
            e2.c((h)object, (h)object2, -this.ah, 6);
            if (bl2) {
                e2.a((h)object, e2.a(e3), 0, 5);
                e2.a((h)object2, (h)object, 0, 5);
                return;
            }
        } else if (this.af != -1.0f) {
            e2.a(e.a(e2, e2.a(this.ai), e2.a(e3), e2.a(object2), this.af, this.ak));
        }
    }

    @Override
    public boolean a() {
        return true;
    }

    public int b() {
        return this.aj;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void b(int n2) {
        block12 : {
            Object object;
            n n3;
            block13 : {
                block16 : {
                    n n4;
                    block15 : {
                        block11 : {
                            block14 : {
                                block9 : {
                                    block7 : {
                                        block10 : {
                                            block8 : {
                                                object = this.k();
                                                if (object == null) {
                                                    return;
                                                }
                                                if (this.b() != 1) break block7;
                                                this.t.a().a(1, ((f)object).t.a(), 0);
                                                this.v.a().a(1, ((f)object).t.a(), 0);
                                                if (this.ag == -1) break block8;
                                                this.s.a().a(1, ((f)object).s.a(), this.ag);
                                                n4 = this.u.a();
                                                object = ((f)object).s;
                                                break block9;
                                            }
                                            if (this.ah == -1) break block10;
                                            this.s.a().a(1, ((f)object).u.a(), -this.ah);
                                            n4 = this.u.a();
                                            object = ((f)object).u;
                                            break block11;
                                        }
                                        if (this.af == -1.0f || ((f)object).G() != f.a.a) break block12;
                                        n2 = (int)((float)((f)object).E * this.af);
                                        this.s.a().a(1, ((f)object).s.a(), n2);
                                        n3 = this.u.a();
                                        object = ((f)object).s;
                                        break block13;
                                    }
                                    this.s.a().a(1, ((f)object).s.a(), 0);
                                    this.u.a().a(1, ((f)object).s.a(), 0);
                                    if (this.ag == -1) break block14;
                                    this.t.a().a(1, ((f)object).t.a(), this.ag);
                                    n4 = this.v.a();
                                    object = ((f)object).t;
                                }
                                object = ((androidx.constraintlayout.b.a.e)object).a();
                                n2 = this.ag;
                                break block15;
                            }
                            if (this.ah == -1) break block16;
                            this.t.a().a(1, ((f)object).v.a(), -this.ah);
                            n4 = this.v.a();
                            object = ((f)object).v;
                        }
                        object = ((androidx.constraintlayout.b.a.e)object).a();
                        n2 = -this.ah;
                    }
                    n4.a(1, (n)object, n2);
                    return;
                }
                if (this.af == -1.0f || ((f)object).H() != f.a.a) break block12;
                n2 = (int)((float)((f)object).F * this.af);
                this.t.a().a(1, ((f)object).t.a(), n2);
                n3 = this.v.a();
                object = ((f)object).t;
            }
            n3.a(1, ((androidx.constraintlayout.b.a.e)object).a(), n2);
            return;
        }
    }

    @Override
    public void c(e e2) {
        if (this.k() == null) {
            return;
        }
        int n2 = e2.b(this.ai);
        if (this.aj == 1) {
            this.f(n2);
            this.g(0);
            this.i(this.k().r());
            this.h(0);
            return;
        }
        this.f(0);
        this.g(n2);
        this.h(this.k().p());
        this.i(0);
    }

    public void e(float f2) {
        if (f2 > -1.0f) {
            this.af = f2;
            this.ag = -1;
            this.ah = -1;
        }
    }

    public void q(int n2) {
        if (n2 > -1) {
            this.af = -1.0f;
            this.ag = n2;
            this.ah = -1;
        }
    }

    public void r(int n2) {
        if (n2 > -1) {
            this.af = -1.0f;
            this.ag = -1;
            this.ah = n2;
        }
    }

}

