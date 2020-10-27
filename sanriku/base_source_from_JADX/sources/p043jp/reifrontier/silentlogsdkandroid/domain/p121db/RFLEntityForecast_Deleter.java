package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0852b;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast_Deleter */
public class RFLEntityForecast_Deleter extends C0852b<RFLEntityForecast, RFLEntityForecast_Deleter> {

    /* renamed from: a */
    final RFLEntityForecast_Schema f3680a;

    public RFLEntityForecast_Deleter(C0855d dVar, RFLEntityForecast_Schema rFLEntityForecast_Schema) {
        super((C0700h) dVar);
        this.f3680a = rFLEntityForecast_Schema;
    }

    public RFLEntityForecast_Deleter(RFLEntityForecast_Deleter rFLEntityForecast_Deleter) {
        super(rFLEntityForecast_Deleter);
        this.f3680a = rFLEntityForecast_Deleter.getSchema();
    }

    public RFLEntityForecast_Deleter(RFLEntityForecast_Relation rFLEntityForecast_Relation) {
        super(rFLEntityForecast_Relation);
        this.f3680a = rFLEntityForecast_Relation.getSchema();
    }

    public RFLEntityForecast_Deleter clone() {
        return new RFLEntityForecast_Deleter(this);
    }

    public RFLEntityForecast_Deleter dateBetween(int i, int i2) {
        return (RFLEntityForecast_Deleter) whereBetween(this.f3680a.date, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityForecast_Deleter dateEq(int i) {
        return (RFLEntityForecast_Deleter) where(this.f3680a.date, "=", Integer.valueOf(i));
    }

    public RFLEntityForecast_Deleter dateGe(int i) {
        return (RFLEntityForecast_Deleter) where(this.f3680a.date, ">=", Integer.valueOf(i));
    }

    public RFLEntityForecast_Deleter dateGt(int i) {
        return (RFLEntityForecast_Deleter) where(this.f3680a.date, ">", Integer.valueOf(i));
    }

    public RFLEntityForecast_Deleter dateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityForecast_Deleter) mo19936in(false, this.f3680a.date, collection);
    }

    public final RFLEntityForecast_Deleter dateIn(@NonNull Integer... numArr) {
        return dateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityForecast_Deleter dateLe(int i) {
        return (RFLEntityForecast_Deleter) where(this.f3680a.date, "<=", Integer.valueOf(i));
    }

    public RFLEntityForecast_Deleter dateLt(int i) {
        return (RFLEntityForecast_Deleter) where(this.f3680a.date, "<", Integer.valueOf(i));
    }

    public RFLEntityForecast_Deleter dateNotEq(int i) {
        return (RFLEntityForecast_Deleter) where(this.f3680a.date, "<>", Integer.valueOf(i));
    }

    public RFLEntityForecast_Deleter dateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityForecast_Deleter) mo19936in(true, this.f3680a.date, collection);
    }

    public final RFLEntityForecast_Deleter dateNotIn(@NonNull Integer... numArr) {
        return dateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityForecast_Schema getSchema() {
        return this.f3680a;
    }
}
