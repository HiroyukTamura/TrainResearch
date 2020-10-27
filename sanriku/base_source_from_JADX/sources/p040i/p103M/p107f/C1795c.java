package p040i.p103M.p107f;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C0976G;
import p040i.C0980J;
import p040i.C1755F;
import p040i.C1758I;
import p040i.C1943t;
import p040i.p103M.p108g.C1818d;
import p040i.p103M.p108g.C1822h;
import p042j.C1015k;
import p042j.C1016z;
import p042j.C2068f;
import p042j.C2075j;
import p042j.C2085t;
import p042j.C2090x;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002ABB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ7\u0010\u001c\u001a\u0002H\u001d\"\n\b\u0000\u0010\u001d*\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u0002H\u001d¢\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020&J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0016J\u0006\u0010,\u001a\u00020&J\u0006\u0010-\u001a\u00020&J\u0006\u0010.\u001a\u00020&J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020&J\u0006\u00102\u001a\u00020&J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u0010\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020\u0016J\u000e\u0010:\u001a\u00020&2\u0006\u00105\u001a\u000206J\u0006\u0010;\u001a\u00020&J\u0010\u0010<\u001a\u00020&2\u0006\u0010#\u001a\u00020\u001eH\u0002J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020&J\u000e\u0010@\u001a\u00020&2\u0006\u0010)\u001a\u00020*R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168@X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018¨\u0006C"}, mo21739d2 = {"Lokhttp3/internal/connection/Exchange;", "", "call", "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "finder", "Lokhttp3/internal/connection/ExchangeFinder;", "codec", "Lokhttp3/internal/http/ExchangeCodec;", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;Lokhttp3/internal/connection/ExchangeFinder;Lokhttp3/internal/http/ExchangeCodec;)V", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnection$okhttp", "()Lokhttp3/internal/connection/RealConnection;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "getFinder$okhttp", "()Lokhttp3/internal/connection/ExchangeFinder;", "isCoalescedConnection", "", "isCoalescedConnection$okhttp", "()Z", "<set-?>", "isDuplex", "isDuplex$okhttp", "bodyComplete", "E", "Ljava/io/IOException;", "bytesRead", "", "responseDone", "requestDone", "e", "(JZZLjava/io/IOException;)Ljava/io/IOException;", "cancel", "", "createRequestBody", "Lokio/Sink;", "request", "Lokhttp3/Request;", "duplex", "detachWithViolence", "finishRequest", "flushRequest", "newWebSocketStreams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "noNewExchangesOnConnection", "noRequestBody", "openResponseBody", "Lokhttp3/ResponseBody;", "response", "Lokhttp3/Response;", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "responseHeadersEnd", "responseHeadersStart", "trackFailure", "trailers", "Lokhttp3/Headers;", "webSocketUpgradeFailed", "writeRequestHeaders", "RequestBodySink", "ResponseBodySource", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.f.c */
public final class C1795c {

    /* renamed from: a */
    private boolean f2325a;

    /* renamed from: b */
    private final C1806i f2326b;

    /* renamed from: c */
    private final C1799e f2327c;

    /* renamed from: d */
    private final C1943t f2328d;

    /* renamed from: e */
    private final C1798d f2329e;

    /* renamed from: f */
    private final C1818d f2330f;

    /* renamed from: i.M.f.c$a */
    private final class C1796a extends C2075j {

        /* renamed from: b */
        private boolean f2331b;

        /* renamed from: c */
        private long f2332c;

        /* renamed from: d */
        private boolean f2333d;

        /* renamed from: e */
        private final long f2334e;

        /* renamed from: f */
        final /* synthetic */ C1795c f2335f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1796a(C1795c cVar, C2090x xVar, long j) {
            super(xVar);
            Intrinsics.checkParameterIsNotNull(xVar, "delegate");
            this.f2335f = cVar;
            this.f2334e = j;
        }

        /* renamed from: a */
        private final <E extends IOException> E m2771a(E e) {
            if (this.f2331b) {
                return e;
            }
            this.f2331b = true;
            return this.f2335f.mo27686a(this.f2332c, false, true, e);
        }

        /* renamed from: a */
        public void mo27647a(C2068f fVar, long j) throws IOException {
            Intrinsics.checkParameterIsNotNull(fVar, FirebaseAnalytics.Param.SOURCE);
            if (!this.f2333d) {
                long j2 = this.f2334e;
                if (j2 == -1 || this.f2332c + j <= j2) {
                    try {
                        super.mo27647a(fVar, j);
                        this.f2332c += j;
                    } catch (IOException e) {
                        throw m2771a(e);
                    }
                } else {
                    StringBuilder a = C0681a.m330a("expected ");
                    a.append(this.f2334e);
                    a.append(" bytes but received ");
                    a.append(this.f2332c + j);
                    throw new ProtocolException(a.toString());
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }

        public void close() throws IOException {
            if (!this.f2333d) {
                this.f2333d = true;
                long j = this.f2334e;
                if (j == -1 || this.f2332c == j) {
                    try {
                        super.close();
                        m2771a((IOException) null);
                    } catch (IOException e) {
                        throw m2771a(e);
                    }
                } else {
                    throw new ProtocolException("unexpected end of stream");
                }
            }
        }

        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw m2771a(e);
            }
        }
    }

    /* renamed from: i.M.f.c$b */
    public final class C1797b extends C1015k {

        /* renamed from: a */
        private long f2336a;

        /* renamed from: b */
        private boolean f2337b = true;

        /* renamed from: c */
        private boolean f2338c;

        /* renamed from: d */
        private boolean f2339d;

        /* renamed from: e */
        private final long f2340e;

        /* renamed from: f */
        final /* synthetic */ C1795c f2341f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1797b(C1795c cVar, C1016z zVar, long j) {
            super(zVar);
            Intrinsics.checkParameterIsNotNull(zVar, "delegate");
            this.f2341f = cVar;
            this.f2340e = j;
            if (j == 0) {
                mo27702a((IOException) null);
            }
        }

        /* renamed from: a */
        public final <E extends IOException> E mo27702a(E e) {
            if (this.f2338c) {
                return e;
            }
            this.f2338c = true;
            if (e == null && this.f2337b) {
                this.f2337b = false;
                C1943t g = this.f2341f.mo27695g();
                C1799e e2 = this.f2341f.mo27693e();
                if (g != null) {
                    Intrinsics.checkParameterIsNotNull(e2, NotificationCompat.CATEGORY_CALL);
                } else {
                    throw null;
                }
            }
            return this.f2341f.mo27686a(this.f2336a, true, false, e);
        }

        public void close() throws IOException {
            if (!this.f2339d) {
                this.f2339d = true;
                try {
                    super.close();
                    mo27702a((IOException) null);
                } catch (IOException e) {
                    throw mo27702a(e);
                }
            }
        }

        public long read(C2068f fVar, long j) throws IOException {
            Intrinsics.checkParameterIsNotNull(fVar, "sink");
            if (!this.f2339d) {
                try {
                    long read = delegate().read(fVar, j);
                    if (this.f2337b) {
                        this.f2337b = false;
                        C1943t g = this.f2341f.mo27695g();
                        C1799e e = this.f2341f.mo27693e();
                        if (g != null) {
                            Intrinsics.checkParameterIsNotNull(e, NotificationCompat.CATEGORY_CALL);
                        } else {
                            throw null;
                        }
                    }
                    if (read == -1) {
                        mo27702a((IOException) null);
                        return -1;
                    }
                    long j2 = this.f2336a + read;
                    if (this.f2340e != -1) {
                        if (j2 > this.f2340e) {
                            throw new ProtocolException("expected " + this.f2340e + " bytes but received " + j2);
                        }
                    }
                    this.f2336a = j2;
                    if (j2 == this.f2340e) {
                        mo27702a((IOException) null);
                    }
                    return read;
                } catch (IOException e2) {
                    throw mo27702a(e2);
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
    }

    public C1795c(C1799e eVar, C1943t tVar, C1798d dVar, C1818d dVar2) {
        Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(tVar, "eventListener");
        Intrinsics.checkParameterIsNotNull(dVar, "finder");
        Intrinsics.checkParameterIsNotNull(dVar2, "codec");
        this.f2327c = eVar;
        this.f2328d = tVar;
        this.f2329e = dVar;
        this.f2330f = dVar2;
        this.f2326b = dVar2.mo27787b();
    }

    /* renamed from: a */
    private final void m2751a(IOException iOException) {
        this.f2329e.mo27705a(iOException);
        this.f2330f.mo27787b().mo27746a(this.f2327c, iOException);
    }

    /* renamed from: a */
    public final <E extends IOException> E mo27686a(long j, boolean z, boolean z2, E e) {
        if (e != null) {
            m2751a((IOException) e);
        }
        if (z2) {
            C1943t tVar = this.f2328d;
            C1799e eVar = this.f2327c;
            if (e != null) {
                if (tVar != null) {
                    Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                    Intrinsics.checkParameterIsNotNull(e, "ioe");
                } else {
                    throw null;
                }
            } else if (tVar != null) {
                Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            } else {
                throw null;
            }
        }
        if (z) {
            if (e != null) {
                C1943t tVar2 = this.f2328d;
                C1799e eVar2 = this.f2327c;
                if (tVar2 != null) {
                    Intrinsics.checkParameterIsNotNull(eVar2, NotificationCompat.CATEGORY_CALL);
                    Intrinsics.checkParameterIsNotNull(e, "ioe");
                } else {
                    throw null;
                }
            } else {
                C1943t tVar3 = this.f2328d;
                C1799e eVar3 = this.f2327c;
                if (tVar3 != null) {
                    Intrinsics.checkParameterIsNotNull(eVar3, NotificationCompat.CATEGORY_CALL);
                } else {
                    throw null;
                }
            }
        }
        return this.f2327c.mo27711a(this, z2, z, e);
    }

    /* renamed from: a */
    public final void mo27687a() {
        this.f2330f.cancel();
    }

    /* renamed from: b */
    public final void mo27689b() {
        this.f2330f.cancel();
        this.f2327c.mo27711a(this, true, true, null);
    }

    /* renamed from: b */
    public final void mo27690b(C1758I i) {
        Intrinsics.checkParameterIsNotNull(i, "response");
        C1943t tVar = this.f2328d;
        C1799e eVar = this.f2327c;
        if (tVar != null) {
            Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkParameterIsNotNull(i, "response");
            return;
        }
        throw null;
    }

    /* renamed from: c */
    public final void mo27691c() throws IOException {
        try {
            this.f2330f.mo27784a();
        } catch (IOException e) {
            C1943t tVar = this.f2328d;
            C1799e eVar = this.f2327c;
            if (tVar != null) {
                Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkParameterIsNotNull(e, "ioe");
                m2751a(e);
                throw e;
            }
            throw null;
        }
    }

    /* renamed from: d */
    public final void mo27692d() throws IOException {
        try {
            this.f2330f.mo27788c();
        } catch (IOException e) {
            C1943t tVar = this.f2328d;
            C1799e eVar = this.f2327c;
            if (tVar != null) {
                Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkParameterIsNotNull(e, "ioe");
                m2751a(e);
                throw e;
            }
            throw null;
        }
    }

    /* renamed from: e */
    public final C1799e mo27693e() {
        return this.f2327c;
    }

    /* renamed from: f */
    public final C1806i mo27694f() {
        return this.f2326b;
    }

    /* renamed from: g */
    public final C1943t mo27695g() {
        return this.f2328d;
    }

    /* renamed from: h */
    public final C1798d mo27696h() {
        return this.f2329e;
    }

    /* renamed from: i */
    public final boolean mo27697i() {
        return !Intrinsics.areEqual((Object) this.f2329e.mo27707b().mo28020k().mo28138f(), (Object) this.f2326b.mo27762l().mo27588a().mo28020k().mo28138f());
    }

    /* renamed from: j */
    public final boolean mo27698j() {
        return this.f2325a;
    }

    /* renamed from: k */
    public final void mo27699k() {
        this.f2330f.mo27787b().mo27761k();
    }

    /* renamed from: l */
    public final void mo27700l() {
        this.f2327c.mo27711a(this, true, false, null);
    }

    /* renamed from: m */
    public final void mo27701m() {
        C1943t tVar = this.f2328d;
        C1799e eVar = this.f2327c;
        if (tVar != null) {
            Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            return;
        }
        throw null;
    }

    /* renamed from: a */
    public final C2090x mo27685a(C1755F f, boolean z) throws IOException {
        Intrinsics.checkParameterIsNotNull(f, "request");
        this.f2325a = z;
        C0976G a = f.mo27533a();
        if (a == null) {
            Intrinsics.throwNpe();
        }
        long contentLength = a.contentLength();
        C1943t tVar = this.f2328d;
        C1799e eVar = this.f2327c;
        if (tVar != null) {
            Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            return new C1796a(this, this.f2330f.mo27782a(f, contentLength), contentLength);
        }
        throw null;
    }

    /* renamed from: a */
    public final C0980J mo27684a(C1758I i) throws IOException {
        Intrinsics.checkParameterIsNotNull(i, "response");
        try {
            String a = C1758I.m2561a(i, "Content-Type", (String) null, 2);
            long b = this.f2330f.mo27786b(i);
            C1797b bVar = new C1797b(this, this.f2330f.mo27783a(i), b);
            Intrinsics.checkParameterIsNotNull(bVar, "$this$buffer");
            return new C1822h(a, b, new C2085t(bVar));
        } catch (IOException e) {
            C1943t tVar = this.f2328d;
            C1799e eVar = this.f2327c;
            if (tVar != null) {
                Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkParameterIsNotNull(e, "ioe");
                m2751a(e);
                throw e;
            }
            throw null;
        }
    }

    /* renamed from: a */
    public final C1758I.C1759a mo27683a(boolean z) throws IOException {
        try {
            C1758I.C1759a a = this.f2330f.mo27781a(z);
            if (a != null) {
                a.mo27582a(this);
            }
            return a;
        } catch (IOException e) {
            C1943t tVar = this.f2328d;
            C1799e eVar = this.f2327c;
            if (tVar != null) {
                Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkParameterIsNotNull(e, "ioe");
                m2751a(e);
                throw e;
            }
            throw null;
        }
    }

    /* renamed from: a */
    public final void mo27688a(C1755F f) throws IOException {
        Intrinsics.checkParameterIsNotNull(f, "request");
        try {
            C1943t tVar = this.f2328d;
            C1799e eVar = this.f2327c;
            if (tVar != null) {
                Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                this.f2330f.mo27785a(f);
                C1943t tVar2 = this.f2328d;
                C1799e eVar2 = this.f2327c;
                if (tVar2 != null) {
                    Intrinsics.checkParameterIsNotNull(eVar2, NotificationCompat.CATEGORY_CALL);
                    Intrinsics.checkParameterIsNotNull(f, "request");
                    return;
                }
                throw null;
            }
            throw null;
        } catch (IOException e) {
            C1943t tVar3 = this.f2328d;
            C1799e eVar3 = this.f2327c;
            if (tVar3 != null) {
                Intrinsics.checkParameterIsNotNull(eVar3, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkParameterIsNotNull(e, "ioe");
                m2751a(e);
                throw e;
            }
            throw null;
        }
    }
}
