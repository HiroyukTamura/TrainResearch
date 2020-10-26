// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation;

import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.LineStationInfoWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultStationLine;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationDetailInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInData;
import com.google.common.collect.Lists;
import java.util.Iterator;
import jp.seibugroup.seiburailway.seibuapp.client.event.CTCEventBus;
import com.google.gson.Gson;
import android.location.Location;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.StationDeparture;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationInfoList;
import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import jp.seibugroup.seiburailway.seibuapp.client.util.LocationUtils;
import android.content.Context;
import java.util.List;
import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.util.Constants;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import com.feilang.mvpproject.util.LogUtils;
import com.feilang.mvpproject.util.AppEventBus;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository_;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainInfo;
import java.util.ArrayList;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.util.CTCLocationListener$CTCLocationHandler;
import com.feilang.mvpproject.base.BasePresenterClass;

public class MyStationCardPresenterImpl extends BasePresenterClass implements MyStationCardContract$Presenter, CTCLocationListener$CTCLocationHandler
{
    private DeviceDataRepository mDeviceDataRepository;
    private MasterDataRepository mMasterDataRepository;
    private StationsRepository mStationsRepository;
    private ArrayList<TrainInfo> mTrainInfo;
    private MyStationCardContract$View mView;
    
    public MyStationCardPresenterImpl(@NonNull final MyStationCardContract$View myStationCardContract$View) {
        (this.mView = Preconditions.checkNotNull(myStationCardContract$View)).setPresenter((Object)this);
        this.mStationsRepository = StationsRepository_.getInstance_(this.mView.getContext());
        this.mDeviceDataRepository = DeviceDataRepository_.getInstance_(this.mView.getContext());
        this.mMasterDataRepository = MasterDataRepository_.getInstance_(this.mView.getContext());
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_GET_CHECK_IN)
    void failedCheckInData() {
        AppEventBus.hideProgress();
        this.mView.showTrainInfo((ArrayList)this.mTrainInfo);
        LogUtils.w("API Failed : API_GET_CHECK_IN ");
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_DETAIL_INFO)
    void failedStationInfo() {
        this.mView.showErrorMessage();
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_LINE_DIRECTION)
    void failedStationLines() {
        if (this.mView.isDestroyed()) {
            return;
        }
        LogUtils.w("API Failed : API_STATION_LINE_DIRECTION ");
    }
    
    public void getAllStationDepartures() {
        final List<String> myStationList = this.mDeviceDataRepository.getMyStationList();
        if (myStationList == null || myStationList.size() == 0) {
            return;
        }
        if (TextUtils.isEmpty((CharSequence)Constants.LOCATION_STATION_ID)) {
            this.mStationsRepository.getStationDeparturesForHome(this, myStationList, true, false);
            return;
        }
        if (!myStationList.contains(Constants.LOCATION_STATION_ID)) {
            myStationList.add(Constants.LOCATION_STATION_ID);
            this.mStationsRepository.getStationDeparturesForHome(this, myStationList, true, false);
            return;
        }
        this.mStationsRepository.getStationDeparturesForHome(this, myStationList, true, true);
    }
    
    public void getNearbyStation(final Context context) {
        if (LocationUtils.startGPS(context, (CTCLocationListener$CTCLocationHandler)this)) {
            AppEventBus.showProgress();
            return;
        }
        this.mView.showNearbyStations((List)new ArrayList());
    }
    
    public void getStationDepartures(final String s) {
        this.mStationsRepository.getStationDeparturesForHome(this, s, true);
    }
    
    public void getStationInfoDetail(final String s) {
        this.mStationsRepository.getStationDetailInfo(this, s);
    }
    
    public String getStationKanjiName(final String s) {
        final BaseStation stationById = this.mMasterDataRepository.getStationById(s);
        if (stationById != null) {
            return stationById.getKanjiName();
        }
        return "";
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_MY_STATION_ADD)
    public void onAddMyStationFailed() {
        if (this.mView.isDestroyed()) {
            return;
        }
        LogUtils.v("\u30de\u30a4\u99c5\u8ffd\u52a0\u306e\u5931\u6557\u51e6\u7406");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_MY_STATION_ADD)
    public void onAddMyStationSuccess(final Object[] array, final String s) {
        if (this.mView.isDestroyed()) {
            return;
        }
        this.getStationDepartures((String)array[0]);
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_NEARBY)
    public void onGetNearbyStationsFailed() {
        if (this.mView.isDestroyed()) {
            return;
        }
        LogUtils.v("\u7d4c\u7def\u5ea6\u3088\u308a\u5468\u8fba\u306e\u99c5\u3092\u53d6\u5f97\u5931\u6557");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_NEARBY)
    public void onGetNearbyStationsSuccess(final String s, final StationInfoList list) {
        if (this.mView.isDestroyed()) {
            return;
        }
        this.mView.showNearbyStations((List)list.getStation());
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_DEPARTURES_MY)
    public void onGetStationDeparturesFailed() {
        if (this.mView.isDestroyed()) {
            return;
        }
        LogUtils.v("\u30de\u30a4\u99c5\u66f4\u65b0\u306e\u5931\u6557\u51e6\u7406");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_DEPARTURES_MY)
    public void onGetStationDeparturesSuccess(final Object[] array, final List<StationDeparture> list) {
        if (array.length < 1 || (int)array[0] != this.hashCode() || this.mView.isDestroyed()) {
            return;
        }
        if (list.size() > 0) {
            this.mView.updateMyStaiton((StationDeparture)list.get(0));
            return;
        }
        this.mView.updateMyStaiton((StationDeparture)null);
    }
    
    public void onLocationChanged(final Location obj) {
        LogUtils.v("location: " + obj);
        if (obj == null) {
            this.mView.showNearbyStations((List)new ArrayList());
            AppEventBus.hideProgress();
            return;
        }
        this.mStationsRepository.getNearbyStations(this, obj);
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_DEPARTURES_HOME)
    public void onStationDeparturesApiSuccess(final Object[] array, final List<StationDeparture> list) {
        if ((int)array[0] == this.hashCode() && !this.mView.isDestroyed() && list != null && list.size() != 0) {
            if (array[1]) {
                for (final StationDeparture stationDeparture : list) {
                    if (stationDeparture.getStationId().equals(Constants.LOCATION_STATION_ID)) {
                        final StationDeparture stationDeparture2 = new Gson().fromJson(new Gson().toJson(stationDeparture), StationDeparture.class);
                        stationDeparture2.setModelType(MyStationCardFragment$Model.LOCATION);
                        list.add(stationDeparture2);
                        break;
                    }
                }
            }
            else if (!TextUtils.isEmpty((CharSequence)Constants.LOCATION_STATION_ID)) {
                for (final StationDeparture stationDeparture3 : list) {
                    if (stationDeparture3.getStationId().equals(Constants.LOCATION_STATION_ID)) {
                        stationDeparture3.setModelType(MyStationCardFragment$Model.LOCATION);
                        break;
                    }
                }
            }
            CTCEventBus.post(list);
        }
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_TRAIN_INFO)
    void onTrainsFailed() {
        LogUtils.w("API Failed : API_TRAIN_LIST ");
        AppEventBus.hideProgress();
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_TRAIN_INFO)
    void onTrainsSucceed(final Object[] array, final List<TrainInfo> list) {
        if (array.length < 3 || (int)array[2] != this.hashCode()) {
            return;
        }
        this.mTrainInfo = Lists.newArrayList((Iterable<? extends TrainInfo>)list);
        this.mDeviceDataRepository.getCheckIn(this, false, true);
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_MY_STATION_UPDATE)
    public void onUpdateMyStationFailed() {
        if (this.mView.isDestroyed()) {
            return;
        }
        LogUtils.v("\u30de\u30a4\u99c5\u66f4\u65b0\u306e\u5931\u6557\u51e6\u7406");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_MY_STATION_UPDATE)
    public void onUpdateMyStationSuccess(final Object[] array, final String s) {
        if (this.mView.isDestroyed()) {
            return;
        }
        this.getStationDepartures((String)array[0]);
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_GET_CHECK_IN)
    void receiveCheckInData(final Object[] array, final List<CheckInData> list) {
        AppEventBus.hideProgress();
        if (array.length > 0 && (int)array[0] == this.hashCode()) {
            this.mView.showTrainInfo((ArrayList)this.mTrainInfo);
        }
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_DETAIL_INFO)
    void receiveStationInfo(final Object[] array, final StationDetailInfo stationDetailInfo) {
        if (stationDetailInfo != null) {
            this.mView.goStationInfoPage(stationDetailInfo);
            return;
        }
        LogUtils.w("API Return Null : API_STATION_INFO ");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_LINE_DIRECTION)
    void receiveStationLines(final Object[] array, final ResultStationLine resultStationLine) {
        if (this.mView.isDestroyed()) {
            return;
        }
        if (resultStationLine.getLines() != null) {
            this.mView.showStationTimeTableTop((List)resultStationLine.getLines());
            return;
        }
        LogUtils.w("\u4f55\u3082\u53d6\u5f97\u3055\u308c\u306a\u3044");
    }
    
    public void requestStationLines(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            this.mView.showErrorMessage();
        }
        else {
            final List<LineStationInfoWrapper> stationLines = this.mStationsRepository.getStationLines(this, s);
            if (stationLines != null) {
                this.mView.showStationTimeTableTop((List)stationLines);
            }
        }
    }
    
    public void requestTrains(final String s, final List<String> list) {
        AppEventBus.showProgress();
        this.mStationsRepository.requestTrainsById(this, s, list, false, false, false);
    }
}
