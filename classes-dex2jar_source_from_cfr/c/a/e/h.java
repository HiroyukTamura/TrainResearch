/*
 * Decompiled with CFR 0.139.
 */
package c.a.e;

import c.a.c;
import c.a.e.d;
import c.a.e.e;
import c.a.e.m;
import d.f;
import d.t;
import d.u;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class h
implements Closeable {
    static final Logger a = Logger.getLogger(e.class.getName());
    final d.a b;
    private final d.e c;
    private final a d;
    private final boolean e;

    h(d.e e2, boolean bl2) {
        this.c = e2;
        this.e = bl2;
        this.d = new a(this.c);
        this.b = new d.a(4096, this.d);
    }

    static int a(int n2, byte by2, short s2) {
        int n3 = n2;
        if ((by2 & 8) != 0) {
            n3 = n2 - 1;
        }
        if (s2 <= n3) {
            return (short)(n3 - s2);
        }
        throw e.b("PROTOCOL_ERROR padding %s > remaining length %s", s2, n3);
    }

    static int a(d.e e2) {
        byte by2 = e2.i();
        byte by3 = e2.i();
        return e2.i() & 255 | ((by2 & 255) << 16 | (by3 & 255) << 8);
    }

    private List<c.a.e.c> a(int n2, short s2, byte by2, int n3) {
        a a2 = this.d;
        this.d.d = n2;
        a2.a = n2;
        this.d.e = s2;
        this.d.b = by2;
        this.d.c = n3;
        this.b.a();
        return this.b.b();
    }

    private void a(b b2, int n2) {
        int n3 = this.c.k();
        boolean bl2 = (Integer.MIN_VALUE & n3) != 0;
        b2.a(n2, n3 & Integer.MAX_VALUE, (this.c.i() & 255) + 1, bl2);
    }

    private void a(b b2, int n2, byte by2, int n3) {
        short s2 = 0;
        if (n3 != 0) {
            boolean bl2 = (by2 & 1) != 0;
            if ((by2 & 8) != 0) {
                s2 = (short)(this.c.i() & 255);
            }
            int n4 = n2;
            if ((by2 & 32) != 0) {
                this.a(b2, n3);
                n4 = n2 - 5;
            }
            b2.a(bl2, n3, -1, this.a(h.a(n4, by2, s2), s2, by2, n3));
            return;
        }
        throw e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    private void b(b b2, int n2, byte by2, int n3) {
        short s2 = 0;
        if (n3 != 0) {
            boolean bl2 = true;
            boolean bl3 = (by2 & 1) != 0;
            if ((by2 & 32) == 0) {
                bl2 = false;
            }
            if (!bl2) {
                if ((by2 & 8) != 0) {
                    s2 = (short)(this.c.i() & 255);
                }
                n2 = h.a(n2, by2, s2);
                b2.a(bl3, n3, this.c, n2);
                this.c.i(s2);
                return;
            }
            throw e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void c(b b2, int n2, byte by2, int n3) {
        if (n2 == 5) {
            if (n3 != 0) {
                this.a(b2, n3);
                return;
            }
            throw e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        throw e.b("TYPE_PRIORITY length: %d != 5", n2);
    }

    private void d(b b2, int n2, byte by2, int n3) {
        if (n2 == 4) {
            if (n3 != 0) {
                n2 = this.c.k();
                c.a.e.b b3 = c.a.e.b.a(n2);
                if (b3 != null) {
                    b2.a(n3, b3);
                    return;
                }
                throw e.b("TYPE_RST_STREAM unexpected error code: %d", n2);
            }
            throw e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        throw e.b("TYPE_RST_STREAM length: %d != 4", n2);
    }

    private void e(b b2, int n2, byte by2, int n3) {
        if (n3 == 0) {
            if ((by2 & 1) != 0) {
                if (n2 == 0) {
                    b2.a();
                    return;
                }
                throw e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            if (n2 % 6 == 0) {
                m m2 = new m();
                for (n3 = 0; n3 < n2; n3 += 6) {
                    int n4 = this.c.j() & 65535;
                    int n5 = this.c.k();
                    by2 = (byte)n4;
                    switch (n4) {
                        default: {
                            by2 = (byte)n4;
                            break;
                        }
                        case 5: {
                            if (n5 >= 16384 && n5 <= 16777215) {
                                by2 = (byte)n4;
                                break;
                            }
                            throw e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", n5);
                        }
                        case 4: {
                            by2 = (byte)7;
                            if (n5 >= 0) break;
                            throw e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        case 3: {
                            by2 = (byte)4;
                            break;
                        }
                        case 2: {
                            by2 = (byte)n4;
                            if (n5 == 0) break;
                            if (n5 == 1) {
                                by2 = (byte)n4;
                                break;
                            }
                            throw e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        case 1: 
                        case 6: 
                    }
                    m2.a(by2, n5);
                }
                b2.a(false, m2);
                return;
            }
            throw e.b("TYPE_SETTINGS length %% 6 != 0: %s", n2);
        }
        throw e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
    }

    private void f(b b2, int n2, byte by2, int n3) {
        short s2 = 0;
        if (n3 != 0) {
            if ((by2 & 8) != 0) {
                s2 = (short)(this.c.i() & 255);
            }
            b2.a(n3, this.c.k() & Integer.MAX_VALUE, this.a(h.a(n2 - 4, by2, s2), s2, by2, n3));
            return;
        }
        throw e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void g(b b2, int n2, byte by2, int n3) {
        boolean bl2 = false;
        if (n2 == 8) {
            if (n3 == 0) {
                n2 = this.c.k();
                n3 = this.c.k();
                if ((by2 & 1) != 0) {
                    bl2 = true;
                }
                b2.a(bl2, n2, n3);
                return;
            }
            throw e.b("TYPE_PING streamId != 0", new Object[0]);
        }
        throw e.b("TYPE_PING length != 8: %s", n2);
    }

    private void h(b b2, int n2, byte by2, int n3) {
        if (n2 >= 8) {
            if (n3 == 0) {
                by2 = (byte)this.c.k();
                n3 = this.c.k();
                n2 -= 8;
                c.a.e.b b3 = c.a.e.b.a(n3);
                if (b3 != null) {
                    f f2 = f.b;
                    if (n2 > 0) {
                        f2 = this.c.d(n2);
                    }
                    b2.a((int)by2, b3, f2);
                    return;
                }
                throw e.b("TYPE_GOAWAY unexpected error code: %d", n3);
            }
            throw e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        throw e.b("TYPE_GOAWAY length < 8: %s", n2);
    }

    private void i(b b2, int n2, byte by2, int n3) {
        if (n2 == 4) {
            long l2 = (long)this.c.k() & Integer.MAX_VALUE;
            if (l2 != 0L) {
                b2.a(n3, l2);
                return;
            }
            throw e.b("windowSizeIncrement was 0", l2);
        }
        throw e.b("TYPE_WINDOW_UPDATE length !=4: %s", n2);
    }

    public void a(b object) {
        if (this.e) {
            if (this.a(true, (b)object)) {
                return;
            }
            throw e.b("Required SETTINGS preface not received", new Object[0]);
        }
        object = this.c.d(e.a.g());
        if (a.isLoggable(Level.FINE)) {
            a.fine(c.a("<< CONNECTION %s", new Object[]{((f)object).e()}));
        }
        if (e.a.equals(object)) {
            return;
        }
        throw e.b("Expected a connection header but was %s", ((f)object).a());
    }

    public boolean a(boolean bl2, b b2) {
        try {
            this.c.a(9L);
        }
        catch (IOException iOException) {
            return false;
        }
        int n2 = h.a(this.c);
        if (n2 >= 0 && n2 <= 16384) {
            byte by2 = (byte)(this.c.i() & 255);
            if (bl2 && by2 != 4) {
                throw e.b("Expected a SETTINGS frame but was %s", by2);
            }
            byte by3 = (byte)(this.c.i() & 255);
            int n3 = this.c.k() & Integer.MAX_VALUE;
            if (a.isLoggable(Level.FINE)) {
                a.fine(e.a(true, n3, n2, by2, by3));
            }
            switch (by2) {
                default: {
                    this.c.i(n2);
                    return true;
                }
                case 8: {
                    this.i(b2, n2, by3, n3);
                    return true;
                }
                case 7: {
                    this.h(b2, n2, by3, n3);
                    return true;
                }
                case 6: {
                    this.g(b2, n2, by3, n3);
                    return true;
                }
                case 5: {
                    this.f(b2, n2, by3, n3);
                    return true;
                }
                case 4: {
                    this.e(b2, n2, by3, n3);
                    return true;
                }
                case 3: {
                    this.d(b2, n2, by3, n3);
                    return true;
                }
                case 2: {
                    this.c(b2, n2, by3, n3);
                    return true;
                }
                case 1: {
                    this.a(b2, n2, by3, n3);
                    return true;
                }
                case 0: 
            }
            this.b(b2, n2, by3, n3);
            return true;
        }
        throw e.b("FRAME_SIZE_ERROR: %s", n2);
    }

    @Override
    public void close() {
        this.c.close();
    }

    static final class a
    implements t {
        int a;
        byte b;
        int c;
        int d;
        short e;
        private final d.e f;

        a(d.e e2) {
            this.f = e2;
        }

        private void b() {
            int n2;
            int n3 = this.c;
            this.d = n2 = h.a(this.f);
            this.a = n2;
            byte by2 = (byte)(this.f.i() & 255);
            this.b = (byte)(this.f.i() & 255);
            if (h.a.isLoggable(Level.FINE)) {
                h.a.fine(e.a(true, this.c, this.a, by2, this.b));
            }
            this.c = this.f.k() & Integer.MAX_VALUE;
            if (by2 == 9) {
                if (this.c == n3) {
                    return;
                }
                throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
            throw e.b("%s != TYPE_CONTINUATION", by2);
        }

        @Override
        public long a(d.c c2, long l2) {
            while (this.d == 0) {
                this.f.i(this.e);
                this.e = 0;
                if ((this.b & 4) != 0) {
                    return -1L;
                }
                this.b();
            }
            if ((l2 = this.f.a(c2, Math.min(l2, (long)this.d))) == -1L) {
                return -1L;
            }
            this.d = (int)((long)this.d - l2);
            return l2;
        }

        @Override
        public u a() {
            return this.f.a();
        }

        @Override
        public void close() {
        }
    }

    static interface b {
        public void a();

        public void a(int var1, int var2, int var3, boolean var4);

        public void a(int var1, int var2, List<c.a.e.c> var3);

        public void a(int var1, long var2);

        public void a(int var1, c.a.e.b var2);

        public void a(int var1, c.a.e.b var2, f var3);

        public void a(boolean var1, int var2, int var3);

        public void a(boolean var1, int var2, int var3, List<c.a.e.c> var4);

        public void a(boolean var1, int var2, d.e var3, int var4);

        public void a(boolean var1, m var2);
    }

}

