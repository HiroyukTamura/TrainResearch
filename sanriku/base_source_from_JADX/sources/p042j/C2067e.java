package p042j;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: j.e */
final class C2067e implements C2090x {
    /* renamed from: a */
    public void mo27647a(C2068f fVar, long j) {
        Intrinsics.checkParameterIsNotNull(fVar, FirebaseAnalytics.Param.SOURCE);
        fVar.skip(j);
    }

    public void close() {
    }

    public void flush() {
    }

    public C2057A timeout() {
        return C2057A.f2872d;
    }
}
