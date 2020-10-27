package p043jp.reifrontier.gym.data.bus;

import kotlin.Metadata;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo21739d2 = {"Ljp/reifrontier/gym/data/bus/RFGCompletedRemoveData;", "", "success", "", "(Z)V", "getSuccess", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.bus.RFGCompletedRemoveData */
public final class RFGCompletedRemoveData {
    private final boolean success;

    public RFGCompletedRemoveData(boolean z) {
        this.success = z;
    }

    public static /* synthetic */ RFGCompletedRemoveData copy$default(RFGCompletedRemoveData rFGCompletedRemoveData, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = rFGCompletedRemoveData.success;
        }
        return rFGCompletedRemoveData.copy(z);
    }

    public final boolean component1() {
        return this.success;
    }

    public final RFGCompletedRemoveData copy(boolean z) {
        return new RFGCompletedRemoveData(z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RFGCompletedRemoveData) && this.success == ((RFGCompletedRemoveData) obj).success;
        }
        return true;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        boolean z = this.success;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGCompletedRemoveData(success=");
        a.append(this.success);
        a.append(")");
        return a.toString();
    }
}
