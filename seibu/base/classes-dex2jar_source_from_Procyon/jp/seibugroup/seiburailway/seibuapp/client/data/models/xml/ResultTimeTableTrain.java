// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.xml;

import java.util.Comparator;
import android.text.TextUtils;
import java.util.Collection;
import com.annimon.stream.Optional;
import com.annimon.stream.function.Predicate;
import java.util.ArrayList;
import com.google.common.collect.Lists;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.Stream;
import java.util.List;

public class ResultTimeTableTrain
{
    private ResultTimeTableTrainCondition condition;
    private LineTimeTable lineTimetable;
    
    private void addStationInfo(final List<TimeTableTrainStationInfo> list) {
        Stream.of((Iterable<?>)list).forEach(ResultTimeTableTrain$$Lambda$3.lambdaFactory$(this.getStationList()));
    }
    
    private List<TimeTableTrainStationInfo> flatTrainStationList() {
        final ArrayList<TimeTableTrainStationInfo> arrayList = Lists.newArrayList();
        Stream.of((Iterable<?>)this.lineTimetable.getTimetableTrainDataList()).forEach(ResultTimeTableTrain$$Lambda$4.lambdaFactory$(arrayList));
        return arrayList;
    }
    
    public ResultTimeTableTrainCondition getCondition() {
        return this.condition;
    }
    
    public LineTimeTable getLineTimetable() {
        return this.lineTimetable;
    }
    
    public List<TimeTableStationInfoWrapper> getStationList() {
        final ArrayList<TimeTableStationInfoWrapper> arrayList = Lists.newArrayList();
        Stream.of((Iterable<?>)this.lineTimetable.getTimetableLineInfoList()).forEach(ResultTimeTableTrain$$Lambda$1.lambdaFactory$(arrayList));
        return arrayList;
    }
    
    public List<TimeTableTrainStationInfo> getTrainStationListSortByGroupId() {
        final List<TimeTableTrainStationInfo> flatTrainStationList = this.flatTrainStationList();
        Stream.of((Iterable<?>)flatTrainStationList).sorted(ResultTimeTableTrain$$Lambda$2.lambdaFactory$(flatTrainStationList)).toList();
        this.addStationInfo(flatTrainStationList);
        return flatTrainStationList;
    }
    
    public void setCondition(final ResultTimeTableTrainCondition condition) {
        this.condition = condition;
    }
    
    public void setLineTimetable(final LineTimeTable lineTimetable) {
        this.lineTimetable = lineTimetable;
    }
}
