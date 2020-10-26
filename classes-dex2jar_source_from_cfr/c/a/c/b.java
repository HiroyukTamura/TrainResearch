/*
 * Decompiled with CFR 0.139.
 */
package c.a.c;

import c.a.c;
import c.a.c.f;
import c.a.c.g;
import c.aa;
import c.ab;
import c.ac;
import c.ad;
import c.e;
import c.i;
import c.p;
import c.r;
import c.u;
import d.d;
import d.l;
import d.s;
import java.net.ProtocolException;

public final class b
implements u {
    private final boolean a;

    public b(boolean bl2) {
        this.a = bl2;
    }

    @Override
    public ac a(u.a object) {
        int n2;
        g g2 = (g)object;
        c.a.c.c c2 = g2.g();
        c.a.b.g g3 = g2.f();
        c.a.b.c c3 = (c.a.b.c)g2.e();
        aa aa2 = g2.a();
        long l2 = System.currentTimeMillis();
        g2.i().c(g2.h());
        c2.a(aa2);
        g2.i().a(g2.h(), aa2);
        boolean bl2 = f.c(aa2.b());
        d d2 = null;
        Object object2 = null;
        object = d2;
        if (bl2) {
            object = d2;
            if (aa2.d() != null) {
                if ("100-continue".equalsIgnoreCase(aa2.a("Expect"))) {
                    c2.a();
                    g2.i().e(g2.h());
                    object2 = c2.a(true);
                }
                if (object2 == null) {
                    g2.i().d(g2.h());
                    object = new a(c2.a(aa2, aa2.d().b()));
                    d2 = l.a((s)object);
                    aa2.d().a(d2);
                    d2.close();
                    g2.i().a(g2.h(), ((a)object).a);
                    object = object2;
                } else {
                    object = object2;
                    if (!c3.e()) {
                        g3.e();
                        object = object2;
                    }
                }
            }
        }
        c2.b();
        object2 = object;
        if (object == null) {
            g2.i().e(g2.h());
            object2 = c2.a(false);
        }
        object = ((ac.a)object2).a(aa2).a(g3.c().d()).a(l2).b(System.currentTimeMillis()).a();
        int n3 = n2 = ((ac)object).b();
        if (n2 == 100) {
            object = c2.a(false).a(aa2).a(g3.c().d()).a(l2).b(System.currentTimeMillis()).a();
            n3 = ((ac)object).b();
        }
        g2.i().a(g2.h(), (ac)object);
        if (this.a && n3 == 101) {
            object2 = ((ac)object).h();
            object = c.c;
        } else {
            object2 = ((ac)object).h();
            object = c2.a((ac)object);
        }
        object = ((ac.a)object2).a((ad)object).a();
        if ("close".equalsIgnoreCase(((ac)object).a().a("Connection")) || "close".equalsIgnoreCase(((ac)object).a("Connection"))) {
            g3.e();
        }
        if (n3 != 204 && n3 != 205 || ((ac)object).g().b() <= 0L) {
            return object;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("HTTP ");
        ((StringBuilder)object2).append(n3);
        ((StringBuilder)object2).append(" had non-zero Content-Length: ");
        ((StringBuilder)object2).append(((ac)object).g().b());
        throw new ProtocolException(((StringBuilder)object2).toString());
    }

    static final class a
    extends d.g {
        long a;

        a(s s2) {
            super(s2);
        }

        @Override
        public void a_(d.c c2, long l2) {
            super.a_(c2, l2);
            this.a += l2;
        }
    }

}

