/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

final class y {
    private static int a(int n2) {
        int n3 = n2;
        if (n2 > -12) {
            n3 = -1;
        }
        return n3;
    }

    private static int a(int n2, int n3) {
        if (n2 <= -12 && n3 <= -65) {
            return n2 ^ n3 << 8;
        }
        return -1;
    }

    private static int a(int n2, int n3, int n4) {
        if (n2 <= -12 && n3 <= -65 && n4 <= -65) {
            return n2 ^ n3 << 8 ^ n4 << 16;
        }
        return -1;
    }

    public static int a(int n2, byte[] arrby, int n3, int n4) {
        block22 : {
            int n5;
            block19 : {
                block25 : {
                    byte by2;
                    int n6;
                    block23 : {
                        block24 : {
                            block20 : {
                                block21 : {
                                    n5 = n3;
                                    if (n2 == 0) break block19;
                                    if (n3 >= n4) {
                                        return n2;
                                    }
                                    by2 = (byte)n2;
                                    if (by2 >= -32) break block20;
                                    if (by2 < -62) break block21;
                                    n2 = n3 + 1;
                                    if (arrby[n3] <= -65) break block22;
                                }
                                return -1;
                            }
                            if (by2 >= -16) break block23;
                            byte by3 = (byte)(n2 >> 8);
                            n2 = by3;
                            n5 = n3;
                            if (by3 == 0) {
                                n5 = n3 + 1;
                                n2 = arrby[n3];
                                if (n5 >= n4) {
                                    return y.a(by2, n2);
                                }
                            }
                            if (n2 > -65 || by2 == -32 && n2 < -96 || by2 == -19 && n2 >= -96) break block24;
                            n2 = n5 + 1;
                            if (arrby[n5] <= -65) break block22;
                        }
                        return -1;
                    }
                    n5 = (byte)(n2 >> 8);
                    byte by4 = 0;
                    if (n5 == 0) {
                        int n7;
                        n6 = n3 + 1;
                        n5 = n7 = arrby[n3];
                        n3 = by4;
                        n2 = n6;
                        if (n6 >= n4) {
                            return y.a(by2, n7);
                        }
                    } else {
                        by4 = (byte)(n2 >> 16);
                        n2 = n3;
                        n3 = by4;
                    }
                    n6 = n3;
                    by4 = (byte)n2;
                    if (n3 == 0) {
                        by4 = (byte)(n2 + 1);
                        n6 = arrby[n2];
                        if (by4 >= n4) {
                            return y.a(by2, n5, n6);
                        }
                    }
                    if (n5 > -65 || (by2 << 28) + (n5 + 112) >> 30 != 0 || n6 > -65) break block25;
                    n5 = by4 + 1;
                    if (arrby[by4] <= -65) break block19;
                }
                return -1;
            }
            n2 = n5;
        }
        return y.b(arrby, n2, n4);
    }

    public static boolean a(byte[] arrby) {
        return y.a(arrby, 0, arrby.length);
    }

    public static boolean a(byte[] arrby, int n2, int n3) {
        return y.b(arrby, n2, n3) == 0;
    }

    public static int b(byte[] arrby, int n2, int n3) {
        while (n2 < n3 && arrby[n2] >= 0) {
            ++n2;
        }
        if (n2 >= n3) {
            return 0;
        }
        return y.c(arrby, n2, n3);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static int c(byte[] var0, int var1_1, int var2_2) {
        do lbl-1000: // 5 sources:
        {
            block8 : {
                block7 : {
                    if (var1_1 >= var2_2) {
                        return 0;
                    }
                    var3_3 = var1_1 + 1;
                    var4_4 = var0[var1_1];
                    var1_1 = var3_3;
                    if (var4_4 >= 0) ** GOTO lbl-1000
                    if (var4_4 >= -32) break block7;
                    if (var3_3 >= var2_2) {
                        return var4_4;
                    }
                    if (var4_4 < -62) return -1;
                    var1_1 = var3_3 + 1;
                    if (var0[var3_3] <= -65) ** GOTO lbl-1000
                    return -1;
                }
                if (var4_4 >= -16) break block8;
                if (var3_3 >= var2_2 - 1) {
                    return y.d(var0, var3_3, var2_2);
                }
                var5_5 = var3_3 + 1;
                var1_1 = var0[var3_3];
                if (var1_1 > -65) return -1;
                if (var4_4 == -32) {
                    if (var1_1 < -96) return -1;
                }
                if (var4_4 == -19) {
                    if (var1_1 >= -96) return -1;
                }
                var1_1 = var5_5 + 1;
                if (var0[var5_5] <= -65) ** GOTO lbl-1000
                return -1;
            }
            if (var3_3 >= var2_2 - 2) {
                return y.d(var0, var3_3, var2_2);
            }
            var1_1 = var3_3 + 1;
            if ((var3_3 = var0[var3_3]) > -65) return -1;
            if ((var4_4 << 28) + (var3_3 + 112) >> 30 != 0) return -1;
            var3_3 = var1_1 + 1;
            if (var0[var1_1] > -65) return -1;
            var1_1 = var3_3 + 1;
        } while (var0[var3_3] <= -65);
        return -1;
    }

    private static int d(byte[] arrby, int n2, int n3) {
        byte by2 = arrby[n2 - 1];
        switch (n3 - n2) {
            default: {
                throw new AssertionError();
            }
            case 2: {
                return y.a(by2, (int)arrby[n2], (int)arrby[n2 + 1]);
            }
            case 1: {
                return y.a(by2, arrby[n2]);
            }
            case 0: 
        }
        return y.a(by2);
    }
}

