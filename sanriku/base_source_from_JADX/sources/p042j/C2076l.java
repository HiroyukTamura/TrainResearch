package p042j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: j.l */
public class C2076l extends C2057A {

    /* renamed from: e */
    private C2057A f2900e;

    public C2076l(C2057A a) {
        Intrinsics.checkParameterIsNotNull(a, "delegate");
        this.f2900e = a;
    }

    /* renamed from: a */
    public C2057A mo29118a() {
        return this.f2900e.mo29118a();
    }

    /* renamed from: a */
    public C2057A mo29119a(long j) {
        return this.f2900e.mo29119a(j);
    }

    /* renamed from: a */
    public C2057A mo29120a(long j, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        return this.f2900e.mo29120a(j, timeUnit);
    }

    /* renamed from: a */
    public final C2076l mo29223a(C2057A a) {
        Intrinsics.checkParameterIsNotNull(a, "delegate");
        this.f2900e = a;
        return this;
    }

    /* renamed from: b */
    public C2057A mo29121b() {
        return this.f2900e.mo29121b();
    }

    /* renamed from: c */
    public long mo29122c() {
        return this.f2900e.mo29122c();
    }

    /* renamed from: d */
    public boolean mo29123d() {
        return this.f2900e.mo29123d();
    }

    /* renamed from: e */
    public void mo29124e() throws IOException {
        this.f2900e.mo29124e();
    }

    /* renamed from: f */
    public long mo29125f() {
        return this.f2900e.mo29125f();
    }

    @JvmName(name = "delegate")
    /* renamed from: g */
    public final C2057A mo29224g() {
        return this.f2900e;
    }
}
