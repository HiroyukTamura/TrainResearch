package p040i.p103M.p108g;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C0976G;
import p040i.C0980J;
import p040i.C1744A;
import p040i.C1755F;
import p040i.C1758I;
import p040i.p103M.C1764b;
import p040i.p103M.p107f.C1795c;
import p042j.C2084s;
import p042j.C2090x;

/* renamed from: i.M.g.b */
public final class C1815b implements C1744A {

    /* renamed from: a */
    private final boolean f2420a;

    public C1815b(boolean z) {
        this.f2420a = z;
    }

    public C1758I intercept(C1744A.C1745a aVar) throws IOException {
        boolean z;
        C1758I.C1759a aVar2;
        C1758I.C1759a aVar3;
        C0980J j;
        Intrinsics.checkParameterIsNotNull(aVar, "chain");
        C1821g gVar = (C1821g) aVar;
        C1795c d = gVar.mo27792d();
        if (d == null) {
            Intrinsics.throwNpe();
        }
        C1755F f = gVar.mo27794f();
        C0976G a = f.mo27533a();
        long currentTimeMillis = System.currentTimeMillis();
        d.mo27688a(f);
        Long l = null;
        if (!C1820f.m2874a(f.mo27541f()) || a == null) {
            d.mo27700l();
            z = true;
            aVar2 = null;
        } else {
            if (StringsKt__StringsJVMKt.equals("100-continue", f.mo27535a("Expect"), true)) {
                d.mo27692d();
                aVar2 = d.mo27683a(true);
                d.mo27701m();
                z = false;
            } else {
                z = true;
                aVar2 = null;
            }
            if (aVar2 != null) {
                d.mo27700l();
                if (!d.mo27694f().mo27759i()) {
                    d.mo27699k();
                }
            } else if (a.isDuplex()) {
                d.mo27692d();
                C2090x a2 = d.mo27685a(f, true);
                Intrinsics.checkParameterIsNotNull(a2, "$this$buffer");
                a.writeTo(new C2084s(a2));
            } else {
                C2090x a3 = d.mo27685a(f, false);
                Intrinsics.checkParameterIsNotNull(a3, "$this$buffer");
                C2084s sVar = new C2084s(a3);
                a.writeTo(sVar);
                sVar.close();
            }
        }
        if (a == null || !a.isDuplex()) {
            d.mo27691c();
        }
        if (aVar2 == null) {
            aVar2 = d.mo27683a(false);
            if (aVar2 == null) {
                Intrinsics.throwNpe();
            }
            if (z) {
                d.mo27701m();
                z = false;
            }
        }
        aVar2.mo27574a(f);
        aVar2.mo27577a(d.mo27694f().mo27758h());
        aVar2.mo27584b(currentTimeMillis);
        aVar2.mo27572a(System.currentTimeMillis());
        C1758I a4 = aVar2.mo27581a();
        int o = a4.mo27558o();
        if (o == 100) {
            C1758I.C1759a a5 = d.mo27683a(false);
            if (a5 == null) {
                Intrinsics.throwNpe();
            }
            if (z) {
                d.mo27701m();
            }
            a5.mo27574a(f);
            a5.mo27577a(d.mo27694f().mo27758h());
            a5.mo27584b(currentTimeMillis);
            a5.mo27572a(System.currentTimeMillis());
            a4 = a5.mo27581a();
            o = a4.mo27558o();
        }
        d.mo27690b(a4);
        if (!this.f2420a || o != 101) {
            aVar3 = new C1758I.C1759a(a4);
            j = d.mo27684a(a4);
        } else {
            aVar3 = new C1758I.C1759a(a4);
            j = C1764b.f2215c;
        }
        aVar3.mo27576a(j);
        C1758I a6 = aVar3.mo27581a();
        if (StringsKt__StringsJVMKt.equals("close", a6.mo27569y().mo27535a("Connection"), true) || StringsKt__StringsJVMKt.equals("close", C1758I.m2561a(a6, "Connection", (String) null, 2), true)) {
            d.mo27699k();
        }
        if (o == 204 || o == 205) {
            C0980J d2 = a6.mo27554d();
            if ((d2 != null ? d2.contentLength() : -1) > 0) {
                StringBuilder b = C0681a.m338b("HTTP ", o, " had non-zero Content-Length: ");
                C0980J d3 = a6.mo27554d();
                if (d3 != null) {
                    l = Long.valueOf(d3.contentLength());
                }
                b.append(l);
                throw new ProtocolException(b.toString());
            }
        }
        return a6;
    }
}
