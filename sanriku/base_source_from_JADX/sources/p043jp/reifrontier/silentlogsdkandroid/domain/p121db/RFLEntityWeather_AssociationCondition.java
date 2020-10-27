package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0694b;
import p009e.p015c.p016a.p017a.p018a.C0700h;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather_AssociationCondition */
public class RFLEntityWeather_AssociationCondition extends C0694b<RFLEntityWeather, RFLEntityWeather_AssociationCondition> {

    /* renamed from: a */
    final RFLEntityWeather_Schema f3733a;

    public RFLEntityWeather_AssociationCondition(C0700h hVar, RFLEntityWeather_Schema rFLEntityWeather_Schema) {
        super(hVar);
        this.f3733a = rFLEntityWeather_Schema;
    }

    public RFLEntityWeather_AssociationCondition(RFLEntityWeather_AssociationCondition rFLEntityWeather_AssociationCondition) {
        super(rFLEntityWeather_AssociationCondition);
        this.f3733a = rFLEntityWeather_AssociationCondition.getSchema();
    }

    public RFLEntityWeather_AssociationCondition(RFLEntityWeather_Relation rFLEntityWeather_Relation) {
        super(rFLEntityWeather_Relation);
        this.f3733a = rFLEntityWeather_Relation.getSchema();
    }

    public RFLEntityWeather_AssociationCondition clone() {
        return new RFLEntityWeather_AssociationCondition(this);
    }

    public RFLEntityWeather_AssociationCondition dateBetween(int i, int i2) {
        return (RFLEntityWeather_AssociationCondition) whereBetween(this.f3733a.date, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityWeather_AssociationCondition dateEq(int i) {
        return (RFLEntityWeather_AssociationCondition) where(this.f3733a.date, "=", Integer.valueOf(i));
    }

    public RFLEntityWeather_AssociationCondition dateGe(int i) {
        return (RFLEntityWeather_AssociationCondition) where(this.f3733a.date, ">=", Integer.valueOf(i));
    }

    public RFLEntityWeather_AssociationCondition dateGt(int i) {
        return (RFLEntityWeather_AssociationCondition) where(this.f3733a.date, ">", Integer.valueOf(i));
    }

    public RFLEntityWeather_AssociationCondition dateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityWeather_AssociationCondition) mo19936in(false, this.f3733a.date, collection);
    }

    public final RFLEntityWeather_AssociationCondition dateIn(@NonNull Integer... numArr) {
        return dateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityWeather_AssociationCondition dateLe(int i) {
        return (RFLEntityWeather_AssociationCondition) where(this.f3733a.date, "<=", Integer.valueOf(i));
    }

    public RFLEntityWeather_AssociationCondition dateLt(int i) {
        return (RFLEntityWeather_AssociationCondition) where(this.f3733a.date, "<", Integer.valueOf(i));
    }

    public RFLEntityWeather_AssociationCondition dateNotEq(int i) {
        return (RFLEntityWeather_AssociationCondition) where(this.f3733a.date, "<>", Integer.valueOf(i));
    }

    public RFLEntityWeather_AssociationCondition dateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityWeather_AssociationCondition) mo19936in(true, this.f3733a.date, collection);
    }

    public final RFLEntityWeather_AssociationCondition dateNotIn(@NonNull Integer... numArr) {
        return dateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityWeather_Schema getSchema() {
        return this.f3733a;
    }
}
