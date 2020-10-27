package p040i.p103M.p108g;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.Intrinsics;
import p040i.C0980J;
import p040i.C1746B;
import p042j.C2072h;

/* renamed from: i.M.g.h */
public final class C1822h extends C0980J {

    /* renamed from: a */
    private final String f2435a;

    /* renamed from: b */
    private final long f2436b;

    /* renamed from: c */
    private final C2072h f2437c;

    public C1822h(String str, long j, C2072h hVar) {
        Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
        this.f2435a = str;
        this.f2436b = j;
        this.f2437c = hVar;
    }

    public long contentLength() {
        return this.f2436b;
    }

    public C1746B contentType() {
        String str = this.f2435a;
        if (str == null) {
            return null;
        }
        C1746B.C1747a aVar = C1746B.f2080f;
        return C1746B.C1747a.m2461b(str);
    }

    public C2072h source() {
        return this.f2437c;
    }
}
