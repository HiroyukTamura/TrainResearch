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

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTP_Schema */
public class RFLEntityTP_Schema implements C0707k<RFLEntityTP> {
    public static final RFLEntityTP_Schema INSTANCE;
    public final C0695c<RFLEntityTP, Long> _rowid_;
    @Nullable

    /* renamed from: a */
    private final String f3700a;

    /* renamed from: b */
    private final String[] f3701b;
    public final C0695c<RFLEntityTP, byte[]> data;
    public final C0695c<RFLEntityTP, String> date;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTP_Schema$a */
    class C2329a extends C0695c<RFLEntityTP, Long> {
        C2329a(RFLEntityTP_Schema rFLEntityTP_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Long mo33352a(@NonNull RFLEntityTP rFLEntityTP) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        /* renamed from: b */
        public Long mo33353b(@NonNull RFLEntityTP rFLEntityTP) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object get(@NonNull Object obj) {
            mo33352a((RFLEntityTP) obj);
            throw null;
        }

        @NonNull
        public Long getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Long.valueOf(cursor.getLong(i));
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object getSerialized(@NonNull Object obj) {
            mo33353b((RFLEntityTP) obj);
            throw null;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTP_Schema$b */
    class C2330b extends C0695c<RFLEntityTP, String> {
        C2330b(RFLEntityTP_Schema rFLEntityTP_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public String get(@NonNull RFLEntityTP rFLEntityTP) {
            return rFLEntityTP.getDate();
        }

        @NonNull
        /* renamed from: b */
        public String getSerialized(@NonNull RFLEntityTP rFLEntityTP) {
            return rFLEntityTP.getDate();
        }

        @NonNull
        public String getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getString(i);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTP_Schema$c */
    class C2331c extends C0695c<RFLEntityTP, byte[]> {
        C2331c(RFLEntityTP_Schema rFLEntityTP_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public byte[] get(@NonNull RFLEntityTP rFLEntityTP) {
            return rFLEntityTP.getData();
        }

        @NonNull
        /* renamed from: b */
        public byte[] getSerialized(@NonNull RFLEntityTP rFLEntityTP) {
            return rFLEntityTP.getData();
        }

        @NonNull
        public byte[] getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getBlob(i);
        }
    }

    static {
        RFLEntityTP_Schema rFLEntityTP_Schema = new RFLEntityTP_Schema();
        C0730d.m411a(rFLEntityTP_Schema);
        INSTANCE = rFLEntityTP_Schema;
    }

    public RFLEntityTP_Schema() {
        this((C0727a) null);
    }

    public RFLEntityTP_Schema(@Nullable C0727a aVar) {
        if (aVar == null) {
            this.f3700a = null;
            this._rowid_ = new C2329a(this, this, "_rowid_", Long.TYPE, "INTEGER", C0695c.PRIMARY_KEY | C0695c.AUTO_VALUE);
            this.date = new C2330b(this, this, "date", String.class, "TEXT", C0695c.INDEXED);
            this.data = new C2331c(this, this, "data", byte[].class, "BLOB", 0);
            this.f3701b = new String[]{this.date.getQualifiedName(), this.data.getQualifiedName()};
            return;
        }
        throw null;
    }

    public void bindArgs(@NonNull C0700h hVar, @NonNull C0713c cVar, @NonNull RFLEntityTP rFLEntityTP, boolean z) {
        cVar.mo19902a(1, rFLEntityTP.getDate());
        cVar.mo19903a(2, rFLEntityTP.getData());
    }

    @NonNull
    public Object[] convertToArgs(@NonNull C0700h hVar, @NonNull RFLEntityTP rFLEntityTP, boolean z) {
        Object[] objArr = new Object[2];
        if (rFLEntityTP.getDate() != null) {
            objArr[0] = rFLEntityTP.getDate();
            if (rFLEntityTP.getData() != null) {
                objArr[1] = rFLEntityTP.getData();
                return objArr;
            }
            throw new IllegalArgumentException("RFLEntityTP.data must not be null, or use @Nullable to declare it as NULL");
        }
        throw new IllegalArgumentException("RFLEntityTP.date must not be null, or use @Nullable to declare it as NULL");
    }

    @NonNull
    public ContentValues convertToContentValues(@NonNull C0700h hVar, @NonNull RFLEntityTP rFLEntityTP, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", rFLEntityTP.getDate());
        contentValues.put("data", rFLEntityTP.getData());
        return contentValues;
    }

    @NonNull
    public List<C0695c<RFLEntityTP, ?>> getColumns() {
        return Arrays.asList(new C0695c[]{this.date, this.data});
    }

    @NonNull
    public List<String> getCreateIndexStatements() {
        return Arrays.asList(new String[]{"CREATE INDEX `index_date_on_RFLEntityTP` ON `RFLEntityTP` (`date`)"});
    }

    @NonNull
    public String getCreateTableStatement() {
        return "CREATE TABLE `RFLEntityTP` (`date` TEXT NOT NULL, `data` BLOB NOT NULL)";
    }

    @NonNull
    public String[] getDefaultResultColumns() {
        return this.f3701b;
    }

    @NonNull
    public String getDropTableStatement() {
        return "DROP TABLE IF EXISTS `RFLEntityTP`";
    }

    @Nullable
    public String getEscapedTableAlias() {
        if (this.f3700a != null) {
            return C0681a.m323a(C0681a.m329a('`'), this.f3700a, '`');
        }
        return null;
    }

    @NonNull
    public String getEscapedTableName() {
        return "`RFLEntityTP`";
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
        a.append(" INTO `RFLEntityTP` (`date`,`data`) VALUES (?,?)");
        return a.toString();
    }

    @NonNull
    public Class<RFLEntityTP> getModelClass() {
        return RFLEntityTP.class;
    }

    @NonNull
    public C0695c<RFLEntityTP, Long> getPrimaryKey() {
        return this._rowid_;
    }

    @NonNull
    public String getSelectFromTableClause() {
        StringBuilder a = C0681a.m330a("`RFLEntityTP`");
        a.append(this.f3700a != null ? C0681a.m323a(C0681a.m330a(" AS `"), this.f3700a, '`') : "");
        return a.toString();
    }

    @Nullable
    public String getTableAlias() {
        return this.f3700a;
    }

    @NonNull
    public String getTableName() {
        return "RFLEntityTP";
    }

    @NonNull
    public RFLEntityTP newModelFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
        return new RFLEntityTP(cursor.getString(i + 0), cursor.getBlob(i + 1));
    }
}
