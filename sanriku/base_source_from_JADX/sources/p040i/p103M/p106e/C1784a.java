package p040i.p103M.p106e;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: i.M.e.a */
public abstract class C1784a {

    /* renamed from: a */
    private C1787d f2297a;

    /* renamed from: b */
    private long f2298b = -1;

    /* renamed from: c */
    private final String f2299c;

    /* renamed from: d */
    private final boolean f2300d;

    public C1784a(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        this.f2299c = str;
        this.f2300d = z;
    }

    /* renamed from: a */
    public final void mo27650a(long j) {
        this.f2298b = j;
    }

    /* renamed from: a */
    public final void mo27651a(C1787d dVar) {
        Intrinsics.checkParameterIsNotNull(dVar, "queue");
        C1787d dVar2 = this.f2297a;
        if (dVar2 != dVar) {
            if (dVar2 == null) {
                this.f2297a = dVar;
                return;
            }
            throw new IllegalStateException("task is in multiple queues".toString());
        }
    }

    /* renamed from: a */
    public final boolean mo27652a() {
        return this.f2300d;
    }

    /* renamed from: b */
    public final String mo27653b() {
        return this.f2299c;
    }

    /* renamed from: c */
    public final long mo27654c() {
        return this.f2298b;
    }

    /* renamed from: d */
    public final C1787d mo27655d() {
        return this.f2297a;
    }

    /* renamed from: e */
    public abstract long mo27646e();

    public String toString() {
        return this.f2299c;
    }
}
