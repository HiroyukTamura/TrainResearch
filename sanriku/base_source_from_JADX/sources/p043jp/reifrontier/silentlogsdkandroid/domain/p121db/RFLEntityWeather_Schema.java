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

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather_Schema */
public class RFLEntityWeather_Schema implements C0707k<RFLEntityWeather> {
    public static final RFLEntityWeather_Schema INSTANCE;
    public final C0695c<RFLEntityWeather, Long> _rowid_;
    @Nullable

    /* renamed from: a */
    private final String f3736a;

    /* renamed from: b */
    private final String[] f3737b;
    public final C0695c<RFLEntityWeather, Integer> date;
    public final C0695c<RFLEntityWeather, String> pressure;
    public final C0695c<RFLEntityWeather, String> pressureIn;
    public final C0695c<RFLEntityWeather, Integer> temperature;
    public final C0695c<RFLEntityWeather, Integer> timestamp;
    public final C0695c<RFLEntityWeather, String> trend;
    public final C0695c<RFLEntityWeather, String> type;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather_Schema$a */
    class C2340a extends C0695c<RFLEntityWeather, Long> {
        C2340a(RFLEntityWeather_Schema rFLEntityWeather_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Long mo33782a(@NonNull RFLEntityWeather rFLEntityWeather) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        /* renamed from: b */
        public Long mo33783b(@NonNull RFLEntityWeather rFLEntityWeather) {
            throw new C0724d("Missing @PrimaryKey definition");
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object get(@NonNull Object obj) {
            mo33782a((RFLEntityWeather) obj);
            throw null;
        }

        @NonNull
        public Long getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Long.valueOf(cursor.getLong(i));
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object getSerialized(@NonNull Object obj) {
            mo33783b((RFLEntityWeather) obj);
            throw null;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather_Schema$b */
    class C2341b extends C0695c<RFLEntityWeather, Integer> {
        C2341b(RFLEntityWeather_Schema rFLEntityWeather_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull RFLEntityWeather rFLEntityWeather) {
            return Integer.valueOf(rFLEntityWeather.getDate());
        }

        @NonNull
        /* renamed from: b */
        public Integer getSerialized(@NonNull RFLEntityWeather rFLEntityWeather) {
            return Integer.valueOf(rFLEntityWeather.getDate());
        }

        @NonNull
        public Integer getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather_Schema$c */
    class C2342c extends C0695c<RFLEntityWeather, Integer> {
        C2342c(RFLEntityWeather_Schema rFLEntityWeather_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull RFLEntityWeather rFLEntityWeather) {
            return Integer.valueOf(rFLEntityWeather.getTemperature());
        }

        @NonNull
        /* renamed from: b */
        public Integer getSerialized(@NonNull RFLEntityWeather rFLEntityWeather) {
            return Integer.valueOf(rFLEntityWeather.getTemperature());
        }

        @NonNull
        public Integer getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather_Schema$d */
    class C2343d extends C0695c<RFLEntityWeather, Integer> {
        C2343d(RFLEntityWeather_Schema rFLEntityWeather_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull RFLEntityWeather rFLEntityWeather) {
            return Integer.valueOf(rFLEntityWeather.getTimestamp());
        }

        @NonNull
        /* renamed from: b */
        public Integer getSerialized(@NonNull RFLEntityWeather rFLEntityWeather) {
            return Integer.valueOf(rFLEntityWeather.getTimestamp());
        }

        @NonNull
        public Integer getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather_Schema$e */
    class C2344e extends C0695c<RFLEntityWeather, String> {
        C2344e(RFLEntityWeather_Schema rFLEntityWeather_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public String get(@NonNull RFLEntityWeather rFLEntityWeather) {
            return rFLEntityWeather.getPressure();
        }

        @NonNull
        /* renamed from: b */
        public String getSerialized(@NonNull RFLEntityWeather rFLEntityWeather) {
            return rFLEntityWeather.getPressure();
        }

        @NonNull
        public String getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getString(i);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather_Schema$f */
    class C2345f extends C0695c<RFLEntityWeather, String> {
        C2345f(RFLEntityWeather_Schema rFLEntityWeather_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public String get(@NonNull RFLEntityWeather rFLEntityWeather) {
            return rFLEntityWeather.getPressureIn();
        }

        @NonNull
        /* renamed from: b */
        public String getSerialized(@NonNull RFLEntityWeather rFLEntityWeather) {
            return rFLEntityWeather.getPressureIn();
        }

        @NonNull
        public String getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getString(i);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather_Schema$g */
    class C2346g extends C0695c<RFLEntityWeather, String> {
        C2346g(RFLEntityWeather_Schema rFLEntityWeather_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public String get(@NonNull RFLEntityWeather rFLEntityWeather) {
            return rFLEntityWeather.getTrend();
        }

        @NonNull
        /* renamed from: b */
        public String getSerialized(@NonNull RFLEntityWeather rFLEntityWeather) {
            return rFLEntityWeather.getTrend();
        }

        @NonNull
        public String getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getString(i);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather_Schema$h */
    class C2347h extends C0695c<RFLEntityWeather, String> {
        C2347h(RFLEntityWeather_Schema rFLEntityWeather_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public String get(@NonNull RFLEntityWeather rFLEntityWeather) {
            return rFLEntityWeather.getType();
        }

        @NonNull
        /* renamed from: b */
        public String getSerialized(@NonNull RFLEntityWeather rFLEntityWeather) {
            return rFLEntityWeather.getType();
        }

        @NonNull
        public String getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getString(i);
        }
    }

    static {
        RFLEntityWeather_Schema rFLEntityWeather_Schema = new RFLEntityWeather_Schema();
        C0730d.m411a(rFLEntityWeather_Schema);
        INSTANCE = rFLEntityWeather_Schema;
    }

    public RFLEntityWeather_Schema() {
        this((C0727a) null);
    }

    public RFLEntityWeather_Schema(@Nullable C0727a aVar) {
        if (aVar == null) {
            this.f3736a = null;
            this._rowid_ = new C2340a(this, this, "_rowid_", Long.TYPE, "INTEGER", C0695c.PRIMARY_KEY | C0695c.AUTO_VALUE);
            this.date = new C2341b(this, this, "date", Integer.TYPE, "INTEGER", C0695c.INDEXED);
            this.temperature = new C2342c(this, this, "temperature", Integer.TYPE, "INTEGER", 0);
            this.timestamp = new C2343d(this, this, "timestamp", Integer.TYPE, "INTEGER", 0);
            this.pressure = new C2344e(this, this, "pressure", String.class, "TEXT", 0);
            this.pressureIn = new C2345f(this, this, "pressureIn", String.class, "TEXT", 0);
            this.trend = new C2346g(this, this, "trend", String.class, "TEXT", 0);
            this.type = new C2347h(this, this, "type", String.class, "TEXT", 0);
            this.f3737b = new String[]{this.date.getQualifiedName(), this.temperature.getQualifiedName(), this.timestamp.getQualifiedName(), this.pressure.getQualifiedName(), this.pressureIn.getQualifiedName(), this.trend.getQualifiedName(), this.type.getQualifiedName()};
            return;
        }
        throw null;
    }

    public void bindArgs(@NonNull C0700h hVar, @NonNull C0713c cVar, @NonNull RFLEntityWeather rFLEntityWeather, boolean z) {
        cVar.mo19901a(1, (long) rFLEntityWeather.getDate());
        cVar.mo19901a(2, (long) rFLEntityWeather.getTemperature());
        cVar.mo19901a(3, (long) rFLEntityWeather.getTimestamp());
        cVar.mo19902a(4, rFLEntityWeather.getPressure());
        cVar.mo19902a(5, rFLEntityWeather.getPressureIn());
        cVar.mo19902a(6, rFLEntityWeather.getTrend());
        cVar.mo19902a(7, rFLEntityWeather.getType());
    }

    @NonNull
    public Object[] convertToArgs(@NonNull C0700h hVar, @NonNull RFLEntityWeather rFLEntityWeather, boolean z) {
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(rFLEntityWeather.getDate());
        objArr[1] = Integer.valueOf(rFLEntityWeather.getTemperature());
        objArr[2] = Integer.valueOf(rFLEntityWeather.getTimestamp());
        if (rFLEntityWeather.getPressure() != null) {
            objArr[3] = rFLEntityWeather.getPressure();
            if (rFLEntityWeather.getPressureIn() != null) {
                objArr[4] = rFLEntityWeather.getPressureIn();
                if (rFLEntityWeather.getTrend() != null) {
                    objArr[5] = rFLEntityWeather.getTrend();
                    if (rFLEntityWeather.getType() != null) {
                        objArr[6] = rFLEntityWeather.getType();
                        return objArr;
                    }
                    throw new IllegalArgumentException("RFLEntityWeather.type must not be null, or use @Nullable to declare it as NULL");
                }
                throw new IllegalArgumentException("RFLEntityWeather.trend must not be null, or use @Nullable to declare it as NULL");
            }
            throw new IllegalArgumentException("RFLEntityWeather.pressureIn must not be null, or use @Nullable to declare it as NULL");
        }
        throw new IllegalArgumentException("RFLEntityWeather.pressure must not be null, or use @Nullable to declare it as NULL");
    }

    @NonNull
    public ContentValues convertToContentValues(@NonNull C0700h hVar, @NonNull RFLEntityWeather rFLEntityWeather, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", Integer.valueOf(rFLEntityWeather.getDate()));
        contentValues.put("temperature", Integer.valueOf(rFLEntityWeather.getTemperature()));
        contentValues.put("timestamp", Integer.valueOf(rFLEntityWeather.getTimestamp()));
        contentValues.put("pressure", rFLEntityWeather.getPressure());
        contentValues.put("pressureIn", rFLEntityWeather.getPressureIn());
        contentValues.put("trend", rFLEntityWeather.getTrend());
        contentValues.put("type", rFLEntityWeather.getType());
        return contentValues;
    }

    @NonNull
    public List<C0695c<RFLEntityWeather, ?>> getColumns() {
        return Arrays.asList(new C0695c[]{this.date, this.temperature, this.timestamp, this.pressure, this.pressureIn, this.trend, this.type});
    }

    @NonNull
    public List<String> getCreateIndexStatements() {
        return Arrays.asList(new String[]{"CREATE INDEX `index_date_on_RFLEntityWeather` ON `RFLEntityWeather` (`date`)"});
    }

    @NonNull
    public String getCreateTableStatement() {
        return "CREATE TABLE `RFLEntityWeather` (`date` INTEGER NOT NULL, `temperature` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `pressure` TEXT NOT NULL, `pressureIn` TEXT NOT NULL, `trend` TEXT NOT NULL, `type` TEXT NOT NULL)";
    }

    @NonNull
    public String[] getDefaultResultColumns() {
        return this.f3737b;
    }

    @NonNull
    public String getDropTableStatement() {
        return "DROP TABLE IF EXISTS `RFLEntityWeather`";
    }

    @Nullable
    public String getEscapedTableAlias() {
        if (this.f3736a != null) {
            return C0681a.m323a(C0681a.m329a('`'), this.f3736a, '`');
        }
        return null;
    }

    @NonNull
    public String getEscapedTableName() {
        return "`RFLEntityWeather`";
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
        a.append(" INTO `RFLEntityWeather` (`date`,`temperature`,`timestamp`,`pressure`,`pressureIn`,`trend`,`type`) VALUES (?,?,?,?,?,?,?)");
        return a.toString();
    }

    @NonNull
    public Class<RFLEntityWeather> getModelClass() {
        return RFLEntityWeather.class;
    }

    @NonNull
    public C0695c<RFLEntityWeather, Long> getPrimaryKey() {
        return this._rowid_;
    }

    @NonNull
    public String getSelectFromTableClause() {
        StringBuilder a = C0681a.m330a("`RFLEntityWeather`");
        a.append(this.f3736a != null ? C0681a.m323a(C0681a.m330a(" AS `"), this.f3736a, '`') : "");
        return a.toString();
    }

    @Nullable
    public String getTableAlias() {
        return this.f3736a;
    }

    @NonNull
    public String getTableName() {
        return "RFLEntityWeather";
    }

    @NonNull
    public RFLEntityWeather newModelFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
        return new RFLEntityWeather(cursor.getInt(i + 0), cursor.getInt(i + 1), cursor.getInt(i + 2), cursor.getString(i + 3), cursor.getString(i + 4), cursor.getString(i + 5), cursor.getString(i + 6));
    }
}
