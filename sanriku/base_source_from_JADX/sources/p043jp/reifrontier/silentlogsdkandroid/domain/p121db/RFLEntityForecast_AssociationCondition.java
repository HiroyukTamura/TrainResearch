package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0694b;
import p009e.p015c.p016a.p017a.p018a.C0700h;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast_AssociationCondition */
public class RFLEntityForecast_AssociationCondition extends C0694b<RFLEntityForecast, RFLEntityForecast_AssociationCondition> {

    /* renamed from: a */
    final RFLEntityForecast_Schema f3679a;

    public RFLEntityForecast_AssociationCondition(C0700h hVar, RFLEntityForecast_Schema rFLEntityForecast_Schema) {
        super(hVar);
        this.f3679a = rFLEntityForecast_Schema;
    }

    public RFLEntityForecast_AssociationCondition(RFLEntityForecast_AssociationCondition rFLEntityForecast_AssociationCondition) {
        super(rFLEntityForecast_AssociationCondition);
        this.f3679a = rFLEntityForecast_AssociationCondition.getSchema();
    }

    public RFLEntityForecast_AssociationCondition(RFLEntityForecast_Relation rFLEntityForecast_Relation) {
        super(rFLEntityForecast_Relation);
        this.f3679a = rFLEntityForecast_Relation.getSchema();
    }

    public RFLEntityForecast_AssociationCondition clone() {
        return new RFLEntityForecast_AssociationCondition(this);
    }

    public RFLEntityForecast_AssociationCondition dateBetween(int i, int i2) {
        return (RFLEntityForecast_AssociationCondition) whereBetween(this.f3679a.date, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityForecast_AssociationCondition dateEq(int i) {
        return (RFLEntityForecast_AssociationCondition) where(this.f3679a.date, "=", Integer.valueOf(i));
    }

    public RFLEntityForecast_AssociationCondition dateGe(int i) {
        return (RFLEntityForecast_AssociationCondition) where(this.f3679a.date, ">=", Integer.valueOf(i));
    }

    public RFLEntityForecast_AssociationCondition dateGt(int i) {
        return (RFLEntityForecast_AssociationCondition) where(this.f3679a.date, ">", Integer.valueOf(i));
    }

    public RFLEntityForecast_AssociationCondition dateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityForecast_AssociationCondition) mo19936in(false, this.f3679a.date, collection);
    }

    public final RFLEntityForecast_AssociationCondition dateIn(@NonNull Integer... numArr) {
        return dateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityForecast_AssociationCondition dateLe(int i) {
        return (RFLEntityForecast_AssociationCondition) where(this.f3679a.date, "<=", Integer.valueOf(i));
    }

    public RFLEntityForecast_AssociationCondition dateLt(int i) {
        return (RFLEntityForecast_AssociationCondition) where(this.f3679a.date, "<", Integer.valueOf(i));
    }

    public RFLEntityForecast_AssociationCondition dateNotEq(int i) {
        return (RFLEntityForecast_AssociationCondition) where(this.f3679a.date, "<>", Integer.valueOf(i));
    }

    public RFLEntityForecast_AssociationCondition dateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityForecast_AssociationCondition) mo19936in(true, this.f3679a.date, collection);
    }

    public final RFLEntityForecast_AssociationCondition dateNotIn(@NonNull Integer... numArr) {
        return dateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityForecast_Schema getSchema() {
        return this.f3679a;
    }
}
