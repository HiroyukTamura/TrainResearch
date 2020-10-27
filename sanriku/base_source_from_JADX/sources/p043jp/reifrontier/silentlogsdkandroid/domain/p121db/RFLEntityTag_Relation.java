package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0856e;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag_Relation */
public class RFLEntityTag_Relation extends C0856e<RFLEntityTag, RFLEntityTag_Relation> {

    /* renamed from: a */
    final RFLEntityTag_Schema f3710a;

    public RFLEntityTag_Relation(C0855d dVar, RFLEntityTag_Schema rFLEntityTag_Schema) {
        super(dVar);
        this.f3710a = rFLEntityTag_Schema;
    }

    public RFLEntityTag_Relation(RFLEntityTag_Relation rFLEntityTag_Relation) {
        super(rFLEntityTag_Relation);
        this.f3710a = rFLEntityTag_Relation.getSchema();
    }

    public RFLEntityTag_Relation clone() {
        return new RFLEntityTag_Relation(this);
    }

    @NonNull
    public RFLEntityTag_Deleter deleter() {
        return new RFLEntityTag_Deleter(this);
    }

    public RFLEntityTag_Relation fromDateBetween(int i, int i2) {
        return (RFLEntityTag_Relation) whereBetween(this.f3710a.fromDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityTag_Relation fromDateEq(int i) {
        return (RFLEntityTag_Relation) where(this.f3710a.fromDate, "=", Integer.valueOf(i));
    }

    public RFLEntityTag_Relation fromDateGe(int i) {
        return (RFLEntityTag_Relation) where(this.f3710a.fromDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityTag_Relation fromDateGt(int i) {
        return (RFLEntityTag_Relation) where(this.f3710a.fromDate, ">", Integer.valueOf(i));
    }

    public RFLEntityTag_Relation fromDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Relation) mo19936in(false, this.f3710a.fromDate, collection);
    }

    public final RFLEntityTag_Relation fromDateIn(@NonNull Integer... numArr) {
        return fromDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityTag_Relation fromDateLe(int i) {
        return (RFLEntityTag_Relation) where(this.f3710a.fromDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityTag_Relation fromDateLt(int i) {
        return (RFLEntityTag_Relation) where(this.f3710a.fromDate, "<", Integer.valueOf(i));
    }

    public RFLEntityTag_Relation fromDateNotEq(int i) {
        return (RFLEntityTag_Relation) where(this.f3710a.fromDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityTag_Relation fromDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Relation) mo19936in(true, this.f3710a.fromDate, collection);
    }

    public final RFLEntityTag_Relation fromDateNotIn(@NonNull Integer... numArr) {
        return fromDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityTag_Schema getSchema() {
        return this.f3710a;
    }

    public RFLEntityTag_Relation orderByFromDateAsc() {
        return (RFLEntityTag_Relation) orderBy(this.f3710a.fromDate.orderInAscending());
    }

    public RFLEntityTag_Relation orderByFromDateDesc() {
        return (RFLEntityTag_Relation) orderBy(this.f3710a.fromDate.orderInDescending());
    }

    public RFLEntityTag_Relation orderByToDateAsc() {
        return (RFLEntityTag_Relation) orderBy(this.f3710a.toDate.orderInAscending());
    }

    public RFLEntityTag_Relation orderByToDateDesc() {
        return (RFLEntityTag_Relation) orderBy(this.f3710a.toDate.orderInDescending());
    }

    @NonNull
    public RFLEntityTag_Selector selector() {
        return new RFLEntityTag_Selector(this);
    }

    public RFLEntityTag_Relation toDateBetween(int i, int i2) {
        return (RFLEntityTag_Relation) whereBetween(this.f3710a.toDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityTag_Relation toDateEq(int i) {
        return (RFLEntityTag_Relation) where(this.f3710a.toDate, "=", Integer.valueOf(i));
    }

    public RFLEntityTag_Relation toDateGe(int i) {
        return (RFLEntityTag_Relation) where(this.f3710a.toDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityTag_Relation toDateGt(int i) {
        return (RFLEntityTag_Relation) where(this.f3710a.toDate, ">", Integer.valueOf(i));
    }

    public RFLEntityTag_Relation toDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Relation) mo19936in(false, this.f3710a.toDate, collection);
    }

    public final RFLEntityTag_Relation toDateIn(@NonNull Integer... numArr) {
        return toDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityTag_Relation toDateLe(int i) {
        return (RFLEntityTag_Relation) where(this.f3710a.toDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityTag_Relation toDateLt(int i) {
        return (RFLEntityTag_Relation) where(this.f3710a.toDate, "<", Integer.valueOf(i));
    }

    public RFLEntityTag_Relation toDateNotEq(int i) {
        return (RFLEntityTag_Relation) where(this.f3710a.toDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityTag_Relation toDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Relation) mo19936in(true, this.f3710a.toDate, collection);
    }

    public final RFLEntityTag_Relation toDateNotIn(@NonNull Integer... numArr) {
        return toDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityTag_Updater updater() {
        return new RFLEntityTag_Updater(this);
    }

    @NonNull
    public RFLEntityTag upsertWithoutTransaction(@NonNull RFLEntityTag rFLEntityTag) {
        throw new UnsupportedOperationException("upsert is not supported because of missing @PrimaryKey");
    }
}
