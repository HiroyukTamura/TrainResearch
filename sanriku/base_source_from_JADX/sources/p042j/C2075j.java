package p042j;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: j.j */
public abstract class C2075j implements C2090x {

    /* renamed from: a */
    private final C2090x f2899a;

    public C2075j(C2090x xVar) {
        Intrinsics.checkParameterIsNotNull(xVar, "delegate");
        this.f2899a = xVar;
    }

    /* renamed from: a */
    public void mo27647a(C2068f fVar, long j) throws IOException {
        Intrinsics.checkParameterIsNotNull(fVar, FirebaseAnalytics.Param.SOURCE);
        this.f2899a.mo27647a(fVar, j);
    }

    public void close() throws IOException {
        this.f2899a.close();
    }

    public void flush() throws IOException {
        this.f2899a.flush();
    }

    public C2057A timeout() {
        return this.f2899a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f2899a + ')';
    }
}
