package p043jp.reifrontier.gym.p044ui.viewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.data.train.RFGStation;
import p043jp.reifrontier.gym.data.train.RFGStationSchedule;
import p043jp.reifrontier.gym.data.train.RFGTrain;
import p043jp.reifrontier.gym.data.train.RFGTrainData;
import p043jp.reifrontier.gym.data.train.RFGTrainSchedule;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001\u0019B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/viewModel/RFGStationDetail;", "", "stationId", "", "stationName", "", "scheduleList", "", "Ljp/reifrontier/gym/ui/viewModel/RFGTrainDetail;", "(ILjava/lang/String;Ljava/util/List;)V", "getScheduleList", "()Ljava/util/List;", "getStationId", "()I", "getStationName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Builder", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.viewModel.RFGStationDetail */
public final class RFGStationDetail {
    private final List<RFGTrainDetail> scheduleList;
    private final int stationId;
    private final String stationName;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/viewModel/RFGStationDetail$Builder;", "", "station", "Ljp/reifrontier/gym/data/train/RFGStation;", "(Ljp/reifrontier/gym/data/train/RFGStation;)V", "build", "Ljp/reifrontier/gym/ui/viewModel/RFGStationDetail;", "createTrainDetail", "Ljp/reifrontier/gym/ui/viewModel/RFGTrainDetail;", "targetStationId", "", "stationSchedule", "Ljp/reifrontier/gym/data/train/RFGStationSchedule;", "isVisibleTransfer", "", "transferStationId", "trainType", "Ljp/reifrontier/gym/RFGDef$TrainType;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.viewModel.RFGStationDetail$Builder */
    public static final class Builder {
        private final RFGStation station;

        public Builder(RFGStation rFGStation) {
            Intrinsics.checkParameterIsNotNull(rFGStation, "station");
            this.station = rFGStation;
        }

        private final RFGTrainDetail createTrainDetail(int i, RFGStationSchedule rFGStationSchedule) {
            T t;
            String name;
            T t2;
            boolean z;
            boolean z2;
            int i2 = i;
            RFGTrain rFGTrain = RFGTrainData.INSTANCE.getTrainMap().get(rFGStationSchedule.getTrainNo());
            if (rFGTrain != null) {
                Intrinsics.checkExpressionValueIsNotNull(rFGTrain, "RFGTrainData.trainMap[st…e.trainNo] ?: return null");
                if (rFGTrain.getSchedules().isEmpty()) {
                    return null;
                }
                Iterator<T> it = rFGTrain.getSchedules().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (((RFGTrainSchedule) t).getStationId() == i2) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (z2) {
                        break;
                    }
                }
                RFGTrainSchedule rFGTrainSchedule = (RFGTrainSchedule) t;
                if (rFGTrainSchedule != null) {
                    Calendar departureTime = rFGTrainSchedule.getDepartureTime();
                    if (departureTime != null) {
                        RFGStation findStation = RFGTrainData.INSTANCE.findStation(Integer.valueOf(((RFGTrainSchedule) CollectionsKt___CollectionsKt.last(rFGTrain.getSchedules())).getStationId()));
                        if (findStation == null || (name = findStation.getName()) == null) {
                            return null;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (Number intValue : rFGTrain.getTransferStationIds()) {
                            int intValue2 = intValue.intValue();
                            if (isVisibleTransfer(i2, intValue2, rFGTrain.getTrainType())) {
                                Iterator<T> it2 = rFGTrain.getSchedules().iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        t2 = null;
                                        break;
                                    }
                                    t2 = it2.next();
                                    if (((RFGTrainSchedule) t2).getStationId() == intValue2) {
                                        z = true;
                                        continue;
                                    } else {
                                        z = false;
                                        continue;
                                    }
                                    if (z) {
                                        break;
                                    }
                                }
                                RFGTrainSchedule rFGTrainSchedule2 = (RFGTrainSchedule) t2;
                                RFGStation findStation2 = RFGTrainData.INSTANCE.findStation(Integer.valueOf(intValue2));
                                String name2 = findStation2 != null ? findStation2.getName() : null;
                                if (!(rFGTrainSchedule2 == null || name2 == null)) {
                                    arrayList.add(new RFGTransfer(intValue2, name2, rFGTrainSchedule2.getArrival()));
                                }
                            }
                        }
                        return new RFGTrainDetail(rFGStationSchedule.getTrainNo(), rFGTrain.getTrainType(), rFGTrainSchedule.getDeparture(), departureTime, name, rFGStationSchedule.getStopHoliday(), arrayList);
                    }
                    return null;
                }
                return null;
            }
            return null;
        }

        private final boolean isVisibleTransfer(int i, int i2, RFGDef.TrainType trainType) {
            if (trainType == RFGDef.TrainType.UP) {
                if (i < i2) {
                    return true;
                }
            } else if (i > i2) {
                return true;
            }
            return false;
        }

        public final RFGStationDetail build() {
            ArrayList arrayList = new ArrayList();
            for (RFGStationSchedule createTrainDetail : this.station.getSchedules()) {
                RFGTrainDetail createTrainDetail2 = createTrainDetail(this.station.getStationId(), createTrainDetail);
                if (createTrainDetail2 != null) {
                    arrayList.add(createTrainDetail2);
                }
            }
            return new RFGStationDetail(this.station.getStationId(), this.station.getName(), arrayList);
        }
    }

    public RFGStationDetail(int i, String str, List<RFGTrainDetail> list) {
        Intrinsics.checkParameterIsNotNull(str, "stationName");
        Intrinsics.checkParameterIsNotNull(list, "scheduleList");
        this.stationId = i;
        this.stationName = str;
        this.scheduleList = list;
    }

    public static /* synthetic */ RFGStationDetail copy$default(RFGStationDetail rFGStationDetail, int i, String str, List<RFGTrainDetail> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = rFGStationDetail.stationId;
        }
        if ((i2 & 2) != 0) {
            str = rFGStationDetail.stationName;
        }
        if ((i2 & 4) != 0) {
            list = rFGStationDetail.scheduleList;
        }
        return rFGStationDetail.copy(i, str, list);
    }

    public final int component1() {
        return this.stationId;
    }

    public final String component2() {
        return this.stationName;
    }

    public final List<RFGTrainDetail> component3() {
        return this.scheduleList;
    }

    public final RFGStationDetail copy(int i, String str, List<RFGTrainDetail> list) {
        Intrinsics.checkParameterIsNotNull(str, "stationName");
        Intrinsics.checkParameterIsNotNull(list, "scheduleList");
        return new RFGStationDetail(i, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGStationDetail)) {
            return false;
        }
        RFGStationDetail rFGStationDetail = (RFGStationDetail) obj;
        return this.stationId == rFGStationDetail.stationId && Intrinsics.areEqual((Object) this.stationName, (Object) rFGStationDetail.stationName) && Intrinsics.areEqual((Object) this.scheduleList, (Object) rFGStationDetail.scheduleList);
    }

    public final List<RFGTrainDetail> getScheduleList() {
        return this.scheduleList;
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
        List<RFGTrainDetail> list = this.scheduleList;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGStationDetail(stationId=");
        a.append(this.stationId);
        a.append(", stationName=");
        a.append(this.stationName);
        a.append(", scheduleList=");
        return C0681a.m325a(a, (List) this.scheduleList, ")");
    }
}
