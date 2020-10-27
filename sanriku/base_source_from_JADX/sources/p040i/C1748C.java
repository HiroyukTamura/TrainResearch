package p040i;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import p040i.C1746B;
import p040i.C1952y;
import p040i.p103M.C1764b;
import p042j.C2071g;
import p042j.C2073i;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0003\"#$B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\b\u0015J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0012J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b\u0018J\r\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\b\u0019J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u001aJ\u001a\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0014¨\u0006%"}, mo21739d2 = {"Lokhttp3/MultipartBody;", "Lokhttp3/RequestBody;", "boundaryByteString", "Lokio/ByteString;", "type", "Lokhttp3/MediaType;", "parts", "", "Lokhttp3/MultipartBody$Part;", "(Lokio/ByteString;Lokhttp3/MediaType;Ljava/util/List;)V", "boundary", "", "()Ljava/lang/String;", "contentLength", "", "contentType", "()Ljava/util/List;", "size", "", "()I", "()Lokhttp3/MediaType;", "-deprecated_boundary", "part", "index", "-deprecated_parts", "-deprecated_size", "-deprecated_type", "writeOrCountBytes", "sink", "Lokio/BufferedSink;", "countBytes", "", "writeTo", "", "Builder", "Companion", "Part", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.C */
public final class C1748C extends C0976G {
    @JvmField

    /* renamed from: f */
    public static final C1746B f2084f = C1746B.C1747a.m2460a("multipart/mixed");
    @JvmField

    /* renamed from: g */
    public static final C1746B f2085g = C1746B.C1747a.m2460a("multipart/form-data");

    /* renamed from: h */
    private static final byte[] f2086h = {(byte) 58, (byte) 32};

    /* renamed from: i */
    private static final byte[] f2087i = {(byte) 13, (byte) 10};

    /* renamed from: j */
    private static final byte[] f2088j;

    /* renamed from: k */
    public static final C1750b f2089k = new C1750b((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final C1746B f2090a = C1746B.C1747a.m2460a(this.f2093d + "; boundary=" + this.f2092c.mo29217h());

    /* renamed from: b */
    private long f2091b = -1;

    /* renamed from: c */
    private final C2073i f2092c;

    /* renamed from: d */
    private final C1746B f2093d;

    /* renamed from: e */
    private final List<C1751c> f2094e;

    /* renamed from: i.C$a */
    public static final class C1749a {

        /* renamed from: a */
        private final C2073i f2095a;

        /* renamed from: b */
        private C1746B f2096b = C1748C.f2084f;

        /* renamed from: c */
        private final List<C1751c> f2097c = new ArrayList();

        @JvmOverloads
        public C1749a() {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
            Intrinsics.checkParameterIsNotNull(uuid, "boundary");
            this.f2095a = C2073i.f2895e.mo29221b(uuid);
        }

        /* renamed from: a */
        public final C1749a mo27458a(C1746B b) {
            Intrinsics.checkParameterIsNotNull(b, "type");
            if (Intrinsics.areEqual((Object) b.mo27453a(), (Object) "multipart")) {
                this.f2096b = b;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + b).toString());
        }

        /* renamed from: a */
        public final C1749a mo27459a(C1751c cVar) {
            Intrinsics.checkParameterIsNotNull(cVar, "part");
            this.f2097c.add(cVar);
            return this;
        }

        /* renamed from: a */
        public final C1748C mo27460a() {
            if (!this.f2097c.isEmpty()) {
                return new C1748C(this.f2095a, this.f2096b, C1764b.m2639b(this.f2097c));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }
    }

    /* renamed from: i.C$b */
    public static final class C1750b {
        public /* synthetic */ C1750b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final void mo27461a(StringBuilder sb, String str) {
            String str2;
            Intrinsics.checkParameterIsNotNull(sb, "$this$appendQuotedString");
            Intrinsics.checkParameterIsNotNull(str, "key");
            sb.append(Typography.quote);
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt == 10) {
                    str2 = "%0A";
                } else if (charAt == 13) {
                    str2 = "%0D";
                } else if (charAt == '\"') {
                    str2 = "%22";
                } else {
                    sb.append(charAt);
                }
                sb.append(str2);
            }
            sb.append(Typography.quote);
        }
    }

    /* renamed from: i.C$c */
    public static final class C1751c {

        /* renamed from: a */
        private final C1952y f2098a;

        /* renamed from: b */
        private final C0976G f2099b;

        public /* synthetic */ C1751c(C1952y yVar, C0976G g, DefaultConstructorMarker defaultConstructorMarker) {
            this.f2098a = yVar;
            this.f2099b = g;
        }

        @JvmStatic
        /* renamed from: a */
        public static final C1751c m2467a(C1952y yVar, C0976G g) {
            Intrinsics.checkParameterIsNotNull(g, "body");
            boolean z = true;
            if ((yVar != null ? yVar.get("Content-Type") : null) == null) {
                if ((yVar != null ? yVar.get("Content-Length") : null) != null) {
                    z = false;
                }
                if (z) {
                    return new C1751c(yVar, g, (DefaultConstructorMarker) null);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            }
            throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
        }

        @JvmStatic
        /* renamed from: a */
        public static final C1751c m2468a(String str, String str2, C0976G g) {
            Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(g, "body");
            StringBuilder sb = new StringBuilder();
            sb.append("form-data; name=");
            C1748C.f2089k.mo27461a(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                C1748C.f2089k.mo27461a(sb, str2);
            }
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
            C1952y.C1953a aVar = new C1952y.C1953a();
            Intrinsics.checkParameterIsNotNull("Content-Disposition", AppMeasurementSdk.ConditionalUserProperty.NAME);
            Intrinsics.checkParameterIsNotNull(sb2, "value");
            C1952y.f2848b.m3384a("Content-Disposition");
            aVar.mo28125b("Content-Disposition", sb2);
            return m2467a(aVar.mo28124a(), g);
        }

        @JvmName(name = "body")
        /* renamed from: a */
        public final C0976G mo27462a() {
            return this.f2099b;
        }

        @JvmName(name = "headers")
        /* renamed from: b */
        public final C1952y mo27463b() {
            return this.f2098a;
        }
    }

    static {
        C1746B.C1747a aVar = C1746B.f2080f;
        C1746B.C1747a aVar2 = C1746B.f2080f;
        C1746B.C1747a.m2460a("multipart/alternative");
        C1746B.C1747a aVar3 = C1746B.f2080f;
        C1746B.C1747a.m2460a("multipart/digest");
        C1746B.C1747a aVar4 = C1746B.f2080f;
        C1746B.C1747a.m2460a("multipart/parallel");
        C1746B.C1747a aVar5 = C1746B.f2080f;
        byte b = (byte) 45;
        f2088j = new byte[]{b, b};
    }

    public C1748C(C2073i iVar, C1746B b, List<C1751c> list) {
        Intrinsics.checkParameterIsNotNull(iVar, "boundaryByteString");
        Intrinsics.checkParameterIsNotNull(b, "type");
        Intrinsics.checkParameterIsNotNull(list, "parts");
        this.f2092c = iVar;
        this.f2093d = b;
        this.f2094e = list;
        C1746B.C1747a aVar = C1746B.f2080f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: j.g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: j.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: j.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: j.g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: j.f} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long m2462a(p042j.C2071g r13, boolean r14) throws java.io.IOException {
        /*
            r12 = this;
            if (r14 == 0) goto L_0x0009
            j.f r13 = new j.f
            r13.<init>()
            r0 = r13
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.util.List<i.C$c> r1 = r12.f2094e
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r5 = 0
        L_0x0014:
            if (r5 >= r1) goto L_0x00b4
            java.util.List<i.C$c> r6 = r12.f2094e
            java.lang.Object r6 = r6.get(r5)
            i.C$c r6 = (p040i.C1748C.C1751c) r6
            i.y r7 = r6.mo27463b()
            i.G r6 = r6.mo27462a()
            if (r13 != 0) goto L_0x002b
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x002b:
            byte[] r8 = f2088j
            r13.write(r8)
            j.i r8 = r12.f2092c
            r13.mo29137a((p042j.C2073i) r8)
            byte[] r8 = f2087i
            r13.write(r8)
            if (r7 == 0) goto L_0x0061
            int r8 = r7.size()
            r9 = 0
        L_0x0041:
            if (r9 >= r8) goto L_0x0061
            java.lang.String r10 = r7.mo28113a((int) r9)
            j.g r10 = r13.mo29138a((java.lang.String) r10)
            byte[] r11 = f2086h
            j.g r10 = r10.write(r11)
            java.lang.String r11 = r7.mo28115b(r9)
            j.g r10 = r10.mo29138a((java.lang.String) r11)
            byte[] r11 = f2087i
            r10.write(r11)
            int r9 = r9 + 1
            goto L_0x0041
        L_0x0061:
            i.B r7 = r6.contentType()
            if (r7 == 0) goto L_0x007a
            java.lang.String r8 = "Content-Type: "
            j.g r8 = r13.mo29138a((java.lang.String) r8)
            java.lang.String r7 = r7.toString()
            j.g r7 = r8.mo29138a((java.lang.String) r7)
            byte[] r8 = f2087i
            r7.write(r8)
        L_0x007a:
            long r7 = r6.contentLength()
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x0094
            java.lang.String r9 = "Content-Length: "
            j.g r9 = r13.mo29138a((java.lang.String) r9)
            j.g r9 = r9.mo29161g(r7)
            byte[] r10 = f2087i
            r9.write(r10)
            goto L_0x009f
        L_0x0094:
            if (r14 == 0) goto L_0x009f
            if (r0 != 0) goto L_0x009b
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x009b:
            r0.mo29154d()
            return r9
        L_0x009f:
            byte[] r9 = f2087i
            r13.write(r9)
            if (r14 == 0) goto L_0x00a8
            long r3 = r3 + r7
            goto L_0x00ab
        L_0x00a8:
            r6.writeTo(r13)
        L_0x00ab:
            byte[] r6 = f2087i
            r13.write(r6)
            int r5 = r5 + 1
            goto L_0x0014
        L_0x00b4:
            if (r13 != 0) goto L_0x00b9
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00b9:
            byte[] r1 = f2088j
            r13.write(r1)
            j.i r1 = r12.f2092c
            r13.mo29137a((p042j.C2073i) r1)
            byte[] r1 = f2088j
            r13.write(r1)
            byte[] r1 = f2087i
            r13.write(r1)
            if (r14 == 0) goto L_0x00dc
            if (r0 != 0) goto L_0x00d4
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00d4:
            long r13 = r0.size()
            long r3 = r3 + r13
            r0.mo29154d()
        L_0x00dc:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.C1748C.m2462a(j.g, boolean):long");
    }

    public long contentLength() throws IOException {
        long j = this.f2091b;
        if (j != -1) {
            return j;
        }
        long a = m2462a((C2071g) null, true);
        this.f2091b = a;
        return a;
    }

    public C1746B contentType() {
        return this.f2090a;
    }

    public void writeTo(C2071g gVar) throws IOException {
        Intrinsics.checkParameterIsNotNull(gVar, "sink");
        m2462a(gVar, false);
    }
}
