/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a.c;
import c.b;
import c.g;
import c.k;
import c.o;
import c.t;
import c.y;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class a {
    final t a;
    final o b;
    final SocketFactory c;
    final b d;
    final List<y> e;
    final List<k> f;
    final ProxySelector g;
    @Nullable
    final Proxy h;
    @Nullable
    final SSLSocketFactory i;
    @Nullable
    final HostnameVerifier j;
    @Nullable
    final g k;

    public a(String string2, int n2, o o2, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable g g2, b b2, @Nullable Proxy proxy, List<y> list, List<k> list2, ProxySelector proxySelector) {
        t.a a2 = new t.a();
        String string3 = sSLSocketFactory != null ? "https" : "http";
        this.a = a2.a(string3).d(string2).a(n2).c();
        if (o2 != null) {
            this.b = o2;
            if (socketFactory != null) {
                this.c = socketFactory;
                if (b2 != null) {
                    this.d = b2;
                    if (list != null) {
                        this.e = c.a(list);
                        if (list2 != null) {
                            this.f = c.a(list2);
                            if (proxySelector != null) {
                                this.g = proxySelector;
                                this.h = proxy;
                                this.i = sSLSocketFactory;
                                this.j = hostnameVerifier;
                                this.k = g2;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    public t a() {
        return this.a;
    }

    boolean a(a a2) {
        return this.b.equals(a2.b) && this.d.equals(a2.d) && this.e.equals(a2.e) && this.f.equals(a2.f) && this.g.equals(a2.g) && c.a(this.h, (Object)a2.h) && c.a(this.i, (Object)a2.i) && c.a(this.j, (Object)a2.j) && c.a(this.k, (Object)a2.k) && this.a().g() == a2.a().g();
    }

    public o b() {
        return this.b;
    }

    public SocketFactory c() {
        return this.c;
    }

    public b d() {
        return this.d;
    }

    public List<y> e() {
        return this.e;
    }

    public boolean equals(@Nullable Object object) {
        if (object instanceof a) {
            t t2 = this.a;
            object = (a)object;
            if (t2.equals(((a)object).a) && this.a((a)object)) {
                return true;
            }
        }
        return false;
    }

    public List<k> f() {
        return this.f;
    }

    public ProxySelector g() {
        return this.g;
    }

    @Nullable
    public Proxy h() {
        return this.h;
    }

    public int hashCode() {
        int n2 = this.a.hashCode();
        int n3 = this.b.hashCode();
        int n4 = this.d.hashCode();
        int n5 = this.e.hashCode();
        int n6 = this.f.hashCode();
        int n7 = this.g.hashCode();
        Proxy proxy = this.h;
        int n8 = 0;
        int n9 = proxy != null ? this.h.hashCode() : 0;
        int n10 = this.i != null ? this.i.hashCode() : 0;
        int n11 = this.j != null ? this.j.hashCode() : 0;
        if (this.k != null) {
            n8 = this.k.hashCode();
        }
        return (((((((((527 + n2) * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + n7) * 31 + n9) * 31 + n10) * 31 + n11) * 31 + n8;
    }

    @Nullable
    public SSLSocketFactory i() {
        return this.i;
    }

    @Nullable
    public HostnameVerifier j() {
        return this.j;
    }

    @Nullable
    public g k() {
        return this.k;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        Object object;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Address{");
        stringBuilder.append(this.a.f());
        stringBuilder.append(":");
        stringBuilder.append(this.a.g());
        if (this.h != null) {
            stringBuilder.append(", proxy=");
            object = this.h;
        } else {
            stringBuilder.append(", proxySelector=");
            object = this.g;
        }
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

