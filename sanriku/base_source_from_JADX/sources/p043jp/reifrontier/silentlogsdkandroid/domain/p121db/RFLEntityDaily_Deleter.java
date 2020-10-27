package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0852b;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily_Deleter */
public class RFLEntityDaily_Deleter extends C0852b<RFLEntityDaily, RFLEntityDaily_Deleter> {

    /* renamed from: a */
    final RFLEntityDaily_Schema f3666a;

    public RFLEntityDaily_Deleter(C0855d dVar, RFLEntityDaily_Schema rFLEntityDaily_Schema) {
        super((C0700h) dVar);
        this.f3666a = rFLEntityDaily_Schema;
    }

    public RFLEntityDaily_Deleter(RFLEntityDaily_Deleter rFLEntityDaily_Deleter) {
        super(rFLEntityDaily_Deleter);
        this.f3666a = rFLEntityDaily_Deleter.getSchema();
    }

    public RFLEntityDaily_Deleter(RFLEntityDaily_Relation rFLEntityDaily_Relation) {
        super(rFLEntityDaily_Relation);
        this.f3666a = rFLEntityDaily_Relation.getSchema();
    }

    public RFLEntityDaily_Deleter clone() {
        return new RFLEntityDaily_Deleter(this);
    }

    public RFLEntityDaily_Deleter dateEq(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.date, "=", str);
    }

    public RFLEntityDaily_Deleter dateGe(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.date, ">=", str);
    }

    public RFLEntityDaily_Deleter dateGlob(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.date, "GLOB", str);
    }

    public RFLEntityDaily_Deleter dateGt(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.date, ">", str);
    }

    public RFLEntityDaily_Deleter dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Deleter) mo19936in(false, this.f3666a.date, collection);
    }

    public final RFLEntityDaily_Deleter dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Deleter dateLe(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.date, "<=", str);
    }

    public RFLEntityDaily_Deleter dateLike(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.date, "LIKE", str);
    }

    public RFLEntityDaily_Deleter dateLt(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.date, "<", str);
    }

    public RFLEntityDaily_Deleter dateNotEq(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.date, "<>", str);
    }

    public RFLEntityDaily_Deleter dateNotGlob(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.date, "NOT GLOB", str);
    }

    public RFLEntityDaily_Deleter dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Deleter) mo19936in(true, this.f3666a.date, collection);
    }

    public final RFLEntityDaily_Deleter dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Deleter dateNotLike(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityDaily_Schema getSchema() {
        return this.f3666a;
    }

    public RFLEntityDaily_Deleter timezoneEq(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.timezone, "=", str);
    }

    public RFLEntityDaily_Deleter timezoneGe(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.timezone, ">=", str);
    }

    public RFLEntityDaily_Deleter timezoneGlob(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.timezone, "GLOB", str);
    }

    public RFLEntityDaily_Deleter timezoneGt(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.timezone, ">", str);
    }

    public RFLEntityDaily_Deleter timezoneIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Deleter) mo19936in(false, this.f3666a.timezone, collection);
    }

    public final RFLEntityDaily_Deleter timezoneIn(@NonNull String... strArr) {
        return timezoneIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Deleter timezoneLe(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.timezone, "<=", str);
    }

    public RFLEntityDaily_Deleter timezoneLike(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.timezone, "LIKE", str);
    }

    public RFLEntityDaily_Deleter timezoneLt(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.timezone, "<", str);
    }

    public RFLEntityDaily_Deleter timezoneNotEq(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.timezone, "<>", str);
    }

    public RFLEntityDaily_Deleter timezoneNotGlob(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.timezone, "NOT GLOB", str);
    }

    public RFLEntityDaily_Deleter timezoneNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Deleter) mo19936in(true, this.f3666a.timezone, collection);
    }

    public final RFLEntityDaily_Deleter timezoneNotIn(@NonNull String... strArr) {
        return timezoneNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Deleter timezoneNotLike(@NonNull String str) {
        return (RFLEntityDaily_Deleter) where(this.f3666a.timezone, "NOT LIKE", str);
    }
}
