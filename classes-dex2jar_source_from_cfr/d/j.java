/*
 * Decompiled with CFR 0.139.
 */
package d;

import d.c;
import d.e;
import d.k;
import d.l;
import d.p;
import d.t;
import d.u;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class j
implements t {
    private int a = 0;
    private final e b;
    private final Inflater c;
    private final k d;
    private final CRC32 e = new CRC32();

    public j(t t2) {
        if (t2 != null) {
            this.c = new Inflater(true);
            this.b = l.a(t2);
            this.d = new k(this.b, this.c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void a(c object, long l2, long l3) {
        object = ((c)object).a;
        while (l2 >= (long)(((p)object).c - ((p)object).b)) {
            l2 -= (long)(((p)object).c - ((p)object).b);
            object = ((p)object).f;
        }
        while (l3 > 0L) {
            int n2 = (int)((long)((p)object).b + l2);
            int n3 = (int)Math.min((long)(((p)object).c - n2), l3);
            this.e.update(((p)object).a, n2, n3);
            l3 -= (long)n3;
            object = ((p)object).f;
            l2 = 0L;
        }
    }

    private void a(String string2, int n2, int n3) {
        if (n3 == n2) {
            return;
        }
        throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", string2, n3, n2));
    }

    private void b() {
        long l2;
        this.b.a(10L);
        byte by2 = this.b.c().c(3L);
        boolean bl2 = (by2 >> 1 & 1) == 1;
        if (bl2) {
            this.a(this.b.c(), 0L, 10L);
        }
        this.a("ID1ID2", 8075, this.b.j());
        this.b.i(8L);
        if ((by2 >> 2 & 1) == 1) {
            this.b.a(2L);
            if (bl2) {
                this.a(this.b.c(), 0L, 2L);
            }
            short s2 = this.b.c().l();
            e e2 = this.b;
            l2 = s2;
            e2.a(l2);
            if (bl2) {
                this.a(this.b.c(), 0L, l2);
            }
            this.b.i(l2);
        }
        if ((by2 >> 3 & 1) == 1) {
            l2 = this.b.a((byte)0);
            if (l2 != -1L) {
                if (bl2) {
                    this.a(this.b.c(), 0L, l2 + 1L);
                }
                this.b.i(l2 + 1L);
            } else {
                throw new EOFException();
            }
        }
        if ((by2 >> 4 & 1) == 1) {
            l2 = this.b.a((byte)0);
            if (l2 != -1L) {
                if (bl2) {
                    this.a(this.b.c(), 0L, l2 + 1L);
                }
                this.b.i(l2 + 1L);
            } else {
                throw new EOFException();
            }
        }
        if (bl2) {
            this.a("FHCRC", this.b.l(), (short)this.e.getValue());
            this.e.reset();
        }
    }

    private void c() {
        this.a("CRC", this.b.m(), (int)this.e.getValue());
        this.a("ISIZE", this.b.m(), (int)this.c.getBytesWritten());
    }

    @Override
    public long a(c object, long l2) {
        long l3 = l2 LCMP 0L;
        if (l3 >= 0) {
            if (l3 == false) {
                return 0L;
            }
            if (this.a == 0) {
                this.b();
                this.a = 1;
            }
            if (this.a == 1) {
                long l4 = ((c)object).b;
                if ((l2 = this.d.a((c)object, l2)) != -1L) {
                    this.a((c)object, l4, l2);
                    return l2;
                }
                this.a = 2;
            }
            if (this.a == 2) {
                this.c();
                this.a = 3;
                if (this.b.f()) {
                    return -1L;
                }
                throw new IOException("gzip finished without exhausting source");
            }
            return -1L;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount < 0: ");
        ((StringBuilder)object).append(l2);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    @Override
    public u a() {
        return this.b.a();
    }

    @Override
    public void close() {
        this.d.close();
    }
}

