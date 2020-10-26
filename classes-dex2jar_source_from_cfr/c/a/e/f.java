/*
 * Decompiled with CFR 0.139.
 */
package c.a.e;

import c.a.c.h;
import c.a.c.k;
import c.a.e.b;
import c.a.e.c;
import c.a.e.g;
import c.a.e.i;
import c.aa;
import c.ab;
import c.ac;
import c.ad;
import c.e;
import c.p;
import c.s;
import c.t;
import c.u;
import c.x;
import c.y;
import d.l;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class f
implements c.a.c.c {
    private static final d.f b = d.f.a("connection");
    private static final d.f c = d.f.a("host");
    private static final d.f d = d.f.a("keep-alive");
    private static final d.f e = d.f.a("proxy-connection");
    private static final d.f f = d.f.a("transfer-encoding");
    private static final d.f g = d.f.a("te");
    private static final d.f h = d.f.a("encoding");
    private static final d.f i = d.f.a("upgrade");
    private static final List<d.f> j = c.a.c.a(b, c, d, e, g, f, h, i, c.c, c.d, c.e, c.f);
    private static final List<d.f> k = c.a.c.a(b, c, d, e, g, f, h, i);
    final c.a.b.g a;
    private final x l;
    private final u.a m;
    private final g n;
    private i o;

    public f(x x2, u.a a2, c.a.b.g g2, g g3) {
        this.l = x2;
        this.m = a2;
        this.a = g2;
        this.n = g3;
    }

    public static ac.a a(List<c> list) {
        s.a a2 = new s.a();
        int n2 = list.size();
        c c2 = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            s.a a3;
            Object object = list.get(i2);
            if (object == null) {
                object = c2;
                a3 = a2;
                if (c2 != null) {
                    object = c2;
                    a3 = a2;
                    if (((k)c2).b == 100) {
                        a3 = new s.a();
                        object = null;
                    }
                }
            } else {
                d.f f2 = ((c)object).g;
                String string2 = ((c)object).h.a();
                if (f2.equals(c.b)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("HTTP/1.1 ");
                    ((StringBuilder)object).append(string2);
                    object = k.a(((StringBuilder)object).toString());
                    a3 = a2;
                } else {
                    object = c2;
                    a3 = a2;
                    if (!k.contains(f2)) {
                        c.a.a.a.a(a2, f2.a(), string2);
                        a3 = a2;
                        object = c2;
                    }
                }
            }
            c2 = object;
            a2 = a3;
        }
        if (c2 != null) {
            return new ac.a().a(y.d).a(((k)c2).b).a(((k)c2).c).a(a2.a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public static List<c> b(aa object) {
        s s2 = ((aa)object).c();
        ArrayList<c> arrayList = new ArrayList<c>(s2.a() + 4);
        arrayList.add(new c(c.c, ((aa)object).b()));
        arrayList.add(new c(c.d, c.a.c.i.a(((aa)object).a())));
        String string2 = ((aa)object).a("Host");
        if (string2 != null) {
            arrayList.add(new c(c.f, string2));
        }
        arrayList.add(new c(c.e, ((aa)object).a().b()));
        int n2 = s2.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            object = d.f.a(s2.a(i2).toLowerCase(Locale.US));
            if (j.contains(object)) continue;
            arrayList.add(new c((d.f)object, s2.b(i2)));
        }
        return arrayList;
    }

    @Override
    public ac.a a(boolean bl2) {
        ac.a a2 = f.a(this.o.d());
        if (bl2 && c.a.a.a.a(a2) == 100) {
            return null;
        }
        return a2;
    }

    @Override
    public ad a(ac ac2) {
        this.a.c.f(this.a.b);
        return new h(ac2.a("Content-Type"), c.a.c.e.a(ac2), l.a(new a(this.o.g())));
    }

    @Override
    public d.s a(aa aa2, long l2) {
        return this.o.h();
    }

    @Override
    public void a() {
        this.n.b();
    }

    @Override
    public void a(aa object) {
        if (this.o != null) {
            return;
        }
        boolean bl2 = ((aa)object).d() != null;
        object = f.b((aa)object);
        this.o = this.n.a((List<c>)object, bl2);
        this.o.e().a(this.m.c(), TimeUnit.MILLISECONDS);
        this.o.f().a(this.m.d(), TimeUnit.MILLISECONDS);
    }

    @Override
    public void b() {
        this.o.h().close();
    }

    @Override
    public void c() {
        if (this.o != null) {
            this.o.b(b.f);
        }
    }

    class a
    extends d.h {
        boolean a;
        long b;

        a(d.t t2) {
            super(t2);
            this.a = false;
            this.b = 0L;
        }

        private void a(IOException iOException) {
            if (this.a) {
                return;
            }
            this.a = true;
            f.this.a.a(false, f.this, this.b, iOException);
        }

        @Override
        public long a(d.c c2, long l2) {
            block3 : {
                try {
                    l2 = this.b().a(c2, l2);
                    if (l2 <= 0L) break block3;
                }
                catch (IOException iOException) {
                    this.a(iOException);
                    throw iOException;
                }
                this.b += l2;
            }
            return l2;
        }

        @Override
        public void close() {
            super.close();
            this.a(null);
        }
    }

}

