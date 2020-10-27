package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0865f;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityPedometer_Selector */
public class RFLEntityPedometer_Selector extends C0865f<RFLEntityPedometer, RFLEntityPedometer_Selector> {

    /* renamed from: a */
    final RFLEntityPedometer_Schema f3692a;

    public RFLEntityPedometer_Selector(C0855d dVar, RFLEntityPedometer_Schema rFLEntityPedometer_Schema) {
        super((C0700h) dVar);
        this.f3692a = rFLEntityPedometer_Schema;
    }

    public RFLEntityPedometer_Selector(RFLEntityPedometer_Relation rFLEntityPedometer_Relation) {
        super(rFLEntityPedometer_Relation);
        this.f3692a = rFLEntityPedometer_Relation.getSchema();
    }

    public RFLEntityPedometer_Selector(RFLEntityPedometer_Selector rFLEntityPedometer_Selector) {
        super(rFLEntityPedometer_Selector);
        this.f3692a = rFLEntityPedometer_Selector.getSchema();
    }

    @Nullable
    public Double avgByTimestamp() {
        Cursor executeWithColumns = executeWithColumns(this.f3692a.timestamp.buildCallExpr("AVG"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Double.valueOf(executeWithColumns.getDouble(0));
        } finally {
            executeWithColumns.close();
        }
    }

    public RFLEntityPedometer_Selector clone() {
        return new RFLEntityPedometer_Selector(this);
    }

    @NonNull
    public RFLEntityPedometer_Schema getSchema() {
        return this.f3692a;
    }

    @Nullable
    public Long maxByTimestamp() {
        Cursor executeWithColumns = executeWithColumns(this.f3692a.timestamp.buildCallExpr("MAX"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3692a.timestamp.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    @Nullable
    public Long minByTimestamp() {
        Cursor executeWithColumns = executeWithColumns(this.f3692a.timestamp.buildCallExpr("MIN"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : this.f3692a.timestamp.getFromCursor(this.conn, executeWithColumns, 0);
        } finally {
            executeWithColumns.close();
        }
    }

    public RFLEntityPedometer_Selector orderByTimestampAsc() {
        return (RFLEntityPedometer_Selector) orderBy(this.f3692a.timestamp.orderInAscending());
    }

    public RFLEntityPedometer_Selector orderByTimestampDesc() {
        return (RFLEntityPedometer_Selector) orderBy(this.f3692a.timestamp.orderInDescending());
    }

    @Nullable
    public Long sumByTimestamp() {
        Cursor executeWithColumns = executeWithColumns(this.f3692a.timestamp.buildCallExpr("SUM"));
        try {
            executeWithColumns.moveToFirst();
            return executeWithColumns.isNull(0) ? null : Long.valueOf(executeWithColumns.getLong(0));
        } finally {
            executeWithColumns.close();
        }
    }

    public RFLEntityPedometer_Selector timestampBetween(long j, long j2) {
        return (RFLEntityPedometer_Selector) whereBetween(this.f3692a.timestamp, Long.valueOf(j), Long.valueOf(j2));
    }

    public RFLEntityPedometer_Selector timestampEq(long j) {
        return (RFLEntityPedometer_Selector) where(this.f3692a.timestamp, "=", Long.valueOf(j));
    }

    public RFLEntityPedometer_Selector timestampGe(long j) {
        return (RFLEntityPedometer_Selector) where(this.f3692a.timestamp, ">=", Long.valueOf(j));
    }

    public RFLEntityPedometer_Selector timestampGt(long j) {
        return (RFLEntityPedometer_Selector) where(this.f3692a.timestamp, ">", Long.valueOf(j));
    }

    public RFLEntityPedometer_Selector timestampIn(@NonNull Collection<Long> collection) {
        return (RFLEntityPedometer_Selector) mo19936in(false, this.f3692a.timestamp, collection);
    }

    public final RFLEntityPedometer_Selector timestampIn(@NonNull Long... lArr) {
        return timestampIn((Collection<Long>) Arrays.asList(lArr));
    }

    public RFLEntityPedometer_Selector timestampLe(long j) {
        return (RFLEntityPedometer_Selector) where(this.f3692a.timestamp, "<=", Long.valueOf(j));
    }

    public RFLEntityPedometer_Selector timestampLt(long j) {
        return (RFLEntityPedometer_Selector) where(this.f3692a.timestamp, "<", Long.valueOf(j));
    }

    public RFLEntityPedometer_Selector timestampNotEq(long j) {
        return (RFLEntityPedometer_Selector) where(this.f3692a.timestamp, "<>", Long.valueOf(j));
    }

    public RFLEntityPedometer_Selector timestampNotIn(@NonNull Collection<Long> collection) {
        return (RFLEntityPedometer_Selector) mo19936in(true, this.f3692a.timestamp, collection);
    }

    public final RFLEntityPedometer_Selector timestampNotIn(@NonNull Long... lArr) {
        return timestampNotIn((Collection<Long>) Arrays.asList(lArr));
    }
}
