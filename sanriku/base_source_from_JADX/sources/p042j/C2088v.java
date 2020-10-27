package p042j;

import android.support.p001v4.media.session.PlaybackStateCompat;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: j.v */
public final class C2088v {

    /* renamed from: a */
    private static C2087u f2931a;

    /* renamed from: b */
    private static long f2932b;

    /* renamed from: c */
    public static final C2088v f2933c = new C2088v();

    private C2088v() {
    }

    /* renamed from: a */
    public final C2087u mo29252a() {
        synchronized (this) {
            C2087u uVar = f2931a;
            if (uVar == null) {
                return new C2087u();
            }
            f2931a = uVar.f2929f;
            uVar.f2929f = null;
            f2932b -= (long) 8192;
            return uVar;
        }
    }

    /* renamed from: a */
    public final void mo29253a(C2087u uVar) {
        Intrinsics.checkParameterIsNotNull(uVar, "segment");
        if (!(uVar.f2929f == null && uVar.f2930g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!uVar.f2927d) {
            synchronized (this) {
                long j = (long) 8192;
                if (f2932b + j <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    f2932b += j;
                    uVar.f2929f = f2931a;
                    uVar.f2926c = 0;
                    uVar.f2925b = 0;
                    f2931a = uVar;
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }
}
