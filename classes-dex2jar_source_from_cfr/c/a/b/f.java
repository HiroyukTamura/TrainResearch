/*
 * Decompiled with CFR 0.139.
 */
package c.a.b;

import c.a.b.d;
import c.a.c;
import c.ae;
import c.e;
import c.o;
import c.p;
import c.t;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class f {
    private final c.a a;
    private final d b;
    private final e c;
    private final p d;
    private List<Proxy> e = Collections.emptyList();
    private int f;
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<ae> h = new ArrayList<ae>();

    public f(c.a a2, d d2, e e2, p p2) {
        this.a = a2;
        this.b = d2;
        this.c = e2;
        this.d = p2;
        this.a(a2.a(), a2.h());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress inetAddress = inetSocketAddress.getAddress();
        if (inetAddress == null) {
            return inetSocketAddress.getHostName();
        }
        return inetAddress.getHostAddress();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(t list, Proxy proxy) {
        list = proxy != null ? Collections.singletonList(proxy) : ((list = this.a.g().select(((t)((Object)list)).a())) != null && !list.isEmpty() ? c.a(list) : c.a(Proxy.NO_PROXY));
        this.e = list;
        this.f = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Proxy object) {
        Object object2;
        int n2;
        this.g = new ArrayList<InetSocketAddress>();
        if (((Proxy)object).type() != Proxy.Type.DIRECT && ((Proxy)object).type() != Proxy.Type.SOCKS) {
            object2 = ((Proxy)object).address();
            if (!(object2 instanceof InetSocketAddress)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Proxy.address() is not an InetSocketAddress: ");
                ((StringBuilder)object).append(object2.getClass());
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress)object2;
            object2 = f.a(inetSocketAddress);
            n2 = inetSocketAddress.getPort();
        } else {
            object2 = this.a.a().f();
            n2 = this.a.a().g();
        }
        if (n2 >= 1 && n2 <= 65535) {
            if (((Proxy)object).type() == Proxy.Type.SOCKS) {
                this.g.add(InetSocketAddress.createUnresolved((String)object2, n2));
                return;
            }
            this.d.a(this.c, (String)object2);
            object = this.a.b().a((String)object2);
            if (object.isEmpty()) {
                object = new StringBuilder();
                ((StringBuilder)object).append(this.a.b());
                ((StringBuilder)object).append(" returned no addresses for ");
                ((StringBuilder)object).append((String)object2);
                throw new UnknownHostException(((StringBuilder)object).toString());
            }
            this.d.a(this.c, (String)object2, (List<InetAddress>)object);
            int n3 = 0;
            int n4 = object.size();
            do {
                if (n3 >= n4) {
                    return;
                }
                object2 = (InetAddress)object.get(n3);
                this.g.add(new InetSocketAddress((InetAddress)object2, n2));
                ++n3;
            } while (true);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("No route to ");
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(":");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append("; port is out of range");
        throw new SocketException(((StringBuilder)object).toString());
    }

    private boolean c() {
        return this.f < this.e.size();
    }

    private Proxy d() {
        if (this.c()) {
            Object object = this.e;
            int n2 = this.f;
            this.f = n2 + 1;
            object = object.get(n2);
            this.a((Proxy)object);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No route to ");
        stringBuilder.append(this.a.a().f());
        stringBuilder.append("; exhausted proxy configurations: ");
        stringBuilder.append(this.e);
        throw new SocketException(stringBuilder.toString());
    }

    public void a(ae ae2, IOException iOException) {
        if (ae2.b().type() != Proxy.Type.DIRECT && this.a.g() != null) {
            this.a.g().connectFailed(this.a.a().a(), ae2.b().address(), iOException);
        }
        this.b.a(ae2);
    }

    public boolean a() {
        return this.c() || !this.h.isEmpty();
        {
        }
    }

    public a b() {
        if (this.a()) {
            ArrayList<ae> arrayList = new ArrayList<ae>();
            while (this.c()) {
                Proxy proxy = this.d();
                int n2 = this.g.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    ae ae2 = new ae(this.a, proxy, this.g.get(i2));
                    if (this.b.c(ae2)) {
                        this.h.add(ae2);
                        continue;
                    }
                    arrayList.add(ae2);
                }
                if (arrayList.isEmpty()) continue;
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.h);
                this.h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }

    public static final class a {
        private final List<ae> a;
        private int b = 0;

        a(List<ae> list) {
            this.a = list;
        }

        public boolean a() {
            return this.b < this.a.size();
        }

        public ae b() {
            if (this.a()) {
                List<ae> list = this.a;
                int n2 = this.b;
                this.b = n2 + 1;
                return list.get(n2);
            }
            throw new NoSuchElementException();
        }

        public List<ae> c() {
            return new ArrayList<ae>(this.a);
        }
    }

}

