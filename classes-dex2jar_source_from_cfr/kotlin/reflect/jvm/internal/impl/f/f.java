/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import kotlin.reflect.jvm.internal.impl.f.d;
import kotlin.reflect.jvm.internal.impl.f.m;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.f.z;

public final class f {
    private final byte[] a;
    private final int b;
    private int c;
    private int d = 0;
    private final OutputStream e;

    private f(OutputStream outputStream, byte[] arrby) {
        this.e = outputStream;
        this.a = arrby;
        this.c = 0;
        this.b = arrby.length;
    }

    static int a(int n2) {
        if (n2 > 4096) {
            return 4096;
        }
        return n2;
    }

    public static int a(m m2) {
        int n2 = m2.b();
        return f.q(n2) + n2;
    }

    public static f a(OutputStream outputStream, int n2) {
        return new f(outputStream, new byte[n2]);
    }

    public static int b(double d2) {
        return 8;
    }

    public static int b(float f2) {
        return 4;
    }

    public static int b(int n2, double d2) {
        return f.o(n2) + f.b(d2);
    }

    public static int b(int n2, float f2) {
        return f.o(n2) + f.b(f2);
    }

    public static int b(int n2, long l2) {
        return f.o(n2) + f.j(l2);
    }

    public static int b(int n2, d d2) {
        return f.o(n2) + f.b(d2);
    }

    public static int b(int n2, boolean bl2) {
        return f.o(n2) + f.b(bl2);
    }

    public static int b(String arrby) {
        try {
            arrby = arrby.getBytes("UTF-8");
            int n2 = f.q(arrby.length);
            int n3 = arrby.length;
            return n2 + n3;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException("UTF-8 not supported.", unsupportedEncodingException);
        }
    }

    public static int b(d d2) {
        return f.q(d2.a()) + d2.a();
    }

    public static int b(boolean bl2) {
        return 1;
    }

    public static int b(byte[] arrby) {
        return f.q(arrby.length) + arrby.length;
    }

    private void b() {
        if (this.e != null) {
            this.e.write(this.a, 0, this.c);
            this.c = 0;
            return;
        }
        throw new a();
    }

    public static int c(q q2) {
        return q2.i();
    }

    public static int d(int n2, int n3) {
        return f.o(n2) + f.h(n3);
    }

    public static int d(int n2, q q2) {
        return f.o(n2) + f.d(q2);
    }

    public static int d(q q2) {
        int n2 = q2.i();
        return f.q(n2) + n2;
    }

    public static int e(int n2, int n3) {
        return f.o(n2) + f.k(n3);
    }

    public static int f(long l2) {
        return f.l(l2);
    }

    public static int g(long l2) {
        return f.l(l2);
    }

    public static int h(int n2) {
        if (n2 >= 0) {
            return f.q(n2);
        }
        return 10;
    }

    public static int h(long l2) {
        return 8;
    }

    public static int i(int n2) {
        return 4;
    }

    public static int i(long l2) {
        return 8;
    }

    public static int j(int n2) {
        return f.q(n2);
    }

    public static int j(long l2) {
        return f.l(f.n(l2));
    }

    public static int k(int n2) {
        return f.h(n2);
    }

    public static int l(int n2) {
        return 4;
    }

    public static int l(long l2) {
        if ((-128L & l2) == 0L) {
            return 1;
        }
        if ((-16384L & l2) == 0L) {
            return 2;
        }
        if ((-2097152L & l2) == 0L) {
            return 3;
        }
        if ((-268435456L & l2) == 0L) {
            return 4;
        }
        if ((-34359738368L & l2) == 0L) {
            return 5;
        }
        if ((-4398046511104L & l2) == 0L) {
            return 6;
        }
        if ((-562949953421312L & l2) == 0L) {
            return 7;
        }
        if ((-72057594037927936L & l2) == 0L) {
            return 8;
        }
        if ((l2 & Long.MIN_VALUE) == 0L) {
            return 9;
        }
        return 10;
    }

    public static int m(int n2) {
        return f.q(f.s(n2));
    }

    public static long n(long l2) {
        return l2 >> 63 ^ l2 << 1;
    }

    public static int o(int n2) {
        return f.q(z.a(n2, 0));
    }

    public static int q(int n2) {
        if ((n2 & -128) == 0) {
            return 1;
        }
        if ((n2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & n2) == 0) {
            return 3;
        }
        if ((n2 & -268435456) == 0) {
            return 4;
        }
        return 5;
    }

    public static int s(int n2) {
        return n2 >> 31 ^ n2 << 1;
    }

    public void a() {
        if (this.e != null) {
            this.b();
        }
    }

    public void a(byte by2) {
        if (this.c == this.b) {
            this.b();
        }
        byte[] arrby = this.a;
        int n2 = this.c;
        this.c = n2 + 1;
        arrby[n2] = by2;
        ++this.d;
    }

    public void a(double d2) {
        this.m(Double.doubleToRawLongBits(d2));
    }

    public void a(float f2) {
        this.r(Float.floatToRawIntBits(f2));
    }

    public void a(int n2, double d2) {
        this.f(n2, 1);
        this.a(d2);
    }

    public void a(int n2, float f2) {
        this.f(n2, 5);
        this.a(f2);
    }

    public void a(int n2, int n3) {
        this.f(n2, 0);
        this.b(n3);
    }

    public void a(int n2, long l2) {
        this.f(n2, 0);
        this.e(l2);
    }

    public void a(int n2, d d2) {
        this.f(n2, 2);
        this.a(d2);
    }

    public void a(int n2, q q2) {
        this.f(n2, 3);
        this.a(q2);
        this.f(n2, 4);
    }

    public void a(int n2, boolean bl2) {
        this.f(n2, 0);
        this.a(bl2);
    }

    public void a(long l2) {
        this.k(l2);
    }

    public void a(String arrby) {
        arrby = arrby.getBytes("UTF-8");
        this.p(arrby.length);
        this.c(arrby);
    }

    public void a(d d2) {
        this.p(d2.a());
        this.c(d2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(d d2, int n2, int n3) {
        if (this.b - this.c >= n3) {
            d2.b(this.a, n2, this.c, n3);
            this.c += n3;
        } else {
            int n4 = this.b - this.c;
            d2.b(this.a, n2, this.c, n4);
            n2 += n4;
            this.c = this.b;
            this.d += n4;
            this.b();
            if ((n3 -= n4) <= this.b) {
                d2.b(this.a, n2, 0, n3);
                this.c = n3;
            } else {
                d2.a(this.e, n2, n3);
            }
        }
        this.d += n3;
    }

    public void a(q q2) {
        q2.a(this);
    }

    public void a(boolean bl2) {
        RuntimeException runtimeException;
        super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        throw runtimeException;
    }

    public void a(byte[] arrby) {
        this.p(arrby.length);
        this.c(arrby);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(byte[] arrby, int n2, int n3) {
        if (this.b - this.c >= n3) {
            System.arraycopy(arrby, n2, this.a, this.c, n3);
            this.c += n3;
        } else {
            int n4 = this.b - this.c;
            System.arraycopy(arrby, n2, this.a, this.c, n4);
            n2 += n4;
            this.c = this.b;
            this.d += n4;
            this.b();
            if ((n3 -= n4) <= this.b) {
                System.arraycopy(arrby, n2, this.a, 0, n3);
                this.c = n3;
            } else {
                this.e.write(arrby, n2, n3);
            }
        }
        this.d += n3;
    }

    public void b(int n2) {
        if (n2 >= 0) {
            this.p(n2);
            return;
        }
        this.k(n2);
    }

    public void b(int n2, int n3) {
        this.f(n2, 0);
        this.d(n3);
    }

    public void b(int n2, q q2) {
        this.f(n2, 2);
        this.b(q2);
    }

    public void b(long l2) {
        this.k(l2);
    }

    public void b(q q2) {
        this.p(q2.i());
        q2.a(this);
    }

    public void c(int n2) {
        this.r(n2);
    }

    public void c(int n2, int n3) {
        this.f(n2, 0);
        this.e(n3);
    }

    public void c(int n2, q q2) {
        this.f(1, 3);
        this.b(2, n2);
        this.b(3, q2);
        this.f(1, 4);
    }

    public void c(long l2) {
        this.m(l2);
    }

    public void c(d d2) {
        this.a(d2, 0, d2.a());
    }

    public void c(byte[] arrby) {
        this.a(arrby, 0, arrby.length);
    }

    public void d(int n2) {
        this.p(n2);
    }

    public void d(long l2) {
        this.m(l2);
    }

    public void e(int n2) {
        this.b(n2);
    }

    public void e(long l2) {
        this.k(f.n(l2));
    }

    public void f(int n2) {
        this.r(n2);
    }

    public void f(int n2, int n3) {
        this.p(z.a(n2, n3));
    }

    public void g(int n2) {
        this.p(f.s(n2));
    }

    public void k(long l2) {
        do {
            if ((-128L & l2) == 0L) {
                this.n((int)l2);
                return;
            }
            this.n((int)l2 & 127 | 128);
            l2 >>>= 7;
        } while (true);
    }

    public void m(long l2) {
        this.n((int)l2 & 255);
        this.n((int)(l2 >> 8) & 255);
        this.n((int)(l2 >> 16) & 255);
        this.n((int)(l2 >> 24) & 255);
        this.n((int)(l2 >> 32) & 255);
        this.n((int)(l2 >> 40) & 255);
        this.n((int)(l2 >> 48) & 255);
        this.n((int)(l2 >> 56) & 255);
    }

    public void n(int n2) {
        this.a((byte)n2);
    }

    public void p(int n2) {
        do {
            if ((n2 & -128) == 0) {
                this.n(n2);
                return;
            }
            this.n(n2 & 127 | 128);
            n2 >>>= 7;
        } while (true);
    }

    public void r(int n2) {
        this.n(n2 & 255);
        this.n(n2 >> 8 & 255);
        this.n(n2 >> 16 & 255);
        this.n(n2 >> 24 & 255);
    }

    public static class a
    extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

}

