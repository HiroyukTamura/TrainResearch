package p009e.p028d.p030b.p031a.p032i.p035u.p036h;

import android.database.sqlite.SQLiteDatabase;
import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0923A;

/* renamed from: e.d.b.a.i.u.h.i */
final /* synthetic */ class C0947i implements C0923A.C0925b {

    /* renamed from: a */
    private final long f664a;

    /* renamed from: b */
    private final C0903k f665b;

    private C0947i(long j, C0903k kVar) {
        this.f664a = j;
        this.f665b = kVar;
    }

    /* renamed from: a */
    public static C0923A.C0925b m1346a(long j, C0903k kVar) {
        return new C0947i(j, kVar);
    }

    public Object apply(Object obj) {
        C0923A.m1264a(this.f664a, this.f665b, (SQLiteDatabase) obj);
        return null;
    }
}
