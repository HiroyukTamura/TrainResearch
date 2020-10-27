package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0694b;
import p009e.p015c.p016a.p017a.p018a.C0700h;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTrackPoint_AssociationCondition */
public class RFLEntityTrackPoint_AssociationCondition extends C0694b<RFLEntityTrackPoint, RFLEntityTrackPoint_AssociationCondition> {

    /* renamed from: a */
    final RFLEntityTrackPoint_Schema f3719a;

    public RFLEntityTrackPoint_AssociationCondition(C0700h hVar, RFLEntityTrackPoint_Schema rFLEntityTrackPoint_Schema) {
        super(hVar);
        this.f3719a = rFLEntityTrackPoint_Schema;
    }

    public RFLEntityTrackPoint_AssociationCondition(RFLEntityTrackPoint_AssociationCondition rFLEntityTrackPoint_AssociationCondition) {
        super(rFLEntityTrackPoint_AssociationCondition);
        this.f3719a = rFLEntityTrackPoint_AssociationCondition.getSchema();
    }

    public RFLEntityTrackPoint_AssociationCondition(RFLEntityTrackPoint_Relation rFLEntityTrackPoint_Relation) {
        super(rFLEntityTrackPoint_Relation);
        this.f3719a = rFLEntityTrackPoint_Relation.getSchema();
    }

    public RFLEntityTrackPoint_AssociationCondition clone() {
        return new RFLEntityTrackPoint_AssociationCondition(this);
    }

    public RFLEntityTrackPoint_AssociationCondition dateEq(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.date, "=", str);
    }

    public RFLEntityTrackPoint_AssociationCondition dateGe(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.date, ">=", str);
    }

    public RFLEntityTrackPoint_AssociationCondition dateGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.date, "GLOB", str);
    }

    public RFLEntityTrackPoint_AssociationCondition dateGt(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.date, ">", str);
    }

    public RFLEntityTrackPoint_AssociationCondition dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_AssociationCondition) mo19936in(false, this.f3719a.date, collection);
    }

    public final RFLEntityTrackPoint_AssociationCondition dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_AssociationCondition dateLe(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.date, "<=", str);
    }

    public RFLEntityTrackPoint_AssociationCondition dateLike(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.date, "LIKE", str);
    }

    public RFLEntityTrackPoint_AssociationCondition dateLt(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.date, "<", str);
    }

    public RFLEntityTrackPoint_AssociationCondition dateNotEq(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.date, "<>", str);
    }

    public RFLEntityTrackPoint_AssociationCondition dateNotGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.date, "NOT GLOB", str);
    }

    public RFLEntityTrackPoint_AssociationCondition dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_AssociationCondition) mo19936in(true, this.f3719a.date, collection);
    }

    public final RFLEntityTrackPoint_AssociationCondition dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_AssociationCondition dateNotLike(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityTrackPoint_Schema getSchema() {
        return this.f3719a;
    }

    public RFLEntityTrackPoint_AssociationCondition timezoneEq(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.timezone, "=", str);
    }

    public RFLEntityTrackPoint_AssociationCondition timezoneGe(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.timezone, ">=", str);
    }

    public RFLEntityTrackPoint_AssociationCondition timezoneGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.timezone, "GLOB", str);
    }

    public RFLEntityTrackPoint_AssociationCondition timezoneGt(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.timezone, ">", str);
    }

    public RFLEntityTrackPoint_AssociationCondition timezoneIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_AssociationCondition) mo19936in(false, this.f3719a.timezone, collection);
    }

    public final RFLEntityTrackPoint_AssociationCondition timezoneIn(@NonNull String... strArr) {
        return timezoneIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_AssociationCondition timezoneLe(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.timezone, "<=", str);
    }

    public RFLEntityTrackPoint_AssociationCondition timezoneLike(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.timezone, "LIKE", str);
    }

    public RFLEntityTrackPoint_AssociationCondition timezoneLt(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.timezone, "<", str);
    }

    public RFLEntityTrackPoint_AssociationCondition timezoneNotEq(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.timezone, "<>", str);
    }

    public RFLEntityTrackPoint_AssociationCondition timezoneNotGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.timezone, "NOT GLOB", str);
    }

    public RFLEntityTrackPoint_AssociationCondition timezoneNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_AssociationCondition) mo19936in(true, this.f3719a.timezone, collection);
    }

    public final RFLEntityTrackPoint_AssociationCondition timezoneNotIn(@NonNull String... strArr) {
        return timezoneNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_AssociationCondition timezoneNotLike(@NonNull String str) {
        return (RFLEntityTrackPoint_AssociationCondition) where(this.f3719a.timezone, "NOT LIKE", str);
    }
}
