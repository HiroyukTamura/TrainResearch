package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0694b;
import p009e.p015c.p016a.p017a.p018a.C0700h;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer_AssociationCondition */
public class RFLEntityBarometer_AssociationCondition extends C0694b<RFLEntityBarometer, RFLEntityBarometer_AssociationCondition> {

    /* renamed from: a */
    final RFLEntityBarometer_Schema f3644a;

    public RFLEntityBarometer_AssociationCondition(C0700h hVar, RFLEntityBarometer_Schema rFLEntityBarometer_Schema) {
        super(hVar);
        this.f3644a = rFLEntityBarometer_Schema;
    }

    public RFLEntityBarometer_AssociationCondition(RFLEntityBarometer_AssociationCondition rFLEntityBarometer_AssociationCondition) {
        super(rFLEntityBarometer_AssociationCondition);
        this.f3644a = rFLEntityBarometer_AssociationCondition.getSchema();
    }

    public RFLEntityBarometer_AssociationCondition(RFLEntityBarometer_Relation rFLEntityBarometer_Relation) {
        super(rFLEntityBarometer_Relation);
        this.f3644a = rFLEntityBarometer_Relation.getSchema();
    }

    public RFLEntityBarometer_AssociationCondition clone() {
        return new RFLEntityBarometer_AssociationCondition(this);
    }

    public RFLEntityBarometer_AssociationCondition dateEq(@NonNull String str) {
        return (RFLEntityBarometer_AssociationCondition) where(this.f3644a.date, "=", str);
    }

    public RFLEntityBarometer_AssociationCondition dateGe(@NonNull String str) {
        return (RFLEntityBarometer_AssociationCondition) where(this.f3644a.date, ">=", str);
    }

    public RFLEntityBarometer_AssociationCondition dateGlob(@NonNull String str) {
        return (RFLEntityBarometer_AssociationCondition) where(this.f3644a.date, "GLOB", str);
    }

    public RFLEntityBarometer_AssociationCondition dateGt(@NonNull String str) {
        return (RFLEntityBarometer_AssociationCondition) where(this.f3644a.date, ">", str);
    }

    public RFLEntityBarometer_AssociationCondition dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityBarometer_AssociationCondition) mo19936in(false, this.f3644a.date, collection);
    }

    public final RFLEntityBarometer_AssociationCondition dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityBarometer_AssociationCondition dateLe(@NonNull String str) {
        return (RFLEntityBarometer_AssociationCondition) where(this.f3644a.date, "<=", str);
    }

    public RFLEntityBarometer_AssociationCondition dateLike(@NonNull String str) {
        return (RFLEntityBarometer_AssociationCondition) where(this.f3644a.date, "LIKE", str);
    }

    public RFLEntityBarometer_AssociationCondition dateLt(@NonNull String str) {
        return (RFLEntityBarometer_AssociationCondition) where(this.f3644a.date, "<", str);
    }

    public RFLEntityBarometer_AssociationCondition dateNotEq(@NonNull String str) {
        return (RFLEntityBarometer_AssociationCondition) where(this.f3644a.date, "<>", str);
    }

    public RFLEntityBarometer_AssociationCondition dateNotGlob(@NonNull String str) {
        return (RFLEntityBarometer_AssociationCondition) where(this.f3644a.date, "NOT GLOB", str);
    }

    public RFLEntityBarometer_AssociationCondition dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityBarometer_AssociationCondition) mo19936in(true, this.f3644a.date, collection);
    }

    public final RFLEntityBarometer_AssociationCondition dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityBarometer_AssociationCondition dateNotLike(@NonNull String str) {
        return (RFLEntityBarometer_AssociationCondition) where(this.f3644a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityBarometer_Schema getSchema() {
        return this.f3644a;
    }
}
