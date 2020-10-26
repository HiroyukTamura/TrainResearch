/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.f.a;
import kotlin.reflect.jvm.internal.impl.f.d;
import kotlin.reflect.jvm.internal.impl.f.i;
import kotlin.reflect.jvm.internal.impl.f.j;
import kotlin.reflect.jvm.internal.impl.f.q;

public final class a {

    public static final class kotlin.reflect.jvm.internal.impl.d.a$a
    extends kotlin.reflect.jvm.internal.impl.f.i
    implements kotlin.reflect.jvm.internal.impl.d.a$b {
        public static kotlin.reflect.jvm.internal.impl.f.s<kotlin.reflect.jvm.internal.impl.d.a$a> a = new kotlin.reflect.jvm.internal.impl.f.b<kotlin.reflect.jvm.internal.impl.d.a$a>(){

            public kotlin.reflect.jvm.internal.impl.d.a$a a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new kotlin.reflect.jvm.internal.impl.d.a$a(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final kotlin.reflect.jvm.internal.impl.d.a$a c = new kotlin.reflect.jvm.internal.impl.d.a$a(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private int f;
        private List<a> g;
        private byte h = (byte)-1;
        private int i = -1;

        static {
            c.p();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private kotlin.reflect.jvm.internal.impl.d.a$a(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.p();
            var9_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var10_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var9_10, 1);
            var8_12 = false;
            var3_13 = 0;
            while (!var8_12) {
                block19 : {
                    block20 : {
                        var5_15 = var3_13;
                        var6_16 = var3_13;
                        var7_17 = var3_13;
                        var4_14 = var1_1.a();
                        if (var4_14 == 0) break block20;
                        if (var4_14 == 8) ** GOTO lbl37
                        if (var4_14 != 18) {
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            if (this.a(var1_1, var10_11, var2_8, var4_14)) continue;
                        } else {
                            var4_14 = var3_13;
                            if ((var3_13 & 2) != 2) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.g = new ArrayList<a>();
                                var4_14 = var3_13 | 2;
                            }
                            var5_15 = var4_14;
                            var6_16 = var4_14;
                            var7_17 = var4_14;
                            this.g.add(var1_1.a(a.a, var2_8));
                            var3_13 = var4_14;
                            continue;
lbl37: // 1 sources:
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.e |= 1;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.f = var1_1.f();
                            continue;
                        }
                    }
                    var8_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block19;
                    }
                    catch (IOException var1_3) {
                        var5_15 = var6_16;
                        throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                        var5_15 = var7_17;
                        throw var1_4.a(this);
                    }
                }
                if ((var5_15 & 2) == 2) {
                    this.g = Collections.unmodifiableList(this.g);
                }
                try {
                    var10_11.a();
lbl62: // 2 sources:
                    do {
                        this.d = var9_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var9_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            if ((var3_13 & 2) == 2) {
                this.g = Collections.unmodifiableList(this.g);
            }
            try {
                var10_11.a();
lbl74: // 2 sources:
                do {
                    this.d = var9_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var9_10.a();
                throw var1_6;
            }
            this.O();
            return;
            catch (IOException var2_9) {
                ** continue;
            }
            catch (IOException var1_7) {
                ** continue;
            }
        }

        private kotlin.reflect.jvm.internal.impl.d.a$a(i.a a2) {
            super(a2);
            this.d = a2.x();
        }

        private kotlin.reflect.jvm.internal.impl.d.a$a(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static c a(kotlin.reflect.jvm.internal.impl.d.a$a a2) {
            return kotlin.reflect.jvm.internal.impl.d.a$a.j().a(a2);
        }

        public static kotlin.reflect.jvm.internal.impl.d.a$a a() {
            return c;
        }

        public static c j() {
            return c.n();
        }

        private void p() {
            this.f = 0;
            this.g = Collections.emptyList();
        }

        public a a(int n2) {
            return this.g.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            this.i();
            if ((this.e & 1) == 1) {
                f2.a(1, this.f);
            }
            for (int i2 = 0; i2 < this.g.size(); ++i2) {
                f2.b(2, this.g.get(i2));
            }
            f2.c(this.d);
        }

        public kotlin.reflect.jvm.internal.impl.d.a$a b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<kotlin.reflect.jvm.internal.impl.d.a$a> c() {
            return a;
        }

        public boolean d() {
            return (this.e & 1) == 1;
        }

        public int e() {
            return this.f;
        }

        public List<a> f() {
            return this.g;
        }

        public int g() {
            return this.g.size();
        }

        @Override
        public final boolean h() {
            int n2 = this.h;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            if (!this.d()) {
                this.h = 0;
                return false;
            }
            for (n2 = 0; n2 < this.g(); ++n2) {
                if (this.a(n2).h()) continue;
                this.h = 0;
                return false;
            }
            this.h = 1;
            return true;
        }

        @Override
        public int i() {
            int n2 = this.i;
            if (n2 != -1) {
                return n2;
            }
            n2 = this.e;
            n2 = (n2 & 1) == 1 ? kotlin.reflect.jvm.internal.impl.f.f.d(1, this.f) + 0 : 0;
            for (int i2 = 0; i2 < this.g.size(); ++i2) {
                n2 += kotlin.reflect.jvm.internal.impl.f.f.d(2, this.g.get(i2));
            }
            this.i = n2 += this.d.a();
            return n2;
        }

        public c k() {
            return kotlin.reflect.jvm.internal.impl.d.a$a.j();
        }

        public c l() {
            return kotlin.reflect.jvm.internal.impl.d.a$a.a(this);
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.l();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.k();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public static final class kotlin.reflect.jvm.internal.impl.d.a$a$a
        extends kotlin.reflect.jvm.internal.impl.f.i
        implements kotlin.reflect.jvm.internal.impl.d.a$a$b {
            public static kotlin.reflect.jvm.internal.impl.f.s<kotlin.reflect.jvm.internal.impl.d.a$a$a> a = new kotlin.reflect.jvm.internal.impl.f.b<kotlin.reflect.jvm.internal.impl.d.a$a$a>(){

                public kotlin.reflect.jvm.internal.impl.d.a$a$a a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    return new kotlin.reflect.jvm.internal.impl.d.a$a$a(e2, g2);
                }

                @Override
                public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    return this.a(e2, g2);
                }
            };
            private static final kotlin.reflect.jvm.internal.impl.d.a$a$a c = new kotlin.reflect.jvm.internal.impl.d.a$a$a(true);
            private final kotlin.reflect.jvm.internal.impl.f.d d;
            private int e;
            private int f;
            private b g;
            private byte h = (byte)-1;
            private int i = -1;

            static {
                c.p();
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive exception aggregation
             */
            private kotlin.reflect.jvm.internal.impl.d.a$a$a(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
                super();
                this.p();
                var6_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
                var7_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var6_10, 1);
                var3_12 = false;
                while (!var3_12) {
                    block18 : {
                        block19 : {
                            var4_13 = var1_1.a();
                            if (var4_13 == 0) break block19;
                            if (var4_13 == 8) ** GOTO lbl26
                            if (var4_13 != 18) {
                                if (this.a(var1_1, var7_11, var2_8, var4_13)) continue;
                            } else {
                                var5_14 = null;
                                if ((this.e & 2) == 2) {
                                    var5_14 = this.g.E();
                                }
                                this.g = var1_1.a(b.a, var2_8);
                                if (var5_14 != null) {
                                    var5_14.a(this.g);
                                    this.g = var5_14.d();
                                }
                                this.e |= 2;
                                continue;
lbl26: // 1 sources:
                                this.e |= 1;
                                this.f = var1_1.f();
                                continue;
                            }
                        }
                        var3_12 = true;
                        continue;
                        catch (Throwable var1_2) {
                            break block18;
                        }
                        catch (IOException var1_3) {
                            throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                        }
                        catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                            throw var1_4.a(this);
                        }
                    }
                    try {
                        var7_11.a();
lbl41: // 2 sources:
                        do {
                            this.d = var6_10.a();
                            break;
                        } while (true);
                    }
                    catch (Throwable var1_5) {
                        this.d = var6_10.a();
                        throw var1_5;
                    }
                    this.O();
                    throw var1_2;
                }
                try {
                    var7_11.a();
lbl51: // 2 sources:
                    do {
                        this.d = var6_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_6) {
                    this.d = var6_10.a();
                    throw var1_6;
                }
                this.O();
                return;
                catch (IOException var2_9) {
                    ** continue;
                }
                catch (IOException var1_7) {
                    ** continue;
                }
            }

            private kotlin.reflect.jvm.internal.impl.d.a$a$a(i.a a2) {
                super(a2);
                this.d = a2.x();
            }

            private kotlin.reflect.jvm.internal.impl.d.a$a$a(boolean bl2) {
                this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
            }

            public static a a(kotlin.reflect.jvm.internal.impl.d.a$a$a a2) {
                return kotlin.reflect.jvm.internal.impl.d.a$a$a.j().a(a2);
            }

            public static kotlin.reflect.jvm.internal.impl.d.a$a$a a() {
                return c;
            }

            public static a j() {
                return a.p();
            }

            private void p() {
                this.f = 0;
                this.g = b.a();
            }

            @Override
            public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
                this.i();
                if ((this.e & 1) == 1) {
                    f2.a(1, this.f);
                }
                if ((this.e & 2) == 2) {
                    f2.b(2, this.g);
                }
                f2.c(this.d);
            }

            public kotlin.reflect.jvm.internal.impl.d.a$a$a b() {
                return c;
            }

            public kotlin.reflect.jvm.internal.impl.f.s<kotlin.reflect.jvm.internal.impl.d.a$a$a> c() {
                return a;
            }

            public boolean d() {
                return (this.e & 1) == 1;
            }

            public int e() {
                return this.f;
            }

            public boolean f() {
                return (this.e & 2) == 2;
            }

            public b g() {
                return this.g;
            }

            @Override
            public final boolean h() {
                byte by2 = this.h;
                if (by2 == 1) {
                    return true;
                }
                if (by2 == 0) {
                    return false;
                }
                if (!this.d()) {
                    this.h = 0;
                    return false;
                }
                if (!this.f()) {
                    this.h = 0;
                    return false;
                }
                if (!this.g().h()) {
                    this.h = 0;
                    return false;
                }
                this.h = 1;
                return true;
            }

            @Override
            public int i() {
                int n2 = this.i;
                if (n2 != -1) {
                    return n2;
                }
                n2 = 0;
                if ((this.e & 1) == 1) {
                    n2 = 0 + kotlin.reflect.jvm.internal.impl.f.f.d(1, this.f);
                }
                int n3 = n2;
                if ((this.e & 2) == 2) {
                    n3 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(2, this.g);
                }
                this.i = n2 = n3 + this.d.a();
                return n2;
            }

            public a k() {
                return kotlin.reflect.jvm.internal.impl.d.a$a$a.j();
            }

            public a l() {
                return kotlin.reflect.jvm.internal.impl.d.a$a$a.a(this);
            }

            @Override
            public /* synthetic */ q.a m() {
                return this.l();
            }

            @Override
            public /* synthetic */ q.a n() {
                return this.k();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }

            public static final class a
            extends i.a<kotlin.reflect.jvm.internal.impl.d.a$a$a, a>
            implements kotlin.reflect.jvm.internal.impl.d.a$a$b {
                private int a;
                private int b;
                private b c = b.a();

                private a() {
                    this.n();
                }

                private void n() {
                }

                private static a p() {
                    return new a();
                }

                public a a() {
                    return a.p().a(this.d());
                }

                @Override
                public a a(int n2) {
                    this.a |= 1;
                    this.b = n2;
                    return this;
                }

                @Override
                public a a(b b2) {
                    b b3 = b2;
                    if ((this.a & 2) == 2) {
                        b3 = b2;
                        if (this.c != b.a()) {
                            b3 = b.a(this.c).a(b2).d();
                        }
                    }
                    this.c = b3;
                    this.a |= 2;
                    return this;
                }

                @Override
                public a a(kotlin.reflect.jvm.internal.impl.d.a$a$a a2) {
                    if (a2 == kotlin.reflect.jvm.internal.impl.d.a$a$a.a()) {
                        return this;
                    }
                    if (a2.d()) {
                        this.a(a2.e());
                    }
                    if (a2.f()) {
                        this.a(a2.g());
                    }
                    this.a(this.x().a(a2.d));
                    return this;
                }

                /*
                 * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
                 * Loose catch block
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Lifted jumps to return sites
                 */
                public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    void var2_6;
                    Object var3_7 = null;
                    object = kotlin.reflect.jvm.internal.impl.d.a$a$a.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                    if (object == null) return this;
                    this.a((kotlin.reflect.jvm.internal.impl.d.a$a$a)object);
                    return this;
                    {
                        catch (Throwable throwable) {
                            object = var3_7;
                        }
                        catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                        {
                            object = (kotlin.reflect.jvm.internal.impl.d.a$a$a)k2.a();
                        }
                        try {
                            throw k2;
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    if (object == null) throw var2_6;
                    this.a((kotlin.reflect.jvm.internal.impl.d.a$a$a)object);
                    throw var2_6;
                }

                public kotlin.reflect.jvm.internal.impl.d.a$a$a b() {
                    return kotlin.reflect.jvm.internal.impl.d.a$a$a.a();
                }

                @Override
                public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.a$a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    return this.a(e2, g2);
                }

                public kotlin.reflect.jvm.internal.impl.d.a$a$a c() {
                    kotlin.reflect.jvm.internal.impl.d.a$a$a a2 = this.d();
                    if (a2.h()) {
                        return a2;
                    }
                    throw a.a(a2);
                }

                @Override
                public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    return this.a(e2, g2);
                }

                @Override
                public /* synthetic */ Object clone() {
                    return this.a();
                }

                public kotlin.reflect.jvm.internal.impl.d.a$a$a d() {
                    kotlin.reflect.jvm.internal.impl.d.a$a$a a2 = new kotlin.reflect.jvm.internal.impl.d.a$a$a(this);
                    int n2 = this.a;
                    int n3 = 1;
                    if ((n2 & 1) != 1) {
                        n3 = 0;
                    }
                    a2.f = this.b;
                    int n4 = n3;
                    if ((n2 & 2) == 2) {
                        n4 = n3 | 2;
                    }
                    a2.g = this.c;
                    a2.e = n4;
                    return a2;
                }

                public boolean e() {
                    return (this.a & 1) == 1;
                }

                public boolean f() {
                    return (this.a & 2) == 2;
                }

                public b g() {
                    return this.c;
                }

                @Override
                public final boolean h() {
                    if (!this.e()) {
                        return false;
                    }
                    if (!this.f()) {
                        return false;
                    }
                    return this.g().h();
                }

                @Override
                public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                    return this.b();
                }

                @Override
                public /* synthetic */ i.a j() {
                    return this.a();
                }

                @Override
                public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.a$a k() {
                    return this.a();
                }

                @Override
                public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                    return this.c();
                }

                @Override
                public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                    return this.b();
                }
            }

            public static final class kotlin.reflect.jvm.internal.impl.d.a$a$a$b
            extends kotlin.reflect.jvm.internal.impl.f.i
            implements c {
                public static kotlin.reflect.jvm.internal.impl.f.s<kotlin.reflect.jvm.internal.impl.d.a$a$a$b> a = new kotlin.reflect.jvm.internal.impl.f.b<kotlin.reflect.jvm.internal.impl.d.a$a$a$b>(){

                    public kotlin.reflect.jvm.internal.impl.d.a$a$a$b a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                        return new kotlin.reflect.jvm.internal.impl.d.a$a$a$b(e2, g2);
                    }

                    @Override
                    public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                        return this.a(e2, g2);
                    }
                };
                private static final kotlin.reflect.jvm.internal.impl.d.a$a$a$b c = new kotlin.reflect.jvm.internal.impl.d.a$a$a$b(true);
                private final kotlin.reflect.jvm.internal.impl.f.d d;
                private int e;
                private b f;
                private long g;
                private float h;
                private double i;
                private int j;
                private int k;
                private int l;
                private kotlin.reflect.jvm.internal.impl.d.a$a m;
                private List<kotlin.reflect.jvm.internal.impl.d.a$a$a$b> n;
                private int o;
                private byte p;
                private int q;

                static {
                    c.F();
                }

                /*
                 * Exception decompiling
                 */
                private kotlin.reflect.jvm.internal.impl.d.a$a$a$b(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
                    // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                    // org.benf.cfr.reader.util.ConfusedCFRException: First case is not immediately after switch.
                    // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:358)
                    // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:61)
                    // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:372)
                    // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
                    // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
                    // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
                    // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
                    // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
                    // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
                    // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
                    // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
                    // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
                    // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
                    // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
                    // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
                    // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
                    // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
                    // org.benf.cfr.reader.Main.main(Main.java:48)
                    throw new IllegalStateException("Decompilation failed");
                }

                private kotlin.reflect.jvm.internal.impl.d.a$a$a$b(i.a a2) {
                    super(a2);
                    this.p = (byte)-1;
                    this.q = -1;
                    this.d = a2.x();
                }

                private kotlin.reflect.jvm.internal.impl.d.a$a$a$b(boolean bl2) {
                    this.p = (byte)-1;
                    this.q = -1;
                    this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
                }

                public static a C() {
                    return a.p();
                }

                private void F() {
                    this.f = b.a;
                    this.g = 0L;
                    this.h = 0.0f;
                    this.i = 0.0;
                    this.j = 0;
                    this.k = 0;
                    this.l = 0;
                    this.m = kotlin.reflect.jvm.internal.impl.d.a$a.a();
                    this.n = Collections.emptyList();
                    this.o = 0;
                }

                public static a a(kotlin.reflect.jvm.internal.impl.d.a$a$a$b b2) {
                    return kotlin.reflect.jvm.internal.impl.d.a$a$a$b.C().a(b2);
                }

                public static kotlin.reflect.jvm.internal.impl.d.a$a$a$b a() {
                    return c;
                }

                public boolean A() {
                    return (this.e & 256) == 256;
                }

                public int B() {
                    return this.o;
                }

                public a D() {
                    return kotlin.reflect.jvm.internal.impl.d.a$a$a$b.C();
                }

                public a E() {
                    return kotlin.reflect.jvm.internal.impl.d.a$a$a$b.a(this);
                }

                public kotlin.reflect.jvm.internal.impl.d.a$a$a$b a(int n2) {
                    return this.n.get(n2);
                }

                @Override
                public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
                    this.i();
                    if ((this.e & 1) == 1) {
                        f2.c(1, this.f.a());
                    }
                    if ((this.e & 2) == 2) {
                        f2.a(2, this.g);
                    }
                    if ((this.e & 4) == 4) {
                        f2.a(3, this.h);
                    }
                    if ((this.e & 8) == 8) {
                        f2.a(4, this.i);
                    }
                    if ((this.e & 16) == 16) {
                        f2.a(5, this.j);
                    }
                    if ((this.e & 32) == 32) {
                        f2.a(6, this.k);
                    }
                    if ((this.e & 64) == 64) {
                        f2.a(7, this.l);
                    }
                    if ((this.e & 128) == 128) {
                        f2.b(8, this.m);
                    }
                    for (int i2 = 0; i2 < this.n.size(); ++i2) {
                        f2.b(9, this.n.get(i2));
                    }
                    if ((this.e & 256) == 256) {
                        f2.a(10, this.o);
                    }
                    f2.c(this.d);
                }

                public kotlin.reflect.jvm.internal.impl.d.a$a$a$b b() {
                    return c;
                }

                public kotlin.reflect.jvm.internal.impl.f.s<kotlin.reflect.jvm.internal.impl.d.a$a$a$b> c() {
                    return a;
                }

                public boolean d() {
                    return (this.e & 1) == 1;
                }

                public b e() {
                    return this.f;
                }

                public boolean f() {
                    return (this.e & 2) == 2;
                }

                public long g() {
                    return this.g;
                }

                @Override
                public final boolean h() {
                    int n2 = this.p;
                    if (n2 == 1) {
                        return true;
                    }
                    if (n2 == 0) {
                        return false;
                    }
                    if (this.w() && !this.x().h()) {
                        this.p = 0;
                        return false;
                    }
                    for (n2 = 0; n2 < this.z(); ++n2) {
                        if (this.a(n2).h()) continue;
                        this.p = 0;
                        return false;
                    }
                    this.p = 1;
                    return true;
                }

                @Override
                public int i() {
                    int n2 = this.q;
                    if (n2 != -1) {
                        return n2;
                    }
                    n2 = this.e;
                    int n3 = 0;
                    int n4 = (n2 & 1) == 1 ? kotlin.reflect.jvm.internal.impl.f.f.e(1, this.f.a()) + 0 : 0;
                    n2 = n4;
                    if ((this.e & 2) == 2) {
                        n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.b(2, this.g);
                    }
                    n4 = n2;
                    if ((this.e & 4) == 4) {
                        n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.b(3, this.h);
                    }
                    n2 = n4;
                    if ((this.e & 8) == 8) {
                        n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.b(4, this.i);
                    }
                    n4 = n2;
                    if ((this.e & 16) == 16) {
                        n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(5, this.j);
                    }
                    n2 = n4;
                    if ((this.e & 32) == 32) {
                        n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.d(6, this.k);
                    }
                    n4 = n2;
                    if ((this.e & 64) == 64) {
                        n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(7, this.l);
                    }
                    n2 = n4;
                    int n5 = n3;
                    if ((this.e & 128) == 128) {
                        n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.d(8, this.m);
                        n5 = n3;
                    }
                    while (n5 < this.n.size()) {
                        n2 += kotlin.reflect.jvm.internal.impl.f.f.d(9, this.n.get(n5));
                        ++n5;
                    }
                    n4 = n2;
                    if ((this.e & 256) == 256) {
                        n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(10, this.o);
                    }
                    this.q = n2 = n4 + this.d.a();
                    return n2;
                }

                public boolean j() {
                    return (this.e & 4) == 4;
                }

                public float k() {
                    return this.h;
                }

                public boolean l() {
                    return (this.e & 8) == 8;
                }

                @Override
                public /* synthetic */ q.a m() {
                    return this.E();
                }

                @Override
                public /* synthetic */ q.a n() {
                    return this.D();
                }

                @Override
                public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                    return this.b();
                }

                public double p() {
                    return this.i;
                }

                public boolean q() {
                    return (this.e & 16) == 16;
                }

                public int r() {
                    return this.j;
                }

                public boolean s() {
                    return (this.e & 32) == 32;
                }

                public int t() {
                    return this.k;
                }

                public boolean u() {
                    return (this.e & 64) == 64;
                }

                public int v() {
                    return this.l;
                }

                public boolean w() {
                    return (this.e & 128) == 128;
                }

                public kotlin.reflect.jvm.internal.impl.d.a$a x() {
                    return this.m;
                }

                public List<kotlin.reflect.jvm.internal.impl.d.a$a$a$b> y() {
                    return this.n;
                }

                public int z() {
                    return this.n.size();
                }

                public static final class a
                extends i.a<kotlin.reflect.jvm.internal.impl.d.a$a$a$b, a>
                implements c {
                    private int a;
                    private b b = b.a;
                    private long c;
                    private float d;
                    private double e;
                    private int f;
                    private int g;
                    private int h;
                    private kotlin.reflect.jvm.internal.impl.d.a$a i = kotlin.reflect.jvm.internal.impl.d.a$a.a();
                    private List<kotlin.reflect.jvm.internal.impl.d.a$a$a$b> j = Collections.emptyList();
                    private int k;

                    private a() {
                        this.n();
                    }

                    private void n() {
                    }

                    private static a p() {
                        return new a();
                    }

                    private void q() {
                        if ((this.a & 256) != 256) {
                            this.j = new ArrayList<kotlin.reflect.jvm.internal.impl.d.a$a$a$b>(this.j);
                            this.a |= 256;
                        }
                    }

                    public a a() {
                        return a.p().a(this.d());
                    }

                    @Override
                    public a a(double d2) {
                        this.a |= 8;
                        this.e = d2;
                        return this;
                    }

                    @Override
                    public a a(float f2) {
                        this.a |= 4;
                        this.d = f2;
                        return this;
                    }

                    @Override
                    public a a(int n2) {
                        this.a |= 16;
                        this.f = n2;
                        return this;
                    }

                    @Override
                    public a a(long l2) {
                        this.a |= 2;
                        this.c = l2;
                        return this;
                    }

                    @Override
                    public a a(b b2) {
                        if (b2 != null) {
                            this.a |= 1;
                            this.b = b2;
                            return this;
                        }
                        throw new NullPointerException();
                    }

                    @Override
                    public a a(kotlin.reflect.jvm.internal.impl.d.a$a$a$b b2) {
                        if (b2 == kotlin.reflect.jvm.internal.impl.d.a$a$a$b.a()) {
                            return this;
                        }
                        if (b2.d()) {
                            this.a(b2.e());
                        }
                        if (b2.f()) {
                            this.a(b2.g());
                        }
                        if (b2.j()) {
                            this.a(b2.k());
                        }
                        if (b2.l()) {
                            this.a(b2.p());
                        }
                        if (b2.q()) {
                            this.a(b2.r());
                        }
                        if (b2.s()) {
                            this.b(b2.t());
                        }
                        if (b2.u()) {
                            this.c(b2.v());
                        }
                        if (b2.w()) {
                            this.a(b2.x());
                        }
                        if (!b2.n.isEmpty()) {
                            if (this.j.isEmpty()) {
                                this.j = b2.n;
                                this.a &= -257;
                            } else {
                                this.q();
                                this.j.addAll(b2.n);
                            }
                        }
                        if (b2.A()) {
                            this.e(b2.B());
                        }
                        this.a(this.x().a(b2.d));
                        return this;
                    }

                    @Override
                    public a a(kotlin.reflect.jvm.internal.impl.d.a$a a2) {
                        kotlin.reflect.jvm.internal.impl.d.a$a a3 = a2;
                        if ((this.a & 128) == 128) {
                            a3 = a2;
                            if (this.i != kotlin.reflect.jvm.internal.impl.d.a$a.a()) {
                                a3 = kotlin.reflect.jvm.internal.impl.d.a$a.a(this.i).a(a2).d();
                            }
                        }
                        this.i = a3;
                        this.a |= 128;
                        return this;
                    }

                    /*
                     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
                     * Loose catch block
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     * Lifted jumps to return sites
                     */
                    public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                        void var2_6;
                        Object var3_7 = null;
                        object = kotlin.reflect.jvm.internal.impl.d.a$a$a$b.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                        if (object == null) return this;
                        this.a((kotlin.reflect.jvm.internal.impl.d.a$a$a$b)object);
                        return this;
                        {
                            catch (Throwable throwable) {
                                object = var3_7;
                            }
                            catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                            {
                                object = (kotlin.reflect.jvm.internal.impl.d.a$a$a$b)k2.a();
                            }
                            try {
                                throw k2;
                            }
                            catch (Throwable throwable) {
                                // empty catch block
                            }
                        }
                        if (object == null) throw var2_6;
                        this.a((kotlin.reflect.jvm.internal.impl.d.a$a$a$b)object);
                        throw var2_6;
                    }

                    public a b(int n2) {
                        this.a |= 32;
                        this.g = n2;
                        return this;
                    }

                    public kotlin.reflect.jvm.internal.impl.d.a$a$a$b b() {
                        return kotlin.reflect.jvm.internal.impl.d.a$a$a$b.a();
                    }

                    @Override
                    public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.a$a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                        return this.a(e2, g2);
                    }

                    public a c(int n2) {
                        this.a |= 64;
                        this.h = n2;
                        return this;
                    }

                    public kotlin.reflect.jvm.internal.impl.d.a$a$a$b c() {
                        kotlin.reflect.jvm.internal.impl.d.a$a$a$b b2 = this.d();
                        if (b2.h()) {
                            return b2;
                        }
                        throw a.a(b2);
                    }

                    @Override
                    public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                        return this.a(e2, g2);
                    }

                    @Override
                    public /* synthetic */ Object clone() {
                        return this.a();
                    }

                    public kotlin.reflect.jvm.internal.impl.d.a$a$a$b d() {
                        kotlin.reflect.jvm.internal.impl.d.a$a$a$b b2 = new kotlin.reflect.jvm.internal.impl.d.a$a$a$b(this);
                        int n2 = this.a;
                        int n3 = 1;
                        if ((n2 & 1) != 1) {
                            n3 = 0;
                        }
                        b2.f = this.b;
                        int n4 = n3;
                        if ((n2 & 2) == 2) {
                            n4 = n3 | 2;
                        }
                        b2.g = this.c;
                        n3 = n4;
                        if ((n2 & 4) == 4) {
                            n3 = n4 | 4;
                        }
                        b2.h = this.d;
                        n4 = n3;
                        if ((n2 & 8) == 8) {
                            n4 = n3 | 8;
                        }
                        b2.i = this.e;
                        n3 = n4;
                        if ((n2 & 16) == 16) {
                            n3 = n4 | 16;
                        }
                        b2.j = this.f;
                        n4 = n3;
                        if ((n2 & 32) == 32) {
                            n4 = n3 | 32;
                        }
                        b2.k = this.g;
                        n3 = n4;
                        if ((n2 & 64) == 64) {
                            n3 = n4 | 64;
                        }
                        b2.l = this.h;
                        n4 = n3;
                        if ((n2 & 128) == 128) {
                            n4 = n3 | 128;
                        }
                        b2.m = this.i;
                        if ((this.a & 256) == 256) {
                            this.j = Collections.unmodifiableList(this.j);
                            this.a &= -257;
                        }
                        b2.n = this.j;
                        n3 = n4;
                        if ((n2 & 512) == 512) {
                            n3 = n4 | 256;
                        }
                        b2.o = this.k;
                        b2.e = n3;
                        return b2;
                    }

                    public kotlin.reflect.jvm.internal.impl.d.a$a$a$b d(int n2) {
                        return this.j.get(n2);
                    }

                    public a e(int n2) {
                        this.a |= 512;
                        this.k = n2;
                        return this;
                    }

                    public boolean e() {
                        return (this.a & 128) == 128;
                    }

                    public kotlin.reflect.jvm.internal.impl.d.a$a f() {
                        return this.i;
                    }

                    public int g() {
                        return this.j.size();
                    }

                    @Override
                    public final boolean h() {
                        if (this.e() && !this.f().h()) {
                            return false;
                        }
                        for (int i2 = 0; i2 < this.g(); ++i2) {
                            if (this.d(i2).h()) continue;
                            return false;
                        }
                        return true;
                    }

                    @Override
                    public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                        return this.b();
                    }

                    @Override
                    public /* synthetic */ i.a j() {
                        return this.a();
                    }

                    @Override
                    public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.a$a k() {
                        return this.a();
                    }

                    @Override
                    public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                        return this.c();
                    }

                    @Override
                    public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                        return this.b();
                    }
                }

                public static enum b implements j.a
                {
                    a(0, 0),
                    b(1, 1),
                    c(2, 2),
                    d(3, 3),
                    e(4, 4),
                    f(5, 5),
                    g(6, 6),
                    h(7, 7),
                    i(8, 8),
                    j(9, 9),
                    k(10, 10),
                    l(11, 11),
                    m(12, 12);
                    
                    private static j.b<b> n;
                    private final int o;

                    static {
                        n = new j.b<b>(){

                            public b a(int n2) {
                                return b.a(n2);
                            }

                            @Override
                            public /* synthetic */ j.a b(int n2) {
                                return this.a(n2);
                            }
                        };
                    }

                    private b(int n3, int n4) {
                        this.o = n4;
                    }

                    public static b a(int n2) {
                        switch (n2) {
                            default: {
                                return null;
                            }
                            case 12: {
                                return m;
                            }
                            case 11: {
                                return l;
                            }
                            case 10: {
                                return k;
                            }
                            case 9: {
                                return j;
                            }
                            case 8: {
                                return i;
                            }
                            case 7: {
                                return h;
                            }
                            case 6: {
                                return g;
                            }
                            case 5: {
                                return f;
                            }
                            case 4: {
                                return e;
                            }
                            case 3: {
                                return d;
                            }
                            case 2: {
                                return c;
                            }
                            case 1: {
                                return b;
                            }
                            case 0: 
                        }
                        return a;
                    }

                    @Override
                    public final int a() {
                        return this.o;
                    }

                }

            }

            public static interface c
            extends kotlin.reflect.jvm.internal.impl.f.r {
            }

        }

        public static interface b
        extends kotlin.reflect.jvm.internal.impl.f.r {
        }

        public static final class c
        extends i.a<kotlin.reflect.jvm.internal.impl.d.a$a, c>
        implements kotlin.reflect.jvm.internal.impl.d.a$b {
            private int a;
            private int b;
            private List<a> c = Collections.emptyList();

            private c() {
                this.m();
            }

            private void m() {
            }

            private static c n() {
                return new c();
            }

            private void p() {
                if ((this.a & 2) != 2) {
                    this.c = new ArrayList<a>(this.c);
                    this.a |= 2;
                }
            }

            public c a() {
                return c.n().a(this.d());
            }

            @Override
            public c a(int n2) {
                this.a |= 1;
                this.b = n2;
                return this;
            }

            @Override
            public c a(kotlin.reflect.jvm.internal.impl.d.a$a a2) {
                if (a2 == kotlin.reflect.jvm.internal.impl.d.a$a.a()) {
                    return this;
                }
                if (a2.d()) {
                    this.a(a2.e());
                }
                if (!a2.g.isEmpty()) {
                    if (this.c.isEmpty()) {
                        this.c = a2.g;
                        this.a &= -3;
                    } else {
                        this.p();
                        this.c.addAll(a2.g);
                    }
                }
                this.a(this.x().a(a2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public c a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = kotlin.reflect.jvm.internal.impl.d.a$a.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((kotlin.reflect.jvm.internal.impl.d.a$a)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (kotlin.reflect.jvm.internal.impl.d.a$a)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((kotlin.reflect.jvm.internal.impl.d.a$a)object);
                throw var2_6;
            }

            public a b(int n2) {
                return this.c.get(n2);
            }

            public kotlin.reflect.jvm.internal.impl.d.a$a b() {
                return kotlin.reflect.jvm.internal.impl.d.a$a.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.a$a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public kotlin.reflect.jvm.internal.impl.d.a$a c() {
                kotlin.reflect.jvm.internal.impl.d.a$a a2 = this.d();
                if (a2.h()) {
                    return a2;
                }
                throw c.a(a2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public kotlin.reflect.jvm.internal.impl.d.a$a d() {
                kotlin.reflect.jvm.internal.impl.d.a$a a2 = new kotlin.reflect.jvm.internal.impl.d.a$a(this);
                int n2 = this.a;
                int n3 = 1;
                if ((n2 & 1) != 1) {
                    n3 = 0;
                }
                a2.f = this.b;
                if ((this.a & 2) == 2) {
                    this.c = Collections.unmodifiableList(this.c);
                    this.a &= -3;
                }
                a2.g = this.c;
                a2.e = n3;
                return a2;
            }

            public boolean e() {
                return (this.a & 1) == 1;
            }

            public int f() {
                return this.c.size();
            }

            @Override
            public final boolean h() {
                if (!this.e()) {
                    return false;
                }
                for (int i2 = 0; i2 < this.f(); ++i2) {
                    if (this.b(i2).h()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.a$a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }
        }

    }

    public static final class aa
    extends kotlin.reflect.jvm.internal.impl.f.i
    implements ab {
        public static kotlin.reflect.jvm.internal.impl.f.s<aa> a = new kotlin.reflect.jvm.internal.impl.f.b<aa>(){

            public aa a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new aa(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final aa c = new aa(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private kotlin.reflect.jvm.internal.impl.f.o e;
        private byte f = (byte)-1;
        private int g = -1;

        static {
            c.j();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private aa(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.j();
            var9_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var10_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var9_10, 1);
            var8_12 = false;
            var3_13 = 0;
            while (!var8_12) {
                block20 : {
                    var5_15 = var3_13;
                    var6_16 = var3_13;
                    var7_17 = var3_13;
                    var4_14 = var1_1.a();
                    if (var4_14 != 0) {
                        if (var4_14 != 10) {
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            if (this.a(var1_1, var10_11, var2_8, var4_14)) continue;
                        } else {
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            var11_18 = var1_1.l();
                            var4_14 = var3_13;
                            if ((var3_13 & 1) != 1) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.e = new kotlin.reflect.jvm.internal.impl.f.n();
                                var4_14 = var3_13 | 1;
                            }
                            var5_15 = var4_14;
                            var6_16 = var4_14;
                            var7_17 = var4_14;
                            this.e.a(var11_18);
                            var3_13 = var4_14;
                            continue;
                        }
                    }
                    var8_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block20;
                    }
                    catch (IOException var1_3) {
                        var5_15 = var6_16;
                        throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                        var5_15 = var7_17;
                        throw var1_4.a(this);
                    }
                }
                if (var5_15 & true) {
                    this.e = this.e.b();
                }
                try {
                    var10_11.a();
lbl55: // 2 sources:
                    do {
                        this.d = var9_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var9_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            if (var3_13 & true) {
                this.e = this.e.b();
            }
            try {
                var10_11.a();
lbl67: // 2 sources:
                do {
                    this.d = var9_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var9_10.a();
                throw var1_6;
            }
            this.O();
            return;
            catch (IOException var2_9) {
                ** continue;
            }
            catch (IOException var1_7) {
                ** continue;
            }
        }

        private aa(i.a a2) {
            super(a2);
            this.d = a2.x();
        }

        private aa(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(aa aa2) {
            return aa.e().a(aa2);
        }

        public static aa a() {
            return c;
        }

        public static a e() {
            return a.g();
        }

        private void j() {
            this.e = kotlin.reflect.jvm.internal.impl.f.n.a;
        }

        public String a(int n2) {
            return (String)this.e.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            this.i();
            for (int i2 = 0; i2 < this.e.size(); ++i2) {
                f2.a(1, this.e.c(i2));
            }
            f2.c(this.d);
        }

        public aa b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<aa> c() {
            return a;
        }

        public kotlin.reflect.jvm.internal.impl.f.t d() {
            return this.e;
        }

        public a f() {
            return aa.e();
        }

        public a g() {
            return aa.a(this);
        }

        @Override
        public final boolean h() {
            byte by2 = this.f;
            if (by2 == 1) {
                return true;
            }
            if (by2 == 0) {
                return false;
            }
            this.f = 1;
            return true;
        }

        @Override
        public int i() {
            int n2 = this.g;
            if (n2 != -1) {
                return n2;
            }
            int n3 = 0;
            for (n2 = 0; n2 < this.e.size(); ++n2) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.b(this.e.c(n2));
            }
            this.g = n2 = n3 + 0 + this.d().size() * 1 + this.d.a();
            return n2;
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.g();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.f();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public static final class a
        extends i.a<aa, a>
        implements ab {
            private int a;
            private kotlin.reflect.jvm.internal.impl.f.o b = kotlin.reflect.jvm.internal.impl.f.n.a;

            private a() {
                this.f();
            }

            private void f() {
            }

            private static a g() {
                return new a();
            }

            private void m() {
                if ((this.a & 1) != 1) {
                    this.b = new kotlin.reflect.jvm.internal.impl.f.n(this.b);
                    this.a |= 1;
                }
            }

            public a a() {
                return a.g().a(this.d());
            }

            @Override
            public a a(aa aa2) {
                if (aa2 == aa.a()) {
                    return this;
                }
                if (!aa2.e.isEmpty()) {
                    if (this.b.isEmpty()) {
                        this.b = aa2.e;
                        this.a &= -2;
                    } else {
                        this.m();
                        this.b.addAll(aa2.e);
                    }
                }
                this.a(this.x().a(aa2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = aa.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((aa)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (aa)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((aa)object);
                throw var2_6;
            }

            public aa b() {
                return aa.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public aa c() {
                aa aa2 = this.d();
                if (aa2.h()) {
                    return aa2;
                }
                throw a.a(aa2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public aa d() {
                aa aa2 = new aa(this);
                int n2 = this.a;
                if ((this.a & 1) == 1) {
                    this.b = this.b.b();
                    this.a &= -2;
                }
                aa2.e = this.b;
                return aa2;
            }

            @Override
            public final boolean h() {
                return true;
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }
        }

    }

    public static interface ab
    extends kotlin.reflect.jvm.internal.impl.f.r {
    }

    public static final class ac
    extends i.c<ac>
    implements af {
        public static kotlin.reflect.jvm.internal.impl.f.s<ac> a = new kotlin.reflect.jvm.internal.impl.f.b<ac>(){

            public ac a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new ac(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final ac c = new ac(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private List<a> f;
        private boolean g;
        private int h;
        private ac i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int n;
        private ac o;
        private int p;
        private ac q;
        private int r;
        private int s;
        private byte t;
        private int u;

        static {
            c.S();
        }

        /*
         * Exception decompiling
         */
        private ac(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: First case is not immediately after switch.
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:358)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:61)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:372)
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

        private ac(i.b<ac, ?> b2) {
            super(b2);
            this.t = (byte)-1;
            this.u = -1;
            this.d = b2.x();
        }

        private ac(boolean bl2) {
            this.t = (byte)-1;
            this.u = -1;
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static c K() {
            return c.t();
        }

        private void S() {
            this.f = Collections.emptyList();
            this.g = false;
            this.h = 0;
            this.i = ac.a();
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.o = ac.a();
            this.p = 0;
            this.q = ac.a();
            this.r = 0;
            this.s = 0;
        }

        public static c a(ac ac2) {
            return ac.K().a(ac2);
        }

        public static ac a() {
            return c;
        }

        public boolean A() {
            return (this.e & 256) == 256;
        }

        public ac B() {
            return this.o;
        }

        public boolean C() {
            return (this.e & 512) == 512;
        }

        public int D() {
            return this.p;
        }

        public boolean E() {
            return (this.e & 1024) == 1024;
        }

        public ac F() {
            return this.q;
        }

        public boolean G() {
            return (this.e & 2048) == 2048;
        }

        public int H() {
            return this.r;
        }

        public boolean I() {
            return (this.e & 4096) == 4096;
        }

        public int J() {
            return this.s;
        }

        public c L() {
            return ac.K();
        }

        public c M() {
            return ac.a(this);
        }

        public a a(int n2) {
            return this.f.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            this.i();
            i.c.a a2 = this.Q();
            if ((this.e & 4096) == 4096) {
                f2.a(1, this.s);
            }
            for (int i2 = 0; i2 < this.f.size(); ++i2) {
                f2.b(2, this.f.get(i2));
            }
            if ((this.e & 1) == 1) {
                f2.a(3, this.g);
            }
            if ((this.e & 2) == 2) {
                f2.a(4, this.h);
            }
            if ((this.e & 4) == 4) {
                f2.b(5, this.i);
            }
            if ((this.e & 16) == 16) {
                f2.a(6, this.k);
            }
            if ((this.e & 32) == 32) {
                f2.a(7, this.l);
            }
            if ((this.e & 8) == 8) {
                f2.a(8, this.j);
            }
            if ((this.e & 64) == 64) {
                f2.a(9, this.m);
            }
            if ((this.e & 256) == 256) {
                f2.b(10, this.o);
            }
            if ((this.e & 512) == 512) {
                f2.a(11, this.p);
            }
            if ((this.e & 128) == 128) {
                f2.a(12, this.n);
            }
            if ((this.e & 1024) == 1024) {
                f2.b(13, this.q);
            }
            if ((this.e & 2048) == 2048) {
                f2.a(14, this.r);
            }
            a2.a(200, f2);
            f2.c(this.d);
        }

        public ac b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<ac> c() {
            return a;
        }

        public List<a> d() {
            return this.f;
        }

        public int e() {
            return this.f.size();
        }

        public boolean f() {
            return (this.e & 1) == 1;
        }

        public boolean g() {
            return this.g;
        }

        @Override
        public final boolean h() {
            int n2 = this.t;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            for (n2 = 0; n2 < this.e(); ++n2) {
                if (this.a(n2).h()) continue;
                this.t = 0;
                return false;
            }
            if (this.l() && !this.p().h()) {
                this.t = 0;
                return false;
            }
            if (this.A() && !this.B().h()) {
                this.t = 0;
                return false;
            }
            if (this.E() && !this.F().h()) {
                this.t = 0;
                return false;
            }
            if (!this.P()) {
                this.t = 0;
                return false;
            }
            this.t = 1;
            return true;
        }

        @Override
        public int i() {
            int n2;
            int n3 = this.u;
            if (n3 != -1) {
                return n3;
            }
            n3 = this.e;
            n3 = (n3 & 4096) == 4096 ? kotlin.reflect.jvm.internal.impl.f.f.d(1, this.s) + 0 : 0;
            for (n2 = 0; n2 < this.f.size(); ++n2) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(2, this.f.get(n2));
            }
            n2 = n3;
            if ((this.e & 1) == 1) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.b(3, this.g);
            }
            n3 = n2;
            if ((this.e & 2) == 2) {
                n3 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(4, this.h);
            }
            n2 = n3;
            if ((this.e & 4) == 4) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(5, this.i);
            }
            n3 = n2;
            if ((this.e & 16) == 16) {
                n3 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(6, this.k);
            }
            n2 = n3;
            if ((this.e & 32) == 32) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(7, this.l);
            }
            n3 = n2;
            if ((this.e & 8) == 8) {
                n3 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(8, this.j);
            }
            n2 = n3;
            if ((this.e & 64) == 64) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(9, this.m);
            }
            n3 = n2;
            if ((this.e & 256) == 256) {
                n3 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(10, this.o);
            }
            n2 = n3;
            if ((this.e & 512) == 512) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(11, this.p);
            }
            n3 = n2;
            if ((this.e & 128) == 128) {
                n3 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(12, this.n);
            }
            n2 = n3;
            if ((this.e & 1024) == 1024) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(13, this.q);
            }
            n3 = n2;
            if ((this.e & 2048) == 2048) {
                n3 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(14, this.r);
            }
            this.u = n3 = n3 + this.R() + this.d.a();
            return n3;
        }

        public boolean j() {
            return (this.e & 2) == 2;
        }

        public int k() {
            return this.h;
        }

        public boolean l() {
            return (this.e & 4) == 4;
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.M();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.L();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public ac p() {
            return this.i;
        }

        public boolean q() {
            return (this.e & 8) == 8;
        }

        public int r() {
            return this.j;
        }

        public boolean s() {
            return (this.e & 16) == 16;
        }

        public int t() {
            return this.k;
        }

        public boolean u() {
            return (this.e & 32) == 32;
        }

        public int v() {
            return this.l;
        }

        public boolean w() {
            return (this.e & 64) == 64;
        }

        public int x() {
            return this.m;
        }

        public boolean y() {
            return (this.e & 128) == 128;
        }

        public int z() {
            return this.n;
        }

        public static final class kotlin.reflect.jvm.internal.impl.d.a$ac$a
        extends kotlin.reflect.jvm.internal.impl.f.i
        implements kotlin.reflect.jvm.internal.impl.d.a$ac$b {
            public static kotlin.reflect.jvm.internal.impl.f.s<kotlin.reflect.jvm.internal.impl.d.a$ac$a> a = new kotlin.reflect.jvm.internal.impl.f.b<kotlin.reflect.jvm.internal.impl.d.a$ac$a>(){

                public kotlin.reflect.jvm.internal.impl.d.a$ac$a a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    return new kotlin.reflect.jvm.internal.impl.d.a$ac$a(e2, g2);
                }

                @Override
                public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    return this.a(e2, g2);
                }
            };
            private static final kotlin.reflect.jvm.internal.impl.d.a$ac$a c = new kotlin.reflect.jvm.internal.impl.d.a$ac$a(true);
            private final kotlin.reflect.jvm.internal.impl.f.d d;
            private int e;
            private b f;
            private ac g;
            private int h;
            private byte i = (byte)-1;
            private int j = -1;

            static {
                c.r();
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive exception aggregation
             */
            private kotlin.reflect.jvm.internal.impl.d.a$ac$a(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
                super();
                this.r();
                var7_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
                var8_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var7_10, 1);
                var3_12 = false;
                while (!var3_12) {
                    block19 : {
                        block20 : {
                            var4_13 = var1_1.a();
                            if (var4_13 == 0) break block20;
                            if (var4_13 == 8) ** GOTO lbl30
                            if (var4_13 == 18) ** GOTO lbl21
                            if (var4_13 != 24) {
                                if (this.a(var1_1, var8_11, var2_8, var4_13)) continue;
                            } else {
                                this.e |= 4;
                                this.h = var1_1.f();
                                continue;
lbl21: // 1 sources:
                                var6_15 = null;
                                if ((this.e & 2) == 2) {
                                    var6_15 = this.g.M();
                                }
                                this.g = var1_1.a(ac.a, var2_8);
                                if (var6_15 != null) {
                                    var6_15.a(this.g);
                                    this.g = var6_15.d();
                                }
                                this.e |= 2;
                                continue;
lbl30: // 1 sources:
                                var5_14 = var1_1.n();
                                var6_15 = b.a(var5_14);
                                if (var6_15 == null) {
                                    var8_11.p(var4_13);
                                    var8_11.p(var5_14);
                                    continue;
                                }
                                this.e |= 1;
                                this.f = var6_15;
                                continue;
                            }
                        }
                        var3_12 = true;
                        continue;
                        catch (Throwable var1_2) {
                            break block19;
                        }
                        catch (IOException var1_3) {
                            throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                        }
                        catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                            throw var1_4.a(this);
                        }
                    }
                    try {
                        var8_11.a();
lbl51: // 2 sources:
                        do {
                            this.d = var7_10.a();
                            break;
                        } while (true);
                    }
                    catch (Throwable var1_5) {
                        this.d = var7_10.a();
                        throw var1_5;
                    }
                    this.O();
                    throw var1_2;
                }
                try {
                    var8_11.a();
lbl61: // 2 sources:
                    do {
                        this.d = var7_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_6) {
                    this.d = var7_10.a();
                    throw var1_6;
                }
                this.O();
                return;
                catch (IOException var2_9) {
                    ** continue;
                }
                catch (IOException var1_7) {
                    ** continue;
                }
            }

            private kotlin.reflect.jvm.internal.impl.d.a$ac$a(i.a a2) {
                super(a2);
                this.d = a2.x();
            }

            private kotlin.reflect.jvm.internal.impl.d.a$ac$a(boolean bl2) {
                this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
            }

            public static a a(kotlin.reflect.jvm.internal.impl.d.a$ac$a a2) {
                return kotlin.reflect.jvm.internal.impl.d.a$ac$a.l().a(a2);
            }

            public static kotlin.reflect.jvm.internal.impl.d.a$ac$a a() {
                return c;
            }

            public static a l() {
                return a.n();
            }

            private void r() {
                this.f = b.c;
                this.g = ac.a();
                this.h = 0;
            }

            @Override
            public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
                this.i();
                if ((this.e & 1) == 1) {
                    f2.c(1, this.f.a());
                }
                if ((this.e & 2) == 2) {
                    f2.b(2, this.g);
                }
                if ((this.e & 4) == 4) {
                    f2.a(3, this.h);
                }
                f2.c(this.d);
            }

            public kotlin.reflect.jvm.internal.impl.d.a$ac$a b() {
                return c;
            }

            public kotlin.reflect.jvm.internal.impl.f.s<kotlin.reflect.jvm.internal.impl.d.a$ac$a> c() {
                return a;
            }

            public boolean d() {
                return (this.e & 1) == 1;
            }

            public b e() {
                return this.f;
            }

            public boolean f() {
                return (this.e & 2) == 2;
            }

            public ac g() {
                return this.g;
            }

            @Override
            public final boolean h() {
                byte by2 = this.i;
                if (by2 == 1) {
                    return true;
                }
                if (by2 == 0) {
                    return false;
                }
                if (this.f() && !this.g().h()) {
                    this.i = 0;
                    return false;
                }
                this.i = 1;
                return true;
            }

            @Override
            public int i() {
                int n2 = this.j;
                if (n2 != -1) {
                    return n2;
                }
                int n3 = 0;
                if ((this.e & 1) == 1) {
                    n3 = 0 + kotlin.reflect.jvm.internal.impl.f.f.e(1, this.f.a());
                }
                n2 = n3;
                if ((this.e & 2) == 2) {
                    n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(2, this.g);
                }
                n3 = n2;
                if ((this.e & 4) == 4) {
                    n3 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(3, this.h);
                }
                this.j = n2 = n3 + this.d.a();
                return n2;
            }

            public boolean j() {
                return (this.e & 4) == 4;
            }

            public int k() {
                return this.h;
            }

            @Override
            public /* synthetic */ q.a m() {
                return this.q();
            }

            @Override
            public /* synthetic */ q.a n() {
                return this.p();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }

            public a p() {
                return kotlin.reflect.jvm.internal.impl.d.a$ac$a.l();
            }

            public a q() {
                return kotlin.reflect.jvm.internal.impl.d.a$ac$a.a(this);
            }

            public static final class a
            extends i.a<kotlin.reflect.jvm.internal.impl.d.a$ac$a, a>
            implements kotlin.reflect.jvm.internal.impl.d.a$ac$b {
                private int a;
                private b b = b.c;
                private ac c = ac.a();
                private int d;

                private a() {
                    this.m();
                }

                private void m() {
                }

                private static a n() {
                    return new a();
                }

                public a a() {
                    return a.n().a(this.d());
                }

                @Override
                public a a(int n2) {
                    this.a |= 4;
                    this.d = n2;
                    return this;
                }

                @Override
                public a a(b b2) {
                    if (b2 != null) {
                        this.a |= 1;
                        this.b = b2;
                        return this;
                    }
                    throw new NullPointerException();
                }

                @Override
                public a a(kotlin.reflect.jvm.internal.impl.d.a$ac$a a2) {
                    if (a2 == kotlin.reflect.jvm.internal.impl.d.a$ac$a.a()) {
                        return this;
                    }
                    if (a2.d()) {
                        this.a(a2.e());
                    }
                    if (a2.f()) {
                        this.a(a2.g());
                    }
                    if (a2.j()) {
                        this.a(a2.k());
                    }
                    this.a(this.x().a(a2.d));
                    return this;
                }

                @Override
                public a a(ac ac2) {
                    ac ac3 = ac2;
                    if ((this.a & 2) == 2) {
                        ac3 = ac2;
                        if (this.c != ac.a()) {
                            ac3 = ac.a(this.c).a(ac2).d();
                        }
                    }
                    this.c = ac3;
                    this.a |= 2;
                    return this;
                }

                /*
                 * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
                 * Loose catch block
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Lifted jumps to return sites
                 */
                public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    void var2_6;
                    Object var3_7 = null;
                    object = kotlin.reflect.jvm.internal.impl.d.a$ac$a.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                    if (object == null) return this;
                    this.a((kotlin.reflect.jvm.internal.impl.d.a$ac$a)object);
                    return this;
                    {
                        catch (Throwable throwable) {
                            object = var3_7;
                        }
                        catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                        {
                            object = (kotlin.reflect.jvm.internal.impl.d.a$ac$a)k2.a();
                        }
                        try {
                            throw k2;
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    if (object == null) throw var2_6;
                    this.a((kotlin.reflect.jvm.internal.impl.d.a$ac$a)object);
                    throw var2_6;
                }

                public kotlin.reflect.jvm.internal.impl.d.a$ac$a b() {
                    return kotlin.reflect.jvm.internal.impl.d.a$ac$a.a();
                }

                @Override
                public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.a$a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    return this.a(e2, g2);
                }

                public kotlin.reflect.jvm.internal.impl.d.a$ac$a c() {
                    kotlin.reflect.jvm.internal.impl.d.a$ac$a a2 = this.d();
                    if (a2.h()) {
                        return a2;
                    }
                    throw a.a(a2);
                }

                @Override
                public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    return this.a(e2, g2);
                }

                @Override
                public /* synthetic */ Object clone() {
                    return this.a();
                }

                public kotlin.reflect.jvm.internal.impl.d.a$ac$a d() {
                    kotlin.reflect.jvm.internal.impl.d.a$ac$a a2 = new kotlin.reflect.jvm.internal.impl.d.a$ac$a(this);
                    int n2 = this.a;
                    int n3 = 1;
                    if ((n2 & 1) != 1) {
                        n3 = 0;
                    }
                    a2.f = this.b;
                    int n4 = n3;
                    if ((n2 & 2) == 2) {
                        n4 = n3 | 2;
                    }
                    a2.g = this.c;
                    n3 = n4;
                    if ((n2 & 4) == 4) {
                        n3 = n4 | 4;
                    }
                    a2.h = this.d;
                    a2.e = n3;
                    return a2;
                }

                public boolean e() {
                    return (this.a & 2) == 2;
                }

                public ac f() {
                    return this.c;
                }

                @Override
                public final boolean h() {
                    return !this.e() || this.f().h();
                }

                @Override
                public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                    return this.b();
                }

                @Override
                public /* synthetic */ i.a j() {
                    return this.a();
                }

                @Override
                public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.a$a k() {
                    return this.a();
                }

                @Override
                public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                    return this.c();
                }

                @Override
                public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                    return this.b();
                }
            }

            public static enum b implements j.a
            {
                a(0, 0),
                b(1, 1),
                c(2, 2),
                d(3, 3);
                
                private static j.b<b> e;
                private final int f;

                static {
                    e = new j.b<b>(){

                        public b a(int n2) {
                            return b.a(n2);
                        }

                        @Override
                        public /* synthetic */ j.a b(int n2) {
                            return this.a(n2);
                        }
                    };
                }

                private b(int n3, int n4) {
                    this.f = n4;
                }

                public static b a(int n2) {
                    switch (n2) {
                        default: {
                            return null;
                        }
                        case 3: {
                            return d;
                        }
                        case 2: {
                            return c;
                        }
                        case 1: {
                            return b;
                        }
                        case 0: 
                    }
                    return a;
                }

                @Override
                public final int a() {
                    return this.f;
                }

            }

        }

        public static interface b
        extends kotlin.reflect.jvm.internal.impl.f.r {
        }

        public static final class c
        extends i.b<ac, c>
        implements af {
            private int a;
            private List<a> b = Collections.emptyList();
            private boolean c;
            private int d;
            private ac e = ac.a();
            private int f;
            private int g;
            private int h;
            private int i;
            private int j;
            private ac k = ac.a();
            private int l;
            private ac m = ac.a();
            private int n;
            private int o;

            private c() {
                this.s();
            }

            private void s() {
            }

            private static c t() {
                return new c();
            }

            private void v() {
                if ((this.a & 1) != 1) {
                    this.b = new ArrayList<a>(this.b);
                    this.a |= 1;
                }
            }

            @Override
            public a a(int n2) {
                return this.b.get(n2);
            }

            public c a() {
                return c.t().a(this.d());
            }

            @Override
            public c a(ac ac2) {
                if (ac2 == ac.a()) {
                    return this;
                }
                if (!ac2.f.isEmpty()) {
                    if (this.b.isEmpty()) {
                        this.b = ac2.f;
                        this.a &= -2;
                    } else {
                        this.v();
                        this.b.addAll(ac2.f);
                    }
                }
                if (ac2.f()) {
                    this.a(ac2.g());
                }
                if (ac2.j()) {
                    this.b(ac2.k());
                }
                if (ac2.l()) {
                    this.b(ac2.p());
                }
                if (ac2.q()) {
                    this.c(ac2.r());
                }
                if (ac2.s()) {
                    this.d(ac2.t());
                }
                if (ac2.u()) {
                    this.e(ac2.v());
                }
                if (ac2.w()) {
                    this.f(ac2.x());
                }
                if (ac2.y()) {
                    this.g(ac2.z());
                }
                if (ac2.A()) {
                    this.c(ac2.B());
                }
                if (ac2.C()) {
                    this.h(ac2.D());
                }
                if (ac2.E()) {
                    this.d(ac2.F());
                }
                if (ac2.G()) {
                    this.i(ac2.H());
                }
                if (ac2.I()) {
                    this.j(ac2.J());
                }
                this.a(ac2);
                this.a(this.x().a(ac2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public c a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = ac.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((ac)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (ac)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((ac)object);
                throw var2_6;
            }

            @Override
            public c a(boolean bl2) {
                this.a |= 2;
                this.c = bl2;
                return this;
            }

            public c b(int n2) {
                this.a |= 4;
                this.d = n2;
                return this;
            }

            public c b(ac ac2) {
                ac ac3 = ac2;
                if ((this.a & 8) == 8) {
                    ac3 = ac2;
                    if (this.e != ac.a()) {
                        ac3 = ac.a(this.e).a(ac2).d();
                    }
                }
                this.e = ac3;
                this.a |= 8;
                return this;
            }

            public ac b() {
                return ac.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.a$a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public c c(int n2) {
                this.a |= 16;
                this.f = n2;
                return this;
            }

            public c c(ac ac2) {
                ac ac3 = ac2;
                if ((this.a & 512) == 512) {
                    ac3 = ac2;
                    if (this.k != ac.a()) {
                        ac3 = ac.a(this.k).a(ac2).d();
                    }
                }
                this.k = ac3;
                this.a |= 512;
                return this;
            }

            public ac c() {
                ac ac2 = this.d();
                if (ac2.h()) {
                    return ac2;
                }
                throw c.a(ac2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public c d(int n2) {
                this.a |= 32;
                this.g = n2;
                return this;
            }

            public c d(ac ac2) {
                ac ac3 = ac2;
                if ((this.a & 2048) == 2048) {
                    ac3 = ac2;
                    if (this.m != ac.a()) {
                        ac3 = ac.a(this.m).a(ac2).d();
                    }
                }
                this.m = ac3;
                this.a |= 2048;
                return this;
            }

            public ac d() {
                ac ac2 = new ac(this);
                int n2 = this.a;
                int n3 = this.a;
                int n4 = 1;
                if ((n3 & 1) == 1) {
                    this.b = Collections.unmodifiableList(this.b);
                    this.a &= -2;
                }
                ac2.f = this.b;
                if ((n2 & 2) != 2) {
                    n4 = 0;
                }
                ac2.g = this.c;
                n3 = n4;
                if ((n2 & 4) == 4) {
                    n3 = n4 | 2;
                }
                ac2.h = this.d;
                n4 = n3;
                if ((n2 & 8) == 8) {
                    n4 = n3 | 4;
                }
                ac2.i = this.e;
                n3 = n4;
                if ((n2 & 16) == 16) {
                    n3 = n4 | 8;
                }
                ac2.j = this.f;
                n4 = n3;
                if ((n2 & 32) == 32) {
                    n4 = n3 | 16;
                }
                ac2.k = this.g;
                n3 = n4;
                if ((n2 & 64) == 64) {
                    n3 = n4 | 32;
                }
                ac2.l = this.h;
                n4 = n3;
                if ((n2 & 128) == 128) {
                    n4 = n3 | 64;
                }
                ac2.m = this.i;
                n3 = n4;
                if ((n2 & 256) == 256) {
                    n3 = n4 | 128;
                }
                ac2.n = this.j;
                n4 = n3;
                if ((n2 & 512) == 512) {
                    n4 = n3 | 256;
                }
                ac2.o = this.k;
                n3 = n4;
                if ((n2 & 1024) == 1024) {
                    n3 = n4 | 512;
                }
                ac2.p = this.l;
                n4 = n3;
                if ((n2 & 2048) == 2048) {
                    n4 = n3 | 1024;
                }
                ac2.q = this.m;
                n3 = n4;
                if ((n2 & 4096) == 4096) {
                    n3 = n4 | 2048;
                }
                ac2.r = this.n;
                n4 = n3;
                if ((n2 & 8192) == 8192) {
                    n4 = n3 | 4096;
                }
                ac2.s = this.o;
                ac2.e = n4;
                return ac2;
            }

            public int e() {
                return this.b.size();
            }

            public c e(int n2) {
                this.a |= 64;
                this.h = n2;
                return this;
            }

            public c f(int n2) {
                this.a |= 128;
                this.i = n2;
                return this;
            }

            public boolean f() {
                return (this.a & 8) == 8;
            }

            public c g(int n2) {
                this.a |= 256;
                this.j = n2;
                return this;
            }

            public ac g() {
                return this.e;
            }

            public c h(int n2) {
                this.a |= 1024;
                this.l = n2;
                return this;
            }

            @Override
            public final boolean h() {
                for (int i2 = 0; i2 < this.e(); ++i2) {
                    if (this.a(i2).h()) continue;
                    return false;
                }
                if (this.f() && !this.g().h()) {
                    return false;
                }
                if (this.m() && !this.n().h()) {
                    return false;
                }
                if (this.p() && !this.q().h()) {
                    return false;
                }
                return this.y();
            }

            public c i(int n2) {
                this.a |= 4096;
                this.n = n2;
                return this;
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            public c j(int n2) {
                this.a |= 8192;
                this.o = n2;
                return this;
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.a$a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            public boolean m() {
                return (this.a & 512) == 512;
            }

            public ac n() {
                return this.k;
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }

            public boolean p() {
                return (this.a & 2048) == 2048;
            }

            public ac q() {
                return this.m;
            }

            @Override
            public /* synthetic */ i.b u() {
                return this.a();
            }
        }

    }

    public static final class ad
    extends i.c<ad>
    implements ae {
        public static kotlin.reflect.jvm.internal.impl.f.s<ad> a = new kotlin.reflect.jvm.internal.impl.f.b<ad>(){

            public ad a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new ad(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final ad c = new ad(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private int f;
        private int g;
        private List<ag> h;
        private ac i;
        private int j;
        private ac k;
        private int l;
        private List<kotlin.reflect.jvm.internal.impl.d.a$a> m;
        private List<Integer> n;
        private byte o;
        private int p;

        static {
            c.C();
        }

        /*
         * Exception decompiling
         */
        private ad(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: First case is not immediately after switch.
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:358)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:61)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:372)
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

        private ad(i.b<ad, ?> b2) {
            super(b2);
            this.o = (byte)-1;
            this.p = -1;
            this.d = b2.x();
        }

        private ad(boolean bl2) {
            this.o = (byte)-1;
            this.p = -1;
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        private void C() {
            this.f = 6;
            this.g = 0;
            this.h = Collections.emptyList();
            this.i = ac.a();
            this.j = 0;
            this.k = ac.a();
            this.l = 0;
            this.m = Collections.emptyList();
            this.n = Collections.emptyList();
        }

        public static a a(ad ad2) {
            return ad.z().a(ad2);
        }

        public static ad a() {
            return c;
        }

        public static ad a(InputStream inputStream, kotlin.reflect.jvm.internal.impl.f.g g2) {
            return a.e(inputStream, g2);
        }

        public static a z() {
            return a.t();
        }

        public a A() {
            return ad.z();
        }

        public a B() {
            return ad.a(this);
        }

        public ag a(int n2) {
            return this.h.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            int n2;
            this.i();
            i.c.a a2 = this.Q();
            if ((this.e & 1) == 1) {
                f2.a(1, this.f);
            }
            if ((this.e & 2) == 2) {
                f2.a(2, this.g);
            }
            int n3 = 0;
            for (n2 = 0; n2 < this.h.size(); ++n2) {
                f2.b(3, this.h.get(n2));
            }
            if ((this.e & 4) == 4) {
                f2.b(4, this.i);
            }
            if ((this.e & 8) == 8) {
                f2.a(5, this.j);
            }
            if ((this.e & 16) == 16) {
                f2.b(6, this.k);
            }
            if ((this.e & 32) == 32) {
                f2.a(7, this.l);
            }
            n2 = 0;
            do {
                if (n2 >= this.m.size()) break;
                f2.b(8, this.m.get(n2));
                ++n2;
            } while (true);
            for (int i2 = n3; i2 < this.n.size(); ++i2) {
                f2.a(31, this.n.get(i2));
            }
            a2.a(200, f2);
            f2.c(this.d);
        }

        public kotlin.reflect.jvm.internal.impl.d.a$a b(int n2) {
            return this.m.get(n2);
        }

        public ad b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<ad> c() {
            return a;
        }

        public boolean d() {
            return (this.e & 1) == 1;
        }

        public int e() {
            return this.f;
        }

        public boolean f() {
            return (this.e & 2) == 2;
        }

        public int g() {
            return this.g;
        }

        @Override
        public final boolean h() {
            int n2 = this.o;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            if (!this.f()) {
                this.o = 0;
                return false;
            }
            for (n2 = 0; n2 < this.k(); ++n2) {
                if (this.a(n2).h()) continue;
                this.o = 0;
                return false;
            }
            if (this.l() && !this.p().h()) {
                this.o = 0;
                return false;
            }
            if (this.s() && !this.t().h()) {
                this.o = 0;
                return false;
            }
            for (n2 = 0; n2 < this.x(); ++n2) {
                if (this.b(n2).h()) continue;
                this.o = 0;
                return false;
            }
            if (!this.P()) {
                this.o = 0;
                return false;
            }
            this.o = 1;
            return true;
        }

        @Override
        public int i() {
            int n2 = this.p;
            if (n2 != -1) {
                return n2;
            }
            n2 = this.e;
            int n3 = 0;
            n2 = (n2 & 1) == 1 ? kotlin.reflect.jvm.internal.impl.f.f.d(1, this.f) + 0 : 0;
            int n4 = n2;
            if ((this.e & 2) == 2) {
                n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(2, this.g);
            }
            n2 = n4;
            for (n4 = 0; n4 < this.h.size(); ++n4) {
                n2 += kotlin.reflect.jvm.internal.impl.f.f.d(3, this.h.get(n4));
            }
            n4 = n2;
            if ((this.e & 4) == 4) {
                n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(4, this.i);
            }
            n2 = n4;
            if ((this.e & 8) == 8) {
                n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.d(5, this.j);
            }
            n4 = n2;
            if ((this.e & 16) == 16) {
                n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(6, this.k);
            }
            n2 = n4;
            if ((this.e & 32) == 32) {
                n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.d(7, this.l);
            }
            for (n4 = 0; n4 < this.m.size(); ++n4) {
                n2 += kotlin.reflect.jvm.internal.impl.f.f.d(8, this.m.get(n4));
            }
            int n5 = 0;
            n4 = n3;
            n3 = n5;
            while (n4 < this.n.size()) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.h(this.n.get(n4));
                ++n4;
            }
            this.p = n2 = n2 + n3 + this.y().size() * 2 + this.R() + this.d.a();
            return n2;
        }

        public List<ag> j() {
            return this.h;
        }

        public int k() {
            return this.h.size();
        }

        public boolean l() {
            return (this.e & 4) == 4;
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.B();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.A();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public ac p() {
            return this.i;
        }

        public boolean q() {
            return (this.e & 8) == 8;
        }

        public int r() {
            return this.j;
        }

        public boolean s() {
            return (this.e & 16) == 16;
        }

        public ac t() {
            return this.k;
        }

        public boolean u() {
            return (this.e & 32) == 32;
        }

        public int v() {
            return this.l;
        }

        public List<kotlin.reflect.jvm.internal.impl.d.a$a> w() {
            return this.m;
        }

        public int x() {
            return this.m.size();
        }

        public List<Integer> y() {
            return this.n;
        }

        public static final class a
        extends i.b<ad, a>
        implements ae {
            private int a;
            private int b = 6;
            private int c;
            private List<ag> d = Collections.emptyList();
            private ac e = ac.a();
            private int f;
            private ac g = ac.a();
            private int h;
            private List<kotlin.reflect.jvm.internal.impl.d.a$a> i = Collections.emptyList();
            private List<Integer> j = Collections.emptyList();

            private a() {
                this.s();
            }

            private void s() {
            }

            private static a t() {
                return new a();
            }

            private void v() {
                if ((this.a & 4) != 4) {
                    this.d = new ArrayList<ag>(this.d);
                    this.a |= 4;
                }
            }

            private void w() {
                if ((this.a & 128) != 128) {
                    this.i = new ArrayList<kotlin.reflect.jvm.internal.impl.d.a$a>(this.i);
                    this.a |= 128;
                }
            }

            private void z() {
                if ((this.a & 256) != 256) {
                    this.j = new ArrayList<Integer>(this.j);
                    this.a |= 256;
                }
            }

            public a a() {
                return a.t().a(this.d());
            }

            @Override
            public a a(int n2) {
                this.a |= 1;
                this.b = n2;
                return this;
            }

            @Override
            public a a(ac ac2) {
                ac ac3 = ac2;
                if ((this.a & 8) == 8) {
                    ac3 = ac2;
                    if (this.e != ac.a()) {
                        ac3 = ac.a(this.e).a(ac2).d();
                    }
                }
                this.e = ac3;
                this.a |= 8;
                return this;
            }

            @Override
            public a a(ad ad2) {
                if (ad2 == ad.a()) {
                    return this;
                }
                if (ad2.d()) {
                    this.a(ad2.e());
                }
                if (ad2.f()) {
                    this.b(ad2.g());
                }
                if (!ad2.h.isEmpty()) {
                    if (this.d.isEmpty()) {
                        this.d = ad2.h;
                        this.a &= -5;
                    } else {
                        this.v();
                        this.d.addAll(ad2.h);
                    }
                }
                if (ad2.l()) {
                    this.a(ad2.p());
                }
                if (ad2.q()) {
                    this.d(ad2.r());
                }
                if (ad2.s()) {
                    this.b(ad2.t());
                }
                if (ad2.u()) {
                    this.e(ad2.v());
                }
                if (!ad2.m.isEmpty()) {
                    if (this.i.isEmpty()) {
                        this.i = ad2.m;
                        this.a &= -129;
                    } else {
                        this.w();
                        this.i.addAll(ad2.m);
                    }
                }
                if (!ad2.n.isEmpty()) {
                    if (this.j.isEmpty()) {
                        this.j = ad2.n;
                        this.a &= -257;
                    } else {
                        this.z();
                        this.j.addAll(ad2.n);
                    }
                }
                this.a(ad2);
                this.a(this.x().a(ad2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = ad.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((ad)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (ad)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((ad)object);
                throw var2_6;
            }

            public a b(int n2) {
                this.a |= 2;
                this.c = n2;
                return this;
            }

            public a b(ac ac2) {
                ac ac3 = ac2;
                if ((this.a & 32) == 32) {
                    ac3 = ac2;
                    if (this.g != ac.a()) {
                        ac3 = ac.a(this.g).a(ac2).d();
                    }
                }
                this.g = ac3;
                this.a |= 32;
                return this;
            }

            public ad b() {
                return ad.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public ad c() {
                ad ad2 = this.d();
                if (ad2.h()) {
                    return ad2;
                }
                throw a.a(ad2);
            }

            public ag c(int n2) {
                return this.d.get(n2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public a d(int n2) {
                this.a |= 16;
                this.f = n2;
                return this;
            }

            public ad d() {
                ad ad2 = new ad(this);
                int n2 = this.a;
                int n3 = 1;
                if ((n2 & 1) != 1) {
                    n3 = 0;
                }
                ad2.f = this.b;
                int n4 = n3;
                if ((n2 & 2) == 2) {
                    n4 = n3 | 2;
                }
                ad2.g = this.c;
                if ((this.a & 4) == 4) {
                    this.d = Collections.unmodifiableList(this.d);
                    this.a &= -5;
                }
                ad2.h = this.d;
                n3 = n4;
                if ((n2 & 8) == 8) {
                    n3 = n4 | 4;
                }
                ad2.i = this.e;
                n4 = n3;
                if ((n2 & 16) == 16) {
                    n4 = n3 | 8;
                }
                ad2.j = this.f;
                n3 = n4;
                if ((n2 & 32) == 32) {
                    n3 = n4 | 16;
                }
                ad2.k = this.g;
                n4 = n3;
                if ((n2 & 64) == 64) {
                    n4 = n3 | 32;
                }
                ad2.l = this.h;
                if ((this.a & 128) == 128) {
                    this.i = Collections.unmodifiableList(this.i);
                    this.a &= -129;
                }
                ad2.m = this.i;
                if ((this.a & 256) == 256) {
                    this.j = Collections.unmodifiableList(this.j);
                    this.a &= -257;
                }
                ad2.n = this.j;
                ad2.e = n4;
                return ad2;
            }

            public a e(int n2) {
                this.a |= 64;
                this.h = n2;
                return this;
            }

            public boolean e() {
                return (this.a & 2) == 2;
            }

            public int f() {
                return this.d.size();
            }

            public kotlin.reflect.jvm.internal.impl.d.a$a f(int n2) {
                return this.i.get(n2);
            }

            public boolean g() {
                return (this.a & 8) == 8;
            }

            @Override
            public final boolean h() {
                int n2;
                if (!this.e()) {
                    return false;
                }
                for (n2 = 0; n2 < this.f(); ++n2) {
                    if (this.c(n2).h()) continue;
                    return false;
                }
                if (this.g() && !this.m().h()) {
                    return false;
                }
                if (this.n() && !this.p().h()) {
                    return false;
                }
                for (n2 = 0; n2 < this.q(); ++n2) {
                    if (this.f(n2).h()) continue;
                    return false;
                }
                return this.y();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            public ac m() {
                return this.e;
            }

            public boolean n() {
                return (this.a & 32) == 32;
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }

            public ac p() {
                return this.g;
            }

            public int q() {
                return this.i.size();
            }

            @Override
            public /* synthetic */ i.b u() {
                return this.a();
            }
        }

    }

    public static interface ae
    extends i.d {
    }

    public static interface af
    extends i.d {
    }

    public static final class ag
    extends i.c<ag>
    implements ah {
        public static kotlin.reflect.jvm.internal.impl.f.s<ag> a = new kotlin.reflect.jvm.internal.impl.f.b<ag>(){

            public ag a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new ag(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final ag c = new ag(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private int f;
        private int g;
        private boolean h;
        private b i;
        private List<ac> j;
        private List<Integer> k;
        private int l = -1;
        private byte m = (byte)-1;
        private int n = -1;

        static {
            c.w();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private ag(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.w();
            var12_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var13_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var12_10, 1);
            var8_12 = false;
            var3_13 = 0;
            block11 : while (!var8_12) {
                block27 : {
                    block28 : {
                        var4_14 = var3_13;
                        var5_15 = var3_13;
                        var6_16 = var3_13;
                        var7_17 = var1_1.a();
                        if (var7_17 == 0) break block28;
                        if (var7_17 == 8) ** GOTO lbl146
                        if (var7_17 == 16) ** GOTO lbl137
                        if (var7_17 == 24) ** GOTO lbl128
                        if (var7_17 == 32) ** GOTO lbl101
                        if (var7_17 == 42) ** GOTO lbl84
                        if (var7_17 == 48) ** GOTO lbl62
                        if (var7_17 != 50) {
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            if (this.a(var1_1, var13_11, var2_8, var7_17)) continue;
                        } else {
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var9_18 = var1_1.c(var1_1.s());
                            var7_17 = var3_13;
                            if ((var3_13 & 32) != 32) {
                                var7_17 = var3_13;
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                if (var1_1.x() > 0) {
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    this.k = new ArrayList<Integer>();
                                    var7_17 = var3_13 | 32;
                                }
                            }
                            do {
                                var4_14 = var7_17;
                                var5_15 = var7_17;
                                var6_16 = var7_17;
                                if (var1_1.x() <= 0) break;
                                var4_14 = var7_17;
                                var5_15 = var7_17;
                                var6_16 = var7_17;
                                this.k.add(var1_1.f());
                            } while (true);
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var1_1.d(var9_18);
                            var3_13 = var7_17;
                            continue;
lbl62: // 1 sources:
                            var7_17 = var3_13;
                            if ((var3_13 & 32) != 32) {
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                this.k = new ArrayList<Integer>();
                                var7_17 = var3_13 | 32;
                            }
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var10_19 = this.k;
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var11_20 /* !! */  = Integer.valueOf(var1_1.f());
                            var3_13 = var7_17;
lbl78: // 2 sources:
                            do {
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var10_19.add((Integer)var11_20 /* !! */ );
                                continue block11;
                                break;
                            } while (true);
lbl84: // 1 sources:
                            var7_17 = var3_13;
                            if ((var3_13 & 16) != 16) {
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                this.j = new ArrayList<ac>();
                                var7_17 = var3_13 | 16;
                            }
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var10_19 = this.j;
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var11_20 /* !! */  = var1_1.a(ac.a, var2_8);
                            var3_13 = var7_17;
                            ** continue;
lbl101: // 1 sources:
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var9_18 = var1_1.n();
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var10_19 = b.a(var9_18);
                            if (var10_19 == null) {
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var13_11.p(var7_17);
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var13_11.p(var9_18);
                                continue;
                            }
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            this.e |= 8;
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            this.i = var10_19;
                            continue;
lbl128: // 1 sources:
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            this.e |= 4;
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            this.h = var1_1.i();
                            continue;
lbl137: // 1 sources:
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            this.e |= 2;
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            this.g = var1_1.f();
                            continue;
lbl146: // 1 sources:
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            this.e |= 1;
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            this.f = var1_1.f();
                            continue;
                        }
                    }
                    var8_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block27;
                    }
                    catch (IOException var1_3) {
                        var4_14 = var5_15;
                        throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                        var4_14 = var6_16;
                        throw var1_4.a(this);
                    }
                }
                if ((var4_14 & 16) == 16) {
                    this.j = Collections.unmodifiableList(this.j);
                }
                if ((var4_14 & 32) == 32) {
                    this.k = Collections.unmodifiableList(this.k);
                }
                try {
                    var13_11.a();
lbl173: // 2 sources:
                    do {
                        this.d = var12_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var12_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            if ((var3_13 & 16) == 16) {
                this.j = Collections.unmodifiableList(this.j);
            }
            if ((var3_13 & 32) == 32) {
                this.k = Collections.unmodifiableList(this.k);
            }
            try {
                var13_11.a();
lbl187: // 2 sources:
                do {
                    this.d = var12_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var12_10.a();
                throw var1_6;
            }
            this.O();
            return;
            catch (IOException var2_9) {
                ** continue;
            }
            catch (IOException var1_7) {
                ** continue;
            }
        }

        private ag(i.b<ag, ?> b2) {
            super(b2);
            this.d = b2.x();
        }

        private ag(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(ag ag2) {
            return ag.t().a(ag2);
        }

        public static ag a() {
            return c;
        }

        public static a t() {
            return a.p();
        }

        private void w() {
            this.f = 0;
            this.g = 0;
            this.h = false;
            this.i = b.c;
            this.j = Collections.emptyList();
            this.k = Collections.emptyList();
        }

        public ac a(int n2) {
            return this.j.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            int n2;
            this.i();
            i.c.a a2 = this.Q();
            if ((this.e & 1) == 1) {
                f2.a(1, this.f);
            }
            if ((this.e & 2) == 2) {
                f2.a(2, this.g);
            }
            if ((this.e & 4) == 4) {
                f2.a(3, this.h);
            }
            if ((this.e & 8) == 8) {
                f2.c(4, this.i.a());
            }
            int n3 = 0;
            for (n2 = 0; n2 < this.j.size(); ++n2) {
                f2.b(5, this.j.get(n2));
            }
            n2 = n3;
            if (this.s().size() > 0) {
                f2.p(50);
                f2.p(this.l);
                n2 = n3;
            }
            while (n2 < this.k.size()) {
                f2.b(this.k.get(n2));
                ++n2;
            }
            a2.a(1000, f2);
            f2.c(this.d);
        }

        public ag b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<ag> c() {
            return a;
        }

        public boolean d() {
            return (this.e & 1) == 1;
        }

        public int e() {
            return this.f;
        }

        public boolean f() {
            return (this.e & 2) == 2;
        }

        public int g() {
            return this.g;
        }

        @Override
        public final boolean h() {
            int n2 = this.m;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            if (!this.d()) {
                this.m = 0;
                return false;
            }
            if (!this.f()) {
                this.m = 0;
                return false;
            }
            for (n2 = 0; n2 < this.r(); ++n2) {
                if (this.a(n2).h()) continue;
                this.m = 0;
                return false;
            }
            if (!this.P()) {
                this.m = 0;
                return false;
            }
            this.m = 1;
            return true;
        }

        @Override
        public int i() {
            int n2 = this.n;
            if (n2 != -1) {
                return n2;
            }
            n2 = this.e;
            int n3 = 0;
            int n4 = (n2 & 1) == 1 ? kotlin.reflect.jvm.internal.impl.f.f.d(1, this.f) + 0 : 0;
            n2 = n4;
            if ((this.e & 2) == 2) {
                n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.d(2, this.g);
            }
            n4 = n2;
            if ((this.e & 4) == 4) {
                n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.b(3, this.h);
            }
            n2 = n4;
            if ((this.e & 8) == 8) {
                n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.e(4, this.i.a());
            }
            for (n4 = 0; n4 < this.j.size(); ++n4) {
                n2 += kotlin.reflect.jvm.internal.impl.f.f.d(5, this.j.get(n4));
            }
            n4 = 0;
            while (n3 < this.k.size()) {
                n4 += kotlin.reflect.jvm.internal.impl.f.f.h(this.k.get(n3));
                ++n3;
            }
            n2 = n3 = n2 + n4;
            if (!this.s().isEmpty()) {
                n2 = n3 + 1 + kotlin.reflect.jvm.internal.impl.f.f.h(n4);
            }
            this.l = n4;
            this.n = n2 = n2 + this.R() + this.d.a();
            return n2;
        }

        public boolean j() {
            return (this.e & 4) == 4;
        }

        public boolean k() {
            return this.h;
        }

        public boolean l() {
            return (this.e & 8) == 8;
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.v();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.u();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public b p() {
            return this.i;
        }

        public List<ac> q() {
            return this.j;
        }

        public int r() {
            return this.j.size();
        }

        public List<Integer> s() {
            return this.k;
        }

        public a u() {
            return ag.t();
        }

        public a v() {
            return ag.a(this);
        }

        public static final class a
        extends i.b<ag, a>
        implements ah {
            private int a;
            private int b;
            private int c;
            private boolean d;
            private b e = b.c;
            private List<ac> f = Collections.emptyList();
            private List<Integer> g = Collections.emptyList();

            private a() {
                this.n();
            }

            private void n() {
            }

            private static a p() {
                return new a();
            }

            private void q() {
                if ((this.a & 16) != 16) {
                    this.f = new ArrayList<ac>(this.f);
                    this.a |= 16;
                }
            }

            private void r() {
                if ((this.a & 32) != 32) {
                    this.g = new ArrayList<Integer>(this.g);
                    this.a |= 32;
                }
            }

            public a a() {
                return a.p().a(this.d());
            }

            @Override
            public a a(int n2) {
                this.a |= 1;
                this.b = n2;
                return this;
            }

            @Override
            public a a(b b2) {
                if (b2 != null) {
                    this.a |= 8;
                    this.e = b2;
                    return this;
                }
                throw new NullPointerException();
            }

            @Override
            public a a(ag ag2) {
                if (ag2 == ag.a()) {
                    return this;
                }
                if (ag2.d()) {
                    this.a(ag2.e());
                }
                if (ag2.f()) {
                    this.b(ag2.g());
                }
                if (ag2.j()) {
                    this.a(ag2.k());
                }
                if (ag2.l()) {
                    this.a(ag2.p());
                }
                if (!ag2.j.isEmpty()) {
                    if (this.f.isEmpty()) {
                        this.f = ag2.j;
                        this.a &= -17;
                    } else {
                        this.q();
                        this.f.addAll(ag2.j);
                    }
                }
                if (!ag2.k.isEmpty()) {
                    if (this.g.isEmpty()) {
                        this.g = ag2.k;
                        this.a &= -33;
                    } else {
                        this.r();
                        this.g.addAll(ag2.k);
                    }
                }
                this.a(ag2);
                this.a(this.x().a(ag2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = ag.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((ag)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (ag)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((ag)object);
                throw var2_6;
            }

            @Override
            public a a(boolean bl2) {
                this.a |= 4;
                this.d = bl2;
                return this;
            }

            public a b(int n2) {
                this.a |= 2;
                this.c = n2;
                return this;
            }

            public ag b() {
                return ag.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public ac c(int n2) {
                return this.f.get(n2);
            }

            public ag c() {
                ag ag2 = this.d();
                if (ag2.h()) {
                    return ag2;
                }
                throw a.a(ag2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public ag d() {
                ag ag2 = new ag(this);
                int n2 = this.a;
                int n3 = 1;
                if ((n2 & 1) != 1) {
                    n3 = 0;
                }
                ag2.f = this.b;
                int n4 = n3;
                if ((n2 & 2) == 2) {
                    n4 = n3 | 2;
                }
                ag2.g = this.c;
                n3 = n4;
                if ((n2 & 4) == 4) {
                    n3 = n4 | 4;
                }
                ag2.h = this.d;
                n4 = n3;
                if ((n2 & 8) == 8) {
                    n4 = n3 | 8;
                }
                ag2.i = this.e;
                if ((this.a & 16) == 16) {
                    this.f = Collections.unmodifiableList(this.f);
                    this.a &= -17;
                }
                ag2.j = this.f;
                if ((this.a & 32) == 32) {
                    this.g = Collections.unmodifiableList(this.g);
                    this.a &= -33;
                }
                ag2.k = this.g;
                ag2.e = n4;
                return ag2;
            }

            public boolean e() {
                return (this.a & 1) == 1;
            }

            public boolean f() {
                return (this.a & 2) == 2;
            }

            public int g() {
                return this.f.size();
            }

            @Override
            public final boolean h() {
                if (!this.e()) {
                    return false;
                }
                if (!this.f()) {
                    return false;
                }
                for (int i2 = 0; i2 < this.g(); ++i2) {
                    if (this.c(i2).h()) continue;
                    return false;
                }
                return this.y();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.b u() {
                return this.a();
            }
        }

        public static enum b implements j.a
        {
            a(0, 0),
            b(1, 1),
            c(2, 2);
            
            private static j.b<b> d;
            private final int e;

            static {
                d = new j.b<b>(){

                    public b a(int n2) {
                        return b.a(n2);
                    }

                    @Override
                    public /* synthetic */ j.a b(int n2) {
                        return this.a(n2);
                    }
                };
            }

            private b(int n3, int n4) {
                this.e = n4;
            }

            public static b a(int n2) {
                switch (n2) {
                    default: {
                        return null;
                    }
                    case 2: {
                        return c;
                    }
                    case 1: {
                        return b;
                    }
                    case 0: 
                }
                return a;
            }

            @Override
            public final int a() {
                return this.e;
            }

        }

    }

    public static interface ah
    extends i.d {
    }

    public static final class ai
    extends kotlin.reflect.jvm.internal.impl.f.i
    implements aj {
        public static kotlin.reflect.jvm.internal.impl.f.s<ai> a = new kotlin.reflect.jvm.internal.impl.f.b<ai>(){

            public ai a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new ai(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final ai c = new ai(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private List<ac> f;
        private int g;
        private byte h = (byte)-1;
        private int i = -1;

        static {
            c.p();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private ai(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.p();
            var9_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var10_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var9_10, 1);
            var8_12 = false;
            var3_13 = 0;
            while (!var8_12) {
                block19 : {
                    block20 : {
                        var5_15 = var3_13;
                        var6_16 = var3_13;
                        var7_17 = var3_13;
                        var4_14 = var1_1.a();
                        if (var4_14 == 0) break block20;
                        if (var4_14 == 10) ** GOTO lbl33
                        if (var4_14 != 16) {
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            if (this.a(var1_1, var10_11, var2_8, var4_14)) continue;
                        } else {
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.e |= 1;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.g = var1_1.f();
                            continue;
lbl33: // 1 sources:
                            var4_14 = var3_13;
                            if ((var3_13 & 1) != 1) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.f = new ArrayList<ac>();
                                var4_14 = var3_13 | 1;
                            }
                            var5_15 = var4_14;
                            var6_16 = var4_14;
                            var7_17 = var4_14;
                            this.f.add(var1_1.a(ac.a, var2_8));
                            var3_13 = var4_14;
                            continue;
                        }
                    }
                    var8_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block19;
                    }
                    catch (IOException var1_3) {
                        var5_15 = var6_16;
                        throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                        var5_15 = var7_17;
                        throw var1_4.a(this);
                    }
                }
                if (var5_15 & true) {
                    this.f = Collections.unmodifiableList(this.f);
                }
                try {
                    var10_11.a();
lbl62: // 2 sources:
                    do {
                        this.d = var9_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var9_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            if (var3_13 & true) {
                this.f = Collections.unmodifiableList(this.f);
            }
            try {
                var10_11.a();
lbl74: // 2 sources:
                do {
                    this.d = var9_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var9_10.a();
                throw var1_6;
            }
            this.O();
            return;
            catch (IOException var2_9) {
                ** continue;
            }
            catch (IOException var1_7) {
                ** continue;
            }
        }

        private ai(i.a a2) {
            super(a2);
            this.d = a2.x();
        }

        private ai(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(ai ai2) {
            return ai.j().a(ai2);
        }

        public static ai a() {
            return c;
        }

        public static a j() {
            return a.m();
        }

        private void p() {
            this.f = Collections.emptyList();
            this.g = -1;
        }

        public ac a(int n2) {
            return this.f.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            this.i();
            for (int i2 = 0; i2 < this.f.size(); ++i2) {
                f2.b(1, this.f.get(i2));
            }
            if ((this.e & 1) == 1) {
                f2.a(2, this.g);
            }
            f2.c(this.d);
        }

        public ai b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<ai> c() {
            return a;
        }

        public List<ac> d() {
            return this.f;
        }

        public int e() {
            return this.f.size();
        }

        public boolean f() {
            return (this.e & 1) == 1;
        }

        public int g() {
            return this.g;
        }

        @Override
        public final boolean h() {
            int n2 = this.h;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            for (n2 = 0; n2 < this.e(); ++n2) {
                if (this.a(n2).h()) continue;
                this.h = 0;
                return false;
            }
            this.h = 1;
            return true;
        }

        @Override
        public int i() {
            int n2;
            int n3 = this.i;
            if (n3 != -1) {
                return n3;
            }
            n3 = 0;
            for (n2 = 0; n2 < this.f.size(); ++n2) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(1, this.f.get(n2));
            }
            n2 = n3;
            if ((this.e & 1) == 1) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(2, this.g);
            }
            this.i = n3 = n2 + this.d.a();
            return n3;
        }

        public a k() {
            return ai.j();
        }

        public a l() {
            return ai.a(this);
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.l();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.k();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public static final class a
        extends i.a<ai, a>
        implements aj {
            private int a;
            private List<ac> b = Collections.emptyList();
            private int c = -1;

            private a() {
                this.g();
            }

            private void g() {
            }

            private static a m() {
                return new a();
            }

            private void n() {
                if ((this.a & 1) != 1) {
                    this.b = new ArrayList<ac>(this.b);
                    this.a |= 1;
                }
            }

            @Override
            public ac a(int n2) {
                return this.b.get(n2);
            }

            public a a() {
                return a.m().a(this.d());
            }

            @Override
            public a a(ai ai2) {
                if (ai2 == ai.a()) {
                    return this;
                }
                if (!ai2.f.isEmpty()) {
                    if (this.b.isEmpty()) {
                        this.b = ai2.f;
                        this.a &= -2;
                    } else {
                        this.n();
                        this.b.addAll(ai2.f);
                    }
                }
                if (ai2.f()) {
                    this.b(ai2.g());
                }
                this.a(this.x().a(ai2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = ai.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((ai)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (ai)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((ai)object);
                throw var2_6;
            }

            public a b(int n2) {
                this.a |= 2;
                this.c = n2;
                return this;
            }

            public ai b() {
                return ai.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public ai c() {
                ai ai2 = this.d();
                if (ai2.h()) {
                    return ai2;
                }
                throw a.a(ai2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public ai d() {
                ai ai2 = new ai(this);
                int n2 = this.a;
                int n3 = this.a;
                int n4 = 1;
                if ((n3 & 1) == 1) {
                    this.b = Collections.unmodifiableList(this.b);
                    this.a &= -2;
                }
                ai2.f = this.b;
                if ((n2 & 2) != 2) {
                    n4 = 0;
                }
                ai2.g = this.c;
                ai2.e = n4;
                return ai2;
            }

            public int e() {
                return this.b.size();
            }

            @Override
            public final boolean h() {
                for (int i2 = 0; i2 < this.e(); ++i2) {
                    if (this.a(i2).h()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }
        }

    }

    public static interface aj
    extends kotlin.reflect.jvm.internal.impl.f.r {
    }

    public static final class ak
    extends i.c<ak>
    implements al {
        public static kotlin.reflect.jvm.internal.impl.f.s<ak> a = new kotlin.reflect.jvm.internal.impl.f.b<ak>(){

            public ak a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new ak(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final ak c = new ak(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private int f;
        private int g;
        private ac h;
        private int i;
        private ac j;
        private int k;
        private byte l = (byte)-1;
        private int m = -1;

        static {
            c.x();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private ak(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.x();
            var7_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var8_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var7_10, 1);
            var3_12 = false;
            while (!var3_12) {
                block20 : {
                    block21 : {
                        var4_13 = var1_1.a();
                        if (var4_13 == 0) break block21;
                        if (var4_13 == 8) ** GOTO lbl49
                        if (var4_13 == 16) ** GOTO lbl46
                        var6_15 = null;
                        var5_14 = null;
                        if (var4_13 == 26) ** GOTO lbl37
                        if (var4_13 == 34) ** GOTO lbl29
                        if (var4_13 == 40) ** GOTO lbl26
                        if (var4_13 != 48) {
                            if (this.a(var1_1, var8_11, var2_8, var4_13)) continue;
                        } else {
                            this.e |= 32;
                            this.k = var1_1.f();
                            continue;
lbl26: // 1 sources:
                            this.e |= 8;
                            this.i = var1_1.f();
                            continue;
lbl29: // 1 sources:
                            if ((this.e & 16) == 16) {
                                var5_14 = this.j.M();
                            }
                            this.j = var1_1.a(ac.a, var2_8);
                            if (var5_14 != null) {
                                var5_14.a(this.j);
                                this.j = var5_14.d();
                            }
                            this.e |= 16;
                            continue;
lbl37: // 1 sources:
                            var5_14 = var6_15;
                            if ((this.e & 4) == 4) {
                                var5_14 = this.h.M();
                            }
                            this.h = var1_1.a(ac.a, var2_8);
                            if (var5_14 != null) {
                                var5_14.a(this.h);
                                this.h = var5_14.d();
                            }
                            this.e |= 4;
                            continue;
lbl46: // 1 sources:
                            this.e |= 2;
                            this.g = var1_1.f();
                            continue;
lbl49: // 1 sources:
                            this.e |= 1;
                            this.f = var1_1.f();
                            continue;
                        }
                    }
                    var3_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block20;
                    }
                    catch (IOException var1_3) {
                        throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                        throw var1_4.a(this);
                    }
                }
                try {
                    var8_11.a();
lbl64: // 2 sources:
                    do {
                        this.d = var7_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var7_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            try {
                var8_11.a();
lbl74: // 2 sources:
                do {
                    this.d = var7_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var7_10.a();
                throw var1_6;
            }
            this.O();
            return;
            catch (IOException var2_9) {
                ** continue;
            }
            catch (IOException var1_7) {
                ** continue;
            }
        }

        private ak(i.b<ak, ?> b2) {
            super(b2);
            this.d = b2.x();
        }

        private ak(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(ak ak2) {
            return ak.u().a(ak2);
        }

        public static ak a() {
            return c;
        }

        public static a u() {
            return a.r();
        }

        private void x() {
            this.f = 0;
            this.g = 0;
            this.h = ac.a();
            this.i = 0;
            this.j = ac.a();
            this.k = 0;
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            this.i();
            i.c.a a2 = this.Q();
            if ((this.e & 1) == 1) {
                f2.a(1, this.f);
            }
            if ((this.e & 2) == 2) {
                f2.a(2, this.g);
            }
            if ((this.e & 4) == 4) {
                f2.b(3, this.h);
            }
            if ((this.e & 16) == 16) {
                f2.b(4, this.j);
            }
            if ((this.e & 8) == 8) {
                f2.a(5, this.i);
            }
            if ((this.e & 32) == 32) {
                f2.a(6, this.k);
            }
            a2.a(200, f2);
            f2.c(this.d);
        }

        public ak b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<ak> c() {
            return a;
        }

        public boolean d() {
            return (this.e & 1) == 1;
        }

        public int e() {
            return this.f;
        }

        public boolean f() {
            return (this.e & 2) == 2;
        }

        public int g() {
            return this.g;
        }

        @Override
        public final boolean h() {
            byte by2 = this.l;
            if (by2 == 1) {
                return true;
            }
            if (by2 == 0) {
                return false;
            }
            if (!this.f()) {
                this.l = 0;
                return false;
            }
            if (this.j() && !this.k().h()) {
                this.l = 0;
                return false;
            }
            if (this.q() && !this.r().h()) {
                this.l = 0;
                return false;
            }
            if (!this.P()) {
                this.l = 0;
                return false;
            }
            this.l = 1;
            return true;
        }

        @Override
        public int i() {
            int n2 = this.m;
            if (n2 != -1) {
                return n2;
            }
            int n3 = 0;
            if ((this.e & 1) == 1) {
                n3 = 0 + kotlin.reflect.jvm.internal.impl.f.f.d(1, this.f);
            }
            n2 = n3;
            if ((this.e & 2) == 2) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(2, this.g);
            }
            n3 = n2;
            if ((this.e & 4) == 4) {
                n3 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(3, this.h);
            }
            n2 = n3;
            if ((this.e & 16) == 16) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(4, this.j);
            }
            n3 = n2;
            if ((this.e & 8) == 8) {
                n3 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(5, this.i);
            }
            n2 = n3;
            if ((this.e & 32) == 32) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(6, this.k);
            }
            this.m = n2 = n2 + this.R() + this.d.a();
            return n2;
        }

        public boolean j() {
            return (this.e & 4) == 4;
        }

        public ac k() {
            return this.h;
        }

        public boolean l() {
            return (this.e & 8) == 8;
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.w();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.v();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public int p() {
            return this.i;
        }

        public boolean q() {
            return (this.e & 16) == 16;
        }

        public ac r() {
            return this.j;
        }

        public boolean s() {
            return (this.e & 32) == 32;
        }

        public int t() {
            return this.k;
        }

        public a v() {
            return ak.u();
        }

        public a w() {
            return ak.a(this);
        }

        public static final class a
        extends i.b<ak, a>
        implements al {
            private int a;
            private int b;
            private int c;
            private ac d = ac.a();
            private int e;
            private ac f = ac.a();
            private int g;

            private a() {
                this.q();
            }

            private void q() {
            }

            private static a r() {
                return new a();
            }

            public a a() {
                return a.r().a(this.d());
            }

            @Override
            public a a(int n2) {
                this.a |= 1;
                this.b = n2;
                return this;
            }

            @Override
            public a a(ac ac2) {
                ac ac3 = ac2;
                if ((this.a & 4) == 4) {
                    ac3 = ac2;
                    if (this.d != ac.a()) {
                        ac3 = ac.a(this.d).a(ac2).d();
                    }
                }
                this.d = ac3;
                this.a |= 4;
                return this;
            }

            @Override
            public a a(ak ak2) {
                if (ak2 == ak.a()) {
                    return this;
                }
                if (ak2.d()) {
                    this.a(ak2.e());
                }
                if (ak2.f()) {
                    this.b(ak2.g());
                }
                if (ak2.j()) {
                    this.a(ak2.k());
                }
                if (ak2.l()) {
                    this.c(ak2.p());
                }
                if (ak2.q()) {
                    this.b(ak2.r());
                }
                if (ak2.s()) {
                    this.d(ak2.t());
                }
                this.a(ak2);
                this.a(this.x().a(ak2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = ak.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((ak)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (ak)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((ak)object);
                throw var2_6;
            }

            public a b(int n2) {
                this.a |= 2;
                this.c = n2;
                return this;
            }

            public a b(ac ac2) {
                ac ac3 = ac2;
                if ((this.a & 16) == 16) {
                    ac3 = ac2;
                    if (this.f != ac.a()) {
                        ac3 = ac.a(this.f).a(ac2).d();
                    }
                }
                this.f = ac3;
                this.a |= 16;
                return this;
            }

            public ak b() {
                return ak.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public a c(int n2) {
                this.a |= 8;
                this.e = n2;
                return this;
            }

            public ak c() {
                ak ak2 = this.d();
                if (ak2.h()) {
                    return ak2;
                }
                throw a.a(ak2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public a d(int n2) {
                this.a |= 32;
                this.g = n2;
                return this;
            }

            public ak d() {
                ak ak2 = new ak(this);
                int n2 = this.a;
                int n3 = 1;
                if ((n2 & 1) != 1) {
                    n3 = 0;
                }
                ak2.f = this.b;
                int n4 = n3;
                if ((n2 & 2) == 2) {
                    n4 = n3 | 2;
                }
                ak2.g = this.c;
                n3 = n4;
                if ((n2 & 4) == 4) {
                    n3 = n4 | 4;
                }
                ak2.h = this.d;
                n4 = n3;
                if ((n2 & 8) == 8) {
                    n4 = n3 | 8;
                }
                ak2.i = this.e;
                n3 = n4;
                if ((n2 & 16) == 16) {
                    n3 = n4 | 16;
                }
                ak2.j = this.f;
                n4 = n3;
                if ((n2 & 32) == 32) {
                    n4 = n3 | 32;
                }
                ak2.k = this.g;
                ak2.e = n4;
                return ak2;
            }

            public boolean e() {
                return (this.a & 2) == 2;
            }

            public boolean f() {
                return (this.a & 4) == 4;
            }

            public ac g() {
                return this.d;
            }

            @Override
            public final boolean h() {
                if (!this.e()) {
                    return false;
                }
                if (this.f() && !this.g().h()) {
                    return false;
                }
                if (this.m() && !this.n().h()) {
                    return false;
                }
                return this.y();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            public boolean m() {
                return (this.a & 16) == 16;
            }

            public ac n() {
                return this.f;
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.b u() {
                return this.a();
            }
        }

    }

    public static interface al
    extends i.d {
    }

    public static final class am
    extends kotlin.reflect.jvm.internal.impl.f.i
    implements an {
        public static kotlin.reflect.jvm.internal.impl.f.s<am> a = new kotlin.reflect.jvm.internal.impl.f.b<am>(){

            public am a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new am(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final am c = new am(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private int f;
        private int g;
        private b h;
        private int i;
        private int j;
        private c k;
        private byte l = (byte)-1;
        private int m = -1;

        static {
            c.x();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private am(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.x();
            var6_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var7_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var6_10, 1);
            var3_12 = false;
            block11 : while (!var3_12) {
                block19 : {
                    block20 : {
                        var5_14 = var1_1.a();
                        if (var5_14 == 0) break block20;
                        if (var5_14 == 8) ** GOTO lbl48
                        if (var5_14 == 16) ** GOTO lbl45
                        if (var5_14 == 24) ** GOTO lbl37
                        if (var5_14 == 32) ** GOTO lbl34
                        if (var5_14 == 40) ** GOTO lbl31
                        if (var5_14 != 48) {
                            if (this.a(var1_1, var7_11, var2_8, var5_14)) continue;
                        } else {
                            var4_13 = var1_1.n();
                            var8_15 /* !! */  = c.a(var4_13);
                            if (var8_15 /* !! */  == null) {
                                var7_11.p(var5_14);
lbl25: // 2 sources:
                                do {
                                    var7_11.p(var4_13);
                                    continue block11;
                                    break;
                                } while (true);
                            }
                            this.e |= 32;
                            this.k = var8_15 /* !! */ ;
                            continue;
lbl31: // 1 sources:
                            this.e |= 16;
                            this.j = var1_1.f();
                            continue;
lbl34: // 1 sources:
                            this.e |= 8;
                            this.i = var1_1.f();
                            continue;
lbl37: // 1 sources:
                            var4_13 = var1_1.n();
                            var8_15 /* !! */  = b.a(var4_13);
                            if (var8_15 /* !! */  == null) {
                                var7_11.p(var5_14);
                                ** continue;
                            }
                            this.e |= 4;
                            this.h = var8_15 /* !! */ ;
                            continue;
lbl45: // 1 sources:
                            this.e |= 2;
                            this.g = var1_1.f();
                            continue;
lbl48: // 1 sources:
                            this.e |= 1;
                            this.f = var1_1.f();
                            continue;
                        }
                    }
                    var3_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block19;
                    }
                    catch (IOException var1_3) {
                        throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                        throw var1_4.a(this);
                    }
                }
                try {
                    var7_11.a();
lbl63: // 2 sources:
                    do {
                        this.d = var6_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var6_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            try {
                var7_11.a();
lbl73: // 2 sources:
                do {
                    this.d = var6_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var6_10.a();
                throw var1_6;
            }
            this.O();
            return;
            catch (IOException var2_9) {
                ** continue;
            }
            catch (IOException var1_7) {
                ** continue;
            }
        }

        private am(i.a a2) {
            super(a2);
            this.d = a2.x();
        }

        private am(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(am am2) {
            return am.u().a(am2);
        }

        public static am a() {
            return c;
        }

        public static a u() {
            return a.g();
        }

        private void x() {
            this.f = 0;
            this.g = 0;
            this.h = b.b;
            this.i = 0;
            this.j = 0;
            this.k = c.a;
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            this.i();
            if ((this.e & 1) == 1) {
                f2.a(1, this.f);
            }
            if ((this.e & 2) == 2) {
                f2.a(2, this.g);
            }
            if ((this.e & 4) == 4) {
                f2.c(3, this.h.a());
            }
            if ((this.e & 8) == 8) {
                f2.a(4, this.i);
            }
            if ((this.e & 16) == 16) {
                f2.a(5, this.j);
            }
            if ((this.e & 32) == 32) {
                f2.c(6, this.k.a());
            }
            f2.c(this.d);
        }

        public am b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<am> c() {
            return a;
        }

        public boolean d() {
            return (this.e & 1) == 1;
        }

        public int e() {
            return this.f;
        }

        public boolean f() {
            return (this.e & 2) == 2;
        }

        public int g() {
            return this.g;
        }

        @Override
        public final boolean h() {
            byte by2 = this.l;
            if (by2 == 1) {
                return true;
            }
            if (by2 == 0) {
                return false;
            }
            this.l = 1;
            return true;
        }

        @Override
        public int i() {
            int n2 = this.m;
            if (n2 != -1) {
                return n2;
            }
            int n3 = 0;
            if ((this.e & 1) == 1) {
                n3 = 0 + kotlin.reflect.jvm.internal.impl.f.f.d(1, this.f);
            }
            n2 = n3;
            if ((this.e & 2) == 2) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(2, this.g);
            }
            n3 = n2;
            if ((this.e & 4) == 4) {
                n3 = n2 + kotlin.reflect.jvm.internal.impl.f.f.e(3, this.h.a());
            }
            n2 = n3;
            if ((this.e & 8) == 8) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(4, this.i);
            }
            n3 = n2;
            if ((this.e & 16) == 16) {
                n3 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(5, this.j);
            }
            n2 = n3;
            if ((this.e & 32) == 32) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.e(6, this.k.a());
            }
            this.m = n2 += this.d.a();
            return n2;
        }

        public boolean j() {
            return (this.e & 4) == 4;
        }

        public b k() {
            return this.h;
        }

        public boolean l() {
            return (this.e & 8) == 8;
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.w();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.v();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public int p() {
            return this.i;
        }

        public boolean q() {
            return (this.e & 16) == 16;
        }

        public int r() {
            return this.j;
        }

        public boolean s() {
            return (this.e & 32) == 32;
        }

        public c t() {
            return this.k;
        }

        public a v() {
            return am.u();
        }

        public a w() {
            return am.a(this);
        }

        public static final class a
        extends i.a<am, a>
        implements an {
            private int a;
            private int b;
            private int c;
            private b d = b.b;
            private int e;
            private int f;
            private c g = c.a;

            private a() {
                this.f();
            }

            private void f() {
            }

            private static a g() {
                return new a();
            }

            public a a() {
                return a.g().a(this.d());
            }

            @Override
            public a a(int n2) {
                this.a |= 1;
                this.b = n2;
                return this;
            }

            @Override
            public a a(b b2) {
                if (b2 != null) {
                    this.a |= 4;
                    this.d = b2;
                    return this;
                }
                throw new NullPointerException();
            }

            @Override
            public a a(c c2) {
                if (c2 != null) {
                    this.a |= 32;
                    this.g = c2;
                    return this;
                }
                throw new NullPointerException();
            }

            @Override
            public a a(am am2) {
                if (am2 == am.a()) {
                    return this;
                }
                if (am2.d()) {
                    this.a(am2.e());
                }
                if (am2.f()) {
                    this.b(am2.g());
                }
                if (am2.j()) {
                    this.a(am2.k());
                }
                if (am2.l()) {
                    this.c(am2.p());
                }
                if (am2.q()) {
                    this.d(am2.r());
                }
                if (am2.s()) {
                    this.a(am2.t());
                }
                this.a(this.x().a(am2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = am.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((am)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (am)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((am)object);
                throw var2_6;
            }

            public a b(int n2) {
                this.a |= 2;
                this.c = n2;
                return this;
            }

            public am b() {
                return am.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public a c(int n2) {
                this.a |= 8;
                this.e = n2;
                return this;
            }

            public am c() {
                am am2 = this.d();
                if (am2.h()) {
                    return am2;
                }
                throw a.a(am2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public a d(int n2) {
                this.a |= 16;
                this.f = n2;
                return this;
            }

            public am d() {
                am am2 = new am(this);
                int n2 = this.a;
                int n3 = 1;
                if ((n2 & 1) != 1) {
                    n3 = 0;
                }
                am2.f = this.b;
                int n4 = n3;
                if ((n2 & 2) == 2) {
                    n4 = n3 | 2;
                }
                am2.g = this.c;
                n3 = n4;
                if ((n2 & 4) == 4) {
                    n3 = n4 | 4;
                }
                am2.h = this.d;
                n4 = n3;
                if ((n2 & 8) == 8) {
                    n4 = n3 | 8;
                }
                am2.i = this.e;
                n3 = n4;
                if ((n2 & 16) == 16) {
                    n3 = n4 | 16;
                }
                am2.j = this.f;
                n4 = n3;
                if ((n2 & 32) == 32) {
                    n4 = n3 | 32;
                }
                am2.k = this.g;
                am2.e = n4;
                return am2;
            }

            @Override
            public final boolean h() {
                return true;
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }
        }

        public static enum b implements j.a
        {
            a(0, 0),
            b(1, 1),
            c(2, 2);
            
            private static j.b<b> d;
            private final int e;

            static {
                d = new j.b<b>(){

                    public b a(int n2) {
                        return b.a(n2);
                    }

                    @Override
                    public /* synthetic */ j.a b(int n2) {
                        return this.a(n2);
                    }
                };
            }

            private b(int n3, int n4) {
                this.e = n4;
            }

            public static b a(int n2) {
                switch (n2) {
                    default: {
                        return null;
                    }
                    case 2: {
                        return c;
                    }
                    case 1: {
                        return b;
                    }
                    case 0: 
                }
                return a;
            }

            @Override
            public final int a() {
                return this.e;
            }

        }

        public static enum c implements j.a
        {
            a(0, 0),
            b(1, 1),
            c(2, 2);
            
            private static j.b<c> d;
            private final int e;

            static {
                d = new j.b<c>(){

                    public c a(int n2) {
                        return c.a(n2);
                    }

                    @Override
                    public /* synthetic */ j.a b(int n2) {
                        return this.a(n2);
                    }
                };
            }

            private c(int n3, int n4) {
                this.e = n4;
            }

            public static c a(int n2) {
                switch (n2) {
                    default: {
                        return null;
                    }
                    case 2: {
                        return c;
                    }
                    case 1: {
                        return b;
                    }
                    case 0: 
                }
                return a;
            }

            @Override
            public final int a() {
                return this.e;
            }

        }

    }

    public static interface an
    extends kotlin.reflect.jvm.internal.impl.f.r {
    }

    public static final class ao
    extends kotlin.reflect.jvm.internal.impl.f.i
    implements ap {
        public static kotlin.reflect.jvm.internal.impl.f.s<ao> a = new kotlin.reflect.jvm.internal.impl.f.b<ao>(){

            public ao a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new ao(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final ao c = new ao(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private List<am> e;
        private byte f = (byte)-1;
        private int g = -1;

        static {
            c.k();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private ao(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.k();
            var9_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var10_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var9_10, 1);
            var8_12 = false;
            var3_13 = 0;
            while (!var8_12) {
                block20 : {
                    var5_15 = var3_13;
                    var6_16 = var3_13;
                    var7_17 = var3_13;
                    var4_14 = var1_1.a();
                    if (var4_14 != 0) {
                        if (var4_14 != 10) {
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            if (this.a(var1_1, var10_11, var2_8, var4_14)) continue;
                        } else {
                            var4_14 = var3_13;
                            if ((var3_13 & 1) != 1) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.e = new ArrayList<am>();
                                var4_14 = var3_13 | 1;
                            }
                            var5_15 = var4_14;
                            var6_16 = var4_14;
                            var7_17 = var4_14;
                            this.e.add(var1_1.a(am.a, var2_8));
                            var3_13 = var4_14;
                            continue;
                        }
                    }
                    var8_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block20;
                    }
                    catch (IOException var1_3) {
                        var5_15 = var6_16;
                        throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                        var5_15 = var7_17;
                        throw var1_4.a(this);
                    }
                }
                if (var5_15 & true) {
                    this.e = Collections.unmodifiableList(this.e);
                }
                try {
                    var10_11.a();
lbl51: // 2 sources:
                    do {
                        this.d = var9_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var9_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            if (var3_13 & true) {
                this.e = Collections.unmodifiableList(this.e);
            }
            try {
                var10_11.a();
lbl63: // 2 sources:
                do {
                    this.d = var9_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var9_10.a();
                throw var1_6;
            }
            this.O();
            return;
            catch (IOException var2_9) {
                ** continue;
            }
            catch (IOException var1_7) {
                ** continue;
            }
        }

        private ao(i.a a2) {
            super(a2);
            this.d = a2.x();
        }

        private ao(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(ao ao2) {
            return ao.f().a(ao2);
        }

        public static ao a() {
            return c;
        }

        public static a f() {
            return a.g();
        }

        private void k() {
            this.e = Collections.emptyList();
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            this.i();
            for (int i2 = 0; i2 < this.e.size(); ++i2) {
                f2.b(1, this.e.get(i2));
            }
            f2.c(this.d);
        }

        public ao b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<ao> c() {
            return a;
        }

        public List<am> d() {
            return this.e;
        }

        public int e() {
            return this.e.size();
        }

        public a g() {
            return ao.f();
        }

        @Override
        public final boolean h() {
            byte by2 = this.f;
            if (by2 == 1) {
                return true;
            }
            if (by2 == 0) {
                return false;
            }
            this.f = 1;
            return true;
        }

        @Override
        public int i() {
            int n2 = this.g;
            if (n2 != -1) {
                return n2;
            }
            int n3 = 0;
            for (n2 = 0; n2 < this.e.size(); ++n2) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(1, this.e.get(n2));
            }
            this.g = n2 = n3 + this.d.a();
            return n2;
        }

        public a j() {
            return ao.a(this);
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.j();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.g();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public static final class a
        extends i.a<ao, a>
        implements ap {
            private int a;
            private List<am> b = Collections.emptyList();

            private a() {
                this.f();
            }

            private void f() {
            }

            private static a g() {
                return new a();
            }

            private void m() {
                if ((this.a & 1) != 1) {
                    this.b = new ArrayList<am>(this.b);
                    this.a |= 1;
                }
            }

            public a a() {
                return a.g().a(this.d());
            }

            @Override
            public a a(ao ao2) {
                if (ao2 == ao.a()) {
                    return this;
                }
                if (!ao2.e.isEmpty()) {
                    if (this.b.isEmpty()) {
                        this.b = ao2.e;
                        this.a &= -2;
                    } else {
                        this.m();
                        this.b.addAll(ao2.e);
                    }
                }
                this.a(this.x().a(ao2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = ao.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((ao)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (ao)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((ao)object);
                throw var2_6;
            }

            public ao b() {
                return ao.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public ao c() {
                ao ao2 = this.d();
                if (ao2.h()) {
                    return ao2;
                }
                throw a.a(ao2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public ao d() {
                ao ao2 = new ao(this);
                int n2 = this.a;
                if ((this.a & 1) == 1) {
                    this.b = Collections.unmodifiableList(this.b);
                    this.a &= -2;
                }
                ao2.e = this.b;
                return ao2;
            }

            @Override
            public final boolean h() {
                return true;
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }
        }

    }

    public static interface ap
    extends kotlin.reflect.jvm.internal.impl.f.r {
    }

    public static enum aq implements j.a
    {
        a(0, 0),
        b(1, 1),
        c(2, 2),
        d(3, 3),
        e(4, 4),
        f(5, 5);
        
        private static j.b<aq> g;
        private final int h;

        static {
            g = new j.b<aq>(){

                public aq a(int n2) {
                    return aq.a(n2);
                }

                @Override
                public /* synthetic */ j.a b(int n2) {
                    return this.a(n2);
                }
            };
        }

        private aq(int n3, int n4) {
            this.h = n4;
        }

        public static aq a(int n2) {
            switch (n2) {
                default: {
                    return null;
                }
                case 5: {
                    return f;
                }
                case 4: {
                    return e;
                }
                case 3: {
                    return d;
                }
                case 2: {
                    return c;
                }
                case 1: {
                    return b;
                }
                case 0: 
            }
            return a;
        }

        @Override
        public final int a() {
            return this.h;
        }

    }

    public static interface b
    extends kotlin.reflect.jvm.internal.impl.f.r {
    }

    public static final class c
    extends i.c<c>
    implements d {
        public static kotlin.reflect.jvm.internal.impl.f.s<c> a = new kotlin.reflect.jvm.internal.impl.f.b<c>(){

            public c a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new c(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final c c = new c(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private int f;
        private int g;
        private int h;
        private List<ag> i;
        private List<ac> j;
        private List<Integer> k;
        private int l;
        private List<Integer> m;
        private int n;
        private List<e> o;
        private List<o> p;
        private List<w> q;
        private List<ad> r;
        private List<k> s;
        private List<Integer> t;
        private int u;
        private ai v;
        private List<Integer> w;
        private ao x;
        private byte y;
        private int z;

        static {
            c.S();
        }

        /*
         * Exception decompiling
         */
        private c(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: First case is not immediately after switch.
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:358)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:61)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:372)
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

        private c(i.b<c, ?> b2) {
            super(b2);
            this.l = -1;
            this.n = -1;
            this.u = -1;
            this.y = (byte)-1;
            this.z = -1;
            this.d = b2.x();
        }

        private c(boolean bl2) {
            this.l = -1;
            this.n = -1;
            this.u = -1;
            this.y = (byte)-1;
            this.z = -1;
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a K() {
            return a.z();
        }

        private void S() {
            this.f = 6;
            this.g = 0;
            this.h = 0;
            this.i = Collections.emptyList();
            this.j = Collections.emptyList();
            this.k = Collections.emptyList();
            this.m = Collections.emptyList();
            this.o = Collections.emptyList();
            this.p = Collections.emptyList();
            this.q = Collections.emptyList();
            this.r = Collections.emptyList();
            this.s = Collections.emptyList();
            this.t = Collections.emptyList();
            this.v = ai.a();
            this.w = Collections.emptyList();
            this.x = ao.a();
        }

        public static a a(c c2) {
            return c.K().a(c2);
        }

        public static c a() {
            return c;
        }

        public static c a(InputStream inputStream, kotlin.reflect.jvm.internal.impl.f.g g2) {
            return a.f(inputStream, g2);
        }

        public List<ad> A() {
            return this.r;
        }

        public int B() {
            return this.r.size();
        }

        public List<k> C() {
            return this.s;
        }

        public int D() {
            return this.s.size();
        }

        public List<Integer> E() {
            return this.t;
        }

        public boolean F() {
            return (this.e & 8) == 8;
        }

        public ai G() {
            return this.v;
        }

        public List<Integer> H() {
            return this.w;
        }

        public boolean I() {
            return (this.e & 16) == 16;
        }

        public ao J() {
            return this.x;
        }

        public a L() {
            return c.K();
        }

        public a M() {
            return c.a(this);
        }

        public ag a(int n2) {
            return this.i.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            int n2;
            this.i();
            i.c.a a2 = this.Q();
            if ((this.e & 1) == 1) {
                f2.a(1, this.f);
            }
            if (this.s().size() > 0) {
                f2.p(18);
                f2.p(this.l);
            }
            int n3 = 0;
            for (n2 = 0; n2 < this.k.size(); ++n2) {
                f2.b(this.k.get(n2));
            }
            if ((this.e & 2) == 2) {
                f2.a(3, this.g);
            }
            if ((this.e & 4) == 4) {
                f2.a(4, this.h);
            }
            for (n2 = 0; n2 < this.i.size(); ++n2) {
                f2.b(5, this.i.get(n2));
            }
            for (n2 = 0; n2 < this.j.size(); ++n2) {
                f2.b(6, this.j.get(n2));
            }
            if (this.t().size() > 0) {
                f2.p(58);
                f2.p(this.n);
            }
            for (n2 = 0; n2 < this.m.size(); ++n2) {
                f2.b(this.m.get(n2));
            }
            for (n2 = 0; n2 < this.o.size(); ++n2) {
                f2.b(8, this.o.get(n2));
            }
            for (n2 = 0; n2 < this.p.size(); ++n2) {
                f2.b(9, this.p.get(n2));
            }
            for (n2 = 0; n2 < this.q.size(); ++n2) {
                f2.b(10, this.q.get(n2));
            }
            for (n2 = 0; n2 < this.r.size(); ++n2) {
                f2.b(11, this.r.get(n2));
            }
            for (n2 = 0; n2 < this.s.size(); ++n2) {
                f2.b(13, this.s.get(n2));
            }
            if (this.E().size() > 0) {
                f2.p(130);
                f2.p(this.u);
            }
            for (n2 = 0; n2 < this.t.size(); ++n2) {
                f2.b(this.t.get(n2));
            }
            n2 = n3;
            if ((this.e & 8) == 8) {
                f2.b(30, this.v);
                n2 = n3;
            }
            while (n2 < this.w.size()) {
                f2.a(31, this.w.get(n2));
                ++n2;
            }
            if ((this.e & 16) == 16) {
                f2.b(32, this.x);
            }
            a2.a(19000, f2);
            f2.c(this.d);
        }

        public ac b(int n2) {
            return this.j.get(n2);
        }

        public c b() {
            return c;
        }

        public e c(int n2) {
            return this.o.get(n2);
        }

        public kotlin.reflect.jvm.internal.impl.f.s<c> c() {
            return a;
        }

        public o d(int n2) {
            return this.p.get(n2);
        }

        public boolean d() {
            return (this.e & 1) == 1;
        }

        public int e() {
            return this.f;
        }

        public w e(int n2) {
            return this.q.get(n2);
        }

        public ad f(int n2) {
            return this.r.get(n2);
        }

        public boolean f() {
            return (this.e & 2) == 2;
        }

        public int g() {
            return this.g;
        }

        public k g(int n2) {
            return this.s.get(n2);
        }

        @Override
        public final boolean h() {
            int n2 = this.y;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            if (!this.f()) {
                this.y = 0;
                return false;
            }
            for (n2 = 0; n2 < this.p(); ++n2) {
                if (this.a(n2).h()) continue;
                this.y = 0;
                return false;
            }
            for (n2 = 0; n2 < this.r(); ++n2) {
                if (this.b(n2).h()) continue;
                this.y = 0;
                return false;
            }
            for (n2 = 0; n2 < this.v(); ++n2) {
                if (this.c(n2).h()) continue;
                this.y = 0;
                return false;
            }
            for (n2 = 0; n2 < this.x(); ++n2) {
                if (this.d(n2).h()) continue;
                this.y = 0;
                return false;
            }
            for (n2 = 0; n2 < this.z(); ++n2) {
                if (this.e(n2).h()) continue;
                this.y = 0;
                return false;
            }
            for (n2 = 0; n2 < this.B(); ++n2) {
                if (this.f(n2).h()) continue;
                this.y = 0;
                return false;
            }
            for (n2 = 0; n2 < this.D(); ++n2) {
                if (this.g(n2).h()) continue;
                this.y = 0;
                return false;
            }
            if (this.F() && !this.G().h()) {
                this.y = 0;
                return false;
            }
            if (!this.P()) {
                this.y = 0;
                return false;
            }
            this.y = 1;
            return true;
        }

        @Override
        public int i() {
            int n2;
            int n3 = this.z;
            if (n3 != -1) {
                return n3;
            }
            n3 = this.e;
            int n4 = 0;
            n3 = (n3 & 1) == 1 ? kotlin.reflect.jvm.internal.impl.f.f.d(1, this.f) + 0 : 0;
            int n5 = 0;
            for (n2 = 0; n2 < this.k.size(); ++n2) {
                n5 += kotlin.reflect.jvm.internal.impl.f.f.h(this.k.get(n2));
            }
            n3 = n2 = n3 + n5;
            if (!this.s().isEmpty()) {
                n3 = n2 + 1 + kotlin.reflect.jvm.internal.impl.f.f.h(n5);
            }
            this.l = n5;
            n5 = n3;
            if ((this.e & 2) == 2) {
                n5 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(3, this.g);
            }
            n3 = n5;
            if ((this.e & 4) == 4) {
                n3 = n5 + kotlin.reflect.jvm.internal.impl.f.f.d(4, this.h);
            }
            for (n5 = 0; n5 < this.i.size(); ++n5) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(5, this.i.get(n5));
            }
            for (n5 = 0; n5 < this.j.size(); ++n5) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(6, this.j.get(n5));
            }
            n5 = 0;
            for (n2 = 0; n2 < this.m.size(); ++n2) {
                n5 += kotlin.reflect.jvm.internal.impl.f.f.h(this.m.get(n2));
            }
            n3 = n2 = n3 + n5;
            if (!this.t().isEmpty()) {
                n3 = n2 + 1 + kotlin.reflect.jvm.internal.impl.f.f.h(n5);
            }
            this.n = n5;
            for (n5 = 0; n5 < this.o.size(); ++n5) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(8, this.o.get(n5));
            }
            for (n5 = 0; n5 < this.p.size(); ++n5) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(9, this.p.get(n5));
            }
            for (n5 = 0; n5 < this.q.size(); ++n5) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(10, this.q.get(n5));
            }
            for (n5 = 0; n5 < this.r.size(); ++n5) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(11, this.r.get(n5));
            }
            for (n5 = 0; n5 < this.s.size(); ++n5) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(13, this.s.get(n5));
            }
            n5 = 0;
            for (n2 = 0; n2 < this.t.size(); ++n2) {
                n5 += kotlin.reflect.jvm.internal.impl.f.f.h(this.t.get(n2));
            }
            n3 = n2 = n3 + n5;
            if (!this.E().isEmpty()) {
                n3 = n2 + 2 + kotlin.reflect.jvm.internal.impl.f.f.h(n5);
            }
            this.u = n5;
            n5 = n3;
            if ((this.e & 8) == 8) {
                n5 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(30, this.v);
            }
            n2 = 0;
            for (n3 = n4; n3 < this.w.size(); ++n3) {
                n2 += kotlin.reflect.jvm.internal.impl.f.f.h(this.w.get(n3));
            }
            n3 = n5 = n5 + n2 + this.H().size() * 2;
            if ((this.e & 16) == 16) {
                n3 = n5 + kotlin.reflect.jvm.internal.impl.f.f.d(32, this.x);
            }
            this.z = n3 = n3 + this.R() + this.d.a();
            return n3;
        }

        public boolean j() {
            return (this.e & 4) == 4;
        }

        public int k() {
            return this.h;
        }

        public List<ag> l() {
            return this.i;
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.M();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.L();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public int p() {
            return this.i.size();
        }

        public List<ac> q() {
            return this.j;
        }

        public int r() {
            return this.j.size();
        }

        public List<Integer> s() {
            return this.k;
        }

        public List<Integer> t() {
            return this.m;
        }

        public List<e> u() {
            return this.o;
        }

        public int v() {
            return this.o.size();
        }

        public List<o> w() {
            return this.p;
        }

        public int x() {
            return this.p.size();
        }

        public List<w> y() {
            return this.q;
        }

        public int z() {
            return this.q.size();
        }

        public static final class a
        extends i.b<c, a>
        implements d {
            private int a;
            private int b = 6;
            private int c;
            private int d;
            private List<ag> e = Collections.emptyList();
            private List<ac> f = Collections.emptyList();
            private List<Integer> g = Collections.emptyList();
            private List<Integer> h = Collections.emptyList();
            private List<e> i = Collections.emptyList();
            private List<o> j = Collections.emptyList();
            private List<w> k = Collections.emptyList();
            private List<ad> l = Collections.emptyList();
            private List<k> m = Collections.emptyList();
            private List<Integer> n = Collections.emptyList();
            private ai o = ai.a();
            private List<Integer> p = Collections.emptyList();
            private ao q = ao.a();

            private a() {
                this.w();
            }

            private void A() {
                if ((this.a & 8) != 8) {
                    this.e = new ArrayList<ag>(this.e);
                    this.a |= 8;
                }
            }

            private void B() {
                if ((this.a & 16) != 16) {
                    this.f = new ArrayList<ac>(this.f);
                    this.a |= 16;
                }
            }

            private void C() {
                if ((this.a & 32) != 32) {
                    this.g = new ArrayList<Integer>(this.g);
                    this.a |= 32;
                }
            }

            private void D() {
                if ((this.a & 64) != 64) {
                    this.h = new ArrayList<Integer>(this.h);
                    this.a |= 64;
                }
            }

            private void E() {
                if ((this.a & 128) != 128) {
                    this.i = new ArrayList<e>(this.i);
                    this.a |= 128;
                }
            }

            private void F() {
                if ((this.a & 256) != 256) {
                    this.j = new ArrayList<o>(this.j);
                    this.a |= 256;
                }
            }

            private void G() {
                if ((this.a & 512) != 512) {
                    this.k = new ArrayList<w>(this.k);
                    this.a |= 512;
                }
            }

            private void H() {
                if ((this.a & 1024) != 1024) {
                    this.l = new ArrayList<ad>(this.l);
                    this.a |= 1024;
                }
            }

            private void I() {
                if ((this.a & 2048) != 2048) {
                    this.m = new ArrayList<k>(this.m);
                    this.a |= 2048;
                }
            }

            private void J() {
                if ((this.a & 4096) != 4096) {
                    this.n = new ArrayList<Integer>(this.n);
                    this.a |= 4096;
                }
            }

            private void K() {
                if ((this.a & 16384) != 16384) {
                    this.p = new ArrayList<Integer>(this.p);
                    this.a |= 16384;
                }
            }

            private void w() {
            }

            private static a z() {
                return new a();
            }

            public a a() {
                return a.z().a(this.d());
            }

            @Override
            public a a(int n2) {
                this.a |= 1;
                this.b = n2;
                return this;
            }

            @Override
            public a a(ai ai2) {
                ai ai3 = ai2;
                if ((this.a & 8192) == 8192) {
                    ai3 = ai2;
                    if (this.o != ai.a()) {
                        ai3 = ai.a(this.o).a(ai2).d();
                    }
                }
                this.o = ai3;
                this.a |= 8192;
                return this;
            }

            @Override
            public a a(ao ao2) {
                ao ao3 = ao2;
                if ((this.a & 32768) == 32768) {
                    ao3 = ao2;
                    if (this.q != ao.a()) {
                        ao3 = ao.a(this.q).a(ao2).d();
                    }
                }
                this.q = ao3;
                this.a |= 32768;
                return this;
            }

            @Override
            public a a(c c2) {
                if (c2 == c.a()) {
                    return this;
                }
                if (c2.d()) {
                    this.a(c2.e());
                }
                if (c2.f()) {
                    this.b(c2.g());
                }
                if (c2.j()) {
                    this.c(c2.k());
                }
                if (!c2.i.isEmpty()) {
                    if (this.e.isEmpty()) {
                        this.e = c2.i;
                        this.a &= -9;
                    } else {
                        this.A();
                        this.e.addAll(c2.i);
                    }
                }
                if (!c2.j.isEmpty()) {
                    if (this.f.isEmpty()) {
                        this.f = c2.j;
                        this.a &= -17;
                    } else {
                        this.B();
                        this.f.addAll(c2.j);
                    }
                }
                if (!c2.k.isEmpty()) {
                    if (this.g.isEmpty()) {
                        this.g = c2.k;
                        this.a &= -33;
                    } else {
                        this.C();
                        this.g.addAll(c2.k);
                    }
                }
                if (!c2.m.isEmpty()) {
                    if (this.h.isEmpty()) {
                        this.h = c2.m;
                        this.a &= -65;
                    } else {
                        this.D();
                        this.h.addAll(c2.m);
                    }
                }
                if (!c2.o.isEmpty()) {
                    if (this.i.isEmpty()) {
                        this.i = c2.o;
                        this.a &= -129;
                    } else {
                        this.E();
                        this.i.addAll(c2.o);
                    }
                }
                if (!c2.p.isEmpty()) {
                    if (this.j.isEmpty()) {
                        this.j = c2.p;
                        this.a &= -257;
                    } else {
                        this.F();
                        this.j.addAll(c2.p);
                    }
                }
                if (!c2.q.isEmpty()) {
                    if (this.k.isEmpty()) {
                        this.k = c2.q;
                        this.a &= -513;
                    } else {
                        this.G();
                        this.k.addAll(c2.q);
                    }
                }
                if (!c2.r.isEmpty()) {
                    if (this.l.isEmpty()) {
                        this.l = c2.r;
                        this.a &= -1025;
                    } else {
                        this.H();
                        this.l.addAll(c2.r);
                    }
                }
                if (!c2.s.isEmpty()) {
                    if (this.m.isEmpty()) {
                        this.m = c2.s;
                        this.a &= -2049;
                    } else {
                        this.I();
                        this.m.addAll(c2.s);
                    }
                }
                if (!c2.t.isEmpty()) {
                    if (this.n.isEmpty()) {
                        this.n = c2.t;
                        this.a &= -4097;
                    } else {
                        this.J();
                        this.n.addAll(c2.t);
                    }
                }
                if (c2.F()) {
                    this.a(c2.G());
                }
                if (!c2.w.isEmpty()) {
                    if (this.p.isEmpty()) {
                        this.p = c2.w;
                        this.a &= -16385;
                    } else {
                        this.K();
                        this.p.addAll(c2.w);
                    }
                }
                if (c2.I()) {
                    this.a(c2.J());
                }
                this.a(c2);
                this.a(this.x().a(c2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = c.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((c)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (c)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((c)object);
                throw var2_6;
            }

            public a b(int n2) {
                this.a |= 2;
                this.c = n2;
                return this;
            }

            public c b() {
                return c.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public a c(int n2) {
                this.a |= 4;
                this.d = n2;
                return this;
            }

            public c c() {
                c c2 = this.d();
                if (c2.h()) {
                    return c2;
                }
                throw a.a(c2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public ag d(int n2) {
                return this.e.get(n2);
            }

            public c d() {
                c c2 = new c(this);
                int n2 = this.a;
                int n3 = 1;
                if ((n2 & 1) != 1) {
                    n3 = 0;
                }
                c2.f = this.b;
                int n4 = n3;
                if ((n2 & 2) == 2) {
                    n4 = n3 | 2;
                }
                c2.g = this.c;
                n3 = n4;
                if ((n2 & 4) == 4) {
                    n3 = n4 | 4;
                }
                c2.h = this.d;
                if ((this.a & 8) == 8) {
                    this.e = Collections.unmodifiableList(this.e);
                    this.a &= -9;
                }
                c2.i = this.e;
                if ((this.a & 16) == 16) {
                    this.f = Collections.unmodifiableList(this.f);
                    this.a &= -17;
                }
                c2.j = this.f;
                if ((this.a & 32) == 32) {
                    this.g = Collections.unmodifiableList(this.g);
                    this.a &= -33;
                }
                c2.k = this.g;
                if ((this.a & 64) == 64) {
                    this.h = Collections.unmodifiableList(this.h);
                    this.a &= -65;
                }
                c2.m = this.h;
                if ((this.a & 128) == 128) {
                    this.i = Collections.unmodifiableList(this.i);
                    this.a &= -129;
                }
                c2.o = this.i;
                if ((this.a & 256) == 256) {
                    this.j = Collections.unmodifiableList(this.j);
                    this.a &= -257;
                }
                c2.p = this.j;
                if ((this.a & 512) == 512) {
                    this.k = Collections.unmodifiableList(this.k);
                    this.a &= -513;
                }
                c2.q = this.k;
                if ((this.a & 1024) == 1024) {
                    this.l = Collections.unmodifiableList(this.l);
                    this.a &= -1025;
                }
                c2.r = this.l;
                if ((this.a & 2048) == 2048) {
                    this.m = Collections.unmodifiableList(this.m);
                    this.a &= -2049;
                }
                c2.s = this.m;
                if ((this.a & 4096) == 4096) {
                    this.n = Collections.unmodifiableList(this.n);
                    this.a &= -4097;
                }
                c2.t = this.n;
                n4 = n3;
                if ((n2 & 8192) == 8192) {
                    n4 = n3 | 8;
                }
                c2.v = this.o;
                if ((this.a & 16384) == 16384) {
                    this.p = Collections.unmodifiableList(this.p);
                    this.a &= -16385;
                }
                c2.w = this.p;
                n3 = n4;
                if ((n2 & 32768) == 32768) {
                    n3 = n4 | 16;
                }
                c2.x = this.q;
                c2.e = n3;
                return c2;
            }

            public ac e(int n2) {
                return this.f.get(n2);
            }

            public boolean e() {
                return (this.a & 2) == 2;
            }

            public int f() {
                return this.e.size();
            }

            public e f(int n2) {
                return this.i.get(n2);
            }

            public int g() {
                return this.f.size();
            }

            public o g(int n2) {
                return this.j.get(n2);
            }

            public w h(int n2) {
                return this.k.get(n2);
            }

            @Override
            public final boolean h() {
                int n2;
                if (!this.e()) {
                    return false;
                }
                for (n2 = 0; n2 < this.f(); ++n2) {
                    if (this.d(n2).h()) continue;
                    return false;
                }
                for (n2 = 0; n2 < this.g(); ++n2) {
                    if (this.e(n2).h()) continue;
                    return false;
                }
                for (n2 = 0; n2 < this.m(); ++n2) {
                    if (this.f(n2).h()) continue;
                    return false;
                }
                for (n2 = 0; n2 < this.n(); ++n2) {
                    if (this.g(n2).h()) continue;
                    return false;
                }
                for (n2 = 0; n2 < this.p(); ++n2) {
                    if (this.h(n2).h()) continue;
                    return false;
                }
                for (n2 = 0; n2 < this.q(); ++n2) {
                    if (this.i(n2).h()) continue;
                    return false;
                }
                for (n2 = 0; n2 < this.r(); ++n2) {
                    if (this.j(n2).h()) continue;
                    return false;
                }
                if (this.s() && !this.t().h()) {
                    return false;
                }
                return this.y();
            }

            public ad i(int n2) {
                return this.l.get(n2);
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            public k j(int n2) {
                return this.m.get(n2);
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            public int m() {
                return this.i.size();
            }

            public int n() {
                return this.j.size();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }

            public int p() {
                return this.k.size();
            }

            public int q() {
                return this.l.size();
            }

            public int r() {
                return this.m.size();
            }

            public boolean s() {
                return (this.a & 8192) == 8192;
            }

            public ai t() {
                return this.o;
            }

            @Override
            public /* synthetic */ i.b u() {
                return this.a();
            }
        }

        public static enum b implements j.a
        {
            a(0, 0),
            b(1, 1),
            c(2, 2),
            d(3, 3),
            e(4, 4),
            f(5, 5),
            g(6, 6);
            
            private static j.b<b> h;
            private final int i;

            static {
                h = new j.b<b>(){

                    public b a(int n2) {
                        return b.a(n2);
                    }

                    @Override
                    public /* synthetic */ j.a b(int n2) {
                        return this.a(n2);
                    }
                };
            }

            private b(int n3, int n4) {
                this.i = n4;
            }

            public static b a(int n2) {
                switch (n2) {
                    default: {
                        return null;
                    }
                    case 6: {
                        return g;
                    }
                    case 5: {
                        return f;
                    }
                    case 4: {
                        return e;
                    }
                    case 3: {
                        return d;
                    }
                    case 2: {
                        return c;
                    }
                    case 1: {
                        return b;
                    }
                    case 0: 
                }
                return a;
            }

            @Override
            public final int a() {
                return this.i;
            }

        }

    }

    public static interface d
    extends i.d {
    }

    public static final class e
    extends i.c<e>
    implements f {
        public static kotlin.reflect.jvm.internal.impl.f.s<e> a = new kotlin.reflect.jvm.internal.impl.f.b<e>(){

            public e a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new e(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final e c = new e(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private int f;
        private List<ak> g;
        private List<Integer> h;
        private byte i = (byte)-1;
        private int j = -1;

        static {
            c.q();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private e(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.q();
            var12_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var13_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var12_10, 1);
            var8_12 = false;
            var3_13 = 0;
            block11 : while (!var8_12) {
                block26 : {
                    block27 : {
                        var4_14 = var3_13;
                        var5_15 = var3_13;
                        var6_16 = var3_13;
                        var7_17 = var1_1.a();
                        if (var7_17 == 0) break block27;
                        if (var7_17 == 8) ** GOTO lbl97
                        if (var7_17 == 18) ** GOTO lbl80
                        if (var7_17 == 248) ** GOTO lbl58
                        if (var7_17 != 250) {
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            if (this.a(var1_1, var13_11, var2_8, var7_17)) continue;
                        } else {
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var9_18 = var1_1.c(var1_1.s());
                            var7_17 = var3_13;
                            if ((var3_13 & 4) != 4) {
                                var7_17 = var3_13;
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                if (var1_1.x() > 0) {
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    this.h = new ArrayList<Integer>();
                                    var7_17 = var3_13 | 4;
                                }
                            }
                            do {
                                var4_14 = var7_17;
                                var5_15 = var7_17;
                                var6_16 = var7_17;
                                if (var1_1.x() <= 0) break;
                                var4_14 = var7_17;
                                var5_15 = var7_17;
                                var6_16 = var7_17;
                                this.h.add(var1_1.f());
                            } while (true);
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var1_1.d(var9_18);
                            var3_13 = var7_17;
                            continue;
lbl58: // 1 sources:
                            var7_17 = var3_13;
                            if ((var3_13 & 4) != 4) {
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                this.h = new ArrayList<Integer>();
                                var7_17 = var3_13 | 4;
                            }
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var10_19 = this.h;
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var11_20 /* !! */  = Integer.valueOf(var1_1.f());
                            var3_13 = var7_17;
lbl74: // 2 sources:
                            do {
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var10_19.add(var11_20 /* !! */ );
                                continue block11;
                                break;
                            } while (true);
lbl80: // 1 sources:
                            var7_17 = var3_13;
                            if ((var3_13 & 2) != 2) {
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                this.g = new ArrayList<ak>();
                                var7_17 = var3_13 | 2;
                            }
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var10_19 = this.g;
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var11_20 /* !! */  = var1_1.a(ak.a, var2_8);
                            var3_13 = var7_17;
                            ** continue;
lbl97: // 1 sources:
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            this.e |= 1;
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            this.f = var1_1.f();
                            continue;
                        }
                    }
                    var8_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block26;
                    }
                    catch (IOException var1_3) {
                        var4_14 = var5_15;
                        throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                        var4_14 = var6_16;
                        throw var1_4.a(this);
                    }
                }
                if ((var4_14 & 2) == 2) {
                    this.g = Collections.unmodifiableList(this.g);
                }
                if ((var4_14 & 4) == 4) {
                    this.h = Collections.unmodifiableList(this.h);
                }
                try {
                    var13_11.a();
lbl124: // 2 sources:
                    do {
                        this.d = var12_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var12_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            if ((var3_13 & 2) == 2) {
                this.g = Collections.unmodifiableList(this.g);
            }
            if ((var3_13 & 4) == 4) {
                this.h = Collections.unmodifiableList(this.h);
            }
            try {
                var13_11.a();
lbl138: // 2 sources:
                do {
                    this.d = var12_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var12_10.a();
                throw var1_6;
            }
            this.O();
            return;
            catch (IOException var2_9) {
                ** continue;
            }
            catch (IOException var1_7) {
                ** continue;
            }
        }

        private e(i.b<e, ?> b2) {
            super(b2);
            this.d = b2.x();
        }

        private e(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(e e2) {
            return e.k().a(e2);
        }

        public static e a() {
            return c;
        }

        public static a k() {
            return a.m();
        }

        private void q() {
            this.f = 6;
            this.g = Collections.emptyList();
            this.h = Collections.emptyList();
        }

        public ak a(int n2) {
            return this.g.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            this.i();
            i.c.a a2 = this.Q();
            if ((this.e & 1) == 1) {
                f2.a(1, this.f);
            }
            int n2 = 0;
            int n3 = 0;
            do {
                if (n3 >= this.g.size()) break;
                f2.b(2, this.g.get(n3));
                ++n3;
            } while (true);
            for (int i2 = n2; i2 < this.h.size(); ++i2) {
                f2.a(31, this.h.get(i2));
            }
            a2.a(19000, f2);
            f2.c(this.d);
        }

        public e b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<e> c() {
            return a;
        }

        public boolean d() {
            return (this.e & 1) == 1;
        }

        public int e() {
            return this.f;
        }

        public List<ak> f() {
            return this.g;
        }

        public int g() {
            return this.g.size();
        }

        @Override
        public final boolean h() {
            int n2 = this.i;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            for (n2 = 0; n2 < this.g(); ++n2) {
                if (this.a(n2).h()) continue;
                this.i = 0;
                return false;
            }
            if (!this.P()) {
                this.i = 0;
                return false;
            }
            this.i = 1;
            return true;
        }

        @Override
        public int i() {
            int n2;
            int n3 = this.j;
            if (n3 != -1) {
                return n3;
            }
            n3 = this.e;
            int n4 = 0;
            n3 = (n3 & 1) == 1 ? kotlin.reflect.jvm.internal.impl.f.f.d(1, this.f) + 0 : 0;
            for (n2 = 0; n2 < this.g.size(); ++n2) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(2, this.g.get(n2));
            }
            int n5 = 0;
            n2 = n4;
            n4 = n5;
            while (n2 < this.h.size()) {
                n4 += kotlin.reflect.jvm.internal.impl.f.f.h(this.h.get(n2));
                ++n2;
            }
            this.j = n3 = n3 + n4 + this.j().size() * 2 + this.R() + this.d.a();
            return n3;
        }

        public List<Integer> j() {
            return this.h;
        }

        public a l() {
            return e.k();
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.p();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.l();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public a p() {
            return e.a(this);
        }

        public static final class a
        extends i.b<e, a>
        implements f {
            private int a;
            private int b = 6;
            private List<ak> c = Collections.emptyList();
            private List<Integer> d = Collections.emptyList();

            private a() {
                this.g();
            }

            private void g() {
            }

            private static a m() {
                return new a();
            }

            private void n() {
                if ((this.a & 2) != 2) {
                    this.c = new ArrayList<ak>(this.c);
                    this.a |= 2;
                }
            }

            private void p() {
                if ((this.a & 4) != 4) {
                    this.d = new ArrayList<Integer>(this.d);
                    this.a |= 4;
                }
            }

            public a a() {
                return a.m().a(this.d());
            }

            @Override
            public a a(int n2) {
                this.a |= 1;
                this.b = n2;
                return this;
            }

            @Override
            public a a(e e2) {
                if (e2 == e.a()) {
                    return this;
                }
                if (e2.d()) {
                    this.a(e2.e());
                }
                if (!e2.g.isEmpty()) {
                    if (this.c.isEmpty()) {
                        this.c = e2.g;
                        this.a &= -3;
                    } else {
                        this.n();
                        this.c.addAll(e2.g);
                    }
                }
                if (!e2.h.isEmpty()) {
                    if (this.d.isEmpty()) {
                        this.d = e2.h;
                        this.a &= -5;
                    } else {
                        this.p();
                        this.d.addAll(e2.h);
                    }
                }
                this.a(e2);
                this.a(this.x().a(e2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = e.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((e)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (e)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((e)object);
                throw var2_6;
            }

            public ak b(int n2) {
                return this.c.get(n2);
            }

            public e b() {
                return e.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public e c() {
                e e2 = this.d();
                if (e2.h()) {
                    return e2;
                }
                throw a.a(e2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public e d() {
                e e2 = new e(this);
                int n2 = this.a;
                int n3 = 1;
                if ((n2 & 1) != 1) {
                    n3 = 0;
                }
                e2.f = this.b;
                if ((this.a & 2) == 2) {
                    this.c = Collections.unmodifiableList(this.c);
                    this.a &= -3;
                }
                e2.g = this.c;
                if ((this.a & 4) == 4) {
                    this.d = Collections.unmodifiableList(this.d);
                    this.a &= -5;
                }
                e2.h = this.d;
                e2.e = n3;
                return e2;
            }

            public int e() {
                return this.c.size();
            }

            @Override
            public final boolean h() {
                for (int i2 = 0; i2 < this.e(); ++i2) {
                    if (this.b(i2).h()) continue;
                    return false;
                }
                return this.y();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.b u() {
                return this.a();
            }
        }

    }

    public static interface f
    extends i.d {
    }

    public static final class g
    extends kotlin.reflect.jvm.internal.impl.f.i
    implements h {
        public static kotlin.reflect.jvm.internal.impl.f.s<g> a = new kotlin.reflect.jvm.internal.impl.f.b<g>(){

            public g a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new g(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final g c = new g(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private List<i> e;
        private byte f = (byte)-1;
        private int g = -1;

        static {
            c.j();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private g(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.j();
            var9_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var10_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var9_10, 1);
            var8_12 = false;
            var3_13 = 0;
            while (!var8_12) {
                block20 : {
                    var5_15 = var3_13;
                    var6_16 = var3_13;
                    var7_17 = var3_13;
                    var4_14 = var1_1.a();
                    if (var4_14 != 0) {
                        if (var4_14 != 10) {
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            if (this.a(var1_1, var10_11, var2_8, var4_14)) continue;
                        } else {
                            var4_14 = var3_13;
                            if ((var3_13 & 1) != 1) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.e = new ArrayList<i>();
                                var4_14 = var3_13 | 1;
                            }
                            var5_15 = var4_14;
                            var6_16 = var4_14;
                            var7_17 = var4_14;
                            this.e.add(var1_1.a(i.a, var2_8));
                            var3_13 = var4_14;
                            continue;
                        }
                    }
                    var8_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block20;
                    }
                    catch (IOException var1_3) {
                        var5_15 = var6_16;
                        throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                        var5_15 = var7_17;
                        throw var1_4.a(this);
                    }
                }
                if (var5_15 & true) {
                    this.e = Collections.unmodifiableList(this.e);
                }
                try {
                    var10_11.a();
lbl51: // 2 sources:
                    do {
                        this.d = var9_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var9_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            if (var3_13 & true) {
                this.e = Collections.unmodifiableList(this.e);
            }
            try {
                var10_11.a();
lbl63: // 2 sources:
                do {
                    this.d = var9_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var9_10.a();
                throw var1_6;
            }
            this.O();
            return;
            catch (IOException var2_9) {
                ** continue;
            }
            catch (IOException var1_7) {
                ** continue;
            }
        }

        private g(i.a a2) {
            super(a2);
            this.d = a2.x();
        }

        private g(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(g g2) {
            return g.e().a(g2);
        }

        public static g a() {
            return c;
        }

        public static a e() {
            return a.m();
        }

        private void j() {
            this.e = Collections.emptyList();
        }

        public i a(int n2) {
            return this.e.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            this.i();
            for (int i2 = 0; i2 < this.e.size(); ++i2) {
                f2.b(1, this.e.get(i2));
            }
            f2.c(this.d);
        }

        public g b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<g> c() {
            return a;
        }

        public int d() {
            return this.e.size();
        }

        public a f() {
            return g.e();
        }

        public a g() {
            return g.a(this);
        }

        @Override
        public final boolean h() {
            int n2 = this.f;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            for (n2 = 0; n2 < this.d(); ++n2) {
                if (this.a(n2).h()) continue;
                this.f = 0;
                return false;
            }
            this.f = 1;
            return true;
        }

        @Override
        public int i() {
            int n2 = this.g;
            if (n2 != -1) {
                return n2;
            }
            int n3 = 0;
            for (n2 = 0; n2 < this.e.size(); ++n2) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(1, this.e.get(n2));
            }
            this.g = n2 = n3 + this.d.a();
            return n2;
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.g();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.f();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public static final class a
        extends i.a<g, a>
        implements h {
            private int a;
            private List<i> b = Collections.emptyList();

            private a() {
                this.g();
            }

            private void g() {
            }

            private static a m() {
                return new a();
            }

            private void n() {
                if ((this.a & 1) != 1) {
                    this.b = new ArrayList<i>(this.b);
                    this.a |= 1;
                }
            }

            public a a() {
                return a.m().a(this.d());
            }

            @Override
            public a a(g g2) {
                if (g2 == g.a()) {
                    return this;
                }
                if (!g2.e.isEmpty()) {
                    if (this.b.isEmpty()) {
                        this.b = g2.e;
                        this.a &= -2;
                    } else {
                        this.n();
                        this.b.addAll(g2.e);
                    }
                }
                this.a(this.x().a(g2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = g.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((g)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (g)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((g)object);
                throw var2_6;
            }

            @Override
            public i a(int n2) {
                return this.b.get(n2);
            }

            public g b() {
                return g.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public g c() {
                g g2 = this.d();
                if (g2.h()) {
                    return g2;
                }
                throw a.a(g2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public g d() {
                g g2 = new g(this);
                int n2 = this.a;
                if ((this.a & 1) == 1) {
                    this.b = Collections.unmodifiableList(this.b);
                    this.a &= -2;
                }
                g2.e = this.b;
                return g2;
            }

            public int e() {
                return this.b.size();
            }

            @Override
            public final boolean h() {
                for (int i2 = 0; i2 < this.e(); ++i2) {
                    if (this.a(i2).h()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }
        }

    }

    public static interface h
    extends kotlin.reflect.jvm.internal.impl.f.r {
    }

    public static final class i
    extends kotlin.reflect.jvm.internal.impl.f.i
    implements j {
        public static kotlin.reflect.jvm.internal.impl.f.s<i> a = new kotlin.reflect.jvm.internal.impl.f.b<i>(){

            public i a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new i(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final i c = new i(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private b f;
        private List<m> g;
        private m h;
        private c i;
        private byte j = (byte)-1;
        private int k = -1;

        static {
            c.s();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private i(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.s();
            var11_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var12_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var11_10, 1);
            var8_12 = false;
            var3_13 = 0;
            block11 : while (!var8_12) {
                block24 : {
                    block25 : {
                        var5_15 = var3_13;
                        var6_16 = var3_13;
                        var7_17 = var3_13;
                        var9_18 = var1_1.a();
                        if (var9_18 == 0) break block25;
                        if (var9_18 == 8) ** GOTO lbl94
                        if (var9_18 == 18) ** GOTO lbl81
                        if (var9_18 == 26) ** GOTO lbl54
                        if (var9_18 != 32) {
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            if (this.a(var1_1, var12_11, var2_8, var9_18)) continue;
                        } else {
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            var4_14 = var1_1.n();
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            var10_19 = c.a(var4_14);
                            if (var10_19 == null) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                var12_11.p(var9_18);
lbl39: // 2 sources:
                                do {
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    var7_17 = var3_13;
                                    var12_11.p(var4_14);
                                    continue block11;
                                    break;
                                } while (true);
                            }
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.e |= 4;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.i = var10_19;
                            continue;
lbl54: // 1 sources:
                            var10_19 = null;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            if ((this.e & 2) == 2) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                var10_19 = this.h.w();
                            }
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.h = var1_1.a(m.a, var2_8);
                            if (var10_19 != null) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                var10_19.a(this.h);
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.h = var10_19.d();
                            }
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.e |= 2;
                            continue;
lbl81: // 1 sources:
                            var4_14 = var3_13;
                            if ((var3_13 & 2) != 2) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.g = new ArrayList<m>();
                                var4_14 = var3_13 | 2;
                            }
                            var5_15 = var4_14;
                            var6_16 = var4_14;
                            var7_17 = var4_14;
                            this.g.add(var1_1.a(m.a, var2_8));
                            var3_13 = var4_14;
                            continue;
lbl94: // 1 sources:
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            var4_14 = var1_1.n();
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            var10_19 = b.a(var4_14);
                            if (var10_19 == null) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                var12_11.p(var9_18);
                                ** continue;
                            }
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.e |= 1;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.f = var10_19;
                            continue;
                        }
                    }
                    var8_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block24;
                    }
                    catch (IOException var1_3) {
                        var5_15 = var6_16;
                        throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                        var5_15 = var7_17;
                        throw var1_4.a(this);
                    }
                }
                if ((var5_15 & 2) == 2) {
                    this.g = Collections.unmodifiableList(this.g);
                }
                try {
                    var12_11.a();
lbl133: // 2 sources:
                    do {
                        this.d = var11_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var11_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            if ((var3_13 & 2) == 2) {
                this.g = Collections.unmodifiableList(this.g);
            }
            try {
                var12_11.a();
lbl145: // 2 sources:
                do {
                    this.d = var11_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var11_10.a();
                throw var1_6;
            }
            this.O();
            return;
            catch (IOException var2_9) {
                ** continue;
            }
            catch (IOException var1_7) {
                ** continue;
            }
        }

        private i(i.a a2) {
            super(a2);
            this.d = a2.x();
        }

        private i(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(i i2) {
            return i.p().a(i2);
        }

        public static i a() {
            return c;
        }

        public static a p() {
            return a.p();
        }

        private void s() {
            this.f = b.a;
            this.g = Collections.emptyList();
            this.h = m.a();
            this.i = c.a;
        }

        public m a(int n2) {
            return this.g.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            this.i();
            if ((this.e & 1) == 1) {
                f2.c(1, this.f.a());
            }
            for (int i2 = 0; i2 < this.g.size(); ++i2) {
                f2.b(2, this.g.get(i2));
            }
            if ((this.e & 2) == 2) {
                f2.b(3, this.h);
            }
            if ((this.e & 4) == 4) {
                f2.c(4, this.i.a());
            }
            f2.c(this.d);
        }

        public i b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<i> c() {
            return a;
        }

        public boolean d() {
            return (this.e & 1) == 1;
        }

        public b e() {
            return this.f;
        }

        public int f() {
            return this.g.size();
        }

        public boolean g() {
            return (this.e & 2) == 2;
        }

        @Override
        public final boolean h() {
            int n2 = this.j;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            for (n2 = 0; n2 < this.f(); ++n2) {
                if (this.a(n2).h()) continue;
                this.j = 0;
                return false;
            }
            if (this.g() && !this.j().h()) {
                this.j = 0;
                return false;
            }
            this.j = 1;
            return true;
        }

        @Override
        public int i() {
            int n2;
            int n3 = this.k;
            if (n3 != -1) {
                return n3;
            }
            n3 = this.e;
            n3 = (n3 & 1) == 1 ? kotlin.reflect.jvm.internal.impl.f.f.e(1, this.f.a()) + 0 : 0;
            for (n2 = 0; n2 < this.g.size(); ++n2) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(2, this.g.get(n2));
            }
            n2 = n3;
            if ((this.e & 2) == 2) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(3, this.h);
            }
            n3 = n2;
            if ((this.e & 4) == 4) {
                n3 = n2 + kotlin.reflect.jvm.internal.impl.f.f.e(4, this.i.a());
            }
            this.k = n3 += this.d.a();
            return n3;
        }

        public m j() {
            return this.h;
        }

        public boolean k() {
            return (this.e & 4) == 4;
        }

        public c l() {
            return this.i;
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.r();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.q();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public a q() {
            return i.p();
        }

        public a r() {
            return i.a(this);
        }

        public static final class a
        extends i.a<i, a>
        implements j {
            private int a;
            private b b = b.a;
            private List<m> c = Collections.emptyList();
            private m d = m.a();
            private c e = c.a;

            private a() {
                this.n();
            }

            private void n() {
            }

            private static a p() {
                return new a();
            }

            private void q() {
                if ((this.a & 2) != 2) {
                    this.c = new ArrayList<m>(this.c);
                    this.a |= 2;
                }
            }

            public a a() {
                return a.p().a(this.d());
            }

            @Override
            public a a(b b2) {
                if (b2 != null) {
                    this.a |= 1;
                    this.b = b2;
                    return this;
                }
                throw new NullPointerException();
            }

            @Override
            public a a(c c2) {
                if (c2 != null) {
                    this.a |= 8;
                    this.e = c2;
                    return this;
                }
                throw new NullPointerException();
            }

            @Override
            public a a(i i2) {
                if (i2 == i.a()) {
                    return this;
                }
                if (i2.d()) {
                    this.a(i2.e());
                }
                if (!i2.g.isEmpty()) {
                    if (this.c.isEmpty()) {
                        this.c = i2.g;
                        this.a &= -3;
                    } else {
                        this.q();
                        this.c.addAll(i2.g);
                    }
                }
                if (i2.g()) {
                    this.a(i2.j());
                }
                if (i2.k()) {
                    this.a(i2.l());
                }
                this.a(this.x().a(i2.d));
                return this;
            }

            @Override
            public a a(m m2) {
                m m3 = m2;
                if ((this.a & 4) == 4) {
                    m3 = m2;
                    if (this.d != m.a()) {
                        m3 = m.a(this.d).a(m2).d();
                    }
                }
                this.d = m3;
                this.a |= 4;
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = i.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((i)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (i)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((i)object);
                throw var2_6;
            }

            @Override
            public m a(int n2) {
                return this.c.get(n2);
            }

            public i b() {
                return i.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public i c() {
                i i2 = this.d();
                if (i2.h()) {
                    return i2;
                }
                throw a.a(i2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public i d() {
                i i2 = new i(this);
                int n2 = this.a;
                int n3 = 1;
                if ((n2 & 1) != 1) {
                    n3 = 0;
                }
                i2.f = this.b;
                if ((this.a & 2) == 2) {
                    this.c = Collections.unmodifiableList(this.c);
                    this.a &= -3;
                }
                i2.g = this.c;
                int n4 = n3;
                if ((n2 & 4) == 4) {
                    n4 = n3 | 2;
                }
                i2.h = this.d;
                n3 = n4;
                if ((n2 & 8) == 8) {
                    n3 = n4 | 4;
                }
                i2.i = this.e;
                i2.e = n3;
                return i2;
            }

            public int e() {
                return this.c.size();
            }

            public boolean f() {
                return (this.a & 4) == 4;
            }

            public m g() {
                return this.d;
            }

            @Override
            public final boolean h() {
                for (int i2 = 0; i2 < this.e(); ++i2) {
                    if (this.a(i2).h()) continue;
                    return false;
                }
                return !this.f() || this.g().h();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }
        }

        public static enum b implements j.a
        {
            a(0, 0),
            b(1, 1),
            c(2, 2);
            
            private static j.b<b> d;
            private final int e;

            static {
                d = new j.b<b>(){

                    public b a(int n2) {
                        return b.a(n2);
                    }

                    @Override
                    public /* synthetic */ j.a b(int n2) {
                        return this.a(n2);
                    }
                };
            }

            private b(int n3, int n4) {
                this.e = n4;
            }

            public static b a(int n2) {
                switch (n2) {
                    default: {
                        return null;
                    }
                    case 2: {
                        return c;
                    }
                    case 1: {
                        return b;
                    }
                    case 0: 
                }
                return a;
            }

            @Override
            public final int a() {
                return this.e;
            }

        }

        public static enum c implements j.a
        {
            a(0, 0),
            b(1, 1),
            c(2, 2);
            
            private static j.b<c> d;
            private final int e;

            static {
                d = new j.b<c>(){

                    public c a(int n2) {
                        return c.a(n2);
                    }

                    @Override
                    public /* synthetic */ j.a b(int n2) {
                        return this.a(n2);
                    }
                };
            }

            private c(int n3, int n4) {
                this.e = n4;
            }

            public static c a(int n2) {
                switch (n2) {
                    default: {
                        return null;
                    }
                    case 2: {
                        return c;
                    }
                    case 1: {
                        return b;
                    }
                    case 0: 
                }
                return a;
            }

            @Override
            public final int a() {
                return this.e;
            }

        }

    }

    public static interface j
    extends kotlin.reflect.jvm.internal.impl.f.r {
    }

    public static final class k
    extends i.c<k>
    implements l {
        public static kotlin.reflect.jvm.internal.impl.f.s<k> a = new kotlin.reflect.jvm.internal.impl.f.b<k>(){

            public k a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new k(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final k c = new k(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private int f;
        private byte g = (byte)-1;
        private int h = -1;

        static {
            c.k();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private k(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.k();
            var5_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var6_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var5_10, 1);
            var3_12 = false;
            while (!var3_12) {
                block17 : {
                    var4_13 = var1_1.a();
                    if (var4_13 != 0) {
                        if (var4_13 != 8) {
                            if (this.a(var1_1, var6_11, var2_8, var4_13)) continue;
                        } else {
                            this.e |= 1;
                            this.f = var1_1.f();
                            continue;
                        }
                    }
                    var3_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block17;
                    }
                    catch (IOException var1_3) {
                        throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                        throw var1_4.a(this);
                    }
                }
                try {
                    var6_11.a();
lbl30: // 2 sources:
                    do {
                        this.d = var5_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var5_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            try {
                var6_11.a();
lbl40: // 2 sources:
                do {
                    this.d = var5_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var5_10.a();
                throw var1_6;
            }
            this.O();
            return;
            catch (IOException var2_9) {
                ** continue;
            }
            catch (IOException var1_7) {
                ** continue;
            }
        }

        private k(i.b<k, ?> b2) {
            super(b2);
            this.d = b2.x();
        }

        private k(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(k k2) {
            return k.f().a(k2);
        }

        public static k a() {
            return c;
        }

        public static a f() {
            return a.g();
        }

        private void k() {
            this.f = 0;
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            this.i();
            i.c.a a2 = this.Q();
            if ((this.e & 1) == 1) {
                f2.a(1, this.f);
            }
            a2.a(200, f2);
            f2.c(this.d);
        }

        public k b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<k> c() {
            return a;
        }

        public boolean d() {
            return (this.e & 1) == 1;
        }

        public int e() {
            return this.f;
        }

        public a g() {
            return k.f();
        }

        @Override
        public final boolean h() {
            byte by2 = this.g;
            if (by2 == 1) {
                return true;
            }
            if (by2 == 0) {
                return false;
            }
            if (!this.P()) {
                this.g = 0;
                return false;
            }
            this.g = 1;
            return true;
        }

        @Override
        public int i() {
            int n2 = this.h;
            if (n2 != -1) {
                return n2;
            }
            n2 = 0;
            if ((this.e & 1) == 1) {
                n2 = 0 + kotlin.reflect.jvm.internal.impl.f.f.d(1, this.f);
            }
            this.h = n2 = n2 + this.R() + this.d.a();
            return n2;
        }

        public a j() {
            return k.a(this);
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.j();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.g();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public static final class a
        extends i.b<k, a>
        implements l {
            private int a;
            private int b;

            private a() {
                this.f();
            }

            private void f() {
            }

            private static a g() {
                return new a();
            }

            public a a() {
                return a.g().a(this.d());
            }

            @Override
            public a a(int n2) {
                this.a |= 1;
                this.b = n2;
                return this;
            }

            @Override
            public a a(k k2) {
                if (k2 == k.a()) {
                    return this;
                }
                if (k2.d()) {
                    this.a(k2.e());
                }
                this.a(k2);
                this.a(this.x().a(k2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = k.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((k)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (k)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((k)object);
                throw var2_6;
            }

            public k b() {
                return k.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public k c() {
                k k2 = this.d();
                if (k2.h()) {
                    return k2;
                }
                throw a.a(k2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public k d() {
                k k2 = new k(this);
                int n2 = this.a;
                int n3 = 1;
                if ((n2 & 1) != 1) {
                    n3 = 0;
                }
                k2.f = this.b;
                k2.e = n3;
                return k2;
            }

            @Override
            public final boolean h() {
                return this.y();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.b u() {
                return this.a();
            }
        }

    }

    public static interface l
    extends i.d {
    }

    public static final class m
    extends kotlin.reflect.jvm.internal.impl.f.i
    implements n {
        public static kotlin.reflect.jvm.internal.impl.f.s<m> a = new kotlin.reflect.jvm.internal.impl.f.b<m>(){

            public m a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new m(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final m c = new m(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private int f;
        private int g;
        private b h;
        private ac i;
        private int j;
        private List<m> k;
        private List<m> l;
        private byte m = (byte)-1;
        private int n = -1;

        static {
            c.x();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private m(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.x();
            var12_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var13_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var12_10, 1);
            var8_12 = false;
            var3_13 = 0;
            block11 : while (!var8_12) {
                block26 : {
                    block27 : {
                        var4_14 = var3_13;
                        var6_16 = var3_13;
                        var7_17 = var3_13;
                        var5_15 = var1_1.a();
                        if (var5_15 == 0) break block27;
                        if (var5_15 == 8) ** GOTO lbl140
                        if (var5_15 == 16) ** GOTO lbl131
                        if (var5_15 == 24) ** GOTO lbl104
                        if (var5_15 == 34) ** GOTO lbl77
                        if (var5_15 == 40) ** GOTO lbl68
                        if (var5_15 == 50) ** GOTO lbl51
                        if (var5_15 != 58) {
                            var4_14 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            if (this.a(var1_1, var13_11, var2_8, var5_15)) continue;
                        } else {
                            var5_15 = var3_13;
                            if ((var3_13 & 64) != 64) {
                                var4_14 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.l = new ArrayList<m>();
                                var5_15 = var3_13 | 64;
                            }
                            var4_14 = var5_15;
                            var6_16 = var5_15;
                            var7_17 = var5_15;
                            var10_19 = this.l;
                            var4_14 = var5_15;
                            var6_16 = var5_15;
                            var7_17 = var5_15;
                            var11_20 = var1_1.a(m.a, var2_8);
                            var3_13 = var5_15;
lbl45: // 2 sources:
                            do {
                                var4_14 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                var10_19.add((m)var11_20);
                                continue block11;
                                break;
                            } while (true);
lbl51: // 1 sources:
                            var5_15 = var3_13;
                            if ((var3_13 & 32) != 32) {
                                var4_14 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.k = new ArrayList<m>();
                                var5_15 = var3_13 | 32;
                            }
                            var4_14 = var5_15;
                            var6_16 = var5_15;
                            var7_17 = var5_15;
                            var10_19 = this.k;
                            var4_14 = var5_15;
                            var6_16 = var5_15;
                            var7_17 = var5_15;
                            var11_20 = var1_1.a(m.a, var2_8);
                            var3_13 = var5_15;
                            ** continue;
lbl68: // 1 sources:
                            var4_14 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.e |= 16;
                            var4_14 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.j = var1_1.f();
                            continue;
lbl77: // 1 sources:
                            var10_19 = null;
                            var4_14 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            if ((this.e & 8) == 8) {
                                var4_14 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                var10_19 = this.i.M();
                            }
                            var4_14 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.i = var1_1.a(ac.a, var2_8);
                            if (var10_19 != null) {
                                var4_14 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                var10_19.a(this.i);
                                var4_14 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.i = var10_19.d();
                            }
                            var4_14 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.e |= 8;
                            continue;
lbl104: // 1 sources:
                            var4_14 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            var9_18 = var1_1.n();
                            var4_14 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            var10_19 = b.a(var9_18);
                            if (var10_19 == null) {
                                var4_14 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                var13_11.p(var5_15);
                                var4_14 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                var13_11.p(var9_18);
                                continue;
                            }
                            var4_14 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.e |= 4;
                            var4_14 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.h = var10_19;
                            continue;
lbl131: // 1 sources:
                            var4_14 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.e |= 2;
                            var4_14 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.g = var1_1.f();
                            continue;
lbl140: // 1 sources:
                            var4_14 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.e |= 1;
                            var4_14 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.f = var1_1.f();
                            continue;
                        }
                    }
                    var8_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block26;
                    }
                    catch (IOException var1_3) {
                        var4_14 = var6_16;
                        throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                        var4_14 = var7_17;
                        throw var1_4.a(this);
                    }
                }
                if ((var4_14 & 32) == 32) {
                    this.k = Collections.unmodifiableList(this.k);
                }
                if ((var4_14 & 64) == 64) {
                    this.l = Collections.unmodifiableList(this.l);
                }
                try {
                    var13_11.a();
lbl167: // 2 sources:
                    do {
                        this.d = var12_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var12_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            if ((var3_13 & 32) == 32) {
                this.k = Collections.unmodifiableList(this.k);
            }
            if ((var3_13 & 64) == 64) {
                this.l = Collections.unmodifiableList(this.l);
            }
            try {
                var13_11.a();
lbl181: // 2 sources:
                do {
                    this.d = var12_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var12_10.a();
                throw var1_6;
            }
            this.O();
            return;
            catch (IOException var2_9) {
                ** continue;
            }
            catch (IOException var1_7) {
                ** continue;
            }
        }

        private m(i.a a2) {
            super(a2);
            this.d = a2.x();
        }

        private m(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(m m2) {
            return m.u().a(m2);
        }

        public static m a() {
            return c;
        }

        public static a u() {
            return a.q();
        }

        private void x() {
            this.f = 0;
            this.g = 0;
            this.h = b.a;
            this.i = ac.a();
            this.j = 0;
            this.k = Collections.emptyList();
            this.l = Collections.emptyList();
        }

        public m a(int n2) {
            return this.k.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            this.i();
            if ((this.e & 1) == 1) {
                f2.a(1, this.f);
            }
            if ((this.e & 2) == 2) {
                f2.a(2, this.g);
            }
            if ((this.e & 4) == 4) {
                f2.c(3, this.h.a());
            }
            if ((this.e & 8) == 8) {
                f2.b(4, this.i);
            }
            if ((this.e & 16) == 16) {
                f2.a(5, this.j);
            }
            int n2 = 0;
            int n3 = 0;
            do {
                if (n3 >= this.k.size()) break;
                f2.b(6, this.k.get(n3));
                ++n3;
            } while (true);
            for (int i2 = n2; i2 < this.l.size(); ++i2) {
                f2.b(7, this.l.get(i2));
            }
            f2.c(this.d);
        }

        public m b() {
            return c;
        }

        public m b(int n2) {
            return this.l.get(n2);
        }

        public kotlin.reflect.jvm.internal.impl.f.s<m> c() {
            return a;
        }

        public boolean d() {
            return (this.e & 1) == 1;
        }

        public int e() {
            return this.f;
        }

        public boolean f() {
            return (this.e & 2) == 2;
        }

        public int g() {
            return this.g;
        }

        @Override
        public final boolean h() {
            int n2 = this.m;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            if (this.l() && !this.p().h()) {
                this.m = 0;
                return false;
            }
            for (n2 = 0; n2 < this.s(); ++n2) {
                if (this.a(n2).h()) continue;
                this.m = 0;
                return false;
            }
            for (n2 = 0; n2 < this.t(); ++n2) {
                if (this.b(n2).h()) continue;
                this.m = 0;
                return false;
            }
            this.m = 1;
            return true;
        }

        @Override
        public int i() {
            int n2;
            int n3 = this.n;
            if (n3 != -1) {
                return n3;
            }
            n3 = this.e;
            int n4 = 0;
            int n5 = (n3 & 1) == 1 ? kotlin.reflect.jvm.internal.impl.f.f.d(1, this.f) + 0 : 0;
            n3 = n5;
            if ((this.e & 2) == 2) {
                n3 = n5 + kotlin.reflect.jvm.internal.impl.f.f.d(2, this.g);
            }
            n5 = n3;
            if ((this.e & 4) == 4) {
                n5 = n3 + kotlin.reflect.jvm.internal.impl.f.f.e(3, this.h.a());
            }
            n3 = n5;
            if ((this.e & 8) == 8) {
                n3 = n5 + kotlin.reflect.jvm.internal.impl.f.f.d(4, this.i);
            }
            n5 = n3;
            if ((this.e & 16) == 16) {
                n5 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(5, this.j);
            }
            n3 = n5;
            n5 = 0;
            do {
                n2 = n3;
                if (n5 >= this.k.size()) break;
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(6, this.k.get(n5));
                ++n5;
            } while (true);
            for (int i2 = n4; i2 < this.l.size(); ++i2) {
                n2 += kotlin.reflect.jvm.internal.impl.f.f.d(7, this.l.get(i2));
            }
            this.n = n3 = n2 + this.d.a();
            return n3;
        }

        public boolean j() {
            return (this.e & 4) == 4;
        }

        public b k() {
            return this.h;
        }

        public boolean l() {
            return (this.e & 8) == 8;
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.w();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.v();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public ac p() {
            return this.i;
        }

        public boolean q() {
            return (this.e & 16) == 16;
        }

        public int r() {
            return this.j;
        }

        public int s() {
            return this.k.size();
        }

        public int t() {
            return this.l.size();
        }

        public a v() {
            return m.u();
        }

        public a w() {
            return m.a(this);
        }

        public static final class a
        extends i.a<m, a>
        implements n {
            private int a;
            private int b;
            private int c;
            private b d = b.a;
            private ac e = ac.a();
            private int f;
            private List<m> g = Collections.emptyList();
            private List<m> h = Collections.emptyList();

            private a() {
                this.p();
            }

            private void p() {
            }

            private static a q() {
                return new a();
            }

            private void r() {
                if ((this.a & 32) != 32) {
                    this.g = new ArrayList<m>(this.g);
                    this.a |= 32;
                }
            }

            private void s() {
                if ((this.a & 64) != 64) {
                    this.h = new ArrayList<m>(this.h);
                    this.a |= 64;
                }
            }

            public a a() {
                return a.q().a(this.d());
            }

            @Override
            public a a(int n2) {
                this.a |= 1;
                this.b = n2;
                return this;
            }

            @Override
            public a a(ac ac2) {
                ac ac3 = ac2;
                if ((this.a & 8) == 8) {
                    ac3 = ac2;
                    if (this.e != ac.a()) {
                        ac3 = ac.a(this.e).a(ac2).d();
                    }
                }
                this.e = ac3;
                this.a |= 8;
                return this;
            }

            @Override
            public a a(b b2) {
                if (b2 != null) {
                    this.a |= 4;
                    this.d = b2;
                    return this;
                }
                throw new NullPointerException();
            }

            @Override
            public a a(m m2) {
                if (m2 == m.a()) {
                    return this;
                }
                if (m2.d()) {
                    this.a(m2.e());
                }
                if (m2.f()) {
                    this.b(m2.g());
                }
                if (m2.j()) {
                    this.a(m2.k());
                }
                if (m2.l()) {
                    this.a(m2.p());
                }
                if (m2.q()) {
                    this.c(m2.r());
                }
                if (!m2.k.isEmpty()) {
                    if (this.g.isEmpty()) {
                        this.g = m2.k;
                        this.a &= -33;
                    } else {
                        this.r();
                        this.g.addAll(m2.k);
                    }
                }
                if (!m2.l.isEmpty()) {
                    if (this.h.isEmpty()) {
                        this.h = m2.l;
                        this.a &= -65;
                    } else {
                        this.s();
                        this.h.addAll(m2.l);
                    }
                }
                this.a(this.x().a(m2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = m.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((m)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (m)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((m)object);
                throw var2_6;
            }

            public a b(int n2) {
                this.a |= 2;
                this.c = n2;
                return this;
            }

            public m b() {
                return m.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public a c(int n2) {
                this.a |= 16;
                this.f = n2;
                return this;
            }

            public m c() {
                m m2 = this.d();
                if (m2.h()) {
                    return m2;
                }
                throw a.a(m2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public m d() {
                m m2 = new m(this);
                int n2 = this.a;
                int n3 = 1;
                if ((n2 & 1) != 1) {
                    n3 = 0;
                }
                m2.f = this.b;
                int n4 = n3;
                if ((n2 & 2) == 2) {
                    n4 = n3 | 2;
                }
                m2.g = this.c;
                n3 = n4;
                if ((n2 & 4) == 4) {
                    n3 = n4 | 4;
                }
                m2.h = this.d;
                n4 = n3;
                if ((n2 & 8) == 8) {
                    n4 = n3 | 8;
                }
                m2.i = this.e;
                n3 = n4;
                if ((n2 & 16) == 16) {
                    n3 = n4 | 16;
                }
                m2.j = this.f;
                if ((this.a & 32) == 32) {
                    this.g = Collections.unmodifiableList(this.g);
                    this.a &= -33;
                }
                m2.k = this.g;
                if ((this.a & 64) == 64) {
                    this.h = Collections.unmodifiableList(this.h);
                    this.a &= -65;
                }
                m2.l = this.h;
                m2.e = n3;
                return m2;
            }

            public m d(int n2) {
                return this.g.get(n2);
            }

            public m e(int n2) {
                return this.h.get(n2);
            }

            public boolean e() {
                return (this.a & 8) == 8;
            }

            public ac f() {
                return this.e;
            }

            public int g() {
                return this.g.size();
            }

            @Override
            public final boolean h() {
                int n2;
                if (this.e() && !this.f().h()) {
                    return false;
                }
                for (n2 = 0; n2 < this.g(); ++n2) {
                    if (this.d(n2).h()) continue;
                    return false;
                }
                for (n2 = 0; n2 < this.m(); ++n2) {
                    if (this.e(n2).h()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            public int m() {
                return this.h.size();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }
        }

        public static enum b implements j.a
        {
            a(0, 0),
            b(1, 1),
            c(2, 2);
            
            private static j.b<b> d;
            private final int e;

            static {
                d = new j.b<b>(){

                    public b a(int n2) {
                        return b.a(n2);
                    }

                    @Override
                    public /* synthetic */ j.a b(int n2) {
                        return this.a(n2);
                    }
                };
            }

            private b(int n3, int n4) {
                this.e = n4;
            }

            public static b a(int n2) {
                switch (n2) {
                    default: {
                        return null;
                    }
                    case 2: {
                        return c;
                    }
                    case 1: {
                        return b;
                    }
                    case 0: 
                }
                return a;
            }

            @Override
            public final int a() {
                return this.e;
            }

        }

    }

    public static interface n
    extends kotlin.reflect.jvm.internal.impl.f.r {
    }

    public static final class o
    extends i.c<o>
    implements p {
        public static kotlin.reflect.jvm.internal.impl.f.s<o> a = new kotlin.reflect.jvm.internal.impl.f.b<o>(){

            public o a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new o(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final o c = new o(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private int f;
        private int g;
        private int h;
        private ac i;
        private int j;
        private List<ag> k;
        private ac l;
        private int m;
        private List<ak> n;
        private ai o;
        private List<Integer> p;
        private g q;
        private byte r;
        private int s;

        static {
            c.I();
        }

        /*
         * Exception decompiling
         */
        private o(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: First case is not immediately after switch.
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:358)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:61)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:372)
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

        private o(i.b<o, ?> b2) {
            super(b2);
            this.r = (byte)-1;
            this.s = -1;
            this.d = b2.x();
        }

        private o(boolean bl2) {
            this.r = (byte)-1;
            this.s = -1;
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a F() {
            return a.A();
        }

        private void I() {
            this.f = 6;
            this.g = 6;
            this.h = 0;
            this.i = ac.a();
            this.j = 0;
            this.k = Collections.emptyList();
            this.l = ac.a();
            this.m = 0;
            this.n = Collections.emptyList();
            this.o = ai.a();
            this.p = Collections.emptyList();
            this.q = g.a();
        }

        public static a a(o o2) {
            return o.F().a(o2);
        }

        public static o a() {
            return c;
        }

        public static o a(InputStream inputStream, kotlin.reflect.jvm.internal.impl.f.g g2) {
            return a.f(inputStream, g2);
        }

        public boolean A() {
            return (this.e & 128) == 128;
        }

        public ai B() {
            return this.o;
        }

        public List<Integer> C() {
            return this.p;
        }

        public boolean D() {
            return (this.e & 256) == 256;
        }

        public g E() {
            return this.q;
        }

        public a G() {
            return o.F();
        }

        public a H() {
            return o.a(this);
        }

        public ag a(int n2) {
            return this.k.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            int n2;
            this.i();
            i.c.a a2 = this.Q();
            if ((this.e & 2) == 2) {
                f2.a(1, this.g);
            }
            if ((this.e & 4) == 4) {
                f2.a(2, this.h);
            }
            if ((this.e & 8) == 8) {
                f2.b(3, this.i);
            }
            int n3 = 0;
            for (n2 = 0; n2 < this.k.size(); ++n2) {
                f2.b(4, this.k.get(n2));
            }
            if ((this.e & 32) == 32) {
                f2.b(5, this.l);
            }
            for (n2 = 0; n2 < this.n.size(); ++n2) {
                f2.b(6, this.n.get(n2));
            }
            if ((this.e & 16) == 16) {
                f2.a(7, this.j);
            }
            if ((this.e & 64) == 64) {
                f2.a(8, this.m);
            }
            if ((this.e & 1) == 1) {
                f2.a(9, this.f);
            }
            n2 = n3;
            if ((this.e & 128) == 128) {
                f2.b(30, this.o);
                n2 = n3;
            }
            while (n2 < this.p.size()) {
                f2.a(31, this.p.get(n2));
                ++n2;
            }
            if ((this.e & 256) == 256) {
                f2.b(32, this.q);
            }
            a2.a(19000, f2);
            f2.c(this.d);
        }

        public ak b(int n2) {
            return this.n.get(n2);
        }

        public o b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<o> c() {
            return a;
        }

        public boolean d() {
            return (this.e & 1) == 1;
        }

        public int e() {
            return this.f;
        }

        public boolean f() {
            return (this.e & 2) == 2;
        }

        public int g() {
            return this.g;
        }

        @Override
        public final boolean h() {
            int n2 = this.r;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            if (!this.j()) {
                this.r = 0;
                return false;
            }
            if (this.l() && !this.p().h()) {
                this.r = 0;
                return false;
            }
            for (n2 = 0; n2 < this.t(); ++n2) {
                if (this.a(n2).h()) continue;
                this.r = 0;
                return false;
            }
            if (this.u() && !this.v().h()) {
                this.r = 0;
                return false;
            }
            for (n2 = 0; n2 < this.z(); ++n2) {
                if (this.b(n2).h()) continue;
                this.r = 0;
                return false;
            }
            if (this.A() && !this.B().h()) {
                this.r = 0;
                return false;
            }
            if (this.D() && !this.E().h()) {
                this.r = 0;
                return false;
            }
            if (!this.P()) {
                this.r = 0;
                return false;
            }
            this.r = 1;
            return true;
        }

        @Override
        public int i() {
            int n2 = this.s;
            if (n2 != -1) {
                return n2;
            }
            n2 = this.e;
            int n3 = 0;
            int n4 = (n2 & 2) == 2 ? kotlin.reflect.jvm.internal.impl.f.f.d(1, this.g) + 0 : 0;
            n2 = n4;
            if ((this.e & 4) == 4) {
                n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.d(2, this.h);
            }
            n4 = n2;
            if ((this.e & 8) == 8) {
                n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(3, this.i);
            }
            n2 = n4;
            for (n4 = 0; n4 < this.k.size(); ++n4) {
                n2 += kotlin.reflect.jvm.internal.impl.f.f.d(4, this.k.get(n4));
            }
            n4 = n2;
            if ((this.e & 32) == 32) {
                n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(5, this.l);
            }
            int n5 = 0;
            n2 = n4;
            for (n4 = n5; n4 < this.n.size(); ++n4) {
                n2 += kotlin.reflect.jvm.internal.impl.f.f.d(6, this.n.get(n4));
            }
            n4 = n2;
            if ((this.e & 16) == 16) {
                n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(7, this.j);
            }
            n2 = n4;
            if ((this.e & 64) == 64) {
                n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.d(8, this.m);
            }
            n4 = n2;
            if ((this.e & 1) == 1) {
                n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(9, this.f);
            }
            n2 = n4;
            if ((this.e & 128) == 128) {
                n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.d(30, this.o);
            }
            n5 = 0;
            n4 = n3;
            n3 = n5;
            while (n4 < this.p.size()) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.h(this.p.get(n4));
                ++n4;
            }
            n2 = n4 = n2 + n3 + this.C().size() * 2;
            if ((this.e & 256) == 256) {
                n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.d(32, this.q);
            }
            this.s = n2 = n2 + this.R() + this.d.a();
            return n2;
        }

        public boolean j() {
            return (this.e & 4) == 4;
        }

        public int k() {
            return this.h;
        }

        public boolean l() {
            return (this.e & 8) == 8;
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.H();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.G();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public ac p() {
            return this.i;
        }

        public boolean q() {
            return (this.e & 16) == 16;
        }

        public int r() {
            return this.j;
        }

        public List<ag> s() {
            return this.k;
        }

        public int t() {
            return this.k.size();
        }

        public boolean u() {
            return (this.e & 32) == 32;
        }

        public ac v() {
            return this.l;
        }

        public boolean w() {
            return (this.e & 64) == 64;
        }

        public int x() {
            return this.m;
        }

        public List<ak> y() {
            return this.n;
        }

        public int z() {
            return this.n.size();
        }

        public static final class a
        extends i.b<o, a>
        implements p {
            private int a;
            private int b = 6;
            private int c = 6;
            private int d;
            private ac e = ac.a();
            private int f;
            private List<ag> g = Collections.emptyList();
            private ac h = ac.a();
            private int i;
            private List<ak> j = Collections.emptyList();
            private ai k = ai.a();
            private List<Integer> l = Collections.emptyList();
            private g m = g.a();

            private a() {
                this.z();
            }

            private static a A() {
                return new a();
            }

            private void B() {
                if ((this.a & 32) != 32) {
                    this.g = new ArrayList<ag>(this.g);
                    this.a |= 32;
                }
            }

            private void C() {
                if ((this.a & 256) != 256) {
                    this.j = new ArrayList<ak>(this.j);
                    this.a |= 256;
                }
            }

            private void D() {
                if ((this.a & 1024) != 1024) {
                    this.l = new ArrayList<Integer>(this.l);
                    this.a |= 1024;
                }
            }

            private void z() {
            }

            public a a() {
                return a.A().a(this.d());
            }

            @Override
            public a a(int n2) {
                this.a |= 1;
                this.b = n2;
                return this;
            }

            @Override
            public a a(ac ac2) {
                ac ac3 = ac2;
                if ((this.a & 8) == 8) {
                    ac3 = ac2;
                    if (this.e != ac.a()) {
                        ac3 = ac.a(this.e).a(ac2).d();
                    }
                }
                this.e = ac3;
                this.a |= 8;
                return this;
            }

            @Override
            public a a(ai ai2) {
                ai ai3 = ai2;
                if ((this.a & 512) == 512) {
                    ai3 = ai2;
                    if (this.k != ai.a()) {
                        ai3 = ai.a(this.k).a(ai2).d();
                    }
                }
                this.k = ai3;
                this.a |= 512;
                return this;
            }

            @Override
            public a a(g g2) {
                g g3 = g2;
                if ((this.a & 2048) == 2048) {
                    g3 = g2;
                    if (this.m != g.a()) {
                        g3 = g.a(this.m).a(g2).d();
                    }
                }
                this.m = g3;
                this.a |= 2048;
                return this;
            }

            @Override
            public a a(o o2) {
                if (o2 == o.a()) {
                    return this;
                }
                if (o2.d()) {
                    this.a(o2.e());
                }
                if (o2.f()) {
                    this.b(o2.g());
                }
                if (o2.j()) {
                    this.c(o2.k());
                }
                if (o2.l()) {
                    this.a(o2.p());
                }
                if (o2.q()) {
                    this.d(o2.r());
                }
                if (!o2.k.isEmpty()) {
                    if (this.g.isEmpty()) {
                        this.g = o2.k;
                        this.a &= -33;
                    } else {
                        this.B();
                        this.g.addAll(o2.k);
                    }
                }
                if (o2.u()) {
                    this.b(o2.v());
                }
                if (o2.w()) {
                    this.f(o2.x());
                }
                if (!o2.n.isEmpty()) {
                    if (this.j.isEmpty()) {
                        this.j = o2.n;
                        this.a &= -257;
                    } else {
                        this.C();
                        this.j.addAll(o2.n);
                    }
                }
                if (o2.A()) {
                    this.a(o2.B());
                }
                if (!o2.p.isEmpty()) {
                    if (this.l.isEmpty()) {
                        this.l = o2.p;
                        this.a &= -1025;
                    } else {
                        this.D();
                        this.l.addAll(o2.p);
                    }
                }
                if (o2.D()) {
                    this.a(o2.E());
                }
                this.a(o2);
                this.a(this.x().a(o2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = o.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((o)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (o)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((o)object);
                throw var2_6;
            }

            public a b(int n2) {
                this.a |= 2;
                this.c = n2;
                return this;
            }

            public a b(ac ac2) {
                ac ac3 = ac2;
                if ((this.a & 64) == 64) {
                    ac3 = ac2;
                    if (this.h != ac.a()) {
                        ac3 = ac.a(this.h).a(ac2).d();
                    }
                }
                this.h = ac3;
                this.a |= 64;
                return this;
            }

            public o b() {
                return o.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public a c(int n2) {
                this.a |= 4;
                this.d = n2;
                return this;
            }

            public o c() {
                o o2 = this.d();
                if (o2.h()) {
                    return o2;
                }
                throw a.a(o2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public a d(int n2) {
                this.a |= 16;
                this.f = n2;
                return this;
            }

            public o d() {
                o o2 = new o(this);
                int n2 = this.a;
                int n3 = 1;
                if ((n2 & 1) != 1) {
                    n3 = 0;
                }
                o2.f = this.b;
                int n4 = n3;
                if ((n2 & 2) == 2) {
                    n4 = n3 | 2;
                }
                o2.g = this.c;
                n3 = n4;
                if ((n2 & 4) == 4) {
                    n3 = n4 | 4;
                }
                o2.h = this.d;
                n4 = n3;
                if ((n2 & 8) == 8) {
                    n4 = n3 | 8;
                }
                o2.i = this.e;
                n3 = n4;
                if ((n2 & 16) == 16) {
                    n3 = n4 | 16;
                }
                o2.j = this.f;
                if ((this.a & 32) == 32) {
                    this.g = Collections.unmodifiableList(this.g);
                    this.a &= -33;
                }
                o2.k = this.g;
                n4 = n3;
                if ((n2 & 64) == 64) {
                    n4 = n3 | 32;
                }
                o2.l = this.h;
                n3 = n4;
                if ((n2 & 128) == 128) {
                    n3 = n4 | 64;
                }
                o2.m = this.i;
                if ((this.a & 256) == 256) {
                    this.j = Collections.unmodifiableList(this.j);
                    this.a &= -257;
                }
                o2.n = this.j;
                n4 = n3;
                if ((n2 & 512) == 512) {
                    n4 = n3 | 128;
                }
                o2.o = this.k;
                if ((this.a & 1024) == 1024) {
                    this.l = Collections.unmodifiableList(this.l);
                    this.a &= -1025;
                }
                o2.p = this.l;
                n3 = n4;
                if ((n2 & 2048) == 2048) {
                    n3 = n4 | 256;
                }
                o2.q = this.m;
                o2.e = n3;
                return o2;
            }

            public ag e(int n2) {
                return this.g.get(n2);
            }

            public boolean e() {
                return (this.a & 4) == 4;
            }

            public a f(int n2) {
                this.a |= 128;
                this.i = n2;
                return this;
            }

            public boolean f() {
                return (this.a & 8) == 8;
            }

            public ac g() {
                return this.e;
            }

            public ak g(int n2) {
                return this.j.get(n2);
            }

            @Override
            public final boolean h() {
                int n2;
                if (!this.e()) {
                    return false;
                }
                if (this.f() && !this.g().h()) {
                    return false;
                }
                for (n2 = 0; n2 < this.m(); ++n2) {
                    if (this.e(n2).h()) continue;
                    return false;
                }
                if (this.n() && !this.p().h()) {
                    return false;
                }
                for (n2 = 0; n2 < this.q(); ++n2) {
                    if (this.g(n2).h()) continue;
                    return false;
                }
                if (this.r() && !this.s().h()) {
                    return false;
                }
                if (this.t() && !this.v().h()) {
                    return false;
                }
                return this.y();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            public int m() {
                return this.g.size();
            }

            public boolean n() {
                return (this.a & 64) == 64;
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }

            public ac p() {
                return this.h;
            }

            public int q() {
                return this.j.size();
            }

            public boolean r() {
                return (this.a & 512) == 512;
            }

            public ai s() {
                return this.k;
            }

            public boolean t() {
                return (this.a & 2048) == 2048;
            }

            @Override
            public /* synthetic */ i.b u() {
                return this.a();
            }

            public g v() {
                return this.m;
            }
        }

    }

    public static interface p
    extends i.d {
    }

    public static enum q implements j.a
    {
        a(0, 0),
        b(1, 1),
        c(2, 2),
        d(3, 3);
        
        private static j.b<q> e;
        private final int f;

        static {
            e = new j.b<q>(){

                public q a(int n2) {
                    return q.a(n2);
                }

                @Override
                public /* synthetic */ j.a b(int n2) {
                    return this.a(n2);
                }
            };
        }

        private q(int n3, int n4) {
            this.f = n4;
        }

        public static q a(int n2) {
            switch (n2) {
                default: {
                    return null;
                }
                case 3: {
                    return d;
                }
                case 2: {
                    return c;
                }
                case 1: {
                    return b;
                }
                case 0: 
            }
            return a;
        }

        @Override
        public final int a() {
            return this.f;
        }

    }

    public static enum r implements j.a
    {
        a(0, 0),
        b(1, 1),
        c(2, 2),
        d(3, 3);
        
        private static j.b<r> e;
        private final int f;

        static {
            e = new j.b<r>(){

                public r a(int n2) {
                    return r.a(n2);
                }

                @Override
                public /* synthetic */ j.a b(int n2) {
                    return this.a(n2);
                }
            };
        }

        private r(int n3, int n4) {
            this.f = n4;
        }

        public static r a(int n2) {
            switch (n2) {
                default: {
                    return null;
                }
                case 3: {
                    return d;
                }
                case 2: {
                    return c;
                }
                case 1: {
                    return b;
                }
                case 0: 
            }
            return a;
        }

        @Override
        public final int a() {
            return this.f;
        }

    }

    public static final class s
    extends i.c<s>
    implements v {
        public static kotlin.reflect.jvm.internal.impl.f.s<s> a = new kotlin.reflect.jvm.internal.impl.f.b<s>(){

            public s a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new s(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final s c = new s(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private List<o> f;
        private List<w> g;
        private List<ad> h;
        private ai i;
        private ao j;
        private byte k = (byte)-1;
        private int l = -1;

        static {
            c.v();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private s(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.v();
            var11_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var12_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var11_10, 1);
            var8_12 = false;
            var3_13 = 0;
            block11 : while (!var8_12) {
                block28 : {
                    block29 : {
                        block30 : {
                            block31 : {
                                block32 : {
                                    block33 : {
                                        block34 : {
                                            var4_14 = var3_13;
                                            var5_15 = var3_13;
                                            var6_16 = var3_13;
                                            var7_17 = var1_1.a();
                                            if (var7_17 == 0) break block29;
                                            if (var7_17 == 26) break block30;
                                            if (var7_17 == 34) break block31;
                                            if (var7_17 == 42) break block32;
                                            var10_19 = null;
                                            var9_18 = null;
                                            if (var7_17 == 242) break block33;
                                            if (var7_17 == 258) break block34;
                                            var4_14 = var3_13;
                                            var5_15 = var3_13;
                                            var6_16 = var3_13;
                                            if (this.a(var1_1, var12_11, var2_8, var7_17)) continue;
                                            break block29;
                                        }
                                        var4_14 = var3_13;
                                        var5_15 = var3_13;
                                        var6_16 = var3_13;
                                        if ((this.e & 2) == 2) {
                                            var4_14 = var3_13;
                                            var5_15 = var3_13;
                                            var6_16 = var3_13;
                                            var9_18 = this.j.j();
                                        }
                                        var4_14 = var3_13;
                                        var5_15 = var3_13;
                                        var6_16 = var3_13;
                                        this.j = var1_1.a(ao.a, var2_8);
                                        if (var9_18 != null) {
                                            var4_14 = var3_13;
                                            var5_15 = var3_13;
                                            var6_16 = var3_13;
                                            var9_18.a(this.j);
                                            var4_14 = var3_13;
                                            var5_15 = var3_13;
                                            var6_16 = var3_13;
                                            this.j = var9_18.d();
                                        }
                                        var4_14 = var3_13;
                                        var5_15 = var3_13;
                                        var6_16 = var3_13;
                                        this.e |= 2;
                                        continue;
                                    }
                                    var9_18 = var10_19;
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    if ((this.e & 1) == 1) {
                                        var4_14 = var3_13;
                                        var5_15 = var3_13;
                                        var6_16 = var3_13;
                                        var9_18 = this.i.l();
                                    }
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    this.i = var1_1.a(ai.a, var2_8);
                                    if (var9_18 != null) {
                                        var4_14 = var3_13;
                                        var5_15 = var3_13;
                                        var6_16 = var3_13;
                                        var9_18.a(this.i);
                                        var4_14 = var3_13;
                                        var5_15 = var3_13;
                                        var6_16 = var3_13;
                                        this.i = var9_18.d();
                                    }
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    this.e |= 1;
                                    continue;
                                }
                                var7_17 = var3_13;
                                if ((var3_13 & 4) != 4) {
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    this.h = new ArrayList<ad>();
                                    var7_17 = var3_13 | 4;
                                }
                                var4_14 = var7_17;
                                var5_15 = var7_17;
                                var6_16 = var7_17;
                                var9_18 = this.h;
                                var4_14 = var7_17;
                                var5_15 = var7_17;
                                var6_16 = var7_17;
                                var10_19 = var1_1.a(ad.a, var2_8);
                                var3_13 = var7_17;
lbl101: // 3 sources:
                                do {
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    var9_18.add(var10_19);
                                    continue block11;
                                    break;
                                } while (true);
                            }
                            var7_17 = var3_13;
                            if ((var3_13 & 2) != 2) {
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                this.g = new ArrayList<w>();
                                var7_17 = var3_13 | 2;
                            }
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var9_18 = this.g;
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var10_19 = var1_1.a(w.a, var2_8);
                            var3_13 = var7_17;
                            ** GOTO lbl101
                        }
                        var7_17 = var3_13;
                        if ((var3_13 & 1) != 1) {
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            this.f = new ArrayList<o>();
                            var7_17 = var3_13 | 1;
                        }
                        var4_14 = var7_17;
                        var5_15 = var7_17;
                        var6_16 = var7_17;
                        var9_18 = this.f;
                        var4_14 = var7_17;
                        var5_15 = var7_17;
                        var6_16 = var7_17;
                        var10_19 = var1_1.a(o.a, var2_8);
                        var3_13 = var7_17;
                        ** continue;
                    }
                    var8_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block28;
                    }
                    catch (IOException var1_3) {
                        var4_14 = var5_15;
                        throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                        var4_14 = var6_16;
                        throw var1_4.a(this);
                    }
                }
                if ((var4_14 & 1) == 1) {
                    this.f = Collections.unmodifiableList(this.f);
                }
                if ((var4_14 & 2) == 2) {
                    this.g = Collections.unmodifiableList(this.g);
                }
                if ((var4_14 & 4) == 4) {
                    this.h = Collections.unmodifiableList(this.h);
                }
                try {
                    var12_11.a();
lbl163: // 2 sources:
                    do {
                        this.d = var11_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var11_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            if (var3_13 & true) {
                this.f = Collections.unmodifiableList(this.f);
            }
            if ((var3_13 & 2) == 2) {
                this.g = Collections.unmodifiableList(this.g);
            }
            if ((var3_13 & 4) == 4) {
                this.h = Collections.unmodifiableList(this.h);
            }
            try {
                var12_11.a();
lbl179: // 2 sources:
                do {
                    this.d = var11_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var11_10.a();
                throw var1_6;
            }
            this.O();
            return;
            catch (IOException var2_9) {
                ** continue;
            }
            catch (IOException var1_7) {
                ** continue;
            }
        }

        private s(i.b<s, ?> b2) {
            super(b2);
            this.d = b2.x();
        }

        private s(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(s s2) {
            return s.s().a(s2);
        }

        public static s a() {
            return c;
        }

        public static s a(InputStream inputStream, kotlin.reflect.jvm.internal.impl.f.g g2) {
            return a.f(inputStream, g2);
        }

        public static a s() {
            return a.r();
        }

        private void v() {
            this.f = Collections.emptyList();
            this.g = Collections.emptyList();
            this.h = Collections.emptyList();
            this.i = ai.a();
            this.j = ao.a();
        }

        public o a(int n2) {
            return this.f.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            int n2;
            this.i();
            i.c.a a2 = this.Q();
            int n3 = 0;
            for (n2 = 0; n2 < this.f.size(); ++n2) {
                f2.b(3, this.f.get(n2));
            }
            n2 = 0;
            do {
                if (n2 >= this.g.size()) break;
                f2.b(4, this.g.get(n2));
                ++n2;
            } while (true);
            for (int i2 = n3; i2 < this.h.size(); ++i2) {
                f2.b(5, this.h.get(i2));
            }
            if ((this.e & 1) == 1) {
                f2.b(30, this.i);
            }
            if ((this.e & 2) == 2) {
                f2.b(32, this.j);
            }
            a2.a(200, f2);
            f2.c(this.d);
        }

        public s b() {
            return c;
        }

        public w b(int n2) {
            return this.g.get(n2);
        }

        public ad c(int n2) {
            return this.h.get(n2);
        }

        public kotlin.reflect.jvm.internal.impl.f.s<s> c() {
            return a;
        }

        public List<o> d() {
            return this.f;
        }

        public int e() {
            return this.f.size();
        }

        public List<w> f() {
            return this.g;
        }

        public int g() {
            return this.g.size();
        }

        @Override
        public final boolean h() {
            int n2 = this.k;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            for (n2 = 0; n2 < this.e(); ++n2) {
                if (this.a(n2).h()) continue;
                this.k = 0;
                return false;
            }
            for (n2 = 0; n2 < this.g(); ++n2) {
                if (this.b(n2).h()) continue;
                this.k = 0;
                return false;
            }
            for (n2 = 0; n2 < this.k(); ++n2) {
                if (this.c(n2).h()) continue;
                this.k = 0;
                return false;
            }
            if (this.l() && !this.p().h()) {
                this.k = 0;
                return false;
            }
            if (!this.P()) {
                this.k = 0;
                return false;
            }
            this.k = 1;
            return true;
        }

        @Override
        public int i() {
            int n2;
            int n3 = this.l;
            if (n3 != -1) {
                return n3;
            }
            int n4 = 0;
            n3 = 0;
            for (n2 = 0; n2 < this.f.size(); ++n2) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(3, this.f.get(n2));
            }
            int n5 = 0;
            do {
                n2 = n3;
                if (n5 >= this.g.size()) break;
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(4, this.g.get(n5));
                ++n5;
            } while (true);
            for (int i2 = n4; i2 < this.h.size(); ++i2) {
                n2 += kotlin.reflect.jvm.internal.impl.f.f.d(5, this.h.get(i2));
            }
            n3 = n2;
            if ((this.e & 1) == 1) {
                n3 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(30, this.i);
            }
            n2 = n3;
            if ((this.e & 2) == 2) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(32, this.j);
            }
            this.l = n3 = n2 + this.R() + this.d.a();
            return n3;
        }

        public List<ad> j() {
            return this.h;
        }

        public int k() {
            return this.h.size();
        }

        public boolean l() {
            return (this.e & 1) == 1;
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.u();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.t();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public ai p() {
            return this.i;
        }

        public boolean q() {
            return (this.e & 2) == 2;
        }

        public ao r() {
            return this.j;
        }

        public a t() {
            return s.s();
        }

        public a u() {
            return s.a(this);
        }

        public static final class a
        extends i.b<s, a>
        implements v {
            private int a;
            private List<o> b = Collections.emptyList();
            private List<w> c = Collections.emptyList();
            private List<ad> d = Collections.emptyList();
            private ai e = ai.a();
            private ao f = ao.a();

            private a() {
                this.q();
            }

            private void q() {
            }

            private static a r() {
                return new a();
            }

            private void s() {
                if ((this.a & 1) != 1) {
                    this.b = new ArrayList<o>(this.b);
                    this.a |= 1;
                }
            }

            private void t() {
                if ((this.a & 2) != 2) {
                    this.c = new ArrayList<w>(this.c);
                    this.a |= 2;
                }
            }

            private void v() {
                if ((this.a & 4) != 4) {
                    this.d = new ArrayList<ad>(this.d);
                    this.a |= 4;
                }
            }

            @Override
            public o a(int n2) {
                return this.b.get(n2);
            }

            public a a() {
                return a.r().a(this.d());
            }

            @Override
            public a a(ai ai2) {
                ai ai3 = ai2;
                if ((this.a & 8) == 8) {
                    ai3 = ai2;
                    if (this.e != ai.a()) {
                        ai3 = ai.a(this.e).a(ai2).d();
                    }
                }
                this.e = ai3;
                this.a |= 8;
                return this;
            }

            @Override
            public a a(ao ao2) {
                ao ao3 = ao2;
                if ((this.a & 16) == 16) {
                    ao3 = ao2;
                    if (this.f != ao.a()) {
                        ao3 = ao.a(this.f).a(ao2).d();
                    }
                }
                this.f = ao3;
                this.a |= 16;
                return this;
            }

            @Override
            public a a(s s2) {
                if (s2 == s.a()) {
                    return this;
                }
                if (!s2.f.isEmpty()) {
                    if (this.b.isEmpty()) {
                        this.b = s2.f;
                        this.a &= -2;
                    } else {
                        this.s();
                        this.b.addAll(s2.f);
                    }
                }
                if (!s2.g.isEmpty()) {
                    if (this.c.isEmpty()) {
                        this.c = s2.g;
                        this.a &= -3;
                    } else {
                        this.t();
                        this.c.addAll(s2.g);
                    }
                }
                if (!s2.h.isEmpty()) {
                    if (this.d.isEmpty()) {
                        this.d = s2.h;
                        this.a &= -5;
                    } else {
                        this.v();
                        this.d.addAll(s2.h);
                    }
                }
                if (s2.l()) {
                    this.a(s2.p());
                }
                if (s2.q()) {
                    this.a(s2.r());
                }
                this.a(s2);
                this.a(this.x().a(s2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = s.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((s)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (s)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((s)object);
                throw var2_6;
            }

            public s b() {
                return s.a();
            }

            public w b(int n2) {
                return this.c.get(n2);
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public ad c(int n2) {
                return this.d.get(n2);
            }

            public s c() {
                s s2 = this.d();
                if (s2.h()) {
                    return s2;
                }
                throw a.a(s2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public s d() {
                s s2 = new s(this);
                int n2 = this.a;
                int n3 = this.a;
                int n4 = 1;
                if ((n3 & 1) == 1) {
                    this.b = Collections.unmodifiableList(this.b);
                    this.a &= -2;
                }
                s2.f = this.b;
                if ((this.a & 2) == 2) {
                    this.c = Collections.unmodifiableList(this.c);
                    this.a &= -3;
                }
                s2.g = this.c;
                if ((this.a & 4) == 4) {
                    this.d = Collections.unmodifiableList(this.d);
                    this.a &= -5;
                }
                s2.h = this.d;
                if ((n2 & 8) != 8) {
                    n4 = 0;
                }
                s2.i = this.e;
                n3 = n4;
                if ((n2 & 16) == 16) {
                    n3 = n4 | 2;
                }
                s2.j = this.f;
                s2.e = n3;
                return s2;
            }

            public int e() {
                return this.b.size();
            }

            public int f() {
                return this.c.size();
            }

            public int g() {
                return this.d.size();
            }

            @Override
            public final boolean h() {
                int n2;
                for (n2 = 0; n2 < this.e(); ++n2) {
                    if (this.a(n2).h()) continue;
                    return false;
                }
                for (n2 = 0; n2 < this.f(); ++n2) {
                    if (this.b(n2).h()) continue;
                    return false;
                }
                for (n2 = 0; n2 < this.g(); ++n2) {
                    if (this.c(n2).h()) continue;
                    return false;
                }
                if (this.m() && !this.n().h()) {
                    return false;
                }
                return this.y();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            public boolean m() {
                return (this.a & 8) == 8;
            }

            public ai n() {
                return this.e;
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.b u() {
                return this.a();
            }
        }

    }

    public static final class t
    extends i.c<t>
    implements u {
        public static kotlin.reflect.jvm.internal.impl.f.s<t> a = new kotlin.reflect.jvm.internal.impl.f.b<t>(){

            public t a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new t(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final t c = new t(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private aa f;
        private y g;
        private s h;
        private List<c> i;
        private byte j = (byte)-1;
        private int k = -1;

        static {
            c.t();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private t(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.t();
            var13_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var14_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var13_10, 1);
            var8_12 = false;
            var3_13 = 0;
            block11 : while (!var8_12) {
                block26 : {
                    block27 : {
                        var5_15 = var3_13;
                        var6_16 = var3_13;
                        var7_17 = var3_13;
                        var4_14 = var1_1.a();
                        if (var4_14 == 0) break block27;
                        var11_20 = null;
                        var12_21 = null;
                        var10_19 = null;
                        if (var4_14 == 10) ** GOTO lbl104
                        if (var4_14 == 18) ** GOTO lbl75
                        if (var4_14 == 26) ** GOTO lbl42
                        if (var4_14 != 34) {
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            if (this.a(var1_1, var14_11, var2_8, var4_14)) continue;
                        } else {
                            var4_14 = var3_13;
                            if ((var3_13 & 8) != 8) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.i = new ArrayList<c>();
                                var4_14 = var3_13 | 8;
                            }
                            var5_15 = var4_14;
                            var6_16 = var4_14;
                            var7_17 = var4_14;
                            this.i.add(var1_1.a(c.a, var2_8));
                            var3_13 = var4_14;
                            continue;
lbl42: // 1 sources:
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            var4_14 = this.e;
                            var9_18 = 4;
                            if ((var4_14 & 4) == 4) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                var10_19 = this.h.u();
                            }
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.h = var1_1.a(s.a, var2_8);
                            if (var10_19 != null) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                var10_19.a(this.h);
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.h = var10_19.d();
                            }
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            var4_14 = this.e;
lbl69: // 2 sources:
                            do {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.e = var4_14 | var9_18;
                                continue block11;
                                break;
                            } while (true);
lbl75: // 1 sources:
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            var4_14 = this.e;
                            var9_18 = 2;
                            var10_19 = var11_20;
                            if ((var4_14 & 2) == 2) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                var10_19 = this.g.g();
                            }
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.g = var1_1.a(y.a, var2_8);
                            if (var10_19 != null) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                var10_19.a(this.g);
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.g = var10_19.d();
                            }
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            var4_14 = this.e;
                            ** continue;
lbl104: // 1 sources:
                            var10_19 = var12_21;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            if ((this.e & 1) == 1) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                var10_19 = this.f.g();
                            }
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.f = var1_1.a(aa.a, var2_8);
                            if (var10_19 != null) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                var10_19.a(this.f);
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.f = var10_19.d();
                            }
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            this.e |= 1;
                            continue;
                        }
                    }
                    var8_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block26;
                    }
                    catch (IOException var1_3) {
                        var5_15 = var6_16;
                        throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                        var5_15 = var7_17;
                        throw var1_4.a(this);
                    }
                }
                if ((var5_15 & 8) == 8) {
                    this.i = Collections.unmodifiableList(this.i);
                }
                try {
                    var14_11.a();
lbl147: // 2 sources:
                    do {
                        this.d = var13_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var13_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            if ((var3_13 & 8) == 8) {
                this.i = Collections.unmodifiableList(this.i);
            }
            try {
                var14_11.a();
lbl159: // 2 sources:
                do {
                    this.d = var13_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var13_10.a();
                throw var1_6;
            }
            this.O();
            return;
            catch (IOException var2_9) {
                ** continue;
            }
            catch (IOException var1_7) {
                ** continue;
            }
        }

        private t(i.b<t, ?> b2) {
            super(b2);
            this.d = b2.x();
        }

        private t(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(t t2) {
            return t.q().a(t2);
        }

        public static t a() {
            return c;
        }

        public static t a(InputStream inputStream, kotlin.reflect.jvm.internal.impl.f.g g2) {
            return a.f(inputStream, g2);
        }

        public static a q() {
            return a.r();
        }

        private void t() {
            this.f = aa.a();
            this.g = y.a();
            this.h = s.a();
            this.i = Collections.emptyList();
        }

        public c a(int n2) {
            return this.i.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            this.i();
            i.c.a a2 = this.Q();
            if ((this.e & 1) == 1) {
                f2.b(1, this.f);
            }
            if ((this.e & 2) == 2) {
                f2.b(2, this.g);
            }
            if ((this.e & 4) == 4) {
                f2.b(3, this.h);
            }
            for (int i2 = 0; i2 < this.i.size(); ++i2) {
                f2.b(4, this.i.get(i2));
            }
            a2.a(200, f2);
            f2.c(this.d);
        }

        public t b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<t> c() {
            return a;
        }

        public boolean d() {
            return (this.e & 1) == 1;
        }

        public aa e() {
            return this.f;
        }

        public boolean f() {
            return (this.e & 2) == 2;
        }

        public y g() {
            return this.g;
        }

        @Override
        public final boolean h() {
            int n2 = this.j;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            if (this.f() && !this.g().h()) {
                this.j = 0;
                return false;
            }
            if (this.j() && !this.k().h()) {
                this.j = 0;
                return false;
            }
            for (n2 = 0; n2 < this.p(); ++n2) {
                if (this.a(n2).h()) continue;
                this.j = 0;
                return false;
            }
            if (!this.P()) {
                this.j = 0;
                return false;
            }
            this.j = 1;
            return true;
        }

        @Override
        public int i() {
            int n2 = this.k;
            if (n2 != -1) {
                return n2;
            }
            n2 = this.e;
            int n3 = 0;
            int n4 = (n2 & 1) == 1 ? kotlin.reflect.jvm.internal.impl.f.f.d(1, this.f) + 0 : 0;
            n2 = n4;
            if ((this.e & 2) == 2) {
                n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.d(2, this.g);
            }
            n4 = n2;
            int n5 = n3;
            if ((this.e & 4) == 4) {
                n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(3, this.h);
                n5 = n3;
            }
            while (n5 < this.i.size()) {
                n4 += kotlin.reflect.jvm.internal.impl.f.f.d(4, this.i.get(n5));
                ++n5;
            }
            this.k = n2 = n4 + this.R() + this.d.a();
            return n2;
        }

        public boolean j() {
            return (this.e & 4) == 4;
        }

        public s k() {
            return this.h;
        }

        public List<c> l() {
            return this.i;
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.s();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.r();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public int p() {
            return this.i.size();
        }

        public a r() {
            return t.q();
        }

        public a s() {
            return t.a(this);
        }

        public static final class a
        extends i.b<t, a>
        implements u {
            private int a;
            private aa b = aa.a();
            private y c = y.a();
            private s d = s.a();
            private List<c> e = Collections.emptyList();

            private a() {
                this.q();
            }

            private void q() {
            }

            private static a r() {
                return new a();
            }

            private void s() {
                if ((this.a & 8) != 8) {
                    this.e = new ArrayList<c>(this.e);
                    this.a |= 8;
                }
            }

            @Override
            public c a(int n2) {
                return this.e.get(n2);
            }

            public a a() {
                return a.r().a(this.d());
            }

            @Override
            public a a(aa aa2) {
                aa aa3 = aa2;
                if ((this.a & 1) == 1) {
                    aa3 = aa2;
                    if (this.b != aa.a()) {
                        aa3 = aa.a(this.b).a(aa2).d();
                    }
                }
                this.b = aa3;
                this.a |= 1;
                return this;
            }

            @Override
            public a a(s s2) {
                s s3 = s2;
                if ((this.a & 4) == 4) {
                    s3 = s2;
                    if (this.d != s.a()) {
                        s3 = s.a(this.d).a(s2).d();
                    }
                }
                this.d = s3;
                this.a |= 4;
                return this;
            }

            @Override
            public a a(t t2) {
                if (t2 == t.a()) {
                    return this;
                }
                if (t2.d()) {
                    this.a(t2.e());
                }
                if (t2.f()) {
                    this.a(t2.g());
                }
                if (t2.j()) {
                    this.a(t2.k());
                }
                if (!t2.i.isEmpty()) {
                    if (this.e.isEmpty()) {
                        this.e = t2.i;
                        this.a &= -9;
                    } else {
                        this.s();
                        this.e.addAll(t2.i);
                    }
                }
                this.a(t2);
                this.a(this.x().a(t2.d));
                return this;
            }

            @Override
            public a a(y y2) {
                y y3 = y2;
                if ((this.a & 2) == 2) {
                    y3 = y2;
                    if (this.c != y.a()) {
                        y3 = y.a(this.c).a(y2).d();
                    }
                }
                this.c = y3;
                this.a |= 2;
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = t.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((t)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (t)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((t)object);
                throw var2_6;
            }

            public t b() {
                return t.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public t c() {
                t t2 = this.d();
                if (t2.h()) {
                    return t2;
                }
                throw a.a(t2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public t d() {
                t t2 = new t(this);
                int n2 = this.a;
                int n3 = 1;
                if ((n2 & 1) != 1) {
                    n3 = 0;
                }
                t2.f = this.b;
                int n4 = n3;
                if ((n2 & 2) == 2) {
                    n4 = n3 | 2;
                }
                t2.g = this.c;
                n3 = n4;
                if ((n2 & 4) == 4) {
                    n3 = n4 | 4;
                }
                t2.h = this.d;
                if ((this.a & 8) == 8) {
                    this.e = Collections.unmodifiableList(this.e);
                    this.a &= -9;
                }
                t2.i = this.e;
                t2.e = n3;
                return t2;
            }

            public boolean e() {
                return (this.a & 2) == 2;
            }

            public y f() {
                return this.c;
            }

            public boolean g() {
                return (this.a & 4) == 4;
            }

            @Override
            public final boolean h() {
                if (this.e() && !this.f().h()) {
                    return false;
                }
                if (this.g() && !this.m().h()) {
                    return false;
                }
                for (int i2 = 0; i2 < this.n(); ++i2) {
                    if (this.a(i2).h()) continue;
                    return false;
                }
                return this.y();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            public s m() {
                return this.d;
            }

            public int n() {
                return this.e.size();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.b u() {
                return this.a();
            }
        }

    }

    public static interface u
    extends i.d {
    }

    public static interface v
    extends i.d {
    }

    public static final class w
    extends i.c<w>
    implements x {
        public static kotlin.reflect.jvm.internal.impl.f.s<w> a = new kotlin.reflect.jvm.internal.impl.f.b<w>(){

            public w a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new w(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final w c = new w(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private int f;
        private int g;
        private int h;
        private ac i;
        private int j;
        private List<ag> k;
        private ac l;
        private int m;
        private ak n;
        private int o;
        private int p;
        private List<Integer> q;
        private byte r;
        private int s;

        static {
            c.I();
        }

        /*
         * Exception decompiling
         */
        private w(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: First case is not immediately after switch.
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:358)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:61)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:372)
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

        private w(i.b<w, ?> b2) {
            super(b2);
            this.r = (byte)-1;
            this.s = -1;
            this.d = b2.x();
        }

        private w(boolean bl2) {
            this.r = (byte)-1;
            this.s = -1;
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a F() {
            return a.v();
        }

        private void I() {
            this.f = 518;
            this.g = 2054;
            this.h = 0;
            this.i = ac.a();
            this.j = 0;
            this.k = Collections.emptyList();
            this.l = ac.a();
            this.m = 0;
            this.n = ak.a();
            this.o = 0;
            this.p = 0;
            this.q = Collections.emptyList();
        }

        public static a a(w w2) {
            return w.F().a(w2);
        }

        public static w a() {
            return c;
        }

        public boolean A() {
            return (this.e & 256) == 256;
        }

        public int B() {
            return this.o;
        }

        public boolean C() {
            return (this.e & 512) == 512;
        }

        public int D() {
            return this.p;
        }

        public List<Integer> E() {
            return this.q;
        }

        public a G() {
            return w.F();
        }

        public a H() {
            return w.a(this);
        }

        public ag a(int n2) {
            return this.k.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            int n2;
            this.i();
            i.c.a a2 = this.Q();
            if ((this.e & 2) == 2) {
                f2.a(1, this.g);
            }
            if ((this.e & 4) == 4) {
                f2.a(2, this.h);
            }
            if ((this.e & 8) == 8) {
                f2.b(3, this.i);
            }
            int n3 = 0;
            for (n2 = 0; n2 < this.k.size(); ++n2) {
                f2.b(4, this.k.get(n2));
            }
            if ((this.e & 32) == 32) {
                f2.b(5, this.l);
            }
            if ((this.e & 128) == 128) {
                f2.b(6, this.n);
            }
            if ((this.e & 256) == 256) {
                f2.a(7, this.o);
            }
            if ((this.e & 512) == 512) {
                f2.a(8, this.p);
            }
            if ((this.e & 16) == 16) {
                f2.a(9, this.j);
            }
            if ((this.e & 64) == 64) {
                f2.a(10, this.m);
            }
            n2 = n3;
            if ((this.e & 1) == 1) {
                f2.a(11, this.f);
                n2 = n3;
            }
            while (n2 < this.q.size()) {
                f2.a(31, this.q.get(n2));
                ++n2;
            }
            a2.a(19000, f2);
            f2.c(this.d);
        }

        public w b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<w> c() {
            return a;
        }

        public boolean d() {
            return (this.e & 1) == 1;
        }

        public int e() {
            return this.f;
        }

        public boolean f() {
            return (this.e & 2) == 2;
        }

        public int g() {
            return this.g;
        }

        @Override
        public final boolean h() {
            int n2 = this.r;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            if (!this.j()) {
                this.r = 0;
                return false;
            }
            if (this.l() && !this.p().h()) {
                this.r = 0;
                return false;
            }
            for (n2 = 0; n2 < this.t(); ++n2) {
                if (this.a(n2).h()) continue;
                this.r = 0;
                return false;
            }
            if (this.u() && !this.v().h()) {
                this.r = 0;
                return false;
            }
            if (this.y() && !this.z().h()) {
                this.r = 0;
                return false;
            }
            if (!this.P()) {
                this.r = 0;
                return false;
            }
            this.r = 1;
            return true;
        }

        @Override
        public int i() {
            int n2 = this.s;
            if (n2 != -1) {
                return n2;
            }
            n2 = this.e;
            int n3 = 0;
            int n4 = (n2 & 2) == 2 ? kotlin.reflect.jvm.internal.impl.f.f.d(1, this.g) + 0 : 0;
            n2 = n4;
            if ((this.e & 4) == 4) {
                n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.d(2, this.h);
            }
            n4 = n2;
            if ((this.e & 8) == 8) {
                n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(3, this.i);
            }
            n2 = n4;
            for (n4 = 0; n4 < this.k.size(); ++n4) {
                n2 += kotlin.reflect.jvm.internal.impl.f.f.d(4, this.k.get(n4));
            }
            n4 = n2;
            if ((this.e & 32) == 32) {
                n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(5, this.l);
            }
            n2 = n4;
            if ((this.e & 128) == 128) {
                n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.d(6, this.n);
            }
            n4 = n2;
            if ((this.e & 256) == 256) {
                n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(7, this.o);
            }
            n2 = n4;
            if ((this.e & 512) == 512) {
                n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.d(8, this.p);
            }
            n4 = n2;
            if ((this.e & 16) == 16) {
                n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(9, this.j);
            }
            n2 = n4;
            if ((this.e & 64) == 64) {
                n2 = n4 + kotlin.reflect.jvm.internal.impl.f.f.d(10, this.m);
            }
            n4 = n2;
            if ((this.e & 1) == 1) {
                n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.d(11, this.f);
            }
            int n5 = 0;
            n2 = n3;
            n3 = n5;
            while (n2 < this.q.size()) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.h(this.q.get(n2));
                ++n2;
            }
            this.s = n2 = n4 + n3 + this.E().size() * 2 + this.R() + this.d.a();
            return n2;
        }

        public boolean j() {
            return (this.e & 4) == 4;
        }

        public int k() {
            return this.h;
        }

        public boolean l() {
            return (this.e & 8) == 8;
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.H();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.G();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public ac p() {
            return this.i;
        }

        public boolean q() {
            return (this.e & 16) == 16;
        }

        public int r() {
            return this.j;
        }

        public List<ag> s() {
            return this.k;
        }

        public int t() {
            return this.k.size();
        }

        public boolean u() {
            return (this.e & 32) == 32;
        }

        public ac v() {
            return this.l;
        }

        public boolean w() {
            return (this.e & 64) == 64;
        }

        public int x() {
            return this.m;
        }

        public boolean y() {
            return (this.e & 128) == 128;
        }

        public ak z() {
            return this.n;
        }

        public static final class a
        extends i.b<w, a>
        implements x {
            private int a;
            private int b = 518;
            private int c = 2054;
            private int d;
            private ac e = ac.a();
            private int f;
            private List<ag> g = Collections.emptyList();
            private ac h = ac.a();
            private int i;
            private ak j = ak.a();
            private int k;
            private int l;
            private List<Integer> m = Collections.emptyList();

            private a() {
                this.t();
            }

            private void t() {
            }

            private static a v() {
                return new a();
            }

            private void w() {
                if ((this.a & 32) != 32) {
                    this.g = new ArrayList<ag>(this.g);
                    this.a |= 32;
                }
            }

            private void z() {
                if ((this.a & 2048) != 2048) {
                    this.m = new ArrayList<Integer>(this.m);
                    this.a |= 2048;
                }
            }

            public a a() {
                return a.v().a(this.d());
            }

            @Override
            public a a(int n2) {
                this.a |= 1;
                this.b = n2;
                return this;
            }

            @Override
            public a a(ac ac2) {
                ac ac3 = ac2;
                if ((this.a & 8) == 8) {
                    ac3 = ac2;
                    if (this.e != ac.a()) {
                        ac3 = ac.a(this.e).a(ac2).d();
                    }
                }
                this.e = ac3;
                this.a |= 8;
                return this;
            }

            @Override
            public a a(ak ak2) {
                ak ak3 = ak2;
                if ((this.a & 256) == 256) {
                    ak3 = ak2;
                    if (this.j != ak.a()) {
                        ak3 = ak.a(this.j).a(ak2).d();
                    }
                }
                this.j = ak3;
                this.a |= 256;
                return this;
            }

            @Override
            public a a(w w2) {
                if (w2 == w.a()) {
                    return this;
                }
                if (w2.d()) {
                    this.a(w2.e());
                }
                if (w2.f()) {
                    this.b(w2.g());
                }
                if (w2.j()) {
                    this.c(w2.k());
                }
                if (w2.l()) {
                    this.a(w2.p());
                }
                if (w2.q()) {
                    this.d(w2.r());
                }
                if (!w2.k.isEmpty()) {
                    if (this.g.isEmpty()) {
                        this.g = w2.k;
                        this.a &= -33;
                    } else {
                        this.w();
                        this.g.addAll(w2.k);
                    }
                }
                if (w2.u()) {
                    this.b(w2.v());
                }
                if (w2.w()) {
                    this.f(w2.x());
                }
                if (w2.y()) {
                    this.a(w2.z());
                }
                if (w2.A()) {
                    this.g(w2.B());
                }
                if (w2.C()) {
                    this.h(w2.D());
                }
                if (!w2.q.isEmpty()) {
                    if (this.m.isEmpty()) {
                        this.m = w2.q;
                        this.a &= -2049;
                    } else {
                        this.z();
                        this.m.addAll(w2.q);
                    }
                }
                this.a(w2);
                this.a(this.x().a(w2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = w.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((w)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (w)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((w)object);
                throw var2_6;
            }

            public a b(int n2) {
                this.a |= 2;
                this.c = n2;
                return this;
            }

            public a b(ac ac2) {
                ac ac3 = ac2;
                if ((this.a & 64) == 64) {
                    ac3 = ac2;
                    if (this.h != ac.a()) {
                        ac3 = ac.a(this.h).a(ac2).d();
                    }
                }
                this.h = ac3;
                this.a |= 64;
                return this;
            }

            public w b() {
                return w.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public a c(int n2) {
                this.a |= 4;
                this.d = n2;
                return this;
            }

            public w c() {
                w w2 = this.d();
                if (w2.h()) {
                    return w2;
                }
                throw a.a(w2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public a d(int n2) {
                this.a |= 16;
                this.f = n2;
                return this;
            }

            public w d() {
                w w2 = new w(this);
                int n2 = this.a;
                int n3 = 1;
                if ((n2 & 1) != 1) {
                    n3 = 0;
                }
                w2.f = this.b;
                int n4 = n3;
                if ((n2 & 2) == 2) {
                    n4 = n3 | 2;
                }
                w2.g = this.c;
                n3 = n4;
                if ((n2 & 4) == 4) {
                    n3 = n4 | 4;
                }
                w2.h = this.d;
                n4 = n3;
                if ((n2 & 8) == 8) {
                    n4 = n3 | 8;
                }
                w2.i = this.e;
                n3 = n4;
                if ((n2 & 16) == 16) {
                    n3 = n4 | 16;
                }
                w2.j = this.f;
                if ((this.a & 32) == 32) {
                    this.g = Collections.unmodifiableList(this.g);
                    this.a &= -33;
                }
                w2.k = this.g;
                n4 = n3;
                if ((n2 & 64) == 64) {
                    n4 = n3 | 32;
                }
                w2.l = this.h;
                n3 = n4;
                if ((n2 & 128) == 128) {
                    n3 = n4 | 64;
                }
                w2.m = this.i;
                n4 = n3;
                if ((n2 & 256) == 256) {
                    n4 = n3 | 128;
                }
                w2.n = this.j;
                n3 = n4;
                if ((n2 & 512) == 512) {
                    n3 = n4 | 256;
                }
                w2.o = this.k;
                n4 = n3;
                if ((n2 & 1024) == 1024) {
                    n4 = n3 | 512;
                }
                w2.p = this.l;
                if ((this.a & 2048) == 2048) {
                    this.m = Collections.unmodifiableList(this.m);
                    this.a &= -2049;
                }
                w2.q = this.m;
                w2.e = n4;
                return w2;
            }

            public ag e(int n2) {
                return this.g.get(n2);
            }

            public boolean e() {
                return (this.a & 4) == 4;
            }

            public a f(int n2) {
                this.a |= 128;
                this.i = n2;
                return this;
            }

            public boolean f() {
                return (this.a & 8) == 8;
            }

            public ac g() {
                return this.e;
            }

            public a g(int n2) {
                this.a |= 512;
                this.k = n2;
                return this;
            }

            public a h(int n2) {
                this.a |= 1024;
                this.l = n2;
                return this;
            }

            @Override
            public final boolean h() {
                if (!this.e()) {
                    return false;
                }
                if (this.f() && !this.g().h()) {
                    return false;
                }
                for (int i2 = 0; i2 < this.m(); ++i2) {
                    if (this.e(i2).h()) continue;
                    return false;
                }
                if (this.n() && !this.p().h()) {
                    return false;
                }
                if (this.q() && !this.r().h()) {
                    return false;
                }
                return this.y();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            public int m() {
                return this.g.size();
            }

            public boolean n() {
                return (this.a & 64) == 64;
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }

            public ac p() {
                return this.h;
            }

            public boolean q() {
                return (this.a & 256) == 256;
            }

            public ak r() {
                return this.j;
            }

            @Override
            public /* synthetic */ i.b u() {
                return this.a();
            }
        }

    }

    public static interface x
    extends i.d {
    }

    public static final class y
    extends kotlin.reflect.jvm.internal.impl.f.i
    implements z {
        public static kotlin.reflect.jvm.internal.impl.f.s<y> a = new kotlin.reflect.jvm.internal.impl.f.b<y>(){

            public y a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new y(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final y c = new y(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private List<b> e;
        private byte f = (byte)-1;
        private int g = -1;

        static {
            c.j();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private y(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.j();
            var9_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var10_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var9_10, 1);
            var8_12 = false;
            var3_13 = 0;
            while (!var8_12) {
                block20 : {
                    var5_15 = var3_13;
                    var6_16 = var3_13;
                    var7_17 = var3_13;
                    var4_14 = var1_1.a();
                    if (var4_14 != 0) {
                        if (var4_14 != 10) {
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var3_13;
                            if (this.a(var1_1, var10_11, var2_8, var4_14)) continue;
                        } else {
                            var4_14 = var3_13;
                            if ((var3_13 & 1) != 1) {
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var7_17 = var3_13;
                                this.e = new ArrayList<b>();
                                var4_14 = var3_13 | 1;
                            }
                            var5_15 = var4_14;
                            var6_16 = var4_14;
                            var7_17 = var4_14;
                            this.e.add(var1_1.a(b.a, var2_8));
                            var3_13 = var4_14;
                            continue;
                        }
                    }
                    var8_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block20;
                    }
                    catch (IOException var1_3) {
                        var5_15 = var6_16;
                        throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                        var5_15 = var7_17;
                        throw var1_4.a(this);
                    }
                }
                if (var5_15 & true) {
                    this.e = Collections.unmodifiableList(this.e);
                }
                try {
                    var10_11.a();
lbl51: // 2 sources:
                    do {
                        this.d = var9_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var9_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            if (var3_13 & true) {
                this.e = Collections.unmodifiableList(this.e);
            }
            try {
                var10_11.a();
lbl63: // 2 sources:
                do {
                    this.d = var9_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var9_10.a();
                throw var1_6;
            }
            this.O();
            return;
            catch (IOException var2_9) {
                ** continue;
            }
            catch (IOException var1_7) {
                ** continue;
            }
        }

        private y(i.a a2) {
            super(a2);
            this.d = a2.x();
        }

        private y(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(y y2) {
            return y.e().a(y2);
        }

        public static y a() {
            return c;
        }

        public static a e() {
            return a.m();
        }

        private void j() {
            this.e = Collections.emptyList();
        }

        public b a(int n2) {
            return this.e.get(n2);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            this.i();
            for (int i2 = 0; i2 < this.e.size(); ++i2) {
                f2.b(1, this.e.get(i2));
            }
            f2.c(this.d);
        }

        public y b() {
            return c;
        }

        public kotlin.reflect.jvm.internal.impl.f.s<y> c() {
            return a;
        }

        public int d() {
            return this.e.size();
        }

        public a f() {
            return y.e();
        }

        public a g() {
            return y.a(this);
        }

        @Override
        public final boolean h() {
            int n2 = this.f;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            for (n2 = 0; n2 < this.d(); ++n2) {
                if (this.a(n2).h()) continue;
                this.f = 0;
                return false;
            }
            this.f = 1;
            return true;
        }

        @Override
        public int i() {
            int n2 = this.g;
            if (n2 != -1) {
                return n2;
            }
            int n3 = 0;
            for (n2 = 0; n2 < this.e.size(); ++n2) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(1, this.e.get(n2));
            }
            this.g = n2 = n3 + this.d.a();
            return n2;
        }

        @Override
        public /* synthetic */ q.a m() {
            return this.g();
        }

        @Override
        public /* synthetic */ q.a n() {
            return this.f();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
            return this.b();
        }

        public static final class a
        extends i.a<y, a>
        implements z {
            private int a;
            private List<b> b = Collections.emptyList();

            private a() {
                this.g();
            }

            private void g() {
            }

            private static a m() {
                return new a();
            }

            private void n() {
                if ((this.a & 1) != 1) {
                    this.b = new ArrayList<b>(this.b);
                    this.a |= 1;
                }
            }

            public a a() {
                return a.m().a(this.d());
            }

            @Override
            public a a(y y2) {
                if (y2 == y.a()) {
                    return this;
                }
                if (!y2.e.isEmpty()) {
                    if (this.b.isEmpty()) {
                        this.b = y2.e;
                        this.a &= -2;
                    } else {
                        this.n();
                        this.b.addAll(y2.e);
                    }
                }
                this.a(this.x().a(y2.d));
                return this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                void var2_6;
                Object var3_7 = null;
                object = y.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((y)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                    {
                        object = (y)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((y)object);
                throw var2_6;
            }

            @Override
            public b a(int n2) {
                return this.b.get(n2);
            }

            public y b() {
                return y.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public y c() {
                y y2 = this.d();
                if (y2.h()) {
                    return y2;
                }
                throw a.a(y2);
            }

            @Override
            public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public y d() {
                y y2 = new y(this);
                int n2 = this.a;
                if ((this.a & 1) == 1) {
                    this.b = Collections.unmodifiableList(this.b);
                    this.a &= -2;
                }
                y2.e = this.b;
                return y2;
            }

            public int e() {
                return this.b.size();
            }

            @Override
            public final boolean h() {
                for (int i2 = 0; i2 < this.e(); ++i2) {
                    if (this.a(i2).h()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                return this.b();
            }

            @Override
            public /* synthetic */ i.a j() {
                return this.a();
            }

            @Override
            public /* synthetic */ a.a k() {
                return this.a();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                return this.c();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }
        }

        public static final class kotlin.reflect.jvm.internal.impl.d.a$y$b
        extends kotlin.reflect.jvm.internal.impl.f.i
        implements c {
            public static kotlin.reflect.jvm.internal.impl.f.s<kotlin.reflect.jvm.internal.impl.d.a$y$b> a = new kotlin.reflect.jvm.internal.impl.f.b<kotlin.reflect.jvm.internal.impl.d.a$y$b>(){

                public kotlin.reflect.jvm.internal.impl.d.a$y$b a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    return new kotlin.reflect.jvm.internal.impl.d.a$y$b(e2, g2);
                }

                @Override
                public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    return this.a(e2, g2);
                }
            };
            private static final kotlin.reflect.jvm.internal.impl.d.a$y$b c = new kotlin.reflect.jvm.internal.impl.d.a$y$b(true);
            private final kotlin.reflect.jvm.internal.impl.f.d d;
            private int e;
            private int f;
            private int g;
            private b h;
            private byte i = (byte)-1;
            private int j = -1;

            static {
                c.r();
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive exception aggregation
             */
            private kotlin.reflect.jvm.internal.impl.d.a$y$b(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
                super();
                this.r();
                var6_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
                var7_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var6_10, 1);
                var3_12 = false;
                while (!var3_12) {
                    block17 : {
                        block18 : {
                            var4_13 = var1_1.a();
                            if (var4_13 == 0) break block18;
                            if (var4_13 == 8) ** GOTO lbl30
                            if (var4_13 == 16) ** GOTO lbl27
                            if (var4_13 != 24) {
                                if (this.a(var1_1, var7_11, var2_8, var4_13)) continue;
                            } else {
                                var5_14 = var1_1.n();
                                var8_15 = b.a(var5_14);
                                if (var8_15 == null) {
                                    var7_11.p(var4_13);
                                    var7_11.p(var5_14);
                                    continue;
                                }
                                this.e |= 4;
                                this.h = var8_15;
                                continue;
lbl27: // 1 sources:
                                this.e |= 2;
                                this.g = var1_1.f();
                                continue;
lbl30: // 1 sources:
                                this.e |= 1;
                                this.f = var1_1.f();
                                continue;
                            }
                        }
                        var3_12 = true;
                        continue;
                        catch (Throwable var1_2) {
                            break block17;
                        }
                        catch (IOException var1_3) {
                            throw new kotlin.reflect.jvm.internal.impl.f.k(var1_3.getMessage()).a(this);
                        }
                        catch (kotlin.reflect.jvm.internal.impl.f.k var1_4) {
                            throw var1_4.a(this);
                        }
                    }
                    try {
                        var7_11.a();
lbl45: // 2 sources:
                        do {
                            this.d = var6_10.a();
                            break;
                        } while (true);
                    }
                    catch (Throwable var1_5) {
                        this.d = var6_10.a();
                        throw var1_5;
                    }
                    this.O();
                    throw var1_2;
                }
                try {
                    var7_11.a();
lbl55: // 2 sources:
                    do {
                        this.d = var6_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_6) {
                    this.d = var6_10.a();
                    throw var1_6;
                }
                this.O();
                return;
                catch (IOException var2_9) {
                    ** continue;
                }
                catch (IOException var1_7) {
                    ** continue;
                }
            }

            private kotlin.reflect.jvm.internal.impl.d.a$y$b(i.a a2) {
                super(a2);
                this.d = a2.x();
            }

            private kotlin.reflect.jvm.internal.impl.d.a$y$b(boolean bl2) {
                this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
            }

            public static a a(kotlin.reflect.jvm.internal.impl.d.a$y$b b2) {
                return kotlin.reflect.jvm.internal.impl.d.a$y$b.l().a(b2);
            }

            public static kotlin.reflect.jvm.internal.impl.d.a$y$b a() {
                return c;
            }

            public static a l() {
                return a.m();
            }

            private void r() {
                this.f = -1;
                this.g = 0;
                this.h = b.b;
            }

            @Override
            public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
                this.i();
                if ((this.e & 1) == 1) {
                    f2.a(1, this.f);
                }
                if ((this.e & 2) == 2) {
                    f2.a(2, this.g);
                }
                if ((this.e & 4) == 4) {
                    f2.c(3, this.h.a());
                }
                f2.c(this.d);
            }

            public kotlin.reflect.jvm.internal.impl.d.a$y$b b() {
                return c;
            }

            public kotlin.reflect.jvm.internal.impl.f.s<kotlin.reflect.jvm.internal.impl.d.a$y$b> c() {
                return a;
            }

            public boolean d() {
                return (this.e & 1) == 1;
            }

            public int e() {
                return this.f;
            }

            public boolean f() {
                return (this.e & 2) == 2;
            }

            public int g() {
                return this.g;
            }

            @Override
            public final boolean h() {
                byte by2 = this.i;
                if (by2 == 1) {
                    return true;
                }
                if (by2 == 0) {
                    return false;
                }
                if (!this.f()) {
                    this.i = 0;
                    return false;
                }
                this.i = 1;
                return true;
            }

            @Override
            public int i() {
                int n2 = this.j;
                if (n2 != -1) {
                    return n2;
                }
                int n3 = 0;
                if ((this.e & 1) == 1) {
                    n3 = 0 + kotlin.reflect.jvm.internal.impl.f.f.d(1, this.f);
                }
                n2 = n3;
                if ((this.e & 2) == 2) {
                    n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(2, this.g);
                }
                n3 = n2;
                if ((this.e & 4) == 4) {
                    n3 = n2 + kotlin.reflect.jvm.internal.impl.f.f.e(3, this.h.a());
                }
                this.j = n2 = n3 + this.d.a();
                return n2;
            }

            public boolean j() {
                return (this.e & 4) == 4;
            }

            public b k() {
                return this.h;
            }

            @Override
            public /* synthetic */ q.a m() {
                return this.q();
            }

            @Override
            public /* synthetic */ q.a n() {
                return this.p();
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                return this.b();
            }

            public a p() {
                return kotlin.reflect.jvm.internal.impl.d.a$y$b.l();
            }

            public a q() {
                return kotlin.reflect.jvm.internal.impl.d.a$y$b.a(this);
            }

            public static final class a
            extends i.a<kotlin.reflect.jvm.internal.impl.d.a$y$b, a>
            implements c {
                private int a;
                private int b = -1;
                private int c;
                private b d = b.b;

                private a() {
                    this.g();
                }

                private void g() {
                }

                private static a m() {
                    return new a();
                }

                public a a() {
                    return a.m().a(this.d());
                }

                @Override
                public a a(int n2) {
                    this.a |= 1;
                    this.b = n2;
                    return this;
                }

                @Override
                public a a(b b2) {
                    if (b2 != null) {
                        this.a |= 4;
                        this.d = b2;
                        return this;
                    }
                    throw new NullPointerException();
                }

                @Override
                public a a(kotlin.reflect.jvm.internal.impl.d.a$y$b b2) {
                    if (b2 == kotlin.reflect.jvm.internal.impl.d.a$y$b.a()) {
                        return this;
                    }
                    if (b2.d()) {
                        this.a(b2.e());
                    }
                    if (b2.f()) {
                        this.b(b2.g());
                    }
                    if (b2.j()) {
                        this.a(b2.k());
                    }
                    this.a(this.x().a(b2.d));
                    return this;
                }

                /*
                 * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
                 * Loose catch block
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Lifted jumps to return sites
                 */
                public a a(kotlin.reflect.jvm.internal.impl.f.e object, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    void var2_6;
                    Object var3_7 = null;
                    object = kotlin.reflect.jvm.internal.impl.d.a$y$b.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                    if (object == null) return this;
                    this.a((kotlin.reflect.jvm.internal.impl.d.a$y$b)object);
                    return this;
                    {
                        catch (Throwable throwable) {
                            object = var3_7;
                        }
                        catch (kotlin.reflect.jvm.internal.impl.f.k k2) {}
                        {
                            object = (kotlin.reflect.jvm.internal.impl.d.a$y$b)k2.a();
                        }
                        try {
                            throw k2;
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    if (object == null) throw var2_6;
                    this.a((kotlin.reflect.jvm.internal.impl.d.a$y$b)object);
                    throw var2_6;
                }

                public a b(int n2) {
                    this.a |= 2;
                    this.c = n2;
                    return this;
                }

                public kotlin.reflect.jvm.internal.impl.d.a$y$b b() {
                    return kotlin.reflect.jvm.internal.impl.d.a$y$b.a();
                }

                @Override
                public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    return this.a(e2, g2);
                }

                public kotlin.reflect.jvm.internal.impl.d.a$y$b c() {
                    kotlin.reflect.jvm.internal.impl.d.a$y$b b2 = this.d();
                    if (b2.h()) {
                        return b2;
                    }
                    throw a.a(b2);
                }

                @Override
                public /* synthetic */ q.a c(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    return this.a(e2, g2);
                }

                @Override
                public /* synthetic */ Object clone() {
                    return this.a();
                }

                public kotlin.reflect.jvm.internal.impl.d.a$y$b d() {
                    kotlin.reflect.jvm.internal.impl.d.a$y$b b2 = new kotlin.reflect.jvm.internal.impl.d.a$y$b(this);
                    int n2 = this.a;
                    int n3 = 1;
                    if ((n2 & 1) != 1) {
                        n3 = 0;
                    }
                    b2.f = this.b;
                    int n4 = n3;
                    if ((n2 & 2) == 2) {
                        n4 = n3 | 2;
                    }
                    b2.g = this.c;
                    n3 = n4;
                    if ((n2 & 4) == 4) {
                        n3 = n4 | 4;
                    }
                    b2.h = this.d;
                    b2.e = n3;
                    return b2;
                }

                public boolean e() {
                    return (this.a & 2) == 2;
                }

                @Override
                public final boolean h() {
                    return this.e();
                }

                @Override
                public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.i i() {
                    return this.b();
                }

                @Override
                public /* synthetic */ i.a j() {
                    return this.a();
                }

                @Override
                public /* synthetic */ a.a k() {
                    return this.a();
                }

                @Override
                public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q l() {
                    return this.c();
                }

                @Override
                public /* synthetic */ kotlin.reflect.jvm.internal.impl.f.q o() {
                    return this.b();
                }
            }

            public static enum b implements j.a
            {
                a(0, 0),
                b(1, 1),
                c(2, 2);
                
                private static j.b<b> d;
                private final int e;

                static {
                    d = new j.b<b>(){

                        public b a(int n2) {
                            return b.a(n2);
                        }

                        @Override
                        public /* synthetic */ j.a b(int n2) {
                            return this.a(n2);
                        }
                    };
                }

                private b(int n3, int n4) {
                    this.e = n4;
                }

                public static b a(int n2) {
                    switch (n2) {
                        default: {
                            return null;
                        }
                        case 2: {
                            return c;
                        }
                        case 1: {
                            return b;
                        }
                        case 0: 
                    }
                    return a;
                }

                @Override
                public final int a() {
                    return this.e;
                }

            }

        }

        public static interface c
        extends kotlin.reflect.jvm.internal.impl.f.r {
        }

    }

    public static interface z
    extends kotlin.reflect.jvm.internal.impl.f.r {
    }

}

