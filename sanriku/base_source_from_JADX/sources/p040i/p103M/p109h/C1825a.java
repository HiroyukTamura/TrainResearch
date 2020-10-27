package p040i.p103M.p109h;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.Intrinsics;
import p040i.C1952y;
import p042j.C2072h;

/* renamed from: i.M.h.a */
public final class C1825a {

    /* renamed from: a */
    private long f2442a = ((long) 262144);

    /* renamed from: b */
    private final C2072h f2443b;

    public C1825a(C2072h hVar) {
        Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
        this.f2443b = hVar;
    }

    /* renamed from: a */
    public final C1952y mo27798a() {
        C1952y.C1953a aVar = new C1952y.C1953a();
        while (true) {
            String b = mo27799b();
            if (b.length() == 0) {
                return aVar.mo28124a();
            }
            aVar.mo28122a(b);
        }
    }

    /* renamed from: b */
    public final String mo27799b() {
        String b = this.f2443b.mo29148b(this.f2442a);
        this.f2442a -= (long) b.length();
        return b;
    }
}
