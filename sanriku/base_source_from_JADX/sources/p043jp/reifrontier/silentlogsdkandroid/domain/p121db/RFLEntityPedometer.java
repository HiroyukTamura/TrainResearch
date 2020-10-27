package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import kotlin.Metadata;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityPedometer;", "", "timestamp", "", "(J)V", "getTimestamp", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityPedometer */
public final class RFLEntityPedometer {

    /* renamed from: a */
    private final long f3686a;

    public RFLEntityPedometer(long j) {
        this.f3686a = j;
    }

    public static /* synthetic */ RFLEntityPedometer copy$default(RFLEntityPedometer rFLEntityPedometer, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = rFLEntityPedometer.f3686a;
        }
        return rFLEntityPedometer.copy(j);
    }

    public final long component1() {
        return this.f3686a;
    }

    public final RFLEntityPedometer copy(long j) {
        return new RFLEntityPedometer(j);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RFLEntityPedometer) && this.f3686a == ((RFLEntityPedometer) obj).f3686a;
        }
        return true;
    }

    public final long getTimestamp() {
        return this.f3686a;
    }

    public int hashCode() {
        return C0680d.m300a(this.f3686a);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLEntityPedometer(timestamp=");
        a.append(this.f3686a);
        a.append(")");
        return a.toString();
    }
}
