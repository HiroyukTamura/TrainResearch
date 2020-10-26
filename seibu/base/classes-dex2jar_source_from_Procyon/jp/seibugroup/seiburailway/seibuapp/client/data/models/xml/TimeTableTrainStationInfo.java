// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.xml;

import android.support.annotation.Nullable;
import com.annimon.stream.Optional;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.Stream;
import java.util.Collection;
import android.text.TextUtils;
import java.util.List;

public class TimeTableTrainStationInfo
{
    private String groupId;
    private String kind;
    private String stationName;
    private List<ArrivalDepartureTimeWrapper> timetableTrainStationInfo;
    
    public void addList(final List<ArrivalDepartureTimeWrapper> timetableTrainStationInfo) {
        if (this.timetableTrainStationInfo != null) {
            this.timetableTrainStationInfo.addAll(timetableTrainStationInfo);
            return;
        }
        this.timetableTrainStationInfo = timetableTrainStationInfo;
    }
    
    @Nullable
    public String getArrivalTime() {
        if (this.timetableTrainStationInfo != null && this.timetableTrainStationInfo.size() != 0) {
            final Optional<ArrivalDepartureTimeWrapper> first = Stream.of((Iterable<? extends ArrivalDepartureTimeWrapper>)this.timetableTrainStationInfo).filter(TimeTableTrainStationInfo$$Lambda$1.lambdaFactory$()).findFirst();
            if (first.isPresent()) {
                String str2;
                final String str = str2 = first.get().getArrivalDepartureTime().getTime().getMin();
                if (str.length() == 1) {
                    str2 = "0" + str;
                }
                return first.get().getArrivalDepartureTime().getTime().getHour() + ":" + str2;
            }
        }
        return null;
    }
    
    @Nullable
    public String getDepartureTime() {
        if (this.timetableTrainStationInfo != null && this.timetableTrainStationInfo.size() != 0) {
            final Optional<ArrivalDepartureTimeWrapper> first = Stream.of((Iterable<? extends ArrivalDepartureTimeWrapper>)this.timetableTrainStationInfo).filter(TimeTableTrainStationInfo$$Lambda$2.lambdaFactory$()).findFirst();
            if (first.isPresent()) {
                String str2;
                final String str = str2 = first.get().getArrivalDepartureTime().getTime().getMin();
                if (str.length() == 1) {
                    str2 = "0" + str;
                }
                return first.get().getArrivalDepartureTime().getTime().getHour() + ":" + str2;
            }
        }
        return null;
    }
    
    public String getGroupId() {
        return this.groupId;
    }
    
    public String getKind() {
        return this.kind;
    }
    
    public String getStationName() {
        return this.stationName;
    }
    
    public List<ArrivalDepartureTimeWrapper> getTimetableTrainStationInfo() {
        return this.timetableTrainStationInfo;
    }
    
    public void setGroupId(final String groupId) {
        this.groupId = groupId;
    }
    
    public void setKind(final String kind) {
        this.kind = kind;
    }
    
    public void setStationName(final String stationName) {
        this.stationName = stationName;
    }
    
    public void setTimetableTrainStationInfo(final List<ArrivalDepartureTimeWrapper> timetableTrainStationInfo) {
        this.timetableTrainStationInfo = timetableTrainStationInfo;
    }
}
