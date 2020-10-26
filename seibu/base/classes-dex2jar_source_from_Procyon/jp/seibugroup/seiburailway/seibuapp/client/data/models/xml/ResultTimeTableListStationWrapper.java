// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.xml;

import java.util.List;

public class ResultTimeTableListStationWrapper
{
    private int offset;
    private List<ResultTimeTableListStation> timetableList;
    private String todayWeekPatternCode;
    private int total;
    
    public int getOffset() {
        return this.offset;
    }
    
    public List<ResultTimeTableListStation> getTimetableList() {
        return this.timetableList;
    }
    
    public String getTodayWeekPatternCode() {
        return this.todayWeekPatternCode;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setOffset(final int offset) {
        this.offset = offset;
    }
    
    public void setTimetableList(final List<ResultTimeTableListStation> timetableList) {
        this.timetableList = timetableList;
    }
    
    public void setTodayWeekPatternCode(final String todayWeekPatternCode) {
        this.todayWeekPatternCode = todayWeekPatternCode;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
}
