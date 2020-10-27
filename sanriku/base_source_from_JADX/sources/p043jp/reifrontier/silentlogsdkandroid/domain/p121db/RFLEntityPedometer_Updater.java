package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;
import p009e.p015c.p016a.p017a.p018a.p027t.C0869g;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityPedometer_Updater */
public class RFLEntityPedometer_Updater extends C0869g<RFLEntityPedometer, RFLEntityPedometer_Updater> {

    /* renamed from: a */
    final RFLEntityPedometer_Schema f3693a;

    public RFLEntityPedometer_Updater(C0855d dVar, RFLEntityPedometer_Schema rFLEntityPedometer_Schema) {
        super((C0700h) dVar);
        this.f3693a = rFLEntityPedometer_Schema;
    }

    public RFLEntityPedometer_Updater(RFLEntityPedometer_Relation rFLEntityPedometer_Relation) {
        super(rFLEntityPedometer_Relation);
        this.f3693a = rFLEntityPedometer_Relation.getSchema();
    }

    public RFLEntityPedometer_Updater(RFLEntityPedometer_Updater rFLEntityPedometer_Updater) {
        super(rFLEntityPedometer_Updater);
        this.f3693a = rFLEntityPedometer_Updater.getSchema();
    }

    public RFLEntityPedometer_Updater clone() {
        return new RFLEntityPedometer_Updater(this);
    }

    @NonNull
    public RFLEntityPedometer_Schema getSchema() {
        return this.f3693a;
    }

    public RFLEntityPedometer_Updater timestamp(long j) {
        this.contents.put("`timestamp`", Long.valueOf(j));
        return this;
    }

    public RFLEntityPedometer_Updater timestampBetween(long j, long j2) {
        return (RFLEntityPedometer_Updater) whereBetween(this.f3693a.timestamp, Long.valueOf(j), Long.valueOf(j2));
    }

    public RFLEntityPedometer_Updater timestampEq(long j) {
        return (RFLEntityPedometer_Updater) where(this.f3693a.timestamp, "=", Long.valueOf(j));
    }

    public RFLEntityPedometer_Updater timestampGe(long j) {
        return (RFLEntityPedometer_Updater) where(this.f3693a.timestamp, ">=", Long.valueOf(j));
    }

    public RFLEntityPedometer_Updater timestampGt(long j) {
        return (RFLEntityPedometer_Updater) where(this.f3693a.timestamp, ">", Long.valueOf(j));
    }

    public RFLEntityPedometer_Updater timestampIn(@NonNull Collection<Long> collection) {
        return (RFLEntityPedometer_Updater) mo19936in(false, this.f3693a.timestamp, collection);
    }

    public final RFLEntityPedometer_Updater timestampIn(@NonNull Long... lArr) {
        return timestampIn((Collection<Long>) Arrays.asList(lArr));
    }

    public RFLEntityPedometer_Updater timestampLe(long j) {
        return (RFLEntityPedometer_Updater) where(this.f3693a.timestamp, "<=", Long.valueOf(j));
    }

    public RFLEntityPedometer_Updater timestampLt(long j) {
        return (RFLEntityPedometer_Updater) where(this.f3693a.timestamp, "<", Long.valueOf(j));
    }

    public RFLEntityPedometer_Updater timestampNotEq(long j) {
        return (RFLEntityPedometer_Updater) where(this.f3693a.timestamp, "<>", Long.valueOf(j));
    }

    public RFLEntityPedometer_Updater timestampNotIn(@NonNull Collection<Long> collection) {
        return (RFLEntityPedometer_Updater) mo19936in(true, this.f3693a.timestamp, collection);
    }

    public final RFLEntityPedometer_Updater timestampNotIn(@NonNull Long... lArr) {
        return timestampNotIn((Collection<Long>) Arrays.asList(lArr));
    }
}
