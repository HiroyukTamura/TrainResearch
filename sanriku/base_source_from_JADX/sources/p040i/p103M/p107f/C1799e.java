package p040i.p103M.p107f;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.fitness.FitnessActivities;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C1752D;
import p040i.C1755F;
import p040i.C1758I;
import p040i.C1912a;
import p040i.C1923f;
import p040i.C1925g;
import p040i.C1926h;
import p040i.C1940q;
import p040i.C1943t;
import p040i.C1955z;
import p040i.p103M.C1764b;
import p040i.p103M.p108g.C1818d;
import p040i.p103M.p108g.C1821g;
import p040i.p103M.p112k.C1890h;
import p042j.C2057A;
import p042j.C2062b;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001)\u0018\u00002\u00020\u0001:\u0002`aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010,\u001a\u00020-2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010.\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020-H\u0016J\b\u00100\u001a\u00020\u0000H\u0016J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020-2\u0006\u00106\u001a\u000207H\u0016J\u0016\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0007J\b\u0010;\u001a\u00020<H\u0016J\u0015\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020\u0007H\u0000¢\u0006\u0002\b?J\r\u0010@\u001a\u00020<H\u0000¢\u0006\u0002\bAJ\u0015\u0010B\u001a\u00020\u00192\u0006\u0010C\u001a\u00020DH\u0000¢\u0006\u0002\bEJ\b\u0010F\u001a\u00020\u0007H\u0016J\b\u0010G\u001a\u00020\u0007H\u0016J)\u0010H\u001a\u0002HI\"\n\b\u0000\u0010I*\u0004\u0018\u00010J2\u0006\u0010K\u001a\u0002HI2\u0006\u0010L\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010MJ;\u0010N\u001a\u0002HI\"\n\b\u0000\u0010I*\u0004\u0018\u00010J2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\u0006\u0010K\u001a\u0002HIH\u0000¢\u0006\u0004\bQ\u0010RJ\u0019\u0010%\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010JH\u0000¢\u0006\u0002\bSJ\r\u0010T\u001a\u00020UH\u0000¢\u0006\u0002\bVJ\u000f\u0010W\u001a\u0004\u0018\u00010XH\u0000¢\u0006\u0002\bYJ\b\u00109\u001a\u00020\u0005H\u0016J\u0006\u0010Z\u001a\u00020\u0007J\b\u0010(\u001a\u00020[H\u0016J\u0006\u0010+\u001a\u00020-J!\u0010\\\u001a\u0002HI\"\n\b\u0000\u0010I*\u0004\u0018\u00010J2\u0006\u0010]\u001a\u0002HIH\u0002¢\u0006\u0002\u0010^J\b\u0010_\u001a\u00020UH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u0004\u0018\u00010\u00192\b\u0010!\u001a\u0004\u0018\u00010\u0019@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0010\u0010(\u001a\u00020)X\u0004¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, mo21739d2 = {"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "client", "Lokhttp3/OkHttpClient;", "originalRequest", "Lokhttp3/Request;", "forWebSocket", "", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "callStackTrace", "", "canceled", "getClient", "()Lokhttp3/OkHttpClient;", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "setConnection", "(Lokhttp3/internal/connection/RealConnection;)V", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "eventListener", "Lokhttp3/EventListener;", "exchange", "Lokhttp3/internal/connection/Exchange;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "exchangeRequestDone", "exchangeResponseDone", "executed", "getForWebSocket", "()Z", "<set-?>", "interceptorScopedExchange", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "noMoreExchanges", "getOriginalRequest", "()Lokhttp3/Request;", "timeout", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "timeoutEarlyExit", "acquireConnectionNoEvents", "", "callStart", "cancel", "clone", "createAddress", "Lokhttp3/Address;", "url", "Lokhttp3/HttpUrl;", "enqueue", "responseCallback", "Lokhttp3/Callback;", "enterNetworkInterceptorExchange", "request", "newExchangeFinder", "execute", "Lokhttp3/Response;", "exitNetworkInterceptorExchange", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "getResponseWithInterceptorChain", "getResponseWithInterceptorChain$okhttp", "initExchange", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "initExchange$okhttp", "isCanceled", "isExecuted", "maybeReleaseConnection", "E", "Ljava/io/IOException;", "e", "force", "(Ljava/io/IOException;Z)Ljava/io/IOException;", "messageDone", "requestDone", "responseDone", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "noMoreExchanges$okhttp", "redactedUrl", "", "redactedUrl$okhttp", "releaseConnectionNoEvents", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "retryAfterFailure", "Lokio/AsyncTimeout;", "timeoutExit", "cause", "(Ljava/io/IOException;)Ljava/io/IOException;", "toLoggableString", "AsyncCall", "CallReference", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.f.e */
public final class C1799e implements C1923f {

    /* renamed from: a */
    private final C1807j f2353a;

    /* renamed from: b */
    private final C1943t f2354b = this.f2367q.mo27481l().mo27597a(this);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1802c f2355c;

    /* renamed from: d */
    private Object f2356d;

    /* renamed from: e */
    private C1798d f2357e;

    /* renamed from: f */
    private C1806i f2358f;

    /* renamed from: g */
    private C1795c f2359g;

    /* renamed from: h */
    private boolean f2360h;

    /* renamed from: i */
    private boolean f2361i;

    /* renamed from: l */
    private boolean f2362l;

    /* renamed from: m */
    private boolean f2363m;

    /* renamed from: n */
    private boolean f2364n;

    /* renamed from: o */
    private boolean f2365o;

    /* renamed from: p */
    private C1795c f2366p;

    /* renamed from: q */
    private final C1752D f2367q;

    /* renamed from: r */
    private final C1755F f2368r;

    /* renamed from: s */
    private final boolean f2369s;

    /* renamed from: i.M.f.e$a */
    public final class C1800a implements Runnable {

        /* renamed from: a */
        private volatile AtomicInteger f2370a = new AtomicInteger(0);

        /* renamed from: b */
        private final C1925g f2371b;

        /* renamed from: c */
        final /* synthetic */ C1799e f2372c;

        public C1800a(C1799e eVar, C1925g gVar) {
            Intrinsics.checkParameterIsNotNull(gVar, "responseCallback");
            this.f2372c = eVar;
            this.f2371b = gVar;
        }

        /* renamed from: a */
        public final C1799e mo27732a() {
            return this.f2372c;
        }

        /* renamed from: a */
        public final void mo27733a(C1800a aVar) {
            Intrinsics.checkParameterIsNotNull(aVar, FitnessActivities.OTHER);
            this.f2370a = aVar.f2370a;
        }

        /* renamed from: a */
        public final void mo27734a(ExecutorService executorService) {
            Intrinsics.checkParameterIsNotNull(executorService, "executorService");
            C1940q j = this.f2372c.mo27709a().mo27479j();
            if (!C1764b.f2219g || !Thread.holdsLock(j)) {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    this.f2372c.mo27712a((IOException) interruptedIOException);
                    this.f2371b.onFailure(this.f2372c, interruptedIOException);
                    this.f2372c.mo27709a().mo27479j().mo28098b(this);
                } catch (Throwable th) {
                    this.f2372c.mo27709a().mo27479j().mo28098b(this);
                    throw th;
                }
            } else {
                StringBuilder a = C0681a.m330a("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                a.append(currentThread.getName());
                a.append(" MUST NOT hold lock on ");
                a.append(j);
                throw new AssertionError(a.toString());
            }
        }

        /* renamed from: b */
        public final AtomicInteger mo27735b() {
            return this.f2370a;
        }

        /* renamed from: c */
        public final String mo27736c() {
            return this.f2372c.mo27722e().mo27542g().mo28138f();
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0052 A[Catch:{ all -> 0x0073, all -> 0x00be }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0079 A[Catch:{ all -> 0x0073, all -> 0x00be }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A[Catch:{ all -> 0x0073, all -> 0x00be }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                java.lang.String r0 = "OkHttp "
                java.lang.StringBuilder r0 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r0)
                i.M.f.e r1 = r6.f2372c
                java.lang.String r1 = r1.mo27725g()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                java.lang.String r2 = "currentThread"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                java.lang.String r2 = r1.getName()
                r1.setName(r0)
                i.M.f.e r0 = r6.f2372c     // Catch:{ all -> 0x00be }
                i.M.f.e$c r0 = r0.f2355c     // Catch:{ all -> 0x00be }
                r0.mo29126g()     // Catch:{ all -> 0x00be }
                i.M.f.e r0 = r6.f2372c     // Catch:{ IOException -> 0x0075, all -> 0x0049 }
                i.I r0 = r0.mo27724f()     // Catch:{ IOException -> 0x0075, all -> 0x0049 }
                r3 = 1
                i.g r4 = r6.f2371b     // Catch:{ IOException -> 0x0047, all -> 0x0045 }
                i.M.f.e r5 = r6.f2372c     // Catch:{ IOException -> 0x0047, all -> 0x0045 }
                r4.onResponse(r5, r0)     // Catch:{ IOException -> 0x0047, all -> 0x0045 }
                i.M.f.e r0 = r6.f2372c     // Catch:{ all -> 0x00be }
                i.D r0 = r0.mo27709a()     // Catch:{ all -> 0x00be }
            L_0x0040:
                i.q r0 = r0.mo27479j()     // Catch:{ all -> 0x00be }
                goto L_0x00a9
            L_0x0045:
                r0 = move-exception
                goto L_0x004b
            L_0x0047:
                r0 = move-exception
                goto L_0x0077
            L_0x0049:
                r0 = move-exception
                r3 = 0
            L_0x004b:
                i.M.f.e r4 = r6.f2372c     // Catch:{ all -> 0x0073 }
                r4.cancel()     // Catch:{ all -> 0x0073 }
                if (r3 != 0) goto L_0x0072
                java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r4.<init>()     // Catch:{ all -> 0x0073 }
                java.lang.String r5 = "canceled due to "
                r4.append(r5)     // Catch:{ all -> 0x0073 }
                r4.append(r0)     // Catch:{ all -> 0x0073 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0073 }
                r3.<init>(r4)     // Catch:{ all -> 0x0073 }
                r3.addSuppressed(r0)     // Catch:{ all -> 0x0073 }
                i.g r4 = r6.f2371b     // Catch:{ all -> 0x0073 }
                i.M.f.e r5 = r6.f2372c     // Catch:{ all -> 0x0073 }
                r4.onFailure(r5, r3)     // Catch:{ all -> 0x0073 }
            L_0x0072:
                throw r0     // Catch:{ all -> 0x0073 }
            L_0x0073:
                r0 = move-exception
                goto L_0x00b0
            L_0x0075:
                r0 = move-exception
                r3 = 0
            L_0x0077:
                if (r3 == 0) goto L_0x009b
                i.M.k.h$a r3 = p040i.p103M.p112k.C1890h.f2683c     // Catch:{ all -> 0x0073 }
                i.M.k.h r3 = p040i.p103M.p112k.C1890h.f2681a     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r4.<init>()     // Catch:{ all -> 0x0073 }
                java.lang.String r5 = "Callback failure for "
                r4.append(r5)     // Catch:{ all -> 0x0073 }
                i.M.f.e r5 = r6.f2372c     // Catch:{ all -> 0x0073 }
                java.lang.String r5 = p040i.p103M.p107f.C1799e.m2784b(r5)     // Catch:{ all -> 0x0073 }
                r4.append(r5)     // Catch:{ all -> 0x0073 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0073 }
                r5 = 4
                r3.mo27964a((java.lang.String) r4, (int) r5, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0073 }
                goto L_0x00a2
            L_0x009b:
                i.g r3 = r6.f2371b     // Catch:{ all -> 0x0073 }
                i.M.f.e r4 = r6.f2372c     // Catch:{ all -> 0x0073 }
                r3.onFailure(r4, r0)     // Catch:{ all -> 0x0073 }
            L_0x00a2:
                i.M.f.e r0 = r6.f2372c     // Catch:{ all -> 0x00be }
                i.D r0 = r0.mo27709a()     // Catch:{ all -> 0x00be }
                goto L_0x0040
            L_0x00a9:
                r0.mo28098b((p040i.p103M.p107f.C1799e.C1800a) r6)     // Catch:{ all -> 0x00be }
                r1.setName(r2)
                return
            L_0x00b0:
                i.M.f.e r3 = r6.f2372c     // Catch:{ all -> 0x00be }
                i.D r3 = r3.mo27709a()     // Catch:{ all -> 0x00be }
                i.q r3 = r3.mo27479j()     // Catch:{ all -> 0x00be }
                r3.mo28098b((p040i.p103M.p107f.C1799e.C1800a) r6)     // Catch:{ all -> 0x00be }
                throw r0     // Catch:{ all -> 0x00be }
            L_0x00be:
                r0 = move-exception
                r1.setName(r2)
                goto L_0x00c4
            L_0x00c3:
                throw r0
            L_0x00c4:
                goto L_0x00c3
            */
            throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p107f.C1799e.C1800a.run():void");
        }
    }

    /* renamed from: i.M.f.e$b */
    public static final class C1801b extends WeakReference<C1799e> {

        /* renamed from: a */
        private final Object f2373a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1801b(C1799e eVar, Object obj) {
            super(eVar);
            Intrinsics.checkParameterIsNotNull(eVar, "referent");
            this.f2373a = obj;
        }

        /* renamed from: a */
        public final Object mo27738a() {
            return this.f2373a;
        }
    }

    /* renamed from: i.M.f.e$c */
    public static final class C1802c extends C2062b {

        /* renamed from: l */
        final /* synthetic */ C1799e f2374l;

        C1802c(C1799e eVar) {
            this.f2374l = eVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: i */
        public void mo27739i() {
            this.f2374l.cancel();
        }
    }

    public C1799e(C1752D d, C1755F f, boolean z) {
        Intrinsics.checkParameterIsNotNull(d, "client");
        Intrinsics.checkParameterIsNotNull(f, "originalRequest");
        this.f2367q = d;
        this.f2368r = f;
        this.f2369s = z;
        this.f2353a = d.mo27476g().mo28077a();
        C1802c cVar = new C1802c(this);
        cVar.mo29120a((long) this.f2367q.mo27471c(), TimeUnit.MILLISECONDS);
        this.f2355c = cVar;
    }

    /* renamed from: b */
    public static final /* synthetic */ String m2784b(C1799e eVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(eVar.isCanceled() ? "canceled " : "");
        sb.append(eVar.f2369s ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(eVar.f2368r.mo27542g().mo28145l());
        return sb.toString();
    }

    /* renamed from: k */
    private final void m2785k() {
        C1890h.C1891a aVar = C1890h.f2683c;
        this.f2356d = C1890h.f2681a.mo27968a("response.body().close()");
        if (this.f2354b != null) {
            Intrinsics.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
            return;
        }
        throw null;
    }

    /* renamed from: a */
    public final C1752D mo27709a() {
        return this.f2367q;
    }

    /* renamed from: a */
    public final C1795c mo27710a(C1821g gVar) {
        Intrinsics.checkParameterIsNotNull(gVar, "chain");
        synchronized (this.f2353a) {
            boolean z = true;
            if (!this.f2364n) {
                if (this.f2359g != null) {
                    z = false;
                }
                if (z) {
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        C1798d dVar = this.f2357e;
        if (dVar == null) {
            Intrinsics.throwNpe();
        }
        C1818d a = dVar.mo27704a(this.f2367q, gVar);
        C1943t tVar = this.f2354b;
        C1798d dVar2 = this.f2357e;
        if (dVar2 == null) {
            Intrinsics.throwNpe();
        }
        C1795c cVar = new C1795c(this, tVar, dVar2, a);
        this.f2366p = cVar;
        synchronized (this.f2353a) {
            this.f2359g = cVar;
            this.f2360h = false;
            this.f2361i = false;
        }
        return cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004c, code lost:
        if (r1 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return m2783a(r6, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return r6;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E extends java.io.IOException> E mo27711a(p040i.p103M.p107f.C1795c r3, boolean r4, boolean r5, E r6) {
        /*
            r2 = this;
            java.lang.String r0 = "exchange"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            i.M.f.j r0 = r2.f2353a
            monitor-enter(r0)
            i.M.f.c r1 = r2.f2359g     // Catch:{ all -> 0x0053 }
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)     // Catch:{ all -> 0x0053 }
            r1 = 1
            r3 = r3 ^ r1
            if (r3 == 0) goto L_0x0014
            monitor-exit(r0)
            return r6
        L_0x0014:
            r3 = 0
            if (r4 == 0) goto L_0x001d
            boolean r4 = r2.f2360h     // Catch:{ all -> 0x0053 }
            r4 = r4 ^ r1
            r2.f2360h = r1     // Catch:{ all -> 0x0053 }
            goto L_0x001e
        L_0x001d:
            r4 = 0
        L_0x001e:
            if (r5 == 0) goto L_0x0027
            boolean r5 = r2.f2361i     // Catch:{ all -> 0x0053 }
            if (r5 != 0) goto L_0x0025
            r4 = 1
        L_0x0025:
            r2.f2361i = r1     // Catch:{ all -> 0x0053 }
        L_0x0027:
            boolean r5 = r2.f2360h     // Catch:{ all -> 0x0053 }
            if (r5 == 0) goto L_0x0048
            boolean r5 = r2.f2361i     // Catch:{ all -> 0x0053 }
            if (r5 == 0) goto L_0x0048
            if (r4 == 0) goto L_0x0048
            i.M.f.c r4 = r2.f2359g     // Catch:{ all -> 0x0053 }
            if (r4 != 0) goto L_0x0038
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0053 }
        L_0x0038:
            i.M.f.i r4 = r4.mo27694f()     // Catch:{ all -> 0x0053 }
            int r5 = r4.mo27757g()     // Catch:{ all -> 0x0053 }
            int r5 = r5 + r1
            r4.mo27742a((int) r5)     // Catch:{ all -> 0x0053 }
            r4 = 0
            r2.f2359g = r4     // Catch:{ all -> 0x0053 }
            goto L_0x0049
        L_0x0048:
            r1 = 0
        L_0x0049:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0053 }
            monitor-exit(r0)
            if (r1 == 0) goto L_0x0052
            java.io.IOException r6 = r2.m2783a(r6, (boolean) r3)
        L_0x0052:
            return r6
        L_0x0053:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p107f.C1799e.mo27711a(i.M.f.c, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    /* renamed from: a */
    public final IOException mo27712a(IOException iOException) {
        synchronized (this.f2353a) {
            this.f2364n = true;
            Unit unit = Unit.INSTANCE;
        }
        return m2783a(iOException, false);
    }

    /* renamed from: a */
    public final void mo27713a(C1755F f, boolean z) {
        C1926h hVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        Intrinsics.checkParameterIsNotNull(f, "request");
        boolean z2 = true;
        if (this.f2366p == null) {
            if (this.f2359g != null) {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            } else if (z) {
                C1807j jVar = this.f2353a;
                C1955z g = f.mo27542g();
                if (g.mo28139g()) {
                    SSLSocketFactory B = this.f2367q.mo27465B();
                    hostnameVerifier = this.f2367q.mo27485p();
                    sSLSocketFactory = B;
                    hVar = this.f2367q.mo27474e();
                } else {
                    sSLSocketFactory = null;
                    hostnameVerifier = null;
                    hVar = null;
                }
                this.f2357e = new C1798d(jVar, new C1912a(g.mo28138f(), g.mo28143j(), this.f2367q.mo27480k(), this.f2367q.mo27464A(), sSLSocketFactory, hostnameVerifier, hVar, this.f2367q.mo27492w(), this.f2367q.mo27491v(), this.f2367q.mo27490u(), this.f2367q.mo27477h(), this.f2367q.mo27493x()), this, this.f2354b);
            }
        } else {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* renamed from: a */
    public final void mo27714a(C1806i iVar) {
        Intrinsics.checkParameterIsNotNull(iVar, "connection");
        C1807j jVar = this.f2353a;
        if (!C1764b.f2219g || Thread.holdsLock(jVar)) {
            if (this.f2358f == null) {
                this.f2358f = iVar;
                iVar.mo27753c().add(new C1801b(this, this.f2356d));
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        StringBuilder a = C0681a.m330a("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        a.append(currentThread.getName());
        a.append(" MUST hold lock on ");
        a.append(jVar);
        throw new AssertionError(a.toString());
    }

    /* renamed from: a */
    public void mo27715a(C1925g gVar) {
        Intrinsics.checkParameterIsNotNull(gVar, "responseCallback");
        synchronized (this) {
            if (!this.f2365o) {
                this.f2365o = true;
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("Already Executed".toString());
            }
        }
        m2785k();
        this.f2367q.mo27479j().mo28095a(new C1800a(this, gVar));
    }

    /* renamed from: a */
    public final void mo27716a(boolean z) {
        boolean z2 = true;
        if (!this.f2364n) {
            if (z) {
                C1795c cVar = this.f2359g;
                if (cVar != null) {
                    cVar.mo27689b();
                }
                if (this.f2359g != null) {
                    z2 = false;
                }
                if (!z2) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
            this.f2366p = null;
            return;
        }
        throw new IllegalStateException("released".toString());
    }

    /* renamed from: b */
    public final C1806i mo27717b() {
        return this.f2358f;
    }

    /* renamed from: c */
    public final boolean mo27718c() {
        return this.f2369s;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        if (r1 == null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0020, code lost:
        r1.mo27687a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0024, code lost:
        if (r2 == null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
        r2.mo27751b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002b, code lost:
        if (r4.f2354b == null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002d, code lost:
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, androidx.core.app.NotificationCompat.CATEGORY_CALL);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0034, code lost:
        throw null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r4 = this;
            i.M.f.j r0 = r4.f2353a
            monitor-enter(r0)
            boolean r1 = r4.f2362l     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            r1 = 1
            r4.f2362l = r1     // Catch:{ all -> 0x0035 }
            i.M.f.c r1 = r4.f2359g     // Catch:{ all -> 0x0035 }
            i.M.f.d r2 = r4.f2357e     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0019
            i.M.f.i r2 = r2.mo27703a()     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            i.M.f.i r2 = r4.f2358f     // Catch:{ all -> 0x0035 }
        L_0x001b:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)
            if (r1 == 0) goto L_0x0024
            r1.mo27687a()
            goto L_0x0029
        L_0x0024:
            if (r2 == 0) goto L_0x0029
            r2.mo27751b()
        L_0x0029:
            i.t r0 = r4.f2354b
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            return
        L_0x0033:
            r0 = 0
            throw r0
        L_0x0035:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p107f.C1799e.cancel():void");
    }

    public Object clone() {
        return new C1799e(this.f2367q, this.f2368r, this.f2369s);
    }

    /* renamed from: d */
    public final C1795c mo27721d() {
        return this.f2366p;
    }

    /* renamed from: e */
    public final C1755F mo27722e() {
        return this.f2368r;
    }

    public C1758I execute() {
        synchronized (this) {
            if (!this.f2365o) {
                this.f2365o = true;
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("Already Executed".toString());
            }
        }
        this.f2355c.mo29126g();
        m2785k();
        try {
            this.f2367q.mo27479j().mo28096a(this);
            return mo27724f();
        } finally {
            this.f2367q.mo27479j().mo28099b(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a2  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final p040i.C1758I mo27724f() throws java.io.IOException {
        /*
            r10 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            i.D r0 = r10.f2367q
            java.util.List r0 = r0.mo27486q()
            boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(r2, r0)
            i.M.g.i r0 = new i.M.g.i
            i.D r1 = r10.f2367q
            r0.<init>(r1)
            r2.add(r0)
            i.M.g.a r0 = new i.M.g.a
            i.D r1 = r10.f2367q
            i.p r1 = r1.mo27478i()
            r0.<init>(r1)
            r2.add(r0)
            i.M.d.a r0 = new i.M.d.a
            i.D r1 = r10.f2367q
            i.d r1 = r1.mo27470b()
            r0.<init>(r1)
            r2.add(r0)
            i.M.f.a r0 = p040i.p103M.p107f.C1793a.f2320a
            r2.add(r0)
            boolean r0 = r10.f2369s
            if (r0 != 0) goto L_0x0046
            i.D r0 = r10.f2367q
            java.util.List r0 = r0.mo27488s()
            boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(r2, r0)
        L_0x0046:
            i.M.g.b r0 = new i.M.g.b
            boolean r1 = r10.f2369s
            r0.<init>(r1)
            r2.add(r0)
            i.M.g.g r9 = new i.M.g.g
            r3 = 0
            r4 = 0
            i.F r5 = r10.f2368r
            i.D r0 = r10.f2367q
            int r6 = r0.mo27475f()
            i.D r0 = r10.f2367q
            int r7 = r0.mo27494y()
            i.D r0 = r10.f2367q
            int r8 = r0.mo27466C()
            r0 = r9
            r1 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            r1 = 0
            i.F r2 = r10.f2368r     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            i.I r2 = r9.mo27450a(r2)     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            boolean r3 = r10.isCanceled()     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            if (r3 != 0) goto L_0x007f
            r10.mo27712a((java.io.IOException) r1)
            return r2
        L_0x007f:
            p040i.p103M.C1764b.m2629a((java.io.Closeable) r2)     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            throw r2     // Catch:{ IOException -> 0x008c, all -> 0x008a }
        L_0x008a:
            r2 = move-exception
            goto L_0x00a0
        L_0x008c:
            r0 = move-exception
            r2 = 1
            java.io.IOException r0 = r10.mo27712a((java.io.IOException) r0)     // Catch:{ all -> 0x009d }
            if (r0 != 0) goto L_0x009c
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ all -> 0x009d }
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Throwable"
            r0.<init>(r3)     // Catch:{ all -> 0x009d }
            throw r0     // Catch:{ all -> 0x009d }
        L_0x009c:
            throw r0     // Catch:{ all -> 0x009d }
        L_0x009d:
            r0 = move-exception
            r2 = r0
            r0 = 1
        L_0x00a0:
            if (r0 != 0) goto L_0x00a5
            r10.mo27712a((java.io.IOException) r1)
        L_0x00a5:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p107f.C1799e.mo27724f():i.I");
    }

    /* renamed from: g */
    public final String mo27725g() {
        return this.f2368r.mo27542g().mo28145l();
    }

    /* renamed from: h */
    public final Socket mo27726h() {
        C1807j jVar = this.f2353a;
        if (!C1764b.f2219g || Thread.holdsLock(jVar)) {
            C1806i iVar = this.f2358f;
            if (iVar == null) {
                Intrinsics.throwNpe();
            }
            Iterator<Reference<C1799e>> it = iVar.mo27753c().iterator();
            boolean z = false;
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual((Object) (C1799e) it.next().get(), (Object) this)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                z = true;
            }
            if (z) {
                C1806i iVar2 = this.f2358f;
                if (iVar2 == null) {
                    Intrinsics.throwNpe();
                }
                iVar2.mo27753c().remove(i);
                this.f2358f = null;
                if (iVar2.mo27753c().isEmpty()) {
                    iVar2.mo27744a(System.nanoTime());
                    if (this.f2353a.mo27766a(iVar2)) {
                        return iVar2.mo27763m();
                    }
                }
                return null;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        StringBuilder a = C0681a.m330a("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        a.append(currentThread.getName());
        a.append(" MUST hold lock on ");
        a.append(jVar);
        throw new AssertionError(a.toString());
    }

    /* renamed from: i */
    public final boolean mo27727i() {
        C1798d dVar = this.f2357e;
        if (dVar == null) {
            Intrinsics.throwNpe();
        }
        return dVar.mo27708c();
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.f2353a) {
            z = this.f2362l;
        }
        return z;
    }

    /* renamed from: j */
    public final void mo27729j() {
        if (!this.f2363m) {
            this.f2363m = true;
            this.f2355c.mo29127h();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public C1755F request() {
        return this.f2368r;
    }

    public C2057A timeout() {
        return this.f2355c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0019 A[Catch:{ all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00a8  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <E extends java.io.IOException> E m2783a(E r8, boolean r9) {
        /*
            r7 = this;
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            i.M.f.j r1 = r7.f2353a
            monitor-enter(r1)
            r2 = 1
            r3 = 0
            if (r9 == 0) goto L_0x0016
            i.M.f.c r4 = r7.f2359g     // Catch:{ all -> 0x0013 }
            if (r4 != 0) goto L_0x0011
            goto L_0x0016
        L_0x0011:
            r4 = 0
            goto L_0x0017
        L_0x0013:
            r8 = move-exception
            goto L_0x00b4
        L_0x0016:
            r4 = 1
        L_0x0017:
            if (r4 == 0) goto L_0x00a8
            i.M.f.i r4 = r7.f2358f     // Catch:{ all -> 0x0013 }
            r0.element = r4     // Catch:{ all -> 0x0013 }
            i.M.f.i r4 = r7.f2358f     // Catch:{ all -> 0x0013 }
            r5 = 0
            if (r4 == 0) goto L_0x0031
            i.M.f.c r4 = r7.f2359g     // Catch:{ all -> 0x0013 }
            if (r4 != 0) goto L_0x0031
            if (r9 != 0) goto L_0x002c
            boolean r9 = r7.f2364n     // Catch:{ all -> 0x0013 }
            if (r9 == 0) goto L_0x0031
        L_0x002c:
            java.net.Socket r9 = r7.mo27726h()     // Catch:{ all -> 0x0013 }
            goto L_0x0032
        L_0x0031:
            r9 = r5
        L_0x0032:
            i.M.f.i r4 = r7.f2358f     // Catch:{ all -> 0x0013 }
            if (r4 == 0) goto L_0x0038
            r0.element = r5     // Catch:{ all -> 0x0013 }
        L_0x0038:
            boolean r4 = r7.f2364n     // Catch:{ all -> 0x0013 }
            if (r4 == 0) goto L_0x0042
            i.M.f.c r4 = r7.f2359g     // Catch:{ all -> 0x0013 }
            if (r4 != 0) goto L_0x0042
            r4 = 1
            goto L_0x0043
        L_0x0042:
            r4 = 0
        L_0x0043:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0013 }
            monitor-exit(r1)
            if (r9 == 0) goto L_0x004b
            p040i.p103M.C1764b.m2630a((java.net.Socket) r9)
        L_0x004b:
            T r9 = r0.element
            i.k r9 = (p040i.C1934k) r9
            if (r9 == 0) goto L_0x0066
            i.t r0 = r7.f2354b
            if (r9 != 0) goto L_0x0058
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0058:
            if (r0 == 0) goto L_0x0065
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            java.lang.String r0 = "connection"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            goto L_0x0066
        L_0x0065:
            throw r5
        L_0x0066:
            if (r4 == 0) goto L_0x00a7
            if (r8 == 0) goto L_0x006b
            goto L_0x006c
        L_0x006b:
            r2 = 0
        L_0x006c:
            boolean r9 = r7.f2363m
            if (r9 == 0) goto L_0x0071
            goto L_0x0087
        L_0x0071:
            i.M.f.e$c r9 = r7.f2355c
            boolean r9 = r9.mo29127h()
            if (r9 != 0) goto L_0x007a
            goto L_0x0087
        L_0x007a:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException
            java.lang.String r0 = "timeout"
            r9.<init>(r0)
            if (r8 == 0) goto L_0x0086
            r9.initCause(r8)
        L_0x0086:
            r8 = r9
        L_0x0087:
            i.t r9 = r7.f2354b
            if (r2 == 0) goto L_0x009e
            if (r8 != 0) goto L_0x0090
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0090:
            if (r9 == 0) goto L_0x009d
            java.lang.String r9 = "call"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r9)
            java.lang.String r9 = "ioe"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r9)
            goto L_0x00a7
        L_0x009d:
            throw r5
        L_0x009e:
            if (r9 == 0) goto L_0x00a6
            java.lang.String r9 = "call"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r9)
            goto L_0x00a7
        L_0x00a6:
            throw r5
        L_0x00a7:
            return r8
        L_0x00a8:
            java.lang.String r8 = "cannot release connection while it is in use"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0013 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0013 }
            r9.<init>(r8)     // Catch:{ all -> 0x0013 }
            throw r9     // Catch:{ all -> 0x0013 }
        L_0x00b4:
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p107f.C1799e.m2783a(java.io.IOException, boolean):java.io.IOException");
    }
}
