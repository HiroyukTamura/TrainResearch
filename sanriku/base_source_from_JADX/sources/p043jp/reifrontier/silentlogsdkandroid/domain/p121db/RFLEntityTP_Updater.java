package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0869g;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTP_Updater */
public class RFLEntityTP_Updater extends C0869g<RFLEntityTP, RFLEntityTP_Updater> {

    /* renamed from: a */
    final RFLEntityTP_Schema f3703a;

    public RFLEntityTP_Updater(C0855d dVar, RFLEntityTP_Schema rFLEntityTP_Schema) {
        super((C0700h) dVar);
        this.f3703a = rFLEntityTP_Schema;
    }

    public RFLEntityTP_Updater(RFLEntityTP_Relation rFLEntityTP_Relation) {
        super(rFLEntityTP_Relation);
        this.f3703a = rFLEntityTP_Relation.getSchema();
    }

    public RFLEntityTP_Updater(RFLEntityTP_Updater rFLEntityTP_Updater) {
        super(rFLEntityTP_Updater);
        this.f3703a = rFLEntityTP_Updater.getSchema();
    }

    public RFLEntityTP_Updater clone() {
        return new RFLEntityTP_Updater(this);
    }

    public RFLEntityTP_Updater data(@NonNull byte[] bArr) {
        this.contents.put("`data`", bArr);
        return this;
    }

    public RFLEntityTP_Updater date(@NonNull String str) {
        this.contents.put("`date`", str);
        return this;
    }

    public RFLEntityTP_Updater dateEq(@NonNull String str) {
        return (RFLEntityTP_Updater) where(this.f3703a.date, "=", str);
    }

    public RFLEntityTP_Updater dateGe(@NonNull String str) {
        return (RFLEntityTP_Updater) where(this.f3703a.date, ">=", str);
    }

    public RFLEntityTP_Updater dateGlob(@NonNull String str) {
        return (RFLEntityTP_Updater) where(this.f3703a.date, "GLOB", str);
    }

    public RFLEntityTP_Updater dateGt(@NonNull String str) {
        return (RFLEntityTP_Updater) where(this.f3703a.date, ">", str);
    }

    public RFLEntityTP_Updater dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityTP_Updater) mo19936in(false, this.f3703a.date, collection);
    }

    public final RFLEntityTP_Updater dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTP_Updater dateLe(@NonNull String str) {
        return (RFLEntityTP_Updater) where(this.f3703a.date, "<=", str);
    }

    public RFLEntityTP_Updater dateLike(@NonNull String str) {
        return (RFLEntityTP_Updater) where(this.f3703a.date, "LIKE", str);
    }

    public RFLEntityTP_Updater dateLt(@NonNull String str) {
        return (RFLEntityTP_Updater) where(this.f3703a.date, "<", str);
    }

    public RFLEntityTP_Updater dateNotEq(@NonNull String str) {
        return (RFLEntityTP_Updater) where(this.f3703a.date, "<>", str);
    }

    public RFLEntityTP_Updater dateNotGlob(@NonNull String str) {
        return (RFLEntityTP_Updater) where(this.f3703a.date, "NOT GLOB", str);
    }

    public RFLEntityTP_Updater dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityTP_Updater) mo19936in(true, this.f3703a.date, collection);
    }

    public final RFLEntityTP_Updater dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTP_Updater dateNotLike(@NonNull String str) {
        return (RFLEntityTP_Updater) where(this.f3703a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityTP_Schema getSchema() {
        return this.f3703a;
    }
}
