package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0865f;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTP_Selector */
public class RFLEntityTP_Selector extends C0865f<RFLEntityTP, RFLEntityTP_Selector> {

    /* renamed from: a */
    final RFLEntityTP_Schema f3702a;

    public RFLEntityTP_Selector(C0855d dVar, RFLEntityTP_Schema rFLEntityTP_Schema) {
        super((C0700h) dVar);
        this.f3702a = rFLEntityTP_Schema;
    }

    public RFLEntityTP_Selector(RFLEntityTP_Relation rFLEntityTP_Relation) {
        super(rFLEntityTP_Relation);
        this.f3702a = rFLEntityTP_Relation.getSchema();
    }

    public RFLEntityTP_Selector(RFLEntityTP_Selector rFLEntityTP_Selector) {
        super(rFLEntityTP_Selector);
        this.f3702a = rFLEntityTP_Selector.getSchema();
    }

    public RFLEntityTP_Selector clone() {
        return new RFLEntityTP_Selector(this);
    }

    public RFLEntityTP_Selector dateEq(@NonNull String str) {
        return (RFLEntityTP_Selector) where(this.f3702a.date, "=", str);
    }

    public RFLEntityTP_Selector dateGe(@NonNull String str) {
        return (RFLEntityTP_Selector) where(this.f3702a.date, ">=", str);
    }

    public RFLEntityTP_Selector dateGlob(@NonNull String str) {
        return (RFLEntityTP_Selector) where(this.f3702a.date, "GLOB", str);
    }

    public RFLEntityTP_Selector dateGt(@NonNull String str) {
        return (RFLEntityTP_Selector) where(this.f3702a.date, ">", str);
    }

    public RFLEntityTP_Selector dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityTP_Selector) mo19936in(false, this.f3702a.date, collection);
    }

    public final RFLEntityTP_Selector dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTP_Selector dateLe(@NonNull String str) {
        return (RFLEntityTP_Selector) where(this.f3702a.date, "<=", str);
    }

    public RFLEntityTP_Selector dateLike(@NonNull String str) {
        return (RFLEntityTP_Selector) where(this.f3702a.date, "LIKE", str);
    }

    public RFLEntityTP_Selector dateLt(@NonNull String str) {
        return (RFLEntityTP_Selector) where(this.f3702a.date, "<", str);
    }

    public RFLEntityTP_Selector dateNotEq(@NonNull String str) {
        return (RFLEntityTP_Selector) where(this.f3702a.date, "<>", str);
    }

    public RFLEntityTP_Selector dateNotGlob(@NonNull String str) {
        return (RFLEntityTP_Selector) where(this.f3702a.date, "NOT GLOB", str);
    }

    public RFLEntityTP_Selector dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityTP_Selector) mo19936in(true, this.f3702a.date, collection);
    }

    public final RFLEntityTP_Selector dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTP_Selector dateNotLike(@NonNull String str) {
        return (RFLEntityTP_Selector) where(this.f3702a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityTP_Schema getSchema() {
        return this.f3702a;
    }

    public RFLEntityTP_Selector orderByDateAsc() {
        return (RFLEntityTP_Selector) orderBy(this.f3702a.date.orderInAscending());
    }

    public RFLEntityTP_Selector orderByDateDesc() {
        return (RFLEntityTP_Selector) orderBy(this.f3702a.date.orderInDescending());
    }
}
