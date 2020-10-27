package p040i.p103M.p112k;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;
import p040i.C0974E;
import p040i.p103M.p112k.C1879c;
import p040i.p103M.p112k.C1881d;
import p040i.p103M.p112k.p113i.C1894b;
import p040i.p103M.p112k.p113i.C1896d;
import p040i.p103M.p112k.p113i.C1897e;
import p040i.p103M.p112k.p113i.C1898f;
import p040i.p103M.p112k.p113i.C1899g;
import p040i.p103M.p112k.p113i.C1900h;
import p040i.p103M.p112k.p113i.C1901i;
import p040i.p103M.p115m.C1906c;
import p040i.p103M.p115m.C1908e;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J-\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0011\u0010\u0014\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u00160\u0006H\u0016J \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u0013H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010+\u001a\u00020,H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, mo21739d2 = {"Lokhttp3/internal/platform/AndroidPlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "closeGuard", "Lokhttp3/internal/platform/android/CloseGuard;", "socketAdapters", "", "Lokhttp3/internal/platform/android/SocketAdapter;", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "buildTrustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "connectSocket", "socket", "Ljava/net/Socket;", "address", "Ljava/net/InetSocketAddress;", "connectTimeout", "", "getSelectedProtocol", "getStackTraceForCloseable", "", "closer", "isCleartextTrafficPermitted", "", "log", "message", "level", "t", "", "logCloseableLeak", "stackTrace", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "CustomTrustRootIndex", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.k.b */
public final class C1876b extends C1890h {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final boolean f2654f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final boolean f2655g;

    /* renamed from: h */
    public static final C1877a f2656h = new C1877a((DefaultConstructorMarker) null);

    /* renamed from: d */
    private final List<C1900h> f2657d;

    /* renamed from: e */
    private final C1897e f2658e;

    /* renamed from: i.M.k.b$a */
    public static final class C1877a {
        public /* synthetic */ C1877a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* renamed from: i.M.k.b$b */
    public static final class C1878b implements C1908e {

        /* renamed from: a */
        private final X509TrustManager f2659a;

        /* renamed from: b */
        private final Method f2660b;

        public C1878b(X509TrustManager x509TrustManager, Method method) {
            Intrinsics.checkParameterIsNotNull(x509TrustManager, "trustManager");
            Intrinsics.checkParameterIsNotNull(method, "findByIssuerAndSignatureMethod");
            this.f2659a = x509TrustManager;
            this.f2660b = method;
        }

        /* renamed from: a */
        public X509Certificate mo27972a(X509Certificate x509Certificate) {
            Intrinsics.checkParameterIsNotNull(x509Certificate, "cert");
            try {
                Object invoke = this.f2660b.invoke(this.f2659a, new Object[]{x509Certificate});
                if (invoke != null) {
                    return ((TrustAnchor) invoke).getTrustedCert();
                }
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1878b)) {
                return false;
            }
            C1878b bVar = (C1878b) obj;
            return Intrinsics.areEqual((Object) this.f2659a, (Object) bVar.f2659a) && Intrinsics.areEqual((Object) this.f2660b, (Object) bVar.f2660b);
        }

        public int hashCode() {
            X509TrustManager x509TrustManager = this.f2659a;
            int i = 0;
            int hashCode = (x509TrustManager != null ? x509TrustManager.hashCode() : 0) * 31;
            Method method = this.f2660b;
            if (method != null) {
                i = method.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("CustomTrustRootIndex(trustManager=");
            a.append(this.f2659a);
            a.append(", findByIssuerAndSignatureMethod=");
            a.append(this.f2660b);
            a.append(")");
            return a.toString();
        }
    }

    static {
        boolean z;
        int i;
        boolean z2 = true;
        boolean z3 = false;
        try {
            Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            if (1 != 0) {
                z = true;
                f2654f = z;
                if (z && (i = Build.VERSION.SDK_INT) < 30) {
                    if (i >= 21) {
                        z3 = true;
                    }
                    if (!z3) {
                        StringBuilder a = C0681a.m330a("Expected Android API level 21+ but was ");
                        a.append(Build.VERSION.SDK_INT);
                        throw new IllegalStateException(a.toString().toString());
                    }
                } else {
                    z2 = false;
                }
                f2655g = z2;
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        } catch (ClassNotFoundException | UnsatisfiedLinkError unused) {
            z = false;
        }
    }

    public C1876b() {
        C1901i iVar;
        Method method;
        Method method2;
        C1900h[] hVarArr = new C1900h[4];
        C1901i.C1902a aVar = C1901i.f2697f;
        Intrinsics.checkParameterIsNotNull("com.android.org.conscrypt", "packageName");
        Method method3 = null;
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            Class<?> cls2 = Class.forName("com.android.org.conscrypt" + ".OpenSSLSocketFactoryImpl");
            Class<?> cls3 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            Intrinsics.checkExpressionValueIsNotNull(cls3, "paramsClass");
            iVar = new C1901i(cls, cls2, cls3);
        } catch (Exception e) {
            C1532a.m2134a(5, "unable to load android socket classes", (Throwable) e);
            iVar = null;
        }
        hVarArr[0] = iVar;
        C1881d.C1882a aVar2 = C1881d.f2665f;
        hVarArr[1] = C1881d.f2664e ? new C1898f() : null;
        hVarArr[2] = new C1899g("com.google.android.gms.org.conscrypt");
        C1879c.C1880a aVar3 = C1879c.f2662f;
        hVarArr[3] = C1879c.f2661e ? new C1896d() : null;
        List listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((T[]) hVarArr);
        ArrayList arrayList = new ArrayList();
        for (Object next : listOfNotNull) {
            if (((C1900h) next).mo27989a()) {
                arrayList.add(next);
            }
        }
        this.f2657d = arrayList;
        try {
            Class<?> cls4 = Class.forName("dalvik.system.CloseGuard");
            Method method4 = cls4.getMethod("get", new Class[0]);
            method = cls4.getMethod("open", new Class[]{String.class});
            method2 = cls4.getMethod("warnIfOpen", new Class[0]);
            method3 = method4;
        } catch (Exception unused) {
            method2 = null;
            method = null;
        }
        this.f2658e = new C1897e(method3, method, method2);
    }

    /* renamed from: a */
    public C1906c mo27963a(X509TrustManager x509TrustManager) {
        Intrinsics.checkParameterIsNotNull(x509TrustManager, "trustManager");
        C1894b a = C1894b.m3217a(x509TrustManager);
        return a != null ? a : super.mo27963a(x509TrustManager);
    }

    /* renamed from: a */
    public Object mo27968a(String str) {
        Intrinsics.checkParameterIsNotNull(str, "closer");
        return this.f2658e.mo27994a(str);
    }

    /* renamed from: a */
    public void mo27964a(String str, int i, Throwable th) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        C1532a.m2134a(i, str, th);
    }

    /* renamed from: a */
    public void mo27969a(String str, Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        if (!this.f2658e.mo27995a(obj)) {
            C1890h.m3195a(this, str, 5, (Throwable) null, 4, (Object) null);
        }
    }

    /* renamed from: a */
    public void mo27970a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        Intrinsics.checkParameterIsNotNull(socket, "socket");
        Intrinsics.checkParameterIsNotNull(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", e);
            }
            throw e;
        }
    }

    /* renamed from: a */
    public void mo27965a(SSLSocket sSLSocket, String str, List<C0974E> list) {
        T t;
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics.checkParameterIsNotNull(list, "protocols");
        Iterator<T> it = this.f2657d.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((C1900h) t).mo27990b(sSLSocket)) {
                break;
            }
        }
        C1900h hVar = (C1900h) t;
        if (hVar != null) {
            hVar.mo27988a(sSLSocket, str, list);
        }
    }

    /* renamed from: b */
    public C1908e mo27971b(X509TrustManager x509TrustManager) {
        Intrinsics.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            Intrinsics.checkExpressionValueIsNotNull(declaredMethod, FirebaseAnalytics.Param.METHOD);
            declaredMethod.setAccessible(true);
            return new C1878b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo27971b(x509TrustManager);
        }
    }

    /* renamed from: b */
    public String mo27966b(SSLSocket sSLSocket) {
        T t;
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Iterator<T> it = this.f2657d.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((C1900h) t).mo27990b(sSLSocket)) {
                break;
            }
        }
        C1900h hVar = (C1900h) t;
        if (hVar != null) {
            return hVar.mo27987a(sSLSocket);
        }
        return null;
    }

    /* renamed from: b */
    public boolean mo27967b(String str) {
        Intrinsics.checkParameterIsNotNull(str, "hostname");
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        if (i < 23) {
            return true;
        }
        NetworkSecurityPolicy instance = NetworkSecurityPolicy.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "NetworkSecurityPolicy.getInstance()");
        return instance.isCleartextTrafficPermitted();
    }
}
