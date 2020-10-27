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

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily_Schema */
public class RFLEntityDaily_Schema implements C0707k<RFLEntityDaily> {
    public static final RFLEntityDaily_Schema INSTANCE;
    public final C0695c<RFLEntityDaily, Long> _rowid_;
    @Nullable

    /* renamed from: a */
    private final String f3668a;

    /* renamed from: b */
    private final String[] f3669b;
    public final C0695c<RFLEntityDaily, byte[]> data;
    public final C0695c<RFLEntityDaily, String> date;
    public final C0695c<RFLEntityDaily, String> timezone;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily_Schema$a */
    class C2316a extends C0695c<RFLEntityDaily, Long> {
        C2316a(RFLEntityDaily_Schema rFLEntityDaily_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Long mo33014a(@NonNull RFLEntityDaily rFLEntityDaily) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        /* renamed from: b */
        public Long mo33015b(@NonNull RFLEntityDaily rFLEntityDaily) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object get(@NonNull Object obj) {
            mo33014a((RFLEntityDaily) obj);
            throw null;
        }

        @NonNull
        public Long getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Long.valueOf(cursor.getLong(i));
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object getSerialized(@NonNull Object obj) {
            mo33015b((RFLEntityDaily) obj);
            throw null;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily_Schema$b */
    class C2317b extends C0695c<RFLEntityDaily, String> {
        C2317b(RFLEntityDaily_Schema rFLEntityDaily_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public String get(@NonNull RFLEntityDaily rFLEntityDaily) {
            return rFLEntityDaily.getDate();
        }

        @NonNull
        /* renamed from: b */
        public String getSerialized(@NonNull RFLEntityDaily rFLEntityDaily) {
            return rFLEntityDaily.getDate();
        }

        @NonNull
        public String getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getString(i);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily_Schema$c */
    class C2318c extends C0695c<RFLEntityDaily, String> {
        C2318c(RFLEntityDaily_Schema rFLEntityDaily_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public String get(@NonNull RFLEntityDaily rFLEntityDaily) {
            return rFLEntityDaily.getTimezone();
        }

        @NonNull
        /* renamed from: b */
        public String getSerialized(@NonNull RFLEntityDaily rFLEntityDaily) {
            return rFLEntityDaily.getTimezone();
        }

        @NonNull
        public String getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getString(i);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily_Schema$d */
    class C2319d extends C0695c<RFLEntityDaily, byte[]> {
        C2319d(RFLEntityDaily_Schema rFLEntityDaily_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public byte[] get(@NonNull RFLEntityDaily rFLEntityDaily) {
            return rFLEntityDaily.getData();
        }

        @NonNull
        /* renamed from: b */
        public byte[] getSerialized(@NonNull RFLEntityDaily rFLEntityDaily) {
            return rFLEntityDaily.getData();
        }

        @NonNull
        public byte[] getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getBlob(i);
        }
    }

    static {
        RFLEntityDaily_Schema rFLEntityDaily_Schema = new RFLEntityDaily_Schema();
        C0730d.m411a(rFLEntityDaily_Schema);
        INSTANCE = rFLEntityDaily_Schema;
    }

    public RFLEntityDaily_Schema() {
        this((C0727a) null);
    }

    public RFLEntityDaily_Schema(@Nullable C0727a aVar) {
        if (aVar == null) {
            this.f3668a = null;
            this._rowid_ = new C2316a(this, this, "_rowid_", Long.TYPE, "INTEGER", C0695c.PRIMARY_KEY | C0695c.AUTO_VALUE);
            this.date = new C2317b(this, this, "date", String.class, "TEXT", C0695c.INDEXED);
            this.timezone = new C2318c(this, this, "timezone", String.class, "TEXT", C0695c.INDEXED);
            this.data = new C2319d(this, this, "data", byte[].class, "BLOB", 0);
            this.f3669b = new String[]{this.date.getQualifiedName(), this.timezone.getQualifiedName(), this.data.getQualifiedName()};
            return;
        }
        throw null;
    }

    public void bindArgs(@NonNull C0700h hVar, @NonNull C0713c cVar, @NonNull RFLEntityDaily rFLEntityDaily, boolean z) {
        cVar.mo19902a(1, rFLEntityDaily.getDate());
        cVar.mo19902a(2, rFLEntityDaily.getTimezone());
        cVar.mo19903a(3, rFLEntityDaily.getData());
    }

    @NonNull
    public Object[] convertToArgs(@NonNull C0700h hVar, @NonNull RFLEntityDaily rFLEntityDaily, boolean z) {
        Object[] objArr = new Object[3];
        if (rFLEntityDaily.getDate() != null) {
            objArr[0] = rFLEntityDaily.getDate();
            if (rFLEntityDaily.getTimezone() != null) {
                objArr[1] = rFLEntityDaily.getTimezone();
                if (rFLEntityDaily.getData() != null) {
                    objArr[2] = rFLEntityDaily.getData();
                    return objArr;
                }
                throw new IllegalArgumentException("RFLEntityDaily.data must not be null, or use @Nullable to declare it as NULL");
            }
            throw new IllegalArgumentException("RFLEntityDaily.timezone must not be null, or use @Nullable to declare it as NULL");
        }
        throw new IllegalArgumentException("RFLEntityDaily.date must not be null, or use @Nullable to declare it as NULL");
    }

    @NonNull
    public ContentValues convertToContentValues(@NonNull C0700h hVar, @NonNull RFLEntityDaily rFLEntityDaily, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", rFLEntityDaily.getDate());
        contentValues.put("timezone", rFLEntityDaily.getTimezone());
        contentValues.put("data", rFLEntityDaily.getData());
        return contentValues;
    }

    @NonNull
    public List<C0695c<RFLEntityDaily, ?>> getColumns() {
        return Arrays.asList(new C0695c[]{this.date, this.timezone, this.data});
    }

    @NonNull
    public List<String> getCreateIndexStatements() {
        return Arrays.asList(new String[]{"CREATE INDEX `index_date_on_RFLEntityDaily` ON `RFLEntityDaily` (`date`)", "CREATE INDEX `index_timezone_on_RFLEntityDaily` ON `RFLEntityDaily` (`timezone`)"});
    }

    @NonNull
    public String getCreateTableStatement() {
        return "CREATE TABLE `RFLEntityDaily` (`date` TEXT NOT NULL, `timezone` TEXT NOT NULL, `data` BLOB NOT NULL)";
    }

    @NonNull
    public String[] getDefaultResultColumns() {
        return this.f3669b;
    }

    @NonNull
    public String getDropTableStatement() {
        return "DROP TABLE IF EXISTS `RFLEntityDaily`";
    }

    @Nullable
    public String getEscapedTableAlias() {
        if (this.f3668a != null) {
            return C0681a.m323a(C0681a.m329a('`'), this.f3668a, '`');
        }
        return null;
    }

    @NonNull
    public String getEscapedTableName() {
        return "`RFLEntityDaily`";
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
        a.append(" INTO `RFLEntityDaily` (`date`,`timezone`,`data`) VALUES (?,?,?)");
        return a.toString();
    }

    @NonNull
    public Class<RFLEntityDaily> getModelClass() {
        return RFLEntityDaily.class;
    }

    @NonNull
    public C0695c<RFLEntityDaily, Long> getPrimaryKey() {
        return this._rowid_;
    }

    @NonNull
    public String getSelectFromTableClause() {
        StringBuilder a = C0681a.m330a("`RFLEntityDaily`");
        a.append(this.f3668a != null ? C0681a.m323a(C0681a.m330a(" AS `"), this.f3668a, '`') : "");
        return a.toString();
    }

    @Nullable
    public String getTableAlias() {
        return this.f3668a;
    }

    @NonNull
    public String getTableName() {
        return "RFLEntityDaily";
    }

    @NonNull
    public RFLEntityDaily newModelFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
        return new RFLEntityDaily(cursor.getString(i + 0), cursor.getString(i + 1), cursor.getBlob(i + 2));
    }
}
