/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import androidx.constraintlayout.b.a.e;
import androidx.constraintlayout.b.a.o;
import androidx.constraintlayout.b.a.p;
import androidx.constraintlayout.b.b;
import androidx.constraintlayout.b.e;
import androidx.constraintlayout.b.f;
import androidx.constraintlayout.b.h;

public class n
extends p {
    androidx.constraintlayout.b.a.e a;
    float b;
    n c;
    float d;
    n e;
    float f;
    int g = 0;
    private n j;
    private float k;
    private o l = null;
    private int m = 1;
    private o n = null;
    private int o = 1;

    public n(androidx.constraintlayout.b.a.e e2) {
        this.a = e2;
    }

    String a(int n2) {
        if (n2 == 1) {
            return "DIRECT";
        }
        if (n2 == 2) {
            return "CENTER";
        }
        if (n2 == 3) {
            return "MATCH";
        }
        if (n2 == 4) {
            return "CHAIN";
        }
        if (n2 == 5) {
            return "BARRIER";
        }
        return "UNCONNECTED";
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a() {
        block26 : {
            block25 : {
                block24 : {
                    float f2;
                    float f3;
                    void var9_8;
                    int n2 = this.i;
                    int n3 = 1;
                    if (n2 == 1) {
                        return;
                    }
                    if (this.g == 4) {
                        return;
                    }
                    if (this.l != null) {
                        if (this.l.i != 1) {
                            return;
                        }
                        this.d = (float)this.m * this.l.a;
                    }
                    if (this.n != null) {
                        if (this.n.i != 1) {
                            return;
                        }
                        this.k = (float)this.o * this.n.a;
                    }
                    if (this.g == 1 && (this.c == null || this.c.i == 1)) {
                        float f4;
                        if (this.c == null) {
                            this.e = this;
                            f4 = this.d;
                        } else {
                            this.e = this.c.e;
                            f4 = this.c.f + this.d;
                        }
                        this.f = f4;
                        this.f();
                        return;
                    }
                    if (this.g != 2 || this.c == null || this.c.i != 1 || this.j == null || this.j.c == null || this.j.c.i != 1) break block24;
                    if (e.a() != null) {
                        f f5 = e.a();
                        ++f5.w;
                    }
                    this.e = this.c.e;
                    this.j.e = this.j.c.e;
                    e.c c2 = this.a.b;
                    e.c c3 = e.c.d;
                    int n4 = 0;
                    n2 = n3;
                    if (c2 != c3) {
                        n2 = this.a.b == e.c.e ? n3 : 0;
                    }
                    if (n2 != 0) {
                        f3 = this.c.f;
                        n n5 = this.j.c;
                    } else {
                        f3 = this.j.c.f;
                        n n6 = this.c;
                    }
                    f3 -= var9_8.f;
                    if (this.a.b != e.c.b && this.a.b != e.c.d) {
                        f2 = f3 - (float)this.a.a.r();
                        f3 = this.a.a.T;
                    } else {
                        f2 = f3 - (float)this.a.a.p();
                        f3 = this.a.a.S;
                    }
                    int n7 = this.a.e();
                    n3 = this.j.a.e();
                    if (this.a.g() == this.j.a.g()) {
                        f3 = 0.5f;
                        n3 = 0;
                    } else {
                        n4 = n7;
                    }
                    float f6 = n4;
                    float f7 = n3;
                    f2 = f2 - f6 - f7;
                    if (n2 != 0) {
                        this.j.f = this.j.c.f + f7 + f2 * f3;
                        this.f = this.c.f - f6 - f2 * (1.0f - f3);
                    } else {
                        this.f = this.c.f + f6 + f2 * f3;
                        this.j.f = this.j.c.f - f7 - f2 * (1.0f - f3);
                    }
                    break block25;
                }
                if (this.g != 3 || this.c == null || this.c.i != 1 || this.j == null || this.j.c == null || this.j.c.i != 1) break block26;
                if (e.a() != null) {
                    f f8 = e.a();
                    ++f8.x;
                }
                this.e = this.c.e;
                this.j.e = this.j.c.e;
                this.f = this.c.f + this.d;
                this.j.f = this.j.c.f + this.j.d;
            }
            this.f();
            this.j.f();
            return;
        }
        if (this.g == 5) {
            this.a.a.d();
        }
    }

    public void a(int n2, n n3, int n4) {
        this.g = n2;
        this.c = n3;
        this.d = n4;
        this.c.a(this);
    }

    public void a(n n2, float f2) {
        if (this.i == 0 || this.e != n2 && this.f != f2) {
            this.e = n2;
            this.f = f2;
            if (this.i == 1) {
                this.e();
            }
            this.f();
        }
    }

    public void a(n n2, int n3) {
        this.c = n2;
        this.d = n3;
        this.c.a(this);
    }

    public void a(n n2, int n3, o o2) {
        this.c = n2;
        this.c.a(this);
        this.l = o2;
        this.m = n3;
        this.l.a(this);
    }

    void a(e e2) {
        h h2 = this.a.b();
        if (this.e == null) {
            e2.a(h2, (int)this.f);
            return;
        }
        e2.c(h2, e2.a(this.e.a), (int)this.f, 6);
    }

    @Override
    public void b() {
        super.b();
        this.c = null;
        this.d = 0.0f;
        this.l = null;
        this.m = 1;
        this.n = null;
        this.o = 1;
        this.e = null;
        this.f = 0.0f;
        this.b = 0.0f;
        this.j = null;
        this.k = 0.0f;
        this.g = 0;
    }

    public void b(int n2) {
        this.g = n2;
    }

    public void b(n n2, float f2) {
        this.j = n2;
        this.k = f2;
    }

    public void b(n n2, int n3, o o2) {
        this.j = n2;
        this.n = o2;
        this.o = n3;
    }

    public void c() {
        int n2;
        androidx.constraintlayout.b.a.e e2;
        block6 : {
            int n3;
            block5 : {
                e2 = this.a.g();
                if (e2 == null) {
                    return;
                }
                if (e2.g() == this.a) {
                    this.g = 4;
                    e2.a().g = 4;
                }
                n3 = this.a.e();
                if (this.a.b == e.c.d) break block5;
                n2 = n3;
                if (this.a.b != e.c.e) break block6;
            }
            n2 = -n3;
        }
        this.a(e2.a(), n2);
    }

    public float d() {
        return this.f;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        String string2;
        StringBuilder stringBuilder;
        if (this.i == 1) {
            if (this.e == this) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("[");
                stringBuilder.append(this.a);
                stringBuilder.append(", RESOLVED: ");
                stringBuilder.append(this.f);
                string2 = "]  type: ";
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("[");
                stringBuilder.append(this.a);
                stringBuilder.append(", RESOLVED: ");
                stringBuilder.append(this.e);
                stringBuilder.append(":");
                stringBuilder.append(this.f);
                string2 = "] type: ";
            }
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("{ ");
            stringBuilder.append(this.a);
            string2 = " UNRESOLVED} type: ";
        }
        stringBuilder.append(string2);
        stringBuilder.append(this.a(this.g));
        return stringBuilder.toString();
    }
}

