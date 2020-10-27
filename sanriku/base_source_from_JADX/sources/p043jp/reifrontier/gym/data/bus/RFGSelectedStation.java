package p043jp.reifrontier.gym.data.bus;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.data.train.RFGStation;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo21739d2 = {"Ljp/reifrontier/gym/data/bus/RFGSelectedStation;", "", "station", "Ljp/reifrontier/gym/data/train/RFGStation;", "(Ljp/reifrontier/gym/data/train/RFGStation;)V", "getStation", "()Ljp/reifrontier/gym/data/train/RFGStation;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.bus.RFGSelectedStation */
public final class RFGSelectedStation {
    private final RFGStation station;

    public RFGSelectedStation(RFGStation rFGStation) {
        Intrinsics.checkParameterIsNotNull(rFGStation, "station");
        this.station = rFGStation;
    }

    public static /* synthetic */ RFGSelectedStation copy$default(RFGSelectedStation rFGSelectedStation, RFGStation rFGStation, int i, Object obj) {
        if ((i & 1) != 0) {
            rFGStation = rFGSelectedStation.station;
        }
        return rFGSelectedStation.copy(rFGStation);
    }

    public final RFGStation component1() {
        return this.station;
    }

    public final RFGSelectedStation copy(RFGStation rFGStation) {
        Intrinsics.checkParameterIsNotNull(rFGStation, "station");
        return new RFGSelectedStation(rFGStation);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RFGSelectedStation) && Intrinsics.areEqual((Object) this.station, (Object) ((RFGSelectedStation) obj).station);
        }
        return true;
    }

    public final RFGStation getStation() {
        return this.station;
    }

    public int hashCode() {
        RFGStation rFGStation = this.station;
        if (rFGStation != null) {
            return rFGStation.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGSelectedStation(station=");
        a.append(this.station);
        a.append(")");
        return a.toString();
    }
}
