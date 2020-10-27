package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import android.content.ContentValues;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0856e;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast_Relation */
public class RFLEntityForecast_Relation extends C0856e<RFLEntityForecast, RFLEntityForecast_Relation> {

    /* renamed from: a */
    final RFLEntityForecast_Schema f3681a;

    public RFLEntityForecast_Relation(C0855d dVar, RFLEntityForecast_Schema rFLEntityForecast_Schema) {
        super(dVar);
        this.f3681a = rFLEntityForecast_Schema;
    }

    public RFLEntityForecast_Relation(RFLEntityForecast_Relation rFLEntityForecast_Relation) {
        super(rFLEntityForecast_Relation);
        this.f3681a = rFLEntityForecast_Relation.getSchema();
    }

    public RFLEntityForecast_Relation clone() {
        return new RFLEntityForecast_Relation(this);
    }

    public RFLEntityForecast_Relation dateBetween(int i, int i2) {
        return (RFLEntityForecast_Relation) whereBetween(this.f3681a.date, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityForecast_Relation dateEq(int i) {
        return (RFLEntityForecast_Relation) where(this.f3681a.date, "=", Integer.valueOf(i));
    }

    public RFLEntityForecast_Relation dateGe(int i) {
        return (RFLEntityForecast_Relation) where(this.f3681a.date, ">=", Integer.valueOf(i));
    }

    public RFLEntityForecast_Relation dateGt(int i) {
        return (RFLEntityForecast_Relation) where(this.f3681a.date, ">", Integer.valueOf(i));
    }

    public RFLEntityForecast_Relation dateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityForecast_Relation) mo19936in(false, this.f3681a.date, collection);
    }

    public final RFLEntityForecast_Relation dateIn(@NonNull Integer... numArr) {
        return dateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityForecast_Relation dateLe(int i) {
        return (RFLEntityForecast_Relation) where(this.f3681a.date, "<=", Integer.valueOf(i));
    }

    public RFLEntityForecast_Relation dateLt(int i) {
        return (RFLEntityForecast_Relation) where(this.f3681a.date, "<", Integer.valueOf(i));
    }

    public RFLEntityForecast_Relation dateNotEq(int i) {
        return (RFLEntityForecast_Relation) where(this.f3681a.date, "<>", Integer.valueOf(i));
    }

    public RFLEntityForecast_Relation dateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityForecast_Relation) mo19936in(true, this.f3681a.date, collection);
    }

    public final RFLEntityForecast_Relation dateNotIn(@NonNull Integer... numArr) {
        return dateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityForecast_Deleter deleter() {
        return new RFLEntityForecast_Deleter(this);
    }

    @NonNull
    public RFLEntityForecast_Schema getSchema() {
        return this.f3681a;
    }

    public RFLEntityForecast_Relation orderByDateAsc() {
        return (RFLEntityForecast_Relation) orderBy(this.f3681a.date.orderInAscending());
    }

    public RFLEntityForecast_Relation orderByDateDesc() {
        return (RFLEntityForecast_Relation) orderBy(this.f3681a.date.orderInDescending());
    }

    @CheckResult
    @NonNull
    public RFLEntityForecast reload(@NonNull RFLEntityForecast rFLEntityForecast) {
        return (RFLEntityForecast) selector().dateEq(rFLEntityForecast.getDate()).value();
    }

    @NonNull
    public RFLEntityForecast_Selector selector() {
        return new RFLEntityForecast_Selector(this);
    }

    @NonNull
    public RFLEntityForecast_Updater updater() {
        return new RFLEntityForecast_Updater(this);
    }

    @NonNull
    public RFLEntityForecast upsertWithoutTransaction(@NonNull RFLEntityForecast rFLEntityForecast) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("`highTemperature`", Integer.valueOf(rFLEntityForecast.getHighTemperature()));
        contentValues.put("`lowTemperature`", Integer.valueOf(rFLEntityForecast.getLowTemperature()));
        contentValues.put("`icon`", rFLEntityForecast.getIcon() != null ? rFLEntityForecast.getIcon() : null);
        contentValues.put("`weatherCode`", Integer.valueOf(rFLEntityForecast.getWeatherCode()));
        contentValues.put("`weatherType`", Integer.valueOf(rFLEntityForecast.getWeatherType()));
        contentValues.put("`timestamp`", Integer.valueOf(rFLEntityForecast.getTimestamp()));
        contentValues.put("`date`", Integer.valueOf(rFLEntityForecast.getDate()));
        return (RFLEntityForecast) (((RFLEntityForecast_Updater) updater().dateEq(rFLEntityForecast.getDate()).putAll(contentValues)).execute() != 0 ? selector().dateEq(rFLEntityForecast.getDate()).value() : this.conn.mo19804a(this.f3681a, this.conn.mo19802a(this.f3681a, contentValues, 0)));
    }
}
