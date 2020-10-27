package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0869g;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather_Updater */
public class RFLEntityWeather_Updater extends C0869g<RFLEntityWeather, RFLEntityWeather_Updater> {

    /* renamed from: a */
    final RFLEntityWeather_Schema f3739a;

    public RFLEntityWeather_Updater(C0855d dVar, RFLEntityWeather_Schema rFLEntityWeather_Schema) {
        super((C0700h) dVar);
        this.f3739a = rFLEntityWeather_Schema;
    }

    public RFLEntityWeather_Updater(RFLEntityWeather_Relation rFLEntityWeather_Relation) {
        super(rFLEntityWeather_Relation);
        this.f3739a = rFLEntityWeather_Relation.getSchema();
    }

    public RFLEntityWeather_Updater(RFLEntityWeather_Updater rFLEntityWeather_Updater) {
        super(rFLEntityWeather_Updater);
        this.f3739a = rFLEntityWeather_Updater.getSchema();
    }

    public RFLEntityWeather_Updater clone() {
        return new RFLEntityWeather_Updater(this);
    }

    public RFLEntityWeather_Updater date(int i) {
        this.contents.put("`date`", Integer.valueOf(i));
        return this;
    }

    public RFLEntityWeather_Updater dateBetween(int i, int i2) {
        return (RFLEntityWeather_Updater) whereBetween(this.f3739a.date, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityWeather_Updater dateEq(int i) {
        return (RFLEntityWeather_Updater) where(this.f3739a.date, "=", Integer.valueOf(i));
    }

    public RFLEntityWeather_Updater dateGe(int i) {
        return (RFLEntityWeather_Updater) where(this.f3739a.date, ">=", Integer.valueOf(i));
    }

    public RFLEntityWeather_Updater dateGt(int i) {
        return (RFLEntityWeather_Updater) where(this.f3739a.date, ">", Integer.valueOf(i));
    }

    public RFLEntityWeather_Updater dateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityWeather_Updater) mo19936in(false, this.f3739a.date, collection);
    }

    public final RFLEntityWeather_Updater dateIn(@NonNull Integer... numArr) {
        return dateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityWeather_Updater dateLe(int i) {
        return (RFLEntityWeather_Updater) where(this.f3739a.date, "<=", Integer.valueOf(i));
    }

    public RFLEntityWeather_Updater dateLt(int i) {
        return (RFLEntityWeather_Updater) where(this.f3739a.date, "<", Integer.valueOf(i));
    }

    public RFLEntityWeather_Updater dateNotEq(int i) {
        return (RFLEntityWeather_Updater) where(this.f3739a.date, "<>", Integer.valueOf(i));
    }

    public RFLEntityWeather_Updater dateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityWeather_Updater) mo19936in(true, this.f3739a.date, collection);
    }

    public final RFLEntityWeather_Updater dateNotIn(@NonNull Integer... numArr) {
        return dateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityWeather_Schema getSchema() {
        return this.f3739a;
    }

    public RFLEntityWeather_Updater pressure(@NonNull String str) {
        this.contents.put("`pressure`", str);
        return this;
    }

    public RFLEntityWeather_Updater pressureIn(@NonNull String str) {
        this.contents.put("`pressureIn`", str);
        return this;
    }

    public RFLEntityWeather_Updater temperature(int i) {
        this.contents.put("`temperature`", Integer.valueOf(i));
        return this;
    }

    public RFLEntityWeather_Updater timestamp(int i) {
        this.contents.put("`timestamp`", Integer.valueOf(i));
        return this;
    }

    public RFLEntityWeather_Updater trend(@NonNull String str) {
        this.contents.put("`trend`", str);
        return this;
    }

    public RFLEntityWeather_Updater type(@NonNull String str) {
        this.contents.put("`type`", str);
        return this;
    }
}
