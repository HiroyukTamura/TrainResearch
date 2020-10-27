package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0865f;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint_Selector */
public class RFLEntityAdjustTrackPoint_Selector extends C0865f<RFLEntityAdjustTrackPoint, RFLEntityAdjustTrackPoint_Selector> {

    /* renamed from: a */
    final RFLEntityAdjustTrackPoint_Schema f3639a;

    public RFLEntityAdjustTrackPoint_Selector(C0855d dVar, RFLEntityAdjustTrackPoint_Schema rFLEntityAdjustTrackPoint_Schema) {
        super((C0700h) dVar);
        this.f3639a = rFLEntityAdjustTrackPoint_Schema;
    }

    public RFLEntityAdjustTrackPoint_Selector(RFLEntityAdjustTrackPoint_Relation rFLEntityAdjustTrackPoint_Relation) {
        super(rFLEntityAdjustTrackPoint_Relation);
        this.f3639a = rFLEntityAdjustTrackPoint_Relation.getSchema();
    }

    public RFLEntityAdjustTrackPoint_Selector(RFLEntityAdjustTrackPoint_Selector rFLEntityAdjustTrackPoint_Selector) {
        super(rFLEntityAdjustTrackPoint_Selector);
        this.f3639a = rFLEntityAdjustTrackPoint_Selector.getSchema();
    }

    @Nullable
    public Double avgByFromDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3639a.fromDate.buildCallExpr("AVG"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Double.valueOf(executeWithColumns.getDouble(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Double avgByToDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3639a.toDate.buildCallExpr("AVG"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Double.valueOf(executeWithColumns.getDouble(0));
        } finally {
            executeWithColumns.close();
        }
    }

    public RFLEntityAdjustTrackPoint_Selector clone() {
        return new RFLEntityAdjustTrackPoint_Selector(this);
    }

    public RFLEntityAdjustTrackPoint_Selector fromDateBetween(int i, int i2) {
        return (RFLEntityAdjustTrackPoint_Selector) whereBetween(this.f3639a.fromDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityAdjustTrackPoint_Selector fromDateEq(int i) {
        return (RFLEntityAdjustTrackPoint_Selector) where(this.f3639a.fromDate, "=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Selector fromDateGe(int i) {
        return (RFLEntityAdjustTrackPoint_Selector) where(this.f3639a.fromDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Selector fromDateGt(int i) {
        return (RFLEntityAdjustTrackPoint_Selector) where(this.f3639a.fromDate, ">", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Selector fromDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Selector) mo19936in(false, this.f3639a.fromDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Selector fromDateIn(@NonNull Integer... numArr) {
        return fromDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityAdjustTrackPoint_Selector fromDateLe(int i) {
        return (RFLEntityAdjustTrackPoint_Selector) where(this.f3639a.fromDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Selector fromDateLt(int i) {
        return (RFLEntityAdjustTrackPoint_Selector) where(this.f3639a.fromDate, "<", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Selector fromDateNotEq(int i) {
        return (RFLEntityAdjustTrackPoint_Selector) where(this.f3639a.fromDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Selector fromDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Selector) mo19936in(true, this.f3639a.fromDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Selector fromDateNotIn(@NonNull Integer... numArr) {
        return fromDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityAdjustTrackPoint_Schema getSchema() {
        return this.f3639a;
    }

    @Nullable
    public Integer maxByFromDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3639a.fromDate.buildCallExpr("MAX"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3639a.fromDate.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer maxByToDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3639a.toDate.buildCallExpr("MAX"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3639a.toDate.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer minByFromDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3639a.fromDate.buildCallExpr("MIN"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3639a.fromDate.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer minByToDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3639a.toDate.buildCallExpr("MIN"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3639a.toDate.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    public RFLEntityAdjustTrackPoint_Selector orderByFromDateAsc() {
        return (RFLEntityAdjustTrackPoint_Selector) orderBy(this.f3639a.fromDate.orderInAscending());
    }

    public RFLEntityAdjustTrackPoint_Selector orderByFromDateDesc() {
        return (RFLEntityAdjustTrackPoint_Selector) orderBy(this.f3639a.fromDate.orderInDescending());
    }

    public RFLEntityAdjustTrackPoint_Selector orderByToDateAsc() {
        return (RFLEntityAdjustTrackPoint_Selector) orderBy(this.f3639a.toDate.orderInAscending());
    }

    public RFLEntityAdjustTrackPoint_Selector orderByToDateDesc() {
        return (RFLEntityAdjustTrackPoint_Selector) orderBy(this.f3639a.toDate.orderInDescending());
    }

    @Nullable
    public Long sumByFromDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3639a.fromDate.buildCallExpr("SUM"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Long.valueOf(executeWithColumns.getLong(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Long sumByToDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3639a.toDate.buildCallExpr("SUM"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Long.valueOf(executeWithColumns.getLong(0));
        } finally {
            executeWithColumns.close();
        }
    }

    public RFLEntityAdjustTrackPoint_Selector toDateBetween(int i, int i2) {
        return (RFLEntityAdjustTrackPoint_Selector) whereBetween(this.f3639a.toDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityAdjustTrackPoint_Selector toDateEq(int i) {
        return (RFLEntityAdjustTrackPoint_Selector) where(this.f3639a.toDate, "=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Selector toDateGe(int i) {
        return (RFLEntityAdjustTrackPoint_Selector) where(this.f3639a.toDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Selector toDateGt(int i) {
        return (RFLEntityAdjustTrackPoint_Selector) where(this.f3639a.toDate, ">", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Selector toDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Selector) mo19936in(false, this.f3639a.toDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Selector toDateIn(@NonNull Integer... numArr) {
        return toDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityAdjustTrackPoint_Selector toDateLe(int i) {
        return (RFLEntityAdjustTrackPoint_Selector) where(this.f3639a.toDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Selector toDateLt(int i) {
        return (RFLEntityAdjustTrackPoint_Selector) where(this.f3639a.toDate, "<", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Selector toDateNotEq(int i) {
        return (RFLEntityAdjustTrackPoint_Selector) where(this.f3639a.toDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Selector toDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Selector) mo19936in(true, this.f3639a.toDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Selector toDateNotIn(@NonNull Integer... numArr) {
        return toDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }
}
