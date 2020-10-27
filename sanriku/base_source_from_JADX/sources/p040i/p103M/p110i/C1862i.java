package p040i.p103M.p110i;

import android.support.p001v4.media.session.PlaybackStateCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C1952y;
import p040i.p103M.C1764b;
import p042j.C1016z;
import p042j.C2057A;
import p042j.C2062b;
import p042j.C2068f;
import p042j.C2072h;
import p042j.C2090x;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 _2\u00020\u0001:\u0004_`abB1\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020#J\r\u0010C\u001a\u00020AH\u0000¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020AH\u0000¢\u0006\u0002\bFJ\u0018\u0010G\u001a\u00020A2\u0006\u0010H\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001a\u0010I\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u000e\u0010J\u001a\u00020A2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010K\u001a\u00020A2\u0006\u0010L\u001a\u00020\nJ\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u00020PJ\u0006\u0010,\u001a\u00020QJ\u0016\u0010R\u001a\u00020A2\u0006\u00104\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010U\u001a\u00020A2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010V\u001a\u00020A2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010W\u001a\u00020\nJ\u0006\u0010L\u001a\u00020\nJ\r\u0010X\u001a\u00020AH\u0000¢\u0006\u0002\bYJ$\u0010Z\u001a\u00020A2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u0007J\u0006\u0010>\u001a\u00020QR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010 R$\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0018\u0010,\u001a\u00060-R\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u00100\u001a\u000601R\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u00104\u001a\u000605R\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R$\u00108\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010&\"\u0004\b:\u0010(R$\u0010;\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010&\"\u0004\b=\u0010(R\u0018\u0010>\u001a\u00060-R\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010/¨\u0006c"}, mo21739d2 = {"Lokhttp3/internal/http2/Http2Stream;", "", "id", "", "connection", "Lokhttp3/internal/http2/Http2Connection;", "outFinished", "", "inFinished", "headers", "Lokhttp3/Headers;", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "(Lokhttp3/internal/http2/ErrorCode;)V", "errorException", "Ljava/io/IOException;", "getErrorException$okhttp", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "hasResponseHeaders", "headersQueue", "Ljava/util/ArrayDeque;", "getId", "()I", "isLocallyInitiated", "()Z", "isOpen", "<set-?>", "", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "setReadBytesAcknowledged$okhttp", "(J)V", "readBytesTotal", "getReadBytesTotal", "setReadBytesTotal$okhttp", "readTimeout", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "sink", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "getSink$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "source", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "getSource$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "writeBytesMaximum", "getWriteBytesMaximum", "setWriteBytesMaximum$okhttp", "writeBytesTotal", "getWriteBytesTotal", "setWriteBytesTotal$okhttp", "writeTimeout", "getWriteTimeout$okhttp", "addBytesToWriteWindow", "", "delta", "cancelStreamIfNecessary", "cancelStreamIfNecessary$okhttp", "checkOutNotClosed", "checkOutNotClosed$okhttp", "close", "rstStatusCode", "closeInternal", "closeLater", "enqueueTrailers", "trailers", "getSink", "Lokio/Sink;", "getSource", "Lokio/Source;", "Lokio/Timeout;", "receiveData", "Lokio/BufferedSource;", "length", "receiveHeaders", "receiveRstStream", "takeHeaders", "waitForIo", "waitForIo$okhttp", "writeHeaders", "responseHeaders", "", "Lokhttp3/internal/http2/Header;", "flushHeaders", "Companion", "FramingSink", "FramingSource", "StreamTimeout", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.i.i */
public final class C1862i {

    /* renamed from: a */
    private long f2607a;

    /* renamed from: b */
    private long f2608b;

    /* renamed from: c */
    private long f2609c;

    /* renamed from: d */
    private long f2610d;

    /* renamed from: e */
    private final ArrayDeque<C1952y> f2611e = new ArrayDeque<>();

    /* renamed from: f */
    private boolean f2612f;

    /* renamed from: g */
    private final C1864b f2613g;

    /* renamed from: h */
    private final C1863a f2614h;

    /* renamed from: i */
    private final C1865c f2615i;

    /* renamed from: j */
    private final C1865c f2616j;

    /* renamed from: k */
    private C1834b f2617k;

    /* renamed from: l */
    private IOException f2618l;

    /* renamed from: m */
    private final int f2619m;

    /* renamed from: n */
    private final C1841f f2620n;

    /* renamed from: i.M.i.i$a */
    public final class C1863a implements C2090x {

        /* renamed from: a */
        private final C2068f f2621a = new C2068f();

        /* renamed from: b */
        private boolean f2622b;

        /* renamed from: c */
        private boolean f2623c;

        public C1863a(boolean z) {
            this.f2623c = z;
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private final void m3087a(boolean z) throws IOException {
            long min;
            boolean z2;
            synchronized (C1862i.this) {
                C1862i.this.mo27906o().mo29126g();
                while (C1862i.this.mo27905n() >= C1862i.this.mo27904m() && !this.f2623c && !this.f2622b && C1862i.this.mo27894d() == null) {
                    try {
                        C1862i.this.mo27911t();
                    } catch (Throwable th) {
                        C1862i.this.mo27906o().mo27920m();
                        throw th;
                    }
                }
                C1862i.this.mo27906o().mo27920m();
                C1862i.this.mo27889b();
                min = Math.min(C1862i.this.mo27904m() - C1862i.this.mo27905n(), this.f2621a.size());
                C1862i iVar = C1862i.this;
                iVar.mo27895d(iVar.mo27905n() + min);
                z2 = z && min == this.f2621a.size() && C1862i.this.mo27894d() == null;
                Unit unit = Unit.INSTANCE;
            }
            C1862i.this.mo27906o().mo29126g();
            try {
                C1862i.this.mo27892c().mo27830a(C1862i.this.mo27897f(), z2, this.f2621a, min);
            } finally {
                C1862i.this.mo27906o().mo27920m();
            }
        }

        /* renamed from: a */
        public void mo27647a(C2068f fVar, long j) throws IOException {
            Intrinsics.checkParameterIsNotNull(fVar, FirebaseAnalytics.Param.SOURCE);
            C1862i iVar = C1862i.this;
            if (!C1764b.f2219g || !Thread.holdsLock(iVar)) {
                this.f2621a.mo27647a(fVar, j);
                while (this.f2621a.size() >= PlaybackStateCompat.ACTION_PREPARE) {
                    m3087a(false);
                }
                return;
            }
            StringBuilder a = C0681a.m330a("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            a.append(currentThread.getName());
            a.append(" MUST NOT hold lock on ");
            a.append(iVar);
            throw new AssertionError(a.toString());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
            if (r10.f2624d.mo27902k().f2623c != false) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
            if (r10.f2621a.size() <= 0) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
            if (r2 == false) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x006f, code lost:
            if (r10.f2621a.size() <= 0) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
            m3087a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0075, code lost:
            if (r1 == false) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0077, code lost:
            r10.f2624d.mo27892c().mo27830a(r10.f2624d.mo27897f(), true, (p042j.C2068f) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x008a, code lost:
            r0 = r10.f2624d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x008c, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r10.f2622b = true;
            r1 = kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0092, code lost:
            r10.f2624d.mo27892c().flush();
            r10.f2624d.mo27883a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a0, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r10 = this;
                i.M.i.i r0 = p040i.p103M.p110i.C1862i.this
                boolean r1 = p040i.p103M.C1764b.f2219g
                if (r1 == 0) goto L_0x0035
                boolean r1 = java.lang.Thread.holdsLock(r0)
                if (r1 != 0) goto L_0x000d
                goto L_0x0035
            L_0x000d:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                java.lang.String r2 = "Thread "
                java.lang.StringBuilder r2 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r2)
                java.lang.Thread r3 = java.lang.Thread.currentThread()
                java.lang.String r4 = "Thread.currentThread()"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
                java.lang.String r3 = r3.getName()
                r2.append(r3)
                java.lang.String r3 = " MUST NOT hold lock on "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                r1.<init>(r0)
                throw r1
            L_0x0035:
                i.M.i.i r0 = p040i.p103M.p110i.C1862i.this
                monitor-enter(r0)
                boolean r1 = r10.f2622b     // Catch:{ all -> 0x00a4 }
                if (r1 == 0) goto L_0x003e
                monitor-exit(r0)
                return
            L_0x003e:
                i.M.i.i r1 = p040i.p103M.p110i.C1862i.this     // Catch:{ all -> 0x00a4 }
                i.M.i.b r1 = r1.mo27894d()     // Catch:{ all -> 0x00a4 }
                r2 = 0
                r3 = 1
                if (r1 != 0) goto L_0x004a
                r1 = 1
                goto L_0x004b
            L_0x004a:
                r1 = 0
            L_0x004b:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a4 }
                monitor-exit(r0)
                i.M.i.i r0 = p040i.p103M.p110i.C1862i.this
                i.M.i.i$a r0 = r0.mo27902k()
                boolean r0 = r0.f2623c
                if (r0 != 0) goto L_0x008a
                j.f r0 = r10.f2621a
                long r4 = r0.size()
                r6 = 0
                int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r0 <= 0) goto L_0x0065
                r2 = 1
            L_0x0065:
                if (r2 == 0) goto L_0x0075
            L_0x0067:
                j.f r0 = r10.f2621a
                long r0 = r0.size()
                int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r2 <= 0) goto L_0x008a
                r10.m3087a(r3)
                goto L_0x0067
            L_0x0075:
                if (r1 == 0) goto L_0x008a
                i.M.i.i r0 = p040i.p103M.p110i.C1862i.this
                i.M.i.f r4 = r0.mo27892c()
                i.M.i.i r0 = p040i.p103M.p110i.C1862i.this
                int r5 = r0.mo27897f()
                r6 = 1
                r7 = 0
                r8 = 0
                r4.mo27830a((int) r5, (boolean) r6, (p042j.C2068f) r7, (long) r8)
            L_0x008a:
                i.M.i.i r0 = p040i.p103M.p110i.C1862i.this
                monitor-enter(r0)
                r10.f2622b = r3     // Catch:{ all -> 0x00a1 }
                kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a1 }
                monitor-exit(r0)
                i.M.i.i r0 = p040i.p103M.p110i.C1862i.this
                i.M.i.f r0 = r0.mo27892c()
                r0.flush()
                i.M.i.i r0 = p040i.p103M.p110i.C1862i.this
                r0.mo27883a()
                return
            L_0x00a1:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            L_0x00a4:
                r1 = move-exception
                monitor-exit(r0)
                goto L_0x00a8
            L_0x00a7:
                throw r1
            L_0x00a8:
                goto L_0x00a7
            */
            throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p110i.C1862i.C1863a.close():void");
        }

        /* renamed from: d */
        public final boolean mo27913d() {
            return this.f2622b;
        }

        public void flush() throws IOException {
            C1862i iVar = C1862i.this;
            if (!C1764b.f2219g || !Thread.holdsLock(iVar)) {
                synchronized (C1862i.this) {
                    C1862i.this.mo27889b();
                    Unit unit = Unit.INSTANCE;
                }
                while (this.f2621a.size() > 0) {
                    m3087a(false);
                    C1862i.this.mo27892c().flush();
                }
                return;
            }
            StringBuilder a = C0681a.m330a("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            a.append(currentThread.getName());
            a.append(" MUST NOT hold lock on ");
            a.append(iVar);
            throw new AssertionError(a.toString());
        }

        /* renamed from: h */
        public final boolean mo27914h() {
            return this.f2623c;
        }

        public C2057A timeout() {
            return C1862i.this.mo27906o();
        }
    }

    /* renamed from: i.M.i.i$b */
    public final class C1864b implements C1016z {

        /* renamed from: a */
        private final C2068f f2625a = new C2068f();

        /* renamed from: b */
        private final C2068f f2626b = new C2068f();

        /* renamed from: c */
        private boolean f2627c;

        /* renamed from: d */
        private final long f2628d;

        /* renamed from: e */
        private boolean f2629e;

        public C1864b(long j, boolean z) {
            this.f2628d = j;
            this.f2629e = z;
        }

        /* renamed from: h */
        private final void m3091h(long j) {
            C1862i iVar = C1862i.this;
            if (!C1764b.f2219g || !Thread.holdsLock(iVar)) {
                C1862i.this.mo27892c().mo27846i(j);
                return;
            }
            StringBuilder a = C0681a.m330a("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            a.append(currentThread.getName());
            a.append(" MUST NOT hold lock on ");
            a.append(iVar);
            throw new AssertionError(a.toString());
        }

        /* renamed from: a */
        public final void mo27915a(C2072h hVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j2;
            Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
            C1862i iVar = C1862i.this;
            if (!C1764b.f2219g || !Thread.holdsLock(iVar)) {
                while (j > 0) {
                    synchronized (C1862i.this) {
                        z = this.f2629e;
                        z2 = true;
                        z3 = this.f2626b.size() + j > this.f2628d;
                        Unit unit = Unit.INSTANCE;
                    }
                    if (z3) {
                        hVar.skip(j);
                        C1862i.this.mo27885a(C1834b.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        hVar.skip(j);
                        return;
                    } else {
                        long read = hVar.read(this.f2625a, j);
                        if (read != -1) {
                            j -= read;
                            synchronized (C1862i.this) {
                                if (this.f2627c) {
                                    j2 = this.f2625a.size();
                                    this.f2625a.mo29154d();
                                } else {
                                    if (this.f2626b.size() != 0) {
                                        z2 = false;
                                    }
                                    this.f2626b.mo29135a((C1016z) this.f2625a);
                                    if (z2) {
                                        C1862i iVar2 = C1862i.this;
                                        if (iVar2 != null) {
                                            iVar2.notifyAll();
                                        } else {
                                            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                                        }
                                    }
                                    j2 = 0;
                                }
                                Unit unit2 = Unit.INSTANCE;
                            }
                            if (j2 > 0) {
                                m3091h(j2);
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
                return;
            }
            StringBuilder a = C0681a.m330a("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            a.append(currentThread.getName());
            a.append(" MUST NOT hold lock on ");
            a.append(iVar);
            throw new AssertionError(a.toString());
        }

        /* renamed from: a */
        public final void mo27916a(boolean z) {
            this.f2629e = z;
        }

        public void close() throws IOException {
            long size;
            synchronized (C1862i.this) {
                this.f2627c = true;
                size = this.f2626b.size();
                this.f2626b.mo29154d();
                C1862i iVar = C1862i.this;
                if (iVar != null) {
                    iVar.notifyAll();
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                }
            }
            if (size > 0) {
                m3091h(size);
            }
            C1862i.this.mo27883a();
        }

        /* renamed from: d */
        public final boolean mo27917d() {
            return this.f2627c;
        }

        /* renamed from: h */
        public final boolean mo27918h() {
            return this.f2629e;
        }

        /* JADX INFO: finally extract failed */
        public long read(C2068f fVar, long j) throws IOException {
            Throwable th;
            long j2;
            boolean z;
            long j3;
            C2068f fVar2 = fVar;
            long j4 = j;
            Intrinsics.checkParameterIsNotNull(fVar2, "sink");
            if (j4 >= 0) {
                do {
                    th = null;
                    synchronized (C1862i.this) {
                        C1862i.this.mo27900i().mo29126g();
                        try {
                            if (C1862i.this.mo27894d() != null) {
                                th = C1862i.this.mo27896e();
                                if (th == null) {
                                    C1834b d = C1862i.this.mo27894d();
                                    if (d == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    th = new C1872o(d);
                                }
                            }
                            if (!this.f2627c) {
                                if (this.f2626b.size() > 0) {
                                    j3 = this.f2626b.read(fVar2, Math.min(j4, this.f2626b.size()));
                                    C1862i iVar = C1862i.this;
                                    iVar.mo27893c(iVar.mo27899h() + j3);
                                    long h = C1862i.this.mo27899h() - C1862i.this.mo27898g();
                                    if (th == null && h >= ((long) (C1862i.this.mo27892c().mo27849p().mo27949b() / 2))) {
                                        C1862i.this.mo27892c().mo27825a(C1862i.this.mo27897f(), h);
                                        C1862i.this.mo27890b(C1862i.this.mo27899h());
                                    }
                                } else if (this.f2629e || th != null) {
                                    j3 = -1;
                                } else {
                                    C1862i.this.mo27911t();
                                    z = true;
                                    j2 = -1;
                                    C1862i.this.mo27900i().mo27920m();
                                    Unit unit = Unit.INSTANCE;
                                }
                                j2 = j3;
                                z = false;
                                C1862i.this.mo27900i().mo27920m();
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                throw new IOException("stream closed");
                            }
                        } catch (Throwable th2) {
                            C1862i.this.mo27900i().mo27920m();
                            throw th2;
                        }
                    }
                } while (z);
                if (j2 != -1) {
                    m3091h(j2);
                    return j2;
                } else if (th == null) {
                    return -1;
                } else {
                    throw th;
                }
            } else {
                throw new IllegalArgumentException(C0681a.m318a("byteCount < 0: ", j4).toString());
            }
        }

        public C2057A timeout() {
            return C1862i.this.mo27900i();
        }
    }

    /* renamed from: i.M.i.i$c */
    public final class C1865c extends C2062b {
        public C1865c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public IOException mo27919a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        /* renamed from: i */
        public void mo27739i() {
            C1862i.this.mo27885a(C1834b.CANCEL);
            C1862i.this.mo27892c().mo27854u();
        }

        /* renamed from: m */
        public final void mo27920m() throws IOException {
            if (mo29127h()) {
                throw new SocketTimeoutException("timeout");
            }
        }
    }

    public C1862i(int i, C1841f fVar, boolean z, boolean z2, C1952y yVar) {
        Intrinsics.checkParameterIsNotNull(fVar, "connection");
        this.f2619m = i;
        this.f2620n = fVar;
        this.f2610d = (long) fVar.mo27850q().mo27949b();
        this.f2613g = new C1864b((long) this.f2620n.mo27849p().mo27949b(), z2);
        this.f2614h = new C1863a(z);
        this.f2615i = new C1865c();
        this.f2616j = new C1865c();
        boolean p = mo27907p();
        if (yVar != null) {
            if (!p) {
                this.f2611e.add(yVar);
                return;
            }
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
        } else if (!p) {
            throw new IllegalStateException("remotely-initiated streams should have headers".toString());
        }
    }

    /* renamed from: b */
    private final boolean m3056b(C1834b bVar, IOException iOException) {
        if (!C1764b.f2219g || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f2617k != null) {
                    return false;
                }
                if (this.f2613g.mo27918h() && this.f2614h.mo27914h()) {
                    return false;
                }
                this.f2617k = bVar;
                this.f2618l = iOException;
                notifyAll();
                Unit unit = Unit.INSTANCE;
                this.f2620n.mo27837c(this.f2619m);
                return true;
            }
        }
        StringBuilder a = C0681a.m330a("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        a.append(currentThread.getName());
        a.append(" MUST NOT hold lock on ");
        a.append(this);
        throw new AssertionError(a.toString());
    }

    /* renamed from: a */
    public final void mo27883a() throws IOException {
        boolean z;
        boolean q;
        if (!C1764b.f2219g || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = !this.f2613g.mo27918h() && this.f2613g.mo27917d() && (this.f2614h.mo27914h() || this.f2614h.mo27913d());
                q = mo27908q();
                Unit unit = Unit.INSTANCE;
            }
            if (z) {
                mo27886a(C1834b.CANCEL, (IOException) null);
            } else if (!q) {
                this.f2620n.mo27837c(this.f2619m);
            }
        } else {
            StringBuilder a = C0681a.m330a("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            a.append(currentThread.getName());
            a.append(" MUST NOT hold lock on ");
            a.append(this);
            throw new AssertionError(a.toString());
        }
    }

    /* renamed from: a */
    public final void mo27884a(long j) {
        this.f2610d += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* renamed from: a */
    public final void mo27885a(C1834b bVar) {
        Intrinsics.checkParameterIsNotNull(bVar, "errorCode");
        if (m3056b(bVar, (IOException) null)) {
            this.f2620n.mo27838c(this.f2619m, bVar);
        }
    }

    /* renamed from: a */
    public final void mo27886a(C1834b bVar, IOException iOException) throws IOException {
        Intrinsics.checkParameterIsNotNull(bVar, "rstStatusCode");
        if (m3056b(bVar, iOException)) {
            this.f2620n.mo27835b(this.f2619m, bVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo27887a(p040i.C1952y r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            boolean r0 = p040i.p103M.C1764b.f2219g
            if (r0 == 0) goto L_0x0038
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto L_0x0010
            goto L_0x0038
        L_0x0010:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.String r4 = "Thread "
            java.lang.StringBuilder r4 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r4)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r1 = "Thread.currentThread()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.String r0 = r0.getName()
            r4.append(r0)
            java.lang.String r0 = " MUST NOT hold lock on "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x0038:
            monitor-enter(r2)
            boolean r0 = r2.f2612f     // Catch:{ all -> 0x006a }
            r1 = 1
            if (r0 == 0) goto L_0x0048
            if (r4 != 0) goto L_0x0041
            goto L_0x0048
        L_0x0041:
            i.M.i.i$b r3 = r2.f2613g     // Catch:{ all -> 0x006a }
            if (r3 == 0) goto L_0x0046
            goto L_0x004f
        L_0x0046:
            r3 = 0
            throw r3     // Catch:{ all -> 0x006a }
        L_0x0048:
            r2.f2612f = r1     // Catch:{ all -> 0x006a }
            java.util.ArrayDeque<i.y> r0 = r2.f2611e     // Catch:{ all -> 0x006a }
            r0.add(r3)     // Catch:{ all -> 0x006a }
        L_0x004f:
            if (r4 == 0) goto L_0x0056
            i.M.i.i$b r3 = r2.f2613g     // Catch:{ all -> 0x006a }
            r3.mo27916a(r1)     // Catch:{ all -> 0x006a }
        L_0x0056:
            boolean r3 = r2.mo27908q()     // Catch:{ all -> 0x006a }
            r2.notifyAll()     // Catch:{ all -> 0x006a }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x006a }
            monitor-exit(r2)
            if (r3 != 0) goto L_0x0069
            i.M.i.f r3 = r2.f2620n
            int r4 = r2.f2619m
            r3.mo27837c((int) r4)
        L_0x0069:
            return
        L_0x006a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p110i.C1862i.mo27887a(i.y, boolean):void");
    }

    /* renamed from: a */
    public final void mo27888a(C2072h hVar, int i) throws IOException {
        Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
        if (!C1764b.f2219g || !Thread.holdsLock(this)) {
            this.f2613g.mo27915a(hVar, (long) i);
            return;
        }
        StringBuilder a = C0681a.m330a("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        a.append(currentThread.getName());
        a.append(" MUST NOT hold lock on ");
        a.append(this);
        throw new AssertionError(a.toString());
    }

    /* renamed from: b */
    public final void mo27889b() throws IOException {
        if (this.f2614h.mo27913d()) {
            throw new IOException("stream closed");
        } else if (this.f2614h.mo27914h()) {
            throw new IOException("stream finished");
        } else if (this.f2617k != null) {
            Throwable th = this.f2618l;
            if (th == null) {
                C1834b bVar = this.f2617k;
                if (bVar == null) {
                    Intrinsics.throwNpe();
                }
                th = new C1872o(bVar);
            }
            throw th;
        }
    }

    /* renamed from: b */
    public final void mo27890b(long j) {
        this.f2608b = j;
    }

    /* renamed from: b */
    public final synchronized void mo27891b(C1834b bVar) {
        Intrinsics.checkParameterIsNotNull(bVar, "errorCode");
        if (this.f2617k == null) {
            this.f2617k = bVar;
            notifyAll();
        }
    }

    /* renamed from: c */
    public final C1841f mo27892c() {
        return this.f2620n;
    }

    /* renamed from: c */
    public final void mo27893c(long j) {
        this.f2607a = j;
    }

    /* renamed from: d */
    public final synchronized C1834b mo27894d() {
        return this.f2617k;
    }

    /* renamed from: d */
    public final void mo27895d(long j) {
        this.f2609c = j;
    }

    /* renamed from: e */
    public final IOException mo27896e() {
        return this.f2618l;
    }

    /* renamed from: f */
    public final int mo27897f() {
        return this.f2619m;
    }

    /* renamed from: g */
    public final long mo27898g() {
        return this.f2608b;
    }

    /* renamed from: h */
    public final long mo27899h() {
        return this.f2607a;
    }

    /* renamed from: i */
    public final C1865c mo27900i() {
        return this.f2615i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0017  */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final p042j.C2090x mo27901j() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f2612f     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x000e
            boolean r0 = r2.mo27907p()     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x000c
            goto L_0x000e
        L_0x000c:
            r0 = 0
            goto L_0x000f
        L_0x000e:
            r0 = 1
        L_0x000f:
            if (r0 == 0) goto L_0x0017
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            i.M.i.i$a r0 = r2.f2614h
            return r0
        L_0x0017:
            java.lang.String r0 = "reply before requesting the sink"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0023 }
            r1.<init>(r0)     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p110i.C1862i.mo27901j():j.x");
    }

    /* renamed from: k */
    public final C1863a mo27902k() {
        return this.f2614h;
    }

    /* renamed from: l */
    public final C1864b mo27903l() {
        return this.f2613g;
    }

    /* renamed from: m */
    public final long mo27904m() {
        return this.f2610d;
    }

    /* renamed from: n */
    public final long mo27905n() {
        return this.f2609c;
    }

    /* renamed from: o */
    public final C1865c mo27906o() {
        return this.f2616j;
    }

    /* renamed from: p */
    public final boolean mo27907p() {
        return this.f2620n.mo27841d() == ((this.f2619m & 1) == 1);
    }

    /* renamed from: q */
    public final synchronized boolean mo27908q() {
        if (this.f2617k != null) {
            return false;
        }
        return (!this.f2613g.mo27918h() && !this.f2613g.mo27917d()) || (!this.f2614h.mo27914h() && !this.f2614h.mo27913d()) || !this.f2612f;
    }

    /* renamed from: r */
    public final C2057A mo27909r() {
        return this.f2615i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
        r2.f2615i.mo27920m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004b, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized p040i.C1952y mo27910s() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            i.M.i.i$c r0 = r2.f2615i     // Catch:{ all -> 0x004c }
            r0.mo29126g()     // Catch:{ all -> 0x004c }
        L_0x0006:
            java.util.ArrayDeque<i.y> r0 = r2.f2611e     // Catch:{ all -> 0x0045 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0016
            i.M.i.b r0 = r2.f2617k     // Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0016
            r2.mo27911t()     // Catch:{ all -> 0x0045 }
            goto L_0x0006
        L_0x0016:
            i.M.i.i$c r0 = r2.f2615i     // Catch:{ all -> 0x004c }
            r0.mo27920m()     // Catch:{ all -> 0x004c }
            java.util.ArrayDeque<i.y> r0 = r2.f2611e     // Catch:{ all -> 0x004c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x004c }
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x0034
            java.util.ArrayDeque<i.y> r0 = r2.f2611e     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x004c }
            java.lang.String r1 = "headersQueue.removeFirst()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)     // Catch:{ all -> 0x004c }
            i.y r0 = (p040i.C1952y) r0     // Catch:{ all -> 0x004c }
            monitor-exit(r2)
            return r0
        L_0x0034:
            java.io.IOException r0 = r2.f2618l     // Catch:{ all -> 0x004c }
            if (r0 != 0) goto L_0x0044
            i.M.i.o r0 = new i.M.i.o     // Catch:{ all -> 0x004c }
            i.M.i.b r1 = r2.f2617k     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x0041
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x004c }
        L_0x0041:
            r0.<init>(r1)     // Catch:{ all -> 0x004c }
        L_0x0044:
            throw r0     // Catch:{ all -> 0x004c }
        L_0x0045:
            r0 = move-exception
            i.M.i.i$c r1 = r2.f2615i     // Catch:{ all -> 0x004c }
            r1.mo27920m()     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            monitor-exit(r2)
            goto L_0x0050
        L_0x004f:
            throw r0
        L_0x0050:
            goto L_0x004f
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p110i.C1862i.mo27910s():i.y");
    }

    /* renamed from: t */
    public final void mo27911t() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* renamed from: u */
    public final C2057A mo27912u() {
        return this.f2616j;
    }
}
