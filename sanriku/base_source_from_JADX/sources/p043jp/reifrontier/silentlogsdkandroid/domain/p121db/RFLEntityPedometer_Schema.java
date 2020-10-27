package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p015c.p016a.p017a.p018a.C0695c;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.C0707k;
import p009e.p015c.p016a.p017a.p018a.p019n.C0713c;
import p009e.p015c.p016a.p017a.p018a.p021p.C0724d;
import p009e.p015c.p016a.p017a.p018a.p023r.C0727a;
import p009e.p015c.p016a.p017a.p018a.p023r.C0730d;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityPedometer_Schema */
public class RFLEntityPedometer_Schema implements C0707k<RFLEntityPedometer> {
    public static final RFLEntityPedometer_Schema INSTANCE;
    public final C0695c<RFLEntityPedometer, Long> _rowid_;
    @Nullable

    /* renamed from: a */
    private final String f3690a;

    /* renamed from: b */
    private final String[] f3691b;
    public final C0695c<RFLEntityPedometer, Long> timestamp;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityPedometer_Schema$a */
    class C2327a extends C0695c<RFLEntityPedometer, Long> {
        C2327a(RFLEntityPedometer_Schema rFLEntityPedometer_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Long mo33259a(@NonNull RFLEntityPedometer rFLEntityPedometer) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        /* renamed from: b */
        public Long mo33260b(@NonNull RFLEntityPedometer rFLEntityPedometer) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object get(@NonNull Object obj) {
            mo33259a((RFLEntityPedometer) obj);
            throw null;
        }

        @NonNull
        public Long getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Long.valueOf(cursor.getLong(i));
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object getSerialized(@NonNull Object obj) {
            mo33260b((RFLEntityPedometer) obj);
            throw null;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityPedometer_Schema$b */
    class C2328b extends C0695c<RFLEntityPedometer, Long> {
        C2328b(RFLEntityPedometer_Schema rFLEntityPedometer_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Long get(@NonNull RFLEntityPedometer rFLEntityPedometer) {
            return Long.valueOf(rFLEntityPedometer.getTimestamp());
        }

        @NonNull
        /* renamed from: b */
        public Long getSerialized(@NonNull RFLEntityPedometer rFLEntityPedometer) {
            return Long.valueOf(rFLEntityPedometer.getTimestamp());
        }

        @NonNull
        public Long getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Long.valueOf(cursor.getLong(i));
        }
    }

    static {
        RFLEntityPedometer_Schema rFLEntityPedometer_Schema = new RFLEntityPedometer_Schema();
        C0730d.m411a(rFLEntityPedometer_Schema);
        INSTANCE = rFLEntityPedometer_Schema;
    }

    public RFLEntityPedometer_Schema() {
        this((C0727a) null);
    }

    public RFLEntityPedometer_Schema(@Nullable C0727a aVar) {
        if (aVar == null) {
            this.f3690a = null;
            this._rowid_ = new C2327a(this, this, "_rowid_", Long.TYPE, "INTEGER", C0695c.PRIMARY_KEY | C0695c.AUTO_VALUE);
            C2328b bVar = new C2328b(this, this, "timestamp", Long.TYPE, "INTEGER", C0695c.INDEXED);
            this.timestamp = bVar;
            this.f3691b = new String[]{bVar.getQualifiedName()};
            return;
        }
        throw null;
    }

    public void bindArgs(@NonNull C0700h hVar, @NonNull C0713c cVar, @NonNull RFLEntityPedometer rFLEntityPedometer, boolean z) {
        cVar.mo19901a(1, rFLEntityPedometer.getTimestamp());
    }

    @NonNull
    public Object[] convertToArgs(@NonNull C0700h hVar, @NonNull RFLEntityPedometer rFLEntityPedometer, boolean z) {
        return new Object[]{Long.valueOf(rFLEntityPedometer.getTimestamp())};
    }

    @NonNull
    public ContentValues convertToContentValues(@NonNull C0700h hVar, @NonNull RFLEntityPedometer rFLEntityPedometer, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(rFLEntityPedometer.getTimestamp()));
        return contentValues;
    }

    @NonNull
    public List<C0695c<RFLEntityPedometer, ?>> getColumns() {
        return Arrays.asList(new C0695c[]{this.timestamp});
    }

    @NonNull
    public List<String> getCreateIndexStatements() {
        return Arrays.asList(new String[]{"CREATE INDEX `index_timestamp_on_RFLEntityPedometer` ON `RFLEntityPedometer` (`timestamp`)"});
    }

    @NonNull
    public String getCreateTableStatement() {
        return "CREATE TABLE `RFLEntityPedometer` (`timestamp` INTEGER NOT NULL)";
    }

    @NonNull
    public String[] getDefaultResultColumns() {
        return this.f3691b;
    }

    @NonNull
    public String getDropTableStatement() {
        return "DROP TABLE IF EXISTS `RFLEntityPedometer`";
    }

    @Nullable
    public String getEscapedTableAlias() {
        if (this.f3690a != null) {
            return C0681a.m323a(C0681a.m329a('`'), this.f3690a, '`');
        }
        return null;
    }

    @NonNull
    public String getEscapedTableName() {
        return "`RFLEntityPedometer`";
    }

    @NonNull
    public String getInsertStatement(int i, boolean z) {
        String str;
        StringBuilder a = C0681a.m330a("INSERT");
        if (i != 0) {
            if (i == 1) {
                str = " OR ROLLBACK";
            } else if (i == 2) {
                str = " OR ABORT";
            } else if (i == 3) {
                str = " OR FAIL";
            } else if (i == 4) {
                str = " OR IGNORE";
            } else if (i == 5) {
                str = " OR REPLACE";
            } else {
                throw new IllegalArgumentException(C0681a.m316a("Invalid OnConflict algorithm: ", i));
            }
            a.append(str);
        }
        a.append(" INTO `RFLEntityPedometer` (`timestamp`) VALUES (?)");
        return a.toString();
    }

    @NonNull
    public Class<RFLEntityPedometer> getModelClass() {
        return RFLEntityPedometer.class;
    }

    @NonNull
    public C0695c<RFLEntityPedometer, Long> getPrimaryKey() {
        return this._rowid_;
    }

    @NonNull
    public String getSelectFromTableClause() {
        StringBuilder a = C0681a.m330a("`RFLEntityPedometer`");
        a.append(this.f3690a != null ? C0681a.m323a(C0681a.m330a(" AS `"), this.f3690a, '`') : "");
        return a.toString();
    }

    @Nullable
    public String getTableAlias() {
        return this.f3690a;
    }

    @NonNull
    public String getTableName() {
        return "RFLEntityPedometer";
    }

    @NonNull
    public RFLEntityPedometer newModelFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
        return new RFLEntityPedometer(cursor.getLong(i + 0));
    }
}
