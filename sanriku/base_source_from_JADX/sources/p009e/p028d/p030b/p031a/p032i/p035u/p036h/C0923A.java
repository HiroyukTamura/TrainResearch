package p009e.p028d.p030b.p031a.p032i.p035u.p036h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p031a.C0875b;
import p009e.p028d.p030b.p031a.p032i.C0895f;
import p009e.p028d.p030b.p031a.p032i.C0896g;
import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.p033s.C0913a;
import p009e.p028d.p030b.p031a.p032i.p037v.C0965a;
import p009e.p028d.p030b.p031a.p032i.p037v.C0966b;
import p009e.p028d.p030b.p031a.p032i.p038w.C0968a;
import p009e.p028d.p030b.p031a.p032i.p039x.C0973a;

@WorkerThread
/* renamed from: e.d.b.a.i.u.h.A */
public class C0923A implements C0940c, C0966b {

    /* renamed from: e */
    private static final C0875b f621e = C0875b.m1149a("proto");

    /* renamed from: a */
    private final C0933G f622a;

    /* renamed from: b */
    private final C0968a f623b;

    /* renamed from: c */
    private final C0968a f624c;

    /* renamed from: d */
    private final C0941d f625d;

    /* renamed from: e.d.b.a.i.u.h.A$b */
    interface C0925b<T, U> {
        U apply(T t);
    }

    /* renamed from: e.d.b.a.i.u.h.A$c */
    private static class C0926c {

        /* renamed from: a */
        final String f626a;

        /* renamed from: b */
        final String f627b;

        /* synthetic */ C0926c(String str, String str2, C0924a aVar) {
            this.f626a = str;
            this.f627b = str2;
        }
    }

    /* renamed from: e.d.b.a.i.u.h.A$d */
    interface C0927d<T> {
        /* renamed from: a */
        T mo20369a();
    }

    C0923A(C0968a aVar, C0968a aVar2, C0941d dVar, C0933G g) {
        this.f622a = g;
        this.f623b = aVar;
        this.f624c = aVar2;
        this.f625d = dVar;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m1259a(C0923A a, C0903k kVar, SQLiteDatabase sQLiteDatabase) {
        Long a2 = a.m1262a(sQLiteDatabase, kVar);
        if (a2 == null) {
            return false;
        }
        return (Boolean) m1265a(a.mo20366d().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{a2.toString()}), C0958t.m1359a());
    }

    /* renamed from: a */
    static /* synthetic */ Long m1261a(Cursor cursor) {
        return Long.valueOf(cursor.moveToNext() ? cursor.getLong(0) : 0);
    }

    @Nullable
    /* renamed from: a */
    private Long m1262a(SQLiteDatabase sQLiteDatabase, C0903k kVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{kVar.mo20321a(), String.valueOf(C0973a.m1372a(kVar.mo20323c()))}));
        if (kVar.mo20322b() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(kVar.mo20322b(), 0));
        }
        return (Long) m1265a(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), (String) null, (String) null, (String) null), C0961w.m1362a());
    }

    /* renamed from: a */
    static /* synthetic */ Object m1264a(long j, C0903k kVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{kVar.mo20321a(), String.valueOf(C0973a.m1372a(kVar.mo20323c()))}) < 1) {
            contentValues.put("backend_name", kVar.mo20321a());
            contentValues.put("priority", Integer.valueOf(C0973a.m1372a(kVar.mo20323c())));
            sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        return null;
    }

    /* renamed from: a */
    private static <T> T m1265a(Cursor cursor, C0925b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    /* renamed from: a */
    private <T> T m1267a(C0925b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase d = mo20366d();
        d.beginTransaction();
        try {
            T apply = bVar.apply(d);
            d.setTransactionSuccessful();
            return apply;
        } finally {
            d.endTransaction();
        }
    }

    /* renamed from: a */
    private <T> T m1268a(C0927d<T> dVar, C0925b<Throwable, T> bVar) {
        long a = this.f624c.mo20396a();
        while (true) {
            try {
                return dVar.mo20369a();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.f624c.mo20396a() >= ((long) this.f625d.mo20376a()) + a) {
                    return bVar.apply(e);
                }
                SystemClock.sleep(50);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ Object m1269a(C0923A a, List list, C0903k kVar, Cursor cursor) {
        Cursor cursor2 = cursor;
        while (cursor.moveToNext()) {
            long j = cursor2.getLong(0);
            boolean z = cursor2.getInt(7) != 0;
            C0896g.C0897a i = C0896g.m1196i();
            i.mo20302a(cursor2.getString(1));
            i.mo20299a(cursor2.getLong(2));
            i.mo20305b(cursor2.getLong(3));
            if (z) {
                String string = cursor2.getString(4);
                i.mo20300a(new C0895f(string == null ? f621e : C0875b.m1149a(string), cursor2.getBlob(5)));
            } else {
                String string2 = cursor2.getString(4);
                i.mo20300a(new C0895f(string2 == null ? f621e : C0875b.m1149a(string2), (byte[]) m1265a(a.mo20366d().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, (String) null, (String) null, "sequence_num"), C0952n.m1351a())));
            }
            if (!cursor2.isNull(6)) {
                i.mo20301a(Integer.valueOf(cursor2.getInt(6)));
            }
            list.add(new C0939b(j, kVar, i.mo20304a()));
        }
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ Object m1270a(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 10").execute();
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ Object m1271a(Throwable th) {
        throw new C0965a("Timed out while trying to acquire the lock.", th);
    }

    /* renamed from: a */
    static /* synthetic */ Object m1272a(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j), set);
            }
            set.add(new C0926c(cursor.getString(1), cursor.getString(2), (C0924a) null));
        }
        return null;
    }

    /* renamed from: b */
    static /* synthetic */ SQLiteDatabase m1273b(Throwable th) {
        throw new C0965a("Timed out while trying to open db.", th);
    }

    /* renamed from: b */
    static /* synthetic */ Long m1274b(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    /* renamed from: b */
    static /* synthetic */ List m1275b(SQLiteDatabase sQLiteDatabase) {
        return (List) m1265a(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), C0957s.m1358a());
    }

    /* renamed from: b */
    static /* synthetic */ List m1276b(C0923A a, C0903k kVar, SQLiteDatabase sQLiteDatabase) {
        C0923A a2 = a;
        C0903k kVar2 = kVar;
        if (a2 != null) {
            ArrayList arrayList = new ArrayList();
            Long a3 = a.m1262a(sQLiteDatabase, kVar);
            if (a3 != null) {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                m1265a(sQLiteDatabase2.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{a3.toString()}, (String) null, (String) null, (String) null, String.valueOf(a2.f625d.mo20378c())), C0951m.m1350a(a, arrayList, kVar));
            }
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder("event_id IN (");
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(((C0946h) arrayList.get(i)).mo20391b());
                if (i < arrayList.size() - 1) {
                    sb.append(',');
                }
            }
            sb.append(')');
            m1265a(sQLiteDatabase.query("event_metadata", new String[]{"event_id", AppMeasurementSdk.ConditionalUserProperty.NAME, "value"}, sb.toString(), (String[]) null, (String) null, (String) null, (String) null), C0953o.m1352a(hashMap));
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                C0946h hVar = (C0946h) listIterator.next();
                if (hashMap.containsKey(Long.valueOf(hVar.mo20391b()))) {
                    C0896g.C0897a h = hVar.mo20390a().mo20343h();
                    for (C0926c cVar : (Set) hashMap.get(Long.valueOf(hVar.mo20391b()))) {
                        h.mo20346a(cVar.f626a, cVar.f627b);
                    }
                    listIterator.set(new C0939b(hVar.mo20391b(), hVar.mo20392c(), h.mo20304a()));
                }
            }
            return arrayList;
        }
        throw null;
    }

    /* renamed from: c */
    private static String m1277c(Iterable<C0946h> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<C0946h> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().mo20391b());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: c */
    static /* synthetic */ List m1278c(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            C0903k.C0904a d = C0903k.m1231d();
            d.mo20327a(cursor.getString(1));
            d.mo20326a(C0973a.m1373a(cursor.getInt(2)));
            String string = cursor.getString(3);
            d.mo20328a(string == null ? null : Base64.decode(string, 0));
            arrayList.add(d.mo20329a());
        }
        return arrayList;
    }

    /* renamed from: d */
    static /* synthetic */ byte[] m1279d(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i += blob.length;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            byte[] bArr2 = (byte[]) arrayList.get(i3);
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 += bArr2.length;
        }
        return bArr;
    }

    /* renamed from: a */
    public int mo20356a() {
        return ((Integer) m1267a(C0950l.m1349a(this.f623b.mo20396a() - this.f625d.mo20377b()))).intValue();
    }

    /* renamed from: a */
    public Iterable<C0946h> mo20358a(C0903k kVar) {
        return (Iterable) m1267a(C0948j.m1347a(this, kVar));
    }

    /* renamed from: a */
    public void mo20360a(C0903k kVar, long j) {
        m1267a(C0947i.m1346a(j, kVar));
    }

    /* renamed from: a */
    public void mo20361a(Iterable<C0946h> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder a = C0681a.m330a("DELETE FROM events WHERE _id in ");
            a.append(m1277c(iterable));
            mo20366d().compileStatement(a.toString()).execute();
        }
    }

    /* renamed from: b */
    public long mo20362b(C0903k kVar) {
        return ((Long) m1265a(mo20366d().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{kVar.mo20321a(), String.valueOf(C0973a.m1372a(kVar.mo20323c()))}), C0963y.m1364a())).longValue();
    }

    /* renamed from: b */
    public void mo20363b(Iterable<C0946h> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder a = C0681a.m330a("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
            a.append(m1277c(iterable));
            m1267a(C0962x.m1363a(a.toString()));
        }
    }

    /* renamed from: c */
    public boolean mo20364c(C0903k kVar) {
        return ((Boolean) m1267a(C0964z.m1365a(this, kVar))).booleanValue();
    }

    public void close() {
        this.f622a.close();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: d */
    public SQLiteDatabase mo20366d() {
        C0933G g = this.f622a;
        g.getClass();
        return (SQLiteDatabase) m1268a(C0956r.m1356a(g), C0959u.m1360a());
    }

    /* renamed from: e */
    public Iterable<C0903k> mo20367e() {
        return (Iterable) m1267a(C0949k.m1348a());
    }

    /* renamed from: a */
    static /* synthetic */ Long m1263a(C0923A a, C0903k kVar, C0896g gVar, SQLiteDatabase sQLiteDatabase) {
        long j;
        if (a.mo20366d().compileStatement("PRAGMA page_size").simpleQueryForLong() * a.mo20366d().compileStatement("PRAGMA page_count").simpleQueryForLong() >= a.f625d.mo20380e()) {
            return -1L;
        }
        Long a2 = a.m1262a(sQLiteDatabase, kVar);
        if (a2 != null) {
            j = a2.longValue();
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("backend_name", kVar.mo20321a());
            contentValues.put("priority", Integer.valueOf(C0973a.m1372a(kVar.mo20323c())));
            contentValues.put("next_request_ms", 0);
            if (kVar.mo20322b() != null) {
                contentValues.put("extras", Base64.encodeToString(kVar.mo20322b(), 0));
            }
            j = sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        int d = a.f625d.mo20379d();
        byte[] a3 = gVar.mo20292c().mo20334a();
        boolean z = a3.length <= d;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("context_id", Long.valueOf(j));
        contentValues2.put("transport_name", gVar.mo20295f());
        contentValues2.put("timestamp_ms", Long.valueOf(gVar.mo20293d()));
        contentValues2.put("uptime_ms", Long.valueOf(gVar.mo20296g()));
        contentValues2.put("payload_encoding", gVar.mo20292c().mo20335b().mo20281a());
        contentValues2.put("code", gVar.mo20291b());
        contentValues2.put("num_attempts", 0);
        contentValues2.put("inline", Boolean.valueOf(z));
        contentValues2.put("payload", z ? a3 : new byte[0]);
        long insert = sQLiteDatabase.insert("events", (String) null, contentValues2);
        if (!z) {
            double length = (double) a3.length;
            double d2 = (double) d;
            Double.isNaN(length);
            Double.isNaN(d2);
            int ceil = (int) Math.ceil(length / d2);
            for (int i = 1; i <= ceil; i++) {
                byte[] copyOfRange = Arrays.copyOfRange(a3, (i - 1) * d, Math.min(i * d, a3.length));
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("event_id", Long.valueOf(insert));
                contentValues3.put("sequence_num", Integer.valueOf(i));
                contentValues3.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", (String) null, contentValues3);
            }
        }
        for (Map.Entry next : gVar.mo20342e().entrySet()) {
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("event_id", Long.valueOf(insert));
            contentValues4.put(AppMeasurementSdk.ConditionalUserProperty.NAME, (String) next.getKey());
            contentValues4.put("value", (String) next.getValue());
            sQLiteDatabase.insert("event_metadata", (String) null, contentValues4);
        }
        return Long.valueOf(insert);
    }

    @Nullable
    /* renamed from: a */
    public C0946h mo20357a(C0903k kVar, C0896g gVar) {
        C0913a.m1251a("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", kVar.mo20323c(), gVar.mo20295f(), kVar.mo20321a());
        long longValue = ((Long) m1267a(C0960v.m1361a(this, kVar, gVar))).longValue();
        if (longValue < 1) {
            return null;
        }
        return new C0939b(longValue, kVar, gVar);
    }

    /* renamed from: a */
    public <T> T mo20359a(C0966b.C0967a<T> aVar) {
        SQLiteDatabase d = mo20366d();
        m1268a(C0954p.m1353a(d), C0955q.m1355a());
        try {
            T execute = aVar.execute();
            d.setTransactionSuccessful();
            return execute;
        } finally {
            d.endTransaction();
        }
    }
}
