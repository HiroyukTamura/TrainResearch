package p040i.p103M.p112k.p113i;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import p040i.C0974E;
import p040i.p103M.p112k.C1876b;
import p040i.p103M.p112k.C1890h;

/* renamed from: i.M.k.i.c */
public class C1895c implements C1900h {

    /* renamed from: a */
    private final Method f2686a;

    /* renamed from: b */
    private final Method f2687b = this.f2690e.getMethod("setHostname", new Class[]{String.class});

    /* renamed from: c */
    private final Method f2688c = this.f2690e.getMethod("getAlpnSelectedProtocol", new Class[0]);

    /* renamed from: d */
    private final Method f2689d = this.f2690e.getMethod("setAlpnProtocols", new Class[]{byte[].class});

    /* renamed from: e */
    private final Class<? super SSLSocket> f2690e;

    public C1895c(Class<? super SSLSocket> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "sslSocketClass");
        this.f2690e = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", new Class[]{Boolean.TYPE});
        Intrinsics.checkExpressionValueIsNotNull(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f2686a = declaredMethod;
    }

    /* renamed from: a */
    public String mo27987a(SSLSocket sSLSocket) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (!mo27990b(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f2688c.invoke(sSLSocket, new Object[0]);
            if (bArr == null) {
                return null;
            }
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkExpressionValueIsNotNull(charset, "StandardCharsets.UTF_8");
            return new String(bArr, charset);
        } catch (NullPointerException e) {
            if (Intrinsics.areEqual((Object) e.getMessage(), (Object) "ssl == null")) {
                return null;
            }
            throw e;
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }

    /* renamed from: a */
    public void mo27988a(SSLSocket sSLSocket, String str, List<? extends C0974E> list) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics.checkParameterIsNotNull(list, "protocols");
        if (mo27990b(sSLSocket)) {
            try {
                this.f2686a.invoke(sSLSocket, new Object[]{true});
                if (str != null) {
                    this.f2687b.invoke(sSLSocket, new Object[]{str});
                }
                this.f2689d.invoke(sSLSocket, new Object[]{C1890h.f2683c.mo27986b(list)});
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* renamed from: a */
    public boolean mo27989a() {
        C1876b.C1877a aVar = C1876b.f2656h;
        return C1876b.f2655g;
    }

    /* renamed from: b */
    public boolean mo27990b(SSLSocket sSLSocket) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return this.f2690e.isInstance(sSLSocket);
    }
}
