package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0694b;
import p009e.p015c.p016a.p017a.p018a.C0700h;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity_AssociationCondition */
public class RFLEntityActivity_AssociationCondition extends C0694b<RFLEntityActivity, RFLEntityActivity_AssociationCondition> {

    /* renamed from: a */
    final RFLEntityActivity_Schema f3624a;

    public RFLEntityActivity_AssociationCondition(C0700h hVar, RFLEntityActivity_Schema rFLEntityActivity_Schema) {
        super(hVar);
        this.f3624a = rFLEntityActivity_Schema;
    }

    public RFLEntityActivity_AssociationCondition(RFLEntityActivity_AssociationCondition rFLEntityActivity_AssociationCondition) {
        super(rFLEntityActivity_AssociationCondition);
        this.f3624a = rFLEntityActivity_AssociationCondition.getSchema();
    }

    public RFLEntityActivity_AssociationCondition(RFLEntityActivity_Relation rFLEntityActivity_Relation) {
        super(rFLEntityActivity_Relation);
        this.f3624a = rFLEntityActivity_Relation.getSchema();
    }

    public RFLEntityActivity_AssociationCondition clone() {
        return new RFLEntityActivity_AssociationCondition(this);
    }

    public RFLEntityActivity_AssociationCondition dateEq(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.date, "=", str);
    }

    public RFLEntityActivity_AssociationCondition dateGe(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.date, ">=", str);
    }

    public RFLEntityActivity_AssociationCondition dateGlob(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.date, "GLOB", str);
    }

    public RFLEntityActivity_AssociationCondition dateGt(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.date, ">", str);
    }

    public RFLEntityActivity_AssociationCondition dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_AssociationCondition) mo19936in(false, this.f3624a.date, collection);
    }

    public final RFLEntityActivity_AssociationCondition dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_AssociationCondition dateLe(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.date, "<=", str);
    }

    public RFLEntityActivity_AssociationCondition dateLike(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.date, "LIKE", str);
    }

    public RFLEntityActivity_AssociationCondition dateLt(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.date, "<", str);
    }

    public RFLEntityActivity_AssociationCondition dateNotEq(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.date, "<>", str);
    }

    public RFLEntityActivity_AssociationCondition dateNotGlob(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.date, "NOT GLOB", str);
    }

    public RFLEntityActivity_AssociationCondition dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_AssociationCondition) mo19936in(true, this.f3624a.date, collection);
    }

    public final RFLEntityActivity_AssociationCondition dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_AssociationCondition dateNotLike(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityActivity_Schema getSchema() {
        return this.f3624a;
    }

    public RFLEntityActivity_AssociationCondition timezoneEq(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.timezone, "=", str);
    }

    public RFLEntityActivity_AssociationCondition timezoneGe(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.timezone, ">=", str);
    }

    public RFLEntityActivity_AssociationCondition timezoneGlob(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.timezone, "GLOB", str);
    }

    public RFLEntityActivity_AssociationCondition timezoneGt(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.timezone, ">", str);
    }

    public RFLEntityActivity_AssociationCondition timezoneIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_AssociationCondition) mo19936in(false, this.f3624a.timezone, collection);
    }

    public final RFLEntityActivity_AssociationCondition timezoneIn(@NonNull String... strArr) {
        return timezoneIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_AssociationCondition timezoneLe(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.timezone, "<=", str);
    }

    public RFLEntityActivity_AssociationCondition timezoneLike(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.timezone, "LIKE", str);
    }

    public RFLEntityActivity_AssociationCondition timezoneLt(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.timezone, "<", str);
    }

    public RFLEntityActivity_AssociationCondition timezoneNotEq(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.timezone, "<>", str);
    }

    public RFLEntityActivity_AssociationCondition timezoneNotGlob(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.timezone, "NOT GLOB", str);
    }

    public RFLEntityActivity_AssociationCondition timezoneNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_AssociationCondition) mo19936in(true, this.f3624a.timezone, collection);
    }

    public final RFLEntityActivity_AssociationCondition timezoneNotIn(@NonNull String... strArr) {
        return timezoneNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_AssociationCondition timezoneNotLike(@NonNull String str) {
        return (RFLEntityActivity_AssociationCondition) where(this.f3624a.timezone, "NOT LIKE", str);
    }
}
