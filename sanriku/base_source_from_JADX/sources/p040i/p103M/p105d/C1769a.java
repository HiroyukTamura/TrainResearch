package p040i.p103M.p105d;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p040i.C0974E;
import p040i.C0980J;
import p040i.C1744A;
import p040i.C1755F;
import p040i.C1758I;
import p040i.C1915d;
import p040i.C1952y;
import p040i.p103M.C1764b;
import p040i.p103M.p105d.C1773d;
import p040i.p103M.p108g.C1819e;
import p040i.p103M.p108g.C1822h;
import p042j.C2080p;
import p042j.C2085t;
import p042j.C2090x;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo21739d2 = {"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/Interceptor;", "cache", "Lokhttp3/Cache;", "(Lokhttp3/Cache;)V", "getCache$okhttp", "()Lokhttp3/Cache;", "cacheWritingResponse", "Lokhttp3/Response;", "cacheRequest", "Lokhttp3/internal/cache/CacheRequest;", "response", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.d.a */
public final class C1769a implements C1744A {

    /* renamed from: b */
    public static final C1770a f2226b = new C1770a((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final C1915d f2227a;

    /* renamed from: i.M.d.a$a */
    public static final class C1770a {
        public /* synthetic */ C1770a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public static final /* synthetic */ C1952y m2647a(C1770a aVar, C1952y yVar, C1952y yVar2) {
            if (aVar != null) {
                C1952y.C1953a aVar2 = new C1952y.C1953a();
                int size = yVar.size();
                for (int i = 0; i < size; i++) {
                    String a = yVar.mo28113a(i);
                    String b = yVar.mo28115b(i);
                    if ((!StringsKt__StringsJVMKt.equals("Warning", a, true) || !StringsKt__StringsJVMKt.startsWith$default(b, "1", false, 2, (Object) null)) && (aVar.m2648a(a) || !aVar.m2649b(a) || yVar2.get(a) == null)) {
                        aVar2.mo28125b(a, b);
                    }
                }
                int size2 = yVar2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String a2 = yVar2.mo28113a(i2);
                    if (!aVar.m2648a(a2) && aVar.m2649b(a2)) {
                        aVar2.mo28125b(a2, yVar2.mo28115b(i2));
                    }
                }
                return aVar2.mo28124a();
            }
            throw null;
        }

        /* renamed from: a */
        private final boolean m2648a(String str) {
            return StringsKt__StringsJVMKt.equals("Content-Length", str, true) || StringsKt__StringsJVMKt.equals("Content-Encoding", str, true) || StringsKt__StringsJVMKt.equals("Content-Type", str, true);
        }

        /* renamed from: b */
        private final boolean m2649b(String str) {
            return !StringsKt__StringsJVMKt.equals("Connection", str, true) && !StringsKt__StringsJVMKt.equals("Keep-Alive", str, true) && !StringsKt__StringsJVMKt.equals("Proxy-Authenticate", str, true) && !StringsKt__StringsJVMKt.equals("Proxy-Authorization", str, true) && !StringsKt__StringsJVMKt.equals("TE", str, true) && !StringsKt__StringsJVMKt.equals("Trailers", str, true) && !StringsKt__StringsJVMKt.equals("Transfer-Encoding", str, true) && !StringsKt__StringsJVMKt.equals("Upgrade", str, true);
        }

        /* renamed from: a */
        public static final /* synthetic */ C1758I m2646a(C1770a aVar, C1758I i) {
            if (aVar != null) {
                if ((i != null ? i.mo27554d() : null) == null) {
                    return i;
                }
                if (i != null) {
                    C1758I.C1759a aVar2 = new C1758I.C1759a(i);
                    aVar2.mo27576a((C0980J) null);
                    return aVar2.mo27581a();
                }
                throw null;
            }
            throw null;
        }
    }

    public C1769a(C1915d dVar) {
        this.f2227a = dVar;
    }

    public C1758I intercept(C1744A.C1745a aVar) throws IOException {
        C0980J d;
        C0980J d2;
        Intrinsics.checkParameterIsNotNull(aVar, "chain");
        C1915d dVar = this.f2227a;
        C1758I a = dVar != null ? dVar.mo28022a(aVar.request()) : null;
        C1773d a2 = new C1773d.C1774a(System.currentTimeMillis(), aVar.request(), a).mo27604a();
        C1755F b = a2.mo27603b();
        C1758I a3 = a2.mo27602a();
        C1915d dVar2 = this.f2227a;
        if (dVar2 != null) {
            dVar2.mo28026a(a2);
        }
        if (!(a == null || a3 != null || (d2 = a.mo27554d()) == null)) {
            C1764b.m2629a((Closeable) d2);
        }
        if (b == null && a3 == null) {
            C1758I.C1759a aVar2 = new C1758I.C1759a();
            aVar2.mo27574a(aVar.request());
            aVar2.mo27573a(C0974E.HTTP_1_1);
            aVar2.mo27571a(504);
            aVar2.mo27579a("Unsatisfiable Request (only-if-cached)");
            aVar2.mo27576a(C1764b.f2215c);
            aVar2.mo27584b(-1);
            aVar2.mo27572a(System.currentTimeMillis());
            return aVar2.mo27581a();
        } else if (b == null) {
            if (a3 == null) {
                Intrinsics.throwNpe();
            }
            if (a3 != null) {
                C1758I.C1759a aVar3 = new C1758I.C1759a(a3);
                aVar3.mo27575a(C1770a.m2646a(f2226b, a3));
                return aVar3.mo27581a();
            }
            throw null;
        } else {
            try {
                C1758I a4 = aVar.mo27450a(b);
                if (!(a4 != null || a == null || d == null)) {
                }
                if (a3 != null) {
                    if (a4 == null || a4.mo27558o() != 304) {
                        C0980J d3 = a3.mo27554d();
                        if (d3 != null) {
                            C1764b.m2629a((Closeable) d3);
                        }
                    } else {
                        C1758I.C1759a aVar4 = new C1758I.C1759a(a3);
                        aVar4.mo27578a(C1770a.m2647a(f2226b, a3.mo27561r(), a4.mo27561r()));
                        aVar4.mo27584b(a4.mo27570z());
                        aVar4.mo27572a(a4.mo27568x());
                        aVar4.mo27575a(C1770a.m2646a(f2226b, a3));
                        aVar4.mo27585b(C1770a.m2646a(f2226b, a4));
                        C1758I a5 = aVar4.mo27581a();
                        C0980J d4 = a4.mo27554d();
                        if (d4 == null) {
                            Intrinsics.throwNpe();
                        }
                        d4.close();
                        C1915d dVar3 = this.f2227a;
                        if (dVar3 == null) {
                            Intrinsics.throwNpe();
                        }
                        dVar3.mo28033i();
                        this.f2227a.mo28025a(a3, a5);
                        return a5;
                    }
                }
                if (a4 == null) {
                    Intrinsics.throwNpe();
                }
                if (a4 != null) {
                    C1758I.C1759a aVar5 = new C1758I.C1759a(a4);
                    aVar5.mo27575a(C1770a.m2646a(f2226b, a3));
                    aVar5.mo27585b(C1770a.m2646a(f2226b, a4));
                    C1758I a6 = aVar5.mo27581a();
                    if (this.f2227a != null) {
                        if (!C1819e.m2872a(a6) || !C1773d.m2652a(a6, b)) {
                            String f = b.mo27541f();
                            Intrinsics.checkParameterIsNotNull(f, FirebaseAnalytics.Param.METHOD);
                            if (Intrinsics.areEqual((Object) f, (Object) "POST") || Intrinsics.areEqual((Object) f, (Object) "PATCH") || Intrinsics.areEqual((Object) f, (Object) "PUT") || Intrinsics.areEqual((Object) f, (Object) "DELETE") || Intrinsics.areEqual((Object) f, (Object) "MOVE")) {
                                try {
                                    this.f2227a.mo28028b(b);
                                } catch (IOException unused) {
                                }
                            }
                        } else {
                            C1772c a7 = this.f2227a.mo28023a(a6);
                            if (a7 == null) {
                                return a6;
                            }
                            C2090x b2 = a7.mo27601b();
                            C0980J d5 = a6.mo27554d();
                            if (d5 == null) {
                                Intrinsics.throwNpe();
                            }
                            C1771b bVar = new C1771b(d5.source(), a7, C2080p.m3577a(b2));
                            String a8 = C1758I.m2561a(a6, "Content-Type", (String) null, 2);
                            long contentLength = a6.mo27554d().contentLength();
                            C1758I.C1759a aVar6 = new C1758I.C1759a(a6);
                            Intrinsics.checkParameterIsNotNull(bVar, "$this$buffer");
                            aVar6.mo27576a((C0980J) new C1822h(a8, contentLength, new C2085t(bVar)));
                            return aVar6.mo27581a();
                        }
                    }
                    return a6;
                }
                throw null;
            } finally {
                if (!(a == null || (d = a.mo27554d()) == null)) {
                    C1764b.m2629a((Closeable) d);
                }
            }
        }
    }
}
