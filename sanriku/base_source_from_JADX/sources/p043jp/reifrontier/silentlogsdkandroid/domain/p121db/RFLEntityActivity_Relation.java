package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0856e;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity_Relation */
public class RFLEntityActivity_Relation extends C0856e<RFLEntityActivity, RFLEntityActivity_Relation> {

    /* renamed from: a */
    final RFLEntityActivity_Schema f3626a;

    public RFLEntityActivity_Relation(C0855d dVar, RFLEntityActivity_Schema rFLEntityActivity_Schema) {
        super(dVar);
        this.f3626a = rFLEntityActivity_Schema;
    }

    public RFLEntityActivity_Relation(RFLEntityActivity_Relation rFLEntityActivity_Relation) {
        super(rFLEntityActivity_Relation);
        this.f3626a = rFLEntityActivity_Relation.getSchema();
    }

    public RFLEntityActivity_Relation clone() {
        return new RFLEntityActivity_Relation(this);
    }

    public RFLEntityActivity_Relation dateEq(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.date, "=", str);
    }

    public RFLEntityActivity_Relation dateGe(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.date, ">=", str);
    }

    public RFLEntityActivity_Relation dateGlob(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.date, "GLOB", str);
    }

    public RFLEntityActivity_Relation dateGt(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.date, ">", str);
    }

    public RFLEntityActivity_Relation dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Relation) mo19936in(false, this.f3626a.date, collection);
    }

    public final RFLEntityActivity_Relation dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Relation dateLe(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.date, "<=", str);
    }

    public RFLEntityActivity_Relation dateLike(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.date, "LIKE", str);
    }

    public RFLEntityActivity_Relation dateLt(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.date, "<", str);
    }

    public RFLEntityActivity_Relation dateNotEq(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.date, "<>", str);
    }

    public RFLEntityActivity_Relation dateNotGlob(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.date, "NOT GLOB", str);
    }

    public RFLEntityActivity_Relation dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Relation) mo19936in(true, this.f3626a.date, collection);
    }

    public final RFLEntityActivity_Relation dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Relation dateNotLike(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityActivity_Deleter deleter() {
        return new RFLEntityActivity_Deleter(this);
    }

    @NonNull
    public RFLEntityActivity_Schema getSchema() {
        return this.f3626a;
    }

    public RFLEntityActivity_Relation orderByDateAsc() {
        return (RFLEntityActivity_Relation) orderBy(this.f3626a.date.orderInAscending());
    }

    public RFLEntityActivity_Relation orderByDateDesc() {
        return (RFLEntityActivity_Relation) orderBy(this.f3626a.date.orderInDescending());
    }

    public RFLEntityActivity_Relation orderByTimezoneAsc() {
        return (RFLEntityActivity_Relation) orderBy(this.f3626a.timezone.orderInAscending());
    }

    public RFLEntityActivity_Relation orderByTimezoneDesc() {
        return (RFLEntityActivity_Relation) orderBy(this.f3626a.timezone.orderInDescending());
    }

    @NonNull
    public RFLEntityActivity_Selector selector() {
        return new RFLEntityActivity_Selector(this);
    }

    public RFLEntityActivity_Relation timezoneEq(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.timezone, "=", str);
    }

    public RFLEntityActivity_Relation timezoneGe(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.timezone, ">=", str);
    }

    public RFLEntityActivity_Relation timezoneGlob(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.timezone, "GLOB", str);
    }

    public RFLEntityActivity_Relation timezoneGt(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.timezone, ">", str);
    }

    public RFLEntityActivity_Relation timezoneIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Relation) mo19936in(false, this.f3626a.timezone, collection);
    }

    public final RFLEntityActivity_Relation timezoneIn(@NonNull String... strArr) {
        return timezoneIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Relation timezoneLe(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.timezone, "<=", str);
    }

    public RFLEntityActivity_Relation timezoneLike(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.timezone, "LIKE", str);
    }

    public RFLEntityActivity_Relation timezoneLt(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.timezone, "<", str);
    }

    public RFLEntityActivity_Relation timezoneNotEq(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.timezone, "<>", str);
    }

    public RFLEntityActivity_Relation timezoneNotGlob(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.timezone, "NOT GLOB", str);
    }

    public RFLEntityActivity_Relation timezoneNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Relation) mo19936in(true, this.f3626a.timezone, collection);
    }

    public final RFLEntityActivity_Relation timezoneNotIn(@NonNull String... strArr) {
        return timezoneNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Relation timezoneNotLike(@NonNull String str) {
        return (RFLEntityActivity_Relation) where(this.f3626a.timezone, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityActivity_Updater updater() {
        return new RFLEntityActivity_Updater(this);
    }

    @NonNull
    public RFLEntityActivity upsertWithoutTransaction(@NonNull RFLEntityActivity rFLEntityActivity) {
        throw new UnsupportedOperationException("upsert is not supported because of missing @PrimaryKey");
    }
}
