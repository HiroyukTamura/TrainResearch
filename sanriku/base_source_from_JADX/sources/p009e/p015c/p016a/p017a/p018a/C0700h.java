package p009e.p015c.p016a.p017a.p018a;

import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.Closeable;
import java.util.Arrays;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p015c.p016a.p017a.p018a.p019n.C0711a;
import p009e.p015c.p016a.p017a.p018a.p019n.C0713c;
import p009e.p015c.p016a.p017a.p018a.p019n.C0714d;
import p009e.p015c.p016a.p017a.p018a.p020o.C0718a;
import p009e.p015c.p016a.p017a.p018a.p020o.C0720b;
import p009e.p015c.p016a.p017a.p018a.p021p.C0721a;
import p009e.p015c.p016a.p017a.p018a.p021p.C0722b;
import p009e.p015c.p016a.p017a.p018a.p021p.C0724d;
import p009e.p015c.p016a.p017a.p018a.p024s.C0737e;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.C0760g;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.p026i.C0764a;

/* renamed from: e.c.a.a.a.h */
public class C0700h implements Closeable {

    /* renamed from: a */
    final String f385a;

    /* renamed from: b */
    final C0711a f386b;

    /* renamed from: c */
    final List<C0707k<?>> f387c;

    /* renamed from: d */
    final C0737e f388d;

    /* renamed from: e */
    final boolean f389e;

    /* renamed from: f */
    final boolean f390f;

    /* renamed from: g */
    final boolean f391g;

    /* renamed from: h */
    final boolean f392h;

    /* renamed from: i */
    final C0693a f393i;

    /* renamed from: l */
    final C0693a f394l;

    /* renamed from: m */
    boolean f395m = false;

    /* renamed from: e.c.a.a.a.h$a */
    class C0701a implements Runnable {
        C0701a() {
        }

        public void run() {
            for (C0707k<?> a : C0700h.this.f387c) {
                C0700h.this.mo19801a(a, (String) null, (String[]) null);
            }
        }
    }

    public C0700h(@NonNull C0702i<?> iVar, List<C0707k<?>> list) {
        C0711a aVar;
        int i = 0;
        String str = iVar.name;
        this.f385a = str;
        this.f387c = list;
        this.f388d = iVar.migrationEngine;
        this.f390f = iVar.foreignKeys;
        boolean z = iVar.wal;
        this.f389e = z;
        this.f391g = iVar.tryParsingSql;
        this.f392h = iVar.trace;
        this.f393i = iVar.readOnMainThread;
        this.f394l = iVar.writeOnMainThread;
        if (str == null) {
            aVar = ((C0714d.C0716b) iVar.databaseProvider).mo19925a(iVar.context);
        } else {
            aVar = ((C0714d.C0716b) iVar.databaseProvider).mo19926a(iVar.context, str, z ? 8 : i);
        }
        ((C0714d) aVar).mo19916a(this.f390f);
        this.f386b = aVar;
        if (this.f391g) {
            for (C0707k<?> createTableStatement : list) {
                C0760g.m464a(createTableStatement.getCreateTableStatement(), (C0764a) null);
            }
        }
    }

    /* renamed from: a */
    public int mo19801a(@NonNull C0707k<?> kVar, @Nullable String str, @Nullable String[] strArr) {
        C0711a l = mo19816l();
        StringBuilder a = C0681a.m330a("DELETE FROM ");
        a.append(kVar.getEscapedTableName());
        a.append(!TextUtils.isEmpty(str) ? C0681a.m320a(" WHERE ", str) : "");
        String sb = a.toString();
        mo19809a((CharSequence) sb, (Object[]) strArr);
        C0713c a2 = ((C0714d) l).mo19913a(sb);
        a2.mo19904a(strArr);
        try {
            int a3 = a2.mo19899a();
            mo19808a(C0718a.C0719a.DELETE, kVar);
            return a3;
        } finally {
            a2.close();
        }
    }

    @NonNull
    /* renamed from: a */
    public Cursor mo19803a(@NonNull String str, String... strArr) {
        mo19809a((CharSequence) str, (Object[]) strArr);
        return ((C0714d) mo19814h()).mo19917b(str, strArr);
    }

    /* renamed from: a */
    public <T> T mo19804a(C0707k<T> kVar, long j) {
        String escapedTableAlias = kVar.getEscapedTableAlias();
        T a = mo19806a(kVar, kVar.getDefaultResultColumns(), C0681a.m324a(new StringBuilder(), escapedTableAlias == null ? "" : C0681a.m320a(escapedTableAlias, "."), "`_rowid_` = ?"), new String[]{String.valueOf(j)}, (String) null, (String) null, (String) null, 0);
        if (a != null) {
            return a;
        }
        throw new C0724d("Can't retrieve the created model for rowId=" + j + " in " + kVar.getModelClass().getCanonicalName());
    }

    @NonNull
    /* renamed from: a */
    public <T> T mo19805a(C0707k<T> kVar, C0698f<T> fVar) {
        T call = fVar.call();
        C0711a l = mo19816l();
        String insertStatement = kVar.getInsertStatement(0, true);
        C0713c a = ((C0714d) l).mo19913a(insertStatement);
        if (this.f392h) {
            mo19809a((CharSequence) insertStatement, kVar.convertToArgs(this, call, true));
        }
        kVar.bindArgs(this, a, call, true);
        long b = a.mo19905b();
        mo19808a(C0718a.C0719a.INSERT, kVar);
        if (b != -1) {
            return mo19804a(kVar, b);
        }
        throw new C0722b("Failed to INSERT for " + call);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19807a(C0711a aVar) {
        long j;
        if (this.f392h) {
            Log.i("Orma", "migration started");
            j = System.currentTimeMillis();
        } else {
            j = 0;
        }
        this.f388d.mo19956a(aVar, this.f387c);
        if (this.f392h) {
            StringBuilder a = C0681a.m330a("migration finished in ");
            a.append(System.currentTimeMillis() - j);
            a.append("ms");
            Log.i("Orma", a.toString());
        }
    }

    /* renamed from: a */
    public <Model> void mo19808a(C0718a.C0719a aVar, C0707k<Model> kVar) {
        mo19815i().mo19929a(this.f386b, aVar, kVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19809a(@NonNull CharSequence charSequence, @Nullable Object[] objArr) {
        String str;
        if (this.f392h) {
            StringBuilder a = C0681a.m330a("[");
            a.append(Thread.currentThread().getName());
            a.append("] ");
            String sb = a.toString();
            if (objArr == null) {
                str = sb + charSequence;
            } else {
                str = sb + charSequence + " - " + Arrays.deepToString(objArr);
            }
            Log.v("Orma", str);
        }
    }

    /* renamed from: a */
    public void mo19810a(@NonNull Runnable runnable) {
        C0711a h = mo19814h();
        mo19809a((CharSequence) "begin transaction (non exclusive)", (Object[]) null);
        C0714d dVar = (C0714d) h;
        dVar.mo19918b();
        try {
            runnable.run();
            dVar.mo19924g();
        } finally {
            dVar.mo19921d();
            mo19809a((CharSequence) "end transaction (non exclusive)", (Object[]) null);
            mo19815i().mo19928a();
        }
    }

    @WorkerThread
    /* renamed from: b */
    public void mo19811b(@NonNull Runnable runnable) {
        C0711a l = mo19816l();
        mo19809a((CharSequence) "begin transaction", (Object[]) null);
        C0714d dVar = (C0714d) l;
        dVar.mo19914a();
        try {
            runnable.run();
            dVar.mo19924g();
        } finally {
            dVar.mo19921d();
            mo19809a((CharSequence) "end transaction", (Object[]) null);
            mo19815i().mo19928a();
        }
    }

    public void close() {
        ((C0714d) this.f386b).mo19920c();
    }

    /* renamed from: d */
    public void mo19813d() {
        mo19811b(new C0701a());
    }

    /* renamed from: h */
    public synchronized C0711a mo19814h() {
        if (this.f393i != C0693a.NONE && Looper.getMainLooper().getThread() == Thread.currentThread()) {
            if (this.f393i != C0693a.FATAL) {
                Log.w("Orma", "Reading things must run in background");
            } else {
                throw new C0721a("Reading things must run in background");
            }
        }
        if (!this.f395m) {
            mo19807a(this.f386b);
            this.f395m = true;
        }
        return this.f386b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public C0720b mo19815i() {
        throw null;
    }

    /* renamed from: l */
    public synchronized C0711a mo19816l() {
        if (this.f394l != C0693a.NONE && Looper.getMainLooper().getThread() == Thread.currentThread()) {
            if (this.f394l != C0693a.FATAL) {
                Log.w("Orma", "Writing things must run in background");
            } else {
                throw new C0721a("Writing things must run in background");
            }
        }
        if (!this.f395m) {
            mo19807a(this.f386b);
            this.f395m = true;
        }
        return this.f386b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> long mo19802a(p009e.p015c.p016a.p017a.p018a.C0707k<T> r9, android.content.ContentValues r10, int r11) {
        /*
            r8 = this;
            boolean r0 = r8.f392h
            if (r0 == 0) goto L_0x008e
            java.lang.String r0 = "INSERT"
            java.lang.StringBuilder r0 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r0)
            r1 = 1
            if (r11 == r1) goto L_0x0026
            r1 = 2
            if (r11 == r1) goto L_0x0023
            r1 = 3
            if (r11 == r1) goto L_0x0020
            r1 = 4
            if (r11 == r1) goto L_0x001d
            r1 = 5
            if (r11 == r1) goto L_0x001a
            goto L_0x002b
        L_0x001a:
            java.lang.String r1 = " OR REPLACE"
            goto L_0x0028
        L_0x001d:
            java.lang.String r1 = " OR IGNORE"
            goto L_0x0028
        L_0x0020:
            java.lang.String r1 = " OR FAIL"
            goto L_0x0028
        L_0x0023:
            java.lang.String r1 = " OR ABORT"
            goto L_0x0028
        L_0x0026:
            java.lang.String r1 = " OR ROLLBACK"
        L_0x0028:
            r0.append(r1)
        L_0x002b:
            java.lang.String r1 = " INTO "
            r0.append(r1)
            java.lang.String r1 = r9.getEscapedTableName()
            r0.append(r1)
            r1 = 40
            r0.append(r1)
            int r1 = r10.size()
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.util.Set r3 = r10.keySet()
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
            r5 = 0
        L_0x004c:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x006f
            java.lang.Object r6 = r3.next()
            java.lang.String r6 = (java.lang.String) r6
            if (r5 <= 0) goto L_0x005d
            java.lang.String r7 = ","
            goto L_0x005f
        L_0x005d:
            java.lang.String r7 = ""
        L_0x005f:
            r0.append(r7)
            r0.append(r6)
            int r7 = r5 + 1
            java.lang.Object r6 = r10.get(r6)
            r2[r5] = r6
            r5 = r7
            goto L_0x004c
        L_0x006f:
            r3 = 41
            r0.append(r3)
            java.lang.String r5 = " VALUES ("
            r0.append(r5)
        L_0x0079:
            if (r4 >= r1) goto L_0x0088
            if (r4 <= 0) goto L_0x0080
            java.lang.String r5 = ",?"
            goto L_0x0082
        L_0x0080:
            java.lang.String r5 = "?"
        L_0x0082:
            r0.append(r5)
            int r4 = r4 + 1
            goto L_0x0079
        L_0x0088:
            r0.append(r3)
            r8.mo19809a((java.lang.CharSequence) r0, (java.lang.Object[]) r2)
        L_0x008e:
            e.c.a.a.a.n.a r0 = r8.mo19816l()
            java.lang.String r9 = r9.getEscapedTableName()
            r1 = 0
            e.c.a.a.a.n.d r0 = (p009e.p015c.p016a.p017a.p018a.p019n.C0714d) r0
            long r9 = r0.mo19909a((java.lang.String) r9, (java.lang.String) r1, (android.content.ContentValues) r10, (int) r11)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p009e.p015c.p016a.p017a.p018a.C0700h.mo19802a(e.c.a.a.a.k, android.content.ContentValues, int):long");
    }

    @Nullable
    /* renamed from: a */
    public <T> T mo19806a(C0707k<T> kVar, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, long j) {
        String[] strArr3 = strArr2;
        Cursor a = mo19803a(SQLiteQueryBuilder.buildQueryString(false, kVar.getSelectFromTableClause(), strArr, str, str2, str3, str4, j + ",1"), strArr2);
        try {
            if (a.moveToFirst()) {
                C0707k<T> kVar2 = kVar;
                return kVar.newModelFromCursor(this, a, 0);
            }
            a.close();
            return null;
        } finally {
            a.close();
        }
    }
}
