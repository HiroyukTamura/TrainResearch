// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.timetabletop;

import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import com.feilang.mvpproject.base.listview.BaseListView;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import java.util.Iterator;
import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TransferData;
import com.google.common.collect.Lists;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultTimeTableListStation;
import java.util.ArrayList;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultTimeTableListStationWrapper;
import com.feilang.mvpproject.util.LogUtils;
import java.util.List;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository_;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.LineStationInfoWrapper;
import com.feilang.mvpproject.base.listview.BaseListAdapter;
import com.feilang.mvpproject.base.BasePresenterClass;

public class TimeTableTopPresenterImpl extends BasePresenterClass implements TimeTableTopContract$Presenter
{
    private BaseListAdapter<LineStationInfoWrapper> mAdapter;
    private String mLineId;
    private String mLineName;
    private MasterDataRepository mMasterDataRepository;
    private StationsRepository mRepository;
    private String mStationId;
    private TimeTableTopContract$View mView;
    
    TimeTableTopPresenterImpl(@NonNull final TimeTableTopContract$View timeTableTopContract$View, final String mStationId) {
        (this.mView = Preconditions.checkNotNull(timeTableTopContract$View)).setPresenter((Object)this);
        this.mStationId = mStationId;
        this.mRepository = StationsRepository_.getInstance_(this.mView.getContext());
        this.mMasterDataRepository = MasterDataRepository_.getInstance_(this.mView.getContext());
    }
    
    private List<LineStationInfoWrapper> getLines(final String str) {
        final List<LineStationInfoWrapper> stationLines = StationsRepository_.getInstance_(this.mView.getContext()).getStationLines(this, str);
        if (stationLines == null || stationLines.size() < 1) {
            LogUtils.w("ERR!!! Line not existed in station: " + str);
        }
        return stationLines;
    }
    
    private ArrayList<String> getTabsName(final ResultTimeTableListStationWrapper resultTimeTableListStationWrapper) {
        if (resultTimeTableListStationWrapper.getTimetableList().size() == 5 && resultTimeTableListStationWrapper.getTimetableList().get(2).getMeta() != null && resultTimeTableListStationWrapper.getTimetableList().get(3).getMeta() != null && resultTimeTableListStationWrapper.getTimetableList().get(4).getMeta() != null) {
            return Lists.newArrayList(resultTimeTableListStationWrapper.getTimetableList().get(2).getMeta().getTimetableInfo().getWeekPattern() + resultTimeTableListStationWrapper.getTimetableList().get(2).getMeta().getTimetableInfo().getGameTypeName(), resultTimeTableListStationWrapper.getTimetableList().get(3).getMeta().getTimetableInfo().getWeekPattern() + resultTimeTableListStationWrapper.getTimetableList().get(3).getMeta().getTimetableInfo().getGameTypeName(), resultTimeTableListStationWrapper.getTimetableList().get(4).getMeta().getTimetableInfo().getWeekPattern() + resultTimeTableListStationWrapper.getTimetableList().get(4).getMeta().getTimetableInfo().getGameTypeName());
        }
        return null;
    }
    
    private List<TransferData> insertSection(final List<TransferData> list) {
        ArrayList<TransferData> arrayList2;
        if (list != null && list.size() > 0) {
            final ArrayList<TransferData> arrayList = Lists.newArrayList();
            final String s = "";
            final Iterator<TransferData> iterator = list.iterator();
            String companyId = s;
            while (true) {
                arrayList2 = arrayList;
                if (!iterator.hasNext()) {
                    break;
                }
                final TransferData transferData = iterator.next();
                if (TextUtils.equals((CharSequence)transferData.getCompanyId(), (CharSequence)companyId)) {
                    continue;
                }
                arrayList.add(transferData);
                companyId = transferData.getCompanyId();
            }
        }
        else {
            arrayList2 = Lists.newArrayList();
        }
        return arrayList2;
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_INFO)
    void failedStationInfo() {
        LogUtils.w("API Failed : API_STATION_INFO ");
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_TIME_TABLE)
    void failedStationLines() {
        LogUtils.w("API Failed : API_STATION_TIME_TABLE ");
        this.mLineName = null;
        this.mLineId = null;
    }
    
    public BaseListAdapter<LineStationInfoWrapper> getAdapter() {
        if (this.mAdapter == null) {
            this.mAdapter = new BaseListAdapter<LineStationInfoWrapper>((BaseListView)this.mView, this.getLines(this.mStationId));
        }
        return this.mAdapter;
    }
    
    public boolean hasTransfer() {
        final BaseStation stationById = this.mMasterDataRepository.getStationById(this.mStationId);
        return stationById != null && stationById.isTransfer();
    }
    
    public void loadOtherLineInfo() {
        this.mRepository.getOtherCompanyLineInfo(this, this.mStationId);
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_INFO)
    void receiveStationInfo(final Object[] array, final StationInfo stationInfo) {
        if (array[1].equals("2")) {
            this.mView.showOtherLineDialog((List)this.insertSection(stationInfo.getTransfer()));
        }
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_TIME_TABLE)
    void receiveStationLines(final Object[] array, final ResultTimeTableListStationWrapper resultTimeTableListStationWrapper) {
        this.mView.migrateToTimeTableStation(this.mLineName, this.mLineId, (String)array[0], (String)array[2], (String)array[1], resultTimeTableListStationWrapper.getTimetableList().size() == 5 && resultTimeTableListStationWrapper.getTimetableList().get(2).getMeta() != null && resultTimeTableListStationWrapper.getTimetableList().get(3).getMeta() != null && resultTimeTableListStationWrapper.getTimetableList().get(4).getMeta() != null, (ArrayList)this.getTabsName(resultTimeTableListStationWrapper), resultTimeTableListStationWrapper.getTodayWeekPatternCode());
        this.mLineName = null;
        this.mLineId = null;
    }
    
    public void requestTimeTableStation(final String mLineName, final String s, final String s2, final String s3, final String mLineId) {
        this.mLineName = mLineName;
        this.mLineId = mLineId;
        final ResultTimeTableListStationWrapper stationTimeTable = this.mRepository.getStationTimeTable(this, s, s2, s3, mLineId);
        if (stationTimeTable != null) {
            this.mView.migrateToTimeTableStation(this.mLineName, mLineId, s, s2, s3, stationTimeTable.getTimetableList().size() == 5 && stationTimeTable.getTimetableList().get(2).getMeta() != null && stationTimeTable.getTimetableList().get(3).getMeta() != null && stationTimeTable.getTimetableList().get(4).getMeta() != null, (ArrayList)this.getTabsName(stationTimeTable), stationTimeTable.getTodayWeekPatternCode());
            this.mLineName = null;
            this.mLineId = null;
        }
    }
}
