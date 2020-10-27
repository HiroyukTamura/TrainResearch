package p040i.p103M.p112k.p113i;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p040i.p103M.p115m.C1906c;

/* renamed from: i.M.k.i.b */
public final class C1894b extends C1906c {

    /* renamed from: a */
    private final X509TrustManager f2684a;

    /* renamed from: b */
    private final X509TrustManagerExtensions f2685b;

    public C1894b(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        Intrinsics.checkParameterIsNotNull(x509TrustManager, "trustManager");
        Intrinsics.checkParameterIsNotNull(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.f2684a = x509TrustManager;
        this.f2685b = x509TrustManagerExtensions;
    }

    /* renamed from: a */
    public static final C1894b m3217a(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        Intrinsics.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        if (x509TrustManagerExtensions != null) {
            return new C1894b(x509TrustManager, x509TrustManagerExtensions);
        }
        return null;
    }

    /* renamed from: a */
    public List<Certificate> mo27991a(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
        Intrinsics.checkParameterIsNotNull(list, "chain");
        Intrinsics.checkParameterIsNotNull(str, "hostname");
        Object[] array = list.toArray(new X509Certificate[0]);
        if (array != null) {
            try {
                List<X509Certificate> checkServerTrusted = this.f2685b.checkServerTrusted((X509Certificate[]) array, "RSA", str);
                Intrinsics.checkExpressionValueIsNotNull(checkServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
                return checkServerTrusted;
            } catch (CertificateException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1894b) && ((C1894b) obj).f2684a == this.f2684a;
    }

    public int hashCode() {
        return System.identityHashCode(this.f2684a);
    }
}
