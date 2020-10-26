/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import androidx.constraintlayout.b.a.d;
import androidx.constraintlayout.b.a.e;
import androidx.constraintlayout.b.a.f;
import androidx.constraintlayout.b.a.g;
import androidx.constraintlayout.b.a.l;
import androidx.constraintlayout.b.b;
import androidx.constraintlayout.b.h;
import java.util.ArrayList;

class c {
    static void a(g g2, androidx.constraintlayout.b.e e2, int n2) {
        d[] arrd;
        int n3;
        int n4;
        int n5 = 0;
        if (n2 == 0) {
            n3 = g2.ak;
            arrd = g2.an;
            n4 = 0;
        } else {
            n4 = 2;
            n3 = g2.al;
            arrd = g2.am;
        }
        while (n5 < n3) {
            d d2 = arrd[n5];
            d2.a();
            if (!g2.q(4) || !l.a(g2, e2, n2, n4, d2)) {
                c.a(g2, e2, n2, n4, d2);
            }
            ++n5;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static void a(g var0, androidx.constraintlayout.b.e var1_1, int var2_2, int var3_3, d var4_4) {
        block62 : {
            block65 : {
                block64 : {
                    block63 : {
                        block61 : {
                            block58 : {
                                block57 : {
                                    var18_5 = var4_4.a;
                                    var24_6 = var4_4.c;
                                    var17_7 = var4_4.b;
                                    var25_8 = var4_4.d;
                                    var19_9 = var4_4.e;
                                    var5_10 = var4_4.k;
                                    var16_11 = var4_4.f;
                                    var16_11 = var4_4.g;
                                    var13_12 = var0.C[var2_2] == f.a.b ? 1 : 0;
                                    if (var2_2 != 0) break block57;
                                    var8_13 = var19_9.W == 0 ? 1 : 0;
                                    var9_14 = var19_9.W == 1 ? 1 : 0;
                                    var10_15 = var9_14;
                                    var11_16 = var8_13;
                                    if (var19_9.W != 2) ** GOTO lbl-1000
                                    ** GOTO lbl-1000
                                }
                                var8_13 = var19_9.X == 0 ? 1 : 0;
                                var9_14 = var19_9.X == 1 ? 1 : 0;
                                var10_15 = var9_14;
                                var11_16 = var8_13;
                                if (var19_9.X == 2) lbl-1000: // 2 sources:
                                {
                                    var10_15 = 1;
                                    var11_16 = var9_14;
                                    var12_17 = var8_13;
                                } else lbl-1000: // 2 sources:
                                {
                                    var8_13 = 0;
                                    var12_17 = var11_16;
                                    var11_16 = var10_15;
                                    var10_15 = var8_13;
                                }
                                var20_18 = var18_5;
                                var8_13 = 0;
                                do {
                                    var21_21 = null;
                                    if (var8_13 != 0) break;
                                    var16_11 = var20_18.A[var3_3];
                                    var9_14 = var13_12 == 0 && var10_15 == 0 ? 4 : 1;
                                    var14_19 = var15_20 = var16_11.e();
                                    if (var16_11.c != null) {
                                        var14_19 = var15_20;
                                        if (var20_18 != var18_5) {
                                            var14_19 = var15_20 + var16_11.c.e();
                                        }
                                    }
                                    if (var10_15 != 0 && var20_18 != var18_5 && var20_18 != var17_7) {
                                        var9_14 = 6;
                                    } else if (var12_17 != 0 && var13_12 != 0) {
                                        var9_14 = 4;
                                    }
                                    if (var16_11.c != null) {
                                        if (var20_18 == var17_7) {
                                            var1_1.a(var16_11.f, var16_11.c.f, var14_19, 5);
                                        } else {
                                            var1_1.a(var16_11.f, var16_11.c.f, var14_19, 6);
                                        }
                                        var1_1.c(var16_11.f, var16_11.c.f, var14_19, var9_14);
                                    }
                                    if (var13_12 != 0) {
                                        if (var20_18.l() != 8 && var20_18.C[var2_2] == f.a.c) {
                                            var1_1.a(var20_18.A[var3_3 + 1].f, var20_18.A[var3_3].f, 0, 5);
                                        }
                                        var1_1.a(var20_18.A[var3_3].f, var0.A[var3_3].f, 0, 6);
                                    }
                                    var22_22 = var20_18.A[var3_3 + 1].c;
                                    var16_11 = var21_21;
                                    if (var22_22 != null) {
                                        var22_22 = var22_22.a;
                                        var16_11 = var21_21;
                                        if (var22_22.A[var3_3].c != null) {
                                            var16_11 = var22_22.A[var3_3].c.a != var20_18 ? var21_21 : var22_22;
                                        }
                                    }
                                    if (var16_11 != null) {
                                        var20_18 = var16_11;
                                        continue;
                                    }
                                    var8_13 = 1;
                                } while (true);
                                if (var25_8 != null) {
                                    var16_11 = var24_6.A;
                                    var8_13 = var3_3 + 1;
                                    if (var16_11[var8_13].c != null) {
                                        var16_11 = var25_8.A[var8_13];
                                        var1_1.b(var16_11.f, var24_6.A[var8_13].c.f, -var16_11.e(), 5);
                                    }
                                }
                                if (var13_12 != 0) {
                                    var0 = var0.A;
                                    var8_13 = var3_3 + 1;
                                    var1_1.a(var0[var8_13].f, var24_6.A[var8_13].f, var24_6.A[var8_13].e(), 6);
                                }
                                if ((var0 = var4_4.h) == null || (var8_13 = var0.size()) <= 1) break block58;
                                var6_23 = var4_4.l != false && var4_4.n == false ? (float)var4_4.j : var5_10;
                                var16_11 = null;
                                var7_24 = 0.0f;
                                for (var9_14 = 0; var9_14 < var8_13; ++var9_14) {
                                    block59 : {
                                        block60 : {
                                            var20_18 = (f)var0.get(var9_14);
                                            var5_10 = var20_18.aa[var2_2];
                                            if (!(var5_10 < 0.0f)) break block59;
                                            if (!var4_4.n) break block60;
                                            var1_1.c(var20_18.A[var3_3 + 1].f, var20_18.A[var3_3].f, 0, 4);
                                            ** GOTO lbl96
                                        }
                                        var5_10 = 1.0f;
                                    }
                                    if (var5_10 == 0.0f) {
                                        var1_1.c(var20_18.A[var3_3 + 1].f, var20_18.A[var3_3].f, 0, 6);
lbl96: // 2 sources:
                                        var5_10 = var7_24;
                                    } else {
                                        if (var16_11 != null) {
                                            var21_21 = var16_11.A[var3_3].f;
                                            var16_11 = var16_11.A;
                                            var13_12 = var3_3 + 1;
                                            var16_11 = var16_11[var13_12].f;
                                            var22_22 = var20_18.A[var3_3].f;
                                            var23_25 = var20_18.A[var13_12].f;
                                            var26_26 = var1_1.c();
                                            var26_26.a(var7_24, var6_23, var5_10, (h)var21_21, (h)var16_11, (h)var22_22, (h)var23_25);
                                            var1_1.a((b)var26_26);
                                        }
                                        var16_11 = var20_18;
                                    }
                                    var7_24 = var5_10;
                                }
                            }
                            if (var17_7 == null || var17_7 != var25_8 && var10_15 == 0) break block61;
                            var16_11 = var18_5.A[var3_3];
                            var0 = var24_6.A;
                            var8_13 = var3_3 + 1;
                            var20_18 = var0[var8_13];
                            var0 = var18_5.A[var3_3].c != null ? var18_5.A[var3_3].c.f : null;
                            var4_4 = var24_6.A[var8_13].c != null ? var24_6.A[var8_13].c.f : null;
                            var18_5 = var20_18;
                            if (var17_7 == var25_8) {
                                var16_11 = var17_7.A[var3_3];
                                var18_5 = var17_7.A[var8_13];
                            }
                            if (var0 != null && var4_4 != null) {
                                var5_10 = var2_2 == 0 ? var19_9.S : var19_9.T;
                                var2_2 = var16_11.e();
                                var8_13 = var18_5.e();
                                var1_1.a(var16_11.f, (h)var0, var2_2, var5_10, (h)var4_4, var18_5.f, var8_13, 5);
                            }
                            break block62;
                        }
                        if (var12_17 == 0 || var17_7 == null) break block63;
                        var10_15 = var4_4.j > 0 && var4_4.i == var4_4.j ? 1 : 0;
                        var0 = var4_4 = var17_7;
                        var19_9 = var4_4;
                        break block64;
                    }
                    if (var11_16 == 0 || var17_7 == null) break block62;
                    var8_13 = var4_4.j > 0 && var4_4.i == var4_4.j ? 1 : 0;
                    var4_4 = var0 = var17_7;
                    var19_9 = var0;
                    break block65;
                }
                while (var0 != null) {
                    block67 : {
                        block69 : {
                            block68 : {
                                block66 : {
                                    var20_18 = var0.ac[var2_2];
                                    if (var20_18 != null || var0 == var25_8) break block66;
                                    var4_4 = var20_18;
                                    break block67;
                                }
                                var21_21 = var0.A[var3_3];
                                var26_26 = var21_21.f;
                                var16_11 = var21_21.c != null ? var21_21.c.f : null;
                                if (var19_9 == var0) break block68;
                                var4_4 = var19_9.A[var3_3 + 1];
                                ** GOTO lbl161
                            }
                            var4_4 = var16_11;
                            if (var0 != var17_7) break block69;
                            var4_4 = var16_11;
                            if (var19_9 != var0) break block69;
                            if (var18_5.A[var3_3].c != null) {
                                var4_4 = var18_5.A[var3_3].c;
lbl161: // 2 sources:
                                var4_4 = var4_4.f;
                            } else {
                                var4_4 = null;
                            }
                        }
                        var13_12 = var21_21.e();
                        var16_11 = var0.A;
                        var14_19 = var3_3 + 1;
                        var9_14 = var16_11[var14_19].e();
                        if (var20_18 != null) {
                            var23_25 = var20_18.A[var3_3];
                            var22_22 = var23_25.f;
                            var21_21 = var0.A[var14_19].f;
                        } else {
                            var23_25 = var24_6.A[var14_19].c;
                            var16_11 = var23_25 != null ? var23_25.f : null;
                            var21_21 = var0.A[var14_19].f;
                            var22_22 = var16_11;
                        }
                        var16_11 = var20_18;
                        var8_13 = var9_14;
                        if (var23_25 != null) {
                            var8_13 = var9_14 + var23_25.e();
                        }
                        var9_14 = var13_12;
                        if (var19_9 != null) {
                            var9_14 = var13_12 + var19_9.A[var14_19].e();
                        }
                        if (var26_26 != null && var4_4 != null && var22_22 != null && var21_21 != null) {
                            if (var0 == var17_7) {
                                var9_14 = var17_7.A[var3_3].e();
                            }
                            if (var0 == var25_8) {
                                var8_13 = var25_8.A[var14_19].e();
                            }
                            var13_12 = var10_15 != 0 ? 6 : 4;
                            var1_1.a((h)var26_26, (h)var4_4, var9_14, 0.5f, (h)var22_22, (h)var21_21, var8_13, var13_12);
                            var4_4 = var16_11;
                        } else {
                            var4_4 = var16_11;
                        }
                    }
                    var19_9 = var0;
                    var0 = var4_4;
                }
                break block62;
            }
            while ((var16_11 = var4_4) != null) {
                var0 = var16_11.ac[var2_2];
                if (var16_11 != var17_7 && var16_11 != var25_8 && var0 != null) {
                    if (var0 == var25_8) {
                        var0 = null;
                    }
                    var4_4 = var16_11.A[var3_3];
                    var23_25 = var4_4.f;
                    if (var4_4.c != null) {
                        var20_18 = var4_4.c.f;
                    }
                    var20_18 = var19_9.A;
                    var14_19 = var3_3 + 1;
                    var26_26 = var20_18[var14_19].f;
                    var13_12 = var4_4.e();
                    var10_15 = var16_11.A[var14_19].e();
                    if (var0 != null) {
                        var20_18 = var0.A[var3_3];
                        var21_21 = var20_18.f;
                        var4_4 = var20_18.c != null ? var20_18.c.f : null;
                    } else {
                        var20_18 = var16_11.A[var14_19].c;
                        var4_4 = var20_18 != null ? var20_18.f : null;
                        var22_22 = var16_11.A[var14_19].f;
                        var21_21 = var4_4;
                        var4_4 = var22_22;
                    }
                    var9_14 = var10_15;
                    if (var20_18 != null) {
                        var9_14 = var10_15 + var20_18.e();
                    }
                    var10_15 = var13_12;
                    if (var19_9 != null) {
                        var10_15 = var13_12 + var19_9.A[var14_19].e();
                    }
                    var13_12 = var8_13 != 0 ? 6 : 4;
                    if (var23_25 != null && var26_26 != null && var21_21 != null && var4_4 != null) {
                        var1_1.a((h)var23_25, (h)var26_26, var10_15, 0.5f, (h)var21_21, (h)var4_4, var9_14, var13_12);
                    }
                }
                var19_9 = var16_11;
                var4_4 = var0;
            }
            var4_4 = var17_7.A[var3_3];
            var16_11 = var18_5.A[var3_3].c;
            var0 = var25_8.A;
            var2_2 = var3_3 + 1;
            var18_5 = var0[var2_2];
            var0 = var24_6.A[var2_2].c;
            if (var16_11 != null) {
                if (var17_7 != var25_8) {
                    var1_1.c(var4_4.f, var16_11.f, var4_4.e(), 5);
                } else if (var0 != null) {
                    var1_1.a(var4_4.f, var16_11.f, var4_4.e(), 0.5f, var18_5.f, var0.f, var18_5.e(), 5);
                }
            }
            if (var0 != null && var17_7 != var25_8) {
                var1_1.c(var18_5.f, var0.f, -var18_5.e(), 5);
            }
        }
        if (var12_17 == 0) {
            if (var11_16 == 0) return;
        }
        if (var17_7 == null) return;
        var16_11 = var17_7.A[var3_3];
        var0 = var25_8.A;
        var2_2 = var3_3 + 1;
        var18_5 = var0[var2_2];
        var4_4 = var16_11.c != null ? var16_11.c.f : null;
        var0 = var18_5.c != null ? var18_5.c.f : null;
        if (var24_6 != var25_8) {
            var0 = var24_6.A[var2_2];
            var0 = var0.c != null ? var0.c.f : null;
        }
        if (var17_7 == var25_8) {
            var16_11 = var17_7.A[var3_3];
            var18_5 = var17_7.A[var2_2];
        }
        if (var4_4 == null) return;
        if (var0 == null) return;
        var3_3 = var16_11.e();
        var17_7 = var25_8 == null ? var24_6 : var25_8;
        var2_2 = var17_7.A[var2_2].e();
        var1_1.a(var16_11.f, (h)var4_4, var3_3, 0.5f, (h)var0, var18_5.f, var2_2, 5);
    }
}

