package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0869g;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTrackPoint_Updater */
public class RFLEntityTrackPoint_Updater extends C0869g<RFLEntityTrackPoint, RFLEntityTrackPoint_Updater> {

    /* renamed from: a */
    final RFLEntityTrackPoint_Schema f3725a;

    public RFLEntityTrackPoint_Updater(C0855d dVar, RFLEntityTrackPoint_Schema rFLEntityTrackPoint_Schema) {
        super((C0700h) dVar);
        this.f3725a = rFLEntityTrackPoint_Schema;
    }

    public RFLEntityTrackPoint_Updater(RFLEntityTrackPoint_Relation rFLEntityTrackPoint_Relation) {
        super(rFLEntityTrackPoint_Relation);
        this.f3725a = rFLEntityTrackPoint_Relation.getSchema();
    }

    public RFLEntityTrackPoint_Updater(RFLEntityTrackPoint_Updater rFLEntityTrackPoint_Updater) {
        super(rFLEntityTrackPoint_Updater);
        this.f3725a = rFLEntityTrackPoint_Updater.getSchema();
    }

    public RFLEntityTrackPoint_Updater clone() {
        return new RFLEntityTrackPoint_Updater(this);
    }

    public RFLEntityTrackPoint_Updater data(@NonNull byte[] bArr) {
        this.contents.put("`data`", bArr);
        return this;
    }

    public RFLEntityTrackPoint_Updater date(@NonNull String str) {
        this.contents.put("`date`", str);
        return this;
    }

    public RFLEntityTrackPoint_Updater dateEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.date, "=", str);
    }

    public RFLEntityTrackPoint_Updater dateGe(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.date, ">=", str);
    }

    public RFLEntityTrackPoint_Updater dateGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.date, "GLOB", str);
    }

    public RFLEntityTrackPoint_Updater dateGt(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.date, ">", str);
    }

    public RFLEntityTrackPoint_Updater dateIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Updater) mo19936in(false, this.f3725a.date, collection);
    }

    public final RFLEntityTrackPoint_Updater dateIn(@NonNull String... strArr) {
        return dateIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Updater dateLe(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.date, "<=", str);
    }

    public RFLEntityTrackPoint_Updater dateLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.date, "LIKE", str);
    }

    public RFLEntityTrackPoint_Updater dateLt(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.date, "<", str);
    }

    public RFLEntityTrackPoint_Updater dateNotEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.date, "<>", str);
    }

    public RFLEntityTrackPoint_Updater dateNotGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.date, "NOT GLOB", str);
    }

    public RFLEntityTrackPoint_Updater dateNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Updater) mo19936in(true, this.f3725a.date, collection);
    }

    public final RFLEntityTrackPoint_Updater dateNotIn(@NonNull String... strArr) {
        return dateNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Updater dateNotLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.date, "NOT LIKE", str);
    }

    @NonNull
    public RFLEntityTrackPoint_Schema getSchema() {
        return this.f3725a;
    }

    public RFLEntityTrackPoint_Updater timezone(@NonNull String str) {
        this.contents.put("`timezone`", str);
        return this;
    }

    public RFLEntityTrackPoint_Updater timezoneEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.timezone, "=", str);
    }

    public RFLEntityTrackPoint_Updater timezoneGe(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.timezone, ">=", str);
    }

    public RFLEntityTrackPoint_Updater timezoneGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.timezone, "GLOB", str);
    }

    public RFLEntityTrackPoint_Updater timezoneGt(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.timezone, ">", str);
    }

    public RFLEntityTrackPoint_Updater timezoneIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Updater) mo19936in(false, this.f3725a.timezone, collection);
    }

    public final RFLEntityTrackPoint_Updater timezoneIn(@NonNull String... strArr) {
        return timezoneIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Updater timezoneLe(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.timezone, "<=", str);
    }

    public RFLEntityTrackPoint_Updater timezoneLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.timezone, "LIKE", str);
    }

    public RFLEntityTrackPoint_Updater timezoneLt(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.timezone, "<", str);
    }

    public RFLEntityTrackPoint_Updater timezoneNotEq(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.timezone, "<>", str);
    }

    public RFLEntityTrackPoint_Updater timezoneNotGlob(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.timezone, "NOT GLOB", str);
    }

    public RFLEntityTrackPoint_Updater timezoneNotIn(@NonNull Collection<String> collection) {
        return (RFLEntityTrackPoint_Updater) mo19936in(true, this.f3725a.timezone, collection);
    }

    public final RFLEntityTrackPoint_Updater timezoneNotIn(@NonNull String... strArr) {
        return timezoneNotIn((Collection<String>) Arrays.asList(strArr));
    }

    public RFLEntityTrackPoint_Updater timezoneNotLike(@NonNull String str) {
        return (RFLEntityTrackPoint_Updater) where(this.f3725a.timezone, "NOT LIKE", str);
    }
}
