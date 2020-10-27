package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0865f;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag_Selector */
public class RFLEntityTag_Selector extends C0865f<RFLEntityTag, RFLEntityTag_Selector> {

    /* renamed from: a */
    final RFLEntityTag_Schema f3713a;

    public RFLEntityTag_Selector(C0855d dVar, RFLEntityTag_Schema rFLEntityTag_Schema) {
        super((C0700h) dVar);
        this.f3713a = rFLEntityTag_Schema;
    }

    public RFLEntityTag_Selector(RFLEntityTag_Relation rFLEntityTag_Relation) {
        super(rFLEntityTag_Relation);
        this.f3713a = rFLEntityTag_Relation.getSchema();
    }

    public RFLEntityTag_Selector(RFLEntityTag_Selector rFLEntityTag_Selector) {
        super(rFLEntityTag_Selector);
        this.f3713a = rFLEntityTag_Selector.getSchema();
    }

    @Nullable
    public Double avgByFromDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3713a.fromDate.buildCallExpr("AVG"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Double.valueOf(executeWithColumns.getDouble(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Double avgByToDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3713a.toDate.buildCallExpr("AVG"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Double.valueOf(executeWithColumns.getDouble(0));
        } finally {
            executeWithColumns.close();
        }
    }

    public RFLEntityTag_Selector clone() {
        return new RFLEntityTag_Selector(this);
    }

    public RFLEntityTag_Selector fromDateBetween(int i, int i2) {
        return (RFLEntityTag_Selector) whereBetween(this.f3713a.fromDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityTag_Selector fromDateEq(int i) {
        return (RFLEntityTag_Selector) where(this.f3713a.fromDate, "=", Integer.valueOf(i));
    }

    public RFLEntityTag_Selector fromDateGe(int i) {
        return (RFLEntityTag_Selector) where(this.f3713a.fromDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityTag_Selector fromDateGt(int i) {
        return (RFLEntityTag_Selector) where(this.f3713a.fromDate, ">", Integer.valueOf(i));
    }

    public RFLEntityTag_Selector fromDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Selector) mo19936in(false, this.f3713a.fromDate, collection);
    }

    public final RFLEntityTag_Selector fromDateIn(@NonNull Integer... numArr) {
        return fromDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityTag_Selector fromDateLe(int i) {
        return (RFLEntityTag_Selector) where(this.f3713a.fromDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityTag_Selector fromDateLt(int i) {
        return (RFLEntityTag_Selector) where(this.f3713a.fromDate, "<", Integer.valueOf(i));
    }

    public RFLEntityTag_Selector fromDateNotEq(int i) {
        return (RFLEntityTag_Selector) where(this.f3713a.fromDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityTag_Selector fromDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Selector) mo19936in(true, this.f3713a.fromDate, collection);
    }

    public final RFLEntityTag_Selector fromDateNotIn(@NonNull Integer... numArr) {
        return fromDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityTag_Schema getSchema() {
        return this.f3713a;
    }

    @Nullable
    public Integer maxByFromDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3713a.fromDate.buildCallExpr("MAX"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3713a.fromDate.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer maxByToDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3713a.toDate.buildCallExpr("MAX"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3713a.toDate.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer minByFromDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3713a.fromDate.buildCallExpr("MIN"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3713a.fromDate.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Integer minByToDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3713a.toDate.buildCallExpr("MIN"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3713a.toDate.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    public RFLEntityTag_Selector orderByFromDateAsc() {
        return (RFLEntityTag_Selector) orderBy(this.f3713a.fromDate.orderInAscending());
    }

    public RFLEntityTag_Selector orderByFromDateDesc() {
        return (RFLEntityTag_Selector) orderBy(this.f3713a.fromDate.orderInDescending());
    }

    public RFLEntityTag_Selector orderByToDateAsc() {
        return (RFLEntityTag_Selector) orderBy(this.f3713a.toDate.orderInAscending());
    }

    public RFLEntityTag_Selector orderByToDateDesc() {
        return (RFLEntityTag_Selector) orderBy(this.f3713a.toDate.orderInDescending());
    }

    @Nullable
    public Long sumByFromDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3713a.fromDate.buildCallExpr("SUM"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Long.valueOf(executeWithColumns.getLong(0));
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Long sumByToDate() {
        Cursor executeWithColumns = executeWithColumns(this.f3713a.toDate.buildCallExpr("SUM"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Long.valueOf(executeWithColumns.getLong(0));
        } finally {
            executeWithColumns.close();
        }
    }

    public RFLEntityTag_Selector toDateBetween(int i, int i2) {
        return (RFLEntityTag_Selector) whereBetween(this.f3713a.toDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityTag_Selector toDateEq(int i) {
        return (RFLEntityTag_Selector) where(this.f3713a.toDate, "=", Integer.valueOf(i));
    }

    public RFLEntityTag_Selector toDateGe(int i) {
        return (RFLEntityTag_Selector) where(this.f3713a.toDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityTag_Selector toDateGt(int i) {
        return (RFLEntityTag_Selector) where(this.f3713a.toDate, ">", Integer.valueOf(i));
    }

    public RFLEntityTag_Selector toDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Selector) mo19936in(false, this.f3713a.toDate, collection);
    }

    public final RFLEntityTag_Selector toDateIn(@NonNull Integer... numArr) {
        return toDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityTag_Selector toDateLe(int i) {
        return (RFLEntityTag_Selector) where(this.f3713a.toDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityTag_Selector toDateLt(int i) {
        return (RFLEntityTag_Selector) where(this.f3713a.toDate, "<", Integer.valueOf(i));
    }

    public RFLEntityTag_Selector toDateNotEq(int i) {
        return (RFLEntityTag_Selector) where(this.f3713a.toDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityTag_Selector toDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Selector) mo19936in(true, this.f3713a.toDate, collection);
    }

    public final RFLEntityTag_Selector toDateNotIn(@NonNull Integer... numArr) {
        return toDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }
}
