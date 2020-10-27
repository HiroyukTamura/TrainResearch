package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0852b;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity_Deleter */
public class RFLEntityActivity_Deleter extends C0852b<RFLEntityActivity, RFLEntityActivity_Deleter> {

    /* renamed from: a */
    final RFLEntityActivity_Schema f3625a;

    public RFLEntityActivity_Deleter(C0855d dVar, RFLEntityActivity_Schema rFLEntityActivity_Schema) {
        super((C0700h) dVar);
        this.f3625a = rFLEntityActivity_Schema;
    }

    public RFLEntityActivity_Deleter(RFLEntityActivity_Deleter rFLEntityActivity_Deleter) {
        super(rFLEntityActivity_Deleter);
        this.f3625a = rFLEntityActivity_Deleter.getSchema();
    }

    public RFLEntityActivity_Deleter(RFLEntityActivity_Relation rFLEntityActivity_Relation) {
        super(rFLEntityActivity_Relation);
        this.f3625a = rFLEntityActivity_Relation.getSchema();
    }

    public RFLEntityActivity_Deleter clone() {
        return new RFLEntityActivity_Deleter(this);
    }

    public RFLEntityActivity_Deleter dateEq(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.date, "=", str);
    }

    public RFLEntityActivity_Deleter dateGe(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.date, ">=", str);
    }

    public RFLEntityActivity_Deleter dateGlob(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.date, "GLOB", str);
    }

    public RFLEntityActivity_Deleter dateGt(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.date, ">", str);
    }

    public RFLEntityActivity_Deleter dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Deleter) mo19936in(false, this.f3625a.date, collection);
    }

    public final RFLEntityActivity_Deleter dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Deleter dateLe(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.date, "<=", str);
    }

    public RFLEntityActivity_Deleter dateLike(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.date, "LIKE", str);
    }

    public RFLEntityActivity_Deleter dateLt(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.date, "<", str);
    }

    public RFLEntityActivity_Deleter dateNotEq(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.date, "<>", str);
    }

    public RFLEntityActivity_Deleter dateNotGlob(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.date, "NOT GLOB", str);
    }

    public RFLEntityActivity_Deleter dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Deleter) mo19936in(true, this.f3625a.date, collection);
    }

    public final RFLEntityActivity_Deleter dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Deleter dateNotLike(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityActivity_Schema getSchema() {
        return this.f3625a;
    }

    public RFLEntityActivity_Deleter timezoneEq(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.timezone, "=", str);
    }

    public RFLEntityActivity_Deleter timezoneGe(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.timezone, ">=", str);
    }

    public RFLEntityActivity_Deleter timezoneGlob(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.timezone, "GLOB", str);
    }

    public RFLEntityActivity_Deleter timezoneGt(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.timezone, ">", str);
    }

    public RFLEntityActivity_Deleter timezoneIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Deleter) mo19936in(false, this.f3625a.timezone, collection);
    }

    public final RFLEntityActivity_Deleter timezoneIn(@NonNull String... strArr) {
        return timezoneIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Deleter timezoneLe(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.timezone, "<=", str);
    }

    public RFLEntityActivity_Deleter timezoneLike(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.timezone, "LIKE", str);
    }

    public RFLEntityActivity_Deleter timezoneLt(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.timezone, "<", str);
    }

    public RFLEntityActivity_Deleter timezoneNotEq(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.timezone, "<>", str);
    }

    public RFLEntityActivity_Deleter timezoneNotGlob(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.timezone, "NOT GLOB", str);
    }

    public RFLEntityActivity_Deleter timezoneNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Deleter) mo19936in(true, this.f3625a.timezone, collection);
    }

    public final RFLEntityActivity_Deleter timezoneNotIn(@NonNull String... strArr) {
        return timezoneNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Deleter timezoneNotLike(@NonNull String str) {
        return (RFLEntityActivity_Deleter) where(this.f3625a.timezone, "NOT LIKE", str);
    }
}
