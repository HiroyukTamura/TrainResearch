/*
 * Decompiled with CFR 0.139.
 */
package d;

import d.c;
import d.f;
import d.p;
import d.v;
import java.util.Arrays;

final class r
extends f {
    final transient byte[][] f;
    final transient int[] g;

    r(c object, int n2) {
        super(null);
        v.a(((c)object).b, 0L, n2);
        p p2 = ((c)object).a;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        while (n4 < n2) {
            if (p2.c != p2.b) {
                n4 += p2.c - p2.b;
                ++n5;
                p2 = p2.f;
                continue;
            }
            throw new AssertionError((Object)"s.limit == s.pos");
        }
        this.f = new byte[n5][];
        this.g = new int[n5 * 2];
        object = ((c)object).a;
        n4 = 0;
        n5 = n3;
        while (n5 < n2) {
            this.f[n4] = ((p)object).a;
            n5 = n3 = n5 + (((p)object).c - ((p)object).b);
            if (n3 > n2) {
                n5 = n2;
            }
            this.g[n4] = n5;
            this.g[this.f.length + n4] = ((p)object).b;
            ((p)object).d = true;
            ++n4;
            object = ((p)object).f;
        }
    }

    private int b(int n2) {
        if ((n2 = Arrays.binarySearch(this.g, 0, this.f.length, n2 + 1)) >= 0) {
            return n2;
        }
        return n2;
    }

    private f j() {
        return new f(this.h());
    }

    @Override
    public byte a(int n2) {
        v.a(this.g[this.f.length - 1], n2, 1L);
        int n3 = this.b(n2);
        int n4 = n3 == 0 ? 0 : this.g[n3 - 1];
        int n5 = this.g[this.f.length + n3];
        return this.f[n3][n2 - n4 + n5];
    }

    @Override
    public f a(int n2, int n3) {
        return this.j().a(n2, n3);
    }

    @Override
    public String a() {
        return this.j().a();
    }

    @Override
    void a(c c2) {
        int n2 = this.f.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = this.g[n2 + i2];
            int n5 = this.g[i2];
            p p2 = new p(this.f[i2], n4, n4 + n5 - n3, true, false);
            if (c2.a == null) {
                p2.g = p2;
                p2.f = p2;
                c2.a = p2;
            } else {
                c2.a.g.a(p2);
            }
            n3 = n5;
        }
        c2.b += (long)n3;
    }

    @Override
    public boolean a(int n2, f f2, int n3, int n4) {
        if (n2 >= 0) {
            if (n2 > this.g() - n4) {
                return false;
            }
            int n5 = this.b(n2);
            int n6 = n2;
            n2 = n5;
            while (n4 > 0) {
                int n7;
                int n8;
                n5 = n2 == 0 ? 0 : this.g[n2 - 1];
                if (!f2.a(n3, this.f[n2], n6 - n5 + (n8 = this.g[this.f.length + n2]), n7 = Math.min(n4, this.g[n2] - n5 + n5 - n6))) {
                    return false;
                }
                n6 += n7;
                n3 += n7;
                n4 -= n7;
                ++n2;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean a(int n2, byte[] arrby, int n3, int n4) {
        if (n2 >= 0 && n2 <= this.g() - n4 && n3 >= 0) {
            if (n3 > arrby.length - n4) {
                return false;
            }
            int n5 = this.b(n2);
            int n6 = n2;
            n2 = n5;
            while (n4 > 0) {
                int n7;
                int n8;
                n5 = n2 == 0 ? 0 : this.g[n2 - 1];
                if (!v.a(this.f[n2], n6 - n5 + (n8 = this.g[this.f.length + n2]), arrby, n3, n7 = Math.min(n4, this.g[n2] - n5 + n5 - n6))) {
                    return false;
                }
                n6 += n7;
                n3 += n7;
                n4 -= n7;
                ++n2;
            }
            return true;
        }
        return false;
    }

    @Override
    public String b() {
        return this.j().b();
    }

    @Override
    public f c() {
        return this.j().c();
    }

    @Override
    public f d() {
        return this.j().d();
    }

    @Override
    public String e() {
        return this.j().e();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return object instanceof f && ((f)(object = (f)object)).g() == this.g() && this.a(0, (f)object, 0, this.g());
    }

    @Override
    public f f() {
        return this.j().f();
    }

    @Override
    public int g() {
        return this.g[this.f.length - 1];
    }

    @Override
    public byte[] h() {
        byte[] arrby = new byte[this.g[this.f.length - 1]];
        int n2 = this.f.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = this.g[n2 + i2];
            int n5 = this.g[i2];
            System.arraycopy(this.f[i2], n4, arrby, n3, n5 - n3);
            n3 = n5;
        }
        return arrby;
    }

    @Override
    public int hashCode() {
        int n2 = this.d;
        if (n2 != 0) {
            return n2;
        }
        int n3 = this.f.length;
        int n4 = 0;
        int n5 = 1;
        for (int i2 = 0; i2 < n3; ++i2) {
            byte[] arrby = this.f[i2];
            int n6 = this.g[n3 + i2];
            int n7 = this.g[i2];
            for (n2 = n6; n2 < n7 - n4 + n6; ++n2) {
                n5 = n5 * 31 + arrby[n2];
            }
            n4 = n7;
        }
        this.d = n5;
        return n5;
    }

    @Override
    byte[] i() {
        return this.h();
    }

    @Override
    public String toString() {
        return this.j().toString();
    }
}

