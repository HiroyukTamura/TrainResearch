package p043jp.reifrontier.gym.domain.api.train;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/train/RFGApiRealtime;", "", "trainNo", "", "stationId", "", "lat", "", "lon", "timestamp", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;)V", "getLat", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLon", "getStationId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTimestamp", "getTrainNo", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;)Ljp/reifrontier/gym/domain/api/train/RFGApiRealtime;", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.train.RFGApiRealtime */
public final class RFGApiRealtime {
    @SerializedName("lat")
    private final Double lat;
    @SerializedName("lon")
    private final Double lon;
    @SerializedName("station_no")
    private final Integer stationId;
    @SerializedName("timestamp")
    private final Integer timestamp;
    @SerializedName("train_id")
    private final String trainNo;

    public RFGApiRealtime(String str, Integer num, Double d, Double d2, Integer num2) {
        this.trainNo = str;
        this.stationId = num;
        this.lat = d;
        this.lon = d2;
        this.timestamp = num2;
    }

    public static /* synthetic */ RFGApiRealtime copy$default(RFGApiRealtime rFGApiRealtime, String str, Integer num, Double d, Double d2, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGApiRealtime.trainNo;
        }
        if ((i & 2) != 0) {
            num = rFGApiRealtime.stationId;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            d = rFGApiRealtime.lat;
        }
        Double d3 = d;
        if ((i & 8) != 0) {
            d2 = rFGApiRealtime.lon;
        }
        Double d4 = d2;
        if ((i & 16) != 0) {
            num2 = rFGApiRealtime.timestamp;
        }
        return rFGApiRealtime.copy(str, num3, d3, d4, num2);
    }

    public final String component1() {
        return this.trainNo;
    }

    public final Integer component2() {
        return this.stationId;
    }

    public final Double component3() {
        return this.lat;
    }

    public final Double component4() {
        return this.lon;
    }

    public final Integer component5() {
        return this.timestamp;
    }

    public final RFGApiRealtime copy(String str, Integer num, Double d, Double d2, Integer num2) {
        return new RFGApiRealtime(str, num, d, d2, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGApiRealtime)) {
            return false;
        }
        RFGApiRealtime rFGApiRealtime = (RFGApiRealtime) obj;
        return Intrinsics.areEqual((Object) this.trainNo, (Object) rFGApiRealtime.trainNo) && Intrinsics.areEqual((Object) this.stationId, (Object) rFGApiRealtime.stationId) && Intrinsics.areEqual((Object) this.lat, (Object) rFGApiRealtime.lat) && Intrinsics.areEqual((Object) this.lon, (Object) rFGApiRealtime.lon) && Intrinsics.areEqual((Object) this.timestamp, (Object) rFGApiRealtime.timestamp);
    }

    public final Double getLat() {
        return this.lat;
    }

    public final Double getLon() {
        return this.lon;
    }

    public final Integer getStationId() {
        return this.stationId;
    }

    public final Integer getTimestamp() {
        return this.timestamp;
    }

    public final String getTrainNo() {
        return this.trainNo;
    }

    public int hashCode() {
        String str = this.trainNo;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.stationId;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Double d = this.lat;
        int hashCode3 = (hashCode2 + (d != null ? d.hashCode() : 0)) * 31;
        Double d2 = this.lon;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Integer num2 = this.timestamp;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGApiRealtime(trainNo=");
        a.append(this.trainNo);
        a.append(", stationId=");
        a.append(this.stationId);
        a.append(", lat=");
        a.append(this.lat);
        a.append(", lon=");
        a.append(this.lon);
        a.append(", timestamp=");
        a.append(this.timestamp);
        a.append(")");
        return a.toString();
    }
}
