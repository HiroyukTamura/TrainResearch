package p040i.p103M.p112k.p113i;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.Conscrypt;
import p040i.C0974E;
import p040i.p103M.p112k.C1881d;
import p040i.p103M.p112k.C1890h;

/* renamed from: i.M.k.i.f */
public final class C1898f implements C1900h {
    /* renamed from: a */
    public String mo27987a(SSLSocket sSLSocket) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (mo27990b(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    /* renamed from: a */
    public void mo27988a(SSLSocket sSLSocket, String str, List<? extends C0974E> list) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics.checkParameterIsNotNull(list, "protocols");
        if (mo27990b(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Object[] array = C1890h.f2683c.mo27985a(list).toArray(new String[0]);
            if (array != null) {
                Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    /* renamed from: a */
    public boolean mo27989a() {
        C1881d.C1882a aVar = C1881d.f2665f;
        return C1881d.f2664e;
    }

    /* renamed from: b */
    public boolean mo27990b(SSLSocket sSLSocket) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket);
    }
}
