package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0865f;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily_Selector */
public class RFLEntityDaily_Selector extends C0865f<RFLEntityDaily, RFLEntityDaily_Selector> {

    /* renamed from: a */
    final RFLEntityDaily_Schema f3670a;

    public RFLEntityDaily_Selector(C0855d dVar, RFLEntityDaily_Schema rFLEntityDaily_Schema) {
        super((C0700h) dVar);
        this.f3670a = rFLEntityDaily_Schema;
    }

    public RFLEntityDaily_Selector(RFLEntityDaily_Relation rFLEntityDaily_Relation) {
        super(rFLEntityDaily_Relation);
        this.f3670a = rFLEntityDaily_Relation.getSchema();
    }

    public RFLEntityDaily_Selector(RFLEntityDaily_Selector rFLEntityDaily_Selector) {
        super(rFLEntityDaily_Selector);
        this.f3670a = rFLEntityDaily_Selector.getSchema();
    }

    public RFLEntityDaily_Selector clone() {
        return new RFLEntityDaily_Selector(this);
    }

    public RFLEntityDaily_Selector dateEq(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.date, "=", str);
    }

    public RFLEntityDaily_Selector dateGe(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.date, ">=", str);
    }

    public RFLEntityDaily_Selector dateGlob(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.date, "GLOB", str);
    }

    public RFLEntityDaily_Selector dateGt(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.date, ">", str);
    }

    public RFLEntityDaily_Selector dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Selector) mo19936in(false, this.f3670a.date, collection);
    }

    public final RFLEntityDaily_Selector dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Selector dateLe(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.date, "<=", str);
    }

    public RFLEntityDaily_Selector dateLike(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.date, "LIKE", str);
    }

    public RFLEntityDaily_Selector dateLt(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.date, "<", str);
    }

    public RFLEntityDaily_Selector dateNotEq(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.date, "<>", str);
    }

    public RFLEntityDaily_Selector dateNotGlob(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.date, "NOT GLOB", str);
    }

    public RFLEntityDaily_Selector dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Selector) mo19936in(true, this.f3670a.date, collection);
    }

    public final RFLEntityDaily_Selector dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Selector dateNotLike(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityDaily_Schema getSchema() {
        return this.f3670a;
    }

    public RFLEntityDaily_Selector orderByDateAsc() {
        return (RFLEntityDaily_Selector) orderBy(this.f3670a.date.orderInAscending());
    }

    public RFLEntityDaily_Selector orderByDateDesc() {
        return (RFLEntityDaily_Selector) orderBy(this.f3670a.date.orderInDescending());
    }

    public RFLEntityDaily_Selector orderByTimezoneAsc() {
        return (RFLEntityDaily_Selector) orderBy(this.f3670a.timezone.orderInAscending());
    }

    public RFLEntityDaily_Selector orderByTimezoneDesc() {
        return (RFLEntityDaily_Selector) orderBy(this.f3670a.timezone.orderInDescending());
    }

    public RFLEntityDaily_Selector timezoneEq(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.timezone, "=", str);
    }

    public RFLEntityDaily_Selector timezoneGe(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.timezone, ">=", str);
    }

    public RFLEntityDaily_Selector timezoneGlob(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.timezone, "GLOB", str);
    }

    public RFLEntityDaily_Selector timezoneGt(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.timezone, ">", str);
    }

    public RFLEntityDaily_Selector timezoneIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Selector) mo19936in(false, this.f3670a.timezone, collection);
    }

    public final RFLEntityDaily_Selector timezoneIn(@NonNull String... strArr) {
        return timezoneIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Selector timezoneLe(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.timezone, "<=", str);
    }

    public RFLEntityDaily_Selector timezoneLike(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.timezone, "LIKE", str);
    }

    public RFLEntityDaily_Selector timezoneLt(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.timezone, "<", str);
    }

    public RFLEntityDaily_Selector timezoneNotEq(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.timezone, "<>", str);
    }

    public RFLEntityDaily_Selector timezoneNotGlob(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.timezone, "NOT GLOB", str);
    }

    public RFLEntityDaily_Selector timezoneNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Selector) mo19936in(true, this.f3670a.timezone, collection);
    }

    public final RFLEntityDaily_Selector timezoneNotIn(@NonNull String... strArr) {
        return timezoneNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Selector timezoneNotLike(@NonNull String str) {
        return (RFLEntityDaily_Selector) where(this.f3670a.timezone, "NOT LIKE", str);
    }
}
