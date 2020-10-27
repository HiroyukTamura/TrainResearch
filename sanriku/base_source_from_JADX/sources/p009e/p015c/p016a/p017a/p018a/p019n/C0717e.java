package p009e.p015c.p016a.p017a.p018a.p019n;

import android.database.sqlite.SQLiteStatement;

/* renamed from: e.c.a.a.a.n.e */
class C0717e implements C0713c {

    /* renamed from: a */
    private final SQLiteStatement f406a;

    C0717e(SQLiteStatement sQLiteStatement) {
        this.f406a = sQLiteStatement;
    }

    /* renamed from: a */
    public int mo19899a() {
        return this.f406a.executeUpdateDelete();
    }

    /* renamed from: a */
    public void mo19900a(int i) {
        this.f406a.bindNull(i);
    }

    /* renamed from: a */
    public void mo19901a(int i, long j) {
        this.f406a.bindLong(i, j);
    }

    /* renamed from: a */
    public void mo19902a(int i, String str) {
        this.f406a.bindString(i, str);
    }

    /* renamed from: a */
    public void mo19903a(int i, byte[] bArr) {
        this.f406a.bindBlob(i, bArr);
    }

    /* renamed from: a */
    public void mo19904a(String[] strArr) {
        this.f406a.bindAllArgsAsStrings(strArr);
    }

    /* renamed from: b */
    public long mo19905b() {
        return this.f406a.executeInsert();
    }

    public void close() {
        this.f406a.close();
    }
}
