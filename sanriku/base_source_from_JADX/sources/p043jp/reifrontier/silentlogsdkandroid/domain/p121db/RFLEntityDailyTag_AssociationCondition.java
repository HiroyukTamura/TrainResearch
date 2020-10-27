package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0694b;
import p009e.p015c.p016a.p017a.p018a.C0700h;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDailyTag_AssociationCondition */
public class RFLEntityDailyTag_AssociationCondition extends C0694b<RFLEntityDailyTag, RFLEntityDailyTag_AssociationCondition> {

    /* renamed from: a */
    final RFLEntityDailyTag_Schema f3658a;

    public RFLEntityDailyTag_AssociationCondition(C0700h hVar, RFLEntityDailyTag_Schema rFLEntityDailyTag_Schema) {
        super(hVar);
        this.f3658a = rFLEntityDailyTag_Schema;
    }

    public RFLEntityDailyTag_AssociationCondition(RFLEntityDailyTag_AssociationCondition rFLEntityDailyTag_AssociationCondition) {
        super(rFLEntityDailyTag_AssociationCondition);
        this.f3658a = rFLEntityDailyTag_AssociationCondition.getSchema();
    }

    public RFLEntityDailyTag_AssociationCondition(RFLEntityDailyTag_Relation rFLEntityDailyTag_Relation) {
        super(rFLEntityDailyTag_Relation);
        this.f3658a = rFLEntityDailyTag_Relation.getSchema();
    }

    public RFLEntityDailyTag_AssociationCondition clone() {
        return new RFLEntityDailyTag_AssociationCondition(this);
    }

    public RFLEntityDailyTag_AssociationCondition dateBetween(int i, int i2) {
        return (RFLEntityDailyTag_AssociationCondition) whereBetween(this.f3658a.date, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityDailyTag_AssociationCondition dateEq(int i) {
        return (RFLEntityDailyTag_AssociationCondition) where(this.f3658a.date, "=", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_AssociationCondition dateGe(int i) {
        return (RFLEntityDailyTag_AssociationCondition) where(this.f3658a.date, ">=", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_AssociationCondition dateGt(int i) {
        return (RFLEntityDailyTag_AssociationCondition) where(this.f3658a.date, ">", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_AssociationCondition dateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityDailyTag_AssociationCondition) mo19936in(false, this.f3658a.date, collection);
    }

    public final RFLEntityDailyTag_AssociationCondition dateIn(@NonNull Integer... numArr) {
        return dateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityDailyTag_AssociationCondition dateLe(int i) {
        return (RFLEntityDailyTag_AssociationCondition) where(this.f3658a.date, "<=", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_AssociationCondition dateLt(int i) {
        return (RFLEntityDailyTag_AssociationCondition) where(this.f3658a.date, "<", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_AssociationCondition dateNotEq(int i) {
        return (RFLEntityDailyTag_AssociationCondition) where(this.f3658a.date, "<>", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_AssociationCondition dateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityDailyTag_AssociationCondition) mo19936in(true, this.f3658a.date, collection);
    }

    public final RFLEntityDailyTag_AssociationCondition dateNotIn(@NonNull Integer... numArr) {
        return dateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityDailyTag_Schema getSchema() {
        return this.f3658a;
    }
}
