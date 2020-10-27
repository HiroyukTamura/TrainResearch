package p043jp.reifrontier.gym.p044ui.viewModel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/viewModel/RFGTransfer;", "", "stationId", "", "stationName", "", "arrival", "(ILjava/lang/String;Ljava/lang/String;)V", "getArrival", "()Ljava/lang/String;", "getStationId", "()I", "getStationName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.viewModel.RFGTransfer */
public final class RFGTransfer {
    private final String arrival;
    private final int stationId;
    private final String stationName;

    public RFGTransfer(int i, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "stationName");
        Intrinsics.checkParameterIsNotNull(str2, "arrival");
        this.stationId = i;
        this.stationName = str;
        this.arrival = str2;
    }

    public static /* synthetic */ RFGTransfer copy$default(RFGTransfer rFGTransfer, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = rFGTransfer.stationId;
        }
        if ((i2 & 2) != 0) {
            str = rFGTransfer.stationName;
        }
        if ((i2 & 4) != 0) {
            str2 = rFGTransfer.arrival;
        }
        return rFGTransfer.copy(i, str, str2);
    }

    public final int component1() {
        return this.stationId;
    }

    public final String component2() {
        return this.stationName;
    }

    public final String component3() {
        return this.arrival;
    }

    public final RFGTransfer copy(int i, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "stationName");
        Intrinsics.checkParameterIsNotNull(str2, "arrival");
        return new RFGTransfer(i, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGTransfer)) {
            return false;
        }
        RFGTransfer rFGTransfer = (RFGTransfer) obj;
        return this.stationId == rFGTransfer.stationId && Intrinsics.areEqual((Object) this.stationName, (Object) rFGTransfer.stationName) && Intrinsics.areEqual((Object) this.arrival, (Object) rFGTransfer.arrival);
    }

    public final String getArrival() {
        return this.arrival;
    }

    public final int getStationId() {
        return this.stationId;
    }

    public final String getStationName() {
        return this.stationName;
    }

    public int hashCode() {
        int i = this.stationId * 31;
        String str = this.stationName;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.arrival;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGTransfer(stationId=");
        a.append(this.stationId);
        a.append(", stationName=");
        a.append(this.stationName);
        a.append(", arrival=");
        return C0681a.m324a(a, this.arrival, ")");
    }
}
