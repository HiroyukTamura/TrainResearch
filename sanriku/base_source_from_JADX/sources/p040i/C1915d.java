package p040i;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Typography;
import p040i.C1746B;
import p040i.C1755F;
import p040i.C1758I;
import p040i.C1952y;
import p040i.p103M.C1764b;
import p040i.p103M.p105d.C1772c;
import p040i.p103M.p105d.C1773d;
import p040i.p103M.p105d.C1775e;
import p040i.p103M.p106e.C1788e;
import p040i.p103M.p108g.C1824j;
import p040i.p103M.p111j.C1873b;
import p040i.p103M.p112k.C1890h;
import p042j.C1015k;
import p042j.C1016z;
import p042j.C2061a;
import p042j.C2068f;
import p042j.C2071g;
import p042j.C2072h;
import p042j.C2073i;
import p042j.C2075j;
import p042j.C2085t;
import p042j.C2090x;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0004BCDEB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0018\u00010\"R\u00020\fH\u0002J\b\u0010#\u001a\u00020 H\u0016J\u0006\u0010$\u001a\u00020 J\r\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b%J\u0006\u0010&\u001a\u00020 J\b\u0010'\u001a\u00020 H\u0016J\u0017\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b,J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010-\u001a\u00020 J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0011J\u0017\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020)H\u0000¢\u0006\u0002\b1J\u0015\u00102\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b3J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u00104\u001a\u00020\u0006J\r\u00105\u001a\u00020 H\u0000¢\u0006\u0002\b6J\u0015\u00107\u001a\u00020 2\u0006\u00108\u001a\u000209H\u0000¢\u0006\u0002\b:J\u001d\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020)H\u0000¢\u0006\u0002\b>J\f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0011R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006F"}, mo21739d2 = {"Lokhttp3/Cache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "directory", "Ljava/io/File;", "maxSize", "", "(Ljava/io/File;J)V", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "(Ljava/io/File;JLokhttp3/internal/io/FileSystem;)V", "cache", "Lokhttp3/internal/cache/DiskLruCache;", "getCache$okhttp", "()Lokhttp3/internal/cache/DiskLruCache;", "()Ljava/io/File;", "hitCount", "", "isClosed", "", "()Z", "networkCount", "requestCount", "writeAbortCount", "getWriteAbortCount$okhttp", "()I", "setWriteAbortCount$okhttp", "(I)V", "writeSuccessCount", "getWriteSuccessCount$okhttp", "setWriteSuccessCount$okhttp", "abortQuietly", "", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "close", "delete", "-deprecated_directory", "evictAll", "flush", "get", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "get$okhttp", "initialize", "put", "Lokhttp3/internal/cache/CacheRequest;", "response", "put$okhttp", "remove", "remove$okhttp", "size", "trackConditionalCacheHit", "trackConditionalCacheHit$okhttp", "trackResponse", "cacheStrategy", "Lokhttp3/internal/cache/CacheStrategy;", "trackResponse$okhttp", "update", "cached", "network", "update$okhttp", "urls", "", "", "CacheResponseBody", "Companion", "Entry", "RealCacheRequest", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.d */
public final class C1915d implements Closeable, Flushable {

    /* renamed from: a */
    private final C1775e f2720a;

    /* renamed from: b */
    private int f2721b;

    /* renamed from: c */
    private int f2722c;

    /* renamed from: d */
    private int f2723d;

    /* renamed from: e */
    private int f2724e;

    /* renamed from: f */
    private int f2725f;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0007\u001a\u00020\rH\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, mo21739d2 = {"Lokhttp3/Cache$CacheResponseBody;", "Lokhttp3/ResponseBody;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "contentType", "", "contentLength", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;Ljava/lang/String;Ljava/lang/String;)V", "bodySource", "Lokio/BufferedSource;", "getSnapshot$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "", "Lokhttp3/MediaType;", "source", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: i.d$a */
    private static final class C1916a extends C0980J {

        /* renamed from: a */
        private final C2072h f2726a;

        /* renamed from: b */
        private final C1775e.C1779c f2727b;

        /* renamed from: c */
        private final String f2728c;

        /* renamed from: d */
        private final String f2729d;

        /* renamed from: i.d$a$a */
        public static final class C1917a extends C1015k {

            /* renamed from: a */
            final /* synthetic */ C1916a f2730a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1917a(C1916a aVar, C1016z zVar, C1016z zVar2) {
                super(zVar2);
                this.f2730a = aVar;
            }

            public void close() throws IOException {
                this.f2730a.mo28034d().close();
                super.close();
            }
        }

        public C1916a(C1775e.C1779c cVar, String str, String str2) {
            Intrinsics.checkParameterIsNotNull(cVar, "snapshot");
            this.f2727b = cVar;
            this.f2728c = str;
            this.f2729d = str2;
            C1016z a = cVar.mo27643a(1);
            C1917a aVar = new C1917a(this, a, a);
            Intrinsics.checkParameterIsNotNull(aVar, "$this$buffer");
            this.f2726a = new C2085t(aVar);
        }

        public long contentLength() {
            String str = this.f2729d;
            if (str != null) {
                return C1764b.m2617a(str, -1);
            }
            return -1;
        }

        public C1746B contentType() {
            String str = this.f2728c;
            if (str == null) {
                return null;
            }
            C1746B.C1747a aVar = C1746B.f2080f;
            return C1746B.C1747a.m2461b(str);
        }

        /* renamed from: d */
        public final C1775e.C1779c mo28034d() {
            return this.f2727b;
        }

        public C2072h source() {
            return this.f2726a;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo21739d2 = {"Lokhttp3/Cache$RealCacheRequest;", "Lokhttp3/internal/cache/CacheRequest;", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "body", "Lokio/Sink;", "cacheOut", "done", "", "getDone$okhttp", "()Z", "setDone$okhttp", "(Z)V", "abort", "", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: i.d$c */
    private final class C1919c implements C1772c {

        /* renamed from: a */
        private final C2090x f2743a;

        /* renamed from: b */
        private final C2090x f2744b;

        /* renamed from: c */
        private boolean f2745c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final C1775e.C1776a f2746d;

        /* renamed from: e */
        final /* synthetic */ C1915d f2747e;

        /* renamed from: i.d$c$a */
        public static final class C1920a extends C2075j {

            /* renamed from: b */
            final /* synthetic */ C1919c f2748b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1920a(C1919c cVar, C2090x xVar) {
                super(xVar);
                this.f2748b = cVar;
            }

            public void close() throws IOException {
                synchronized (this.f2748b.f2747e) {
                    if (!this.f2748b.mo28039c()) {
                        this.f2748b.mo28038a(true);
                        C1915d dVar = this.f2748b.f2747e;
                        dVar.mo28027b(dVar.mo28032h() + 1);
                        super.close();
                        this.f2748b.f2746d.mo27621b();
                    }
                }
            }
        }

        public C1919c(C1915d dVar, C1775e.C1776a aVar) {
            Intrinsics.checkParameterIsNotNull(aVar, "editor");
            this.f2747e = dVar;
            this.f2746d = aVar;
            C2090x a = aVar.mo27619a(1);
            this.f2743a = a;
            this.f2744b = new C1920a(this, a);
        }

        /* renamed from: a */
        public void mo27600a() {
            synchronized (this.f2747e) {
                if (!this.f2745c) {
                    this.f2745c = true;
                    C1915d dVar = this.f2747e;
                    dVar.mo28024a(dVar.mo28030d() + 1);
                    C1764b.m2629a((Closeable) this.f2743a);
                    try {
                        this.f2746d.mo27620a();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* renamed from: a */
        public final void mo28038a(boolean z) {
            this.f2745c = z;
        }

        /* renamed from: b */
        public C2090x mo27601b() {
            return this.f2744b;
        }

        /* renamed from: c */
        public final boolean mo28039c() {
            return this.f2745c;
        }
    }

    public C1915d(File file, long j) {
        Intrinsics.checkParameterIsNotNull(file, "directory");
        C1873b bVar = C1873b.f2650a;
        Intrinsics.checkParameterIsNotNull(file, "directory");
        Intrinsics.checkParameterIsNotNull(bVar, "fileSystem");
        this.f2720a = new C1775e(bVar, file, 201105, 2, j, C1788e.f2308h);
    }

    /* renamed from: a */
    public static final int m3267a(C2072h hVar) throws IOException {
        Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
        try {
            long g = hVar.mo29160g();
            String k = hVar.mo29171k();
            if (g >= 0 && g <= ((long) Integer.MAX_VALUE)) {
                if (!(k.length() > 0)) {
                    return (int) g;
                }
            }
            throw new IOException("expected an int but was \"" + g + k + Typography.quote);
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private static final Set<String> m3269a(C1952y yVar) {
        int size = yVar.size();
        TreeSet treeSet = null;
        for (int i = 0; i < size; i++) {
            if (StringsKt__StringsJVMKt.equals("Vary", yVar.mo28113a(i), true)) {
                String b = yVar.mo28115b(i);
                if (treeSet == null) {
                    treeSet = new TreeSet(StringsKt__StringsJVMKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
                }
                for (String str : StringsKt__StringsKt.split$default((CharSequence) b, new char[]{','}, false, 0, 6, (Object) null)) {
                    if (str != null) {
                        treeSet.add(StringsKt__StringsKt.trim((CharSequence) str).toString());
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
                continue;
            }
        }
        return treeSet != null ? treeSet : SetsKt__SetsKt.emptySet();
    }

    /* renamed from: a */
    public static final boolean m3270a(C1758I i, C1952y yVar, C1755F f) {
        Intrinsics.checkParameterIsNotNull(i, "cachedResponse");
        Intrinsics.checkParameterIsNotNull(yVar, "cachedRequest");
        Intrinsics.checkParameterIsNotNull(f, "newRequest");
        Set<String> a = m3269a(i.mo27561r());
        if ((a instanceof Collection) && a.isEmpty()) {
            return true;
        }
        for (String str : a) {
            if (!Intrinsics.areEqual((Object) yVar.mo28114a(str), (Object) f.mo27537b(str))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static final boolean m3271b(C1758I i) {
        Intrinsics.checkParameterIsNotNull(i, "$this$hasVaryAll");
        return m3269a(i.mo27561r()).contains("*");
    }

    /* renamed from: c */
    public static final C1952y m3272c(C1758I i) {
        Intrinsics.checkParameterIsNotNull(i, "$this$varyHeaders");
        C1758I u = i.mo27565u();
        if (u == null) {
            Intrinsics.throwNpe();
        }
        C1952y d = u.mo27569y().mo27539d();
        Set<String> a = m3269a(i.mo27561r());
        if (a.isEmpty()) {
            return C1764b.f2214b;
        }
        C1952y.C1953a aVar = new C1952y.C1953a();
        int size = d.size();
        for (int i2 = 0; i2 < size; i2++) {
            String a2 = d.mo28113a(i2);
            if (a.contains(a2)) {
                aVar.mo28123a(a2, d.mo28115b(i2));
            }
        }
        return aVar.mo28124a();
    }

    /* renamed from: a */
    public final C1758I mo28022a(C1755F f) {
        Intrinsics.checkParameterIsNotNull(f, "request");
        try {
            C1775e.C1779c b = this.f2720a.mo27608b(m3268a(f.mo27542g()));
            if (b != null) {
                try {
                    C1918b bVar = new C1918b(b.mo27643a(0));
                    C1758I a = bVar.mo28035a(b);
                    if (bVar.mo28037a(f, a)) {
                        return a;
                    }
                    C0980J d = a.mo27554d();
                    if (d != null) {
                        Intrinsics.checkParameterIsNotNull(d, "$this$closeQuietly");
                        try {
                            d.close();
                        } catch (RuntimeException e) {
                            throw e;
                        } catch (Exception unused) {
                        }
                    }
                    return null;
                } catch (IOException unused2) {
                    C1764b.m2629a((Closeable) b);
                }
            }
        } catch (IOException unused3) {
        }
        return null;
    }

    /* renamed from: a */
    public final void mo28024a(int i) {
        this.f2722c = i;
    }

    /* renamed from: a */
    public final synchronized void mo28026a(C1773d dVar) {
        Intrinsics.checkParameterIsNotNull(dVar, "cacheStrategy");
        this.f2725f++;
        if (dVar.mo27603b() != null) {
            this.f2723d++;
        } else if (dVar.mo27602a() != null) {
            this.f2724e++;
        }
    }

    /* renamed from: b */
    public final void mo28027b(int i) {
        this.f2721b = i;
    }

    /* renamed from: b */
    public final void mo28028b(C1755F f) throws IOException {
        Intrinsics.checkParameterIsNotNull(f, "request");
        this.f2720a.mo27609c(m3268a(f.mo27542g()));
    }

    public void close() throws IOException {
        this.f2720a.close();
    }

    /* renamed from: d */
    public final int mo28030d() {
        return this.f2722c;
    }

    public void flush() throws IOException {
        this.f2720a.flush();
    }

    /* renamed from: h */
    public final int mo28032h() {
        return this.f2721b;
    }

    /* renamed from: i */
    public final synchronized void mo28033i() {
        this.f2724e++;
    }

    /* renamed from: i.d$b */
    private static final class C1918b {

        /* renamed from: k */
        private static final String f2731k = "OkHttp-Sent-Millis";

        /* renamed from: l */
        private static final String f2732l = "OkHttp-Received-Millis";

        /* renamed from: a */
        private final String f2733a;

        /* renamed from: b */
        private final C1952y f2734b;

        /* renamed from: c */
        private final String f2735c;

        /* renamed from: d */
        private final C0974E f2736d;

        /* renamed from: e */
        private final int f2737e;

        /* renamed from: f */
        private final String f2738f;

        /* renamed from: g */
        private final C1952y f2739g;

        /* renamed from: h */
        private final C1950x f2740h;

        /* renamed from: i */
        private final long f2741i;

        /* renamed from: j */
        private final long f2742j;

        static {
            C1890h.C1891a aVar = C1890h.f2683c;
            if (C1890h.f2681a != null) {
                C1890h.C1891a aVar2 = C1890h.f2683c;
                if (C1890h.f2681a != null) {
                    return;
                }
                throw null;
            }
            throw null;
        }

        public C1918b(C1758I i) {
            Intrinsics.checkParameterIsNotNull(i, "response");
            this.f2733a = i.mo27569y().mo27542g().toString();
            this.f2734b = C1915d.m3272c(i);
            this.f2735c = i.mo27569y().mo27541f();
            this.f2736d = i.mo27567w();
            this.f2737e = i.mo27558o();
            this.f2738f = i.mo27563t();
            this.f2739g = i.mo27561r();
            this.f2740h = i.mo27560q();
            this.f2741i = i.mo27570z();
            this.f2742j = i.mo27568x();
        }

        public C1918b(C1016z zVar) throws IOException {
            Intrinsics.checkParameterIsNotNull(zVar, "rawSource");
            try {
                Intrinsics.checkParameterIsNotNull(zVar, "$this$buffer");
                C2085t tVar = new C2085t(zVar);
                this.f2733a = tVar.mo29171k();
                this.f2735c = tVar.mo29171k();
                C1952y.C1953a aVar = new C1952y.C1953a();
                int a = C1915d.m3267a((C2072h) tVar);
                boolean z = false;
                for (int i = 0; i < a; i++) {
                    aVar.mo28122a(tVar.mo29171k());
                }
                this.f2734b = aVar.mo28124a();
                C1824j a2 = C1824j.m2889a(tVar.mo29171k());
                this.f2736d = a2.f2439a;
                this.f2737e = a2.f2440b;
                this.f2738f = a2.f2441c;
                C1952y.C1953a aVar2 = new C1952y.C1953a();
                int a3 = C1915d.m3267a((C2072h) tVar);
                for (int i2 = 0; i2 < a3; i2++) {
                    aVar2.mo28122a(tVar.mo29171k());
                }
                String b = aVar2.mo28126b(f2731k);
                String b2 = aVar2.mo28126b(f2732l);
                aVar2.mo28128c(f2731k);
                aVar2.mo28128c(f2732l);
                long j = 0;
                this.f2741i = b != null ? Long.parseLong(b) : 0;
                this.f2742j = b2 != null ? Long.parseLong(b2) : j;
                this.f2739g = aVar2.mo28124a();
                if (StringsKt__StringsJVMKt.startsWith$default(this.f2733a, "https://", false, 2, (Object) null)) {
                    String k = tVar.mo29171k();
                    if (!(k.length() > 0 ? true : z)) {
                        C1931j a4 = C1931j.f2801t.mo28076a(tVar.mo29171k());
                        List<Certificate> a5 = m3284a((C2072h) tVar);
                        List<Certificate> a6 = m3284a((C2072h) tVar);
                        C1761L a7 = !tVar.mo29152c() ? C1761L.f2211g.mo27596a(tVar.mo29171k()) : C1761L.SSL_3_0;
                        Intrinsics.checkParameterIsNotNull(a7, "tlsVersion");
                        Intrinsics.checkParameterIsNotNull(a4, "cipherSuite");
                        Intrinsics.checkParameterIsNotNull(a5, "peerCertificates");
                        Intrinsics.checkParameterIsNotNull(a6, "localCertificates");
                        this.f2740h = new C1950x(a7, a4, C1764b.m2639b(a6), new C1948v(C1764b.m2639b(a5)));
                    } else {
                        throw new IOException("expected \"\" but was \"" + k + Typography.quote);
                    }
                } else {
                    this.f2740h = null;
                }
            } finally {
                zVar.close();
            }
        }

        /* renamed from: a */
        private final List<Certificate> m3284a(C2072h hVar) throws IOException {
            int a = C1915d.m3267a(hVar);
            if (a == -1) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(a);
                for (int i = 0; i < a; i++) {
                    String k = hVar.mo29171k();
                    C2068f fVar = new C2068f();
                    C2073i.C2074a aVar = C2073i.f2895e;
                    Intrinsics.checkParameterIsNotNull(k, "$this$decodeBase64");
                    byte[] a2 = C2061a.m3459a(k);
                    C2073i iVar = a2 != null ? new C2073i(a2) : null;
                    if (iVar == null) {
                        Intrinsics.throwNpe();
                    }
                    fVar.mo29137a(iVar);
                    arrayList.add(instance.generateCertificate(fVar.mo29174n()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* renamed from: a */
        private final void m3285a(C2071g gVar, List<? extends Certificate> list) throws IOException {
            try {
                gVar.mo29161g((long) list.size()).writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    byte[] encoded = ((Certificate) list.get(i)).getEncoded();
                    C2073i.C2074a aVar = C2073i.f2895e;
                    Intrinsics.checkExpressionValueIsNotNull(encoded, "bytes");
                    gVar.mo29138a(C2073i.C2074a.m3561a(aVar, encoded, 0, 0, 3).mo29203a()).writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* renamed from: a */
        public final C1758I mo28035a(C1775e.C1779c cVar) {
            Intrinsics.checkParameterIsNotNull(cVar, "snapshot");
            String str = this.f2739g.get("Content-Type");
            String str2 = this.f2739g.get("Content-Length");
            C1755F.C1756a aVar = new C1755F.C1756a();
            aVar.mo27552b(this.f2733a);
            aVar.mo27549a(this.f2735c, (C0976G) null);
            aVar.mo27545a(this.f2734b);
            C1755F a = aVar.mo27551a();
            C1758I.C1759a aVar2 = new C1758I.C1759a();
            aVar2.mo27574a(a);
            aVar2.mo27573a(this.f2736d);
            aVar2.mo27571a(this.f2737e);
            aVar2.mo27579a(this.f2738f);
            aVar2.mo27578a(this.f2739g);
            aVar2.mo27576a((C0980J) new C1916a(cVar, str, str2));
            aVar2.mo27577a(this.f2740h);
            aVar2.mo27584b(this.f2741i);
            aVar2.mo27572a(this.f2742j);
            return aVar2.mo27581a();
        }

        /* renamed from: a */
        public final boolean mo28037a(C1755F f, C1758I i) {
            Intrinsics.checkParameterIsNotNull(f, "request");
            Intrinsics.checkParameterIsNotNull(i, "response");
            return Intrinsics.areEqual((Object) this.f2733a, (Object) f.mo27542g().toString()) && Intrinsics.areEqual((Object) this.f2735c, (Object) f.mo27541f()) && C1915d.m3270a(i, this.f2734b, f);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x011b, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x011c, code lost:
            kotlin.p045io.CloseableKt.closeFinally(r9, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0120, code lost:
            throw r1;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo28036a(p040i.p103M.p105d.C1775e.C1776a r9) throws java.io.IOException {
            /*
                r8 = this;
                java.lang.String r0 = "editor"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
                r0 = 0
                j.x r9 = r9.mo27619a(r0)
                j.g r9 = p042j.C2080p.m3577a((p042j.C2090x) r9)
                java.lang.String r1 = r8.f2733a     // Catch:{ all -> 0x0119 }
                j.g r1 = r9.mo29138a((java.lang.String) r1)     // Catch:{ all -> 0x0119 }
                r2 = 10
                r1.writeByte(r2)     // Catch:{ all -> 0x0119 }
                java.lang.String r1 = r8.f2735c     // Catch:{ all -> 0x0119 }
                j.g r1 = r9.mo29138a((java.lang.String) r1)     // Catch:{ all -> 0x0119 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0119 }
                i.y r1 = r8.f2734b     // Catch:{ all -> 0x0119 }
                int r1 = r1.size()     // Catch:{ all -> 0x0119 }
                long r3 = (long) r1     // Catch:{ all -> 0x0119 }
                j.g r1 = r9.mo29161g(r3)     // Catch:{ all -> 0x0119 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0119 }
                i.y r1 = r8.f2734b     // Catch:{ all -> 0x0119 }
                int r1 = r1.size()     // Catch:{ all -> 0x0119 }
                r3 = 0
            L_0x0037:
                java.lang.String r4 = ": "
                if (r3 >= r1) goto L_0x0059
                i.y r5 = r8.f2734b     // Catch:{ all -> 0x0119 }
                java.lang.String r5 = r5.mo28113a((int) r3)     // Catch:{ all -> 0x0119 }
                j.g r5 = r9.mo29138a((java.lang.String) r5)     // Catch:{ all -> 0x0119 }
                j.g r4 = r5.mo29138a((java.lang.String) r4)     // Catch:{ all -> 0x0119 }
                i.y r5 = r8.f2734b     // Catch:{ all -> 0x0119 }
                java.lang.String r5 = r5.mo28115b(r3)     // Catch:{ all -> 0x0119 }
                j.g r4 = r4.mo29138a((java.lang.String) r5)     // Catch:{ all -> 0x0119 }
                r4.writeByte(r2)     // Catch:{ all -> 0x0119 }
                int r3 = r3 + 1
                goto L_0x0037
            L_0x0059:
                i.M.g.j r1 = new i.M.g.j     // Catch:{ all -> 0x0119 }
                i.E r3 = r8.f2736d     // Catch:{ all -> 0x0119 }
                int r5 = r8.f2737e     // Catch:{ all -> 0x0119 }
                java.lang.String r6 = r8.f2738f     // Catch:{ all -> 0x0119 }
                r1.<init>(r3, r5, r6)     // Catch:{ all -> 0x0119 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0119 }
                j.g r1 = r9.mo29138a((java.lang.String) r1)     // Catch:{ all -> 0x0119 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0119 }
                i.y r1 = r8.f2739g     // Catch:{ all -> 0x0119 }
                int r1 = r1.size()     // Catch:{ all -> 0x0119 }
                r3 = 2
                int r1 = r1 + r3
                long r5 = (long) r1     // Catch:{ all -> 0x0119 }
                j.g r1 = r9.mo29161g(r5)     // Catch:{ all -> 0x0119 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0119 }
                i.y r1 = r8.f2739g     // Catch:{ all -> 0x0119 }
                int r1 = r1.size()     // Catch:{ all -> 0x0119 }
                r5 = 0
            L_0x0086:
                if (r5 >= r1) goto L_0x00a6
                i.y r6 = r8.f2739g     // Catch:{ all -> 0x0119 }
                java.lang.String r6 = r6.mo28113a((int) r5)     // Catch:{ all -> 0x0119 }
                j.g r6 = r9.mo29138a((java.lang.String) r6)     // Catch:{ all -> 0x0119 }
                j.g r6 = r6.mo29138a((java.lang.String) r4)     // Catch:{ all -> 0x0119 }
                i.y r7 = r8.f2739g     // Catch:{ all -> 0x0119 }
                java.lang.String r7 = r7.mo28115b(r5)     // Catch:{ all -> 0x0119 }
                j.g r6 = r6.mo29138a((java.lang.String) r7)     // Catch:{ all -> 0x0119 }
                r6.writeByte(r2)     // Catch:{ all -> 0x0119 }
                int r5 = r5 + 1
                goto L_0x0086
            L_0x00a6:
                java.lang.String r1 = f2731k     // Catch:{ all -> 0x0119 }
                j.g r1 = r9.mo29138a((java.lang.String) r1)     // Catch:{ all -> 0x0119 }
                j.g r1 = r1.mo29138a((java.lang.String) r4)     // Catch:{ all -> 0x0119 }
                long r5 = r8.f2741i     // Catch:{ all -> 0x0119 }
                j.g r1 = r1.mo29161g(r5)     // Catch:{ all -> 0x0119 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0119 }
                java.lang.String r1 = f2732l     // Catch:{ all -> 0x0119 }
                j.g r1 = r9.mo29138a((java.lang.String) r1)     // Catch:{ all -> 0x0119 }
                j.g r1 = r1.mo29138a((java.lang.String) r4)     // Catch:{ all -> 0x0119 }
                long r4 = r8.f2742j     // Catch:{ all -> 0x0119 }
                j.g r1 = r1.mo29161g(r4)     // Catch:{ all -> 0x0119 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0119 }
                java.lang.String r1 = r8.f2733a     // Catch:{ all -> 0x0119 }
                java.lang.String r4 = "https://"
                r5 = 0
                boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r1, r4, r0, r3, r5)     // Catch:{ all -> 0x0119 }
                if (r0 == 0) goto L_0x0113
                r9.writeByte(r2)     // Catch:{ all -> 0x0119 }
                i.x r0 = r8.f2740h     // Catch:{ all -> 0x0119 }
                if (r0 != 0) goto L_0x00e1
                kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0119 }
            L_0x00e1:
                i.j r0 = r0.mo28105a()     // Catch:{ all -> 0x0119 }
                java.lang.String r0 = r0.mo28073a()     // Catch:{ all -> 0x0119 }
                j.g r0 = r9.mo29138a((java.lang.String) r0)     // Catch:{ all -> 0x0119 }
                r0.writeByte(r2)     // Catch:{ all -> 0x0119 }
                i.x r0 = r8.f2740h     // Catch:{ all -> 0x0119 }
                java.util.List r0 = r0.mo28107c()     // Catch:{ all -> 0x0119 }
                r8.m3285a((p042j.C2071g) r9, (java.util.List<? extends java.security.cert.Certificate>) r0)     // Catch:{ all -> 0x0119 }
                i.x r0 = r8.f2740h     // Catch:{ all -> 0x0119 }
                java.util.List r0 = r0.mo28106b()     // Catch:{ all -> 0x0119 }
                r8.m3285a((p042j.C2071g) r9, (java.util.List<? extends java.security.cert.Certificate>) r0)     // Catch:{ all -> 0x0119 }
                i.x r0 = r8.f2740h     // Catch:{ all -> 0x0119 }
                i.L r0 = r0.mo28108d()     // Catch:{ all -> 0x0119 }
                java.lang.String r0 = r0.mo27595a()     // Catch:{ all -> 0x0119 }
                j.g r0 = r9.mo29138a((java.lang.String) r0)     // Catch:{ all -> 0x0119 }
                r0.writeByte(r2)     // Catch:{ all -> 0x0119 }
            L_0x0113:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0119 }
                kotlin.p045io.CloseableKt.closeFinally(r9, r5)
                return
            L_0x0119:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x011b }
            L_0x011b:
                r1 = move-exception
                kotlin.p045io.CloseableKt.closeFinally(r9, r0)
                goto L_0x0121
            L_0x0120:
                throw r1
            L_0x0121:
                goto L_0x0120
            */
            throw new UnsupportedOperationException("Method not decompiled: p040i.C1915d.C1918b.mo28036a(i.M.d.e$a):void");
        }
    }

    @JvmStatic
    /* renamed from: a */
    public static final String m3268a(C1955z zVar) {
        Intrinsics.checkParameterIsNotNull(zVar, ImagesContract.URL);
        return C2073i.f2895e.mo29221b(zVar.toString()).mo29202a("MD5").mo29213e();
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x009d A[SYNTHETIC, Splitter:B:36:0x009d] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final p040i.p103M.p105d.C1772c mo28023a(p040i.C1758I r7) {
        /*
            r6 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            i.F r0 = r7.mo27569y()
            java.lang.String r0 = r0.mo27541f()
            i.F r1 = r7.mo27569y()
            java.lang.String r1 = r1.mo27541f()
            java.lang.String r2 = "method"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r2)
            java.lang.String r2 = "POST"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            r3 = 1
            if (r2 != 0) goto L_0x0046
            java.lang.String r2 = "PATCH"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x0046
            java.lang.String r2 = "PUT"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x0046
            java.lang.String r2 = "DELETE"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x0046
            java.lang.String r2 = "MOVE"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r1 = 0
            goto L_0x0047
        L_0x0046:
            r1 = 1
        L_0x0047:
            r2 = 0
            if (r1 == 0) goto L_0x0061
            i.F r7 = r7.mo27569y()     // Catch:{ IOException -> 0x0060 }
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)     // Catch:{ IOException -> 0x0060 }
            i.M.d.e r0 = r6.f2720a     // Catch:{ IOException -> 0x0060 }
            i.z r7 = r7.mo27542g()     // Catch:{ IOException -> 0x0060 }
            java.lang.String r7 = m3268a((p040i.C1955z) r7)     // Catch:{ IOException -> 0x0060 }
            r0.mo27609c((java.lang.String) r7)     // Catch:{ IOException -> 0x0060 }
        L_0x0060:
            return r2
        L_0x0061:
            java.lang.String r1 = "GET"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x006b
            return r2
        L_0x006b:
            boolean r0 = m3271b((p040i.C1758I) r7)
            if (r0 == 0) goto L_0x0072
            return r2
        L_0x0072:
            i.d$b r0 = new i.d$b
            r0.<init>((p040i.C1758I) r7)
            i.M.d.e r1 = r6.f2720a     // Catch:{ IOException -> 0x009a }
            i.F r7 = r7.mo27569y()     // Catch:{ IOException -> 0x009a }
            i.z r7 = r7.mo27542g()     // Catch:{ IOException -> 0x009a }
            java.lang.String r7 = m3268a((p040i.C1955z) r7)     // Catch:{ IOException -> 0x009a }
            r3 = 0
            r5 = 2
            i.M.d.e$a r7 = p040i.p103M.p105d.C1775e.m2656a(r1, r7, r3, r5)     // Catch:{ IOException -> 0x009a }
            if (r7 == 0) goto L_0x0099
            r0.mo28036a((p040i.p103M.p105d.C1775e.C1776a) r7)     // Catch:{ IOException -> 0x0097 }
            i.d$c r0 = new i.d$c     // Catch:{ IOException -> 0x0097 }
            r0.<init>(r6, r7)     // Catch:{ IOException -> 0x0097 }
            return r0
        L_0x0097:
            goto L_0x009b
        L_0x0099:
            return r2
        L_0x009a:
            r7 = r2
        L_0x009b:
            if (r7 == 0) goto L_0x00a0
            r7.mo27620a()     // Catch:{ IOException -> 0x00a0 }
        L_0x00a0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.C1915d.mo28023a(i.I):i.M.d.c");
    }

    /* renamed from: a */
    public final void mo28025a(C1758I i, C1758I i2) {
        Intrinsics.checkParameterIsNotNull(i, "cached");
        Intrinsics.checkParameterIsNotNull(i2, "network");
        C1918b bVar = new C1918b(i2);
        C0980J d = i.mo27554d();
        if (d != null) {
            C1775e.C1776a aVar = null;
            try {
                C1775e.C1776a d2 = ((C1916a) d).mo28034d().mo27645d();
                if (d2 != null) {
                    bVar.mo28036a(d2);
                    d2.mo27621b();
                }
            } catch (IOException unused) {
                if (aVar != null) {
                    try {
                        aVar.mo27620a();
                    } catch (IOException unused2) {
                    }
                }
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        }
    }
}
