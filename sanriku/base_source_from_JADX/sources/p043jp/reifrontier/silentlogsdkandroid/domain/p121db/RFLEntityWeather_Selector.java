package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0865f;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather_Selector */
public class RFLEntityWeather_Selector extends C0865f<RFLEntityWeather, RFLEntityWeather_Selector> {

    /* renamed from: a */
    final RFLEntityWeather_Schema f3738a;

    public RFLEntityWeather_Selector(C0855d dVar, RFLEntityWeather_Schema rFLEntityWeather_Schema) {
        super((C0700h) dVar);
        this.f3738a = rFLEntityWeather_Schema;
    }

    public RFLEntityWeather_Selector(RFLEntityWeather_Relation rFLEntityWeather_Relation) {
        super(rFLEntityWeather_Relation);
        this.f3738a = rFLEntityWeather_Relation.getSchema();
    }

    public RFLEntityWeather_Selector(RFLEntityWeather_Selector rFLEntityWeather_Selector) {
        super(rFLEntityWeather_Selector);
        this.f3738a = rFLEntityWeather_Selector.getSchema();
    }

    @Nullable
    public Double avgByDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3738a.date.buildCallExpr("AVG"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Double.valueOf(executeWithColumns.getDouble(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Double avgByTemperature() {
        Cursor executeWithColumns = executeWithColumns(this.f3738a.temperature.buildCallExpr("AVG"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Double.valueOf(executeWithColumns.getDouble(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Double avgByTimestamp() {
        Cursor executeWithColumns = executeWithColumns(this.f3738a.timestamp.buildCallExpr("AVG"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Double.valueOf(executeWithColumns.getDouble(0));
        } finally {
            executeWithColumns.close();
        }
    }

    public RFLEntityWeather_Selector clone() {
        return new RFLEntityWeather_Selector(this);
    }

    public RFLEntityWeather_Selector dateBetween(int i, int i2) {
        return (RFLEntityWeather_Selector) whereBetween(this.f3738a.date, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityWeather_Selector dateEq(int i) {
        return (RFLEntityWeather_Selector) where(this.f3738a.date, "=", Integer.valueOf(i));
    }

    public RFLEntityWeather_Selector dateGe(int i) {
        return (RFLEntityWeather_Selector) where(this.f3738a.date, ">=", Integer.valueOf(i));
    }

    public RFLEntityWeather_Selector dateGt(int i) {
        return (RFLEntityWeather_Selector) where(this.f3738a.date, ">", Integer.valueOf(i));
    }

    public RFLEntityWeather_Selector dateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityWeather_Selector) mo19936in(false, this.f3738a.date, collection);
    }

    public final RFLEntityWeather_Selector dateIn(@NonNull Integer... numArr) {
        return dateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityWeather_Selector dateLe(int i) {
        return (RFLEntityWeather_Selector) where(this.f3738a.date, "<=", Integer.valueOf(i));
    }

    public RFLEntityWeather_Selector dateLt(int i) {
        return (RFLEntityWeather_Selector) where(this.f3738a.date, "<", Integer.valueOf(i));
    }

    public RFLEntityWeather_Selector dateNotEq(int i) {
        return (RFLEntityWeather_Selector) where(this.f3738a.date, "<>", Integer.valueOf(i));
    }

    public RFLEntityWeather_Selector dateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityWeather_Selector) mo19936in(true, this.f3738a.date, collection);
    }

    public final RFLEntityWeather_Selector dateNotIn(@NonNull Integer... numArr) {
        return dateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityWeather_Schema getSchema() {
        return this.f3738a;
    }

    @Nullable
    public Integer maxByDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3738a.date.buildCallExpr("MAX"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3738a.date.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer maxByTemperature() {
        Cursor executeWithColumns = executeWithColumns(this.f3738a.temperature.buildCallExpr("MAX"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3738a.temperature.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer maxByTimestamp() {
        Cursor executeWithColumns = executeWithColumns(this.f3738a.timestamp.buildCallExpr("MAX"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3738a.timestamp.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer minByDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3738a.date.buildCallExpr("MIN"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3738a.date.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer minByTemperature() {
        Cursor executeWithColumns = executeWithColumns(this.f3738a.temperature.buildCallExpr("MIN"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3738a.temperature.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer minByTimestamp() {
        Cursor executeWithColumns = executeWithColumns(this.f3738a.timestamp.buildCallExpr("MIN"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3738a.timestamp.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    public RFLEntityWeather_Selector orderByDateAsc() {
        return (RFLEntityWeather_Selector) orderBy(this.f3738a.date.orderInAscending());
    }

    public RFLEntityWeather_Selector orderByDateDesc() {
        return (RFLEntityWeather_Selector) orderBy(this.f3738a.date.orderInDescending());
    }

    @Nullable
    public Long sumByDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3738a.date.buildCallExpr("SUM"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Long.valueOf(executeWithColumns.getLong(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Long sumByTemperature() {
        Cursor executeWithColumns = executeWithColumns(this.f3738a.temperature.buildCallExpr("SUM"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Long.valueOf(executeWithColumns.getLong(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Long sumByTimestamp() {
        Cursor executeWithColumns = executeWithColumns(this.f3738a.timestamp.buildCallExpr("SUM"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Long.valueOf(executeWithColumns.getLong(0));
        } finally {
            executeWithColumns.close();
        }
    }
}
