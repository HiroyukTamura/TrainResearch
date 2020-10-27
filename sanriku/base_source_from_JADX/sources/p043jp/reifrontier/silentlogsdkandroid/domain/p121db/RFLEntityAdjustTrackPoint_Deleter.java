package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0852b;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint_Deleter */
public class RFLEntityAdjustTrackPoint_Deleter extends C0852b<RFLEntityAdjustTrackPoint, RFLEntityAdjustTrackPoint_Deleter> {

    /* renamed from: a */
    final RFLEntityAdjustTrackPoint_Schema f3635a;

    public RFLEntityAdjustTrackPoint_Deleter(C0855d dVar, RFLEntityAdjustTrackPoint_Schema rFLEntityAdjustTrackPoint_Schema) {
        super((C0700h) dVar);
        this.f3635a = rFLEntityAdjustTrackPoint_Schema;
    }

    public RFLEntityAdjustTrackPoint_Deleter(RFLEntityAdjustTrackPoint_Deleter rFLEntityAdjustTrackPoint_Deleter) {
        super(rFLEntityAdjustTrackPoint_Deleter);
        this.f3635a = rFLEntityAdjustTrackPoint_Deleter.getSchema();
    }

    public RFLEntityAdjustTrackPoint_Deleter(RFLEntityAdjustTrackPoint_Relation rFLEntityAdjustTrackPoint_Relation) {
        super(rFLEntityAdjustTrackPoint_Relation);
        this.f3635a = rFLEntityAdjustTrackPoint_Relation.getSchema();
    }

    public RFLEntityAdjustTrackPoint_Deleter clone() {
        return new RFLEntityAdjustTrackPoint_Deleter(this);
    }

    public RFLEntityAdjustTrackPoint_Deleter fromDateBetween(int i, int i2) {
        return (RFLEntityAdjustTrackPoint_Deleter) whereBetween(this.f3635a.fromDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityAdjustTrackPoint_Deleter fromDateEq(int i) {
        return (RFLEntityAdjustTrackPoint_Deleter) where(this.f3635a.fromDate, "=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Deleter fromDateGe(int i) {
        return (RFLEntityAdjustTrackPoint_Deleter) where(this.f3635a.fromDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Deleter fromDateGt(int i) {
        return (RFLEntityAdjustTrackPoint_Deleter) where(this.f3635a.fromDate, ">", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Deleter fromDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Deleter) mo19936in(false, this.f3635a.fromDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Deleter fromDateIn(@NonNull Integer... numArr) {
        return fromDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityAdjustTrackPoint_Deleter fromDateLe(int i) {
        return (RFLEntityAdjustTrackPoint_Deleter) where(this.f3635a.fromDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Deleter fromDateLt(int i) {
        return (RFLEntityAdjustTrackPoint_Deleter) where(this.f3635a.fromDate, "<", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Deleter fromDateNotEq(int i) {
        return (RFLEntityAdjustTrackPoint_Deleter) where(this.f3635a.fromDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Deleter fromDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Deleter) mo19936in(true, this.f3635a.fromDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Deleter fromDateNotIn(@NonNull Integer... numArr) {
        return fromDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityAdjustTrackPoint_Schema getSchema() {
        return this.f3635a;
    }

    public RFLEntityAdjustTrackPoint_Deleter toDateBetween(int i, int i2) {
        return (RFLEntityAdjustTrackPoint_Deleter) whereBetween(this.f3635a.toDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityAdjustTrackPoint_Deleter toDateEq(int i) {
        return (RFLEntityAdjustTrackPoint_Deleter) where(this.f3635a.toDate, "=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Deleter toDateGe(int i) {
        return (RFLEntityAdjustTrackPoint_Deleter) where(this.f3635a.toDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Deleter toDateGt(int i) {
        return (RFLEntityAdjustTrackPoint_Deleter) where(this.f3635a.toDate, ">", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Deleter toDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Deleter) mo19936in(false, this.f3635a.toDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Deleter toDateIn(@NonNull Integer... numArr) {
        return toDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityAdjustTrackPoint_Deleter toDateLe(int i) {
        return (RFLEntityAdjustTrackPoint_Deleter) where(this.f3635a.toDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Deleter toDateLt(int i) {
        return (RFLEntityAdjustTrackPoint_Deleter) where(this.f3635a.toDate, "<", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Deleter toDateNotEq(int i) {
        return (RFLEntityAdjustTrackPoint_Deleter) where(this.f3635a.toDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Deleter toDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Deleter) mo19936in(true, this.f3635a.toDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Deleter toDateNotIn(@NonNull Integer... numArr) {
        return toDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }
}
