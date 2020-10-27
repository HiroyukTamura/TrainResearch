package p040i.p103M.p109h;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C1752D;
import p040i.C1755F;
import p040i.C1758I;
import p040i.C1939p;
import p040i.C1952y;
import p040i.C1955z;
import p040i.p103M.C1764b;
import p040i.p103M.p107f.C1806i;
import p040i.p103M.p108g.C1818d;
import p040i.p103M.p108g.C1819e;
import p040i.p103M.p108g.C1824j;
import p042j.C1016z;
import p042j.C2057A;
import p042j.C2068f;
import p042j.C2071g;
import p042j.C2072h;
import p042j.C2076l;
import p042j.C2090x;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 ?2\u00020\u0001:\u0007<=>?@ABB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u001cH\u0016J\b\u0010'\u001a\u00020\u001eH\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\b\u0010/\u001a\u00020)H\u0002J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u0019H\u0016J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u0010H\u0016J\u0010\u00105\u001a\u00020!2\u0006\u00101\u001a\u00020\u0019H\u0016J\u000e\u00106\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0019J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0017H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\u00020\u0010*\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0018\u0010\u0016\u001a\u00020\u0010*\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u001a¨\u0006C"}, mo21739d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "connection", "Lokhttp3/internal/connection/RealConnection;", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokio/BufferedSource;Lokio/BufferedSink;)V", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "headersReader", "Lokhttp3/internal/http1/HeadersReader;", "isClosed", "", "()Z", "state", "", "trailers", "Lokhttp3/Headers;", "isChunked", "Lokhttp3/Request;", "(Lokhttp3/Request;)Z", "Lokhttp3/Response;", "(Lokhttp3/Response;)Z", "cancel", "", "createRequestBody", "Lokio/Sink;", "request", "contentLength", "", "detachTimeout", "timeout", "Lokio/ForwardingTimeout;", "finishRequest", "flushRequest", "newChunkedSink", "newChunkedSource", "Lokio/Source;", "url", "Lokhttp3/HttpUrl;", "newFixedLengthSource", "length", "newKnownLengthSink", "newUnknownLengthSource", "openResponseBodySource", "response", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "reportedContentLength", "skipConnectBody", "writeRequest", "headers", "requestLine", "", "writeRequestHeaders", "AbstractSource", "ChunkedSink", "ChunkedSource", "Companion", "FixedLengthSource", "KnownLengthSink", "UnknownLengthSource", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.h.b */
public final class C1826b implements C1818d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f2444a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1825a f2445b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C1952y f2446c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1752D f2447d;

    /* renamed from: e */
    private final C1806i f2448e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C2072h f2449f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C2071g f2450g;

    /* renamed from: i.M.h.b$a */
    private abstract class C1827a implements C1016z {

        /* renamed from: a */
        private final C2076l f2451a;

        /* renamed from: b */
        private boolean f2452b;

        public C1827a() {
            this.f2451a = new C2076l(C1826b.this.f2449f.timeout());
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo27802a(boolean z) {
            this.f2452b = z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public final boolean mo27803d() {
            return this.f2452b;
        }

        /* renamed from: h */
        public final void mo27804h() {
            if (C1826b.this.f2444a != 6) {
                if (C1826b.this.f2444a == 5) {
                    C1826b.m2896a(C1826b.this, this.f2451a);
                    C1826b.this.f2444a = 6;
                    return;
                }
                StringBuilder a = C0681a.m330a("state: ");
                a.append(C1826b.this.f2444a);
                throw new IllegalStateException(a.toString());
            }
        }

        public long read(C2068f fVar, long j) {
            Intrinsics.checkParameterIsNotNull(fVar, "sink");
            try {
                return C1826b.this.f2449f.read(fVar, j);
            } catch (IOException e) {
                C1826b.this.mo27787b().mo27761k();
                mo27804h();
                throw e;
            }
        }

        public C2057A timeout() {
            return this.f2451a;
        }
    }

    /* renamed from: i.M.h.b$b */
    private final class C1828b implements C2090x {

        /* renamed from: a */
        private final C2076l f2454a;

        /* renamed from: b */
        private boolean f2455b;

        public C1828b() {
            this.f2454a = new C2076l(C1826b.this.f2450g.timeout());
        }

        /* renamed from: a */
        public void mo27647a(C2068f fVar, long j) {
            Intrinsics.checkParameterIsNotNull(fVar, FirebaseAnalytics.Param.SOURCE);
            if (!(!this.f2455b)) {
                throw new IllegalStateException("closed".toString());
            } else if (j != 0) {
                C1826b.this.f2450g.mo29151c(j);
                C1826b.this.f2450g.mo29138a("\r\n");
                C1826b.this.f2450g.mo27647a(fVar, j);
                C1826b.this.f2450g.mo29138a("\r\n");
            }
        }

        public synchronized void close() {
            if (!this.f2455b) {
                this.f2455b = true;
                C1826b.this.f2450g.mo29138a("0\r\n\r\n");
                C1826b.m2896a(C1826b.this, this.f2454a);
                C1826b.this.f2444a = 3;
            }
        }

        public synchronized void flush() {
            if (!this.f2455b) {
                C1826b.this.f2450g.flush();
            }
        }

        public C2057A timeout() {
            return this.f2454a;
        }
    }

    /* renamed from: i.M.h.b$c */
    private final class C1829c extends C1827a {

        /* renamed from: d */
        private long f2457d = -1;

        /* renamed from: e */
        private boolean f2458e = true;

        /* renamed from: f */
        private final C1955z f2459f;

        /* renamed from: g */
        final /* synthetic */ C1826b f2460g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1829c(C1826b bVar, C1955z zVar) {
            super();
            Intrinsics.checkParameterIsNotNull(zVar, ImagesContract.URL);
            this.f2460g = bVar;
            this.f2459f = zVar;
        }

        public void close() {
            if (!mo27803d()) {
                if (this.f2458e && !C1764b.m2632a((C1016z) this, 100, TimeUnit.MILLISECONDS)) {
                    this.f2460g.mo27787b().mo27761k();
                    mo27804h();
                }
                mo27802a(true);
            }
        }

        public long read(C2068f fVar, long j) {
            Intrinsics.checkParameterIsNotNull(fVar, "sink");
            boolean z = true;
            if (!(j >= 0)) {
                throw new IllegalArgumentException(C0681a.m318a("byteCount < 0: ", j).toString());
            } else if (!(!mo27803d())) {
                throw new IllegalStateException("closed".toString());
            } else if (!this.f2458e) {
                return -1;
            } else {
                long j2 = this.f2457d;
                if (j2 == 0 || j2 == -1) {
                    if (this.f2457d != -1) {
                        this.f2460g.f2449f.mo29171k();
                    }
                    try {
                        this.f2457d = this.f2460g.f2449f.mo29173m();
                        String k = this.f2460g.f2449f.mo29171k();
                        if (k != null) {
                            String obj = StringsKt__StringsKt.trim((CharSequence) k).toString();
                            if (this.f2457d >= 0) {
                                if (obj.length() <= 0) {
                                    z = false;
                                }
                                if (!z || StringsKt__StringsJVMKt.startsWith$default(obj, ";", false, 2, (Object) null)) {
                                    if (this.f2457d == 0) {
                                        this.f2458e = false;
                                        C1826b bVar = this.f2460g;
                                        bVar.f2446c = bVar.f2445b.mo27798a();
                                        C1752D a = this.f2460g.f2447d;
                                        if (a == null) {
                                            Intrinsics.throwNpe();
                                        }
                                        C1939p i = a.mo27478i();
                                        C1955z zVar = this.f2459f;
                                        C1952y f = this.f2460g.f2446c;
                                        if (f == null) {
                                            Intrinsics.throwNpe();
                                        }
                                        C1819e.m2870a(i, zVar, f);
                                        mo27804h();
                                    }
                                    if (!this.f2458e) {
                                        return -1;
                                    }
                                }
                            }
                            throw new ProtocolException("expected chunk size and optional extensions" + " but was \"" + this.f2457d + obj + Typography.quote);
                        }
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    } catch (NumberFormatException e) {
                        throw new ProtocolException(e.getMessage());
                    }
                }
                long read = super.read(fVar, Math.min(j, this.f2457d));
                if (read != -1) {
                    this.f2457d -= read;
                    return read;
                }
                this.f2460g.mo27787b().mo27761k();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                mo27804h();
                throw protocolException;
            }
        }
    }

    /* renamed from: i.M.h.b$d */
    private final class C1830d extends C1827a {

        /* renamed from: d */
        private long f2461d;

        public C1830d(long j) {
            super();
            this.f2461d = j;
            if (j == 0) {
                mo27804h();
            }
        }

        public void close() {
            if (!mo27803d()) {
                if (this.f2461d != 0 && !C1764b.m2632a((C1016z) this, 100, TimeUnit.MILLISECONDS)) {
                    C1826b.this.mo27787b().mo27761k();
                    mo27804h();
                }
                mo27802a(true);
            }
        }

        public long read(C2068f fVar, long j) {
            Intrinsics.checkParameterIsNotNull(fVar, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(C0681a.m318a("byteCount < 0: ", j).toString());
            } else if (!mo27803d()) {
                long j2 = this.f2461d;
                if (j2 == 0) {
                    return -1;
                }
                long read = super.read(fVar, Math.min(j2, j));
                if (read != -1) {
                    long j3 = this.f2461d - read;
                    this.f2461d = j3;
                    if (j3 == 0) {
                        mo27804h();
                    }
                    return read;
                }
                C1826b.this.mo27787b().mo27761k();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                mo27804h();
                throw protocolException;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
    }

    /* renamed from: i.M.h.b$e */
    private final class C1831e implements C2090x {

        /* renamed from: a */
        private final C2076l f2463a;

        /* renamed from: b */
        private boolean f2464b;

        public C1831e() {
            this.f2463a = new C2076l(C1826b.this.f2450g.timeout());
        }

        /* renamed from: a */
        public void mo27647a(C2068f fVar, long j) {
            Intrinsics.checkParameterIsNotNull(fVar, FirebaseAnalytics.Param.SOURCE);
            if (!this.f2464b) {
                C1764b.m2627a(fVar.size(), 0, j);
                C1826b.this.f2450g.mo27647a(fVar, j);
                return;
            }
            throw new IllegalStateException("closed".toString());
        }

        public void close() {
            if (!this.f2464b) {
                this.f2464b = true;
                C1826b.m2896a(C1826b.this, this.f2463a);
                C1826b.this.f2444a = 3;
            }
        }

        public void flush() {
            if (!this.f2464b) {
                C1826b.this.f2450g.flush();
            }
        }

        public C2057A timeout() {
            return this.f2463a;
        }
    }

    /* renamed from: i.M.h.b$f */
    private final class C1832f extends C1827a {

        /* renamed from: d */
        private boolean f2466d;

        public C1832f(C1826b bVar) {
            super();
        }

        public void close() {
            if (!mo27803d()) {
                if (!this.f2466d) {
                    mo27804h();
                }
                mo27802a(true);
            }
        }

        public long read(C2068f fVar, long j) {
            Intrinsics.checkParameterIsNotNull(fVar, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(C0681a.m318a("byteCount < 0: ", j).toString());
            } else if (!(!mo27803d())) {
                throw new IllegalStateException("closed".toString());
            } else if (this.f2466d) {
                return -1;
            } else {
                long read = super.read(fVar, j);
                if (read != -1) {
                    return read;
                }
                this.f2466d = true;
                mo27804h();
                return -1;
            }
        }
    }

    public C1826b(C1752D d, C1806i iVar, C2072h hVar, C2071g gVar) {
        Intrinsics.checkParameterIsNotNull(iVar, "connection");
        Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
        Intrinsics.checkParameterIsNotNull(gVar, "sink");
        this.f2447d = d;
        this.f2448e = iVar;
        this.f2449f = hVar;
        this.f2450g = gVar;
        this.f2445b = new C1825a(hVar);
    }

    /* renamed from: a */
    private final C1016z m2893a(long j) {
        if (this.f2444a == 4) {
            this.f2444a = 5;
            return new C1830d(j);
        }
        StringBuilder a = C0681a.m330a("state: ");
        a.append(this.f2444a);
        throw new IllegalStateException(a.toString().toString());
    }

    /* renamed from: a */
    public static final /* synthetic */ void m2896a(C1826b bVar, C2076l lVar) {
        if (bVar != null) {
            C2057A g = lVar.mo29224g();
            lVar.mo29223a(C2057A.f2872d);
            g.mo29118a();
            g.mo29121b();
            return;
        }
        throw null;
    }

    /* renamed from: a */
    public void mo27784a() {
        this.f2450g.flush();
    }

    /* renamed from: a */
    public final void mo27800a(C1952y yVar, String str) {
        Intrinsics.checkParameterIsNotNull(yVar, "headers");
        Intrinsics.checkParameterIsNotNull(str, "requestLine");
        if (this.f2444a == 0) {
            this.f2450g.mo29138a(str).mo29138a("\r\n");
            int size = yVar.size();
            for (int i = 0; i < size; i++) {
                this.f2450g.mo29138a(yVar.mo28113a(i)).mo29138a(": ").mo29138a(yVar.mo28115b(i)).mo29138a("\r\n");
            }
            this.f2450g.mo29138a("\r\n");
            this.f2444a = 1;
            return;
        }
        StringBuilder a = C0681a.m330a("state: ");
        a.append(this.f2444a);
        throw new IllegalStateException(a.toString().toString());
    }

    /* renamed from: b */
    public long mo27786b(C1758I i) {
        Intrinsics.checkParameterIsNotNull(i, "response");
        if (!C1819e.m2872a(i)) {
            return 0;
        }
        if (StringsKt__StringsJVMKt.equals("chunked", C1758I.m2561a(i, "Transfer-Encoding", (String) null, 2), true)) {
            return -1;
        }
        return C1764b.m2616a(i);
    }

    /* renamed from: b */
    public C1806i mo27787b() {
        return this.f2448e;
    }

    /* renamed from: c */
    public void mo27788c() {
        this.f2450g.flush();
    }

    /* renamed from: c */
    public final void mo27801c(C1758I i) {
        Intrinsics.checkParameterIsNotNull(i, "response");
        long a = C1764b.m2616a(i);
        if (a != -1) {
            C1016z a2 = m2893a(a);
            C1764b.m2640b(a2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            a2.close();
        }
    }

    public void cancel() {
        this.f2448e.mo27751b();
    }

    /* renamed from: a */
    public C2090x mo27782a(C1755F f, long j) {
        Intrinsics.checkParameterIsNotNull(f, "request");
        if (f.mo27533a() == null || !f.mo27533a().isDuplex()) {
            boolean z = true;
            if (StringsKt__StringsJVMKt.equals("chunked", f.mo27535a("Transfer-Encoding"), true)) {
                if (this.f2444a != 1) {
                    z = false;
                }
                if (z) {
                    this.f2444a = 2;
                    return new C1828b();
                }
                StringBuilder a = C0681a.m330a("state: ");
                a.append(this.f2444a);
                throw new IllegalStateException(a.toString().toString());
            } else if (j != -1) {
                if (this.f2444a != 1) {
                    z = false;
                }
                if (z) {
                    this.f2444a = 2;
                    return new C1831e();
                }
                StringBuilder a2 = C0681a.m330a("state: ");
                a2.append(this.f2444a);
                throw new IllegalStateException(a2.toString().toString());
            } else {
                throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
            }
        } else {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
    }

    /* renamed from: a */
    public C1016z mo27783a(C1758I i) {
        Intrinsics.checkParameterIsNotNull(i, "response");
        if (!C1819e.m2872a(i)) {
            return m2893a(0);
        }
        boolean z = true;
        if (StringsKt__StringsJVMKt.equals("chunked", C1758I.m2561a(i, "Transfer-Encoding", (String) null, 2), true)) {
            C1955z g = i.mo27569y().mo27542g();
            if (this.f2444a != 4) {
                z = false;
            }
            if (z) {
                this.f2444a = 5;
                return new C1829c(this, g);
            }
            StringBuilder a = C0681a.m330a("state: ");
            a.append(this.f2444a);
            throw new IllegalStateException(a.toString().toString());
        }
        long a2 = C1764b.m2616a(i);
        if (a2 != -1) {
            return m2893a(a2);
        }
        if (this.f2444a != 4) {
            z = false;
        }
        if (z) {
            this.f2444a = 5;
            this.f2448e.mo27761k();
            return new C1832f(this);
        }
        StringBuilder a3 = C0681a.m330a("state: ");
        a3.append(this.f2444a);
        throw new IllegalStateException(a3.toString().toString());
    }

    /* renamed from: a */
    public C1758I.C1759a mo27781a(boolean z) {
        int i = this.f2444a;
        boolean z2 = true;
        if (!(i == 1 || i == 3)) {
            z2 = false;
        }
        if (z2) {
            try {
                C1824j a = C1824j.m2889a(this.f2445b.mo27799b());
                C1758I.C1759a aVar = new C1758I.C1759a();
                aVar.mo27573a(a.f2439a);
                aVar.mo27571a(a.f2440b);
                aVar.mo27579a(a.f2441c);
                aVar.mo27578a(this.f2445b.mo27798a());
                if (z && a.f2440b == 100) {
                    return null;
                }
                if (a.f2440b == 100) {
                    this.f2444a = 3;
                    return aVar;
                }
                this.f2444a = 4;
                return aVar;
            } catch (EOFException e) {
                throw new IOException(C0681a.m320a("unexpected end of stream on ", this.f2448e.mo27762l().mo27588a().mo28020k().mo28145l()), e);
            }
        } else {
            StringBuilder a2 = C0681a.m330a("state: ");
            a2.append(this.f2444a);
            throw new IllegalStateException(a2.toString().toString());
        }
    }

    /* renamed from: a */
    public void mo27785a(C1755F f) {
        Intrinsics.checkParameterIsNotNull(f, "request");
        Proxy.Type type = this.f2448e.mo27762l().mo27589b().type();
        Intrinsics.checkExpressionValueIsNotNull(type, "connection.route().proxy.type()");
        Intrinsics.checkParameterIsNotNull(f, "request");
        Intrinsics.checkParameterIsNotNull(type, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(f.mo27541f());
        sb.append(' ');
        boolean z = !f.mo27540e() && type == Proxy.Type.HTTP;
        C1955z g = f.mo27542g();
        if (z) {
            sb.append(g);
        } else {
            Intrinsics.checkParameterIsNotNull(g, ImagesContract.URL);
            String b = g.mo28133b();
            String d = g.mo28135d();
            if (d != null) {
                b = b + '?' + d;
            }
            sb.append(b);
        }
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        mo27800a(f.mo27539d(), sb2);
    }
}
