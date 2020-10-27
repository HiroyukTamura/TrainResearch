package p040i.p103M.p107f;

import androidx.core.app.NotificationCompat;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C0974E;
import p040i.C0976G;
import p040i.C1752D;
import p040i.C1755F;
import p040i.C1758I;
import p040i.C1760K;
import p040i.C1912a;
import p040i.C1923f;
import p040i.C1934k;
import p040i.C1943t;
import p040i.C1950x;
import p040i.C1955z;
import p040i.p103M.C1764b;
import p040i.p103M.p106e.C1788e;
import p040i.p103M.p108g.C1818d;
import p040i.p103M.p108g.C1821g;
import p040i.p103M.p109h.C1826b;
import p040i.p103M.p110i.C1833a;
import p040i.p103M.p110i.C1834b;
import p040i.p103M.p110i.C1841f;
import p040i.p103M.p110i.C1858g;
import p040i.p103M.p110i.C1862i;
import p040i.p103M.p110i.C1871n;
import p040i.p103M.p110i.C1872o;
import p040i.p103M.p112k.C1890h;
import p042j.C1016z;
import p042j.C2071g;
import p042j.C2072h;
import p042j.C2080p;
import p042j.C2084s;
import p042j.C2085t;
import p042j.C2090x;

/* renamed from: i.M.f.i */
public final class C1806i extends C1841f.C1844c implements C1934k {

    /* renamed from: b */
    private Socket f2380b;

    /* renamed from: c */
    private Socket f2381c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1950x f2382d;

    /* renamed from: e */
    private C0974E f2383e;

    /* renamed from: f */
    private C1841f f2384f;

    /* renamed from: g */
    private C2072h f2385g;

    /* renamed from: h */
    private C2071g f2386h;

    /* renamed from: i */
    private boolean f2387i;

    /* renamed from: j */
    private boolean f2388j;

    /* renamed from: k */
    private int f2389k;

    /* renamed from: l */
    private int f2390l;

    /* renamed from: m */
    private int f2391m;

    /* renamed from: n */
    private int f2392n = 1;

    /* renamed from: o */
    private final List<Reference<C1799e>> f2393o = new ArrayList();

    /* renamed from: p */
    private long f2394p = LongCompanionObject.MAX_VALUE;

    /* renamed from: q */
    private final C1807j f2395q;

    /* renamed from: r */
    private final C1760K f2396r;

    public C1806i(C1807j jVar, C1760K k) {
        Intrinsics.checkParameterIsNotNull(jVar, "connectionPool");
        Intrinsics.checkParameterIsNotNull(k, "route");
        this.f2395q = jVar;
        this.f2396r = k;
    }

    /* renamed from: b */
    private final void m2814b(int i) throws IOException {
        Socket socket = this.f2381c;
        if (socket == null) {
            Intrinsics.throwNpe();
        }
        C2072h hVar = this.f2385g;
        if (hVar == null) {
            Intrinsics.throwNpe();
        }
        C2071g gVar = this.f2386h;
        if (gVar == null) {
            Intrinsics.throwNpe();
        }
        socket.setSoTimeout(0);
        C1841f.C1843b bVar = new C1841f.C1843b(true, C1788e.f2308h);
        bVar.mo27857a(socket, this.f2396r.mo27588a().mo28020k().mo28138f(), hVar, gVar);
        bVar.mo27856a((C1841f.C1844c) this);
        bVar.mo27855a(i);
        C1841f fVar = new C1841f(bVar);
        this.f2384f = fVar;
        C1841f fVar2 = C1841f.f2512F;
        this.f2392n = C1841f.f2511E.mo27951c();
        C1841f.m2945a(fVar, false, (C1788e) null, 3);
    }

    /* renamed from: a */
    public C0974E mo27740a() {
        C0974E e = this.f2383e;
        if (e == null) {
            Intrinsics.throwNpe();
        }
        return e;
    }

    /* renamed from: a */
    public final C1818d mo27741a(C1752D d, C1821g gVar) throws SocketException {
        Intrinsics.checkParameterIsNotNull(d, "client");
        Intrinsics.checkParameterIsNotNull(gVar, "chain");
        Socket socket = this.f2381c;
        if (socket == null) {
            Intrinsics.throwNpe();
        }
        C2072h hVar = this.f2385g;
        if (hVar == null) {
            Intrinsics.throwNpe();
        }
        C2071g gVar2 = this.f2386h;
        if (gVar2 == null) {
            Intrinsics.throwNpe();
        }
        C1841f fVar = this.f2384f;
        if (fVar != null) {
            return new C1858g(d, this, gVar, fVar);
        }
        socket.setSoTimeout(gVar.mo27796h());
        hVar.timeout().mo29120a((long) gVar.mo27793e(), TimeUnit.MILLISECONDS);
        gVar2.timeout().mo29120a((long) gVar.mo27795g(), TimeUnit.MILLISECONDS);
        return new C1826b(d, this, hVar, gVar2);
    }

    /* renamed from: a */
    public final void mo27742a(int i) {
        this.f2390l = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ff A[SYNTHETIC, Splitter:B:44:0x00ff] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0162 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo27743a(int r18, int r19, int r20, int r21, boolean r22, p040i.C1923f r23, p040i.C1943t r24) {
        /*
            r17 = this;
            r7 = r17
            r8 = r23
            r9 = r24
            java.lang.String r10 = "proxy"
            java.lang.String r11 = "inetSocketAddress"
            java.lang.String r12 = "call"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r12)
            java.lang.String r0 = "eventListener"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            i.E r0 = r7.f2383e
            r13 = 1
            if (r0 != 0) goto L_0x001b
            r0 = 1
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            if (r0 == 0) goto L_0x0170
            i.K r0 = r7.f2396r
            i.a r0 = r0.mo27588a()
            java.util.List r0 = r0.mo28009b()
            i.M.f.b r14 = new i.M.f.b
            r14.<init>(r0)
            i.K r1 = r7.f2396r
            i.a r1 = r1.mo27588a()
            javax.net.ssl.SSLSocketFactory r1 = r1.mo28019j()
            if (r1 != 0) goto L_0x007c
            i.m r1 = p040i.C1936m.f2807h
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x006f
            i.K r0 = r7.f2396r
            i.a r0 = r0.mo27588a()
            i.z r0 = r0.mo28020k()
            java.lang.String r0 = r0.mo28138f()
            i.M.k.h$a r1 = p040i.p103M.p112k.C1890h.f2683c
            i.M.k.h r1 = p040i.p103M.p112k.C1890h.f2681a
            boolean r1 = r1.mo27967b((java.lang.String) r0)
            if (r1 == 0) goto L_0x005c
            goto L_0x008e
        L_0x005c:
            i.M.f.l r1 = new i.M.f.l
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.String r3 = "CLEARTEXT communication to "
            java.lang.String r4 = " not permitted by network security policy"
            java.lang.String r0 = p009e.p010a.p011a.p012a.C0681a.m321a((java.lang.String) r3, (java.lang.String) r0, (java.lang.String) r4)
            r2.<init>(r0)
            r1.<init>(r2)
            throw r1
        L_0x006f:
            i.M.f.l r0 = new i.M.f.l
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x007c:
            i.K r0 = r7.f2396r
            i.a r0 = r0.mo27588a()
            java.util.List r0 = r0.mo28012e()
            i.E r1 = p040i.C0974E.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0163
        L_0x008e:
            r15 = 0
            r6 = r15
        L_0x0090:
            i.K r0 = r7.f2396r     // Catch:{ IOException -> 0x0106 }
            boolean r0 = r0.mo27590c()     // Catch:{ IOException -> 0x0106 }
            if (r0 == 0) goto L_0x00b9
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r23
            r16 = r6
            r6 = r24
            r1.m2811a(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00b3 }
            java.net.Socket r0 = r7.f2380b     // Catch:{ IOException -> 0x00b3 }
            if (r0 != 0) goto L_0x00ae
            goto L_0x00de
        L_0x00ae:
            r1 = r18
            r2 = r19
            goto L_0x00c2
        L_0x00b3:
            r0 = move-exception
            r1 = r18
            r2 = r19
            goto L_0x0103
        L_0x00b9:
            r16 = r6
            r1 = r18
            r2 = r19
            r7.m2812a((int) r1, (int) r2, (p040i.C1923f) r8, (p040i.C1943t) r9)     // Catch:{ IOException -> 0x0102 }
        L_0x00c2:
            r3 = r21
            r7.m2813a((p040i.p103M.p107f.C1794b) r14, (int) r3, (p040i.C1923f) r8, (p040i.C1943t) r9)     // Catch:{ IOException -> 0x0100 }
            i.K r0 = r7.f2396r     // Catch:{ IOException -> 0x0100 }
            java.net.InetSocketAddress r0 = r0.mo27591d()     // Catch:{ IOException -> 0x0100 }
            i.K r4 = r7.f2396r     // Catch:{ IOException -> 0x0100 }
            java.net.Proxy r4 = r4.mo27589b()     // Catch:{ IOException -> 0x0100 }
            if (r9 == 0) goto L_0x00ff
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r12)     // Catch:{ IOException -> 0x0100 }
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r11)     // Catch:{ IOException -> 0x0100 }
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r10)     // Catch:{ IOException -> 0x0100 }
        L_0x00de:
            i.K r0 = r7.f2396r
            boolean r0 = r0.mo27590c()
            if (r0 == 0) goto L_0x00f8
            java.net.Socket r0 = r7.f2380b
            if (r0 == 0) goto L_0x00eb
            goto L_0x00f8
        L_0x00eb:
            i.M.f.l r0 = new i.M.f.l
            java.net.ProtocolException r1 = new java.net.ProtocolException
            java.lang.String r2 = "Too many tunnel connections attempted: 21"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x00f8:
            long r0 = java.lang.System.nanoTime()
            r7.f2394p = r0
            return
        L_0x00ff:
            throw r15     // Catch:{ IOException -> 0x0100 }
        L_0x0100:
            r0 = move-exception
            goto L_0x010f
        L_0x0102:
            r0 = move-exception
        L_0x0103:
            r3 = r21
            goto L_0x010f
        L_0x0106:
            r0 = move-exception
            r1 = r18
            r2 = r19
            r3 = r21
            r16 = r6
        L_0x010f:
            java.net.Socket r4 = r7.f2381c
            if (r4 == 0) goto L_0x0116
            p040i.p103M.C1764b.m2630a((java.net.Socket) r4)
        L_0x0116:
            java.net.Socket r4 = r7.f2380b
            if (r4 == 0) goto L_0x011d
            p040i.p103M.C1764b.m2630a((java.net.Socket) r4)
        L_0x011d:
            r7.f2381c = r15
            r7.f2380b = r15
            r7.f2385g = r15
            r7.f2386h = r15
            r7.f2382d = r15
            r7.f2383e = r15
            r7.f2384f = r15
            r7.f2392n = r13
            i.K r4 = r7.f2396r
            java.net.InetSocketAddress r4 = r4.mo27591d()
            i.K r5 = r7.f2396r
            java.net.Proxy r5 = r5.mo27589b()
            if (r9 == 0) goto L_0x0162
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r12)
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r11)
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r10)
            java.lang.String r4 = "ioe"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r4)
            r4 = r16
            if (r4 != 0) goto L_0x0153
            i.M.f.l r6 = new i.M.f.l
            r6.<init>(r0)
            goto L_0x0157
        L_0x0153:
            r4.mo27773a(r0)
            r6 = r4
        L_0x0157:
            if (r22 == 0) goto L_0x0161
            boolean r0 = r14.mo27682a((java.io.IOException) r0)
            if (r0 == 0) goto L_0x0161
            goto L_0x0090
        L_0x0161:
            throw r6
        L_0x0162:
            throw r15
        L_0x0163:
            i.M.f.l r0 = new i.M.f.l
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0170:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            goto L_0x017d
        L_0x017c:
            throw r0
        L_0x017d:
            goto L_0x017c
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p107f.C1806i.mo27743a(int, int, int, int, boolean, i.f, i.t):void");
    }

    /* renamed from: a */
    public final void mo27744a(long j) {
        this.f2394p = j;
    }

    /* renamed from: a */
    public final void mo27745a(C1752D d, C1760K k, IOException iOException) {
        Intrinsics.checkParameterIsNotNull(d, "client");
        Intrinsics.checkParameterIsNotNull(k, "failedRoute");
        Intrinsics.checkParameterIsNotNull(iOException, "failure");
        if (k.mo27589b().type() != Proxy.Type.DIRECT) {
            C1912a a = k.mo27588a();
            a.mo28016h().connectFailed(a.mo28020k().mo28147n(), k.mo27589b().address(), iOException);
        }
        d.mo27484o().mo27770b(k);
    }

    /* renamed from: a */
    public final void mo27746a(C1799e eVar, IOException iOException) {
        Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        C1807j jVar = this.f2395q;
        if (!C1764b.f2219g || !Thread.holdsLock(jVar)) {
            synchronized (this.f2395q) {
                if (!(iOException instanceof C1872o)) {
                    if (!mo27759i() || (iOException instanceof C1833a)) {
                        this.f2387i = true;
                        if (this.f2390l == 0) {
                            if (iOException != null) {
                                mo27745a(eVar.mo27709a(), this.f2396r, iOException);
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } else if (((C1872o) iOException).f2649a == C1834b.REFUSED_STREAM) {
                    int i = this.f2391m + 1;
                    this.f2391m = i;
                    if (i > 1) {
                        this.f2387i = true;
                    }
                    Unit unit2 = Unit.INSTANCE;
                } else if (((C1872o) iOException).f2649a != C1834b.CANCEL || !eVar.isCanceled()) {
                    this.f2387i = true;
                } else {
                    Unit unit22 = Unit.INSTANCE;
                }
                this.f2389k++;
                Unit unit222 = Unit.INSTANCE;
            }
            return;
        }
        StringBuilder a = C0681a.m330a("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        a.append(currentThread.getName());
        a.append(" MUST NOT hold lock on ");
        a.append(jVar);
        throw new AssertionError(a.toString());
    }

    /* renamed from: a */
    public void mo27747a(C1841f fVar, C1871n nVar) {
        Intrinsics.checkParameterIsNotNull(fVar, "connection");
        Intrinsics.checkParameterIsNotNull(nVar, "settings");
        synchronized (this.f2395q) {
            this.f2392n = nVar.mo27951c();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* renamed from: a */
    public void mo27748a(C1862i iVar) throws IOException {
        Intrinsics.checkParameterIsNotNull(iVar, "stream");
        iVar.mo27886a(C1834b.REFUSED_STREAM, (IOException) null);
    }

    /* renamed from: a */
    public final boolean mo27750a(boolean z) {
        long nanoTime = System.nanoTime();
        Socket socket = this.f2380b;
        if (socket == null) {
            Intrinsics.throwNpe();
        }
        Socket socket2 = this.f2381c;
        if (socket2 == null) {
            Intrinsics.throwNpe();
        }
        C2072h hVar = this.f2385g;
        if (hVar == null) {
            Intrinsics.throwNpe();
        }
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        C1841f fVar = this.f2384f;
        if (fVar != null) {
            return fVar.mo27844h(nanoTime);
        }
        if (nanoTime - this.f2394p < 10000000000L || !z) {
            return true;
        }
        return C1764b.m2634a(socket2, hVar);
    }

    /* renamed from: b */
    public final void mo27751b() {
        Socket socket = this.f2380b;
        if (socket != null) {
            C1764b.m2630a(socket);
        }
    }

    /* renamed from: b */
    public final void mo27752b(boolean z) {
        this.f2387i = z;
    }

    /* renamed from: c */
    public final List<Reference<C1799e>> mo27753c() {
        return this.f2393o;
    }

    /* renamed from: d */
    public final long mo27754d() {
        return this.f2394p;
    }

    /* renamed from: e */
    public final boolean mo27755e() {
        return this.f2387i;
    }

    /* renamed from: f */
    public final int mo27756f() {
        return this.f2389k;
    }

    /* renamed from: g */
    public final int mo27757g() {
        return this.f2390l;
    }

    /* renamed from: h */
    public C1950x mo27758h() {
        return this.f2382d;
    }

    /* renamed from: i */
    public final boolean mo27759i() {
        return this.f2384f != null;
    }

    /* renamed from: j */
    public final void mo27760j() {
        C1807j jVar = this.f2395q;
        if (!C1764b.f2219g || !Thread.holdsLock(jVar)) {
            synchronized (this.f2395q) {
                this.f2388j = true;
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        StringBuilder a = C0681a.m330a("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        a.append(currentThread.getName());
        a.append(" MUST NOT hold lock on ");
        a.append(jVar);
        throw new AssertionError(a.toString());
    }

    /* renamed from: k */
    public final void mo27761k() {
        C1807j jVar = this.f2395q;
        if (!C1764b.f2219g || !Thread.holdsLock(jVar)) {
            synchronized (this.f2395q) {
                this.f2387i = true;
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        StringBuilder a = C0681a.m330a("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        a.append(currentThread.getName());
        a.append(" MUST NOT hold lock on ");
        a.append(jVar);
        throw new AssertionError(a.toString());
    }

    /* renamed from: l */
    public C1760K mo27762l() {
        return this.f2396r;
    }

    /* renamed from: m */
    public Socket mo27763m() {
        Socket socket = this.f2381c;
        if (socket == null) {
            Intrinsics.throwNpe();
        }
        return socket;
    }

    public String toString() {
        Object obj;
        StringBuilder a = C0681a.m330a("Connection{");
        a.append(this.f2396r.mo27588a().mo28020k().mo28138f());
        a.append(':');
        a.append(this.f2396r.mo27588a().mo28020k().mo28143j());
        a.append(',');
        a.append(" proxy=");
        a.append(this.f2396r.mo27589b());
        a.append(" hostAddress=");
        a.append(this.f2396r.mo27591d());
        a.append(" cipherSuite=");
        C1950x xVar = this.f2382d;
        if (xVar == null || (obj = xVar.mo28105a()) == null) {
            obj = "none";
        }
        a.append(obj);
        a.append(" protocol=");
        a.append(this.f2383e);
        a.append('}');
        return a.toString();
    }

    /* renamed from: a */
    private final void m2812a(int i, int i2, C1923f fVar, C1943t tVar) throws IOException {
        Socket socket;
        int i3;
        Proxy b = this.f2396r.mo27589b();
        C1912a a = this.f2396r.mo27588a();
        Proxy.Type type = b.type();
        if (type != null && ((i3 = C1803f.f2375a[type.ordinal()]) == 1 || i3 == 2)) {
            socket = a.mo28018i().createSocket();
            if (socket == null) {
                Intrinsics.throwNpe();
            }
        } else {
            socket = new Socket(b);
        }
        this.f2380b = socket;
        InetSocketAddress d = this.f2396r.mo27591d();
        if (tVar != null) {
            Intrinsics.checkParameterIsNotNull(fVar, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkParameterIsNotNull(d, "inetSocketAddress");
            Intrinsics.checkParameterIsNotNull(b, "proxy");
            socket.setSoTimeout(i2);
            try {
                C1890h.C1891a aVar = C1890h.f2683c;
                C1890h.f2681a.mo27970a(socket, this.f2396r.mo27591d(), i);
                try {
                    C1016z b2 = C2080p.m3586b(socket);
                    Intrinsics.checkParameterIsNotNull(b2, "$this$buffer");
                    this.f2385g = new C2085t(b2);
                    C2090x a2 = C2080p.m3582a(socket);
                    Intrinsics.checkParameterIsNotNull(a2, "$this$buffer");
                    this.f2386h = new C2084s(a2);
                } catch (NullPointerException e) {
                    if (Intrinsics.areEqual((Object) e.getMessage(), (Object) "throw with null exception")) {
                        throw new IOException(e);
                    }
                }
            } catch (ConnectException e2) {
                StringBuilder a3 = C0681a.m330a("Failed to connect to ");
                a3.append(this.f2396r.mo27591d());
                ConnectException connectException = new ConnectException(a3.toString());
                connectException.initCause(e2);
                throw connectException;
            }
        } else {
            throw null;
        }
    }

    /* renamed from: a */
    private final void m2811a(int i, int i2, int i3, C1923f fVar, C1943t tVar) throws IOException {
        int i4 = i2;
        C1923f fVar2 = fVar;
        C1755F.C1756a aVar = new C1755F.C1756a();
        aVar.mo27546a(this.f2396r.mo27588a().mo28020k());
        C1752D d = null;
        aVar.mo27549a("CONNECT", (C0976G) null);
        boolean z = true;
        aVar.mo27550a("Host", C1764b.m2620a(this.f2396r.mo27588a().mo28020k(), true));
        aVar.mo27550a("Proxy-Connection", "Keep-Alive");
        aVar.mo27550a(AbstractSpiCall.HEADER_USER_AGENT, "okhttp/4.6.0");
        C1755F a = aVar.mo27551a();
        C1758I.C1759a aVar2 = new C1758I.C1759a();
        aVar2.mo27574a(a);
        aVar2.mo27573a(C0974E.HTTP_1_1);
        aVar2.mo27571a(407);
        aVar2.mo27579a("Preemptive Authenticate");
        aVar2.mo27576a(C1764b.f2215c);
        aVar2.mo27584b(-1);
        aVar2.mo27572a(-1);
        aVar2.mo27586b("Proxy-Authenticate", "OkHttp-Preemptive");
        C1755F a2 = this.f2396r.mo27588a().mo28015g().mo27599a(this.f2396r, aVar2.mo27581a());
        if (a2 != null) {
            a = a2;
        }
        C1955z g = a.mo27542g();
        int i5 = 0;
        while (i5 < 21) {
            m2812a(i, i4, fVar2, tVar);
            StringBuilder a3 = C0681a.m330a("CONNECT ");
            a3.append(C1764b.m2620a(g, z));
            a3.append(" HTTP/1.1");
            String sb = a3.toString();
            while (true) {
                C2072h hVar = this.f2385g;
                if (hVar == null) {
                    Intrinsics.throwNpe();
                }
                C2071g gVar = this.f2386h;
                if (gVar == null) {
                    Intrinsics.throwNpe();
                }
                C1826b bVar = new C1826b(d, this, hVar, gVar);
                hVar.timeout().mo29120a((long) i4, TimeUnit.MILLISECONDS);
                gVar.timeout().mo29120a((long) i3, TimeUnit.MILLISECONDS);
                bVar.mo27800a(a.mo27539d(), sb);
                bVar.mo27784a();
                C1758I.C1759a a4 = bVar.mo27781a(false);
                if (a4 == null) {
                    Intrinsics.throwNpe();
                }
                a4.mo27574a(a);
                C1758I a5 = a4.mo27581a();
                bVar.mo27801c(a5);
                int o = a5.mo27558o();
                if (o != 200) {
                    if (o == 407) {
                        a = this.f2396r.mo27588a().mo28015g().mo27599a(this.f2396r, a5);
                        if (a == null) {
                            throw new IOException("Failed to authenticate with proxy");
                        } else if (StringsKt__StringsJVMKt.equals("close", C1758I.m2561a(a5, "Connection", (String) null, 2), true)) {
                            break;
                        } else {
                            d = null;
                            i4 = i2;
                        }
                    } else {
                        StringBuilder a6 = C0681a.m330a("Unexpected response code for CONNECT: ");
                        a6.append(a5.mo27558o());
                        throw new IOException(a6.toString());
                    }
                } else if (!hVar.getBuffer().mo29152c() || !gVar.getBuffer().mo29152c()) {
                    throw new IOException("TLS tunnel buffered too many bytes!");
                } else {
                    a = null;
                }
            }
            if (a != null) {
                Socket socket = this.f2380b;
                if (socket != null) {
                    C1764b.m2630a(socket);
                }
                d = null;
                this.f2380b = null;
                this.f2386h = null;
                this.f2385g = null;
                InetSocketAddress d2 = this.f2396r.mo27591d();
                Proxy b = this.f2396r.mo27589b();
                Intrinsics.checkParameterIsNotNull(fVar2, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkParameterIsNotNull(d2, "inetSocketAddress");
                Intrinsics.checkParameterIsNotNull(b, "proxy");
                i5++;
                z = true;
                i4 = i2;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01e1  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m2813a(p040i.p103M.p107f.C1794b r12, int r13, p040i.C1923f r14, p040i.C1943t r15) throws java.io.IOException {
        /*
            r11 = this;
            i.K r0 = r11.f2396r
            i.a r0 = r0.mo27588a()
            javax.net.ssl.SSLSocketFactory r0 = r0.mo28019j()
            if (r0 != 0) goto L_0x0033
            i.K r12 = r11.f2396r
            i.a r12 = r12.mo27588a()
            java.util.List r12 = r12.mo28012e()
            i.E r14 = p040i.C0974E.H2_PRIOR_KNOWLEDGE
            boolean r12 = r12.contains(r14)
            if (r12 == 0) goto L_0x002a
            java.net.Socket r12 = r11.f2380b
            r11.f2381c = r12
            i.E r12 = p040i.C0974E.H2_PRIOR_KNOWLEDGE
            r11.f2383e = r12
            r11.m2814b((int) r13)
            return
        L_0x002a:
            java.net.Socket r12 = r11.f2380b
            r11.f2381c = r12
            i.E r12 = p040i.C0974E.HTTP_1_1
            r11.f2383e = r12
            return
        L_0x0033:
            r0 = 0
            if (r15 == 0) goto L_0x01e5
            java.lang.String r15 = "call"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r15)
            java.lang.String r1 = "$this$buffer"
            i.K r2 = r11.f2396r
            i.a r2 = r2.mo27588a()
            javax.net.ssl.SSLSocketFactory r3 = r2.mo28019j()
            if (r3 != 0) goto L_0x004c
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x01d3 }
        L_0x004c:
            java.net.Socket r4 = r11.f2380b     // Catch:{ all -> 0x01d3 }
            i.z r5 = r2.mo28020k()     // Catch:{ all -> 0x01d3 }
            java.lang.String r5 = r5.mo28138f()     // Catch:{ all -> 0x01d3 }
            i.z r6 = r2.mo28020k()     // Catch:{ all -> 0x01d3 }
            int r6 = r6.mo28143j()     // Catch:{ all -> 0x01d3 }
            r7 = 1
            java.net.Socket r3 = r3.createSocket(r4, r5, r6, r7)     // Catch:{ all -> 0x01d3 }
            if (r3 == 0) goto L_0x01cb
            javax.net.ssl.SSLSocket r3 = (javax.net.ssl.SSLSocket) r3     // Catch:{ all -> 0x01d3 }
            i.m r12 = r12.mo27681a((javax.net.ssl.SSLSocket) r3)     // Catch:{ all -> 0x01c8 }
            boolean r4 = r12.mo28082c()     // Catch:{ all -> 0x01c8 }
            if (r4 == 0) goto L_0x0086
            i.M.k.h$a r4 = p040i.p103M.p112k.C1890h.f2683c     // Catch:{ all -> 0x01c8 }
            i.M.k.h r4 = p040i.p103M.p112k.C1890h.f2681a     // Catch:{ all -> 0x01c8 }
            i.z r5 = r2.mo28020k()     // Catch:{ all -> 0x01c8 }
            java.lang.String r5 = r5.mo28138f()     // Catch:{ all -> 0x01c8 }
            java.util.List r6 = r2.mo28012e()     // Catch:{ all -> 0x01c8 }
            r4.mo27965a((javax.net.ssl.SSLSocket) r3, (java.lang.String) r5, (java.util.List<p040i.C0974E>) r6)     // Catch:{ all -> 0x01c8 }
        L_0x0086:
            r3.startHandshake()     // Catch:{ all -> 0x01c8 }
            javax.net.ssl.SSLSession r4 = r3.getSession()     // Catch:{ all -> 0x01c8 }
            java.lang.String r5 = "sslSocketSession"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)     // Catch:{ all -> 0x01c8 }
            i.x r5 = p040i.C1950x.m3363a((javax.net.ssl.SSLSession) r4)     // Catch:{ all -> 0x01c8 }
            javax.net.ssl.HostnameVerifier r6 = r2.mo28011d()     // Catch:{ all -> 0x01c8 }
            if (r6 != 0) goto L_0x009f
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x01c8 }
        L_0x009f:
            i.z r8 = r2.mo28020k()     // Catch:{ all -> 0x01c8 }
            java.lang.String r8 = r8.mo28138f()     // Catch:{ all -> 0x01c8 }
            boolean r4 = r6.verify(r8, r4)     // Catch:{ all -> 0x01c8 }
            if (r4 != 0) goto L_0x0146
            java.util.List r12 = r5.mo28107c()     // Catch:{ all -> 0x01c8 }
            boolean r13 = r12.isEmpty()     // Catch:{ all -> 0x01c8 }
            r13 = r13 ^ r7
            if (r13 == 0) goto L_0x0122
            r13 = 0
            java.lang.Object r12 = r12.get(r13)     // Catch:{ all -> 0x01c8 }
            if (r12 != 0) goto L_0x00c7
            kotlin.TypeCastException r12 = new kotlin.TypeCastException     // Catch:{ all -> 0x01c8 }
            java.lang.String r13 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            r12.<init>(r13)     // Catch:{ all -> 0x01c8 }
            throw r12     // Catch:{ all -> 0x01c8 }
        L_0x00c7:
            java.security.cert.X509Certificate r12 = (java.security.cert.X509Certificate) r12     // Catch:{ all -> 0x01c8 }
            javax.net.ssl.SSLPeerUnverifiedException r13 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ all -> 0x01c8 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c8 }
            r14.<init>()     // Catch:{ all -> 0x01c8 }
            java.lang.String r15 = "\n              |Hostname "
            r14.append(r15)     // Catch:{ all -> 0x01c8 }
            i.z r15 = r2.mo28020k()     // Catch:{ all -> 0x01c8 }
            java.lang.String r15 = r15.mo28138f()     // Catch:{ all -> 0x01c8 }
            r14.append(r15)     // Catch:{ all -> 0x01c8 }
            java.lang.String r15 = " not verified:\n              |    certificate: "
            r14.append(r15)     // Catch:{ all -> 0x01c8 }
            i.h r15 = p040i.C1926h.f2771d     // Catch:{ all -> 0x01c8 }
            java.lang.String r15 = p040i.C1926h.m3313a((java.security.cert.Certificate) r12)     // Catch:{ all -> 0x01c8 }
            r14.append(r15)     // Catch:{ all -> 0x01c8 }
            java.lang.String r15 = "\n              |    DN: "
            r14.append(r15)     // Catch:{ all -> 0x01c8 }
            java.security.Principal r15 = r12.getSubjectDN()     // Catch:{ all -> 0x01c8 }
            java.lang.String r1 = "cert.subjectDN"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r15, r1)     // Catch:{ all -> 0x01c8 }
            java.lang.String r15 = r15.getName()     // Catch:{ all -> 0x01c8 }
            r14.append(r15)     // Catch:{ all -> 0x01c8 }
            java.lang.String r15 = "\n              |    subjectAltNames: "
            r14.append(r15)     // Catch:{ all -> 0x01c8 }
            i.M.m.d r15 = p040i.p103M.p115m.C1907d.f2701a     // Catch:{ all -> 0x01c8 }
            java.util.List r12 = r15.mo28002a(r12)     // Catch:{ all -> 0x01c8 }
            r14.append(r12)     // Catch:{ all -> 0x01c8 }
            java.lang.String r12 = "\n              "
            r14.append(r12)     // Catch:{ all -> 0x01c8 }
            java.lang.String r12 = r14.toString()     // Catch:{ all -> 0x01c8 }
            java.lang.String r12 = kotlin.text.StringsKt__IndentKt.trimMargin$default(r12, r0, r7, r0)     // Catch:{ all -> 0x01c8 }
            r13.<init>(r12)     // Catch:{ all -> 0x01c8 }
            throw r13     // Catch:{ all -> 0x01c8 }
        L_0x0122:
            javax.net.ssl.SSLPeerUnverifiedException r12 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ all -> 0x01c8 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c8 }
            r13.<init>()     // Catch:{ all -> 0x01c8 }
            java.lang.String r14 = "Hostname "
            r13.append(r14)     // Catch:{ all -> 0x01c8 }
            i.z r14 = r2.mo28020k()     // Catch:{ all -> 0x01c8 }
            java.lang.String r14 = r14.mo28138f()     // Catch:{ all -> 0x01c8 }
            r13.append(r14)     // Catch:{ all -> 0x01c8 }
            java.lang.String r14 = " not verified (no certificates)"
            r13.append(r14)     // Catch:{ all -> 0x01c8 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x01c8 }
            r12.<init>(r13)     // Catch:{ all -> 0x01c8 }
            throw r12     // Catch:{ all -> 0x01c8 }
        L_0x0146:
            i.h r4 = r2.mo28007a()     // Catch:{ all -> 0x01c8 }
            if (r4 != 0) goto L_0x014f
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x01c8 }
        L_0x014f:
            i.x r6 = new i.x     // Catch:{ all -> 0x01c8 }
            i.L r7 = r5.mo28108d()     // Catch:{ all -> 0x01c8 }
            i.j r8 = r5.mo28105a()     // Catch:{ all -> 0x01c8 }
            java.util.List r9 = r5.mo28106b()     // Catch:{ all -> 0x01c8 }
            i.M.f.g r10 = new i.M.f.g     // Catch:{ all -> 0x01c8 }
            r10.<init>(r4, r5, r2)     // Catch:{ all -> 0x01c8 }
            r6.<init>(r7, r8, r9, r10)     // Catch:{ all -> 0x01c8 }
            r11.f2382d = r6     // Catch:{ all -> 0x01c8 }
            i.z r2 = r2.mo28020k()     // Catch:{ all -> 0x01c8 }
            java.lang.String r2 = r2.mo28138f()     // Catch:{ all -> 0x01c8 }
            i.M.f.h r5 = new i.M.f.h     // Catch:{ all -> 0x01c8 }
            r5.<init>(r11)     // Catch:{ all -> 0x01c8 }
            r4.mo28060a((java.lang.String) r2, (kotlin.jvm.functions.Function0<? extends java.util.List<? extends java.security.cert.X509Certificate>>) r5)     // Catch:{ all -> 0x01c8 }
            boolean r12 = r12.mo28082c()     // Catch:{ all -> 0x01c8 }
            if (r12 == 0) goto L_0x0187
            i.M.k.h$a r12 = p040i.p103M.p112k.C1890h.f2683c     // Catch:{ all -> 0x01c8 }
            i.M.k.h r12 = p040i.p103M.p112k.C1890h.f2681a     // Catch:{ all -> 0x01c8 }
            java.lang.String r0 = r12.mo27966b((javax.net.ssl.SSLSocket) r3)     // Catch:{ all -> 0x01c8 }
        L_0x0187:
            r11.f2381c = r3     // Catch:{ all -> 0x01c8 }
            j.z r12 = p042j.C2080p.m3586b((java.net.Socket) r3)     // Catch:{ all -> 0x01c8 }
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r1)     // Catch:{ all -> 0x01c8 }
            j.t r2 = new j.t     // Catch:{ all -> 0x01c8 }
            r2.<init>(r12)     // Catch:{ all -> 0x01c8 }
            r11.f2385g = r2     // Catch:{ all -> 0x01c8 }
            j.x r12 = p042j.C2080p.m3582a((java.net.Socket) r3)     // Catch:{ all -> 0x01c8 }
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r1)     // Catch:{ all -> 0x01c8 }
            j.s r1 = new j.s     // Catch:{ all -> 0x01c8 }
            r1.<init>(r12)     // Catch:{ all -> 0x01c8 }
            r11.f2386h = r1     // Catch:{ all -> 0x01c8 }
            if (r0 == 0) goto L_0x01ae
            i.E$a r12 = p040i.C0974E.f699h     // Catch:{ all -> 0x01c8 }
            i.E r12 = r12.mo20398a(r0)     // Catch:{ all -> 0x01c8 }
            goto L_0x01b0
        L_0x01ae:
            i.E r12 = p040i.C0974E.HTTP_1_1     // Catch:{ all -> 0x01c8 }
        L_0x01b0:
            r11.f2383e = r12     // Catch:{ all -> 0x01c8 }
            i.M.k.h$a r12 = p040i.p103M.p112k.C1890h.f2683c
            i.M.k.h r12 = p040i.p103M.p112k.C1890h.f2681a
            r12.mo27980a((javax.net.ssl.SSLSocket) r3)
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r15)
            i.E r12 = r11.f2383e
            i.E r14 = p040i.C0974E.HTTP_2
            if (r12 != r14) goto L_0x01c7
            r11.m2814b((int) r13)
        L_0x01c7:
            return
        L_0x01c8:
            r12 = move-exception
            r0 = r3
            goto L_0x01d4
        L_0x01cb:
            kotlin.TypeCastException r12 = new kotlin.TypeCastException     // Catch:{ all -> 0x01d3 }
            java.lang.String r13 = "null cannot be cast to non-null type javax.net.ssl.SSLSocket"
            r12.<init>(r13)     // Catch:{ all -> 0x01d3 }
            throw r12     // Catch:{ all -> 0x01d3 }
        L_0x01d3:
            r12 = move-exception
        L_0x01d4:
            if (r0 == 0) goto L_0x01df
            i.M.k.h$a r13 = p040i.p103M.p112k.C1890h.f2683c
            i.M.k.h r13 = p040i.p103M.p112k.C1890h.f2681a
            r13.mo27980a((javax.net.ssl.SSLSocket) r0)
        L_0x01df:
            if (r0 == 0) goto L_0x01e4
            p040i.p103M.C1764b.m2630a((java.net.Socket) r0)
        L_0x01e4:
            throw r12
        L_0x01e5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p107f.C1806i.m2813a(i.M.f.b, int, i.f, i.t):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00fd, code lost:
        if (r7 == false) goto L_0x0101;
     */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0104 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0105 A[SYNTHETIC, Splitter:B:57:0x0105] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo27749a(p040i.C1912a r6, java.util.List<p040i.C1760K> r7) {
        /*
            r5 = this;
            java.lang.String r0 = "address"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.util.List<java.lang.ref.Reference<i.M.f.e>> r0 = r5.f2393o
            int r0 = r0.size()
            int r1 = r5.f2392n
            r2 = 0
            if (r0 >= r1) goto L_0x0125
            boolean r0 = r5.f2387i
            if (r0 == 0) goto L_0x0016
            goto L_0x0125
        L_0x0016:
            i.K r0 = r5.f2396r
            i.a r0 = r0.mo27588a()
            boolean r0 = r0.mo28008a(r6)
            if (r0 != 0) goto L_0x0023
            return r2
        L_0x0023:
            i.z r0 = r6.mo28020k()
            java.lang.String r0 = r0.mo28138f()
            i.K r1 = r5.f2396r
            i.a r1 = r1.mo27588a()
            i.z r1 = r1.mo28020k()
            java.lang.String r1 = r1.mo28138f()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r1 = 1
            if (r0 == 0) goto L_0x0041
            return r1
        L_0x0041:
            i.M.i.f r0 = r5.f2384f
            if (r0 != 0) goto L_0x0046
            return r2
        L_0x0046:
            if (r7 == 0) goto L_0x0125
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L_0x004f
            goto L_0x0090
        L_0x004f:
            java.util.Iterator r7 = r7.iterator()
        L_0x0053:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0090
            java.lang.Object r0 = r7.next()
            i.K r0 = (p040i.C1760K) r0
            java.net.Proxy r3 = r0.mo27589b()
            java.net.Proxy$Type r3 = r3.type()
            java.net.Proxy$Type r4 = java.net.Proxy.Type.DIRECT
            if (r3 != r4) goto L_0x008b
            i.K r3 = r5.f2396r
            java.net.Proxy r3 = r3.mo27589b()
            java.net.Proxy$Type r3 = r3.type()
            java.net.Proxy$Type r4 = java.net.Proxy.Type.DIRECT
            if (r3 != r4) goto L_0x008b
            i.K r3 = r5.f2396r
            java.net.InetSocketAddress r3 = r3.mo27591d()
            java.net.InetSocketAddress r0 = r0.mo27591d()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x008b
            r0 = 1
            goto L_0x008c
        L_0x008b:
            r0 = 0
        L_0x008c:
            if (r0 == 0) goto L_0x0053
            r7 = 1
            goto L_0x0091
        L_0x0090:
            r7 = 0
        L_0x0091:
            if (r7 != 0) goto L_0x0095
            goto L_0x0125
        L_0x0095:
            javax.net.ssl.HostnameVerifier r7 = r6.mo28011d()
            i.M.m.d r0 = p040i.p103M.p115m.C1907d.f2701a
            if (r7 == r0) goto L_0x009e
            return r2
        L_0x009e:
            i.z r7 = r6.mo28020k()
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            i.K r0 = r5.f2396r
            i.a r0 = r0.mo27588a()
            i.z r0 = r0.mo28020k()
            int r3 = r7.mo28143j()
            int r4 = r0.mo28143j()
            if (r3 == r4) goto L_0x00bc
            goto L_0x0101
        L_0x00bc:
            java.lang.String r3 = r7.mo28138f()
            java.lang.String r0 = r0.mo28138f()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x00cb
            goto L_0x00ff
        L_0x00cb:
            boolean r0 = r5.f2388j
            if (r0 != 0) goto L_0x0101
            i.x r0 = r5.f2382d
            if (r0 == 0) goto L_0x0101
            java.util.List r0 = r0.mo28107c()
            boolean r3 = r0.isEmpty()
            r3 = r3 ^ r1
            if (r3 == 0) goto L_0x00fc
            i.M.m.d r3 = p040i.p103M.p115m.C1907d.f2701a
            java.lang.String r7 = r7.mo28138f()
            java.lang.Object r0 = r0.get(r2)
            if (r0 == 0) goto L_0x00f4
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            boolean r7 = r3.mo28003a((java.lang.String) r7, (java.security.cert.X509Certificate) r0)
            if (r7 == 0) goto L_0x00fc
            r7 = 1
            goto L_0x00fd
        L_0x00f4:
            kotlin.TypeCastException r6 = new kotlin.TypeCastException
            java.lang.String r7 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            r6.<init>(r7)
            throw r6
        L_0x00fc:
            r7 = 0
        L_0x00fd:
            if (r7 == 0) goto L_0x0101
        L_0x00ff:
            r7 = 1
            goto L_0x0102
        L_0x0101:
            r7 = 0
        L_0x0102:
            if (r7 != 0) goto L_0x0105
            return r2
        L_0x0105:
            i.h r7 = r6.mo28007a()     // Catch:{ SSLPeerUnverifiedException -> 0x0125 }
            if (r7 != 0) goto L_0x010e
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ SSLPeerUnverifiedException -> 0x0125 }
        L_0x010e:
            i.z r6 = r6.mo28020k()     // Catch:{ SSLPeerUnverifiedException -> 0x0125 }
            java.lang.String r6 = r6.mo28138f()     // Catch:{ SSLPeerUnverifiedException -> 0x0125 }
            i.x r0 = r5.f2382d     // Catch:{ SSLPeerUnverifiedException -> 0x0125 }
            if (r0 != 0) goto L_0x011d
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ SSLPeerUnverifiedException -> 0x0125 }
        L_0x011d:
            java.util.List r0 = r0.mo28107c()     // Catch:{ SSLPeerUnverifiedException -> 0x0125 }
            r7.mo28059a((java.lang.String) r6, (java.util.List<? extends java.security.cert.Certificate>) r0)     // Catch:{ SSLPeerUnverifiedException -> 0x0125 }
            return r1
        L_0x0125:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p107f.C1806i.mo27749a(i.a, java.util.List):boolean");
    }
}
