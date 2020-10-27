package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0694b;
import p009e.p015c.p016a.p017a.p018a.C0700h;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityPedometer_AssociationCondition */
public class RFLEntityPedometer_AssociationCondition extends C0694b<RFLEntityPedometer, RFLEntityPedometer_AssociationCondition> {

    /* renamed from: a */
    final RFLEntityPedometer_Schema f3687a;

    public RFLEntityPedometer_AssociationCondition(C0700h hVar, RFLEntityPedometer_Schema rFLEntityPedometer_Schema) {
        super(hVar);
        this.f3687a = rFLEntityPedometer_Schema;
    }

    public RFLEntityPedometer_AssociationCondition(RFLEntityPedometer_AssociationCondition rFLEntityPedometer_AssociationCondition) {
        super(rFLEntityPedometer_AssociationCondition);
        this.f3687a = rFLEntityPedometer_AssociationCondition.getSchema();
    }

    public RFLEntityPedometer_AssociationCondition(RFLEntityPedometer_Relation rFLEntityPedometer_Relation) {
        super(rFLEntityPedometer_Relation);
        this.f3687a = rFLEntityPedometer_Relation.getSchema();
    }

    public RFLEntityPedometer_AssociationCondition clone() {
        return new RFLEntityPedometer_AssociationCondition(this);
    }

    @NonNull
    public RFLEntityPedometer_Schema getSchema() {
        return this.f3687a;
    }

    public RFLEntityPedometer_AssociationCondition timestampBetween(long j, long j2) {
        return (RFLEntityPedometer_AssociationCondition) whereBetween(this.f3687a.timestamp, Long.valueOf(j), Long.valueOf(j2));
    }

    public RFLEntityPedometer_AssociationCondition timestampEq(long j) {
        return (RFLEntityPedometer_AssociationCondition) where(this.f3687a.timestamp, "=", Long.valueOf(j));
    }

    public RFLEntityPedometer_AssociationCondition timestampGe(long j) {
        return (RFLEntityPedometer_AssociationCondition) where(this.f3687a.timestamp, ">=", Long.valueOf(j));
    }

    public RFLEntityPedometer_AssociationCondition timestampGt(long j) {
        return (RFLEntityPedometer_AssociationCondition) where(this.f3687a.timestamp, ">", Long.valueOf(j));
    }

    public RFLEntityPedometer_AssociationCondition timestampIn(@NonNull Collection<Long> collection) {
        return (RFLEntityPedometer_AssociationCondition) mo19936in(false, this.f3687a.timestamp, collection);
    }

    public final RFLEntityPedometer_AssociationCondition timestampIn(@NonNull Long... lArr) {
        return timestampIn((Collection<Long>) Arrays.asList(lArr));
    }

    public RFLEntityPedometer_AssociationCondition timestampLe(long j) {
        return (RFLEntityPedometer_AssociationCondition) where(this.f3687a.timestamp, "<=", Long.valueOf(j));
    }

    public RFLEntityPedometer_AssociationCondition timestampLt(long j) {
        return (RFLEntityPedometer_AssociationCondition) where(this.f3687a.timestamp, "<", Long.valueOf(j));
    }

    public RFLEntityPedometer_AssociationCondition timestampNotEq(long j) {
        return (RFLEntityPedometer_AssociationCondition) where(this.f3687a.timestamp, "<>", Long.valueOf(j));
    }

    public RFLEntityPedometer_AssociationCondition timestampNotIn(@NonNull Collection<Long> collection) {
        return (RFLEntityPedometer_AssociationCondition) mo19936in(true, this.f3687a.timestamp, collection);
    }

    public final RFLEntityPedometer_AssociationCondition timestampNotIn(@NonNull Long... lArr) {
        return timestampNotIn((Collection<Long>) Arrays.asList(lArr));
    }
}
