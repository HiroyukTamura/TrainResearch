/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b;

import androidx.constraintlayout.b.a;
import androidx.constraintlayout.b.c;
import androidx.constraintlayout.b.e;
import androidx.constraintlayout.b.h;

public class b
implements e.a {
    h a = null;
    float b = 0.0f;
    boolean c = false;
    public final a d;
    boolean e = false;

    public b(c c2) {
        this.d = new a(this, c2);
    }

    public b a(float f2, float f3, float f4, h h2, h h3, h h4, h h5) {
        this.b = 0.0f;
        if (f3 != 0.0f && f2 != f4) {
            if (f2 == 0.0f) {
                this.d.a(h2, 1.0f);
                this.d.a(h3, -1.0f);
                return this;
            }
            if (f4 == 0.0f) {
                this.d.a(h4, 1.0f);
                this.d.a(h5, -1.0f);
                return this;
            }
            f2 = f2 / f3 / (f4 / f3);
            this.d.a(h2, 1.0f);
            this.d.a(h3, -1.0f);
            this.d.a(h5, f2);
            this.d.a(h4, -f2);
            return this;
        }
        this.d.a(h2, 1.0f);
        this.d.a(h3, -1.0f);
        this.d.a(h5, 1.0f);
        this.d.a(h4, -1.0f);
        return this;
    }

    public b a(e e2, int n2) {
        this.d.a(e2.a(n2, "ep"), 1.0f);
        this.d.a(e2.a(n2, "em"), -1.0f);
        return this;
    }

    b a(h h2, int n2) {
        float f2;
        this.a = h2;
        h2.d = f2 = (float)n2;
        this.b = f2;
        this.e = true;
        return this;
    }

    public b a(h h2, h h3, int n2) {
        int n3 = 0;
        int n4 = 0;
        if (n2 != 0) {
            n3 = n4;
            n4 = n2;
            if (n2 < 0) {
                n4 = n2 * -1;
                n3 = 1;
            }
            this.b = n4;
        }
        if (n3 == 0) {
            this.d.a(h2, -1.0f);
            this.d.a(h3, 1.0f);
            return this;
        }
        this.d.a(h2, 1.0f);
        this.d.a(h3, -1.0f);
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    b a(h h2, h h3, int n2, float f2, h h4, h h5, int n3) {
        block5 : {
            block6 : {
                block8 : {
                    block7 : {
                        block4 : {
                            if (h3 == h4) {
                                this.d.a(h2, 1.0f);
                                this.d.a(h5, 1.0f);
                                this.d.a(h3, -2.0f);
                                return this;
                            }
                            if (f2 != 0.5f) break block4;
                            this.d.a(h2, 1.0f);
                            this.d.a(h3, -1.0f);
                            this.d.a(h4, -1.0f);
                            this.d.a(h5, 1.0f);
                            if (n2 <= 0 && n3 <= 0) break block5;
                            f2 = -n2 + n3;
                            break block6;
                        }
                        if (!(f2 <= 0.0f)) break block7;
                        this.d.a(h2, -1.0f);
                        this.d.a(h3, 1.0f);
                        f2 = n2;
                        break block6;
                    }
                    if (!(f2 >= 1.0f)) break block8;
                    this.d.a(h4, -1.0f);
                    this.d.a(h5, 1.0f);
                    f2 = n3;
                    break block6;
                }
                a a2 = this.d;
                float f3 = 1.0f - f2;
                a2.a(h2, f3 * 1.0f);
                this.d.a(h3, f3 * -1.0f);
                this.d.a(h4, -1.0f * f2);
                this.d.a(h5, 1.0f * f2);
                if (n2 <= 0 && n3 <= 0) break block5;
                f2 = (float)(-n2) * f3 + (float)n3 * f2;
            }
            this.b = f2;
            return this;
        }
        return this;
    }

    b a(h h2, h h3, h h4, float f2) {
        this.d.a(h2, -1.0f);
        this.d.a(h3, 1.0f - f2);
        this.d.a(h4, f2);
        return this;
    }

    public b a(h h2, h h3, h h4, int n2) {
        int n3 = 0;
        int n4 = 0;
        if (n2 != 0) {
            n3 = n4;
            n4 = n2;
            if (n2 < 0) {
                n4 = n2 * -1;
                n3 = 1;
            }
            this.b = n4;
        }
        if (n3 == 0) {
            this.d.a(h2, -1.0f);
            this.d.a(h3, 1.0f);
            this.d.a(h4, 1.0f);
            return this;
        }
        this.d.a(h2, 1.0f);
        this.d.a(h3, -1.0f);
        this.d.a(h4, -1.0f);
        return this;
    }

    public b a(h h2, h h3, h h4, h h5, float f2) {
        this.d.a(h2, -1.0f);
        this.d.a(h3, 1.0f);
        this.d.a(h4, f2);
        this.d.a(h5, -f2);
        return this;
    }

    @Override
    public h a(e e2, boolean[] arrbl) {
        return this.d.a(arrbl, null);
    }

    @Override
    public void a(e.a a2) {
        if (a2 instanceof b) {
            a2 = (b)a2;
            this.a = null;
            this.d.a();
            for (int i2 = 0; i2 < a2.d.a; ++i2) {
                h h2 = ((b)a2).d.a(i2);
                float f2 = ((b)a2).d.b(i2);
                this.d.a(h2, f2, true);
            }
        }
    }

    boolean a() {
        return !(this.a == null || this.a.f != h.a.a && this.b < 0.0f);
    }

    boolean a(e object) {
        boolean bl2;
        if ((object = this.d.a((e)object)) == null) {
            bl2 = true;
        } else {
            this.c((h)object);
            bl2 = false;
        }
        if (this.d.a == 0) {
            this.e = true;
        }
        return bl2;
    }

    boolean a(h h2) {
        return this.d.a(h2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public b b(h h2, int n2) {
        float f2;
        a a2;
        if (n2 < 0) {
            this.b = n2 * -1;
            a2 = this.d;
            f2 = 1.0f;
        } else {
            this.b = n2;
            a2 = this.d;
            f2 = -1.0f;
        }
        a2.a(h2, f2);
        return this;
    }

    public b b(h h2, h h3, h h4, int n2) {
        int n3 = 0;
        int n4 = 0;
        if (n2 != 0) {
            n3 = n4;
            n4 = n2;
            if (n2 < 0) {
                n4 = n2 * -1;
                n3 = 1;
            }
            this.b = n4;
        }
        if (n3 == 0) {
            this.d.a(h2, -1.0f);
            this.d.a(h3, 1.0f);
            this.d.a(h4, -1.0f);
            return this;
        }
        this.d.a(h2, 1.0f);
        this.d.a(h3, -1.0f);
        this.d.a(h4, 1.0f);
        return this;
    }

    public b b(h h2, h h3, h h4, h h5, float f2) {
        this.d.a(h4, 0.5f);
        this.d.a(h5, 0.5f);
        this.d.a(h2, -0.5f);
        this.d.a(h3, -0.5f);
        this.b = -f2;
        return this;
    }

    h b(h h2) {
        return this.d.a(null, h2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    String b() {
        if (this.a == null) {
            var7_1 = new StringBuilder();
            var7_1.append("");
            var7_1.append("0");
        } else {
            var7_1 = new StringBuilder();
            var7_1.append("");
            var7_1.append(this.a);
        }
        var7_1 = var7_1.toString();
        var8_2 = new StringBuilder();
        var8_2.append((String)var7_1);
        var8_2.append(" = ");
        var7_1 = var8_2.toString();
        var1_3 = this.b;
        var4_4 = 0;
        if (var1_3 != 0.0f) {
            var8_2 = new StringBuilder();
            var8_2.append((String)var7_1);
            var8_2.append(this.b);
            var7_1 = var8_2.toString();
            var3_5 = true;
        } else {
            var3_5 = false;
        }
        var5_6 = this.d.a;
        do {
            block10 : {
                block12 : {
                    block11 : {
                        if (var4_4 >= var5_6) {
                            var8_2 = var7_1;
                            if (var3_5 != false) return var8_2;
                            var8_2 = new StringBuilder();
                            var8_2.append((String)var7_1);
                            var8_2.append("0.0");
                            return var8_2.toString();
                        }
                        var8_2 = this.d.a(var4_4);
                        if (var8_2 == null || (var6_8 = (var2_7 = this.d.b(var4_4) FCMPL 0.0f)) == false) break block10;
                        var9_9 = var8_2.toString();
                        if (var3_5) break block11;
                        var8_2 = var7_1;
                        var1_3 = var2_7;
                        if (!(var2_7 < 0.0f)) break block12;
                        var8_2 = new StringBuilder();
                        var8_2.append((String)var7_1);
                        var7_1 = "- ";
                        ** GOTO lbl55
                    }
                    if (var6_8 > 0) {
                        var8_2 = new StringBuilder();
                        var8_2.append((String)var7_1);
                        var8_2.append(" + ");
                        var8_2 = var8_2.toString();
                        var1_3 = var2_7;
                    } else {
                        var8_2 = new StringBuilder();
                        var8_2.append((String)var7_1);
                        var7_1 = " - ";
lbl55: // 2 sources:
                        var8_2.append((String)var7_1);
                        var8_2 = var8_2.toString();
                        var1_3 = var2_7 * -1.0f;
                    }
                }
                if (var1_3 == 1.0f) {
                    var7_1 = new StringBuilder();
                } else {
                    var7_1 = new StringBuilder();
                    var7_1.append((String)var8_2);
                    var7_1.append(var1_3);
                    var8_2 = " ";
                }
                var7_1.append((String)var8_2);
                var7_1.append(var9_9);
                var7_1 = var7_1.toString();
                var3_5 = true;
            }
            ++var4_4;
        } while (true);
    }

    b c(h h2, int n2) {
        this.d.a(h2, n2);
        return this;
    }

    public void c() {
        this.a = null;
        this.d.a();
        this.b = 0.0f;
        this.e = false;
    }

    void c(h h2) {
        if (this.a != null) {
            this.d.a(this.a, -1.0f);
            this.a = null;
        }
        float f2 = this.d.a(h2, true) * -1.0f;
        this.a = h2;
        if (f2 == 1.0f) {
            return;
        }
        this.b /= f2;
        this.d.a(f2);
    }

    void d() {
        if (this.b < 0.0f) {
            this.b *= -1.0f;
            this.d.b();
        }
    }

    @Override
    public void d(h h2) {
        int n2 = h2.c;
        float f2 = 1.0f;
        if (n2 != 1) {
            if (h2.c == 2) {
                f2 = 1000.0f;
            } else if (h2.c == 3) {
                f2 = 1000000.0f;
            } else if (h2.c == 4) {
                f2 = 1.0E9f;
            } else if (h2.c == 5) {
                f2 = 1.0E12f;
            }
        }
        this.d.a(h2, f2);
    }

    public boolean e() {
        return this.a == null && this.b == 0.0f && this.d.a == 0;
    }

    @Override
    public void f() {
        this.d.a();
        this.a = null;
        this.b = 0.0f;
    }

    @Override
    public h g() {
        return this.a;
    }

    public String toString() {
        return this.b();
    }
}

