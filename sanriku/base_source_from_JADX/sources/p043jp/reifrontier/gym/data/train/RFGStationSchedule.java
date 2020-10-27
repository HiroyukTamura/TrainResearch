package p043jp.reifrontier.gym.data.train;

import com.google.gson.annotations.SerializedName;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.util.CalendarEx;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\n¨\u0006\u001f"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/RFGStationSchedule;", "", "trainNo", "", "arrival", "departure", "stopHoliday", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getArrival", "()Ljava/lang/String;", "arrivalTime", "Ljava/util/Calendar;", "getArrivalTime", "()Ljava/util/Calendar;", "getDeparture", "departureTime", "getDepartureTime", "getStopHoliday", "()Z", "getTrainNo", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.RFGStationSchedule */
public final class RFGStationSchedule {
    @SerializedName("arrival")
    private final String arrival;
    @SerializedName("departure")
    private final String departure;
    @SerializedName("stop_holiday")
    private final boolean stopHoliday;
    @SerializedName("train_no")
    private final String trainNo;

    public RFGStationSchedule(String str, String str2, String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "trainNo");
        Intrinsics.checkParameterIsNotNull(str2, "arrival");
        Intrinsics.checkParameterIsNotNull(str3, "departure");
        this.trainNo = str;
        this.arrival = str2;
        this.departure = str3;
        this.stopHoliday = z;
    }

    public static /* synthetic */ RFGStationSchedule copy$default(RFGStationSchedule rFGStationSchedule, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGStationSchedule.trainNo;
        }
        if ((i & 2) != 0) {
            str2 = rFGStationSchedule.arrival;
        }
        if ((i & 4) != 0) {
            str3 = rFGStationSchedule.departure;
        }
        if ((i & 8) != 0) {
            z = rFGStationSchedule.stopHoliday;
        }
        return rFGStationSchedule.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.trainNo;
    }

    public final String component2() {
        return this.arrival;
    }

    public final String component3() {
        return this.departure;
    }

    public final boolean component4() {
        return this.stopHoliday;
    }

    public final RFGStationSchedule copy(String str, String str2, String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "trainNo");
        Intrinsics.checkParameterIsNotNull(str2, "arrival");
        Intrinsics.checkParameterIsNotNull(str3, "departure");
        return new RFGStationSchedule(str, str2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGStationSchedule)) {
            return false;
        }
        RFGStationSchedule rFGStationSchedule = (RFGStationSchedule) obj;
        return Intrinsics.areEqual((Object) this.trainNo, (Object) rFGStationSchedule.trainNo) && Intrinsics.areEqual((Object) this.arrival, (Object) rFGStationSchedule.arrival) && Intrinsics.areEqual((Object) this.departure, (Object) rFGStationSchedule.departure) && this.stopHoliday == rFGStationSchedule.stopHoliday;
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

    public final boolean getStopHoliday() {
        return this.stopHoliday;
    }

    public final String getTrainNo() {
        return this.trainNo;
    }

    public int hashCode() {
        String str = this.trainNo;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.arrival;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.departure;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.stopHoliday;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGStationSchedule(trainNo=");
        a.append(this.trainNo);
        a.append(", arrival=");
        a.append(this.arrival);
        a.append(", departure=");
        a.append(this.departure);
        a.append(", stopHoliday=");
        a.append(this.stopHoliday);
        a.append(")");
        return a.toString();
    }
}
