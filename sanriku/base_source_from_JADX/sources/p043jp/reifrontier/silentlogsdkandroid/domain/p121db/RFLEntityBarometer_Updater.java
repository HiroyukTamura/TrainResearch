package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0869g;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer_Updater */
public class RFLEntityBarometer_Updater extends C0869g<RFLEntityBarometer, RFLEntityBarometer_Updater> {

    /* renamed from: a */
    final RFLEntityBarometer_Schema f3650a;

    public RFLEntityBarometer_Updater(C0855d dVar, RFLEntityBarometer_Schema rFLEntityBarometer_Schema) {
        super((C0700h) dVar);
        this.f3650a = rFLEntityBarometer_Schema;
    }

    public RFLEntityBarometer_Updater(RFLEntityBarometer_Relation rFLEntityBarometer_Relation) {
        super(rFLEntityBarometer_Relation);
        this.f3650a = rFLEntityBarometer_Relation.getSchema();
    }

    public RFLEntityBarometer_Updater(RFLEntityBarometer_Updater rFLEntityBarometer_Updater) {
        super(rFLEntityBarometer_Updater);
        this.f3650a = rFLEntityBarometer_Updater.getSchema();
    }

    public RFLEntityBarometer_Updater clone() {
        return new RFLEntityBarometer_Updater(this);
    }

    public RFLEntityBarometer_Updater data(@NonNull byte[] bArr) {
        this.contents.put("`data`", bArr);
        return this;
    }

    public RFLEntityBarometer_Updater date(@NonNull String str) {
        this.contents.put("`date`", str);
        return this;
    }

    public RFLEntityBarometer_Updater dateEq(@NonNull String str) {
        return (RFLEntityBarometer_Updater) where(this.f3650a.date, "=", str);
    }

    public RFLEntityBarometer_Updater dateGe(@NonNull String str) {
        return (RFLEntityBarometer_Updater) where(this.f3650a.date, ">=", str);
    }

    public RFLEntityBarometer_Updater dateGlob(@NonNull String str) {
        return (RFLEntityBarometer_Updater) where(this.f3650a.date, "GLOB", str);
    }

    public RFLEntityBarometer_Updater dateGt(@NonNull String str) {
        return (RFLEntityBarometer_Updater) where(this.f3650a.date, ">", str);
    }

    public RFLEntityBarometer_Updater dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityBarometer_Updater) mo19936in(false, this.f3650a.date, collection);
    }

    public final RFLEntityBarometer_Updater dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityBarometer_Updater dateLe(@NonNull String str) {
        return (RFLEntityBarometer_Updater) where(this.f3650a.date, "<=", str);
    }

    public RFLEntityBarometer_Updater dateLike(@NonNull String str) {
        return (RFLEntityBarometer_Updater) where(this.f3650a.date, "LIKE", str);
    }

    public RFLEntityBarometer_Updater dateLt(@NonNull String str) {
        return (RFLEntityBarometer_Updater) where(this.f3650a.date, "<", str);
    }

    public RFLEntityBarometer_Updater dateNotEq(@NonNull String str) {
        return (RFLEntityBarometer_Updater) where(this.f3650a.date, "<>", str);
    }

    public RFLEntityBarometer_Updater dateNotGlob(@NonNull String str) {
        return (RFLEntityBarometer_Updater) where(this.f3650a.date, "NOT GLOB", str);
    }

    public RFLEntityBarometer_Updater dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityBarometer_Updater) mo19936in(true, this.f3650a.date, collection);
    }

    public final RFLEntityBarometer_Updater dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityBarometer_Updater dateNotLike(@NonNull String str) {
        return (RFLEntityBarometer_Updater) where(this.f3650a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityBarometer_Schema getSchema() {
        return this.f3650a;
    }
}
