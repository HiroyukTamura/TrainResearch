/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c.a.b;

import c.a.a;
import c.a.d;
import c.a.e.f;
import c.a.e.g;
import c.aa;
import c.ac;
import c.ae;
import c.b;
import c.e;
import c.g;
import c.h;
import c.i;
import c.j;
import c.k;
import c.p;
import c.r;
import c.s;
import c.t;
import c.u;
import c.x;
import c.y;
import d.l;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class c
extends g.b
implements i {
    public boolean a;
    public int b;
    public int c = 1;
    public final List<Reference<c.a.b.g>> d = new ArrayList<Reference<c.a.b.g>>();
    public long e = Long.MAX_VALUE;
    private final j g;
    private final ae h;
    private Socket i;
    private Socket j;
    private r k;
    private y l;
    private c.a.e.g m;
    private d.e n;
    private d.d o;

    public c(j j2, ae ae2) {
        this.g = j2;
        this.h = ae2;
    }

    private aa a(int n2, int n3, aa object, t object2) {
        block3 : {
            Object object3;
            block4 : {
                block5 : {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("CONNECT ");
                    ((StringBuilder)object3).append(c.a.c.a((t)object2, true));
                    ((StringBuilder)object3).append(" HTTP/1.1");
                    object2 = ((StringBuilder)object3).toString();
                    do {
                        long l2;
                        c.a.d.a a2 = new c.a.d.a(null, null, this.n, this.o);
                        this.n.a().a(n2, TimeUnit.MILLISECONDS);
                        this.o.a().a(n3, TimeUnit.MILLISECONDS);
                        a2.a(((aa)object).c(), (String)object2);
                        a2.b();
                        object3 = a2.a(false).a((aa)object).a();
                        long l3 = l2 = c.a.c.e.a((ac)object3);
                        if (l2 == -1L) {
                            l3 = 0L;
                        }
                        object = a2.b(l3);
                        c.a.c.b((d.t)object, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
                        object.close();
                        int n4 = ((ac)object3).b();
                        if (n4 == 200) break block3;
                        if (n4 != 407) break block4;
                        object = this.h.a().d().a(this.h, (ac)object3);
                        if (object == null) break block5;
                    } while (!"close".equalsIgnoreCase(((ac)object3).a("Connection")));
                    return object;
                }
                throw new IOException("Failed to authenticate with proxy");
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Unexpected response code for CONNECT: ");
            ((StringBuilder)object).append(((ac)object3).b());
            throw new IOException(((StringBuilder)object).toString());
        }
        if (this.n.c().f() && this.o.c().f()) {
            return null;
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
    }

    private void a(int n2, int n3, int n4, e e2, p p2) {
        aa aa2 = this.f();
        t t2 = aa2.a();
        for (int i2 = 0; i2 < 21; ++i2) {
            this.a(n2, n3, e2, p2);
            aa2 = this.a(n3, n4, aa2, t2);
            if (aa2 == null) {
                return;
            }
            c.a.c.a(this.i);
            this.i = null;
            this.o = null;
            this.n = null;
            p2.a(e2, this.h.c(), this.h.b(), null);
        }
    }

    private void a(int n2, int n3, e e2, p object) {
        Proxy proxy = this.h.b();
        Object object2 = this.h.a();
        object2 = proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.HTTP ? new Socket(proxy) : ((c.a)object2).c().createSocket();
        this.i = object2;
        ((p)object).a(e2, this.h.c(), proxy);
        this.i.setSoTimeout(n3);
        try {
            c.a.g.f.c().a(this.i, this.h.c(), n2);
        }
        catch (ConnectException connectException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Failed to connect to ");
            ((StringBuilder)object).append(this.h.c());
            object = new ConnectException(((StringBuilder)object).toString());
            ((Throwable)object).initCause(connectException);
            throw object;
        }
        try {
            this.n = l.a(l.b(this.i));
            this.o = l.a(l.a(this.i));
            return;
        }
        catch (NullPointerException nullPointerException) {
            if (!"throw with null exception".equals(nullPointerException.getMessage())) {
                return;
            }
            throw new IOException(nullPointerException);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void a(c.a.b.b object) {
        void var1_4;
        Object object2;
        block14 : {
            c.a a2 = this.h.a();
            object2 = a2.i();
            Object object3 = null;
            k k2 = null;
            Object var4_11 = null;
            object2 = (SSLSocket)((SSLSocketFactory)object2).createSocket(this.i, a2.a().f(), a2.a().g(), true);
            try {
                k2 = ((c.a.b.b)object).a((SSLSocket)object2);
                if (k2.d()) {
                    c.a.g.f.c().a((SSLSocket)object2, a2.a().f(), a2.e());
                }
                ((SSLSocket)object2).startHandshake();
                object = ((SSLSocket)object2).getSession();
                if (!this.a((SSLSession)object)) throw new IOException("a valid ssl session was not established");
                object3 = r.a((SSLSession)object);
                if (a2.j().verify(a2.a().f(), (SSLSession)object)) {
                    a2.k().a(a2.a().f(), ((r)object3).b());
                    object = var4_11;
                    if (k2.d()) {
                        object = c.a.g.f.c().a((SSLSocket)object2);
                    }
                    this.j = object2;
                    this.n = l.a(l.b(this.j));
                    this.o = l.a(l.a(this.j));
                    this.k = object3;
                    object = object != null ? y.a((String)object) : y.b;
                    this.l = object;
                    if (object2 == null) return;
                    c.a.g.f.c().b((SSLSocket)object2);
                    return;
                }
                object = (X509Certificate)((r)object3).b().get(0);
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Hostname ");
                ((StringBuilder)object3).append(a2.a().f());
                ((StringBuilder)object3).append(" not verified:\n    certificate: ");
                ((StringBuilder)object3).append(g.a((Certificate)object));
                ((StringBuilder)object3).append("\n    DN: ");
                ((StringBuilder)object3).append(((X509Certificate)object).getSubjectDN().getName());
                ((StringBuilder)object3).append("\n    subjectAltNames: ");
                ((StringBuilder)object3).append(c.a.i.d.a((X509Certificate)object));
                throw new SSLPeerUnverifiedException(((StringBuilder)object3).toString());
            }
            catch (Throwable throwable) {}
            catch (AssertionError assertionError) {
                object = object2;
                object2 = assertionError;
            }
            catch (Throwable throwable) {
                object2 = object3;
                break block14;
            }
            catch (AssertionError assertionError) {}
            object3 = object = k2;
            {
                if (c.a.c.a((AssertionError)object2)) {
                    object3 = object;
                    throw new IOException((Throwable)object2);
                }
                object3 = object;
                throw object2;
            }
        }
        if (object2 != null) {
            c.a.g.f.c().b((SSLSocket)object2);
        }
        c.a.c.a((Socket)object2);
        throw var1_4;
    }

    private void a(c.a.b.b b2, int n2, e e2, p p2) {
        if (this.h.a().i() == null) {
            this.l = y.b;
            this.j = this.i;
            return;
        }
        p2.b(e2);
        this.a(b2);
        p2.a(e2, this.k);
        if (this.l == y.d) {
            this.j.setSoTimeout(0);
            this.m = new g.a(true).a(this.j, this.h.a().a().f(), this.n, this.o).a(this).a(n2).a();
            this.m.c();
        }
    }

    private boolean a(SSLSession sSLSession) {
        return !"NONE".equals(sSLSession.getProtocol()) && !"SSL_NULL_WITH_NULL_NULL".equals(sSLSession.getCipherSuite());
    }

    private aa f() {
        return new aa.a().a(this.h.a().a()).a("Host", c.a.c.a(this.h.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", d.a()).a();
    }

    public c.a.c.c a(x x2, u.a a2, c.a.b.g g2) {
        if (this.m != null) {
            return new f(x2, a2, g2, this.m);
        }
        this.j.setSoTimeout(a2.c());
        this.n.a().a(a2.c(), TimeUnit.MILLISECONDS);
        this.o.a().a(a2.d(), TimeUnit.MILLISECONDS);
        return new c.a.d.a(x2, g2, this.n, this.o);
    }

    public ae a() {
        return this.h;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void a(int n2, int n3, int n4, int n5, boolean bl2, e object, p p2) {
        if (this.l != null) throw new IllegalStateException("already connected");
        Object object2 = this.h.a().f();
        c.a.b.b b2 = new c.a.b.b((List<k>)object2);
        if (this.h.a().i() == null) {
            if (!object2.contains(k.c)) throw new c.a.b.e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            object2 = this.h.a().a().f();
            if (!c.a.g.f.c().b((String)object2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("CLEARTEXT communication to ");
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(" not permitted by network security policy");
                throw new c.a.b.e(new UnknownServiceException(((StringBuilder)object).toString()));
            }
        }
        c.a.b.e e2 = null;
        do {
            block17 : {
                block16 : {
                    block15 : {
                        block14 : {
                            if (!this.h.d()) break block14;
                            this.a(n2, n3, n4, (e)object, p2);
                            object2 = this.i;
                            if (object2 != null) break block15;
                            break block16;
                        }
                        try {
                            this.a(n2, n3, (e)object, p2);
                        }
                        catch (IOException iOException3) {
                            break block17;
                        }
                    }
                    try {
                        this.a(b2, n5, (e)object, p2);
                        p2.a((e)object, this.h.c(), this.h.b(), this.l);
                    }
                    catch (IOException iOException) {}
                }
                if (this.h.d()) {
                    if (this.i == null) throw new c.a.b.e(new ProtocolException("Too many tunnel connections attempted: 21"));
                }
                if (this.m == null) return;
                object = this.g;
                // MONITORENTER : object
                this.c = this.m.a();
                // MONITOREXIT : object
                return;
                break block17;
                catch (IOException iOException2) {
                    // empty catch block
                }
            }
            c.a.c.a(this.j);
            c.a.c.a(this.i);
            this.j = null;
            this.i = null;
            this.n = null;
            this.o = null;
            this.k = null;
            this.l = null;
            this.m = null;
            p2.a((e)object, this.h.c(), this.h.b(), null, (IOException)object2);
            if (e2 == null) {
                e2 = new c.a.b.e((IOException)object2);
            } else {
                e2.a((IOException)object2);
            }
            if (!bl2) throw e2;
            if (!b2.a((IOException)object2)) throw e2;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(c.a.e.g g2) {
        j j2 = this.g;
        synchronized (j2) {
            this.c = g2.a();
            return;
        }
    }

    @Override
    public void a(c.a.e.i i2) {
        i2.a(c.a.e.b.e);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean a(c.a a2, @Nullable ae ae2) {
        if (this.d.size() >= this.c) return false;
        if (this.a) {
            return false;
        }
        if (!a.a.a(this.h.a(), a2)) {
            return false;
        }
        if (a2.a().f().equals(this.a().a().a().f())) {
            return true;
        }
        if (this.m == null) {
            return false;
        }
        if (ae2 == null) {
            return false;
        }
        if (ae2.b().type() != Proxy.Type.DIRECT) {
            return false;
        }
        if (this.h.b().type() != Proxy.Type.DIRECT) {
            return false;
        }
        if (!this.h.c().equals(ae2.c())) {
            return false;
        }
        if (ae2.a().j() != c.a.i.d.a) {
            return false;
        }
        if (!this.a(a2.a())) {
            return false;
        }
        try {
            a2.k().a(a2.a().f(), this.d().b());
            return true;
        }
        catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
            return false;
        }
    }

    public boolean a(t t2) {
        if (t2.g() != this.h.a().a().g()) {
            return false;
        }
        boolean bl2 = t2.f().equals(this.h.a().a().f());
        boolean bl3 = true;
        if (!bl2) {
            if (this.k != null && c.a.i.d.a.a(t2.f(), (X509Certificate)this.k.b().get(0))) {
                return true;
            }
            bl3 = false;
        }
        return bl3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean a(boolean bl2) {
        int n2;
        block10 : {
            if (this.j.isClosed() || this.j.isInputShutdown()) return false;
            if (this.j.isOutputShutdown()) {
                return false;
            }
            if (this.m != null) {
                return this.m.d() ^ true;
            }
            if (!bl2) return true;
            n2 = this.j.getSoTimeout();
            try {
                this.j.setSoTimeout(1);
                bl2 = this.n.f();
                if (!bl2) break block10;
            }
            catch (Throwable throwable) {
                try {
                    this.j.setSoTimeout(n2);
                    throw throwable;
                }
                catch (SocketTimeoutException socketTimeoutException) {
                    return true;
                }
                catch (IOException iOException) {
                    return false;
                }
            }
            this.j.setSoTimeout(n2);
            return false;
        }
        this.j.setSoTimeout(n2);
        return true;
    }

    public void b() {
        c.a.c.a(this.i);
    }

    public Socket c() {
        return this.j;
    }

    public r d() {
        return this.k;
    }

    public boolean e() {
        return this.m != null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Connection{");
        stringBuilder.append(this.h.a().a().f());
        stringBuilder.append(":");
        stringBuilder.append(this.h.a().a().g());
        stringBuilder.append(", proxy=");
        stringBuilder.append(this.h.b());
        stringBuilder.append(" hostAddress=");
        stringBuilder.append(this.h.c());
        stringBuilder.append(" cipherSuite=");
        Object object = this.k != null ? this.k.a() : "none";
        stringBuilder.append(object);
        stringBuilder.append(" protocol=");
        stringBuilder.append((Object)this.l);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

