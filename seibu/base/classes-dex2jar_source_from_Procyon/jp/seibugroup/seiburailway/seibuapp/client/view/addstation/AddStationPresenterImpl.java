// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.addstation;

import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultStationLine;
import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import com.feilang.mvpproject.util.LogUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationDetailInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.LineStationInfoWrapper;
import java.util.ArrayList;
import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.view.mystation.helper.OnStartDragListener;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingCallback;
import com.feilang.mvpproject.util.Exclusive;
import android.view.View;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import jp.seibugroup.seiburailway.seibuapp.client.view.common.adapter.StationListAdapter;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import java.util.List;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository;
import com.feilang.mvpproject.base.BasePresenterClass;

public class AddStationPresenterImpl extends BasePresenterClass implements AddStationContract$Presenter
{
    private DeviceDataRepository mDeviceDataRepository;
    private boolean mIsSavingData;
    private MasterDataRepository mMasterDataRepository;
    private List<BaseStation> mSearchList;
    private StationListAdapter mSearchListAdapter;
    private String mStationId;
    private StationsRepository mStationsRepository;
    private AddStationContract$View mView;
    
    public AddStationPresenterImpl(@NonNull final DeviceDataRepository deviceDataRepository, @NonNull final MasterDataRepository masterDataRepository, @NonNull final StationsRepository stationsRepository, @NonNull final AddStationContract$View addStationContract$View) {
        this.mIsSavingData = false;
        this.mDeviceDataRepository = Preconditions.checkNotNull(deviceDataRepository);
        this.mMasterDataRepository = Preconditions.checkNotNull(masterDataRepository);
        this.mStationsRepository = Preconditions.checkNotNull(stationsRepository);
        (this.mView = Preconditions.checkNotNull(addStationContract$View)).setPresenter((Object)this);
    }
    
    private void saveHistoryData(final String s) {
        this.mDeviceDataRepository.saveStationHistory(s, (APSettingCallback.Common)new AddStationPresenterImpl$2(this));
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_DETAIL_INFO)
    void failedStationInfo() {
        this.mView.saveDataOnError();
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_LINE_DIRECTION)
    void failedStationLineInfo() {
        this.mView.saveDataOnError();
    }
    
    public StationListAdapter getAdapter() {
        if (this.mSearchListAdapter == null) {
            (this.mSearchListAdapter = new StationListAdapter(this.mView.getContext(), (OnStartDragListener)null, true)).setOnItemClickListener(AddStationPresenterImpl$$Lambda$1.lambdaFactory$(this));
        }
        return this.mSearchListAdapter;
    }
    
    public void getInputAssistWords(final String anObject) {
        if ("".equals(anObject)) {
            this.mView.showSearchResultView((List)null);
            return;
        }
        if (TextUtils.equals((CharSequence)anObject, (CharSequence)"_")) {
            this.mView.showSearchResultView((List)new ArrayList());
            return;
        }
        this.mSearchList = this.mMasterDataRepository.queryStationsByKeyword(anObject);
        this.mView.showSearchResultView((List)this.mSearchList);
    }
    
    public void getLines(final String s) {
        final List<LineStationInfoWrapper> stationLines = this.mStationsRepository.getStationLines(this, s);
        if (stationLines != null && stationLines.size() > 0) {
            this.mView.goTimeTablePage(stationLines.get(0).getLineStationInfo().getStation().getStationName());
        }
    }
    
    public void getStationInfo(final String mStationId) {
        this.mStationsRepository = StationsRepository_.getInstance_(this.mView.getContext());
        this.mStationId = mStationId;
        this.mStationsRepository.getStationDetailInfo(this, mStationId);
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_DETAIL_INFO)
    void receiveStationInfo(final Object[] array, final StationDetailInfo stationDetailInfo) {
        if (stationDetailInfo != null && array.length > 0 && TextUtils.equals((CharSequence)array[0], (CharSequence)this.mStationId)) {
            this.mStationId = "";
            this.mView.goStationInfoPage(stationDetailInfo.getStation().getStationId(), (List)stationDetailInfo.getDepartures());
            return;
        }
        LogUtils.w("API Return Null : API_STATION_INFO ");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_LINE_DIRECTION)
    void receiveStationLineInfo(final Object[] array, final ResultStationLine resultStationLine) {
        if (resultStationLine != null && resultStationLine.getLines().size() > 0) {
            this.mView.goTimeTablePage(resultStationLine.getLines().get(0).getLineStationInfo().getStation().getStationName());
            return;
        }
        LogUtils.w("API Return Null : API_STATION_LINE_DIRECTION ");
    }
    
    public void saveSelectStationToMyStation(final BaseStation baseStation) {
        if (!this.mIsSavingData) {
            this.mIsSavingData = true;
            this.mDeviceDataRepository.saveMyStation(baseStation.getId(), (APSettingCallback.Common)new AddStationPresenterImpl$1(this, baseStation));
        }
    }
    
    @Override
    public void start() {
        super.start();
        this.mSearchList = new ArrayList<BaseStation>();
    }
}
