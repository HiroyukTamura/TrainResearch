package p040i.p103M.p112k.p113i;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p040i.C0974E;
import p040i.p103M.p112k.C1876b;
import p040i.p103M.p112k.C1890h;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0017J\u0012\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0015"}, mo21739d2 = {"Lokhttp3/internal/platform/android/Android10SocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "()V", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "isSupported", "", "matchesSocket", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@SuppressLint({"NewApi"})
/* renamed from: i.M.k.i.a */
public final class C1892a implements C1900h {

    /* renamed from: i.M.k.i.a$a */
    public static final class C1893a {
        /* renamed from: a */
        public static final boolean m3216a() {
            C1876b.C1877a aVar = C1876b.f2656h;
            return C1876b.f2654f && Build.VERSION.SDK_INT >= 29;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public String mo27987a(SSLSocket sSLSocket) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol != null && !Intrinsics.areEqual((Object) applicationProtocol, (Object) "")) {
            return applicationProtocol;
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo27988a(SSLSocket sSLSocket, String str, List<? extends C0974E> list) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics.checkParameterIsNotNull(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            Intrinsics.checkExpressionValueIsNotNull(sSLParameters, "sslParameters");
            Object[] array = C1890h.f2683c.mo27985a(list).toArray(new String[0]);
            if (array != null) {
                sSLParameters.setApplicationProtocols((String[]) array);
                sSLSocket.setSSLParameters(sSLParameters);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }

    /* renamed from: a */
    public boolean mo27989a() {
        return C1893a.m3216a();
    }

    /* renamed from: b */
    public boolean mo27990b(SSLSocket sSLSocket) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sSLSocket);
    }
}
