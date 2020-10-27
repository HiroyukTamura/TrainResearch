package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0694b;
import p009e.p015c.p016a.p017a.p018a.C0700h;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag_AssociationCondition */
public class RFLEntityTag_AssociationCondition extends C0694b<RFLEntityTag, RFLEntityTag_AssociationCondition> {

    /* renamed from: a */
    final RFLEntityTag_Schema f3708a;

    public RFLEntityTag_AssociationCondition(C0700h hVar, RFLEntityTag_Schema rFLEntityTag_Schema) {
        super(hVar);
        this.f3708a = rFLEntityTag_Schema;
    }

    public RFLEntityTag_AssociationCondition(RFLEntityTag_AssociationCondition rFLEntityTag_AssociationCondition) {
        super(rFLEntityTag_AssociationCondition);
        this.f3708a = rFLEntityTag_AssociationCondition.getSchema();
    }

    public RFLEntityTag_AssociationCondition(RFLEntityTag_Relation rFLEntityTag_Relation) {
        super(rFLEntityTag_Relation);
        this.f3708a = rFLEntityTag_Relation.getSchema();
    }

    public RFLEntityTag_AssociationCondition clone() {
        return new RFLEntityTag_AssociationCondition(this);
    }

    public RFLEntityTag_AssociationCondition fromDateBetween(int i, int i2) {
        return (RFLEntityTag_AssociationCondition) whereBetween(this.f3708a.fromDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityTag_AssociationCondition fromDateEq(int i) {
        return (RFLEntityTag_AssociationCondition) where(this.f3708a.fromDate, "=", Integer.valueOf(i));
    }

    public RFLEntityTag_AssociationCondition fromDateGe(int i) {
        return (RFLEntityTag_AssociationCondition) where(this.f3708a.fromDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityTag_AssociationCondition fromDateGt(int i) {
        return (RFLEntityTag_AssociationCondition) where(this.f3708a.fromDate, ">", Integer.valueOf(i));
    }

    public RFLEntityTag_AssociationCondition fromDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_AssociationCondition) mo19936in(false, this.f3708a.fromDate, collection);
    }

    public final RFLEntityTag_AssociationCondition fromDateIn(@NonNull Integer... numArr) {
        return fromDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityTag_AssociationCondition fromDateLe(int i) {
        return (RFLEntityTag_AssociationCondition) where(this.f3708a.fromDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityTag_AssociationCondition fromDateLt(int i) {
        return (RFLEntityTag_AssociationCondition) where(this.f3708a.fromDate, "<", Integer.valueOf(i));
    }

    public RFLEntityTag_AssociationCondition fromDateNotEq(int i) {
        return (RFLEntityTag_AssociationCondition) where(this.f3708a.fromDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityTag_AssociationCondition fromDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_AssociationCondition) mo19936in(true, this.f3708a.fromDate, collection);
    }

    public final RFLEntityTag_AssociationCondition fromDateNotIn(@NonNull Integer... numArr) {
        return fromDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityTag_Schema getSchema() {
        return this.f3708a;
    }

    public RFLEntityTag_AssociationCondition toDateBetween(int i, int i2) {
        return (RFLEntityTag_AssociationCondition) whereBetween(this.f3708a.toDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityTag_AssociationCondition toDateEq(int i) {
        return (RFLEntityTag_AssociationCondition) where(this.f3708a.toDate, "=", Integer.valueOf(i));
    }

    public RFLEntityTag_AssociationCondition toDateGe(int i) {
        return (RFLEntityTag_AssociationCondition) where(this.f3708a.toDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityTag_AssociationCondition toDateGt(int i) {
        return (RFLEntityTag_AssociationCondition) where(this.f3708a.toDate, ">", Integer.valueOf(i));
    }

    public RFLEntityTag_AssociationCondition toDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_AssociationCondition) mo19936in(false, this.f3708a.toDate, collection);
    }

    public final RFLEntityTag_AssociationCondition toDateIn(@NonNull Integer... numArr) {
        return toDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityTag_AssociationCondition toDateLe(int i) {
        return (RFLEntityTag_AssociationCondition) where(this.f3708a.toDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityTag_AssociationCondition toDateLt(int i) {
        return (RFLEntityTag_AssociationCondition) where(this.f3708a.toDate, "<", Integer.valueOf(i));
    }

    public RFLEntityTag_AssociationCondition toDateNotEq(int i) {
        return (RFLEntityTag_AssociationCondition) where(this.f3708a.toDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityTag_AssociationCondition toDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_AssociationCondition) mo19936in(true, this.f3708a.toDate, collection);
    }

    public final RFLEntityTag_AssociationCondition toDateNotIn(@NonNull Integer... numArr) {
        return toDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }
}
