/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a.c;
import d.f;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class g {
    public static final g a = new a().a();
    private final Set<b> b;
    @Nullable
    private final c.a.i.c c;

    g(Set<b> set, @Nullable c.a.i.c c2) {
        this.b = set;
        this.c = c2;
    }

    static f a(X509Certificate x509Certificate) {
        return f.a(x509Certificate.getPublicKey().getEncoded()).c();
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sha256/");
            stringBuilder.append(g.b((X509Certificate)certificate).b());
            return stringBuilder.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static f b(X509Certificate x509Certificate) {
        return f.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    g a(@Nullable c.a.i.c c2) {
        if (c.a(this.c, (Object)c2)) {
            return this;
        }
        return new g(this.b, c2);
    }

    List<b> a(String string2) {
        List<b> list = Collections.emptyList();
        for (b b2 : this.b) {
            if (!b2.a(string2)) continue;
            List<b> list2 = list;
            if (list.isEmpty()) {
                list2 = new ArrayList<b>();
            }
            list2.add(b2);
            list = list2;
        }
        return list;
    }

    public void a(String object, List<Certificate> object2) {
        X509Certificate x509Certificate;
        int n2;
        int n3;
        List<b> list = this.a((String)object);
        if (list.isEmpty()) {
            return;
        }
        List<Certificate> list2 = object2;
        if (this.c != null) {
            list2 = this.c.a((List<Certificate>)object2, (String)object);
        }
        int n4 = list2.size();
        int n5 = 0;
        for (n2 = 0; n2 < n4; ++n2) {
            X509Certificate x509Certificate2 = (X509Certificate)list2.get(n2);
            int n6 = list.size();
            x509Certificate = null;
            object2 = x509Certificate;
            for (n3 = 0; n3 < n6; ++n3) {
                Object object3;
                b b2 = list.get(n3);
                if (b2.c.equals("sha256/")) {
                    object3 = x509Certificate;
                    if (x509Certificate == null) {
                        object3 = g.b(x509Certificate2);
                    }
                    x509Certificate = object3;
                    if (!b2.d.equals(object3)) continue;
                    return;
                }
                if (b2.c.equals("sha1/")) {
                    object3 = object2;
                    if (object2 == null) {
                        object3 = g.a(x509Certificate2);
                    }
                    object2 = object3;
                    if (!b2.d.equals(object3)) continue;
                    return;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("unsupported hashAlgorithm: ");
                ((StringBuilder)object).append(b2.c);
                throw new AssertionError((Object)((StringBuilder)object).toString());
            }
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Certificate pinning failure!");
        ((StringBuilder)object2).append("\n  Peer certificate chain:");
        n3 = list2.size();
        for (n2 = 0; n2 < n3; ++n2) {
            x509Certificate = (X509Certificate)list2.get(n2);
            ((StringBuilder)object2).append("\n    ");
            ((StringBuilder)object2).append(g.a((Certificate)x509Certificate));
            ((StringBuilder)object2).append(": ");
            ((StringBuilder)object2).append(x509Certificate.getSubjectDN().getName());
        }
        ((StringBuilder)object2).append("\n  Pinned certificates for ");
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(":");
        n3 = list.size();
        for (n2 = n5; n2 < n3; ++n2) {
            object = list.get(n2);
            ((StringBuilder)object2).append("\n    ");
            ((StringBuilder)object2).append(object);
        }
        throw new SSLPeerUnverifiedException(((StringBuilder)object2).toString());
    }

    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof g) {
            c.a.i.c c2 = this.c;
            object = (g)object;
            if (c.a(c2, (Object)((g)object).c) && this.b.equals(((g)object).b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int n2 = this.c != null ? this.c.hashCode() : 0;
        return n2 * 31 + this.b.hashCode();
    }

    public static final class a {
        private final List<b> a = new ArrayList<b>();

        public g a() {
            return new g(new LinkedHashSet<b>(this.a), null);
        }
    }

    static final class b {
        final String a;
        final String b;
        final String c;
        final f d;

        boolean a(String string2) {
            if (this.a.startsWith("*.")) {
                int n2 = string2.indexOf(46);
                return string2.length() - n2 - 1 == this.b.length() && string2.regionMatches(false, n2 + 1, this.b, 0, this.b.length());
            }
            return string2.equals(this.b);
        }

        public boolean equals(Object object) {
            if (object instanceof b) {
                String string2 = this.a;
                object = (b)object;
                if (string2.equals(((b)object).a) && this.c.equals(((b)object).c) && this.d.equals(((b)object).d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((527 + this.a.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.c);
            stringBuilder.append(this.d.b());
            return stringBuilder.toString();
        }
    }

}

