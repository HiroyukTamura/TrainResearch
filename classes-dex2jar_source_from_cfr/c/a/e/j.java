/*
 * Decompiled with CFR 0.139.
 */
package c.a.e;

import c.a.c;
import c.a.e.b;
import c.a.e.d;
import c.a.e.e;
import c.a.e.m;
import d.f;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class j
implements Closeable {
    private static final Logger b = Logger.getLogger(e.class.getName());
    final d.b a;
    private final d.d c;
    private final boolean d;
    private final d.c e;
    private int f;
    private boolean g;

    j(d.d d2, boolean bl2) {
        this.c = d2;
        this.d = bl2;
        this.e = new d.c();
        this.a = new d.b(this.e);
        this.f = 16384;
    }

    private static void a(d.d d2, int n2) {
        d2.i(n2 >>> 16 & 255);
        d2.i(n2 >>> 8 & 255);
        d2.i(n2 & 255);
    }

    private void b(int n2, long l2) {
        while (l2 > 0L) {
            int n3;
            long l3;
            byte by2 = (l2 -= (l3 = (long)(n3 = (int)Math.min((long)this.f, l2)))) == 0L ? (byte)4 : 0;
            this.a(n2, n3, (byte)9, by2);
            this.c.a_(this.e, l3);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a() {
        synchronized (this) {
            block5 : {
                if (this.g) throw new IOException("closed");
                boolean bl2 = this.d;
                if (bl2) break block5;
                return;
            }
            if (b.isLoggable(Level.FINE)) {
                b.fine(c.a(">> CONNECTION %s", new Object[]{e.a.e()}));
            }
            this.c.c(e.a.h());
            this.c.flush();
            return;
        }
    }

    void a(int n2, byte by2, d.c c2, int n3) {
        this.a(n2, n3, (byte)0, by2);
        if (n3 > 0) {
            this.c.a_(c2, n3);
        }
    }

    public void a(int n2, int n3, byte by2, byte by3) {
        if (b.isLoggable(Level.FINE)) {
            b.fine(e.a(false, n2, n3, by2, by3));
        }
        if (n3 <= this.f) {
            if ((Integer.MIN_VALUE & n2) == 0) {
                j.a(this.c, n3);
                this.c.i(by2 & 255);
                this.c.i(by3 & 255);
                this.c.g(n2 & Integer.MAX_VALUE);
                return;
            }
            throw e.a("reserved bit set: %s", n2);
        }
        throw e.a("FRAME_SIZE_ERROR length > %d: %d", this.f, n3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n2, int n3, List<c.a.e.c> list) {
        synchronized (this) {
            if (this.g) {
                throw new IOException("closed");
            }
            this.a.a(list);
            long l2 = this.e.b();
            int n4 = (int)Math.min((long)(this.f - 4), l2);
            long l3 = n4;
            long l4 = l2 LCMP l3;
            byte by2 = l4 == false ? (byte)4 : 0;
            this.a(n2, n4 + 4, (byte)5, by2);
            this.c.g(n3 & Integer.MAX_VALUE);
            this.c.a_(this.e, l3);
            if (l4 > 0) {
                this.b(n2, l2 - l3);
            }
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(int n2, long l2) {
        synchronized (this) {
            if (this.g) throw new IOException("closed");
            if (l2 == 0L || l2 > Integer.MAX_VALUE) throw e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", l2);
            this.a(n2, 4, (byte)8, (byte)0);
            this.c.g((int)l2);
            this.c.flush();
            return;
        }
    }

    public void a(int n2, b b2) {
        synchronized (this) {
            if (!this.g) {
                if (b2.l != -1) {
                    this.a(n2, 4, (byte)3, (byte)0);
                    this.c.g(b2.l);
                    this.c.flush();
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IOException("closed");
        }
    }

    public void a(int n2, b b2, byte[] arrby) {
        synchronized (this) {
            if (!this.g) {
                if (b2.l != -1) {
                    this.a(0, arrby.length + 8, (byte)7, (byte)0);
                    this.c.g(n2);
                    this.c.g(b2.l);
                    if (arrby.length > 0) {
                        this.c.c(arrby);
                    }
                    this.c.flush();
                    return;
                }
                throw e.a("errorCode.httpCode == -1", new Object[0]);
            }
            throw new IOException("closed");
        }
    }

    public void a(m m2) {
        synchronized (this) {
            if (!this.g) {
                this.f = m2.d(this.f);
                if (m2.c() != -1) {
                    this.a.a(m2.c());
                }
                this.a(0, 0, (byte)4, (byte)1);
                this.c.flush();
                return;
            }
            throw new IOException("closed");
        }
    }

    public void a(boolean bl2, int n2, int n3) {
        RuntimeException runtimeException;
        super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        throw runtimeException;
    }

    public void a(boolean bl2, int n2, int n3, List<c.a.e.c> list) {
        synchronized (this) {
            if (!this.g) {
                this.a(bl2, n2, list);
                return;
            }
            throw new IOException("closed");
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(boolean bl2, int n2, d.c c2, int n3) {
        synchronized (this) {
            byte by2;
            block4 : {
                if (this.g) throw new IOException("closed");
                by2 = 0;
                if (!bl2) break block4;
                by2 = (byte)(true ? 1 : 0);
            }
            this.a(n2, by2, c2, n3);
            return;
        }
    }

    void a(boolean bl2, int n2, List<c.a.e.c> list) {
        if (!this.g) {
            this.a.a(list);
            long l2 = this.e.b();
            int n3 = (int)Math.min((long)this.f, l2);
            long l3 = n3;
            long l4 = l2 LCMP l3;
            byte by2 = l4 == false ? (byte)4 : 0;
            byte by3 = by2;
            if (bl2) {
                by3 = (byte)(by2 | 1);
            }
            this.a(n2, n3, (byte)1, by3);
            this.c.a_(this.e, l3);
            if (l4 > 0) {
                this.b(n2, l2 - l3);
            }
            return;
        }
        throw new IOException("closed");
    }

    public void b() {
        synchronized (this) {
            if (!this.g) {
                this.c.flush();
                return;
            }
            throw new IOException("closed");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(m m2) {
        synchronized (this) {
            if (this.g) {
                throw new IOException("closed");
            }
            int n2 = m2.b();
            int n3 = 0;
            this.a(0, n2 * 6, (byte)4, (byte)0);
            do {
                if (n3 >= 10) {
                    this.c.flush();
                    return;
                }
                if (m2.a(n3)) {
                    n2 = n3 == 4 ? 3 : (n3 == 7 ? 4 : n3);
                    this.c.h(n2);
                    this.c.g(m2.b(n3));
                }
                ++n3;
            } while (true);
        }
    }

    public int c() {
        return this.f;
    }

    @Override
    public void close() {
        synchronized (this) {
            this.g = true;
            this.c.close();
            return;
        }
    }
}

