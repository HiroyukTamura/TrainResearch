package p009e.p028d.p030b.p031a.p032i.p035u.p036h;

import android.database.sqlite.SQLiteDatabase;
import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0923A;

/* renamed from: e.d.b.a.i.u.h.z */
final /* synthetic */ class C0964z implements C0923A.C0925b {

    /* renamed from: a */
    private final C0923A f687a;

    /* renamed from: b */
    private final C0903k f688b;

    private C0964z(C0923A a, C0903k kVar) {
        this.f687a = a;
        this.f688b = kVar;
    }

    /* renamed from: a */
    public static C0923A.C0925b m1365a(C0923A a, C0903k kVar) {
        return new C0964z(a, kVar);
    }

    public Object apply(Object obj) {
        return C0923A.m1259a(this.f687a, this.f688b, (SQLiteDatabase) obj);
    }
}
