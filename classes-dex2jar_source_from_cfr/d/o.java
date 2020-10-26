/*
 * Decompiled with CFR 0.139.
 */
package d;

import d.c;
import d.e;
import d.f;
import d.m;
import d.s;
import d.t;
import d.u;
import d.v;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class o
implements e {
    public final c a = new c();
    public final t b;
    boolean c;

    o(t t2) {
        if (t2 != null) {
            this.b = t2;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override
    public int a(m m2) {
        if (!this.c) {
            int n2;
            block3 : {
                do {
                    if ((n2 = this.a.a(m2, true)) == -1) {
                        return -1;
                    }
                    if (n2 != -2) break block3;
                } while (this.b.a(this.a, 8192L) != -1L);
                return -1;
            }
            int n3 = m2.a[n2].g();
            this.a.i((long)n3);
            return n2;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public long a(byte by2) {
        return this.a(by2, 0L, Long.MAX_VALUE);
    }

    public long a(byte by2, long l2, long l3) {
        if (!this.c) {
            if (l2 >= 0L && l3 >= l2) {
                while (l2 < l3) {
                    long l4 = this.a.a(by2, l2, l3);
                    if (l4 != -1L) {
                        return l4;
                    }
                    l4 = this.a.b;
                    if (l4 >= l3) break;
                    if (this.b.a(this.a, 8192L) == -1L) {
                        return -1L;
                    }
                    l2 = Math.max(l2, l4);
                }
                return -1L;
            }
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", l2, l3));
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public long a(c object, long l2) {
        if (object != null) {
            if (l2 >= 0L) {
                if (!this.c) {
                    if (this.a.b == 0L && this.b.a(this.a, 8192L) == -1L) {
                        return -1L;
                    }
                    l2 = Math.min(l2, this.a.b);
                    return this.a.a((c)object, l2);
                }
                throw new IllegalStateException("closed");
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("byteCount < 0: ");
            ((StringBuilder)object).append(l2);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        throw new IllegalArgumentException("sink == null");
    }

    public long a(f f2, long l2) {
        if (!this.c) {
            do {
                long l3;
                if ((l3 = this.a.a(f2, l2)) != -1L) {
                    return l3;
                }
                l3 = this.a.b;
                if (this.b.a(this.a, 8192L) == -1L) {
                    return -1L;
                }
                l2 = Math.max(l2, l3 - (long)f2.g() + 1L);
            } while (true);
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public long a(s s2) {
        if (s2 != null) {
            long l2;
            long l3 = 0L;
            while (this.b.a(this.a, 8192L) != -1L) {
                l2 = this.a.h();
                if (l2 <= 0L) continue;
                l3 += l2;
                s2.a_(this.a, l2);
            }
            l2 = l3;
            if (this.a.b() > 0L) {
                l2 = l3 + this.a.b();
                s2.a_(this.a, this.a.b());
            }
            return l2;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override
    public u a() {
        return this.b.a();
    }

    @Override
    public String a(Charset charset) {
        if (charset != null) {
            this.a.a(this.b);
            return this.a.a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override
    public void a(long l2) {
        if (this.b(l2)) {
            return;
        }
        throw new EOFException();
    }

    @Override
    public void a(byte[] arrby) {
        try {
            this.a(arrby.length);
            this.a.a(arrby);
            return;
        }
        catch (EOFException eOFException) {
            int n2 = 0;
            while (this.a.b > 0L) {
                int n3 = this.a.a(arrby, n2, (int)this.a.b);
                if (n3 != -1) {
                    n2 += n3;
                    continue;
                }
                throw new AssertionError();
            }
            throw eOFException;
        }
    }

    @Override
    public boolean a(long l2, f f2) {
        return this.a(l2, f2, 0, f2.g());
    }

    public boolean a(long l2, f f2, int n2, int n3) {
        if (!this.c) {
            if (l2 >= 0L && n2 >= 0 && n3 >= 0) {
                if (f2.g() - n2 < n3) {
                    return false;
                }
                for (int i2 = 0; i2 < n3; ++i2) {
                    long l3 = (long)i2 + l2;
                    if (!this.b(1L + l3)) {
                        return false;
                    }
                    if (this.a.c(l3) == f2.a(n2 + i2)) continue;
                    return false;
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public long b(f f2) {
        return this.a(f2, 0L);
    }

    public long b(f f2, long l2) {
        if (!this.c) {
            do {
                long l3;
                if ((l3 = this.a.b(f2, l2)) != -1L) {
                    return l3;
                }
                l3 = this.a.b;
                if (this.b.a(this.a, 8192L) == -1L) {
                    return -1L;
                }
                l2 = Math.max(l2, l3);
            } while (true);
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public boolean b(long l2) {
        if (l2 >= 0L) {
            if (!this.c) {
                while (this.a.b < l2) {
                    if (this.b.a(this.a, 8192L) != -1L) continue;
                    return false;
                }
                return true;
            }
            throw new IllegalStateException("closed");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("byteCount < 0: ");
        stringBuilder.append(l2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Override
    public long c(f f2) {
        return this.b(f2, 0L);
    }

    @Override
    public c c() {
        return this.a;
    }

    @Override
    public void close() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.a.s();
    }

    @Override
    public c d() {
        return this.a;
    }

    @Override
    public f d(long l2) {
        this.a(l2);
        return this.a.d(l2);
    }

    @Override
    public String f(long l2) {
        if (l2 >= 0L) {
            long l3 = l2 == Long.MAX_VALUE ? Long.MAX_VALUE : l2 + 1L;
            long l4 = this.a((byte)10, 0L, l3);
            if (l4 != -1L) {
                return this.a.g(l4);
            }
            if (l3 < Long.MAX_VALUE && this.b(l3) && this.a.c(l3 - 1L) == 13 && this.b(1L + l3) && this.a.c(l3) == 10) {
                return this.a.g(l3);
            }
            c c2 = new c();
            this.a.a(c2, 0L, Math.min(32L, this.a.b()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\\n not found: limit=");
            stringBuilder.append(Math.min(this.a.b(), l2));
            stringBuilder.append(" content=");
            stringBuilder.append(c2.o().e());
            stringBuilder.append('\u2026');
            throw new EOFException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("limit < 0: ");
        stringBuilder.append(l2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Override
    public boolean f() {
        if (!this.c) {
            return this.a.f() && this.b.a(this.a, 8192L) == -1L;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public InputStream g() {
        return new InputStream(){

            @Override
            public int available() {
                if (!o.this.c) {
                    return (int)Math.min(o.this.a.b, Integer.MAX_VALUE);
                }
                throw new IOException("closed");
            }

            @Override
            public void close() {
                o.this.close();
            }

            @Override
            public int read() {
                if (!o.this.c) {
                    if (o.this.a.b == 0L && o.this.b.a(o.this.a, 8192L) == -1L) {
                        return -1;
                    }
                    return o.this.a.i() & 255;
                }
                throw new IOException("closed");
            }

            @Override
            public int read(byte[] arrby, int n2, int n3) {
                if (!o.this.c) {
                    v.a(arrby.length, n2, n3);
                    if (o.this.a.b == 0L && o.this.b.a(o.this.a, 8192L) == -1L) {
                        return -1;
                    }
                    return o.this.a.a(arrby, n2, n3);
                }
                throw new IOException("closed");
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(o.this);
                stringBuilder.append(".inputStream()");
                return stringBuilder.toString();
            }
        };
    }

    @Override
    public byte[] h(long l2) {
        this.a(l2);
        return this.a.h(l2);
    }

    @Override
    public byte i() {
        this.a(1L);
        return this.a.i();
    }

    @Override
    public void i(long l2) {
        if (!this.c) {
            while (l2 > 0L) {
                if (this.a.b == 0L && this.b.a(this.a, 8192L) == -1L) {
                    throw new EOFException();
                }
                long l3 = Math.min(l2, this.a.b());
                this.a.i(l3);
                l2 -= l3;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public boolean isOpen() {
        return this.c ^ true;
    }

    @Override
    public short j() {
        this.a(2L);
        return this.a.j();
    }

    @Override
    public int k() {
        this.a(4L);
        return this.a.k();
    }

    @Override
    public short l() {
        this.a(2L);
        return this.a.l();
    }

    @Override
    public int m() {
        this.a(4L);
        return this.a.m();
    }

    @Override
    public long n() {
        int n2;
        this.a(1L);
        int n3 = 0;
        while (this.b(n2 = n3 + 1)) {
            byte by2 = this.a.c((long)n3);
            if (by2 >= 48 && by2 <= 57 || by2 >= 97 && by2 <= 102 || by2 >= 65 && by2 <= 70) {
                n3 = n2;
                continue;
            }
            if (n3 != 0) break;
            throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", by2));
        }
        return this.a.n();
    }

    @Override
    public String p() {
        this.a.a(this.b);
        return this.a.p();
    }

    @Override
    public String q() {
        return this.f(Long.MAX_VALUE);
    }

    @Override
    public int read(ByteBuffer byteBuffer) {
        if (this.a.b == 0L && this.b.a(this.a, 8192L) == -1L) {
            return -1;
        }
        return this.a.read(byteBuffer);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

}

