package p009e.p015c.p016a.p017a.p018a.p019n;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;

/* renamed from: e.c.a.a.a.n.d */
public class C0714d implements C0711a {

    /* renamed from: a */
    private final SQLiteDatabase f405a;

    /* renamed from: e.c.a.a.a.n.d$b */
    public static class C0716b implements C0712b {
        @NonNull
        /* renamed from: a */
        public C0711a mo19925a(@NonNull Context context) {
            return new C0714d(SQLiteDatabase.create((SQLiteDatabase.CursorFactory) null), (C0715a) null);
        }

        @NonNull
        /* renamed from: a */
        public C0711a mo19926a(@NonNull Context context, @NonNull String str, int i) {
            return new C0714d(context.openOrCreateDatabase(str, i, (SQLiteDatabase.CursorFactory) null, (DatabaseErrorHandler) null), (C0715a) null);
        }
    }

    /* synthetic */ C0714d(SQLiteDatabase sQLiteDatabase, C0715a aVar) {
        this.f405a = sQLiteDatabase;
    }

    /* renamed from: a */
    public int mo19907a(String str, ContentValues contentValues, String str2, String[] strArr) {
        return this.f405a.update(str, contentValues, str2, strArr);
    }

    /* renamed from: a */
    public long mo19908a(String str, String str2, ContentValues contentValues) {
        return this.f405a.insertOrThrow(str, str2, contentValues);
    }

    /* renamed from: a */
    public long mo19909a(String str, String str2, ContentValues contentValues, int i) {
        return this.f405a.insertWithOnConflict(str, str2, contentValues, i);
    }

    /* renamed from: a */
    public long mo19910a(String str, String str2, String[] strArr) {
        return DatabaseUtils.queryNumEntries(this.f405a, str, str2, strArr);
    }

    /* renamed from: a */
    public long mo19911a(String str, String[] strArr) {
        return DatabaseUtils.longForQuery(this.f405a, str, strArr);
    }

    /* renamed from: a */
    public Cursor mo19912a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return this.f405a.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    /* renamed from: a */
    public C0713c mo19913a(String str) {
        return new C0717e(this.f405a.compileStatement(str));
    }

    /* renamed from: a */
    public void mo19914a() {
        this.f405a.beginTransaction();
    }

    /* renamed from: a */
    public void mo19915a(int i) {
        this.f405a.setVersion(i);
    }

    @TargetApi(16)
    /* renamed from: a */
    public void mo19916a(boolean z) {
        this.f405a.setForeignKeyConstraintsEnabled(z);
    }

    /* renamed from: b */
    public Cursor mo19917b(String str, String[] strArr) {
        return this.f405a.rawQuery(str, strArr);
    }

    /* renamed from: b */
    public void mo19918b() {
        this.f405a.beginTransactionNonExclusive();
    }

    /* renamed from: b */
    public void mo19919b(String str) {
        this.f405a.execSQL(str);
    }

    /* renamed from: c */
    public void mo19920c() {
        this.f405a.close();
    }

    /* renamed from: d */
    public void mo19921d() {
        this.f405a.endTransaction();
    }

    /* renamed from: e */
    public int mo19922e() {
        return this.f405a.getVersion();
    }

    /* renamed from: f */
    public boolean mo19923f() {
        return this.f405a.inTransaction();
    }

    /* renamed from: g */
    public void mo19924g() {
        this.f405a.setTransactionSuccessful();
    }
}
