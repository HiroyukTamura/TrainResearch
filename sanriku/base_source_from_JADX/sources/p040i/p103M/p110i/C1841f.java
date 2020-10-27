package p040i.p103M.p110i;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.p103M.C1764b;
import p040i.p103M.p106e.C1784a;
import p040i.p103M.p106e.C1786c;
import p040i.p103M.p106e.C1787d;
import p040i.p103M.p106e.C1788e;
import p040i.p103M.p110i.C1859h;
import p040i.p103M.p112k.C1890h;
import p042j.C2068f;
import p042j.C2071g;
import p042j.C2072h;
import p042j.C2073i;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u00012\u00020\u0001:\b\u0001\u0001\u0001\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010P\u001a\u00020QJ\b\u0010R\u001a\u00020QH\u0016J'\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\b\u0010V\u001a\u0004\u0018\u00010WH\u0000¢\u0006\u0002\bXJ\u0012\u0010Y\u001a\u00020Q2\b\u0010Z\u001a\u0004\u0018\u00010WH\u0002J\u0006\u0010[\u001a\u00020QJ\u0010\u0010\\\u001a\u0004\u0018\u00010B2\u0006\u0010]\u001a\u00020\u0012J\u000e\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\u0006J&\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tH\u0002J\u001c\u0010`\u001a\u00020B2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tJ\u0006\u0010f\u001a\u00020\u0012J-\u0010g\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u00122\u0006\u0010l\u001a\u00020\tH\u0000¢\u0006\u0002\bmJ+\u0010n\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010l\u001a\u00020\tH\u0000¢\u0006\u0002\boJ#\u0010p\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0cH\u0000¢\u0006\u0002\bqJ\u001d\u0010r\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010s\u001a\u00020TH\u0000¢\u0006\u0002\btJ$\u0010u\u001a\u00020B2\u0006\u0010a\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tJ\u0015\u0010v\u001a\u00020\t2\u0006\u0010h\u001a\u00020\u0012H\u0000¢\u0006\u0002\bwJ\u0017\u0010x\u001a\u0004\u0018\u00010B2\u0006\u0010h\u001a\u00020\u0012H\u0000¢\u0006\u0002\byJ\r\u0010z\u001a\u00020QH\u0000¢\u0006\u0002\b{J\u000e\u0010|\u001a\u00020Q2\u0006\u0010}\u001a\u00020&J\u000e\u0010~\u001a\u00020Q2\u0006\u0010\u001a\u00020TJ\u001e\u0010\u0001\u001a\u00020Q2\t\b\u0002\u0010\u0001\u001a\u00020\t2\b\b\u0002\u0010E\u001a\u00020FH\u0007J\u0018\u0010\u0001\u001a\u00020Q2\u0007\u0010\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0003\b\u0001J,\u0010\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\t2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010k\u001a\u00020\u0006J/\u0010\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\t2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020d0cH\u0000¢\u0006\u0003\b\u0001J\u0007\u0010\u0001\u001a\u00020QJ\"\u0010\u0001\u001a\u00020Q2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012J\u0007\u0010\u0001\u001a\u00020QJ\u001f\u0010\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010\u001a\u00020TH\u0000¢\u0006\u0003\b\u0001J\u001f\u0010\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010s\u001a\u00020TH\u0000¢\u0006\u0003\b\u0001J \u0010\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0003\b\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010(\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001e\u00105\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00104R\u0015\u00107\u001a\u000608R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010;\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020=X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R \u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020B0AX\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020FX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010G\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u00104R\u001e\u0010I\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u00104R\u0011\u0010K\u001a\u00020L¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u000200X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo21739d2 = {"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "builder", "Lokhttp3/internal/http2/Http2Connection$Builder;", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "awaitPingsSent", "", "awaitPongsReceived", "client", "", "getClient$okhttp", "()Z", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "currentPushRequests", "", "", "degradedPingsSent", "degradedPongDeadlineNs", "degradedPongsReceived", "intervalPingsSent", "intervalPongsReceived", "isShutdown", "lastGoodStreamId", "getLastGoodStreamId$okhttp", "()I", "setLastGoodStreamId$okhttp", "(I)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "nextStreamId", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "okHttpSettings", "Lokhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "peerSettings", "getPeerSettings", "setPeerSettings", "(Lokhttp3/internal/http2/Settings;)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "pushQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "<set-?>", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "readBytesTotal", "getReadBytesTotal", "readerRunnable", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "settingsListenerQueue", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "streams", "", "Lokhttp3/internal/http2/Http2Stream;", "getStreams$okhttp", "()Ljava/util/Map;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "writeBytesMaximum", "getWriteBytesMaximum", "writeBytesTotal", "getWriteBytesTotal", "writer", "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "writerQueue", "awaitPong", "", "close", "connectionCode", "Lokhttp3/internal/http2/ErrorCode;", "streamCode", "cause", "Ljava/io/IOException;", "close$okhttp", "failConnection", "e", "flush", "getStream", "id", "isHealthy", "nowNs", "newStream", "associatedStreamId", "requestHeaders", "", "Lokhttp3/internal/http2/Header;", "out", "openStreamCount", "pushDataLater", "streamId", "source", "Lokio/BufferedSource;", "byteCount", "inFinished", "pushDataLater$okhttp", "pushHeadersLater", "pushHeadersLater$okhttp", "pushRequestLater", "pushRequestLater$okhttp", "pushResetLater", "errorCode", "pushResetLater$okhttp", "pushStream", "pushedStream", "pushedStream$okhttp", "removeStream", "removeStream$okhttp", "sendDegradedPingLater", "sendDegradedPingLater$okhttp", "setSettings", "settings", "shutdown", "statusCode", "start", "sendConnectionPreface", "updateConnectionFlowControl", "read", "updateConnectionFlowControl$okhttp", "writeData", "outFinished", "buffer", "Lokio/Buffer;", "writeHeaders", "alternating", "writeHeaders$okhttp", "writePing", "reply", "payload1", "payload2", "writePingAndAwaitPong", "writeSynReset", "writeSynReset$okhttp", "writeSynResetLater", "writeSynResetLater$okhttp", "writeWindowUpdateLater", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "Builder", "Companion", "Listener", "ReaderRunnable", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.i.f */
public final class C1841f implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: E */
    public static final C1871n f2511E;

    /* renamed from: F */
    public static final C1841f f2512F = null;

    /* renamed from: A */
    private final Socket f2513A;

    /* renamed from: B */
    private final C1866j f2514B;

    /* renamed from: C */
    private final C1846d f2515C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public final Set<Integer> f2516D;

    /* renamed from: a */
    private final boolean f2517a;

    /* renamed from: b */
    private final C1844c f2518b;

    /* renamed from: c */
    private final Map<Integer, C1862i> f2519c = new LinkedHashMap();

    /* renamed from: d */
    private final String f2520d;

    /* renamed from: e */
    private int f2521e;

    /* renamed from: f */
    private int f2522f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f2523g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C1788e f2524h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C1787d f2525i;

    /* renamed from: l */
    private final C1787d f2526l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final C1787d f2527m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final C1870m f2528n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public long f2529o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public long f2530p;

    /* renamed from: q */
    private long f2531q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public long f2532r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public long f2533s;

    /* renamed from: t */
    private long f2534t;

    /* renamed from: u */
    private final C1871n f2535u;

    /* renamed from: v */
    private C1871n f2536v;

    /* renamed from: w */
    private long f2537w;

    /* renamed from: x */
    private long f2538x;

    /* renamed from: y */
    private long f2539y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public long f2540z;

    /* renamed from: i.M.i.f$a */
    public static final class C1842a extends C1784a {

        /* renamed from: e */
        final /* synthetic */ C1841f f2541e;

        /* renamed from: f */
        final /* synthetic */ long f2542f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1842a(String str, String str2, C1841f fVar, long j) {
            super(str2, true);
            this.f2541e = fVar;
            this.f2542f = j;
        }

        /* renamed from: e */
        public long mo27646e() {
            boolean z;
            synchronized (this.f2541e) {
                if (this.f2541e.f2530p < this.f2541e.f2529o) {
                    z = true;
                } else {
                    C1841f fVar = this.f2541e;
                    fVar.f2529o = fVar.f2529o + 1;
                    z = false;
                }
            }
            C1841f fVar2 = this.f2541e;
            if (z) {
                C1841f.m2943a(fVar2, (IOException) null);
                return -1;
            }
            fVar2.mo27834a(false, 1, 0);
            return this.f2542f;
        }
    }

    /* renamed from: i.M.i.f$b */
    public static final class C1843b {

        /* renamed from: a */
        public Socket f2543a;

        /* renamed from: b */
        public String f2544b;

        /* renamed from: c */
        public C2072h f2545c;

        /* renamed from: d */
        public C2071g f2546d;

        /* renamed from: e */
        private C1844c f2547e = C1844c.f2552a;

        /* renamed from: f */
        private C1870m f2548f = C1870m.f2646a;

        /* renamed from: g */
        private int f2549g;

        /* renamed from: h */
        private boolean f2550h;

        /* renamed from: i */
        private final C1788e f2551i;

        public C1843b(boolean z, C1788e eVar) {
            Intrinsics.checkParameterIsNotNull(eVar, "taskRunner");
            this.f2550h = z;
            this.f2551i = eVar;
        }

        /* renamed from: a */
        public final C1843b mo27855a(int i) {
            this.f2549g = i;
            return this;
        }

        /* renamed from: a */
        public final C1843b mo27856a(C1844c cVar) {
            Intrinsics.checkParameterIsNotNull(cVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.f2547e = cVar;
            return this;
        }

        @JvmOverloads
        /* renamed from: a */
        public final C1843b mo27857a(Socket socket, String str, C2072h hVar, C2071g gVar) throws IOException {
            StringBuilder sb;
            Intrinsics.checkParameterIsNotNull(socket, "socket");
            Intrinsics.checkParameterIsNotNull(str, "peerName");
            Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
            Intrinsics.checkParameterIsNotNull(gVar, "sink");
            this.f2543a = socket;
            if (this.f2550h) {
                sb = new StringBuilder();
                sb.append(C1764b.f2220h);
                sb.append(' ');
            } else {
                sb = C0681a.m330a("MockWebServer ");
            }
            sb.append(str);
            this.f2544b = sb.toString();
            this.f2545c = hVar;
            this.f2546d = gVar;
            return this;
        }

        /* renamed from: a */
        public final boolean mo27858a() {
            return this.f2550h;
        }

        /* renamed from: b */
        public final C1844c mo27859b() {
            return this.f2547e;
        }

        /* renamed from: c */
        public final int mo27860c() {
            return this.f2549g;
        }

        /* renamed from: d */
        public final C1870m mo27861d() {
            return this.f2548f;
        }

        /* renamed from: e */
        public final C1788e mo27862e() {
            return this.f2551i;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, mo21739d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "()V", "onSettings", "", "connection", "Lokhttp3/internal/http2/Http2Connection;", "settings", "Lokhttp3/internal/http2/Settings;", "onStream", "stream", "Lokhttp3/internal/http2/Http2Stream;", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: i.M.i.f$c */
    public static abstract class C1844c {
        @JvmField

        /* renamed from: a */
        public static final C1844c f2552a = new C1845a();

        /* renamed from: i.M.i.f$c$a */
        public static final class C1845a extends C1844c {
            C1845a() {
            }

            /* renamed from: a */
            public void mo27748a(C1862i iVar) throws IOException {
                Intrinsics.checkParameterIsNotNull(iVar, "stream");
                iVar.mo27886a(C1834b.REFUSED_STREAM, (IOException) null);
            }
        }

        /* renamed from: a */
        public void mo27747a(C1841f fVar, C1871n nVar) {
            Intrinsics.checkParameterIsNotNull(fVar, "connection");
            Intrinsics.checkParameterIsNotNull(nVar, "settings");
        }

        /* renamed from: a */
        public abstract void mo27748a(C1862i iVar) throws IOException;
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0003H\u0016J8\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J(\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0016J \u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010H\u0016J.\u0010$\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\t\u0010)\u001a\u00020\u0003H\u0002J \u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fH\u0016J(\u0010.\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0017H\u0016J&\u00102\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\f\u00104\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0018\u00105\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u00106\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u00068"}, mo21739d2 = {"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "Lkotlin/Function0;", "", "reader", "Lokhttp3/internal/http2/Http2Reader;", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "ackSettings", "alternateService", "streamId", "", "origin", "", "protocol", "Lokio/ByteString;", "host", "port", "maxAge", "", "applyAndAckSettings", "clearPrevious", "", "settings", "Lokhttp3/internal/http2/Settings;", "data", "inFinished", "source", "Lokio/BufferedSource;", "length", "goAway", "lastGoodStreamId", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "debugData", "headers", "associatedStreamId", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "invoke", "ping", "ack", "payload1", "payload2", "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "windowUpdate", "windowSizeIncrement", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: i.M.i.f$d */
    public final class C1846d implements C1859h.C1861b, Function0<Unit> {

        /* renamed from: a */
        private final C1859h f2553a;

        /* renamed from: b */
        final /* synthetic */ C1841f f2554b;

        /* renamed from: i.M.i.f$d$a */
        public static final class C1847a extends C1784a {

            /* renamed from: e */
            final /* synthetic */ C1846d f2555e;

            /* renamed from: f */
            final /* synthetic */ Ref.ObjectRef f2556f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1847a(String str, boolean z, String str2, boolean z2, C1846d dVar, boolean z3, Ref.ObjectRef objectRef, C1871n nVar, Ref.LongRef longRef, Ref.ObjectRef objectRef2) {
                super(str2, z2);
                this.f2555e = dVar;
                this.f2556f = objectRef;
            }

            /* renamed from: e */
            public long mo27646e() {
                this.f2555e.f2554b.mo27847l().mo27747a(this.f2555e.f2554b, (C1871n) this.f2556f.element);
                return -1;
            }
        }

        /* renamed from: i.M.i.f$d$b */
        public static final class C1848b extends C1784a {

            /* renamed from: e */
            final /* synthetic */ C1862i f2557e;

            /* renamed from: f */
            final /* synthetic */ C1846d f2558f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1848b(String str, boolean z, String str2, boolean z2, C1862i iVar, C1846d dVar, C1862i iVar2, int i, List list, boolean z3) {
                super(str2, z2);
                this.f2557e = iVar;
                this.f2558f = dVar;
            }

            /* renamed from: e */
            public long mo27646e() {
                try {
                    this.f2558f.f2554b.mo27847l().mo27748a(this.f2557e);
                    return -1;
                } catch (IOException e) {
                    C1890h.C1891a aVar = C1890h.f2683c;
                    C1890h c = C1890h.f2681a;
                    StringBuilder a = C0681a.m330a("Http2Connection.Listener failure for ");
                    a.append(this.f2558f.f2554b.mo27843h());
                    c.mo27964a(a.toString(), 4, (Throwable) e);
                    try {
                        this.f2557e.mo27886a(C1834b.PROTOCOL_ERROR, e);
                        return -1;
                    } catch (IOException unused) {
                        return -1;
                    }
                }
            }
        }

        /* renamed from: i.M.i.f$d$c */
        public static final class C1849c extends C1784a {

            /* renamed from: e */
            final /* synthetic */ C1846d f2559e;

            /* renamed from: f */
            final /* synthetic */ int f2560f;

            /* renamed from: g */
            final /* synthetic */ int f2561g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1849c(String str, boolean z, String str2, boolean z2, C1846d dVar, int i, int i2) {
                super(str2, z2);
                this.f2559e = dVar;
                this.f2560f = i;
                this.f2561g = i2;
            }

            /* renamed from: e */
            public long mo27646e() {
                this.f2559e.f2554b.mo27834a(true, this.f2560f, this.f2561g);
                return -1;
            }
        }

        /* renamed from: i.M.i.f$d$d */
        public static final class C1850d extends C1784a {

            /* renamed from: e */
            final /* synthetic */ C1846d f2562e;

            /* renamed from: f */
            final /* synthetic */ boolean f2563f;

            /* renamed from: g */
            final /* synthetic */ C1871n f2564g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1850d(String str, boolean z, String str2, boolean z2, C1846d dVar, boolean z3, C1871n nVar) {
                super(str2, z2);
                this.f2562e = dVar;
                this.f2563f = z3;
                this.f2564g = nVar;
            }

            /* renamed from: e */
            public long mo27646e() {
                this.f2562e.mo27873b(this.f2563f, this.f2564g);
                return -1;
            }
        }

        public C1846d(C1841f fVar, C1859h hVar) {
            Intrinsics.checkParameterIsNotNull(hVar, "reader");
            this.f2554b = fVar;
            this.f2553a = hVar;
        }

        /* renamed from: a */
        public void mo27863a() {
        }

        /* renamed from: a */
        public void mo27864a(int i, int i2, int i3, boolean z) {
        }

        /* renamed from: a */
        public void mo27865a(int i, int i2, List<C1836c> list) {
            Intrinsics.checkParameterIsNotNull(list, "requestHeaders");
            this.f2554b.mo27828a(i2, list);
        }

        /* renamed from: a */
        public void mo27866a(int i, long j) {
            Object obj;
            if (i == 0) {
                Object obj2 = this.f2554b;
                synchronized (obj2) {
                    C1841f fVar = this.f2554b;
                    fVar.f2540z = fVar.mo27852s() + j;
                    C1841f fVar2 = this.f2554b;
                    if (fVar2 != null) {
                        fVar2.notifyAll();
                        Unit unit = Unit.INSTANCE;
                        obj = obj2;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                    }
                }
            } else {
                C1862i a = this.f2554b.mo27823a(i);
                if (a != null) {
                    synchronized (a) {
                        a.mo27884a(j);
                        Unit unit2 = Unit.INSTANCE;
                        obj = a;
                    }
                } else {
                    return;
                }
            }
        }

        /* renamed from: a */
        public void mo27867a(int i, C1834b bVar) {
            Intrinsics.checkParameterIsNotNull(bVar, "errorCode");
            if (this.f2554b.mo27836b(i)) {
                this.f2554b.mo27826a(i, bVar);
                return;
            }
            C1862i c = this.f2554b.mo27837c(i);
            if (c != null) {
                c.mo27891b(bVar);
            }
        }

        /* renamed from: a */
        public void mo27868a(int i, C1834b bVar, C2073i iVar) {
            int i2;
            C1862i[] iVarArr;
            Intrinsics.checkParameterIsNotNull(bVar, "errorCode");
            Intrinsics.checkParameterIsNotNull(iVar, "debugData");
            iVar.mo29212d();
            synchronized (this.f2554b) {
                Object[] array = this.f2554b.mo27851r().values().toArray(new C1862i[0]);
                if (array != null) {
                    iVarArr = (C1862i[]) array;
                    this.f2554b.f2523g = true;
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            for (C1862i iVar2 : iVarArr) {
                if (iVar2.mo27897f() > i && iVar2.mo27907p()) {
                    iVar2.mo27891b(C1834b.REFUSED_STREAM);
                    this.f2554b.mo27837c(iVar2.mo27897f());
                }
            }
        }

        /* renamed from: a */
        public void mo27869a(boolean z, int i, int i2) {
            if (z) {
                synchronized (this.f2554b) {
                    if (i == 1) {
                        C1841f fVar = this.f2554b;
                        fVar.f2530p = fVar.f2530p + 1;
                    } else if (i != 2) {
                        if (i == 3) {
                            C1841f fVar2 = this.f2554b;
                            fVar2.f2533s = fVar2.f2533s + 1;
                            C1841f fVar3 = this.f2554b;
                            if (fVar3 != null) {
                                fVar3.notifyAll();
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    } else {
                        C1841f fVar4 = this.f2554b;
                        fVar4.f2532r = fVar4.f2532r + 1;
                    }
                }
                return;
            }
            String str = this.f2554b.mo27843h() + " ping";
            this.f2554b.f2525i.mo27659a(new C1849c(str, true, str, true, this, i, i2), 0);
        }

        /* renamed from: a */
        public void mo27870a(boolean z, int i, int i2, List<C1836c> list) {
            boolean z2 = z;
            int i3 = i;
            List<C1836c> list2 = list;
            Intrinsics.checkParameterIsNotNull(list2, "headerBlock");
            if (this.f2554b.mo27836b(i3)) {
                this.f2554b.mo27829a(i3, list2, z2);
                return;
            }
            synchronized (this.f2554b) {
                C1862i a = this.f2554b.mo27823a(i3);
                if (a != null) {
                    Unit unit = Unit.INSTANCE;
                    a.mo27887a(C1764b.m2619a(list), z2);
                } else if (!this.f2554b.f2523g) {
                    if (i3 > this.f2554b.mo27845i()) {
                        if (i3 % 2 != this.f2554b.mo27848o() % 2) {
                            C1862i iVar = new C1862i(i, this.f2554b, false, z, C1764b.m2619a(list));
                            this.f2554b.mo27840d(i3);
                            this.f2554b.mo27851r().put(Integer.valueOf(i), iVar);
                            String str = this.f2554b.mo27843h() + '[' + i3 + "] onStream";
                            this.f2554b.f2524h.mo27675d().mo27659a(new C1848b(str, true, str, true, iVar, this, a, i, list, z), 0);
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo27871a(boolean z, int i, C2072h hVar, int i2) throws IOException {
            Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
            if (this.f2554b.mo27836b(i)) {
                this.f2554b.mo27827a(i, hVar, i2, z);
                return;
            }
            C1862i a = this.f2554b.mo27823a(i);
            if (a == null) {
                this.f2554b.mo27838c(i, C1834b.PROTOCOL_ERROR);
                long j = (long) i2;
                this.f2554b.mo27846i(j);
                hVar.skip(j);
                return;
            }
            a.mo27888a(hVar, i2);
            if (z) {
                a.mo27887a(C1764b.f2214b, true);
            }
        }

        /* renamed from: a */
        public void mo27872a(boolean z, C1871n nVar) {
            Intrinsics.checkParameterIsNotNull(nVar, "settings");
            String str = this.f2554b.mo27843h() + " applyAndAckSettings";
            this.f2554b.f2525i.mo27659a(new C1850d(str, true, str, true, this, z, nVar), 0);
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
            	at java.base/java.util.Objects.checkIndex(Objects.java:372)
            	at java.base/java.util.ArrayList.get(ArrayList.java:458)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        /* renamed from: b */
        public final void mo27873b(boolean r22, p040i.p103M.p110i.C1871n r23) {
            /*
                r21 = this;
                r12 = r21
                r0 = r23
                java.lang.String r1 = "settings"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r1)
                kotlin.jvm.internal.Ref$LongRef r13 = new kotlin.jvm.internal.Ref$LongRef
                r13.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
                r14.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
                r15.<init>()
                i.M.i.f r1 = r12.f2554b
                i.M.i.j r16 = r1.mo27853t()
                monitor-enter(r16)
                i.M.i.f r11 = r12.f2554b     // Catch:{ all -> 0x010d }
                monitor-enter(r11)     // Catch:{ all -> 0x010d }
                i.M.i.f r1 = r12.f2554b     // Catch:{ all -> 0x0108 }
                i.M.i.n r1 = r1.mo27850q()     // Catch:{ all -> 0x0108 }
                if (r22 == 0) goto L_0x002d
                r15.element = r0     // Catch:{ all -> 0x0108 }
                goto L_0x003a
            L_0x002d:
                i.M.i.n r2 = new i.M.i.n     // Catch:{ all -> 0x0108 }
                r2.<init>()     // Catch:{ all -> 0x0108 }
                r2.mo27948a((p040i.p103M.p110i.C1871n) r1)     // Catch:{ all -> 0x0108 }
                r2.mo27948a((p040i.p103M.p110i.C1871n) r0)     // Catch:{ all -> 0x0108 }
                r15.element = r2     // Catch:{ all -> 0x0108 }
            L_0x003a:
                T r2 = r15.element     // Catch:{ all -> 0x0108 }
                i.M.i.n r2 = (p040i.p103M.p110i.C1871n) r2     // Catch:{ all -> 0x0108 }
                int r2 = r2.mo27949b()     // Catch:{ all -> 0x0108 }
                long r2 = (long) r2     // Catch:{ all -> 0x0108 }
                int r1 = r1.mo27949b()     // Catch:{ all -> 0x0108 }
                long r4 = (long) r1     // Catch:{ all -> 0x0108 }
                long r2 = r2 - r4
                r13.element = r2     // Catch:{ all -> 0x0108 }
                r10 = 0
                r8 = 0
                int r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r1 == 0) goto L_0x007c
                i.M.i.f r1 = r12.f2554b     // Catch:{ all -> 0x0108 }
                java.util.Map r1 = r1.mo27851r()     // Catch:{ all -> 0x0108 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0108 }
                if (r1 == 0) goto L_0x005f
                goto L_0x007c
            L_0x005f:
                i.M.i.f r1 = r12.f2554b     // Catch:{ all -> 0x0108 }
                java.util.Map r1 = r1.mo27851r()     // Catch:{ all -> 0x0108 }
                java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x0108 }
                i.M.i.i[] r2 = new p040i.p103M.p110i.C1862i[r10]     // Catch:{ all -> 0x0108 }
                java.lang.Object[] r1 = r1.toArray(r2)     // Catch:{ all -> 0x0108 }
                if (r1 == 0) goto L_0x0074
                i.M.i.i[] r1 = (p040i.p103M.p110i.C1862i[]) r1     // Catch:{ all -> 0x0108 }
                goto L_0x007d
            L_0x0074:
                kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ all -> 0x0108 }
                java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
                r0.<init>(r1)     // Catch:{ all -> 0x0108 }
                throw r0     // Catch:{ all -> 0x0108 }
            L_0x007c:
                r1 = 0
            L_0x007d:
                r14.element = r1     // Catch:{ all -> 0x0108 }
                i.M.i.f r1 = r12.f2554b     // Catch:{ all -> 0x0108 }
                T r2 = r15.element     // Catch:{ all -> 0x0108 }
                i.M.i.n r2 = (p040i.p103M.p110i.C1871n) r2     // Catch:{ all -> 0x0108 }
                r1.mo27833a((p040i.p103M.p110i.C1871n) r2)     // Catch:{ all -> 0x0108 }
                i.M.i.f r1 = r12.f2554b     // Catch:{ all -> 0x0108 }
                i.M.e.d r7 = r1.f2527m     // Catch:{ all -> 0x0108 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0108 }
                r1.<init>()     // Catch:{ all -> 0x0108 }
                i.M.i.f r2 = r12.f2554b     // Catch:{ all -> 0x0108 }
                java.lang.String r2 = r2.mo27843h()     // Catch:{ all -> 0x0108 }
                r1.append(r2)     // Catch:{ all -> 0x0108 }
                java.lang.String r2 = " onSettings"
                r1.append(r2)     // Catch:{ all -> 0x0108 }
                java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0108 }
                r5 = 1
                i.M.i.f$d$a r6 = new i.M.i.f$d$a     // Catch:{ all -> 0x0108 }
                r1 = r6
                r2 = r4
                r3 = r5
                r17 = r6
                r6 = r21
                r18 = r7
                r7 = r22
                r8 = r15
                r9 = r23
                r19 = 0
                r10 = r13
                r20 = r11
                r11 = r14
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0106 }
                r1 = r17
                r0 = r18
                r2 = 0
                r0.mo27659a(r1, r2)     // Catch:{ all -> 0x0106 }
                kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0106 }
                monitor-exit(r20)     // Catch:{ all -> 0x010d }
                i.M.i.f r0 = r12.f2554b     // Catch:{ IOException -> 0x00d9 }
                i.M.i.j r0 = r0.mo27853t()     // Catch:{ IOException -> 0x00d9 }
                T r1 = r15.element     // Catch:{ IOException -> 0x00d9 }
                i.M.i.n r1 = (p040i.p103M.p110i.C1871n) r1     // Catch:{ IOException -> 0x00d9 }
                r0.mo27926a(r1)     // Catch:{ IOException -> 0x00d9 }
                goto L_0x00df
            L_0x00d9:
                r0 = move-exception
                i.M.i.f r1 = r12.f2554b     // Catch:{ all -> 0x010d }
                p040i.p103M.p110i.C1841f.m2943a((p040i.p103M.p110i.C1841f) r1, (java.io.IOException) r0)     // Catch:{ all -> 0x010d }
            L_0x00df:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x010d }
                monitor-exit(r16)
                T r0 = r14.element
                r1 = r0
                i.M.i.i[] r1 = (p040i.p103M.p110i.C1862i[]) r1
                if (r1 == 0) goto L_0x0105
                i.M.i.i[] r0 = (p040i.p103M.p110i.C1862i[]) r0
                if (r0 != 0) goto L_0x00f0
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x00f0:
                int r1 = r0.length
                r10 = 0
            L_0x00f2:
                if (r10 >= r1) goto L_0x0105
                r2 = r0[r10]
                monitor-enter(r2)
                long r3 = r13.element     // Catch:{ all -> 0x0102 }
                r2.mo27884a((long) r3)     // Catch:{ all -> 0x0102 }
                kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0102 }
                monitor-exit(r2)
                int r10 = r10 + 1
                goto L_0x00f2
            L_0x0102:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x0105:
                return
            L_0x0106:
                r0 = move-exception
                goto L_0x010b
            L_0x0108:
                r0 = move-exception
                r20 = r11
            L_0x010b:
                monitor-exit(r20)     // Catch:{ all -> 0x010d }
                throw r0     // Catch:{ all -> 0x010d }
            L_0x010d:
                r0 = move-exception
                monitor-exit(r16)
                goto L_0x0111
            L_0x0110:
                throw r0
            L_0x0111:
                goto L_0x0110
            */
            throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p110i.C1841f.C1846d.mo27873b(boolean, i.M.i.n):void");
        }

        public Object invoke() {
            C1834b bVar;
            C1834b bVar2;
            C1834b bVar3 = C1834b.INTERNAL_ERROR;
            e = null;
            try {
                this.f2553a.mo27874a(this);
                while (this.f2553a.mo27875a(false, (C1859h.C1861b) this)) {
                }
                bVar = C1834b.NO_ERROR;
                try {
                    bVar2 = C1834b.CANCEL;
                } catch (IOException e) {
                    e = e;
                }
            } catch (IOException e2) {
                e = e2;
                bVar = bVar3;
                try {
                    bVar = C1834b.PROTOCOL_ERROR;
                    bVar2 = C1834b.PROTOCOL_ERROR;
                    this.f2554b.mo27832a(bVar, bVar2, e);
                    C1764b.m2629a((Closeable) this.f2553a);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    this.f2554b.mo27832a(bVar, bVar3, e);
                    C1764b.m2629a((Closeable) this.f2553a);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar3;
                this.f2554b.mo27832a(bVar, bVar3, e);
                C1764b.m2629a((Closeable) this.f2553a);
                throw th;
            }
            this.f2554b.mo27832a(bVar, bVar2, e);
            C1764b.m2629a((Closeable) this.f2553a);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: i.M.i.f$e */
    public static final class C1851e extends C1784a {

        /* renamed from: e */
        final /* synthetic */ C1841f f2565e;

        /* renamed from: f */
        final /* synthetic */ int f2566f;

        /* renamed from: g */
        final /* synthetic */ C2068f f2567g;

        /* renamed from: h */
        final /* synthetic */ int f2568h;

        /* renamed from: i */
        final /* synthetic */ boolean f2569i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1851e(String str, boolean z, String str2, boolean z2, C1841f fVar, int i, C2068f fVar2, int i2, boolean z3) {
            super(str2, z2);
            this.f2565e = fVar;
            this.f2566f = i;
            this.f2567g = fVar2;
            this.f2568h = i2;
            this.f2569i = z3;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return -1;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* renamed from: e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long mo27646e() {
            /*
                r5 = this;
                i.M.i.f r0 = r5.f2565e     // Catch:{ IOException -> 0x003e }
                i.M.i.m r0 = r0.f2528n     // Catch:{ IOException -> 0x003e }
                int r1 = r5.f2566f     // Catch:{ IOException -> 0x003e }
                j.f r2 = r5.f2567g     // Catch:{ IOException -> 0x003e }
                int r3 = r5.f2568h     // Catch:{ IOException -> 0x003e }
                boolean r4 = r5.f2569i     // Catch:{ IOException -> 0x003e }
                boolean r0 = r0.mo27942a(r1, r2, r3, r4)     // Catch:{ IOException -> 0x003e }
                if (r0 == 0) goto L_0x0021
                i.M.i.f r1 = r5.f2565e     // Catch:{ IOException -> 0x003e }
                i.M.i.j r1 = r1.mo27853t()     // Catch:{ IOException -> 0x003e }
                int r2 = r5.f2566f     // Catch:{ IOException -> 0x003e }
                i.M.i.b r3 = p040i.p103M.p110i.C1834b.CANCEL     // Catch:{ IOException -> 0x003e }
                r1.mo27924a((int) r2, (p040i.p103M.p110i.C1834b) r3)     // Catch:{ IOException -> 0x003e }
            L_0x0021:
                if (r0 != 0) goto L_0x0027
                boolean r0 = r5.f2569i     // Catch:{ IOException -> 0x003e }
                if (r0 == 0) goto L_0x003e
            L_0x0027:
                i.M.i.f r0 = r5.f2565e     // Catch:{ IOException -> 0x003e }
                monitor-enter(r0)     // Catch:{ IOException -> 0x003e }
                i.M.i.f r1 = r5.f2565e     // Catch:{ all -> 0x003b }
                java.util.Set r1 = r1.f2516D     // Catch:{ all -> 0x003b }
                int r2 = r5.f2566f     // Catch:{ all -> 0x003b }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x003b }
                r1.remove(r2)     // Catch:{ all -> 0x003b }
                monitor-exit(r0)     // Catch:{ IOException -> 0x003e }
                goto L_0x003e
            L_0x003b:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ IOException -> 0x003e }
                throw r1     // Catch:{ IOException -> 0x003e }
            L_0x003e:
                r0 = -1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p110i.C1841f.C1851e.mo27646e():long");
        }
    }

    /* renamed from: i.M.i.f$f */
    public static final class C1852f extends C1784a {

        /* renamed from: e */
        final /* synthetic */ C1841f f2570e;

        /* renamed from: f */
        final /* synthetic */ int f2571f;

        /* renamed from: g */
        final /* synthetic */ List f2572g;

        /* renamed from: h */
        final /* synthetic */ boolean f2573h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1852f(String str, boolean z, String str2, boolean z2, C1841f fVar, int i, List list, boolean z3) {
            super(str2, z2);
            this.f2570e = fVar;
            this.f2571f = i;
            this.f2572g = list;
            this.f2573h = z3;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return -1;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* renamed from: e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long mo27646e() {
            /*
                r4 = this;
                i.M.i.f r0 = r4.f2570e
                i.M.i.m r0 = r0.f2528n
                int r1 = r4.f2571f
                java.util.List r2 = r4.f2572g
                boolean r3 = r4.f2573h
                boolean r0 = r0.mo27944a(r1, r2, r3)
                if (r0 == 0) goto L_0x001f
                i.M.i.f r1 = r4.f2570e     // Catch:{ IOException -> 0x003c }
                i.M.i.j r1 = r1.mo27853t()     // Catch:{ IOException -> 0x003c }
                int r2 = r4.f2571f     // Catch:{ IOException -> 0x003c }
                i.M.i.b r3 = p040i.p103M.p110i.C1834b.CANCEL     // Catch:{ IOException -> 0x003c }
                r1.mo27924a((int) r2, (p040i.p103M.p110i.C1834b) r3)     // Catch:{ IOException -> 0x003c }
            L_0x001f:
                if (r0 != 0) goto L_0x0025
                boolean r0 = r4.f2573h     // Catch:{ IOException -> 0x003c }
                if (r0 == 0) goto L_0x003c
            L_0x0025:
                i.M.i.f r0 = r4.f2570e     // Catch:{ IOException -> 0x003c }
                monitor-enter(r0)     // Catch:{ IOException -> 0x003c }
                i.M.i.f r1 = r4.f2570e     // Catch:{ all -> 0x0039 }
                java.util.Set r1 = r1.f2516D     // Catch:{ all -> 0x0039 }
                int r2 = r4.f2571f     // Catch:{ all -> 0x0039 }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0039 }
                r1.remove(r2)     // Catch:{ all -> 0x0039 }
                monitor-exit(r0)     // Catch:{ IOException -> 0x003c }
                goto L_0x003c
            L_0x0039:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ IOException -> 0x003c }
                throw r1     // Catch:{ IOException -> 0x003c }
            L_0x003c:
                r0 = -1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p110i.C1841f.C1852f.mo27646e():long");
        }
    }

    /* renamed from: i.M.i.f$g */
    public static final class C1853g extends C1784a {

        /* renamed from: e */
        final /* synthetic */ C1841f f2574e;

        /* renamed from: f */
        final /* synthetic */ int f2575f;

        /* renamed from: g */
        final /* synthetic */ List f2576g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1853g(String str, boolean z, String str2, boolean z2, C1841f fVar, int i, List list) {
            super(str2, z2);
            this.f2574e = fVar;
            this.f2575f = i;
            this.f2576g = list;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            return -1;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* renamed from: e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long mo27646e() {
            /*
                r3 = this;
                i.M.i.f r0 = r3.f2574e
                i.M.i.m r0 = r0.f2528n
                int r1 = r3.f2575f
                java.util.List r2 = r3.f2576g
                boolean r0 = r0.mo27943a((int) r1, (java.util.List<p040i.p103M.p110i.C1836c>) r2)
                if (r0 == 0) goto L_0x0034
                i.M.i.f r0 = r3.f2574e     // Catch:{ IOException -> 0x0034 }
                i.M.i.j r0 = r0.mo27853t()     // Catch:{ IOException -> 0x0034 }
                int r1 = r3.f2575f     // Catch:{ IOException -> 0x0034 }
                i.M.i.b r2 = p040i.p103M.p110i.C1834b.CANCEL     // Catch:{ IOException -> 0x0034 }
                r0.mo27924a((int) r1, (p040i.p103M.p110i.C1834b) r2)     // Catch:{ IOException -> 0x0034 }
                i.M.i.f r0 = r3.f2574e     // Catch:{ IOException -> 0x0034 }
                monitor-enter(r0)     // Catch:{ IOException -> 0x0034 }
                i.M.i.f r1 = r3.f2574e     // Catch:{ all -> 0x0031 }
                java.util.Set r1 = r1.f2516D     // Catch:{ all -> 0x0031 }
                int r2 = r3.f2575f     // Catch:{ all -> 0x0031 }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0031 }
                r1.remove(r2)     // Catch:{ all -> 0x0031 }
                monitor-exit(r0)     // Catch:{ IOException -> 0x0034 }
                goto L_0x0034
            L_0x0031:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ IOException -> 0x0034 }
                throw r1     // Catch:{ IOException -> 0x0034 }
            L_0x0034:
                r0 = -1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p110i.C1841f.C1853g.mo27646e():long");
        }
    }

    /* renamed from: i.M.i.f$h */
    public static final class C1854h extends C1784a {

        /* renamed from: e */
        final /* synthetic */ C1841f f2577e;

        /* renamed from: f */
        final /* synthetic */ int f2578f;

        /* renamed from: g */
        final /* synthetic */ C1834b f2579g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1854h(String str, boolean z, String str2, boolean z2, C1841f fVar, int i, C1834b bVar) {
            super(str2, z2);
            this.f2577e = fVar;
            this.f2578f = i;
            this.f2579g = bVar;
        }

        /* renamed from: e */
        public long mo27646e() {
            this.f2577e.f2528n.mo27941a(this.f2578f, this.f2579g);
            synchronized (this.f2577e) {
                this.f2577e.f2516D.remove(Integer.valueOf(this.f2578f));
            }
            return -1;
        }
    }

    /* renamed from: i.M.i.f$i */
    public static final class C1855i extends C1784a {

        /* renamed from: e */
        final /* synthetic */ C1841f f2580e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1855i(String str, boolean z, String str2, boolean z2, C1841f fVar) {
            super(str2, z2);
            this.f2580e = fVar;
        }

        /* renamed from: e */
        public long mo27646e() {
            this.f2580e.mo27834a(false, 2, 0);
            return -1;
        }
    }

    /* renamed from: i.M.i.f$j */
    public static final class C1856j extends C1784a {

        /* renamed from: e */
        final /* synthetic */ C1841f f2581e;

        /* renamed from: f */
        final /* synthetic */ int f2582f;

        /* renamed from: g */
        final /* synthetic */ C1834b f2583g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1856j(String str, boolean z, String str2, boolean z2, C1841f fVar, int i, C1834b bVar) {
            super(str2, z2);
            this.f2581e = fVar;
            this.f2582f = i;
            this.f2583g = bVar;
        }

        /* renamed from: e */
        public long mo27646e() {
            try {
                this.f2581e.mo27835b(this.f2582f, this.f2583g);
                return -1;
            } catch (IOException e) {
                C1841f.m2943a(this.f2581e, e);
                return -1;
            }
        }
    }

    /* renamed from: i.M.i.f$k */
    public static final class C1857k extends C1784a {

        /* renamed from: e */
        final /* synthetic */ C1841f f2584e;

        /* renamed from: f */
        final /* synthetic */ int f2585f;

        /* renamed from: g */
        final /* synthetic */ long f2586g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1857k(String str, boolean z, String str2, boolean z2, C1841f fVar, int i, long j) {
            super(str2, z2);
            this.f2584e = fVar;
            this.f2585f = i;
            this.f2586g = j;
        }

        /* renamed from: e */
        public long mo27646e() {
            try {
                this.f2584e.mo27853t().mo27923a(this.f2585f, this.f2586g);
                return -1;
            } catch (IOException e) {
                C1841f.m2943a(this.f2584e, e);
                return -1;
            }
        }
    }

    static {
        C1871n nVar = new C1871n();
        nVar.mo27947a(7, 65535);
        nVar.mo27947a(5, 16384);
        f2511E = nVar;
    }

    public C1841f(C1843b bVar) {
        Intrinsics.checkParameterIsNotNull(bVar, "builder");
        this.f2517a = bVar.mo27858a();
        this.f2518b = bVar.mo27859b();
        String str = bVar.f2544b;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
        }
        this.f2520d = str;
        this.f2522f = bVar.mo27858a() ? 3 : 2;
        C1788e e = bVar.mo27862e();
        this.f2524h = e;
        this.f2525i = e.mo27675d();
        this.f2526l = this.f2524h.mo27675d();
        this.f2527m = this.f2524h.mo27675d();
        this.f2528n = bVar.mo27861d();
        C1871n nVar = new C1871n();
        if (bVar.mo27858a()) {
            nVar.mo27947a(7, 16777216);
        }
        this.f2535u = nVar;
        C1871n nVar2 = f2511E;
        this.f2536v = nVar2;
        this.f2540z = (long) nVar2.mo27949b();
        Socket socket = bVar.f2543a;
        if (socket == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socket");
        }
        this.f2513A = socket;
        C2071g gVar = bVar.f2546d;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sink");
        }
        this.f2514B = new C1866j(gVar, this.f2517a);
        C2072h hVar = bVar.f2545c;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(FirebaseAnalytics.Param.SOURCE);
        }
        this.f2515C = new C1846d(this, new C1859h(hVar, this.f2517a));
        this.f2516D = new LinkedHashSet();
        if (bVar.mo27860c() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos((long) bVar.mo27860c());
            C1787d dVar = this.f2525i;
            String a = C0681a.m324a(new StringBuilder(), this.f2520d, " ping");
            dVar.mo27659a(new C1842a(a, a, this, nanos), nanos);
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m2943a(C1841f fVar, IOException iOException) {
        if (fVar != null) {
            C1834b bVar = C1834b.PROTOCOL_ERROR;
            fVar.mo27832a(bVar, bVar, iOException);
            return;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final p040i.p103M.p110i.C1862i m2946b(int r11, java.util.List<p040i.p103M.p110i.C1836c> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            i.M.i.j r7 = r10.f2514B
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0088 }
            int r0 = r10.f2522f     // Catch:{ all -> 0x0085 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0013
            i.M.i.b r0 = p040i.p103M.p110i.C1834b.REFUSED_STREAM     // Catch:{ all -> 0x0085 }
            r10.mo27831a((p040i.p103M.p110i.C1834b) r0)     // Catch:{ all -> 0x0085 }
        L_0x0013:
            boolean r0 = r10.f2523g     // Catch:{ all -> 0x0085 }
            if (r0 != 0) goto L_0x007f
            int r8 = r10.f2522f     // Catch:{ all -> 0x0085 }
            int r0 = r10.f2522f     // Catch:{ all -> 0x0085 }
            int r0 = r0 + 2
            r10.f2522f = r0     // Catch:{ all -> 0x0085 }
            i.M.i.i r9 = new i.M.i.i     // Catch:{ all -> 0x0085 }
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0085 }
            r0 = 1
            if (r13 == 0) goto L_0x0043
            long r1 = r10.f2539y     // Catch:{ all -> 0x0085 }
            long r3 = r10.f2540z     // Catch:{ all -> 0x0085 }
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x0043
            long r1 = r9.mo27905n()     // Catch:{ all -> 0x0085 }
            long r3 = r9.mo27904m()     // Catch:{ all -> 0x0085 }
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 < 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r13 = 0
            goto L_0x0044
        L_0x0043:
            r13 = 1
        L_0x0044:
            boolean r1 = r9.mo27908q()     // Catch:{ all -> 0x0085 }
            if (r1 == 0) goto L_0x0053
            java.util.Map<java.lang.Integer, i.M.i.i> r1 = r10.f2519c     // Catch:{ all -> 0x0085 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0085 }
            r1.put(r2, r9)     // Catch:{ all -> 0x0085 }
        L_0x0053:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0085 }
            monitor-exit(r10)     // Catch:{ all -> 0x0088 }
            if (r11 != 0) goto L_0x005e
            i.M.i.j r11 = r10.f2514B     // Catch:{ all -> 0x0088 }
            r11.mo27929a((boolean) r6, (int) r8, (java.util.List<p040i.p103M.p110i.C1836c>) r12)     // Catch:{ all -> 0x0088 }
            goto L_0x0068
        L_0x005e:
            boolean r1 = r10.f2517a     // Catch:{ all -> 0x0088 }
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0073
            i.M.i.j r0 = r10.f2514B     // Catch:{ all -> 0x0088 }
            r0.mo27922a((int) r11, (int) r8, (java.util.List<p040i.p103M.p110i.C1836c>) r12)     // Catch:{ all -> 0x0088 }
        L_0x0068:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0088 }
            monitor-exit(r7)
            if (r13 == 0) goto L_0x0072
            i.M.i.j r11 = r10.f2514B
            r11.flush()
        L_0x0072:
            return r9
        L_0x0073:
            java.lang.String r11 = "client streams shouldn't have associated stream IDs"
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0088 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0088 }
            r12.<init>(r11)     // Catch:{ all -> 0x0088 }
            throw r12     // Catch:{ all -> 0x0088 }
        L_0x007f:
            i.M.i.a r11 = new i.M.i.a     // Catch:{ all -> 0x0085 }
            r11.<init>()     // Catch:{ all -> 0x0085 }
            throw r11     // Catch:{ all -> 0x0085 }
        L_0x0085:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0088 }
            throw r11     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r11 = move-exception
            monitor-exit(r7)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p110i.C1841f.m2946b(int, java.util.List, boolean):i.M.i.i");
    }

    /* renamed from: a */
    public final synchronized C1862i mo27823a(int i) {
        return this.f2519c.get(Integer.valueOf(i));
    }

    /* renamed from: a */
    public final C1862i mo27824a(List<C1836c> list, boolean z) throws IOException {
        Intrinsics.checkParameterIsNotNull(list, "requestHeaders");
        return m2946b(0, list, z);
    }

    /* renamed from: a */
    public final void mo27825a(int i, long j) {
        String str = this.f2520d + '[' + i + "] windowUpdate";
        this.f2525i.mo27659a(new C1857k(str, true, str, true, this, i, j), 0);
    }

    /* renamed from: a */
    public final void mo27826a(int i, C1834b bVar) {
        Intrinsics.checkParameterIsNotNull(bVar, "errorCode");
        String str = this.f2520d + '[' + i + "] onReset";
        this.f2526l.mo27659a(new C1854h(str, true, str, true, this, i, bVar), 0);
    }

    /* renamed from: a */
    public final void mo27827a(int i, C2072h hVar, int i2, boolean z) throws IOException {
        Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
        C2068f fVar = new C2068f();
        long j = (long) i2;
        hVar.mo29159f(j);
        hVar.read(fVar, j);
        String str = this.f2520d + '[' + i + "] onData";
        this.f2526l.mo27659a(new C1851e(str, true, str, true, this, i, fVar, i2, z), 0);
    }

    /* renamed from: a */
    public final void mo27828a(int i, List<C1836c> list) {
        Intrinsics.checkParameterIsNotNull(list, "requestHeaders");
        synchronized (this) {
            if (this.f2516D.contains(Integer.valueOf(i))) {
                mo27838c(i, C1834b.PROTOCOL_ERROR);
                return;
            }
            this.f2516D.add(Integer.valueOf(i));
            String str = this.f2520d + '[' + i + "] onRequest";
            this.f2526l.mo27659a(new C1853g(str, true, str, true, this, i, list), 0);
        }
    }

    /* renamed from: a */
    public final void mo27829a(int i, List<C1836c> list, boolean z) {
        Intrinsics.checkParameterIsNotNull(list, "requestHeaders");
        String str = this.f2520d + '[' + i + "] onHeaders";
        this.f2526l.mo27659a(new C1852f(str, true, str, true, this, i, list, z), 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:27|28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r5 = (int) java.lang.Math.min(r13, r9.f2540z - r9.f2539y);
        r3.element = r5;
        r4 = java.lang.Math.min(r5, r9.f2514B.mo27934h());
        r3.element = r4;
        r9.f2539y += (long) r4;
        r5 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0079, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo27830a(int r10, boolean r11, p042j.C2068f r12, long r13) throws java.io.IOException {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            i.M.i.j r13 = r9.f2514B
            r13.mo27928a((boolean) r11, (int) r10, (p042j.C2068f) r12, (int) r0)
            return
        L_0x000d:
            int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x007c
            kotlin.jvm.internal.Ref$IntRef r3 = new kotlin.jvm.internal.Ref$IntRef
            r3.<init>()
            monitor-enter(r9)
        L_0x0017:
            long r4 = r9.f2539y     // Catch:{ InterruptedException -> 0x006d }
            long r6 = r9.f2540z     // Catch:{ InterruptedException -> 0x006d }
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x0037
            java.util.Map<java.lang.Integer, i.M.i.i> r4 = r9.f2519c     // Catch:{ InterruptedException -> 0x006d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)     // Catch:{ InterruptedException -> 0x006d }
            boolean r4 = r4.containsKey(r5)     // Catch:{ InterruptedException -> 0x006d }
            if (r4 == 0) goto L_0x002f
            r9.wait()     // Catch:{ InterruptedException -> 0x006d }
            goto L_0x0017
        L_0x002f:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ InterruptedException -> 0x006d }
            java.lang.String r11 = "stream closed"
            r10.<init>(r11)     // Catch:{ InterruptedException -> 0x006d }
            throw r10     // Catch:{ InterruptedException -> 0x006d }
        L_0x0037:
            long r4 = r9.f2540z     // Catch:{ all -> 0x006b }
            long r6 = r9.f2539y     // Catch:{ all -> 0x006b }
            long r4 = r4 - r6
            long r4 = java.lang.Math.min(r13, r4)     // Catch:{ all -> 0x006b }
            int r5 = (int) r4     // Catch:{ all -> 0x006b }
            r3.element = r5     // Catch:{ all -> 0x006b }
            i.M.i.j r4 = r9.f2514B     // Catch:{ all -> 0x006b }
            int r4 = r4.mo27934h()     // Catch:{ all -> 0x006b }
            int r4 = java.lang.Math.min(r5, r4)     // Catch:{ all -> 0x006b }
            r3.element = r4     // Catch:{ all -> 0x006b }
            long r5 = r9.f2539y     // Catch:{ all -> 0x006b }
            long r7 = (long) r4     // Catch:{ all -> 0x006b }
            long r5 = r5 + r7
            r9.f2539y = r5     // Catch:{ all -> 0x006b }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x006b }
            monitor-exit(r9)
            long r4 = (long) r4
            long r13 = r13 - r4
            i.M.i.j r4 = r9.f2514B
            if (r11 == 0) goto L_0x0064
            int r5 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0064
            r5 = 1
            goto L_0x0065
        L_0x0064:
            r5 = 0
        L_0x0065:
            int r3 = r3.element
            r4.mo27928a((boolean) r5, (int) r10, (p042j.C2068f) r12, (int) r3)
            goto L_0x000d
        L_0x006b:
            r10 = move-exception
            goto L_0x007a
        L_0x006d:
            java.lang.Thread r10 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x006b }
            r10.interrupt()     // Catch:{ all -> 0x006b }
            java.io.InterruptedIOException r10 = new java.io.InterruptedIOException     // Catch:{ all -> 0x006b }
            r10.<init>()     // Catch:{ all -> 0x006b }
            throw r10     // Catch:{ all -> 0x006b }
        L_0x007a:
            monitor-exit(r9)
            throw r10
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p110i.C1841f.mo27830a(int, boolean, j.f, long):void");
    }

    /* renamed from: a */
    public final void mo27831a(C1834b bVar) throws IOException {
        Intrinsics.checkParameterIsNotNull(bVar, "statusCode");
        synchronized (this.f2514B) {
            synchronized (this) {
                if (!this.f2523g) {
                    this.f2523g = true;
                    int i = this.f2521e;
                    Unit unit = Unit.INSTANCE;
                    this.f2514B.mo27925a(i, bVar, C1764b.f2213a);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:6|7|8|41|(2:22|(5:24|25|26|39|27))|29|30|31|32|33|35) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0080 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo27832a(p040i.p103M.p110i.C1834b r4, p040i.p103M.p110i.C1834b r5, java.io.IOException r6) {
        /*
            r3 = this;
            java.lang.String r0 = "connectionCode"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "streamCode"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            boolean r0 = p040i.p103M.C1764b.f2219g
            if (r0 == 0) goto L_0x003d
            boolean r0 = java.lang.Thread.holdsLock(r3)
            if (r0 != 0) goto L_0x0015
            goto L_0x003d
        L_0x0015:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            java.lang.String r5 = "Thread "
            java.lang.StringBuilder r5 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r5)
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            java.lang.String r0 = "Thread.currentThread()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r0)
            java.lang.String r6 = r6.getName()
            r5.append(r6)
            java.lang.String r6 = " MUST NOT hold lock on "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x003d:
            r3.mo27831a((p040i.p103M.p110i.C1834b) r4)     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            r4 = 0
            monitor-enter(r3)
            java.util.Map<java.lang.Integer, i.M.i.i> r0 = r3.f2519c     // Catch:{ all -> 0x0095 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0095 }
            r0 = r0 ^ 1
            r1 = 0
            if (r0 == 0) goto L_0x006b
            java.util.Map<java.lang.Integer, i.M.i.i> r4 = r3.f2519c     // Catch:{ all -> 0x0095 }
            java.util.Collection r4 = r4.values()     // Catch:{ all -> 0x0095 }
            i.M.i.i[] r0 = new p040i.p103M.p110i.C1862i[r1]     // Catch:{ all -> 0x0095 }
            java.lang.Object[] r4 = r4.toArray(r0)     // Catch:{ all -> 0x0095 }
            if (r4 == 0) goto L_0x0063
            i.M.i.i[] r4 = (p040i.p103M.p110i.C1862i[]) r4     // Catch:{ all -> 0x0095 }
            java.util.Map<java.lang.Integer, i.M.i.i> r0 = r3.f2519c     // Catch:{ all -> 0x0095 }
            r0.clear()     // Catch:{ all -> 0x0095 }
            goto L_0x006b
        L_0x0063:
            kotlin.TypeCastException r4 = new kotlin.TypeCastException     // Catch:{ all -> 0x0095 }
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T>"
            r4.<init>(r5)     // Catch:{ all -> 0x0095 }
            throw r4     // Catch:{ all -> 0x0095 }
        L_0x006b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0095 }
            monitor-exit(r3)
            if (r4 == 0) goto L_0x007b
            int r0 = r4.length
        L_0x0071:
            if (r1 >= r0) goto L_0x007b
            r2 = r4[r1]
            r2.mo27886a((p040i.p103M.p110i.C1834b) r5, (java.io.IOException) r6)     // Catch:{ IOException -> 0x0078 }
        L_0x0078:
            int r1 = r1 + 1
            goto L_0x0071
        L_0x007b:
            i.M.i.j r4 = r3.f2514B     // Catch:{ IOException -> 0x0080 }
            r4.close()     // Catch:{ IOException -> 0x0080 }
        L_0x0080:
            java.net.Socket r4 = r3.f2513A     // Catch:{ IOException -> 0x0085 }
            r4.close()     // Catch:{ IOException -> 0x0085 }
        L_0x0085:
            i.M.e.d r4 = r3.f2525i
            r4.mo27669i()
            i.M.e.d r4 = r3.f2526l
            r4.mo27669i()
            i.M.e.d r4 = r3.f2527m
            r4.mo27669i()
            return
        L_0x0095:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x0099
        L_0x0098:
            throw r4
        L_0x0099:
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p110i.C1841f.mo27832a(i.M.i.b, i.M.i.b, java.io.IOException):void");
    }

    /* renamed from: a */
    public final void mo27833a(C1871n nVar) {
        Intrinsics.checkParameterIsNotNull(nVar, "<set-?>");
        this.f2536v = nVar;
    }

    /* renamed from: b */
    public final void mo27835b(int i, C1834b bVar) throws IOException {
        Intrinsics.checkParameterIsNotNull(bVar, "statusCode");
        this.f2514B.mo27924a(i, bVar);
    }

    /* renamed from: b */
    public final boolean mo27836b(int i) {
        return i != 0 && (i & 1) == 0;
    }

    /* renamed from: c */
    public final synchronized C1862i mo27837c(int i) {
        C1862i remove;
        remove = this.f2519c.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    /* renamed from: c */
    public final void mo27838c(int i, C1834b bVar) {
        Intrinsics.checkParameterIsNotNull(bVar, "errorCode");
        String str = this.f2520d + '[' + i + "] writeSynReset";
        this.f2525i.mo27659a(new C1856j(str, true, str, true, this, i, bVar), 0);
    }

    public void close() {
        mo27832a(C1834b.NO_ERROR, C1834b.CANCEL, (IOException) null);
    }

    /* renamed from: d */
    public final void mo27840d(int i) {
        this.f2521e = i;
    }

    /* renamed from: d */
    public final boolean mo27841d() {
        return this.f2517a;
    }

    public final void flush() throws IOException {
        this.f2514B.flush();
    }

    /* renamed from: h */
    public final String mo27843h() {
        return this.f2520d;
    }

    /* renamed from: h */
    public final synchronized boolean mo27844h(long j) {
        if (this.f2523g) {
            return false;
        }
        return this.f2532r >= this.f2531q || j < this.f2534t;
    }

    /* renamed from: i */
    public final int mo27845i() {
        return this.f2521e;
    }

    /* renamed from: i */
    public final synchronized void mo27846i(long j) {
        long j2 = this.f2537w + j;
        this.f2537w = j2;
        long j3 = j2 - this.f2538x;
        if (j3 >= ((long) (this.f2535u.mo27949b() / 2))) {
            mo27825a(0, j3);
            this.f2538x += j3;
        }
    }

    /* renamed from: l */
    public final C1844c mo27847l() {
        return this.f2518b;
    }

    /* renamed from: o */
    public final int mo27848o() {
        return this.f2522f;
    }

    /* renamed from: p */
    public final C1871n mo27849p() {
        return this.f2535u;
    }

    /* renamed from: q */
    public final C1871n mo27850q() {
        return this.f2536v;
    }

    /* renamed from: r */
    public final Map<Integer, C1862i> mo27851r() {
        return this.f2519c;
    }

    /* renamed from: s */
    public final long mo27852s() {
        return this.f2540z;
    }

    /* renamed from: t */
    public final C1866j mo27853t() {
        return this.f2514B;
    }

    /* renamed from: u */
    public final void mo27854u() {
        synchronized (this) {
            if (this.f2532r >= this.f2531q) {
                this.f2531q++;
                this.f2534t = System.nanoTime() + ((long) 1000000000);
                Unit unit = Unit.INSTANCE;
                C1787d dVar = this.f2525i;
                String a = C0681a.m324a(new StringBuilder(), this.f2520d, " ping");
                dVar.mo27659a(new C1855i(a, true, a, true, this), 0);
            }
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m2945a(C1841f fVar, boolean z, C1788e eVar, int i) throws IOException {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            eVar = C1788e.f2308h;
        }
        if (fVar != null) {
            Intrinsics.checkParameterIsNotNull(eVar, "taskRunner");
            if (z) {
                fVar.f2514B.mo27932d();
                fVar.f2514B.mo27930b(fVar.f2535u);
                int b = fVar.f2535u.mo27949b();
                if (b != 65535) {
                    fVar.f2514B.mo27923a(0, (long) (b - 65535));
                }
            }
            C1787d d = eVar.mo27675d();
            String str = fVar.f2520d;
            d.mo27659a(new C1786c(fVar.f2515C, str, true, str, true), 0);
            return;
        }
        throw null;
    }

    /* renamed from: a */
    public final void mo27834a(boolean z, int i, int i2) {
        try {
            this.f2514B.mo27927a(z, i, i2);
        } catch (IOException e) {
            C1834b bVar = C1834b.PROTOCOL_ERROR;
            mo27832a(bVar, bVar, e);
        }
    }
}
