package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0865f;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDailyTag_Selector */
public class RFLEntityDailyTag_Selector extends C0865f<RFLEntityDailyTag, RFLEntityDailyTag_Selector> {

    /* renamed from: a */
    final RFLEntityDailyTag_Schema f3663a;

    public RFLEntityDailyTag_Selector(C0855d dVar, RFLEntityDailyTag_Schema rFLEntityDailyTag_Schema) {
        super((C0700h) dVar);
        this.f3663a = rFLEntityDailyTag_Schema;
    }

    public RFLEntityDailyTag_Selector(RFLEntityDailyTag_Relation rFLEntityDailyTag_Relation) {
        super(rFLEntityDailyTag_Relation);
        this.f3663a = rFLEntityDailyTag_Relation.getSchema();
    }

    public RFLEntityDailyTag_Selector(RFLEntityDailyTag_Selector rFLEntityDailyTag_Selector) {
        super(rFLEntityDailyTag_Selector);
        this.f3663a = rFLEntityDailyTag_Selector.getSchema();
    }

    @Nullable
    public Double avgByUpdateTime() {
        Cursor executeWithColumns = executeWithColumns(this.f3663a.updateTime.buildCallExpr("AVG"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Double.valueOf(executeWithColumns.getDouble(0));
        } finally {
            executeWithColumns.close();
        }
    }

    public RFLEntityDailyTag_Selector clone() {
        return new RFLEntityDailyTag_Selector(this);
    }

    public RFLEntityDailyTag_Selector dateBetween(int i, int i2) {
        return (RFLEntityDailyTag_Selector) whereBetween(this.f3663a.date, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityDailyTag_Selector dateEq(int i) {
        return (RFLEntityDailyTag_Selector) where(this.f3663a.date, "=", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Selector dateGe(int i) {
        return (RFLEntityDailyTag_Selector) where(this.f3663a.date, ">=", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Selector dateGt(int i) {
        return (RFLEntityDailyTag_Selector) where(this.f3663a.date, ">", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Selector dateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityDailyTag_Selector) mo19936in(false, this.f3663a.date, collection);
    }

    public final RFLEntityDailyTag_Selector dateIn(@NonNull Integer... numArr) {
        return dateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityDailyTag_Selector dateLe(int i) {
        return (RFLEntityDailyTag_Selector) where(this.f3663a.date, "<=", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Selector dateLt(int i) {
        return (RFLEntityDailyTag_Selector) where(this.f3663a.date, "<", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Selector dateNotEq(int i) {
        return (RFLEntityDailyTag_Selector) where(this.f3663a.date, "<>", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Selector dateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityDailyTag_Selector) mo19936in(true, this.f3663a.date, collection);
    }

    public final RFLEntityDailyTag_Selector dateNotIn(@NonNull Integer... numArr) {
        return dateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityDailyTag_Schema getSchema() {
        return this.f3663a;
    }

    @Nullable
    public Integer maxByUpdateTime() {
        Cursor executeWithColumns = executeWithColumns(this.f3663a.updateTime.buildCallExpr("MAX"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3663a.updateTime.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer minByUpdateTime() {
        Cursor executeWithColumns = executeWithColumns(this.f3663a.updateTime.buildCallExpr("MIN"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3663a.updateTime.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    public RFLEntityDailyTag_Selector orderByDateAsc() {
        return (RFLEntityDailyTag_Selector) orderBy(this.f3663a.date.orderInAscending());
    }

    public RFLEntityDailyTag_Selector orderByDateDesc() {
        return (RFLEntityDailyTag_Selector) orderBy(this.f3663a.date.orderInDescending());
    }

    @Nullable
    public Long sumByUpdateTime() {
        Cursor executeWithColumns = executeWithColumns(this.f3663a.updateTime.buildCallExpr("SUM"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Long.valueOf(executeWithColumns.getLong(0));
        } finally {
            executeWithColumns.close();
        }
    }
}
