package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0852b;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer_Deleter */
public class RFLEntityBarometer_Deleter extends C0852b<RFLEntityBarometer, RFLEntityBarometer_Deleter> {

    /* renamed from: a */
    final RFLEntityBarometer_Schema f3645a;

    public RFLEntityBarometer_Deleter(C0855d dVar, RFLEntityBarometer_Schema rFLEntityBarometer_Schema) {
        super((C0700h) dVar);
        this.f3645a = rFLEntityBarometer_Schema;
    }

    public RFLEntityBarometer_Deleter(RFLEntityBarometer_Deleter rFLEntityBarometer_Deleter) {
        super(rFLEntityBarometer_Deleter);
        this.f3645a = rFLEntityBarometer_Deleter.getSchema();
    }

    public RFLEntityBarometer_Deleter(RFLEntityBarometer_Relation rFLEntityBarometer_Relation) {
        super(rFLEntityBarometer_Relation);
        this.f3645a = rFLEntityBarometer_Relation.getSchema();
    }

    public RFLEntityBarometer_Deleter clone() {
        return new RFLEntityBarometer_Deleter(this);
    }

    public RFLEntityBarometer_Deleter dateEq(@NonNull String str) {
        return (RFLEntityBarometer_Deleter) where(this.f3645a.date, "=", str);
    }

    public RFLEntityBarometer_Deleter dateGe(@NonNull String str) {
        return (RFLEntityBarometer_Deleter) where(this.f3645a.date, ">=", str);
    }

    public RFLEntityBarometer_Deleter dateGlob(@NonNull String str) {
        return (RFLEntityBarometer_Deleter) where(this.f3645a.date, "GLOB", str);
    }

    public RFLEntityBarometer_Deleter dateGt(@NonNull String str) {
        return (RFLEntityBarometer_Deleter) where(this.f3645a.date, ">", str);
    }

    public RFLEntityBarometer_Deleter dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityBarometer_Deleter) mo19936in(false, this.f3645a.date, collection);
    }

    public final RFLEntityBarometer_Deleter dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityBarometer_Deleter dateLe(@NonNull String str) {
        return (RFLEntityBarometer_Deleter) where(this.f3645a.date, "<=", str);
    }

    public RFLEntityBarometer_Deleter dateLike(@NonNull String str) {
        return (RFLEntityBarometer_Deleter) where(this.f3645a.date, "LIKE", str);
    }

    public RFLEntityBarometer_Deleter dateLt(@NonNull String str) {
        return (RFLEntityBarometer_Deleter) where(this.f3645a.date, "<", str);
    }

    public RFLEntityBarometer_Deleter dateNotEq(@NonNull String str) {
        return (RFLEntityBarometer_Deleter) where(this.f3645a.date, "<>", str);
    }

    public RFLEntityBarometer_Deleter dateNotGlob(@NonNull String str) {
        return (RFLEntityBarometer_Deleter) where(this.f3645a.date, "NOT GLOB", str);
    }

    public RFLEntityBarometer_Deleter dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityBarometer_Deleter) mo19936in(true, this.f3645a.date, collection);
    }

    public final RFLEntityBarometer_Deleter dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityBarometer_Deleter dateNotLike(@NonNull String str) {
        return (RFLEntityBarometer_Deleter) where(this.f3645a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityBarometer_Schema getSchema() {
        return this.f3645a;
    }
}
