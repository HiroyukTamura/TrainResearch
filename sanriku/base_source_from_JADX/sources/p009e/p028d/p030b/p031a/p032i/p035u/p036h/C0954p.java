package p009e.p028d.p030b.p031a.p032i.p035u.p036h;

import android.database.sqlite.SQLiteDatabase;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0923A;

/* renamed from: e.d.b.a.i.u.h.p */
final /* synthetic */ class C0954p implements C0923A.C0927d {

    /* renamed from: a */
    private final SQLiteDatabase f675a;

    private C0954p(SQLiteDatabase sQLiteDatabase) {
        this.f675a = sQLiteDatabase;
    }

    /* renamed from: a */
    public static C0923A.C0927d m1353a(SQLiteDatabase sQLiteDatabase) {
        return new C0954p(sQLiteDatabase);
    }

    /* renamed from: a */
    public Object mo20369a() {
        Object unused = this.f675a.beginTransaction();
        return null;
    }
}
