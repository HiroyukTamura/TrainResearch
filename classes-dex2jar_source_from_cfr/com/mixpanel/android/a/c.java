/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 */
package com.mixpanel.android.a;

import android.annotation.SuppressLint;
import com.mixpanel.android.a.a;
import com.mixpanel.android.a.b.a;
import com.mixpanel.android.a.b.e;
import com.mixpanel.android.a.c.g;
import com.mixpanel.android.a.d;
import com.mixpanel.android.a.d.d;
import com.mixpanel.android.a.e.f;
import com.mixpanel.android.a.f.b;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@SuppressLint(value={"Assert"})
public class c
implements com.mixpanel.android.a.a {
    public static int a;
    public static boolean b;
    public static final List<a> c;
    static final /* synthetic */ boolean h;
    public SelectionKey d;
    public ByteChannel e;
    public final BlockingQueue<ByteBuffer> f;
    public final BlockingQueue<ByteBuffer> g;
    private volatile boolean i = false;
    private a.a j = a.a.a;
    private final d k;
    private List<a> l;
    private a m = null;
    private a.b n;
    private d.a o = null;
    private ByteBuffer p = ByteBuffer.allocate(0);
    private com.mixpanel.android.a.e.a q = null;
    private String r = null;
    private Integer s = null;
    private Boolean t = null;
    private String u = null;

    static {
        h = c.class.desiredAssertionStatus() ^ true;
        a = 16384;
        b = false;
        c = new ArrayList<a>(4);
        c.add(new com.mixpanel.android.a.b.c());
        c.add(new com.mixpanel.android.a.b.b());
        c.add(new e());
        c.add(new com.mixpanel.android.a.b.d());
    }

    public c(d d2, a a2) {
        if (d2 != null && (a2 != null || this.n != a.b.b)) {
            this.f = new LinkedBlockingQueue<ByteBuffer>();
            this.g = new LinkedBlockingQueue<ByteBuffer>();
            this.k = d2;
            this.n = a.b.a;
            if (a2 != null) {
                this.m = a2.c();
            }
            return;
        }
        throw new IllegalArgumentException("parameters must not be null");
    }

    private void a(f f2) {
        if (b) {
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("open using draft: ");
            stringBuilder.append(this.m.getClass().getSimpleName());
            printStream.println(stringBuilder.toString());
        }
        this.j = a.a.c;
        try {
            this.k.a((com.mixpanel.android.a.a)this, f2);
            return;
        }
        catch (RuntimeException runtimeException) {
            this.k.a((com.mixpanel.android.a.a)this, runtimeException);
            return;
        }
    }

    private void a(Collection<com.mixpanel.android.a.d.d> object) {
        if (this.c()) {
            object = object.iterator();
            while (object.hasNext()) {
                this.a((com.mixpanel.android.a.d.d)object.next());
            }
            return;
        }
        throw new g();
    }

    private void a(List<ByteBuffer> object) {
        object = object.iterator();
        while (object.hasNext()) {
            this.e((ByteBuffer)object.next());
        }
    }

    /*
     * Exception decompiling
     */
    private boolean b(ByteBuffer var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 3[TRYBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void c(int n2, String string2, boolean bl2) {
        block16 : {
            block14 : {
                block15 : {
                    if (this.j == a.a.d) return;
                    if (this.j == a.a.e) return;
                    if (this.j != a.a.c) break block14;
                    if (n2 == 1006) {
                        if (!h) {
                            if (bl2) throw new AssertionError();
                        }
                        this.j = a.a.d;
                        this.b(n2, string2, false);
                        return;
                    }
                    if (this.m.b() != a.a.a) {
                        com.mixpanel.android.a.c.b b2222;
                        block13 : {
                            block12 : {
                                if (!bl2) {
                                    try {
                                        this.k.a((com.mixpanel.android.a.a)this, n2, string2);
                                        break block12;
                                    }
                                    catch (com.mixpanel.android.a.c.b b2222) {
                                        break block13;
                                    }
                                    catch (RuntimeException runtimeException) {
                                        this.k.a((com.mixpanel.android.a.a)this, runtimeException);
                                    }
                                }
                            }
                            this.a(new com.mixpanel.android.a.d.b(n2, string2));
                            break block15;
                        }
                        this.k.a((com.mixpanel.android.a.a)this, b2222);
                        this.b(1006, "generated frame is invalid", false);
                    }
                }
                this.b(n2, string2, bl2);
                break block16;
            }
            if (n2 == -3) {
                if (!h) {
                    if (!bl2) throw new AssertionError();
                }
                this.b(-3, string2, true);
            } else {
                this.b(-1, string2, false);
            }
        }
        if (n2 == 1002) {
            this.b(n2, string2, bl2);
        }
        this.j = a.a.d;
        this.p = null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void c(ByteBuffer var1_1) {
        try {
            var5_6 = this.m.c((ByteBuffer)var1_1 /* !! */ ).iterator();
            while (var5_6.hasNext() != false) {
                var4_10 = var5_6.next();
                if (c.b) {
                    var1_1 /* !! */  = System.out;
                    var6_15 /* !! */  = new StringBuilder();
                    var6_15 /* !! */ .append("matched frame: ");
                    var6_15 /* !! */ .append(var4_10);
                    var1_1 /* !! */ .println(var6_15 /* !! */ .toString());
                }
                var1_1 /* !! */  = var4_10.f();
                var3_8 = var4_10.d();
                if (var1_1 /* !! */  == d.a.f) {
                    var2_7 = 1005;
                    var1_1 /* !! */  = "";
                    if (var4_10 instanceof com.mixpanel.android.a.d.a) {
                        var1_1 /* !! */  = (com.mixpanel.android.a.d.a)var4_10;
                        var2_7 = var1_1 /* !! */ .a();
                        var1_1 /* !! */  = var1_1 /* !! */ .b();
                    }
                    if (this.j == a.a.d) {
                        this.a(var2_7, (String)var1_1 /* !! */ , true);
                        continue;
                    }
                    if (this.m.b() == a.a.c) {
                        this.c(var2_7, (String)var1_1 /* !! */ , true);
                        continue;
                    }
                    this.b(var2_7, (String)var1_1 /* !! */ , false);
                    continue;
                }
                if (var1_1 /* !! */  == d.a.d) {
                    this.k.b(this, var4_10);
                    continue;
                }
                if (var1_1 /* !! */  == d.a.e) {
                    this.k.c(this, var4_10);
                    continue;
                }
                if (!var3_8 || var1_1 /* !! */  == d.a.a) ** GOTO lbl53
                if (this.o != null) throw new com.mixpanel.android.a.c.b(1002, "Continuous frame sequence not completed.");
                var6_15 /* !! */  = d.a.b;
                if (var1_1 /* !! */  != var6_15 /* !! */ ) ** GOTO lbl44
                try {
                    this.k.a((com.mixpanel.android.a.a)this, b.a(var4_10.c()));
                }
                catch (RuntimeException var1_2) {
                    block22 : {
                        var4_11 = this.k;
                        break block22;
lbl44: // 1 sources:
                        var6_15 /* !! */  = d.a.c;
                        if (var1_1 /* !! */  != var6_15 /* !! */ ) throw new com.mixpanel.android.a.c.b(1002, "non control or continious frame expected");
                        try {
                            this.k.a((com.mixpanel.android.a.a)this, var4_10.c());
                            continue;
                        }
                        catch (RuntimeException var1_3) {
                            var4_13 = this.k;
                            break block22;
                        }
lbl53: // 1 sources:
                        if (var1_1 /* !! */  != d.a.a) {
                            if (this.o != null) throw new com.mixpanel.android.a.c.b(1002, "Previous continuous frame sequence not completed.");
                            this.o = var1_1 /* !! */ ;
                        } else if (var3_8) {
                            if (this.o == null) throw new com.mixpanel.android.a.c.b(1002, "Continuous frame sequence was not started.");
                            this.o = null;
                        } else {
                            var1_1 /* !! */  = this.o;
                            if (var1_1 /* !! */  == null) throw new com.mixpanel.android.a.c.b(1002, "Continuous frame sequence was not started.");
                        }
                        try {
                            this.k.a((com.mixpanel.android.a.a)this, var4_10);
                            continue;
                        }
                        catch (RuntimeException var1_4) {
                            var4_14 = this.k;
                        }
                    }
                    var4_12.a((com.mixpanel.android.a.a)this, (Exception)var1_1 /* !! */ );
                }
            }
            return;
        }
        catch (com.mixpanel.android.a.c.b var1_5) {
            this.k.a((com.mixpanel.android.a.a)this, var1_5);
            this.a(var1_5);
            return;
        }
    }

    private a.b d(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        if (byteBuffer.limit() > a.c.length) {
            return a.b.b;
        }
        if (byteBuffer.limit() >= a.c.length) {
            int n2 = 0;
            while (byteBuffer.hasRemaining()) {
                if (a.c[n2] != byteBuffer.get()) {
                    byteBuffer.reset();
                    return a.b.b;
                }
                ++n2;
            }
            return a.b.a;
        }
        throw new com.mixpanel.android.a.c.a(a.c.length);
    }

    private void e(ByteBuffer byteBuffer) {
        if (b) {
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("write(");
            stringBuilder.append(byteBuffer.remaining());
            stringBuilder.append("): {");
            String string2 = byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array());
            stringBuilder.append(string2);
            stringBuilder.append("}");
            printStream.println(stringBuilder.toString());
        }
        this.f.add(byteBuffer);
        this.k.b(this);
    }

    @Override
    public InetSocketAddress a() {
        return this.k.c(this);
    }

    public void a(int n2, String string2) {
        this.c(n2, string2, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void a(int n2, String string2, boolean bl2) {
        synchronized (this) {
            Object object = this.j;
            a.a a2 = a.a.e;
            if (object == a2) {
                return;
            }
            if (this.d != null) {
                this.d.cancel();
            }
            if ((object = this.e) != null) {
                try {
                    this.e.close();
                }
                catch (IOException iOException) {
                    this.k.a((com.mixpanel.android.a.a)this, iOException);
                }
            }
            try {
                void var3_4;
                this.k.a(this, n2, string2, (boolean)var3_4);
            }
            catch (RuntimeException runtimeException) {
                this.k.a((com.mixpanel.android.a.a)this, runtimeException);
            }
            if (this.m != null) {
                this.m.a();
            }
            this.q = null;
            this.j = a.a.e;
            this.f.clear();
            return;
        }
    }

    protected void a(int n2, boolean bl2) {
        this.a(n2, "", bl2);
    }

    public void a(com.mixpanel.android.a.c.b b2) {
        this.c(b2.a(), b2.getMessage(), false);
    }

    public void a(d.a a2, ByteBuffer byteBuffer, boolean bl2) {
        this.a((Collection<com.mixpanel.android.a.d.d>)this.m.a(a2, byteBuffer, bl2));
    }

    @Override
    public void a(com.mixpanel.android.a.d.d d2) {
        if (b) {
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("send frame: ");
            stringBuilder.append(d2);
            printStream.println(stringBuilder.toString());
        }
        this.e(this.m.a(d2));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(com.mixpanel.android.a.e.b b2) {
        if (!h && this.j == a.a.b) {
            throw new AssertionError((Object)"shall only be called once");
        }
        this.q = this.m.a(b2);
        this.u = b2.a();
        if (!h && this.u == null) {
            throw new AssertionError();
        }
        try {
            this.k.a((com.mixpanel.android.a.a)this, this.q);
        }
        catch (RuntimeException runtimeException) {
            this.k.a((com.mixpanel.android.a.a)this, runtimeException);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("rejected because of");
            stringBuilder.append(runtimeException);
            throw new com.mixpanel.android.a.c.d(stringBuilder.toString());
        }
        catch (com.mixpanel.android.a.c.b b3) {
            throw new com.mixpanel.android.a.c.d("Handshake data rejected by client.");
        }
        this.a(this.m.a((f)this.q, this.n));
        return;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(ByteBuffer var1_1) {
        if (!c.h && !var1_1.hasRemaining()) {
            throw new AssertionError();
        }
        if (c.b) {
            var3_2 = System.out;
            var4_3 = new StringBuilder();
            var4_3.append("process(");
            var4_3.append(var1_1.remaining());
            var4_3.append("): {");
            var2_4 = var1_1.remaining() > 1000 ? "too big to display" : new String(var1_1.array(), var1_1.position(), var1_1.remaining());
            var4_3.append(var2_4);
            var4_3.append("}");
            var3_2.println(var4_3.toString());
        }
        if (this.j != a.a.a) {
            do {
                this.c(var1_1);
                break;
            } while (true);
        } else if (this.b(var1_1)) {
            if (!c.h && this.p.hasRemaining() == var1_1.hasRemaining() && var1_1.hasRemaining()) {
                throw new AssertionError();
            }
            if (var1_1.hasRemaining()) ** continue;
            if (this.p.hasRemaining()) {
                this.c(this.p);
            }
        }
        if (c.h || this.d() || this.e()) return;
        if (var1_1.hasRemaining()) throw new AssertionError();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void b() {
        if (this.g() == a.a.a) {
            this.a(-1, true);
            return;
        }
        if (this.i) {
            this.a(this.s, this.r, (boolean)this.t);
            return;
        }
        if (this.m.b() == a.a.a || this.m.b() == a.a.b && this.n != a.b.b) {
            this.a(1000, true);
            return;
        }
        this.a(1006, true);
    }

    public void b(int n2, String string2) {
        this.a(n2, string2, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void b(int n2, String string2, boolean bl2) {
        synchronized (this) {
            void var3_4;
            boolean bl3 = this.i;
            if (bl3) {
                return;
            }
            this.s = n2;
            this.r = string2;
            this.t = (boolean)var3_4;
            this.i = true;
            this.k.b(this);
            try {
                this.k.b(this, n2, string2, (boolean)var3_4);
            }
            catch (RuntimeException runtimeException) {
                this.k.a((com.mixpanel.android.a.a)this, runtimeException);
            }
            if (this.m != null) {
                this.m.a();
            }
            this.q = null;
            return;
        }
    }

    public boolean c() {
        if (!h && this.j == a.a.c && this.i) {
            throw new AssertionError();
        }
        return this.j == a.a.c;
    }

    public boolean d() {
        return this.j == a.a.d;
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.j == a.a.e;
    }

    public a.a g() {
        return this.j;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }
}

