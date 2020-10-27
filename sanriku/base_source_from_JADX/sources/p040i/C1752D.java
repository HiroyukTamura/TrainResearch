package p040i;

import android.support.p001v4.media.session.PlaybackStateCompat;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import p040i.C1923f;
import p040i.C1943t;
import p040i.p103M.C1764b;
import p040i.p103M.p107f.C1799e;
import p040i.p103M.p107f.C1809k;
import p040i.p103M.p115m.C1906c;
import p040i.p103M.p115m.C1907d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 y2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002xyB\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u000f\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\bSJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\bTJ\r\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\bUJ\r\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\bVJ\r\u0010\u0017\u001a\u00020\u000fH\u0007¢\u0006\u0002\bWJ\r\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\bXJ\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007¢\u0006\u0002\bYJ\r\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\bZJ\r\u0010\"\u001a\u00020#H\u0007¢\u0006\u0002\b[J\r\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\b\\J\r\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\b]J\r\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\b^J\r\u0010.\u001a\u00020,H\u0007¢\u0006\u0002\b_J\r\u0010/\u001a\u000200H\u0007¢\u0006\u0002\b`J\u0013\u00102\u001a\b\u0012\u0004\u0012\u0002030\u001cH\u0007¢\u0006\u0002\baJ\u0013\u00107\u001a\b\u0012\u0004\u0012\u0002030\u001cH\u0007¢\u0006\u0002\bbJ\b\u0010c\u001a\u00020\u0006H\u0016J\u0010\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0016J\u0018\u0010h\u001a\u00020i2\u0006\u0010f\u001a\u00020g2\u0006\u0010j\u001a\u00020kH\u0016J\r\u00108\u001a\u00020\u000fH\u0007¢\u0006\u0002\blJ\u0013\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u001cH\u0007¢\u0006\u0002\bmJ\u000f\u0010;\u001a\u0004\u0018\u00010<H\u0007¢\u0006\u0002\bnJ\r\u0010>\u001a\u00020\tH\u0007¢\u0006\u0002\boJ\r\u0010?\u001a\u00020@H\u0007¢\u0006\u0002\bpJ\r\u0010B\u001a\u00020\u000fH\u0007¢\u0006\u0002\bqJ\r\u0010C\u001a\u00020,H\u0007¢\u0006\u0002\brJ\r\u0010H\u001a\u00020IH\u0007¢\u0006\u0002\bsJ\r\u0010K\u001a\u00020LH\u0007¢\u0006\u0002\btJ\b\u0010u\u001a\u00020vH\u0002J\r\u0010O\u001a\u00020\u000fH\u0007¢\u0006\u0002\bwR\u0013\u0010\b\u001a\u00020\t8G¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f8G¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0013\u0010\u000e\u001a\u00020\u000f8G¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00128G¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0013R\u0013\u0010\u0014\u001a\u00020\u00158G¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0016R\u0013\u0010\u0017\u001a\u00020\u000f8G¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u0018\u001a\u00020\u00198G¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001aR\u0019\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8G¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001eR\u0013\u0010\u001f\u001a\u00020 8G¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010!R\u0013\u0010\"\u001a\u00020#8G¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010$R\u0013\u0010%\u001a\u00020&8G¢\u0006\b\n\u0000\u001a\u0004\b%\u0010'R\u0013\u0010(\u001a\u00020)8G¢\u0006\b\n\u0000\u001a\u0004\b(\u0010*R\u0013\u0010+\u001a\u00020,8G¢\u0006\b\n\u0000\u001a\u0004\b+\u0010-R\u0013\u0010.\u001a\u00020,8G¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0013\u0010/\u001a\u0002008G¢\u0006\b\n\u0000\u001a\u0004\b/\u00101R\u0019\u00102\u001a\b\u0012\u0004\u0012\u0002030\u001c8G¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u0013\u00104\u001a\u0002058G¢\u0006\b\n\u0000\u001a\u0004\b4\u00106R\u0019\u00107\u001a\b\u0012\u0004\u0012\u0002030\u001c8G¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001eR\u0013\u00108\u001a\u00020\u000f8G¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0010R\u0019\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u001c8G¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001eR\u0015\u0010;\u001a\u0004\u0018\u00010<8G¢\u0006\b\n\u0000\u001a\u0004\b;\u0010=R\u0013\u0010>\u001a\u00020\t8G¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\nR\u0013\u0010?\u001a\u00020@8G¢\u0006\b\n\u0000\u001a\u0004\b?\u0010AR\u0013\u0010B\u001a\u00020\u000f8G¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0010R\u0013\u0010C\u001a\u00020,8G¢\u0006\b\n\u0000\u001a\u0004\bC\u0010-R\u0011\u0010D\u001a\u00020E¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0013\u0010H\u001a\u00020I8G¢\u0006\b\n\u0000\u001a\u0004\bH\u0010JR\u0011\u0010K\u001a\u00020L8G¢\u0006\u0006\u001a\u0004\bK\u0010MR\u0010\u0010N\u001a\u0004\u0018\u00010LX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010O\u001a\u00020\u000f8G¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0010R\u0015\u0010P\u001a\u0004\u0018\u00010Q8G¢\u0006\b\n\u0000\u001a\u0004\bP\u0010R¨\u0006z"}, mo21739d2 = {"Lokhttp3/OkHttpClient;", "", "Lokhttp3/Call$Factory;", "Lokhttp3/WebSocket$Factory;", "()V", "builder", "Lokhttp3/OkHttpClient$Builder;", "(Lokhttp3/OkHttpClient$Builder;)V", "authenticator", "Lokhttp3/Authenticator;", "()Lokhttp3/Authenticator;", "cache", "Lokhttp3/Cache;", "()Lokhttp3/Cache;", "callTimeoutMillis", "", "()I", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "certificatePinner", "Lokhttp3/CertificatePinner;", "()Lokhttp3/CertificatePinner;", "connectTimeoutMillis", "connectionPool", "Lokhttp3/ConnectionPool;", "()Lokhttp3/ConnectionPool;", "connectionSpecs", "", "Lokhttp3/ConnectionSpec;", "()Ljava/util/List;", "cookieJar", "Lokhttp3/CookieJar;", "()Lokhttp3/CookieJar;", "dispatcher", "Lokhttp3/Dispatcher;", "()Lokhttp3/Dispatcher;", "dns", "Lokhttp3/Dns;", "()Lokhttp3/Dns;", "eventListenerFactory", "Lokhttp3/EventListener$Factory;", "()Lokhttp3/EventListener$Factory;", "followRedirects", "", "()Z", "followSslRedirects", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "()Ljavax/net/ssl/HostnameVerifier;", "interceptors", "Lokhttp3/Interceptor;", "minWebSocketMessageToCompress", "", "()J", "networkInterceptors", "pingIntervalMillis", "protocols", "Lokhttp3/Protocol;", "proxy", "Ljava/net/Proxy;", "()Ljava/net/Proxy;", "proxyAuthenticator", "proxySelector", "Ljava/net/ProxySelector;", "()Ljava/net/ProxySelector;", "readTimeoutMillis", "retryOnConnectionFailure", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase", "()Lokhttp3/internal/connection/RouteDatabase;", "socketFactory", "Ljavax/net/SocketFactory;", "()Ljavax/net/SocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactoryOrNull", "writeTimeoutMillis", "x509TrustManager", "Ljavax/net/ssl/X509TrustManager;", "()Ljavax/net/ssl/X509TrustManager;", "-deprecated_authenticator", "-deprecated_cache", "-deprecated_callTimeoutMillis", "-deprecated_certificatePinner", "-deprecated_connectTimeoutMillis", "-deprecated_connectionPool", "-deprecated_connectionSpecs", "-deprecated_cookieJar", "-deprecated_dispatcher", "-deprecated_dns", "-deprecated_eventListenerFactory", "-deprecated_followRedirects", "-deprecated_followSslRedirects", "-deprecated_hostnameVerifier", "-deprecated_interceptors", "-deprecated_networkInterceptors", "newBuilder", "newCall", "Lokhttp3/Call;", "request", "Lokhttp3/Request;", "newWebSocket", "Lokhttp3/WebSocket;", "listener", "Lokhttp3/WebSocketListener;", "-deprecated_pingIntervalMillis", "-deprecated_protocols", "-deprecated_proxy", "-deprecated_proxyAuthenticator", "-deprecated_proxySelector", "-deprecated_readTimeoutMillis", "-deprecated_retryOnConnectionFailure", "-deprecated_socketFactory", "-deprecated_sslSocketFactory", "verifyClientState", "", "-deprecated_writeTimeoutMillis", "Builder", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.D */
public class C1752D implements Cloneable, C1923f.C1924a {
    /* access modifiers changed from: private */

    /* renamed from: G */
    public static final List<C0974E> f2100G = C1764b.m2624a((T[]) new C0974E[]{C0974E.HTTP_2, C0974E.HTTP_1_1});
    /* access modifiers changed from: private */

    /* renamed from: H */
    public static final List<C1936m> f2101H = C1764b.m2624a((T[]) new C1936m[]{C1936m.f2806g, C1936m.f2807h});

    /* renamed from: I */
    public static final C1754b f2102I = new C1754b((DefaultConstructorMarker) null);

    /* renamed from: A */
    private final int f2103A;

    /* renamed from: B */
    private final int f2104B;

    /* renamed from: C */
    private final int f2105C;

    /* renamed from: D */
    private final int f2106D;

    /* renamed from: E */
    private final long f2107E;

    /* renamed from: F */
    private final C1809k f2108F;

    /* renamed from: a */
    private final C1940q f2109a;

    /* renamed from: b */
    private final C1935l f2110b;

    /* renamed from: c */
    private final List<C1744A> f2111c;

    /* renamed from: d */
    private final List<C1744A> f2112d;

    /* renamed from: e */
    private final C1943t.C1945b f2113e;

    /* renamed from: f */
    private final boolean f2114f;

    /* renamed from: g */
    private final C1914c f2115g;

    /* renamed from: h */
    private final boolean f2116h;

    /* renamed from: i */
    private final boolean f2117i;

    /* renamed from: l */
    private final C1939p f2118l;

    /* renamed from: m */
    private final C1915d f2119m;

    /* renamed from: n */
    private final C1942s f2120n;

    /* renamed from: o */
    private final Proxy f2121o;

    /* renamed from: p */
    private final ProxySelector f2122p;

    /* renamed from: q */
    private final C1914c f2123q;

    /* renamed from: r */
    private final SocketFactory f2124r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final SSLSocketFactory f2125s;

    /* renamed from: t */
    private final X509TrustManager f2126t;

    /* renamed from: u */
    private final List<C1936m> f2127u;

    /* renamed from: v */
    private final List<C0974E> f2128v;

    /* renamed from: w */
    private final HostnameVerifier f2129w;

    /* renamed from: x */
    private final C1926h f2130x;

    /* renamed from: y */
    private final C1906c f2131y;

    /* renamed from: z */
    private final int f2132z;

    /* renamed from: i.D$a */
    public static final class C1753a {

        /* renamed from: A */
        private int f2133A;

        /* renamed from: B */
        private int f2134B;

        /* renamed from: C */
        private long f2135C;

        /* renamed from: D */
        private C1809k f2136D;

        /* renamed from: a */
        private C1940q f2137a;

        /* renamed from: b */
        private C1935l f2138b;

        /* renamed from: c */
        private final List<C1744A> f2139c;

        /* renamed from: d */
        private final List<C1744A> f2140d;

        /* renamed from: e */
        private C1943t.C1945b f2141e;

        /* renamed from: f */
        private boolean f2142f;

        /* renamed from: g */
        private C1914c f2143g;

        /* renamed from: h */
        private boolean f2144h;

        /* renamed from: i */
        private boolean f2145i;

        /* renamed from: j */
        private C1939p f2146j;

        /* renamed from: k */
        private C1915d f2147k;

        /* renamed from: l */
        private C1942s f2148l;

        /* renamed from: m */
        private Proxy f2149m;

        /* renamed from: n */
        private ProxySelector f2150n;

        /* renamed from: o */
        private C1914c f2151o;

        /* renamed from: p */
        private SocketFactory f2152p;

        /* renamed from: q */
        private SSLSocketFactory f2153q;

        /* renamed from: r */
        private X509TrustManager f2154r;

        /* renamed from: s */
        private List<C1936m> f2155s;

        /* renamed from: t */
        private List<? extends C0974E> f2156t;

        /* renamed from: u */
        private HostnameVerifier f2157u;

        /* renamed from: v */
        private C1926h f2158v;

        /* renamed from: w */
        private C1906c f2159w;

        /* renamed from: x */
        private int f2160x;

        /* renamed from: y */
        private int f2161y;

        /* renamed from: z */
        private int f2162z;

        public C1753a() {
            this.f2137a = new C1940q();
            this.f2138b = new C1935l();
            this.f2139c = new ArrayList();
            this.f2140d = new ArrayList();
            this.f2141e = C1764b.m2618a(C1943t.f2834a);
            this.f2142f = true;
            this.f2143g = C1914c.f2719a;
            this.f2144h = true;
            this.f2145i = true;
            this.f2146j = C1939p.f2826a;
            this.f2148l = C1942s.f2833a;
            this.f2151o = C1914c.f2719a;
            SocketFactory socketFactory = SocketFactory.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(socketFactory, "SocketFactory.getDefault()");
            this.f2152p = socketFactory;
            C1754b bVar = C1752D.f2102I;
            this.f2155s = C1752D.f2101H;
            C1754b bVar2 = C1752D.f2102I;
            this.f2156t = C1752D.f2100G;
            this.f2157u = C1907d.f2701a;
            this.f2158v = C1926h.f2770c;
            this.f2161y = 10000;
            this.f2162z = 10000;
            this.f2133A = 10000;
            this.f2135C = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public C1753a(C1752D d) {
            this();
            Intrinsics.checkParameterIsNotNull(d, "okHttpClient");
            this.f2137a = d.mo27479j();
            this.f2138b = d.mo27476g();
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(this.f2139c, d.mo27486q());
            boolean unused2 = CollectionsKt__MutableCollectionsKt.addAll(this.f2140d, d.mo27488s());
            this.f2141e = d.mo27481l();
            this.f2142f = d.mo27495z();
            this.f2143g = d.mo27468a();
            this.f2144h = d.mo27482m();
            this.f2145i = d.mo27483n();
            this.f2146j = d.mo27478i();
            this.f2147k = d.mo27470b();
            this.f2148l = d.mo27480k();
            this.f2149m = d.mo27491v();
            this.f2150n = d.mo27493x();
            this.f2151o = d.mo27492w();
            this.f2152p = d.mo27464A();
            this.f2153q = d.f2125s;
            this.f2154r = d.mo27467D();
            this.f2155s = d.mo27477h();
            this.f2156t = d.mo27490u();
            this.f2157u = d.mo27485p();
            this.f2158v = d.mo27474e();
            this.f2159w = d.mo27473d();
            this.f2160x = d.mo27471c();
            this.f2161y = d.mo27475f();
            this.f2162z = d.mo27494y();
            this.f2133A = d.mo27466C();
            this.f2134B = d.mo27489t();
            this.f2135C = d.mo27487r();
            this.f2136D = d.mo27484o();
        }

        /* renamed from: A */
        public final SocketFactory mo27496A() {
            return this.f2152p;
        }

        /* renamed from: B */
        public final SSLSocketFactory mo27497B() {
            return this.f2153q;
        }

        /* renamed from: C */
        public final int mo27498C() {
            return this.f2133A;
        }

        /* renamed from: D */
        public final X509TrustManager mo27499D() {
            return this.f2154r;
        }

        /* renamed from: a */
        public final C1753a mo27500a(long j, TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
            this.f2160x = C1764b.m2613a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: a */
        public final C1753a mo27501a(C1744A a) {
            Intrinsics.checkParameterIsNotNull(a, "interceptor");
            this.f2139c.add(a);
            return this;
        }

        /* renamed from: a */
        public final C1753a mo27502a(C1915d dVar) {
            this.f2147k = dVar;
            return this;
        }

        /* renamed from: a */
        public final C1753a mo27503a(boolean z) {
            this.f2142f = z;
            return this;
        }

        /* renamed from: a */
        public final C1914c mo27504a() {
            return this.f2143g;
        }

        /* renamed from: b */
        public final C1753a mo27505b(long j, TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
            this.f2161y = C1764b.m2613a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: b */
        public final C1915d mo27506b() {
            return this.f2147k;
        }

        /* renamed from: c */
        public final int mo27507c() {
            return this.f2160x;
        }

        /* renamed from: c */
        public final C1753a mo27508c(long j, TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
            this.f2162z = C1764b.m2613a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: d */
        public final C1753a mo27509d(long j, TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
            this.f2133A = C1764b.m2613a("timeout", j, timeUnit);
            return this;
        }

        /* renamed from: d */
        public final C1906c mo27510d() {
            return this.f2159w;
        }

        /* renamed from: e */
        public final C1926h mo27511e() {
            return this.f2158v;
        }

        /* renamed from: f */
        public final int mo27512f() {
            return this.f2161y;
        }

        /* renamed from: g */
        public final C1935l mo27513g() {
            return this.f2138b;
        }

        /* renamed from: h */
        public final List<C1936m> mo27514h() {
            return this.f2155s;
        }

        /* renamed from: i */
        public final C1939p mo27515i() {
            return this.f2146j;
        }

        /* renamed from: j */
        public final C1940q mo27516j() {
            return this.f2137a;
        }

        /* renamed from: k */
        public final C1942s mo27517k() {
            return this.f2148l;
        }

        /* renamed from: l */
        public final C1943t.C1945b mo27518l() {
            return this.f2141e;
        }

        /* renamed from: m */
        public final boolean mo27519m() {
            return this.f2144h;
        }

        /* renamed from: n */
        public final boolean mo27520n() {
            return this.f2145i;
        }

        /* renamed from: o */
        public final HostnameVerifier mo27521o() {
            return this.f2157u;
        }

        /* renamed from: p */
        public final List<C1744A> mo27522p() {
            return this.f2139c;
        }

        /* renamed from: q */
        public final long mo27523q() {
            return this.f2135C;
        }

        /* renamed from: r */
        public final List<C1744A> mo27524r() {
            return this.f2140d;
        }

        /* renamed from: s */
        public final int mo27525s() {
            return this.f2134B;
        }

        /* renamed from: t */
        public final List<C0974E> mo27526t() {
            return this.f2156t;
        }

        /* renamed from: u */
        public final Proxy mo27527u() {
            return this.f2149m;
        }

        /* renamed from: v */
        public final C1914c mo27528v() {
            return this.f2151o;
        }

        /* renamed from: w */
        public final ProxySelector mo27529w() {
            return this.f2150n;
        }

        /* renamed from: x */
        public final int mo27530x() {
            return this.f2162z;
        }

        /* renamed from: y */
        public final boolean mo27531y() {
            return this.f2142f;
        }

        /* renamed from: z */
        public final C1809k mo27532z() {
            return this.f2136D;
        }
    }

    /* renamed from: i.D$b */
    public static final class C1754b {
        public /* synthetic */ C1754b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public C1752D() {
        this(new C1753a());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0122, code lost:
        if (r0 == null) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0162, code lost:
        if (r0 == null) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0070, code lost:
        if (r0 != null) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1752D(p040i.C1752D.C1753a r5) {
        /*
            r4 = this;
            java.lang.String r0 = "builder"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            r4.<init>()
            i.q r0 = r5.mo27516j()
            r4.f2109a = r0
            i.l r0 = r5.mo27513g()
            r4.f2110b = r0
            java.util.List r0 = r5.mo27522p()
            java.util.List r0 = p040i.p103M.C1764b.m2639b(r0)
            r4.f2111c = r0
            java.util.List r0 = r5.mo27524r()
            java.util.List r0 = p040i.p103M.C1764b.m2639b(r0)
            r4.f2112d = r0
            i.t$b r0 = r5.mo27518l()
            r4.f2113e = r0
            boolean r0 = r5.mo27531y()
            r4.f2114f = r0
            i.c r0 = r5.mo27504a()
            r4.f2115g = r0
            boolean r0 = r5.mo27519m()
            r4.f2116h = r0
            boolean r0 = r5.mo27520n()
            r4.f2117i = r0
            i.p r0 = r5.mo27515i()
            r4.f2118l = r0
            i.d r0 = r5.mo27506b()
            r4.f2119m = r0
            i.s r0 = r5.mo27517k()
            r4.f2120n = r0
            java.net.Proxy r0 = r5.mo27527u()
            r4.f2121o = r0
            java.net.Proxy r0 = r5.mo27527u()
            if (r0 == 0) goto L_0x0065
            goto L_0x0073
        L_0x0065:
            java.net.ProxySelector r0 = r5.mo27529w()
            if (r0 == 0) goto L_0x006c
            goto L_0x0070
        L_0x006c:
            java.net.ProxySelector r0 = java.net.ProxySelector.getDefault()
        L_0x0070:
            if (r0 == 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            i.M.l.a r0 = p040i.p103M.p114l.C1903a.f2698a
        L_0x0075:
            r4.f2122p = r0
            i.c r0 = r5.mo27528v()
            r4.f2123q = r0
            javax.net.SocketFactory r0 = r5.mo27496A()
            r4.f2124r = r0
            java.util.List r0 = r5.mo27514h()
            r4.f2127u = r0
            java.util.List r0 = r5.mo27526t()
            r4.f2128v = r0
            javax.net.ssl.HostnameVerifier r0 = r5.mo27521o()
            r4.f2129w = r0
            int r0 = r5.mo27507c()
            r4.f2132z = r0
            int r0 = r5.mo27512f()
            r4.f2103A = r0
            int r0 = r5.mo27530x()
            r4.f2104B = r0
            int r0 = r5.mo27498C()
            r4.f2105C = r0
            int r0 = r5.mo27525s()
            r4.f2106D = r0
            long r0 = r5.mo27523q()
            r4.f2107E = r0
            i.M.f.k r0 = r5.mo27532z()
            if (r0 == 0) goto L_0x00c0
            goto L_0x00c5
        L_0x00c0:
            i.M.f.k r0 = new i.M.f.k
            r0.<init>()
        L_0x00c5:
            r4.f2108F = r0
            java.util.List<i.m> r0 = r4.f2127u
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 0
            if (r1 == 0) goto L_0x00d5
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x00d5
            goto L_0x00ed
        L_0x00d5:
            java.util.Iterator r0 = r0.iterator()
        L_0x00d9:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00ed
            java.lang.Object r1 = r0.next()
            i.m r1 = (p040i.C1936m) r1
            boolean r1 = r1.mo28081b()
            if (r1 == 0) goto L_0x00d9
            r0 = 0
            goto L_0x00ee
        L_0x00ed:
            r0 = 1
        L_0x00ee:
            r1 = 0
            if (r0 == 0) goto L_0x00fa
            r4.f2125s = r1
            r4.f2131y = r1
            r4.f2126t = r1
            i.h r5 = p040i.C1926h.f2770c
            goto L_0x016b
        L_0x00fa:
            javax.net.ssl.SSLSocketFactory r0 = r5.mo27497B()
            if (r0 == 0) goto L_0x0125
            javax.net.ssl.SSLSocketFactory r0 = r5.mo27497B()
            r4.f2125s = r0
            i.M.m.c r0 = r5.mo27510d()
            if (r0 != 0) goto L_0x010f
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x010f:
            r4.f2131y = r0
            javax.net.ssl.X509TrustManager r0 = r5.mo27499D()
            if (r0 != 0) goto L_0x011a
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x011a:
            r4.f2126t = r0
            i.h r5 = r5.mo27511e()
            i.M.m.c r0 = r4.f2131y
            if (r0 != 0) goto L_0x0167
            goto L_0x0164
        L_0x0125:
            i.M.k.h$a r0 = p040i.p103M.p112k.C1890h.f2683c
            i.M.k.h r0 = p040i.p103M.p112k.C1890h.f2681a
            javax.net.ssl.X509TrustManager r0 = r0.mo27977b()
            r4.f2126t = r0
            i.M.k.h$a r0 = p040i.p103M.p112k.C1890h.f2683c
            i.M.k.h r0 = p040i.p103M.p112k.C1890h.f2681a
            javax.net.ssl.X509TrustManager r3 = r4.f2126t
            if (r3 != 0) goto L_0x013e
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x013e:
            javax.net.ssl.SSLSocketFactory r0 = r0.mo27978c(r3)
            r4.f2125s = r0
            javax.net.ssl.X509TrustManager r0 = r4.f2126t
            if (r0 != 0) goto L_0x014b
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x014b:
            java.lang.String r3 = "trustManager"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r3)
            i.M.k.h$a r3 = p040i.p103M.p112k.C1890h.f2683c
            i.M.k.h r3 = p040i.p103M.p112k.C1890h.f2681a
            i.M.m.c r0 = r3.mo27963a((javax.net.ssl.X509TrustManager) r0)
            r4.f2131y = r0
            i.h r5 = r5.mo27511e()
            i.M.m.c r0 = r4.f2131y
            if (r0 != 0) goto L_0x0167
        L_0x0164:
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0167:
            i.h r5 = r5.mo28058a((p040i.p103M.p115m.C1906c) r0)
        L_0x016b:
            r4.f2130x = r5
            java.util.List<i.A> r5 = r4.f2111c
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>"
            if (r5 == 0) goto L_0x0266
            boolean r5 = r5.contains(r1)
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x024d
            java.util.List<i.A> r5 = r4.f2112d
            if (r5 == 0) goto L_0x0247
            boolean r5 = r5.contains(r1)
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x022e
            java.util.List<i.m> r5 = r4.f2127u
            boolean r0 = r5 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0194
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L_0x0194
            goto L_0x01ac
        L_0x0194:
            java.util.Iterator r5 = r5.iterator()
        L_0x0198:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x01ac
            java.lang.Object r0 = r5.next()
            i.m r0 = (p040i.C1936m) r0
            boolean r0 = r0.mo28081b()
            if (r0 == 0) goto L_0x0198
            r5 = 0
            goto L_0x01ad
        L_0x01ac:
            r5 = 1
        L_0x01ad:
            if (r5 == 0) goto L_0x01fd
            javax.net.ssl.SSLSocketFactory r5 = r4.f2125s
            if (r5 != 0) goto L_0x01b5
            r5 = 1
            goto L_0x01b6
        L_0x01b5:
            r5 = 0
        L_0x01b6:
            java.lang.String r0 = "Check failed."
            if (r5 == 0) goto L_0x01f3
            i.M.m.c r5 = r4.f2131y
            if (r5 != 0) goto L_0x01c0
            r5 = 1
            goto L_0x01c1
        L_0x01c0:
            r5 = 0
        L_0x01c1:
            if (r5 == 0) goto L_0x01e9
            javax.net.ssl.X509TrustManager r5 = r4.f2126t
            if (r5 != 0) goto L_0x01c8
            r2 = 1
        L_0x01c8:
            if (r2 == 0) goto L_0x01df
            i.h r5 = r4.f2130x
            i.h r1 = p040i.C1926h.f2770c
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r1)
            if (r5 == 0) goto L_0x01d5
            goto L_0x0209
        L_0x01d5:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x01df:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x01e9:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x01f3:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x01fd:
            javax.net.ssl.SSLSocketFactory r5 = r4.f2125s
            if (r5 == 0) goto L_0x0222
            i.M.m.c r5 = r4.f2131y
            if (r5 == 0) goto L_0x0216
            javax.net.ssl.X509TrustManager r5 = r4.f2126t
            if (r5 == 0) goto L_0x020a
        L_0x0209:
            return
        L_0x020a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "x509TrustManager == null"
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x0216:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "certificateChainCleaner == null"
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x0222:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "sslSocketFactory == null"
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x022e:
            java.lang.String r5 = "Null network interceptor: "
            java.lang.StringBuilder r5 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r5)
            java.util.List<i.A> r0 = r4.f2112d
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r5 = r5.toString()
            r0.<init>(r5)
            throw r0
        L_0x0247:
            kotlin.TypeCastException r5 = new kotlin.TypeCastException
            r5.<init>(r0)
            throw r5
        L_0x024d:
            java.lang.String r5 = "Null interceptor: "
            java.lang.StringBuilder r5 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r5)
            java.util.List<i.A> r0 = r4.f2111c
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r5 = r5.toString()
            r0.<init>(r5)
            throw r0
        L_0x0266:
            kotlin.TypeCastException r5 = new kotlin.TypeCastException
            r5.<init>(r0)
            goto L_0x026d
        L_0x026c:
            throw r5
        L_0x026d:
            goto L_0x026c
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.C1752D.<init>(i.D$a):void");
    }

    @JvmName(name = "socketFactory")
    /* renamed from: A */
    public final SocketFactory mo27464A() {
        return this.f2124r;
    }

    @JvmName(name = "sslSocketFactory")
    /* renamed from: B */
    public final SSLSocketFactory mo27465B() {
        SSLSocketFactory sSLSocketFactory = this.f2125s;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    @JvmName(name = "writeTimeoutMillis")
    /* renamed from: C */
    public final int mo27466C() {
        return this.f2105C;
    }

    @JvmName(name = "x509TrustManager")
    /* renamed from: D */
    public final X509TrustManager mo27467D() {
        return this.f2126t;
    }

    @JvmName(name = "authenticator")
    /* renamed from: a */
    public final C1914c mo27468a() {
        return this.f2115g;
    }

    /* renamed from: a */
    public C1923f mo27469a(C1755F f) {
        Intrinsics.checkParameterIsNotNull(f, "request");
        return new C1799e(this, f, false);
    }

    @JvmName(name = "cache")
    /* renamed from: b */
    public final C1915d mo27470b() {
        return this.f2119m;
    }

    @JvmName(name = "callTimeoutMillis")
    /* renamed from: c */
    public final int mo27471c() {
        return this.f2132z;
    }

    public Object clone() {
        return super.clone();
    }

    @JvmName(name = "certificateChainCleaner")
    /* renamed from: d */
    public final C1906c mo27473d() {
        return this.f2131y;
    }

    @JvmName(name = "certificatePinner")
    /* renamed from: e */
    public final C1926h mo27474e() {
        return this.f2130x;
    }

    @JvmName(name = "connectTimeoutMillis")
    /* renamed from: f */
    public final int mo27475f() {
        return this.f2103A;
    }

    @JvmName(name = "connectionPool")
    /* renamed from: g */
    public final C1935l mo27476g() {
        return this.f2110b;
    }

    @JvmName(name = "connectionSpecs")
    /* renamed from: h */
    public final List<C1936m> mo27477h() {
        return this.f2127u;
    }

    @JvmName(name = "cookieJar")
    /* renamed from: i */
    public final C1939p mo27478i() {
        return this.f2118l;
    }

    @JvmName(name = "dispatcher")
    /* renamed from: j */
    public final C1940q mo27479j() {
        return this.f2109a;
    }

    @JvmName(name = "dns")
    /* renamed from: k */
    public final C1942s mo27480k() {
        return this.f2120n;
    }

    @JvmName(name = "eventListenerFactory")
    /* renamed from: l */
    public final C1943t.C1945b mo27481l() {
        return this.f2113e;
    }

    @JvmName(name = "followRedirects")
    /* renamed from: m */
    public final boolean mo27482m() {
        return this.f2116h;
    }

    @JvmName(name = "followSslRedirects")
    /* renamed from: n */
    public final boolean mo27483n() {
        return this.f2117i;
    }

    /* renamed from: o */
    public final C1809k mo27484o() {
        return this.f2108F;
    }

    @JvmName(name = "hostnameVerifier")
    /* renamed from: p */
    public final HostnameVerifier mo27485p() {
        return this.f2129w;
    }

    @JvmName(name = "interceptors")
    /* renamed from: q */
    public final List<C1744A> mo27486q() {
        return this.f2111c;
    }

    @JvmName(name = "minWebSocketMessageToCompress")
    /* renamed from: r */
    public final long mo27487r() {
        return this.f2107E;
    }

    @JvmName(name = "networkInterceptors")
    /* renamed from: s */
    public final List<C1744A> mo27488s() {
        return this.f2112d;
    }

    @JvmName(name = "pingIntervalMillis")
    /* renamed from: t */
    public final int mo27489t() {
        return this.f2106D;
    }

    @JvmName(name = "protocols")
    /* renamed from: u */
    public final List<C0974E> mo27490u() {
        return this.f2128v;
    }

    @JvmName(name = "proxy")
    /* renamed from: v */
    public final Proxy mo27491v() {
        return this.f2121o;
    }

    @JvmName(name = "proxyAuthenticator")
    /* renamed from: w */
    public final C1914c mo27492w() {
        return this.f2123q;
    }

    @JvmName(name = "proxySelector")
    /* renamed from: x */
    public final ProxySelector mo27493x() {
        return this.f2122p;
    }

    @JvmName(name = "readTimeoutMillis")
    /* renamed from: y */
    public final int mo27494y() {
        return this.f2104B;
    }

    @JvmName(name = "retryOnConnectionFailure")
    /* renamed from: z */
    public final boolean mo27495z() {
        return this.f2114f;
    }
}
