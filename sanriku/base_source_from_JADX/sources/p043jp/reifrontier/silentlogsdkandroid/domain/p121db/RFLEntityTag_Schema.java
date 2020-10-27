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

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag_Schema */
public class RFLEntityTag_Schema implements C0707k<RFLEntityTag> {
    public static final RFLEntityTag_Schema INSTANCE;
    public final C0695c<RFLEntityTag, Long> _rowid_;
    @Nullable

    /* renamed from: a */
    private final String f3711a;

    /* renamed from: b */
    private final String[] f3712b;
    public final C0695c<RFLEntityTag, byte[]> data;
    public final C0695c<RFLEntityTag, Integer> fromDate;
    public final C0695c<RFLEntityTag, Integer> toDate;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag_Schema$a */
    class C2332a extends C0695c<RFLEntityTag, Long> {
        C2332a(RFLEntityTag_Schema rFLEntityTag_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Long mo33478a(@NonNull RFLEntityTag rFLEntityTag) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        /* renamed from: b */
        public Long mo33479b(@NonNull RFLEntityTag rFLEntityTag) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object get(@NonNull Object obj) {
            mo33478a((RFLEntityTag) obj);
            throw null;
        }

        @NonNull
        public Long getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Long.valueOf(cursor.getLong(i));
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object getSerialized(@NonNull Object obj) {
            mo33479b((RFLEntityTag) obj);
            throw null;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag_Schema$b */
    class C2333b extends C0695c<RFLEntityTag, Integer> {
        C2333b(RFLEntityTag_Schema rFLEntityTag_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull RFLEntityTag rFLEntityTag) {
            return Integer.valueOf(rFLEntityTag.getFromDate());
        }

        @NonNull
        /* renamed from: b */
        public Integer getSerialized(@NonNull RFLEntityTag rFLEntityTag) {
            return Integer.valueOf(rFLEntityTag.getFromDate());
        }

        @NonNull
        public Integer getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag_Schema$c */
    class C2334c extends C0695c<RFLEntityTag, Integer> {
        C2334c(RFLEntityTag_Schema rFLEntityTag_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull RFLEntityTag rFLEntityTag) {
            return Integer.valueOf(rFLEntityTag.getToDate());
        }

        @NonNull
        /* renamed from: b */
        public Integer getSerialized(@NonNull RFLEntityTag rFLEntityTag) {
            return Integer.valueOf(rFLEntityTag.getToDate());
        }

        @NonNull
        public Integer getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag_Schema$d */
    class C2335d extends C0695c<RFLEntityTag, byte[]> {
        C2335d(RFLEntityTag_Schema rFLEntityTag_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public byte[] get(@NonNull RFLEntityTag rFLEntityTag) {
            return rFLEntityTag.getData();
        }

        @NonNull
        /* renamed from: b */
        public byte[] getSerialized(@NonNull RFLEntityTag rFLEntityTag) {
            return rFLEntityTag.getData();
        }

        @NonNull
        public byte[] getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getBlob(i);
        }
    }

    static {
        RFLEntityTag_Schema rFLEntityTag_Schema = new RFLEntityTag_Schema();
        C0730d.m411a(rFLEntityTag_Schema);
        INSTANCE = rFLEntityTag_Schema;
    }

    public RFLEntityTag_Schema() {
        this((C0727a) null);
    }

    public RFLEntityTag_Schema(@Nullable C0727a aVar) {
        if (aVar == null) {
            this.f3711a = null;
            this._rowid_ = new C2332a(this, this, "_rowid_", Long.TYPE, "INTEGER", C0695c.PRIMARY_KEY | C0695c.AUTO_VALUE);
            this.fromDate = new C2333b(this, this, "fromDate", Integer.TYPE, "INTEGER", C0695c.INDEXED);
            this.toDate = new C2334c(this, this, "toDate", Integer.TYPE, "INTEGER", C0695c.INDEXED);
            this.data = new C2335d(this, this, "data", byte[].class, "BLOB", 0);
            this.f3712b = new String[]{this.fromDate.getQualifiedName(), this.toDate.getQualifiedName(), this.data.getQualifiedName()};
            return;
        }
        throw null;
    }

    public void bindArgs(@NonNull C0700h hVar, @NonNull C0713c cVar, @NonNull RFLEntityTag rFLEntityTag, boolean z) {
        cVar.mo19901a(1, (long) rFLEntityTag.getFromDate());
        cVar.mo19901a(2, (long) rFLEntityTag.getToDate());
        cVar.mo19903a(3, rFLEntityTag.getData());
    }

    @NonNull
    public Object[] convertToArgs(@NonNull C0700h hVar, @NonNull RFLEntityTag rFLEntityTag, boolean z) {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(rFLEntityTag.getFromDate());
        objArr[1] = Integer.valueOf(rFLEntityTag.getToDate());
        if (rFLEntityTag.getData() != null) {
            objArr[2] = rFLEntityTag.getData();
            return objArr;
        }
        throw new IllegalArgumentException("RFLEntityTag.data must not be null, or use @Nullable to declare it as NULL");
    }

    @NonNull
    public ContentValues convertToContentValues(@NonNull C0700h hVar, @NonNull RFLEntityTag rFLEntityTag, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("fromDate", Integer.valueOf(rFLEntityTag.getFromDate()));
        contentValues.put("toDate", Integer.valueOf(rFLEntityTag.getToDate()));
        contentValues.put("data", rFLEntityTag.getData());
        return contentValues;
    }

    @NonNull
    public List<C0695c<RFLEntityTag, ?>> getColumns() {
        return Arrays.asList(new C0695c[]{this.fromDate, this.toDate, this.data});
    }

    @NonNull
    public List<String> getCreateIndexStatements() {
        return Arrays.asList(new String[]{"CREATE INDEX `index_fromDate_on_RFLEntityTag` ON `RFLEntityTag` (`fromDate`)", "CREATE INDEX `index_toDate_on_RFLEntityTag` ON `RFLEntityTag` (`toDate`)"});
    }

    @NonNull
    public String getCreateTableStatement() {
        return "CREATE TABLE `RFLEntityTag` (`fromDate` INTEGER NOT NULL, `toDate` INTEGER NOT NULL, `data` BLOB NOT NULL)";
    }

    @NonNull
    public String[] getDefaultResultColumns() {
        return this.f3712b;
    }

    @NonNull
    public String getDropTableStatement() {
        return "DROP TABLE IF EXISTS `RFLEntityTag`";
    }

    @Nullable
    public String getEscapedTableAlias() {
        if (this.f3711a != null) {
            return C0681a.m323a(C0681a.m329a('`'), this.f3711a, '`');
        }
        return null;
    }

    @NonNull
    public String getEscapedTableName() {
        return "`RFLEntityTag`";
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
        a.append(" INTO `RFLEntityTag` (`fromDate`,`toDate`,`data`) VALUES (?,?,?)");
        return a.toString();
    }

    @NonNull
    public Class<RFLEntityTag> getModelClass() {
        return RFLEntityTag.class;
    }

    @NonNull
    public C0695c<RFLEntityTag, Long> getPrimaryKey() {
        return this._rowid_;
    }

    @NonNull
    public String getSelectFromTableClause() {
        StringBuilder a = C0681a.m330a("`RFLEntityTag`");
        a.append(this.f3711a != null ? C0681a.m323a(C0681a.m330a(" AS `"), this.f3711a, '`') : "");
        return a.toString();
    }

    @Nullable
    public String getTableAlias() {
        return this.f3711a;
    }

    @NonNull
    public String getTableName() {
        return "RFLEntityTag";
    }

    @NonNull
    public RFLEntityTag newModelFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
        return new RFLEntityTag(cursor.getInt(i + 0), cursor.getInt(i + 1), cursor.getBlob(i + 2));
    }
}
