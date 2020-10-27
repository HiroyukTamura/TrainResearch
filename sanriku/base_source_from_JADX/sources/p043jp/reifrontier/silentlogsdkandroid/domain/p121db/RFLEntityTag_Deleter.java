package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0852b;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTag_Deleter */
public class RFLEntityTag_Deleter extends C0852b<RFLEntityTag, RFLEntityTag_Deleter> {

    /* renamed from: a */
    final RFLEntityTag_Schema f3709a;

    public RFLEntityTag_Deleter(C0855d dVar, RFLEntityTag_Schema rFLEntityTag_Schema) {
        super((C0700h) dVar);
        this.f3709a = rFLEntityTag_Schema;
    }

    public RFLEntityTag_Deleter(RFLEntityTag_Deleter rFLEntityTag_Deleter) {
        super(rFLEntityTag_Deleter);
        this.f3709a = rFLEntityTag_Deleter.getSchema();
    }

    public RFLEntityTag_Deleter(RFLEntityTag_Relation rFLEntityTag_Relation) {
        super(rFLEntityTag_Relation);
        this.f3709a = rFLEntityTag_Relation.getSchema();
    }

    public RFLEntityTag_Deleter clone() {
        return new RFLEntityTag_Deleter(this);
    }

    public RFLEntityTag_Deleter fromDateBetween(int i, int i2) {
        return (RFLEntityTag_Deleter) whereBetween(this.f3709a.fromDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityTag_Deleter fromDateEq(int i) {
        return (RFLEntityTag_Deleter) where(this.f3709a.fromDate, "=", Integer.valueOf(i));
    }

    public RFLEntityTag_Deleter fromDateGe(int i) {
        return (RFLEntityTag_Deleter) where(this.f3709a.fromDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityTag_Deleter fromDateGt(int i) {
        return (RFLEntityTag_Deleter) where(this.f3709a.fromDate, ">", Integer.valueOf(i));
    }

    public RFLEntityTag_Deleter fromDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Deleter) mo19936in(false, this.f3709a.fromDate, collection);
    }

    public final RFLEntityTag_Deleter fromDateIn(@NonNull Integer... numArr) {
        return fromDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityTag_Deleter fromDateLe(int i) {
        return (RFLEntityTag_Deleter) where(this.f3709a.fromDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityTag_Deleter fromDateLt(int i) {
        return (RFLEntityTag_Deleter) where(this.f3709a.fromDate, "<", Integer.valueOf(i));
    }

    public RFLEntityTag_Deleter fromDateNotEq(int i) {
        return (RFLEntityTag_Deleter) where(this.f3709a.fromDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityTag_Deleter fromDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Deleter) mo19936in(true, this.f3709a.fromDate, collection);
    }

    public final RFLEntityTag_Deleter fromDateNotIn(@NonNull Integer... numArr) {
        return fromDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityTag_Schema getSchema() {
        return this.f3709a;
    }

    public RFLEntityTag_Deleter toDateBetween(int i, int i2) {
        return (RFLEntityTag_Deleter) whereBetween(this.f3709a.toDate, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityTag_Deleter toDateEq(int i) {
        return (RFLEntityTag_Deleter) where(this.f3709a.toDate, "=", Integer.valueOf(i));
    }

    public RFLEntityTag_Deleter toDateGe(int i) {
        return (RFLEntityTag_Deleter) where(this.f3709a.toDate, ">=", Integer.valueOf(i));
    }

    public RFLEntityTag_Deleter toDateGt(int i) {
        return (RFLEntityTag_Deleter) where(this.f3709a.toDate, ">", Integer.valueOf(i));
    }

    public RFLEntityTag_Deleter toDateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Deleter) mo19936in(false, this.f3709a.toDate, collection);
    }

    public final RFLEntityTag_Deleter toDateIn(@NonNull Integer... numArr) {
        return toDateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityTag_Deleter toDateLe(int i) {
        return (RFLEntityTag_Deleter) where(this.f3709a.toDate, "<=", Integer.valueOf(i));
    }

    public RFLEntityTag_Deleter toDateLt(int i) {
        return (RFLEntityTag_Deleter) where(this.f3709a.toDate, "<", Integer.valueOf(i));
    }

    public RFLEntityTag_Deleter toDateNotEq(int i) {
        return (RFLEntityTag_Deleter) where(this.f3709a.toDate, "<>", Integer.valueOf(i));
    }

    public RFLEntityTag_Deleter toDateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityTag_Deleter) mo19936in(true, this.f3709a.toDate, collection);
    }

    public final RFLEntityTag_Deleter toDateNotIn(@NonNull Integer... numArr) {
        return toDateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }
}
