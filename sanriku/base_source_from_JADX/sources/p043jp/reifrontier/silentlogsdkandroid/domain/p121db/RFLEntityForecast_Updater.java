package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0869g;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityForecast_Updater */
public class RFLEntityForecast_Updater extends C0869g<RFLEntityForecast, RFLEntityForecast_Updater> {

    /* renamed from: a */
    final RFLEntityForecast_Schema f3685a;

    public RFLEntityForecast_Updater(C0855d dVar, RFLEntityForecast_Schema rFLEntityForecast_Schema) {
        super((C0700h) dVar);
        this.f3685a = rFLEntityForecast_Schema;
    }

    public RFLEntityForecast_Updater(RFLEntityForecast_Relation rFLEntityForecast_Relation) {
        super(rFLEntityForecast_Relation);
        this.f3685a = rFLEntityForecast_Relation.getSchema();
    }

    public RFLEntityForecast_Updater(RFLEntityForecast_Updater rFLEntityForecast_Updater) {
        super(rFLEntityForecast_Updater);
        this.f3685a = rFLEntityForecast_Updater.getSchema();
    }

    public RFLEntityForecast_Updater clone() {
        return new RFLEntityForecast_Updater(this);
    }

    public RFLEntityForecast_Updater date(int i) {
        this.contents.put("`date`", Integer.valueOf(i));
        return this;
    }

    public RFLEntityForecast_Updater dateBetween(int i, int i2) {
        return (RFLEntityForecast_Updater) whereBetween(this.f3685a.date, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityForecast_Updater dateEq(int i) {
        return (RFLEntityForecast_Updater) where(this.f3685a.date, "=", Integer.valueOf(i));
    }

    public RFLEntityForecast_Updater dateGe(int i) {
        return (RFLEntityForecast_Updater) where(this.f3685a.date, ">=", Integer.valueOf(i));
    }

    public RFLEntityForecast_Updater dateGt(int i) {
        return (RFLEntityForecast_Updater) where(this.f3685a.date, ">", Integer.valueOf(i));
    }

    public RFLEntityForecast_Updater dateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityForecast_Updater) mo19936in(false, this.f3685a.date, collection);
    }

    public final RFLEntityForecast_Updater dateIn(@NonNull Integer... numArr) {
        return dateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityForecast_Updater dateLe(int i) {
        return (RFLEntityForecast_Updater) where(this.f3685a.date, "<=", Integer.valueOf(i));
    }

    public RFLEntityForecast_Updater dateLt(int i) {
        return (RFLEntityForecast_Updater) where(this.f3685a.date, "<", Integer.valueOf(i));
    }

    public RFLEntityForecast_Updater dateNotEq(int i) {
        return (RFLEntityForecast_Updater) where(this.f3685a.date, "<>", Integer.valueOf(i));
    }

    public RFLEntityForecast_Updater dateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityForecast_Updater) mo19936in(true, this.f3685a.date, collection);
    }

    public final RFLEntityForecast_Updater dateNotIn(@NonNull Integer... numArr) {
        return dateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityForecast_Schema getSchema() {
        return this.f3685a;
    }

    public RFLEntityForecast_Updater highTemperature(int i) {
        this.contents.put("`highTemperature`", Integer.valueOf(i));
        return this;
    }

    public RFLEntityForecast_Updater icon(@Nullable String str) {
        if (str == null) {
            this.contents.putNull("`icon`");
        } else {
            this.contents.put("`icon`", str);
        }
        return this;
    }

    public RFLEntityForecast_Updater lowTemperature(int i) {
        this.contents.put("`lowTemperature`", Integer.valueOf(i));
        return this;
    }

    public RFLEntityForecast_Updater timestamp(int i) {
        this.contents.put("`timestamp`", Integer.valueOf(i));
        return this;
    }

    public RFLEntityForecast_Updater weatherCode(int i) {
        this.contents.put("`weatherCode`", Integer.valueOf(i));
        return this;
    }

    public RFLEntityForecast_Updater weatherType(int i) {
        this.contents.put("`weatherType`", Integer.valueOf(i));
        return this;
    }
}
