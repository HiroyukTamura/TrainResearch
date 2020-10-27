package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0869g;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDailyTag_Updater */
public class RFLEntityDailyTag_Updater extends C0869g<RFLEntityDailyTag, RFLEntityDailyTag_Updater> {

    /* renamed from: a */
    final RFLEntityDailyTag_Schema f3664a;

    public RFLEntityDailyTag_Updater(C0855d dVar, RFLEntityDailyTag_Schema rFLEntityDailyTag_Schema) {
        super((C0700h) dVar);
        this.f3664a = rFLEntityDailyTag_Schema;
    }

    public RFLEntityDailyTag_Updater(RFLEntityDailyTag_Relation rFLEntityDailyTag_Relation) {
        super(rFLEntityDailyTag_Relation);
        this.f3664a = rFLEntityDailyTag_Relation.getSchema();
    }

    public RFLEntityDailyTag_Updater(RFLEntityDailyTag_Updater rFLEntityDailyTag_Updater) {
        super(rFLEntityDailyTag_Updater);
        this.f3664a = rFLEntityDailyTag_Updater.getSchema();
    }

    public RFLEntityDailyTag_Updater clone() {
        return new RFLEntityDailyTag_Updater(this);
    }

    public RFLEntityDailyTag_Updater dailyTag(@NonNull String str) {
        this.contents.put("`dailyTag`", str);
        return this;
    }

    public RFLEntityDailyTag_Updater date(int i) {
        this.contents.put("`date`", Integer.valueOf(i));
        return this;
    }

    public RFLEntityDailyTag_Updater dateBetween(int i, int i2) {
        return (RFLEntityDailyTag_Updater) whereBetween(this.f3664a.date, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityDailyTag_Updater dateEq(int i) {
        return (RFLEntityDailyTag_Updater) where(this.f3664a.date, "=", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Updater dateGe(int i) {
        return (RFLEntityDailyTag_Updater) where(this.f3664a.date, ">=", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Updater dateGt(int i) {
        return (RFLEntityDailyTag_Updater) where(this.f3664a.date, ">", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Updater dateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityDailyTag_Updater) mo19936in(false, this.f3664a.date, collection);
    }

    public final RFLEntityDailyTag_Updater dateIn(@NonNull Integer... numArr) {
        return dateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityDailyTag_Updater dateLe(int i) {
        return (RFLEntityDailyTag_Updater) where(this.f3664a.date, "<=", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Updater dateLt(int i) {
        return (RFLEntityDailyTag_Updater) where(this.f3664a.date, "<", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Updater dateNotEq(int i) {
        return (RFLEntityDailyTag_Updater) where(this.f3664a.date, "<>", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Updater dateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityDailyTag_Updater) mo19936in(true, this.f3664a.date, collection);
    }

    public final RFLEntityDailyTag_Updater dateNotIn(@NonNull Integer... numArr) {
        return dateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityDailyTag_Schema getSchema() {
        return this.f3664a;
    }

    public RFLEntityDailyTag_Updater updateTime(int i) {
        this.contents.put("`updateTime`", Integer.valueOf(i));
        return this;
    }
}
