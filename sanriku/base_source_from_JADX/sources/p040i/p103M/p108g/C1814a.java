package p040i.p103M.p108g;

import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import p040i.C0976G;
import p040i.C0980J;
import p040i.C1744A;
import p040i.C1746B;
import p040i.C1755F;
import p040i.C1758I;
import p040i.C1937n;
import p040i.C1939p;
import p040i.C1952y;
import p040i.p103M.C1764b;
import p042j.C2077m;
import p042j.C2085t;

/* renamed from: i.M.g.a */
public final class C1814a implements C1744A {

    /* renamed from: a */
    private final C1939p f2419a;

    public C1814a(C1939p pVar) {
        Intrinsics.checkParameterIsNotNull(pVar, "cookieJar");
        this.f2419a = pVar;
    }

    public C1758I intercept(C1744A.C1745a aVar) throws IOException {
        boolean z;
        C0980J d;
        C1744A.C1745a aVar2 = aVar;
        Intrinsics.checkParameterIsNotNull(aVar2, "chain");
        C1755F request = aVar.request();
        if (request != null) {
            C1755F.C1756a aVar3 = new C1755F.C1756a(request);
            C0976G a = request.mo27533a();
            if (a != null) {
                C1746B contentType = a.contentType();
                if (contentType != null) {
                    aVar3.mo27550a("Content-Type", contentType.toString());
                }
                long contentLength = a.contentLength();
                if (contentLength != -1) {
                    aVar3.mo27550a("Content-Length", String.valueOf(contentLength));
                    aVar3.mo27548a("Transfer-Encoding");
                } else {
                    aVar3.mo27550a("Transfer-Encoding", "chunked");
                    aVar3.mo27548a("Content-Length");
                }
            }
            int i = 0;
            if (request.mo27535a("Host") == null) {
                aVar3.mo27550a("Host", C1764b.m2620a(request.mo27542g(), false));
            }
            if (request.mo27535a("Connection") == null) {
                aVar3.mo27550a("Connection", "Keep-Alive");
            }
            if (request.mo27535a("Accept-Encoding") == null && request.mo27535a("Range") == null) {
                aVar3.mo27550a("Accept-Encoding", "gzip");
                z = true;
            } else {
                z = false;
            }
            List<C1937n> a2 = this.f2419a.mo28092a(request.mo27542g());
            if (!a2.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (T next : a2) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    C1937n nVar = (C1937n) next;
                    if (i > 0) {
                        sb.append("; ");
                    }
                    sb.append(nVar.mo28087a());
                    sb.append('=');
                    sb.append(nVar.mo28088b());
                    i = i2;
                }
                String sb2 = sb.toString();
                Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
                aVar3.mo27550a("Cookie", sb2);
            }
            if (request.mo27535a(AbstractSpiCall.HEADER_USER_AGENT) == null) {
                aVar3.mo27550a(AbstractSpiCall.HEADER_USER_AGENT, "okhttp/4.6.0");
            }
            C1758I a3 = aVar2.mo27450a(aVar3.mo27551a());
            C1819e.m2870a(this.f2419a, request.mo27542g(), a3.mo27561r());
            C1758I.C1759a aVar4 = new C1758I.C1759a(a3);
            aVar4.mo27574a(request);
            if (z && StringsKt__StringsJVMKt.equals("gzip", C1758I.m2561a(a3, "Content-Encoding", (String) null, 2), true) && C1819e.m2872a(a3) && (d = a3.mo27554d()) != null) {
                C2077m mVar = new C2077m(d.source());
                C1952y.C1953a a4 = a3.mo27561r().mo28112a();
                a4.mo28128c("Content-Encoding");
                a4.mo28128c("Content-Length");
                aVar4.mo27578a(a4.mo28124a());
                String a5 = C1758I.m2561a(a3, "Content-Type", (String) null, 2);
                Intrinsics.checkParameterIsNotNull(mVar, "$this$buffer");
                aVar4.mo27576a((C0980J) new C1822h(a5, -1, new C2085t(mVar)));
            }
            return aVar4.mo27581a();
        }
        throw null;
    }
}
