package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0856e;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTP_Relation */
public class RFLEntityTP_Relation extends C0856e<RFLEntityTP, RFLEntityTP_Relation> {

    /* renamed from: a */
    final RFLEntityTP_Schema f3699a;

    public RFLEntityTP_Relation(C0855d dVar, RFLEntityTP_Schema rFLEntityTP_Schema) {
        super(dVar);
        this.f3699a = rFLEntityTP_Schema;
    }

    public RFLEntityTP_Relation(RFLEntityTP_Relation rFLEntityTP_Relation) {
        super(rFLEntityTP_Relation);
        this.f3699a = rFLEntityTP_Relation.getSchema();
    }

    public RFLEntityTP_Relation clone() {
        return new RFLEntityTP_Relation(this);
    }

    public RFLEntityTP_Relation dateEq(@NonNull String str) {
        return (RFLEntityTP_Relation) where(this.f3699a.date, "=", str);
    }

    public RFLEntityTP_Relation dateGe(@NonNull String str) {
        return (RFLEntityTP_Relation) where(this.f3699a.date, ">=", str);
    }

    public RFLEntityTP_Relation dateGlob(@NonNull String str) {
        return (RFLEntityTP_Relation) where(this.f3699a.date, "GLOB", str);
    }

    public RFLEntityTP_Relation dateGt(@NonNull String str) {
        return (RFLEntityTP_Relation) where(this.f3699a.date, ">", str);
    }

    public RFLEntityTP_Relation dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityTP_Relation) mo19936in(false, this.f3699a.date, collection);
    }

    public final RFLEntityTP_Relation dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTP_Relation dateLe(@NonNull String str) {
        return (RFLEntityTP_Relation) where(this.f3699a.date, "<=", str);
    }

    public RFLEntityTP_Relation dateLike(@NonNull String str) {
        return (RFLEntityTP_Relation) where(this.f3699a.date, "LIKE", str);
    }

    public RFLEntityTP_Relation dateLt(@NonNull String str) {
        return (RFLEntityTP_Relation) where(this.f3699a.date, "<", str);
    }

    public RFLEntityTP_Relation dateNotEq(@NonNull String str) {
        return (RFLEntityTP_Relation) where(this.f3699a.date, "<>", str);
    }

    public RFLEntityTP_Relation dateNotGlob(@NonNull String str) {
        return (RFLEntityTP_Relation) where(this.f3699a.date, "NOT GLOB", str);
    }

    public RFLEntityTP_Relation dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityTP_Relation) mo19936in(true, this.f3699a.date, collection);
    }

    public final RFLEntityTP_Relation dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTP_Relation dateNotLike(@NonNull String str) {
        return (RFLEntityTP_Relation) where(this.f3699a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityTP_Deleter deleter() {
        return new RFLEntityTP_Deleter(this);
    }

    @NonNull
    public RFLEntityTP_Schema getSchema() {
        return this.f3699a;
    }

    public RFLEntityTP_Relation orderByDateAsc() {
        return (RFLEntityTP_Relation) orderBy(this.f3699a.date.orderInAscending());
    }

    public RFLEntityTP_Relation orderByDateDesc() {
        return (RFLEntityTP_Relation) orderBy(this.f3699a.date.orderInDescending());
    }

    @NonNull
    public RFLEntityTP_Selector selector() {
        return new RFLEntityTP_Selector(this);
    }

    @NonNull
    public RFLEntityTP_Updater updater() {
        return new RFLEntityTP_Updater(this);
    }

    @NonNull
    public RFLEntityTP upsertWithoutTransaction(@NonNull RFLEntityTP rFLEntityTP) {
        throw new UnsupportedOperationException("upsert is not supported because of missing @PrimaryKey");
    }
}
