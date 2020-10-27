package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0856e;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTrackPoint_Relation */
public class RFLEntityTrackPoint_Relation extends C0856e<RFLEntityTrackPoint, RFLEntityTrackPoint_Relation> {

    /* renamed from: a */
    final RFLEntityTrackPoint_Schema f3721a;

    public RFLEntityTrackPoint_Relation(C0855d dVar, RFLEntityTrackPoint_Schema rFLEntityTrackPoint_Schema) {
        super(dVar);
        this.f3721a = rFLEntityTrackPoint_Schema;
    }

    public RFLEntityTrackPoint_Relation(RFLEntityTrackPoint_Relation rFLEntityTrackPoint_Relation) {
        super(rFLEntityTrackPoint_Relation);
        this.f3721a = rFLEntityTrackPoint_Relation.getSchema();
    }

    public RFLEntityTrackPoint_Relation clone() {
        return new RFLEntityTrackPoint_Relation(this);
    }

    public RFLEntityTrackPoint_Relation dateEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.date, "=", str);
    }

    public RFLEntityTrackPoint_Relation dateGe(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.date, ">=", str);
    }

    public RFLEntityTrackPoint_Relation dateGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.date, "GLOB", str);
    }

    public RFLEntityTrackPoint_Relation dateGt(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.date, ">", str);
    }

    public RFLEntityTrackPoint_Relation dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Relation) mo19936in(false, this.f3721a.date, collection);
    }

    public final RFLEntityTrackPoint_Relation dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Relation dateLe(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.date, "<=", str);
    }

    public RFLEntityTrackPoint_Relation dateLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.date, "LIKE", str);
    }

    public RFLEntityTrackPoint_Relation dateLt(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.date, "<", str);
    }

    public RFLEntityTrackPoint_Relation dateNotEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.date, "<>", str);
    }

    public RFLEntityTrackPoint_Relation dateNotGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.date, "NOT GLOB", str);
    }

    public RFLEntityTrackPoint_Relation dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Relation) mo19936in(true, this.f3721a.date, collection);
    }

    public final RFLEntityTrackPoint_Relation dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Relation dateNotLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityTrackPoint_Deleter deleter() {
        return new RFLEntityTrackPoint_Deleter(this);
    }

    @NonNull
    public RFLEntityTrackPoint_Schema getSchema() {
        return this.f3721a;
    }

    public RFLEntityTrackPoint_Relation orderByDateAsc() {
        return (RFLEntityTrackPoint_Relation) orderBy(this.f3721a.date.orderInAscending());
    }

    public RFLEntityTrackPoint_Relation orderByDateDesc() {
        return (RFLEntityTrackPoint_Relation) orderBy(this.f3721a.date.orderInDescending());
    }

    public RFLEntityTrackPoint_Relation orderByTimezoneAsc() {
        return (RFLEntityTrackPoint_Relation) orderBy(this.f3721a.timezone.orderInAscending());
    }

    public RFLEntityTrackPoint_Relation orderByTimezoneDesc() {
        return (RFLEntityTrackPoint_Relation) orderBy(this.f3721a.timezone.orderInDescending());
    }

    @NonNull
    public RFLEntityTrackPoint_Selector selector() {
        return new RFLEntityTrackPoint_Selector(this);
    }

    public RFLEntityTrackPoint_Relation timezoneEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.timezone, "=", str);
    }

    public RFLEntityTrackPoint_Relation timezoneGe(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.timezone, ">=", str);
    }

    public RFLEntityTrackPoint_Relation timezoneGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.timezone, "GLOB", str);
    }

    public RFLEntityTrackPoint_Relation timezoneGt(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.timezone, ">", str);
    }

    public RFLEntityTrackPoint_Relation timezoneIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Relation) mo19936in(false, this.f3721a.timezone, collection);
    }

    public final RFLEntityTrackPoint_Relation timezoneIn(@NonNull String... strArr) {
        return timezoneIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Relation timezoneLe(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.timezone, "<=", str);
    }

    public RFLEntityTrackPoint_Relation timezoneLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.timezone, "LIKE", str);
    }

    public RFLEntityTrackPoint_Relation timezoneLt(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.timezone, "<", str);
    }

    public RFLEntityTrackPoint_Relation timezoneNotEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.timezone, "<>", str);
    }

    public RFLEntityTrackPoint_Relation timezoneNotGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.timezone, "NOT GLOB", str);
    }

    public RFLEntityTrackPoint_Relation timezoneNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Relation) mo19936in(true, this.f3721a.timezone, collection);
    }

    public final RFLEntityTrackPoint_Relation timezoneNotIn(@NonNull String... strArr) {
        return timezoneNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Relation timezoneNotLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Relation) where(this.f3721a.timezone, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityTrackPoint_Updater updater() {
        return new RFLEntityTrackPoint_Updater(this);
    }

    @NonNull
    public RFLEntityTrackPoint upsertWithoutTransaction(@NonNull RFLEntityTrackPoint rFLEntityTrackPoint) {
        throw new UnsupportedOperationException("upsert is not supported because of missing @PrimaryKey");
    }
}
