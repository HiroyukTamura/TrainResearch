package p040i.p103M.p112k.p113i;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import p040i.C0974E;
import p040i.p103M.p112k.C1879c;
import p040i.p103M.p112k.C1890h;

/* renamed from: i.M.k.i.d */
public final class C1896d implements C1900h {
    /* renamed from: a */
    public String mo27987a(SSLSocket sSLSocket) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol != null && !Intrinsics.areEqual((Object) applicationProtocol, (Object) "")) {
            return applicationProtocol;
        }
        return null;
    }

    /* renamed from: a */
    public void mo27988a(SSLSocket sSLSocket, String str, List<? extends C0974E> list) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics.checkParameterIsNotNull(list, "protocols");
        if (mo27990b(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters, "sslParameters");
            Object[] array = C1890h.f2683c.mo27985a(list).toArray(new String[0]);
            if (array != null) {
                parameters.setApplicationProtocols((String[]) array);
                bCSSLSocket.setParameters(parameters);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    /* renamed from: a */
    public boolean mo27989a() {
        C1879c.C1880a aVar = C1879c.f2662f;
        return C1879c.f2661e;
    }

    /* renamed from: b */
    public boolean mo27990b(SSLSocket sSLSocket) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return sSLSocket instanceof BCSSLSocket;
    }
}
