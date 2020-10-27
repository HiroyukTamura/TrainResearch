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

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint_Schema */
public class RFLEntityAdjustTrackPoint_Schema implements C0707k<RFLEntityAdjustTrackPoint> {
    public static final RFLEntityAdjustTrackPoint_Schema INSTANCE;
    public final C0695c<RFLEntityAdjustTrackPoint, Long> _rowid_;
    @Nullable

    /* renamed from: a */
    private final String f3637a;

    /* renamed from: b */
    private final String[] f3638b;
    public final C0695c<RFLEntityAdjustTrackPoint, byte[]> data;
    public final C0695c<RFLEntityAdjustTrackPoint, Integer> fromDate;
    public final C0695c<RFLEntityAdjustTrackPoint, Integer> toDate;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint_Schema$a */
    class C2306a extends C0695c<RFLEntityAdjustTrackPoint, Long> {
        C2306a(RFLEntityAdjustTrackPoint_Schema rFLEntityAdjustTrackPoint_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Long mo32652a(@NonNull RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        /* renamed from: b */
        public Long mo32653b(@NonNull RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object get(@NonNull Object obj) {
            mo32652a((RFLEntityAdjustTrackPoint) obj);
            throw null;
        }

        @NonNull
        public Long getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Long.valueOf(cursor.getLong(i));
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object getSerialized(@NonNull Object obj) {
            mo32653b((RFLEntityAdjustTrackPoint) obj);
            throw null;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint_Schema$b */
    class C2307b extends C0695c<RFLEntityAdjustTrackPoint, Integer> {
        C2307b(RFLEntityAdjustTrackPoint_Schema rFLEntityAdjustTrackPoint_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint) {
            return Integer.valueOf(rFLEntityAdjustTrackPoint.getFromDate());
        }

        @NonNull
        /* renamed from: b */
        public Integer getSerialized(@NonNull RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint) {
            return Integer.valueOf(rFLEntityAdjustTrackPoint.getFromDate());
        }

        @NonNull
        public Integer getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint_Schema$c */
    class C2308c extends C0695c<RFLEntityAdjustTrackPoint, Integer> {
        C2308c(RFLEntityAdjustTrackPoint_Schema rFLEntityAdjustTrackPoint_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint) {
            return Integer.valueOf(rFLEntityAdjustTrackPoint.getToDate());
        }

        @NonNull
        /* renamed from: b */
        public Integer getSerialized(@NonNull RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint) {
            return Integer.valueOf(rFLEntityAdjustTrackPoint.getToDate());
        }

        @NonNull
        public Integer getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint_Schema$d */
    class C2309d extends C0695c<RFLEntityAdjustTrackPoint, byte[]> {
        C2309d(RFLEntityAdjustTrackPoint_Schema rFLEntityAdjustTrackPoint_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public byte[] get(@NonNull RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint) {
            return rFLEntityAdjustTrackPoint.getData();
        }

        @NonNull
        /* renamed from: b */
        public byte[] getSerialized(@NonNull RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint) {
            return rFLEntityAdjustTrackPoint.getData();
        }

        @NonNull
        public byte[] getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getBlob(i);
        }
    }

    static {
        RFLEntityAdjustTrackPoint_Schema rFLEntityAdjustTrackPoint_Schema = new RFLEntityAdjustTrackPoint_Schema();
        C0730d.m411a(rFLEntityAdjustTrackPoint_Schema);
        INSTANCE = rFLEntityAdjustTrackPoint_Schema;
    }

    public RFLEntityAdjustTrackPoint_Schema() {
        this((C0727a) null);
    }

    public RFLEntityAdjustTrackPoint_Schema(@Nullable C0727a aVar) {
        if (aVar == null) {
            this.f3637a = null;
            this._rowid_ = new C2306a(this, this, "_rowid_", Long.TYPE, "INTEGER", C0695c.PRIMARY_KEY | C0695c.AUTO_VALUE);
            this.fromDate = new C2307b(this, this, "fromDate", Integer.TYPE, "INTEGER", C0695c.INDEXED);
            this.toDate = new C2308c(this, this, "toDate", Integer.TYPE, "INTEGER", C0695c.INDEXED);
            this.data = new C2309d(this, this, "data", byte[].class, "BLOB", 0);
            this.f3638b = new String[]{this.fromDate.getQualifiedName(), this.toDate.getQualifiedName(), this.data.getQualifiedName()};
            return;
        }
        throw null;
    }

    public void bindArgs(@NonNull C0700h hVar, @NonNull C0713c cVar, @NonNull RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint, boolean z) {
        cVar.mo19901a(1, (long) rFLEntityAdjustTrackPoint.getFromDate());
        cVar.mo19901a(2, (long) rFLEntityAdjustTrackPoint.getToDate());
        cVar.mo19903a(3, rFLEntityAdjustTrackPoint.getData());
    }

    @NonNull
    public Object[] convertToArgs(@NonNull C0700h hVar, @NonNull RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint, boolean z) {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(rFLEntityAdjustTrackPoint.getFromDate());
        objArr[1] = Integer.valueOf(rFLEntityAdjustTrackPoint.getToDate());
        if (rFLEntityAdjustTrackPoint.getData() != null) {
            objArr[2] = rFLEntityAdjustTrackPoint.getData();
            return objArr;
        }
        throw new IllegalArgumentException("RFLEntityAdjustTrackPoint.data must not be null, or use @Nullable to declare it as NULL");
    }

    @NonNull
    public ContentValues convertToContentValues(@NonNull C0700h hVar, @NonNull RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("fromDate", Integer.valueOf(rFLEntityAdjustTrackPoint.getFromDate()));
        contentValues.put("toDate", Integer.valueOf(rFLEntityAdjustTrackPoint.getToDate()));
        contentValues.put("data", rFLEntityAdjustTrackPoint.getData());
        return contentValues;
    }

    @NonNull
    public List<C0695c<RFLEntityAdjustTrackPoint, ?>> getColumns() {
        return Arrays.asList(new C0695c[]{this.fromDate, this.toDate, this.data});
    }

    @NonNull
    public List<String> getCreateIndexStatements() {
        return Arrays.asList(new String[]{"CREATE INDEX `index_fromDate_on_RFLEntityAdjustTrackPoint` ON `RFLEntityAdjustTrackPoint` (`fromDate`)", "CREATE INDEX `index_toDate_on_RFLEntityAdjustTrackPoint` ON `RFLEntityAdjustTrackPoint` (`toDate`)"});
    }

    @NonNull
    public String getCreateTableStatement() {
        return "CREATE TABLE `RFLEntityAdjustTrackPoint` (`fromDate` INTEGER NOT NULL, `toDate` INTEGER NOT NULL, `data` BLOB NOT NULL)";
    }

    @NonNull
    public String[] getDefaultResultColumns() {
        return this.f3638b;
    }

    @NonNull
    public String getDropTableStatement() {
        return "DROP TABLE IF EXISTS `RFLEntityAdjustTrackPoint`";
    }

    @Nullable
    public String getEscapedTableAlias() {
        if (this.f3637a != null) {
            return C0681a.m323a(C0681a.m329a('`'), this.f3637a, '`');
        }
        return null;
    }

    @NonNull
    public String getEscapedTableName() {
        return "`RFLEntityAdjustTrackPoint`";
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
        a.append(" INTO `RFLEntityAdjustTrackPoint` (`fromDate`,`toDate`,`data`) VALUES (?,?,?)");
        return a.toString();
    }

    @NonNull
    public Class<RFLEntityAdjustTrackPoint> getModelClass() {
        return RFLEntityAdjustTrackPoint.class;
    }

    @NonNull
    public C0695c<RFLEntityAdjustTrackPoint, Long> getPrimaryKey() {
        return this._rowid_;
    }

    @NonNull
    public String getSelectFromTableClause() {
        StringBuilder a = C0681a.m330a("`RFLEntityAdjustTrackPoint`");
        a.append(this.f3637a != null ? C0681a.m323a(C0681a.m330a(" AS `"), this.f3637a, '`') : "");
        return a.toString();
    }

    @Nullable
    public String getTableAlias() {
        return this.f3637a;
    }

    @NonNull
    public String getTableName() {
        return "RFLEntityAdjustTrackPoint";
    }

    @NonNull
    public RFLEntityAdjustTrackPoint newModelFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
        return new RFLEntityAdjustTrackPoint(cursor.getInt(i + 0), cursor.getInt(i + 1), cursor.getBlob(i + 2));
    }
}
