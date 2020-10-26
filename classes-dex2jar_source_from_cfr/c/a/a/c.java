/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c.a.a;

import c.a.c.e;
import c.aa;
import c.ac;
import c.d;
import c.r;
import c.s;
import c.t;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class c {
    @Nullable
    public final aa a;
    @Nullable
    public final ac b;

    c(aa aa2, ac ac2) {
        this.a = aa2;
        this.b = ac2;
    }

    public static boolean a(ac ac2, aa aa2) {
        boolean bl2;
        int n2 = ac2.b();
        boolean bl3 = false;
        switch (n2) {
            default: {
                return false;
            }
            case 302: 
            case 307: {
                if (ac2.a("Expires") == null && ac2.j().c() == -1 && !ac2.j().e()) {
                    bl2 = bl3;
                    if (!ac2.j().d()) break;
                }
            }
            case 200: 
            case 203: 
            case 204: 
            case 300: 
            case 301: 
            case 308: 
            case 404: 
            case 405: 
            case 410: 
            case 414: 
            case 501: {
                bl2 = bl3;
                if (ac2.j().b()) break;
                bl2 = bl3;
                if (aa2.f().b()) break;
                bl2 = true;
            }
        }
        return bl2;
    }

    public static class a {
        final long a;
        final aa b;
        final ac c;
        private Date d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l = -1;

        public a(long l2, aa object, ac object2) {
            this.a = l2;
            this.b = object;
            this.c = object2;
            if (object2 != null) {
                this.i = ((ac)object2).k();
                this.j = ((ac)object2).l();
                object = ((ac)object2).f();
                int n2 = ((s)object).a();
                for (int i2 = 0; i2 < n2; ++i2) {
                    object2 = ((s)object).a(i2);
                    String string2 = ((s)object).b(i2);
                    if ("Date".equalsIgnoreCase((String)object2)) {
                        this.d = c.a.c.d.a(string2);
                        this.e = string2;
                        continue;
                    }
                    if ("Expires".equalsIgnoreCase((String)object2)) {
                        this.h = c.a.c.d.a(string2);
                        continue;
                    }
                    if ("Last-Modified".equalsIgnoreCase((String)object2)) {
                        this.f = c.a.c.d.a(string2);
                        this.g = string2;
                        continue;
                    }
                    if ("ETag".equalsIgnoreCase((String)object2)) {
                        this.k = string2;
                        continue;
                    }
                    if (!"Age".equalsIgnoreCase((String)object2)) continue;
                    this.l = e.b(string2, -1);
                }
            }
        }

        private static boolean a(aa aa2) {
            return aa2.a("If-Modified-Since") != null || aa2.a("If-None-Match") != null;
            {
            }
        }

        private c b() {
            block13 : {
                block17 : {
                    Object object;
                    Object object2;
                    block15 : {
                        block16 : {
                            block14 : {
                                long l2;
                                if (this.c == null) {
                                    return new c(this.b, null);
                                }
                                if (this.b.g() && this.c.e() == null) {
                                    return new c(this.b, null);
                                }
                                if (!c.a(this.c, this.b)) {
                                    return new c(this.b, null);
                                }
                                object2 = this.b.f();
                                if (((d)object2).a() || a.a(this.b)) break block13;
                                object = this.c.j();
                                if (((d)object).j()) {
                                    return new c(null, this.c);
                                }
                                long l3 = this.d();
                                long l4 = l2 = this.c();
                                if (((d)object2).c() != -1) {
                                    l4 = Math.min(l2, TimeUnit.SECONDS.toMillis(((d)object2).c()));
                                }
                                int n2 = ((d)object2).h();
                                long l5 = 0L;
                                l2 = n2 != -1 ? TimeUnit.SECONDS.toMillis(((d)object2).h()) : 0L;
                                long l6 = l5;
                                if (!((d)object).f()) {
                                    l6 = l5;
                                    if (((d)object2).g() != -1) {
                                        l6 = TimeUnit.SECONDS.toMillis(((d)object2).g());
                                    }
                                }
                                if (!((d)object).a() && (l2 += l3) < l6 + l4) {
                                    object2 = this.c.h();
                                    if (l2 >= l4) {
                                        ((ac.a)object2).a("Warning", "110 HttpURLConnection \"Response is stale\"");
                                    }
                                    if (l3 > 86400000L && this.e()) {
                                        ((ac.a)object2).a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                                    }
                                    return new c(null, ((ac.a)object2).a());
                                }
                                if (this.k == null) break block14;
                                object2 = "If-None-Match";
                                object = this.k;
                                break block15;
                            }
                            if (this.f == null) break block16;
                            object2 = "If-Modified-Since";
                            object = this.g;
                            break block15;
                        }
                        if (this.d == null) break block17;
                        object2 = "If-Modified-Since";
                        object = this.e;
                    }
                    s.a a2 = this.b.c().b();
                    c.a.a.a.a(a2, (String)object2, (String)object);
                    return new c(this.b.e().a(a2.a()).a(), this.c);
                }
                return new c(this.b, null);
            }
            return new c(this.b, null);
        }

        private long c() {
            Object object = this.c.j();
            if (((d)object).c() != -1) {
                return TimeUnit.SECONDS.toMillis(((d)object).c());
            }
            object = this.h;
            long l2 = 0L;
            if (object != null) {
                long l3 = this.d != null ? this.d.getTime() : this.j;
                l3 = this.h.getTime() - l3;
                if (l3 > 0L) {
                    l2 = l3;
                }
                return l2;
            }
            long l4 = l2;
            if (this.f != null) {
                l4 = l2;
                if (this.c.a().a().l() == null) {
                    l4 = this.d != null ? this.d.getTime() : this.i;
                    long l5 = l4 - this.f.getTime();
                    l4 = l2;
                    if (l5 > 0L) {
                        l4 = l5 / 10L;
                    }
                }
            }
            return l4;
        }

        private long d() {
            Date date = this.d;
            long l2 = 0L;
            if (date != null) {
                l2 = Math.max(0L, this.j - this.d.getTime());
            }
            long l3 = l2;
            if (this.l != -1) {
                l3 = Math.max(l2, TimeUnit.SECONDS.toMillis(this.l));
            }
            return l3 + (this.j - this.i) + (this.a - this.j);
        }

        private boolean e() {
            return this.c.j().c() == -1 && this.h == null;
        }

        public c a() {
            c c2;
            c c3 = c2 = this.b();
            if (c2.a != null) {
                c3 = c2;
                if (this.b.f().i()) {
                    c3 = new c(null, null);
                }
            }
            return c3;
        }
    }

}

