package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGUserPoint;", "", "point", "", "(I)V", "isCanLottery", "", "()Z", "getPoint", "()I", "component1", "copy", "equals", "other", "hashCode", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGUserPoint */
public final class RFGUserPoint {
    @SerializedName("point")
    private final int point;

    public RFGUserPoint(int i) {
        this.point = i;
    }

    public static /* synthetic */ RFGUserPoint copy$default(RFGUserPoint rFGUserPoint, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = rFGUserPoint.point;
        }
        return rFGUserPoint.copy(i);
    }

    public final int component1() {
        return this.point;
    }

    public final RFGUserPoint copy(int i) {
        return new RFGUserPoint(i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RFGUserPoint) && this.point == ((RFGUserPoint) obj).point;
        }
        return true;
    }

    public final int getPoint() {
        return this.point;
    }

    public int hashCode() {
        return this.point;
    }

    public final boolean isCanLottery() {
        return this.point > 2999;
    }

    public String toString() {
        return C0681a.m322a(C0681a.m330a("RFGUserPoint(point="), this.point, ")");
    }
}
