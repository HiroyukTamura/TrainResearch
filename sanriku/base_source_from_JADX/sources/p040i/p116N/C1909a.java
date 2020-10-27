package p040i.p116N;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.p045io.CloseableKt;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;
import p040i.C0976G;
import p040i.C0980J;
import p040i.C1744A;
import p040i.C1746B;
import p040i.C1755F;
import p040i.C1758I;
import p040i.C1934k;
import p040i.C1952y;
import p040i.p103M.p108g.C1819e;
import p042j.C1016z;
import p042j.C2068f;
import p042j.C2072h;
import p042j.C2077m;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\r\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\n\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\bF0\u0001¨\u0006 "}, mo21739d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "headersToRedact", "", "", "<set-?>", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", "getLevel", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "bodyHasUnknownEncoding", "", "headers", "Lokhttp3/Headers;", "-deprecated_level", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "logHeader", "", "i", "", "redactHeader", "name", "setLevel", "Level", "Logger", "okhttp-logging-interceptor"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.N.a */
public final class C1909a implements C1744A {

    /* renamed from: a */
    private volatile Set<String> f2702a = SetsKt__SetsKt.emptySet();

    /* renamed from: b */
    private volatile C1910a f2703b = C1910a.NONE;

    /* renamed from: c */
    private final C1911b f2704c;

    /* renamed from: i.N.a$a */
    public enum C1910a {
        NONE,
        HEADERS,
        BODY;

        static {
            NONE = new C1910a("NONE", 0);
            new C1910a("BASIC", 1);
            HEADERS = new C1910a("HEADERS", 2);
            BODY = new C1910a("BODY", 3);
        }
    }

    /* renamed from: i.N.a$b */
    public interface C1911b {
        void log(String str);
    }

    @JvmOverloads
    public C1909a(C1911b bVar) {
        Intrinsics.checkParameterIsNotNull(bVar, "logger");
        this.f2704c = bVar;
    }

    /* renamed from: a */
    private final void m3250a(C1952y yVar, int i) {
        String b = this.f2702a.contains(yVar.mo28113a(i)) ? "██" : yVar.mo28115b(i);
        C1911b bVar = this.f2704c;
        bVar.log(yVar.mo28113a(i) + ": " + b);
    }

    /* renamed from: a */
    private final boolean m3251a(C1952y yVar) {
        String str = yVar.get("Content-Encoding");
        return str != null && !StringsKt__StringsJVMKt.equals(str, "identity", true) && !StringsKt__StringsJVMKt.equals(str, "gzip", true);
    }

    @JvmName(name = "level")
    /* renamed from: a */
    public final void mo28005a(C1910a aVar) {
        Intrinsics.checkParameterIsNotNull(aVar, "<set-?>");
        this.f2703b = aVar;
    }

    public C1758I intercept(C1744A.C1745a aVar) throws IOException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        C1911b bVar;
        Charset charset;
        String str6;
        Throwable th;
        C1911b bVar2;
        String str7;
        String str8;
        StringBuilder sb;
        C1911b bVar3;
        Charset charset2;
        StringBuilder sb2;
        C1744A.C1745a aVar2 = aVar;
        Intrinsics.checkParameterIsNotNull(aVar2, "chain");
        C1910a aVar3 = this.f2703b;
        C1755F request = aVar.request();
        if (aVar3 == C1910a.NONE) {
            return aVar2.mo27450a(request);
        }
        boolean z = aVar3 == C1910a.BODY;
        boolean z2 = z || aVar3 == C1910a.HEADERS;
        C0976G a = request.mo27533a();
        C1934k a2 = aVar.mo27451a();
        StringBuilder a3 = C0681a.m330a("--> ");
        a3.append(request.mo27541f());
        a3.append(' ');
        a3.append(request.mo27542g());
        if (a2 != null) {
            StringBuilder a4 = C0681a.m330a(" ");
            a4.append(a2.mo27740a());
            str = a4.toString();
        } else {
            str = "";
        }
        a3.append(str);
        String sb3 = a3.toString();
        if (!z2 && a != null) {
            StringBuilder c = C0681a.m340c(sb3, " (");
            c.append(a.contentLength());
            c.append("-byte body)");
            sb3 = c.toString();
        }
        this.f2704c.log(sb3);
        if (z2) {
            C1952y d = request.mo27539d();
            if (a != null) {
                C1746B contentType = a.contentType();
                if (contentType != null && d.get("Content-Type") == null) {
                    this.f2704c.log("Content-Type: " + contentType);
                }
                if (a.contentLength() != -1 && d.get("Content-Length") == null) {
                    C1911b bVar4 = this.f2704c;
                    StringBuilder a5 = C0681a.m330a("Content-Length: ");
                    a5.append(a.contentLength());
                    bVar4.log(a5.toString());
                }
            }
            int size = d.size();
            for (int i = 0; i < size; i++) {
                m3250a(d, i);
            }
            if (!z || a == null) {
                bVar3 = this.f2704c;
                sb = C0681a.m330a("--> END ");
                str8 = request.mo27541f();
            } else if (m3251a(request.mo27539d())) {
                bVar3 = this.f2704c;
                sb = C0681a.m330a("--> END ");
                sb.append(request.mo27541f());
                str8 = " (encoded body omitted)";
            } else if (a.isDuplex()) {
                bVar3 = this.f2704c;
                sb = C0681a.m330a("--> END ");
                sb.append(request.mo27541f());
                str8 = " (duplex request body omitted)";
            } else if (a.isOneShot()) {
                bVar3 = this.f2704c;
                sb = C0681a.m330a("--> END ");
                sb.append(request.mo27541f());
                str8 = " (one-shot body omitted)";
            } else {
                C2068f fVar = new C2068f();
                a.writeTo(fVar);
                C1746B contentType2 = a.contentType();
                if (contentType2 == null || (charset2 = contentType2.mo27454a(StandardCharsets.UTF_8)) == null) {
                    charset2 = StandardCharsets.UTF_8;
                    Intrinsics.checkExpressionValueIsNotNull(charset2, "UTF_8");
                }
                this.f2704c.log("");
                if (C1532a.m2143a(fVar)) {
                    this.f2704c.log(fVar.mo29144a(charset2));
                    bVar2 = this.f2704c;
                    sb2 = C0681a.m330a("--> END ");
                    sb2.append(request.mo27541f());
                    sb2.append(" (");
                    sb2.append(a.contentLength());
                    sb2.append("-byte body)");
                } else {
                    bVar2 = this.f2704c;
                    sb2 = C0681a.m330a("--> END ");
                    sb2.append(request.mo27541f());
                    sb2.append(" (binary ");
                    sb2.append(a.contentLength());
                    sb2.append("-byte body omitted)");
                }
                str7 = sb2.toString();
                bVar2.log(str7);
            }
            sb.append(str8);
            bVar2 = bVar3;
            str7 = sb.toString();
            bVar2.log(str7);
        }
        long nanoTime = System.nanoTime();
        try {
            C1758I a6 = aVar2.mo27450a(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            C0980J d2 = a6.mo27554d();
            if (d2 == null) {
                Intrinsics.throwNpe();
            }
            long contentLength = d2.contentLength();
            if (contentLength != -1) {
                str2 = contentLength + "-byte";
            } else {
                str2 = "unknown-length";
            }
            C1911b bVar5 = this.f2704c;
            String str9 = "-byte body)";
            StringBuilder a7 = C0681a.m330a("<-- ");
            long j = contentLength;
            a7.append(a6.mo27558o());
            if (a6.mo27563t().length() == 0) {
                str3 = "-byte body omitted)";
                str4 = "";
            } else {
                String t = a6.mo27563t();
                StringBuilder sb4 = new StringBuilder();
                str3 = "-byte body omitted)";
                sb4.append(String.valueOf(' '));
                sb4.append(t);
                str4 = sb4.toString();
            }
            a7.append(str4);
            a7.append(' ');
            a7.append(a6.mo27569y().mo27542g());
            a7.append(" (");
            a7.append(millis);
            a7.append("ms");
            a7.append(!z2 ? C0681a.m321a(", ", str2, " body") : "");
            a7.append(')');
            bVar5.log(a7.toString());
            if (z2) {
                C1952y r = a6.mo27561r();
                int size2 = r.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    m3250a(r, i2);
                }
                if (!z || !C1819e.m2872a(a6)) {
                    bVar = this.f2704c;
                    str5 = "<-- END HTTP";
                } else if (m3251a(a6.mo27561r())) {
                    bVar = this.f2704c;
                    str5 = "<-- END HTTP (encoded body omitted)";
                } else {
                    C2072h source = d2.source();
                    source.mo29155d(LongCompanionObject.MAX_VALUE);
                    C2068f buffer = source.getBuffer();
                    Long l = null;
                    if (StringsKt__StringsJVMKt.equals("gzip", r.get("Content-Encoding"), true)) {
                        Long valueOf = Long.valueOf(buffer.size());
                        C2077m mVar = new C2077m(buffer.clone());
                        try {
                            buffer = new C2068f();
                            buffer.mo29135a((C1016z) mVar);
                            CloseableKt.closeFinally(mVar, (Throwable) null);
                            l = valueOf;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            CloseableKt.closeFinally(mVar, th);
                            throw th3;
                        }
                    }
                    C1746B contentType3 = d2.contentType();
                    if (contentType3 == null || (charset = contentType3.mo27454a(StandardCharsets.UTF_8)) == null) {
                        charset = StandardCharsets.UTF_8;
                        Intrinsics.checkExpressionValueIsNotNull(charset, "UTF_8");
                    }
                    if (!C1532a.m2143a(buffer)) {
                        this.f2704c.log("");
                        C1911b bVar6 = this.f2704c;
                        StringBuilder a8 = C0681a.m330a("<-- END HTTP (binary ");
                        a8.append(buffer.size());
                        a8.append(str3);
                        bVar6.log(a8.toString());
                        return a6;
                    }
                    if (j != 0) {
                        this.f2704c.log("");
                        this.f2704c.log(buffer.clone().mo29144a(charset));
                    }
                    C1911b bVar7 = this.f2704c;
                    StringBuilder a9 = C0681a.m330a("<-- END HTTP (");
                    if (l != null) {
                        a9.append(buffer.size());
                        a9.append("-byte, ");
                        a9.append(l);
                        str6 = "-gzipped-byte body)";
                    } else {
                        a9.append(buffer.size());
                        str6 = str9;
                    }
                    a9.append(str6);
                    bVar7.log(a9.toString());
                }
                bVar.log(str5);
            }
            return a6;
        } catch (Exception e) {
            Exception exc = e;
            this.f2704c.log("<-- HTTP FAILED: " + exc);
            throw exc;
        }
    }
}
