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

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDailyTag_Schema */
public class RFLEntityDailyTag_Schema implements C0707k<RFLEntityDailyTag> {
    public static final RFLEntityDailyTag_Schema INSTANCE;
    @Nullable

    /* renamed from: a */
    private final String f3661a;

    /* renamed from: b */
    private final String[] f3662b;
    public final C0695c<RFLEntityDailyTag, String> dailyTag;
    public final C0695c<RFLEntityDailyTag, Integer> date;
    public final C0695c<RFLEntityDailyTag, Integer> updateTime;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDailyTag_Schema$a */
    class C2313a extends C0695c<RFLEntityDailyTag, Integer> {
        C2313a(RFLEntityDailyTag_Schema rFLEntityDailyTag_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull RFLEntityDailyTag rFLEntityDailyTag) {
            return Integer.valueOf(rFLEntityDailyTag.getDate());
        }

        @NonNull
        /* renamed from: b */
        public Integer getSerialized(@NonNull RFLEntityDailyTag rFLEntityDailyTag) {
            return Integer.valueOf(rFLEntityDailyTag.getDate());
        }

        @NonNull
        public Integer getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDailyTag_Schema$b */
    class C2314b extends C0695c<RFLEntityDailyTag, String> {
        C2314b(RFLEntityDailyTag_Schema rFLEntityDailyTag_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public String get(@NonNull RFLEntityDailyTag rFLEntityDailyTag) {
            return rFLEntityDailyTag.getDailyTag();
        }

        @NonNull
        /* renamed from: b */
        public String getSerialized(@NonNull RFLEntityDailyTag rFLEntityDailyTag) {
            return rFLEntityDailyTag.getDailyTag();
        }

        @NonNull
        public String getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return cursor.getString(i);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDailyTag_Schema$c */
    class C2315c extends C0695c<RFLEntityDailyTag, Integer> {
        C2315c(RFLEntityDailyTag_Schema rFLEntityDailyTag_Schema, C0707k kVar, String str, Type type, String str2, int i) {
            super(kVar, str, type, str2, i);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull RFLEntityDailyTag rFLEntityDailyTag) {
            return Integer.valueOf(rFLEntityDailyTag.getUpdateTime());
        }

        @NonNull
        /* renamed from: b */
        public Integer getSerialized(@NonNull RFLEntityDailyTag rFLEntityDailyTag) {
            return Integer.valueOf(rFLEntityDailyTag.getUpdateTime());
        }

        @NonNull
        public Integer getFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    static {
        RFLEntityDailyTag_Schema rFLEntityDailyTag_Schema = new RFLEntityDailyTag_Schema();
        C0730d.m411a(rFLEntityDailyTag_Schema);
        INSTANCE = rFLEntityDailyTag_Schema;
    }

    public RFLEntityDailyTag_Schema() {
        this((C0727a) null);
    }

    public RFLEntityDailyTag_Schema(@Nullable C0727a aVar) {
        if (aVar == null) {
            this.f3661a = null;
            this.date = new C2313a(this, this, "date", Integer.TYPE, "INTEGER", C0695c.PRIMARY_KEY);
            this.dailyTag = new C2314b(this, this, "dailyTag", String.class, "TEXT", 0);
            this.updateTime = new C2315c(this, this, "updateTime", Integer.TYPE, "INTEGER", 0);
            this.f3662b = new String[]{this.dailyTag.getQualifiedName(), this.updateTime.getQualifiedName(), this.date.getQualifiedName()};
            return;
        }
        throw null;
    }

    public void bindArgs(@NonNull C0700h hVar, @NonNull C0713c cVar, @NonNull RFLEntityDailyTag rFLEntityDailyTag, boolean z) {
        cVar.mo19902a(1, rFLEntityDailyTag.getDailyTag());
        cVar.mo19901a(2, (long) rFLEntityDailyTag.getUpdateTime());
        cVar.mo19901a(3, (long) rFLEntityDailyTag.getDate());
    }

    @NonNull
    public Object[] convertToArgs(@NonNull C0700h hVar, @NonNull RFLEntityDailyTag rFLEntityDailyTag, boolean z) {
        Object[] objArr = new Object[3];
        if (rFLEntityDailyTag.getDailyTag() != null) {
            objArr[0] = rFLEntityDailyTag.getDailyTag();
            objArr[1] = Integer.valueOf(rFLEntityDailyTag.getUpdateTime());
            objArr[2] = Integer.valueOf(rFLEntityDailyTag.getDate());
            return objArr;
        }
        throw new IllegalArgumentException("RFLEntityDailyTag.dailyTag must not be null, or use @Nullable to declare it as NULL");
    }

    @NonNull
    public ContentValues convertToContentValues(@NonNull C0700h hVar, @NonNull RFLEntityDailyTag rFLEntityDailyTag, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("dailyTag", rFLEntityDailyTag.getDailyTag());
        contentValues.put("updateTime", Integer.valueOf(rFLEntityDailyTag.getUpdateTime()));
        contentValues.put("date", Integer.valueOf(rFLEntityDailyTag.getDate()));
        return contentValues;
    }

    @NonNull
    public List<C0695c<RFLEntityDailyTag, ?>> getColumns() {
        return Arrays.asList(new C0695c[]{this.dailyTag, this.updateTime, this.date});
    }

    @NonNull
    public List<String> getCreateIndexStatements() {
        return Collections.emptyList();
    }

    @NonNull
    public String getCreateTableStatement() {
        return "CREATE TABLE `RFLEntityDailyTag` (`dailyTag` TEXT NOT NULL, `updateTime` INTEGER NOT NULL, `date` INTEGER PRIMARY KEY)";
    }

    @NonNull
    public String[] getDefaultResultColumns() {
        return this.f3662b;
    }

    @NonNull
    public String getDropTableStatement() {
        return "DROP TABLE IF EXISTS `RFLEntityDailyTag`";
    }

    @Nullable
    public String getEscapedTableAlias() {
        if (this.f3661a != null) {
            return C0681a.m323a(C0681a.m329a('`'), this.f3661a, '`');
        }
        return null;
    }

    @NonNull
    public String getEscapedTableName() {
        return "`RFLEntityDailyTag`";
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
        a.append(" INTO `RFLEntityDailyTag` (`dailyTag`,`updateTime`,`date`) VALUES (?,?,?)");
        return a.toString();
    }

    @NonNull
    public Class<RFLEntityDailyTag> getModelClass() {
        return RFLEntityDailyTag.class;
    }

    @NonNull
    public C0695c<RFLEntityDailyTag, Integer> getPrimaryKey() {
        return this.date;
    }

    @NonNull
    public String getSelectFromTableClause() {
        StringBuilder a = C0681a.m330a("`RFLEntityDailyTag`");
        a.append(this.f3661a != null ? C0681a.m323a(C0681a.m330a(" AS `"), this.f3661a, '`') : "");
        return a.toString();
    }

    @Nullable
    public String getTableAlias() {
        return this.f3661a;
    }

    @NonNull
    public String getTableName() {
        return "RFLEntityDailyTag";
    }

    @NonNull
    public RFLEntityDailyTag newModelFromCursor(@NonNull C0700h hVar, @NonNull Cursor cursor, int i) {
        return new RFLEntityDailyTag(cursor.getInt(i + 2), cursor.getString(i + 0), cursor.getInt(i + 1));
    }
}
