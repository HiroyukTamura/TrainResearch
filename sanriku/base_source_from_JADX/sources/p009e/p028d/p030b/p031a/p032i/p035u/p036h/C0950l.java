package p009e.p028d.p030b.p031a.p032i.p035u.p036h;

import android.database.sqlite.SQLiteDatabase;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0923A;

/* renamed from: e.d.b.a.i.u.h.l */
final /* synthetic */ class C0950l implements C0923A.C0925b {

    /* renamed from: a */
    private final long f669a;

    private C0950l(long j) {
        this.f669a = j;
    }

    /* renamed from: a */
    public static C0923A.C0925b m1349a(long j) {
        return new C0950l(j);
    }

    public Object apply(Object obj) {
        return Integer.valueOf(((SQLiteDatabase) obj).delete("events", "timestamp_ms < ?", new String[]{String.valueOf(this.f669a)}));
    }
}
