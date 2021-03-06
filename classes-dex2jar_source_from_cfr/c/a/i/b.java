/*
 * Decompiled with CFR 0.139.
 */
package c.a.i;

import c.a.i.e;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public final class b
implements e {
    private final Map<X500Principal, Set<X509Certificate>> a = new LinkedHashMap<X500Principal, Set<X509Certificate>>();

    public /* varargs */ b(X509Certificate ... arrx509Certificate) {
        for (X509Certificate x509Certificate : arrx509Certificate) {
            Set<X509Certificate> set;
            X500Principal x500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> set2 = set = this.a.get(x500Principal);
            if (set == null) {
                set2 = new LinkedHashSet<X509Certificate>(1);
                this.a.put(x500Principal, set2);
            }
            set2.add(x509Certificate);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public X509Certificate a(X509Certificate x509Certificate) {
        Iterator iterator = x509Certificate.getIssuerX500Principal();
        if ((iterator = this.a.get(iterator)) == null) {
            return null;
        }
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            X509Certificate x509Certificate2 = (X509Certificate)iterator.next();
            PublicKey publicKey = x509Certificate2.getPublicKey();
            try {
                x509Certificate.verify(publicKey);
                return x509Certificate2;
            }
            catch (Exception exception) {
            }
        }
        return null;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return object instanceof b && ((b)object).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

