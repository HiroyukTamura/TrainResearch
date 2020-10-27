package p043jp.reifrontier.gym.data.train;

import com.google.gson.annotations.SerializedName;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.util.CalendarEx;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/RFGTrainSchedule;", "", "stationId", "", "arrival", "", "departure", "(ILjava/lang/String;Ljava/lang/String;)V", "getArrival", "()Ljava/lang/String;", "arrivalTime", "Ljava/util/Calendar;", "getArrivalTime", "()Ljava/util/Calendar;", "getDeparture", "departureTime", "getDepartureTime", "getStationId", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.RFGTrainSchedule */
public final class RFGTrainSchedule {
    @SerializedName("arrival")
    private final String arrival;
    @SerializedName("departure")
    private final String departure;
    @SerializedName("station_id")
    private final int stationId;

    public RFGTrainSchedule(int i, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "arrival");
        Intrinsics.checkParameterIsNotNull(str2, "departure");
        this.stationId = i;
        this.arrival = str;
        this.departure = str2;
    }

    public static /* synthetic */ RFGTrainSchedule copy$default(RFGTrainSchedule rFGTrainSchedule, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = rFGTrainSchedule.stationId;
        }
        if ((i2 & 2) != 0) {
            str = rFGTrainSchedule.arrival;
        }
        if ((i2 & 4) != 0) {
            str2 = rFGTrainSchedule.departure;
        }
        return rFGTrainSchedule.copy(i, str, str2);
    }

    public final int component1() {
        return this.stationId;
    }

    public final String component2() {
        return this.arrival;
    }

    public final String component3() {
        return this.departure;
    }

    public final RFGTrainSchedule copy(int i, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "arrival");
        Intrinsics.checkParameterIsNotNull(str2, "departure");
        return new RFGTrainSchedule(i, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGTrainSchedule)) {
            return false;
        }
        RFGTrainSchedule rFGTrainSchedule = (RFGTrainSchedule) obj;
        return this.stationId == rFGTrainSchedule.stationId && Intrinsics.areEqual((Object) this.arrival, (Object) rFGTrainSchedule.arrival) && Intrinsics.areEqual((Object) this.departure, (Object) rFGTrainSchedule.departure);
    }

    public final String getArrival() {
        return this.arrival;
    }

    public final Calendar getArrivalTime() {
        return CalendarEx.INSTANCE.parseTime(this.arrival, "H:mm");
    }

    public final String getDeparture() {
        return this.departure;
    }

    public final Calendar getDepartureTime() {
        return CalendarEx.INSTANCE.parseTime(this.departure, "H:mm");
    }

    public final int getStationId() {
        return this.stationId;
    }

    public int hashCode() {
        int i = this.stationId * 31;
        String str = this.arrival;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.departure;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGTrainSchedule(stationId=");
        a.append(this.stationId);
        a.append(", arrival=");
        a.append(this.arrival);
        a.append(", departure=");
        return C0681a.m324a(a, this.departure, ")");
    }
}
