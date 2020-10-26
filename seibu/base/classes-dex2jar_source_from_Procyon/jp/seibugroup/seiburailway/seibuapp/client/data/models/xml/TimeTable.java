// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.xml;

import java.util.List;

public class TimeTable
{
    private List<TimeTableDetailInfo> timeTableDataList;
    private TimeTableInfo timetableInfo;
    
    public List<TimeTableDetailInfo> getList() {
        return this.timeTableDataList;
    }
    
    public TimeTableInfo getTimetableInfo() {
        return this.timetableInfo;
    }
    
    public void setTimetableInfo(final TimeTableInfo timetableInfo) {
        this.timetableInfo = timetableInfo;
    }
}
