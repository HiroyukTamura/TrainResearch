package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0856e;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint_Relation */
public class RFLEntityAdjustTrackPoint_Relation extends C0856e<RFLEntityAdjustTrackPoint, RFLEntityAdjustTrackPoint_Relation> {

    /* renamed from: a */
    final RFLEntityAdjustTrackPoint_Schema f3636a;

    public RFLEntityAdjustTrackPoint_Relation(C0855d dVar, RFLEntityAdjustTrackPoint_Schema rFLEntityAdjustTrackPoint_Schema) {
        super(dVar);
        this.f3636a = rFLEntityAdjustTrackPoint_Schema;
    }

    public RFLEntityAdjustTrackPoint_Relation(RFLEntityAdjustTrackPoint_Relation rFLEntityAdjustTrackPoint_Relation) {
        super(rFLEntityAdjustTrackPoint_Relation);
        this.f3636a = rFLEntityAdjustTrackPoint_Relation.getSchema();
    }

    public RFLEntityAdjustTrackPoint_Relation clone() {
        return new RFLEntityAdjustTrackPoint_Relation(this);
    }

    @NonNull
    public RFLEntityAdjustTrackPoint_Deleter deleter() {
        return new RFLEntityAdjustTrackPoint_Deleter(this);
    }

    public RFLEntityAdjustTrackPoint_Relation fromDateBetween(int i, int i2) {
        return (RFLEntityAdjustTrackPoint_Relation) whereBetween(this.f3636a.fromDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityAdjustTrackPoint_Relation fromDateEq(int i) {
        return (RFLEntityAdjustTrackPoint_Relation) where(this.f3636a.fromDate, "=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Relation fromDateGe(int i) {
        return (RFLEntityAdjustTrackPoint_Relation) where(this.f3636a.fromDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Relation fromDateGt(int i) {
        return (RFLEntityAdjustTrackPoint_Relation) where(this.f3636a.fromDate, ">", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Relation fromDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Relation) mo19936in(false, this.f3636a.fromDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Relation fromDateIn(@NonNull Integer... numArr) {
        return fromDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityAdjustTrackPoint_Relation fromDateLe(int i) {
        return (RFLEntityAdjustTrackPoint_Relation) where(this.f3636a.fromDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Relation fromDateLt(int i) {
        return (RFLEntityAdjustTrackPoint_Relation) where(this.f3636a.fromDate, "<", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Relation fromDateNotEq(int i) {
        return (RFLEntityAdjustTrackPoint_Relation) where(this.f3636a.fromDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Relation fromDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Relation) mo19936in(true, this.f3636a.fromDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Relation fromDateNotIn(@NonNull Integer... numArr) {
        return fromDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityAdjustTrackPoint_Schema getSchema() {
        return this.f3636a;
    }

    public RFLEntityAdjustTrackPoint_Relation orderByFromDateAsc() {
        return (RFLEntityAdjustTrackPoint_Relation) orderBy(this.f3636a.fromDate.orderInAscending());
    }

    public RFLEntityAdjustTrackPoint_Relation orderByFromDateDesc() {
        return (RFLEntityAdjustTrackPoint_Relation) orderBy(this.f3636a.fromDate.orderInDescending());
    }

    public RFLEntityAdjustTrackPoint_Relation orderByToDateAsc() {
        return (RFLEntityAdjustTrackPoint_Relation) orderBy(this.f3636a.toDate.orderInAscending());
    }

    public RFLEntityAdjustTrackPoint_Relation orderByToDateDesc() {
        return (RFLEntityAdjustTrackPoint_Relation) orderBy(this.f3636a.toDate.orderInDescending());
    }

    @NonNull
    public RFLEntityAdjustTrackPoint_Selector selector() {
        return new RFLEntityAdjustTrackPoint_Selector(this);
    }

    public RFLEntityAdjustTrackPoint_Relation toDateBetween(int i, int i2) {
        return (RFLEntityAdjustTrackPoint_Relation) whereBetween(this.f3636a.toDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityAdjustTrackPoint_Relation toDateEq(int i) {
        return (RFLEntityAdjustTrackPoint_Relation) where(this.f3636a.toDate, "=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Relation toDateGe(int i) {
        return (RFLEntityAdjustTrackPoint_Relation) where(this.f3636a.toDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Relation toDateGt(int i) {
        return (RFLEntityAdjustTrackPoint_Relation) where(this.f3636a.toDate, ">", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Relation toDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Relation) mo19936in(false, this.f3636a.toDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Relation toDateIn(@NonNull Integer... numArr) {
        return toDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityAdjustTrackPoint_Relation toDateLe(int i) {
        return (RFLEntityAdjustTrackPoint_Relation) where(this.f3636a.toDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Relation toDateLt(int i) {
        return (RFLEntityAdjustTrackPoint_Relation) where(this.f3636a.toDate, "<", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Relation toDateNotEq(int i) {
        return (RFLEntityAdjustTrackPoint_Relation) where(this.f3636a.toDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Relation toDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Relation) mo19936in(true, this.f3636a.toDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Relation toDateNotIn(@NonNull Integer... numArr) {
        return toDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityAdjustTrackPoint_Updater updater() {
        return new RFLEntityAdjustTrackPoint_Updater(this);
    }

    @NonNull
    public RFLEntityAdjustTrackPoint upsertWithoutTransaction(@NonNull RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint) {
        throw new UnsupportedOperationException("upsert is not supported because of missing @PrimaryKey");
    }
}
