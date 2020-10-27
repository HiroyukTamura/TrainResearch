package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0852b;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTrackPoint_Deleter */
public class RFLEntityTrackPoint_Deleter extends C0852b<RFLEntityTrackPoint, RFLEntityTrackPoint_Deleter> {

    /* renamed from: a */
    final RFLEntityTrackPoint_Schema f3720a;

    public RFLEntityTrackPoint_Deleter(C0855d dVar, RFLEntityTrackPoint_Schema rFLEntityTrackPoint_Schema) {
        super((C0700h) dVar);
        this.f3720a = rFLEntityTrackPoint_Schema;
    }

    public RFLEntityTrackPoint_Deleter(RFLEntityTrackPoint_Deleter rFLEntityTrackPoint_Deleter) {
        super(rFLEntityTrackPoint_Deleter);
        this.f3720a = rFLEntityTrackPoint_Deleter.getSchema();
    }

    public RFLEntityTrackPoint_Deleter(RFLEntityTrackPoint_Relation rFLEntityTrackPoint_Relation) {
        super(rFLEntityTrackPoint_Relation);
        this.f3720a = rFLEntityTrackPoint_Relation.getSchema();
    }

    public RFLEntityTrackPoint_Deleter clone() {
        return new RFLEntityTrackPoint_Deleter(this);
    }

    public RFLEntityTrackPoint_Deleter dateEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.date, "=", str);
    }

    public RFLEntityTrackPoint_Deleter dateGe(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.date, ">=", str);
    }

    public RFLEntityTrackPoint_Deleter dateGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.date, "GLOB", str);
    }

    public RFLEntityTrackPoint_Deleter dateGt(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.date, ">", str);
    }

    public RFLEntityTrackPoint_Deleter dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Deleter) mo19936in(false, this.f3720a.date, collection);
    }

    public final RFLEntityTrackPoint_Deleter dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Deleter dateLe(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.date, "<=", str);
    }

    public RFLEntityTrackPoint_Deleter dateLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.date, "LIKE", str);
    }

    public RFLEntityTrackPoint_Deleter dateLt(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.date, "<", str);
    }

    public RFLEntityTrackPoint_Deleter dateNotEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.date, "<>", str);
    }

    public RFLEntityTrackPoint_Deleter dateNotGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.date, "NOT GLOB", str);
    }

    public RFLEntityTrackPoint_Deleter dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Deleter) mo19936in(true, this.f3720a.date, collection);
    }

    public final RFLEntityTrackPoint_Deleter dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Deleter dateNotLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityTrackPoint_Schema getSchema() {
        return this.f3720a;
    }

    public RFLEntityTrackPoint_Deleter timezoneEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.timezone, "=", str);
    }

    public RFLEntityTrackPoint_Deleter timezoneGe(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.timezone, ">=", str);
    }

    public RFLEntityTrackPoint_Deleter timezoneGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.timezone, "GLOB", str);
    }

    public RFLEntityTrackPoint_Deleter timezoneGt(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.timezone, ">", str);
    }

    public RFLEntityTrackPoint_Deleter timezoneIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Deleter) mo19936in(false, this.f3720a.timezone, collection);
    }

    public final RFLEntityTrackPoint_Deleter timezoneIn(@NonNull String... strArr) {
        return timezoneIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Deleter timezoneLe(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.timezone, "<=", str);
    }

    public RFLEntityTrackPoint_Deleter timezoneLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.timezone, "LIKE", str);
    }

    public RFLEntityTrackPoint_Deleter timezoneLt(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.timezone, "<", str);
    }

    public RFLEntityTrackPoint_Deleter timezoneNotEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.timezone, "<>", str);
    }

    public RFLEntityTrackPoint_Deleter timezoneNotGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.timezone, "NOT GLOB", str);
    }

    public RFLEntityTrackPoint_Deleter timezoneNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Deleter) mo19936in(true, this.f3720a.timezone, collection);
    }

    public final RFLEntityTrackPoint_Deleter timezoneNotIn(@NonNull String... strArr) {
        return timezoneNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Deleter timezoneNotLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Deleter) where(this.f3720a.timezone, "NOT LIKE", str);
    }
}
