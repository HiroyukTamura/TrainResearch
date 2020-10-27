package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import android.content.ContentValues;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0856e;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDailyTag_Relation */
public class RFLEntityDailyTag_Relation extends C0856e<RFLEntityDailyTag, RFLEntityDailyTag_Relation> {

    /* renamed from: a */
    final RFLEntityDailyTag_Schema f3660a;

    public RFLEntityDailyTag_Relation(C0855d dVar, RFLEntityDailyTag_Schema rFLEntityDailyTag_Schema) {
        super(dVar);
        this.f3660a = rFLEntityDailyTag_Schema;
    }

    public RFLEntityDailyTag_Relation(RFLEntityDailyTag_Relation rFLEntityDailyTag_Relation) {
        super(rFLEntityDailyTag_Relation);
        this.f3660a = rFLEntityDailyTag_Relation.getSchema();
    }

    public RFLEntityDailyTag_Relation clone() {
        return new RFLEntityDailyTag_Relation(this);
    }

    public RFLEntityDailyTag_Relation dateBetween(int i, int i2) {
        return (RFLEntityDailyTag_Relation) whereBetween(this.f3660a.date, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public RFLEntityDailyTag_Relation dateEq(int i) {
        return (RFLEntityDailyTag_Relation) where(this.f3660a.date, "=", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Relation dateGe(int i) {
        return (RFLEntityDailyTag_Relation) where(this.f3660a.date, ">=", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Relation dateGt(int i) {
        return (RFLEntityDailyTag_Relation) where(this.f3660a.date, ">", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Relation dateIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityDailyTag_Relation) mo19936in(false, this.f3660a.date, collection);
    }

    public final RFLEntityDailyTag_Relation dateIn(@NonNull Integer... numArr) {
        return dateIn((Collection<Integer>) Arrays.asList(numArr));
    }

    public RFLEntityDailyTag_Relation dateLe(int i) {
        return (RFLEntityDailyTag_Relation) where(this.f3660a.date, "<=", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Relation dateLt(int i) {
        return (RFLEntityDailyTag_Relation) where(this.f3660a.date, "<", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Relation dateNotEq(int i) {
        return (RFLEntityDailyTag_Relation) where(this.f3660a.date, "<>", Integer.valueOf(i));
    }

    public RFLEntityDailyTag_Relation dateNotIn(@NonNull Collection<Integer> collection) {
        return (RFLEntityDailyTag_Relation) mo19936in(true, this.f3660a.date, collection);
    }

    public final RFLEntityDailyTag_Relation dateNotIn(@NonNull Integer... numArr) {
        return dateNotIn((Collection<Integer>) Arrays.asList(numArr));
    }

    @NonNull
    public RFLEntityDailyTag_Deleter deleter() {
        return new RFLEntityDailyTag_Deleter(this);
    }

    @NonNull
    public RFLEntityDailyTag_Schema getSchema() {
        return this.f3660a;
    }

    public RFLEntityDailyTag_Relation orderByDateAsc() {
        return (RFLEntityDailyTag_Relation) orderBy(this.f3660a.date.orderInAscending());
    }

    public RFLEntityDailyTag_Relation orderByDateDesc() {
        return (RFLEntityDailyTag_Relation) orderBy(this.f3660a.date.orderInDescending());
    }

    @CheckResult
    @NonNull
    public RFLEntityDailyTag reload(@NonNull RFLEntityDailyTag rFLEntityDailyTag) {
        return (RFLEntityDailyTag) selector().dateEq(rFLEntityDailyTag.getDate()).value();
    }

    @NonNull
    public RFLEntityDailyTag_Selector selector() {
        return new RFLEntityDailyTag_Selector(this);
    }

    @NonNull
    public RFLEntityDailyTag_Updater updater() {
        return new RFLEntityDailyTag_Updater(this);
    }

    @NonNull
    public RFLEntityDailyTag upsertWithoutTransaction(@NonNull RFLEntityDailyTag rFLEntityDailyTag) {
        Object a;
        ContentValues contentValues = new ContentValues();
        contentValues.put("`dailyTag`", rFLEntityDailyTag.getDailyTag());
        contentValues.put("`updateTime`", Integer.valueOf(rFLEntityDailyTag.getUpdateTime()));
        contentValues.put("`date`", Integer.valueOf(rFLEntityDailyTag.getDate()));
        if (((RFLEntityDailyTag_Updater) updater().dateEq(rFLEntityDailyTag.getDate()).putAll(contentValues)).execute() != 0) {
            a = selector().dateEq(rFLEntityDailyTag.getDate()).value();
        } else {
            a = this.conn.mo19804a(this.f3660a, this.conn.mo19802a(this.f3660a, contentValues, 0));
        }
        return (RFLEntityDailyTag) a;
    }
}
