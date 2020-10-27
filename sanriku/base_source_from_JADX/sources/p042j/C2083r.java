package p042j;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: j.r */
final class C2083r implements C2090x {

    /* renamed from: a */
    private final OutputStream f2915a;

    /* renamed from: b */
    private final C2057A f2916b;

    public C2083r(OutputStream outputStream, C2057A a) {
        Intrinsics.checkParameterIsNotNull(outputStream, "out");
        Intrinsics.checkParameterIsNotNull(a, "timeout");
        this.f2915a = outputStream;
        this.f2916b = a;
    }

    /* renamed from: a */
    public void mo27647a(C2068f fVar, long j) {
        Intrinsics.checkParameterIsNotNull(fVar, FirebaseAnalytics.Param.SOURCE);
        C1532a.m2135a(fVar.size(), 0, j);
        while (j > 0) {
            this.f2916b.mo29124e();
            C2087u uVar = fVar.f2890a;
            if (uVar == null) {
                Intrinsics.throwNpe();
            }
            int min = (int) Math.min(j, (long) (uVar.f2926c - uVar.f2925b));
            this.f2915a.write(uVar.f2924a, uVar.f2925b, min);
            uVar.f2925b += min;
            long j2 = (long) min;
            j -= j2;
            fVar.mo29170j(fVar.size() - j2);
            if (uVar.f2925b == uVar.f2926c) {
                fVar.f2890a = uVar.mo29248a();
                C2088v.f2933c.mo29253a(uVar);
            }
        }
    }

    public void close() {
        this.f2915a.close();
    }

    public void flush() {
        this.f2915a.flush();
    }

    public C2057A timeout() {
        return this.f2916b;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("sink(");
        a.append(this.f2915a);
        a.append(')');
        return a.toString();
    }
}
