package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0869g;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityDaily_Updater */
public class RFLEntityDaily_Updater extends C0869g<RFLEntityDaily, RFLEntityDaily_Updater> {

    /* renamed from: a */
    final RFLEntityDaily_Schema f3671a;

    public RFLEntityDaily_Updater(C0855d dVar, RFLEntityDaily_Schema rFLEntityDaily_Schema) {
        super((C0700h) dVar);
        this.f3671a = rFLEntityDaily_Schema;
    }

    public RFLEntityDaily_Updater(RFLEntityDaily_Relation rFLEntityDaily_Relation) {
        super(rFLEntityDaily_Relation);
        this.f3671a = rFLEntityDaily_Relation.getSchema();
    }

    public RFLEntityDaily_Updater(RFLEntityDaily_Updater rFLEntityDaily_Updater) {
        super(rFLEntityDaily_Updater);
        this.f3671a = rFLEntityDaily_Updater.getSchema();
    }

    public RFLEntityDaily_Updater clone() {
        return new RFLEntityDaily_Updater(this);
    }

    public RFLEntityDaily_Updater data(@NonNull byte[] bArr) {
        this.contents.put("`data`", bArr);
        return this;
    }

    public RFLEntityDaily_Updater date(@NonNull String str) {
        this.contents.put("`date`", str);
        return this;
    }

    public RFLEntityDaily_Updater dateEq(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.date, "=", str);
    }

    public RFLEntityDaily_Updater dateGe(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.date, ">=", str);
    }

    public RFLEntityDaily_Updater dateGlob(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.date, "GLOB", str);
    }

    public RFLEntityDaily_Updater dateGt(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.date, ">", str);
    }

    public RFLEntityDaily_Updater dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Updater) mo19936in(false, this.f3671a.date, collection);
    }

    public final RFLEntityDaily_Updater dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Updater dateLe(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.date, "<=", str);
    }

    public RFLEntityDaily_Updater dateLike(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.date, "LIKE", str);
    }

    public RFLEntityDaily_Updater dateLt(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.date, "<", str);
    }

    public RFLEntityDaily_Updater dateNotEq(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.date, "<>", str);
    }

    public RFLEntityDaily_Updater dateNotGlob(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.date, "NOT GLOB", str);
    }

    public RFLEntityDaily_Updater dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Updater) mo19936in(true, this.f3671a.date, collection);
    }

    public final RFLEntityDaily_Updater dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Updater dateNotLike(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityDaily_Schema getSchema() {
        return this.f3671a;
    }

    public RFLEntityDaily_Updater timezone(@NonNull String str) {
        this.contents.put("`timezone`", str);
        return this;
    }

    public RFLEntityDaily_Updater timezoneEq(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.timezone, "=", str);
    }

    public RFLEntityDaily_Updater timezoneGe(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.timezone, ">=", str);
    }

    public RFLEntityDaily_Updater timezoneGlob(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.timezone, "GLOB", str);
    }

    public RFLEntityDaily_Updater timezoneGt(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.timezone, ">", str);
    }

    public RFLEntityDaily_Updater timezoneIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Updater) mo19936in(false, this.f3671a.timezone, collection);
    }

    public final RFLEntityDaily_Updater timezoneIn(@NonNull String... strArr) {
        return timezoneIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Updater timezoneLe(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.timezone, "<=", str);
    }

    public RFLEntityDaily_Updater timezoneLike(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.timezone, "LIKE", str);
    }

    public RFLEntityDaily_Updater timezoneLt(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.timezone, "<", str);
    }

    public RFLEntityDaily_Updater timezoneNotEq(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.timezone, "<>", str);
    }

    public RFLEntityDaily_Updater timezoneNotGlob(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.timezone, "NOT GLOB", str);
    }

    public RFLEntityDaily_Updater timezoneNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityDaily_Updater) mo19936in(true, this.f3671a.timezone, collection);
    }

    public final RFLEntityDaily_Updater timezoneNotIn(@NonNull String... strArr) {
        return timezoneNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityDaily_Updater timezoneNotLike(@NonNull String str) {
        return (RFLEntityDaily_Updater) where(this.f3671a.timezone, "NOT LIKE", str);
    }
}
