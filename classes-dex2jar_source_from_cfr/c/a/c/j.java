/*
 * Decompiled with CFR 0.139.
 */
package c.a.c;

import c.a;
import c.a.c;
import c.a.c.f;
import c.a.c.g;
import c.a.c.l;
import c.aa;
import c.ab;
import c.ac;
import c.ad;
import c.ae;
import c.b;
import c.e;
import c.k;
import c.o;
import c.p;
import c.t;
import c.u;
import c.x;
import c.y;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class j
implements u {
    private final x a;
    private final boolean b;
    private volatile c.a.b.g c;
    private Object d;
    private volatile boolean e;

    public j(x x2, boolean bl2) {
        this.a = x2;
        this.b = bl2;
    }

    private int a(ac object, int n2) {
        if ((object = ((ac)object).a("Retry-After")) == null) {
            return n2;
        }
        if (((String)object).matches("\\d+")) {
            return Integer.valueOf((String)object);
        }
        return Integer.MAX_VALUE;
    }

    private a a(t t2) {
        HostnameVerifier hostnameVerifier;
        Object object;
        Object object2;
        if (t2.c()) {
            object = this.a.k();
            hostnameVerifier = this.a.l();
            c.g g2 = this.a.m();
            object2 = g2;
        } else {
            HostnameVerifier hostnameVerifier2;
            hostnameVerifier = hostnameVerifier2 = null;
            object2 = hostnameVerifier;
            object = hostnameVerifier2;
        }
        return new a(t2.f(), t2.g(), this.a.i(), this.a.j(), (SSLSocketFactory)object, hostnameVerifier, (c.g)object2, this.a.o(), this.a.e(), this.a.u(), this.a.v(), this.a.f());
    }

    /*
     * Enabled aggressive block sorting
     */
    private aa a(ac ac2, ae object) {
        if (ac2 == null) {
            throw new IllegalStateException();
        }
        int n2 = ac2.b();
        String string2 = ac2.a().b();
        Object object2 = null;
        switch (n2) {
            default: {
                return null;
            }
            case 503: {
                if (ac2.i() != null && ac2.i().b() == 503) {
                    return null;
                }
                if (this.a(ac2, Integer.MAX_VALUE) == 0) {
                    return ac2.a();
                }
                return null;
            }
            case 408: {
                if (!this.a.s()) {
                    return null;
                }
                if (ac2.a().d() instanceof l) {
                    return null;
                }
                if (ac2.i() != null && ac2.i().b() == 408) {
                    return null;
                }
                if (this.a(ac2, 0) > 0) {
                    return null;
                }
                return ac2.a();
            }
            case 407: {
                object2 = object != null ? ((ae)object).b() : this.a.e();
                if (((Proxy)object2).type() == Proxy.Type.HTTP) {
                    return this.a.o().a((ae)object, ac2);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            case 401: {
                return this.a.n().a((ae)object, ac2);
            }
            case 307: 
            case 308: {
                if (string2.equals("GET") || string2.equals("HEAD")) break;
                return null;
            }
            case 300: 
            case 301: 
            case 302: 
            case 303: 
        }
        if (!this.a.r()) {
            return null;
        }
        object = ac2.a("Location");
        if (object == null) {
            return null;
        }
        t t2 = ac2.a().a().c((String)object);
        if (t2 == null) {
            return null;
        }
        if (!t2.b().equals(ac2.a().a().b()) && !this.a.q()) {
            return null;
        }
        aa.a a2 = ac2.a().e();
        if (f.c(string2)) {
            boolean bl2 = f.d(string2);
            if (f.e(string2)) {
                object = "GET";
            } else {
                object = string2;
                if (bl2) {
                    object2 = ac2.a().d();
                    object = string2;
                }
            }
            a2.a((String)object, (ab)object2);
            if (!bl2) {
                a2.a("Transfer-Encoding");
                a2.a("Content-Length");
                a2.a("Content-Type");
            }
        }
        if (!this.a(ac2, t2)) {
            a2.a("Authorization");
        }
        return a2.a(t2).a();
    }

    private boolean a(ac object, t t2) {
        return ((t)(object = ((ac)object).a().a())).f().equals(t2.f()) && ((t)object).g() == t2.g() && ((t)object).b().equals(t2.b());
    }

    private boolean a(IOException iOException, c.a.b.g g2, boolean bl2, aa aa2) {
        g2.a(iOException);
        if (!this.a.s()) {
            return false;
        }
        if (bl2 && aa2.d() instanceof l) {
            return false;
        }
        if (!this.a(iOException, bl2)) {
            return false;
        }
        return g2.g();
    }

    private boolean a(IOException iOException, boolean bl2) {
        boolean bl3 = iOException instanceof ProtocolException;
        boolean bl4 = false;
        if (bl3) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            bl3 = bl4;
            if (iOException instanceof SocketTimeoutException) {
                bl3 = bl4;
                if (!bl2) {
                    bl3 = true;
                }
            }
            return bl3;
        }
        if (iOException instanceof SSLHandshakeException && iOException.getCause() instanceof CertificateException) {
            return false;
        }
        return !(iOException instanceof SSLPeerUnverifiedException);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public ac a(u.a var1_1) {
        var6_3 = var1_1.a();
        var7_6 = (g)var1_1;
        var8_7 = var7_6.h();
        var9_8 = var7_6.i();
        var4_9 = new c.a.b.g(this.a.p(), this.a(var6_3.a()), var8_7, var9_8, this.d);
        this.c = var4_9;
        var5_10 = null;
        var2_11 = 0;
        var1_1 = var6_3;
        do {
            if (this.e) {
                var4_9.d();
                throw new IOException("Canceled");
            }
            var6_3 = var7_6.a((aa)var1_1, (c.a.b.g)var4_9, null, null);
            var1_1 = var5_10 != null ? var6_3.h().c(var5_10.h().a((ad)null).a()).a() : var6_3;
            var6_3 = this.a((ac)var1_1, var4_9.b());
            if (var6_3 == null) {
                if (this.b != false) return var1_1;
                var4_9.d();
                return var1_1;
            }
            c.a(var1_1.g());
            if (++var2_11 > 20) {
                var4_9.d();
                var1_1 = new StringBuilder();
                var1_1.append("Too many follow-up requests: ");
                var1_1.append(var2_11);
                throw new ProtocolException(var1_1.toString());
            }
            if (var6_3.d() instanceof l) {
                var4_9.d();
                throw new HttpRetryException("Cannot retry streamed HTTP body", var1_1.b());
            }
            if (!this.a((ac)var1_1, var6_3.a())) {
                var4_9.d();
                this.c = var4_9 = new c.a.b.g(this.a.p(), this.a(var6_3.a()), var8_7, var9_8, this.d);
            } else if (var4_9.a() != null) {
                var4_9 = new StringBuilder();
                var4_9.append("Closing the body of ");
                var4_9.append(var1_1);
                var4_9.append(" didn't close its backing stream. Bad interceptor?");
                throw new IllegalStateException(var4_9.toString());
            }
            var5_10 = var1_1;
            var1_1 = var6_3;
            continue;
            {
                catch (Throwable var1_2) {
                    ** GOTO lbl52
                }
                catch (IOException var6_4) {}
                {
                    var3_12 = var6_4 instanceof c.a.e.a == false;
                    catch (c.a.b.e var6_5) {
                        if (this.a(var6_5.a(), (c.a.b.g)var4_9, false, (aa)var1_1) == false) throw var6_5.a();
                        continue;
                    }
lbl52: // 1 sources:
                    var4_9.a((IOException)null);
                    var4_9.d();
                    throw var1_2;
                    if (this.a(var6_4, (c.a.b.g)var4_9, var3_12, (aa)var1_1) == false) throw var6_4;
                    continue;
                }
            }
            break;
        } while (true);
    }

    public void a() {
        this.e = true;
        c.a.b.g g2 = this.c;
        if (g2 != null) {
            g2.f();
        }
    }

    public void a(Object object) {
        this.d = object;
    }

    public boolean b() {
        return this.e;
    }
}

