package p040i.p103M.p110i;

import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p040i.C0974E;
import p040i.C1752D;
import p040i.C1755F;
import p040i.C1758I;
import p040i.C1952y;
import p040i.C1955z;
import p040i.p103M.C1764b;
import p040i.p103M.p107f.C1806i;
import p040i.p103M.p108g.C1818d;
import p040i.p103M.p108g.C1819e;
import p040i.p103M.p108g.C1821g;
import p040i.p103M.p108g.C1824j;
import p042j.C1016z;
import p042j.C2073i;
import p042j.C2090x;

/* renamed from: i.M.i.g */
public final class C1858g implements C1818d {
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final List<String> f2587g = C1764b.m2624a((T[]) new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority"});

    /* renamed from: h */
    private static final List<String> f2588h = C1764b.m2624a((T[]) new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});

    /* renamed from: a */
    private volatile C1862i f2589a;

    /* renamed from: b */
    private final C0974E f2590b;

    /* renamed from: c */
    private volatile boolean f2591c;

    /* renamed from: d */
    private final C1806i f2592d;

    /* renamed from: e */
    private final C1821g f2593e;

    /* renamed from: f */
    private final C1841f f2594f;

    public C1858g(C1752D d, C1806i iVar, C1821g gVar, C1841f fVar) {
        Intrinsics.checkParameterIsNotNull(d, "client");
        Intrinsics.checkParameterIsNotNull(iVar, "connection");
        Intrinsics.checkParameterIsNotNull(gVar, "chain");
        Intrinsics.checkParameterIsNotNull(fVar, "http2Connection");
        this.f2592d = iVar;
        this.f2593e = gVar;
        this.f2594f = fVar;
        this.f2590b = d.mo27490u().contains(C0974E.H2_PRIOR_KNOWLEDGE) ? C0974E.H2_PRIOR_KNOWLEDGE : C0974E.HTTP_2;
    }

    /* renamed from: a */
    public C1758I.C1759a mo27781a(boolean z) {
        C1862i iVar = this.f2589a;
        if (iVar == null) {
            Intrinsics.throwNpe();
        }
        C1952y s = iVar.mo27910s();
        C0974E e = this.f2590b;
        Intrinsics.checkParameterIsNotNull(s, "headerBlock");
        Intrinsics.checkParameterIsNotNull(e, "protocol");
        C1952y.C1953a aVar = new C1952y.C1953a();
        int size = s.size();
        C1824j jVar = null;
        for (int i = 0; i < size; i++) {
            String a = s.mo28113a(i);
            String b = s.mo28115b(i);
            if (Intrinsics.areEqual((Object) a, (Object) ":status")) {
                jVar = C1824j.m2889a("HTTP/1.1 " + b);
            } else if (!f2588h.contains(a)) {
                aVar.mo28125b(a, b);
            }
        }
        if (jVar != null) {
            C1758I.C1759a aVar2 = new C1758I.C1759a();
            aVar2.mo27573a(e);
            aVar2.mo27571a(jVar.f2440b);
            aVar2.mo27579a(jVar.f2441c);
            aVar2.mo27578a(aVar.mo28124a());
            if (!z || aVar2.mo27583b() != 100) {
                return aVar2;
            }
            return null;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    /* renamed from: a */
    public C2090x mo27782a(C1755F f, long j) {
        Intrinsics.checkParameterIsNotNull(f, "request");
        C1862i iVar = this.f2589a;
        if (iVar == null) {
            Intrinsics.throwNpe();
        }
        return iVar.mo27901j();
    }

    /* renamed from: a */
    public C1016z mo27783a(C1758I i) {
        Intrinsics.checkParameterIsNotNull(i, "response");
        C1862i iVar = this.f2589a;
        if (iVar == null) {
            Intrinsics.throwNpe();
        }
        return iVar.mo27903l();
    }

    /* renamed from: a */
    public void mo27784a() {
        C1862i iVar = this.f2589a;
        if (iVar == null) {
            Intrinsics.throwNpe();
        }
        iVar.mo27901j().close();
    }

    /* renamed from: b */
    public long mo27786b(C1758I i) {
        Intrinsics.checkParameterIsNotNull(i, "response");
        if (!C1819e.m2872a(i)) {
            return 0;
        }
        return C1764b.m2616a(i);
    }

    /* renamed from: b */
    public C1806i mo27787b() {
        return this.f2592d;
    }

    /* renamed from: c */
    public void mo27788c() {
        this.f2594f.flush();
    }

    public void cancel() {
        this.f2591c = true;
        C1862i iVar = this.f2589a;
        if (iVar != null) {
            iVar.mo27885a(C1834b.CANCEL);
        }
    }

    /* renamed from: a */
    public void mo27785a(C1755F f) {
        Intrinsics.checkParameterIsNotNull(f, "request");
        if (this.f2589a == null) {
            int i = 0;
            boolean z = f.mo27533a() != null;
            Intrinsics.checkParameterIsNotNull(f, "request");
            C1952y d = f.mo27539d();
            ArrayList arrayList = new ArrayList(d.size() + 4);
            arrayList.add(new C1836c(C1836c.f2478f, f.mo27541f()));
            C2073i iVar = C1836c.f2479g;
            C1955z g = f.mo27542g();
            Intrinsics.checkParameterIsNotNull(g, ImagesContract.URL);
            String b = g.mo28133b();
            String d2 = g.mo28135d();
            if (d2 != null) {
                b = b + '?' + d2;
            }
            arrayList.add(new C1836c(iVar, b));
            String a = f.mo27535a("Host");
            if (a != null) {
                arrayList.add(new C1836c(C1836c.f2481i, a));
            }
            arrayList.add(new C1836c(C1836c.f2480h, f.mo27542g().mo28146m()));
            int size = d.size();
            while (i < size) {
                String a2 = d.mo28113a(i);
                Locale locale = Locale.US;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
                if (a2 != null) {
                    String lowerCase = a2.toLowerCase(locale);
                    Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (!f2587g.contains(lowerCase) || (Intrinsics.areEqual((Object) lowerCase, (Object) "te") && Intrinsics.areEqual((Object) d.mo28115b(i), (Object) "trailers"))) {
                        arrayList.add(new C1836c(lowerCase, d.mo28115b(i)));
                    }
                    i++;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            this.f2589a = this.f2594f.mo27824a((List<C1836c>) arrayList, z);
            if (this.f2591c) {
                C1862i iVar2 = this.f2589a;
                if (iVar2 == null) {
                    Intrinsics.throwNpe();
                }
                iVar2.mo27885a(C1834b.CANCEL);
                throw new IOException("Canceled");
            }
            C1862i iVar3 = this.f2589a;
            if (iVar3 == null) {
                Intrinsics.throwNpe();
            }
            iVar3.mo27909r().mo29120a((long) this.f2593e.mo27793e(), TimeUnit.MILLISECONDS);
            C1862i iVar4 = this.f2589a;
            if (iVar4 == null) {
                Intrinsics.throwNpe();
            }
            iVar4.mo27912u().mo29120a((long) this.f2593e.mo27795g(), TimeUnit.MILLISECONDS);
        }
    }
}
