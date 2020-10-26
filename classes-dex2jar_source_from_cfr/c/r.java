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
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class r {
    private final af a;
    private final h b;
    private final List<Certificate> c;
    private final List<Certificate> d;

    private r(af af2, h h2, List<Certificate> list, List<Certificate> list2) {
        this.a = af2;
        this.b = h2;
        this.c = list;
        this.d = list2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static r a(SSLSession object) {
        h h2;
        af af2;
        void var1_13;
        void var0_4;
        void var1_10;
        block5 : {
            String string2 = object.getCipherSuite();
            if (string2 == null) throw new IllegalStateException("cipherSuite == null");
            h2 = h.a(string2);
            String string3 = object.getProtocol();
            if (string3 == null) throw new IllegalStateException("tlsVersion == null");
            af2 = af.a(string3);
            try {
                Certificate[] arrcertificate = object.getPeerCertificates();
                break block5;
            }
            catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {}
            Object var1_9 = null;
        }
        if (var1_10 != null) {
            List list = c.a(var1_10);
        } else {
            List list = Collections.emptyList();
        }
        Certificate[] arrcertificate = object.getLocalCertificates();
        if (arrcertificate != null) {
            List<Certificate> list = c.a(arrcertificate);
            return new r(af2, h2, (List<Certificate>)var1_13, (List<Certificate>)var0_4);
        }
        List list = Collections.emptyList();
        return new r(af2, h2, (List<Certificate>)var1_13, (List<Certificate>)var0_4);
    }

    public h a() {
        return this.b;
    }

    public List<Certificate> b() {
        return this.c;
    }

    public boolean equals(@Nullable Object object) {
        boolean bl2 = object instanceof r;
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        object = (r)object;
        bl2 = bl3;
        if (this.a.equals((Object)((r)object).a)) {
            bl2 = bl3;
            if (this.b.equals(((r)object).b)) {
                bl2 = bl3;
                if (this.c.equals(((r)object).c)) {
                    bl2 = bl3;
                    if (this.d.equals(((r)object).d)) {
                        bl2 = true;
                    }
                }
            }
        }
        return bl2;
    }

    public int hashCode() {
        return (((527 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
    }
}

