package p040i;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p040i.C1746B;
import p040i.p103M.C1764b;
import p042j.C2071g;
import p042j.C2073i;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000f"}, mo21739d2 = {"Lokhttp3/RequestBody;", "", "()V", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "isDuplex", "", "isOneShot", "writeTo", "", "sink", "Lokio/BufferedSink;", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.G */
public abstract class C0976G {
    public static final C0977a Companion = new C0977a((DefaultConstructorMarker) null);

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u000eH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u000fH\u0007J\u001d\u0010\u0010\u001a\u00020\u0004*\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J1\u0010\u0011\u001a\u00020\u0004*\u00020\n2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u0011\u001a\u00020\u0004*\u00020\u000e2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J\u001d\u0010\u0011\u001a\u00020\u0004*\u00020\u000f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003¨\u0006\u0012"}, mo21739d2 = {"Lokhttp3/RequestBody$Companion;", "", "()V", "create", "Lokhttp3/RequestBody;", "contentType", "Lokhttp3/MediaType;", "file", "Ljava/io/File;", "content", "", "offset", "", "byteCount", "", "Lokio/ByteString;", "asRequestBody", "toRequestBody", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: i.G$a */
    public static final class C0977a {

        /* renamed from: i.G$a$a */
        public static final class C0978a extends C0976G {

            /* renamed from: a */
            final /* synthetic */ File f701a;

            /* renamed from: b */
            final /* synthetic */ C1746B f702b;

            C0978a(File file, C1746B b) {
                this.f701a = file;
                this.f702b = b;
            }

            public long contentLength() {
                return this.f701a.length();
            }

            public C1746B contentType() {
                return this.f702b;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
                throw r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
                r1 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
                kotlin.p045io.CloseableKt.closeFinally(r0, r3);
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void writeTo(p042j.C2071g r3) {
                /*
                    r2 = this;
                    java.lang.String r0 = "sink"
                    kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
                    java.io.File r0 = r2.f701a
                    j.z r0 = p042j.C2080p.m3585b((java.io.File) r0)
                    r3.mo29135a((p042j.C1016z) r0)     // Catch:{ all -> 0x0013 }
                    r3 = 0
                    kotlin.p045io.CloseableKt.closeFinally(r0, r3)
                    return
                L_0x0013:
                    r3 = move-exception
                    throw r3     // Catch:{ all -> 0x0015 }
                L_0x0015:
                    r1 = move-exception
                    kotlin.p045io.CloseableKt.closeFinally(r0, r3)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: p040i.C0976G.C0977a.C0978a.writeTo(j.g):void");
            }
        }

        /* renamed from: i.G$a$b */
        public static final class C0979b extends C0976G {

            /* renamed from: a */
            final /* synthetic */ byte[] f703a;

            /* renamed from: b */
            final /* synthetic */ C1746B f704b;

            /* renamed from: c */
            final /* synthetic */ int f705c;

            /* renamed from: d */
            final /* synthetic */ int f706d;

            C0979b(byte[] bArr, C1746B b, int i, int i2) {
                this.f703a = bArr;
                this.f704b = b;
                this.f705c = i;
                this.f706d = i2;
            }

            public long contentLength() {
                return (long) this.f705c;
            }

            public C1746B contentType() {
                return this.f704b;
            }

            public void writeTo(C2071g gVar) {
                Intrinsics.checkParameterIsNotNull(gVar, "sink");
                gVar.write(this.f703a, this.f706d, this.f705c);
            }
        }

        public /* synthetic */ C0977a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public static /* synthetic */ C0976G m1376a(C0977a aVar, C1746B b, byte[] bArr, int i, int i2, int i3) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            if (aVar != null) {
                Intrinsics.checkParameterIsNotNull(bArr, FirebaseAnalytics.Param.CONTENT);
                return aVar.mo20406a(bArr, b, i, i2);
            }
            throw null;
        }

        /* renamed from: a */
        public static /* synthetic */ C0976G m1377a(C0977a aVar, byte[] bArr, C1746B b, int i, int i2, int i3) {
            if ((i3 & 1) != 0) {
                b = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return aVar.mo20406a(bArr, b, i, i2);
        }

        @JvmStatic
        @JvmName(name = "create")
        /* renamed from: a */
        public final C0976G mo20404a(File file, C1746B b) {
            Intrinsics.checkParameterIsNotNull(file, "$this$asRequestBody");
            return new C0978a(file, b);
        }

        @JvmStatic
        @JvmName(name = "create")
        /* renamed from: a */
        public final C0976G mo20405a(String str, C1746B b) {
            Intrinsics.checkParameterIsNotNull(str, "$this$toRequestBody");
            Charset charset = Charsets.UTF_8;
            if (b != null && (charset = C1746B.m2455a(b, (Charset) null, 1)) == null) {
                charset = Charsets.UTF_8;
                C1746B.C1747a aVar = C1746B.f2080f;
                b = C1746B.C1747a.m2461b(b + "; charset=utf-8");
            }
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            return mo20406a(bytes, b, 0, bytes.length);
        }

        @JvmStatic
        @JvmOverloads
        @JvmName(name = "create")
        /* renamed from: a */
        public final C0976G mo20406a(byte[] bArr, C1746B b, int i, int i2) {
            Intrinsics.checkParameterIsNotNull(bArr, "$this$toRequestBody");
            C1764b.m2627a((long) bArr.length, (long) i, (long) i2);
            return new C0979b(bArr, b, i2, i);
        }
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmOverloads
    public static final C0976G create(C1746B b, byte[] bArr) {
        return C0977a.m1376a(Companion, b, bArr, 0, 0, 12);
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmOverloads
    public static final C0976G create(C1746B b, byte[] bArr, int i) {
        return C0977a.m1376a(Companion, b, bArr, i, 0, 8);
    }

    @JvmStatic
    @JvmName(name = "create")
    public static final C0976G create(File file, C1746B b) {
        if (Companion != null) {
            Intrinsics.checkParameterIsNotNull(file, "$this$asRequestBody");
            return new C0977a.C0978a(file, b);
        }
        throw null;
    }

    @JvmStatic
    @JvmName(name = "create")
    public static final C0976G create(String str, C1746B b) {
        return Companion.mo20405a(str, b);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName(name = "create")
    public static final C0976G create(byte[] bArr) {
        return C0977a.m1377a(Companion, bArr, (C1746B) null, 0, 0, 7);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName(name = "create")
    public static final C0976G create(byte[] bArr, C1746B b) {
        return C0977a.m1377a(Companion, bArr, b, 0, 0, 6);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName(name = "create")
    public static final C0976G create(byte[] bArr, C1746B b, int i) {
        return C0977a.m1377a(Companion, bArr, b, i, 0, 4);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName(name = "create")
    public static final C0976G create(byte[] bArr, C1746B b, int i, int i2) {
        return Companion.mo20406a(bArr, b, i, i2);
    }

    public long contentLength() throws IOException {
        return -1;
    }

    public abstract C1746B contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(C2071g gVar) throws IOException;

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
    public static final C0976G create(C1746B b, File file) {
        if (Companion != null) {
            Intrinsics.checkParameterIsNotNull(file, "file");
            Intrinsics.checkParameterIsNotNull(file, "$this$asRequestBody");
            return new C0977a.C0978a(file, b);
        }
        throw null;
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    public static final C0976G create(C1746B b, String str) {
        C0977a aVar = Companion;
        if (aVar != null) {
            Intrinsics.checkParameterIsNotNull(str, FirebaseAnalytics.Param.CONTENT);
            return aVar.mo20405a(str, b);
        }
        throw null;
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    public static final C0976G create(C1746B b, C2073i iVar) {
        if (Companion != null) {
            Intrinsics.checkParameterIsNotNull(iVar, FirebaseAnalytics.Param.CONTENT);
            Intrinsics.checkParameterIsNotNull(iVar, "$this$toRequestBody");
            return new C1757H(iVar, b);
        }
        throw null;
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmOverloads
    public static final C0976G create(C1746B b, byte[] bArr, int i, int i2) {
        C0977a aVar = Companion;
        if (aVar != null) {
            Intrinsics.checkParameterIsNotNull(bArr, FirebaseAnalytics.Param.CONTENT);
            return aVar.mo20406a(bArr, b, i, i2);
        }
        throw null;
    }

    @JvmStatic
    @JvmName(name = "create")
    public static final C0976G create(C2073i iVar, C1746B b) {
        if (Companion != null) {
            Intrinsics.checkParameterIsNotNull(iVar, "$this$toRequestBody");
            return new C1757H(iVar, b);
        }
        throw null;
    }
}
