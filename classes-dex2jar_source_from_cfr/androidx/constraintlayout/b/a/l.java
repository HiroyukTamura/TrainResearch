/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import androidx.constraintlayout.b.a.d;
import androidx.constraintlayout.b.a.f;
import androidx.constraintlayout.b.a.g;
import androidx.constraintlayout.b.a.n;
import androidx.constraintlayout.b.a.o;
import androidx.constraintlayout.b.a.p;
import androidx.constraintlayout.b.e;
import androidx.constraintlayout.b.f;
import androidx.constraintlayout.b.h;

public class l {
    static boolean[] a = new boolean[3];

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static void a(int var0, androidx.constraintlayout.b.a.f var1_1) {
        block48 : {
            block43 : {
                block47 : {
                    block46 : {
                        block45 : {
                            block44 : {
                                block35 : {
                                    block42 : {
                                        block41 : {
                                            block40 : {
                                                block36 : {
                                                    block39 : {
                                                        block38 : {
                                                            block37 : {
                                                                var1_1.h();
                                                                var3_2 = var1_1.s.a();
                                                                var4_3 = var1_1.t.a();
                                                                var5_4 = var1_1.u.a();
                                                                var6_5 = var1_1.v.a();
                                                                var0 = (var0 & 8) == 8 ? 1 : 0;
                                                                var2_6 = var1_1.C[0] == f.a.c && l.a(var1_1, 0) != false ? 1 : 0;
                                                                if (var3_2.g == 4 || var5_4.g == 4) break block35;
                                                                if (var1_1.C[0] == f.a.a || var2_6 != 0 && var1_1.l() == 8) break block36;
                                                                if (var2_6 == 0) break block35;
                                                                var2_6 = var1_1.p();
                                                                var3_2.b(1);
                                                                var5_4.b(1);
                                                                if (var1_1.s.c != null || var1_1.u.c != null) break block37;
                                                                if (var0 == 0) ** GOTO lbl57
                                                                ** GOTO lbl-1000
                                                            }
                                                            if (var1_1.s.c == null || var1_1.u.c != null) break block38;
                                                            if (var0 == 0) ** GOTO lbl57
                                                            ** GOTO lbl-1000
                                                        }
                                                        if (var1_1.s.c != null || var1_1.u.c == null) break block39;
                                                        if (var0 == 0) ** GOTO lbl69
                                                        ** GOTO lbl-1000
                                                    }
                                                    if (var1_1.s.c != null && var1_1.u.c != null) {
                                                        if (var0 != 0) {
                                                            var1_1.i().a(var3_2);
                                                            var1_1.i().a(var5_4);
                                                        }
                                                        if (var1_1.G == 0.0f) {
                                                            var3_2.b(3);
                                                            var5_4.b(3);
                                                            var3_2.b(var5_4, 0.0f);
                                                            var5_4.b(var3_2, 0.0f);
                                                        } else {
                                                            var3_2.b(2);
                                                            var5_4.b(2);
                                                            var3_2.b(var5_4, -var2_6);
                                                            var5_4.b(var3_2, var2_6);
                                                            var1_1.h(var2_6);
                                                        }
                                                    }
                                                    break block35;
                                                }
                                                if (var1_1.s.c != null || var1_1.u.c != null) break block40;
                                                var3_2.b(1);
                                                var5_4.b(1);
                                                if (var0 == 0) ** GOTO lbl-1000
                                                ** GOTO lbl-1000
                                            }
                                            if (var1_1.s.c != null && var1_1.u.c == null) {
                                                var3_2.b(1);
                                                var5_4.b(1);
                                                ** if (var0 == 0) goto lbl-1000
                                            }
                                            break block41;
lbl-1000: // 4 sources:
                                            {
                                                var5_4.a(var3_2, 1, var1_1.i());
                                                ** GOTO lbl83
                                            }
lbl-1000: // 2 sources:
                                            {
                                                var2_6 = var1_1.p();
lbl57: // 3 sources:
                                                var5_4.a(var3_2, var2_6);
                                            }
                                            break block35;
                                        }
                                        if (var1_1.s.c == null && var1_1.u.c != null) {
                                            var3_2.b(1);
                                            var5_4.b(1);
                                            var3_2.a(var5_4, -var1_1.p());
                                            ** if (var0 == 0) goto lbl-1000
                                        }
                                        break block42;
lbl-1000: // 2 sources:
                                        {
                                            var3_2.a(var5_4, -1, var1_1.i());
                                            ** GOTO lbl83
                                        }
lbl-1000: // 1 sources:
                                        {
                                            var2_6 = var1_1.p();
lbl69: // 2 sources:
                                            var3_2.a(var5_4, -var2_6);
                                        }
                                        break block35;
                                    }
                                    if (var1_1.s.c != null && var1_1.u.c != null) {
                                        var3_2.b(2);
                                        var5_4.b(2);
                                        if (var0 != 0) {
                                            var1_1.i().a(var3_2);
                                            var1_1.i().a(var5_4);
                                            var3_2.b(var5_4, -1, var1_1.i());
                                            var5_4.b(var3_2, 1, var1_1.i());
                                        } else {
                                            var3_2.b(var5_4, -var1_1.p());
                                            var5_4.b(var3_2, var1_1.p());
                                        }
                                    }
                                }
                                var2_6 = var1_1.C[1] == f.a.c && l.a(var1_1, 1) != false ? 1 : 0;
                                if (var4_3.g == 4) return;
                                if (var6_5.g == 4) return;
                                if (var1_1.C[1] == f.a.a || var2_6 != 0 && var1_1.l() == 8) break block43;
                                if (var2_6 == 0) return;
                                var2_6 = var1_1.r();
                                var4_3.b(1);
                                var6_5.b(1);
                                if (var1_1.t.c != null || var1_1.v.c != null) break block44;
                                if (var0 == 0) break block45;
                                break block46;
                            }
                            if (var1_1.t.c == null || var1_1.v.c != null) break block47;
                            if (var0 != 0) break block46;
                        }
                        var6_5.a(var4_3, var2_6);
                        return;
                    }
                    var6_5.a(var4_3, 1, var1_1.j());
                    return;
                }
                if (var1_1.t.c == null && var1_1.v.c != null) {
                    if (var0 != 0) {
                        var4_3.a(var6_5, -1, var1_1.j());
                        return;
                    }
                    var4_3.a(var6_5, -var2_6);
                    return;
                }
                if (var1_1.t.c == null) return;
                if (var1_1.v.c == null) return;
                if (var0 != 0) {
                    var1_1.j().a(var4_3);
                    var1_1.i().a(var6_5);
                }
                if (var1_1.G == 0.0f) {
                    var4_3.b(3);
                    var6_5.b(3);
                    var4_3.b(var6_5, 0.0f);
                    var6_5.b(var4_3, 0.0f);
                    return;
                }
                var4_3.b(2);
                var6_5.b(2);
                var4_3.b(var6_5, -var2_6);
                var6_5.b(var4_3, var2_6);
                var1_1.i(var2_6);
                if (var1_1.O <= 0) return;
                break block48;
            }
            if (var1_1.t.c == null && var1_1.v.c == null) {
                var4_3.b(1);
                var6_5.b(1);
                if (var0 != 0) {
                    var6_5.a(var4_3, 1, var1_1.j());
                } else {
                    var6_5.a(var4_3, var1_1.r());
                }
                if (var1_1.w.c == null) return;
                var1_1.w.a().b(1);
                var4_3.a(1, var1_1.w.a(), -var1_1.O);
                return;
            }
            if (var1_1.t.c != null && var1_1.v.c == null) {
                var4_3.b(1);
                var6_5.b(1);
                if (var0 != 0) {
                    var6_5.a(var4_3, 1, var1_1.j());
                } else {
                    var6_5.a(var4_3, var1_1.r());
                }
                if (var1_1.O <= 0) return;
            } else if (var1_1.t.c == null && var1_1.v.c != null) {
                var4_3.b(1);
                var6_5.b(1);
                if (var0 != 0) {
                    var4_3.a(var6_5, -1, var1_1.j());
                } else {
                    var4_3.a(var6_5, -var1_1.r());
                }
                if (var1_1.O <= 0) return;
            } else {
                if (var1_1.t.c == null) return;
                if (var1_1.v.c == null) return;
                var4_3.b(2);
                var6_5.b(2);
                if (var0 != 0) {
                    var4_3.b(var6_5, -1, var1_1.j());
                    var6_5.b(var4_3, 1, var1_1.j());
                    var1_1.j().a(var4_3);
                    var1_1.i().a(var6_5);
                } else {
                    var4_3.b(var6_5, -var1_1.r());
                    var6_5.b(var4_3, var1_1.r());
                }
                if (var1_1.O <= 0) return;
            }
        }
        var1_1.w.a().a(1, var4_3, var1_1.O);
    }

    static void a(g g2, e e2, androidx.constraintlayout.b.a.f f2) {
        int n2;
        int n3;
        if (g2.C[0] != f.a.b && f2.C[0] == f.a.d) {
            n2 = f2.s.d;
            n3 = g2.p() - f2.u.d;
            f2.s.f = e2.a(f2.s);
            f2.u.f = e2.a(f2.u);
            e2.a(f2.s.f, n2);
            e2.a(f2.u.f, n3);
            f2.a = 2;
            f2.c(n2, n3);
        }
        if (g2.C[1] != f.a.b && f2.C[1] == f.a.d) {
            n2 = f2.t.d;
            n3 = g2.r() - f2.v.d;
            f2.t.f = e2.a(f2.t);
            f2.v.f = e2.a(f2.v);
            e2.a(f2.t.f, n2);
            e2.a(f2.v.f, n3);
            if (f2.O > 0 || f2.l() == 8) {
                f2.w.f = e2.a(f2.w);
                e2.a(f2.w.f, f2.O + n2);
            }
            f2.b = 2;
            f2.d(n2, n3);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean a(androidx.constraintlayout.b.a.f arra, int n2) {
        if (arra.C[n2] != f.a.c) {
            return false;
        }
        float f2 = arra.G;
        int n3 = 1;
        if (f2 != 0.0f) {
            arra = arra.C;
            if (arra[n2 = n2 == 0 ? n3 : 0] != f.a.c) return false;
            return false;
        }
        if (n2 == 0) {
            if (arra.e != 0) {
                return false;
            }
            if (arra.h == 0 && arra.i == 0) return true;
            return false;
        }
        if (arra.f != 0) {
            return false;
        }
        if (arra.k != 0) return false;
        if (arra.l == 0) return true;
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static boolean a(g var0, e var1_1, int var2_2, int var3_3, d var4_4) {
        block66 : {
            block63 : {
                block65 : {
                    block64 : {
                        block60 : {
                            var21_5 = var4_4.a;
                            var24_6 = var4_4.c;
                            var20_7 = var4_4.b;
                            var22_8 = var4_4.d;
                            var23_9 = var4_4.e;
                            var11_10 = var4_4.k;
                            var25_11 = var4_4.f;
                            var4_4 = var4_4.g;
                            var0 = var0.C[var2_2];
                            var0 = f.a.b;
                            if (var2_2 != 0) break block60;
                            var12_12 = var23_9.W == 0 ? 1 : 0;
                            var13_13 = var23_9.W == 1 ? 1 : 0;
                            var15_14 = var12_12;
                            var14_15 = var13_13;
                            if (var23_9.W != 2) ** GOTO lbl-1000
                            ** GOTO lbl-1000
                        }
                        var12_12 = var23_9.X == 0 ? 1 : 0;
                        var13_13 = var23_9.X == 1 ? 1 : 0;
                        var15_14 = var12_12;
                        var14_15 = var13_13;
                        if (var23_9.X == 2) lbl-1000: // 2 sources:
                        {
                            var16_16 = true;
                            var15_14 = var12_12;
                        } else lbl-1000: // 2 sources:
                        {
                            var16_16 = false;
                            var13_13 = var14_15;
                        }
                        var4_4 = var21_5;
                        var17_17 = 0;
                        var14_15 = 0;
                        var12_12 = 0;
                        var8_18 = 0.0f;
                        var7_19 = 0.0f;
                        while (var12_12 == 0) {
                            block62 : {
                                block61 : {
                                    var18_22 = var17_17;
                                    var5_20 = var8_18;
                                    var6_21 = var7_19;
                                    if (var4_4.l() != 8) {
                                        var18_22 = var17_17 + 1;
                                        var17_17 = var2_2 == 0 ? var4_4.p() : var4_4.r();
                                        var6_21 = var8_18 + (float)var17_17;
                                        var5_20 = var6_21;
                                        if (var4_4 != var20_7) {
                                            var5_20 = var6_21 + (float)var4_4.A[var3_3].e();
                                        }
                                        var6_21 = var7_19 + (float)var4_4.A[var3_3].e() + (float)var4_4.A[var3_3 + 1].e();
                                    }
                                    var0 = var4_4.A[var3_3];
                                    var19_23 = var14_15;
                                    if (var4_4.l() != 8) {
                                        var19_23 = var14_15;
                                        if (var4_4.C[var2_2] == f.a.c) {
                                            var19_23 = var14_15 + 1;
                                            if (var2_2 == 0) {
                                                if (var4_4.e != 0) {
                                                    return false;
                                                }
                                                if (var4_4.h != 0) return false;
                                                if (var4_4.i != 0) {
                                                    return false;
                                                }
                                            } else {
                                                if (var4_4.f != 0) {
                                                    return false;
                                                }
                                                if (var4_4.k != 0) return false;
                                                if (var4_4.l != 0) {
                                                    return false;
                                                }
                                            }
                                        }
                                    }
                                    if ((var0 = var4_4.A[var3_3 + 1].c) == null) break block61;
                                    var0 = var0.a;
                                    if (var0.A[var3_3].c != null && var0.A[var3_3].c.a == var4_4) break block62;
                                }
                                var0 = null;
                            }
                            if (var0 != null) {
                                var17_17 = var18_22;
                                var14_15 = var19_23;
                                var4_4 = var0;
                                var8_18 = var5_20;
                                var7_19 = var6_21;
                                continue;
                            }
                            var12_12 = 1;
                            var17_17 = var18_22;
                            var14_15 = var19_23;
                            var8_18 = var5_20;
                            var7_19 = var6_21;
                        }
                        var23_9 = var21_5.A[var3_3].a();
                        var0 = var24_6.A;
                        var18_22 = var3_3 + 1;
                        var0 = var0[var18_22].a();
                        if (var23_9.c == null) return false;
                        if (var0.c == null) {
                            return false;
                        }
                        if (var23_9.c.i != 1 && var0.c.i != 1) {
                            return false;
                        }
                        if (var14_15 > 0 && var14_15 != var17_17) {
                            return false;
                        }
                        if (!var16_16 && var15_14 == 0 && var13_13 == 0) {
                            var5_20 = 0.0f;
                        } else {
                            var6_21 = var20_7 != null ? (float)var20_7.A[var3_3].e() : 0.0f;
                            var5_20 = var6_21;
                            if (var22_8 != null) {
                                var5_20 = var6_21 + (float)var22_8.A[var18_22].e();
                            }
                        }
                        var9_24 = var23_9.c.f;
                        var6_21 = var0.c.f;
                        var6_21 = var9_24 < var6_21 ? (var6_21 -= var9_24) : var9_24 - var6_21;
                        var10_25 = var6_21 - var8_18;
                        if (var14_15 > 0 && var14_15 == var17_17) {
                            if (var4_4.k() != null && var4_4.k().C[var2_2] == f.a.b) {
                                return false;
                            }
                            var6_21 = var8_18 = var10_25 + var8_18 - var7_19;
                            if (var15_14 != 0) {
                                var6_21 = var8_18 - (var7_19 - var5_20);
                            }
                            var5_20 = var9_24;
                            var0 = var20_7;
                            if (var15_14 != 0) {
                                var7_19 = var9_24 + (float)var20_7.A[var18_22].e();
                                var4_4 = var20_7.ac[var2_2];
                                var5_20 = var7_19;
                                var0 = var20_7;
                                if (var4_4 != null) {
                                    var5_20 = var7_19 + (float)var4_4.A[var3_3].e();
                                    var0 = var20_7;
                                }
                            }
                            while (var0 != null) {
                                if (e.g != null) {
                                    var4_4 = e.g;
                                    --var4_4.B;
                                    var4_4 = e.g;
                                    ++var4_4.s;
                                    var4_4 = e.g;
                                    ++var4_4.y;
                                }
                                if ((var4_4 = var0.ac[var2_2]) != null || var0 == var22_8) {
                                    var7_19 = var6_21 / (float)var14_15;
                                    if (var11_10 > 0.0f) {
                                        var7_19 = var0.aa[var2_2] * var6_21 / var11_10;
                                    }
                                    var0.A[var3_3].a().a(var23_9.e, var5_20 += (float)var0.A[var3_3].e());
                                    var20_7 = var0.A[var18_22].a();
                                    var21_5 = var23_9.e;
                                    var20_7.a((n)var21_5, var5_20 += var7_19);
                                    var0.A[var3_3].a().a(var1_1);
                                    var0.A[var18_22].a().a(var1_1);
                                    var5_20 += (float)var0.A[var18_22].e();
                                }
                                var0 = var4_4;
                            }
                            return true;
                        }
                        if (var10_25 < var8_18) {
                            return false;
                        }
                        if (var16_16) break block63;
                        if (var15_14 == 0) {
                            if (var13_13 == 0) return true;
                        }
                        if (var15_14 != 0) break block64;
                        var6_21 = var10_25;
                        if (var13_13 == 0) break block65;
                    }
                    var6_21 = var10_25 - var5_20;
                }
                var7_19 = var6_21 / (float)(var17_17 + 1);
                if (var13_13 != 0) {
                    var5_20 = var17_17 > 1 ? (float)(var17_17 - 1) : 2.0f;
                    var7_19 = var6_21 / var5_20;
                }
                var5_20 = var6_21 = var9_24 + var7_19;
                if (var13_13 != 0) {
                    var5_20 = var6_21;
                    if (var17_17 > 1) {
                        var5_20 = (float)var20_7.A[var3_3].e() + var9_24;
                    }
                }
                var6_21 = var5_20;
                var0 = var20_7;
                if (var15_14 != 0) {
                    var6_21 = var5_20;
                    var0 = var20_7;
                    if (var20_7 != null) {
                        var6_21 = var5_20 + (float)var20_7.A[var3_3].e();
                        var0 = var20_7;
                    }
                }
                break block66;
            }
            var5_20 = var9_24 + (var10_25 - var5_20) * var21_5.z();
            while (var20_7 != null) {
                block68 : {
                    block67 : {
                        if (e.g != null) {
                            var0 = e.g;
                            --var0.B;
                            var0 = e.g;
                            ++var0.s;
                            var0 = e.g;
                            ++var0.y;
                        }
                        if ((var0 = var20_7.ac[var2_2]) != null) break block67;
                        var6_21 = var5_20;
                        if (var20_7 != var22_8) break block68;
                    }
                    var12_12 = var2_2 == 0 ? var20_7.p() : var20_7.r();
                    var6_21 = var12_12;
                    var20_7.A[var3_3].a().a(var23_9.e, var5_20 += (float)var20_7.A[var3_3].e());
                    var4_4 = var20_7.A[var18_22].a();
                    var21_5 = var23_9.e;
                    var4_4.a((n)var21_5, var5_20 += var6_21);
                    var20_7.A[var3_3].a().a(var1_1);
                    var20_7.A[var18_22].a().a(var1_1);
                    var6_21 = var5_20 + (float)var20_7.A[var18_22].e();
                }
                var20_7 = var0;
                var5_20 = var6_21;
            }
            return true;
        }
        while (var0 != null) {
            block70 : {
                block69 : {
                    if (e.g != null) {
                        var4_4 = e.g;
                        --var4_4.B;
                        var4_4 = e.g;
                        ++var4_4.s;
                        var4_4 = e.g;
                        ++var4_4.y;
                    }
                    if ((var4_4 = var0.ac[var2_2]) != null) break block69;
                    var5_20 = var6_21;
                    if (var0 != var22_8) break block70;
                }
                var12_12 = var2_2 == 0 ? var0.p() : var0.r();
                var5_20 = var12_12;
                var0.A[var3_3].a().a(var23_9.e, var6_21);
                var0.A[var18_22].a().a(var23_9.e, var6_21 + var5_20);
                var0.A[var3_3].a().a(var1_1);
                var0.A[var18_22].a().a(var1_1);
                var5_20 = var6_21 + (var5_20 + var7_19);
            }
            var0 = var4_4;
            var6_21 = var5_20;
        }
        return true;
    }
}

