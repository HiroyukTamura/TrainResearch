/*
 * Decompiled with CFR 0.139.
 */
package c;

import c.a.a.e;
import c.a.b;
import c.a.c.c;
import c.a.c.g;
import c.a.c.j;
import c.a.g.f;
import c.aa;
import c.ac;
import c.m;
import c.n;
import c.p;
import c.t;
import c.u;
import c.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class z
implements c.e {
    final x a;
    final j b;
    final aa c;
    final boolean d;
    private p e;
    private boolean f;

    private z(x x2, aa aa2, boolean bl2) {
        this.a = x2;
        this.c = aa2;
        this.d = bl2;
        this.b = new j(x2, bl2);
    }

    static /* synthetic */ p a(z z2) {
        return z2.e;
    }

    static z a(x x2, aa object, boolean bl2) {
        object = new z(x2, (aa)object, bl2);
        ((z)object).e = x2.y().a((c.e)object);
        return object;
    }

    private void h() {
        Object object = f.c().a("response.body().close()");
        this.b.a(object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public ac a() {
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f = true;
        }
        this.h();
        this.e.a(this);
        try {
            this.a.t().a(this);
            ac ac2 = this.g();
            if (ac2 != null) {
                this.a.t().b(this);
                return ac2;
            }
            throw new IOException("Canceled");
        }
        catch (Throwable throwable) {
        }
        catch (IOException iOException) {
            this.e.a((c.e)this, iOException);
            throw iOException;
        }
        this.a.t().b(this);
        throw throwable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(c.f f2) {
        synchronized (this) {
            if (!this.f) {
                this.f = true;
                // MONITOREXIT [2, 3] lbl4 : MonitorExitStatement: MONITOREXIT : this
                this.h();
                this.e.a(this);
                this.a.t().a(new a(f2));
                return;
            }
            throw new IllegalStateException("Already Executed");
        }
    }

    @Override
    public void b() {
        this.b.a();
    }

    @Override
    public boolean c() {
        return this.b.b();
    }

    public /* synthetic */ Object clone() {
        return this.d();
    }

    public z d() {
        return z.a(this.a, this.c, this.d);
    }

    String e() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.c() ? "canceled " : "";
        stringBuilder.append(string2);
        string2 = this.d ? "web socket" : "call";
        stringBuilder.append(string2);
        stringBuilder.append(" to ");
        stringBuilder.append(this.f());
        return stringBuilder.toString();
    }

    String f() {
        return this.c.a().n();
    }

    ac g() {
        ArrayList<u> arrayList = new ArrayList<u>();
        arrayList.addAll(this.a.w());
        arrayList.add(this.b);
        arrayList.add(new c.a.c.a(this.a.g()));
        arrayList.add(new c.a.a.a(this.a.h()));
        arrayList.add(new c.a.b.a(this.a));
        if (!this.d) {
            arrayList.addAll(this.a.x());
        }
        arrayList.add(new c.a.c.b(this.d));
        return new g(arrayList, null, null, null, 0, this.c, this, this.e, this.a.a(), this.a.b(), this.a.c()).a(this.c);
    }

    final class a
    extends b {
        private final c.f c;

        a(c.f f2) {
            super("OkHttp %s", z.this.f());
            this.c = f2;
        }

        String a() {
            return z.this.c.a().f();
        }

        z b() {
            return z.this;
        }

        /*
         * Exception decompiling
         */
        @Override
        protected void c() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 5[CATCHBLOCK]
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:432)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
            // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
            // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
            // org.benf.cfr.reader.Main.main(Main.java:48)
            throw new IllegalStateException("Decompilation failed");
        }
    }

}

