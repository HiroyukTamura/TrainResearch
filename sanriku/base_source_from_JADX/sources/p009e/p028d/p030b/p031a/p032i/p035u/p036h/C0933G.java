package p009e.p028d.p030b.p031a.p032i.p035u.p036h;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* renamed from: e.d.b.a.i.u.h.G */
final class C0933G extends SQLiteOpenHelper {

    /* renamed from: c */
    static int f636c = 4;

    /* renamed from: d */
    private static final C0934a f637d = C0929C.m1292a();

    /* renamed from: e */
    private static final C0934a f638e = C0930D.m1294a();

    /* renamed from: f */
    private static final C0934a f639f = C0931E.m1296a();

    /* renamed from: g */
    private static final C0934a f640g;

    /* renamed from: h */
    private static final List<C0934a> f641h;

    /* renamed from: a */
    private final int f642a;

    /* renamed from: b */
    private boolean f643b = false;

    /* renamed from: e.d.b.a.i.u.h.G$a */
    public interface C0934a {
        /* renamed from: a */
        void mo20370a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        C0934a a = C0932F.m1298a();
        f640g = a;
        f641h = Arrays.asList(new C0934a[]{f637d, f638e, f639f, a});
    }

    C0933G(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.f642a = i;
    }

    /* renamed from: a */
    static /* synthetic */ void m1300a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    /* renamed from: a */
    private void m1301a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= f641h.size()) {
            while (i < i2) {
                f641h.get(i).mo20370a(sQLiteDatabase);
                i++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i + " to " + i2 + " was requested, but cannot be performed. Only " + f641h.size() + " migrations are provided");
    }

    /* renamed from: b */
    static /* synthetic */ void m1302b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    /* renamed from: d */
    static /* synthetic */ void m1304d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f643b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i = this.f642a;
        if (!this.f643b) {
            onConfigure(sQLiteDatabase);
        }
        m1301a(sQLiteDatabase, 0, i);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        if (!this.f643b) {
            onConfigure(sQLiteDatabase);
        }
        m1301a(sQLiteDatabase, 0, i2);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (!this.f643b) {
            onConfigure(sQLiteDatabase);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (!this.f643b) {
            onConfigure(sQLiteDatabase);
        }
        m1301a(sQLiteDatabase, i, i2);
    }
}
