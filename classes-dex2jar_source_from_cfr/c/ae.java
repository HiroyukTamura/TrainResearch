/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a;
import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocketFactory;

public final class ae {
    final a a;
    final Proxy b;
    final InetSocketAddress c;

    public ae(a a2, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (a2 != null) {
            if (proxy != null) {
                if (inetSocketAddress != null) {
                    this.a = a2;
                    this.b = proxy;
                    this.c = inetSocketAddress;
                    return;
                }
                throw new NullPointerException("inetSocketAddress == null");
            }
            throw new NullPointerException("proxy == null");
        }
        throw new NullPointerException("address == null");
    }

    public a a() {
        return this.a;
    }

    public Proxy b() {
        return this.b;
    }

    public InetSocketAddress c() {
        return this.c;
    }

    public boolean d() {
        return this.a.i != null && this.b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(@Nullable Object object) {
        if (object instanceof ae) {
            object = (ae)object;
            if (((ae)object).a.equals(this.a) && ((ae)object).b.equals(this.b) && ((ae)object).c.equals(this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Route{");
        stringBuilder.append(this.c);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

