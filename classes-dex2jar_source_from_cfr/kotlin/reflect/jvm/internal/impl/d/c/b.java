/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.c;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.f.a;
import kotlin.reflect.jvm.internal.impl.f.d;
import kotlin.reflect.jvm.internal.impl.f.i;
import kotlin.reflect.jvm.internal.impl.f.j;
import kotlin.reflect.jvm.internal.impl.f.k;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.f.r;
import kotlin.reflect.jvm.internal.impl.f.s;
import kotlin.reflect.jvm.internal.impl.f.z;

public final class b {
    public static final i.f<a.e, c> a = i.a(a.e.a(), c.a(), c.a(), null, 100, z.a.k, c.class);
    public static final i.f<a.o, c> b = i.a(a.o.a(), c.a(), c.a(), null, 100, z.a.k, c.class);
    public static final i.f<a.o, Integer> c = i.a(a.o.a(), 0, null, null, 101, z.a.e, Integer.class);
    public static final i.f<a.w, e> d = i.a(a.w.a(), e.a(), e.a(), null, 100, z.a.k, e.class);
    public static final i.f<a.w, Integer> e = i.a(a.w.a(), 0, null, null, 101, z.a.e, Integer.class);
    public static final i.f<a.ac, List<a.a>> f = i.a(a.ac.a(), a.a.a(), null, 100, z.a.k, false, a.a.class);
    public static final i.f<a.ac, Boolean> g = i.a(a.ac.a(), false, null, null, 101, z.a.h, Boolean.class);
    public static final i.f<a.ag, List<a.a>> h = i.a(a.ag.a(), a.a.a(), null, 100, z.a.k, false, a.a.class);
    public static final i.f<a.c, Integer> i = i.a(a.c.a(), 0, null, null, 101, z.a.e, Integer.class);
    public static final i.f<a.c, List<a.w>> j = i.a(a.c.a(), a.w.a(), null, 102, z.a.k, false, a.w.class);
    public static final i.f<a.c, Integer> k = i.a(a.c.a(), 0, null, null, 103, z.a.e, Integer.class);
    public static final i.f<a.s, Integer> l = i.a(a.s.a(), 0, null, null, 101, z.a.e, Integer.class);
    public static final i.f<a.s, List<a.w>> m = i.a(a.s.a(), a.w.a(), null, 102, z.a.k, false, a.w.class);

    public static void a(kotlin.reflect.jvm.internal.impl.f.g g2) {
        g2.a(a);
        g2.a(b);
        g2.a(c);
        g2.a(d);
        g2.a(e);
        g2.a(f);
        g2.a(g);
        g2.a(h);
        g2.a(i);
        g2.a(j);
        g2.a(k);
        g2.a(l);
        g2.a(m);
    }

    public static final class kotlin.reflect.jvm.internal.impl.d.c.b$a
    extends i
    implements b {
        public static s<kotlin.reflect.jvm.internal.impl.d.c.b$a> a = new kotlin.reflect.jvm.internal.impl.f.b<kotlin.reflect.jvm.internal.impl.d.c.b$a>(){

            public kotlin.reflect.jvm.internal.impl.d.c.b$a a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return new kotlin.reflect.jvm.internal.impl.d.c.b$a(e2, g2);
            }

            @Override
            public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }
        };
        private static final kotlin.reflect.jvm.internal.impl.d.c.b$a c = new kotlin.reflect.jvm.internal.impl.d.c.b$a(true);
        private final kotlin.reflect.jvm.internal.impl.f.d d;
        private int e;
        private int f;
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
        private kotlin.reflect.jvm.internal.impl.d.c.b$a(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.p();
            var5_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var6_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var5_10, 1);
            var3_12 = false;
            while (!var3_12) {
                block16 : {
                    block17 : {
                        var4_13 = var1_1.a();
                        if (var4_13 == 0) break block17;
                        if (var4_13 == 8) ** GOTO lbl20
                        if (var4_13 != 16) {
                            if (this.a(var1_1, var6_11, var2_8, var4_13)) continue;
                        } else {
                            this.e |= 2;
                            this.g = var1_1.f();
                            continue;
lbl20: // 1 sources:
                            this.e |= 1;
                            this.f = var1_1.f();
                            continue;
                        }
                    }
                    var3_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block16;
                    }
                    catch (IOException var1_3) {
                        throw new k(var1_3.getMessage()).a(this);
                    }
                    catch (k var1_4) {
                        throw var1_4.a(this);
                    }
                }
                try {
                    var6_11.a();
lbl35: // 2 sources:
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
lbl45: // 2 sources:
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

        private kotlin.reflect.jvm.internal.impl.d.c.b$a(i.a a2) {
            super(a2);
            this.d = a2.x();
        }

        private kotlin.reflect.jvm.internal.impl.d.c.b$a(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(kotlin.reflect.jvm.internal.impl.d.c.b$a a2) {
            return kotlin.reflect.jvm.internal.impl.d.c.b$a.j().a(a2);
        }

        public static kotlin.reflect.jvm.internal.impl.d.c.b$a a() {
            return c;
        }

        public static a j() {
            return a.g();
        }

        private void p() {
            this.f = 0;
            this.g = 0;
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
            f2.c(this.d);
        }

        public kotlin.reflect.jvm.internal.impl.d.c.b$a b() {
            return c;
        }

        public s<kotlin.reflect.jvm.internal.impl.d.c.b$a> c() {
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
            byte by2 = this.h;
            if (by2 == 1) {
                return true;
            }
            if (by2 == 0) {
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
            return kotlin.reflect.jvm.internal.impl.d.c.b$a.j();
        }

        public a l() {
            return kotlin.reflect.jvm.internal.impl.d.c.b$a.a(this);
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
        public /* synthetic */ q o() {
            return this.b();
        }

        public static final class a
        extends i.a<kotlin.reflect.jvm.internal.impl.d.c.b$a, a>
        implements b {
            private int a;
            private int b;
            private int c;

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
            public a a(kotlin.reflect.jvm.internal.impl.d.c.b$a a2) {
                if (a2 == kotlin.reflect.jvm.internal.impl.d.c.b$a.a()) {
                    return this;
                }
                if (a2.d()) {
                    this.a(a2.e());
                }
                if (a2.f()) {
                    this.b(a2.g());
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
                object = kotlin.reflect.jvm.internal.impl.d.c.b$a.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                if (object == null) return this;
                this.a((kotlin.reflect.jvm.internal.impl.d.c.b$a)object);
                return this;
                {
                    catch (Throwable throwable) {
                        object = var3_7;
                    }
                    catch (k k2) {}
                    {
                        object = (kotlin.reflect.jvm.internal.impl.d.c.b$a)k2.a();
                    }
                    try {
                        throw k2;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (object == null) throw var2_6;
                this.a((kotlin.reflect.jvm.internal.impl.d.c.b$a)object);
                throw var2_6;
            }

            public a b(int n2) {
                this.a |= 2;
                this.c = n2;
                return this;
            }

            public kotlin.reflect.jvm.internal.impl.d.c.b$a b() {
                return kotlin.reflect.jvm.internal.impl.d.c.b$a.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public kotlin.reflect.jvm.internal.impl.d.c.b$a c() {
                kotlin.reflect.jvm.internal.impl.d.c.b$a a2 = this.d();
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

            public kotlin.reflect.jvm.internal.impl.d.c.b$a d() {
                kotlin.reflect.jvm.internal.impl.d.c.b$a a2 = new kotlin.reflect.jvm.internal.impl.d.c.b$a(this);
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

            @Override
            public final boolean h() {
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
        private byte h = (byte)-1;
        private int i = -1;

        static {
            c.p();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private c(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.p();
            var5_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var6_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var5_10, 1);
            var3_12 = false;
            while (!var3_12) {
                block16 : {
                    block17 : {
                        var4_13 = var1_1.a();
                        if (var4_13 == 0) break block17;
                        if (var4_13 == 8) ** GOTO lbl20
                        if (var4_13 != 16) {
                            if (this.a(var1_1, var6_11, var2_8, var4_13)) continue;
                        } else {
                            this.e |= 2;
                            this.g = var1_1.f();
                            continue;
lbl20: // 1 sources:
                            this.e |= 1;
                            this.f = var1_1.f();
                            continue;
                        }
                    }
                    var3_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block16;
                    }
                    catch (IOException var1_3) {
                        throw new k(var1_3.getMessage()).a(this);
                    }
                    catch (k var1_4) {
                        throw var1_4.a(this);
                    }
                }
                try {
                    var6_11.a();
lbl35: // 2 sources:
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
lbl45: // 2 sources:
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

        private c(i.a a2) {
            super(a2);
            this.d = a2.x();
        }

        private c(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(c c2) {
            return c.j().a(c2);
        }

        public static c a() {
            return c;
        }

        public static a j() {
            return a.g();
        }

        private void p() {
            this.f = 0;
            this.g = 0;
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
            byte by2 = this.h;
            if (by2 == 1) {
                return true;
            }
            if (by2 == 0) {
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
            return c.j();
        }

        public a l() {
            return c.a(this);
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
        public /* synthetic */ q o() {
            return this.b();
        }

        public static final class a
        extends i.a<c, a>
        implements d {
            private int a;
            private int b;
            private int c;

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
                c2.e = n4;
                return c2;
            }

            @Override
            public final boolean h() {
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

            @Override
            public /* synthetic */ q o() {
                return this.b();
            }
        }

    }

    public static interface d
    extends r {
    }

    public static final class e
    extends i
    implements f {
        public static s<e> a = new kotlin.reflect.jvm.internal.impl.f.b<e>(){

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
        private kotlin.reflect.jvm.internal.impl.d.c.b$a f;
        private c g;
        private c h;
        private c i;
        private byte j = (byte)-1;
        private int k = -1;

        static {
            c.t();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private e(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.t();
            var10_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
            var11_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var10_10, 1);
            var5_12 = false;
            block11 : while (!var5_12) {
                block23 : {
                    block24 : {
                        block25 : {
                            block26 : {
                                block27 : {
                                    block28 : {
                                        var3_13 = var1_1.a();
                                        if (var3_13 == 0) break block24;
                                        var7_16 = null;
                                        var8_17 = null;
                                        var9_18 = null;
                                        var6_15 = null;
                                        if (var3_13 == 10) break block25;
                                        if (var3_13 == 18) break block26;
                                        if (var3_13 == 26) break block27;
                                        if (var3_13 == 34) break block28;
                                        if (this.a(var1_1, var11_11, var2_8, var3_13)) continue;
                                        break block24;
                                    }
                                    var3_13 = this.e;
                                    var4_14 = 8;
                                    if ((var3_13 & 8) == 8) {
                                        var6_15 = this.i.l();
                                    }
                                    this.i = var1_1.a(c.a, var2_8);
                                    if (var6_15 != null) {
                                        var6_15.a(this.i);
                                        this.i = var6_15.d();
                                    }
                                    var3_13 = this.e;
lbl33: // 3 sources:
                                    do {
                                        this.e = var3_13 | var4_14;
                                        continue block11;
                                        break;
                                    } while (true);
                                }
                                var3_13 = this.e;
                                var4_14 = 4;
                                var6_15 = var7_16;
                                if ((var3_13 & 4) == 4) {
                                    var6_15 = this.h.l();
                                }
                                this.h = var1_1.a(c.a, var2_8);
                                if (var6_15 != null) {
                                    var6_15.a(this.h);
                                    this.h = var6_15.d();
                                }
                                var3_13 = this.e;
                                ** GOTO lbl33
                            }
                            var3_13 = this.e;
                            var4_14 = 2;
                            var6_15 = var8_17;
                            if ((var3_13 & 2) == 2) {
                                var6_15 = this.g.l();
                            }
                            this.g = var1_1.a(c.a, var2_8);
                            if (var6_15 != null) {
                                var6_15.a(this.g);
                                this.g = var6_15.d();
                            }
                            var3_13 = this.e;
                            ** continue;
                        }
                        var6_15 = var9_18;
                        if ((this.e & 1) == 1) {
                            var6_15 = this.f.l();
                        }
                        this.f = var1_1.a(kotlin.reflect.jvm.internal.impl.d.c.b$a.a, var2_8);
                        if (var6_15 != null) {
                            var6_15.a(this.f);
                            this.f = var6_15.d();
                        }
                        this.e |= 1;
                        continue;
                    }
                    var5_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block23;
                    }
                    catch (IOException var1_3) {
                        throw new k(var1_3.getMessage()).a(this);
                    }
                    catch (k var1_4) {
                        throw var1_4.a(this);
                    }
                }
                try {
                    var11_11.a();
lbl82: // 2 sources:
                    do {
                        this.d = var10_10.a();
                        break;
                    } while (true);
                }
                catch (Throwable var1_5) {
                    this.d = var10_10.a();
                    throw var1_5;
                }
                this.O();
                throw var1_2;
            }
            try {
                var11_11.a();
lbl92: // 2 sources:
                do {
                    this.d = var10_10.a();
                    break;
                } while (true);
            }
            catch (Throwable var1_6) {
                this.d = var10_10.a();
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

        private e(i.a a2) {
            super(a2);
            this.d = a2.x();
        }

        private e(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(e e2) {
            return e.q().a(e2);
        }

        public static e a() {
            return c;
        }

        public static a q() {
            return a.g();
        }

        private void t() {
            this.f = kotlin.reflect.jvm.internal.impl.d.c.b$a.a();
            this.g = c.a();
            this.h = c.a();
            this.i = c.a();
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            this.i();
            if ((this.e & 1) == 1) {
                f2.b(1, this.f);
            }
            if ((this.e & 2) == 2) {
                f2.b(2, this.g);
            }
            if ((this.e & 4) == 4) {
                f2.b(3, this.h);
            }
            if ((this.e & 8) == 8) {
                f2.b(4, this.i);
            }
            f2.c(this.d);
        }

        public e b() {
            return c;
        }

        public s<e> c() {
            return a;
        }

        public boolean d() {
            return (this.e & 1) == 1;
        }

        public kotlin.reflect.jvm.internal.impl.d.c.b$a e() {
            return this.f;
        }

        public boolean f() {
            return (this.e & 2) == 2;
        }

        public c g() {
            return this.g;
        }

        @Override
        public final boolean h() {
            byte by2 = this.j;
            if (by2 == 1) {
                return true;
            }
            if (by2 == 0) {
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
            if ((this.e & 8) == 8) {
                n2 = n3 + kotlin.reflect.jvm.internal.impl.f.f.d(4, this.i);
            }
            this.k = n2 += this.d.a();
            return n2;
        }

        public boolean j() {
            return (this.e & 4) == 4;
        }

        public c k() {
            return this.h;
        }

        public boolean l() {
            return (this.e & 8) == 8;
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

        public c p() {
            return this.i;
        }

        public a r() {
            return e.q();
        }

        public a s() {
            return e.a(this);
        }

        public static final class a
        extends i.a<e, a>
        implements f {
            private int a;
            private kotlin.reflect.jvm.internal.impl.d.c.b$a b = kotlin.reflect.jvm.internal.impl.d.c.b$a.a();
            private c c = c.a();
            private c d = c.a();
            private c e = c.a();

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
            public a a(kotlin.reflect.jvm.internal.impl.d.c.b$a a2) {
                kotlin.reflect.jvm.internal.impl.d.c.b$a a3 = a2;
                if ((this.a & 1) == 1) {
                    a3 = a2;
                    if (this.b != kotlin.reflect.jvm.internal.impl.d.c.b$a.a()) {
                        a3 = kotlin.reflect.jvm.internal.impl.d.c.b$a.a(this.b).a(a2).d();
                    }
                }
                this.b = a3;
                this.a |= 1;
                return this;
            }

            @Override
            public a a(c c2) {
                c c3 = c2;
                if ((this.a & 2) == 2) {
                    c3 = c2;
                    if (this.c != c.a()) {
                        c3 = c.a(this.c).a(c2).d();
                    }
                }
                this.c = c3;
                this.a |= 2;
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
                if (e2.f()) {
                    this.a(e2.g());
                }
                if (e2.j()) {
                    this.b(e2.k());
                }
                if (e2.l()) {
                    this.c(e2.p());
                }
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
                    catch (k k2) {}
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

            public a b(c c2) {
                c c3 = c2;
                if ((this.a & 4) == 4) {
                    c3 = c2;
                    if (this.d != c.a()) {
                        c3 = c.a(this.d).a(c2).d();
                    }
                }
                this.d = c3;
                this.a |= 4;
                return this;
            }

            public e b() {
                return e.a();
            }

            @Override
            public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                return this.a(e2, g2);
            }

            public a c(c c2) {
                c c3 = c2;
                if ((this.a & 8) == 8) {
                    c3 = c2;
                    if (this.e != c.a()) {
                        c3 = c.a(this.e).a(c2).d();
                    }
                }
                this.e = c3;
                this.a |= 8;
                return this;
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
                int n4 = n3;
                if ((n2 & 2) == 2) {
                    n4 = n3 | 2;
                }
                e2.g = this.c;
                n3 = n4;
                if ((n2 & 4) == 4) {
                    n3 = n4 | 4;
                }
                e2.h = this.d;
                n4 = n3;
                if ((n2 & 8) == 8) {
                    n4 = n3 | 8;
                }
                e2.i = this.e;
                e2.e = n4;
                return e2;
            }

            @Override
            public final boolean h() {
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

            @Override
            public /* synthetic */ q o() {
                return this.b();
            }
        }

    }

    public static interface f
    extends r {
    }

    public static final class g
    extends i
    implements h {
        public static s<g> a = new kotlin.reflect.jvm.internal.impl.f.b<g>(){

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
        private List<b> e;
        private List<Integer> f;
        private int g = -1;
        private byte h = (byte)-1;
        private int i = -1;

        static {
            c.k();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        private g(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
            super();
            this.k();
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
                        if (var7_17 == 10) ** GOTO lbl80
                        if (var7_17 == 40) ** GOTO lbl58
                        if (var7_17 != 42) {
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
                            if ((var3_13 & 2) != 2) {
                                var7_17 = var3_13;
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                if (var1_1.x() > 0) {
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    this.f = new ArrayList<Integer>();
                                    var7_17 = var3_13 | 2;
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
                                this.f.add(var1_1.f());
                            } while (true);
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var1_1.d(var9_18);
                            var3_13 = var7_17;
                            continue;
lbl58: // 1 sources:
                            var7_17 = var3_13;
                            if ((var3_13 & 2) != 2) {
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                this.f = new ArrayList<Integer>();
                                var7_17 = var3_13 | 2;
                            }
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var10_19 = this.f;
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
                            if ((var3_13 & 1) != 1) {
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                this.e = new ArrayList<b>();
                                var7_17 = var3_13 | 1;
                            }
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var10_19 = this.e;
                            var4_14 = var7_17;
                            var5_15 = var7_17;
                            var6_16 = var7_17;
                            var11_20 /* !! */  = var1_1.a(b.a, var2_8);
                            var3_13 = var7_17;
                            ** continue;
                        }
                    }
                    var8_12 = true;
                    continue;
                    catch (Throwable var1_2) {
                        break block26;
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
                    this.e = Collections.unmodifiableList(this.e);
                }
                if ((var4_14 & 2) == 2) {
                    this.f = Collections.unmodifiableList(this.f);
                }
                try {
                    var13_11.a();
lbl115: // 2 sources:
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
            if (var3_13 & true) {
                this.e = Collections.unmodifiableList(this.e);
            }
            if ((var3_13 & 2) == 2) {
                this.f = Collections.unmodifiableList(this.f);
            }
            try {
                var13_11.a();
lbl129: // 2 sources:
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

        private g(i.a a2) {
            super(a2);
            this.d = a2.x();
        }

        private g(boolean bl2) {
            this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
        }

        public static a a(g g2) {
            return g.f().a(g2);
        }

        public static g a() {
            return c;
        }

        public static g a(InputStream inputStream, kotlin.reflect.jvm.internal.impl.f.g g2) {
            return a.e(inputStream, g2);
        }

        public static a f() {
            return a.g();
        }

        private void k() {
            this.e = Collections.emptyList();
            this.f = Collections.emptyList();
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
            int n2;
            this.i();
            int n3 = 0;
            for (n2 = 0; n2 < this.e.size(); ++n2) {
                f2.b(1, this.e.get(n2));
            }
            n2 = n3;
            if (this.e().size() > 0) {
                f2.p(42);
                f2.p(this.g);
                n2 = n3;
            }
            while (n2 < this.f.size()) {
                f2.b(this.f.get(n2));
                ++n2;
            }
            f2.c(this.d);
        }

        public g b() {
            return c;
        }

        public s<g> c() {
            return a;
        }

        public List<b> d() {
            return this.e;
        }

        public List<Integer> e() {
            return this.f;
        }

        public a g() {
            return g.f();
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
            int n4 = 0;
            n3 = 0;
            for (n2 = 0; n2 < this.e.size(); ++n2) {
                n3 += kotlin.reflect.jvm.internal.impl.f.f.d(1, this.e.get(n2));
            }
            n2 = 0;
            while (n4 < this.f.size()) {
                n2 += kotlin.reflect.jvm.internal.impl.f.f.h(this.f.get(n4));
                ++n4;
            }
            n3 = n4 = n3 + n2;
            if (!this.e().isEmpty()) {
                n3 = n4 + 1 + kotlin.reflect.jvm.internal.impl.f.f.h(n2);
            }
            this.g = n2;
            this.i = n3 += this.d.a();
            return n3;
        }

        public a j() {
            return g.a(this);
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
        public /* synthetic */ q o() {
            return this.b();
        }

        public static final class a
        extends i.a<g, a>
        implements h {
            private int a;
            private List<b> b = Collections.emptyList();
            private List<Integer> c = Collections.emptyList();

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
                    this.b = new ArrayList<b>(this.b);
                    this.a |= 1;
                }
            }

            private void n() {
                if ((this.a & 2) != 2) {
                    this.c = new ArrayList<Integer>(this.c);
                    this.a |= 2;
                }
            }

            public a a() {
                return a.g().a(this.d());
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
                        this.m();
                        this.b.addAll(g2.e);
                    }
                }
                if (!g2.f.isEmpty()) {
                    if (this.c.isEmpty()) {
                        this.c = g2.f;
                        this.a &= -3;
                    } else {
                        this.n();
                        this.c.addAll(g2.f);
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
                    catch (k k2) {}
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
                if ((this.a & 2) == 2) {
                    this.c = Collections.unmodifiableList(this.c);
                    this.a &= -3;
                }
                g2.f = this.c;
                return g2;
            }

            @Override
            public final boolean h() {
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

            @Override
            public /* synthetic */ q o() {
                return this.b();
            }
        }

        public static final class kotlin.reflect.jvm.internal.impl.d.c.b$g$b
        extends i
        implements c {
            public static s<kotlin.reflect.jvm.internal.impl.d.c.b$g$b> a = new kotlin.reflect.jvm.internal.impl.f.b<kotlin.reflect.jvm.internal.impl.d.c.b$g$b>(){

                public kotlin.reflect.jvm.internal.impl.d.c.b$g$b a(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    return new kotlin.reflect.jvm.internal.impl.d.c.b$g$b(e2, g2);
                }

                @Override
                public /* synthetic */ Object b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    return this.a(e2, g2);
                }
            };
            private static final kotlin.reflect.jvm.internal.impl.d.c.b$g$b c = new kotlin.reflect.jvm.internal.impl.d.c.b$g$b(true);
            private final kotlin.reflect.jvm.internal.impl.f.d d;
            private int e;
            private int f;
            private int g;
            private Object h;
            private b i;
            private List<Integer> j;
            private int k = -1;
            private List<Integer> l;
            private int m = -1;
            private byte n = (byte)-1;
            private int o = -1;

            static {
                c.y();
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive exception aggregation
             */
            private kotlin.reflect.jvm.internal.impl.d.c.b$g$b(kotlin.reflect.jvm.internal.impl.f.e var1_1, kotlin.reflect.jvm.internal.impl.f.g var2_8) {
                super();
                this.y();
                var13_10 = kotlin.reflect.jvm.internal.impl.f.d.i();
                var14_11 = kotlin.reflect.jvm.internal.impl.f.f.a(var13_10, 1);
                var8_12 = false;
                var3_13 = 0;
                block11 : while (!var8_12) {
                    block31 : {
                        block32 : {
                            var4_14 = var3_13;
                            var5_15 = var3_13;
                            var6_16 = var3_13;
                            var7_17 = var1_1.a();
                            if (var7_17 == 0) break block32;
                            if (var7_17 == 8) ** GOTO lbl182
                            if (var7_17 == 16) ** GOTO lbl173
                            if (var7_17 == 24) ** GOTO lbl146
                            if (var7_17 == 32) ** GOTO lbl129
                            if (var7_17 == 34) ** GOTO lbl101
                            if (var7_17 == 40) ** GOTO lbl79
                            if (var7_17 == 42) ** GOTO lbl45
                            if (var7_17 != 50) {
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                if (this.a(var1_1, var14_11, var2_8, var7_17)) continue;
                            } else {
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var11_20 = var1_1.l();
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                this.e |= 4;
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                this.h = var11_20;
                                continue;
lbl45: // 1 sources:
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
lbl79: // 1 sources:
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
lbl95: // 2 sources:
                                do {
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    var11_20.add((Integer)var12_21);
                                    continue block11;
                                    break;
                                } while (true);
lbl101: // 1 sources:
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var10_19 = var1_1.c(var1_1.s());
                                var7_17 = var3_13;
                                if ((var3_13 & 16) != 16) {
                                    var7_17 = var3_13;
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    if (var1_1.x() > 0) {
                                        var4_14 = var3_13;
                                        var5_15 = var3_13;
                                        var6_16 = var3_13;
                                        this.j = new ArrayList<Integer>();
                                        var7_17 = var3_13 | 16;
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
                                    this.j.add(var1_1.f());
                                } while (true);
lbl129: // 1 sources:
                                var7_17 = var3_13;
                                if ((var3_13 & 16) != 16) {
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    this.j = new ArrayList<Integer>();
                                    var7_17 = var3_13 | 16;
                                }
                                var4_14 = var7_17;
                                var5_15 = var7_17;
                                var6_16 = var7_17;
                                var11_20 = this.j;
                                var4_14 = var7_17;
                                var5_15 = var7_17;
                                var6_16 = var7_17;
                                var12_21 = var1_1.f();
                                var3_13 = var7_17;
                                ** continue;
lbl146: // 1 sources:
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var9_18 = var1_1.n();
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                var11_20 = b.a(var9_18);
                                if (var11_20 == null) {
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    var14_11.p(var7_17);
                                    var4_14 = var3_13;
                                    var5_15 = var3_13;
                                    var6_16 = var3_13;
                                    var14_11.p(var9_18);
                                    continue;
                                }
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                this.e |= 8;
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                this.i = var11_20;
                                continue;
lbl173: // 1 sources:
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                this.e |= 2;
                                var4_14 = var3_13;
                                var5_15 = var3_13;
                                var6_16 = var3_13;
                                this.g = var1_1.f();
                                continue;
lbl182: // 1 sources:
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
                    if ((var4_14 & 16) == 16) {
                        this.j = Collections.unmodifiableList(this.j);
                    }
                    if ((var4_14 & 32) == 32) {
                        this.l = Collections.unmodifiableList(this.l);
                    }
                    try {
                        var14_11.a();
lbl209: // 2 sources:
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
                if ((var3_13 & 16) == 16) {
                    this.j = Collections.unmodifiableList(this.j);
                }
                if ((var3_13 & 32) == 32) {
                    this.l = Collections.unmodifiableList(this.l);
                }
                try {
                    var14_11.a();
lbl223: // 2 sources:
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

            private kotlin.reflect.jvm.internal.impl.d.c.b$g$b(i.a a2) {
                super(a2);
                this.d = a2.x();
            }

            private kotlin.reflect.jvm.internal.impl.d.c.b$g$b(boolean bl2) {
                this.d = kotlin.reflect.jvm.internal.impl.f.d.a;
            }

            public static a a(kotlin.reflect.jvm.internal.impl.d.c.b$g$b b2) {
                return kotlin.reflect.jvm.internal.impl.d.c.b$g$b.v().a(b2);
            }

            public static kotlin.reflect.jvm.internal.impl.d.c.b$g$b a() {
                return c;
            }

            public static a v() {
                return a.g();
            }

            private void y() {
                this.f = 1;
                this.g = 0;
                this.h = "";
                this.i = b.a;
                this.j = Collections.emptyList();
                this.l = Collections.emptyList();
            }

            @Override
            public void a(kotlin.reflect.jvm.internal.impl.f.f f2) {
                int n2;
                this.i();
                if ((this.e & 1) == 1) {
                    f2.a(1, this.f);
                }
                if ((this.e & 2) == 2) {
                    f2.a(2, this.g);
                }
                if ((this.e & 8) == 8) {
                    f2.c(3, this.i.a());
                }
                if (this.r().size() > 0) {
                    f2.p(34);
                    f2.p(this.k);
                }
                int n3 = 0;
                for (n2 = 0; n2 < this.j.size(); ++n2) {
                    f2.b(this.j.get(n2));
                }
                n2 = n3;
                if (this.t().size() > 0) {
                    f2.p(42);
                    f2.p(this.m);
                    n2 = n3;
                }
                while (n2 < this.l.size()) {
                    f2.b(this.l.get(n2));
                    ++n2;
                }
                if ((this.e & 4) == 4) {
                    f2.a(6, this.l());
                }
                f2.c(this.d);
            }

            public kotlin.reflect.jvm.internal.impl.d.c.b$g$b b() {
                return c;
            }

            public s<kotlin.reflect.jvm.internal.impl.d.c.b$g$b> c() {
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
                byte by2 = this.n;
                if (by2 == 1) {
                    return true;
                }
                if (by2 == 0) {
                    return false;
                }
                this.n = 1;
                return true;
            }

            @Override
            public int i() {
                int n2 = this.o;
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
                if ((this.e & 8) == 8) {
                    n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.e(3, this.i.a());
                }
                int n5 = 0;
                for (n2 = 0; n2 < this.j.size(); ++n2) {
                    n5 += kotlin.reflect.jvm.internal.impl.f.f.h(this.j.get(n2));
                }
                n2 = n4 += n5;
                if (!this.r().isEmpty()) {
                    n2 = n4 + 1 + kotlin.reflect.jvm.internal.impl.f.f.h(n5);
                }
                this.k = n5;
                n4 = 0;
                for (n5 = n3; n5 < this.l.size(); ++n5) {
                    n4 += kotlin.reflect.jvm.internal.impl.f.f.h(this.l.get(n5));
                }
                n2 = n5 = n2 + n4;
                if (!this.t().isEmpty()) {
                    n2 = n5 + 1 + kotlin.reflect.jvm.internal.impl.f.f.h(n4);
                }
                this.m = n4;
                n4 = n2;
                if ((this.e & 4) == 4) {
                    n4 = n2 + kotlin.reflect.jvm.internal.impl.f.f.b(6, this.l());
                }
                this.o = n2 = n4 + this.d.a();
                return n2;
            }

            public boolean j() {
                return (this.e & 4) == 4;
            }

            public String k() {
                Object object = this.h;
                if (object instanceof String) {
                    return (String)object;
                }
                object = (kotlin.reflect.jvm.internal.impl.f.d)object;
                String string2 = ((kotlin.reflect.jvm.internal.impl.f.d)object).f();
                if (((kotlin.reflect.jvm.internal.impl.f.d)object).g()) {
                    this.h = string2;
                }
                return string2;
            }

            public kotlin.reflect.jvm.internal.impl.f.d l() {
                Object object = this.h;
                if (object instanceof String) {
                    this.h = object = kotlin.reflect.jvm.internal.impl.f.d.a((String)object);
                    return object;
                }
                return (kotlin.reflect.jvm.internal.impl.f.d)object;
            }

            @Override
            public /* synthetic */ q.a m() {
                return this.x();
            }

            @Override
            public /* synthetic */ q.a n() {
                return this.w();
            }

            @Override
            public /* synthetic */ q o() {
                return this.b();
            }

            public boolean p() {
                return (this.e & 8) == 8;
            }

            public b q() {
                return this.i;
            }

            public List<Integer> r() {
                return this.j;
            }

            public int s() {
                return this.j.size();
            }

            public List<Integer> t() {
                return this.l;
            }

            public int u() {
                return this.l.size();
            }

            public a w() {
                return kotlin.reflect.jvm.internal.impl.d.c.b$g$b.v();
            }

            public a x() {
                return kotlin.reflect.jvm.internal.impl.d.c.b$g$b.a(this);
            }

            public static final class a
            extends i.a<kotlin.reflect.jvm.internal.impl.d.c.b$g$b, a>
            implements c {
                private int a;
                private int b = 1;
                private int c;
                private Object d = "";
                private b e = b.a;
                private List<Integer> f = Collections.emptyList();
                private List<Integer> g = Collections.emptyList();

                private a() {
                    this.f();
                }

                private void f() {
                }

                private static a g() {
                    return new a();
                }

                private void m() {
                    if ((this.a & 16) != 16) {
                        this.f = new ArrayList<Integer>(this.f);
                        this.a |= 16;
                    }
                }

                private void n() {
                    if ((this.a & 32) != 32) {
                        this.g = new ArrayList<Integer>(this.g);
                        this.a |= 32;
                    }
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
                        this.a |= 8;
                        this.e = b2;
                        return this;
                    }
                    throw new NullPointerException();
                }

                @Override
                public a a(kotlin.reflect.jvm.internal.impl.d.c.b$g$b b2) {
                    if (b2 == kotlin.reflect.jvm.internal.impl.d.c.b$g$b.a()) {
                        return this;
                    }
                    if (b2.d()) {
                        this.a(b2.e());
                    }
                    if (b2.f()) {
                        this.b(b2.g());
                    }
                    if (b2.j()) {
                        this.a |= 4;
                        this.d = b2.h;
                    }
                    if (b2.p()) {
                        this.a(b2.q());
                    }
                    if (!b2.j.isEmpty()) {
                        if (this.f.isEmpty()) {
                            this.f = b2.j;
                            this.a &= -17;
                        } else {
                            this.m();
                            this.f.addAll(b2.j);
                        }
                    }
                    if (!b2.l.isEmpty()) {
                        if (this.g.isEmpty()) {
                            this.g = b2.l;
                            this.a &= -33;
                        } else {
                            this.n();
                            this.g.addAll(b2.l);
                        }
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
                    object = kotlin.reflect.jvm.internal.impl.d.c.b$g$b.a.b((kotlin.reflect.jvm.internal.impl.f.e)object, g2);
                    if (object == null) return this;
                    this.a((kotlin.reflect.jvm.internal.impl.d.c.b$g$b)object);
                    return this;
                    {
                        catch (Throwable throwable) {
                            object = var3_7;
                        }
                        catch (k k2) {}
                        {
                            object = (kotlin.reflect.jvm.internal.impl.d.c.b$g$b)k2.a();
                        }
                        try {
                            throw k2;
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    if (object == null) throw var2_6;
                    this.a((kotlin.reflect.jvm.internal.impl.d.c.b$g$b)object);
                    throw var2_6;
                }

                public a b(int n2) {
                    this.a |= 2;
                    this.c = n2;
                    return this;
                }

                public kotlin.reflect.jvm.internal.impl.d.c.b$g$b b() {
                    return kotlin.reflect.jvm.internal.impl.d.c.b$g$b.a();
                }

                @Override
                public /* synthetic */ a.a b(kotlin.reflect.jvm.internal.impl.f.e e2, kotlin.reflect.jvm.internal.impl.f.g g2) {
                    return this.a(e2, g2);
                }

                public kotlin.reflect.jvm.internal.impl.d.c.b$g$b c() {
                    kotlin.reflect.jvm.internal.impl.d.c.b$g$b b2 = this.d();
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

                public kotlin.reflect.jvm.internal.impl.d.c.b$g$b d() {
                    kotlin.reflect.jvm.internal.impl.d.c.b$g$b b2 = new kotlin.reflect.jvm.internal.impl.d.c.b$g$b(this);
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
                    if ((this.a & 16) == 16) {
                        this.f = Collections.unmodifiableList(this.f);
                        this.a &= -17;
                    }
                    b2.j = this.f;
                    if ((this.a & 32) == 32) {
                        this.g = Collections.unmodifiableList(this.g);
                        this.a &= -33;
                    }
                    b2.l = this.g;
                    b2.e = n4;
                    return b2;
                }

                @Override
                public final boolean h() {
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

                @Override
                public /* synthetic */ q o() {
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
        extends r {
        }

    }

    public static interface h
    extends r {
    }

}

