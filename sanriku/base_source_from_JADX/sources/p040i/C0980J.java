package p040i;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p040i.C1746B;
import p040i.p103M.C1764b;
import p042j.C2068f;
import p042j.C2072h;
import p042j.C2073i;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J@\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002H\u00110\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00170\u0014H\b¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\b\u0010\u001d\u001a\u00020\u0015H&J\u0006\u0010\u001e\u001a\u00020\u001fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo21739d2 = {"Lokhttp3/ResponseBody;", "Ljava/io/Closeable;", "()V", "reader", "Ljava/io/Reader;", "byteStream", "Ljava/io/InputStream;", "byteString", "Lokio/ByteString;", "bytes", "", "charStream", "charset", "Ljava/nio/charset/Charset;", "close", "", "consumeSource", "T", "", "consumer", "Lkotlin/Function1;", "Lokio/BufferedSource;", "sizeMapper", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "source", "string", "", "BomAwareReader", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.J */
public abstract class C0980J implements Closeable {
    public static final C0981b Companion = new C0981b((DefaultConstructorMarker) null);
    private Reader reader;

    /* renamed from: i.J$a */
    public static final class C0983a extends Reader {

        /* renamed from: a */
        private boolean f710a;

        /* renamed from: b */
        private Reader f711b;

        /* renamed from: c */
        private final C2072h f712c;

        /* renamed from: d */
        private final Charset f713d;

        public C0983a(C2072h hVar, Charset charset) {
            Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
            Intrinsics.checkParameterIsNotNull(charset, "charset");
            this.f712c = hVar;
            this.f713d = charset;
        }

        public void close() throws IOException {
            this.f710a = true;
            Reader reader = this.f711b;
            if (reader != null) {
                reader.close();
            } else {
                this.f712c.close();
            }
        }

        public int read(char[] cArr, int i, int i2) throws IOException {
            Intrinsics.checkParameterIsNotNull(cArr, "cbuf");
            if (!this.f710a) {
                Reader reader = this.f711b;
                if (reader == null) {
                    reader = new InputStreamReader(this.f712c.mo29174n(), C1764b.m2623a(this.f712c, this.f713d));
                    this.f711b = reader;
                }
                return reader.read(cArr, i, i2);
            }
            throw new IOException("Stream closed");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.mo27454a(kotlin.text.Charsets.UTF_8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.nio.charset.Charset charset() {
        /*
            r2 = this;
            i.B r0 = r2.contentType()
            if (r0 == 0) goto L_0x000f
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8
            java.nio.charset.Charset r0 = r0.mo27454a((java.nio.charset.Charset) r1)
            if (r0 == 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.C0980J.charset():java.nio.charset.Charset");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.p045io.CloseableKt.closeFinally(r2, r6);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> T consumeSource(kotlin.jvm.functions.Function1<? super p042j.C2072h, ? extends T> r6, kotlin.jvm.functions.Function1<? super T, java.lang.Integer> r7) {
        /*
            r5 = this;
            long r0 = r5.contentLength()
            r2 = 2147483647(0x7fffffff, float:NaN)
            long r2 = (long) r2
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0067
            j.h r2 = r5.source()
            r3 = 0
            r4 = 1
            java.lang.Object r6 = r6.invoke(r2)     // Catch:{ all -> 0x005a }
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            kotlin.p045io.CloseableKt.closeFinally(r2, r3)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            java.lang.Object r7 = r7.invoke(r6)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0059
            long r2 = (long) r7
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0035
            goto L_0x0059
        L_0x0035:
            java.io.IOException r6 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Content-Length ("
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ") and stream length ("
            r2.append(r0)
            r2.append(r7)
            java.lang.String r7 = ") disagree"
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r6.<init>(r7)
            throw r6
        L_0x0059:
            return r6
        L_0x005a:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x005c }
        L_0x005c:
            r7 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            kotlin.p045io.CloseableKt.closeFinally(r2, r6)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            throw r7
        L_0x0067:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r7 = "Cannot buffer entire body for content length: "
            java.lang.String r7 = p009e.p010a.p011a.p012a.C0681a.m318a((java.lang.String) r7, (long) r0)
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.C0980J.consumeSource(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
    public static final C0980J create(C1746B b, long j, C2072h hVar) {
        if (Companion != null) {
            Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.CONTENT);
            Intrinsics.checkParameterIsNotNull(hVar, "$this$asResponseBody");
            return new C0981b.C0982a(hVar, b, j);
        }
        throw null;
    }

    @JvmStatic
    @JvmName(name = "create")
    public static final C0980J create(C2073i iVar, C1746B b) {
        return Companion.mo20417a(iVar, b);
    }

    @JvmStatic
    @JvmName(name = "create")
    public static final C0980J create(String str, C1746B b) {
        return Companion.mo20418a(str, b);
    }

    @JvmStatic
    @JvmName(name = "create")
    public static final C0980J create(byte[] bArr, C1746B b) {
        return Companion.mo20419a(bArr, b);
    }

    public final InputStream byteStream() {
        return source().mo29174n();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final p042j.C2073i byteString() throws java.io.IOException {
        /*
            r7 = this;
            long r0 = r7.contentLength()
            r2 = 2147483647(0x7fffffff, float:NaN)
            long r2 = (long) r2
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0054
            j.h r2 = r7.source()
            r3 = 0
            j.i r4 = r2.mo29169j()     // Catch:{ all -> 0x004d }
            kotlin.p045io.CloseableKt.closeFinally(r2, r3)
            int r2 = r4.mo29212d()
            r5 = -1
            int r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x004c
            long r5 = (long) r2
            int r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x0028
            goto L_0x004c
        L_0x0028:
            java.io.IOException r3 = new java.io.IOException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Content-Length ("
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = ") and stream length ("
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = ") disagree"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            throw r3
        L_0x004c:
            return r4
        L_0x004d:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x004f }
        L_0x004f:
            r1 = move-exception
            kotlin.p045io.CloseableKt.closeFinally(r2, r0)
            throw r1
        L_0x0054:
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Cannot buffer entire body for content length: "
            java.lang.String r0 = p009e.p010a.p011a.p012a.C0681a.m318a((java.lang.String) r3, (long) r0)
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.C0980J.byteString():j.i");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] bytes() throws java.io.IOException {
        /*
            r7 = this;
            long r0 = r7.contentLength()
            r2 = 2147483647(0x7fffffff, float:NaN)
            long r2 = (long) r2
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0051
            j.h r2 = r7.source()
            r3 = 0
            byte[] r4 = r2.mo29149b()     // Catch:{ all -> 0x004a }
            kotlin.p045io.CloseableKt.closeFinally(r2, r3)
            int r2 = r4.length
            r5 = -1
            int r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0049
            long r5 = (long) r2
            int r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x0025
            goto L_0x0049
        L_0x0025:
            java.io.IOException r3 = new java.io.IOException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Content-Length ("
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = ") and stream length ("
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = ") disagree"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            throw r3
        L_0x0049:
            return r4
        L_0x004a:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r1 = move-exception
            kotlin.p045io.CloseableKt.closeFinally(r2, r0)
            throw r1
        L_0x0051:
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Cannot buffer entire body for content length: "
            java.lang.String r0 = p009e.p010a.p011a.p012a.C0681a.m318a((java.lang.String) r3, (long) r0)
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.C0980J.bytes():byte[]");
    }

    public final Reader charStream() {
        Reader reader2 = this.reader;
        if (reader2 != null) {
            return reader2;
        }
        C0983a aVar = new C0983a(source(), charset());
        this.reader = aVar;
        return aVar;
    }

    public void close() {
        C1764b.m2629a((Closeable) source());
    }

    public abstract long contentLength();

    public abstract C1746B contentType();

    public abstract C2072h source();

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r0, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String string() throws java.io.IOException {
        /*
            r3 = this;
            j.h r0 = r3.source()
            java.nio.charset.Charset r1 = r3.charset()     // Catch:{ all -> 0x0015 }
            java.nio.charset.Charset r1 = p040i.p103M.C1764b.m2623a((p042j.C2072h) r0, (java.nio.charset.Charset) r1)     // Catch:{ all -> 0x0015 }
            java.lang.String r1 = r0.mo29144a((java.nio.charset.Charset) r1)     // Catch:{ all -> 0x0015 }
            r2 = 0
            kotlin.p045io.CloseableKt.closeFinally(r0, r2)
            return r1
        L_0x0015:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0017 }
        L_0x0017:
            r2 = move-exception
            kotlin.p045io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.C0980J.string():java.lang.String");
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000bH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\fH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\rH\u0007J'\u0010\u000e\u001a\u00020\u0004*\u00020\u000b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\r2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003¨\u0006\u0010"}, mo21739d2 = {"Lokhttp3/ResponseBody$Companion;", "", "()V", "create", "Lokhttp3/ResponseBody;", "contentType", "Lokhttp3/MediaType;", "content", "", "contentLength", "", "Lokio/BufferedSource;", "", "Lokio/ByteString;", "asResponseBody", "toResponseBody", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: i.J$b */
    public static final class C0981b {

        /* renamed from: i.J$b$a */
        public static final class C0982a extends C0980J {

            /* renamed from: a */
            final /* synthetic */ C2072h f707a;

            /* renamed from: b */
            final /* synthetic */ C1746B f708b;

            /* renamed from: c */
            final /* synthetic */ long f709c;

            C0982a(C2072h hVar, C1746B b, long j) {
                this.f707a = hVar;
                this.f708b = b;
                this.f709c = j;
            }

            public long contentLength() {
                return this.f709c;
            }

            public C1746B contentType() {
                return this.f708b;
            }

            public C2072h source() {
                return this.f707a;
            }
        }

        public /* synthetic */ C0981b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        @JvmName(name = "create")
        /* renamed from: a */
        public final C0980J mo20416a(C2072h hVar, C1746B b, long j) {
            Intrinsics.checkParameterIsNotNull(hVar, "$this$asResponseBody");
            return new C0982a(hVar, b, j);
        }

        @JvmStatic
        @JvmName(name = "create")
        /* renamed from: a */
        public final C0980J mo20418a(String str, C1746B b) {
            Intrinsics.checkParameterIsNotNull(str, "$this$toResponseBody");
            Charset charset = Charsets.UTF_8;
            if (b != null && (charset = C1746B.m2455a(b, (Charset) null, 1)) == null) {
                charset = Charsets.UTF_8;
                C1746B.C1747a aVar = C1746B.f2080f;
                b = C1746B.C1747a.m2461b(b + "; charset=utf-8");
            }
            C2068f fVar = new C2068f();
            Intrinsics.checkParameterIsNotNull(str, "string");
            Intrinsics.checkParameterIsNotNull(charset, "charset");
            fVar.mo29140a(str, 0, str.length(), charset);
            return mo20416a(fVar, b, fVar.size());
        }

        @JvmStatic
        @JvmName(name = "create")
        /* renamed from: a */
        public final C0980J mo20417a(C2073i iVar, C1746B b) {
            Intrinsics.checkParameterIsNotNull(iVar, "$this$toResponseBody");
            C2068f fVar = new C2068f();
            fVar.mo29137a(iVar);
            Intrinsics.checkParameterIsNotNull(fVar, "$this$asResponseBody");
            return new C0982a(fVar, b, (long) iVar.mo29212d());
        }

        @JvmStatic
        @JvmName(name = "create")
        /* renamed from: a */
        public final C0980J mo20419a(byte[] bArr, C1746B b) {
            Intrinsics.checkParameterIsNotNull(bArr, "$this$toResponseBody");
            C2068f fVar = new C2068f();
            fVar.write(bArr);
            Intrinsics.checkParameterIsNotNull(fVar, "$this$asResponseBody");
            return new C0982a(fVar, b, (long) bArr.length);
        }
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    public static final C0980J create(C1746B b, String str) {
        C0981b bVar = Companion;
        if (bVar != null) {
            Intrinsics.checkParameterIsNotNull(str, FirebaseAnalytics.Param.CONTENT);
            return bVar.mo20418a(str, b);
        }
        throw null;
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    public static final C0980J create(C1746B b, C2073i iVar) {
        C0981b bVar = Companion;
        if (bVar != null) {
            Intrinsics.checkParameterIsNotNull(iVar, FirebaseAnalytics.Param.CONTENT);
            return bVar.mo20417a(iVar, b);
        }
        throw null;
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    public static final C0980J create(C1746B b, byte[] bArr) {
        C0981b bVar = Companion;
        if (bVar != null) {
            Intrinsics.checkParameterIsNotNull(bArr, FirebaseAnalytics.Param.CONTENT);
            return bVar.mo20419a(bArr, b);
        }
        throw null;
    }

    @JvmStatic
    @JvmName(name = "create")
    public static final C0980J create(C2072h hVar, C1746B b, long j) {
        if (Companion != null) {
            Intrinsics.checkParameterIsNotNull(hVar, "$this$asResponseBody");
            return new C0981b.C0982a(hVar, b, j);
        }
        throw null;
    }
}
