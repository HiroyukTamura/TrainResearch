package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0694b;
import p009e.p015c.p016a.p017a.p018a.C0700h;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily_AssociationCondition */
public class RFLEntityDaily_AssociationCondition extends C0694b<RFLEntityDaily, RFLEntityDaily_AssociationCondition> {

    /* renamed from: a */
    final RFLEntityDaily_Schema f3665a;

    public RFLEntityDaily_AssociationCondition(C0700h hVar, RFLEntityDaily_Schema rFLEntityDaily_Schema) {
        super(hVar);
        this.f3665a = rFLEntityDaily_Schema;
    }

    public RFLEntityDaily_AssociationCondition(RFLEntityDaily_AssociationCondition rFLEntityDaily_AssociationCondition) {
        super(rFLEntityDaily_AssociationCondition);
        this.f3665a = rFLEntityDaily_AssociationCondition.getSchema();
    }

    public RFLEntityDaily_AssociationCondition(RFLEntityDaily_Relation rFLEntityDaily_Relation) {
        super(rFLEntityDaily_Relation);
        this.f3665a = rFLEntityDaily_Relation.getSchema();
    }

    public RFLEntityDaily_AssociationCondition clone() {
        return new RFLEntityDaily_AssociationCondition(this);
    }

    public RFLEntityDaily_AssociationCondition dateEq(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.date, "=", str);
    }

    public RFLEntityDaily_AssociationCondition dateGe(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.date, ">=", str);
    }

    public RFLEntityDaily_AssociationCondition dateGlob(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.date, "GLOB", str);
    }

    public RFLEntityDaily_AssociationCondition dateGt(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.date, ">", str);
    }

    public RFLEntityDaily_AssociationCondition dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_AssociationCondition) mo19936in(false, this.f3665a.date, collection);
    }

    public final RFLEntityDaily_AssociationCondition dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_AssociationCondition dateLe(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.date, "<=", str);
    }

    public RFLEntityDaily_AssociationCondition dateLike(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.date, "LIKE", str);
    }

    public RFLEntityDaily_AssociationCondition dateLt(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.date, "<", str);
    }

    public RFLEntityDaily_AssociationCondition dateNotEq(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.date, "<>", str);
    }

    public RFLEntityDaily_AssociationCondition dateNotGlob(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.date, "NOT GLOB", str);
    }

    public RFLEntityDaily_AssociationCondition dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_AssociationCondition) mo19936in(true, this.f3665a.date, collection);
    }

    public final RFLEntityDaily_AssociationCondition dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_AssociationCondition dateNotLike(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityDaily_Schema getSchema() {
        return this.f3665a;
    }

    public RFLEntityDaily_AssociationCondition timezoneEq(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.timezone, "=", str);
    }

    public RFLEntityDaily_AssociationCondition timezoneGe(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.timezone, ">=", str);
    }

    public RFLEntityDaily_AssociationCondition timezoneGlob(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.timezone, "GLOB", str);
    }

    public RFLEntityDaily_AssociationCondition timezoneGt(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.timezone, ">", str);
    }

    public RFLEntityDaily_AssociationCondition timezoneIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_AssociationCondition) mo19936in(false, this.f3665a.timezone, collection);
    }

    public final RFLEntityDaily_AssociationCondition timezoneIn(@NonNull String... strArr) {
        return timezoneIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_AssociationCondition timezoneLe(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.timezone, "<=", str);
    }

    public RFLEntityDaily_AssociationCondition timezoneLike(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.timezone, "LIKE", str);
    }

    public RFLEntityDaily_AssociationCondition timezoneLt(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.timezone, "<", str);
    }

    public RFLEntityDaily_AssociationCondition timezoneNotEq(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.timezone, "<>", str);
    }

    public RFLEntityDaily_AssociationCondition timezoneNotGlob(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.timezone, "NOT GLOB", str);
    }

    public RFLEntityDaily_AssociationCondition timezoneNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_AssociationCondition) mo19936in(true, this.f3665a.timezone, collection);
    }

    public final RFLEntityDaily_AssociationCondition timezoneNotIn(@NonNull String... strArr) {
        return timezoneNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_AssociationCondition timezoneNotLike(@NonNull String str) {
        return (RFLEntityDaily_AssociationCondition) where(this.f3665a.timezone, "NOT LIKE", str);
    }
}
