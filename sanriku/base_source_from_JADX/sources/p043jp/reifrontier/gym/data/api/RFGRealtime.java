package p043jp.reifrontier.gym.data.api;

import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.domain.api.train.RFGApiOperation;
import p043jp.reifrontier.gym.domain.api.train.RFGApiRealtime;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001#B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGRealtime;", "", "trainNo", "", "stationId", "", "lat", "", "lon", "timestamp", "status", "Ljp/reifrontier/gym/data/api/RFGOperationStatus;", "(Ljava/lang/String;IDDILjp/reifrontier/gym/data/api/RFGOperationStatus;)V", "getLat", "()D", "getLon", "getStationId", "()I", "getStatus", "()Ljp/reifrontier/gym/data/api/RFGOperationStatus;", "getTimestamp", "getTrainNo", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "Builder", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGRealtime */
public final class RFGRealtime {
    private final double lat;
    private final double lon;
    private final int stationId;
    private final RFGOperationStatus status;
    private final int timestamp;
    private final String trainNo;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGRealtime$Builder;", "", "realTimeResponse", "Ljp/reifrontier/gym/domain/api/train/RFGApiRealtime;", "operationResponse", "", "Ljp/reifrontier/gym/domain/api/train/RFGApiOperation;", "(Ljp/reifrontier/gym/domain/api/train/RFGApiRealtime;Ljava/util/List;)V", "build", "Ljp/reifrontier/gym/data/api/RFGRealtime;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.api.RFGRealtime$Builder */
    public static final class Builder {
        private final List<RFGApiOperation> operationResponse;
        private final RFGApiRealtime realTimeResponse;

        public Builder(RFGApiRealtime rFGApiRealtime, List<RFGApiOperation> list) {
            Intrinsics.checkParameterIsNotNull(rFGApiRealtime, "realTimeResponse");
            Intrinsics.checkParameterIsNotNull(list, "operationResponse");
            this.realTimeResponse = rFGApiRealtime;
            this.operationResponse = list;
        }

        public final RFGRealtime build() {
            Integer stationId;
            String trainNo = this.realTimeResponse.getTrainNo();
            if (trainNo == null || (stationId = this.realTimeResponse.getStationId()) == null) {
                return null;
            }
            int intValue = stationId.intValue();
            Double lat = this.realTimeResponse.getLat();
            if (lat == null) {
                return null;
            }
            double doubleValue = lat.doubleValue();
            Double lon = this.realTimeResponse.getLon();
            if (lon == null) {
                return null;
            }
            double doubleValue2 = lon.doubleValue();
            Integer timestamp = this.realTimeResponse.getTimestamp();
            if (timestamp != null) {
                return new RFGRealtime(trainNo, intValue, doubleValue, doubleValue2, timestamp.intValue(), RFGOperationStatus.Companion.getType(trainNo, this.operationResponse));
            }
            return null;
        }
    }

    public RFGRealtime(String str, int i, double d, double d2, int i2, RFGOperationStatus rFGOperationStatus) {
        Intrinsics.checkParameterIsNotNull(str, "trainNo");
        Intrinsics.checkParameterIsNotNull(rFGOperationStatus, NotificationCompat.CATEGORY_STATUS);
        this.trainNo = str;
        this.stationId = i;
        this.lat = d;
        this.lon = d2;
        this.timestamp = i2;
        this.status = rFGOperationStatus;
    }

    public static /* synthetic */ RFGRealtime copy$default(RFGRealtime rFGRealtime, String str, int i, double d, double d2, int i2, RFGOperationStatus rFGOperationStatus, int i3, Object obj) {
        RFGRealtime rFGRealtime2 = rFGRealtime;
        return rFGRealtime.copy((i3 & 1) != 0 ? rFGRealtime2.trainNo : str, (i3 & 2) != 0 ? rFGRealtime2.stationId : i, (i3 & 4) != 0 ? rFGRealtime2.lat : d, (i3 & 8) != 0 ? rFGRealtime2.lon : d2, (i3 & 16) != 0 ? rFGRealtime2.timestamp : i2, (i3 & 32) != 0 ? rFGRealtime2.status : rFGOperationStatus);
    }

    public final String component1() {
        return this.trainNo;
    }

    public final int component2() {
        return this.stationId;
    }

    public final double component3() {
        return this.lat;
    }

    public final double component4() {
        return this.lon;
    }

    public final int component5() {
        return this.timestamp;
    }

    public final RFGOperationStatus component6() {
        return this.status;
    }

    public final RFGRealtime copy(String str, int i, double d, double d2, int i2, RFGOperationStatus rFGOperationStatus) {
        Intrinsics.checkParameterIsNotNull(str, "trainNo");
        RFGOperationStatus rFGOperationStatus2 = rFGOperationStatus;
        Intrinsics.checkParameterIsNotNull(rFGOperationStatus2, NotificationCompat.CATEGORY_STATUS);
        return new RFGRealtime(str, i, d, d2, i2, rFGOperationStatus2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGRealtime)) {
            return false;
        }
        RFGRealtime rFGRealtime = (RFGRealtime) obj;
        return Intrinsics.areEqual((Object) this.trainNo, (Object) rFGRealtime.trainNo) && this.stationId == rFGRealtime.stationId && Double.compare(this.lat, rFGRealtime.lat) == 0 && Double.compare(this.lon, rFGRealtime.lon) == 0 && this.timestamp == rFGRealtime.timestamp && Intrinsics.areEqual((Object) this.status, (Object) rFGRealtime.status);
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLon() {
        return this.lon;
    }

    public final int getStationId() {
        return this.stationId;
    }

    public final RFGOperationStatus getStatus() {
        return this.status;
    }

    public final int getTimestamp() {
        return this.timestamp;
    }

    public final String getTrainNo() {
        return this.trainNo;
    }

    public int hashCode() {
        String str = this.trainNo;
        int i = 0;
        int hashCode = (((((((((str != null ? str.hashCode() : 0) * 31) + this.stationId) * 31) + Double.doubleToLongBits(this.lat)) * 31) + Double.doubleToLongBits(this.lon)) * 31) + this.timestamp) * 31;
        RFGOperationStatus rFGOperationStatus = this.status;
        if (rFGOperationStatus != null) {
            i = rFGOperationStatus.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGRealtime(trainNo=");
        a.append(this.trainNo);
        a.append(", stationId=");
        a.append(this.stationId);
        a.append(", lat=");
        a.append(this.lat);
        a.append(", lon=");
        a.append(this.lon);
        a.append(", timestamp=");
        a.append(this.timestamp);
        a.append(", status=");
        a.append(this.status);
        a.append(")");
        return a.toString();
    }
}
