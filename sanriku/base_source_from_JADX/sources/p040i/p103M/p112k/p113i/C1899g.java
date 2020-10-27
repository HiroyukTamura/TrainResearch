package p040i.p103M.p112k.p113i;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import p040i.C0974E;
import p040i.p103M.p112k.C1890h;

/* renamed from: i.M.k.i.g */
public final class C1899g implements C1900h {

    /* renamed from: a */
    private boolean f2694a;

    /* renamed from: b */
    private C1900h f2695b;

    /* renamed from: c */
    private final String f2696c;

    public C1899g(String str) {
        Intrinsics.checkParameterIsNotNull(str, "socketPackage");
        this.f2696c = str;
    }

    /* renamed from: c */
    private final synchronized C1900h m3233c(SSLSocket sSLSocket) {
        if (!this.f2694a) {
            try {
                Class cls = sSLSocket.getClass();
                while (true) {
                    String name = cls.getName();
                    if (!(!Intrinsics.areEqual((Object) name, (Object) this.f2696c + ".OpenSSLSocketImpl"))) {
                        break;
                    }
                    cls = cls.getSuperclass();
                    Intrinsics.checkExpressionValueIsNotNull(cls, "possibleClass.superclass");
                }
                this.f2695b = new C1895c(cls);
            } catch (Exception e) {
                C1890h.C1891a aVar = C1890h.f2683c;
                C1890h c = C1890h.f2681a;
                c.mo27964a("Failed to initialize DeferredSocketAdapter " + this.f2696c, 5, (Throwable) e);
            }
            this.f2694a = true;
        }
        return this.f2695b;
    }

    /* renamed from: a */
    public String mo27987a(SSLSocket sSLSocket) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        C1900h c = m3233c(sSLSocket);
        if (c != null) {
            return c.mo27987a(sSLSocket);
        }
        return null;
    }

    /* renamed from: a */
    public void mo27988a(SSLSocket sSLSocket, String str, List<? extends C0974E> list) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics.checkParameterIsNotNull(list, "protocols");
        C1900h c = m3233c(sSLSocket);
        if (c != null) {
            c.mo27988a(sSLSocket, str, list);
        }
    }

    /* renamed from: a */
    public boolean mo27989a() {
        return true;
    }

    /* renamed from: b */
    public boolean mo27990b(SSLSocket sSLSocket) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        String name = sSLSocket.getClass().getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "sslSocket.javaClass.name");
        return StringsKt__StringsJVMKt.startsWith$default(name, this.f2696c, false, 2, (Object) null);
    }
}
