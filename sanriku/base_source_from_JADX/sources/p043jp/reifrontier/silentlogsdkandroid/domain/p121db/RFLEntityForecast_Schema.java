package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p015c.p016a.p017a.p018a.C0695c;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.C0707k;
import p009e.p015c.p016a.p017a.p018a.p019n.C0713c;
import p009e.p015c.p016a.p017a.p018a.p023r.C0727a;
import p009e.p015c.p016a.p017a.p018a.p023r.C0730d;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast_Schema */
public class RFLEntityForecast_Schema implements C0707k<RFLEntityForecast> {
    public static final RFLEntityForecast_Schema INSTANCE;
    @Nullable

    /* renamed from: a */
    private final String f3682a;

    /* renamed from: b */
    private final String[] f3683b;
    public final C0695c<RFLEntityForecast, Integer> date;
    public final C0695c<RFLEntityForecast, Integer> highTemperature;
    public final C0695c<RFLEntityForecast, String> icon;
    public final C0695c<RFLEntityForecast, Integer> lowTemperature;
    public final C0695c<RFLEntityForecast, Integer> timestamp;
    public final C0695c<RFLEntityForecast, Integer> weatherCode;
    public final C0695c<RFLEntityForecast, Integer> weatherType;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast_Schema$a */
    class C2320a extends C0695c<RFLEntityForecast, Integer> {
        C2320a(RFLEntityForecast_Schema rFLEntityForecast_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull RFLEntityForecast rFLEntityForecast) {
            return Integer.valueOf(rFLEntityForecast.getDate());
        }

        @NonNull
        /* renamed from: b */
        public Integer getSerialized(@NonNull RFLEntityForecast rFLEntityForecast) {
            return Integer.valueOf(rFLEntityForecast.getDate());
        }

        @NonNull
        public Integer getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast_Schema$b */
    class C2321b extends C0695c<RFLEntityForecast, Integer> {
        C2321b(RFLEntityForecast_Schema rFLEntityForecast_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull RFLEntityForecast rFLEntityForecast) {
            return Integer.valueOf(rFLEntityForecast.getHighTemperature());
        }

        @NonNull
        /* renamed from: b */
        public Integer getSerialized(@NonNull RFLEntityForecast rFLEntityForecast) {
            return Integer.valueOf(rFLEntityForecast.getHighTemperature());
        }

        @NonNull
        public Integer getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast_Schema$c */
    class C2322c extends C0695c<RFLEntityForecast, Integer> {
        C2322c(RFLEntityForecast_Schema rFLEntityForecast_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull RFLEntityForecast rFLEntityForecast) {
            return Integer.valueOf(rFLEntityForecast.getLowTemperature());
        }

        @NonNull
        /* renamed from: b */
        public Integer getSerialized(@NonNull RFLEntityForecast rFLEntityForecast) {
            return Integer.valueOf(rFLEntityForecast.getLowTemperature());
        }

        @NonNull
        public Integer getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast_Schema$d */
    class C2323d extends C0695c<RFLEntityForecast, String> {
        C2323d(RFLEntityForecast_Schema rFLEntityForecast_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @Nullable
        /* renamed from: a */
        public String get(@NonNull RFLEntityForecast rFLEntityForecast) {
            return rFLEntityForecast.getIcon();
        }

        @Nullable
        /* renamed from: b */
        public String getSerialized(@NonNull RFLEntityForecast rFLEntityForecast) {
            return rFLEntityForecast.getIcon();
        }

        @Nullable
        public String getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            if (cursor.isNull(i)) {
                return null;
            }
            return cursor.getString(i);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast_Schema$e */
    class C2324e extends C0695c<RFLEntityForecast, Integer> {
        C2324e(RFLEntityForecast_Schema rFLEntityForecast_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull RFLEntityForecast rFLEntityForecast) {
            return Integer.valueOf(rFLEntityForecast.getWeatherCode());
        }

        @NonNull
        /* renamed from: b */
        public Integer getSerialized(@NonNull RFLEntityForecast rFLEntityForecast) {
            return Integer.valueOf(rFLEntityForecast.getWeatherCode());
        }

        @NonNull
        public Integer getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast_Schema$f */
    class C2325f extends C0695c<RFLEntityForecast, Integer> {
        C2325f(RFLEntityForecast_Schema rFLEntityForecast_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull RFLEntityForecast rFLEntityForecast) {
            return Integer.valueOf(rFLEntityForecast.getWeatherType());
        }

        @NonNull
        /* renamed from: b */
        public Integer getSerialized(@NonNull RFLEntityForecast rFLEntityForecast) {
            return Integer.valueOf(rFLEntityForecast.getWeatherType());
        }

        @NonNull
        public Integer getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast_Schema$g */
    class C2326g extends C0695c<RFLEntityForecast, Integer> {
        C2326g(RFLEntityForecast_Schema rFLEntityForecast_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull RFLEntityForecast rFLEntityForecast) {
            return Integer.valueOf(rFLEntityForecast.getTimestamp());
        }

        @NonNull
        /* renamed from: b */
        public Integer getSerialized(@NonNull RFLEntityForecast rFLEntityForecast) {
            return Integer.valueOf(rFLEntityForecast.getTimestamp());
        }

        @NonNull
        public Integer getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    static {
        RFLEntityForecast_Schema rFLEntityForecast_Schema = new RFLEntityForecast_Schema();
        C0730d.m411a(rFLEntityForecast_Schema);
        INSTANCE = rFLEntityForecast_Schema;
    }

    public RFLEntityForecast_Schema() {
        this((C0727a) null);
    }

    public RFLEntityForecast_Schema(@Nullable C0727a aVar) {
        if (aVar == null) {
            this.f3682a = null;
            this.date = new C2320a(this, this, "date", Integer.TYPE, "INTEGER", C0695c.PRIMARY_KEY);
            this.highTemperature = new C2321b(this, this, "highTemperature", Integer.TYPE, "INTEGER", 0);
            this.lowTemperature = new C2322c(this, this, "lowTemperature", Integer.TYPE, "INTEGER", 0);
            this.icon = new C2323d(this, this, "icon", String.class, "TEXT", C0695c.NULLABLE);
            this.weatherCode = new C2324e(this, this, "weatherCode", Integer.TYPE, "INTEGER", 0);
            this.weatherType = new C2325f(this, this, "weatherType", Integer.TYPE, "INTEGER", 0);
            this.timestamp = new C2326g(this, this, "timestamp", Integer.TYPE, "INTEGER", 0);
            this.f3683b = new String[]{this.highTemperature.getQualifiedName(), this.lowTemperature.getQualifiedName(), this.icon.getQualifiedName(), this.weatherCode.getQualifiedName(), this.weatherType.getQualifiedName(), this.timestamp.getQualifiedName(), this.date.getQualifiedName()};
            return;
        }
        throw null;
    }

    public void bindArgs(@NonNull C0700h hVar, @NonNull C0713c cVar, @NonNull RFLEntityForecast rFLEntityForecast, boolean z) {
        cVar.mo19901a(1, (long) rFLEntityForecast.getHighTemperature());
        cVar.mo19901a(2, (long) rFLEntityForecast.getLowTemperature());
        if (rFLEntityForecast.getIcon() != null) {
            cVar.mo19902a(3, rFLEntityForecast.getIcon());
        } else {
            cVar.mo19900a(3);
        }
        cVar.mo19901a(4, (long) rFLEntityForecast.getWeatherCode());
        cVar.mo19901a(5, (long) rFLEntityForecast.getWeatherType());
        cVar.mo19901a(6, (long) rFLEntityForecast.getTimestamp());
        cVar.mo19901a(7, (long) rFLEntityForecast.getDate());
    }

    @NonNull
    public Object[] convertToArgs(@NonNull C0700h hVar, @NonNull RFLEntityForecast rFLEntityForecast, boolean z) {
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(rFLEntityForecast.getHighTemperature());
        objArr[1] = Integer.valueOf(rFLEntityForecast.getLowTemperature());
        if (rFLEntityForecast.getIcon() != null) {
            objArr[2] = rFLEntityForecast.getIcon();
        }
        objArr[3] = Integer.valueOf(rFLEntityForecast.getWeatherCode());
        objArr[4] = Integer.valueOf(rFLEntityForecast.getWeatherType());
        objArr[5] = Integer.valueOf(rFLEntityForecast.getTimestamp());
        objArr[6] = Integer.valueOf(rFLEntityForecast.getDate());
        return objArr;
    }

    @NonNull
    public ContentValues convertToContentValues(@NonNull C0700h hVar, @NonNull RFLEntityForecast rFLEntityForecast, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("highTemperature", Integer.valueOf(rFLEntityForecast.getHighTemperature()));
        contentValues.put("lowTemperature", Integer.valueOf(rFLEntityForecast.getLowTemperature()));
        if (rFLEntityForecast.getIcon() != null) {
            contentValues.put("icon", rFLEntityForecast.getIcon());
        } else {
            contentValues.putNull("icon");
        }
        contentValues.put("weatherCode", Integer.valueOf(rFLEntityForecast.getWeatherCode()));
        contentValues.put("weatherType", Integer.valueOf(rFLEntityForecast.getWeatherType()));
        contentValues.put("timestamp", Integer.valueOf(rFLEntityForecast.getTimestamp()));
        contentValues.put("date", Integer.valueOf(rFLEntityForecast.getDate()));
        return contentValues;
    }

    @NonNull
    public List<C0695c<RFLEntityForecast, ?>> getColumns() {
        return Arrays.asList(new C0695c[]{this.highTemperature, this.lowTemperature, this.icon, this.weatherCode, this.weatherType, this.timestamp, this.date});
    }

    @NonNull
    public List<String> getCreateIndexStatements() {
        return Collections.emptyList();
    }

    @NonNull
    public String getCreateTableStatement() {
        return "CREATE TABLE `RFLEntityForecast` (`highTemperature` INTEGER NOT NULL, `lowTemperature` INTEGER NOT NULL, `icon` TEXT , `weatherCode` INTEGER NOT NULL, `weatherType` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `date` INTEGER PRIMARY KEY)";
    }

    @NonNull
    public String[] getDefaultResultColumns() {
        return this.f3683b;
    }

    @NonNull
    public String getDropTableStatement() {
        return "DROP TABLE IF EXISTS `RFLEntityForecast`";
    }

    @Nullable
    public String getEscapedTableAlias() {
        if (this.f3682a != null) {
            return C0681a.m323a(C0681a.m329a('`'), this.f3682a, '`');
        }
        return null;
    }

    @NonNull
    public String getEscapedTableName() {
        return "`RFLEntityForecast`";
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
        a.append(" INTO `RFLEntityForecast` (`highTemperature`,`lowTemperature`,`icon`,`weatherCode`,`weatherType`,`timestamp`,`date`) VALUES (?,?,?,?,?,?,?)");
        return a.toString();
    }

    @NonNull
    public Class<RFLEntityForecast> getModelClass() {
        return RFLEntityForecast.class;
    }

    @NonNull
    public C0695c<RFLEntityForecast, Integer> getPrimaryKey() {
        return this.date;
    }

    @NonNull
    public String getSelectFromTableClause() {
        StringBuilder a = C0681a.m330a("`RFLEntityForecast`");
        a.append(this.f3682a != null ? C0681a.m323a(C0681a.m330a(" AS `"), this.f3682a, '`') : "");
        return a.toString();
    }

    @Nullable
    public String getTableAlias() {
        return this.f3682a;
    }

    @NonNull
    public String getTableName() {
        return "RFLEntityForecast";
    }

    @NonNull
    public RFLEntityForecast newModelFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
        int i2 = i + 2;
        return new RFLEntityForecast(cursor.getInt(i + 6), cursor.getInt(i + 0), cursor.getInt(i + 1), cursor.isNull(i2) ? null : cursor.getString(i2), cursor.getInt(i + 3), cursor.getInt(i + 4), cursor.getInt(i + 5));
    }
}
