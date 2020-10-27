package p040i;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C1952y;
import p040i.p103M.p107f.C1795c;
import p040i.p103M.p108g.C1819e;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001FB{\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\b+J\r\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\b,J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0002\b-J\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/J\b\u00101\u001a\u000202H\u0016J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b3J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\b4J\u001e\u00105\u001a\u0004\u0018\u00010\u00072\u0006\u00106\u001a\u00020\u00072\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0007H\u0007J\r\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\b8J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070/2\u0006\u00106\u001a\u00020\u0007J\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b9J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0002\b:J\u0006\u0010;\u001a\u00020<J\u000e\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u0014J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0002\b?J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b@J\r\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0002\bAJ\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\bBJ\r\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\u0007H\u0016J\u0006\u0010E\u001a\u00020\rR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001dR\u0013\u0010\b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001eR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u001fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010 R\u0013\u0010\f\u001a\u00020\r8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010!R\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b\"\u0010$R\u0011\u0010%\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b%\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010'R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001dR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u001dR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010(R\u0013\u0010\u0015\u001a\u00020\u00148\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010)R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010*R\u0013\u0010\u0013\u001a\u00020\u00148\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010)¨\u0006G"}, mo21739d2 = {"Lokhttp3/Response;", "Ljava/io/Closeable;", "request", "Lokhttp3/Request;", "protocol", "Lokhttp3/Protocol;", "message", "", "code", "", "handshake", "Lokhttp3/Handshake;", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/ResponseBody;", "networkResponse", "cacheResponse", "priorResponse", "sentRequestAtMillis", "", "receivedResponseAtMillis", "exchange", "Lokhttp3/internal/connection/Exchange;", "(Lokhttp3/Request;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/Handshake;Lokhttp3/Headers;Lokhttp3/ResponseBody;Lokhttp3/Response;Lokhttp3/Response;Lokhttp3/Response;JJLokhttp3/internal/connection/Exchange;)V", "()Lokhttp3/ResponseBody;", "cacheControl", "Lokhttp3/CacheControl;", "()Lokhttp3/CacheControl;", "()Lokhttp3/Response;", "()I", "()Lokhttp3/internal/connection/Exchange;", "()Lokhttp3/Handshake;", "()Lokhttp3/Headers;", "isRedirect", "", "()Z", "isSuccessful", "lazyCacheControl", "()Ljava/lang/String;", "()Lokhttp3/Protocol;", "()J", "()Lokhttp3/Request;", "-deprecated_body", "-deprecated_cacheControl", "-deprecated_cacheResponse", "challenges", "", "Lokhttp3/Challenge;", "close", "", "-deprecated_code", "-deprecated_handshake", "header", "name", "defaultValue", "-deprecated_headers", "-deprecated_message", "-deprecated_networkResponse", "newBuilder", "Lokhttp3/Response$Builder;", "peekBody", "byteCount", "-deprecated_priorResponse", "-deprecated_protocol", "-deprecated_receivedResponseAtMillis", "-deprecated_request", "-deprecated_sentRequestAtMillis", "toString", "trailers", "Builder", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.I */
public final class C1758I implements Closeable {

    /* renamed from: a */
    private C1921e f2176a;

    /* renamed from: b */
    private final C1755F f2177b;

    /* renamed from: c */
    private final C0974E f2178c;

    /* renamed from: d */
    private final String f2179d;

    /* renamed from: e */
    private final int f2180e;

    /* renamed from: f */
    private final C1950x f2181f;

    /* renamed from: g */
    private final C1952y f2182g;

    /* renamed from: h */
    private final C0980J f2183h;

    /* renamed from: i */
    private final C1758I f2184i;

    /* renamed from: l */
    private final C1758I f2185l;

    /* renamed from: m */
    private final C1758I f2186m;

    /* renamed from: n */
    private final long f2187n;

    /* renamed from: o */
    private final long f2188o;

    /* renamed from: p */
    private final C1795c f2189p;

    /* renamed from: i.I$a */
    public static class C1759a {

        /* renamed from: a */
        private C1755F f2190a;

        /* renamed from: b */
        private C0974E f2191b;

        /* renamed from: c */
        private int f2192c;

        /* renamed from: d */
        private String f2193d;

        /* renamed from: e */
        private C1950x f2194e;

        /* renamed from: f */
        private C1952y.C1953a f2195f;

        /* renamed from: g */
        private C0980J f2196g;

        /* renamed from: h */
        private C1758I f2197h;

        /* renamed from: i */
        private C1758I f2198i;

        /* renamed from: j */
        private C1758I f2199j;

        /* renamed from: k */
        private long f2200k;

        /* renamed from: l */
        private long f2201l;

        /* renamed from: m */
        private C1795c f2202m;

        public C1759a() {
            this.f2192c = -1;
            this.f2195f = new C1952y.C1953a();
        }

        public C1759a(C1758I i) {
            Intrinsics.checkParameterIsNotNull(i, "response");
            this.f2192c = -1;
            this.f2190a = i.mo27569y();
            this.f2191b = i.mo27567w();
            this.f2192c = i.mo27558o();
            this.f2193d = i.mo27563t();
            this.f2194e = i.mo27560q();
            this.f2195f = i.mo27561r().mo28112a();
            this.f2196g = i.mo27554d();
            this.f2197h = i.mo27565u();
            this.f2198i = i.mo27556i();
            this.f2199j = i.mo27566v();
            this.f2200k = i.mo27570z();
            this.f2201l = i.mo27568x();
            this.f2202m = i.mo27559p();
        }

        /* renamed from: a */
        private final void m2578a(String str, C1758I i) {
            if (i != null) {
                boolean z = true;
                if (i.mo27554d() == null) {
                    if (i.mo27565u() == null) {
                        if (i.mo27556i() == null) {
                            if (i.mo27566v() != null) {
                                z = false;
                            }
                            if (!z) {
                                throw new IllegalArgumentException(C0681a.m320a(str, ".priorResponse != null").toString());
                            }
                            return;
                        }
                        throw new IllegalArgumentException(C0681a.m320a(str, ".cacheResponse != null").toString());
                    }
                    throw new IllegalArgumentException(C0681a.m320a(str, ".networkResponse != null").toString());
                }
                throw new IllegalArgumentException(C0681a.m320a(str, ".body != null").toString());
            }
        }

        /* renamed from: a */
        public C1759a mo27571a(int i) {
            this.f2192c = i;
            return this;
        }

        /* renamed from: a */
        public C1759a mo27572a(long j) {
            this.f2201l = j;
            return this;
        }

        /* renamed from: a */
        public C1759a mo27573a(C0974E e) {
            Intrinsics.checkParameterIsNotNull(e, "protocol");
            this.f2191b = e;
            return this;
        }

        /* renamed from: a */
        public C1759a mo27574a(C1755F f) {
            Intrinsics.checkParameterIsNotNull(f, "request");
            this.f2190a = f;
            return this;
        }

        /* renamed from: a */
        public C1759a mo27575a(C1758I i) {
            m2578a("cacheResponse", i);
            this.f2198i = i;
            return this;
        }

        /* renamed from: a */
        public C1759a mo27576a(C0980J j) {
            this.f2196g = j;
            return this;
        }

        /* renamed from: a */
        public C1759a mo27577a(C1950x xVar) {
            this.f2194e = xVar;
            return this;
        }

        /* renamed from: a */
        public C1759a mo27578a(C1952y yVar) {
            Intrinsics.checkParameterIsNotNull(yVar, "headers");
            this.f2195f = yVar.mo28112a();
            return this;
        }

        /* renamed from: a */
        public C1759a mo27579a(String str) {
            Intrinsics.checkParameterIsNotNull(str, "message");
            this.f2193d = str;
            return this;
        }

        /* renamed from: a */
        public C1759a mo27580a(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(str2, "value");
            this.f2195f.mo28123a(str, str2);
            return this;
        }

        /* renamed from: a */
        public C1758I mo27581a() {
            if (this.f2192c >= 0) {
                C1755F f = this.f2190a;
                if (f != null) {
                    C0974E e = this.f2191b;
                    if (e != null) {
                        String str = this.f2193d;
                        if (str != null) {
                            return new C1758I(f, e, str, this.f2192c, this.f2194e, this.f2195f.mo28124a(), this.f2196g, this.f2197h, this.f2198i, this.f2199j, this.f2200k, this.f2201l, this.f2202m);
                        }
                        throw new IllegalStateException("message == null".toString());
                    }
                    throw new IllegalStateException("protocol == null".toString());
                }
                throw new IllegalStateException("request == null".toString());
            }
            StringBuilder a = C0681a.m330a("code < 0: ");
            a.append(this.f2192c);
            throw new IllegalStateException(a.toString().toString());
        }

        /* renamed from: a */
        public final void mo27582a(C1795c cVar) {
            Intrinsics.checkParameterIsNotNull(cVar, "deferredTrailers");
            this.f2202m = cVar;
        }

        /* renamed from: b */
        public final int mo27583b() {
            return this.f2192c;
        }

        /* renamed from: b */
        public C1759a mo27584b(long j) {
            this.f2200k = j;
            return this;
        }

        /* renamed from: b */
        public C1759a mo27585b(C1758I i) {
            m2578a("networkResponse", i);
            this.f2197h = i;
            return this;
        }

        /* renamed from: b */
        public C1759a mo27586b(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(str2, "value");
            this.f2195f.mo28129c(str, str2);
            return this;
        }

        /* renamed from: c */
        public C1759a mo27587c(C1758I i) {
            if (i != null) {
                if (!(i.mo27554d() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
            this.f2199j = i;
            return this;
        }
    }

    public C1758I(C1755F f, C0974E e, String str, int i, C1950x xVar, C1952y yVar, C0980J j, C1758I i2, C1758I i3, C1758I i4, long j2, long j3, C1795c cVar) {
        Intrinsics.checkParameterIsNotNull(f, "request");
        Intrinsics.checkParameterIsNotNull(e, "protocol");
        Intrinsics.checkParameterIsNotNull(str, "message");
        Intrinsics.checkParameterIsNotNull(yVar, "headers");
        this.f2177b = f;
        this.f2178c = e;
        this.f2179d = str;
        this.f2180e = i;
        this.f2181f = xVar;
        this.f2182g = yVar;
        this.f2183h = j;
        this.f2184i = i2;
        this.f2185l = i3;
        this.f2186m = i4;
        this.f2187n = j2;
        this.f2188o = j3;
        this.f2189p = cVar;
    }

    /* renamed from: a */
    public static /* synthetic */ String m2561a(C1758I i, String str, String str2, int i2) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if (i != null) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            String str3 = i.f2182g.get(str);
            return str3 != null ? str3 : str2;
        }
        throw null;
    }

    public void close() {
        C0980J j = this.f2183h;
        if (j != null) {
            j.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
    }

    @JvmName(name = "body")
    /* renamed from: d */
    public final C0980J mo27554d() {
        return this.f2183h;
    }

    @JvmName(name = "cacheControl")
    /* renamed from: h */
    public final C1921e mo27555h() {
        C1921e eVar = this.f2176a;
        if (eVar != null) {
            return eVar;
        }
        C1921e eVar2 = C1921e.f2750o;
        C1921e a = C1921e.m3295a(this.f2182g);
        this.f2176a = a;
        return a;
    }

    @JvmName(name = "cacheResponse")
    /* renamed from: i */
    public final C1758I mo27556i() {
        return this.f2185l;
    }

    /* renamed from: l */
    public final List<C1930i> mo27557l() {
        String str;
        C1952y yVar = this.f2182g;
        int i = this.f2180e;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else if (i != 407) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            str = "Proxy-Authenticate";
        }
        return C1819e.m2869a(yVar, str);
    }

    @JvmName(name = "code")
    /* renamed from: o */
    public final int mo27558o() {
        return this.f2180e;
    }

    @JvmName(name = "exchange")
    /* renamed from: p */
    public final C1795c mo27559p() {
        return this.f2189p;
    }

    @JvmName(name = "handshake")
    /* renamed from: q */
    public final C1950x mo27560q() {
        return this.f2181f;
    }

    @JvmName(name = "headers")
    /* renamed from: r */
    public final C1952y mo27561r() {
        return this.f2182g;
    }

    /* renamed from: s */
    public final boolean mo27562s() {
        int i = this.f2180e;
        return 200 <= i && 299 >= i;
    }

    @JvmName(name = "message")
    /* renamed from: t */
    public final String mo27563t() {
        return this.f2179d;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("Response{protocol=");
        a.append(this.f2178c);
        a.append(", code=");
        a.append(this.f2180e);
        a.append(", message=");
        a.append(this.f2179d);
        a.append(", url=");
        a.append(this.f2177b.mo27542g());
        a.append('}');
        return a.toString();
    }

    @JvmName(name = "networkResponse")
    /* renamed from: u */
    public final C1758I mo27565u() {
        return this.f2184i;
    }

    @JvmName(name = "priorResponse")
    /* renamed from: v */
    public final C1758I mo27566v() {
        return this.f2186m;
    }

    @JvmName(name = "protocol")
    /* renamed from: w */
    public final C0974E mo27567w() {
        return this.f2178c;
    }

    @JvmName(name = "receivedResponseAtMillis")
    /* renamed from: x */
    public final long mo27568x() {
        return this.f2188o;
    }

    @JvmName(name = "request")
    /* renamed from: y */
    public final C1755F mo27569y() {
        return this.f2177b;
    }

    @JvmName(name = "sentRequestAtMillis")
    /* renamed from: z */
    public final long mo27570z() {
        return this.f2187n;
    }
}
