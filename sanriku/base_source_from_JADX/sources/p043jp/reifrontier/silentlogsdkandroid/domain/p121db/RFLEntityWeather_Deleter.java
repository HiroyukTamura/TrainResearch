package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0852b;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather_Deleter */
public class RFLEntityWeather_Deleter extends C0852b<RFLEntityWeather, RFLEntityWeather_Deleter> {

    /* renamed from: a */
    final RFLEntityWeather_Schema f3734a;

    public RFLEntityWeather_Deleter(C0855d dVar, RFLEntityWeather_Schema rFLEntityWeather_Schema) {
        super((C0700h) dVar);
        this.f3734a = rFLEntityWeather_Schema;
    }

    public RFLEntityWeather_Deleter(RFLEntityWeather_Deleter rFLEntityWeather_Deleter) {
        super(rFLEntityWeather_Deleter);
        this.f3734a = rFLEntityWeather_Deleter.getSchema();
    }

    public RFLEntityWeather_Deleter(RFLEntityWeather_Relation rFLEntityWeather_Relation) {
        super(rFLEntityWeather_Relation);
        this.f3734a = rFLEntityWeather_Relation.getSchema();
    }

    public RFLEntityWeather_Deleter clone() {
        return new RFLEntityWeather_Deleter(this);
    }

    public RFLEntityWeather_Deleter dateBetween(int i, int i2) {
        return (RFLEntityWeather_Deleter) whereBetween(this.f3734a.date, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityWeather_Deleter dateEq(int i) {
        return (RFLEntityWeather_Deleter) where(this.f3734a.date, "=", Integer.valueOf(i));
    }

    public RFLEntityWeather_Deleter dateGe(int i) {
        return (RFLEntityWeather_Deleter) where(this.f3734a.date, ">=", Integer.valueOf(i));
    }

    public RFLEntityWeather_Deleter dateGt(int i) {
        return (RFLEntityWeather_Deleter) where(this.f3734a.date, ">", Integer.valueOf(i));
    }

    public RFLEntityWeather_Deleter dateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityWeather_Deleter) mo19936in(false, this.f3734a.date, collection);
    }

    public final RFLEntityWeather_Deleter dateIn(@NonNull Integer... numArr) {
        return dateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityWeather_Deleter dateLe(int i) {
        return (RFLEntityWeather_Deleter) where(this.f3734a.date, "<=", Integer.valueOf(i));
    }

    public RFLEntityWeather_Deleter dateLt(int i) {
        return (RFLEntityWeather_Deleter) where(this.f3734a.date, "<", Integer.valueOf(i));
    }

    public RFLEntityWeather_Deleter dateNotEq(int i) {
        return (RFLEntityWeather_Deleter) where(this.f3734a.date, "<>", Integer.valueOf(i));
    }

    public RFLEntityWeather_Deleter dateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityWeather_Deleter) mo19936in(true, this.f3734a.date, collection);
    }

    public final RFLEntityWeather_Deleter dateNotIn(@NonNull Integer... numArr) {
        return dateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityWeather_Schema getSchema() {
        return this.f3734a;
    }
}
