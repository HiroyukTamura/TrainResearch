/*
 * Decompiled with CFR 0.139.
 */
package c.a.e;

import c.a.e.c;
import c.a.e.k;
import d.e;
import d.f;
import d.l;
import d.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class d {
    static final c[] a = new c[]{new c(c.f, ""), new c(c.c, "GET"), new c(c.c, "POST"), new c(c.d, "/"), new c(c.d, "/index.html"), new c(c.e, "http"), new c(c.e, "https"), new c(c.b, "200"), new c(c.b, "204"), new c(c.b, "206"), new c(c.b, "304"), new c(c.b, "400"), new c(c.b, "404"), new c(c.b, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
    static final Map<f, Integer> b = d.a();

    static f a(f f2) {
        int n2 = f2.g();
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by2 = f2.a(i2);
            if (by2 < 65 || by2 > 90) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PROTOCOL_ERROR response malformed: mixed case name: ");
            stringBuilder.append(f2.a());
            throw new IOException(stringBuilder.toString());
        }
        return f2;
    }

    private static Map<f, Integer> a() {
        LinkedHashMap<f, Integer> linkedHashMap = new LinkedHashMap<f, Integer>(a.length);
        for (int i2 = 0; i2 < a.length; ++i2) {
            if (linkedHashMap.containsKey(d.a[i2].g)) continue;
            linkedHashMap.put(d.a[i2].g, i2);
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    static final class a {
        c[] a = new c[8];
        int b = this.a.length - 1;
        int c = 0;
        int d = 0;
        private final List<c> e = new ArrayList<c>();
        private final e f;
        private final int g;
        private int h;

        a(int n2, int n3, t t2) {
            this.g = n2;
            this.h = n3;
            this.f = l.a(t2);
        }

        a(int n2, t t2) {
            this(n2, n2, t2);
        }

        private int a(int n2) {
            int n3 = 0;
            int n4 = 0;
            if (n2 > 0) {
                int n5 = n2;
                n2 = n4;
                for (n3 = this.a.length - 1; n3 >= this.b && n5 > 0; --n3) {
                    n5 -= this.a[n3].i;
                    this.d -= this.a[n3].i;
                    --this.c;
                    ++n2;
                }
                System.arraycopy(this.a, this.b + 1, this.a, this.b + 1 + n2, this.c);
                this.b += n2;
                n3 = n2;
            }
            return n3;
        }

        private void a(int n2, c c2) {
            int n3;
            this.e.add(c2);
            int n4 = n3 = c2.i;
            if (n2 != -1) {
                n4 = n3 - this.a[this.c((int)n2)].i;
            }
            if (n4 > this.h) {
                this.e();
                return;
            }
            n3 = this.a(this.d + n4 - this.h);
            if (n2 == -1) {
                if (this.c + 1 > this.a.length) {
                    c[] arrc = new c[this.a.length * 2];
                    System.arraycopy(this.a, 0, arrc, this.a.length, this.a.length);
                    this.b = this.a.length - 1;
                    this.a = arrc;
                }
                n2 = this.b;
                this.b = n2 - 1;
                this.a[n2] = c2;
                ++this.c;
            } else {
                int n5 = this.c(n2);
                this.a[n2 + (n5 + n3)] = c2;
            }
            this.d += n4;
        }

        private void b(int n2) {
            if (this.g(n2)) {
                c c2 = d.a[n2];
                this.e.add(c2);
                return;
            }
            int n3 = this.c(n2 - d.a.length);
            if (n3 >= 0 && n3 < this.a.length) {
                this.e.add(this.a[n3]);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Header index too large ");
            stringBuilder.append(n2 + 1);
            throw new IOException(stringBuilder.toString());
        }

        private int c(int n2) {
            return this.b + 1 + n2;
        }

        private void d() {
            if (this.h < this.d) {
                if (this.h == 0) {
                    this.e();
                    return;
                }
                this.a(this.d - this.h);
            }
        }

        private void d(int n2) {
            f f2 = this.f(n2);
            f f3 = this.c();
            this.e.add(new c(f2, f3));
        }

        private void e() {
            Arrays.fill(this.a, null);
            this.b = this.a.length - 1;
            this.c = 0;
            this.d = 0;
        }

        private void e(int n2) {
            this.a(-1, new c(this.f(n2), this.c()));
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private f f(int n2) {
            c c2;
            if (this.g(n2)) {
                c2 = d.a[n2];
                do {
                    return c2.g;
                    break;
                } while (true);
            }
            int n3 = this.c(n2 - d.a.length);
            if (n3 >= 0 && n3 < this.a.length) {
                c2 = this.a[n3];
                return c2.g;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Header index too large ");
            stringBuilder.append(n2 + 1);
            throw new IOException(stringBuilder.toString());
        }

        private void f() {
            f f2 = d.a(this.c());
            f f3 = this.c();
            this.e.add(new c(f2, f3));
        }

        private void g() {
            this.a(-1, new c(d.a(this.c()), this.c()));
        }

        private boolean g(int n2) {
            return n2 >= 0 && n2 <= d.a.length - 1;
        }

        private int h() {
            return this.f.i() & 255;
        }

        int a(int n2, int n3) {
            int n4;
            if ((n2 &= n3) < n3) {
                return n2;
            }
            n2 = 0;
            while (((n4 = this.h()) & 128) != 0) {
                n3 += (n4 & 127) << n2;
                n2 += 7;
            }
            return n3 + (n4 << n2);
        }

        void a() {
            while (!this.f.f()) {
                int n2 = this.f.i() & 255;
                if (n2 != 128) {
                    if ((n2 & 128) == 128) {
                        this.b(this.a(n2, 127) - 1);
                        continue;
                    }
                    if (n2 == 64) {
                        this.g();
                        continue;
                    }
                    if ((n2 & 64) == 64) {
                        this.e(this.a(n2, 63) - 1);
                        continue;
                    }
                    if ((n2 & 32) == 32) {
                        this.h = this.a(n2, 31);
                        if (this.h >= 0 && this.h <= this.g) {
                            this.d();
                            continue;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid dynamic table size update ");
                        stringBuilder.append(this.h);
                        throw new IOException(stringBuilder.toString());
                    }
                    if (n2 != 16 && n2 != 0) {
                        this.d(this.a(n2, 15) - 1);
                        continue;
                    }
                    this.f();
                    continue;
                }
                throw new IOException("index == 0");
            }
        }

        public List<c> b() {
            ArrayList<c> arrayList = new ArrayList<c>(this.e);
            this.e.clear();
            return arrayList;
        }

        f c() {
            int n2 = this.h();
            boolean bl2 = (n2 & 128) == 128;
            n2 = this.a(n2, 127);
            if (bl2) {
                return f.a(k.a().a(this.f.h(n2)));
            }
            return this.f.d(n2);
        }
    }

    static final class b {
        int a;
        int b;
        c[] c = new c[8];
        int d = this.c.length - 1;
        int e = 0;
        int f = 0;
        private final d.c g;
        private final boolean h;
        private int i = Integer.MAX_VALUE;
        private boolean j;

        b(int n2, boolean bl2, d.c c2) {
            this.a = n2;
            this.b = n2;
            this.h = bl2;
            this.g = c2;
        }

        b(d.c c2) {
            this(4096, true, c2);
        }

        private void a() {
            Arrays.fill(this.c, null);
            this.d = this.c.length - 1;
            this.e = 0;
            this.f = 0;
        }

        private void a(c c2) {
            int n2 = c2.i;
            if (n2 > this.b) {
                this.a();
                return;
            }
            this.b(this.f + n2 - this.b);
            if (this.e + 1 > this.c.length) {
                c[] arrc = new c[this.c.length * 2];
                System.arraycopy(this.c, 0, arrc, this.c.length, this.c.length);
                this.d = this.c.length - 1;
                this.c = arrc;
            }
            int n3 = this.d;
            this.d = n3 - 1;
            this.c[n3] = c2;
            ++this.e;
            this.f += n2;
        }

        private int b(int n2) {
            int n3 = 0;
            int n4 = 0;
            if (n2 > 0) {
                int n5 = n2;
                n2 = n4;
                for (n3 = this.c.length - 1; n3 >= this.d && n5 > 0; --n3) {
                    n5 -= this.c[n3].i;
                    this.f -= this.c[n3].i;
                    --this.e;
                    ++n2;
                }
                System.arraycopy(this.c, this.d + 1, this.c, this.d + 1 + n2, this.e);
                Arrays.fill(this.c, this.d + 1, this.d + 1 + n2, null);
                this.d += n2;
                n3 = n2;
            }
            return n3;
        }

        private void b() {
            if (this.b < this.f) {
                if (this.b == 0) {
                    this.a();
                    return;
                }
                this.b(this.f - this.b);
            }
        }

        void a(int n2) {
            this.a = n2;
            if (this.b == (n2 = Math.min(n2, 16384))) {
                return;
            }
            if (n2 < this.b) {
                this.i = Math.min(this.i, n2);
            }
            this.j = true;
            this.b = n2;
            this.b();
        }

        /*
         * Enabled aggressive block sorting
         */
        void a(int n2, int n3, int n4) {
            d.c c2;
            if (n2 < n3) {
                c2 = this.g;
                n2 |= n4;
            } else {
                this.g.b(n4 | n3);
                n2 -= n3;
                while (n2 >= 128) {
                    this.g.b(128 | n2 & 127);
                    n2 >>>= 7;
                }
                c2 = this.g;
            }
            c2.b(n2);
        }

        void a(f f2) {
            int n2;
            int n3;
            if (this.h && k.a().a(f2) < f2.g()) {
                d.c c2 = new d.c();
                k.a().a(f2, c2);
                f2 = c2.o();
                n3 = f2.g();
                n2 = 128;
            } else {
                n3 = f2.g();
                n2 = 0;
            }
            this.a(n3, 127, n2);
            this.g.a(f2);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        void a(List<c> var1_1) {
            if (this.j) {
                if (this.i < this.b) {
                    this.a(this.i, 31, 32);
                }
                this.j = false;
                this.i = Integer.MAX_VALUE;
                this.a(this.b, 31, 32);
            }
            var8_2 = var1_1.size();
            var4_3 = 0;
            while (var4_3 < var8_2) {
                block17 : {
                    block18 : {
                        block16 : {
                            block15 : {
                                block14 : {
                                    var10_10 = var1_1.get(var4_3);
                                    var11_11 = var10_10.g.f();
                                    var12_12 = var10_10.h;
                                    var13_13 = d.b.get(var11_11);
                                    if (var13_13 == null) break block14;
                                    var3_5 = var13_13 + 1;
                                    if (var3_5 <= 1 || var3_5 >= 8) ** GOTO lbl-1000
                                    if (c.a.c.a(d.a[var3_5 - 1].h, (Object)var12_12)) {
                                        var2_4 = var3_5;
                                    } else if (c.a.c.a(d.a[var3_5].h, (Object)var12_12)) {
                                        var2_4 = var3_5++;
                                    } else lbl-1000: // 2 sources:
                                    {
                                        var2_4 = var3_5;
                                        var3_5 = -1;
                                    }
                                    break block15;
                                }
                                var3_5 = -1;
                                var2_4 = -1;
                            }
                            var6_7 = var3_5;
                            var7_8 = var2_4;
                            if (var3_5 == -1) {
                                var5_6 = this.d + 1;
                                var9_9 = this.c.length;
                                do {
                                    var6_7 = var3_5;
                                    var7_8 = var2_4;
                                    if (var5_6 >= var9_9) break;
                                    var6_7 = var2_4;
                                    if (c.a.c.a(this.c[var5_6].g, (Object)var11_11)) {
                                        if (c.a.c.a(this.c[var5_6].h, (Object)var12_12)) {
                                            var3_5 = this.d;
                                            var6_7 = d.a.length + (var5_6 - var3_5);
                                            var7_8 = var2_4;
                                            break;
                                        }
                                        var6_7 = var2_4;
                                        if (var2_4 == -1) {
                                            var6_7 = var5_6 - this.d + d.a.length;
                                        }
                                    }
                                    ++var5_6;
                                    var2_4 = var6_7;
                                } while (true);
                            }
                            if (var6_7 == -1) break block16;
                            this.a(var6_7, 127, 128);
                            break block17;
                        }
                        if (var7_8 != -1) break block18;
                        this.g.b(64);
                        this.a(var11_11);
                        ** GOTO lbl66
                    }
                    if (var11_11.a(c.a) && !c.f.equals(var11_11)) {
                        this.a(var7_8, 15, 0);
                        this.a(var12_12);
                    } else {
                        this.a(var7_8, 63, 64);
lbl66: // 2 sources:
                        this.a(var12_12);
                        this.a(var10_10);
                    }
                }
                ++var4_3;
            }
        }
    }

}

