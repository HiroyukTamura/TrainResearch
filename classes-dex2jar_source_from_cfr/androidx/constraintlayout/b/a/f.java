/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import androidx.constraintlayout.b.a.e;
import androidx.constraintlayout.b.a.g;
import androidx.constraintlayout.b.a.l;
import androidx.constraintlayout.b.a.n;
import androidx.constraintlayout.b.a.o;
import androidx.constraintlayout.b.b;
import androidx.constraintlayout.b.c;
import androidx.constraintlayout.b.e;
import androidx.constraintlayout.b.h;
import java.util.ArrayList;

public class f {
    public static float R = 0.5f;
    protected androidx.constraintlayout.b.a.e[] A = new androidx.constraintlayout.b.a.e[]{this.s, this.u, this.t, this.v, this.w, this.z};
    protected ArrayList<androidx.constraintlayout.b.a.e> B = new ArrayList();
    protected a[] C = new a[]{a.a, a.a};
    f D = null;
    int E = 0;
    int F = 0;
    protected float G = 0.0f;
    protected int H = -1;
    protected int I = 0;
    protected int J = 0;
    int K = 0;
    int L = 0;
    protected int M = 0;
    protected int N = 0;
    int O = 0;
    protected int P;
    protected int Q;
    float S = R;
    float T = R;
    boolean U;
    boolean V;
    int W = 0;
    int X = 0;
    boolean Y;
    boolean Z;
    public int a = -1;
    float[] aa = new float[]{-1.0f, -1.0f};
    protected f[] ab = new f[]{null, null};
    protected f[] ac = new f[]{null, null};
    f ad = null;
    f ae = null;
    private int[] af = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float ag = 0.0f;
    private int ah = 0;
    private int ai = 0;
    private int aj = 0;
    private int ak = 0;
    private int al;
    private int am;
    private Object an;
    private int ao = 0;
    private int ap = 0;
    private String aq = null;
    private String ar = null;
    public int b = -1;
    o c;
    o d;
    int e = 0;
    int f = 0;
    int[] g = new int[2];
    int h = 0;
    int i = 0;
    float j = 1.0f;
    int k = 0;
    int l = 0;
    float m = 1.0f;
    boolean n;
    boolean o;
    int p = -1;
    float q = 1.0f;
    androidx.constraintlayout.b.a.h r = null;
    androidx.constraintlayout.b.a.e s = new androidx.constraintlayout.b.a.e(this, e.c.b);
    androidx.constraintlayout.b.a.e t = new androidx.constraintlayout.b.a.e(this, e.c.c);
    androidx.constraintlayout.b.a.e u = new androidx.constraintlayout.b.a.e(this, e.c.d);
    androidx.constraintlayout.b.a.e v = new androidx.constraintlayout.b.a.e(this, e.c.e);
    androidx.constraintlayout.b.a.e w = new androidx.constraintlayout.b.a.e(this, e.c.f);
    androidx.constraintlayout.b.a.e x = new androidx.constraintlayout.b.a.e(this, e.c.h);
    androidx.constraintlayout.b.a.e y = new androidx.constraintlayout.b.a.e(this, e.c.i);
    androidx.constraintlayout.b.a.e z = new androidx.constraintlayout.b.a.e(this, e.c.g);

    public f() {
        this.b();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(e var1_1, boolean var2_2, h var3_3, h var4_4, a var5_5, boolean var6_6, androidx.constraintlayout.b.a.e var7_7, androidx.constraintlayout.b.a.e var8_8, int var9_9, int var10_10, int var11_11, int var12_12, float var13_13, boolean var14_14, boolean var15_15, int var16_16, int var17_17, int var18_18, float var19_19, boolean var20_20) {
        block46 : {
            block48 : {
                block54 : {
                    block58 : {
                        block52 : {
                            block57 : {
                                block56 : {
                                    block55 : {
                                        block53 : {
                                            block51 : {
                                                block50 : {
                                                    block49 : {
                                                        block47 : {
                                                            block44 : {
                                                                block45 : {
                                                                    block43 : {
                                                                        var30_26 = var1_1.a(var7_12);
                                                                        var27_27 = var1_1.a(var8_13);
                                                                        var31_28 = var1_1.a(var7_12.g());
                                                                        var28_29 = var1_1.a(var8_13.g());
                                                                        if (var1_1.c && var7_12.a().i == 1 && var8_13.a().i == 1) {
                                                                            if (e.a() != null) {
                                                                                var3_3 = e.a();
                                                                                ++var3_3.s;
                                                                            }
                                                                            var7_12.a().a(var1_1);
                                                                            var8_13.a().a(var1_1);
                                                                            if (var15_20 != false) return;
                                                                            if (var2_2 == false) return;
                                                                            var1_1.a(var4_4, var27_27, 0, 6);
                                                                            return;
                                                                        }
                                                                        if (e.a() != null) {
                                                                            var29_30 = e.a();
                                                                            ++var29_30.B;
                                                                        }
                                                                        var25_31 = var7_12.j();
                                                                        var24_32 = var8_13.j();
                                                                        var26_33 = this.z.j();
                                                                        var22_34 = var25_31 != false ? 1 : 0;
                                                                        var21_35 = var22_34;
                                                                        if (var24_32) {
                                                                            var21_35 = var22_34 + 1;
                                                                        }
                                                                        var22_34 = var21_35;
                                                                        if (var26_33) {
                                                                            var22_34 = var21_35 + 1;
                                                                        }
                                                                        var21_35 = var14_19 != false ? 3 : var16_21;
                                                                        switch (1.b[var5_5.ordinal()]) {
                                                                            case 4: {
                                                                                if (var21_35 != 4) break;
                                                                            }
                                                                            default: {
                                                                                var16_21 = 0;
                                                                                ** break;
                                                                            }
                                                                        }
                                                                        var16_21 = 1;
lbl36: // 2 sources:
                                                                        if (this.ap == 8) {
                                                                            var10_15 = 0;
                                                                            var16_21 = 0;
                                                                        }
                                                                        if (var20_25 != false) {
                                                                            if (!(var25_31 || var24_32 || var26_33)) {
                                                                                var1_1.a(var30_26, var9_14);
                                                                            } else if (var25_31 && !var24_32) {
                                                                                var1_1.c(var30_26, var31_28, var7_12.e(), 6);
                                                                            }
                                                                        }
                                                                        if (var16_21 != 0) break block43;
                                                                        if (var6_11 != false) {
                                                                            var1_1.c(var27_27, var30_26, 0, 3);
                                                                            if (var11_16 > 0) {
                                                                                var1_1.a(var27_27, var30_26, var11_16, 6);
                                                                            }
                                                                            if (var12_17 < Integer.MAX_VALUE) {
                                                                                var1_1.b(var27_27, var30_26, var12_17, 6);
                                                                            }
                                                                        } else {
                                                                            var1_1.c(var27_27, var30_26, var10_15, 6);
                                                                        }
                                                                        var9_14 = var17_22;
                                                                        var17_22 = var18_23;
                                                                        var18_23 = var9_14;
                                                                        break block44;
                                                                    }
                                                                    var9_14 = var17_22 == -2 ? var10_15 : var17_22;
                                                                    var12_17 = var18_23 == -2 ? var10_15 : var18_23;
                                                                    if (var9_14 > 0) {
                                                                        var1_1.a(var27_27, var30_26, var9_14, 6);
                                                                        var10_15 = Math.max(var10_15, var9_14);
                                                                    }
                                                                    var23_36 = var10_15;
                                                                    if (var12_17 > 0) {
                                                                        if (var2_2) {
                                                                            var1_1.b(var27_27, var30_26, var12_17, 1);
                                                                        } else {
                                                                            var1_1.b(var27_27, var30_26, var12_17, 6);
                                                                        }
                                                                        var23_36 = Math.min(var10_15, var12_17);
                                                                    }
                                                                    if (var21_35 != 1) break block45;
                                                                    var10_15 = var2_2 != false ? 6 : (var15_20 != false ? 4 : 1);
                                                                    var1_1.c(var27_27, var30_26, var23_36, var10_15);
                                                                    ** GOTO lbl-1000
                                                                }
                                                                if (var21_35 == 2) {
                                                                    if (var7_12.d() != e.c.c && var7_12.d() != e.c.e) {
                                                                        var5_6 = var1_1.a(this.D.a(e.c.b));
                                                                        var29_30 = var1_1.a(this.D.a(e.c.d));
                                                                    } else {
                                                                        var5_7 = var1_1.a(this.D.a(e.c.c));
                                                                        var29_30 = var1_1.a(this.D.a(e.c.e));
                                                                    }
                                                                    var1_1.a(var1_1.c().a(var27_27, var30_26, (h)var29_30, (h)var5_8, (float)var19_24));
                                                                    var10_15 = 0;
                                                                } else lbl-1000: // 2 sources:
                                                                {
                                                                    var10_15 = var16_21;
                                                                }
                                                                var17_22 = var12_17;
                                                                var18_23 = var9_14;
                                                                var16_21 = var10_15;
                                                                if (var10_15 != 0) {
                                                                    var17_22 = var12_17;
                                                                    var18_23 = var9_14;
                                                                    var16_21 = var10_15;
                                                                    if (var22_34 != 2) {
                                                                        var17_22 = var12_17;
                                                                        var18_23 = var9_14;
                                                                        var16_21 = var10_15;
                                                                        if (var14_19 == false) {
                                                                            var10_15 = var16_21 = Math.max(var9_14, var23_36);
                                                                            if (var12_17 > 0) {
                                                                                var10_15 = Math.min(var12_17, var16_21);
                                                                            }
                                                                            var1_1.c(var27_27, var30_26, var10_15, 6);
                                                                            var16_21 = 0;
                                                                            var18_23 = var9_14;
                                                                            var17_22 = var12_17;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            var5_10 = var31_28;
                                                            if (var20_25 == false || var15_20 != false) break block46;
                                                            var12_17 = 5;
                                                            if (var25_31 || var24_32 || var26_33) break block47;
                                                            if (!var2_2) break block48;
                                                            break block49;
                                                        }
                                                        var9_14 = 4;
                                                        if (!var25_31 || var24_32) break block50;
                                                        if (!var2_2) break block48;
                                                    }
                                                    var1_1.a(var4_4, var27_27, 0, 5);
                                                    break block48;
                                                }
                                                if (var25_31 || !var24_32) break block51;
                                                var1_1.c(var27_27, var28_29, -var8_13.e(), 6);
                                                if (var2_2) {
                                                    var1_1.a(var30_26, (h)var3_3, 0, 5);
                                                }
                                                break block48;
                                            }
                                            if (!var25_31 || !var24_32) break block48;
                                            if (var16_21 == 0) break block52;
                                            if (var2_2 && var11_16 == 0) {
                                                var1_1.a(var27_27, var30_26, 0, 6);
                                            }
                                            if (var21_35 != 0) break block53;
                                            if (var17_22 <= 0 && var18_23 <= 0) {
                                                var9_14 = 0;
                                                var10_15 = 6;
                                            } else {
                                                var11_16 = 1;
                                                var10_15 = var9_14;
                                                var9_14 = var11_16;
                                            }
                                            var1_1.c(var30_26, var5_10, var7_12.e(), var10_15);
                                            var1_1.c(var27_27, var28_29, -var8_13.e(), var10_15);
                                            var10_15 = var17_22 <= 0 && var18_23 <= 0 ? 0 : 1;
                                            var11_16 = var9_14;
                                            var9_14 = var10_15;
                                            var10_15 = var11_16;
                                            break block54;
                                        }
                                        var11_16 = 1;
                                        if (var21_35 != 1) break block55;
                                        var9_14 = 6;
                                        break block56;
                                    }
                                    if (var21_35 != 3) break block57;
                                    if (var14_19 == false) {
                                        var10_15 = var9_14;
                                        if (this.p != -1) {
                                            var10_15 = var9_14;
                                            if (var17_22 <= 0) {
                                                var10_15 = 6;
                                            }
                                        }
                                    } else {
                                        var10_15 = var9_14;
                                    }
                                    var1_1.c(var30_26, var5_10, var7_12.e(), var10_15);
                                    var1_1.c(var27_27, var28_29, -var8_13.e(), var10_15);
                                    var9_14 = var12_17;
                                }
                                var10_15 = 1;
                                var12_17 = var9_14;
                                var9_14 = var11_16;
                                break block54;
                            }
                            var9_14 = 0;
                            break block58;
                        }
                        var9_14 = var10_15 = 1;
                        if (var2_2) {
                            var1_1.a(var30_26, var5_10, var7_12.e(), 5);
                            var1_1.b(var27_27, var28_29, -var8_13.e(), 5);
                            var9_14 = var10_15;
                        }
                    }
                    var10_15 = 0;
                }
                if (var9_14 != 0) {
                    var1_1.a(var30_26, var5_10, var7_12.e(), (float)var13_18, var28_29, var27_27, var8_13.e(), var12_17);
                }
                if (var10_15 != 0) {
                    var1_1.a(var30_26, var5_10, var7_12.e(), 6);
                    var1_1.b(var27_27, var28_29, -var8_13.e(), 6);
                }
                if (var2_2) {
                    var1_1.a(var30_26, (h)var3_3, 0, 6);
                }
            }
            if (var2_2 == false) return;
            var1_1.a(var4_4, var27_27, 0, 6);
            return;
        }
        if (var22_34 >= 2) return;
        if (var2_2 == false) return;
        var1_1.a(var30_26, (h)var3_3, 0, 6);
        var1_1.a(var4_4, var27_27, 0, 6);
    }

    private boolean a(int n2) {
        if (this.A[n2 *= 2].c != null && this.A[n2].c.c != this.A[n2]) {
            androidx.constraintlayout.b.a.e[] arre = this.A;
            if (arre[++n2].c != null && this.A[n2].c.c == this.A[n2]) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        this.B.add(this.s);
        this.B.add(this.t);
        this.B.add(this.u);
        this.B.add(this.v);
        this.B.add(this.x);
        this.B.add(this.y);
        this.B.add(this.z);
        this.B.add(this.w);
    }

    public boolean A() {
        return this.O > 0;
    }

    public int B() {
        return this.O;
    }

    public Object C() {
        return this.an;
    }

    public ArrayList<androidx.constraintlayout.b.a.e> D() {
        return this.B;
    }

    public void E() {
        int n2 = this.I;
        int n3 = this.J;
        int n4 = this.I;
        int n5 = this.E;
        int n6 = this.J;
        int n7 = this.F;
        this.ah = n2;
        this.ai = n3;
        this.aj = n4 + n5 - n2;
        this.ak = n6 + n7 - n3;
    }

    public void F() {
        f f2 = this.k();
        if (f2 != null && f2 instanceof g && ((g)this.k()).S()) {
            return;
        }
        int n2 = this.B.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.B.get(i2).i();
        }
    }

    public a G() {
        return this.C[0];
    }

    public a H() {
        return this.C[1];
    }

    public boolean I() {
        return this.s.c != null && this.s.c.c == this.s || this.u.c != null && this.u.c.c == this.u;
    }

    public boolean J() {
        return this.t.c != null && this.t.c.c == this.t || this.v.c != null && this.v.c.c == this.v;
    }

    public androidx.constraintlayout.b.a.e a(e.c c2) {
        switch (1.a[c2.ordinal()]) {
            default: {
                throw new AssertionError((Object)c2.name());
            }
            case 9: {
                return null;
            }
            case 8: {
                return this.y;
            }
            case 7: {
                return this.x;
            }
            case 6: {
                return this.z;
            }
            case 5: {
                return this.w;
            }
            case 4: {
                return this.v;
            }
            case 3: {
                return this.u;
            }
            case 2: {
                return this.t;
            }
            case 1: 
        }
        return this.s;
    }

    public void a(float f2) {
        this.S = f2;
    }

    public void a(int n2, int n3) {
        this.I = n2;
        this.J = n3;
    }

    public void a(int n2, int n3, int n4) {
        if (n4 == 0) {
            this.c(n2, n3);
            return;
        }
        if (n4 == 1) {
            this.d(n2, n3);
        }
    }

    public void a(int n2, int n3, int n4, float f2) {
        this.e = n2;
        this.h = n3;
        this.i = n4;
        this.j = f2;
        if (f2 < 1.0f && this.e == 0) {
            this.e = 2;
        }
    }

    public void a(int n2, int n3, int n4, int n5) {
        int n6 = n4 - n2;
        n4 = n5 - n3;
        this.I = n2;
        this.J = n3;
        if (this.ap == 8) {
            this.E = 0;
            this.F = 0;
            return;
        }
        n2 = n6;
        if (this.C[0] == a.a) {
            n2 = n6;
            if (n6 < this.E) {
                n2 = this.E;
            }
        }
        n3 = n4;
        if (this.C[1] == a.a) {
            n3 = n4;
            if (n4 < this.F) {
                n3 = this.F;
            }
        }
        this.E = n2;
        this.F = n3;
        if (this.F < this.Q) {
            this.F = this.Q;
        }
        if (this.E < this.P) {
            this.E = this.P;
        }
    }

    public void a(e.c c2, f f2, e.c c3, int n2, int n3) {
        this.a(c2).a(f2.a(c3), n2, n3, e.b.b, 0, true);
    }

    public void a(a a2) {
        this.C[0] = a2;
        if (a2 == a.b) {
            this.h(this.al);
        }
    }

    public void a(f f2, float f3, int n2) {
        this.a(e.c.g, f2, e.c.g, n2, 0);
        this.ag = f3;
    }

    public void a(c c2) {
        this.s.a(c2);
        this.t.a(c2);
        this.u.a(c2);
        this.v.a(c2);
        this.w.a(c2);
        this.z.a(c2);
        this.x.a(c2);
        this.y.a(c2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void a(e var1_1) {
        block32 : {
            block31 : {
                block27 : {
                    block22 : {
                        block30 : {
                            block28 : {
                                block24 : {
                                    block29 : {
                                        block25 : {
                                            block26 : {
                                                block23 : {
                                                    var20_2 = var1_1.a(this.s);
                                                    var22_3 = var1_1.a(this.u);
                                                    var23_4 = var1_1.a(this.t);
                                                    var21_5 = var1_1.a(this.v);
                                                    var17_6 = var1_1.a(this.w);
                                                    if (this.D != null) {
                                                        var10_7 = this.D != null && this.D.C[0] == a.b;
                                                        var11_8 = this.D != null && this.D.C[1] == a.b;
                                                        if (this.a(0)) {
                                                            ((g)this.D).a(this, 0);
                                                            var12_9 = true;
                                                        } else {
                                                            var12_9 = this.I();
                                                        }
                                                        if (this.a(1)) {
                                                            ((g)this.D).a(this, 1);
                                                            var13_10 = true;
                                                        } else {
                                                            var13_10 = this.J();
                                                        }
                                                        if (var10_7 && this.ap != 8 && this.s.c == null && this.u.c == null) {
                                                            var1_1.a(var1_1.a(this.D.u), (h)var22_3, 0, 1);
                                                        }
                                                        if (var11_8 && this.ap != 8 && this.t.c == null && this.v.c == null && this.w == null) {
                                                            var1_1.a(var1_1.a(this.D.v), (h)var21_5, 0, 1);
                                                        }
                                                        var14_11 = var12_9;
                                                        var15_12 = var13_10;
                                                        var12_9 = var10_7;
                                                        var10_7 = var11_8;
                                                        var13_10 = var14_11;
                                                        var11_8 = var15_12;
                                                    } else {
                                                        var12_9 = false;
                                                        var10_7 = false;
                                                        var13_10 = false;
                                                        var11_8 = false;
                                                    }
                                                    var3_14 = var4_13 = this.E;
                                                    if (var4_13 < this.P) {
                                                        var3_14 = this.P;
                                                    }
                                                    var4_13 = var5_15 = this.F;
                                                    if (var5_15 < this.Q) {
                                                        var4_13 = this.Q;
                                                    }
                                                    var14_11 = this.C[0] != a.c;
                                                    var15_12 = this.C[1] != a.c;
                                                    this.p = this.H;
                                                    this.q = this.G;
                                                    var6_16 = this.e;
                                                    var7_17 = this.f;
                                                    if (!(this.G > 0.0f) || this.ap == 8) break block22;
                                                    var5_15 = var6_16;
                                                    if (this.C[0] == a.c) {
                                                        var5_15 = var6_16;
                                                        if (var6_16 == 0) {
                                                            var5_15 = 3;
                                                        }
                                                    }
                                                    var6_16 = var7_17;
                                                    if (this.C[1] == a.c) {
                                                        var6_16 = var7_17;
                                                        if (var7_17 == 0) {
                                                            var6_16 = 3;
                                                        }
                                                    }
                                                    if (this.C[0] != a.c || this.C[1] != a.c || var5_15 != 3 || var6_16 != 3) break block23;
                                                    this.a(var12_9, var10_7, var14_11, var15_12);
                                                    break block24;
                                                }
                                                if (this.C[0] != a.c || var5_15 != 3) break block25;
                                                this.p = 0;
                                                var3_14 = (int)(this.q * (float)this.F);
                                                if (this.C[1] == a.c) break block26;
                                                var5_15 = var3_14;
                                                var7_17 = var6_16;
                                                var6_16 = var4_13;
                                                var3_14 = 4;
                                                var4_13 = var7_17;
                                                break block27;
                                            }
                                            var7_17 = var3_14;
                                            break block28;
                                        }
                                        if (this.C[1] != a.c || var6_16 != 3) break block24;
                                        this.p = 1;
                                        if (this.H == -1) {
                                            this.q = 1.0f / this.q;
                                        }
                                        var7_17 = (int)(this.q * (float)this.E);
                                        if (this.C[0] == a.c) break block29;
                                        var6_16 = var7_17;
                                        var7_17 = var3_14;
                                        var3_14 = var5_15;
                                        var4_13 = 4;
                                        var5_15 = var7_17;
                                        break block27;
                                    }
                                    var4_13 = var3_14;
                                    var3_14 = var7_17;
                                    break block30;
                                }
                                var7_17 = var3_14;
                            }
                            var3_14 = var4_13;
                            var4_13 = var7_17;
                        }
                        var7_17 = 1;
                        var8_18 = var4_13;
                        var9_19 = var3_14;
                        break block31;
                    }
                    var8_18 = var6_16;
                    var6_16 = var4_13;
                    var5_15 = var3_14;
                    var4_13 = var7_17;
                    var3_14 = var8_18;
                }
                var7_17 = 0;
                var9_19 = var6_16;
                var8_18 = var5_15;
                var6_16 = var4_13;
                var5_15 = var3_14;
            }
            this.g[0] = var5_15;
            this.g[1] = var6_16;
            var14_11 = var7_17 != 0 && (this.p == 0 || this.p == -1);
            var15_12 = this.C[0] == a.b && this instanceof g != false;
            var16_20 = this.z.j() ^ true;
            if (this.a != 2) {
                var18_21 = this.D != null ? var1_1.a(this.D.u) : null;
                var19_22 = this.D != null ? var1_1.a(this.D.s) : null;
                this.a(var1_1, var12_9, var19_22, (h)var18_21, this.C[0], var15_12, this.s, this.u, this.I, var8_18, this.P, this.af[0], this.S, var14_11, var13_10, var5_15, this.h, this.i, this.j, var16_20);
            }
            var19_22 = var23_4;
            var23_4 = var17_6;
            var17_6 = var22_3;
            var18_21 = var21_5;
            if (this.b == 2) {
                return;
            }
            var12_9 = this.C[1] == a.b && this instanceof g != false;
            var13_10 = var7_17 != 0 && (this.p == 1 || this.p == -1);
            if (this.O <= 0) ** GOTO lbl-1000
            if (this.w.a().i != 1) break block32;
            this.w.a().a(var1_1);
            ** GOTO lbl-1000
        }
        var21_5 = var1_1;
        var21_5.c(var23_4, var19_22, this.B(), 6);
        if (this.w.c != null) {
            var21_5.c(var23_4, var21_5.a(this.w.c), 0, 6);
            var14_11 = false;
        } else lbl-1000: // 3 sources:
        {
            var14_11 = var16_20;
        }
        var22_3 = var1_1;
        var21_5 = this.D != null ? var22_3.a(this.D.v) : null;
        var22_3 = this.D != null ? var22_3.a(this.D.t) : null;
        this.a(var1_1, var10_7, (h)var22_3, (h)var21_5, this.C[1], var12_9, this.t, this.v, this.J, var9_19, this.Q, this.af[1], this.T, var13_10, var11_8, var6_16, this.k, this.l, this.m, var14_11);
        if (var7_17 != 0) {
            var21_5 = this;
            if (var21_5.p == 1) {
                var2_23 = var21_5.q;
            } else {
                var2_23 = var21_5.q;
                var21_5 = var18_21;
                var22_3 = var19_22;
                var18_21 = var17_6;
                var19_22 = var20_2;
                var17_6 = var21_5;
                var20_2 = var22_3;
            }
            var1_1.a((h)var18_21, var19_22, (h)var17_6, (h)var20_2, var2_23, 6);
        }
        var17_6 = this;
        if (var17_6.z.j() == false) return;
        var1_1.a((f)var17_6, var17_6.z.g().c(), (float)Math.toRadians(var17_6.ag + 90.0f), var17_6.z.e());
    }

    public void a(Object object) {
        this.an = object;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void a(String var1_1) {
        block10 : {
            block13 : {
                block11 : {
                    block12 : {
                        if (var1_1 == null || var1_1.length() == 0) break block11;
                        var6_3 = -1;
                        var8_4 = var1_1.length();
                        var9_5 = var1_1.indexOf(44);
                        var7_6 = 0;
                        var4_7 = var6_3;
                        var5_8 = var7_6;
                        if (var9_5 > 0) {
                            var4_7 = var6_3;
                            var5_8 = var7_6;
                            if (var9_5 < var8_4 - 1) {
                                var10_9 = var1_1.substring(0, var9_5);
                                if (var10_9.equalsIgnoreCase("W")) {
                                    var4_7 = 0;
                                } else {
                                    var4_7 = var6_3;
                                    if (var10_9.equalsIgnoreCase("H")) {
                                        var4_7 = 1;
                                    }
                                }
                                var5_8 = var9_5 + 1;
                            }
                        }
                        if ((var6_3 = var1_1.indexOf(58)) < 0 || var6_3 >= var8_4 - 1) break block12;
                        var10_9 = var1_1.substring(var5_8, var6_3);
                        var1_1 = var1_1.substring(var6_3 + 1);
                        if (var10_9.length() <= 0 || var1_1.length() <= 0) break block13;
                        try {
                            var2_10 = Float.parseFloat(var10_9);
                            var3_11 = Float.parseFloat(var1_1);
                        }
                        catch (NumberFormatException var1_2) {}
                        if (!(var2_10 > 0.0f) || !(var3_11 > 0.0f)) break block13;
                        if (var4_7 != 1) ** GOTO lbl33
                        var2_10 = Math.abs(var3_11 / var2_10);
                        break block10;
lbl33: // 1 sources:
                        var2_10 = Math.abs(var2_10 / var3_11);
                        break block10;
                    }
                    if ((var1_1 = var1_1.substring(var5_8)).length() > 0) {
                        var2_10 = Float.parseFloat(var1_1);
                        break block10;
                    }
                    break block13;
                }
                this.G = 0.0f;
                return;
            }
            var2_10 = 0.0f;
        }
        if (!(var2_10 > 0.0f)) return;
        this.G = var2_10;
        this.H = var4_7;
    }

    public void a(boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        if (this.p == -1) {
            if (bl4 && !bl5) {
                this.p = 0;
            } else if (!bl4 && bl5) {
                this.p = 1;
                if (this.H == -1) {
                    this.q = 1.0f / this.q;
                }
            }
        }
        if (!(this.p != 0 || this.t.j() && this.v.j())) {
            this.p = 1;
        } else if (!(this.p != 1 || this.s.j() && this.u.j())) {
            this.p = 0;
        }
        if (!(this.p != -1 || this.t.j() && this.v.j() && this.s.j() && this.u.j())) {
            if (this.t.j() && this.v.j()) {
                this.p = 0;
            } else if (this.s.j() && this.u.j()) {
                this.q = 1.0f / this.q;
                this.p = 1;
            }
        }
        if (this.p == -1) {
            if (bl2 && !bl3) {
                this.p = 0;
            } else if (!bl2 && bl3) {
                this.q = 1.0f / this.q;
                this.p = 1;
            }
        }
        if (this.p == -1) {
            if (this.h > 0 && this.k == 0) {
                this.p = 0;
            } else if (this.h == 0 && this.k > 0) {
                this.q = 1.0f / this.q;
                this.p = 1;
            }
        }
        if (this.p == -1 && bl2 && bl3) {
            this.q = 1.0f / this.q;
            this.p = 1;
        }
    }

    public boolean a() {
        return this.ap != 8;
    }

    public void a_(f f2) {
        this.D = f2;
    }

    public void b(float f2) {
        this.T = f2;
    }

    public void b(int n2) {
        l.a(n2, this);
    }

    public void b(int n2, int n3) {
        this.M = n2;
        this.N = n3;
    }

    public void b(int n2, int n3, int n4, float f2) {
        this.f = n2;
        this.k = n3;
        this.l = n4;
        this.m = f2;
        if (f2 < 1.0f && this.f == 0) {
            this.f = 2;
        }
    }

    public void b(a a2) {
        this.C[1] = a2;
        if (a2 == a.b) {
            this.i(this.am);
        }
    }

    public void b(e e2) {
        e2.a(this.s);
        e2.a(this.t);
        e2.a(this.u);
        e2.a(this.v);
        if (this.O > 0) {
            e2.a(this.w);
        }
    }

    public void b(boolean bl2) {
        this.n = bl2;
    }

    public void c() {
        for (int i2 = 0; i2 < 6; ++i2) {
            this.A[i2].a().b();
        }
    }

    public void c(float f2) {
        this.aa[0] = f2;
    }

    public void c(int n2) {
        this.af[0] = n2;
    }

    public void c(int n2, int n3) {
        this.I = n2;
        this.E = n3 - n2;
        if (this.E < this.P) {
            this.E = this.P;
        }
    }

    public void c(e e2) {
        int n2;
        int n3;
        int n4;
        int n5;
        block3 : {
            block2 : {
                n5 = e2.b(this.s);
                n2 = e2.b(this.t);
                n4 = e2.b(this.u);
                int n6 = e2.b(this.v);
                if (n4 - n5 < 0 || n6 - n2 < 0 || n5 == Integer.MIN_VALUE || n5 == Integer.MAX_VALUE || n2 == Integer.MIN_VALUE || n2 == Integer.MAX_VALUE || n4 == Integer.MIN_VALUE || n4 == Integer.MAX_VALUE || n6 == Integer.MIN_VALUE) break block2;
                n3 = n6;
                if (n6 != Integer.MAX_VALUE) break block3;
            }
            n3 = 0;
            n5 = 0;
            n2 = 0;
            n4 = 0;
        }
        this.a(n5, n2, n4, n3);
    }

    public void c(boolean bl2) {
        this.o = bl2;
    }

    public void d() {
    }

    public void d(float f2) {
        this.aa[1] = f2;
    }

    public void d(int n2) {
        this.af[1] = n2;
    }

    public void d(int n2, int n3) {
        this.J = n2;
        this.F = n3 - n2;
        if (this.F < this.Q) {
            this.F = this.Q;
        }
    }

    public void e(int n2) {
        this.ap = n2;
    }

    public boolean e() {
        boolean bl2;
        int n2 = this.e;
        boolean bl3 = bl2 = false;
        if (n2 == 0) {
            bl3 = bl2;
            if (this.G == 0.0f) {
                bl3 = bl2;
                if (this.h == 0) {
                    bl3 = bl2;
                    if (this.i == 0) {
                        bl3 = bl2;
                        if (this.C[0] == a.c) {
                            bl3 = true;
                        }
                    }
                }
            }
        }
        return bl3;
    }

    public void f(int n2) {
        this.I = n2;
    }

    public boolean f() {
        return this.f == 0 && this.G == 0.0f && this.k == 0 && this.l == 0 && this.C[1] == a.c;
    }

    public void g() {
        this.s.i();
        this.t.i();
        this.u.i();
        this.v.i();
        this.w.i();
        this.x.i();
        this.y.i();
        this.z.i();
        this.D = null;
        this.ag = 0.0f;
        this.E = 0;
        this.F = 0;
        this.G = 0.0f;
        this.H = -1;
        this.I = 0;
        this.J = 0;
        this.ah = 0;
        this.ai = 0;
        this.aj = 0;
        this.ak = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.al = 0;
        this.am = 0;
        this.S = R;
        this.T = R;
        this.C[0] = a.a;
        this.C[1] = a.a;
        this.an = null;
        this.ao = 0;
        this.ap = 0;
        this.ar = null;
        this.U = false;
        this.V = false;
        this.W = 0;
        this.X = 0;
        this.Y = false;
        this.Z = false;
        this.aa[0] = -1.0f;
        this.aa[1] = -1.0f;
        this.a = -1;
        this.b = -1;
        this.af[0] = Integer.MAX_VALUE;
        this.af[1] = Integer.MAX_VALUE;
        this.e = 0;
        this.f = 0;
        this.j = 1.0f;
        this.m = 1.0f;
        this.i = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.h = 0;
        this.k = 0;
        this.p = -1;
        this.q = 1.0f;
        if (this.c != null) {
            this.c.b();
        }
        if (this.d != null) {
            this.d.b();
        }
        this.r = null;
    }

    public void g(int n2) {
        this.J = n2;
    }

    public void h() {
        for (int i2 = 0; i2 < 6; ++i2) {
            this.A[i2].a().c();
        }
    }

    public void h(int n2) {
        this.E = n2;
        if (this.E < this.P) {
            this.E = this.P;
        }
    }

    public o i() {
        if (this.c == null) {
            this.c = new o();
        }
        return this.c;
    }

    public void i(int n2) {
        this.F = n2;
        if (this.F < this.Q) {
            this.F = this.Q;
        }
    }

    public o j() {
        if (this.d == null) {
            this.d = new o();
        }
        return this.d;
    }

    public void j(int n2) {
        int n3 = n2;
        if (n2 < 0) {
            n3 = 0;
        }
        this.P = n3;
    }

    public f k() {
        return this.D;
    }

    public void k(int n2) {
        int n3 = n2;
        if (n2 < 0) {
            n3 = 0;
        }
        this.Q = n3;
    }

    public int l() {
        return this.ap;
    }

    public void l(int n2) {
        this.al = n2;
    }

    public String m() {
        return this.aq;
    }

    public void m(int n2) {
        this.am = n2;
    }

    public int n() {
        return this.I;
    }

    public void n(int n2) {
        this.O = n2;
    }

    public int o() {
        return this.J;
    }

    public void o(int n2) {
        this.W = n2;
    }

    public int p() {
        if (this.ap == 8) {
            return 0;
        }
        return this.E;
    }

    public void p(int n2) {
        this.X = n2;
    }

    public int q() {
        return this.al;
    }

    public int r() {
        if (this.ap == 8) {
            return 0;
        }
        return this.F;
    }

    public int s() {
        return this.am;
    }

    public int t() {
        return this.ah + this.M;
    }

    public String toString() {
        CharSequence charSequence;
        StringBuilder stringBuilder = new StringBuilder();
        if (this.ar != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("type: ");
            ((StringBuilder)charSequence).append(this.ar);
            ((StringBuilder)charSequence).append(" ");
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = "";
        }
        stringBuilder.append((String)charSequence);
        if (this.aq != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("id: ");
            ((StringBuilder)charSequence).append(this.aq);
            ((StringBuilder)charSequence).append(" ");
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = "";
        }
        stringBuilder.append((String)charSequence);
        stringBuilder.append("(");
        stringBuilder.append(this.I);
        stringBuilder.append(", ");
        stringBuilder.append(this.J);
        stringBuilder.append(") - (");
        stringBuilder.append(this.E);
        stringBuilder.append(" x ");
        stringBuilder.append(this.F);
        stringBuilder.append(") wrap: (");
        stringBuilder.append(this.al);
        stringBuilder.append(" x ");
        stringBuilder.append(this.am);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public int u() {
        return this.ai + this.N;
    }

    protected int v() {
        return this.I + this.M;
    }

    protected int w() {
        return this.J + this.N;
    }

    public int x() {
        return this.n() + this.E;
    }

    public int y() {
        return this.o() + this.F;
    }

    public float z() {
        return this.S;
    }

    public static enum a {
        a,
        b,
        c,
        d;
        
    }

}

