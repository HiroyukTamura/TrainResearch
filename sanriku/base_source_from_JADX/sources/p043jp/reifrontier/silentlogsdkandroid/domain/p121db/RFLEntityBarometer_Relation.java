package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0856e;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer_Relation */
public class RFLEntityBarometer_Relation extends C0856e<RFLEntityBarometer, RFLEntityBarometer_Relation> {

    /* renamed from: a */
    final RFLEntityBarometer_Schema f3646a;

    public RFLEntityBarometer_Relation(C0855d dVar, RFLEntityBarometer_Schema rFLEntityBarometer_Schema) {
        super(dVar);
        this.f3646a = rFLEntityBarometer_Schema;
    }

    public RFLEntityBarometer_Relation(RFLEntityBarometer_Relation rFLEntityBarometer_Relation) {
        super(rFLEntityBarometer_Relation);
        this.f3646a = rFLEntityBarometer_Relation.getSchema();
    }

    public RFLEntityBarometer_Relation clone() {
        return new RFLEntityBarometer_Relation(this);
    }

    public RFLEntityBarometer_Relation dateEq(@NonNull String str) {
        return (RFLEntityBarometer_Relation) where(this.f3646a.date, "=", str);
    }

    public RFLEntityBarometer_Relation dateGe(@NonNull String str) {
        return (RFLEntityBarometer_Relation) where(this.f3646a.date, ">=", str);
    }

    public RFLEntityBarometer_Relation dateGlob(@NonNull String str) {
        return (RFLEntityBarometer_Relation) where(this.f3646a.date, "GLOB", str);
    }

    public RFLEntityBarometer_Relation dateGt(@NonNull String str) {
        return (RFLEntityBarometer_Relation) where(this.f3646a.date, ">", str);
    }

    public RFLEntityBarometer_Relation dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityBarometer_Relation) mo19936in(false, this.f3646a.date, collection);
    }

    public final RFLEntityBarometer_Relation dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityBarometer_Relation dateLe(@NonNull String str) {
        return (RFLEntityBarometer_Relation) where(this.f3646a.date, "<=", str);
    }

    public RFLEntityBarometer_Relation dateLike(@NonNull String str) {
        return (RFLEntityBarometer_Relation) where(this.f3646a.date, "LIKE", str);
    }

    public RFLEntityBarometer_Relation dateLt(@NonNull String str) {
        return (RFLEntityBarometer_Relation) where(this.f3646a.date, "<", str);
    }

    public RFLEntityBarometer_Relation dateNotEq(@NonNull String str) {
        return (RFLEntityBarometer_Relation) where(this.f3646a.date, "<>", str);
    }

    public RFLEntityBarometer_Relation dateNotGlob(@NonNull String str) {
        return (RFLEntityBarometer_Relation) where(this.f3646a.date, "NOT GLOB", str);
    }

    public RFLEntityBarometer_Relation dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityBarometer_Relation) mo19936in(true, this.f3646a.date, collection);
    }

    public final RFLEntityBarometer_Relation dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityBarometer_Relation dateNotLike(@NonNull String str) {
        return (RFLEntityBarometer_Relation) where(this.f3646a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityBarometer_Deleter deleter() {
        return new RFLEntityBarometer_Deleter(this);
    }

    @NonNull
    public RFLEntityBarometer_Schema getSchema() {
        return this.f3646a;
    }

    public RFLEntityBarometer_Relation orderByDateAsc() {
        return (RFLEntityBarometer_Relation) orderBy(this.f3646a.date.orderInAscending());
    }

    public RFLEntityBarometer_Relation orderByDateDesc() {
        return (RFLEntityBarometer_Relation) orderBy(this.f3646a.date.orderInDescending());
    }

    @NonNull
    public RFLEntityBarometer_Selector selector() {
        return new RFLEntityBarometer_Selector(this);
    }

    @NonNull
    public RFLEntityBarometer_Updater updater() {
        return new RFLEntityBarometer_Updater(this);
    }

    @NonNull
    public RFLEntityBarometer upsertWithoutTransaction(@NonNull RFLEntityBarometer rFLEntityBarometer) {
        throw new UnsupportedOperationException("upsert is not supported because of missing @PrimaryKey");
    }
}
