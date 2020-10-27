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

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTrackPoint_Schema */
public class RFLEntityTrackPoint_Schema implements C0707k<RFLEntityTrackPoint> {
    public static final RFLEntityTrackPoint_Schema INSTANCE;
    public final C0695c<RFLEntityTrackPoint, Long> _rowid_;
    @Nullable

    /* renamed from: a */
    private final String f3722a;

    /* renamed from: b */
    private final String[] f3723b;
    public final C0695c<RFLEntityTrackPoint, byte[]> data;
    public final C0695c<RFLEntityTrackPoint, String> date;
    public final C0695c<RFLEntityTrackPoint, String> timezone;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTrackPoint_Schema$a */
    class C2336a extends C0695c<RFLEntityTrackPoint, Long> {
        C2336a(RFLEntityTrackPoint_Schema rFLEntityTrackPoint_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Long mo33651a(@NonNull RFLEntityTrackPoint rFLEntityTrackPoint) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        /* renamed from: b */
        public Long mo33652b(@NonNull RFLEntityTrackPoint rFLEntityTrackPoint) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object get(@NonNull Object obj) {
            mo33651a((RFLEntityTrackPoint) obj);
            throw null;
        }

        @NonNull
        public Long getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Long.valueOf(cursor.getLong(i));
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object getSerialized(@NonNull Object obj) {
            mo33652b((RFLEntityTrackPoint) obj);
            throw null;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTrackPoint_Schema$b */
    class C2337b extends C0695c<RFLEntityTrackPoint, String> {
        C2337b(RFLEntityTrackPoint_Schema rFLEntityTrackPoint_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public String get(@NonNull RFLEntityTrackPoint rFLEntityTrackPoint) {
            return rFLEntityTrackPoint.getDate();
        }

        @NonNull
        /* renamed from: b */
        public String getSerialized(@NonNull RFLEntityTrackPoint rFLEntityTrackPoint) {
            return rFLEntityTrackPoint.getDate();
        }

        @NonNull
        public String getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getString(i);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTrackPoint_Schema$c */
    class C2338c extends C0695c<RFLEntityTrackPoint, String> {
        C2338c(RFLEntityTrackPoint_Schema rFLEntityTrackPoint_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public String get(@NonNull RFLEntityTrackPoint rFLEntityTrackPoint) {
            return rFLEntityTrackPoint.getTimezone();
        }

        @NonNull
        /* renamed from: b */
        public String getSerialized(@NonNull RFLEntityTrackPoint rFLEntityTrackPoint) {
            return rFLEntityTrackPoint.getTimezone();
        }

        @NonNull
        public String getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getString(i);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTrackPoint_Schema$d */
    class C2339d extends C0695c<RFLEntityTrackPoint, byte[]> {
        C2339d(RFLEntityTrackPoint_Schema rFLEntityTrackPoint_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public byte[] get(@NonNull RFLEntityTrackPoint rFLEntityTrackPoint) {
            return rFLEntityTrackPoint.getData();
        }

        @NonNull
        /* renamed from: b */
        public byte[] getSerialized(@NonNull RFLEntityTrackPoint rFLEntityTrackPoint) {
            return rFLEntityTrackPoint.getData();
        }

        @NonNull
        public byte[] getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getBlob(i);
        }
    }

    static {
        RFLEntityTrackPoint_Schema rFLEntityTrackPoint_Schema = new RFLEntityTrackPoint_Schema();
        C0730d.m411a(rFLEntityTrackPoint_Schema);
        INSTANCE = rFLEntityTrackPoint_Schema;
    }

    public RFLEntityTrackPoint_Schema() {
        this((C0727a) null);
    }

    public RFLEntityTrackPoint_Schema(@Nullable C0727a aVar) {
        if (aVar == null) {
            this.f3722a = null;
            this._rowid_ = new C2336a(this, this, "_rowid_", Long.TYPE, "INTEGER", C0695c.PRIMARY_KEY | C0695c.AUTO_VALUE);
            this.date = new C2337b(this, this, "date", String.class, "TEXT", C0695c.INDEXED);
            this.timezone = new C2338c(this, this, "timezone", String.class, "TEXT", C0695c.INDEXED);
            this.data = new C2339d(this, this, "data", byte[].class, "BLOB", 0);
            this.f3723b = new String[]{this.date.getQualifiedName(), this.timezone.getQualifiedName(), this.data.getQualifiedName()};
            return;
        }
        throw null;
    }

    public void bindArgs(@NonNull C0700h hVar, @NonNull C0713c cVar, @NonNull RFLEntityTrackPoint rFLEntityTrackPoint, boolean z) {
        cVar.mo19902a(1, rFLEntityTrackPoint.getDate());
        cVar.mo19902a(2, rFLEntityTrackPoint.getTimezone());
        cVar.mo19903a(3, rFLEntityTrackPoint.getData());
    }

    @NonNull
    public Object[] convertToArgs(@NonNull C0700h hVar, @NonNull RFLEntityTrackPoint rFLEntityTrackPoint, boolean z) {
        Object[] objArr = new Object[3];
        if (rFLEntityTrackPoint.getDate() != null) {
            objArr[0] = rFLEntityTrackPoint.getDate();
            if (rFLEntityTrackPoint.getTimezone() != null) {
                objArr[1] = rFLEntityTrackPoint.getTimezone();
                if (rFLEntityTrackPoint.getData() != null) {
                    objArr[2] = rFLEntityTrackPoint.getData();
                    return objArr;
                }
                throw new IllegalArgumentException("RFLEntityTrackPoint.data must not be null, or use @Nullable to declare it as NULL");
            }
            throw new IllegalArgumentException("RFLEntityTrackPoint.timezone must not be null, or use @Nullable to declare it as NULL");
        }
        throw new IllegalArgumentException("RFLEntityTrackPoint.date must not be null, or use @Nullable to declare it as NULL");
    }

    @NonNull
    public ContentValues convertToContentValues(@NonNull C0700h hVar, @NonNull RFLEntityTrackPoint rFLEntityTrackPoint, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", rFLEntityTrackPoint.getDate());
        contentValues.put("timezone", rFLEntityTrackPoint.getTimezone());
        contentValues.put("data", rFLEntityTrackPoint.getData());
        return contentValues;
    }

    @NonNull
    public List<C0695c<RFLEntityTrackPoint, ?>> getColumns() {
        return Arrays.asList(new C0695c[]{this.date, this.timezone, this.data});
    }

    @NonNull
    public List<String> getCreateIndexStatements() {
        return Arrays.asList(new String[]{"CREATE INDEX `index_date_on_RFLEntityTrackPoint` ON `RFLEntityTrackPoint` (`date`)", "CREATE INDEX `index_timezone_on_RFLEntityTrackPoint` ON `RFLEntityTrackPoint` (`timezone`)"});
    }

    @NonNull
    public String getCreateTableStatement() {
        return "CREATE TABLE `RFLEntityTrackPoint` (`date` TEXT NOT NULL, `timezone` TEXT NOT NULL, `data` BLOB NOT NULL)";
    }

    @NonNull
    public String[] getDefaultResultColumns() {
        return this.f3723b;
    }

    @NonNull
    public String getDropTableStatement() {
        return "DROP TABLE IF EXISTS `RFLEntityTrackPoint`";
    }

    @Nullable
    public String getEscapedTableAlias() {
        if (this.f3722a != null) {
            return C0681a.m323a(C0681a.m329a('`'), this.f3722a, '`');
        }
        return null;
    }

    @NonNull
    public String getEscapedTableName() {
        return "`RFLEntityTrackPoint`";
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
        a.append(" INTO `RFLEntityTrackPoint` (`date`,`timezone`,`data`) VALUES (?,?,?)");
        return a.toString();
    }

    @NonNull
    public Class<RFLEntityTrackPoint> getModelClass() {
        return RFLEntityTrackPoint.class;
    }

    @NonNull
    public C0695c<RFLEntityTrackPoint, Long> getPrimaryKey() {
        return this._rowid_;
    }

    @NonNull
    public String getSelectFromTableClause() {
        StringBuilder a = C0681a.m330a("`RFLEntityTrackPoint`");
        a.append(this.f3722a != null ? C0681a.m323a(C0681a.m330a(" AS `"), this.f3722a, '`') : "");
        return a.toString();
    }

    @Nullable
    public String getTableAlias() {
        return this.f3722a;
    }

    @NonNull
    public String getTableName() {
        return "RFLEntityTrackPoint";
    }

    @NonNull
    public RFLEntityTrackPoint newModelFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
        return new RFLEntityTrackPoint(cursor.getString(i + 0), cursor.getString(i + 1), cursor.getBlob(i + 2));
    }
}
