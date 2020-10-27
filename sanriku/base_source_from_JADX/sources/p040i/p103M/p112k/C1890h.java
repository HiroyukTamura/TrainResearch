package p040i.p103M.p112k;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C0974E;
import p040i.C1752D;
import p040i.p103M.p115m.C1904a;
import p040i.p103M.p115m.C1905b;
import p040i.p103M.p115m.C1906c;
import p040i.p103M.p115m.C1908e;
import p042j.C2068f;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J-\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0011\u0010\u0010\u001a\r\u0012\t\u0012\u00070\u0012¢\u0006\u0002\b\u00130\u0011H\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\u000fJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u001a2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\nH\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010.\u001a\u00020+H\u0016¨\u00060"}, mo21739d2 = {"Lokhttp3/internal/platform/Platform;", "", "()V", "afterHandshake", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "buildTrustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "configureTlsExtensions", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "connectSocket", "socket", "Ljava/net/Socket;", "address", "Ljava/net/InetSocketAddress;", "connectTimeout", "", "getPrefix", "getSelectedProtocol", "getStackTraceForCloseable", "closer", "isCleartextTrafficPermitted", "", "log", "message", "level", "t", "", "logCloseableLeak", "stackTrace", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "newSslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "platformTrustManager", "toString", "sslSocketFactory", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.k.h */
public class C1890h {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static volatile C1890h f2681a;

    /* renamed from: b */
    private static final Logger f2682b = Logger.getLogger(C1752D.class.getName());

    /* renamed from: c */
    public static final C1891a f2683c = new C1891a((DefaultConstructorMarker) null);

    /* renamed from: i.M.k.h$a */
    public static final class C1891a {
        public /* synthetic */ C1891a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final List<String> mo27985a(List<? extends C0974E> list) {
            Intrinsics.checkParameterIsNotNull(list, "protocols");
            ArrayList<C0974E> arrayList = new ArrayList<>();
            for (T next : list) {
                if (((C0974E) next) != C0974E.HTTP_1_0) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (C0974E e : arrayList) {
                arrayList2.add(e.toString());
            }
            return arrayList2;
        }

        /* renamed from: b */
        public final byte[] mo27986b(List<? extends C0974E> list) {
            Intrinsics.checkParameterIsNotNull(list, "protocols");
            C2068f fVar = new C2068f();
            Iterator it = ((ArrayList) mo27985a(list)).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                fVar.writeByte(str.length());
                fVar.mo29138a(str);
            }
            return fVar.mo29149b();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        if (r0 != null) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
        if (r0 != null) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a5, code lost:
        if (r0 != null) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cf, code lost:
        if (java.lang.Integer.parseInt(r0) >= 9) goto L_0x0134;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0138  */
    static {
        /*
            i.M.k.h$a r0 = new i.M.k.h$a
            r1 = 0
            r0.<init>(r1)
            f2683c = r0
            i.M.k.a$a r0 = p040i.p103M.p112k.C1874a.f2652f
            boolean r0 = p040i.p103M.p112k.C1874a.f2651e
            if (r0 == 0) goto L_0x0016
            i.M.k.a r0 = new i.M.k.a
            r0.<init>()
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            if (r0 == 0) goto L_0x001b
            goto L_0x013d
        L_0x001b:
            i.M.k.b$a r0 = p040i.p103M.p112k.C1876b.f2656h
            boolean r0 = p040i.p103M.p112k.C1876b.f2655g
            if (r0 == 0) goto L_0x0029
            i.M.k.b r0 = new i.M.k.b
            r0.<init>()
            goto L_0x002a
        L_0x0029:
            r0 = r1
        L_0x002a:
            if (r0 == 0) goto L_0x002e
            goto L_0x013d
        L_0x002e:
            java.security.Provider[] r0 = java.security.Security.getProviders()
            r2 = 0
            r0 = r0[r2]
            java.lang.String r3 = "Security.getProviders()[0]"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            java.lang.String r0 = r0.getName()
            java.lang.String r4 = "Conscrypt"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0059
            i.M.k.d$a r0 = p040i.p103M.p112k.C1881d.f2665f
            boolean r0 = p040i.p103M.p112k.C1881d.f2664e
            if (r0 == 0) goto L_0x0054
            i.M.k.d r0 = new i.M.k.d
            r0.<init>(r1)
            goto L_0x0055
        L_0x0054:
            r0 = r1
        L_0x0055:
            if (r0 == 0) goto L_0x0059
            goto L_0x013d
        L_0x0059:
            java.security.Provider[] r0 = java.security.Security.getProviders()
            r0 = r0[r2]
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            java.lang.String r0 = r0.getName()
            java.lang.String r4 = "BC"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0081
            i.M.k.c$a r0 = p040i.p103M.p112k.C1879c.f2662f
            boolean r0 = p040i.p103M.p112k.C1879c.f2661e
            if (r0 == 0) goto L_0x007c
            i.M.k.c r0 = new i.M.k.c
            r0.<init>(r1)
            goto L_0x007d
        L_0x007c:
            r0 = r1
        L_0x007d:
            if (r0 == 0) goto L_0x0081
            goto L_0x013d
        L_0x0081:
            java.security.Provider[] r0 = java.security.Security.getProviders()
            r0 = r0[r2]
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            java.lang.String r0 = r0.getName()
            java.lang.String r3 = "OpenJSSE"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x00a9
            i.M.k.g$a r0 = p040i.p103M.p112k.C1888g.f2679f
            boolean r0 = p040i.p103M.p112k.C1888g.f2678e
            if (r0 == 0) goto L_0x00a4
            i.M.k.g r0 = new i.M.k.g
            r0.<init>(r1)
            goto L_0x00a5
        L_0x00a4:
            r0 = r1
        L_0x00a5:
            if (r0 == 0) goto L_0x00a9
            goto L_0x013d
        L_0x00a9:
            i.M.k.f$a r0 = p040i.p103M.p112k.C1886f.f2677e
            boolean r0 = p040i.p103M.p112k.C1886f.f2676d
            if (r0 == 0) goto L_0x00b7
            i.M.k.f r0 = new i.M.k.f
            r0.<init>()
            goto L_0x00b8
        L_0x00b7:
            r0 = r1
        L_0x00b8:
            if (r0 == 0) goto L_0x00bc
            goto L_0x013d
        L_0x00bc:
            java.lang.String r0 = "java.specification.version"
            java.lang.String r3 = "unknown"
            java.lang.String r0 = java.lang.System.getProperty(r0, r3)
            java.lang.String r3 = "jvmVersion"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)     // Catch:{ NumberFormatException -> 0x00d2 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x00d2 }
            r3 = 9
            if (r0 < r3) goto L_0x00d2
            goto L_0x0134
        L_0x00d2:
            java.lang.String r0 = "org.eclipse.jetty.alpn.ALPN"
            r3 = 1
            java.lang.Class r0 = java.lang.Class.forName(r0, r3, r1)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.String r4 = "org.eclipse.jetty.alpn.ALPN$Provider"
            java.lang.Class r4 = java.lang.Class.forName(r4, r3, r1)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.String r5 = "org.eclipse.jetty.alpn.ALPN$ClientProvider"
            java.lang.Class r10 = java.lang.Class.forName(r5, r3, r1)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.String r5 = "org.eclipse.jetty.alpn.ALPN$ServerProvider"
            java.lang.Class r11 = java.lang.Class.forName(r5, r3, r1)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.String r5 = "put"
            r6 = 2
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.Class<javax.net.ssl.SSLSocket> r7 = javax.net.ssl.SSLSocket.class
            r6[r2] = r7     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            r6[r3] = r4     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.reflect.Method r7 = r0.getMethod(r5, r6)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.String r4 = "get"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.Class<javax.net.ssl.SSLSocket> r6 = javax.net.ssl.SSLSocket.class
            r5[r2] = r6     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.reflect.Method r8 = r0.getMethod(r4, r5)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.String r4 = "remove"
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.Class<javax.net.ssl.SSLSocket> r5 = javax.net.ssl.SSLSocket.class
            r3[r2] = r5     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.reflect.Method r9 = r0.getMethod(r4, r3)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            i.M.k.e r0 = new i.M.k.e     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.String r2 = "putMethod"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r2)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.String r2 = "getMethod"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r2)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.String r2 = "removeMethod"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r2)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.String r2 = "clientProviderClass"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r2)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            java.lang.String r2 = "serverProviderClass"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r11, r2)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0133 }
            r1 = r0
            goto L_0x0134
        L_0x0133:
        L_0x0134:
            if (r1 == 0) goto L_0x0138
            r0 = r1
            goto L_0x013d
        L_0x0138:
            i.M.k.h r0 = new i.M.k.h
            r0.<init>()
        L_0x013d:
            f2681a = r0
            java.lang.Class<i.D> r0 = p040i.C1752D.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            f2682b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p112k.C1890h.<clinit>():void");
    }

    /* renamed from: a */
    public static /* synthetic */ void m3195a(C1890h hVar, String str, int i, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 4;
            }
            if ((i2 & 4) != 0) {
                th = null;
            }
            hVar.mo27964a(str, i, th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }

    /* renamed from: a */
    public C1906c mo27963a(X509TrustManager x509TrustManager) {
        Intrinsics.checkParameterIsNotNull(x509TrustManager, "trustManager");
        return new C1904a(mo27971b(x509TrustManager));
    }

    /* renamed from: a */
    public Object mo27968a(String str) {
        Intrinsics.checkParameterIsNotNull(str, "closer");
        if (f2682b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: a */
    public SSLContext mo27976a() {
        SSLContext instance = SSLContext.getInstance("TLS");
        Intrinsics.checkExpressionValueIsNotNull(instance, "SSLContext.getInstance(\"TLS\")");
        return instance;
    }

    /* renamed from: a */
    public void mo27964a(String str, int i, Throwable th) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        f2682b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: a */
    public void mo27969a(String str, Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        if (obj == null) {
            str = C0681a.m320a(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        mo27964a(str, 5, (Throwable) obj);
    }

    /* renamed from: a */
    public void mo27970a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        Intrinsics.checkParameterIsNotNull(socket, "socket");
        Intrinsics.checkParameterIsNotNull(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: a */
    public void mo27980a(SSLSocket sSLSocket) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
    }

    /* renamed from: a */
    public void mo27965a(SSLSocket sSLSocket, String str, List<C0974E> list) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics.checkParameterIsNotNull(list, "protocols");
    }

    /* renamed from: b */
    public C1908e mo27971b(X509TrustManager x509TrustManager) {
        Intrinsics.checkParameterIsNotNull(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        Intrinsics.checkExpressionValueIsNotNull(acceptedIssuers, "trustManager.acceptedIssuers");
        return new C1905b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    /* renamed from: b */
    public String mo27966b(SSLSocket sSLSocket) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return null;
    }

    /* renamed from: b */
    public X509TrustManager mo27977b() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init((KeyStore) null);
        Intrinsics.checkExpressionValueIsNotNull(instance, "factory");
        TrustManager[] trustManagers = instance.getTrustManagers();
        if (trustManagers == null) {
            Intrinsics.throwNpe();
        }
        boolean z = true;
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            z = false;
        }
        if (z) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        StringBuilder a = C0681a.m330a("Unexpected default trust managers: ");
        String arrays = Arrays.toString(trustManagers);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        a.append(arrays);
        throw new IllegalStateException(a.toString().toString());
    }

    /* renamed from: b */
    public boolean mo27967b(String str) {
        Intrinsics.checkParameterIsNotNull(str, "hostname");
        return true;
    }

    /* renamed from: c */
    public SSLSocketFactory mo27978c(X509TrustManager x509TrustManager) {
        Intrinsics.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            SSLContext a = mo27976a();
            a.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            SSLSocketFactory socketFactory = a.getSocketFactory();
            Intrinsics.checkExpressionValueIsNotNull(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
