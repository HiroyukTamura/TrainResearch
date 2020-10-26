/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a.a.e;
import c.a.g.f;
import c.a.i.c;
import c.a.i.d;
import c.aa;
import c.ac;
import c.ae;
import c.b;
import c.e;
import c.g;
import c.j;
import c.k;
import c.m;
import c.n;
import c.o;
import c.p;
import c.s;
import c.u;
import c.y;
import c.z;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class x
implements e.a,
Cloneable {
    static final List<y> a = c.a.c.a(new y[]{y.d, y.b});
    static final List<k> b = c.a.c.a(new k[]{k.a, k.c});
    final int A;
    final int B;
    final int C;
    final n c;
    @Nullable
    final Proxy d;
    final List<y> e;
    final List<k> f;
    final List<u> g;
    final List<u> h;
    final p.a i;
    final ProxySelector j;
    final m k;
    @Nullable
    final c.c l;
    @Nullable
    final e m;
    final SocketFactory n;
    @Nullable
    final SSLSocketFactory o;
    @Nullable
    final c p;
    final HostnameVerifier q;
    final g r;
    final b s;
    final b t;
    final j u;
    final o v;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    static {
        c.a.a.a = new c.a.a(){

            @Override
            public int a(ac.a a2) {
                return a2.c;
            }

            @Override
            public c.a.b.c a(j j2, c.a a2, c.a.b.g g2, ae ae2) {
                return j2.a(a2, g2, ae2);
            }

            @Override
            public c.a.b.d a(j j2) {
                return j2.a;
            }

            @Override
            public Socket a(j j2, c.a a2, c.a.b.g g2) {
                return j2.a(a2, g2);
            }

            @Override
            public void a(k k2, SSLSocket sSLSocket, boolean bl2) {
                k2.a(sSLSocket, bl2);
            }

            @Override
            public void a(s.a a2, String string2) {
                a2.a(string2);
            }

            @Override
            public void a(s.a a2, String string2, String string3) {
                a2.b(string2, string3);
            }

            @Override
            public boolean a(c.a a2, c.a a3) {
                return a2.a(a3);
            }

            @Override
            public boolean a(j j2, c.a.b.c c2) {
                return j2.b(c2);
            }

            @Override
            public void b(j j2, c.a.b.c c2) {
                j2.a(c2);
            }
        };
    }

    public x() {
        this(new a());
    }

    x(a object) {
        boolean bl2;
        this.c = ((a)object).a;
        this.d = ((a)object).b;
        this.e = ((a)object).c;
        this.f = ((a)object).d;
        this.g = c.a.c.a(((a)object).e);
        this.h = c.a.c.a(((a)object).f);
        this.i = ((a)object).g;
        this.j = ((a)object).h;
        this.k = ((a)object).i;
        this.l = ((a)object).j;
        this.m = ((a)object).k;
        this.n = ((a)object).l;
        Object object2 = this.f.iterator();
        block0 : do {
            bl2 = false;
            while (object2.hasNext()) {
                k k2 = object2.next();
                if (!bl2 && !k2.a()) continue block0;
                bl2 = true;
            }
            break;
        } while (true);
        if (((a)object).m == null && bl2) {
            object2 = this.z();
            this.o = this.a((X509TrustManager)object2);
            object2 = c.a((X509TrustManager)object2);
        } else {
            this.o = ((a)object).m;
            object2 = ((a)object).n;
        }
        this.p = object2;
        this.q = ((a)object).o;
        this.r = ((a)object).p.a(this.p);
        this.s = ((a)object).q;
        this.t = ((a)object).r;
        this.u = ((a)object).s;
        this.v = ((a)object).t;
        this.w = ((a)object).u;
        this.x = ((a)object).v;
        this.y = ((a)object).w;
        this.z = ((a)object).x;
        this.A = ((a)object).y;
        this.B = ((a)object).z;
        this.C = ((a)object).A;
        if (!this.g.contains(null)) {
            if (!this.h.contains(null)) {
                return;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Null network interceptor: ");
            ((StringBuilder)object).append(this.h);
            throw new IllegalStateException(((StringBuilder)object).toString());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Null interceptor: ");
        ((StringBuilder)object).append(this.g);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    private SSLSocketFactory a(X509TrustManager object) {
        try {
            SSLContext sSLContext = f.c().x_();
            sSLContext.init(null, new TrustManager[]{object}, null);
            object = sSLContext.getSocketFactory();
            return object;
        }
        catch (GeneralSecurityException generalSecurityException) {
            throw c.a.c.a("No System TLS", generalSecurityException);
        }
    }

    private X509TrustManager z() {
        try {
            Object[] arrobject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            arrobject.init((KeyStore)null);
            arrobject = arrobject.getTrustManagers();
            if (arrobject.length == 1 && arrobject[0] instanceof X509TrustManager) {
                return (X509TrustManager)arrobject[0];
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected default trust managers:");
            stringBuilder.append(Arrays.toString(arrobject));
            throw new IllegalStateException(stringBuilder.toString());
        }
        catch (GeneralSecurityException generalSecurityException) {
            throw c.a.c.a("No System TLS", generalSecurityException);
        }
    }

    public int a() {
        return this.z;
    }

    @Override
    public c.e a(aa aa2) {
        return z.a(this, aa2, false);
    }

    public int b() {
        return this.A;
    }

    public int c() {
        return this.B;
    }

    public int d() {
        return this.C;
    }

    public Proxy e() {
        return this.d;
    }

    public ProxySelector f() {
        return this.j;
    }

    public m g() {
        return this.k;
    }

    e h() {
        if (this.l != null) {
            return this.l.a;
        }
        return this.m;
    }

    public o i() {
        return this.v;
    }

    public SocketFactory j() {
        return this.n;
    }

    public SSLSocketFactory k() {
        return this.o;
    }

    public HostnameVerifier l() {
        return this.q;
    }

    public g m() {
        return this.r;
    }

    public b n() {
        return this.t;
    }

    public b o() {
        return this.s;
    }

    public j p() {
        return this.u;
    }

    public boolean q() {
        return this.w;
    }

    public boolean r() {
        return this.x;
    }

    public boolean s() {
        return this.y;
    }

    public n t() {
        return this.c;
    }

    public List<y> u() {
        return this.e;
    }

    public List<k> v() {
        return this.f;
    }

    public List<u> w() {
        return this.g;
    }

    public List<u> x() {
        return this.h;
    }

    public p.a y() {
        return this.i;
    }

    public static final class a {
        int A = 0;
        n a = new n();
        @Nullable
        Proxy b;
        List<y> c = x.a;
        List<k> d = x.b;
        final List<u> e = new ArrayList<u>();
        final List<u> f = new ArrayList<u>();
        p.a g = p.a(p.a);
        ProxySelector h = ProxySelector.getDefault();
        m i = m.a;
        @Nullable
        c.c j;
        @Nullable
        e k;
        SocketFactory l = SocketFactory.getDefault();
        @Nullable
        SSLSocketFactory m;
        @Nullable
        c n;
        HostnameVerifier o = d.a;
        g p = g.a;
        b q = b.a;
        b r = b.a;
        j s = new j();
        o t = o.a;
        boolean u = true;
        boolean v = true;
        boolean w = true;
        int x = 10000;
        int y = 10000;
        int z = 10000;
    }

}

