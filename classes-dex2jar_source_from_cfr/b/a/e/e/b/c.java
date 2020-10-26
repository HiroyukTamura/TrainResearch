/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.e.b;

import b.a.b.b;
import b.a.e.c.d;
import b.a.e.g.k;
import b.a.f;
import b.a.g;
import b.a.h;

public final class c<T>
extends b.a.e.e.b.a<T, T> {
    final h b;
    final boolean c;
    final int d;

    public c(f<T> f2, h h2, boolean bl2, int n2) {
        super(f2);
        this.b = h2;
        this.c = bl2;
        this.d = n2;
    }

    @Override
    protected void b(g<? super T> g2) {
        if (this.b instanceof k) {
            this.a.a(g2);
            return;
        }
        h.b b2 = this.b.a();
        this.a.a(new a<T>(g2, b2, this.c, this.d));
    }

    static final class a<T>
    extends b.a.e.d.a<T>
    implements g<T>,
    Runnable {
        final g<? super T> a;
        final h.b b;
        final boolean c;
        final int d;
        d<T> e;
        b f;
        Throwable g;
        volatile boolean h;
        volatile boolean i;
        int j;
        boolean k;

        a(g<? super T> g2, h.b b2, boolean bl2, int n2) {
            this.a = g2;
            this.b = b2;
            this.c = bl2;
            this.d = n2;
        }

        @Override
        public int a(int n2) {
            if ((n2 & 2) != 0) {
                this.k = true;
                return 2;
            }
            return 0;
        }

        @Override
        public void a() {
            if (!this.i) {
                this.i = true;
                this.f.a();
                this.b.a();
                if (this.getAndIncrement() == 0) {
                    this.e.d();
                }
            }
        }

        @Override
        public void a(b b2) {
            if (b.a.e.a.b.a(this.f, b2)) {
                this.f = b2;
                if (b2 instanceof b.a.e.c.a) {
                    int n2 = (b2 = (b.a.e.c.a)b2).a(7);
                    if (n2 == 1) {
                        this.j = n2;
                        this.e = b2;
                        this.h = true;
                        this.a.a(this);
                        this.e();
                        return;
                    }
                    if (n2 == 2) {
                        this.j = n2;
                        this.e = b2;
                        this.a.a(this);
                        return;
                    }
                }
                this.e = new b.a.e.f.a(this.d);
                this.a.a(this);
            }
        }

        @Override
        public void a(Throwable throwable) {
            if (this.h) {
                b.a.f.a.a(throwable);
                return;
            }
            this.g = throwable;
            this.h = true;
            this.e();
        }

        boolean a(boolean bl2, boolean bl3, g<? super T> g2) {
            if (this.i) {
                this.e.d();
                return true;
            }
            if (bl2) {
                Throwable throwable = this.g;
                if (this.c) {
                    if (bl3) {
                        if (throwable != null) {
                            g2.a(throwable);
                        } else {
                            g2.b_();
                        }
                        this.b.a();
                        return true;
                    }
                } else {
                    if (throwable != null) {
                        this.e.d();
                        g2.a(throwable);
                        this.b.a();
                        return true;
                    }
                    if (bl3) {
                        g2.b_();
                        this.b.a();
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public void a_(T t2) {
            if (this.h) {
                return;
            }
            if (this.j != 2) {
                this.e.a(t2);
            }
            this.e();
        }

        @Override
        public T b() {
            return this.e.b();
        }

        @Override
        public void b_() {
            if (this.h) {
                return;
            }
            this.h = true;
            this.e();
        }

        @Override
        public boolean c() {
            return this.e.c();
        }

        @Override
        public void d() {
            this.e.d();
        }

        void e() {
            if (this.getAndIncrement() == 0) {
                this.b.a(this);
            }
        }

        /*
         * Exception decompiling
         */
        void f() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
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

        /*
         * Enabled aggressive block sorting
         */
        void g() {
            int n2;
            int n3 = 1;
            do {
                block9 : {
                    block8 : {
                        boolean bl2;
                        Throwable throwable;
                        block7 : {
                            if (this.i) {
                                return;
                            }
                            bl2 = this.h;
                            throwable = this.g;
                            if (this.c || !bl2 || throwable == null) break block7;
                            this.a.a(this.g);
                            break block8;
                        }
                        this.a.a_(null);
                        if (!bl2) break block9;
                        throwable = this.g;
                        if (throwable != null) {
                            this.a.a(throwable);
                        } else {
                            this.a.b_();
                        }
                    }
                    this.b.a();
                    return;
                }
                n3 = n2 = this.addAndGet(-n3);
            } while (n2 != 0);
        }

        @Override
        public void run() {
            if (this.k) {
                this.g();
                return;
            }
            this.f();
        }
    }

}

