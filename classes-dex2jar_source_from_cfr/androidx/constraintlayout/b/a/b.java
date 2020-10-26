/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import androidx.constraintlayout.b.a.f;
import androidx.constraintlayout.b.a.g;
import androidx.constraintlayout.b.a.k;
import androidx.constraintlayout.b.a.n;
import androidx.constraintlayout.b.a.p;
import androidx.constraintlayout.b.e;
import androidx.constraintlayout.b.h;
import java.util.ArrayList;

public class b
extends k {
    private int ah = 0;
    private ArrayList<n> ai = new ArrayList(4);
    private boolean aj = true;

    public void a(int n2) {
        this.ah = n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(e e2) {
        block9 : {
            Object object;
            Object object2;
            block11 : {
                boolean bl2;
                block13 : {
                    block12 : {
                        block10 : {
                            int n2;
                            block8 : {
                                this.A[0] = this.s;
                                this.A[2] = this.t;
                                this.A[1] = this.u;
                                this.A[3] = this.v;
                                for (n2 = 0; n2 < this.A.length; ++n2) {
                                    this.A[n2].f = e2.a(this.A[n2]);
                                }
                                if (this.ah < 0 || this.ah >= 4) break block9;
                                object = this.A[this.ah];
                                for (n2 = 0; n2 < this.ag; ++n2) {
                                    object2 = this.af[n2];
                                    if (!this.aj && !((f)object2).a() || (this.ah != 0 && this.ah != 1 || ((f)object2).G() != f.a.c) && (this.ah != 2 && this.ah != 3 || ((f)object2).H() != f.a.c)) continue;
                                    bl2 = true;
                                    break block8;
                                }
                                bl2 = false;
                            }
                            if (this.ah != 0 && this.ah != 1 ? this.k().H() == f.a.b : this.k().G() == f.a.b) {
                                bl2 = false;
                            }
                            for (n2 = 0; n2 < this.ag; ++n2) {
                                h h2;
                                object2 = this.af[n2];
                                if (!this.aj && !((f)object2).a()) continue;
                                object2.A[this.ah].f = h2 = e2.a(((f)object2).A[this.ah]);
                                if (this.ah != 0 && this.ah != 2) {
                                    e2.a(((androidx.constraintlayout.b.a.e)object).f, h2, bl2);
                                    continue;
                                }
                                e2.b(((androidx.constraintlayout.b.a.e)object).f, h2, bl2);
                            }
                            if (this.ah != 0) break block10;
                            e2.c(this.u.f, this.s.f, 0, 6);
                            if (bl2) break block9;
                            object = this.s.f;
                            object2 = this.D.u;
                            break block11;
                        }
                        if (this.ah != 1) break block12;
                        e2.c(this.s.f, this.u.f, 0, 6);
                        if (bl2) break block9;
                        object = this.s.f;
                        object2 = this.D.s;
                        break block11;
                    }
                    if (this.ah != 2) break block13;
                    e2.c(this.v.f, this.t.f, 0, 6);
                    if (bl2) break block9;
                    object = this.t.f;
                    object2 = this.D.v;
                    break block11;
                }
                if (this.ah != 3) break block9;
                e2.c(this.t.f, this.v.f, 0, 6);
                if (bl2) break block9;
                object = this.t.f;
                object2 = this.D.t;
            }
            e2.c((h)object, ((androidx.constraintlayout.b.a.e)object2).f, 0, 5);
            return;
        }
    }

    public void a(boolean bl2) {
        this.aj = bl2;
    }

    @Override
    public boolean a() {
        return true;
    }

    @Override
    public void b(int n2) {
        Object object;
        if (this.D == null) {
            return;
        }
        if (!((g)this.D).q(2)) {
            return;
        }
        switch (this.ah) {
            default: {
                return;
            }
            case 3: {
                object = this.v;
                break;
            }
            case 2: {
                object = this.t;
                break;
            }
            case 1: {
                object = this.u;
                break;
            }
            case 0: {
                object = this.s;
            }
        }
        n n3 = ((androidx.constraintlayout.b.a.e)object).a();
        n3.b(5);
        if (this.ah != 0 && this.ah != 1) {
            this.s.a().a(null, 0.0f);
            object = this.u;
        } else {
            this.t.a().a(null, 0.0f);
            object = this.v;
        }
        ((androidx.constraintlayout.b.a.e)object).a().a(null, 0.0f);
        this.ai.clear();
        for (n2 = 0; n2 < this.ag; ++n2) {
            block17 : {
                object = this.af[n2];
                if (!this.aj && !((f)object).a()) continue;
                switch (this.ah) {
                    default: {
                        object = null;
                        break block17;
                    }
                    case 3: {
                        object = ((f)object).v;
                        break;
                    }
                    case 2: {
                        object = ((f)object).t;
                        break;
                    }
                    case 1: {
                        object = ((f)object).u;
                        break;
                    }
                    case 0: {
                        object = ((f)object).s;
                    }
                }
                object = ((androidx.constraintlayout.b.a.e)object).a();
            }
            if (object == null) continue;
            this.ai.add((n)object);
            ((p)object).a(n3);
        }
    }

    public boolean b() {
        return this.aj;
    }

    @Override
    public void c() {
        super.c();
        this.ai.clear();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void d() {
        block19 : {
            block18 : {
                var3_1 = this.ah;
                var1_2 = Float.MAX_VALUE;
                switch (var3_1) {
                    default: {
                        return;
                    }
                    case 3: {
                        var5_3 = this.v;
                        ** GOTO lbl14
                    }
                    case 2: {
                        var5_3 = this.t;
                        break block18;
                    }
                    case 1: {
                        var5_3 = this.u;
lbl14: // 2 sources:
                        var5_3 = var5_3.a();
                        var1_2 = 0.0f;
                        break block19;
                    }
                    case 0: 
                }
                var5_3 = this.s;
            }
            var5_3 = var5_3.a();
        }
        var4_4 = this.ai.size();
        var6_5 = null;
        for (var3_1 = 0; var3_1 < var4_4; ++var3_1) {
            block21 : {
                block22 : {
                    block20 : {
                        var7_7 = this.ai.get(var3_1);
                        if (var7_7.i != 1) {
                            return;
                        }
                        if (this.ah == 0 || this.ah == 2) break block20;
                        var2_6 = var1_2;
                        if (!(var7_7.f > var1_2)) break block21;
                        break block22;
                    }
                    var2_6 = var1_2;
                    if (!(var7_7.f < var1_2)) break block21;
                }
                var2_6 = var7_7.f;
                var6_5 = var7_7.e;
            }
            var1_2 = var2_6;
        }
        if (e.a() != null) {
            var7_7 = e.a();
            ++var7_7.z;
        }
        var5_3.e = var6_5;
        var5_3.f = var1_2;
        var5_3.f();
        switch (this.ah) {
            default: {
                return;
            }
            case 3: {
                var5_3 = this.t;
                ** break;
            }
            case 2: {
                var5_3 = this.v;
                ** break;
            }
            case 1: {
                var5_3 = this.s;
                ** break;
            }
            case 0: 
        }
        var5_3 = this.u;
lbl61: // 4 sources:
        var5_3.a().a(var6_5, var1_2);
    }
}

