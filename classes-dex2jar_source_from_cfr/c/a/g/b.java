/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  org.conscrypt.Conscrypt
 *  org.conscrypt.OpenSSLProvider
 */
package c.a.g;

import c.a.g.f;
import c.y;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLProvider;

public class b
extends f {
    private b() {
    }

    public static f b() {
        block3 : {
            try {
                Class.forName("org.conscrypt.ConscryptEngineSocket");
                if (Conscrypt.isAvailable()) break block3;
                return null;
            }
            catch (ClassNotFoundException classNotFoundException) {
                return null;
            }
        }
        Conscrypt.setUseEngineSocketByDefault((boolean)true);
        b b2 = new b();
        return b2;
    }

    private Provider e() {
        return new OpenSSLProvider();
    }

    @Nullable
    @Override
    public String a(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt((SSLSocket)sSLSocket)) {
            return Conscrypt.getApplicationProtocol((SSLSocket)sSLSocket);
        }
        return super.a(sSLSocket);
    }

    @Override
    public void a(SSLSocket sSLSocket, String string2, List<y> list) {
        if (Conscrypt.isConscrypt((SSLSocket)sSLSocket)) {
            if (string2 != null) {
                Conscrypt.setUseSessionTickets((SSLSocket)sSLSocket, (boolean)true);
                Conscrypt.setHostname((SSLSocket)sSLSocket, (String)string2);
            }
            Conscrypt.setApplicationProtocols((SSLSocket)sSLSocket, (String[])f.a(list).toArray(new String[0]));
            return;
        }
        super.a(sSLSocket, string2, list);
    }

    @Override
    public SSLContext x_() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS", this.e());
            return sSLContext;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new IllegalStateException("No TLS provider", noSuchAlgorithmException);
        }
    }
}

