package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0694b;
import p009e.p015c.p016a.p017a.p018a.C0700h;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint_AssociationCondition */
public class RFLEntityAdjustTrackPoint_AssociationCondition extends C0694b<RFLEntityAdjustTrackPoint, RFLEntityAdjustTrackPoint_AssociationCondition> {

    /* renamed from: a */
    final RFLEntityAdjustTrackPoint_Schema f3634a;

    public RFLEntityAdjustTrackPoint_AssociationCondition(C0700h hVar, RFLEntityAdjustTrackPoint_Schema rFLEntityAdjustTrackPoint_Schema) {
        super(hVar);
        this.f3634a = rFLEntityAdjustTrackPoint_Schema;
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition(RFLEntityAdjustTrackPoint_AssociationCondition rFLEntityAdjustTrackPoint_AssociationCondition) {
        super(rFLEntityAdjustTrackPoint_AssociationCondition);
        this.f3634a = rFLEntityAdjustTrackPoint_AssociationCondition.getSchema();
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition(RFLEntityAdjustTrackPoint_Relation rFLEntityAdjustTrackPoint_Relation) {
        super(rFLEntityAdjustTrackPoint_Relation);
        this.f3634a = rFLEntityAdjustTrackPoint_Relation.getSchema();
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition clone() {
        return new RFLEntityAdjustTrackPoint_AssociationCondition(this);
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition fromDateBetween(int i, int i2) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) whereBetween(this.f3634a.fromDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition fromDateEq(int i) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) where(this.f3634a.fromDate, "=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition fromDateGe(int i) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) where(this.f3634a.fromDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition fromDateGt(int i) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) where(this.f3634a.fromDate, ">", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition fromDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) mo19936in(false, this.f3634a.fromDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_AssociationCondition fromDateIn(@NonNull Integer... numArr) {
        return fromDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition fromDateLe(int i) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) where(this.f3634a.fromDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition fromDateLt(int i) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) where(this.f3634a.fromDate, "<", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition fromDateNotEq(int i) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) where(this.f3634a.fromDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition fromDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) mo19936in(true, this.f3634a.fromDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_AssociationCondition fromDateNotIn(@NonNull Integer... numArr) {
        return fromDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityAdjustTrackPoint_Schema getSchema() {
        return this.f3634a;
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition toDateBetween(int i, int i2) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) whereBetween(this.f3634a.toDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition toDateEq(int i) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) where(this.f3634a.toDate, "=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition toDateGe(int i) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) where(this.f3634a.toDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition toDateGt(int i) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) where(this.f3634a.toDate, ">", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition toDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) mo19936in(false, this.f3634a.toDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_AssociationCondition toDateIn(@NonNull Integer... numArr) {
        return toDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition toDateLe(int i) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) where(this.f3634a.toDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition toDateLt(int i) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) where(this.f3634a.toDate, "<", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition toDateNotEq(int i) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) where(this.f3634a.toDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_AssociationCondition toDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_AssociationCondition) mo19936in(true, this.f3634a.toDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_AssociationCondition toDateNotIn(@NonNull Integer... numArr) {
        return toDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }
}
