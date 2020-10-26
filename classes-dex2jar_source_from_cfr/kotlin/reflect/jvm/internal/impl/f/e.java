/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.f.c;
import kotlin.reflect.jvm.internal.impl.f.d;
import kotlin.reflect.jvm.internal.impl.f.f;
import kotlin.reflect.jvm.internal.impl.f.g;
import kotlin.reflect.jvm.internal.impl.f.j;
import kotlin.reflect.jvm.internal.impl.f.k;
import kotlin.reflect.jvm.internal.impl.f.p;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.f.s;
import kotlin.reflect.jvm.internal.impl.f.y;
import kotlin.reflect.jvm.internal.impl.f.z;

public final class e {
    private final byte[] a;
    private final boolean b;
    private int c;
    private int d;
    private int e;
    private final InputStream f;
    private int g;
    private boolean h = false;
    private int i;
    private int j = Integer.MAX_VALUE;
    private int k;
    private int l = 64;
    private int m = 67108864;
    private a n = null;

    private e(InputStream inputStream) {
        this.a = new byte[4096];
        this.c = 0;
        this.e = 0;
        this.i = 0;
        this.f = inputStream;
        this.b = false;
    }

    private e(p p2) {
        this.a = p2.c;
        this.e = p2.b();
        this.c = this.e + p2.a();
        this.i = -this.e;
        this.f = null;
        this.b = true;
    }

    private void A() {
        this.c += this.d;
        int n2 = this.i + this.c;
        if (n2 > this.j) {
            this.d = n2 - this.j;
            this.c -= this.d;
            return;
        }
        this.d = 0;
    }

    public static int a(int n2, InputStream inputStream) {
        int n3;
        int n4;
        block5 : {
            if ((n2 & 128) == 0) {
                return n2;
            }
            n4 = n2 & 127;
            n2 = 7;
            do {
                if (n2 >= 32) break block5;
                n3 = inputStream.read();
                if (n3 == -1) break;
                n4 |= (n3 & 127) << n2;
                if ((n3 & 128) == 0) {
                    return n4;
                }
                n2 += 7;
            } while (true);
            throw k.b();
        }
        for (n3 = n2; n3 < 64; n3 += 7) {
            n2 = inputStream.read();
            if (n2 != -1) {
                if ((n2 & 128) != 0) continue;
                return n4;
            }
            throw k.b();
        }
        throw k.d();
    }

    public static long a(long l2) {
        return -(l2 & 1L) ^ l2 >>> 1;
    }

    public static e a(InputStream inputStream) {
        return new e(inputStream);
    }

    static e a(p p2) {
        e e2 = new e(p2);
        try {
            e2.c(p2.a());
            return e2;
        }
        catch (k k2) {
            throw new IllegalArgumentException(k2);
        }
    }

    public static int b(int n2) {
        return -(n2 & 1) ^ n2 >>> 1;
    }

    private void f(int n2) {
        if (this.c - this.e < n2) {
            this.g(n2);
        }
    }

    private void g(int n2) {
        if (this.h(n2)) {
            return;
        }
        throw k.b();
    }

    private boolean h(int n2) {
        if (this.e + n2 > this.c) {
            if (this.i + this.e + n2 > this.j) {
                return false;
            }
            if (this.n != null) {
                this.n.a();
            }
            if (this.f != null) {
                int n3 = this.e;
                if (n3 > 0) {
                    if (this.c > n3) {
                        System.arraycopy(this.a, n3, this.a, 0, this.c - n3);
                    }
                    this.i += n3;
                    this.c -= n3;
                    this.e = 0;
                }
                if ((n3 = this.f.read(this.a, this.c, this.a.length - this.c)) != 0 && n3 >= -1 && n3 <= this.a.length) {
                    if (n3 > 0) {
                        this.c += n3;
                        if (this.i + n2 - this.m <= 0) {
                            this.A();
                            if (this.c >= n2) {
                                return true;
                            }
                            return this.h(n2);
                        }
                        throw k.i();
                    }
                } else {
                    StringBuilder stringBuilder = new StringBuilder(102);
                    stringBuilder.append("InputStream#read(byte[]) returned invalid result: ");
                    stringBuilder.append(n3);
                    stringBuilder.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder(77);
        stringBuilder.append("refillBuffer() called when ");
        stringBuilder.append(n2);
        stringBuilder.append(" bytes were already available in buffer");
        throw new IllegalStateException(stringBuilder.toString());
    }

    private byte[] i(int n2) {
        if (n2 <= 0) {
            if (n2 == 0) {
                return j.a;
            }
            throw k.c();
        }
        if (this.i + this.e + n2 <= this.j) {
            byte[] arrby;
            if (n2 < 4096) {
                byte[] arrby2 = new byte[n2];
                int n3 = this.c - this.e;
                System.arraycopy(this.a, this.e, arrby2, 0, n3);
                this.e = this.c;
                this.f(n2 -= n3);
                System.arraycopy(this.a, 0, arrby2, n3, n2);
                this.e = n2;
                return arrby2;
            }
            int n4 = this.e;
            int n5 = this.c;
            this.i += this.c;
            this.e = 0;
            this.c = 0;
            int n6 = n5 - n4;
            Object object = new ArrayList();
            for (n5 = n2 - n6; n5 > 0; n5 -= arrby.length) {
                int n7;
                arrby = new byte[Math.min(n5, 4096)];
                for (int i2 = 0; i2 < arrby.length; i2 += n7) {
                    n7 = this.f == null ? -1 : this.f.read(arrby, i2, arrby.length - i2);
                    if (n7 != -1) {
                        this.i += n7;
                        continue;
                    }
                    throw k.b();
                }
                object.add(arrby);
            }
            arrby = new byte[n2];
            System.arraycopy(this.a, n4, arrby, 0, n6);
            object = object.iterator();
            n2 = n6;
            while (object.hasNext()) {
                byte[] arrby3 = (byte[])object.next();
                System.arraycopy(arrby3, 0, arrby, n2, arrby3.length);
                n2 += arrby3.length;
            }
            return arrby;
        }
        this.e(this.j - this.i - this.e);
        throw k.b();
    }

    private void j(int n2) {
        if (n2 >= 0) {
            if (this.i + this.e + n2 <= this.j) {
                int n3;
                int n4 = this.c - this.e;
                this.e = this.c;
                do {
                    this.g(1);
                    n3 = n2 - n4;
                    if (n3 <= this.c) break;
                    n4 += this.c;
                    this.e = this.c;
                } while (true);
                this.e = n3;
                return;
            }
            this.e(this.j - this.i - this.e);
            throw k.b();
        }
        throw k.c();
    }

    public int a() {
        if (this.y()) {
            this.g = 0;
            return 0;
        }
        this.g = this.s();
        if (z.b(this.g) != 0) {
            return this.g;
        }
        throw k.e();
    }

    public <T extends q> T a(s<T> object, g g2) {
        int n2 = this.s();
        if (this.k < this.l) {
            n2 = this.c(n2);
            ++this.k;
            object = (q)object.b(this, g2);
            this.a(0);
            --this.k;
            this.d(n2);
            return (T)object;
        }
        throw k.h();
    }

    public void a(int n2) {
        if (this.g == n2) {
            return;
        }
        throw k.f();
    }

    public void a(int n2, q.a a2, g g2) {
        if (this.k < this.l) {
            ++this.k;
            a2.c(this, g2);
            this.a(z.a(n2, 4));
            --this.k;
            return;
        }
        throw k.h();
    }

    public void a(f f2) {
        int n2;
        while ((n2 = this.a()) != 0 && this.a(n2, f2)) {
        }
    }

    public void a(q.a a2, g g2) {
        int n2 = this.s();
        if (this.k < this.l) {
            n2 = this.c(n2);
            ++this.k;
            a2.c(this, g2);
            this.a(0);
            --this.k;
            this.d(n2);
            return;
        }
        throw k.h();
    }

    public boolean a(int n2, f f2) {
        switch (z.a(n2)) {
            default: {
                throw k.g();
            }
            case 5: {
                int n3 = this.v();
                f2.p(n2);
                f2.c(n3);
                return true;
            }
            case 4: {
                return false;
            }
            case 3: {
                f2.p(n2);
                this.a(f2);
                n2 = z.a(z.b(n2), 4);
                this.a(n2);
                f2.p(n2);
                return true;
            }
            case 2: {
                d d2 = this.l();
                f2.p(n2);
                f2.a(d2);
                return true;
            }
            case 1: {
                long l2 = this.w();
                f2.p(n2);
                f2.c(l2);
                return true;
            }
            case 0: 
        }
        long l3 = this.e();
        f2.p(n2);
        f2.a(l3);
        return true;
    }

    public double b() {
        return Double.longBitsToDouble(this.w());
    }

    public float c() {
        return Float.intBitsToFloat(this.v());
    }

    public int c(int n2) {
        if (n2 >= 0) {
            int n3 = this.j;
            if ((n2 += this.i + this.e) <= n3) {
                this.j = n2;
                this.A();
                return n3;
            }
            throw k.b();
        }
        throw k.c();
    }

    public long d() {
        return this.t();
    }

    public void d(int n2) {
        this.j = n2;
        this.A();
    }

    public long e() {
        return this.t();
    }

    public void e(int n2) {
        if (n2 <= this.c - this.e && n2 >= 0) {
            this.e += n2;
            return;
        }
        this.j(n2);
    }

    public int f() {
        return this.s();
    }

    public long g() {
        return this.w();
    }

    public int h() {
        return this.v();
    }

    public boolean i() {
        return this.t() != 0L;
    }

    public String j() {
        int n2 = this.s();
        if (n2 <= this.c - this.e && n2 > 0) {
            String string2 = new String(this.a, this.e, n2, "UTF-8");
            this.e += n2;
            return string2;
        }
        if (n2 == 0) {
            return "";
        }
        return new String(this.i(n2), "UTF-8");
    }

    public String k() {
        int n2;
        byte[] arrby;
        int n3 = this.s();
        if (n3 <= this.c - (n2 = this.e) && n3 > 0) {
            arrby = this.a;
            this.e = n2 + n3;
        } else {
            if (n3 == 0) {
                return "";
            }
            arrby = this.i(n3);
            n2 = 0;
        }
        if (y.a(arrby, n2, n2 + n3)) {
            return new String(arrby, n2, n3, "UTF-8");
        }
        throw k.j();
    }

    public d l() {
        int n2 = this.s();
        if (n2 <= this.c - this.e && n2 > 0) {
            d d2 = this.b && this.h ? new c(this.a, this.e, n2) : d.a(this.a, this.e, n2);
            this.e += n2;
            return d2;
        }
        if (n2 == 0) {
            return d.a;
        }
        return new p(this.i(n2));
    }

    public int m() {
        return this.s();
    }

    public int n() {
        return this.s();
    }

    public int o() {
        return this.v();
    }

    public long p() {
        return this.w();
    }

    public int q() {
        return e.b(this.s());
    }

    public long r() {
        return e.a(this.t());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public int s() {
        block13 : {
            var2_1 = this.e;
            if (this.c == var2_1) {
                return (int)this.u();
            }
            var10_2 = this.a;
            var1_3 = var2_1 + 1;
            var3_4 = var10_2[var2_1];
            if (var3_4 >= 0) {
                this.e = var1_3;
                return var3_4;
            }
            if (this.c - var1_3 < 9) {
                return (int)this.u();
            }
            var2_1 = var1_3 + 1;
            var8_5 = var3_4 ^= var10_2[var1_3] << 7;
            if (var8_5 >= 0L) break block13;
            var6_6 = -128L;
            var1_3 = var2_1;
            ** GOTO lbl29
        }
        var1_3 = var2_1 + 1;
        var6_6 = var3_4 ^= var10_2[var2_1] << 14;
        if (var6_6 >= 0L) {
            var2_1 = (int)(16256L ^ var6_6);
        } else {
            var2_1 = var1_3 + 1;
            var8_5 = var1_3 = var3_4 ^ var10_2[var1_3] << 21;
            if (var8_5 < 0L) {
                var6_6 = -2080896L;
                var1_3 = var2_1;
lbl29: // 2 sources:
                var2_1 = (int)(var6_6 ^ var8_5);
            } else {
                var4_7 = var2_1 + 1;
                var5_8 = var10_2[var2_1];
                var2_1 = var3_4 = (int)((long)(var1_3 ^ var5_8 << 28) ^ 266354560L);
                var1_3 = var4_7;
                if (var5_8 < 0) {
                    var5_8 = var4_7 + 1;
                    var2_1 = var3_4;
                    var1_3 = var5_8;
                    if (var10_2[var4_7] < 0) {
                        var4_7 = var5_8 + 1;
                        var2_1 = var3_4;
                        var1_3 = var4_7;
                        if (var10_2[var5_8] < 0) {
                            var5_8 = var4_7 + 1;
                            var2_1 = var3_4;
                            var1_3 = var5_8;
                            if (var10_2[var4_7] < 0) {
                                var4_7 = var5_8 + 1;
                                var2_1 = var3_4;
                                var1_3 = var4_7;
                                if (var10_2[var5_8] < 0) {
                                    var1_3 = var4_7 + 1;
                                    var2_1 = var3_4;
                                    if (var10_2[var4_7] < 0) {
                                        return (int)this.u();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.e = var1_3;
        return var2_1;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public long t() {
        block11 : {
            block15 : {
                block14 : {
                    block13 : {
                        block12 : {
                            block10 : {
                                var1_1 = this.e;
                                if (this.c == var1_1) {
                                    return this.u();
                                }
                                var8_2 = this.a;
                                var2_3 = var1_1 + 1;
                                var3_4 = var8_2[var1_1];
                                if (var3_4 >= 0) {
                                    this.e = var2_3;
                                    return var3_4;
                                }
                                if (this.c - var2_3 < 9) {
                                    return this.u();
                                }
                                var1_1 = var2_3 + 1;
                                var4_5 = var3_4 ^ var8_2[var2_3] << 7;
                                if (var4_5 >= 0L) break block10;
                                var4_5 = -128L ^ var4_5;
                                break block11;
                            }
                            var2_3 = var1_1 + 1;
                            if ((var4_5 = (long)(var8_2[var1_1] << 14) ^ var4_5) < 0L) break block12;
                            var6_6 = 16256L;
                            var1_1 = var2_3;
                            ** GOTO lbl48
                        }
                        var1_1 = var2_3 + 1;
                        var6_6 = var4_5 ^ (long)(var8_2[var2_3] << 21);
                        if (var6_6 >= 0L) break block13;
                        var4_5 = -2080896L;
                        ** GOTO lbl54
                    }
                    var2_3 = var1_1 + 1;
                    var4_5 = var6_6 ^ (long)var8_2[var1_1] << 28;
                    if (var4_5 < 0L) break block14;
                    var6_6 = 266354560L;
                    var1_1 = var2_3;
                    ** GOTO lbl48
                }
                var1_1 = var2_3 + 1;
                var6_6 = var4_5 ^ (long)var8_2[var2_3] << 35;
                if (var6_6 >= 0L) break block15;
                var4_5 = -34093383808L;
                ** GOTO lbl54
            }
            var2_3 = var1_1 + 1;
            var4_5 = var6_6 ^ (long)var8_2[var1_1] << 42;
            if (var4_5 >= 0L) {
                var6_6 = 4363953127296L;
                var1_1 = var2_3;
lbl48: // 3 sources:
                var4_5 ^= var6_6;
            } else {
                var1_1 = var2_3 + 1;
                var6_6 = var4_5 ^ (long)var8_2[var2_3] << 49;
                if (var6_6 < 0L) {
                    var4_5 = -558586000294016L;
lbl54: // 3 sources:
                    var4_5 ^= var6_6;
                } else {
                    var2_3 = var1_1 + 1;
                    var4_5 = var6_6 ^ (long)var8_2[var1_1] << 56 ^ 71499008037633920L;
                    if (var4_5 < 0L) {
                        var1_1 = var2_3 + 1;
                        if ((long)var8_2[var2_3] < 0L) {
                            return this.u();
                        }
                    } else {
                        var1_1 = var2_3;
                    }
                }
            }
        }
        this.e = var1_1;
        return var4_5;
    }

    long u() {
        long l2 = 0L;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte by2 = this.z();
            l2 |= (long)(by2 & 127) << i2;
            if ((by2 & 128) != 0) continue;
            return l2;
        }
        throw k.d();
    }

    public int v() {
        int n2;
        int n3 = n2 = this.e;
        if (this.c - n2 < 4) {
            this.g(4);
            n3 = this.e;
        }
        byte[] arrby = this.a;
        this.e = n3 + 4;
        n2 = arrby[n3];
        byte by2 = arrby[n3 + 1];
        byte by3 = arrby[n3 + 2];
        return (arrby[n3 + 3] & 255) << 24 | (n2 & 255 | (by2 & 255) << 8 | (by3 & 255) << 16);
    }

    public long w() {
        int n2;
        int n3 = n2 = this.e;
        if (this.c - n2 < 8) {
            this.g(8);
            n3 = this.e;
        }
        byte[] arrby = this.a;
        this.e = n3 + 8;
        long l2 = arrby[n3];
        long l3 = arrby[n3 + 1];
        long l4 = arrby[n3 + 2];
        long l5 = arrby[n3 + 3];
        long l6 = arrby[n3 + 4];
        long l7 = arrby[n3 + 5];
        long l8 = arrby[n3 + 6];
        return ((long)arrby[n3 + 7] & 255L) << 56 | (l2 & 255L | (l3 & 255L) << 8 | (l4 & 255L) << 16 | (l5 & 255L) << 24 | (l6 & 255L) << 32 | (l7 & 255L) << 40 | (l8 & 255L) << 48);
    }

    public int x() {
        if (this.j == Integer.MAX_VALUE) {
            return -1;
        }
        int n2 = this.i;
        int n3 = this.e;
        return this.j - (n2 + n3);
    }

    public boolean y() {
        return this.e == this.c && !this.h(1);
    }

    public byte z() {
        if (this.e == this.c) {
            this.g(1);
        }
        byte[] arrby = this.a;
        int n2 = this.e;
        this.e = n2 + 1;
        return arrby[n2];
    }

    private static interface a {
        public void a();
    }

}

