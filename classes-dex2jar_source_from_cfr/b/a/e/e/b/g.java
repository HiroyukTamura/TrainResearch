/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.e.b;

import b.a.e;
import b.a.e.a.c;
import b.a.f;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class g<T, R>
extends e<R> {
    final f<? extends T>[] a;
    final Iterable<? extends f<? extends T>> b;
    final b.a.d.e<? super Object[], ? extends R> c;
    final int d;
    final boolean e;

    public g(f<? extends T>[] arrf, Iterable<? extends f<? extends T>> iterable, b.a.d.e<? super Object[], ? extends R> e2, int n2, boolean bl2) {
        this.a = arrf;
        this.b = iterable;
        this.c = e2;
        this.d = n2;
        this.e = bl2;
    }

    @Override
    public void b(b.a.g<? super R> g2) {
        int n2;
        f<? extends T>[] arrf = this.a;
        if (arrf == null) {
            f<Object>[] arrf2 = new e[8];
            Iterator<f<T>> iterator = this.b.iterator();
            int n3 = 0;
            do {
                n2 = ++n3;
                arrf = arrf2;
                if (iterator.hasNext()) {
                    f<? extends T> f2 = iterator.next();
                    arrf = arrf2;
                    if (n3 == arrf2.length) {
                        arrf = new f[(n3 >> 2) + n3];
                        System.arraycopy(arrf2, 0, arrf, 0, n3);
                    }
                    arrf[n3] = f2;
                    arrf2 = arrf;
                    continue;
                }
                break;
            } while (true);
        } else {
            n2 = arrf.length;
        }
        if (n2 == 0) {
            c.a(g2);
            return;
        }
        new a<T, R>(g2, this.c, n2, this.e).a(arrf, this.d);
    }

    static final class a<T, R>
    extends AtomicInteger
    implements b.a.b.b {
        final b.a.g<? super R> a;
        final b.a.d.e<? super Object[], ? extends R> b;
        final b<T, R>[] c;
        final T[] d;
        final boolean e;
        volatile boolean f;

        a(b.a.g<? super R> g2, b.a.d.e<? super Object[], ? extends R> e2, int n2, boolean bl2) {
            this.a = g2;
            this.b = e2;
            this.c = new b[n2];
            this.d = new Object[n2];
            this.e = bl2;
        }

        @Override
        public void a() {
            if (!this.f) {
                this.f = true;
                this.c();
                if (this.getAndIncrement() == 0) {
                    this.d();
                }
            }
        }

        public void a(f<? extends T>[] arrf, int n2) {
            b<T, R>[] arrb = this.c;
            int n3 = arrb.length;
            int n4 = 0;
            for (int i2 = 0; i2 < n3; ++i2) {
                arrb[i2] = new b(this, n2);
            }
            this.lazySet(0);
            this.a.a(this);
            for (n2 = n4; n2 < n3; ++n2) {
                if (this.f) {
                    return;
                }
                arrf[n2].a(arrb[n2]);
            }
        }

        boolean a(boolean bl2, boolean bl3, b.a.g<? super R> g2, boolean bl4, b<?, ?> object) {
            if (this.f) {
                this.b();
                return true;
            }
            if (bl2) {
                if (bl4) {
                    if (bl3) {
                        object = ((b)object).d;
                        this.b();
                        if (object != null) {
                            g2.a((Throwable)object);
                            return true;
                        }
                        g2.b_();
                        return true;
                    }
                } else {
                    object = ((b)object).d;
                    if (object != null) {
                        this.b();
                        g2.a((Throwable)object);
                        return true;
                    }
                    if (bl3) {
                        this.b();
                        g2.b_();
                        return true;
                    }
                }
            }
            return false;
        }

        void b() {
            this.d();
            this.c();
        }

        void c() {
            b<T, R>[] arrb = this.c;
            int n2 = arrb.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                arrb[i2].b();
            }
        }

        void d() {
            b<T, R>[] arrb = this.c;
            int n2 = arrb.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                arrb[i2].b.d();
            }
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        public void e() {
            if (this.getAndIncrement() != 0) {
                return;
            }
            var11_1 = this.c;
            var10_3 = this.a;
            var12_4 = this.d;
            var8_5 = this.e;
            var1_6 = 1;
            do lbl-1000: // 3 sources:
            {
                var6_11 = var11_1.length;
                var3_8 = 0;
                var4_9 = 0;
                for (var2_7 = 0; var2_7 < var6_11; ++var3_8, ++var2_7) {
                    var13_14 = var11_1[var2_7];
                    if (var12_4[var3_8] == null) {
                        var9_13 = var13_14.c;
                        var14_15 = var13_14.b.b();
                        var7_12 = var14_15 == null;
                        if (this.a(var9_13, var7_12, (b.a.g<? super R>)var10_3, var8_5, (b<?, ?>)var13_14)) {
                            return;
                        }
                        if (!var7_12) {
                            var12_4[var3_8] = var14_15;
                            var5_10 = var4_9;
                        } else {
                            var5_10 = var4_9 + 1;
                        }
                    } else {
                        var5_10 = var4_9;
                        if (var13_14.c) {
                            var5_10 = var4_9;
                            if (!var8_5) {
                                var13_14 = var13_14.d;
                                var5_10 = var4_9;
                                if (var13_14 != null) {
                                    this.b();
                                    var10_3.a((Throwable)var13_14);
                                    return;
                                }
                            }
                        }
                    }
                    var4_9 = var5_10;
                }
                if (var4_9 != 0) {
                    var1_6 = var2_7 = this.addAndGet(-var1_6);
                    if (var2_7 != 0) continue;
                    return;
                }
                var13_14 = b.a.e.b.b.a(this.b.a((Object[])var12_4.clone()), "The zipper returned a null value");
                var10_3.a_(var13_14);
                break;
            } while (true);
            catch (Throwable var11_2) {
                b.a.c.b.b(var11_2);
                this.b();
                var10_3.a(var11_2);
                return;
            }
            {
                Arrays.fill(var12_4, null);
                ** while (true)
            }
        }
    }

    static final class b<T, R>
    implements b.a.g<T> {
        final a<T, R> a;
        final b.a.e.f.a<T> b;
        volatile boolean c;
        Throwable d;
        final AtomicReference<b.a.b.b> e = new AtomicReference();

        b(a<T, R> a2, int n2) {
            this.a = a2;
            this.b = new b.a.e.f.a(n2);
        }

        @Override
        public void a(b.a.b.b b2) {
            b.a.e.a.b.a(this.e, b2);
        }

        @Override
        public void a(Throwable throwable) {
            this.d = throwable;
            this.c = true;
            this.a.e();
        }

        @Override
        public void a_(T t2) {
            this.b.a(t2);
            this.a.e();
        }

        public void b() {
            b.a.e.a.b.a(this.e);
        }

        @Override
        public void b_() {
            this.c = true;
            this.a.e();
        }
    }

}

