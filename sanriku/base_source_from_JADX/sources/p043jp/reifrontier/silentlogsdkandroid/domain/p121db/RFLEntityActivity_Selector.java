package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0865f;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity_Selector */
public class RFLEntityActivity_Selector extends C0865f<RFLEntityActivity, RFLEntityActivity_Selector> {

    /* renamed from: a */
    final RFLEntityActivity_Schema f3629a;

    public RFLEntityActivity_Selector(C0855d dVar, RFLEntityActivity_Schema rFLEntityActivity_Schema) {
        super((C0700h) dVar);
        this.f3629a = rFLEntityActivity_Schema;
    }

    public RFLEntityActivity_Selector(RFLEntityActivity_Relation rFLEntityActivity_Relation) {
        super(rFLEntityActivity_Relation);
        this.f3629a = rFLEntityActivity_Relation.getSchema();
    }

    public RFLEntityActivity_Selector(RFLEntityActivity_Selector rFLEntityActivity_Selector) {
        super(rFLEntityActivity_Selector);
        this.f3629a = rFLEntityActivity_Selector.getSchema();
    }

    public RFLEntityActivity_Selector clone() {
        return new RFLEntityActivity_Selector(this);
    }

    public RFLEntityActivity_Selector dateEq(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.date, "=", str);
    }

    public RFLEntityActivity_Selector dateGe(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.date, ">=", str);
    }

    public RFLEntityActivity_Selector dateGlob(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.date, "GLOB", str);
    }

    public RFLEntityActivity_Selector dateGt(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.date, ">", str);
    }

    public RFLEntityActivity_Selector dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Selector) mo19936in(false, this.f3629a.date, collection);
    }

    public final RFLEntityActivity_Selector dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Selector dateLe(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.date, "<=", str);
    }

    public RFLEntityActivity_Selector dateLike(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.date, "LIKE", str);
    }

    public RFLEntityActivity_Selector dateLt(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.date, "<", str);
    }

    public RFLEntityActivity_Selector dateNotEq(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.date, "<>", str);
    }

    public RFLEntityActivity_Selector dateNotGlob(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.date, "NOT GLOB", str);
    }

    public RFLEntityActivity_Selector dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Selector) mo19936in(true, this.f3629a.date, collection);
    }

    public final RFLEntityActivity_Selector dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Selector dateNotLike(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityActivity_Schema getSchema() {
        return this.f3629a;
    }

    public RFLEntityActivity_Selector orderByDateAsc() {
        return (RFLEntityActivity_Selector) orderBy(this.f3629a.date.orderInAscending());
    }

    public RFLEntityActivity_Selector orderByDateDesc() {
        return (RFLEntityActivity_Selector) orderBy(this.f3629a.date.orderInDescending());
    }

    public RFLEntityActivity_Selector orderByTimezoneAsc() {
        return (RFLEntityActivity_Selector) orderBy(this.f3629a.timezone.orderInAscending());
    }

    public RFLEntityActivity_Selector orderByTimezoneDesc() {
        return (RFLEntityActivity_Selector) orderBy(this.f3629a.timezone.orderInDescending());
    }

    public RFLEntityActivity_Selector timezoneEq(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.timezone, "=", str);
    }

    public RFLEntityActivity_Selector timezoneGe(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.timezone, ">=", str);
    }

    public RFLEntityActivity_Selector timezoneGlob(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.timezone, "GLOB", str);
    }

    public RFLEntityActivity_Selector timezoneGt(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.timezone, ">", str);
    }

    public RFLEntityActivity_Selector timezoneIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Selector) mo19936in(false, this.f3629a.timezone, collection);
    }

    public final RFLEntityActivity_Selector timezoneIn(@NonNull String... strArr) {
        return timezoneIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Selector timezoneLe(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.timezone, "<=", str);
    }

    public RFLEntityActivity_Selector timezoneLike(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.timezone, "LIKE", str);
    }

    public RFLEntityActivity_Selector timezoneLt(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.timezone, "<", str);
    }

    public RFLEntityActivity_Selector timezoneNotEq(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.timezone, "<>", str);
    }

    public RFLEntityActivity_Selector timezoneNotGlob(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.timezone, "NOT GLOB", str);
    }

    public RFLEntityActivity_Selector timezoneNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Selector) mo19936in(true, this.f3629a.timezone, collection);
    }

    public final RFLEntityActivity_Selector timezoneNotIn(@NonNull String... strArr) {
        return timezoneNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Selector timezoneNotLike(@NonNull String str) {
        return (RFLEntityActivity_Selector) where(this.f3629a.timezone, "NOT LIKE", str);
    }
}
