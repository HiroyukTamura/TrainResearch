package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0852b;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDailyTag_Deleter */
public class RFLEntityDailyTag_Deleter extends C0852b<RFLEntityDailyTag, RFLEntityDailyTag_Deleter> {

    /* renamed from: a */
    final RFLEntityDailyTag_Schema f3659a;

    public RFLEntityDailyTag_Deleter(C0855d dVar, RFLEntityDailyTag_Schema rFLEntityDailyTag_Schema) {
        super((C0700h) dVar);
        this.f3659a = rFLEntityDailyTag_Schema;
    }

    public RFLEntityDailyTag_Deleter(RFLEntityDailyTag_Deleter rFLEntityDailyTag_Deleter) {
        super(rFLEntityDailyTag_Deleter);
        this.f3659a = rFLEntityDailyTag_Deleter.getSchema();
    }

    public RFLEntityDailyTag_Deleter(RFLEntityDailyTag_Relation rFLEntityDailyTag_Relation) {
        super(rFLEntityDailyTag_Relation);
        this.f3659a = rFLEntityDailyTag_Relation.getSchema();
    }

    public RFLEntityDailyTag_Deleter clone() {
        return new RFLEntityDailyTag_Deleter(this);
    }

    public RFLEntityDailyTag_Deleter dateBetween(int i, int i2) {
        return (RFLEntityDailyTag_Deleter) whereBetween(this.f3659a.date, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityDailyTag_Deleter dateEq(int i) {
        return (RFLEntityDailyTag_Deleter) where(this.f3659a.date, "=", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Deleter dateGe(int i) {
        return (RFLEntityDailyTag_Deleter) where(this.f3659a.date, ">=", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Deleter dateGt(int i) {
        return (RFLEntityDailyTag_Deleter) where(this.f3659a.date, ">", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Deleter dateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityDailyTag_Deleter) mo19936in(false, this.f3659a.date, collection);
    }

    public final RFLEntityDailyTag_Deleter dateIn(@NonNull Integer... numArr) {
        return dateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityDailyTag_Deleter dateLe(int i) {
        return (RFLEntityDailyTag_Deleter) where(this.f3659a.date, "<=", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Deleter dateLt(int i) {
        return (RFLEntityDailyTag_Deleter) where(this.f3659a.date, "<", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Deleter dateNotEq(int i) {
        return (RFLEntityDailyTag_Deleter) where(this.f3659a.date, "<>", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Deleter dateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityDailyTag_Deleter) mo19936in(true, this.f3659a.date, collection);
    }

    public final RFLEntityDailyTag_Deleter dateNotIn(@NonNull Integer... numArr) {
        return dateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityDailyTag_Schema getSchema() {
        return this.f3659a;
    }
}
