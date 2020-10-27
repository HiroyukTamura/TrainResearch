package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0869g;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag_Updater */
public class RFLEntityTag_Updater extends C0869g<RFLEntityTag, RFLEntityTag_Updater> {

    /* renamed from: a */
    final RFLEntityTag_Schema f3714a;

    public RFLEntityTag_Updater(C0855d dVar, RFLEntityTag_Schema rFLEntityTag_Schema) {
        super((C0700h) dVar);
        this.f3714a = rFLEntityTag_Schema;
    }

    public RFLEntityTag_Updater(RFLEntityTag_Relation rFLEntityTag_Relation) {
        super(rFLEntityTag_Relation);
        this.f3714a = rFLEntityTag_Relation.getSchema();
    }

    public RFLEntityTag_Updater(RFLEntityTag_Updater rFLEntityTag_Updater) {
        super(rFLEntityTag_Updater);
        this.f3714a = rFLEntityTag_Updater.getSchema();
    }

    public RFLEntityTag_Updater clone() {
        return new RFLEntityTag_Updater(this);
    }

    public RFLEntityTag_Updater data(@NonNull byte[] bArr) {
        this.contents.put("`data`", bArr);
        return this;
    }

    public RFLEntityTag_Updater fromDate(int i) {
        this.contents.put("`fromDate`", Integer.valueOf(i));
        return this;
    }

    public RFLEntityTag_Updater fromDateBetween(int i, int i2) {
        return (RFLEntityTag_Updater) whereBetween(this.f3714a.fromDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityTag_Updater fromDateEq(int i) {
        return (RFLEntityTag_Updater) where(this.f3714a.fromDate, "=", Integer.valueOf(i));
    }

    public RFLEntityTag_Updater fromDateGe(int i) {
        return (RFLEntityTag_Updater) where(this.f3714a.fromDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityTag_Updater fromDateGt(int i) {
        return (RFLEntityTag_Updater) where(this.f3714a.fromDate, ">", Integer.valueOf(i));
    }

    public RFLEntityTag_Updater fromDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Updater) mo19936in(false, this.f3714a.fromDate, collection);
    }

    public final RFLEntityTag_Updater fromDateIn(@NonNull Integer... numArr) {
        return fromDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityTag_Updater fromDateLe(int i) {
        return (RFLEntityTag_Updater) where(this.f3714a.fromDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityTag_Updater fromDateLt(int i) {
        return (RFLEntityTag_Updater) where(this.f3714a.fromDate, "<", Integer.valueOf(i));
    }

    public RFLEntityTag_Updater fromDateNotEq(int i) {
        return (RFLEntityTag_Updater) where(this.f3714a.fromDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityTag_Updater fromDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Updater) mo19936in(true, this.f3714a.fromDate, collection);
    }

    public final RFLEntityTag_Updater fromDateNotIn(@NonNull Integer... numArr) {
        return fromDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityTag_Schema getSchema() {
        return this.f3714a;
    }

    public RFLEntityTag_Updater toDate(int i) {
        this.contents.put("`toDate`", Integer.valueOf(i));
        return this;
    }

    public RFLEntityTag_Updater toDateBetween(int i, int i2) {
        return (RFLEntityTag_Updater) whereBetween(this.f3714a.toDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityTag_Updater toDateEq(int i) {
        return (RFLEntityTag_Updater) where(this.f3714a.toDate, "=", Integer.valueOf(i));
    }

    public RFLEntityTag_Updater toDateGe(int i) {
        return (RFLEntityTag_Updater) where(this.f3714a.toDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityTag_Updater toDateGt(int i) {
        return (RFLEntityTag_Updater) where(this.f3714a.toDate, ">", Integer.valueOf(i));
    }

    public RFLEntityTag_Updater toDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Updater) mo19936in(false, this.f3714a.toDate, collection);
    }

    public final RFLEntityTag_Updater toDateIn(@NonNull Integer... numArr) {
        return toDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityTag_Updater toDateLe(int i) {
        return (RFLEntityTag_Updater) where(this.f3714a.toDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityTag_Updater toDateLt(int i) {
        return (RFLEntityTag_Updater) where(this.f3714a.toDate, "<", Integer.valueOf(i));
    }

    public RFLEntityTag_Updater toDateNotEq(int i) {
        return (RFLEntityTag_Updater) where(this.f3714a.toDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityTag_Updater toDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Updater) mo19936in(true, this.f3714a.toDate, collection);
    }

    public final RFLEntityTag_Updater toDateNotIn(@NonNull Integer... numArr) {
        return toDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }
}
