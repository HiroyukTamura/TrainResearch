package p009e.p028d.p030b.p031a.p032i.p035u.p036h;

import android.database.sqlite.SQLiteDatabase;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0933G;

/* renamed from: e.d.b.a.i.u.h.E */
final /* synthetic */ class C0931E implements C0933G.C0934a {

    /* renamed from: a */
    private static final C0931E f634a = new C0931E();

    private C0931E() {
    }

    /* renamed from: a */
    public static C0933G.C0934a m1296a() {
        return f634a;
    }

    /* renamed from: a */
    public void mo20370a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
