/*
 * Decompiled with CFR 0.139.
 */
package c.a.b;

import c.a.b.d;
import c.a.b.e;
import c.a.b.f;
import c.a.c;
import c.a.e.b;
import c.a.e.n;
import c.ae;
import c.i;
import c.j;
import c.p;
import c.u;
import c.x;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

public final class g {
    static final /* synthetic */ boolean d;
    public final c.a a;
    public final c.e b;
    public final p c;
    private f.a e;
    private ae f;
    private final j g;
    private final Object h;
    private final f i;
    private int j;
    private c.a.b.c k;
    private boolean l;
    private boolean m;
    private boolean n;
    private c.a.c.c o;

    static {
        d = g.class.desiredAssertionStatus() ^ true;
    }

    public g(j j2, c.a a2, c.e e2, p p2, Object object) {
        this.g = j2;
        this.a = a2;
        this.b = e2;
        this.c = p2;
        this.i = new f(a2, this.i(), e2, p2);
        this.h = object;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private c.a.b.c a(int var1_1, int var2_2, int var3_3, int var4_4, boolean var5_5) {
        block27 : {
            block28 : {
                block25 : {
                    block26 : {
                        var14_6 = this.g;
                        // MONITORENTER : var14_6
                        if (this.m != false) throw new IllegalStateException("released");
                        if (this.o != null) throw new IllegalStateException("codec != null");
                        if (this.n != false) throw new IOException("Canceled");
                        var11_7 = this.k;
                        var15_8 = this.h();
                        var10_9 = this.k;
                        var13_10 = null;
                        if (var10_9 != null) {
                            var10_9 = this.k;
                            var11_7 = null;
                        } else {
                            var10_9 = null;
                        }
                        var12_11 = var11_7;
                        if (!this.l) {
                            var12_11 = null;
                        }
                        if (var10_9 != null) break block25;
                        c.a.a.a.a(this.g, this.a, this, null);
                        if (this.k == null) break block26;
                        var10_9 = this.k;
                        var11_7 = null;
                        var6_12 = true;
                        break block27;
                    }
                    var11_7 = this.f;
                    break block28;
                }
                var11_7 = null;
            }
            var6_12 = false;
        }
        // MONITOREXIT : var14_6
        c.a((Socket)var15_8);
        if (var12_11 != null) {
            this.c.b(this.b, (i)var12_11);
        }
        if (var6_12) {
            this.c.a(this.b, (i)var10_9);
        }
        if (var10_9 != null) {
            return var10_9;
        }
        if (!(var11_7 != null || this.e != null && this.e.a())) {
            this.e = this.i.b();
            var8_13 = 1;
        } else {
            var8_13 = 0;
        }
        var14_6 = this.g;
        // MONITORENTER : var14_6
        if (this.n != false) throw new IOException("Canceled");
        var7_14 = var6_12;
        var12_11 = var10_9;
        if (var8_13 == 0) ** GOTO lbl65
        var15_8 = this.e.c();
        var9_15 = var15_8.size();
        var8_13 = 0;
        do {
            block30 : {
                block29 : {
                    var7_14 = var6_12;
                    var12_11 = var10_9;
                    if (var8_13 >= var9_15) break block29;
                    var16_16 = (ae)var15_8.get(var8_13);
                    c.a.a.a.a(this.g, this.a, this, var16_16);
                    if (this.k == null) break block30;
                    var12_11 = this.k;
                    this.f = var16_16;
                    var7_14 = true;
                }
                var10_9 = var12_11;
                if (!var7_14) {
                    var10_9 = var11_7;
                    if (var11_7 == null) {
                        var10_9 = this.e.b();
                    }
                    this.f = var10_9;
                    this.j = 0;
                    var10_9 = new c.a.b.c(this.g, (ae)var10_9);
                    this.a((c.a.b.c)var10_9, false);
                }
                // MONITOREXIT : var14_6
                if (!var7_14) {
                    var10_9.a(var1_1, var2_2, var3_3, var4_4, var5_5, this.b, this.c);
                    this.i().b(var10_9.a());
                    var14_6 = this.g;
                    // MONITORENTER : var14_6
                    this.l = true;
                    c.a.a.a.b(this.g, (c.a.b.c)var10_9);
                    var12_11 = var13_10;
                    var11_7 = var10_9;
                    if (var10_9.e()) {
                        var12_11 = c.a.a.a.a(this.g, this.a, this);
                        var11_7 = this.k;
                    }
                    // MONITOREXIT : var14_6
                    c.a((Socket)var12_11);
                    var10_9 = var11_7;
                }
                this.c.a(this.b, (i)var10_9);
                return var10_9;
            }
            ++var8_13;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private c.a.b.c a(int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
        do {
            c.a.b.c c2 = this.a(n2, n3, n4, n5, bl2);
            j j2 = this.g;
            // MONITORENTER : j2
            if (c2.b == 0) {
                // MONITOREXIT : j2
                return c2;
            }
            // MONITOREXIT : j2
            if (c2.a(bl3)) return c2;
            this.e();
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private Socket a(boolean var1_1, boolean var2_2, boolean var3_3) {
        if (!g.d) {
            if (Thread.holdsLock(this.g) == false) throw new AssertionError();
        }
        if (var3_3) {
            this.o = null;
        }
        if (var2_2) {
            this.m = true;
        }
        if (this.k == null) return null;
        if (var1_1) {
            this.k.a = true;
        }
        if (this.o != null) return null;
        if (!this.m) {
            if (this.k.a == false) return null;
        }
        this.b(this.k);
        if (!this.k.d.isEmpty()) ** GOTO lbl-1000
        this.k.e = System.nanoTime();
        if (c.a.a.a.a(this.g, this.k)) {
            var4_4 = this.k.c();
        } else lbl-1000: // 2 sources:
        {
            var4_4 = null;
        }
        this.k = null;
        return var4_4;
    }

    private void b(c.a.b.c c2) {
        int n2 = c2.d.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (c2.d.get(i2).get() != this) continue;
            c2.d.remove(i2);
            return;
        }
        throw new IllegalStateException();
    }

    private Socket h() {
        if (!d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        }
        c.a.b.c c2 = this.k;
        if (c2 != null && c2.a) {
            return this.a(false, false, true);
        }
        return null;
    }

    private d i() {
        return c.a.a.a.a(this.g);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public c.a.c.c a() {
        j j2 = this.g;
        synchronized (j2) {
            return this.o;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public c.a.c.c a(x object, u.a object2, boolean bl2) {
        int n2 = object2.b();
        int n3 = object2.c();
        int n4 = object2.d();
        int n5 = ((x)object).d();
        boolean bl3 = ((x)object).s();
        try {
            object2 = this.a(n2, n3, n4, n5, bl3, bl2).a((x)object, (u.a)object2, this);
            object = this.g;
            synchronized (object) {
                this.o = object2;
            }
        }
        catch (IOException iOException) {
            throw new e(iOException);
        }
        return object2;
    }

    public Socket a(c.a.b.c c2) {
        if (!d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        }
        if (this.o == null && this.k.d.size() == 1) {
            Reference<g> reference = this.k.d.get(0);
            Socket socket = this.a(true, false, false);
            this.k = c2;
            c2.d.add(reference);
            return socket;
        }
        throw new IllegalStateException();
    }

    public void a(c.a.b.c c2, boolean bl2) {
        if (!d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        }
        if (this.k == null) {
            this.k = c2;
            this.l = bl2;
            c2.d.add(new a(this, this.h));
            return;
        }
        throw new IllegalStateException();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(IOException object) {
        Socket socket;
        j j2 = this.g;
        synchronized (j2) {
            boolean bl2;
            block14 : {
                block11 : {
                    block13 : {
                        block12 : {
                            block10 : {
                                if (!(object instanceof n)) break block10;
                                object = (n)object;
                                if (((n)object).a == b.e) {
                                    ++this.j;
                                }
                                if (((n)object).a == b.e && this.j <= 1) break block11;
                                break block12;
                            }
                            if (this.k == null || this.k.e() && !(object instanceof c.a.e.a)) break block11;
                            if (this.k.b != 0) break block13;
                            if (this.f != null && object != null) {
                                this.i.a(this.f, (IOException)object);
                            }
                        }
                        this.f = null;
                    }
                    bl2 = true;
                    break block14;
                }
                bl2 = false;
            }
            object = this.k;
            socket = this.a(bl2, false, true);
            if (this.k != null || !this.l) {
                object = null;
            }
        }
        c.a(socket);
        if (object != null) {
            this.c.b(this.b, (i)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2, c.a.c.c object, long l2, IOException serializable) {
        this.c.b(this.b, l2);
        j j2 = this.g;
        synchronized (j2) {
            block10 : {
                if (object != null) {
                    if (object != this.o) break block10;
                    if (!bl2) {
                        object = this.k;
                        ++((c.a.b.c)object).b;
                    }
                    object = this.k;
                    Socket socket = this.a(bl2, false, true);
                    if (this.k != null) {
                        object = null;
                    }
                    bl2 = this.m;
                    // MONITOREXIT [0, 2, 9] lbl15 : MonitorExitStatement: MONITOREXIT : var6_6
                    c.a(socket);
                    if (object != null) {
                        this.c.b(this.b, (i)object);
                    }
                    if (serializable != null) {
                        this.c.a(this.b, (IOException)serializable);
                        return;
                    }
                    if (bl2) {
                        this.c.g(this.b);
                    }
                    return;
                }
            }
            try {
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append("expected ");
                ((StringBuilder)serializable).append(this.o);
                ((StringBuilder)serializable).append(" but was ");
                ((StringBuilder)serializable).append(object);
                throw new IllegalStateException(((StringBuilder)serializable).toString());
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public ae b() {
        return this.f;
    }

    public c.a.b.c c() {
        synchronized (this) {
            c.a.b.c c2 = this.k;
            return c2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d() {
        Socket socket;
        c.a.b.c c2;
        j j2 = this.g;
        synchronized (j2) {
            c2 = this.k;
            socket = this.a(false, true, false);
            if (this.k != null) {
                c2 = null;
            }
        }
        c.a(socket);
        if (c2 != null) {
            this.c.b(this.b, c2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e() {
        Socket socket;
        c.a.b.c c2;
        j j2 = this.g;
        synchronized (j2) {
            c2 = this.k;
            socket = this.a(true, false, false);
            if (this.k != null) {
                c2 = null;
            }
        }
        c.a(socket);
        if (c2 != null) {
            this.c.b(this.b, c2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void f() {
        j j2 = this.g;
        // MONITORENTER : j2
        this.n = true;
        c.a.c.c c2 = this.o;
        c.a.b.c c3 = this.k;
        // MONITOREXIT : j2
        if (c2 != null) {
            c2.c();
            return;
        }
        if (c3 == null) return;
        c3.b();
    }

    public boolean g() {
        return this.f != null || this.e != null && this.e.a() || this.i.a();
        {
        }
    }

    public String toString() {
        c.a.b.c c2 = this.c();
        if (c2 != null) {
            return c2.toString();
        }
        return this.a.toString();
    }

    public static final class a
    extends WeakReference<g> {
        public final Object a;

        a(g g2, Object object) {
            super(g2);
            this.a = object;
        }
    }

}

