package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0869g;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityActivity_Updater */
public class RFLEntityActivity_Updater extends C0869g<RFLEntityActivity, RFLEntityActivity_Updater> {

    /* renamed from: a */
    final RFLEntityActivity_Schema f3630a;

    public RFLEntityActivity_Updater(C0855d dVar, RFLEntityActivity_Schema rFLEntityActivity_Schema) {
        super((C0700h) dVar);
        this.f3630a = rFLEntityActivity_Schema;
    }

    public RFLEntityActivity_Updater(RFLEntityActivity_Relation rFLEntityActivity_Relation) {
        super(rFLEntityActivity_Relation);
        this.f3630a = rFLEntityActivity_Relation.getSchema();
    }

    public RFLEntityActivity_Updater(RFLEntityActivity_Updater rFLEntityActivity_Updater) {
        super(rFLEntityActivity_Updater);
        this.f3630a = rFLEntityActivity_Updater.getSchema();
    }

    public RFLEntityActivity_Updater clone() {
        return new RFLEntityActivity_Updater(this);
    }

    public RFLEntityActivity_Updater data(@NonNull byte[] bArr) {
        this.contents.put("`data`", bArr);
        return this;
    }

    public RFLEntityActivity_Updater date(@NonNull String str) {
        this.contents.put("`date`", str);
        return this;
    }

    public RFLEntityActivity_Updater dateEq(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.date, "=", str);
    }

    public RFLEntityActivity_Updater dateGe(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.date, ">=", str);
    }

    public RFLEntityActivity_Updater dateGlob(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.date, "GLOB", str);
    }

    public RFLEntityActivity_Updater dateGt(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.date, ">", str);
    }

    public RFLEntityActivity_Updater dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Updater) mo19936in(false, this.f3630a.date, collection);
    }

    public final RFLEntityActivity_Updater dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Updater dateLe(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.date, "<=", str);
    }

    public RFLEntityActivity_Updater dateLike(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.date, "LIKE", str);
    }

    public RFLEntityActivity_Updater dateLt(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.date, "<", str);
    }

    public RFLEntityActivity_Updater dateNotEq(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.date, "<>", str);
    }

    public RFLEntityActivity_Updater dateNotGlob(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.date, "NOT GLOB", str);
    }

    public RFLEntityActivity_Updater dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Updater) mo19936in(true, this.f3630a.date, collection);
    }

    public final RFLEntityActivity_Updater dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Updater dateNotLike(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityActivity_Schema getSchema() {
        return this.f3630a;
    }

    public RFLEntityActivity_Updater timezone(@NonNull String str) {
        this.contents.put("`timezone`", str);
        return this;
    }

    public RFLEntityActivity_Updater timezoneEq(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.timezone, "=", str);
    }

    public RFLEntityActivity_Updater timezoneGe(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.timezone, ">=", str);
    }

    public RFLEntityActivity_Updater timezoneGlob(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.timezone, "GLOB", str);
    }

    public RFLEntityActivity_Updater timezoneGt(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.timezone, ">", str);
    }

    public RFLEntityActivity_Updater timezoneIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Updater) mo19936in(false, this.f3630a.timezone, collection);
    }

    public final RFLEntityActivity_Updater timezoneIn(@NonNull String... strArr) {
        return timezoneIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Updater timezoneLe(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.timezone, "<=", str);
    }

    public RFLEntityActivity_Updater timezoneLike(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.timezone, "LIKE", str);
    }

    public RFLEntityActivity_Updater timezoneLt(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.timezone, "<", str);
    }

    public RFLEntityActivity_Updater timezoneNotEq(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.timezone, "<>", str);
    }

    public RFLEntityActivity_Updater timezoneNotGlob(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.timezone, "NOT GLOB", str);
    }

    public RFLEntityActivity_Updater timezoneNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityActivity_Updater) mo19936in(true, this.f3630a.timezone, collection);
    }

    public final RFLEntityActivity_Updater timezoneNotIn(@NonNull String... strArr) {
        return timezoneNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityActivity_Updater timezoneNotLike(@NonNull String str) {
        return (RFLEntityActivity_Updater) where(this.f3630a.timezone, "NOT LIKE", str);
    }
}
