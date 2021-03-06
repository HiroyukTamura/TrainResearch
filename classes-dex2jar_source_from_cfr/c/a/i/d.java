/*
 * Decompiled with CFR 0.139.
 */
package c.a.i;

import c.a.c;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class d
implements HostnameVerifier {
    public static final d a = new d();

    private d() {
    }

    public static List<String> a(X509Certificate object) {
        List<String> list = d.a((X509Certificate)object, 7);
        object = d.a((X509Certificate)object, 2);
        ArrayList<String> arrayList = new ArrayList<String>(list.size() + object.size());
        arrayList.addAll(list);
        arrayList.addAll((Collection<String>)object);
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static List<String> a(X509Certificate iterator, int n2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            iterator = ((X509Certificate)((Object)iterator)).getSubjectAlternativeNames();
            if (iterator == null) {
                return Collections.emptyList();
            }
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                Integer n3;
                Object object = (List)iterator.next();
                if (object == null || object.size() < 2 || (n3 = (Integer)object.get(0)) == null || n3 != n2 || (object = (String)object.get(1)) == null) continue;
                arrayList.add((String)object);
            }
            return arrayList;
        }
        catch (CertificateParsingException certificateParsingException) {
            return Collections.emptyList();
        }
    }

    private boolean b(String string2, X509Certificate object) {
        object = d.a((X509Certificate)object, 7);
        int n2 = object.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string2.equalsIgnoreCase((String)object.get(i2))) continue;
            return true;
        }
        return false;
    }

    private boolean c(String string2, X509Certificate object) {
        string2 = string2.toLowerCase(Locale.US);
        object = d.a((X509Certificate)object, 2).iterator();
        while (object.hasNext()) {
            if (!this.a(string2, (String)object.next())) continue;
            return true;
        }
        return false;
    }

    public boolean a(String charSequence, String string2) {
        if (charSequence != null && ((String)charSequence).length() != 0 && !((String)charSequence).startsWith(".")) {
            if (((String)charSequence).endsWith("..")) {
                return false;
            }
            if (string2 != null && string2.length() != 0 && !string2.startsWith(".")) {
                if (string2.endsWith("..")) {
                    return false;
                }
                CharSequence charSequence2 = charSequence;
                if (!((String)charSequence).endsWith(".")) {
                    charSequence2 = new StringBuilder();
                    ((StringBuilder)charSequence2).append((String)charSequence);
                    ((StringBuilder)charSequence2).append('.');
                    charSequence2 = ((StringBuilder)charSequence2).toString();
                }
                charSequence = string2;
                if (!string2.endsWith(".")) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(string2);
                    ((StringBuilder)charSequence).append('.');
                    charSequence = ((StringBuilder)charSequence).toString();
                }
                if (!((String)(charSequence = ((String)charSequence).toLowerCase(Locale.US))).contains("*")) {
                    return ((String)charSequence2).equals(charSequence);
                }
                if (((String)charSequence).startsWith("*.")) {
                    if (((String)charSequence).indexOf(42, 1) != -1) {
                        return false;
                    }
                    if (((String)charSequence2).length() < ((String)charSequence).length()) {
                        return false;
                    }
                    if ("*.".equals(charSequence)) {
                        return false;
                    }
                    if (!((String)charSequence2).endsWith((String)(charSequence = ((String)charSequence).substring(1)))) {
                        return false;
                    }
                    int n2 = ((String)charSequence2).length() - ((String)charSequence).length();
                    return n2 <= 0 || ((String)charSequence2).lastIndexOf(46, n2 - 1) == -1;
                }
            }
        }
        return false;
    }

    public boolean a(String string2, X509Certificate x509Certificate) {
        if (c.c(string2)) {
            return this.b(string2, x509Certificate);
        }
        return this.c(string2, x509Certificate);
    }

    @Override
    public boolean verify(String string2, SSLSession sSLSession) {
        try {
            boolean bl2 = this.a(string2, (X509Certificate)sSLSession.getPeerCertificates()[0]);
            return bl2;
        }
        catch (SSLException sSLException) {
            return false;
        }
    }
}

