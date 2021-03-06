/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a.c;
import c.af;
import c.h;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

public final class k {
    public static final k a;
    public static final k b;
    public static final k c;
    private static final h[] h;
    final boolean d;
    final boolean e;
    @Nullable
    final String[] f;
    @Nullable
    final String[] g;

    static {
        h = new h[]{h.aX, h.bb, h.aY, h.bc, h.bi, h.bh, h.aI, h.aJ, h.ag, h.ah, h.E, h.I, h.i};
        a = new a(true).a(h).a(af.a, af.b, af.c, af.d).a(true).a();
        b = new a(a).a(af.d).a(true).a();
        c = new a(false).a();
    }

    k(a a2) {
        this.d = a2.a;
        this.f = a2.b;
        this.g = a2.c;
        this.e = a2.d;
    }

    private k b(SSLSocket arrstring, boolean bl2) {
        String[] arrstring2 = this.f != null ? c.a(h.a, arrstring.getEnabledCipherSuites(), this.f) : arrstring.getEnabledCipherSuites();
        String[] arrstring3 = this.g != null ? c.a(c.h, arrstring.getEnabledProtocols(), this.g) : arrstring.getEnabledProtocols();
        String[] arrstring4 = arrstring.getSupportedCipherSuites();
        int n2 = c.a(h.a, arrstring4, "TLS_FALLBACK_SCSV");
        arrstring = arrstring2;
        if (bl2) {
            arrstring = arrstring2;
            if (n2 != -1) {
                arrstring = c.a(arrstring2, arrstring4[n2]);
            }
        }
        return new a(this).a(arrstring).b(arrstring3).a();
    }

    void a(SSLSocket sSLSocket, boolean bl2) {
        k k2 = this.b(sSLSocket, bl2);
        if (k2.g != null) {
            sSLSocket.setEnabledProtocols(k2.g);
        }
        if (k2.f != null) {
            sSLSocket.setEnabledCipherSuites(k2.f);
        }
    }

    public boolean a() {
        return this.d;
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.d) {
            return false;
        }
        if (this.g != null && !c.b(c.h, this.g, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        return this.f == null || c.b(h.a, this.f, sSLSocket.getEnabledCipherSuites());
    }

    @Nullable
    public List<h> b() {
        if (this.f != null) {
            return h.a(this.f);
        }
        return null;
    }

    @Nullable
    public List<af> c() {
        if (this.g != null) {
            return af.a(this.g);
        }
        return null;
    }

    public boolean d() {
        return this.e;
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof k)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        object = (k)object;
        if (this.d != ((k)object).d) {
            return false;
        }
        if (this.d) {
            if (!Arrays.equals(this.f, ((k)object).f)) {
                return false;
            }
            if (!Arrays.equals(this.g, ((k)object).g)) {
                return false;
            }
            if (this.e != ((k)object).e) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.d) {
            return ((527 + Arrays.hashCode(this.f)) * 31 + Arrays.hashCode(this.g)) * 31 + (this.e ^ true);
        }
        return 17;
    }

    public String toString() {
        if (!this.d) {
            return "ConnectionSpec()";
        }
        String string2 = this.f != null ? this.b().toString() : "[all enabled]";
        String string3 = this.g != null ? this.c().toString() : "[all enabled]";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConnectionSpec(cipherSuites=");
        stringBuilder.append(string2);
        stringBuilder.append(", tlsVersions=");
        stringBuilder.append(string3);
        stringBuilder.append(", supportsTlsExtensions=");
        stringBuilder.append(this.e);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static final class a {
        boolean a;
        @Nullable
        String[] b;
        @Nullable
        String[] c;
        boolean d;

        public a(k k2) {
            this.a = k2.d;
            this.b = k2.f;
            this.c = k2.g;
            this.d = k2.e;
        }

        a(boolean bl2) {
            this.a = bl2;
        }

        public a a(boolean bl2) {
            if (this.a) {
                this.d = bl2;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public /* varargs */ a a(af ... arraf) {
            if (this.a) {
                String[] arrstring = new String[arraf.length];
                for (int i2 = 0; i2 < arraf.length; ++i2) {
                    arrstring[i2] = arraf[i2].f;
                }
                return this.b(arrstring);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public /* varargs */ a a(h ... arrh) {
            if (this.a) {
                String[] arrstring = new String[arrh.length];
                for (int i2 = 0; i2 < arrh.length; ++i2) {
                    arrstring[i2] = arrh[i2].bj;
                }
                return this.a(arrstring);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public /* varargs */ a a(String ... arrstring) {
            if (this.a) {
                if (arrstring.length != 0) {
                    this.b = (String[])arrstring.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public k a() {
            return new k(this);
        }

        public /* varargs */ a b(String ... arrstring) {
            if (this.a) {
                if (arrstring.length != 0) {
                    this.c = (String[])arrstring.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
    }

}

