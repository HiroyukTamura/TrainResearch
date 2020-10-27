package p043jp.reifrontier.gym.p044ui.viewModel;

import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.RFGDef;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003JU\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0013\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/viewModel/RFGTrainDetail;", "", "trainNo", "", "trainType", "Ljp/reifrontier/gym/RFGDef$TrainType;", "departure", "departureTime", "Ljava/util/Calendar;", "endStationName", "stopHoliday", "", "transferList", "", "Ljp/reifrontier/gym/ui/viewModel/RFGTransfer;", "(Ljava/lang/String;Ljp/reifrontier/gym/RFGDef$TrainType;Ljava/lang/String;Ljava/util/Calendar;Ljava/lang/String;ZLjava/util/List;)V", "getDeparture", "()Ljava/lang/String;", "getDepartureTime", "()Ljava/util/Calendar;", "getEndStationName", "getStopHoliday", "()Z", "getTrainNo", "getTrainType", "()Ljp/reifrontier/gym/RFGDef$TrainType;", "getTransferList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.viewModel.RFGTrainDetail */
public final class RFGTrainDetail {
    private final String departure;
    private final Calendar departureTime;
    private final String endStationName;
    private final boolean stopHoliday;
    private final String trainNo;
    private final RFGDef.TrainType trainType;
    private final List<RFGTransfer> transferList;

    public RFGTrainDetail(String str, RFGDef.TrainType trainType2, String str2, Calendar calendar, String str3, boolean z, List<RFGTransfer> list) {
        Intrinsics.checkParameterIsNotNull(str, "trainNo");
        Intrinsics.checkParameterIsNotNull(trainType2, "trainType");
        Intrinsics.checkParameterIsNotNull(str2, "departure");
        Intrinsics.checkParameterIsNotNull(calendar, "departureTime");
        Intrinsics.checkParameterIsNotNull(str3, "endStationName");
        Intrinsics.checkParameterIsNotNull(list, "transferList");
        this.trainNo = str;
        this.trainType = trainType2;
        this.departure = str2;
        this.departureTime = calendar;
        this.endStationName = str3;
        this.stopHoliday = z;
        this.transferList = list;
    }

    public static /* synthetic */ RFGTrainDetail copy$default(RFGTrainDetail rFGTrainDetail, String str, RFGDef.TrainType trainType2, String str2, Calendar calendar, String str3, boolean z, List<RFGTransfer> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGTrainDetail.trainNo;
        }
        if ((i & 2) != 0) {
            trainType2 = rFGTrainDetail.trainType;
        }
        RFGDef.TrainType trainType3 = trainType2;
        if ((i & 4) != 0) {
            str2 = rFGTrainDetail.departure;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            calendar = rFGTrainDetail.departureTime;
        }
        Calendar calendar2 = calendar;
        if ((i & 16) != 0) {
            str3 = rFGTrainDetail.endStationName;
        }
        String str5 = str3;
        if ((i & 32) != 0) {
            z = rFGTrainDetail.stopHoliday;
        }
        boolean z2 = z;
        if ((i & 64) != 0) {
            list = rFGTrainDetail.transferList;
        }
        return rFGTrainDetail.copy(str, trainType3, str4, calendar2, str5, z2, list);
    }

    public final String component1() {
        return this.trainNo;
    }

    public final RFGDef.TrainType component2() {
        return this.trainType;
    }

    public final String component3() {
        return this.departure;
    }

    public final Calendar component4() {
        return this.departureTime;
    }

    public final String component5() {
        return this.endStationName;
    }

    public final boolean component6() {
        return this.stopHoliday;
    }

    public final List<RFGTransfer> component7() {
        return this.transferList;
    }

    public final RFGTrainDetail copy(String str, RFGDef.TrainType trainType2, String str2, Calendar calendar, String str3, boolean z, List<RFGTransfer> list) {
        Intrinsics.checkParameterIsNotNull(str, "trainNo");
        Intrinsics.checkParameterIsNotNull(trainType2, "trainType");
        Intrinsics.checkParameterIsNotNull(str2, "departure");
        Intrinsics.checkParameterIsNotNull(calendar, "departureTime");
        Intrinsics.checkParameterIsNotNull(str3, "endStationName");
        List<RFGTransfer> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "transferList");
        return new RFGTrainDetail(str, trainType2, str2, calendar, str3, z, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGTrainDetail)) {
            return false;
        }
        RFGTrainDetail rFGTrainDetail = (RFGTrainDetail) obj;
        return Intrinsics.areEqual((Object) this.trainNo, (Object) rFGTrainDetail.trainNo) && Intrinsics.areEqual((Object) this.trainType, (Object) rFGTrainDetail.trainType) && Intrinsics.areEqual((Object) this.departure, (Object) rFGTrainDetail.departure) && Intrinsics.areEqual((Object) this.departureTime, (Object) rFGTrainDetail.departureTime) && Intrinsics.areEqual((Object) this.endStationName, (Object) rFGTrainDetail.endStationName) && this.stopHoliday == rFGTrainDetail.stopHoliday && Intrinsics.areEqual((Object) this.transferList, (Object) rFGTrainDetail.transferList);
    }

    public final String getDeparture() {
        return this.departure;
    }

    public final Calendar getDepartureTime() {
        return this.departureTime;
    }

    public final String getEndStationName() {
        return this.endStationName;
    }

    public final boolean getStopHoliday() {
        return this.stopHoliday;
    }

    public final String getTrainNo() {
        return this.trainNo;
    }

    public final RFGDef.TrainType getTrainType() {
        return this.trainType;
    }

    public final List<RFGTransfer> getTransferList() {
        return this.transferList;
    }

    public int hashCode() {
        String str = this.trainNo;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        RFGDef.TrainType trainType2 = this.trainType;
        int hashCode2 = (hashCode + (trainType2 != null ? trainType2.hashCode() : 0)) * 31;
        String str2 = this.departure;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Calendar calendar = this.departureTime;
        int hashCode4 = (hashCode3 + (calendar != null ? calendar.hashCode() : 0)) * 31;
        String str3 = this.endStationName;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.stopHoliday;
        if (z) {
            z = true;
        }
        int i2 = (hashCode5 + (z ? 1 : 0)) * 31;
        List<RFGTransfer> list = this.transferList;
        if (list != null) {
            i = list.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGTrainDetail(trainNo=");
        a.append(this.trainNo);
        a.append(", trainType=");
        a.append(this.trainType);
        a.append(", departure=");
        a.append(this.departure);
        a.append(", departureTime=");
        a.append(this.departureTime);
        a.append(", endStationName=");
        a.append(this.endStationName);
        a.append(", stopHoliday=");
        a.append(this.stopHoliday);
        a.append(", transferList=");
        return C0681a.m325a(a, (List) this.transferList, ")");
    }
}
