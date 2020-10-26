// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.xml;

import java.util.List;

public class ResultTimeTableTrainWrapper
{
    private int offset;
    private int total;
    private List<ResultTimeTableTrain> trainTimetable;
    
    public int getOffset() {
        return this.offset;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public ResultTimeTableTrain getTrainTimetable() {
        return this.trainTimetable.get(0);
    }
    
    public void setOffset(final int offset) {
        this.offset = offset;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
    
    public void setTrainTimetable(final List<ResultTimeTableTrain> trainTimetable) {
        this.trainTimetable = trainTimetable;
    }
}
