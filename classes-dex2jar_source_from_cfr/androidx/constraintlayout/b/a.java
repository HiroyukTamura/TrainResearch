/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b;

import androidx.constraintlayout.b.b;
import androidx.constraintlayout.b.c;
import androidx.constraintlayout.b.e;
import androidx.constraintlayout.b.h;
import java.util.Arrays;

public class a {
    int a = 0;
    private final b b;
    private final c c;
    private int d = 8;
    private h e = null;
    private int[] f = new int[this.d];
    private int[] g = new int[this.d];
    private float[] h = new float[this.d];
    private int i = -1;
    private int j = -1;
    private boolean k = false;

    a(b b2, c c2) {
        this.b = b2;
        this.c = c2;
    }

    private boolean a(h h2, e e2) {
        return h2.i <= 1;
    }

    public final float a(h h2, boolean bl2) {
        if (this.e == h2) {
            this.e = null;
        }
        if (this.i == -1) {
            return 0.0f;
        }
        int n2 = this.i;
        int n3 = -1;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            if (this.f[n2] == h2.a) {
                if (n2 == this.i) {
                    this.i = this.g[n2];
                } else {
                    this.g[n3] = this.g[n2];
                }
                if (bl2) {
                    h2.b(this.b);
                }
                --h2.i;
                --this.a;
                this.f[n2] = -1;
                if (this.k) {
                    this.j = n2;
                }
                return this.h[n2];
            }
            int n4 = this.g[n2];
            n3 = n2;
            n2 = n4;
        }
        return 0.0f;
    }

    final h a(int n2) {
        int n3 = this.i;
        for (int i2 = 0; n3 != -1 && i2 < this.a; ++i2) {
            if (i2 == n2) {
                return this.c.c[this.f[n3]];
            }
            n3 = this.g[n3];
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    h a(e e2) {
        int n2 = this.i;
        h h2 = null;
        h h3 = null;
        float f2 = 0.0f;
        boolean bl2 = false;
        float f3 = 0.0f;
        boolean bl3 = false;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            float f4;
            float f5;
            h h4;
            block21 : {
                block22 : {
                    block20 : {
                        f5 = this.h[n2];
                        h4 = this.c.c[this.f[n2]];
                        if (!(f5 < 0.0f)) break block20;
                        f4 = f5;
                        if (!(f5 > -0.001f)) break block21;
                        this.h[n2] = 0.0f;
                        break block22;
                    }
                    f4 = f5;
                    if (!(f5 < 0.001f)) break block21;
                    this.h[n2] = 0.0f;
                }
                h4.b(this.b);
                f4 = 0.0f;
            }
            h h5 = h2;
            h h6 = h3;
            f5 = f2;
            boolean bl4 = bl2;
            float f6 = f3;
            boolean bl5 = bl3;
            if (f4 != 0.0f) {
                if (h4.f == h.a.a) {
                    if (h2 == null || f2 > f4) {
                        bl4 = this.a(h4, e2);
                        h5 = h4;
                        h6 = h3;
                        f5 = f4;
                        f6 = f3;
                        bl5 = bl3;
                    } else {
                        h5 = h2;
                        h6 = h3;
                        f5 = f2;
                        bl4 = bl2;
                        f6 = f3;
                        bl5 = bl3;
                        if (!bl2) {
                            h5 = h2;
                            h6 = h3;
                            f5 = f2;
                            bl4 = bl2;
                            f6 = f3;
                            bl5 = bl3;
                            if (this.a(h4, e2)) {
                                bl4 = true;
                                h5 = h4;
                                h6 = h3;
                                f5 = f4;
                                f6 = f3;
                                bl5 = bl3;
                            }
                        }
                    }
                } else {
                    h5 = h2;
                    h6 = h3;
                    f5 = f2;
                    bl4 = bl2;
                    f6 = f3;
                    bl5 = bl3;
                    if (h2 == null) {
                        h5 = h2;
                        h6 = h3;
                        f5 = f2;
                        bl4 = bl2;
                        f6 = f3;
                        bl5 = bl3;
                        if (f4 < 0.0f) {
                            if (h3 == null || f3 > f4) {
                                bl5 = this.a(h4, e2);
                                h5 = h2;
                                h6 = h4;
                                f5 = f2;
                                bl4 = bl2;
                                f6 = f4;
                            } else {
                                h5 = h2;
                                h6 = h3;
                                f5 = f2;
                                bl4 = bl2;
                                f6 = f3;
                                bl5 = bl3;
                                if (!bl3) {
                                    h5 = h2;
                                    h6 = h3;
                                    f5 = f2;
                                    bl4 = bl2;
                                    f6 = f3;
                                    bl5 = bl3;
                                    if (this.a(h4, e2)) {
                                        bl5 = true;
                                        f6 = f4;
                                        bl4 = bl2;
                                        f5 = f2;
                                        h6 = h4;
                                        h5 = h2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            n2 = this.g[n2];
            h2 = h5;
            h3 = h6;
            f2 = f5;
            bl2 = bl4;
            f3 = f6;
            bl3 = bl5;
        }
        if (h2 != null) {
            return h2;
        }
        return h3;
    }

    h a(boolean[] arrbl, h h2) {
        int n2 = this.i;
        h h3 = null;
        float f2 = 0.0f;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            h h4;
            float f3;
            block5 : {
                h h5;
                block7 : {
                    block6 : {
                        h4 = h3;
                        f3 = f2;
                        if (!(this.h[n2] < 0.0f)) break block5;
                        h5 = this.c.c[this.f[n2]];
                        if (arrbl == null) break block6;
                        h4 = h3;
                        f3 = f2;
                        if (arrbl[h5.a]) break block5;
                    }
                    h4 = h3;
                    f3 = f2;
                    if (h5 == h2) break block5;
                    if (h5.f == h.a.c) break block7;
                    h4 = h3;
                    f3 = f2;
                    if (h5.f != h.a.d) break block5;
                }
                float f4 = this.h[n2];
                h4 = h3;
                f3 = f2;
                if (f4 < f2) {
                    h4 = h5;
                    f3 = f4;
                }
            }
            n2 = this.g[n2];
            h3 = h4;
            f2 = f3;
        }
        return h3;
    }

    public final void a() {
        int n2 = this.i;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            h h2 = this.c.c[this.f[n2]];
            if (h2 != null) {
                h2.b(this.b);
            }
            n2 = this.g[n2];
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.a = 0;
    }

    void a(float f2) {
        int n2 = this.i;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            float[] arrf = this.h;
            arrf[n2] = arrf[n2] / f2;
            n2 = this.g[n2];
        }
    }

    final void a(b b2, b b3, boolean bl2) {
        int n2 = this.i;
        do {
            for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
                if (this.f[n2] == b3.a.a) {
                    float f2 = this.h[n2];
                    this.a(b3.a, bl2);
                    a a2 = b3.d;
                    i2 = a2.i;
                    for (n2 = 0; i2 != -1 && n2 < a2.a; ++n2) {
                        this.a(this.c.c[a2.f[i2]], a2.h[i2] * f2, bl2);
                        i2 = a2.g[i2];
                    }
                    b2.b += b3.b * f2;
                    if (bl2) {
                        b3.a.b(b2);
                    }
                    n2 = this.i;
                    continue;
                }
                n2 = this.g[n2];
            }
            break;
        } while (true);
    }

    void a(b b2, b[] arrb) {
        int n2 = this.i;
        do {
            for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
                Object object = this.c.c[this.f[n2]];
                if (((h)object).b != -1) {
                    float f2 = this.h[n2];
                    this.a((h)object, true);
                    object = arrb[((h)object).b];
                    if (!((b)object).e) {
                        a a2 = ((b)object).d;
                        i2 = a2.i;
                        for (n2 = 0; i2 != -1 && n2 < a2.a; ++n2) {
                            this.a(this.c.c[a2.f[i2]], a2.h[i2] * f2, true);
                            i2 = a2.g[i2];
                        }
                    }
                    b2.b += ((b)object).b * f2;
                    ((b)object).a.b(b2);
                    n2 = this.i;
                    continue;
                }
                n2 = this.g[n2];
            }
            break;
        } while (true);
    }

    public final void a(h h2, float f2) {
        int n2;
        if (f2 == 0.0f) {
            this.a(h2, true);
            return;
        }
        if (this.i == -1) {
            this.i = 0;
            this.h[this.i] = f2;
            this.f[this.i] = h2.a;
            this.g[this.i] = -1;
            ++h2.i;
            h2.a(this.b);
            ++this.a;
            if (!this.k) {
                ++this.j;
                if (this.j >= this.f.length) {
                    this.k = true;
                    this.j = this.f.length - 1;
                }
            }
            return;
        }
        int n3 = this.i;
        int n4 = -1;
        for (n2 = 0; n3 != -1 && n2 < this.a; ++n2) {
            if (this.f[n3] == h2.a) {
                this.h[n3] = f2;
                return;
            }
            if (this.f[n3] < h2.a) {
                n4 = n3;
            }
            n3 = this.g[n3];
        }
        n3 = this.j + 1;
        if (this.k) {
            n3 = this.f[this.j] == -1 ? this.j : this.f.length;
        }
        n2 = n3;
        if (n3 >= this.f.length) {
            n2 = n3;
            if (this.a < this.f.length) {
                int n5 = 0;
                do {
                    n2 = n3;
                    if (n5 >= this.f.length) break;
                    if (this.f[n5] == -1) {
                        n2 = n5;
                        break;
                    }
                    ++n5;
                } while (true);
            }
        }
        n3 = n2;
        if (n2 >= this.f.length) {
            n3 = this.f.length;
            this.d *= 2;
            this.k = false;
            this.j = n3 - 1;
            this.h = Arrays.copyOf(this.h, this.d);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
        }
        this.f[n3] = h2.a;
        this.h[n3] = f2;
        if (n4 != -1) {
            this.g[n3] = this.g[n4];
            this.g[n4] = n3;
        } else {
            this.g[n3] = this.i;
            this.i = n3;
        }
        ++h2.i;
        h2.a(this.b);
        ++this.a;
        if (!this.k) {
            ++this.j;
        }
        if (this.a >= this.f.length) {
            this.k = true;
        }
        if (this.j >= this.f.length) {
            this.k = true;
            this.j = this.f.length - 1;
        }
    }

    final void a(h h2, float f2, boolean bl2) {
        int n2;
        if (f2 == 0.0f) {
            return;
        }
        if (this.i == -1) {
            this.i = 0;
            this.h[this.i] = f2;
            this.f[this.i] = h2.a;
            this.g[this.i] = -1;
            ++h2.i;
            h2.a(this.b);
            ++this.a;
            if (!this.k) {
                ++this.j;
                if (this.j >= this.f.length) {
                    this.k = true;
                    this.j = this.f.length - 1;
                }
            }
            return;
        }
        int n3 = this.i;
        int n4 = -1;
        for (n2 = 0; n3 != -1 && n2 < this.a; ++n2) {
            if (this.f[n3] == h2.a) {
                float[] arrf = this.h;
                arrf[n3] = arrf[n3] + f2;
                if (this.h[n3] == 0.0f) {
                    if (n3 == this.i) {
                        this.i = this.g[n3];
                    } else {
                        this.g[n4] = this.g[n3];
                    }
                    if (bl2) {
                        h2.b(this.b);
                    }
                    if (this.k) {
                        this.j = n3;
                    }
                    --h2.i;
                    --this.a;
                }
                return;
            }
            if (this.f[n3] < h2.a) {
                n4 = n3;
            }
            n3 = this.g[n3];
        }
        n3 = this.j + 1;
        if (this.k) {
            n3 = this.f[this.j] == -1 ? this.j : this.f.length;
        }
        n2 = n3;
        if (n3 >= this.f.length) {
            n2 = n3;
            if (this.a < this.f.length) {
                int n5 = 0;
                do {
                    n2 = n3;
                    if (n5 >= this.f.length) break;
                    if (this.f[n5] == -1) {
                        n2 = n5;
                        break;
                    }
                    ++n5;
                } while (true);
            }
        }
        n3 = n2;
        if (n2 >= this.f.length) {
            n3 = this.f.length;
            this.d *= 2;
            this.k = false;
            this.j = n3 - 1;
            this.h = Arrays.copyOf(this.h, this.d);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
        }
        this.f[n3] = h2.a;
        this.h[n3] = f2;
        if (n4 != -1) {
            this.g[n3] = this.g[n4];
            this.g[n4] = n3;
        } else {
            this.g[n3] = this.i;
            this.i = n3;
        }
        ++h2.i;
        h2.a(this.b);
        ++this.a;
        if (!this.k) {
            ++this.j;
        }
        if (this.j >= this.f.length) {
            this.k = true;
            this.j = this.f.length - 1;
        }
    }

    final boolean a(h h2) {
        if (this.i == -1) {
            return false;
        }
        int n2 = this.i;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            if (this.f[n2] == h2.a) {
                return true;
            }
            n2 = this.g[n2];
        }
        return false;
    }

    final float b(int n2) {
        int n3 = this.i;
        for (int i2 = 0; n3 != -1 && i2 < this.a; ++i2) {
            if (i2 == n2) {
                return this.h[n3];
            }
            n3 = this.g[n3];
        }
        return 0.0f;
    }

    public final float b(h h2) {
        int n2 = this.i;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            if (this.f[n2] == h2.a) {
                return this.h[n2];
            }
            n2 = this.g[n2];
        }
        return 0.0f;
    }

    void b() {
        int n2 = this.i;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            float[] arrf = this.h;
            arrf[n2] = arrf[n2] * -1.0f;
            n2 = this.g[n2];
        }
    }

    public String toString() {
        String string2 = "";
        int n2 = this.i;
        for (int i2 = 0; n2 != -1 && i2 < this.a; ++i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" -> ");
            string2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(this.h[n2]);
            stringBuilder.append(" : ");
            string2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(this.c.c[this.f[n2]]);
            string2 = stringBuilder.toString();
            n2 = this.g[n2];
        }
        return string2;
    }
}

