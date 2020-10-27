package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0856e;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily_Relation */
public class RFLEntityDaily_Relation extends C0856e<RFLEntityDaily, RFLEntityDaily_Relation> {

    /* renamed from: a */
    final RFLEntityDaily_Schema f3667a;

    public RFLEntityDaily_Relation(C0855d dVar, RFLEntityDaily_Schema rFLEntityDaily_Schema) {
        super(dVar);
        this.f3667a = rFLEntityDaily_Schema;
    }

    public RFLEntityDaily_Relation(RFLEntityDaily_Relation rFLEntityDaily_Relation) {
        super(rFLEntityDaily_Relation);
        this.f3667a = rFLEntityDaily_Relation.getSchema();
    }

    public RFLEntityDaily_Relation clone() {
        return new RFLEntityDaily_Relation(this);
    }

    public RFLEntityDaily_Relation dateEq(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.date, "=", str);
    }

    public RFLEntityDaily_Relation dateGe(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.date, ">=", str);
    }

    public RFLEntityDaily_Relation dateGlob(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.date, "GLOB", str);
    }

    public RFLEntityDaily_Relation dateGt(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.date, ">", str);
    }

    public RFLEntityDaily_Relation dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Relation) mo19936in(false, this.f3667a.date, collection);
    }

    public final RFLEntityDaily_Relation dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Relation dateLe(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.date, "<=", str);
    }

    public RFLEntityDaily_Relation dateLike(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.date, "LIKE", str);
    }

    public RFLEntityDaily_Relation dateLt(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.date, "<", str);
    }

    public RFLEntityDaily_Relation dateNotEq(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.date, "<>", str);
    }

    public RFLEntityDaily_Relation dateNotGlob(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.date, "NOT GLOB", str);
    }

    public RFLEntityDaily_Relation dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Relation) mo19936in(true, this.f3667a.date, collection);
    }

    public final RFLEntityDaily_Relation dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Relation dateNotLike(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityDaily_Deleter deleter() {
        return new RFLEntityDaily_Deleter(this);
    }

    @NonNull
    public RFLEntityDaily_Schema getSchema() {
        return this.f3667a;
    }

    public RFLEntityDaily_Relation orderByDateAsc() {
        return (RFLEntityDaily_Relation) orderBy(this.f3667a.date.orderInAscending());
    }

    public RFLEntityDaily_Relation orderByDateDesc() {
        return (RFLEntityDaily_Relation) orderBy(this.f3667a.date.orderInDescending());
    }

    public RFLEntityDaily_Relation orderByTimezoneAsc() {
        return (RFLEntityDaily_Relation) orderBy(this.f3667a.timezone.orderInAscending());
    }

    public RFLEntityDaily_Relation orderByTimezoneDesc() {
        return (RFLEntityDaily_Relation) orderBy(this.f3667a.timezone.orderInDescending());
    }

    @NonNull
    public RFLEntityDaily_Selector selector() {
        return new RFLEntityDaily_Selector(this);
    }

    public RFLEntityDaily_Relation timezoneEq(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.timezone, "=", str);
    }

    public RFLEntityDaily_Relation timezoneGe(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.timezone, ">=", str);
    }

    public RFLEntityDaily_Relation timezoneGlob(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.timezone, "GLOB", str);
    }

    public RFLEntityDaily_Relation timezoneGt(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.timezone, ">", str);
    }

    public RFLEntityDaily_Relation timezoneIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Relation) mo19936in(false, this.f3667a.timezone, collection);
    }

    public final RFLEntityDaily_Relation timezoneIn(@NonNull String... strArr) {
        return timezoneIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Relation timezoneLe(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.timezone, "<=", str);
    }

    public RFLEntityDaily_Relation timezoneLike(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.timezone, "LIKE", str);
    }

    public RFLEntityDaily_Relation timezoneLt(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.timezone, "<", str);
    }

    public RFLEntityDaily_Relation timezoneNotEq(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.timezone, "<>", str);
    }

    public RFLEntityDaily_Relation timezoneNotGlob(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.timezone, "NOT GLOB", str);
    }

    public RFLEntityDaily_Relation timezoneNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Relation) mo19936in(true, this.f3667a.timezone, collection);
    }

    public final RFLEntityDaily_Relation timezoneNotIn(@NonNull String... strArr) {
        return timezoneNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Relation timezoneNotLike(@NonNull String str) {
        return (RFLEntityDaily_Relation) where(this.f3667a.timezone, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityDaily_Updater updater() {
        return new RFLEntityDaily_Updater(this);
    }

    @NonNull
    public RFLEntityDaily upsertWithoutTransaction(@NonNull RFLEntityDaily rFLEntityDaily) {
        throw new UnsupportedOperationException("upsert is not supported because of missing @PrimaryKey");
    }
}
