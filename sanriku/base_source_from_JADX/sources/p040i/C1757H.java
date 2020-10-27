package p040i;

import kotlin.jvm.internal.Intrinsics;
import p042j.C2071g;
import p042j.C2073i;

/* renamed from: i.H */
public final class C1757H extends C0976G {

    /* renamed from: a */
    final /* synthetic */ C2073i f2174a;

    /* renamed from: b */
    final /* synthetic */ C1746B f2175b;

    C1757H(C2073i iVar, C1746B b) {
        this.f2174a = iVar;
        this.f2175b = b;
    }

    public long contentLength() {
        return (long) this.f2174a.mo29212d();
    }

    public C1746B contentType() {
        return this.f2175b;
    }

    public void writeTo(C2071g gVar) {
        Intrinsics.checkParameterIsNotNull(gVar, "sink");
        gVar.mo29137a(this.f2174a);
    }
}
