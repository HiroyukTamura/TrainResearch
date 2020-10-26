/*
 * Decompiled with CFR 0.139.
 */
package c.a.a;

import c.a.a.b;
import c.a.a.c;
import c.a.a.e;
import c.a.c;
import c.a.c.f;
import c.a.c.h;
import c.aa;
import c.ac;
import c.ad;
import c.s;
import c.u;
import c.y;
import d.d;
import d.l;
import d.t;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class a
implements u {
    final e a;

    public a(e e2) {
        this.a = e2;
    }

    private ac a(b object, ac ac2) {
        if (object == null) {
            return ac2;
        }
        Object object2 = object.a();
        if (object2 == null) {
            return ac2;
        }
        object = new t(ac2.g().d(), (b)object, l.a((d.s)object2)){
            boolean a;
            final /* synthetic */ d.e b;
            final /* synthetic */ b c;
            final /* synthetic */ d d;
            {
                this.b = e2;
                this.c = b2;
                this.d = d2;
            }

            @Override
            public long a(d.c c2, long l2) {
                block3 : {
                    block4 : {
                        try {
                            l2 = this.b.a(c2, l2);
                            if (l2 != -1L) break block3;
                            if (this.a) break block4;
                            this.a = true;
                        }
                        catch (IOException iOException) {
                            if (!this.a) {
                                this.a = true;
                                this.c.b();
                            }
                            throw iOException;
                        }
                        this.d.close();
                    }
                    return -1L;
                }
                c2.a(this.d.c(), c2.b() - l2, l2);
                this.d.v();
                return l2;
            }

            @Override
            public d.u a() {
                return this.b.a();
            }

            @Override
            public void close() {
                if (!this.a && !c.a(this, 100, TimeUnit.MILLISECONDS)) {
                    this.a = true;
                    this.c.b();
                }
                this.b.close();
            }
        };
        object2 = ac2.a("Content-Type");
        long l2 = ac2.g().b();
        return ac2.h().a(new h((String)object2, l2, l.a((t)object))).a();
    }

    private static ac a(ac ac2) {
        ac ac3 = ac2;
        if (ac2 != null) {
            ac3 = ac2;
            if (ac2.g() != null) {
                ac3 = ac2.h().a((ad)null).a();
            }
        }
        return ac3;
    }

    private static s a(s object, s s2) {
        int n2;
        s.a a2 = new s.a();
        int n3 = ((s)object).a();
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            String string2 = ((s)object).a(n2);
            String string3 = ((s)object).b(n2);
            if ("Warning".equalsIgnoreCase(string2) && string3.startsWith("1") || !a.b(string2) && a.a(string2) && s2.a(string2) != null) continue;
            c.a.a.a.a(a2, string2, string3);
        }
        n3 = s2.a();
        for (n2 = n4; n2 < n3; ++n2) {
            object = s2.a(n2);
            if (a.b((String)object) || !a.a((String)object)) continue;
            c.a.a.a.a(a2, (String)object, s2.b(n2));
        }
        return a2.a();
    }

    static boolean a(String string2) {
        return !"Connection".equalsIgnoreCase(string2) && !"Keep-Alive".equalsIgnoreCase(string2) && !"Proxy-Authenticate".equalsIgnoreCase(string2) && !"Proxy-Authorization".equalsIgnoreCase(string2) && !"TE".equalsIgnoreCase(string2) && !"Trailers".equalsIgnoreCase(string2) && !"Transfer-Encoding".equalsIgnoreCase(string2) && !"Upgrade".equalsIgnoreCase(string2);
    }

    static boolean b(String string2) {
        return "Content-Length".equalsIgnoreCase(string2) || "Content-Encoding".equalsIgnoreCase(string2) || "Content-Type".equalsIgnoreCase(string2);
        {
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public ac a(u.a object) {
        aa aa2;
        ac ac3;
        ac ac2;
        block11 : {
            ac2 = this.a != null ? this.a.a(object.a()) : null;
            c.a.a.c c2 = new c.a(System.currentTimeMillis(), object.a(), ac2).a();
            aa2 = c2.a;
            ac3 = c2.b;
            if (this.a != null) {
                this.a.a(c2);
            }
            if (ac2 != null && ac3 == null) {
                c.a(ac2.g());
            }
            if (aa2 == null && ac3 == null) {
                return new ac.a().a(object.a()).a(y.b).a(504).a("Unsatisfiable Request (only-if-cached)").a(c.c).a(-1L).b(System.currentTimeMillis()).a();
            }
            if (aa2 == null) {
                return ac3.h().b(a.a(ac3)).a();
            }
            try {
                object = object.a(aa2);
                if (object != null || ac2 == null) break block11;
            }
            catch (Throwable throwable) {
                if (ac2 == null) throw throwable;
                c.a(ac2.g());
                throw throwable;
            }
            c.a(ac2.g());
        }
        if (ac3 != null) {
            if (((ac)object).b() == 304) {
                ac2 = ac3.h().a(a.a(ac3.f(), ((ac)object).f())).a(((ac)object).k()).b(((ac)object).l()).b(a.a(ac3)).a(a.a((ac)object)).a();
                ((ac)object).g().close();
                this.a.a();
                this.a.a(ac3, ac2);
                return ac2;
            }
            c.a(ac3.g());
        }
        object = ((ac)object).h().b(a.a(ac3)).a(a.a((ac)object)).a();
        if (this.a == null) return object;
        if (c.a.c.e.b((ac)object) && c.a.a.c.a((ac)object, aa2)) {
            return this.a(this.a.a((ac)object), (ac)object);
        }
        if (!f.a(aa2.b())) return object;
        try {
            this.a.b(aa2);
        }
        catch (IOException iOException) {
            return object;
        }
        return object;
    }

}

