package p040i.p103M.p112k;

import android.annotation.SuppressLint;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p028d.p030b.p054b.C1532a;
import p040i.C0974E;
import p040i.p103M.p112k.C1876b;
import p040i.p103M.p112k.C1879c;
import p040i.p103M.p112k.C1881d;
import p040i.p103M.p112k.p113i.C1892a;
import p040i.p103M.p112k.p113i.C1894b;
import p040i.p103M.p112k.p113i.C1896d;
import p040i.p103M.p112k.p113i.C1898f;
import p040i.p103M.p112k.p113i.C1899g;
import p040i.p103M.p112k.p113i.C1900h;
import p040i.p103M.p115m.C1906c;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\"\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo21739d2 = {"Lokhttp3/internal/platform/Android10Platform;", "Lokhttp3/internal/platform/Platform;", "()V", "socketAdapters", "", "Lokhttp3/internal/platform/android/SocketAdapter;", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "Lokhttp3/Protocol;", "getSelectedProtocol", "isCleartextTrafficPermitted", "", "log", "message", "level", "", "t", "", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.k.a */
public final class C1874a extends C1890h {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final boolean f2651e = (C1876b.f2654f && Build.VERSION.SDK_INT >= 29);

    /* renamed from: f */
    public static final C1875a f2652f = new C1875a((DefaultConstructorMarker) null);

    /* renamed from: d */
    private final List<C1900h> f2653d;

    /* renamed from: i.M.k.a$a */
    public static final class C1875a {
        public /* synthetic */ C1875a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        C1876b.C1877a aVar = C1876b.f2656h;
    }

    public C1874a() {
        C1900h[] hVarArr = new C1900h[4];
        C1896d dVar = null;
        hVarArr[0] = C1892a.C1893a.m3216a() ? new C1892a() : null;
        C1881d.C1882a aVar = C1881d.f2665f;
        hVarArr[1] = C1881d.f2664e ? new C1898f() : null;
        hVarArr[2] = new C1899g("com.google.android.gms.org.conscrypt");
        C1879c.C1880a aVar2 = C1879c.f2662f;
        hVarArr[3] = C1879c.f2661e ? new C1896d() : dVar;
        List listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((T[]) hVarArr);
        ArrayList arrayList = new ArrayList();
        for (Object next : listOfNotNull) {
            if (((C1900h) next).mo27989a()) {
                arrayList.add(next);
            }
        }
        this.f2653d = arrayList;
    }

    /* renamed from: a */
    public C1906c mo27963a(X509TrustManager x509TrustManager) {
        Intrinsics.checkParameterIsNotNull(x509TrustManager, "trustManager");
        C1894b a = C1894b.m3217a(x509TrustManager);
        return a != null ? a : super.mo27963a(x509TrustManager);
    }

    /* renamed from: a */
    public void mo27964a(String str, int i, Throwable th) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        C1532a.m2134a(i, str, th);
    }

    /* renamed from: a */
    public void mo27965a(SSLSocket sSLSocket, String str, List<? extends C0974E> list) {
        T t;
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics.checkParameterIsNotNull(list, "protocols");
        Iterator<T> it = this.f2653d.iterator();
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
    public String mo27966b(SSLSocket sSLSocket) {
        T t;
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Iterator<T> it = this.f2653d.iterator();
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

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public boolean mo27967b(String str) {
        Intrinsics.checkParameterIsNotNull(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
