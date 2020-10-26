// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.timetableroute;

import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultTimeTableTrainWrapper;
import me.yokeyword.indexablerv.IndexableAdapter;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.TimeTableDetailInfo;
import java.util.ArrayList;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.TimeTable;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.Stream;
import com.google.common.collect.Lists;
import com.feilang.mvpproject.util.LogUtils;
import java.util.List;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository_;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.TimeTableInfo;
import java.util.HashMap;
import com.feilang.mvpproject.base.BasePresenterClass;

public class RouteTimeTablePresenterImpl extends BasePresenterClass implements RouteTimeTableContract$Presenter
{
    private int mCurrentType;
    private HashMap<Integer, TimeTableInfo.TimeTableDate> mDate;
    private String mDirectionCode;
    private String mDirectionName;
    private RouteTimeTablePresenterImpl.RouteTimeTablePresenterImpl$ScheduleAgent mHolidayAgent;
    private String mLineId;
    private String mLineStationId;
    private RouteTimeTablePresenterImpl.RouteTimeTablePresenterImpl$ScheduleAgent mMatchAgent;
    private RouteTimeTablePresenterImpl.RouteTimeTablePresenterImpl$ScheduleAgent mMatchHolidayAgent;
    private RouteTimeTablePresenterImpl.RouteTimeTablePresenterImpl$ScheduleAgent mMatchNormalAgent;
    private RouteTimeTablePresenterImpl.RouteTimeTablePresenterImpl$ScheduleAgent mNormalAgent;
    private StationsRepository mRepository;
    private RouteTimeTableContract$View mView;
    
    RouteTimeTablePresenterImpl(@NonNull final RouteTimeTableContract$View routeTimeTableContract$View, final String mLineStationId, final String mDirectionCode, final String mDirectionName, final String mLineId) {
        this.mCurrentType = 0;
        (this.mView = Preconditions.checkNotNull(routeTimeTableContract$View)).setPresenter((Object)this);
        this.mDate = new HashMap<Integer, TimeTableInfo.TimeTableDate>();
        this.mNormalAgent = new RouteTimeTablePresenterImpl.RouteTimeTablePresenterImpl$ScheduleAgent(this, (RouteTimeTablePresenterImpl$1)null);
        this.mHolidayAgent = new RouteTimeTablePresenterImpl.RouteTimeTablePresenterImpl$ScheduleAgent(this, (RouteTimeTablePresenterImpl$1)null);
        this.mMatchAgent = new RouteTimeTablePresenterImpl.RouteTimeTablePresenterImpl$ScheduleAgent(this, (RouteTimeTablePresenterImpl$1)null);
        this.mMatchHolidayAgent = new RouteTimeTablePresenterImpl.RouteTimeTablePresenterImpl$ScheduleAgent(this, (RouteTimeTablePresenterImpl$1)null);
        this.mMatchNormalAgent = new RouteTimeTablePresenterImpl.RouteTimeTablePresenterImpl$ScheduleAgent(this, (RouteTimeTablePresenterImpl$1)null);
        this.mLineStationId = mLineStationId;
        this.mDirectionCode = mDirectionCode;
        this.mDirectionName = mDirectionName;
        this.mLineId = mLineId;
        this.mRepository = StationsRepository_.getInstance_(this.mView.getContext());
    }
    
    private List<TimeEntity> initTimeDatas(final int n) {
        final TimeTable stationTimeTableNormal = this.mRepository.getStationTimeTableNormal(this, this.mLineStationId, this.mDirectionName, this.mDirectionCode, this.mLineId, String.valueOf(n));
        if (stationTimeTableNormal == null || stationTimeTableNormal.getList() == null) {
            LogUtils.w("Error: Cannot find time table for station code: " + this.mLineStationId);
            return null;
        }
        if (stationTimeTableNormal.getTimetableInfo() != null && stationTimeTableNormal.getTimetableInfo().getDate() != null) {
            this.mDate.put(n, stationTimeTableNormal.getTimetableInfo().getDate());
        }
        final ArrayList<TimeEntity> arrayList = Lists.newArrayList();
        Stream.of((Iterable<?>)stationTimeTableNormal.getList()).forEach(RouteTimeTablePresenterImpl$$Lambda$1.lambdaFactory$(stationTimeTableNormal, (List)arrayList));
        return arrayList;
    }
    
    public void clearCache() {
        this.mRepository.clearTimeTableCache();
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_TRAIN_TIME_TABLE)
    void failedStationLines() {
        LogUtils.w("API Failed : API_TRAIN_TIME_TABLE ");
    }
    
    public IndexableAdapter getAdapter(final int n) {
        if (n == Integer.valueOf("0")) {
            return this.mNormalAgent.getAdapter();
        }
        if (n == Integer.valueOf("2")) {
            return this.mMatchAgent.getAdapter();
        }
        if (n == Integer.valueOf("3")) {
            return this.mMatchNormalAgent.getAdapter();
        }
        if (n == Integer.valueOf("4")) {
            return this.mMatchHolidayAgent.getAdapter();
        }
        return this.mHolidayAgent.getAdapter();
    }
    
    public String getSubTitle(final String str, final String str2) {
        return str + " " + str2;
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_TRAIN_TIME_TABLE)
    void receiveStationLines(final Object[] array, final ResultTimeTableTrainWrapper resultTimeTableTrainWrapper) {
        final RouteTimeTableContract$View mView = this.mView;
        final String s = (String)array[0];
        final int intValue = Integer.valueOf((String)array[1]);
        final String s2 = (String)array[2];
        String formatString;
        if (this.mDate.get(this.mCurrentType) == null) {
            formatString = "";
        }
        else {
            formatString = this.mDate.get(this.mCurrentType).getFormatString();
        }
        mView.migrateToTimeTableTrain(s, intValue, s2, formatString);
    }
    
    public void updateCurrentType(final int n) {
        this.mCurrentType = n;
        this.mView.updateTime(this.mDate.get(n).toString(this.mView.getContext()));
    }
    
    public void updateData(final int n) {
        if (n == Integer.valueOf("0")) {
            this.mNormalAgent.updateData(n);
            return;
        }
        if (n == Integer.valueOf("2")) {
            this.mMatchAgent.updateData(n);
            return;
        }
        if (n == Integer.valueOf("3")) {
            this.mMatchNormalAgent.updateData(n);
            return;
        }
        if (n == Integer.valueOf("4")) {
            this.mMatchHolidayAgent.updateData(n);
            return;
        }
        this.mHolidayAgent.updateData(n);
    }
}
