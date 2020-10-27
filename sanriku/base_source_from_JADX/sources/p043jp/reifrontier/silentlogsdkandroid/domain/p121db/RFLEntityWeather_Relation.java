package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0856e;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather_Relation */
public class RFLEntityWeather_Relation extends C0856e<RFLEntityWeather, RFLEntityWeather_Relation> {

    /* renamed from: a */
    final RFLEntityWeather_Schema f3735a;

    public RFLEntityWeather_Relation(C0855d dVar, RFLEntityWeather_Schema rFLEntityWeather_Schema) {
        super(dVar);
        this.f3735a = rFLEntityWeather_Schema;
    }

    public RFLEntityWeather_Relation(RFLEntityWeather_Relation rFLEntityWeather_Relation) {
        super(rFLEntityWeather_Relation);
        this.f3735a = rFLEntityWeather_Relation.getSchema();
    }

    public RFLEntityWeather_Relation clone() {
        return new RFLEntityWeather_Relation(this);
    }

    public RFLEntityWeather_Relation dateBetween(int i, int i2) {
        return (RFLEntityWeather_Relation) whereBetween(this.f3735a.date, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityWeather_Relation dateEq(int i) {
        return (RFLEntityWeather_Relation) where(this.f3735a.date, "=", Integer.valueOf(i));
    }

    public RFLEntityWeather_Relation dateGe(int i) {
        return (RFLEntityWeather_Relation) where(this.f3735a.date, ">=", Integer.valueOf(i));
    }

    public RFLEntityWeather_Relation dateGt(int i) {
        return (RFLEntityWeather_Relation) where(this.f3735a.date, ">", Integer.valueOf(i));
    }

    public RFLEntityWeather_Relation dateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityWeather_Relation) mo19936in(false, this.f3735a.date, collection);
    }

    public final RFLEntityWeather_Relation dateIn(@NonNull Integer... numArr) {
        return dateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityWeather_Relation dateLe(int i) {
        return (RFLEntityWeather_Relation) where(this.f3735a.date, "<=", Integer.valueOf(i));
    }

    public RFLEntityWeather_Relation dateLt(int i) {
        return (RFLEntityWeather_Relation) where(this.f3735a.date, "<", Integer.valueOf(i));
    }

    public RFLEntityWeather_Relation dateNotEq(int i) {
        return (RFLEntityWeather_Relation) where(this.f3735a.date, "<>", Integer.valueOf(i));
    }

    public RFLEntityWeather_Relation dateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityWeather_Relation) mo19936in(true, this.f3735a.date, collection);
    }

    public final RFLEntityWeather_Relation dateNotIn(@NonNull Integer... numArr) {
        return dateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityWeather_Deleter deleter() {
        return new RFLEntityWeather_Deleter(this);
    }

    @NonNull
    public RFLEntityWeather_Schema getSchema() {
        return this.f3735a;
    }

    public RFLEntityWeather_Relation orderByDateAsc() {
        return (RFLEntityWeather_Relation) orderBy(this.f3735a.date.orderInAscending());
    }

    public RFLEntityWeather_Relation orderByDateDesc() {
        return (RFLEntityWeather_Relation) orderBy(this.f3735a.date.orderInDescending());
    }

    @NonNull
    public RFLEntityWeather_Selector selector() {
        return new RFLEntityWeather_Selector(this);
    }

    @NonNull
    public RFLEntityWeather_Updater updater() {
        return new RFLEntityWeather_Updater(this);
    }

    @NonNull
    public RFLEntityWeather upsertWithoutTransaction(@NonNull RFLEntityWeather rFLEntityWeather) {
        throw new UnsupportedOperationException("upsert is not supported because of missing @PrimaryKey");
    }
}
