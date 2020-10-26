/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.c;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.f.a;
import kotlin.reflect.jvm.internal.impl.f.d;
import kotlin.reflect.jvm.internal.impl.f.e;
import kotlin.reflect.jvm.internal.impl.f.f;
import kotlin.reflect.jvm.internal.impl.f.g;
import kotlin.reflect.jvm.internal.impl.f.i;
import kotlin.reflect.jvm.internal.impl.f.k;
import kotlin.reflect.jvm.internal.impl.f.n;
import kotlin.reflect.jvm.internal.impl.f.o;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.f.r;
import kotlin.reflect.jvm.internal.impl.f.s;
import kotlin.reflect.jvm.internal.impl.f.t;

public final class a {

    public static final class kotlin.reflect.jvm.internal.impl.d.c.a$a
    extends i
    implements b {
        public static s<kotlin.reflect.jvm.internal.impl.d.c.a$a> a = new kotlin.reflect.jvm.internal.impl.f.b<kotlin.reflect.jvm.internal.impl.d.c.a$a>(){

            public kotlin.reflect.jvm.internal.impl.d.c.a$a a(e e2, g g2) {
                return new kotlin.reflect.jvm.internal.impl.d.c.a$a(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(e e2, g g2) {
                return this.a(e2, g2);
            }
        };
        private static final kotlin.reflect.jvm.internal.impl.d.c.a$a c = new kotlin.reflect.jvm.internal.impl.d.c.a$a(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private List<c> f;
        private List<c> g;
        private o h;
        private a.aa i;
        private a.y j;
        private List<a.a> k;
        private byte l = (byte)-1;
        private int m = -1;

        static {
            c.w();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private kotlin.reflect.jvm.internal.impl.d.c.a$a(e var1_1, g var2_8) {
            super();
            this.w();
            var11_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var12_11 = f.a(var11_10, 1);
            var8_12 = false;
            var3_13 = 0;
            block11 : while (!var8_12) {
                block31 : {
                    block32 : {
                        block33 : {
                            block34 : {
                                block35 : {
                                    block36 : {
                                        block37 : {
                                            block38 : {
                                                var4_14 = var3_13;
                                                var5_15 = var3_13;
                                                var6_16 = var3_13;
                                                var7_17 = var1_1.a();
                                                if (var7_17 == 0) break block32;
                                                if (var7_17 == 10) break block33;
                                                if (var7_17 == 18) break block34;
                                                if (var7_17 == 26) break block35;
                                                var10_19 = null;
                                                var9_18 = null;
                                                if (var7_17 == 34) break block36;
                                                if (var7_17 == 42) break block37;
                                                if (var7_17 == 50) break block38;
                                                var4_14 = var3_13;
                                                var5_15 = var3_13;
                                                var6_16 = var3_13;
                                                if (this.a(var1_1, var12_11, var2_8, var7_17)) continue;
                                                break block32;
                                            }
                                            var7_17 = var3_13;
                                            if ((var3_13 & 32) != 32) {
                                                var4_14 = var3_13;
                                                var5_15 = var3_13;
                                                var6_16 = var3_13;
                                                this.k = new ArrayList<a.a>();
                                                var7_17 = var3_13 | 32;
                                            }
                                            var4_14 = var7_17;
                                            var5_15 = var7_17;
                                            var6_16 = var7_17;
                                            var9_18 = this.k;
                                            var4_14 = var7_17;
                                            var5_15 = var7_17;
                                            var6_16 = var7_17;
                                            var10_19 = var1_1.a(a.a.a, var2_8);
                                            var3_13 = var7_17;
lbl47: // 3 sources:
                                            do {
                                                var4_14 = var3_13;
                                                var5_15 = var3_13;
                                                var6_16 = var3_13;
                                                var9_18.add(var10_19);
                                                continue block11;
                                                break;
                                            } while (true);
                                        }
                                        var4_14 = var3_13;
                                        var5_15 = var3_13;
                                        var6_16 = var3_13;
                                        if ((this.e & 2) == 2) {
                                            var4_14 = var3_13;
                                            var5_15 = var3_13;
                                            var6_16 = var3_13;
                                            var9_18 = this.j.g();
                                        }
                                        var4_14 = var3_13;
                                        var5_15 = var3_13;
                                        var6_16 = var3_13;
                                        this.j = var1_1.a(a.y.a, var2_8);
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
                                        var9_18 = this.i.g();
                                    }
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    this.i = var1_1.a(a.aa.a, var2_8);
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
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var9_18 = var1_1.l();
                                var7_17 = var3_13;
                                if ((var3_13 & 4) != 4) {
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    this.h = new n();
                                    var7_17 = var3_13 | 4;
                                }
                                var4_14 = var7_17;
                                var5_15 = var7_17;
                                var6_16 = var7_17;
                                this.h.a((kotlin.reflect.jvm.internal.impl.f.d)var9_18);
                                var3_13 = var7_17;
                                continue;
                            }
                            var7_17 = var3_13;
                            if ((var3_13 & 2) != 2) {
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                this.g = new ArrayList<c>();
                                var7_17 = var3_13 | 2;
                            }
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var9_18 = this.g;
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var10_19 = var1_1.a(c.a, var2_8);
                            var3_13 = var7_17;
                            ** GOTO lbl47
                        }
                        var7_17 = var3_13;
                        if ((var3_13 & 1) != 1) {
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            this.f = new ArrayList<c>();
                            var7_17 = var3_13 | 1;
                        }
                        var4_14 = var7_17;
                        var5_15 = var7_17;
                        var6_16 = var7_17;
                        var9_18 = this.f;
                        var4_14 = var7_17;
                        var5_15 = var7_17;
                        var6_16 = var7_17;
                        var10_19 = var1_1.a(c.a, var2_8);
                        var3_13 = var7_17;
                        ** continue;
                    }
                    var8_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block31;
                    }
                    catch (IOException var1_3) {
                        var4_14 = var5_15;
                        throw new k(var1_3.getMessage()).a(this);
                    }
                    catch (k var1_4) {
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
                    this.h = this.h.b();
                }
                if ((var4_14 & 32) == 32) {
                    this.k = Collections.unmodifiableList(this.k);
                }
                try {
                    var12_11.a();
lbl184: // 2 sources:
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
                this.h = this.h.b();
            }
            if ((var3_13 & 32) == 32) {
                this.k = Collections.unmodifiableList(this.k);
            }
            try {
                var12_11.a();
lbl202: // 2 sources:
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

        private kotlin.reflect.jvm.internal.impl.d.c.a$a(i.a a2) {
            super(a2);
            this.d = a2.x();
        }

        private kotlin.reflect.jvm.internal.impl.d.c.a$a(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(kotlin.reflect.jvm.internal.impl.d.c.a$a a2) {
            return kotlin.reflect.jvm.internal.impl.d.c.a$a.t().a(a2);
        }

        public static kotlin.reflect.jvm.internal.impl.d.c.a$a a() {
            return c;
        }

        public static kotlin.reflect.jvm.internal.impl.d.c.a$a a(InputStream inputStream) {
            return a.b(inputStream);
        }

        public static a t() {
            return a.r();
        }

        private void w() {
            this.f = Collections.emptyList();
            this.g = Collections.emptyList();
            this.h = n.a;
            this.i = a.aa.a();
            this.j = a.y.a();
            this.k = Collections.emptyList();
        }

        public c a(int n2) {
            return this.f.get(n2);
        }

        @Override
        public void a(f f2) {
            int n2;
            this.i();
            int n3 = 0;
            for (n2 = 0; n2 < this.f.size(); ++n2) {
                f2.b(1, this.f.get(n2));
            }
            for (n2 = 0; n2 < this.g.size(); ++n2) {
                f2.b(2, this.g.get(n2));
            }
            for (n2 = 0; n2 < this.h.size(); ++n2) {
                f2.a(3, this.h.c(n2));
            }
            if ((this.e & 1) == 1) {
                f2.b(4, this.i);
            }
            n2 = n3;
            if ((this.e & 2) == 2) {
                f2.b(5, this.j);
                n2 = n3;
            }
            while (n2 < this.k.size()) {
                f2.b(6, this.k.get(n2));
                ++n2;
            }
            f2.c(this.d);
        }

        public kotlin.reflect.jvm.internal.impl.d.c.a$a b() {
            return c;
        }

        public c b(int n2) {
            return this.g.get(n2);
        }

        public a.a c(int n2) {
            return this.k.get(n2);
        }

        public s<kotlin.reflect.jvm.internal.impl.d.c.a$a> c() {
            return a;
        }

        public List<c> d() {
            return this.f;
        }

        public int e() {
            return this.f.size();
        }

        public List<c> f() {
            return this.g;
        }

        public int g() {
            return this.g.size();
        }

        @Override
        public final boolean h() {
            int n2 = this.l;
            if (n2 == 1) {
                return true;
            }
            if (n2 == 0) {
                return false;
            }
            for (n2 = 0; n2 < this.e(); ++n2) {
                if (this.a(n2).h()) continue;
                this.l = 0;
                return false;
            }
            for (n2 = 0; n2 < this.g(); ++n2) {
                if (this.b(n2).h()) continue;
                this.l = 0;
                return false;
            }
            if (this.p() && !this.q().h()) {
                this.l = 0;
                return false;
            }
            for (n2 = 0; n2 < this.s(); ++n2) {
                if (this.c(n2).h()) continue;
                this.l = 0;
                return false;
            }
            this.l = 1;
            return true;
        }

        @Override
        public int i() {
            int n2;
            int n3 = this.m;
            if (n3 != -1) {
                return n3;
            }
            int n4 = 0;
            n3 = 0;
            for (n2 = 0; n2 < this.f.size(); ++n2) {
                n3 += f.d(1, this.f.get(n2));
            }
            for (n2 = 0; n2 < this.g.size(); ++n2) {
                n3 += f.d(2, this.g.get(n2));
            }
            int n5 = 0;
            for (n2 = 0; n2 < this.h.size(); ++n2) {
                n5 += f.b(this.h.c(n2));
            }
            n3 = n2 = n3 + n5 + this.j().size() * 1;
            if ((this.e & 1) == 1) {
                n3 = n2 + f.d(4, this.i);
            }
            n5 = n4;
            n2 = n3;
            if ((this.e & 2) == 2) {
                n2 = n3 + f.d(5, this.j);
                n5 = n4;
            }
            while (n5 < this.k.size()) {
                n2 += f.d(6, this.k.get(n5));
                ++n5;
            }
            this.m = n3 = n2 + this.d.a();
            return n3;
        }

        public t j() {
            return this.h;
        }

        public boolean k() {
            return (this.e & 1) == 1;
        }

        public a.aa l() {
            return this.i;
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
        public /* synthetic */ q o() {
            return this.b();
        }

        public boolean p() {
            return (this.e & 2) == 2;
        }

        public a.y q() {
            return this.j;
        }

        public List<a.a> r() {
            return this.k;
        }

        public int s() {
            return this.k.size();
        }

        public a u() {
            return kotlin.reflect.jvm.internal.impl.d.c.a$a.t();
        }

        public a v() {
            return kotlin.reflect.jvm.internal.impl.d.c.a$a.a(this);
        }

        public static final class a
        extends i.a<kotlin.reflect.jvm.internal.impl.d.c.a$a, a>
        implements b {
            private int a;
            private List<c> b = Collections.emptyList();
            private List<c> c = Collections.emptyList();
            private o d = n.a;
            private a.aa e = a.aa.a();
            private a.y f = a.y.a();
            private List<a.a> g = Collections.emptyList();

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
                    this.b = new ArrayList<c>(this.b);
                    this.a |= 1;
                }
            }

            private void t() {
                if ((this.a & 2) != 2) {
                    this.c = new ArrayList<c>(this.c);
                    this.a |= 2;
                }
            }

            private void u() {
                if ((this.a & 4) != 4) {
                    this.d = new n(this.d);
                    this.a |= 4;
                }
            }

            private void v() {
                if ((this.a & 32) != 32) {
                    this.g = new ArrayList<a.a>(this.g);
                    this.a |= 32;
                }
            }

            public a a() {
                return a.r().a(this.d());
            }

            @Override
            public a a(a.aa aa2) {
                a.aa aa3 = aa2;
                if ((this.a & 8) == 8) {
                    aa3 = aa2;
                    if (this.e != a.aa.a()) {
                        aa3 = a.aa.a(this.e).a(aa2).d();
                    }
                }
                this.e = aa3;
                this.a |= 8;
                return this;
            }

            @Override
            public a a(a.y y2) {
                a.y y3 = y2;
                if ((this.a & 16) == 16) {
                    y3 = y2;
                    if (this.f != a.y.a()) {
                        y3 = a.y.a(this.f).a(y2).d();
                    }
                }
                this.f = y3;
                this.a |= 16;
                return this;
            }

            @Override
            public a a(kotlin.reflect.jvm.internal.impl.d.c.a$a a2) {
                if (a2 == kotlin.reflect.jvm.internal.impl.d.c.a$a.a()) {
                    return this;
                }
                if (!a2.f.isEmpty()) {
                    if (this.b.isEmpty()) {
                        this.b = a2.f;
                        this.a &= -2;
                    } else {
                        this.s();
                        this.b.addAll(a2.f);
                    }
                }
                if (!a2.g.isEmpty()) {
                    if (this.c.isEmpty()) {
                        this.c = a2.g;
                        this.a &= -3;
                    } else {
                        this.t();
                        this.c.addAll(a2.g);
                    }
                }
                if (!a2.h.isEmpty()) {
                    if (this.d.isEmpty()) {
                        this.d = a2.h;
                        this.a &= -5;
                    } else {
                        this.u();
                        this.d.addAll(a2.h);
                    }
                }
                if (a2.k()) {
                    this.a(a2.l());
                }
                if (a2.p()) {
                    this.a(a2.q());
                }
                if (!a2.k.isEmpty()) {
                    if (this.g.isEmpty()) {
                        this.g = a2.k;
                        this.a &= -33;
                    } else {
                        this.v();
                        this.g.addAll(a2.k);
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
            public a a(e object, g g2) {
                void var2_6;
                Object var3_7 = null;
                object = kotlin.reflect.jvm.internal.impl.d.c.a$a.a.b((e)object, g2);
                if (object == null) return this;
                this.a((kotlin.reflect.jvm.internal.impl.d.c.a$a)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (k k2) {}
                    {
                        object = (kotlin.reflect.jvm.internal.impl.d.c.a$a)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((kotlin.reflect.jvm.internal.impl.d.c.a$a)object);
                throw var2_6;
            }

            @Override
            public c a(int n2) {
                return this.b.get(n2);
            }

            public kotlin.reflect.jvm.internal.impl.d.c.a$a b() {
                return kotlin.reflect.jvm.internal.impl.d.c.a$a.a();
            }

            public c b(int n2) {
                return this.c.get(n2);
            }

            @Override
            public /* synthetic */ a.a b(e e2, g g2) {
                return this.a(e2, g2);
            }

            public a.a c(int n2) {
                return this.g.get(n2);
            }

            public kotlin.reflect.jvm.internal.impl.d.c.a$a c() {
                kotlin.reflect.jvm.internal.impl.d.c.a$a a2 = this.d();
                if (a2.h()) {
                    return a2;
                }
                throw a.a(a2);
            }

            @Override
            public /* synthetic */ q.a c(e e2, g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public kotlin.reflect.jvm.internal.impl.d.c.a$a d() {
                kotlin.reflect.jvm.internal.impl.d.c.a$a a2 = new kotlin.reflect.jvm.internal.impl.d.c.a$a(this);
                int n2 = this.a;
                int n3 = this.a;
                int n4 = 1;
                if ((n3 & 1) == 1) {
                    this.b = Collections.unmodifiableList(this.b);
                    this.a &= -2;
                }
                a2.f = this.b;
                if ((this.a & 2) == 2) {
                    this.c = Collections.unmodifiableList(this.c);
                    this.a &= -3;
                }
                a2.g = this.c;
                if ((this.a & 4) == 4) {
                    this.d = this.d.b();
                    this.a &= -5;
                }
                a2.h = this.d;
                if ((n2 & 8) != 8) {
                    n4 = 0;
                }
                a2.i = this.e;
                n3 = n4;
                if ((n2 & 16) == 16) {
                    n3 = n4 | 2;
                }
                a2.j = this.f;
                if ((this.a & 32) == 32) {
                    this.g = Collections.unmodifiableList(this.g);
                    this.a &= -33;
                }
                a2.k = this.g;
                a2.e = n3;
                return a2;
            }

            public int e() {
                return this.b.size();
            }

            public int f() {
                return this.c.size();
            }

            public boolean g() {
                return (this.a & 16) == 16;
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
                if (this.g() && !this.m().h()) {
                    return false;
                }
                for (n2 = 0; n2 < this.n(); ++n2) {
                    if (this.c(n2).h()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public /* synthetic */ i i() {
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
            public /* synthetic */ q l() {
                return this.c();
            }

            public a.y m() {
                return this.f;
            }

            public int n() {
                return this.g.size();
            }

            @Override
            public /* synthetic */ q o() {
                return this.b();
            }
        }

    }

    public static interface b
    extends r {
    }

    public static final class c
    extends i
    implements d {
        public static s<c> a = new kotlin.reflect.jvm.internal.impl.f.b<c>(){

            public c a(e e2, g g2) {
                return new c(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(e e2, g g2) {
                return this.a(e2, g2);
            }
        };
        private static final c c = new c(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private Object f;
        private o g;
        private List<Integer> h;
        private int i = -1;
        private o j;
        private o k;
        private List<Integer> l;
        private int m = -1;
        private byte n = (byte)-1;
        private int o = -1;

        static {
            c.t();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private c(e var1_1, g var2_8) {
            super();
            this.t();
            var13_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var14_11 = f.a(var13_10, 1);
            var8_12 = false;
            var3_13 = 0;
            block11 : while (!var8_12) {
                block38 : {
                    block39 : {
                        block40 : {
                            block41 : {
                                block42 : {
                                    block43 : {
                                        block44 : {
                                            block45 : {
                                                block46 : {
                                                    block47 : {
                                                        var4_14 = var3_13;
                                                        var5_15 = var3_13;
                                                        var6_16 = var3_13;
                                                        var7_17 = var1_1.a();
                                                        if (var7_17 == 0) break block39;
                                                        if (var7_17 == 10) break block40;
                                                        if (var7_17 == 18) break block41;
                                                        if (var7_17 == 24) break block42;
                                                        if (var7_17 == 26) break block43;
                                                        if (var7_17 == 34) break block44;
                                                        if (var7_17 == 42) break block45;
                                                        if (var7_17 == 48) break block46;
                                                        if (var7_17 == 50) break block47;
                                                        var4_14 = var3_13;
                                                        var5_15 = var3_13;
                                                        var6_16 = var3_13;
                                                        if (this.a(var1_1, var14_11, var2_8, var7_17)) continue;
                                                        break block39;
                                                    }
                                                    var4_14 = var3_13;
                                                    var5_15 = var3_13;
                                                    var6_16 = var3_13;
                                                    var10_19 = var1_1.c(var1_1.s());
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
                                                            this.l = new ArrayList<Integer>();
                                                            var7_17 = var3_13 | 32;
                                                        }
                                                    }
                                                    do {
                                                        var3_13 = var7_17;
                                                        var9_18 = var10_19;
                                                        var4_14 = var7_17;
                                                        var5_15 = var7_17;
                                                        var6_16 = var7_17;
                                                        if (var1_1.x() <= 0) break;
                                                        var4_14 = var7_17;
                                                        var5_15 = var7_17;
                                                        var6_16 = var7_17;
                                                        this.l.add(var1_1.f());
                                                    } while (true);
                                                    do {
                                                        var4_14 = var3_13;
                                                        var5_15 = var3_13;
                                                        var6_16 = var3_13;
                                                        var1_1.d(var9_18);
                                                        continue block11;
                                                        break;
                                                    } while (true);
                                                }
                                                var7_17 = var3_13;
                                                if ((var3_13 & 32) != 32) {
                                                    var4_14 = var3_13;
                                                    var5_15 = var3_13;
                                                    var6_16 = var3_13;
                                                    this.l = new ArrayList<Integer>();
                                                    var7_17 = var3_13 | 32;
                                                }
                                                var4_14 = var7_17;
                                                var5_15 = var7_17;
                                                var6_16 = var7_17;
                                                var11_20 = this.l;
                                                var4_14 = var7_17;
                                                var5_15 = var7_17;
                                                var6_16 = var7_17;
                                                var12_21 = var1_1.f();
                                                var3_13 = var7_17;
lbl84: // 2 sources:
                                                do {
                                                    var4_14 = var3_13;
                                                    var5_15 = var3_13;
                                                    var6_16 = var3_13;
                                                    var11_20.add((Byte)var12_21);
                                                    continue block11;
                                                    break;
                                                } while (true);
                                            }
                                            var4_14 = var3_13;
                                            var5_15 = var3_13;
                                            var6_16 = var3_13;
                                            var11_20 = var1_1.l();
                                            var7_17 = var3_13;
                                            if ((var3_13 & 16) != 16) {
                                                var4_14 = var3_13;
                                                var5_15 = var3_13;
                                                var6_16 = var3_13;
                                                this.k = new n();
                                                var7_17 = var3_13 | 16;
                                            }
                                            var4_14 = var7_17;
                                            var5_15 = var7_17;
                                            var6_16 = var7_17;
                                            var12_21 = this.k;
                                            var3_13 = var7_17;
lbl107: // 3 sources:
                                            do {
                                                var4_14 = var3_13;
                                                var5_15 = var3_13;
                                                var6_16 = var3_13;
                                                var12_21.a((kotlin.reflect.jvm.internal.impl.f.d)var11_20);
                                                continue block11;
                                                break;
                                            } while (true);
                                        }
                                        var4_14 = var3_13;
                                        var5_15 = var3_13;
                                        var6_16 = var3_13;
                                        var11_20 = var1_1.l();
                                        var7_17 = var3_13;
                                        if ((var3_13 & 8) != 8) {
                                            var4_14 = var3_13;
                                            var5_15 = var3_13;
                                            var6_16 = var3_13;
                                            this.j = new n();
                                            var7_17 = var3_13 | 8;
                                        }
                                        var4_14 = var7_17;
                                        var5_15 = var7_17;
                                        var6_16 = var7_17;
                                        var12_21 = this.j;
                                        var3_13 = var7_17;
                                        ** GOTO lbl107
                                    }
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    var10_19 = var1_1.c(var1_1.s());
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
                                        var3_13 = var7_17;
                                        var9_18 = var10_19;
                                        var4_14 = var7_17;
                                        var5_15 = var7_17;
                                        var6_16 = var7_17;
                                        if (var1_1.x() <= 0) ** continue;
                                        var4_14 = var7_17;
                                        var5_15 = var7_17;
                                        var6_16 = var7_17;
                                        this.h.add(var1_1.f());
                                    } while (true);
                                }
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
                                var11_20 = this.h;
                                var4_14 = var7_17;
                                var5_15 = var7_17;
                                var6_16 = var7_17;
                                var12_21 = var1_1.f();
                                var3_13 = var7_17;
                                ** continue;
                            }
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var11_20 = var1_1.l();
                            var7_17 = var3_13;
                            if ((var3_13 & 2) != 2) {
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                this.g = new n();
                                var7_17 = var3_13 | 2;
                            }
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var12_21 = this.g;
                            var3_13 = var7_17;
                            ** continue;
                        }
                        var4_14 = var3_13;
                        var5_15 = var3_13;
                        var6_16 = var3_13;
                        var11_20 = var1_1.l();
                        var4_14 = var3_13;
                        var5_15 = var3_13;
                        var6_16 = var3_13;
                        this.e |= 1;
                        var4_14 = var3_13;
                        var5_15 = var3_13;
                        var6_16 = var3_13;
                        this.f = var11_20;
                        continue;
                    }
                    var8_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block38;
                    }
                    catch (IOException var1_3) {
                        var4_14 = var5_15;
                        throw new k(var1_3.getMessage()).a(this);
                    }
                    catch (k var1_4) {
                        var4_14 = var6_16;
                        throw var1_4.a(this);
                    }
                }
                if ((var4_14 & 2) == 2) {
                    this.g = this.g.b();
                }
                if ((var4_14 & 4) == 4) {
                    this.h = Collections.unmodifiableList(this.h);
                }
                if ((var4_14 & 8) == 8) {
                    this.j = this.j.b();
                }
                if ((var4_14 & 16) == 16) {
                    this.k = this.k.b();
                }
                if ((var4_14 & 32) == 32) {
                    this.l = Collections.unmodifiableList(this.l);
                }
                try {
                    var14_11.a();
lbl234: // 2 sources:
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
            if ((var3_13 & 2) == 2) {
                this.g = this.g.b();
            }
            if ((var3_13 & 4) == 4) {
                this.h = Collections.unmodifiableList(this.h);
            }
            if ((var3_13 & 8) == 8) {
                this.j = this.j.b();
            }
            if ((var3_13 & 16) == 16) {
                this.k = this.k.b();
            }
            if ((var3_13 & 32) == 32) {
                this.l = Collections.unmodifiableList(this.l);
            }
            try {
                var14_11.a();
lbl254: // 2 sources:
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

        private c(i.a a2) {
            super(a2);
            this.d = a2.x();
        }

        private c(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(c c2) {
            return c.q().a(c2);
        }

        public static c a() {
            return c;
        }

        public static a q() {
            return a.m();
        }

        private void t() {
            this.f = "";
            this.g = n.a;
            this.h = Collections.emptyList();
            this.j = n.a;
            this.k = n.a;
            this.l = Collections.emptyList();
        }

        @Override
        public void a(f f2) {
            int n2;
            this.i();
            if ((this.e & 1) == 1) {
                f2.a(1, this.f());
            }
            int n3 = 0;
            for (n2 = 0; n2 < this.g.size(); ++n2) {
                f2.a(2, this.g.c(n2));
            }
            if (this.j().size() > 0) {
                f2.p(26);
                f2.p(this.i);
            }
            for (n2 = 0; n2 < this.h.size(); ++n2) {
                f2.b(this.h.get(n2));
            }
            for (n2 = 0; n2 < this.j.size(); ++n2) {
                f2.a(4, this.j.c(n2));
            }
            for (n2 = 0; n2 < this.k.size(); ++n2) {
                f2.a(5, this.k.c(n2));
            }
            n2 = n3;
            if (this.p().size() > 0) {
                f2.p(50);
                f2.p(this.m);
                n2 = n3;
            }
            while (n2 < this.l.size()) {
                f2.b(this.l.get(n2));
                ++n2;
            }
            f2.c(this.d);
        }

        public c b() {
            return c;
        }

        public s<c> c() {
            return a;
        }

        public boolean d() {
            return (this.e & 1) == 1;
        }

        public String e() {
            Object object = this.f;
            if (object instanceof String) {
                return (String)object;
            }
            object = (kotlin.reflect.jvm.internal.impl.f.d)object;
            String string2 = ((kotlin.reflect.jvm.internal.impl.f.d)object).f();
            if (((kotlin.reflect.jvm.internal.impl.f.d)object).g()) {
                this.f = string2;
            }
            return string2;
        }

        public kotlin.reflect.jvm.internal.impl.f.d f() {
            Object object = this.f;
            if (object instanceof String) {
                this.f = object = kotlin.reflect.jvm.internal.impl.f.d.a((String)object);
                return object;
            }
            return (kotlin.reflect.jvm.internal.impl.f.d)object;
        }

        public t g() {
            return this.g;
        }

        @Override
        public final boolean h() {
            byte by2 = this.n;
            if (by2 == 1) {
                return true;
            }
            if (by2 == 0) {
                return false;
            }
            if (!this.d()) {
                this.n = 0;
                return false;
            }
            this.n = 1;
            return true;
        }

        @Override
        public int i() {
            int n2;
            int n3;
            int n4 = this.o;
            if (n4 != -1) {
                return n4;
            }
            n4 = this.e;
            int n5 = 0;
            n4 = (n4 & 1) == 1 ? f.b(1, this.f()) + 0 : 0;
            int n6 = 0;
            for (n3 = 0; n3 < this.g.size(); ++n3) {
                n6 += f.b(this.g.c(n3));
            }
            int n7 = this.g().size();
            n3 = 0;
            for (n2 = 0; n2 < this.h.size(); ++n2) {
                n3 += f.h(this.h.get(n2));
            }
            n4 = n6 = n4 + n6 + n7 * 1 + n3;
            if (!this.j().isEmpty()) {
                n4 = n6 + 1 + f.h(n3);
            }
            this.i = n3;
            n6 = 0;
            for (n3 = 0; n3 < this.j.size(); ++n3) {
                n6 += f.b(this.j.c(n3));
            }
            n7 = this.k().size();
            n3 = 0;
            for (n2 = 0; n2 < this.k.size(); ++n2) {
                n3 += f.b(this.k.c(n2));
            }
            int n8 = this.l().size();
            n2 = 0;
            while (n5 < this.l.size()) {
                n2 += f.h(this.l.get(n5));
                ++n5;
            }
            n4 = n6 = n4 + n6 + n7 * 1 + n3 + n8 * 1 + n2;
            if (!this.p().isEmpty()) {
                n4 = n6 + 1 + f.h(n2);
            }
            this.m = n2;
            this.o = n4 += this.d.a();
            return n4;
        }

        public List<Integer> j() {
            return this.h;
        }

        public t k() {
            return this.j;
        }

        public t l() {
            return this.k;
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
        public /* synthetic */ q o() {
            return this.b();
        }

        public List<Integer> p() {
            return this.l;
        }

        public a r() {
            return c.q();
        }

        public a s() {
            return c.a(this);
        }

        public static final class a
        extends i.a<c, a>
        implements d {
            private int a;
            private Object b = "";
            private o c = n.a;
            private List<Integer> d = Collections.emptyList();
            private o e = n.a;
            private o f = n.a;
            private List<Integer> g = Collections.emptyList();

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
                    this.c = new n(this.c);
                    this.a |= 2;
                }
            }

            private void p() {
                if ((this.a & 4) != 4) {
                    this.d = new ArrayList<Integer>(this.d);
                    this.a |= 4;
                }
            }

            private void q() {
                if ((this.a & 8) != 8) {
                    this.e = new n(this.e);
                    this.a |= 8;
                }
            }

            private void r() {
                if ((this.a & 16) != 16) {
                    this.f = new n(this.f);
                    this.a |= 16;
                }
            }

            private void s() {
                if ((this.a & 32) != 32) {
                    this.g = new ArrayList<Integer>(this.g);
                    this.a |= 32;
                }
            }

            public a a() {
                return a.m().a(this.d());
            }

            @Override
            public a a(c c2) {
                if (c2 == c.a()) {
                    return this;
                }
                if (c2.d()) {
                    this.a |= 1;
                    this.b = c2.f;
                }
                if (!c2.g.isEmpty()) {
                    if (this.c.isEmpty()) {
                        this.c = c2.g;
                        this.a &= -3;
                    } else {
                        this.n();
                        this.c.addAll(c2.g);
                    }
                }
                if (!c2.h.isEmpty()) {
                    if (this.d.isEmpty()) {
                        this.d = c2.h;
                        this.a &= -5;
                    } else {
                        this.p();
                        this.d.addAll(c2.h);
                    }
                }
                if (!c2.j.isEmpty()) {
                    if (this.e.isEmpty()) {
                        this.e = c2.j;
                        this.a &= -9;
                    } else {
                        this.q();
                        this.e.addAll(c2.j);
                    }
                }
                if (!c2.k.isEmpty()) {
                    if (this.f.isEmpty()) {
                        this.f = c2.k;
                        this.a &= -17;
                    } else {
                        this.r();
                        this.f.addAll(c2.k);
                    }
                }
                if (!c2.l.isEmpty()) {
                    if (this.g.isEmpty()) {
                        this.g = c2.l;
                        this.a &= -33;
                    } else {
                        this.s();
                        this.g.addAll(c2.l);
                    }
                }
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
            public a a(e object, g g2) {
                void var2_6;
                Object var3_7 = null;
                object = c.a.b((e)object, g2);
                if (object == null) return this;
                this.a((c)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (k k2) {}
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

            public c b() {
                return c.a();
            }

            @Override
            public /* synthetic */ a.a b(e e2, g g2) {
                return this.a(e2, g2);
            }

            public c c() {
                c c2 = this.d();
                if (c2.h()) {
                    return c2;
                }
                throw a.a(c2);
            }

            @Override
            public /* synthetic */ q.a c(e e2, g g2) {
                return this.a(e2, g2);
            }

            @Override
            public /* synthetic */ Object clone() {
                return this.a();
            }

            public c d() {
                c c2 = new c(this);
                int n2 = this.a;
                int n3 = 1;
                if ((n2 & 1) != 1) {
                    n3 = 0;
                }
                c2.f = this.b;
                if ((this.a & 2) == 2) {
                    this.c = this.c.b();
                    this.a &= -3;
                }
                c2.g = this.c;
                if ((this.a & 4) == 4) {
                    this.d = Collections.unmodifiableList(this.d);
                    this.a &= -5;
                }
                c2.h = this.d;
                if ((this.a & 8) == 8) {
                    this.e = this.e.b();
                    this.a &= -9;
                }
                c2.j = this.e;
                if ((this.a & 16) == 16) {
                    this.f = this.f.b();
                    this.a &= -17;
                }
                c2.k = this.f;
                if ((this.a & 32) == 32) {
                    this.g = Collections.unmodifiableList(this.g);
                    this.a &= -33;
                }
                c2.l = this.g;
                c2.e = n3;
                return c2;
            }

            public boolean e() {
                return (this.a & 1) == 1;
            }

            @Override
            public final boolean h() {
                return this.e();
            }

            @Override
            public /* synthetic */ i i() {
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
            public /* synthetic */ q l() {
                return this.c();
            }

            @Override
            public /* synthetic */ q o() {
                return this.b();
            }
        }

    }

    public static interface d
    extends r {
    }

}

