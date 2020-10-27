package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0694b;
import p009e.p015c.p016a.p017a.p018a.C0700h;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTP_AssociationCondition */
public class RFLEntityTP_AssociationCondition extends C0694b<RFLEntityTP, RFLEntityTP_AssociationCondition> {

    /* renamed from: a */
    final RFLEntityTP_Schema f3697a;

    public RFLEntityTP_AssociationCondition(C0700h hVar, RFLEntityTP_Schema rFLEntityTP_Schema) {
        super(hVar);
        this.f3697a = rFLEntityTP_Schema;
    }

    public RFLEntityTP_AssociationCondition(RFLEntityTP_AssociationCondition rFLEntityTP_AssociationCondition) {
        super(rFLEntityTP_AssociationCondition);
        this.f3697a = rFLEntityTP_AssociationCondition.getSchema();
    }

    public RFLEntityTP_AssociationCondition(RFLEntityTP_Relation rFLEntityTP_Relation) {
        super(rFLEntityTP_Relation);
        this.f3697a = rFLEntityTP_Relation.getSchema();
    }

    public RFLEntityTP_AssociationCondition clone() {
        return new RFLEntityTP_AssociationCondition(this);
    }

    public RFLEntityTP_AssociationCondition dateEq(@NonNull String str) {
        return (RFLEntityTP_AssociationCondition) where(this.f3697a.date, "=", str);
    }

    public RFLEntityTP_AssociationCondition dateGe(@NonNull String str) {
        return (RFLEntityTP_AssociationCondition) where(this.f3697a.date, ">=", str);
    }

    public RFLEntityTP_AssociationCondition dateGlob(@NonNull String str) {
        return (RFLEntityTP_AssociationCondition) where(this.f3697a.date, "GLOB", str);
    }

    public RFLEntityTP_AssociationCondition dateGt(@NonNull String str) {
        return (RFLEntityTP_AssociationCondition) where(this.f3697a.date, ">", str);
    }

    public RFLEntityTP_AssociationCondition dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityTP_AssociationCondition) mo19936in(false, this.f3697a.date, collection);
    }

    public final RFLEntityTP_AssociationCondition dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTP_AssociationCondition dateLe(@NonNull String str) {
        return (RFLEntityTP_AssociationCondition) where(this.f3697a.date, "<=", str);
    }

    public RFLEntityTP_AssociationCondition dateLike(@NonNull String str) {
        return (RFLEntityTP_AssociationCondition) where(this.f3697a.date, "LIKE", str);
    }

    public RFLEntityTP_AssociationCondition dateLt(@NonNull String str) {
        return (RFLEntityTP_AssociationCondition) where(this.f3697a.date, "<", str);
    }

    public RFLEntityTP_AssociationCondition dateNotEq(@NonNull String str) {
        return (RFLEntityTP_AssociationCondition) where(this.f3697a.date, "<>", str);
    }

    public RFLEntityTP_AssociationCondition dateNotGlob(@NonNull String str) {
        return (RFLEntityTP_AssociationCondition) where(this.f3697a.date, "NOT GLOB", str);
    }

    public RFLEntityTP_AssociationCondition dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityTP_AssociationCondition) mo19936in(true, this.f3697a.date, collection);
    }

    public final RFLEntityTP_AssociationCondition dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTP_AssociationCondition dateNotLike(@NonNull String str) {
        return (RFLEntityTP_AssociationCondition) where(this.f3697a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityTP_Schema getSchema() {
        return this.f3697a;
    }
}
