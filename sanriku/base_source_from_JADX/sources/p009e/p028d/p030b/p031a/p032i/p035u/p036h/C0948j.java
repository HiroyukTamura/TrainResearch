package p009e.p028d.p030b.p031a.p032i.p035u.p036h;

import android.database.sqlite.SQLiteDatabase;
import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0923A;

/* renamed from: e.d.b.a.i.u.h.j */
final /* synthetic */ class C0948j implements C0923A.C0925b {

    /* renamed from: a */
    private final C0923A f666a;

    /* renamed from: b */
    private final C0903k f667b;

    private C0948j(C0923A a, C0903k kVar) {
        this.f666a = a;
        this.f667b = kVar;
    }

    /* renamed from: a */
    public static C0923A.C0925b m1347a(C0923A a, C0903k kVar) {
        return new C0948j(a, kVar);
    }

    public Object apply(Object obj) {
        return C0923A.m1276b(this.f666a, this.f667b, (SQLiteDatabase) obj);
    }
}
