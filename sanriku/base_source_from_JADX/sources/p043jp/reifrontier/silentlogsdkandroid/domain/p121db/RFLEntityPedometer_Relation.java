package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0856e;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityPedometer_Relation */
public class RFLEntityPedometer_Relation extends C0856e<RFLEntityPedometer, RFLEntityPedometer_Relation> {

    /* renamed from: a */
    final RFLEntityPedometer_Schema f3689a;

    public RFLEntityPedometer_Relation(C0855d dVar, RFLEntityPedometer_Schema rFLEntityPedometer_Schema) {
        super(dVar);
        this.f3689a = rFLEntityPedometer_Schema;
    }

    public RFLEntityPedometer_Relation(RFLEntityPedometer_Relation rFLEntityPedometer_Relation) {
        super(rFLEntityPedometer_Relation);
        this.f3689a = rFLEntityPedometer_Relation.getSchema();
    }

    public RFLEntityPedometer_Relation clone() {
        return new RFLEntityPedometer_Relation(this);
    }

    @NonNull
    public RFLEntityPedometer_Deleter deleter() {
        return new RFLEntityPedometer_Deleter(this);
    }

    @NonNull
    public RFLEntityPedometer_Schema getSchema() {
        return this.f3689a;
    }

    public RFLEntityPedometer_Relation orderByTimestampAsc() {
        return (RFLEntityPedometer_Relation) orderBy(this.f3689a.timestamp.orderInAscending());
    }

    public RFLEntityPedometer_Relation orderByTimestampDesc() {
        return (RFLEntityPedometer_Relation) orderBy(this.f3689a.timestamp.orderInDescending());
    }

    @NonNull
    public RFLEntityPedometer_Selector selector() {
        return new RFLEntityPedometer_Selector(this);
    }

    public RFLEntityPedometer_Relation timestampBetween(long j, long j2) {
        return (RFLEntityPedometer_Relation) whereBetween(this.f3689a.timestamp, Long.valueOf(j), Long.valueOf(j2));
    }

    public RFLEntityPedometer_Relation timestampEq(long j) {
        return (RFLEntityPedometer_Relation) where(this.f3689a.timestamp, "=", Long.valueOf(j));
    }

    public RFLEntityPedometer_Relation timestampGe(long j) {
        return (RFLEntityPedometer_Relation) where(this.f3689a.timestamp, ">=", Long.valueOf(j));
    }

    public RFLEntityPedometer_Relation timestampGt(long j) {
        return (RFLEntityPedometer_Relation) where(this.f3689a.timestamp, ">", Long.valueOf(j));
    }

    public RFLEntityPedometer_Relation timestampIn(@NonNull Collection<Long> collection) {
        return (RFLEntityPedometer_Relation) mo19936in(false, this.f3689a.timestamp, collection);
    }

    public final RFLEntityPedometer_Relation timestampIn(@NonNull Long... lArr) {
        return timestampIn((Collection<Long>) Arrays.asList(lArr));
    }

    public RFLEntityPedometer_Relation timestampLe(long j) {
        return (RFLEntityPedometer_Relation) where(this.f3689a.timestamp, "<=", Long.valueOf(j));
    }

    public RFLEntityPedometer_Relation timestampLt(long j) {
        return (RFLEntityPedometer_Relation) where(this.f3689a.timestamp, "<", Long.valueOf(j));
    }

    public RFLEntityPedometer_Relation timestampNotEq(long j) {
        return (RFLEntityPedometer_Relation) where(this.f3689a.timestamp, "<>", Long.valueOf(j));
    }

    public RFLEntityPedometer_Relation timestampNotIn(@NonNull Collection<Long> collection) {
        return (RFLEntityPedometer_Relation) mo19936in(true, this.f3689a.timestamp, collection);
    }

    public final RFLEntityPedometer_Relation timestampNotIn(@NonNull Long... lArr) {
        return timestampNotIn((Collection<Long>) Arrays.asList(lArr));
    }

    @NonNull
    public RFLEntityPedometer_Updater updater() {
        return new RFLEntityPedometer_Updater(this);
    }

    @NonNull
    public RFLEntityPedometer upsertWithoutTransaction(@NonNull RFLEntityPedometer rFLEntityPedometer) {
        throw new UnsupportedOperationException("upsert is not supported because of missing @PrimaryKey");
    }
}
