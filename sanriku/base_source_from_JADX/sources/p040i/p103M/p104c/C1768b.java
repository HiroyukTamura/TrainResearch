package p040i.p103M.p104c;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C1755F;
import p040i.C1758I;
import p040i.C1760K;
import p040i.C1912a;
import p040i.C1914c;
import p040i.C1930i;
import p040i.C1942s;
import p040i.C1955z;
import p042j.C2073i;

/* renamed from: i.M.c.b */
public final class C1768b implements C1914c {

    /* renamed from: b */
    private final C1942s f2225b;

    public /* synthetic */ C1768b(C1942s sVar, int i) {
        sVar = (i & 1) != 0 ? C1942s.f2833a : sVar;
        Intrinsics.checkParameterIsNotNull(sVar, "defaultDns");
        this.f2225b = sVar;
    }

    /* renamed from: a */
    private final InetAddress m2644a(Proxy proxy, C1955z zVar, C1942s sVar) throws IOException {
        Proxy.Type type = proxy.type();
        if (type != null && C1767a.f2224a[type.ordinal()] == 1) {
            return (InetAddress) CollectionsKt___CollectionsKt.first(sVar.mo28100a(zVar.mo28138f()));
        }
        SocketAddress address = proxy.address();
        if (address != null) {
            InetAddress address2 = ((InetSocketAddress) address).getAddress();
            Intrinsics.checkExpressionValueIsNotNull(address2, "(address() as InetSocketAddress).address");
            return address2;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
    }

    /* renamed from: a */
    public C1755F mo27599a(C1760K k, C1758I i) throws IOException {
        Proxy proxy;
        C1942s sVar;
        PasswordAuthentication passwordAuthentication;
        C1912a a;
        Intrinsics.checkParameterIsNotNull(i, "response");
        List<C1930i> l = i.mo27557l();
        C1755F y = i.mo27569y();
        C1955z g = y.mo27542g();
        boolean z = i.mo27558o() == 407;
        if (k == null || (proxy = k.mo27589b()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (C1930i next : l) {
            if (StringsKt__StringsJVMKt.equals("Basic", next.mo28069c(), true)) {
                if (k == null || (a = k.mo27588a()) == null || (sVar = a.mo28010c()) == null) {
                    sVar = this.f2225b;
                }
                if (z) {
                    SocketAddress address = proxy.address();
                    if (address != null) {
                        InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                        String hostName = inetSocketAddress.getHostName();
                        Intrinsics.checkExpressionValueIsNotNull(proxy, "proxy");
                        passwordAuthentication = Authenticator.requestPasswordAuthentication(hostName, m2644a(proxy, g, sVar), inetSocketAddress.getPort(), g.mo28146m(), next.mo28068b(), next.mo28069c(), g.mo28148o(), Authenticator.RequestorType.PROXY);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
                    }
                } else {
                    String f = g.mo28138f();
                    Intrinsics.checkExpressionValueIsNotNull(proxy, "proxy");
                    passwordAuthentication = Authenticator.requestPasswordAuthentication(f, m2644a(proxy, g, sVar), g.mo28143j(), g.mo28146m(), next.mo28068b(), next.mo28069c(), g.mo28148o(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthentication != null) {
                    String str = z ? "Proxy-Authorization" : "Authorization";
                    String userName = passwordAuthentication.getUserName();
                    Intrinsics.checkExpressionValueIsNotNull(userName, "auth.userName");
                    char[] password = passwordAuthentication.getPassword();
                    Intrinsics.checkExpressionValueIsNotNull(password, "auth.password");
                    String str2 = new String(password);
                    Charset a2 = next.mo28067a();
                    Intrinsics.checkParameterIsNotNull(userName, "username");
                    Intrinsics.checkParameterIsNotNull(str2, "password");
                    Intrinsics.checkParameterIsNotNull(a2, "charset");
                    String str3 = userName + ':' + str2;
                    C2073i.C2074a aVar = C2073i.f2895e;
                    Intrinsics.checkParameterIsNotNull(str3, "$this$encode");
                    Intrinsics.checkParameterIsNotNull(a2, "charset");
                    byte[] bytes = str3.getBytes(a2);
                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                    String a3 = C0681a.m320a("Basic ", new C2073i(bytes).mo29203a());
                    C1755F.C1756a aVar2 = new C1755F.C1756a(y);
                    aVar2.mo27550a(str, a3);
                    return aVar2.mo27551a();
                }
            }
        }
        return null;
    }
}
