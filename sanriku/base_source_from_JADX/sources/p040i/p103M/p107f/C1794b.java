package p040i.p103M.p107f;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C1936m;

/* renamed from: i.M.f.b */
public final class C1794b {

    /* renamed from: a */
    private int f2321a;

    /* renamed from: b */
    private boolean f2322b;

    /* renamed from: c */
    private boolean f2323c;

    /* renamed from: d */
    private final List<C1936m> f2324d;

    public C1794b(List<C1936m> list) {
        Intrinsics.checkParameterIsNotNull(list, "connectionSpecs");
        this.f2324d = list;
    }

    /* renamed from: a */
    public final C1936m mo27681a(SSLSocket sSLSocket) throws IOException {
        boolean z;
        C1936m mVar;
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        int i = this.f2321a;
        int size = this.f2324d.size();
        while (true) {
            z = true;
            if (i >= size) {
                mVar = null;
                break;
            }
            mVar = this.f2324d.get(i);
            if (mVar.mo28080a(sSLSocket)) {
                this.f2321a = i + 1;
                break;
            }
            i++;
        }
        if (mVar == null) {
            StringBuilder a = C0681a.m330a("Unable to find acceptable protocols. isFallback=");
            a.append(this.f2323c);
            a.append(',');
            a.append(" modes=");
            a.append(this.f2324d);
            a.append(',');
            a.append(" supported protocols=");
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            if (enabledProtocols == null) {
                Intrinsics.throwNpe();
            }
            String arrays = Arrays.toString(enabledProtocols);
            Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
            a.append(arrays);
            throw new UnknownServiceException(a.toString());
        }
        int i2 = this.f2321a;
        int size2 = this.f2324d.size();
        while (true) {
            if (i2 >= size2) {
                z = false;
                break;
            } else if (this.f2324d.get(i2).mo28080a(sSLSocket)) {
                break;
            } else {
                i2++;
            }
        }
        this.f2322b = z;
        mVar.mo28079a(sSLSocket, this.f2323c);
        return mVar;
    }

    /* renamed from: a */
    public final boolean mo27682a(IOException iOException) {
        Intrinsics.checkParameterIsNotNull(iOException, "e");
        this.f2323c = true;
        return this.f2322b && !(iOException instanceof ProtocolException) && !(iOException instanceof InterruptedIOException) && (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException) && (iOException instanceof SSLException);
    }
}
