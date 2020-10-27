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

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity_Schema */
public class RFLEntityActivity_Schema implements C0707k<RFLEntityActivity> {
    public static final RFLEntityActivity_Schema INSTANCE;
    public final C0695c<RFLEntityActivity, Long> _rowid_;
    @Nullable

    /* renamed from: a */
    private final String f3627a;

    /* renamed from: b */
    private final String[] f3628b;
    public final C0695c<RFLEntityActivity, byte[]> data;
    public final C0695c<RFLEntityActivity, String> date;
    public final C0695c<RFLEntityActivity, String> timezone;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity_Schema$a */
    class C2302a extends C0695c<RFLEntityActivity, Long> {
        C2302a(RFLEntityActivity_Schema rFLEntityActivity_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Long mo32493a(@NonNull RFLEntityActivity rFLEntityActivity) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        /* renamed from: b */
        public Long mo32494b(@NonNull RFLEntityActivity rFLEntityActivity) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object get(@NonNull Object obj) {
            mo32493a((RFLEntityActivity) obj);
            throw null;
        }

        @NonNull
        public Long getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Long.valueOf(cursor.getLong(i));
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object getSerialized(@NonNull Object obj) {
            mo32494b((RFLEntityActivity) obj);
            throw null;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity_Schema$b */
    class C2303b extends C0695c<RFLEntityActivity, String> {
        C2303b(RFLEntityActivity_Schema rFLEntityActivity_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public String get(@NonNull RFLEntityActivity rFLEntityActivity) {
            return rFLEntityActivity.getDate();
        }

        @NonNull
        /* renamed from: b */
        public String getSerialized(@NonNull RFLEntityActivity rFLEntityActivity) {
            return rFLEntityActivity.getDate();
        }

        @NonNull
        public String getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getString(i);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity_Schema$c */
    class C2304c extends C0695c<RFLEntityActivity, String> {
        C2304c(RFLEntityActivity_Schema rFLEntityActivity_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public String get(@NonNull RFLEntityActivity rFLEntityActivity) {
            return rFLEntityActivity.getTimezone();
        }

        @NonNull
        /* renamed from: b */
        public String getSerialized(@NonNull RFLEntityActivity rFLEntityActivity) {
            return rFLEntityActivity.getTimezone();
        }

        @NonNull
        public String getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getString(i);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity_Schema$d */
    class C2305d extends C0695c<RFLEntityActivity, byte[]> {
        C2305d(RFLEntityActivity_Schema rFLEntityActivity_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public byte[] get(@NonNull RFLEntityActivity rFLEntityActivity) {
            return rFLEntityActivity.getData();
        }

        @NonNull
        /* renamed from: b */
        public byte[] getSerialized(@NonNull RFLEntityActivity rFLEntityActivity) {
            return rFLEntityActivity.getData();
        }

        @NonNull
        public byte[] getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getBlob(i);
        }
    }

    static {
        RFLEntityActivity_Schema rFLEntityActivity_Schema = new RFLEntityActivity_Schema();
        C0730d.m411a(rFLEntityActivity_Schema);
        INSTANCE = rFLEntityActivity_Schema;
    }

    public RFLEntityActivity_Schema() {
        this((C0727a) null);
    }

    public RFLEntityActivity_Schema(@Nullable C0727a aVar) {
        if (aVar == null) {
            this.f3627a = null;
            this._rowid_ = new C2302a(this, this, "_rowid_", Long.TYPE, "INTEGER", C0695c.PRIMARY_KEY | C0695c.AUTO_VALUE);
            this.date = new C2303b(this, this, "date", String.class, "TEXT", C0695c.INDEXED);
            this.timezone = new C2304c(this, this, "timezone", String.class, "TEXT", C0695c.INDEXED);
            this.data = new C2305d(this, this, "data", byte[].class, "BLOB", 0);
            this.f3628b = new String[]{this.date.getQualifiedName(), this.timezone.getQualifiedName(), this.data.getQualifiedName()};
            return;
        }
        throw null;
    }

    public void bindArgs(@NonNull C0700h hVar, @NonNull C0713c cVar, @NonNull RFLEntityActivity rFLEntityActivity, boolean z) {
        cVar.mo19902a(1, rFLEntityActivity.getDate());
        cVar.mo19902a(2, rFLEntityActivity.getTimezone());
        cVar.mo19903a(3, rFLEntityActivity.getData());
    }

    @NonNull
    public Object[] convertToArgs(@NonNull C0700h hVar, @NonNull RFLEntityActivity rFLEntityActivity, boolean z) {
        Object[] objArr = new Object[3];
        if (rFLEntityActivity.getDate() != null) {
            objArr[0] = rFLEntityActivity.getDate();
            if (rFLEntityActivity.getTimezone() != null) {
                objArr[1] = rFLEntityActivity.getTimezone();
                if (rFLEntityActivity.getData() != null) {
                    objArr[2] = rFLEntityActivity.getData();
                    return objArr;
                }
                throw new IllegalArgumentException("RFLEntityActivity.data must not be null, or use @Nullable to declare it as NULL");
            }
            throw new IllegalArgumentException("RFLEntityActivity.timezone must not be null, or use @Nullable to declare it as NULL");
        }
        throw new IllegalArgumentException("RFLEntityActivity.date must not be null, or use @Nullable to declare it as NULL");
    }

    @NonNull
    public ContentValues convertToContentValues(@NonNull C0700h hVar, @NonNull RFLEntityActivity rFLEntityActivity, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", rFLEntityActivity.getDate());
        contentValues.put("timezone", rFLEntityActivity.getTimezone());
        contentValues.put("data", rFLEntityActivity.getData());
        return contentValues;
    }

    @NonNull
    public List<C0695c<RFLEntityActivity, ?>> getColumns() {
        return Arrays.asList(new C0695c[]{this.date, this.timezone, this.data});
    }

    @NonNull
    public List<String> getCreateIndexStatements() {
        return Arrays.asList(new String[]{"CREATE INDEX `index_date_on_RFLEntityActivity` ON `RFLEntityActivity` (`date`)", "CREATE INDEX `index_timezone_on_RFLEntityActivity` ON `RFLEntityActivity` (`timezone`)"});
    }

    @NonNull
    public String getCreateTableStatement() {
        return "CREATE TABLE `RFLEntityActivity` (`date` TEXT NOT NULL, `timezone` TEXT NOT NULL, `data` BLOB NOT NULL)";
    }

    @NonNull
    public String[] getDefaultResultColumns() {
        return this.f3628b;
    }

    @NonNull
    public String getDropTableStatement() {
        return "DROP TABLE IF EXISTS `RFLEntityActivity`";
    }

    @Nullable
    public String getEscapedTableAlias() {
        if (this.f3627a != null) {
            return C0681a.m323a(C0681a.m329a('`'), this.f3627a, '`');
        }
        return null;
    }

    @NonNull
    public String getEscapedTableName() {
        return "`RFLEntityActivity`";
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
        a.append(" INTO `RFLEntityActivity` (`date`,`timezone`,`data`) VALUES (?,?,?)");
        return a.toString();
    }

    @NonNull
    public Class<RFLEntityActivity> getModelClass() {
        return RFLEntityActivity.class;
    }

    @NonNull
    public C0695c<RFLEntityActivity, Long> getPrimaryKey() {
        return this._rowid_;
    }

    @NonNull
    public String getSelectFromTableClause() {
        StringBuilder a = C0681a.m330a("`RFLEntityActivity`");
        a.append(this.f3627a != null ? C0681a.m323a(C0681a.m330a(" AS `"), this.f3627a, '`') : "");
        return a.toString();
    }

    @Nullable
    public String getTableAlias() {
        return this.f3627a;
    }

    @NonNull
    public String getTableName() {
        return "RFLEntityActivity";
    }

    @NonNull
    public RFLEntityActivity newModelFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
        return new RFLEntityActivity(cursor.getString(i + 0), cursor.getString(i + 1), cursor.getBlob(i + 2));
    }
}
