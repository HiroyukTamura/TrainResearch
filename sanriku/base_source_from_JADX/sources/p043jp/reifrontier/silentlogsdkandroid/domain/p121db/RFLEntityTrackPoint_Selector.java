package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0865f;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTrackPoint_Selector */
public class RFLEntityTrackPoint_Selector extends C0865f<RFLEntityTrackPoint, RFLEntityTrackPoint_Selector> {

    /* renamed from: a */
    final RFLEntityTrackPoint_Schema f3724a;

    public RFLEntityTrackPoint_Selector(C0855d dVar, RFLEntityTrackPoint_Schema rFLEntityTrackPoint_Schema) {
        super((C0700h) dVar);
        this.f3724a = rFLEntityTrackPoint_Schema;
    }

    public RFLEntityTrackPoint_Selector(RFLEntityTrackPoint_Relation rFLEntityTrackPoint_Relation) {
        super(rFLEntityTrackPoint_Relation);
        this.f3724a = rFLEntityTrackPoint_Relation.getSchema();
    }

    public RFLEntityTrackPoint_Selector(RFLEntityTrackPoint_Selector rFLEntityTrackPoint_Selector) {
        super(rFLEntityTrackPoint_Selector);
        this.f3724a = rFLEntityTrackPoint_Selector.getSchema();
    }

    public RFLEntityTrackPoint_Selector clone() {
        return new RFLEntityTrackPoint_Selector(this);
    }

    public RFLEntityTrackPoint_Selector dateEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.date, "=", str);
    }

    public RFLEntityTrackPoint_Selector dateGe(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.date, ">=", str);
    }

    public RFLEntityTrackPoint_Selector dateGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.date, "GLOB", str);
    }

    public RFLEntityTrackPoint_Selector dateGt(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.date, ">", str);
    }

    public RFLEntityTrackPoint_Selector dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Selector) mo19936in(false, this.f3724a.date, collection);
    }

    public final RFLEntityTrackPoint_Selector dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Selector dateLe(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.date, "<=", str);
    }

    public RFLEntityTrackPoint_Selector dateLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.date, "LIKE", str);
    }

    public RFLEntityTrackPoint_Selector dateLt(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.date, "<", str);
    }

    public RFLEntityTrackPoint_Selector dateNotEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.date, "<>", str);
    }

    public RFLEntityTrackPoint_Selector dateNotGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.date, "NOT GLOB", str);
    }

    public RFLEntityTrackPoint_Selector dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Selector) mo19936in(true, this.f3724a.date, collection);
    }

    public final RFLEntityTrackPoint_Selector dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Selector dateNotLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityTrackPoint_Schema getSchema() {
        return this.f3724a;
    }

    public RFLEntityTrackPoint_Selector orderByDateAsc() {
        return (RFLEntityTrackPoint_Selector) orderBy(this.f3724a.date.orderInAscending());
    }

    public RFLEntityTrackPoint_Selector orderByDateDesc() {
        return (RFLEntityTrackPoint_Selector) orderBy(this.f3724a.date.orderInDescending());
    }

    public RFLEntityTrackPoint_Selector orderByTimezoneAsc() {
        return (RFLEntityTrackPoint_Selector) orderBy(this.f3724a.timezone.orderInAscending());
    }

    public RFLEntityTrackPoint_Selector orderByTimezoneDesc() {
        return (RFLEntityTrackPoint_Selector) orderBy(this.f3724a.timezone.orderInDescending());
    }

    public RFLEntityTrackPoint_Selector timezoneEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.timezone, "=", str);
    }

    public RFLEntityTrackPoint_Selector timezoneGe(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.timezone, ">=", str);
    }

    public RFLEntityTrackPoint_Selector timezoneGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.timezone, "GLOB", str);
    }

    public RFLEntityTrackPoint_Selector timezoneGt(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.timezone, ">", str);
    }

    public RFLEntityTrackPoint_Selector timezoneIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Selector) mo19936in(false, this.f3724a.timezone, collection);
    }

    public final RFLEntityTrackPoint_Selector timezoneIn(@NonNull String... strArr) {
        return timezoneIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Selector timezoneLe(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.timezone, "<=", str);
    }

    public RFLEntityTrackPoint_Selector timezoneLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.timezone, "LIKE", str);
    }

    public RFLEntityTrackPoint_Selector timezoneLt(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.timezone, "<", str);
    }

    public RFLEntityTrackPoint_Selector timezoneNotEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.timezone, "<>", str);
    }

    public RFLEntityTrackPoint_Selector timezoneNotGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.timezone, "NOT GLOB", str);
    }

    public RFLEntityTrackPoint_Selector timezoneNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Selector) mo19936in(true, this.f3724a.timezone, collection);
    }

    public final RFLEntityTrackPoint_Selector timezoneNotIn(@NonNull String... strArr) {
        return timezoneNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Selector timezoneNotLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Selector) where(this.f3724a.timezone, "NOT LIKE", str);
    }
}
