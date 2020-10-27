package p040i.p103M.p107f;

import java.security.cert.Certificate;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p040i.C1912a;
import p040i.C1926h;
import p040i.C1950x;
import p040i.p103M.p115m.C1906c;

/* renamed from: i.M.f.g */
final class C1804g extends Lambda implements Function0<List<? extends Certificate>> {

    /* renamed from: a */
    final /* synthetic */ C1926h f2376a;

    /* renamed from: b */
    final /* synthetic */ C1950x f2377b;

    /* renamed from: c */
    final /* synthetic */ C1912a f2378c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1804g(C1926h hVar, C1950x xVar, C1912a aVar) {
        super(0);
        this.f2376a = hVar;
        this.f2377b = xVar;
        this.f2378c = aVar;
    }

    public Object invoke() {
        C1906c a = this.f2376a.mo28057a();
        if (a == null) {
            Intrinsics.throwNpe();
        }
        return a.mo27991a(this.f2377b.mo28107c(), this.f2378c.mo28020k().mo28138f());
    }
}
