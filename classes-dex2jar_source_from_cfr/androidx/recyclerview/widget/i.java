/*
 * Decompiled with CFR 0.139.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

class i {
    final a a;

    i(a a2) {
        this.a = a2;
    }

    private void a(List<a.b> list, int n2, int n3) {
        a.b b2 = list.get(n2);
        a.b b3 = list.get(n3);
        int n4 = b3.a;
        if (n4 != 4) {
            switch (n4) {
                default: {
                    return;
                }
                case 2: {
                    this.a(list, n2, b2, n3, b3);
                    return;
                }
                case 1: 
            }
            this.c(list, n2, b2, n3, b3);
            return;
        }
        this.b(list, n2, b2, n3, b3);
    }

    private int b(List<a.b> list) {
        boolean bl2 = false;
        for (int i2 = list.size() - 1; i2 >= 0; --i2) {
            boolean bl3;
            if (list.get((int)i2).a == 8) {
                bl3 = bl2;
                if (bl2) {
                    return i2;
                }
            } else {
                bl3 = true;
            }
            bl2 = bl3;
        }
        return -1;
    }

    private void c(List<a.b> list, int n2, a.b b2, int n3, a.b b3) {
        int n4 = b2.d < b3.b ? -1 : 0;
        int n5 = n4;
        if (b2.b < b3.b) {
            n5 = n4 + 1;
        }
        if (b3.b <= b2.b) {
            b2.b += b3.d;
        }
        if (b3.b <= b2.d) {
            b2.d += b3.d;
        }
        b3.b += n5;
        list.set(n2, b3);
        list.set(n3, b2);
    }

    void a(List<a.b> list) {
        int n2;
        while ((n2 = this.b(list)) != -1) {
            this.a(list, n2, n2 + 1);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    void a(List<a.b> var1_1, int var2_2, a.b var3_3, int var4_4, a.b var5_5) {
        block24 : {
            block25 : {
                block23 : {
                    block22 : {
                        block20 : {
                            block21 : {
                                var6_6 = var3_3.b;
                                var8_7 = var3_3.d;
                                var7_8 = false;
                                if (var6_6 >= var8_7) break block20;
                                if (var5_5.b != var3_3.b || var5_5.d != var3_3.d - var3_3.b) break block21;
                                var6_6 = 0;
                                ** GOTO lbl14
                            }
                            var6_6 = 0;
                            break block22;
                        }
                        if (var5_5.b == var3_3.d + 1 && var5_5.d == var3_3.b - var3_3.d) {
                            var6_6 = 1;
lbl14: // 2 sources:
                            var7_8 = true;
                        } else {
                            var6_6 = 1;
                        }
                    }
                    if (var3_3.d < var5_5.b) {
                        --var5_5.b;
                    } else if (var3_3.d < var5_5.b + var5_5.d) {
                        --var5_5.d;
                        var3_3.a = 2;
                        var3_3.d = 1;
                        if (var5_5.d != 0) return;
                        var1_1.remove(var4_4);
                        this.a.a(var5_5);
                        return;
                    }
                    var8_7 = var3_3.b;
                    var9_9 = var5_5.b++;
                    var11_10 = null;
                    if (var8_7 > var9_9 && var3_3.b < var5_5.b + var5_5.d) {
                        var8_7 = var5_5.b;
                        var9_9 = var5_5.d;
                        var10_11 = var3_3.b;
                        var11_10 = this.a.a(2, var3_3.b + 1, var8_7 + var9_9 - var10_11, null);
                        var5_5.d = var3_3.b - var5_5.b;
                    }
                    if (var7_8) {
                        var1_1.set(var2_2, var5_5);
                        var1_1.remove(var4_4);
                        this.a.a(var3_3);
                        return;
                    }
                    if (var6_6 == 0) break block23;
                    if (var11_10 != null) {
                        if (var3_3.b > var11_10.b) {
                            var3_3.b -= var11_10.d;
                        }
                        if (var3_3.d > var11_10.b) {
                            var3_3.d -= var11_10.d;
                        }
                    }
                    if (var3_3.b > var5_5.b) {
                        var3_3.b -= var5_5.d;
                    }
                    if (var3_3.d <= var5_5.b) break block24;
                    break block25;
                }
                if (var11_10 != null) {
                    if (var3_3.b >= var11_10.b) {
                        var3_3.b -= var11_10.d;
                    }
                    if (var3_3.d >= var11_10.b) {
                        var3_3.d -= var11_10.d;
                    }
                }
                if (var3_3.b >= var5_5.b) {
                    var3_3.b -= var5_5.d;
                }
                if (var3_3.d < var5_5.b) break block24;
            }
            var3_3.d -= var5_5.d;
        }
        var1_1.set(var2_2, var5_5);
        if (var3_3.b != var3_3.d) {
            var1_1.set(var4_4, var3_3);
        } else {
            var1_1.remove(var4_4);
        }
        if (var11_10 == null) return;
        var1_1.add(var2_2, var11_10);
    }

    void b(List<a.b> list, int n2, a.b b2, int n3, a.b b3) {
        a.b b4;
        int n4 = b2.d;
        int n5 = b3.b--;
        a.b b5 = null;
        if (n4 >= n5 && b2.d < b3.b + b3.d) {
            --b3.d;
            b4 = this.a.a(4, b2.b, 1, b3.c);
        } else {
            b4 = null;
        }
        if (b2.b <= b3.b) {
            ++b3.b;
        } else if (b2.b < b3.b + b3.d) {
            n4 = b3.b + b3.d - b2.b;
            b5 = this.a.a(4, b2.b + 1, n4, b3.c);
            b3.d -= n4;
        }
        list.set(n3, b2);
        if (b3.d > 0) {
            list.set(n2, b3);
        } else {
            list.remove(n2);
            this.a.a(b3);
        }
        if (b4 != null) {
            list.add(n2, b4);
        }
        if (b5 != null) {
            list.add(n2, b5);
        }
    }

    static interface a {
        public a.b a(int var1, int var2, int var3, Object var4);

        public void a(a.b var1);
    }

}

