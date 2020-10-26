// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.xml;

import java.util.List;

public class LineTimeTable
{
    private List<TimeTableLineInfo> timetableLineInfoList;
    private List<TimeTableTrainData> timetableTrainDataList;
    
    public List<TimeTableLineInfo> getTimetableLineInfoList() {
        return this.timetableLineInfoList;
    }
    
    public List<TimeTableTrainData> getTimetableTrainDataList() {
        return this.timetableTrainDataList;
    }
    
    public void setTimetableLineInfoList(final List<TimeTableLineInfo> timetableLineInfoList) {
        this.timetableLineInfoList = timetableLineInfoList;
    }
    
    public void setTimetableTrainDataList(final List<TimeTableTrainData> timetableTrainDataList) {
        this.timetableTrainDataList = timetableTrainDataList;
    }
}
