package p040i;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import p040i.p103M.p106e.C1788e;
import p040i.p103M.p107f.C1807j;

/* renamed from: i.l */
public final class C1935l {

    /* renamed from: a */
    private final C1807j f2803a;

    public C1935l() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
        C1807j jVar = new C1807j(C1788e.f2308h, 5, 5, timeUnit);
        Intrinsics.checkParameterIsNotNull(jVar, "delegate");
        this.f2803a = jVar;
    }

    /* renamed from: a */
    public final C1807j mo28077a() {
        return this.f2803a;
    }
}
