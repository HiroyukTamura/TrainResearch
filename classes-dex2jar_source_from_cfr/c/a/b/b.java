/*
 * Decompiled with CFR 0.139.
 */
package c.a.b;

import c.a.a;
import c.k;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class b {
    private final List<k> a;
    private int b = 0;
    private boolean c;
    private boolean d;

    public b(List<k> list) {
        this.a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i2 = this.b; i2 < this.a.size(); ++i2) {
            if (!this.a.get(i2).a(sSLSocket)) continue;
            return true;
        }
        return false;
    }

    public k a(SSLSocket sSLSocket) {
        Object object;
        block2 : {
            int n2 = this.a.size();
            for (int i2 = this.b; i2 < n2; ++i2) {
                object = this.a.get(i2);
                if (!((k)object).a(sSLSocket)) continue;
                this.b = i2 + 1;
                break block2;
            }
            object = null;
        }
        if (object != null) {
            this.c = this.b(sSLSocket);
            a.a.a((k)object, sSLSocket, this.d);
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Unable to find acceptable protocols. isFallback=");
        ((StringBuilder)object).append(this.d);
        ((StringBuilder)object).append(", modes=");
        ((StringBuilder)object).append(this.a);
        ((StringBuilder)object).append(", supported protocols=");
        ((StringBuilder)object).append(Arrays.toString(sSLSocket.getEnabledProtocols()));
        throw new UnknownServiceException(((StringBuilder)object).toString());
    }

    public boolean a(IOException iOException) {
        boolean bl2 = true;
        this.d = true;
        if (!this.c) {
            return false;
        }
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return false;
        }
        boolean bl3 = iOException instanceof SSLHandshakeException;
        if (bl3 && iOException.getCause() instanceof CertificateException) {
            return false;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return false;
        }
        if (!bl3) {
            if (iOException instanceof SSLProtocolException) {
                return true;
            }
            bl2 = false;
        }
        return bl2;
    }
}

