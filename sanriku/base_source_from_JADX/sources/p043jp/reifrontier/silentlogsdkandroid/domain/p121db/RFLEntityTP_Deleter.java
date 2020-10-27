package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0852b;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTP_Deleter */
public class RFLEntityTP_Deleter extends C0852b<RFLEntityTP, RFLEntityTP_Deleter> {

    /* renamed from: a */
    final RFLEntityTP_Schema f3698a;

    public RFLEntityTP_Deleter(C0855d dVar, RFLEntityTP_Schema rFLEntityTP_Schema) {
        super((C0700h) dVar);
        this.f3698a = rFLEntityTP_Schema;
    }

    public RFLEntityTP_Deleter(RFLEntityTP_Deleter rFLEntityTP_Deleter) {
        super(rFLEntityTP_Deleter);
        this.f3698a = rFLEntityTP_Deleter.getSchema();
    }

    public RFLEntityTP_Deleter(RFLEntityTP_Relation rFLEntityTP_Relation) {
        super(rFLEntityTP_Relation);
        this.f3698a = rFLEntityTP_Relation.getSchema();
    }

    public RFLEntityTP_Deleter clone() {
        return new RFLEntityTP_Deleter(this);
    }

    public RFLEntityTP_Deleter dateEq(@NonNull String str) {
        return (RFLEntityTP_Deleter) where(this.f3698a.date, "=", str);
    }

    public RFLEntityTP_Deleter dateGe(@NonNull String str) {
        return (RFLEntityTP_Deleter) where(this.f3698a.date, ">=", str);
    }

    public RFLEntityTP_Deleter dateGlob(@NonNull String str) {
        return (RFLEntityTP_Deleter) where(this.f3698a.date, "GLOB", str);
    }

    public RFLEntityTP_Deleter dateGt(@NonNull String str) {
        return (RFLEntityTP_Deleter) where(this.f3698a.date, ">", str);
    }

    public RFLEntityTP_Deleter dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityTP_Deleter) mo19936in(false, this.f3698a.date, collection);
    }

    public final RFLEntityTP_Deleter dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTP_Deleter dateLe(@NonNull String str) {
        return (RFLEntityTP_Deleter) where(this.f3698a.date, "<=", str);
    }

    public RFLEntityTP_Deleter dateLike(@NonNull String str) {
        return (RFLEntityTP_Deleter) where(this.f3698a.date, "LIKE", str);
    }

    public RFLEntityTP_Deleter dateLt(@NonNull String str) {
        return (RFLEntityTP_Deleter) where(this.f3698a.date, "<", str);
    }

    public RFLEntityTP_Deleter dateNotEq(@NonNull String str) {
        return (RFLEntityTP_Deleter) where(this.f3698a.date, "<>", str);
    }

    public RFLEntityTP_Deleter dateNotGlob(@NonNull String str) {
        return (RFLEntityTP_Deleter) where(this.f3698a.date, "NOT GLOB", str);
    }

    public RFLEntityTP_Deleter dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityTP_Deleter) mo19936in(true, this.f3698a.date, collection);
    }

    public final RFLEntityTP_Deleter dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTP_Deleter dateNotLike(@NonNull String str) {
        return (RFLEntityTP_Deleter) where(this.f3698a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityTP_Schema getSchema() {
        return this.f3698a;
    }
}
