/*
 * Decompiled with CFR 0.139.
 */
package c.a.i;

import c.a.i.c;
import c.a.i.e;
import java.security.GeneralSecurityException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class a
extends c {
    private final e a;

    public a(e e2) {
        this.a = e2;
    }

    private boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        }
        catch (GeneralSecurityException generalSecurityException) {
            return false;
        }
    }

    @Override
    public List<Certificate> a(List<Certificate> object, String object2) {
        ArrayDeque<Certificate> arrayDeque = new ArrayDeque<Certificate>((Collection<Certificate>)object);
        object = new ArrayList<Certificate>();
        object.add(arrayDeque.removeFirst());
        boolean bl2 = false;
        block0 : for (int i2 = 0; i2 < 9; ++i2) {
            object2 = (X509Certificate)object.get(object.size() - 1);
            Object object3 = this.a.a((X509Certificate)object2);
            if (object3 != null) {
                if (object.size() > 1 || !((Certificate)object2).equals(object3)) {
                    object.add((Certificate)object3);
                }
                if (this.a((X509Certificate)object3, (X509Certificate)object3)) {
                    return object;
                }
                bl2 = true;
                continue;
            }
            object3 = arrayDeque.iterator();
            while (object3.hasNext()) {
                X509Certificate x509Certificate = (X509Certificate)object3.next();
                if (!this.a((X509Certificate)object2, x509Certificate)) continue;
                object3.remove();
                object.add(x509Certificate);
                continue block0;
            }
            if (bl2) {
                return object;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Failed to find a trusted cert that signed ");
            ((StringBuilder)object).append(object2);
            throw new SSLPeerUnverifiedException(((StringBuilder)object).toString());
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Certificate chain too long: ");
        ((StringBuilder)object2).append(object);
        throw new SSLPeerUnverifiedException(((StringBuilder)object2).toString());
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return object instanceof a && ((a)object).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

