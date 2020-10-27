package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.p027t.C0852b;
import p009e.p015c.p016a.p017a.p018a.p027t.C0855d;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityPedometer_Deleter */
public class RFLEntityPedometer_Deleter extends C0852b<RFLEntityPedometer, RFLEntityPedometer_Deleter> {

    /* renamed from: a */
    final RFLEntityPedometer_Schema f3688a;

    public RFLEntityPedometer_Deleter(C0855d dVar, RFLEntityPedometer_Schema rFLEntityPedometer_Schema) {
        super((C0700h) dVar);
        this.f3688a = rFLEntityPedometer_Schema;
    }

    public RFLEntityPedometer_Deleter(RFLEntityPedometer_Deleter rFLEntityPedometer_Deleter) {
        super(rFLEntityPedometer_Deleter);
        this.f3688a = rFLEntityPedometer_Deleter.getSchema();
    }

    public RFLEntityPedometer_Deleter(RFLEntityPedometer_Relation rFLEntityPedometer_Relation) {
        super(rFLEntityPedometer_Relation);
        this.f3688a = rFLEntityPedometer_Relation.getSchema();
    }

    public RFLEntityPedometer_Deleter clone() {
        return new RFLEntityPedometer_Deleter(this);
    }

    @NonNull
    public RFLEntityPedometer_Schema getSchema() {
        return this.f3688a;
    }

    public RFLEntityPedometer_Deleter timestampBetween(long j, long j2) {
        return (RFLEntityPedometer_Deleter) whereBetween(this.f3688a.timestamp, Long.valueOf(j), Long.valueOf(j2));
    }

    public RFLEntityPedometer_Deleter timestampEq(long j) {
        return (RFLEntityPedometer_Deleter) where(this.f3688a.timestamp, "=", Long.valueOf(j));
    }

    public RFLEntityPedometer_Deleter timestampGe(long j) {
        return (RFLEntityPedometer_Deleter) where(this.f3688a.timestamp, ">=", Long.valueOf(j));
    }

    public RFLEntityPedometer_Deleter timestampGt(long j) {
        return (RFLEntityPedometer_Deleter) where(this.f3688a.timestamp, ">", Long.valueOf(j));
    }

    public RFLEntityPedometer_Deleter timestampIn(@NonNull Collection<Long> collection) {
        return (RFLEntityPedometer_Deleter) mo19936in(false, this.f3688a.timestamp, collection);
    }

    public final RFLEntityPedometer_Deleter timestampIn(@NonNull Long... lArr) {
        return timestampIn((Collection<Long>) Arrays.asList(lArr));
    }

    public RFLEntityPedometer_Deleter timestampLe(long j) {
        return (RFLEntityPedometer_Deleter) where(this.f3688a.timestamp, "<=", Long.valueOf(j));
    }

    public RFLEntityPedometer_Deleter timestampLt(long j) {
        return (RFLEntityPedometer_Deleter) where(this.f3688a.timestamp, "<", Long.valueOf(j));
    }

    public RFLEntityPedometer_Deleter timestampNotEq(long j) {
        return (RFLEntityPedometer_Deleter) where(this.f3688a.timestamp, "<>", Long.valueOf(j));
    }

    public RFLEntityPedometer_Deleter timestampNotIn(@NonNull Collection<Long> collection) {
        return (RFLEntityPedometer_Deleter) mo19936in(true, this.f3688a.timestamp, collection);
    }

    public final RFLEntityPedometer_Deleter timestampNotIn(@NonNull Long... lArr) {
        return timestampNotIn((Collection<Long>) Arrays.asList(lArr));
    }
}
