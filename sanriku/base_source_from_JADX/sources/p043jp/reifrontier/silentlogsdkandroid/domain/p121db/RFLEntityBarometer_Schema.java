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

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer_Schema */
public class RFLEntityBarometer_Schema implements C0707k<RFLEntityBarometer> {
    public static final RFLEntityBarometer_Schema INSTANCE;
    public final C0695c<RFLEntityBarometer, Long> _rowid_;
    @Nullable

    /* renamed from: a */
    private final String f3647a;

    /* renamed from: b */
    private final String[] f3648b;
    public final C0695c<RFLEntityBarometer, byte[]> data;
    public final C0695c<RFLEntityBarometer, String> date;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer_Schema$a */
    class C2310a extends C0695c<RFLEntityBarometer, Long> {
        C2310a(RFLEntityBarometer_Schema rFLEntityBarometer_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Long mo32779a(@NonNull RFLEntityBarometer rFLEntityBarometer) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        /* renamed from: b */
        public Long mo32780b(@NonNull RFLEntityBarometer rFLEntityBarometer) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object get(@NonNull Object obj) {
            mo32779a((RFLEntityBarometer) obj);
            throw null;
        }

        @NonNull
        public Long getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Long.valueOf(cursor.getLong(i));
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object getSerialized(@NonNull Object obj) {
            mo32780b((RFLEntityBarometer) obj);
            throw null;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer_Schema$b */
    class C2311b extends C0695c<RFLEntityBarometer, String> {
        C2311b(RFLEntityBarometer_Schema rFLEntityBarometer_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public String get(@NonNull RFLEntityBarometer rFLEntityBarometer) {
            return rFLEntityBarometer.getDate();
        }

        @NonNull
        /* renamed from: b */
        public String getSerialized(@NonNull RFLEntityBarometer rFLEntityBarometer) {
            return rFLEntityBarometer.getDate();
        }

        @NonNull
        public String getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getString(i);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer_Schema$c */
    class C2312c extends C0695c<RFLEntityBarometer, byte[]> {
        C2312c(RFLEntityBarometer_Schema rFLEntityBarometer_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public byte[] get(@NonNull RFLEntityBarometer rFLEntityBarometer) {
            return rFLEntityBarometer.getData();
        }

        @NonNull
        /* renamed from: b */
        public byte[] getSerialized(@NonNull RFLEntityBarometer rFLEntityBarometer) {
            return rFLEntityBarometer.getData();
        }

        @NonNull
        public byte[] getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getBlob(i);
        }
    }

    static {
        RFLEntityBarometer_Schema rFLEntityBarometer_Schema = new RFLEntityBarometer_Schema();
        C0730d.m411a(rFLEntityBarometer_Schema);
        INSTANCE = rFLEntityBarometer_Schema;
    }

    public RFLEntityBarometer_Schema() {
        this((C0727a) null);
    }

    public RFLEntityBarometer_Schema(@Nullable C0727a aVar) {
        if (aVar == null) {
            this.f3647a = null;
            this._rowid_ = new C2310a(this, this, "_rowid_", Long.TYPE, "INTEGER", C0695c.PRIMARY_KEY | C0695c.AUTO_VALUE);
            this.date = new C2311b(this, this, "date", String.class, "TEXT", C0695c.INDEXED);
            this.data = new C2312c(this, this, "data", byte[].class, "BLOB", 0);
            this.f3648b = new String[]{this.date.getQualifiedName(), this.data.getQualifiedName()};
            return;
        }
        throw null;
    }

    public void bindArgs(@NonNull C0700h hVar, @NonNull C0713c cVar, @NonNull RFLEntityBarometer rFLEntityBarometer, boolean z) {
        cVar.mo19902a(1, rFLEntityBarometer.getDate());
        cVar.mo19903a(2, rFLEntityBarometer.getData());
    }

    @NonNull
    public Object[] convertToArgs(@NonNull C0700h hVar, @NonNull RFLEntityBarometer rFLEntityBarometer, boolean z) {
        Object[] objArr = new Object[2];
        if (rFLEntityBarometer.getDate() != null) {
            objArr[0] = rFLEntityBarometer.getDate();
            if (rFLEntityBarometer.getData() != null) {
                objArr[1] = rFLEntityBarometer.getData();
                return objArr;
            }
            throw new IllegalArgumentException("RFLEntityBarometer.data must not be null, or use @Nullable to declare it as NULL");
        }
        throw new IllegalArgumentException("RFLEntityBarometer.date must not be null, or use @Nullable to declare it as NULL");
    }

    @NonNull
    public ContentValues convertToContentValues(@NonNull C0700h hVar, @NonNull RFLEntityBarometer rFLEntityBarometer, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", rFLEntityBarometer.getDate());
        contentValues.put("data", rFLEntityBarometer.getData());
        return contentValues;
    }

    @NonNull
    public List<C0695c<RFLEntityBarometer, ?>> getColumns() {
        return Arrays.asList(new C0695c[]{this.date, this.data});
    }

    @NonNull
    public List<String> getCreateIndexStatements() {
        return Arrays.asList(new String[]{"CREATE INDEX `index_date_on_RFLEntityBarometer` ON `RFLEntityBarometer` (`date`)"});
    }

    @NonNull
    public String getCreateTableStatement() {
        return "CREATE TABLE `RFLEntityBarometer` (`date` TEXT NOT NULL, `data` BLOB NOT NULL)";
    }

    @NonNull
    public String[] getDefaultResultColumns() {
        return this.f3648b;
    }

    @NonNull
    public String getDropTableStatement() {
        return "DROP TABLE IF EXISTS `RFLEntityBarometer`";
    }

    @Nullable
    public String getEscapedTableAlias() {
        if (this.f3647a != null) {
            return C0681a.m323a(C0681a.m329a('`'), this.f3647a, '`');
        }
        return null;
    }

    @NonNull
    public String getEscapedTableName() {
        return "`RFLEntityBarometer`";
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
        a.append(" INTO `RFLEntityBarometer` (`date`,`data`) VALUES (?,?)");
        return a.toString();
    }

    @NonNull
    public Class<RFLEntityBarometer> getModelClass() {
        return RFLEntityBarometer.class;
    }

    @NonNull
    public C0695c<RFLEntityBarometer, Long> getPrimaryKey() {
        return this._rowid_;
    }

    @NonNull
    public String getSelectFromTableClause() {
        StringBuilder a = C0681a.m330a("`RFLEntityBarometer`");
        a.append(this.f3647a != null ? C0681a.m323a(C0681a.m330a(" AS `"), this.f3647a, '`') : "");
        return a.toString();
    }

    @Nullable
    public String getTableAlias() {
        return this.f3647a;
    }

    @NonNull
    public String getTableName() {
        return "RFLEntityBarometer";
    }

    @NonNull
    public RFLEntityBarometer newModelFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
        return new RFLEntityBarometer(cursor.getString(i + 0), cursor.getBlob(i + 1));
    }
}
