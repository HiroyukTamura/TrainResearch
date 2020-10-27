package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGPointHistory;", "", "point", "", "acquisitionPoints", "", "Ljp/reifrontier/gym/domain/api/RFGPoint;", "consumptionPoints", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getAcquisitionPoints", "()Ljava/util/List;", "getConsumptionPoints", "getPoint", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGPointHistory */
public final class RFGPointHistory {
    @SerializedName("acquisition_points")
    private final List<RFGPoint> acquisitionPoints;
    @SerializedName("consumption_points")
    private final List<RFGPoint> consumptionPoints;
    @SerializedName("point")
    private final String point;

    public RFGPointHistory(String str, List<RFGPoint> list, List<RFGPoint> list2) {
        Intrinsics.checkParameterIsNotNull(str, "point");
        Intrinsics.checkParameterIsNotNull(list, "acquisitionPoints");
        Intrinsics.checkParameterIsNotNull(list2, "consumptionPoints");
        this.point = str;
        this.acquisitionPoints = list;
        this.consumptionPoints = list2;
    }

    public static /* synthetic */ RFGPointHistory copy$default(RFGPointHistory rFGPointHistory, String str, List<RFGPoint> list, List<RFGPoint> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGPointHistory.point;
        }
        if ((i & 2) != 0) {
            list = rFGPointHistory.acquisitionPoints;
        }
        if ((i & 4) != 0) {
            list2 = rFGPointHistory.consumptionPoints;
        }
        return rFGPointHistory.copy(str, list, list2);
    }

    public final String component1() {
        return this.point;
    }

    public final List<RFGPoint> component2() {
        return this.acquisitionPoints;
    }

    public final List<RFGPoint> component3() {
        return this.consumptionPoints;
    }

    public final RFGPointHistory copy(String str, List<RFGPoint> list, List<RFGPoint> list2) {
        Intrinsics.checkParameterIsNotNull(str, "point");
        Intrinsics.checkParameterIsNotNull(list, "acquisitionPoints");
        Intrinsics.checkParameterIsNotNull(list2, "consumptionPoints");
        return new RFGPointHistory(str, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGPointHistory)) {
            return false;
        }
        RFGPointHistory rFGPointHistory = (RFGPointHistory) obj;
        return Intrinsics.areEqual((Object) this.point, (Object) rFGPointHistory.point) && Intrinsics.areEqual((Object) this.acquisitionPoints, (Object) rFGPointHistory.acquisitionPoints) && Intrinsics.areEqual((Object) this.consumptionPoints, (Object) rFGPointHistory.consumptionPoints);
    }

    public final List<RFGPoint> getAcquisitionPoints() {
        return this.acquisitionPoints;
    }

    public final List<RFGPoint> getConsumptionPoints() {
        return this.consumptionPoints;
    }

    public final String getPoint() {
        return this.point;
    }

    public int hashCode() {
        String str = this.point;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<RFGPoint> list = this.acquisitionPoints;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<RFGPoint> list2 = this.consumptionPoints;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGPointHistory(point=");
        a.append(this.point);
        a.append(", acquisitionPoints=");
        a.append(this.acquisitionPoints);
        a.append(", consumptionPoints=");
        return C0681a.m325a(a, (List) this.consumptionPoints, ")");
    }
}
