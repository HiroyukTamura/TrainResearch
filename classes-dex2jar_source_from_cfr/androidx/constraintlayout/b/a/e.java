/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import androidx.constraintlayout.b.a.f;
import androidx.constraintlayout.b.a.i;
import androidx.constraintlayout.b.a.n;
import androidx.constraintlayout.b.h;

public class e {
    final f a;
    final c b;
    e c;
    public int d = 0;
    int e = -1;
    h f;
    private n g = new n(this);
    private b h = b.a;
    private a i = a.a;
    private int j = 0;

    public e(f f2, c c2) {
        this.a = f2;
        this.b = c2;
    }

    public n a() {
        return this.g;
    }

    public void a(androidx.constraintlayout.b.c c2) {
        if (this.f == null) {
            this.f = new h(h.a.a, null);
            return;
        }
        this.f.b();
    }

    public boolean a(e e2) {
        boolean bl2 = false;
        if (e2 == null) {
            return false;
        }
        c c2 = e2.d();
        if (c2 == this.b) {
            return this.b != c.f || e2.c().A() && this.c().A();
        }
        switch (1.a[this.b.ordinal()]) {
            default: {
                throw new AssertionError((Object)this.b.name());
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return false;
            }
            case 4: 
            case 5: {
                boolean bl3 = c2 == c.c || c2 == c.e;
                bl2 = bl3;
                if (e2.c() instanceof i) {
                    if (!bl3 && c2 != c.i) {
                        return false;
                    }
                    bl2 = true;
                }
                return bl2;
            }
            case 2: 
            case 3: {
                boolean bl4 = c2 == c.b || c2 == c.d;
                bl2 = bl4;
                if (e2.c() instanceof i) {
                    if (!bl4 && c2 != c.h) {
                        return false;
                    }
                    bl2 = true;
                }
                return bl2;
            }
            case 1: 
        }
        boolean bl5 = bl2;
        if (c2 != c.f) {
            bl5 = bl2;
            if (c2 != c.h) {
                bl5 = bl2;
                if (c2 != c.i) {
                    bl5 = true;
                }
            }
        }
        return bl5;
    }

    public boolean a(e e2, int n2, int n3, b b2, int n4, boolean bl2) {
        if (e2 == null) {
            this.c = null;
            this.d = 0;
            this.e = -1;
            this.h = b.a;
            this.j = 2;
            return true;
        }
        if (!bl2 && !this.a(e2)) {
            return false;
        }
        this.c = e2;
        this.d = n2 > 0 ? n2 : 0;
        this.e = n3;
        this.h = b2;
        this.j = n4;
        return true;
    }

    public boolean a(e e2, int n2, b b2, int n3) {
        return this.a(e2, n2, -1, b2, n3, false);
    }

    public h b() {
        return this.f;
    }

    public f c() {
        return this.a;
    }

    public c d() {
        return this.b;
    }

    public int e() {
        if (this.a.l() == 8) {
            return 0;
        }
        if (this.e > -1 && this.c != null && this.c.a.l() == 8) {
            return this.e;
        }
        return this.d;
    }

    public b f() {
        return this.h;
    }

    public e g() {
        return this.c;
    }

    public int h() {
        return this.j;
    }

    public void i() {
        this.c = null;
        this.d = 0;
        this.e = -1;
        this.h = b.b;
        this.j = 0;
        this.i = a.a;
        this.g.b();
    }

    public boolean j() {
        return this.c != null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.m());
        stringBuilder.append(":");
        stringBuilder.append(this.b.toString());
        return stringBuilder.toString();
    }

    public static enum a {
        a,
        b;
        
    }

    public static enum b {
        a,
        b,
        c;
        
    }

    public static enum c {
        a,
        b,
        c,
        d,
        e,
        f,
        g,
        h,
        i;
        
    }

}

