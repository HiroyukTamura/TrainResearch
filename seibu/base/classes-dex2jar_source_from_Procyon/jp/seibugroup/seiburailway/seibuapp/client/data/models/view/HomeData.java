// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.view;

import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.RunStatusData;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeMessageData;
import java.util.List;

public class HomeData
{
    private List<NoticeMessageData> mHeadlines;
    private List<StationDeparture> mMyStationInfoList;
    private RunStatusData mRunStatusInfo;
    private long unreadedMessageCount;
    
    public HomeData() {
        this.unreadedMessageCount = -1L;
    }
    
    public List<NoticeMessageData> getHeadlines() {
        return this.mHeadlines;
    }
    
    public List<StationDeparture> getMyStationInfoList() {
        return this.mMyStationInfoList;
    }
    
    public RunStatusData getRunStatusInfo() {
        return this.mRunStatusInfo;
    }
    
    public long getUnreadedMessageCount() {
        return this.unreadedMessageCount;
    }
    
    public void setHeadlines(final List<NoticeMessageData> mHeadlines) {
        this.mHeadlines = mHeadlines;
    }
    
    public void setMyStationInfoList(final List<StationDeparture> mMyStationInfoList) {
        this.mMyStationInfoList = mMyStationInfoList;
    }
    
    public void setRunStatusInfo(final RunStatusData mRunStatusInfo) {
        this.mRunStatusInfo = mRunStatusInfo;
    }
    
    public void setUnreadedMessageCount(final long unreadedMessageCount) {
        this.unreadedMessageCount = unreadedMessageCount;
    }
}
