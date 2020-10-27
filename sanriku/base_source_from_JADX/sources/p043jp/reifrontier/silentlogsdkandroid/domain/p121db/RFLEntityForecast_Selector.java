package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0865f;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast_Selector */
public class RFLEntityForecast_Selector extends C0865f<RFLEntityForecast, RFLEntityForecast_Selector> {

    /* renamed from: a */
    final RFLEntityForecast_Schema f3684a;

    public RFLEntityForecast_Selector(C0855d dVar, RFLEntityForecast_Schema rFLEntityForecast_Schema) {
        super((C0700h) dVar);
        this.f3684a = rFLEntityForecast_Schema;
    }

    public RFLEntityForecast_Selector(RFLEntityForecast_Relation rFLEntityForecast_Relation) {
        super(rFLEntityForecast_Relation);
        this.f3684a = rFLEntityForecast_Relation.getSchema();
    }

    public RFLEntityForecast_Selector(RFLEntityForecast_Selector rFLEntityForecast_Selector) {
        super(rFLEntityForecast_Selector);
        this.f3684a = rFLEntityForecast_Selector.getSchema();
    }

    @Nullable
    public Double avgByHighTemperature() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.highTemperature.buildCallExpr("AVG"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Double.valueOf(executeWithColumns.getDouble(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Double avgByLowTemperature() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.lowTemperature.buildCallExpr("AVG"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Double.valueOf(executeWithColumns.getDouble(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Double avgByTimestamp() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.timestamp.buildCallExpr("AVG"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Double.valueOf(executeWithColumns.getDouble(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Double avgByWeatherCode() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.weatherCode.buildCallExpr("AVG"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Double.valueOf(executeWithColumns.getDouble(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Double avgByWeatherType() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.weatherType.buildCallExpr("AVG"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Double.valueOf(executeWithColumns.getDouble(0));
        } finally {
            executeWithColumns.close();
        }
    }

    public RFLEntityForecast_Selector clone() {
        return new RFLEntityForecast_Selector(this);
    }

    public RFLEntityForecast_Selector dateBetween(int i, int i2) {
        return (RFLEntityForecast_Selector) whereBetween(this.f3684a.date, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityForecast_Selector dateEq(int i) {
        return (RFLEntityForecast_Selector) where(this.f3684a.date, "=", Integer.valueOf(i));
    }

    public RFLEntityForecast_Selector dateGe(int i) {
        return (RFLEntityForecast_Selector) where(this.f3684a.date, ">=", Integer.valueOf(i));
    }

    public RFLEntityForecast_Selector dateGt(int i) {
        return (RFLEntityForecast_Selector) where(this.f3684a.date, ">", Integer.valueOf(i));
    }

    public RFLEntityForecast_Selector dateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityForecast_Selector) mo19936in(false, this.f3684a.date, collection);
    }

    public final RFLEntityForecast_Selector dateIn(@NonNull Integer... numArr) {
        return dateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityForecast_Selector dateLe(int i) {
        return (RFLEntityForecast_Selector) where(this.f3684a.date, "<=", Integer.valueOf(i));
    }

    public RFLEntityForecast_Selector dateLt(int i) {
        return (RFLEntityForecast_Selector) where(this.f3684a.date, "<", Integer.valueOf(i));
    }

    public RFLEntityForecast_Selector dateNotEq(int i) {
        return (RFLEntityForecast_Selector) where(this.f3684a.date, "<>", Integer.valueOf(i));
    }

    public RFLEntityForecast_Selector dateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityForecast_Selector) mo19936in(true, this.f3684a.date, collection);
    }

    public final RFLEntityForecast_Selector dateNotIn(@NonNull Integer... numArr) {
        return dateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityForecast_Schema getSchema() {
        return this.f3684a;
    }

    @Nullable
    public Integer maxByHighTemperature() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.highTemperature.buildCallExpr("MAX"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3684a.highTemperature.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer maxByLowTemperature() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.lowTemperature.buildCallExpr("MAX"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3684a.lowTemperature.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer maxByTimestamp() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.timestamp.buildCallExpr("MAX"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3684a.timestamp.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer maxByWeatherCode() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.weatherCode.buildCallExpr("MAX"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3684a.weatherCode.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer maxByWeatherType() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.weatherType.buildCallExpr("MAX"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3684a.weatherType.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer minByHighTemperature() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.highTemperature.buildCallExpr("MIN"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3684a.highTemperature.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer minByLowTemperature() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.lowTemperature.buildCallExpr("MIN"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3684a.lowTemperature.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer minByTimestamp() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.timestamp.buildCallExpr("MIN"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3684a.timestamp.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer minByWeatherCode() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.weatherCode.buildCallExpr("MIN"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3684a.weatherCode.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer minByWeatherType() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.weatherType.buildCallExpr("MIN"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3684a.weatherType.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    public RFLEntityForecast_Selector orderByDateAsc() {
        return (RFLEntityForecast_Selector) orderBy(this.f3684a.date.orderInAscending());
    }

    public RFLEntityForecast_Selector orderByDateDesc() {
        return (RFLEntityForecast_Selector) orderBy(this.f3684a.date.orderInDescending());
    }

    @Nullable
    public Long sumByHighTemperature() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.highTemperature.buildCallExpr("SUM"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Long.valueOf(executeWithColumns.getLong(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Long sumByLowTemperature() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.lowTemperature.buildCallExpr("SUM"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Long.valueOf(executeWithColumns.getLong(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Long sumByTimestamp() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.timestamp.buildCallExpr("SUM"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Long.valueOf(executeWithColumns.getLong(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Long sumByWeatherCode() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.weatherCode.buildCallExpr("SUM"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Long.valueOf(executeWithColumns.getLong(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Long sumByWeatherType() {
        Cursor executeWithColumns = executeWithColumns(this.f3684a.weatherType.buildCallExpr("SUM"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Long.valueOf(executeWithColumns.getLong(0));
        } finally {
            executeWithColumns.close();
        }
    }
}
