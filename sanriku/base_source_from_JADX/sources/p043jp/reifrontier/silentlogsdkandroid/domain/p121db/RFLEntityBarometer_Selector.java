package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0865f;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer_Selector */
public class RFLEntityBarometer_Selector extends C0865f<RFLEntityBarometer, RFLEntityBarometer_Selector> {

    /* renamed from: a */
    final RFLEntityBarometer_Schema f3649a;

    public RFLEntityBarometer_Selector(C0855d dVar, RFLEntityBarometer_Schema rFLEntityBarometer_Schema) {
        super((C0700h) dVar);
        this.f3649a = rFLEntityBarometer_Schema;
    }

    public RFLEntityBarometer_Selector(RFLEntityBarometer_Relation rFLEntityBarometer_Relation) {
        super(rFLEntityBarometer_Relation);
        this.f3649a = rFLEntityBarometer_Relation.getSchema();
    }

    public RFLEntityBarometer_Selector(RFLEntityBarometer_Selector rFLEntityBarometer_Selector) {
        super(rFLEntityBarometer_Selector);
        this.f3649a = rFLEntityBarometer_Selector.getSchema();
    }

    public RFLEntityBarometer_Selector clone() {
        return new RFLEntityBarometer_Selector(this);
    }

    public RFLEntityBarometer_Selector dateEq(@NonNull String str) {
        return (RFLEntityBarometer_Selector) where(this.f3649a.date, "=", str);
    }

    public RFLEntityBarometer_Selector dateGe(@NonNull String str) {
        return (RFLEntityBarometer_Selector) where(this.f3649a.date, ">=", str);
    }

    public RFLEntityBarometer_Selector dateGlob(@NonNull String str) {
        return (RFLEntityBarometer_Selector) where(this.f3649a.date, "GLOB", str);
    }

    public RFLEntityBarometer_Selector dateGt(@NonNull String str) {
        return (RFLEntityBarometer_Selector) where(this.f3649a.date, ">", str);
    }

    public RFLEntityBarometer_Selector dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityBarometer_Selector) mo19936in(false, this.f3649a.date, collection);
    }

    public final RFLEntityBarometer_Selector dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityBarometer_Selector dateLe(@NonNull String str) {
        return (RFLEntityBarometer_Selector) where(this.f3649a.date, "<=", str);
    }

    public RFLEntityBarometer_Selector dateLike(@NonNull String str) {
        return (RFLEntityBarometer_Selector) where(this.f3649a.date, "LIKE", str);
    }

    public RFLEntityBarometer_Selector dateLt(@NonNull String str) {
        return (RFLEntityBarometer_Selector) where(this.f3649a.date, "<", str);
    }

    public RFLEntityBarometer_Selector dateNotEq(@NonNull String str) {
        return (RFLEntityBarometer_Selector) where(this.f3649a.date, "<>", str);
    }

    public RFLEntityBarometer_Selector dateNotGlob(@NonNull String str) {
        return (RFLEntityBarometer_Selector) where(this.f3649a.date, "NOT GLOB", str);
    }

    public RFLEntityBarometer_Selector dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityBarometer_Selector) mo19936in(true, this.f3649a.date, collection);
    }

    public final RFLEntityBarometer_Selector dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityBarometer_Selector dateNotLike(@NonNull String str) {
        return (RFLEntityBarometer_Selector) where(this.f3649a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityBarometer_Schema getSchema() {
        return this.f3649a;
    }

    public RFLEntityBarometer_Selector orderByDateAsc() {
        return (RFLEntityBarometer_Selector) orderBy(this.f3649a.date.orderInAscending());
    }

    public RFLEntityBarometer_Selector orderByDateDesc() {
        return (RFLEntityBarometer_Selector) orderBy(this.f3649a.date.orderInDescending());
    }
}
