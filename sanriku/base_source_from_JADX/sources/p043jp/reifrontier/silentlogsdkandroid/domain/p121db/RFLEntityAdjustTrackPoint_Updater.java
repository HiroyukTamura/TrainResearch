package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0869g;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint_Updater */
public class RFLEntityAdjustTrackPoint_Updater extends C0869g<RFLEntityAdjustTrackPoint, RFLEntityAdjustTrackPoint_Updater> {

    /* renamed from: a */
    final RFLEntityAdjustTrackPoint_Schema f3640a;

    public RFLEntityAdjustTrackPoint_Updater(C0855d dVar, RFLEntityAdjustTrackPoint_Schema rFLEntityAdjustTrackPoint_Schema) {
        super((C0700h) dVar);
        this.f3640a = rFLEntityAdjustTrackPoint_Schema;
    }

    public RFLEntityAdjustTrackPoint_Updater(RFLEntityAdjustTrackPoint_Relation rFLEntityAdjustTrackPoint_Relation) {
        super(rFLEntityAdjustTrackPoint_Relation);
        this.f3640a = rFLEntityAdjustTrackPoint_Relation.getSchema();
    }

    public RFLEntityAdjustTrackPoint_Updater(RFLEntityAdjustTrackPoint_Updater rFLEntityAdjustTrackPoint_Updater) {
        super(rFLEntityAdjustTrackPoint_Updater);
        this.f3640a = rFLEntityAdjustTrackPoint_Updater.getSchema();
    }

    public RFLEntityAdjustTrackPoint_Updater clone() {
        return new RFLEntityAdjustTrackPoint_Updater(this);
    }

    public RFLEntityAdjustTrackPoint_Updater data(@NonNull byte[] bArr) {
        this.contents.put("`data`", bArr);
        return this;
    }

    public RFLEntityAdjustTrackPoint_Updater fromDate(int i) {
        this.contents.put("`fromDate`", Integer.valueOf(i));
        return this;
    }

    public RFLEntityAdjustTrackPoint_Updater fromDateBetween(int i, int i2) {
        return (RFLEntityAdjustTrackPoint_Updater) whereBetween(this.f3640a.fromDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityAdjustTrackPoint_Updater fromDateEq(int i) {
        return (RFLEntityAdjustTrackPoint_Updater) where(this.f3640a.fromDate, "=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Updater fromDateGe(int i) {
        return (RFLEntityAdjustTrackPoint_Updater) where(this.f3640a.fromDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Updater fromDateGt(int i) {
        return (RFLEntityAdjustTrackPoint_Updater) where(this.f3640a.fromDate, ">", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Updater fromDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Updater) mo19936in(false, this.f3640a.fromDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Updater fromDateIn(@NonNull Integer... numArr) {
        return fromDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityAdjustTrackPoint_Updater fromDateLe(int i) {
        return (RFLEntityAdjustTrackPoint_Updater) where(this.f3640a.fromDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Updater fromDateLt(int i) {
        return (RFLEntityAdjustTrackPoint_Updater) where(this.f3640a.fromDate, "<", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Updater fromDateNotEq(int i) {
        return (RFLEntityAdjustTrackPoint_Updater) where(this.f3640a.fromDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Updater fromDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Updater) mo19936in(true, this.f3640a.fromDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Updater fromDateNotIn(@NonNull Integer... numArr) {
        return fromDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityAdjustTrackPoint_Schema getSchema() {
        return this.f3640a;
    }

    public RFLEntityAdjustTrackPoint_Updater toDate(int i) {
        this.contents.put("`toDate`", Integer.valueOf(i));
        return this;
    }

    public RFLEntityAdjustTrackPoint_Updater toDateBetween(int i, int i2) {
        return (RFLEntityAdjustTrackPoint_Updater) whereBetween(this.f3640a.toDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityAdjustTrackPoint_Updater toDateEq(int i) {
        return (RFLEntityAdjustTrackPoint_Updater) where(this.f3640a.toDate, "=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Updater toDateGe(int i) {
        return (RFLEntityAdjustTrackPoint_Updater) where(this.f3640a.toDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Updater toDateGt(int i) {
        return (RFLEntityAdjustTrackPoint_Updater) where(this.f3640a.toDate, ">", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Updater toDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Updater) mo19936in(false, this.f3640a.toDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Updater toDateIn(@NonNull Integer... numArr) {
        return toDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityAdjustTrackPoint_Updater toDateLe(int i) {
        return (RFLEntityAdjustTrackPoint_Updater) where(this.f3640a.toDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Updater toDateLt(int i) {
        return (RFLEntityAdjustTrackPoint_Updater) where(this.f3640a.toDate, "<", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Updater toDateNotEq(int i) {
        return (RFLEntityAdjustTrackPoint_Updater) where(this.f3640a.toDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityAdjustTrackPoint_Updater toDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityAdjustTrackPoint_Updater) mo19936in(true, this.f3640a.toDate, collection);
    }

    public final RFLEntityAdjustTrackPoint_Updater toDateNotIn(@NonNull Integer... numArr) {
        return toDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }
}
